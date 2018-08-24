package com.doubleBall.method;

import java.util.HashMap;
import java.util.Map;

import com.doubleBall.number.Bull;
import com.doubleBall.number.Number1;
import com.doubleBall.number.Number2;
import com.doubleBall.number.Number3;
import com.doubleBall.number.Number4;
import com.doubleBall.number.Number5;
import com.doubleBall.number.Number6;

/**
 * 趋势
 * @author LXF
 *
 */
public class Tendency {

	private void normal(int index,double border){
		int[] num;//每个位置的数值
		//每个位置理论上会有28种可能
		float[] indexs = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};		
		int topBorder = 0,bottomBorder = 0;//上下边界
		float borderTemp = 0;//统计边界的临时变量
		switch (index) {
			case 1:
				num = Number1.num;
				break;
			case 2:
				num = Number2.num;
				break;
			case 3:
				num = Number3.num;
				break;
			case 4:
				num = Number4.num;
				break;
			case 5:
				num = Number5.num;
				break;
			case 6:
				num = Number6.num;
				break;
			default:
				num = Bull.num;
				break;
		}
		//统计总数
		for (int i = 0; i < num.length; i++) {
			indexs[num[i] - index]++;
		}
		//统计百分比
		for (int i = 0; i < indexs.length; i++) {
			indexs[i] = (float)indexs[i]/num.length;			
		}
		//寻找下边界
		for (int i = 0; i < indexs.length; i++) {
			borderTemp = borderTemp + indexs[i];
			if (borderTemp >= border) {
				bottomBorder = i + index;
				break;
			}
		}
		//寻找上边界
		borderTemp = 0;
		for (int i = indexs.length - 1; i >= 0; i--) {
			borderTemp = borderTemp + indexs[i];
			if (borderTemp >= border) {
				topBorder = i + index;
				break;
			}
		}
		for (int i = 0; i < indexs.length; i++) {
			System.out.print((index + i) + ":" + indexs[i] + "\t");
		}
		System.out.println(num.length + " 上：" + topBorder + " 下：" + bottomBorder);
	}
	
	public static void main(String[] args) {
		new Tendency().normal(6,0.2);
	}
}
