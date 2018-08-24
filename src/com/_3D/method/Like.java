package com._3D.method;

import java.util.HashSet;
import java.util.Set;

import com._3D.number.Number1;
import com._3D.number.Number2;
import com._3D.number.Number3;
import com._3D.number.Periods;
/**
 * 相似，只要样本足够大，相似的情况总会重演
 * @author lingxingfa
 *
 */
public class Like {
	/**
	 * 数字完全相同是不可能的，主要是看走势
	 * @param now
	 * @param how
	 * return 最接近
	 */
	public static Set<Integer> lineLike(int now,int how,int[] num,boolean print){
		int maxSame = 0;
		int maxXielv = 1000;
		//
		int[] zoushi = new int[how];
		int[] thisNum = new int[how + 1];
		//打印
		if (print) {
			System.out.print(Periods.periods[now] + ":");			
		}
		for (int i = now - how,j = 0; j <= how; i++,j++) {
			if (print) {
				System.out.print(num[i]);				
			}
			thisNum[j] = num[i];
			if (j < zoushi.length) {
				if (num[i + 1] - num[i] > 0) {
					zoushi[j] = 1;
					if (print) {
						System.out.print("+");						
					}
				}else if(num[i + 1] - num[i] == 0){
					zoushi[j] = 0;
					if (print) {
						System.out.print("=");						
					}
				}else {
					zoushi[j] = -1;
					if (print) {
						System.out.print("-");						
					}
				}
			}
		}
		if (print) {
			System.out.println(" " + num[now + 1]);			
		}
		
		Set<Integer> theValues = new HashSet<Integer>();
		//
		for (int n = now - 1; n >= how; n--) {
			int[] zoushiT = new int[zoushi.length];
			for (int i = n - how,j = 0; j < zoushiT.length; i++,j++) {
				if (num[i + 1] - num[i] > 0) {
					zoushiT[j] = 1;
				}else if(num[i + 1] - num[i] == 0){
					zoushiT[j] = 0;
				}else {
					zoushiT[j] = -1;
				}
			}
			//对比走势
			int same = 0;
			for (int i = 0; i < zoushiT.length; i++) {
				if (zoushi[i] == zoushiT[i]) {
					same++;
				}
			}
			if (same >= maxSame) {
				if (same > maxSame) {
					maxSame = same;
				}
				//寻找最小斜率
				int xielv = 0;
				for (int i = n - how,j = 1; j < how; i++,j++) {
					xielv = xielv + Math.abs(Math.abs(num[i + 1] - num[i]) - Math.abs(thisNum[j] - thisNum[j - 1]));					
				}
				if (xielv <= maxXielv) {
					if (xielv < maxXielv) {
						theValues.clear();
						maxXielv = xielv;
					}
					theValues.add(num[n + 1] - num[n]);
					//打印
					if (print) {
						System.out.print(Periods.periods[n] + ":");						
						for (int i = n - how,j = 0; j <= how; i++,j++) {
							System.out.print(num[i]);
							if (j < zoushiT.length) {
								if (zoushiT[j] == 1) {
									System.out.print("+");
								}else if(zoushiT[j] == 0){
									System.out.print("=");
								}else {
									System.out.print("-");
								}
							}
						}
						System.out.println(" "+ num[n + 1] + " maxSame:" + maxSame + " xielv:" + xielv);					
					}
				}
			}
		}
		return theValues;
	}
	
	public static void main(String[] args) {
		float zhong = 0f;
		int buzhong = 0;
		int how = 4;
		int begin = 3000;
		int end = 3300;
		int[] num = Number1.num;
		for (int i = begin; i < end; i++) {
			Set<Integer> chazhis = lineLike(i, how, num,false);//可以排除多少个数
			Set<Integer> paichu = new HashSet<Integer>();
			int now = num[i];
			int next = num[i +1];
			for (Integer chazhi : chazhis) {
				if (now + chazhi < 0) {
					paichu.add(now +10 + chazhi);
				}else {
					paichu.add((now + chazhi) % 10);
				}
			}
			System.out.print(Periods.periods[i] + "当前：" + now + ",差值：" + chazhis + ",排除:" + paichu + " 下期" + next);
			if (!paichu.contains(next)) {
				zhong = zhong + 1f / (10 - chazhis.size());
				System.out.println(" 中");
			}else {
				buzhong++;
				System.out.println(" 不中");
			}
		}
		System.out.println(zhong / (end - begin) + " 不中：" + buzhong);
	}

}
