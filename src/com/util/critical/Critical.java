package com.util.critical;


/**
 * 临界点，使用各种方法寻找临界点，然后排除
 * @author Lixingfa
 *
 */
public abstract class Critical {

	/**出的每期号码*/
	protected int[][] num;
	/**本规则的理论概率*/
	protected float gailv;
	/**出现号码的最大值*/
	protected int maxNum;
	
	protected Critical(int[][] num,int maxNum){
		this.num = num;
		this.maxNum = maxNum;
	}
	
	protected Critical(int[] num,int maxNum){
		int[][] t = new int[num.length][1];
		for (int i = 0; i < t.length; i++) {
			t[i][0] = num[i];
		}
		this.num = t;
		this.maxNum = maxNum;
	}
	
	/**
	 * 根据当前规则，下期各号码该位置会出的概率
	 * @param now
	 * @param place
	 * @return
	 */
	public float[] nextKill(int now,int place){
		float[] k = new float[maxNum + 1];
		for (int i = 0; i < k.length; i++) {
			if (rule(i) == rule(now,place)) {
				k[i] = gailv * gailv;
				//往前找
				for (int j = 0; j < 30; j++) {
					if (rule(now - j,place) == rule(now - j - 1,place)) {
						k[i] = k[i] * gailv;
					}else {
						break;
					}
				}
			}else {
				k[i] = gailv;
			}
		}
		return k;
	}
	
	/**
	 * 运算规则，子类实现此方法
	 * @param place 号码位置
	 * @param now 当前期数
	 * @return 运算结果
	 */
	protected abstract float rule(int now,int place);
	
	/**
	 * 运算规则，子类实现此方法
	 * @param i 数字
	 * @return 运算结果
	 */
	protected abstract float rule(int i);
}
