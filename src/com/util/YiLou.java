package com.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com._3D.number.Number1;

/**
 * 遗漏类方法的工具类
 * @author LXF
 *
 */
public class YiLou {
	
	public static int[] getYiLou(int scope,int now,int[] num) {
		int[] yl = new int[scope];
		boolean[] has = new boolean[10];//如果已经出现过，就不用计算遗漏
		for (int i = now; i >= 0; i--) {
			int nowNum = num[i];
			has[nowNum] = true;
			boolean find = false;
			for (int j = 0; j < has.length; j++) {
				if (!has[j]) {//有未找到的
					find = true;//继续找
					break;
				}
			}
			if (find) {
				for (int j = 0; j < scope; j++) {
					if (!has[j]) {
						yl[j]++;					
					}
				}				
			}
		}
		return yl;
	}

	public static Map<Integer, Integer> getMaxYiLouOrder(int scope,int now,int[] num){
		Map<Integer, Integer> ylMap = new HashMap<Integer, Integer>();
		int[] yl = getYiLou(scope, now, num);//获取遗漏
		boolean[] hasGet = new boolean[yl.length];//依次取遗漏最大的，取了的就不用再取
		int max = 0;
		int index = 0;
		for (int i = 0; i < yl.length; i++) {
			for (int j = 0; j < yl.length; j++) {
				if (max <= yl[j] && !hasGet[j]) {
					max = yl[j];
					index = j;
				}				
			}
			//本次最大的
			ylMap.put(i, index);
			hasGet[index] = true;
			max = 0;
			index = 0;
		}
		return ylMap;
	}
	
	public static Map<Integer, Integer>[] getYiLouInfo(int scope,int now,int[] num){
		Map<Integer, Integer>[] infoMaps = new HashMap[10];
		for (int i = 0; i < infoMaps.length; i++) {
			infoMaps[i] = new HashMap<Integer, Integer>();
		}
		int end = num.length - 1;
		for (int i = now; i < end; i++) {
			int[] yl = getYiLou(scope, i, num);
			int next = num[i + 1];
			if(infoMaps[next].containsKey(yl[next])){
				infoMaps[next].put(yl[next], infoMaps[next].get(yl[next]) + 1);
			}else {
				infoMaps[next].put(yl[next], 1);
			}
		}
		for (int i = 0; i < infoMaps.length; i++) {
			System.out.println();
			System.out.print(infoMaps[i]);
			
		}
		return infoMaps;
	}
	
	public static Map<Integer, Integer>[] getEachYiLou(int scope,int[] num){
		Map<Integer, Integer>[] maps = new Map[scope];
		ArrayList<Integer>[] list = new ArrayList[scope];
		for (int i = 0; i < maps.length; i++) {
			maps[i] = new HashMap<Integer, Integer>();
			list[i] = new ArrayList<Integer>();
		}
		int[] yilou = new int[scope];//遗漏
		for (int i = 0; i < num.length; i++) {
			list[num[i]].add(yilou[num[i]]);
			if (maps[num[i]].containsKey(yilou[num[i]])) {
				maps[num[i]].put(yilou[num[i]], maps[num[i]].get(yilou[num[i]]) + 1);
			}else {
				maps[num[i]].put(yilou[num[i]], 1);
			}
			for (int j = 0; j < yilou.length; j++) {
				yilou[j]++;
			}
			yilou[num[i]] = 0;
			
		}
		for (int i = 0; i < maps.length; i++) {
			System.out.println(maps[i]);
			for (int j = 0; j < list[i].size(); j++) {
				System.out.print(list[i].get(j) + ",");
			}
			System.out.println();
		}
		System.out.println("从每个数字间隔的统计，可以看到疏密排布。");
		return maps;
	}
	
	public static void main(String[] args) {
//		getMaxYiLouOrder(10, 3973, Number1.num);//2016037
//		getYiLouInfo(10, 100, Number1.num);
		getEachYiLou(10, Number1.num);
	}
}
