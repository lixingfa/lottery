package com.util;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
//  组合算法    
//    本程序的思路是开一个数组，其下标表示1到m个数，数组元素的值为1表示其下标    
//    代表的数被选中，为0则没选中。      
//    首先初始化，将数组前n个元素置1，表示第一个组合为前n个数。      
//    然后从左到右扫描数组元素值的“10”组合，找到第一个“10”组合后将其变为    
//    “01”组合，同时将其左边的所有“1”全部移动到数组的最左端。      
//    当第一个“1”移动到数组的m-n的位置，即n个“1”全部移动到最右端时，就得    
//    到了最后一个组合。      
//    例如求5中选3的组合：      
//    1   1   1   0   0   //1,2,3      
//    1   1   0   1   0   //1,2,4      
//    1   0   1   1   0   //1,3,4      
//    0   1   1   1   0   //2,3,4      
//    1   1   0   0   1   //1,2,5      
//    1   0   1   0   1   //1,3,5      
//    0   1   1   0   1   //2,3,5      
//    1   0   0   1   1   //1,4,5      
//    0   1   0   1   1   //2,4,5      
//    0   0   1   1   1   //3,4,5    

public class Combine {
	/**  
	     * 从n个数字中选择m个数字  
	     * @param a  
	     * @param m  选取的数量
	     * @return  所有组合
	     */   
	    public static List<Set<Integer>> getAllCombine(Integer[] a,int m){
	        int n = a.length;   
	        if(m > n){   
	            System.out.println("错误！数组a中只有"+n+"个元素。"+m+"大于"+2+"!!!");
	            return null;
	        }   
	           
	        List<Set<Integer>> result = new ArrayList<Set<Integer>>();   
	        //选中标识数组
	        Integer[] bs = new Integer[n];   
	        for(int i = 0;i < n;i++){   
	            bs[i] = 0;   
	        }   
	        //初始化，前面几个默认选择
	        for(int i = 0;i < m;i++){   
	            bs[i]=1;   
	        }   
	        boolean flag = true;   
	        boolean tempFlag = false;   
	        int pos = 0;   
	        int sum = 0;   
	        do{   
	            sum = 0;   
	            pos = 0;   
	            tempFlag = true;    
	            //首先找到第一个合   
	            result.add(getNowCombine(bs,a,m));   
	            //临界点
	            for(int i=0;i<n-1;i++){   
	                if(bs[i] == 1 && bs[i+1] == 0 ){
	                    bs[i]=0;   
	                    bs[i+1]=1;   
	                    pos = i;   
	                    break;   
	                }   
	            }   
	            //将左边的1全部移动到数组的最左边  	               
	            for(int i=0;i < pos;i++){   
	                if(bs[i] == 1){   
	                    sum++;   
	                }   
	            }   
	            for(int i = 0;i < pos;i++){   
	                if(i < sum){   
	                    bs[i] = 1;   
	                }else{   
	                    bs[i] = 0;   
	                }   
	            }	               
	            //检查是否所有的1都移动到了最右边   
	            for(int i = n-m;i < n;i++){   
	                if(bs[i] == 0){   
	                    tempFlag = false;   
	                    break;   
	                }   
	            }   
	            if(tempFlag == false){   
	                flag = true;   
	            }else{   
	                flag = false;   
	            }   
	               
	        }while(flag);   
	        result.add(getNowCombine(bs,a,m));   
	           
	        return result;   
	    }   
	    
	    /**获取当前组合，1表示选中*/
	    private static Set<Integer> getNowCombine(Integer[] bs,Integer[] a,int m){
	    	Set<Integer> result = new HashSet<Integer>();
	    	for(int i = 0;i < bs.length; i++){
	    		if(bs[i] == 1){
	    			result.add(a[i]);
	    		}
	    	}
	    	return result ;
	    }
	    
	    /**
	     * getRandomCombine:(从数组中随机获取一个长度为m的子集)
	     * @author lixingfa
	     * @date 2018年12月17日下午4:03:34
	     * @param a 可选取的数组
	     * @param m 子集的长度
	     * @return 子集
	     */
	    public static Integer[] getRandomCombine(Integer[] a,int m){
	    	List<Integer> sub = new ArrayList<Integer>(m);
	    	int index = m - 1;
	    	while (true) {
				int temp = a[(int)(Math.random() * a.length)];
				if (!sub.contains(temp)) {
					sub.add(temp);
					index--;
					if (index < 0) {
						break;
					}
				}
			}	    	
	    	return sub.toArray(new Integer[]{});
	    }
	    
	    	
	    public static void main(String[] args) {
		    Integer[] scope = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33};
//			getAllCombine(scope, 6);
	    	getRandomCombine(scope, 6);
		}
}
