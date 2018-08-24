package com._3D.method;

import com._3D.number.Number1;


/**
 * 在数据足够大的时候，每个号码的概率是接近平均的
 * @author LXF
 *
 */
public class Average {//TODO 某几个数字出现后，就会换到另外一堆。这些组合应该是动态的，我们需要找出最佳的动态的变换的参数个数和值。
	/**
	 * 寻找等候遗漏的关键信息
	 * @param num 数据
	 * @param scope 数据的范围
	 * @param end 验证多长
	 * @return 每个号码的参数，分别为验证多少期n(10,500),开始预防x(-0.1,0.9),等待多少期wait(1,30)
	 */
	static float[][] info(int[] num,int scope,int end){
		float[][] param = new float[scope][3];
		for (int i = 0; i < param.length; i++) {
			param[i][0] = 10;
			param[i][1] = -0.1f;
			param[i][2] = 1;
		}
		float maxRight = 0;
		float initRight = 0;
		for (int i = 0; i < param.length; i++) {
			for (int j = 10; j < end; j++) {
				initRight = initRight + input(param,num,j,new int[]{1,1,1,1,1,1,1,1,1,1});
			}
		}
		for (int n = 10; n <= 500; n++) {
			for (float x = -0.1f; x < 0.9; x = x + 0.01f) {
				for (int wait = 2; wait <= 30; wait++) {//从2开始，有变化
					int[] w = new int[param.length];
					for (int i = 0; i < param.length; i++) {
						float right = initRight;
						param[i][0] = n;
						param[i][1] = x;
						param[i][2] = wait;
						w[i] = (int) param[i][2];
						for (int j = 0; j < end; j++) {
							right = right + input(param,num,j,w);
						}
						if (right > maxRight) {
							maxRight = right;
							System.out.println(right);
							for (int k = 0; k < param.length; k++) {
								System.out.println(param[k][0] + " " + param[k][1] + " " + param[k][2]);
							}
						}
					}
				}
			}
		}
		return param;
	}
	
	private static float input(float[][] param,int[] num,int now,int[] wait){
		boolean[] chu = new boolean[param.length];
		for (int i = 0; i < param.length; i++) {
			if (wait[i] != 0 && chu[i]) {
				chu[i] = true;
				wait[i]--;
				continue;
			}else {
				chu[i] = false;
			}
			int total = 0;
			for (int j = (int) param[i][0]; j >= 0; j--) {//n
				if (num[now + j] == i) {
					total++;
				}
			}
			float x = (float)total / param[i][0] - 0.1f;
			if (x <= param[i][1]) {
				chu[i] = true;
				wait[i] = (int) param[i][2];
			}
		}
		//
		int total = 0;
		boolean right = false;
		for (int i = 0; i < chu.length; i++) {
			if (chu[i]) {
				total++;
				if (num[now + 1] == i) {
					right = true;
				}
			}
		}
		if (right) {
			return 1f / total;					
		}else {
			return 0f;
		}
	}
	
	public static void main(String[] args) {
		info(Number1.num, 10, 2000);		
	}
}
