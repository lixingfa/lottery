package com._3D.method;

import com._3D.number.Number1;

/**
 * 遗漏，距离上次出现隔了多远
 * 理想情况下，距离上次出现达到平均值时出现概率最高，
 * 超过均值会下降，超过一定限度后又提高
 * @author lixingfa
 *
 */
public class Yilou {
	int[] num = Number1.num;
	/**
	 * 用遗传算法求每个取值上升、下降、上升三阶段的因数
	 * @param scope 取值范围
	 * @param now 当前期数
	 * @param chrs 取多少个染色体
	 * @param circle 稳定多少代后认为是最佳解
	 */
	public void doit(int scope,int now,int chrs,int circle,int check){
		Chromosome[] chroms = new Chromosome[chrs];
		
		//生成染色体，开始迭代
		for (int i = 0; i < chrs; i++) {
			chroms[i] = new Chromosome(scope, now,check);
		}
		boolean b = true;
		int same = 0;
		int maxTotal = 0;
		while (b) {
			//统计
			for (int i = 0; i < chroms.length; i++) {
				chroms[i].getTotal(now, scope);
			}
			//寻找最大
			Chromosome temp = chroms[0];
			for (int i = 0; i < chroms.length; i++) {
				if (chroms[i].total > temp.total) {
					temp = chroms[i];
				}
			}
			//交换、变异
			for (int i = 1; i < chroms.length; i++) {//第一个不发生改变
				chroms[i].variation(chroms[0]);//其他的以第一个为样板变异
			}
			//比较最大值
			if (temp.total > maxTotal) {
				maxTotal = temp.total;
				same = 0;
				System.out.println(maxTotal + "c:" + temp.check);
				for (int i = 0; i < temp.genes.length; i++) {
					System.out.print("[");
					for (int j = 0; j < temp.genes[i].length; j++) {
						System.out.print("," + temp.genes[i][j]);						
					}
					System.out.println("]");
				}
			}
//			else if(chroms[0].total == maxTotal){
//				same++;
//				System.out.print(" " + same);
//			}
			//得到结果
			if (maxTotal == circle) {
				b = false;
				System.out.println("当前共" + now + "期，中" + chroms[0].total + "check:" + chroms[0].check);
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
		int check;
		/**
		 * 热度h * g /检验范围check - a((与上次出现的距离l - k)/k)^2 + 1
		 * g,a,k 三个未知数
		 */
		double[][] genes;
		
		Chromosome(int scope,int now,int check){
			this.scope = scope;
			this.check = check;
			genes = new double[3][scope];
			
			for (int i = 0; i < scope; i++) {
				genes[0][i] = Math.random() * 2;// g
			}
			for (int i = 0; i < scope; i++) {
				genes[1][i] = Math.random();//a 0.01 - 0.99
			}
			for (int i = 0; i < scope; i++) {
				genes[2][i] = Math.random() * 10;//k
			}
		}
		
		private void getTotal(int now,int scope){
			statistics(this, now,scope,check);			
		}
		
		/**
		 * 以某个染色体做样板进行变异
		 * @param chr
		 */
		private void variation(Chromosome chr){
//			for (int i = 0; i < 3; i++) {
//				for (int j = 0; j < scope; j++) {
//					genes[i][j] = chr.genes[i][j] + Math.random() - 0.5;//有可能是增加，也可能是减少
//				}
//			}
			for (int i = 0; i < scope; i++) {
				genes[0][i] = Math.random() * 2;// g
			}
			for (int i = 0; i < scope; i++) {
				genes[1][i] = Math.random();//a 0.01 - 0.99
			}
			for (int i = 0; i < scope; i++) {
				genes[2][i] = Math.random() * 10;//k
			}
		}
	}
	
	//按当前的参数，从0 到 now一共中了多少次
	private void statistics(Chromosome chr,int now,int scope,int check){
		int rightM = 0;
		int rightCheck = 0;
		
		double[] appears = new double[scope];//概率
		int[] appearsFlat = new int[scope];//概率标识
		for (int i = 0; i < scope; i++) {
			appearsFlat[i] = i + 1;
		}
		for (int c = 5; c <= check; c++) {//check
			int right = 0;//对了多少个
			for (int index = check; index <= now; index++) {
				//获取h和l
				int[] h = new int[scope];
				int[] l = new int[scope];
				int[] lianxu = new int[scope];
				boolean[] has = new boolean[10];//如果已经出现过，就不用计算遗漏
				int before = -1;
				for (int i = 0; i <= check; i++) {
					int n = num[index - i];
					h[n]++;
					for (int j = 0; j <= 9; j++) {//活得遗漏
						if (n != j && !has[j]) {
							l[j]++;
						}else {
							has[j] = true;
						}
					}
					if (before == n) {
						lianxu[n]++;
					}
					before = n;
				}
				//计算概率
				for (int i = 0; i <= 9; i++) {
					appears[i] = gailv(chr.genes[0][i],chr.genes[1][i],chr.genes[2][i], h[i], l[i], lianxu[i], check);
				}
				//
				int next = num[index + 1];
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
				if (next == appearsFlat[0]) {
					right++;
				}				
			}
			if (right > rightM) {
				rightM = right;
				rightCheck = c;
			}
		}
		chr.check = rightCheck;
		chr.total = rightM;
	}
	
	//计算概率
	private double gailv(double g,double a,double k, int h,int l,int lianxu,int check){
		if (lianxu >= 3) {
			return 0f;
		}else{
			return h * g / check - a * ((l - k) / k) * ((l - k) / k) + 1;
		}
	}
	
	public static void main(String[] args) {
		new Yilou().doit(10,1000,500, 10,20);
	}
}
/**
 * 147c:5
[,0.16642912404250398,1.315818721912652,0.9662124298971069,1.4482193502696796,1.2380812952547913,0.1234008488005971,1.798933382727367,1.245028689138901,1.9921576182048644,0.3235566013609139]
[,0.9606260628055325,0.6256177571810663,0.5633154571171316,0.05704460911058573,0.10747312282849364,0.19666239357688653,0.8853616115710854,0.7342195069220151,0.8623132689080119,0.490798569526111]
[,7.248809745304898,6.7592043173675345,2.9591409161440296,4.693605409234902,5.258466736783617,1.773405956026538,9.136690567025093,9.634194531124795,7.198007295639327,9.654304103517426]
*/
