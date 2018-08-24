package com.doubleBall.method;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import com.doubleBall.number.NumberMethod;
import com.util.Combine;


/**
 * 在数据足够大的时候，每个号码的概率是接近平均的
 * @author LXF
 *TODO 应该把每个组合记录到数据库里，以一年或100期为阶段，统计概率，并记录下来。形成可以分析的数据
 * 中奖率 = 中的注数 / 总的注数。而不因某次全中，影响了整体的判断
 */
public class Average {
	int maxCandidate = 16;
	int N = 200;
	/***/
	List<Float[]> pList = new ArrayList<Float[]>();
	public Average() {
		for (int n = 10; n <= N; n++) {//往回找的期数
			for (float x = -0.1f; x <= 0.9f; x = x + 0.01f) {//防范界限 0.01f，如果都没有，就是-0.1，如果N期里都是，就是0.9
				for (int w = 1; w <= 30; w++) {//防范期数
					Float[] p = new Float[3];
					p[0] = (float) n;
					p[1] = x;
					p[2] = (float) w;
					pList.add(p);
				}
			}
		}
	}
	
	/**集合，数组的长度为33，数组的值来自pList*/
	Set<Integer[]> set = new HashSet<Integer[]>();
	
	private float[][] getParam(){
		float[][] param = new float[33][3];
		Integer[] orders = new Integer[33];
		boolean noFind = true;
		while (noFind) {
			for (int i = 0; i < orders.length; i++) {
				orders[i] = (int)(Math.random() * pList.size());
			}
			//看是否已经包含
			Iterator<Integer[]> iterator = set.iterator();
			boolean allSame = false;
			while (iterator.hasNext()) {
				Integer[] t = (Integer[]) iterator.next();
				boolean notSame = false;
				for (int i = 0; i < t.length; i++) {
					if (orders[i] != t[i]) {
						notSame = true;
						break;
					}
				}
				if (!notSame) {//找到一模一样的
					allSame = true;
					break;
				}
			}
			if (!allSame) {
				noFind = false;
				set.add(orders);				
			}
		}
		for (int i = 0; i < orders.length; i++) {
			param[i][0] = pList.get(orders[i])[0];
			param[i][1] = pList.get(orders[i])[1];
			param[i][2] = pList.get(orders[i])[2];
		}
		return param;
	}
	
	/**
	 * 寻找等候遗漏的关键信息
	 * @param end 验证多长
	 * @return 每个号码的参数，分别为验证多少期n(10,500),开始预防x(-0.1,0.9),等待多少期wait(1,30)
	 */
	int[] getIncom(int[][] redBall,int start,int end,Chromosome chr){
		return getIncom(redBall, start, end, chr,false);
	}
	int[] getIncom(int[][] redBall,int start,int end,Chromosome chr,boolean isPrint){
		//一些参数
		int income = 0;//奖金
		int T = 0;//注数
		int Z = 0;//中的注数
		boolean[] isDe = new boolean[33];
		float[] wait = new float[33];
		//开始计算
		if (end < 500) {
			end = 500;
		}
		if (start < 500) {
			start = 500;
		}
		for (int now = start; now <= end; now++) {
			List<Integer> candidate = new ArrayList<Integer>();
			//按当前每个配置，获取是否防范
			for (int k = 0; k < isDe.length; k++) {
				//不防范或防范到期，重新计算，看是否需要防范
				if (!isDe[k] || wait[k] == 0) {
					//往回计算n期
					float total = 0;
					for (int l = 0; l < chr.param[k][0]; l++) {
						for (int j = 0; j < redBall[0].length; j++) {
							if (redBall[now - l][j] == (k + 1)) {//从0开始的
								total++;
							}
						}
					}
					total = total / chr.param[k][0];//计算
					if (total <= chr.param[k][1]) {
						isDe[k] = true;
						wait[k] = chr.param[k][2];
					}
				}
				//需要防范的
				if (isDe[k]) {
					//加入候选
					candidate.add(k + 1);
					//数值变化
					wait[k]--;
					if (wait[k] == 0) {
						isDe[k] = false;
					}
				}
			}
			if (candidate.size() < 6 || candidate.size() > maxCandidate) {
				continue;
			}
			//根据候选计算成本
			List<Set<Integer>> com = Combine.getAllCombine(candidate.toArray(new Integer[]{}), 6);
			T = T + com.size() * 16;
			//计算收益
			for (int j = 0; j < com.size(); j++) {
				int zong = 0;
				Set<Integer> num = com.get(j);
				for (int l = 0; l < 6; l++) {
					if (num.contains(redBall[now + 1][l])) {
						zong++;
					}										
				}
				switch (zong) {
					case 3://3+1 10元
						income = income + 10;//假设中3个也中了蓝球，抵消只中蓝球的
						Z = Z + 1;
						break;
					case 4://4 10元,4+1 200元
						income = income + 200;
						income = income + 10 * 15;//另外15注蓝球
						Z = Z + 16;
						break;
					case 5://5 200元,5+1 3000元
						income = income + 3000;
						income = income + 200 * 15;//另外15注蓝球
						Z = Z + 16;
						break;
					case 6://5 200元,5+1 3000元
						income = income + 5000000;
						income = income + 200000 * 15;//另外15注蓝球
						Z = Z + 16;
						if (isPrint) {
							System.out.print(now + 1 + " ");
							for (int i = 0; i < 6; i++) {
								System.out.print(redBall[now + 1][i] + " ");
							}						
						}
						break;	
					default:									
						break;
				}
				if (isPrint && zong >= 3) {
					System.out.println(now + 1 + " " + income);							
				}
			}
			if (isPrint) {
				System.out.println(income + "/" + T + "=" + ((float)income/T));
			}
		}
		if (isPrint) {
			System.out.println(income + "/" + T + "=" + ((float)income/T));
		}
		return new int[]{Z,T,income};
	}
	
