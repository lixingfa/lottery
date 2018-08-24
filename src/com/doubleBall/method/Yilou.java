package com.doubleBall.method;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import com.doubleBall.number.Bull;
import com.doubleBall.number.Number1;
import com.doubleBall.number.Number2;
import com.doubleBall.number.Number3;
import com.doubleBall.number.Number4;
import com.doubleBall.number.Number5;
import com.doubleBall.number.Number6;

/**
 * 遗漏，距离上次出现隔了多远
 * 理想情况下，距离上次出现达到平均值时出现概率最高，
 * 超过均值会下降，超过一定限度后又提高
 * @author lixingfa
 *
 */
public class Yilou {
	int[] num1 = Number1.getAscNum();
	int[] num2 = Number2.getAscNum();
	int[] num3 = Number3.getAscNum();
	int[] num4 = Number4.getAscNum();
	int[] num5 = Number5.getAscNum();
	int[] num6 = Number6.getAscNum();
	int[] numb = Bull.getAscNum();
	/**
	 * 用遗传算法求每个取值上升、下降、上升三阶段的因数
	 * @param scope 取值范围
	 * @param now 当前期数
	 * @param chrs 取多少个染色体
	 * @param circle 稳定多少代后认为是最佳解
	 */
	public void doit(int scope,int now,int chrs,int circle){
		double[] averages = new double[scope];
		int[] appears = new int[scope];
		Chromosome[] chroms = new Chromosome[chrs];
		//统计出现次数
		if (scope == 16) {
			for (int i = 0; i <= now; i++) {
				appears[numb[i]-1]++;
			}
		}else {
			for (int i = 0; i <= now; i++) {
				appears[num1[i]-1]++;
				appears[num2[i]-1]++;
				appears[num3[i]-1]++;
				appears[num4[i]-1]++;
				appears[num5[i]-1]++;
				appears[num6[i]-1]++;
			}			
		}
		//获取平均间距
		for (int i = 0; i < appears.length; i++) {
			averages[i] = (double)now / appears[i];
		}
		//生成染色体，开始迭代
		for (int i = 0; i < chrs; i++) {
			chroms[i] = new Chromosome(scope, averages, now);
		}
		boolean b = true;
		int same = 0;
		int maxTotal = 0;
		while (b) {
			//统计
			for (int i = 0; i < chroms.length; i++) {
				chroms[i].getTotal(now, averages, scope);
			}
			//排序
			for (int i = 0; i < chroms.length; i++) {
				for (int j = 0; j < chroms.length; j++) {
					if (chroms[i].total > chroms[j].total) {
						Chromosome temp = chroms[i];
						chroms[i] = chroms[j];
						chroms[j] = temp;
					}
				}
			}
			//交换、变异
			for (int i = 1; i < chroms.length; i++) {//第一个不发生改变
				chroms[i].variation(chroms[0]);//其他的以第一个为样板变异
			}
			//比较最大值
			if (chroms[0].total > maxTotal) {
				maxTotal = chroms[0].total;
				same = 0;
				System.out.println();
				System.out.print(maxTotal);
			}else if(chroms[0].total == maxTotal){
				same++;
				System.out.print(" " + same);
			}
			//得到结果
			if (same == circle) {
				b = false;
				System.out.println("当前共" + now + "期，中" + chroms[0].total);
				for (int i = 0; i < chroms[0].genes.length; i++) {
					System.out.print("[");
					for (int j = 0; j < chroms[0].genes[i].length; j++) {
						System.out.print("," + chroms[0].genes[i][j]);						
					}
					System.out.println("]");
				}
			}
		}
	}
	
	
	private class Chromosome{
		int total;
		int scope;//取值范围
		/**
		 * 0 < dis < aver 时 a*dis + b,
		 * aver <= dis < g 时 c*dis - d,
		 *  dis >= g 时 e*dis + f
		 *  一共7个未知数
		 */
		double[][] genes;
		
