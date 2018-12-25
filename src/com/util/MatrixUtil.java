/**
 * 
 */
package com.util;

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
		matrix.print(3, 0);		
		matrix.getMatrix(0, 1, 0, 1);//取矩阵第一列元素，第一、第二个参数表示行的开始和结束，第三第四个参数表示列的开始和结束
		
		double[][] t={{5,6},{7,8}};
		Matrix matrixt = new Matrix(t);
		//加
		Matrix add = matrix.plus(matrixt);
		add.print(0, 0);
		//减法
		Matrix minus = matrix.minus(matrixt);
		//乘
		Matrix times = matrix.times(matrixt);
		//除
		Matrix divide = matrix.arrayLeftDivide(matrixt);
		
	}
}
