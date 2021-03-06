package com.util.critical;

import com.doubleBall.number.NumberMethod;


/**
 * 除34的余数，连续多少期后变化
 * @author Lixingfa
 *
 */
public class Divide34 extends Critical{	
	
	
	public Divide34(int[] num, int maxNum) {
		super(num, maxNum);
		gailv = 0.03f;
	}

	public Divide34(int[][] num, int maxNum) {
		super(num, maxNum);
		gailv = 0.03f;
	}
	
	@Override
	public float rule(int now,int place) {
		return num[now][place] % 34;
	}
	@Override
	protected float rule(int i) {
		return i % 34;
	}
	public static void main(String[] args) {
//		Divide10 critical = new Divide10(Bull.getAscNum(),16);
		Divide34 critical = new Divide34(NumberMethod.redBall(),33);
		critical.nextKill(1000,0);
	}
}
