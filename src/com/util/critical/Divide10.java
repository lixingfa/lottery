package com.util.critical;

import com.doubleBall.number.NumberMethod;


/**
 * 除10的余数，连续多少期后变化
 * @author Lixingfa
 *
 */
public class Divide10 extends Critical{	
	

	public Divide10(int[] num, int maxNum) {
		super(num, maxNum);
		gailv = 0.1f;
	}

	public Divide10(int[][] num, int maxNum) {
		super(num, maxNum);
		gailv = 0.1f;
	}
	
	@Override
	public float rule(int now,int place) {
		return num[now][place] % 10;
	}
	@Override
	protected float rule(int i) {
		return i % 10;
	}
	
	public static void main(String[] args) {
		Divide10 critical = new Divide10(NumberMethod.redBall(),33);
		critical.nextKill(4,0);
	}

}
