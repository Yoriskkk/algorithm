package com.algorithm.trie;

import java.util.TreeMap;

public class Trie {

    private class Node {
        //是否是一个单词
        private boolean isWord;
        //字典树中，一个节点对应多个节点
        private TreeMap<Character, Node> next;

        public Node(boolean isWord) {
            this.isWord = isWord;
            next = new TreeMap<Character, Node>();
        }

        //大部分节点
        public Node() {
            this(false);
        }
    }

    private Node root;
    private int size;

    public Trie() {
        root = new Node();
        size = 0;
    }

    //获取字典树中的单词数量
    public int getSize() {
        return size;
    }

    //往trie树中添加一个单词,非递归写法
    public void add(String word) {
        Node cur = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (cur.next.get(c) == null) {
                cur.next.put(c, new Node());
            }
            cur = cur.next.get(c);
        }
        if (!cur.isWord) {
            cur.isWord = true;
            size++;
        }
    }

    //查询trie树中是否包含单词word
    public boolean contains(String word){
        Node cur = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if(cur.next.get(c) != null){
                cur = cur.next.get(c);
            }else {
                return false;
            }
        }
        return cur.isWord;
    }

    //查看单词是否是trie树中的前缀
    public boolean isPrefix(String word){

        Node cur = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if(cur.next.get(c) == null){
                return false;
            }else {
                cur = cur.next.get(c);
            }
        }
        return true;

    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.add("Hello");
        trie.add("Help");
        trie.contains("Help");
        System.out.println(trie.toString());
    }

}
