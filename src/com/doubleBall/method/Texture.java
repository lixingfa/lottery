package com.doubleBall.method;

import com.doubleBall.number.Bull;

/**
 * 纹理，数字组成的路径
 * @author LiXF
 *
 */
public class Texture {
	/**
	 * 纹理方法
	 * @param n 多少个路径组成的纹理段
	 * @param now 当前位置
	 * @param balls 数字序列（倒叙）
	 * return 下一个可能出现的数字
	 */
	public static int done(int n,int now,int[] balls){
		int totle = 0;
		int skewing = 0;//偏移
		int skewingY = 0;//y向上的差距
		int minSkewing = 1000;
		int maxSkewingY = 0;
		int next = 0;//下一个数字		
		int[] nowList = new int[n+1];//当前纹理数字
		int[] nowTexture = new int[n];
		int temp = 0;
		
		int same = 0;
		int zero = 0;
		int diff = 0;
		
		
		for (int i = 0; i <= n; i++) {
			nowList[i] = balls[now + i];
		}
		for (int i = nowTexture.length - 1; i >= 0 ; i--) {
			nowTexture[i] = nowList[i + 1] - nowList[i];//后面的减前面的，倒推
		}
		//到当前序列的前一步止，重合的话就一致了
		int flat = now + n + 1;
		for (int i = balls.length - 2; i > flat; i--) {//从最后面开始拿数字
//			skewing = 0;
//			for (int j = 0,k = nowList.length - 1; j <= n; j++,k--) {
//				skewing = skewing + Math.abs(balls[i - j] - nowList[k]);//
//			}
//			if (skewing <= minSkewing) {
//				minSkewing = skewing;
//				next = balls[i - n - 1];
//				System.out.print("偏移：" + skewing +" 序列：");
//				for (int j = n; j >= 0; j--) {
//					System.out.print(balls[i - j] + " ");//
//				}
//				System.out.print("当前序列：");
//				for (int j = 0; j < nowList.length; j++) {
//					System.out.print(nowList[j] + " ");
//				}
//				System.out.println("next:" + next + " 实际出:" + balls[now - 1]);
//			}
			
			skewingY = 0;
			for (int j = 0,k = nowTexture.length - 1; k >= 0; j++,k--) {
				temp = balls[i - j] - balls[i - j - 1];
				if (nowTexture[k] * temp > 0) {//同向
					skewingY++;
				}
			}
//			if (skewingY >= maxSkewingY) {
//				maxSkewingY = skewingY;
//			}
			if (skewingY == n) {
				System.out.print("Y偏移：" + skewingY +" Y序列：");
				System.out.print("(" + balls[i - n - 1] + ")");
				for (int j = n; j >= 0; j--) {
					System.out.print((balls[i - j] - balls[i - j - 1]) + " (" + balls[i - j] + ")");//
				}
				System.out.print("当前序列：(" + nowList[0] + ")");
				for (int j = 0; j < nowTexture.length; j++) {
					System.out.print(nowTexture[j] + " (" + nowList[j + 1] + ")");//
				}
				System.out.println(" 实际出:" + balls[now - 1]);
				
				totle ++;
				temp = (balls[i - n - 1] - balls[i - n]) * (balls[now] - balls[now - 1]);
				if (temp > 0) {
					same++;
				}else if(temp == 0){
					zero++;
				}else {
					diff++;
				}
			}
		}
		System.out.println(totle + " same:" + same + " zero:" + zero + " diff:" + diff);
		return totle;
	}
	
	public static void test() {
		int start = 2;//最小的纹理段
		int end = 10;//最大的纹理段
		int now = 500;//要测试的位置
		int[] balls = Bull.num;		
		
		for (int i = start; i <= end; i++) {
			done(i, now, balls);
		}
	}
	
	public static void main(String[] args) {
		//test();
//		done(0, 100, Bull.num);
//		done(1, 100, Bull.num);
//		done(2, 100, Bull.num);
//		done(3, 100, Bull.num);
//		done(4, 100, Bull.num);
//		done(5, 100, Bull.num);
		done(6, 100, Bull.num);
//		done(7, 100, Bull.num);
//		done(8, 100, Bull.num);
//		done(9, 100, Bull.num);
//		done(10, 100, Bull.num);
//		done(11, 100, Bull.num);
//		done(12, 100, Bull.num);
	}

}
