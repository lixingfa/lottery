package com.doubleBall.number;


/**
 * @author LIXF
 *
 */
public class NumberMethod {
	/**尾数统计*/
	private static void mantissa() {
		int[] totle=new int[10];
		int[] num=new int[6];
		for (int i = Number1.num.length-1; i >=0; i--) {
			num[0]=Number1.num[i];
			num[1]=Number2.num[i];
			num[2]=Number3.num[i];
			num[3]=Number4.num[i];
			num[4]=Number5.num[i];
			num[5]=Number6.num[i];
			for (int j = 0; j < num.length; j++) {
				totle[num[j]%10]++;
			}
		}
		for (int i = 0; i < totle.length; i++) {
			System.out.print((float)totle[i]/(Number6.num.length*6)+" ");
		}
		System.out.println(((float)3/33)+" "+((float)4/33));
	}
	/**
	 * 统计一个数组中各个数字出现的总数
	 * @param nums
	 * @param length
	 */
	private static void totleEach(int[] nums,int length){
		int[] totle = new int[length];
		for (int i = 0; i < nums.length; i++) {
			totle[nums[i]-1]++;
		}
		for (int i = 0; i < totle.length; i++) {
			System.out.print((i + 1) + ":" + totle[i] + " ");
		}
	}
	
	/**
	 * 打印号码
	 */
	private static void printNums(){
		for (int i = Bull.num.length - 1; i >= 0; i--) {
			System.out.println(Periods.periods[i] + " " + NumDate.date[i] + " " 
		+ Number1.num[i] + " " +Number2.num[i] + " " +Number3.num[i] + " " +
					Number4.num[i] + " " +Number5.num[i] + " " +Number6.num[i] + " " +Bull.num[i] + " " + i);
		}
		System.out.println(Bull.num.length);
	}
	
	/**
	 * 打印原值号码
	 */
	private static void printNumsY(){
		String[] ganzhi = GanZhi.getDesc();
		int lenght = Bull.num.length - 1;
		for (int i = 0; i <= lenght; i++) {
			System.out.println(Periods.periods[i] + " " + NumDate.date[i] + " " 
		+ Number1Y.num[i] + " " +Number2Y.num[i] + " " +Number3Y.num[i] + " " +
					Number4Y.num[i] + " " +Number5Y.num[i] + " " +Number6Y.num[i] + " " +Bull.num[i] + " " + ganzhi[i]);
		}
		System.out.println(lenght + 1);
	}
	
	/**
	 * 打印蓝球
	 */
	private static void printBullPlace() {
		for (int i = Bull.num.length - 1; i > 0; i--) {
			for (int j = 1; j < Bull.num[i]; j++) {
				System.out.print("  ");
			}
			if (Bull.num[i] < 10) {
				System.out.print(" ");
			}
			System.out.println(Bull.num[i]);
		}
	}
	
	/**
	 * 打印红球
	 * @param how 1-6
	 * @param many 是否连之前的也打印
	 */
	private static void printRedPlace(int how,boolean many) {
		for (int i = Number1.num.length - 1; i >= 0; i--) {
			for (int j = 1; j < Number1.num[i]; j++) {
				System.out.print("  ");
			}
			if (how > 1 && many || how == 1) {
				if (Number1.num[i] < 10) {
					System.out.print(" ");
				}
				System.out.print(Number1.num[i]);
			}else {
				System.out.print("  ");
			}
			for (int j = Number1.num[i] + 1; j < Number2.num[i]; j++) {
				System.out.print("  ");
			}
			if (how > 2  && many || how == 2) {
				if (Number2.num[i] < 10) {
					System.out.print(" ");
				}
				System.out.print(Number2.num[i]);
			}else {
				System.out.print("  ");
			}
			for (int j = Number2.num[i] + 1; j < Number3.num[i]; j++) {
				System.out.print("  ");
			}
			if (how > 3 && many || how == 3) {
				if (Number3.num[i] < 10) {
					System.out.print(" ");
				}
				System.out.print(Number3.num[i]);				
			}else {
				System.out.print("  ");
			}
			for (int j = Number3.num[i] + 1; j < Number4.num[i]; j++) {
				System.out.print("  ");
			}
			if (how > 4 && many || how == 4) {
				if (Number4.num[i] < 10) {
					System.out.print(" ");
				}
				System.out.print(Number4.num[i]);				
			}else {
				System.out.print("  ");
			}
			for (int j = Number4.num[i] + 1; j < Number5.num[i]; j++) {
				System.out.print("  ");
			}
			if (how > 5 && many || how == 5) {
				if (Number5.num[i] < 10) {
					System.out.print(" ");
				}
				System.out.print(Number5.num[i]);				
			}else {
				System.out.print("  ");
			}
			for (int j = Number5.num[i] + 1; j < Number6.num[i]; j++) {
				System.out.print("  ");
			}
			if (how == 6) {
				if (Number6.num[i] < 10) {
					System.out.print(" ");
				}
				System.out.print(Number6.num[i]);				
			}
			System.out.println();
		}
	}
	
	public static int[][] redBall() {
		int[][] num = new int[Number1.num.length][6];
		int j = 0;
		for (int i = Number1.num.length - 1; i >= 0; i--) {
			num[j][0] = Number1.num[i];
			num[j][1] = Number2.num[i];
			num[j][2] = Number3.num[i];
			num[j][3] = Number4.num[i];
			num[j][4] = Number5.num[i];
			num[j][5] = Number6.num[i];
			j++;
		}
		return num;
	}
	
	public static int[][] redBallY() {
		int[][] num = new int[Number1.num.length][6];
		int j = 0;
		for (int i = Number1Y.num.length - 1; i >= 0; i--) {
			num[j][0] = Number1Y.num[i];
			num[j][1] = Number2Y.num[i];
			num[j][2] = Number3Y.num[i];
			num[j][3] = Number4Y.num[i];
			num[j][4] = Number5Y.num[i];
			num[j][5] = Number6Y.num[i];
			j++;
		}
		return num;
	}
	
	public static void main(String[] args) {
//		System.out.println(Bull.num.length);
//		printNums();
//		printNumsY();
//		printBullPlace();
//		printRedPlace(1,false);
		totleEach(Bull.num, 16);
	}

}
