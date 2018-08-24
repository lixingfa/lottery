package com.util.critical;



/**
 * 除10的余数，连续多少期后变化
 * @author Lixingfa
 *
 */
public class Divide2 extends Critical{	
	

	public Divide2(int[] num, int maxNum) {
		super(num, maxNum);
		gailv = 0.5f;
	}

	public Divide2(int[][] num, int maxNum) {
		super(num, maxNum);
		gailv = 0.5f;
	}
	
	@Override
	public float rule(int now,int place) {
		return num[now][place] % 2;
	}
	@Override
	protected float rule(int i) {
		return i % 2;
	}

}
