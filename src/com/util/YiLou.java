package com.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import com._3D.number.Number1;
import com._3D.number.Periods;

/**
 * 遗漏类方法的工具类
 * @author LXF
 *
 */
public class YiLou {
	
	/**
	 * 获取遗漏
	 * @param star 数字开始的值
	 * @param end 数字结束的值
	 * @param index 当前位置
	 * @param num 出现数字的数组
	 * @return Map<Integer, Integer> 每个数字的遗漏
	 */
	public static Map<Integer, Integer> getYiLou(int start,int end,int index,int[] num) {
		Map<Integer, Integer> yl = new HashMap<Integer, Integer>();
		Map<Integer, Boolean> find = new HashMap<Integer, Boolean>();
		for (int i = start; i <= end; i++) {
			find.put(i, false);
			yl.put(i, 0);
		}
		for (int i = index; i >= 0; i--) {
			find.put(num[i], true);
			if (find.containsValue(false)) {
				for (int j = start; j <= end; j++) {
					if (!find.get(j)) {
						yl.put(j, yl.get(j) + 1);
					}
				}
			}else {
				break;
			}
		}
		return yl;
	}
	
	/**
	 * 获取最大的遗漏
	 * @param yl
	 * @return Entry<Integer, Integer>
	 */
	public static Entry<Integer, Integer> getMaxYL(Map<Integer, Integer> yl){
		Entry<Integer, Integer> max = null;
		int m = 0;
		for (Entry<Integer, Integer> entry : yl.entrySet()) {
			if (entry.getValue() > m) {
				m = entry.getValue();
				max = entry;
			}
		}
		return max;
	}
	
	/** 各个数字在指定范围内的分布
	 * @param begin
	 * @param now
	 * @param start
	 * @param end
	 * @param num
	 * @return
	 */
	public static Map<Integer, Float> getFenBu(int begin,int now,int start,int end,int[] num){
		Map<Integer, Float> fb = new HashMap<Integer, Float>();
		for (int i = start; i <= end; i++) {
			fb.put(i, 0f);
		}
		for (int i = begin + 1; i <= now; i++) {
			fb.put(num[i], fb.get(num[i]) + 1);
		}
		/*float total = 0;
		for (int i = start; i <= end; i++) {
			total = total + fb.get(i);
		}*/
		for (int i = start; i <= end; i++) {
			fb.put(i, Float.parseFloat(String.format("%.3f", fb.get(i) / (now - begin + 1) * 10) ));			
		}
		return fb;
	}
	
	public static void main(String[] args) {
//		getMaxYiLouOrder(10, 3973, Number1.num);//2016037
//		getYiLouInfo(10, 100, Number1.num);
//		getEachYiLou(10, Number1.num);
		Map<Integer, Integer> yl = getYiLou(0,9, 1000, Number1.num);
		System.out.println(Periods.periods[1000] + yl + " max:" + getMaxYL(yl));
	}
}
