package com._3D.method;

import java.util.HashMap;
import java.util.Map;

import com._3D.number.Number3;

public class Test {
	
	//简单粗暴的循环方法……
	public void find(int check,int how,int[] num) {
		Gongshi[]  gongshis= new Gongshi[check * 100 * 30];
		//初始化
		int j = 0;
		for (int g = 0; g < check; g++) {
			for (float a = 0.01f; a <= 1; a = a + 0.01f) {
				for (int k = 1; k <= 30; k++) {
					gongshis[j] = new Gongshi(g,a,k);
					j++;
				}
			}				
		}
		System.out.println("数据初始化完成……");
		//验证
		Gongshi tgsR = new Gongshi(0, 0, 0);
		int rightM = 0;
		for (int gs = 0; gs < gongshis.length; gs++) {
			//以这样的组合去验证
			int right = 0;
			for (int index = check; index < how; index++) {//验证的期数
				//获取h和l
				int[] h = new int[10];
				int[] l = new int[10];
				int[] lianxu = new int[10];
				boolean[] has = new boolean[10];//如果已经出现过，就不用计算遗漏
				int before = -1;
				for (int i = 0; i <= check; i++) {
					int now = num[index - i];
					h[now]++;
					for (j = 0; j <= 9; j++) {//活得遗漏
						if (now != j && !has[j]) {
							l[j]++;
						}else {
							has[j] = true;
						}
					}
					if (before == now) {
						lianxu[now]++;
					}
					before = now;
				}													
				//计算概率
				Map<Integer, Float> map = new HashMap<Integer, Float>();
				for (int i = 0; i <= 9; i++) {
					map.put(i, gailv(gongshis[gs], h[i], l[i], lianxu[i], check));
				}
				//
				int next = num[index + 1];
				float nextg = map.get(num[index + 1]);
				boolean isRight = true;
				for (int i = 0; i <= 9; i++) {
					if (map.get(i) >= nextg && i != next) {
						isRight = false;
						break;
					}
				}
				if (isRight) {
					right++;														
				}
			}
			if (right > rightM) {
				rightM = right;
				tgsR = new Gongshi(gongshis[gs].g, gongshis[gs].a, gongshis[gs].k);
				System.out.println(gs + " " +right + " " + gongshis[gs].g + " " + gongshis[gs].a + " " + gongshis[gs].k);
			}
			if (gs % 10000 == 0) {
				System.out.println(gs);
			}
		}
		System.out.println(rightM + " " + tgsR.g + " " + tgsR.a + " " + tgsR.k);
	}

	
	
	//计算概率
	private float gailv(Gongshi gongshi,int h,int l,int lianxu,int check){
		if (lianxu >= 3) {
			return 0f;
		}else{
			return h * gongshi.g / check - gongshi.a * ((l - gongshi.k) / gongshi.k) * ((l - gongshi.k) / gongshi.k) + 1;
		}
	}
	
	class Gongshi{
		private int g;
		private float a;
		private int k;
		
		public Gongshi(int g,float a,int k) {
			this.g = g;
			this.a = a;
			this.k = k;
		}
	}
	
	public static void main(String[] args) {
		new Test().find(20, 1020, Number3.num);
//		new Test().check();
	}
}
