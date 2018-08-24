package com.doubleBall.method;

import com.doubleBall.number.Number1Y;

/**
 * 划分，最简单的就是分成两份，预测下一次会出现在哪个区域
 * @author Lixingfa
 *
 */
public class Partition {
	/**
	 * 对一组数据，预测下一次
	 * @param nums 数据
	 * @param scope 数据的范围
	 * @param now 当前位置
	 * @return
	 */
	public static boolean partition(int[] nums,int scope,int now){
		int[] d2 = new int[2];
		int[] d4 = new int[4];
		int[] d8 = new int[8];
		for (int i = 0; i < now; i++) {
			if(nums[i] * 2 / scope > 0){
				d2[1]++;
				d2[0] = 0;
			}else {
				d2[1] = 0;
				d2[0]++;
			}
			if(nums[i] * 4 / scope > 0){
				d4[2]++;d4[3]++;
				d4[0] = 0;d4[1] = 0;
			}else {
				d4[2] = 0;d4[3] = 0;
				d4[0]++;d4[1]++;
			}
			if(nums[i] * 8 / scope > 0){
				d8[4]++;d8[5]++;d8[6]++;d8[7]++;
				d8[0] = 0;d8[1] = 0;d8[2] = 0;d8[3] = 0;
			}else {
				d8[4] = 0;d8[5] = 0;d8[6] = 0;d8[7] = 0;
				d8[0]++;d8[1]++;d8[2]++;d8[3]++;
			}
		}
		int next = nums[now + 1];
		if ((d2[1] > 0 && next <= 16) || (d2[0] == 0 && next > 16)) {
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		int totle = 0;
		for (int i = 10; i < 1000; i++) {
			if (partition(Number1Y.getAscNum(), 33, i)) {
				totle++;
			}
		}
		System.out.print(totle);
	}
}
