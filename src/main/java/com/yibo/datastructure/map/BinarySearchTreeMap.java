package com.yibo.datastructure.map;

import com.yibo.datastructure.set.BinarySearchTree;
import com.yibo.datastructure.set.FileOperation;

import java.util.ArrayList;

/**
 * @Author: huangyibo
 * @Date: 2020/9/2422:24
 * @Description:
 */
public class BinarySearchTreeMap<K extends Comparable<K>, V> implements Map<K, V> {

    private class Node{
        public K key;
        public V value;
        public Node left, right;

        public Node(K key,V value){
            this.key = key;
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }

    private Node root;
    private int size;

    public BinarySearchTreeMap(){
        root = null;
        size = 0;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    //向二分搜索树中添加新的元素(key,value)
    @Override
    public void add(K key, V value) {
        root = add(root,key,value);
    }
    //向以node为根的二分搜索树中插入元素(key,value)，递归算法
    //返回插入新节点后二分搜索树的根
    private Node add(Node node, K key, V value){
        if(node == null){
            size++;
            return new Node(key,value);
        }

        if(key.compareTo(node.key) < 0){
            node.left = add(node.left,key,value);
        }else if(key.compareTo(node.key) > 0){
            node.right = add(node.right,key,value);
        }else {
            node.value = value;
        }
        return node;
    }

    //返回以Node为根节点的二分搜索树中，key所在的节点
    private Node getNode(Node node,K key){
        if(node == null){
            return null;
        }
        if(key.compareTo(node.key) < 0){
            return getNode(node.left,key);
        }else if(key.compareTo(node.key) > 0){
            return getNode(node.right,key);
        }else{
            return node;
        }
    }

    @Override
    public boolean contains(K key) {
        return getNode(root,key) != null;
    }

    @Override
    public V get(K key) {
        Node node = getNode(root, key);
        return node == null ? null : node.value;
    }

    @Override
    public void set(K key, V value) {
        Node node = getNode(root, key);
        if(node == null){
            throw new IllegalArgumentException(key + " doesn't exist!");
        }
        node.value = value;
    }

    //删除掉以Node为根的二分搜索树中的最小节点
    //返回删除节点后新的二分搜索树的根
    private Node removeMin(Node node){
        if(node.left == null){
            Node rightNode = node.right;
            node.right = null;
            size--;
            return rightNode;
        }
        node.left = removeMin(node.left);
        return node;
    }

    //返回以node为根的二分搜索树的最小值所在的节点
    private Node minimum(Node node){
        if(node.left == null){
            return node;
        }
        return minimum(node.left);
    }

    //从二分搜索树中删除元素为key的节点
    @Override
    public V remove(K key){
        Node node = getNode(root, key);
        if(node != null){
            root = remove(root,key);
            return node.value;
        }
        return null;
    }
    //删除掉以Node为根的二分搜索树中键为key的节点，递归算法
    //返回删除节点后新的二分搜索树的根
    private Node remove(Node node, K key){
        if(node == null){
            return null;
        }
        if(key.compareTo(node.key) < 0){
            node.left = remove(node.left,key);
            return node;
        }else if(key.compareTo(node.key) > 0){
            node.right = remove(node.right,key);
            return node;
        }else{//e.compareTo(node.e) == 0
            //待删除节点左子树为空的情况
            if(node.left == null){
                Node rightNode = node.right;
                node.right = null;
                size--;
                return rightNode;
            }
            //待删除节点右子树为空的情况
            if(node.right == null){
                Node leftNode = node.left;
                node.left = null;
                size--;
                return leftNode;
            }
            //待删除节点左右子树均不为空的情况
            //找到比待删除节点大的最小节点，即待删除节点右子树的最小节点
            //用这个节点顶替待删除节点
            Node successor = minimum(node.right);
            successor.right = removeMin(node.right);
            successor.left = node.left;
            node.left = node.right = null;
            return successor;
        }
    }

    public static void main(String[] args) {
        System.out.println("Pride and Prejudice");
        ArrayList<String> words1 = new ArrayList<String>();
        if(FileOperation.readFile("E:\\project\\data-structure\\src\\main\\resources\\set\\pride-and-prejudice.txt",words1)){
            System.out.println("Total words: " + words1.size());

            BinarySearchTreeMap<String,Integer> binarySearchTreeMap = new BinarySearchTreeMap<>();
            words1.forEach(word -> {
                if(binarySearchTreeMap.contains(word)){
                    binarySearchTreeMap.set(word,binarySearchTreeMap.get(word)+1);
                }else {
                    binarySearchTreeMap.add(word,1);
                }
            });
            System.out.println("Total different words: " + binarySearchTreeMap.getSize());
            System.out.println("Frequency  of pride: " + binarySearchTreeMap.get("pride"));
            System.out.println("Frequency  of prejudice: " + binarySearchTreeMap.get("prejudice"));
        }
    }
}
