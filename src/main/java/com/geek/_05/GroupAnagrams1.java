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
public class GroupAnagrams1 {

    /**
     * 对其中的每一个字符进行排序
     * 将排序后的字符串作为map的key
     * 如果map.get(key) == null,那么new一个list添加原字符串
     * 如果map.get(key) != null,那么就取出对应的value，然后将原字符串add近该value，然后再put回去
     * @param strs
     * @return
     */
    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key =  new String(chars);
            List<String> list = map.getOrDefault(key, new ArrayList<String>());
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
