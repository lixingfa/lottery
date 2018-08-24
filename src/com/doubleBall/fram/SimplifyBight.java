package com.doubleBall.fram;

import java.awt.Color;
import java.awt.Graphics;
import java.util.HashMap;
import java.util.Map;

import com.doubleBall.number.Number1Y;

/**
 * 简化曲线
 * 参考简化地图的方法简化曲线
 * https://www.zhihu.com/question/38347271/answer/76009077
 * @author LXF
 *
 */
public class SimplifyBight {
	/**
	 * 垂直法
	 * @param nums 需要处理的数组
	 * @param consult 垂直的标量
	 * @param x x轴的增量
	 * @param y y轴的增量
	 * @param g 画图元素
	 */
	public static void vertical(int[] nums,int consult,int x,int y,int height,int index,Graphics g,Color color){
		if (color != null) {
			g.setColor(color);
		}
		int now = index;
		double droopMax = 0;
		int droopMaxI = index;
		//连接N和N+2，然后通过N+1作垂线和N、N+2的连线相交。如果垂线的长度大于参数，因此要保留点N+1；
		//然后挪位到N+1、N+2、N+3这三个点，循环……
		int length = nums.length - 1;
		for (int i = index + 1; i < length; i++) {
			double droop = droop(now, nums[now], i, nums[i], i + 1, nums[i + 1]);
			if (droop > consult) {
				//从这个点往回找到最大的那个
				for (int j = i - 1; j > now; j--) {
					droop = droop(now, nums[now], j, nums[j], i + 1, nums[i + 1]);
					if (droopMax < droop) {
						droopMax = droop;
						droopMaxI = j;
					}
				}
				//距离大于标识，需要保留，上次的点到此连线
				g.drawLine((now - index + 1) * x,height - nums[now] * y, (droopMaxI - index + 1) * x,height - nums[droopMaxI] * y);
				now = droopMaxI;
				droopMax = 0;
			}
		}
		
	}
	
	/**
	 * 已知三角形的三个点坐标，求面积
	 * @return 三角形面积
	 */
	public static float triangleArea(int x1,int y1,int x2,int y2,int x3,int y3){
		int x = x1 * y2 + x2 * y3 + x3 * y1;//从任意一点，顺时针方向，x*下一个点的y，3个相加
		int y = x1 * y3 + x3 * y2 + x2 * y1;//从任意一点，逆时针方向，x*下一个点的y，3个相加
		return (float)Math.abs(x - y)/2;
	}

	/**
	 * 已知三点坐标，求中间一点到其余两点连线的距离
	 * @return
	 */
	public static double droop(int x1,int y1,int x2,int y2,int x3,int y3){
		float area = triangleArea(x1, y1, x2, y2, x3, y3) * 2;
		double bottom = Math.sqrt((double)(x3 - x1) * (x3 - x1) + (y3 - y1) * (y3 - y1));		
		return area / bottom;
	}
	
	/**
	 * 最小二乘法（一元二次方程，曲线拟合）
	 * @param nums
	 * 找出顶点和底点，他们各自的连线可以确定取值范围
	 * @return map 得到ax+b中的a、b
	 */
	public static Map<String, Float> LeastSquares(int[] nums){
		Map<String, Float> map = new HashMap<String, Float>();
		
		
		map.put("a", 0f);
		map.put("b", 0f);
		return map;
	}
	
	/**
	 * 找出之前出现过，与指定间距相似的间距
	 * @param num 给定的数组
	 * @param start 开始坐标
	 * @param end 结束坐标
	 * @return
	 */
	public static int resemblance(int[] num,int start,int end){
		int section = end - start;//区间
		int[] slops = new int[section];//斜率，后面一个数减前面一个数的值
		int[] slopsTemp = new int[section];
		for (int i = end,j = 0; i > start; i--,j++) {
			slops[j] = num[i] - num[i - 1];
		}
		//从开始位置往前找
		for (int i = start; i > section; i--) {
			//每一个位置都往前看对应区间是否符合
			for (int j = 0; j < section; j++) {
				slopsTemp[j] = num[start - j] - num[start - j - 1];
			}
			//查看临时区间的斜率与当前是否一致
			int sameCount = 0;
			for (int j = 0; j < slopsTemp.length; j++) {
				if (slops[j] * slopsTemp[j] >= 0) {
					sameCount++;
				}
			}
			if (sameCount == section) {
				return i;
			}
		}
		
		return 0;
	}
	
	public static void main(String[] args) {
		System.out.println(resemblance(Number1Y.getAscNum(), 1081, 1087));
	}
}
