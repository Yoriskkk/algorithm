package com.algorithm.trie;

import java.util.TreeMap;

/**
 * 字典树实现
 */
public class Trie {

    private class Node{

        private boolean isWord;
        private TreeMap<Character,Node> next;

        public Node(){
            isWord = false;
            next = new TreeMap<Character, Node>();
        }
    }

    private Node root;
    private int size;

    public Trie(){
        root = new Node();
        size = 0;
    }
    /**
     * 添加单词
     * @param word
     */
    public void add(String word){
        Node node = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if(node.next.get(c) == null){
                node.next.put(c,new Node());
            }
            node = node.next.get(c);
        }
        if(!node.isWord){
            node.isWord = true;
            size++;
        }
    }

    /**
     * 判断一个单词是否在这个trie树里面
     * @return
     */
    public boolean contains(String word){

        Node node = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if(node.next.get(c)==null){
                return false;
            }else {
                node = node.next.get(c);
            }
        }
        return node.isWord;
    }

    /**
     * 判断这个单词是否是trie树的前缀
     * @return
     */
    public boolean isPrefix(String word){
        Node node = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if(node.next.get(c)==null){
                return false;
            }else {
                node = node.next.get(c);
            }
        }
        return true;
    }

}