	private class Chromosome{
		//每个号码的参数，分别为验证多少期n(10,500),开始预防x(-0.1,0.9),等待多少期wait(1,30)
		float[][] param;
		public Chromosome() {
			param = getParam();
		}
		public Chromosome(float[][] param) {
			this.param = param;
		}
	}
	
	Chromosome getChromosome(float[][] param){
		return new Chromosome(param);
	}
	
	void info(int eachHow,int end){
		int[][] redBall = NumberMethod.redBall();
		int total = 0;
		float maxIncom = 0;
		while (true) {
			total = total + eachHow;
			System.out.println(total);
			for (int i = 0; i < eachHow; i++) {
				Chromosome chr = new Chromosome();
				int[] incost = getIncom(redBall,500, end, chr);
				if ((float)incost[0] / incost[1] > maxIncom) {
					maxIncom = (float)incost[0] / incost[1];
					System.out.println("=== 中：" + incost[0] + "，共：" + incost[1] + ",比率：" +  maxIncom 
							+ ",利率：" + incost[2] + "/" + incost[1] * 2 + "=" + (float)incost[2]/incost[1] * 2 + " ===");
					for (int j = 0; j < chr.param.length; j++) {
						System.out.println("{" + chr.param[j][0] + ", " + chr.param[j][1] + "f, " + chr.param[j][2] + "},");
					}
				}
			}
		}
	}
	
	public static void main(String[] args) {
		int end = 1000;
//		new Average().info(100,end);
		float[][] param = {{92, -0.030000014f, 4},
				{157, 0.24000002f, 30},
				{197, 0.46999982f, 6},
				{37, 0.17999999f, 20},
				{11, 0.009999985f, 19},
				{25, 0.12999997f, 4},
				{152, 0.089999974f, 21},
				{100, 0.35999992f, 20},
				{196, 0.13999997f, 30},
				{124, 0.42999986f, 7},
				{58, 0.78999954f, 15},
				{92, 0.21000001f, 7},
				{137, 0.5299998f, 10},
				{193, 0.29f, 9},
				{62, 0.06999998f, 28},
				{102, 0.25000003f, 9},
				{113, -1.4901161E-8f, 6},
				{102, -1.4901161E-8f, 20},
				{124, 0.7399996f, 13},
				{134, 0.06999998f, 19},
				{140, 0.3799999f, 30},
				{45, 0.24000002f, 10},
				{103, 0.45999983f, 19},
				{103, 0.17999999f, 9},
				{169, 0.019999985f, 30},
				{76, 0.5999997f, 19},
				{144, 0.22000001f, 12},
				{174, 0.5099998f, 1},
				{45, 0.2f, 6},
				{51, 0.8099995f, 1},
				{155, -0.07000001f, 20},
				{11, 0.089999974f, 4},
				{60, 0.09999997f, 16}};
		Average average = new Average();
		average.getIncom(NumberMethod.redBall(), 500, end, average.getChromosome(param),true);
	}
}
