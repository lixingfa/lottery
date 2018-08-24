package com._3D.method;

import com._3D.number.Number1;
import com.util.YiLou;

public class Yilou5 {
	public static void main(String[] args) {
		go(Number1.num, 100, 600);
	}
	
	static void go(int[] num,int begin,int end){
		int max = 0;//最大中数
		int[][] yl = new int[end - begin][10];
		for (int i = begin,j = 0; i < end; i++,j++) {
			yl[j] = YiLou.getYiLou(10, i, num);
		}
		
		for (int i0 = 0; i0 <= 10; i0++) {
			for (int i1 = 0; i1 <= 10; i1++) {
				for (int i2 = 0; i2 <= 10; i2++) {
					for (int i3 = 0; i3 <= 10; i3++) {
						for (int i4 = 0; i4 <= 10; i4++) {
							for (int i5 = 0; i5 <= 10; i5++) {
								for (int i6 = 0; i6 <= 10; i6++) {
									for (int i7 = 0; i7 <= 10; i7++) {
										for (int i8 = 0; i8 <= 10; i8++) {
											for (int i9 = 0; i9 <= 10; i9++) {
												int total = getTotal(new int[]{i0, i1, i2, i3, i4, i5, i6, i7, i8, i9}, num,yl);
												if (total >= max) {
													max = total;
													System.out.println(i0 + " " + i1 + " " + i2 + " " + i3 + " " + i4 + " " + 
															i5 + " " + i6 + " " + i7 + " " + i8 + " " + i9 + " " 
															+ total + "/" + (end - begin) + "=" + (float)total/(end - begin));
												}
											}
										}
									}
								}
							}							
						}						
					}
				}
			}			
		}
	}
	
	static int getTotal(int[] yil,int[] num,int[][] yls){
		int total = 0;
		for (int i = 0; i < yls.length; i++) {
			int[] yl = yls[i];
			int next = num[i + 1];
			if (yl[next] == yil[next]) {
				total++;
			}
		}
		return total;
	}

}
