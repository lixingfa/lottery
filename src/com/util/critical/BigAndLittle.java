package com.util.critical;

import com.doubleBall.number.NumberMethod;


/**
 * 大的一边，还是小的一边
 * @author Lixingfa
 *
 */
public class BigAndLittle extends Critical{	
	

	public BigAndLittle(int[] num, int maxNum) {
		super(num, maxNum);
		gailv = 0.5f;
	}

	public BigAndLittle(int[][] num, int maxNum) {
		super(num, maxNum);
		gailv = 0.5f;
	}
	
	@Override
	public float rule(int now,int place) {
		if (num[now][place] <= maxNum / 2) {
			return 1;
		}else {
			return 0;
		}
	}
	@Override
	protected float rule(int i) {
		if (i <= maxNum / 2) {
			return 1;
		}else {
			return 0;
		}
	}
	
	public static void main(String[] args) {
		BigAndLittle critical = new BigAndLittle(NumberMethod.redBall(),33);
		critical.nextKill(4,0);
	}

}
