package com.guoan.myapplication;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;

/**
 * USER: 张军伟
 * DATA: 2017/12/29 0029
 * TIME: 下午 3:17
 */

public class CollectionUtil {
    /**
     * 不允许实例化
     */
    private CollectionUtil() {
    }

    /**
     *  获取两个集合的不同元素
     * @param collmax
     * @param collmin
     * @return
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public static Collection getDiffent(Collection collmax,Collection collmin)
    {
        //使用LinkeList防止差异过大时,元素拷贝
        Collection csReturn = new LinkedList();
        Collection max = collmax;
        Collection min = collmin;
        //先比较大小,这样会减少后续map的if判断次数
        if(collmax.size()<collmin.size())
        {
            max = collmin;
            min = collmax;
        }
        //直接指定大小,防止再散列
        Map<Object,Integer> map = new HashMap<Object,Integer>(max.size());
        for (Object object : max) {
            map.put(object, 1);
        }
        for (Object object : min) {
            if(map.get(object)==null)
            {
                csReturn.add(object);
            }else{
                map.put(object, 2);
            }
        }
        for (Map.Entry<Object, Integer> entry : map.entrySet()) {
            if(entry.getValue()==1)
            {
                csReturn.add(entry.getKey());
            }
        }
        return csReturn;



        /**
         * 获取两个List的不同元素
         * @param list1
         * @param list2
         * @return
         */
//        private static List<String> getDiffrent5(List<String> list1, List<String> list2) {
//        long st = System.nanoTime();
//        List<String> diff = new ArrayList<String>();
//        List<String> maxList = list1;
//        List<String> minList = list2;
//        if(list2.size()>list1.size())
//        {
//            maxList = list2;
//            minList = list1;
//        }
//        Map<String,Integer> map = new HashMap<String,Integer>(maxList.size());
//        for (String string : maxList) {
//            map.put(string, 1);
//        }
//        for (String string : minList) {
//            if(map.get(string)!=null)
//            {
//                map.put(string, 2);
//                continue;
//            }
//            diff.add(string);
//        }
//        for(Map.Entry<String, Integer> entry:map.entrySet())
//        {
//            if(entry.getValue()==1)
//            {
//                diff.add(entry.getKey());
//            }
//        }
//        System.out.println("getDiffrent5 total times "+(System.nanoTime()-st));
//        return diff;
//
//    }
    }
    /**
     *  获取两个集合的不同元素,去除重复
     * @param collmax
     * @param collmin
     * @return
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public static Collection getDiffentNoDuplicate (Collection collmax, Collection collmin)
    {
        return new HashSet(getDiffent(collmax, collmin));
    }
}
