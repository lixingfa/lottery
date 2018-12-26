/**
 * 
 */
package com.util;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import Jama.Matrix;

/**
 * @author lixingfa
 * @date 2018年12月25日下午4:20:20
 * 
 */
public class MatrixUtil {

	
	public static void main(String[] args) {
		double[][] data = {{0,5,3,4,2}};
		double[][][] know = {{{1,3,5,7,3}},{{1,3,5,7,3}},{{1,4,2,7,2}},{{2,5,9,4,9}},{{1,1,6,2,2}}};
		int[] result = {1,4,9,3};
		new MatrixUtil().KNN(data, know, result, 2);
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
			//平方
			double[][] t = tMatrix.getArray();
			for (int j = 0; j < t.length; j++) {
				for (int k = 0; k < t[j].length; k++) {
					t[j][k] = t[j][k] * t[j][k];
				}
			}
			//求和
			double sum = 0;
			for (double[] ds : t) {
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
