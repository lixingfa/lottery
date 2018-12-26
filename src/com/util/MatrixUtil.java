/**
 * 
 */
package com.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

import Jama.Matrix;

/**
 * @author lixingfa
 * @date 2018年12月25日下午4:20:20
 * 
 */
public class MatrixUtil {

	
	public static void main(String[] args) {
		double[][] d={{1,2},{3,4}};
		
		Matrix matrix = new Matrix(d);
		matrix.print(4, 2);//打印矩阵，第一个参数是每列的宽度，第二个参数是保留的小数点位数
		
		matrix.set(0, 0, 2);//设置第一行第一列的数值
		matrix.print(3, 0);//打印矩阵，第一个参数是每列的宽度，第二个参数是保留的小数点位数
		matrix.getMatrix(0, 1, 0, 1);//取矩阵第一列元素，第一、第二个参数表示行的开始和结束，第三第四个参数表示列的开始和结束
		
		double[][] t={{5,6},{7,8}};
		Matrix matrixt = new Matrix(t);
		//加
		Matrix add = matrix.plus(matrixt);
		add.print(0, 0);
		//减法
		Matrix minus = matrix.minus(matrixt);
		minus.print(0, 0);
		//乘
		Matrix times = matrix.times(matrixt);
		times.print(0, 0);
		//除
		Matrix divide = matrix.arrayLeftDivide(matrixt);
		divide.print(0, 0);
		
		//求平方和，最后用Math.sqrt()开方
	}
	
	/**
	 * getNearSort:(获取待测数据最可能结果的map)
	 * @author lixingfa
	 * @date 2018年12月26日下午3:10:26
	 * @param data 要预测的数据
	 * @param know 已知的数据
	 * @param result 已知数据的结果
	 * @return Map<Double, Integer> key 与已知数据的距离，value 已知数据的结果
	 */
	private Map<Double, Integer> getNearSort(double[][] data,double[][][] know,int[] result){
		Matrix now = new Matrix(data);
		Map<Double, Integer> sqrts = new HashMap<Double, Integer>();//装距离和结果的map 
		for (int i = 0;i < know.length;i++) {
			Matrix tMatrix = new Matrix(know[i]);
			tMatrix = tMatrix.minus(now);//相减
			tMatrix = tMatrix.times(tMatrix);//平方
			//求和
			double sum = 0;
			double[][] tArray = tMatrix.getArray();
			for (double[] ds : tArray) {
				for (double d : ds) {
					sum = sum + d;
				}
			}
			//开方
			sum = Math.sqrt(sum);
			sqrts.put(sum, result[i]);//装结果
		}
		//对结果map进行排序
		sqrts = MapUtil.sortMapByKey(sqrts);
		return sqrts;
	}
	
	/**
	 * KNN:(前K)
	 * @author lixingfa
	 * @date 2018年12月26日下午4:04:15
	 * @param data 要预测的数据
	 * @param know 已知的数据
	 * @param result 已知数据的结果
	 * @param k 取前k个里出现最多的
	 */
	private Integer KNN(double[][] data,double[][][] know,int[] result,int k){
		Map<Double, Integer> sqrts = getNearSort(data, know, result);
		int i = 0;
		Map<Integer, Integer> kResult = new HashMap<Integer, Integer>();
		for (Entry<Double, Integer> entry : sqrts.entrySet()) {
			if (i < k) {
				int v = entry.getValue();
				if (kResult.containsKey(v)) {
					kResult.put(v, kResult.get(v) + 1);
				}else {
					kResult.put(v, 1);					
				}
			}
			i++;
		}
		//按值排序
		kResult = MapUtil.sortMapByValue(kResult);
		//取第一个
		for (Entry<Integer, Integer> entry : kResult.entrySet()) {
			return entry.getKey();
		}
		return null;
	}
	
	
}
