package com._3D.method;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com._3D.number.Number1;
import com._3D.number.Number2;
import com._3D.number.Number3;
import com._3D.number.Periods;

/**
 * 相似矩阵
 * @author LXF
 *
 */
public class MatrixLike {
	
	/**
	 * 指定区间内，最大相似度最集中的check
	 * @param checkArea 对比期数的范围
	 * @param now 开始数
	 * @param end 结束期数
	 * @param chu 数字除以多少后的余数对比
	 */
	public void info(int checkArea,int now,int end) {
		float max = 0;//最大集中数
		int maxCheck = 0;
		for (int check = 2; check <= checkArea; check++) {//包含本身对比多少期，0无解，1只对比一期，无解
			Map<Integer, Integer> minDist = new HashMap<Integer, Integer>();//对于某个check，每期最大相似的数量
			Map<Integer, Integer> minDistJsuan = new HashMap<Integer, Integer>();//对于某个check，每期最大相似的总量
			//在当前check下，maxLike的分布
			for (int i = now; i <= end; i++) {
				int[] minDistT = findTheMinDistance(check, i);
				if (minDist.containsKey(minDistT[0])) {
					minDist.put(minDistT[0], minDist.get(minDistT[0]) + 1);
					minDistJsuan.put(minDistT[0], minDistJsuan.get(minDistT[0]) + minDistT[1]);
				}else {
					minDist.put(minDistT[0], 1);
					minDistJsuan.put(minDistT[0], minDistT[1]);
				}
			}
			//检查分布
			int maxValue = 0;
			int maxIndex = 0;
			for (Map.Entry<Integer,Integer> entry: minDist.entrySet()) {
				if (entry.getValue() > maxValue) {
					maxValue = entry.getValue();
					maxIndex = entry.getKey();
				}				
			}
			float g = (float)(minDist.get(maxIndex - 1) + minDist.get(maxIndex) + minDist.get(maxIndex +1)) / (end - now);
			int jisuan = minDistJsuan.get(maxIndex - 1) + minDistJsuan.get(maxIndex) + minDistJsuan.get(maxIndex + 1);
			float xiaolv = g * 1000 / jisuan;
			if (max < xiaolv) {
				max = xiaolv;
				maxCheck = check;
			}			
			System.out.println(check + ":" +minDist + " " + g + " " + jisuan + " " + xiaolv);
			
		}
		System.out.println(max + " " + maxCheck);
	}
	
	/**
	 * 求与当前期数相似度最高的区间数量
	 * @param check 对比多少期
	 * @param i 当前期数
	 * @param isPrint 是否打印过程
	 * @return 当前期数之前，在check范围内最小距离，以及该距离的总数[最大相同数量,总数]
	 */
	private int[] findTheMinDistance(int check,int i,boolean isPrint) {
		int[] info = new int[3];
		int minDistance = 10000;//在区间中距离总数
		List<Integer> minDistancePlace = new ArrayList<Integer>();//相同最大时的起始位置
		//
		for (int j = check; j < i; j++) {//从头开始寻找相似
			int distance = 0;
			for (int k = check - 1; k >= 0; k--) {
				distance += Math.abs(Number1.num[i - k] - Number1.num[j - k]) + Math.abs(Number2.num[i - k] - Number2.num[j - k]) + Math.abs(Number3.num[i - k] - Number3.num[j - k]);
			}
			if (distance <= minDistance) {
				if (distance < minDistance) {
					minDistancePlace.removeAll(minDistancePlace);
				}
				minDistance = distance;
				minDistancePlace.add(j);
				//打印
				if (isPrint) {
					System.out.println("now:" + Periods.periods[i] + " place:" + Periods.periods[j] + " " + distance);
					for (int k = check - 1; k >= 0; k--) {						
						System.out.println(Number1.num[i - k] + "" + Number2.num[i - k] + "" + Number3.num[i - k] 
					    + "    " + Number1.num[j - k] + "" + Number2.num[j - k] + "" + Number3.num[j - k] + " " 
					    + (Math.abs(Number1.num[i - k] - Number1.num[j - k]) + Math.abs(Number2.num[i - k] - Number2.num[j - k]) + Math.abs(Number3.num[i - k] - Number3.num[j - k])));
					}
				}				
			}
		}
		info[0] = minDistance;
		info[1] = minDistancePlace.size();
		return info;		
	}
	
	private int[] findTheMinDistance(int check,int i) {
		return findTheMinDistance(check, i, false);
	}
	
	/**
	 * 得到筛选后的结果集合
	 */
	private Set<String> filtrate(int bai,int shi,int ge){
		//下期可能出现的集合
		Set<String> nextSet = new HashSet<String>();
		for (int i = 1; i < Number1.num.length; i++) {//比较两期而已
			int d = Math.abs(bai - Number1.num[i -1]) + Math.abs(shi - Number2.num[i -1]) + Math.abs(ge - Number3.num[i -1]);
			for (int j = 3; j >=3; j--) {//3、4、5占了大部分
				int sheng = j - d;//还剩
				//查找适合的
				find(sheng, Number1.num[i], Number2.num[i], Number3.num[i], nextSet);
			}
		}		
		return nextSet;
	}
	
	private void find(int sheng,int b,int s,int g,Set<String> nextSet){
		for (int bai = 0; bai < 10; bai++) {
			for (int shi = 0; shi < 10; shi++) {
				for (int ge = 0; ge < 10; ge++) {
					int cha = Math.abs(b - bai) + Math.abs(s - shi) + Math.abs(g - ge);
					if (cha == sheng) {
						if (bai == 9 && shi == 3 && ge == 8) {
							System.out.println();
						}
						nextSet.add(bai + "" + shi + "" + ge);
					}
				}
			}
		}
	}
	
	public static void main(String[] args) {
//		new MatrixLike().findTheMinDistance(2, 3950, true);
		new MatrixLike().info(10, 1000, 2000);
//		new MatrixLike().filtrate(3, 2, 4);//938
	}

}
