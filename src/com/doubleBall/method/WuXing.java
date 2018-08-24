package com.doubleBall.method;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com._3D.number.NumDate;
import com._3D.number.Number1;
import com._3D.number.Number2;
import com._3D.number.Number3;
import com._3D.number.Periods;

/**
 * 五行，
 * 1、6水，2、7火，3、8木，4、9金，5、0土
 * 0刑，1生上，2生下，3克上，4克下
 * @author LXF
 *
 */
public class WuXing {
	
	/**
	 * 获取一个数的五行
	 * @param num 数字
	 * @param sum 数字每位相加
	 * @return
	 */
	public static int getWuXing(int num,boolean sum){
		if (sum) {
			int wuxing = 0;
			while (num != 0) {
				wuxing = wuxing + num % 10;
				num = num /10;
			}
			return wuxing % 5;			
		}else {
			return num % 5;			
		}
	}
	
	/**
	 * 打印数字五行属性
	 * @param num
	 */
	public static void printName(int num){
		String s = null;
		switch (num) {
			case 0: s = "土";break;
			case 1: s = "水";break;
			case 2: s = "火";break;
			case 3: s = "木";break;
			case 4: s = "金";break;
			default: s = "";break;
		}
		System.out.print(s);
	}
	
	/**
	 * 获取两个数的生克关系
	 * 0刑，1生上，2生下，3克上，4克下
	 * @param former 前一个数
	 * @param now 后一个数
	 * @return
	 */
	public static int shengke(int former,int now){
		switch (former) {
			case 1:
				switch (now) {
					case 1:return 0;
					case 2:return 4;
					case 3:return 2;
					case 4:return 1;
					case 0:return 3;
				}
			case 2:
				switch (now) {
					case 1:return 3;
					case 2:return 0;
					case 3:return 1;
					case 4:return 4;
					case 0:return 2;
				}
			case 3:
				switch (now) {
					case 1:return 1;
					case 2:return 2;
					case 3:return 0;
					case 4:return 3;
					case 0:return 4;
				}
			case 4:
				switch (now) {
					case 1:return 2;
					case 2:return 3;
					case 3:return 4;
					case 4:return 0;
					case 0:return 1;
				}
			case 0:
				switch (now) {
					case 1:return 4;
					case 2:return 1;
					case 3:return 3;
					case 4:return 2;
					case 0:return 0;
				}
		}
		return 0;
	}
	
	/**
	 * 打印生克关系
	 * @param num
	 */
	public static void printShengKe(int shengke){
		String s = null;
		switch (shengke) {
			case 0: s = "⊕";break;
			case 1: s = "∩";break;
			case 2: s = "∪";break;
			case 3: s = "∧";break;
			case 4: s = "∨";break;
			default: s = "";break;
		}
		System.out.print(s);
	}
	
	/**
	 * 选号
	 * @param sum true和值每位相加得到的五行
	 * @param formerW 前一个和值的五行
	 * @param formerS 前一个生克关系
	 * @param wSet 连同前面三期四个五行的集合
	 * @param sSet 连同前面四期四个生克关系的集合
	 * @return 最后选出的结果
	 */
	public static List<Integer[]> choose(boolean sum,int formerW,int formerS,Set<Integer> wSet,Set<Integer> sSet){
		printName(formerW);
		printShengKe(formerS);
		List<Integer[]> nums = new ArrayList<Integer[]>();
		for (int i = 0; i <= 9; i++) {
			for (int j = 0; j <=9 ; j++) {
				for (int k = 0; k <= 9; k++) {
					int[] num = {i,j,k};
					int total = sum(num);
					int wuXing = getWuXing(total, sum);
					if (wuXing != formerW) {
						int shengke = shengke(formerW, wuXing);
						if (shengke != formerS) {
							Integer[] temp = {i,j,k};
							nums.add(temp);
//							if (wSet.size() <= 4 && wSet.contains(wuXing)) {//连同前面三期四个五行的集合,此数的五行在合集里
//								if (sSet.size() <= 4 && sSet.contains(shengke)) {//此数的五行在合集里
//									Integer[] temp = {i,j,k};
//									nums.add(temp);
//								}
//							}
						}
					}
				}
			}
		}
		return nums;
	}
	
	/**
	 * 兑奖
	 * @param nums 购买的数字列表
	 * @param real 实际开出的数组
	 */
	public static int check(List<Integer[]> nums,int[] real,int beishu){
		int bonus = 0;//奖金
		int total = real[0] + real[1] + real[2];
		int realNum = real[0] * 100 + real[1] * 10 + real[2];
		for (int i = 0; i < nums.size(); i++) {
			boolean[] same = {false,false,false};
			int[] num = {nums.get(i)[0],nums.get(i)[1],nums.get(i)[2]};
			for (int j = 0; j < num.length; j++) {
				for (int k = 0; k < num.length; k++) {
					if (real[j] == num[k]) {
						same[j] = true;
						num[k] = -1;
						break;
					}
				}
			}			
			if (same[0] && same[1] && same[2]) {//三个完全一致才有奖
				if ((nums.get(i)[0] * 100 + nums.get(i)[1] * 10 + nums.get(i)[2]) == realNum) {
					bonus = bonus + 1000 * beishu;//一等奖,完全一致
					System.out.print(" 1000-" + nums.get(i)[0] + "" + nums.get(i)[1] + "" + nums.get(i)[2]);
				}else if(real[0] == real[1] || real[1] == real[2] || real[0] == real[2]){
					bonus = bonus + 320 * beishu;//二等奖，有两个号码相同
					System.out.print(" 320-" + nums.get(i)[0] + "" + nums.get(i)[1] + "" + nums.get(i)[2]);
				}else {
					bonus = bonus + 160 * beishu;//三等奖，每个号码都不同
					System.out.print(" 160-" + nums.get(i)[0] + "" + nums.get(i)[1] + "" + nums.get(i)[2]);
				}
				
			}
		}
		System.out.print("|| 奖金总共：" + bonus + "||投入:" + nums.size() * 2 + " ||收益：" + (bonus - nums.size() * 2));
		return (bonus - nums.size() * 2);
	}
	
