package com._3D.method;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import com._3D.number.Number1;
import com._3D.number.Number2;
import com._3D.number.Periods;
import com.util.YiLou;

/**
 * 冷热号码追逐
 * @author LXF
 *
 */
public class Balance {
	/**
	 * 找出有价值的信息
	 * @param num 数据
	 * @param scope 数据的范围
	 */
	public static void info(int[] num,int start,int end,int now){
		int length = 601 - 1;
		float total = 0;
		float minTotal = 0;
		for (int i = now; i < length; i++) {
			Map<Integer, Integer> yl = YiLou.getYiLou(start, end, i, num);//当前遗漏排序
			Entry<Integer, Integer> max = YiLou.getMaxYL(yl);
			Map<Integer, Float> fb = YiLou.getFenBu(i - max.getValue(), i, start, end, num);
			Map<Integer, Float> fb20 = YiLou.getFenBu(i - 20, i, start, end, num);
			Map<Integer, Float> fb30 = YiLou.getFenBu(i - 30, i, start, end, num);
			Map<Integer, Float> fb50 = YiLou.getFenBu(i - 50, i, start, end, num);
			Map<Integer, Float> fb100 = YiLou.getFenBu(i - 100, i, start, end, num);
			Map<Integer, Float> fbav = new HashMap<Integer, Float>();
			for (int j : fb.keySet()) {
				float a = (fb.get(j) + fb20.get(j) + fb30.get(j) + fb50.get(j) + fb100.get(j)) / 5;
				fbav.put(j, a);
				if (a < 1) {
					minTotal++;
				}
			}
			System.out.println(Periods.periods[i]);
			System.out.println(yl + ",max" + max);
			System.out.println(fb);
			System.out.println(fb20);
			System.out.println(fb30);
			System.out.println(fb50);
			System.out.println(fb100);
			if (fbav.get(num[i + 1]) < 1) {
				total++;
			}
			System.out.println(fbav + " next:" + num[i + 1]);
		}
		System.out.println(total + "/" + (length - now) + "=" + total / (length - now) 
				+ " " + minTotal + "/" + ((length - now) * 10) + "=" + minTotal / ((length - now) * 10));
	}
	
	public static void check(int[] num,int scope){
		int total = 0;
		int start = 100;
		int end = 2100;
		for (int now = start; now < end; now++) {
			Map<Integer, Integer> ylMap = YiLou.getYiLou(0, 9, now, num);//当前遗漏排序
			if (num[now + 1] != ylMap.get(9)) {
				total++;
			}else {
				System.out.println(ylMap);
			}
		}
		System.out.println((float)total / (end - start));
		System.out.println("过半了，证明方向是对的！");
	}
	
	public static void main(String[] args) {
		info(Number1.num, 0,9,100);
//		check(Number1.num, 10);
	}
}
