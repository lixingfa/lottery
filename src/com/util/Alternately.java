/**
 * 
 */
package com.util;

import java.util.List;
import java.util.Set;

import com.doubleBall.number.Bull;
import com.doubleBall.number.Number1Y;



/**
 * @author lixingfa
 * @date 2017年9月23日下午2:18:10
 * 交替，将号码范围选出一个子集，让号码出现的规律尽量符合出现，不出现，出现，不出现……
 */
public class Alternately {

	public void done(Integer[] scope,int[] num,int begin, int end){
		int ban = scope.length / 2;
		int maxTotal = 0;//最大的正确值
		for (int i = 1; i <= ban; i++) {
			List<Set<Integer>> result = Combine.getAllCombine(scope, i);
			for (int j = 0; j < result.size(); j++) {//每个组合去对比
				int total = 0;
				Set<Integer> set = result.get(j);
				int flag = begin % 2;
				boolean b = set.contains(num[begin]);
				for (int k = begin; k <= end; k++) {//对比要检验期数
					if (set.contains(num[k]) == b) {//轮替
						if (flag == k % 2) {
							total++;
						}
					}else if (flag != k % 2){
						total++;
					}
				}
				if (total > maxTotal) {
					maxTotal = total;
					Object[] o = set.toArray();
					System.out.print(total + " " + (flag == 0?"双":"单")+"索引" + b + " " +o[0]);
					for (int k = 1; k < o.length; k++) {
						System.out.print("," + o[k]);
					}
					System.out.println();
				}
			}
		}
	}
	
	public void test(){
		int[] num = Bull.getAscNum();
		int total = 0;
		for (int i = 0; i <= 99; i++) {
			if (i % 2 == 0) {
				if (num[i] == 11 ||num[i] == 12 ||num[i] == 13 ||num[i] == 15) {
					total++;
				}
			}else {
				if (num[i] == 3 ||num[i] == 4 ||num[i] == 6 ||num[i] == 7||num[i] == 16) {
					total++;
				}
			}
		}
		System.out.println(total);
	}
	
	public static void main(String[] args) {
//		514 双索引false 1
//		515 双索引false 1,2
//		526 双索引false 1,3
//		527 双索引false 1,2,3
//		531 双索引false 1,3,4
//		533 双索引false 1,3,15
//		535 双索引false 1,3,23
//		538 双索引false 1,3,4,15
//		540 双索引false 17,1,3,15
//		542 双索引false 1,3,23,15
//		543 双索引false 16,1,3,4,15
//		545 双索引false 17,1,3,4,15
//		547 双索引false 1,3,4,23,15
//		549 双索引false 17,1,3,23,15
//		550 双索引false 17,16,1,3,4,15
//		551 双索引false 1,3,4,23,10,15
//		552 双索引false 16,1,3,4,23,15
//		554 双索引false 17,1,3,4,23,15
//		555 双索引false 1,3,4,23,10,12,15
//		556 双索引false 16,1,3,4,23,10,15
//		557 双索引false 17,1,3,4,23,7,15
//		558 双索引false 17,1,3,4,23,10,15
//		559 双索引false 17,16,1,3,4,23,15
		new Alternately().done(new Integer[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33}
		, Number1Y.num, 0, 999);
//		new Alternately().test();
	}
}
