package com.yibo.datastructure.trie;

import java.util.TreeMap;

/**
 * @Author: huangyibo
 * @Date: 2020/9/300:30
 * @Description:
 */
public class Trie {

    private class Node{

        public boolean isWord;

        public TreeMap<Character,Node> next;

        public Node(){
            this(false);
        }

        public Node(boolean isWord){
            this.isWord = isWord;
            next = new TreeMap<>();
        }
    }

    private Node root;

    private int size;

    public Trie(){
        root = new Node();
        size = 0;
    }

    //获得Trie中存储的单词数量
    public int getSize(){
        return size;
    }

    //向Trie中添加一个新的单词word
    public void add(String word){
        Node cur = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if(cur.next.get(ch) == null){
                cur.next.put(ch,new Node());
            }
            cur = cur.next.get(ch);
        }
        if(!cur.isWord){
            cur.isWord = true;
            size++;
        }
    }

    //查询单词word是否在Trie中
    public boolean contains(String word){
        Node cur = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if(cur.next.get(ch) == null){
                return false;
            }
            cur = cur.next.get(ch);
        }
        return cur.isWord;
    }

    //查询是否在Trie中有单词以prefix为前缀
    public boolean isPrefix(String prefix){
        Node cur = root;
        for (int i = 0; i < prefix.length(); i++) {
            char ch = prefix.charAt(i);
            if(cur.next.get(ch) == null){
                return false;
            }
            cur = cur.next.get(ch);
        }
        return true;
    }


}
