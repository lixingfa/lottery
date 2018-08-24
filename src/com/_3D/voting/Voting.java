package com._3D.voting;

import java.util.ArrayList;
import java.util.List;

import com._3D.number.Number1;
import com._3D.number.Number2;
import com._3D.number.Number3;
import com._3D.number.NumberMethod;

/**
 * 公投，让每个人对同一个事情进行猜测，虽然结果直接差异很大，
 * 但最后的平均结果跟实际结果是比较接近的
 * @author LXF
 *
 */
public class Voting {
	/**参与投票的人*/
	List<VotingPerson> persons;
	
	Voting(List<VotingPerson> persons){
		this.persons = persons;
	}
	
	/**
	 * 获取投票结果
	 * @param nums
	 * @return
	 */
	private int getVotingResult(int[] nums){
		int result = 0;
		for (int i = 0; i < persons.size(); i++) {
			result = result + persons.get(i).guess(nums);//取平均值
		}
		return (int)((float)result / persons.size());
	}
	
	/**
	 * 获取投票结果
	 * @param num1
	 * @param num2
	 * @param num3
	 * @return
	 */
	public int[] getVotingResults(int[] num1,int[] num2,int[] num3){
		int[] nums = {0,0,0};
		nums[0] = getVotingResult(num1);
		nums[1] = getVotingResult(num2);
		nums[2] = getVotingResult(num3);
		return nums;
	}
	
	
	public void check(){
		for (int i = 100; i < Number1.num.length; i++) {
			for (int j = 0; j <= i ; j++) {
				//截取当前到开始的数组
				int[] num1 = NumberMethod.getSubNumbers(0, j, Number1.num);
				int[] num2 = NumberMethod.getSubNumbers(0, j, Number2.num);
				int[] num3 = NumberMethod.getSubNumbers(0, j, Number3.num);
				int[] result = getVotingResults(num1, num2, num3);//获取投票结果
				//与实际对比
				
			}
		}
	}
	
	public static void main(String[] args) {
		List<VotingPerson> persons = new ArrayList<VotingPerson>();
		persons.add(new OmitPerson());
		
		new Voting(persons).check();
	}
}
