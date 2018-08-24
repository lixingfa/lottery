package com._3D.method;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import com._3D.number.Number1;
import com._3D.number.Number2;
import com.util.YiLou;

/**
 * 冷热号码追逐
 * @author LXF
 *
 */
public class ColdAndHot {
	/**
	 * 找出有价值的信息
	 * @param num 数据
	 * @param scope 数据的范围
	 */
	public static void info(int[] num,int scope){
		Map<Integer, Integer> yl = new HashMap<Integer, Integer>();
		for (int now = 100; now < 1100; now++) {
			Map<Integer, Integer> ylMap = YiLou.getMaxYiLouOrder(scope, now, num);//当前遗漏排序
			for (Entry<Integer, Integer> entry : ylMap.entrySet()) {
				if (entry.getValue() == num[now + 1]) {
					if (yl.containsKey(entry.getKey())) {
						yl.put(entry.getKey(), yl.get(entry.getKey()) + 1);
					}else {
						yl.put(entry.getKey(), 1);
					}
					break;
				}
			}
		}
		System.out.println(yl);
		System.out.println("遗漏似乎对下期号码无影响。但既然每个数的概率是差不多的，那在非常长的遗漏之后，会有一段恶补期。即短时间内扎堆出现");
	}
	
	public static void check(int[] num,int scope){
		int total = 0;
		int start = 100;
		int end = 2100;
		for (int now = start; now < end; now++) {
			Map<Integer, Integer> ylMap = YiLou.getMaxYiLouOrder(scope, now, num);//当前遗漏排序
			if (num[now + 1] != ylMap.get(9)) {
				total++;
			}else {
				System.out.println(ylMap);
			}
		}
		System.out.println((float)total / (end - start));
	}
	
	public static void main(String[] args) {
		info(Number1.num, 10);
//		check(Number1.num, 10);
	}
}