	public static void test(){
		int shouru = 0;
		int wuxingqiquan = 0;//5期内五行齐全的数量
		int lianxuWM = 0;//连续出现五行最多
		int lianxuW = 0;
		int fomerw = -1;//上一个五行
		int lianxuSM = 0;//连续生克
		int lianxuS = 0;
		int fomers = -1;//上一个五行
		boolean sum = true;
		
		int length = 100;//Number1.num.length;
		ArrayList<Integer> sumWuxing = new ArrayList<Integer>();
		ArrayList<Integer> shengkes = new ArrayList<Integer>();
		for (int i = 0; i < 5; i++) {
			int[] nums = {Number1.num[i],Number2.num[i],Number3.num[i]};
			int total = sum(nums);
			int wuxing = getWuXing(total, sum);
			if (wuxing == fomerw) {
				lianxuW++;
			}else {
				if(lianxuW > lianxuWM){
					lianxuWM = lianxuW;
				}
				lianxuW = 0;
			}
			fomerw = wuxing;
			sumWuxing.add(wuxing);
			if (i > 0) {
				int shengke = shengke(sumWuxing.get(i - 1), wuxing);
				if (shengke == fomers) {
					lianxuS++;
				}else {
					if (lianxuS > lianxuSM) {
						lianxuSM = lianxuS;
					}
					lianxuS = 0;
				}
				fomers = shengke;
				System.out.print(Periods.periods[i] + " " + NumDate.date[i] + " " 
						+ Number1.num[i] + " " +Number2.num[i] + " " +Number3.num[i] + " " + total + "	" + lianxuW + " " + lianxuS);
				shengkes.add(shengke);
				printShengKe(shengke);
				printName(wuxing);
			}
			System.out.println();
		}
		for (int i = 5; i < length; i++) {
			int[] nums = {Number1.num[i],Number2.num[i],Number3.num[i]};
			int total = sum(nums);
			System.out.print(Periods.periods[i] + " " + NumDate.date[i] + " " 
					+ Number1.num[i] + " " +Number2.num[i] + " " +Number3.num[i] + " " + total + "	");
			
			int wuxing = getWuXing(total, sum);
			if (wuxing == fomerw) {
				lianxuW++;
			}else {
				if(lianxuW > lianxuWM){
					lianxuWM = lianxuW;
				}
				lianxuW = 0;
			}
			fomerw = wuxing;
			sumWuxing.add(wuxing);
			int shengke = shengke(sumWuxing.get(i - 1), wuxing);
			if (shengke == fomers) {
				lianxuS++;
			}else {
				if (lianxuS > lianxuSM) {
					lianxuSM = lianxuS;
				}
				lianxuS = 0;
			}
			fomers = shengke;
			System.out.print(lianxuW + " " + lianxuS);
			shengkes.add(shengke);
			printShengKe(shengke);
			printName(wuxing);
			
			Set<Integer> wSet = new HashSet<Integer>();
			Set<Integer> sSet = new HashSet<Integer>();
			Set<Integer> wSet4 = new HashSet<Integer>();
			Set<Integer> sSet4 = new HashSet<Integer>();
			//看前四期出现了什么
			for (int j = 0; j <= 4; j++) {
				wSet.add(sumWuxing.get(i - j));
				sSet.add(shengkes.get(i - j - 1));
				if (j < 4) {
					wSet4.add(sumWuxing.get(i - j));
					sSet4.add(shengkes.get(i - j - 1));
				}
			}
			if(wSet.size() == 5){
				wuxingqiquan++;
			}
			System.out.print(wSet.size() + " " + sSet.size() + "	");
			//投资情况
			int[] real = {Number1.num[i + 1],Number2.num[i + 1],Number3.num[i + 1]};
			shouru = shouru + check(choose(sum, fomerw, fomers, wSet4, sSet4), real,1);
			System.out.print(" " + shouru);
			System.out.println();
		}
		System.out.println(wuxingqiquan + " " +lianxuWM + " " + lianxuSM + "/" + length);
	}
	
	private static int sum(int[] nums){
		int total = 0;
		for (int i = 0; i < nums.length; i++) {
			total = total + nums[i];
		}
		return total;
	}
	

	public static void main(String[] args) {
		test();		
	}
}
