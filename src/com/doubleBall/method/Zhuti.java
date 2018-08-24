package com.doubleBall.method;

import com.doubleBall.number.Bull;
import com.doubleBall.number.GanZhi;
import com.doubleBall.number.NumDate;
import com.doubleBall.number.Number1;
import com.doubleBall.number.Number2;
import com.doubleBall.number.Number3;
import com.doubleBall.number.Number4;
import com.doubleBall.number.Number5;
import com.doubleBall.number.Number6;
import com.doubleBall.number.Periods;

/**
 * 根据
 * @author Lixingfa
 *
 */
public class Zhuti {
	static String[] periods = Periods.getAsc();
	static String[] date = NumDate.getAsc();
	static int[] num1 = Number1.getAscNum();
	static int[] num2 = Number2.getAscNum();
	static int[] num3 = Number3.getAscNum();
	static int[] num4 = Number4.getAscNum();
	static int[] num5 = Number5.getAscNum();
	static int[] num6 = Number6.getAscNum();
	static int[] bull = Bull.getAscNum();
	
	public static void tongji(){
		String gan[] = {"甲", "乙", "丙", "丁", "戊", "己", "庚", "辛", "壬", "癸"};
		String[] zhi = {"子", "丑", "寅", "卯", "辰", "巳", "午", "未", "申", "酉", "戌", "亥"};
		
		for (int i = 0; i < gan.length; i++) {
			for (int j = 0; j < zhi.length; j++) {
				System.out.println(gan[i] + zhi[j]);
				int[] total = new int[33];
				for (int k = 0; k < GanZhi.data.length; k++) {
					if (GanZhi.data[k].contains(gan[i] + zhi[j] + "日")) {
						System.out.println(periods[k] + " " + date[k] + " " +GanZhi.data[k] + " " 
					+num1[k] + " " + num2[k] + " " + num3[k] + " " + num4[k] + " " + num5[k] + " " + num6[k]+ " " + Bull.num[k]);
						total[num1[k] - 1]++;
						total[num2[k] - 1]++;
						total[num3[k] - 1]++;
						total[num4[k] - 1]++;
						total[num5[k] - 1]++;
						total[num6[k] - 1]++;
						total[Bull.num[k] - 1]++;
					}
				}
				for (int k = 0; k < total.length; k++) {
					System.out.print(total[k] + " ");
				}
			}
			
		}	
	}
	
