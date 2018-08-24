package com.doubleBall.method;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RedTest {

	private static RedTest rt = new RedTest();

	// 循环次数
	private static Integer x = 100;

	// 上期结果：
	private static Integer[] pp = { 6, 13, 16, 18, 20, 22 };

	// 本期结果：
	private static Integer[] bb = {};// 未出，待验证

	// 6期没有出现的数据
	private static Integer[] yl6 = { 2, 4, 10, 12, 14, 17, 24, 26, 28, 30, 33 };

	// 6期出现的数据
	private static Integer[] cx6 = { 1, 3, 5, 6, 7, 8, 9, 11, 13, 15, 16, 18, 19, 20, 21, 22, 23, 25, 27, 29, 31, 32 };

	// 七区杀码 -杀码的意思是不会出现的数据，主要从官网数据得出。
	private static Integer[] sha7 = { 6, 7, 8, 9, 10, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30 };

	// 四区杀码 -杀码的意思是不会出现的数据，主要从官网数据得出。
	private static Integer[] sha4 = {};// 本期放弃

	/**
	 * 程序主入口
	 * 
	 * @author 杨朝敬
	 * @date 2015年9月29日
	 * @param args
	 */
	public static void main(String[] args) {
		List<List<Integer>> tj = new ArrayList<List<Integer>>();

		List<Integer> list = rt.getList();

		// 统计中1,2,3,4,5,6个的次数
		int z1 = 0, z2 = 0, z3 = 0, z4 = 0, z5 = 0, z6 = 0;
		int y = 0;
		while (y < x) {
			boolean isTrue = true;
			while (isTrue) {
				if (rt.isTorF(list) && rt.isTorF1(list) && rt.isTorF2(list)
						&& rt.isTorF3(list) && rt.isTorF4(list)
						&& rt.isTorF5(list) && rt.isTorF6(list)
						&& rt.isTorF7(list) && rt.isTorF8(list)
						&& rt.isTorF9(list) && rt.isTorF10(list)
						&& rt.isTorF11(list) && rt.isTorF12(list)
						&& rt.isTorF13(list) && rt.isTorF14(list)
						&& rt.isTorF15(list) && rt.isTorF16(list)
						&& rt.isTorF17(list) && rt.isTorF18(list)
						&& rt.isTorF19(list) && rt.isTorF20(list) 
						
						&&rt.isTorF21(list) && rt.isTorF22(list)
						&& rt.isTorF23(list) 
						
						&&rt.isTorF(list)) {
					// System.out.println(list);

					// 对比本期，中几个
					int count = rt.ppAndbb(list);

					if (count == 1)
						z1++;
					if (count == 2)
						z2++;
					if (count == 3)
						z3++;
					if (count == 4)
						z4++;
					if (count == 5)
						z5++;
					if (count == 6)
						z6++;

					System.out.println(list + "：中：" + count);

					tj.add(list);
					list = rt.getList();
					isTrue = false;
				} else {
					list = rt.getList();
				}
			}
			y++;
		}
		System.out.println("循环次数为：" + y);
		System.out.println("z1:" + z1);
		System.out.println("z2:" + z2);
		System.out.println("z3:" + z3);
		System.out.println("z4:" + z4);
		System.out.println("z5:" + z5);
		System.out.println("z6:" + z6);

		rt.qqcf(tj);
	}

	/**
	 * 对比本期，中几个
	 * 
	 * @author 杨朝敬
	 * @date 2015年9月29日
	 * @param list
	 * @return
	 */
	private int ppAndbb(List<Integer> list) {
		int count = 0;
		for (int i = 0; i < list.size(); i++) {
			for (int j = 0; j < bb.length; j++) {
				if (list.get(i) == bb[j]) {
					count++;
				}
			}
		}
		return count;
	}

	/**
	 * 统计数据
	 * 
	 * @author 杨朝敬
	 * @date 2015年9月29日
	 * @param list
	 */
	private void statistics(List<List<Integer>> list) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		for (int i = 0; i < list.size(); i++) {
			for (int j = 0; j < list.get(i).size(); j++) {
				if (map.get(list.get(i).get(j) + "") == null) {
					map.put("" + list.get(i).get(j), 1);
				} else {
					int count = map.get("" + list.get(i).get(j));
					map.remove("" + list.get(i).get(j));
					map.put("" + list.get(i).get(j), count + 1);
				}
			}
		}
		System.out.println(">>>>>统计数据>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		int count = 0;
		for (int i = 1; i <= 33; i++) {
			if (map.get("" + i) != null) {
				System.out.println(i + "=" + map.get("" + i));
				count++;
			}
		}
		System.out.println("共有 " + count + " 个数");
	}

	/**
	 * 去处重复项
	 * 
	 * @author 杨朝敬
	 * @date 2015年9月29日
	 * @param list
	 */
	private void qqcf(List<List<Integer>> list) {
		for (int i = 0; i < list.size(); i++) {
			for (int j = i + 1; j < list.size();) {
				if (list.get(i).equals(list.get(j))) {
					list.remove(j);
					j = i + 1;
				} else {
					j++;
				}
			}
		}
		System.out.println("====去处重复项==================================================");
		// 统计中1,2,3,4,5,6个的次数
		int z1 = 0, z2 = 0, z3 = 0, z4 = 0, z5 = 0, z6 = 0;
		for (int i = 0; i < list.size(); i++) {
			// System.out.println(list.get(i));
			// 对比本期，中几个
			int count = rt.ppAndbb(list.get(i));

			if (count == 1)
				z1++;
			if (count == 2)
				z2++;
			if (count == 3)
				z3++;
			if (count == 4)
				z4++;
			if (count == 5)
				z5++;
			if (count == 6)
				z6++;

			System.out.println(list.get(i) + "：中：" + count);
		}
		System.out.println("去除重复后：" + list.size() + "次");
		System.out.println("z1:" + z1);
		System.out.println("z2:" + z2);
		System.out.println("z3:" + z3);
		System.out.println("z4:" + z4);
		System.out.println("z5:" + z5);
		System.out.println("z6:" + z6);

		rt.statistics(list);

	}

	/**
	 * 随机生成6个红球
	 * 
	 * @author 杨朝敬
	 * @date 2015年9月29日
	 * @return
	 */
	private List<Integer> getList() {
		List<Integer> list = new ArrayList<Integer>();
		int[] b = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33 };
		int r1 = b[(int) (Math.random() * 33)];
		int r2 = b[(int) (Math.random() * 33)];
		int r3 = b[(int) (Math.random() * 33)];
		int r4 = b[(int) (Math.random() * 33)];
		int r5 = b[(int) (Math.random() * 33)];
		int r6 = b[(int) (Math.random() * 33)];
		list.add(r1);
		list.add(r2);
		list.add(r3);
		list.add(r4);
		list.add(r5);
		list.add(r6);
		list = rt.sort(list);
		return list;
	}

	/**
	 * 判断6个球互不相同
	 * 
	 * @author 杨朝敬
	 * @date 2015年9月29日
	 * @param list
	 * @return
	 */
	private boolean isTorF(List<Integer> list) {
		int tmp = 0;
		for (int i = 0; i < list.size(); i++) {
			tmp = list.get(i);
			for (int j = i + 1; j < list.size(); j++) {
				if (tmp == list.get(j)) {
					return false;
				}
			}
		}
		return true;
	}

	/**
	 * 对生成的数进行大小排序
	 * 
	 * @author 杨朝敬
	 * @date 2015年9月29日
	 * @param list
	 * @return
	 */
	private List<Integer> sort(List<Integer> list) {
		int tmp = 0;
		for (int i = 0; i < list.size(); i++) {
			for (int j = i + 1; j < list.size(); j++) {
				if (list.get(i) > list.get(j)) {
					tmp = list.get(i);
					list.set(i, list.get(j));
					list.set(j, tmp);
				}
			}
		}
		return list;
	}

	/**
	 * 生成七区杀码的所有种类
	 * 
	 * @author 杨朝敬
	 * @date 2015年9月29日
	 * @return
	 */
	public List<List<Integer>> qiqu3ma() {
		Integer[] qu1 = { 1, 2, 3, 4, 5 };
		Integer[] qu2 = { 6, 7, 8, 9, 10 };
		Integer[] qu3 = { 11, 12, 13, 14, 15 };
		Integer[] qu4 = { 16, 17, 18, 19, 20 };
		Integer[] qu5 = { 21, 22, 23, 24, 25 };
		Integer[] qu6 = { 26, 27, 28, 29, 30 };
		Integer[] qu7 = { 31, 32, 33 };

		List<Integer[]> seven = new ArrayList<Integer[]>();
		seven.add(qu1);
		seven.add(qu2);
		seven.add(qu3);
		seven.add(qu4);
		seven.add(qu5);
		seven.add(qu6);
		seven.add(qu7);

		// 35种杀码的list
		List<List<Integer>> resList = new ArrayList<List<Integer>>();

		for (int i = 0; i < seven.size() - 2; i++) {
			for (int j = i + 1; j < seven.size() - 1; j++) {
				for (int k = j + 1; k < seven.size(); k++) {
					List<Integer> li = new ArrayList<Integer>();
					// 1
					for (int n = 0; n < seven.get(i).length; n++) {
						li.add(seven.get(i)[n]);
					}
					// 2
					for (int n = 0; n < seven.get(j).length; n++) {
						li.add(seven.get(j)[n]);
					}
					// 3
					for (int n = 0; n < seven.get(k).length; n++) {
						li.add(seven.get(k)[n]);
					}
					resList.add(li);
				}
			}
		}
		// System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		// System.out.println(resList);
		// System.out.println(resList.size());
		// System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
		return resList;
	}

	/**
	 * 七区杀码
	 * 
	 * @author 杨朝敬
	 * @date 2015年9月29日
	 * @param list
	 * @return
	 */
	public boolean isTorF1(List<Integer> list) {
		// 可调用生成七区杀码的所有种类的方法返回杀码数据
		// List<List<Integer>> resList = rt.qiqu3ma();

		// 1-5,6-10,11-15,16-20,21-25,26-30,31-33

		// 选其中3区

		for (int i = 0; i < list.size(); i++) {
			for (int j = 0; j < sha7.length; j++) {
				if (list.get(i) == sha7[j]) {
					return false;
				}
			}
		}

		return true;
	}

	/**
	 * 四区杀码
	 * 
	 * @author 杨朝敬
	 * @date 2015年9月29日
	 * @param list
	 * @return
	 */
	public boolean isTorF2(List<Integer> list) {
		// int[] qu1 = {1, 2, 3, 4, 5, 6, 7, 8};
		// int[] qu2 = {9, 10, 11, 12, 13, 14, 15, 16};
		// int[] qu3 = {18, 19, 20, 21, 22, 23, 24, 25};
		// int[] qu4 = {26, 27, 28, 29, 30, 31, 32, 33};
		// int el = 17;

		// 选其中一区
		for (int i = 0; i < list.size(); i++) {
			for (int j = 0; j < sha4.length; j++) {
				if (list.get(i) == sha4[j]) {
					return false;
				}
			}
		}

		return true;
	}

	/**
	 * 和值 初始为：80-120
	 * 
	 * @author 杨朝敬
	 * @date 2015年9月29日
	 * @param list
	 * @return
	 */
	public boolean isTorF3(List<Integer> list) {
		int total = 0;
		for (int i = 0; i < list.size(); i++) {
			total = total + list.get(i);
		}
		if (total <= 125 && total >= 80) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 大小比 一般维持在 3:3 ; 2:4 ; 4:2 。极少出现 1:5 ; 5:1
	 * 
	 * @author 杨朝敬
	 * @date 2015年9月29日
	 * @param list
	 * @return
	 */
	public boolean isTorF4(List<Integer> list) {
		int min = 0;
		int max = 0;
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i) <= 16) {
				min++;
			} else {
				max++;
			}
		}
		if (min <= 4 && max <= 4) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 奇偶比 一般维持在 3:3 ; 2:4 ; 4:2 。极少出现 1:5 ; 5:1
	 * 
	 * @author 杨朝敬
	 * @date 2015年9月29日
	 * @param list
	 * @return
	 */
	public boolean isTorF5(List<Integer> list) {
		int ji = 0;
		int ou = 0;
		for (int i = 0; i < list.size(); i++) {
			if ((list.get(i) % 2) != 0) {
				ji++;
			} else {
				ou++;
			}
		}
		if (ji <= 4 && ou <= 4) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 尾和 一般维持在 23-36 之间 极少出现 23 以下及 36 以上
	 * 
	 * @author 杨朝敬
	 * @date 2015年9月29日
	 * @param list
	 * @return
	 */
	public boolean isTorF6(List<Integer> list) {
		int weiTotal = 0;
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i) < 10) {
				weiTotal = weiTotal + list.get(i);
			} else {
				weiTotal = weiTotal + (list.get(i) % 10);
			}
		}
		if (weiTotal >= 23 && weiTotal <= 36) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 与上期结果对比，基本不出现超过 2 个数相同
	 * 
	 * @author 杨朝敬
	 * @date 2015年9月29日
	 * @param list
	 * @return
	 */
	public boolean isTorF7(List<Integer> list) {
		int count = 0;
		for (int i = 0; i < list.size(); i++) {
			for (int j = 0; j < pp.length; j++) {
				if (list.get(i) == pp[j]) {
					count++;
				}
			}
		}
		if (count > 2) {
			return false;
		} else {
			return true;
		}
	}

	/**
	 * 质数 基本维持在 1-2 个或 1-3 个，这里选取普遍的1-3 个 2,3,5,7,11,13,17,19,23,29,31
	 * 
	 * @author 杨朝敬
	 * @date 2015年9月29日
	 * @param list
	 * @return
	 */
	public boolean isTorF8(List<Integer> list) {
		int[] prime = { 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31 };
		int count = 0;
		for (int i = 0; i < list.size(); i++) {
			for (int j = 0; j < prime.length; j++) {
				if (list.get(i) == prime[j]) {
					count++;
				}
			}
		}
		if (count >= 1 && count <= 3) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 分四区发现规律，每期至少有连号8个不出的情况
	 * 
	 * @author 杨朝敬
	 * @date 2015年9月29日
	 * @param list
	 * @return
	 */
	public boolean isTorF9(List<Integer> list) {
		// 连号的出现次数
		int count = 0;
		for (int i = 0; i < list.size(); i++) {
			if (i == 0) {
				if ((list.get(i) - 1) > 8) {
					count++;
				}
			} else if (i == (list.size() - 1)) {
				if ((list.get(i) - list.get(i - 1)) > 8) {
					count++;
				} else if ((33 - list.get(i)) > 8) {
					count++;
				}
			} else {
				if ((list.get(i) - list.get(i - 1)) > 8) {
					count++;
				}
			}
		}
		if (count >= 1) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 根据四区，基本是每期至少有1区的数字是不会出现的 与isTorF9相似，但是isTorF9不分区段
	 * 
	 * @author 杨朝敬
	 * @date 2015年9月29日
	 * @param list
	 * @return
	 */
	public boolean isTorF10(List<Integer> list) {
		// 区段出现次数
		int count = 0;
		for (int i = 0; i < list.size(); i++) {
			// 第一位数
			// 1,8; 9,16; 18,25; 26,33
			if (i == 0) {
				if (list.get(i) > 8 && list.get(i) <= 16) {
					count = count + 1;
				} else if (list.get(i) > 16 && list.get(i) <= 25) {
					count = count + 2;
				} else if (list.get(i) > 25) {
					count = count + 3;
				}
			} else {
				if ((list.get(i - 1) >= 1 && list.get(i - 1) < 9 && list.get(i) > 16 && list.get(i) <= 25)
						|| (list.get(i - 1) >= 9 && list.get(i - 1) < 18 && list.get(i) > 25)) {
					count = count + 1;
				} else if ((list.get(i - 1) >= 1 && list.get(i - 1) < 9 && list.get(i) > 25)) {
					count = count + 2;
				}
				// 最后一位数
				if (i == (list.size() - 1)) {
					if (list.get(i) < 26 && list.get(i) >= 18) {
						count = count + 1;
					} else if (list.get(i) < 18 && list.get(i) >= 9) {
						count = count + 2;
					} else if (list.get(i) < 9) {
						count = count + 3;
					}
				}
			}
		}

		if (count >= 1) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 根据七区，基本是每期至少有3区的数字是不会出现的
	 * 
	 * @author 杨朝敬
	 * @date 2015年9月29日
	 * @param list
	 * @return
	 */
	public boolean isTorF11(List<Integer> list) {
		// 区段出现次数
		int count = 0;
		// 1,5; 6,10; 11,15; 16,20; 21,25; 26,30; 31,33
		for (int i = 0; i < list.size(); i++) {
			// 第一位数
			if (i == 0) {
				if (list.get(i) > 5 && list.get(i) <= 10) {
					count = count + 1;
				} else if (list.get(i) > 10 && list.get(i) <= 15) {
					count = count + 2;
				} else if (list.get(i) > 15 && list.get(i) <= 20) {
					count = count + 3;
				} else if (list.get(i) > 20 && list.get(i) <= 25) {
					count = count + 4;
				} else if (list.get(i) > 25) {
					count = count + 5;
				}
			} else {
				if ((list.get(i - 1) >= 1 && list.get(i - 1) < 6 && list.get(i) > 10 && list.get(i) <= 15)
						|| (list.get(i - 1) >= 6 && list.get(i - 1) < 11 && list.get(i) > 15 && list.get(i) <= 20)
						|| (list.get(i - 1) >= 11 && list.get(i - 1) < 16 && list.get(i) > 20 && list.get(i) <= 25)
						|| (list.get(i - 1) >= 16 && list.get(i - 1) < 21 && list.get(i) > 25 && list.get(i) <= 30)
						|| (list.get(i - 1) >= 21 && list.get(i - 1) < 26 && list.get(i) > 30)) {
					count = count + 1;
				} else if ((list.get(i - 1) >= 1 && list.get(i - 1) < 6 && list.get(i) > 15 && list.get(i) <= 20)
						|| (list.get(i - 1) >= 6 && list.get(i - 1) < 11 && list.get(i) > 20 && list.get(i) <= 25)
						|| (list.get(i - 1) >= 11 && list.get(i - 1) < 16 && list.get(i) > 25 && list.get(i) <= 30)
						|| (list.get(i - 1) >= 16 && list.get(i - 1) < 21 && list.get(i) > 30)) {
					count = count + 2;
				} else if ((list.get(i - 1) >= 1 && list.get(i - 1) < 6 && list.get(i) > 20 && list.get(i) <= 25)
						|| (list.get(i - 1) >= 6 && list.get(i - 1) < 11 && list.get(i) > 25 && list.get(i) <= 30)
						|| (list.get(i - 1) >= 11 && list.get(i - 1) < 16 && list.get(i) > 30)) {
					count = count + 3;
				} else if ((list.get(i - 1) >= 1 && list.get(i - 1) < 6 && list.get(i) > 25 && list.get(i) <= 30)
						|| (list.get(i - 1) >= 6 && list.get(i - 1) < 11 && list.get(i) > 30)) {
					count = count + 4;
				} else if ((list.get(i - 1) < 6 && list.get(i) > 30)) {
					count = count + 5;
				}
				// 最后一位数
				if (i == (list.size() - 1)) {
					if (list.get(i) < 31 && list.get(i) >= 26) {
						count = count + 1;
					} else if (list.get(i) < 26 && list.get(i) >= 21) {
						count = count + 2;
					} else if (list.get(i) < 21 && list.get(i) >= 16) {
						count = count + 3;
					} else if (list.get(i) < 16 && list.get(i) >= 11) {
						count = count + 4;
					} else if (list.get(i) < 11) {
						count = count + 5;
					}
				}
			}
		}

		if (count >= 3) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 17-33之间的数，基本上出现3-4个
	 * 
	 * @author 杨朝敬
	 * @date 2015年9月29日
	 * @param list
	 * @return
	 */
	public boolean isTorF12(List<Integer> list) {
		int count = 0;
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i) >= 17 && list.get(i) <= 33) {
				count = count + 1;
			}
		}
		if (count >= 3 && count <= 4) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 30-33之间的数，基本上出现0-1个
	 * 
	 * @author 杨朝敬
	 * @date 2015年9月29日
	 * @param list
	 * @return
	 */
	public boolean isTorF13(List<Integer> list) {
		int count = 0;
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i) >= 30 && list.get(i) <= 33) {
				count = count + 1;
			}
		}
		if (count >= 0 && count <= 1) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 每组数据，会出现相邻两个数的差值的绝对值为1-2
	 * 
	 * @author 杨朝敬
	 * @date 2015年9月29日
	 * @param list
	 * @return
	 */
	public boolean isTorF14(List<Integer> list) {
		for (int i = 0; i < list.size() - 1; i++) {
			if (list.get(i) - list.get(i + 1) == 1
					|| list.get(i) - list.get(i + 1) == -1) {
				return true;
			}
		}
		return false;
	}

	/**
	 * 其两个数相加，等于其当中的某一个数
	 * 
	 * @author 杨朝敬
	 * @date 2015年9月29日
	 * @param list
	 * @return
	 */
	public boolean isTorF15(List<Integer> list) {
		for (int i = 0; i < list.size() - 1; i++) {
			for (int j = i + 1; j < list.size() - 1; j++) {
				for (int k = 0; k < list.size(); k++) {
					if (list.get(i) + list.get(j) == list.get(k)) {
						return true;
					}
				}
			}
		}
		return false;
	}

	/**
	 * 6期没有出现的数据出现0-2次
	 * 
	 * @author 杨朝敬
	 * @date 2015年9月29日
	 * @param list
	 * @return
	 */
	public boolean isTorF16(List<Integer> list) {
		int count = 0;
		for (int i = 0; i < list.size(); i++) {
			for (int j = 0; j < yl6.length; j++) {
				if (list.get(i) == yl6[j]) {
					count++;
				}
			}
		}
		if (count >= 0 && count <= 4) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 6期出现的数据出现2-6次
	 * 
	 * @author 杨朝敬
	 * @date 2015年9月29日
	 * @param list
	 * @return
	 */
	public boolean isTorF17(List<Integer> list) {
		int count = 0;
		for (int i = 0; i < list.size(); i++) {
			for (int j = 0; j < cx6.length; j++) {
				if (list.get(i) == cx6[j]) {
					count++;
				}
			}
		}
		if (count >= 2 && count <= 6) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 六区杀码，每期至少有一区不会出现
	 * 
	 * @author 杨朝敬
	 * @date 2015年9月29日
	 * @param list
	 * @return
	 */
	public boolean isTorF18(List<Integer> list) {
		int count = 0;
		// 1,6; 7,12; 13,18; 19,24; 25,30; 31,33
		for (int i = 0; i < list.size(); i++) {
			// 第一位数
			if (i == 0) {
				if (list.get(i) > 6 && list.get(i) <= 12) {
					count = count + 1;
				} else if (list.get(i) > 12 && list.get(i) <= 18) {
					count = count + 2;
				} else if (list.get(i) > 18 && list.get(i) <= 24) {
					count = count + 3;
				} else if (list.get(i) > 24) {
					count = count + 4;
				}
			} else {
				if ((list.get(i - 1) >= 1 && list.get(i - 1) < 7 && list.get(i) > 12 && list.get(i) <= 18)
						|| (list.get(i - 1) >= 7 && list.get(i - 1) < 13 && list.get(i) > 18 && list.get(i) <= 24)
						|| (list.get(i - 1) >= 13 && list.get(i - 1) < 19 && list.get(i) > 24 && list.get(i) <= 30)
						|| (list.get(i - 1) >= 19 && list.get(i - 1) < 25 && list.get(i) > 30 && list.get(i) <= 33)) {
					count = count + 1;
				} else if ((list.get(i - 1) >= 1 && list.get(i - 1) < 7 && list.get(i) > 18 && list.get(i) <= 24)
						|| (list.get(i - 1) >= 7 && list.get(i - 1) < 13 && list.get(i) > 24 && list.get(i) <= 30)
						|| (list.get(i - 1) >= 13 && list.get(i - 1) < 19 && list.get(i) > 30 && list.get(i) <= 33)) {
					count = count + 2;
				} else if ((list.get(i - 1) >= 1 && list.get(i - 1) < 7 && list.get(i) > 24 && list.get(i) <= 30)
						|| (list.get(i - 1) >= 7 && list.get(i - 1) < 13 && list.get(i) > 30 && list.get(i) <= 33)) {
					count = count + 3;
				} else if ((list.get(i - 1) >= 1 && list.get(i - 1) < 7 && list.get(i) > 30 && list.get(i) <= 33)) {
					count = count + 4;
				}
				// 最后一位数
				if (i == (list.size() - 1)) {
					if (list.get(i) < 31 && list.get(i) >= 25) {
						count = count + 1;
					} else if (list.get(i) < 25 && list.get(i) >= 19) {
						count = count + 2;
					} else if (list.get(i) < 19 && list.get(i) >= 13) {
						count = count + 3;
					} else if (list.get(i) < 3 && list.get(i) >= 7) {
						count = count + 4;
					} else if (list.get(i) < 7) {
						count = count + 5;
					}
				}
			}
		}

		if (count >= 1) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 最大的数减最小的数，基本维持在大于20
	 * 
	 * @author 杨朝敬
	 * @date 2015年9月29日
	 * @param list
	 * @return
	 */
	public boolean isTorF19(List<Integer> list) {
		if (list.get(list.size() - 1) - list.get(0) >= 20) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 每个数除以3
	 * 
	 * @author 杨朝敬
	 * @date 2015年9月29日
	 * @param list
	 * @return
	 */
	public boolean isTorF20(List<Integer> list) {
		int y0 = 0;
		int y2 = 0;
		int y1 = 0;
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i) % 3 == 0) {
				y0 = y0 + 1;
			}
			if (list.get(i) % 3 == 1) {
				y1 = y1 + 1;
			}
			if (list.get(i) % 3 == 2) {
				y2 = y2 + 1;
			}
		}
		if (y0 != 0 && y1 != 0 && y2 != 0) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 外为数组1
	 * 
	 * @author 杨朝敬
	 * @date 2015年9月29日
	 * @param list
	 * @return
	 */
	public boolean isTorF21(List<Integer> list) {
		// 外为数组
		int s[] = { 1, 8, 15, 22, 29 };
		int count = 0;
		for (int i = 0; i < list.size(); i++) {
			for (int k = 0; k < s.length; k++) {
				if (list.get(i) == s[k]) {
					count++;
				}
			}
		}
		if (count >= 0 && count <= 3) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 外为数组2
	 * 
	 * @author 杨朝敬
	 * @date 2015年9月29日
	 * @param list
	 * @return
	 */
	public boolean isTorF22(List<Integer> list) {
		// 外为数组
		int s[] = { 6, 11, 16, 21, 26, 31 };
		int count = 0;
		for (int i = 0; i < list.size(); i++) {
			for (int k = 0; k < s.length; k++) {
				if (list.get(i) == s[k]) {
					count++;
				}
			}
		}
		if (count >= 0 && count <= 3) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 外为数组3
	 * 
	 * @author 杨朝敬
	 * @date 2015年9月29日
	 * @param list
	 * @return
	 */
	public boolean isTorF23(List<Integer> list) {
		// 外为数组
		int s[] = { 1, 2, 3, 4, 5, 6, 7, 13, 19, 25, 31, 32, 33, 12, 18, 24, 30 };
		int count = 0;
		for (int i = 0; i < list.size(); i++) {
			for (int k = 0; k < s.length; k++) {
				if (list.get(i) == s[k]) {
					count++;
				}
			}
		}
		if (count >= 2 && count <= 4) {
			return true;
		} else {
			return false;
		}
	}

}
