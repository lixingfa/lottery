/**
 * 
 */
package com.util;

/** k-临近算法
 * @author lixingfa
 * @date 2018年12月17日下午3:53:14
 * 
 */
public class KNearTest {

	public static void test(int n,int m,int testNum,int how,int K){
		Integer[] scope = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33};
		//1、初始化数据
		Integer[][] num = new Integer[n][m];
		for (int i = 0; i < num.length; i++) {
			num[i] = Combine.getRandomCombine(scope, m);
		}
		//2、建立标签
		int i = n - testNum;
		int[][][] dist = new int[i][m][how];//第几行，第几列，与其他位置的距离
		for (; i >= how; i--) {//行
			for (int j = 0; j < m; j++) {//列
				dist[i][j][0] = num[i + 1][j];//首行是下一个值
				for (int k = 1; k < how; k++) {//与其他位置的距离
					dist[i][j][k] = Math.abs(num[i][j] - num[i - k][j]);					
				}
			}
		}
		//3、校验
		i = n - testNum + 1;
		for (; i < n; i++) {
			for (int j = 0; j < m; j++) {
				int[] d = new int[how];
				for (int k = 1; k < how; k++) {
					d[k] = Math.abs(num[i][j] - num[i - k][j]);
				}
				//比较距离,k-近似值算法
				
			}
		}
	}
	
	private int getDist(int[] d,int[][][] dist,int j){
		int max = 10000;
		int dtemp = 0;
		int next = 0;
		for (int i = 0; i < dist.length; i++) {
			for (int k = 1; k < d.length; k++) {
				dtemp = dtemp + Math.abs(d[k] - dist[i][j][k]);				
			}
			if (dtemp < max) {
				max = dtemp;
				next = dist[i][j][0];
				if (max <= 3) {
					return next;
				}
			}
		}
		return next;
	}
	
	public static void main(String[] args) {
		test(10, 6,2,4,3);
	}
}
