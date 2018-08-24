package com._3D.number;

/**
 * @author LIXF
 *
 */
public class NumberMethod {
	
	/**
	 * 统计一个数组中各个数字出现的总数
	 * @param nums 数组
	 * @param length 计算的长度
	 */
	private static void totleEach(int[] nums,int start,int end){
		int[] totle = new int[10];
		for (int i = start; i < end; i++) {
			totle[nums[i]]++;
		}
		for (int i = 0; i < totle.length; i++) {
			System.out.print(i + ":" + totle[i] + " ");
		}
	}
	
	/**
	 * 打印号码
	 */
	private static void printNums(){
		int lenght = Number1.num.length - 1;
		for (int i = 0; i <= lenght; i++) {
//			System.out.println(i + " " + Periods.periods[i] + " " + NumDate.date[i] + " " + Number1.num[i] + " " +Number2.num[i] + " " +Number3.num[i]);
			System.out.println(i + " " + Periods.periods[i] + " " + Number1.num[i] + " " +Number2.num[i] + " " +Number3.num[i]);
		}
		System.out.println(lenght + 1);
	}
	
	/**
	 * 打印红球
	 * @param how 1-6
	 * @param many 是否连之前的也打印
	 */
	private static void printRedPlace(int how,boolean many) {
		for (int i = Number1.num.length - 1; i >= 0; i--) {
			for (int j = 1; j < Number1.num[i]; j++) {
				System.out.print("  ");
			}
			if (how > 1 && many || how == 1) {
				if (Number1.num[i] < 10) {
					System.out.print(" ");
				}
				System.out.print(Number1.num[i]);
			}else {
				System.out.print("  ");
			}
			for (int j = Number1.num[i] + 1; j < Number2.num[i]; j++) {
				System.out.print("  ");
			}
			if (how > 2  && many || how == 2) {
				if (Number2.num[i] < 10) {
					System.out.print(" ");
				}
				System.out.print(Number2.num[i]);
			}else {
				System.out.print("  ");
			}
			for (int j = Number2.num[i] + 1; j < Number3.num[i]; j++) {
				System.out.print("  ");
			}
			if (how > 3 && many || how == 3) {
				if (Number3.num[i] < 10) {
					System.out.print(" ");
				}
				System.out.print(Number3.num[i]);				
			}else {
				System.out.print("  ");
			}
			System.out.println();
		}
	}
	
	/**
	 * 获取子字符串
	 * @param star 开始截取位置
	 * @param end 结束截取位置
	 * @param nums 要截取的字符串
	 * @return
	 */
	public static int[] getSubNumbers(int star,int end,int[] nums){
		int[] temp = new int[end - star + 1];
		for (int i = 0,index = star; i < temp.length; i++,index++) {
			temp[i] = nums[index];
		}
		return temp;
	}
	
	/**
	 * 兑奖
	 * @param num1 第一位选的号码
	 * @param num2 第二位选的号码
	 * @param num3 第三位选的号码
	 * @param now 当前期数,为负表示未开奖，需预测
	 * @return 收益
	 */
	public static int expiry(int[] num1,int[] num2,int[] num3,int now){
		int costing = num1.length * num2.length * num3.length * 2;//成本
		int bonus = 0;//奖金
		if (now >= 0) {
			int[] nowNums = {Number1.num[now],Number2.num[now],Number3.num[now]};//实际的结果
			boolean isSame = false;
			int zhixuan = nowNums[0] * 100 + nowNums[1] * 10 + nowNums[2];
			boolean zu3 = false;
			if (!isSame && (nowNums[0] == nowNums[1] || nowNums[1] == nowNums[2] || nowNums[0] == nowNums[2])) {
				zu3 = true;
			}
			for (int i = 0; i < num1.length; i++) {
				for (int j = 0; j < num2.length; j++) {
					for (int k = 0; k < num3.length; k++) {
						int result = num1[i] * 100 + num2[j] * 10 + num3[k];
						//直选奖
						if (zhixuan == result) {
							isSame = true;
							bonus = 1040;
							System.out.println("中直选奖，1040");
							break;
						}
						//组3
						if (zu3 && ((result == nowNums[2] * 100 + nowNums[0] * 10 + nowNums[1])
								||(result == nowNums[0] * 100 + nowNums[2] * 10 + nowNums[1])
								||(result == nowNums[2] * 100 + nowNums[1] * 10 + nowNums[0]))) {
							isSame = true;
							bonus = 346;
							System.out.println("中组3奖，346");
							break;
						}
						//组6
						if ((result == nowNums[2] * 100 + nowNums[0] * 10 + nowNums[1]) || (result == nowNums[2] * 100 + nowNums[1] * 10 + nowNums[0])
								|| (result == nowNums[1] * 100 + nowNums[2] * 10 + nowNums[0]) || (result == nowNums[1] * 100 + nowNums[0] * 10 + nowNums[2])
								|| (result == nowNums[0] * 100 + nowNums[2] * 10 + nowNums[1]) || (result == nowNums[0] * 100 + nowNums[1] * 10 + nowNums[2])) {
							isSame = true;
							bonus = 173;
							System.out.println("中组6奖，173");
							break;
						}
					}
					if (isSame) {
						break;
					}
				}
				if (isSame) {
					break;
				}
			}
			
			//都对上了
			
		}
		bonus = bonus - costing;
		System.out.println(bonus);
		return bonus;
	}
	
	public static void gailv(int[] num){
		int total = 0;
		for (int i = 1; i < num.length; i++) {
			if (num[i] == num[i - 1] && num[i] != num[i + 1]) {
				total++;
			}
		}
		System.out.println(total + "/" + num.length + "=" + ((float)total/num.length));
	}
	
	public static void main(String[] args) {
//		System.out.println(Number1.num.length);
//		printNums();
//		printRedPlace(1,false);
//		totleEach(Number3.num, 100,999);
//		expiry(new int[]{1,2,3}, new int[]{4,5,6}, new int[]{7,8,9}, 3967);//
		gailv(Number1.num);
	}	
}
