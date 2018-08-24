package com.util.critical;



/**
 * 除10的余数，连续多少期后变化
 * @author Lixingfa
 *
 */
public class Divide5 extends Critical{	
	

	public Divide5(int[] num, int maxNum) {
		super(num, maxNum);
		gailv = 0.2f;
	}

	public Divide5(int[][] num, int maxNum) {
		super(num, maxNum);
		gailv = 0.2f;
	}
	
	@Override
	public float rule(int now,int place) {
		return num[now][place] % 5;
	}
	@Override
	protected float rule(int i) {
		return i % 5;
	}
}
