package com.doubleBall.method;

public class BlueTest {

	// 上一期蓝号
	private static Integer sn1 = 13;

	// 上二期蓝码
	private static Integer sn2 = 7;

	// 上三期蓝码
	private static Integer sn3 = 3;

	// 本期中奖号码
	private static Integer win = 14;

	// 总共次数
	private static double sum = 0;

	// 中奖次数
	private static double count = 0;

	public static void main(String[] args) {
		BlueTest bt = new BlueTest();
		// 生成的蓝号
		// 循环计算次数
		int y = 0;
		while (y < 100) {
			int num = bt.randomNumber();
			if (bt.isTorF1(num) && bt.isTorF2(num) && bt.isTorF3(num)
					&& bt.isTorF4(num) && bt.isTorF5(num) && bt.isTorF6(num)
					&& bt.isTorF7(num) && bt.isTorF8(num) && bt.isTorF9(num)
					&& bt.isTorF10(num) && bt.isTorF11(num) && bt.isTorF12(num)) {
				if (num == win) {
					System.out.println("本次生成的蓝号为：" + num + " , 中");
					count++;
				} else {
					System.out.println("本次生成的蓝号为：" + num);
				}
				sum++;
				y++;
			}
		}
		System.out.println("总共次数为：" + sum);
		System.out.println("中奖次数为：" + count);
		System.out.println("中奖概率为：" + (count / sum * 100) + "%");
	}

