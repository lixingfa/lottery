package com.util.critical;

import com.util.WuXing;



/**
 * 本位置的五行算法
 * @author Lixingfa
 *
 */
public class Wuxing2 extends Critical{	
	/**临时变量*/
	private int numT;
	private int placeT = -1;
	
	public Wuxing2(int[] num, int maxNum) {
		super(num, maxNum);
		gailv = 0.2f;
	}

	public Wuxing2(int[][] num, int maxNum) {
		super(num, maxNum);
		gailv = 0.2f;
	}
	
	@Override
	public float rule(int now,int place) {
		if (placeT != place) {
			placeT = place;
			numT = num[now][place];
		}
		return WuXing.shengke(WuXing.getWuXing(num[now - 1][place]), WuXing.getWuXing(num[now][place]));
	}
	@Override
	protected float rule(int i) {
		return WuXing.shengke(WuXing.getWuXing(numT), WuXing.getWuXing(i));
	}
}
