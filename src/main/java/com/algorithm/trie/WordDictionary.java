package com.algorithm.trie;

import java.util.TreeMap;

class WordDictionary {

    private static class Node{

        private boolean isWord;
        private TreeMap<Character,Node> next;

        public Node(){
            isWord = false;
            next = new TreeMap<Character, Node>();
        }

    }

    private static Node root;


    /** Initialize your data structure here. */
    public WordDictionary() {
        root = new Node();
    }

    /** Adds a word into the data structure. */
    public static void addWord(String word) {
        Node cur = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if(cur.next.get(c) == null){
                cur.next.put(c,new Node());
            }else {
                cur = cur.next.get(c);
            }
        }
        cur.isWord = true;
    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public static boolean search(String word) {
        return match(word,root,0);
    }

    private static boolean match(String word, Node node, int index) {

        if(index == word.length()){
            return node.isWord;
        }
        char c = word.charAt(index);
        if(c != '.'){
            if(node.next.get(c) == null){
                return false;
            }
            return match(word,node.next.get(c),index+1);
        }else {
            for (char key : node.next.keySet()){
                if(match(word,node.next.get(key),index+1)){
                    return true;
                }
            }
            return false;
        }
    }

    public static void main(String[] args) {

        String[] arrStr = new String[]{"WordDictionary","addWord","addWord","addWord","search","search","search","search"};
        WordDictionary wordDictionary = new WordDictionary();
        for (String word : arrStr){
            wordDictionary.addWord(word);
        }
        String str =".ad";
        boolean search = search(str);
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */