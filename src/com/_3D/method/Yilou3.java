package com._3D.method;

import java.util.ArrayList;

import com._3D.number.Number1;
import com._3D.number.Number2;
import com._3D.number.Number3;

public class Yilou3 {
	
	ArrayList<Chromosome> already = new ArrayList<Chromosome>();
	
	public void doit(int scope,int now,int chrs,int circle,int maxOmit,int[] num){
		Chromosome[] chroms = new Chromosome[chrs];		
		//生成染色体
		for (int i = 0; i < chrs; i++) {
			chroms[i] = new Chromosome(scope, now);
			already.add(chroms[i]);
		}
		//寻找开始统计的位置
		int begin = 0;
		boolean[] has = new boolean[scope];//已经出现过
		for (int i = 0; i < now; i++) {
			has[num[i]] = true;
			boolean b = true;
			for (int j = 0; j < has.length; j++) {
				b = b && has[j];
			}
			if (b) {
				begin = i;//从所有都出现的开始
				System.out.println("开始统计位置：" + begin);
				break;
			}
		}
		boolean ok = true;
		int maxTotal = 0;
		//开始查找
		while (ok) {
			for (int i = begin; i < now; i++) {
				int[] l = new int[scope];
				int[] h = new int[scope];
				has = new boolean[scope];//如果已经出现过，就不用计算遗漏
				int[] lianxu = new int[scope];
				int j = 0;
				int before = -1;
				for (; j <= maxOmit; j++) {//往前找
					int n = num[i - j];
					h[n]++;
					for (int k = 0; k < scope; k++) {//遗漏
						if (n != k && !has[k]) {
							l[k]++;
						}else {
							has[k] = true;
						}
					}
					//连续
					if (before == n) {
						lianxu[n]++;
					}
					before = n;
					//看所有位置的遗漏都找到了
					boolean b = true;
					for (int k = 0; k < l.length; k++) {
						b = b && has[k];
					}
					if (b) {
						break;
					}
				}
				//用h l j计算概率
				for (int k = 1; k < chroms.length; k++) {
					chroms[k].gailv(h, l, lianxu, j, num[i + 1]);
				}
			}
			//对染色体进行排序
			for (int i = 0; i < chroms.length; i++) {
				for (int j = 0; j < chroms.length; j++) {
					if (chroms[i].total > chroms[j].total) {
						Chromosome t = chroms[i];
						chroms[i] = chroms[j];
						chroms[j] = t;
					}
				}
			}
			//变异
			//交换、变异
			for (int i = 1; i < chroms.length; i++) {//第一个不发生改变
				chroms[i].variation(chroms);//其他的以第一个为样板变异
			}
			//比较最新值
			if (maxTotal < chroms[0].total) {
				maxTotal = chroms[0].total;
				System.out.println(maxTotal + "/" + (now - begin));
				for (int i = 0; i < chroms[0].genes.length; i++) {
					System.out.print("[" + chroms[0].genes[i][0]);
					for (int j = 1; j < chroms[0].genes[i].length; j++) {
						System.out.print("," + chroms[0].genes[i][j]);						
					}
					System.out.println("]");
				}
			}
			//得到结果
			if (maxTotal == circle) {
				ok = false;
				System.out.println("当前共" + now + "期，中" + chroms[0].total);
				for (int i = 0; i < chroms[0].genes.length; i++) {
					System.out.print("[" + chroms[0].genes[i][0]);
					for (int j = 1; j < chroms[0].genes[i].length; j++) {
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
		 * 热度h * g /检验范围check - a((与上次出现的距离l - k)/k)^2 + 1
		 * g,a,k 三个未知数
		 */
		float[][] genes;
		
		Chromosome(int scope,int now){
			this.scope = scope;
			genes = new float[3][scope];
			
			for (int i = 0; i < scope; i++) {
				genes[0][i] =  Float.valueOf(String.format("%.2f", Math.random() * 2));// g
			}
			for (int i = 0; i < scope; i++) {
				genes[1][i] = Float.valueOf(String.format("%.2f", Math.random()));//a 0.01 - 0.99
			}
			for (int i = 0; i < scope; i++) {
				genes[2][i] = Float.valueOf(String.format("%.2f", Math.random() * 10));//k
			}
		}		
		/**
		 * 变异
		 * @param chr
		 */
		private void variation(Chromosome[] chr){
			total = 0;
			int length = chr.length / 3;
			if (Math.random() > 0.5) {
				for (int i = 0; i < 3; i++) {
					for (int j = 0; j < scope; j++) {
						genes[i][j] = chr[(int)(Math.random() * length)].genes[i][(int)(Math.random() * scope)];// g						
					}
				}
			}else {
				for (int i = 0; i < scope; i++) {
					genes[0][i] =  Float.valueOf(String.format("%.2f", Math.random() * 2));// g
				}
				for (int i = 0; i < scope; i++) {
					genes[1][i] = Float.valueOf(String.format("%.2f", Math.random()));//a 0.01 - 0.99
				}
				for (int i = 0; i < scope; i++) {
					genes[2][i] = Float.valueOf(String.format("%.2f", Math.random() * 10));//k
				}
			}
			//查看是否已经存在了
//			if (already.contains(genes)) {
//				variation(chr);
//			}
		}
		/**
		 * 计算概率
		 */
		private void gailv(int[] h,int[] l,int[] lianxu,int check,int next){
			double[] appears = new double[scope];//概率
			//计算概率
			for (int i = 0; i < scope; i++) {
				if (lianxu[i] >= 3 || l[i] >= 15) {
					appears[i] = 0f;
				}else{
					appears[i] = h[i] * genes[0][i] / check - genes[1][i] * ((l[i] - genes[2][i]) / genes[2][i]) * ((l[i] - genes[2][i]) / genes[2][i]) + 1;
				}
			}
			//寻找最大
			double max = 0;
			int flat = -1;
			for (int i = 0; i < appears.length; i++) {
				if (appears[i] > max) {
					max = appears[i];
					flat = i;
				}
			}
			if (flat == next) {
				total++;
			}
			
		}
	}
	
	private boolean contains(float[][] g){
		for (int i = 0; i < already.size(); i++) {//循环已经出现过的
			float[][] genes = already.get(i).genes;
			boolean same = true;
			for (int j = 0; j < genes.length; j++) {
				for (int k = 0; k < genes[j].length; k++) {
					if (genes[j][k] != g[j][k]) {
						same = false;
						break;
					}
				}
				if (!same) {
					break;
				}
			}
			if (same) {
				System.out.println("出现相同");
				return same;
			}
		}
		return false;
	}
	
	private void check(double[][] genes,int scope,int now,int[] num){
		int tatle = 0;
		//寻找开始统计的位置
		int begin = 0;
		boolean[] has = new boolean[scope];//已经出现过
		for (int i = 0; i < now; i++) {
			has[num[i]] = true;
			boolean b = true;
			for (int j = 0; j < has.length; j++) {
				b = b && has[j];
			}
			if (b) {
				begin = i;//从所有都出现的开始
				System.out.println("开始统计位置：" + begin);
				break;
			}
		}
		for (int i = begin; i < now; i++) {
			int[] l = new int[scope];
			int[] h = new int[scope];
			has = new boolean[scope];//如果已经出现过，就不用计算遗漏
			int[] lianxu = new int[scope];
			int j = 0;
			int before = -1;
			for (; j <= now; j++) {//往前找
				int n = num[i - j];
				h[n]++;
				for (int k = 0; k < scope; k++) {//遗漏
					if (n != k && !has[k]) {
						l[k]++;
					}else {
						has[k] = true;
					}
				}
				//连续
				if (before == n) {
					lianxu[n]++;
				}
				before = n;
				//看所有位置的遗漏都找到了
				boolean b = true;
				for (int k = 0; k < l.length; k++) {
					b = b && has[k];
				}
				if (b) {
					break;
				}
			}
			//用h l j计算概率
			double[] appears = new double[scope];//概率
			//计算概率
			for (int k = 0; k < scope; k++) {
				if (lianxu[k] >= 3 || l[k] >= 15) {
					appears[k] = 0f;
				}else{
					appears[k] = h[k] * genes[0][k] / j - genes[1][k] * ((l[k] - genes[2][k]) / genes[2][k]) * ((l[k] - genes[2][k]) / genes[2][k]) + 1;
				}
			}
			//寻找最大
			double max = 0;
			int flat = -1;
			for (int k = 0; k < appears.length; k++) {
				if (appears[k] > max) {
					max = appears[k];
					flat = k;
				}
			}
			if (flat == num[i + 1]) {
				tatle++;
			}
		}
		System.out.println(tatle + "/" + (now - begin));
	}
	
	public static void main(String[] args) {
		//int scope,int now,int chrs,int circle,int maxOmit,int[] num
//		new Yilou3().doit(10, 2023, 500, 500, 100, Number3.num);
		double[][] genes = {{0.8,0.32,0.35,0.97,1.26,1.17,1.92,0.18,0.2,1.22},
		                     {0.01,0.2,0.77,0.95,0.36,0.29,0.46,0.29,0.82,0.71},
		                      {8.33,2.32,2.49,5.59,7.69,8.57,5.51,7.23,9.9,8.64}};
		new Yilou3().check(genes, 10, 2046, Number2.num);
	}
	/*
	 * 140/1000 Number1
[1.01,0.3,0.49,1.67,0.95,1.62,1.59,0.36,1.76,0.81]
[0.58,0.51,0.65,0.7,0.1,0.58,0.77,0.4,0.62,0.45]
[1.13,4.35,4.53,3.33,2.9,7.89,4.91,1.07,0.07,5.04]
138/1000
[0.86,0.8,0.16,1.14,1.52,1.48,1.5,0.62,0.16,1.05]
[0.21,0.46,0.83,0.22,0.28,0.3,0.51,0.54,0.48,0.38]
[5.39,6.96,9.15,0.47,4.77,7.92,4.77,9.37,8.79,5.83]
Number2
144/993
[0.8,0.32,0.35,0.97,1.26,1.17,1.92,0.18,0.2,1.22]
[0.01,0.2,0.77,0.95,0.36,0.29,0.46,0.29,0.82,0.71]
[8.33,2.32,2.49,5.59,7.69,8.57,5.51,7.23,9.9,8.64]
Number3
137/1000
[1.2,0.1,0.19,0.86,0.04,0.31,1.2,0.7,1.53,0.42]
[0.6,0.26,0.87,0.9,0.01,0.29,0.96,0.13,0.95,0.6]
[5.59,1.71,6.53,8.6,9.63,5.24,2.44,0.51,2.63,0.01]
	 */
}
