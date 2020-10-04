package com.yibo.datastructure.map;

import com.yibo.datastructure.avltree.AVLTree;

/**
 * @Author: huangyibo
 * @Date: 2020/10/221:20
 * @Description:
 */
public class AVLMap<K extends Comparable<K>, V> implements Map<K, V> {

    private AVLTree<K, V> avlTree;

    public AVLMap(){
        avlTree = new AVLTree<>();
    }

    @Override
    public int getSize() {
        return avlTree.getSize();
    }

    @Override
    public boolean isEmpty() {
        return avlTree.isEmpty();
    }

    @Override
    public void add(K key, V value) {
        avlTree.add(key,value);
    }

    @Override
    public boolean contains(K key) {
        return avlTree.contains(key);
    }

    @Override
    public V get(K key) {
        return avlTree.get(key);
    }

    @Override
    public V remove(K key) {
        return avlTree.remove(key);
    }

    @Override
    public void set(K key, V value) {
        avlTree.set(key,value);
    }

}
