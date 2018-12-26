/**
 * 
 */
package com.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.Map.Entry;
/**
 * @author lixingfa
 * @date 2018年12月26日下午5:11:16
 * 
 */
public class MapUtil {

	/**
	 * sortMapByKey:(按键的大小排序)
	 * @author lixingfa
	 * @date 2018年12月26日下午4:43:38
	 * @param map
	 * @return
	 */
	public static Map<Double, Integer> sortMapByKey(Map<Double, Integer> map) {
        if (map == null || map.isEmpty()) {
            return null;
        }
        Map<Double, Integer> sortMap = new TreeMap<Double, Integer>(new MapKeyComparator());
        sortMap.putAll(map);
        return sortMap;
    }

	/**
     * 使用 Map按value进行排序
     * @param map
     * @return
     */
    public static Map<Integer, Integer> sortMapByValue(Map<Integer, Integer> oriMap) {
        if (oriMap == null || oriMap.isEmpty()) {
            return null;
        }
        Map<Integer, Integer> sortedMap = new LinkedHashMap<Integer, Integer>();
        List<Map.Entry<Integer, Integer>> entryList = new ArrayList<Map.Entry<Integer, Integer>>(
                oriMap.entrySet());
        Collections.sort(entryList, new MapValueComparator());

        Iterator<Map.Entry<Integer, Integer>> iter = entryList.iterator();
        Map.Entry<Integer, Integer> tmpEntry = null;
        while (iter.hasNext()) {
            tmpEntry = iter.next();
            sortedMap.put(tmpEntry.getKey(), tmpEntry.getValue());
        }
        return sortedMap;
    }

	
	private static class MapKeyComparator implements Comparator<Double>{
	    @Override
	    public int compare(Double str1, Double str2) {	        
	        return str1.compareTo(str2);
	    }
	}
	
	private static class MapValueComparator implements Comparator<Map.Entry<Integer, Integer>> {

	    @Override
	    public int compare(Entry<Integer, Integer> me1, Entry<Integer, Integer> me2) {

	        return me1.getValue().compareTo(me2.getValue());
	    }
	}
}
