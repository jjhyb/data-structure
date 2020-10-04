package com.yibo.datastructure.trie;

import java.util.HashMap;
import java.util.TreeMap;

/**
 * @Author: huangyibo
 * @Date: 2020/10/115:23
 * @Description:
 *
 * 677. 键值映射
 * 实现一个 MapSum 类里的两个方法，insert 和 sum。
 *
 * 对于方法 insert，你将得到一对（字符串，整数）的键值对。字符串表示键，整数表示值。如果键已经存在，那么原来的键值对将被替代成新的键值对。
 *
 * 对于方法 sum，你将得到一个表示前缀的字符串，你需要返回所有以该前缀开头的键的值的总和。
 *
 * 示例 1:
 * 输入: insert("apple", 3), 输出: Null
 * 输入: sum("ap"), 输出: 3
 * 输入: insert("app", 2), 输出: Null
 * 输入: sum("ap"), 输出: 5
 */
public class MapSum2 {

    private class Node{
        public int value;

        public TreeMap<Character,Node> next;

        public Node(){
            this(0);
        }

        public Node(int value){
            this.value = value;
            next = new TreeMap<>();
        }
    }

    private Node root;

    /** Initialize your data structure here. */
    public MapSum2() {
        root = new Node();
    }

    public void insert(String key, int val) {
        Node cur = root;
        for (int i = 0; i < key.length(); i++) {
            char ch = key.charAt(i);
            if(cur.next.get(ch) == null){
                cur.next.put(ch,new Node());
            }
            cur = cur.next.get(ch);
        }
        cur.value = val;
    }

    public int sum(String prefix) {
        Node cur = root;
        for (int i = 0; i < prefix.length(); i++) {
            char ch = prefix.charAt(i);
            if(cur.next.get(ch) == null){
                return 0;
            }
            cur = cur.next.get(ch);
        }
        return sum(cur);
    }

    private int sum(Node node){
        int res = node.value;
        for (Character ch : node.next.keySet()) {
            res += sum(node.next.get(ch));
        }
        return res;
    }
}

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */