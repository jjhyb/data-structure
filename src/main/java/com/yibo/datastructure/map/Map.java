package com.yibo.datastructure.map;

/**
 * @Author: huangyibo
 * @Date: 2020/9/241:32
 * @Description:
 */
public interface Map<K, V> {

    void add(K key, V value);

    V remove(K key);

    boolean contains(K key);

    V get(K key);

    void set(K key,V value);

    int getSize();

    boolean isEmpty();
}
