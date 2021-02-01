package com.geek._05;

import java.util.*;

/**
 * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"]
 * 输出:
 * [
 *   ["ate","eat","tea"],
 *   ["nat","tan"],
 *   ["bat"]
 * ]
 */
public class GroupAnagrams {

    /**
     * 暴力求解
     * 对每一个字符串进行排序
     * 将排序后的字符串作为map的key
     *      如果map.get(key) == null,就new 一个list，然后将该未排序的字符串添加到list中去，再map.put
     *      如果map.get(key) != null，就取出来list，然后add当前的字符串
     * 最后将map的value值放入list中
     * @param strs
     * @return
     */
    public static List<List<String>> groupAnagrams(String[] strs) {

        Map<String,List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            List<String> list = map.getOrDefault(key,new ArrayList<String>());
            list.add(str);
            map.put(key,list);
        }
        return new ArrayList<List<String>>(map.values());

    }

    public static void test(){
        Map<String, Integer> map = new HashMap<>();
        map.put("a", null);
        map.put("b", 2);
        map.put("c", 3);
        System.out.println(map.getOrDefault("a", 100));
        System.out.println(map.getOrDefault("d", 200));
    }

    public static void main(String[] args) {
        String[] arr = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        groupAnagrams(arr);
        test();
    }
}