		Chromosome(int scope,double[] averages,int now){
			this.scope = scope;
			genes = new double[7][scope];
			//初始化g
			for (int i = 0; i < scope; i++) {
				genes[6][i] = Math.random() * averages[i] * 5;//根据历史统计，最大遗漏可达平均遗漏的10倍，取一半做g点
			}
			//初始化ab、cd、ef
			for (int i = 0; i < 6; i++) {
				for (int j = 0; j < scope; j++) {
					genes[i][j] = Math.random();
				}
			}
		}
		
		private void getTotal(int now,double[] averages,int scope){
			total = statistics(genes, now, averages, scope);			
		}
		
		/**
		 * 以某个染色体做样板进行变异
		 * @param chr
		 */
		private void variation(Chromosome chr){
			//初始化g
			for (int i = 0; i < scope; i++) {
				genes[6][i] = chr.genes[6][i] + 5 * Math.random() - 2.5;//
			}
			for (int i = 0; i < 6; i++) {
				for (int j = 0; j < scope; j++) {
					genes[i][j] = chr.genes[i][j] + Math.random() - 0.5;//有可能是增加，也可能是减少
				}
			}
		}
	}
	
	//按当前的参数，从0 到 now一共中了多少次3个以上的(先算定值)
	private int statistics(double[][] genes,int now,double[] averages,int scope){
		int[] distances = new int[scope];
		double[] appears = new double[scope];
		int[] appearsFlat = new int[scope];
		for (int i = 0; i < scope; i++) {
			appearsFlat[i] = i + 1;
		}
		
		int total = 0;
		for (int i = 1; i <= now; i++) {
			for (int j = 0; j < scope; j++) {
				//计算距离
				if (scope > 16) {//红球
					if (j == (num1[i] -1) || j == (num2[i] -1) || j == (num3[i] -1)
							|| j == (num4[i] -1) || j == (num5[i] -1) || j == (num6[i] -1)) {
						distances[j] = 0;
					}else {
						distances[j]++;
					}
				}else {//蓝球
					if (j == (numb[i] -1)) {
						distances[j] = 0;
					}else {
						distances[j]++;
					}
				}
				//根据距离、平均间隔、参数计算出现的概率
				if (distances[j] >= 0 && distances[j] < averages[j]) {
					appears[j] = genes[0][j] * distances[j] + genes[1][j];
				}else if(distances[j] >= averages[j] && distances[j] <= genes[6][j]){
					appears[j] = genes[2][j] * distances[j] - genes[3][j];
				}else {
					appears[j] = genes[4][j] * distances[j] + genes[5][j];
				}
			}
			//对概率进行排序
			for (int j = 0; j < appears.length; j++) {
				for (int k = 0; k < appears.length; k++) {
					if (appears[j] > appears[k]) {
						double temp = appears[j];
						appears[j] = appears[k];
						appears[k] = temp;
						//交换标识
						int t = appearsFlat[k];
						appearsFlat[k] = appearsFlat[j];
						appearsFlat[j] = t;
					}
				}
			}
			if (scope == 16) {
				for (int j = 0; j < 5; j++) {//选5个篮球
					if (appearsFlat[j] == numb[i]) {
						total++;
					}
				}
			}else {
				//按6个一组来分，看中了多少个
				for (int j = 0; j < scope; j = j + 6) {
					int temp = 0;
					for (int k = 0; k < 6; k++) {
						if (appearsFlat[j + k] == num1[i] || appearsFlat[j + k] == num2[i] || appearsFlat[j + k] == num3[i]
						   || appearsFlat[j + k] == num4[i] || appearsFlat[j + k] == num5[i] || appearsFlat[j + k] == num6[i]){
							temp++;
						}
					}
					if (temp >= 3) {
						total++;
					}
				}				
			}
		}
		return total;
	}
	
