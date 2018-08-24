package com.util;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com._3D.number.Number3;

/**
 * 五行，
 * 1、6水，2、7火，3、8木，4、9金，5、0土
 * 0刑，1生上，2生下，3克上，4克下
 * @author LXF
 *
 */
public class WuXing {
	
	/**
	 * 获取一个数的五行
	 * @param num 数字
	 * @param sum 数字每位相加
	 * @return
	 */
	public static int getWuXing(int num){
		return num % 5;			
	}
	
	/**
	 * 打印数字五行属性
	 * @param num
	 */
	public static void printName(int num){
		String s = null;
		switch (num) {
			case 0: s = "土";break;
			case 1: s = "水";break;
			case 2: s = "火";break;
			case 3: s = "木";break;
			case 4: s = "金";break;
			default: s = "";break;
		}
		System.out.print(s);
	}
	
	public static String getName(int num){
		String s = null;
		switch (num) {
			case 0: s = "土";break;
			case 1: s = "水";break;
			case 2: s = "火";break;
			case 3: s = "木";break;
			case 4: s = "金";break;
			default: s = "";break;
		}
		return s;
	}
	
	/**
	 * 获取两个数的生克关系
	 * 0刑，1生上，2生下，3克上，4克下
	 * @param former 前一个数
	 * @param now 后一个数
	 * @return
	 */
	public static int shengke(int former,int now){
		switch (former) {
			case 1:
				switch (now) {
					case 1:return 0;
					case 2:return 4;
					case 3:return 2;
					case 4:return 1;
					case 0:return 3;
				}
			case 2:
				switch (now) {
					case 1:return 3;
					case 2:return 0;
					case 3:return 1;
					case 4:return 4;
					case 0:return 2;
				}
			case 3:
				switch (now) {
					case 1:return 1;
					case 2:return 2;
					case 3:return 0;
					case 4:return 3;
					case 0:return 4;
				}
			case 4:
				switch (now) {
					case 1:return 2;
					case 2:return 3;
					case 3:return 4;
					case 4:return 0;
					case 0:return 1;
				}
			case 0:
				switch (now) {
					case 1:return 4;
					case 2:return 1;
					case 3:return 3;
					case 4:return 2;
					case 0:return 0;
				}
		}
		return 0;
	}
	
	/**
	 * 打印生克关系
	 * @param num
	 */
	public static void printShengKe(int shengke){
		String s = null;
		switch (shengke) {
			case 0: s = "⊕";break;
			case 1: s = "∩";break;
			case 2: s = "∪";break;
			case 3: s = "∧";break;
			case 4: s = "∨";break;
			default: s = "";break;
		}
		System.out.print(s);
	}
	
	public static String getShengKe(int shengke){
		String s = null;
		switch (shengke) {
			case 0: s = "⊕";break;
			case 1: s = "∩";break;
			case 2: s = "∪";break;
			case 3: s = "∧";break;
			case 4: s = "∨";break;
			default: s = "";break;
		}
		return s;
	}
	
	/**
	 * 之对应的关系
	 * 1、6水，2、7火，3、8木，4、9金，5、0土
	 * 0刑，1生上，2生下，3克上，4克下
	 * @param shengke
	 * @return
	 */
	public static Set<Integer> getNum(int wuxing,int shengke){
		Set<Integer> set = new HashSet<Integer>();
		switch (wuxing) {
			case 1://水
				switch (shengke) {
					case 1:set.add(4);set.add(9);break;//金
					case 2:set.add(3);set.add(8);break;
					case 3:set.add(0);set.add(5);break;
					case 4:set.add(2);set.add(7);break;
					case 0:set.add(1);set.add(6);break;
				}
				break;
			case 2://火
				switch (shengke) {//
					case 1:set.add(3);set.add(8);break;
					case 2:set.add(0);set.add(5);break;
					case 3:set.add(1);set.add(6);break;
					case 4:set.add(4);set.add(9);break;
					case 0:set.add(2);set.add(7);break;
				}
				break;
			case 3://木
				switch (shengke) {
					case 1:set.add(1);set.add(6);break;
					case 2:set.add(2);set.add(7);break;
					case 3:set.add(4);set.add(9);break;
					case 4:set.add(0);set.add(5);break;
					case 0:set.add(3);set.add(8);break;
				}
				break;
			case 4://金
				switch (shengke) {
					case 1:set.add(0);set.add(5);break;
					case 2:set.add(1);set.add(6);break;
					case 3:set.add(2);set.add(7);break;
					case 4:set.add(3);set.add(8);break;
					case 0:set.add(4);set.add(9);break;
				}
				break;
			case 0:
				switch (shengke) {
					case 1:set.add(2);set.add(7);break;
					case 2:set.add(4);set.add(9);break;
					case 3:set.add(3);set.add(8);break;
					case 4:set.add(1);set.add(6);break;
					case 0:set.add(0);set.add(5);break;
				}
				break;
		}
		return set;
	}
	
