package com.util.critical;

import com.util.WuXing;



/**
 * 与后三个位置的五行算法
 * @author Lixingfa
 *
 */
public class Wuxing4 extends Critical{	
	/**临时变量*/
	private int numT;
	private int placeT = -1;
	
	public Wuxing4(int[] num, int maxNum) {
		super(num, maxNum);
		gailv = 0.2f;
	}

	public Wuxing4(int[][] num, int maxNum) {
		super(num, maxNum);
		gailv = 0.2f;
	}
	
	@Override
	public float rule(int now,int place) {
		int p = (place + 3) % 6;
		if (placeT != p) {
			placeT = p;
			numT = num[now][p];
		}
		return WuXing.shengke(WuXing.getWuXing(num[now - 1][p]), WuXing.getWuXing(num[now][place]));
	}
	@Override
	protected float rule(int i) {
		return WuXing.shengke(WuXing.getWuXing(numT), WuXing.getWuXing(i));
	}
}