	private void tongji(int scope,int now){
		Map<Integer, Integer>[] map = new HashMap[scope];
		for (int i = 0; i < map.length; i++) {
			map[i] = new HashMap<Integer, Integer>();
		}
		int[] flats = new int[scope];
		int[] total = new int[scope];
		for (int i = 0; i < now; i++) {
			for (int j = 0; j < scope; j++) {
				if ((numb[i] == (j + 1) && scope == 16) 
						|| (scope == 33 && (num1[i] == (j + 1) || num2[i] == (j + 1) || num3[i] == (j + 1) ||
								num4[i] == (j + 1) || num5[i] == (j + 1) || num6[i] == (j + 1)))) {
					total[j]++;
					if (map[j].containsKey(flats[j])) {
						map[j].put(flats[j], map[j].get(flats[j]) + 1);
					}else {
						map[j].put(flats[j], 1);
					}
					flats[j] = 0;
				}else {
					flats[j]++;
				}
			}
		}
		for (int i = 0; i < map.length; i++) {
			System.out.print((i + 1) + " ");
			Set<Integer> set = map[i].keySet();
			Iterator<Integer> iter = set.iterator();
			while (iter.hasNext()) {
				Integer integer = (Integer) iter.next();
				System.out.print(integer + ":" +map[i].get(integer) + " ");
			}
			System.out.println("平均" + now / total[i]);
		}		
	}
	
	public static void main(String[] args) {
//		new Yilou().doit(16,1000,10000, 1000);
		new Yilou().tongji(33,1000);
	}
	/*391
	[,0.44711272576191263,0.3769398250910412,-0.5684002819756312,0.8063485055901527,0.8166573550263325,-0.22430060932321993,0.6838223509536032,0.06009254862427871,1.3105341243895605,-0.22313496044918213,-0.08604461937377195,-0.912183189989479,1.3796350840878828,0.2590263347583118,2.717097895040252,-0.2716259219317455]
	[,0.8064943887550813,0.5994764272972977,1.2800173220703441,1.038869950426046,0.314194826451772,-0.09121646704576403,2.014717630430253,0.2535120814544085,1.3994632675020133,-1.2689312793416163,0.2981551261387837,0.6262558724912459,0.4839503154945288,0.7043739176307535,-0.14649778375586653,-7.117364185929009E-4]
	[,0.4230008108997212,0.9333181921456974,1.3786728559217267,0.32220239556925767,1.6065334181890467,-0.6659485356484547,0.34813353939663616,0.9795297670395875,0.33196210663734727,1.9693280049152668,-0.5156606582685743,-0.33289201420189996,-0.17559722451468462,1.399335339003473,0.21544441698704853,-0.30942459286251667]
	[,1.2247218625060836,-0.6682758585719417,0.5062500304503019,0.9420958659152214,1.061296696559824,1.3621004624766062,-0.2303343135603736,1.44422998398047,0.16666813421819981,-0.6459479979543569,0.1362711772271631,0.23268112889250325,0.6955806929668331,0.015592915703786625,-1.8201200854126718,1.48245717321872]
	[,1.8462160165297083,0.4867244507496691,0.26731628126701057,1.1648015804163534,0.08173945757945,1.2606219904285467,0.02093265562444846,-0.8449398590239742,0.09459059591510754,1.5187696860868831,0.9527039820064869,-0.40553872308951666,0.45126324222002545,-1.0318221550515987,0.149050071888856,1.4416011891393816]
	[,0.8006294912227745,-0.47336925729148427,-0.044151475585512356,-0.4677620688291657,0.7241791690247035,1.7097241711153761,0.9334140709168397,1.0988090996837192,0.7518548617047149,-0.668734938789594,0.9215318755995465,-0.41609672848045376,0.7624768035928744,0.13641791638115675,0.8749446668009373,-0.28527520124171624]
	[,-6.788118727211199,12.563234907759973,20.11048047575435,11.766460552804656,44.46687254026751,42.644988842443055,58.71468325257236,74.03201793566107,43.27470946244039,63.18736113690966,40.18885148844594,2.683434769390998,59.75489165751996,55.87952408814326,35.28172655985641,68.16112963936341]*/

}
