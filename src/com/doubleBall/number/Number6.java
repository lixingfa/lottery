package com.doubleBall.number;

import com.doubleBall.method.BaseMethod;

public class Number6 {
	public static int[] num={
		//16015 - 15033
		26,27,31,32,29,25,32,33,29,31,33,33,28,30,22,25,29,32,32,31,33,27,30,32,24,32,32,25,28,31,27,24,31,29,32,31,24,33,26,22,27,28,33,29,33,27,28,
		25,29,29,31,31,32,28,32,26,27,27,30,23,33,27,25,32,26,26,32,23,29,21,22,33,27,31,31,17,31,27,31,33,29,31,28,22,29,
		29,32,30,31,30,32,29,27,27,32,29,27,31,31,29,30,27,31,28,29,27,32,26,33,32,32,20,32,20,28,26,33,26,32,31,23,27,27,
		31,31,16,27,32,25,32,30,33,31,33,33,27,32,
//15032 - 14088
		32,32,26,28,28,29,33,32,24,30,25,28,23,26,29,33,31,33,30,29,31,20,31,25,22,33,33,32,24,31,32,23,25,27,32,33,16,32,
		32,29,27,26,28,24,33,29,33,29,32,33,28,31,33,32,33,32,24,27,27,32,33,33,29,30,28,29,30,29,29,32,33,33,30,28,30,28,
		28,27,25,32,28,33,31,32,16,32,31,32,24,31,29,29,26,29,32,30,29,
		//14087-03001
		33,30,29,25,33,29,29,30,28,17,22,33,29,31,33,32,25,29,30,29,23,21,22,32,31,26,31,33,25,25,31,29,30,30,31,33,24,32,
		32,25,29,22,22,33,33,33,22,15,31,33,30,22,33,31,33,33,27,30,29,32,31,23,30,30,22,26,29,25,21,33,26,24,33,29,21,24,
		32,33,32,30,28,27,33,25,33,33,29,29,33,29,33,29,32,22,30,33,24,31,32,29,31,22,27,28,27,26,31,29,25,27,26,33,31,31,
		33,33,28,30,25,27,27,31,32,33,33,33,27,33,33,31,33,32,32,32,31,32,32,28,20,16,32,20,31,26,25,30,29,22,31,31,31,29,
		25,24,28,26,32,21,23,30,31,32,26,27,29,30,33,32,28,33,28,30,33,27,30,32,30,32,31,27,18,20,29,24,28,29,32,28,33,24,
		29,25,32,32,30,26,31,28,25,33,24,30,29,19,32,31,30,33,28,33,33,29,29,28,24,31,30,30,32,20,31,21,26,30,32,28,18,20,
		28,29,29,33,23,32,32,30,32,32,33,30,25,32,28,29,32,26,32,31,32,32,33,30,32,31,27,33,31,21,17,28,17,23,29,25,32,31,
		29,31,32,24,33,33,33,29,24,29,28,28,28,32,32,29,32,31,31,32,31,28,31,32,30,28,33,30,33,33,27,31,22,33,30,33,33,32,
		21,30,25,31,22,23,33,29,33,29,29,27,33,33,28,30,32,32,27,30,23,32,29,33,30,33,31,24,27,31,18,29,31,26,31,31,28,33,
		33,24,31,24,32,30,33,33,30,25,33,28,32,31,29,33,33,26,26,33,27,24,31,31,28,30,31,25,27,28,33,27,30,29,30,32,28,25,
		23,30,32,27,26,26,33,29,32,33,33,23,31,32,17,25,26,33,27,31,26,30,33,30,24,30,31,29,29,31,32,33,31,26,31,31,33,25,
		32,26,23,29,26,32,32,28,31,33,33,32,21,30,27,33,32,33,24,27,33,33,33,29,32,28,29,16,31,31,32,27,32,26,19,24,19,30,
		32,30,25,30,29,28,24,31,32,29,26,32,32,29,29,29,33,32,32,21,27,30,28,30,24,27,32,29,33,19,30,21,31,33,33,33,25,32,
		33,30,28,16,29,31,27,33,30,32,31,31,21,32,28,29,24,25,31,31,31,29,15,32,33,31,17,26,26,33,31,25,21,31,30,33,33,33,
		29,29,26,22,26,24,19,26,31,31,18,22,26,27,33,32,31,31,26,30,30,27,30,32,31,21,31,27,27,29,31,30,33,33,30,28,32,33,
		26,31,32,28,33,28,29,25,32,27,30,29,31,25,28,26,33,25,28,30,18,27,32,24,33,29,31,32,33,29,26,26,30,33,26,28,27,32,
		33,30,24,31,26,30,30,31,27,30,31,31,27,23,22,23,24,32,22,29,31,31,26,33,32,28,25,32,32,31,24,33,26,27,30,29,32,32,
		23,25,30,29,32,30,28,33,32,32,29,31,33,32,29,32,32,16,26,30,21,32,29,33,28,31,22,32,30,22,25,31,27,32,25,26,27,33,
		23,33,28,28,23,33,30,26,32,30,33,18,18,28,31,33,32,25,25,28,30,20,29,32,32,33,33,29,28,24,31,33,29,33,21,33,33,33,
		32,30,33,30,25,32,16,23,27,30,28,32,30,30,21,31,31,32,24,32,29,32,25,30,28,33,29,29,30,32,24,31,24,33,29,30,32,33,
		33,33,33,31,29,30,32,17,32,32,30,33,28,29,30,33,31,20,32,31,30,28,27,29,32,31,23,30,30,32,33,29,32,32,30,33,30,26,
		25,32,29,32,28,30,23,32,31,31,22,30,32,30,26,30,33,30,27,32,31,33,31,26,30,32,33,32,29,26,32,30,33,33,30,18,27,23,
		27,30,26,33,32,18,27,28,23,24,33,33,26,33,21,31,30,33,31,26,30,30,19,32,33,28,33,32,29,33,27,28,33,31,26,32,33,28,
		21,32,26,33,32,32,32,33,30,30,29,22,29,26,32,33,29,33,33,29,18,31,22,23,32,31,28,30,32,30,32,31,33,32,30,28,24,30,
		17,31,29,28,28,30,32,24,27,23,31,30,29,30,32,26,31,32,32,33,33,18,30,24,33,30,28,33,30,29,33,30,31,18,17,27,31,32,
		32,31,30,30,31,25,27,31,33,27,25,32,22,33,32,29,33,24,27,28,29,19,31,28,29,29,33,28,31,28,32,32,26,32,21,30,32,32,
		28,30,31,33,22,33,33,31,28,30,32,27,32,27,30,27,25,29,19,29,29,31,33,25,24,30,28,27,30,31,32,26,30,31,26,22,25,22,
		29,33,25,33,23,27,31,30,31,28,31,33,32,32,32,28,25,31,32,32,27,26,33,31,32,17,28,14,33,28,29,29,32,32,33,30,32,33,
		20,30,32,32,32,29,33,32,31,28,33,21,29,30,27,26,32,33,29,25,32,29,31,32,28,31,33,31,30,32,28,23,33,31,23,28,33,23,
		29,29,27,21,32,29,28,27,29,33,25,33,28,30,26,30,32,30,33,31,30,29,30,33,31,31,25,28,32,31,30,21,30,27,29,26,32,33,
		27,31,31,31,26,32,33,30,26,32,28,33,32,27,25,32,27,30,33,27,22,26,33,33,31,22,27,32,29,31,30,31,29,32,27,31,23,25,
		26,31,24,31,30,31,33,33,32,29,33,30,33,33,32,32,24,33,33,30,30,26,33,29,29,33,33,22,33,26,30,30,33,31,31,31,24,28,
		32,27,23,27,33,29,33,23,21,24,29,22,26,30,31,25,28,29,29,32,29,32,33,33,32,33,33,29,24,31,27,30,33,24,33,30,28,24,
		30,30,32,29,25,31,25,33,30,31,32,30,31,20,32,32,32,21,31,32,31,28,33,32,30,32,21,29,33,31,31,32,32,19,27,27,32,32,
		27,28,27,22,29,32,26,33,30,32,33,21,33,31,29,30,32,33,32,27,31,20,28,28,29,27,30,20,32,29,30,28,28,27,32,29,19,17,
		33,22,33,27,25,30,25,29,24,25,33,33,25,26,32,33,25,32,32,32,22,31,32,30,33,27,27,30,29,25,31,30,26,31,33,33,30,31,
		24,31,31,33,30,33,29,33,29,31,27,32,31,24,26,29,22,20,30,20,30,32,28,32,33,28,31,29,20,33,22,26,33,33,26,28,23,32,
		30,23,24,33,29,26,31,31,33,29,29,32,21,32,27,28,27,24,20,22,32,30,29,32,29,28,32,31,30,32,20,29,32,28,30,32,32,26,
		32,32,25,33,31,29,22,25,31,30,29,32,24,31,30,26,31,33,33,31,33,23,31,33,28,31,32,32,33,31,25,33,33,22,32,33,31,31,
		31,31,20,29,30,29,21,32,26,33,33,31,31,30,32,25,33,31,33,33,30,32,26,27,32,25,33,30,32,26,30,26,26,31,28,29,28,33,
		29,33,29,31,32,25,33,31,28,29,33,28,26,31,32,30,32,28,25,29,29,29,29,29,31,32,28,32,24,21,29,29,29,29,26,30,32,30,
		20,31,24,31,32,22,32,32,33,32,30,30,27,31,32,30,31,32,23,26,32,33,30,19,24,33,28,32,18,29,33,31,25,33,33,28,30,27,
		33,28,31,30,30,31,30,25,29,33,32,30,27,33,19,28,33,31,32,33,30,33,32,32,28,30,33,31,29,31,33,29,31,27,26,25,31,33,
		26,32,33,32,20,25,23,32,27,32,28,11,25,30,30,32,27,32,32,28,31,27,30,31,32,30,32,33,28,31,33,32,31,32,30,32,24,30,
		23,26,27,31,25,32,26,28};

	public static int[] getAscNum(){
		return BaseMethod.desc(num);
	}
}
