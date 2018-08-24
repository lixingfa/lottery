package com.doubleBall.method;

import java.util.ArrayList;
import java.util.List;

import com.doubleBall.number.NumberMethod;
import com.util.critical.BigAndLittle;
import com.util.critical.Critical;
import com.util.critical.Wuxing1;
import com.util.critical.Wuxing2;
import com.util.critical.Wuxing3;
import com.util.critical.Wuxing4;
import com.util.critical.Wuxing5;
import com.util.critical.Wuxing6;

public class DoubleBallCritical {

	public static void main(String[] args) {
		int[][] redBall = NumberMethod.redBallY();
		List<Critical> criticals = new ArrayList<Critical>();
		criticals.add(new BigAndLittle(redBall, 33));
//		criticals.add(new Divide10(redBall, 33));
//		criticals.add(new Divide2(redBall, 33));
//		criticals.add(new Divide34(redBall, 33));
//		criticals.add(new Divide5(redBall, 33));
		criticals.add(new Wuxing1(redBall, 33));
		criticals.add(new Wuxing2(redBall, 33));
		criticals.add(new Wuxing3(redBall, 33));
		criticals.add(new Wuxing4(redBall, 33));
		criticals.add(new Wuxing5(redBall, 33));
		criticals.add(new Wuxing6(redBall, 33));
		//100-1100 概率从小到大排序，下期出现位置的统计情况
		//[240, 157, 222, 182, 206, 226, 176, 161, 177, 179,
		//173, 195, 181, 180, 215, 186, 209, 188, 186, 149,
		//207, 192, 155, 131, 157, 173, 169, 176, 193, 233,
		//145, 124, 125, 32]
		int[] place = new int[34];
		float gailv = 0f;
		for (int i = 100; i < 1100; i++) {
			for (int j = 0; j < redBall[0].length; j++) {
				float[] nextKill = new float[34];//单个位置排除情况
				for (int k = 0; k < criticals.size(); k++) {
					float[] t = criticals.get(k).nextKill(i, j);
					for (int l = 0; l < t.length; l++) {
						nextKill[l] = nextKill[l] + t[l];
					}
				}
				gailv = nextKill[redBall[i + 1][j]];
				//冒泡排序
				for (int k = 0; k < nextKill.length; k++) {
					for (int l = 0; l < nextKill.length; l++) {
						if (nextKill[k] <= nextKill[l]) {
							float t = nextKill[k];
							nextKill[k] = nextKill[l];
							nextKill[l] = t;
						}
					}
				}
				//看跑在什么位置出
				for (int k = 0; k < nextKill.length; k++) {
					if (nextKill[k] == gailv) {
						place[k]++;
						break;//TODO 概率相同的情况下，会出现错觉
					}
				}
			}
			//
			
		}
		System.out.println();
	}
}