	//一起出现或隔一到两期出现
	//31\1-26 32\2-7 33\3-18 4-29 5-10 6-21 8-13 9-24 11-16 12-27 14-19 15-30 17-22 20-25 23-28
	public static void shutuan(){		
		int[] flat = new int[34];//1为出现，2为不出现，0表示未知
		int total3 = 0;
		int total4 = 0;
		int total5 = 0;
		int total6 = 0;
		for (int i = 2; i < 1002; i++) {
			int[] form2 = {num1[i - 2],num2[i - 2],num3[i - 2],num4[i - 2],num5[i - 2],num6[i - 2]};
			int[] form1 = {num1[i - 1],num2[i - 1],num3[i - 1],num4[i - 1],num5[i - 1],num6[i - 1]};
			int[] numn = {num1[i],num2[i],num3[i],num4[i],num5[i],num6[i]};
			for (int j = 0; j < numn.length; j++) {
				switch (numn[j]) {
					case 31:
					case 1:	
					case 26:
						flat[31] = contain(1, 26, form1, form2);
						flat[1] = flat[31];
						flat[26] = flat[31];
						break;
					case 32:
					case 2:	
					case 7:
						flat[32] = contain(2, 7, form1, form2);
						flat[2] = flat[32];
						flat[7] = flat[32];
						break;
					case 33:
					case 3:	
					case 18:
						flat[33] = contain(3, 18, form1, form2);
						flat[3] = flat[33];
						flat[18] = flat[33];
						break;
					case 4:	
					case 29:
						flat[4] = contain(4, 29, form1, form2);
						flat[29] = flat[4];
						break;
					case 5:	
					case 10:
						flat[5] = contain(5, 10, form1, form2);
						flat[10] = flat[5];
						break;
					case 6:	
					case 21:
						flat[6] = contain(6, 21, form1, form2);
						flat[21] = flat[6];
						break;
					case 8:	
					case 13:
						flat[8] = contain(8, 13, form1, form2);
						flat[13] = flat[8];
						break;
					case 9:	
					case 24:
						flat[24] = contain(24, 9, form1, form2);
						flat[9] = flat[24];
						break;
					case 11:	
					case 16:
						flat[11] = contain(11, 16, form1, form2);
						flat[16] = flat[11];
						break;
					case 12:	
					case 27:
						flat[12] = contain(12, 27, form1, form2);
						flat[27] = flat[12];
						break;
					case 14:	
					case 19:
						flat[14] = contain(14, 19, form1, form2);
						flat[19] = flat[14];
						break;
					case 15:	
					case 30:
						flat[15] = contain(15, 30, form1, form2);
						flat[30] = flat[15];
						break;
					case 17:	
					case 22:
						flat[17] = contain(17, 22, form1, form2);
						flat[22] = flat[17];
						break;
					case 20:	
					case 25:
						flat[20] = contain(20, 25, form1, form2);
						flat[25] = flat[20];
						break;
					case 23:	
					case 28:
						flat[23] = contain(23, 28, form1, form2);
						flat[28] = flat[23];
						break;
				}
			}
			//
			int zhong = 0;
			int[] next = {num1[i + 1],num2[i + 1],num3[i + 1],num4[i + 1],num5[i +1],num6[i + 1]};
			for (int j = 1; j < flat.length; j++) {
				if (flat[j] == 1) {
					System.out.print(j + " ");
					for (int k = 0; k < next.length; k++) {
						if (next[k] == j) {
							zhong++;
							break;
						}
					}
				}
			}
			switch (zhong) {
			case 3:
				total3++;
				break;
			case 4:
				total4++;
				break;
			case 5:
				total5++;
				break;
			case 6:
				total6++;
				break;
			}
			System.out.print(" 实际：");
			for (int j = 0; j < next.length; j++) {
				System.out.print(next[j] + " ");
			}
			System.out.println("中" + zhong);
		}
		System.out.println(" 3:" +total3 + " 4:" + total4 + " 5:" + total5 + " 6:" + total6);
	}
	
	private static int contain(int num,int num_,int[] num1,int[] num2){
		int flat = 1;
		for (int i = 0; i < num1.length; i++) {
			if (num == num1[i] || num_ == num1[i]) {
				flat = 0;//出现一次
				break;
			}
		}
		for (int i = 0; i < num2.length; i++) {
			if (num == num2[i] || num_ == num2[i]) {
				flat = 2;//出现两次
				break;
			}
		}
		return flat;
	}
	
	public static void findNear(){
		for (int i = 0; i < 10; i++) {
			System.out.println(periods[i] + " " + date[i] + " " +GanZhi.data[i] + " " +num1[i] + "," + num2[i] + "," + num3[i] + "," + num4[i] 
					+ "," + num5[i] + "," + num6[i] );
			System.out.println("find");
			int[] now = {num1[i],num2[i],num3[i],num4[i],num5[i],num6[i]};
			int same = 0;
			for (int j = i + 1; j < num1.length; j++) {
				int[] numt = {num1[j],num2[j],num3[j],num4[j],num5[j],num6[j]};
				for (int k = 0; k < now.length; k++) {
					for (int l = 0; l < numt.length; l++) {
						if (now[k] == numt[l]) {
							same++;
						}
					}
				}
				if (same >=5) {
					System.out.println(periods[j] + " " + date[j] + " " +GanZhi.data[j] + " " +num1[j] + "," + num2[j] + "," + num3[j] + "," + num4[j] 
							+ "," + num5[j] + "," + num6[j] + " same:" + same);
				}
				same = 0;
			}
			System.out.println("----------------------------------------");
		}
	}
	
	public static void main(String[] args) {
//		shutuan();
//		tongji();
		findNear();
	}

}
