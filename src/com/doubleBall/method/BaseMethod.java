package com.doubleBall.method;
/**一些基础的方法
 * @author LIXF
 *
 */
public class BaseMethod {
	/**
	 * 获取一个数组的倒叙
	 * @param nums
	 * @return
	 */
	public static int[] desc(int[] nums){
		return desc(nums, 0, nums.length);
	}
	public static String[] desc(String[] nums){
		return desc(nums, 0, nums.length);
	}
	/**
	 * 获取一个数组的倒叙
	 * @param nums
	 * @return
	 */
	public static String[] desc(String[] s,int start,int end){
		String[] temp = new String[end - start];
		if (end == s.length) {
			end = end - 1;
		}		
		for (int i = end,j = 0; i >= start; i--,j++) {
			temp[j] = s[i];
		}
		return temp;
	}
	
	public static int[] desc(int[] nums,int start,int end){
		int[] temp = new int[end - start];
		if (end == nums.length) {
			end = end - 1;
		}		
		for (int i = end,j = 0; i >= start; i--,j++) {
			temp[j] = nums[i];
		}
		return temp;
	}
	
	public static void main(String[] args) {
		
	}

}
