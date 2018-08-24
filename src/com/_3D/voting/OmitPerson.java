package com._3D.voting;

import com._3D.number.Number1;
import com._3D.number.Number2;
import com._3D.number.Number3;
import com._3D.number.Periods;

/**
 * 遗漏
 * @author LXF
 *
 */
public class OmitPerson implements VotingPerson {

	@Override
	public int guess(int[] nums) {
//		int[] h = new int[10];//各个号码已经出现的次数
		
		return 0;
	}

	/**
	 * 获取每个数字出现的权重
	 * @param nums 要预测的数组
	 * @param n 验证多少期
	 * @param now 当前期数
	 * @param scope 数值的范围
	 * @return
	 */
	public int[] getWeight(int[] nums,int n,int now,int scope){
		int maybe = n / scope;//在范围内理论上会出的
		int[] l = new int[scope];//与上次出现的距离
		int[] h = new int[scope];//已经出现的次数
		int[] weight = new int[scope];
		//计算出现的个数、与上次出现的距离
		for (int i = now - n; i < now; i++) {
			for (int j = 0; j < scope; j++) {
				l[j]++;
			}
			h[nums[i]]++;
			l[nums[i]] = 0;
		}
		//计算概率
		for (int i = 0; i < scope; i++) {
//			weight[i] = (maybe - h[i]) * l[i];
			weight[i] = h[i];
		}
		return weight;
	}
	
	public void check(int[] nums,int now,int n){
		float mf = 0;
		int mn = 0;
		int mr = 0;
		for (int i = 0; i <= n; i++) {
			int r = 0;//对了多少次
			for (int j = i; j <= now; j++) {
				int[] w = getWeight(nums, i, j, 10);
				int max = 0;
				int index = 0;
				for (int k = 0; k < w.length; k++) {
					if (max < w[k]) {
						max = w[k];
						index = k;
					}
				}
				if (index == nums[j + 1]) {
					r++;
				}
			}
			if (r > mr) {//对的比之前多
				mn = i;
				mr = r;
				mf =  (float)r / (now - i +1);
			}
		}
		System.out.println(mf + " " +mr + "/" + (now - mn + 1) + " " + mn);
	}
	
	public static void main(String[] args) {
		OmitPerson omit = new OmitPerson();
		omit.check(Number2.num, 1000, 30);
	}
}