	public static void info(int[] num){
//		0刑，1生上，2生下，3克上，4克下
		Map<Integer, Integer>[] l = new HashMap[5];
		for (int i = 0; i < l.length; i++) {
			l[i] = new HashMap<Integer, Integer>();
		}
		int[] shengke = new int[num.length - 1];
		for (int i = 1; i < num.length; i++) {
			int former = getWuXing(num[i - 1]);
			int now = getWuXing(num[i]);
			shengke[i - 1] = shengke(former, now);
			System.out.print(num[i - 1]);printName(former);printShengKe(shengke[i - 1]);printName(now);System.out.println(num[i]);
		}
		//统计生克关系
		int now = 0;
		int total = 0;
		int quan = 0 ;
		for (int i = 0; i < shengke.length; i++) {
			if (now != shengke[i]) {
				now = shengke[i];
				if (l[now].containsKey(total)) {
					l[now].put(total, l[now].get(total) + 1);
					total = 0;
				}else {
					l[now].put(total, 1);
				}
			}else {
				total++;
			}
			//五行齐全
			if (i >= 4) {
				Set<Integer> set = new HashSet<Integer>();
				for (int j = 0; j < 5; j++) {
					set.add(shengke[i - j]);
				}
				if (set.size() == 5) {
					quan++;
				}
			}
		}
		System.out.println(quan + "/" + shengke.length + "=" + (float)quan / shengke.length);
		for (int i = 0; i < l.length; i++) {
			printShengKe(i);
			for (Map.Entry<Integer, Integer> entry : l[i].entrySet()) {
				System.out.print(entry.getKey() + ":" + entry.getValue() + " ");
			}
			System.out.println();
		}
		/*Number1
		  五行齐全159/3973=0.040020134
		  	⊕0:514 1:98 2:14 3:7 4:1 5:2 8:1 
			∩0:561 1:81 2:19 3:3 4:2 5:1 7:1 8:2 
			∪0:513 1:110 2:25 3:6 4:4 5:1 7:1 8:1 
			∧0:513 1:79 2:27 3:6 4:4 7:1 8:1 
			∨0:491 1:93 2:22 3:3 4:1 6:1 7:1 
			Number2
			147/3973=0.036999747
			⊕0:502 1:97 2:25 3:5 4:3 
			∩0:503 1:107 2:22 3:4 4:1 6:2 
			∪0:507 1:107 2:21 3:1 4:1 6:2 
			∧0:478 1:101 2:19 3:6 4:1 6:1 
			∨0:524 1:104 2:21 3:4 4:5 6:1 
			Number3
			168/3973=0.042285427
			⊕0:491 1:103 2:27 3:2 4:2 5:2 
			∩0:513 1:95 2:18 3:6 4:1 
			∪0:502 1:105 2:22 3:4 5:2 
			∧0:492 1:102 2:20 3:5 4:2 
			∨0:525 1:109 2:20 3:5 4:4 
		 */
	}
	
	
	
	public static void main(String[] args) {
		info(Number3.num);
	}
}
