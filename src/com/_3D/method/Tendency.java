package com._3D.method;

import com._3D.number.Number1;

/**
 * 找出某种值的趋势
 * @author LXF
 *
 */
public class Tendency {
	
	/**
	 * 和值结果数组
	 * @param num 号码
	 * @param end 结束位置
	 * @param how 多少期的和值
	 * @return 结果数组
	 */
	static float[] getNums(int[] num,int end,int how){
		float[] f = new float[end - how + 1];
		for (int i = 0; i < how; i++) {
			if (num[i] % 2 == 0 ) {
				f[0]++;				
			}
		}
		for (int i = how,j = 1; j < f.length; i++,j++) {			
			f[j] = f[j - 1];
			if (num[i] % 2 == 0) {
				f[j]++;
			}
			if (num[i - how] % 2 == 0) {
				f[j]--;
			}
		}
		return f;
	}
	
	/**
	 * 找出某数组在检验位置前的震荡最佳的上限、最佳的下限、最大值、最小值
	 * @param f 
	 * @param checkPlace 检验位置
	 * @return
	 */
	private static float[] info(float[] f,int checkPlace,int checkEnd,int how){
		if (checkPlace < 100) {
			System.out.println("检验起始位置过小，将设为100.");
			checkPlace = 100;
		}
		if (checkEnd > f.length) {
			System.out.println("检验结束位置过大，将设为数组的长度" + f.length);
			checkEnd = f.length;
		}
		float max = 0;
		float min = 1000;
		int maxTotal = 0;//最大正确数
		float rMax = 0;
		float rMin = 0;
		//寻找最大和最小
		for (int i = 0; i < checkPlace; i++) {
			if (f[i] > max) {
				max = f[i];
			}
			if (f[i] < min) {
				min = f[i];
			}
		}
		System.out.println("最大值：" + max + "，最小值" + min);
		float a = (max + min) / 2;//均值
		boolean up = isUp(checkPlace, f, max, min);
		for (float h = max; h > a; h--) {			
			for (float l = min; l < a; l++) {
				int t = getTotalRight(checkPlace,checkEnd, h, l, f, up,how);
				if (t > maxTotal) {
					maxTotal = t;
					rMax = h;
					rMin = l;
				}
			}			
		}
		System.out.println("检验起始位置：" + checkPlace + "，检验结束位置：" + checkEnd);
		System.out.println("最佳上限：" + rMax + "，最佳下限：" + rMin + "，走势正确率：" 
		+ maxTotal + "/" + (checkEnd - checkPlace) + "=" + (float)maxTotal/(checkEnd - checkPlace));
		return new float[]{rMax,rMin,max,min};
	}
	
	/**
	 * 是否处于爬坡状态
	 * @param now 当前位置
	 * @param f 数组
	 * @return 是否处于爬坡状态
	 */
	private static boolean isUp(int now ,float[] f,float max,float min) {
		boolean up = true;
		float l = (max - min) / 5;
		float h = max - l;
		for (int i = now; i >= 0; i--) {
			if (f[i] <= l) {
				up = true;//离低点近
				break;
			}else if (f[i] >= h) {
				up = false;//离高点近
				break;
			}
		}
		return up;
	}
	/**
	 * 获取正确的数量
	 * @param now 当前位置
	 * @param rMax 最佳上限
	 * @param rMin 最佳下限
	 * @param f 数组
	 * @param isUp 当前位置的趋势
	 * @return
	 */
	private static int getTotalRight(int now,int end,float rMax,float rMin,float[] f,boolean isUp,int how){
		int total = 0;
		boolean up = isUp;
		for (int i = now; i < end; i++) {
			if (f[i] >= rMax) {
				up = false;
			}
			if (f[i] <= rMin) {
				up = true;
			}
			if (up) {
				if (f[i] > f[i - how]) {
					total++;
				}
			}else {
				if (f[i] < f[i - how]) {
					total++;
				}
			}
		}
		return total;
	}
	
	/**
	 * 检查
	 * @param f
	 * @param now 
	 * @param rMax
	 * @param rMin
	 * @param isUp
	 */
	private static void check(int[] num,int now,int end,int how,float rMax, float rMin,boolean isUp){
		int sum = 0;
		for (int i = now,j = 0; j < how; i--,j++) {
			if (num[i] % 2 == 0) {
				sum++;				
			}
		}
		int right = 0;
		for (int i = now + 1; i < end; i++) {
			//判断大走势
			if (sum >= rMax - 2) {
				isUp = false;
			}else if (sum <= rMin + 2) {
				isUp = true;
			}
			//
			String s = "";
			if (isUp) {//往上走
				s = "↑";				
				if (num[i] % 2 == 0) {
					right++;
				}
			}else {//下降
				s = "↓";
				if (num[i] % 2 != 0) {
					right++;
				}
			}
			if (num[i] % 2 == 0) {
				sum++;
			}
			if (num[i - how] % 2 == 0) {
				sum--;
			}
//			sum = sum + num[i] - num[i - how];
			System.out.println(right + " " + (i - now) + " 出：" + num[i] + " 之前：" + num[i - how] + " " + sum + " " + s);
		}
		System.out.println(right);
	}

	public static void main(String[] args) {
		int how = 50;//多少期的和值
		int end = 1000;
		int checkPlace = 500;
		int checkEnd = 900;
		float[] f = getNums(Number1.num, end,how);
		float[] i = info(f,checkPlace,checkEnd,how);//获取最佳上限、最佳下限、最大和最小值
		boolean isUp = isUp(checkEnd + 1, f, i[2], i[3]);
		check(Number1.num, checkEnd + 1,checkEnd + 501,how, i[0], i[1], isUp);
	}
}