	/**
	 * 随机生成1-16的数字
	 * 
	 * @author 杨朝敬
	 * @date 2015年9月29日
	 * @return
	 */
	public Integer randomNumber() {
		int[] arrayNum = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16 };
		int rdnm = arrayNum[(int) (Math.random() * 16)];
		return rdnm;
	}

	/**
	 * 判断true or false
	 * 
	 * @author 杨朝敬
	 * @date 2015年9月29日
	 * @param num
	 * @param sw
	 * @return
	 */
	public boolean torf(int num, int sw) {
		if (sw >= 10) {
			sw = sw % 10;
		}
		if (num >= 10 && num - 10 == sw) {
			return false;
		} else if (num == sw) {
			return false;
		} else {
			return true;
		}
	}

	/**
	 * 1、用15减去上期蓝球号码，得出的数就是下期要杀的蓝号尾数。
	 * 
	 * @author 杨朝敬
	 * @date 2015年9月29日
	 * @param num
	 * @return
	 */
	public boolean isTorF1(int num) {
		// 杀尾数
		int sw = 0;
		if (sn1 < 15) {
			sw = 15 - sn1;
		} else {
			sw = sn1 - 15;
		}

		return this.torf(num, sw);
	}

	/**
	 * 2、用19减上期蓝号得出的数即为下期要杀的尾数。
	 * 
	 * @author 杨朝敬
	 * @date 2015年9月29日
	 * @param num
	 * @return
	 */
	public boolean isTorF2(int num) {
		// 杀尾数
		int sw = 19 - sn1;

		return this.torf(num, sw);
	}

	/**
	 * 3、用21减上期蓝号得出的数就是下期要杀的尾数。
	 * 
	 * @author 杨朝敬
	 * @date 2015年9月29日
	 * @param num
	 * @return
	 */
	public boolean isTorF3(int num) {
		// 杀尾数
		int sw = 21 - sn1;

		return this.torf(num, sw);
	}

	/**
	 * 4、用上两期蓝号的头和尾相加的数即为下期要杀的蓝号尾数。
	 * 
	 * @author 杨朝敬
	 * @date 2015年9月29日
	 * @param num
	 * @return
	 */
	public boolean isTorF4(int num) {
		// 上二期的头
		int tou = 0;
		// 上一期的尾
		int wei = 0;
		if (sn2 >= 10) {
			tou = 1;
		}
		if (sn1 >= 10) {
			wei = sn1 - 10;
		} else {
			wei = sn1;
		}
		// 杀尾数
		int sw = tou + wei;

		return this.torf(num, sw);
	}

	/**
	 * 5、用上两期蓝号的尾和头相加的数即为下期要杀的尾数。
	 * 
	 * @author 杨朝敬
	 * @date 2015年9月29日
	 * @param num
	 * @return
	 */
	public boolean isTorF5(int num) {
		// 上二期的尾
		int wei = 0;
		// 上一期的头
		int tou = 0;
		if (sn2 >= 10) {
			wei = sn2 - 10;
		} else {
			wei = sn2;
		}
		if (sn1 >= 10) {
			tou = 1;
		}
		// 杀尾数
		int sw = tou + wei;

		return this.torf(num, sw);
	}

	/**
	 * 6、用上二期蓝号尾相加得出的数就是下期要杀的尾数。
	 * 
	 * @author 杨朝敬
	 * @date 2015年9月29日
	 * @param num
	 * @return
	 */
	public boolean isTorF6(int num) {
		// 上二期的尾
		int wei2 = 0;
		// 上一期的尾
		int wei1 = 0;
		if (sn2 >= 10) {
			wei2 = sn2 - 10;
		} else {
			wei2 = sn2;
		}
		if (sn1 >= 10) {
			wei1 = sn1 - 10;
		} else {
			wei1 = sn1;
		}
		// 杀尾数
		int sw = wei2 + wei1;

		return this.torf(num, sw);
	}

	/**
	 * 7、用上期蓝号尾与隔一期蓝号尾相加得出的数即为下期要杀的尾数。
	 * 
	 * @author 杨朝敬
	 * @date 2015年9月29日
	 * @param num
	 * @return
	 */
	public boolean isTorF7(int num) {
		// 上二期的尾
		int wei2 = 0;
		// 上三期的尾
		int wei3 = 0;
		if (sn2 >= 10) {
			wei2 = sn2 - 10;
		} else {
			wei2 = sn2;
		}
		if (sn3 >= 10) {
			wei3 = sn3 - 10;
		} else {
			wei3 = sn3;
		}
		// 杀尾数
		int sw = wei2 + wei3;

		return this.torf(num, sw);
	}

	/**
	 * 8、用上期蓝号乘以2得出的数即为下期要杀的尾数。
	 * 
	 * @author 杨朝敬
	 * @date 2015年9月29日
	 * @param num
	 * @return
	 */
	public boolean isTorF8(int num) {
		// 杀尾数
		int sw = sn1 * 2;

		return this.torf(num, sw);
	}

	/**
	 * 9、用上期蓝号尾乘4得出的数即是下期要杀的尾数。
	 * 
	 * @author 杨朝敬
	 * @date 2015年9月29日
	 * @param num
	 * @return
	 */
	public boolean isTorF9(int num) {
		// 杀尾数
		int sw = 0;
		if (sn1 >= 10) {
			sw = (sn1 - 10) * 4;
		} else {
			sw = sn1 * 4;
		}

		return this.torf(num, sw);
	}

	/**
	 * 10、用上期蓝号加7或减7，注意蓝号大于14则减7，小于14则加7，得出的数即为下期要杀的尾数。
	 * 
	 * @author 杨朝敬
	 * @date 2015年9月29日
	 * @param num
	 * @return
	 */
	public boolean isTorF10(int num) {
		// 杀尾数
		int sw = 0;

		if (sn1 >= 14) {
			sw = sn1 - 7;
		} else {
			sw = sn1 + 7;
		}

		return this.torf(num, sw);
	}

	/**
	 * 11、用上期蓝号加2得出的数即为下期要杀的蓝号尾数。
	 * 
	 * @author 杨朝敬
	 * @date 2015年9月29日
	 * @param num
	 * @return
	 */
	public boolean isTorF11(int num) {
		// 杀尾数
		int sw = sn1 + 2;

		return this.torf(num, sw);
	}

	/**
	 * 12、用上期蓝号加6等于的数就是下期蓝号要杀的尾数。
	 * 
	 * @author 杨朝敬
	 * @date 2015年9月29日
	 * @param num
	 * @return
	 */
	public boolean isTorF12(int num) {
		// 杀尾数
		int sw = sn1 + 6;

		return this.torf(num, sw);
	}

}
