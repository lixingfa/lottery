/**
 * 
 */
package com.doubleBall.method;

import java.util.ArrayList;

import com.doubleBall.number.Bull;
/**
 * @author lixingfa
 * @date 2018年1月27日下午3:56:44
 * 根据相似性原理，找出最佳的距离段，在段中的结果会趋于某个稳定值，偏差最小
 */
public class ShouLian {

	public static void sumBull(){
		int duan = 0;
		float jieguo = 0f;
		float xiao = 0f;//小偏差
		float da = 0f;//大偏差
		
		int length = Bull.num.length;
		for (int i = 1; i <= 100; i++) {
			ArrayList<Integer> sumList = new ArrayList<Integer>();
			float sum = 0f;
			for (int j = 0; j < length; j = j + i + 1) {
				int sumt = 0;
				for (int k = j; k <= j + i; k++) {
					sumt = sumt + (Bull.num[k]);					
				}
				sum = sum + sumt;
				sumList.add(sumt);
			}
			//均值、方差，找最小的
			
		}
	}
	
	public static void main(String[] args) {
		ShouLian.sumBull();
	}
}
