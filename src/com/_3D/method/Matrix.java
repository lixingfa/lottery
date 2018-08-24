package com._3D.method;

import com._3D.number.Number1;

/**
 * 遗漏矩阵
 * 统计历史情况：下一期出现的位置赋予本遗漏数组最大值+1
 * @author LXF
 *
 */
public class Matrix {
	/**
	 * 获取指定期数前的遗漏矩阵
	 * @param num 要统计的号码
	 * @param scope 数值范围
	 * @param now 指定期数
	 * @param maxOmit 最大遗漏，可以从500彩票网得到
	 */
	public void getOmitMatrix(int[] num,int scope,int now,int end,int maxOmit){
		int[][] matrix = new int[maxOmit][scope];
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
		//开始统计矩阵
		for (int i = begin; i < now; i++) {
			//获取与上次出现的距离l
			int[] l = getL(scope, maxOmit, num, i);
			//计算矩阵最大值
			int max = 0;
			for (int j = 0; j < scope; j++) {
				if (matrix[l[j]][j] > max) {
					max = matrix[l[j]][j];
				}
			}
			//下一期出现的位置赋予最大值+1
			matrix[l[num[i + 1]]][num[i + 1]] = max + 1;
		}
		//
		System.out.println("验证矩阵");
		int total = 0;
		for (int i = begin; i < now; i++) {
			int[] l = getL(scope, maxOmit, num, i);
			int max = 0;
			int n = 0;
			for (int j = 0; j < l.length; j++) {
				if (matrix[l[j]][j] > max) {
					n = j;
				}
			}
			if (num[i + 1] == n) {
				total++;
			}
		}
		System.out.println(total + "/" + (end - now));
	}

	private int[] getL(int scope,int maxOmit,int[] num,int i){
		int[] l = new int[scope];
		boolean[] has = new boolean[scope];//如果已经出现过，就不用计算遗漏			
		for (int j = 0; j <= maxOmit; j++) {//往前找
			int n = num[i - j];
			for (int k = 0; k < scope; k++) {//遗漏
				if (n != k && !has[k]) {
					l[k]++;
				}else {
					has[k] = true;
				}
			}
			//看所有位置的遗漏都找到了
			boolean b = true;
			for (int k = 0; k < l.length; k++) {
				b = b && has[k];
			}
			if (b) {
				break;
			}
		}
		return l;
	}
	
	public static void main(String[] args) {
		new Matrix().getOmitMatrix(Number1.num, 10, 1000,2000, 100);
	}
}
