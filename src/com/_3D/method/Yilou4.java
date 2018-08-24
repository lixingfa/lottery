package com._3D.method;

import java.util.List;
import java.util.Set;

import com.doubleBall.number.Bull;
import com.util.Combine;

public class Yilou4 {
	
	public static void check(Integer[] scope,int[] num,int begin,int end){
		float maxRight = 0;
		int lenght = scope.length / 2;//分成两份，取最小的那份
		for (int how = 1; how < lenght; how++) {//最小那份选取多少个
			float  proportion = (float)how / scope.length;//当前组合所占的比例
			if (maxRight < proportion) {
				maxRight = proportion;//理论概率
			}
			//获取所有组合
			List<Set<Integer>> combines = Combine.getAllCombine(scope, how);
			//查看每个组合在指定区间的正确率
			for (int i = 0; i < combines.size(); i++) {
				Set<Integer> combine = combines.get(i);
				for (int former = scope.length; former < begin; former++) {
					float right = 0;//这个组合，在某个former下的准确率
					int total = 0;//一共判断了多少次
					for (int now = begin; now < end; now++) {
						int flat = getRight(num, now, combine, proportion, former);
						if (flat != -1) {//判断了
							total++;
							if (flat == 1) {//判断对了
								right++;								
							}
						}
					}
//					right = (right /  total) / combine.size();//平均概率
					right = (right /  total);//平均概率
					if (right > maxRight) {
						maxRight = right;
						System.out.println("right:" + right + " " + total + " combine:" + combine.toString() + " former:" + former);
					}
				}
			}
			
		}
	}

	private static int getRight(int[] num,int now,Set<Integer> combine,float  proportion,int former) {
		int right = -1;//-1，没有判断，0判断错了，1判断对了
		int tatol = 0;
		for (int i = 0; i < former; i++) {
			if (combine.contains(num[now - i])) {
				tatol++;
			}
		}
		float p = (float)tatol / former;
		if (p < proportion) {//占的比例小于理论比例			
			if (combine.contains(num[now + 1])) {
				return 1;//下一个是本组内的
			}else {
				return 0;
			}
		}
		return right;
	}
	
	public static void main(String[] args) {
		Integer[] scope = {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16};
		check(scope, Bull.getAscNum(), 100, 1600);
	}
}
