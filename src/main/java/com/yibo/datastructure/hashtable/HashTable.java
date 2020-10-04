package com.yibo.datastructure.hashtable;

import java.util.TreeMap;

/**
 * @Author: huangyibo
 * @Date: 2020/10/319:05
 * @Description:
 */
public class HashTable<K, V> {

    private static final int[] capacity = {53,97,193,389,769,1543,3079,6151,12289,24593,
                                        49157,98317,196613,393241,786433,1572869,3145793,
                                        6291469,12582917,25165843,50331653,100663319,
                                        201326611,402653189,805306457,1610612741};
    private static final int upperTol = 10;
    private static final int lowerTol = 2;
    private static int capacityIndex = 0;
    private TreeMap<K,V>[] hashtable;
    private int M;
    private int size;

    public HashTable(){
        this(capacity[capacityIndex]);
    }

    public HashTable(int M){
        this.M = M;
        size = 0;
        hashtable = new TreeMap[M];
        for (int i = 0; i < M; i++) {
            hashtable[i] = new TreeMap<>();
        }
    }

    private int hash(K key){
        return (key.hashCode() & 0x7fffffff) % M;
    }

    public int getSize(){
        return size;
    }

    public void add(K key, V value){
        TreeMap<K, V> treeMap = hashtable[hash(key)];
        if(treeMap.containsKey(key)){
            treeMap.put(key,value);
        }else {
            treeMap.put(key,value);
            size++;
            if(size >= upperTol * M && capacityIndex + 1 <capacity.length){
                capacityIndex++;
                resize(capacity[capacityIndex]);
            }
        }
    }

    public V remove(K key){
        TreeMap<K, V> treeMap = hashtable[hash(key)];
        V res = null;
        if(treeMap.containsKey(key)){
            size --;
            res = treeMap.remove(key);
            if(size < lowerTol * M && capacityIndex - 1 >= 0){
                capacityIndex --;
                resize(capacity[capacityIndex]);
            }
        }
        return res;
    }

    public void set(K key,V value){
        TreeMap<K, V> treeMap = hashtable[hash(key)];
        if(!treeMap.containsKey(key)){
            throw new IllegalArgumentException(key + " doesn't exist!");
        }
        treeMap.put(key,value);
    }

    public boolean contains(K key){
        return hashtable[hash(key)].containsKey(key);
    }

    public V get(K key){
        return hashtable[hash(key)].get(key);
    }

    private void resize(int newM){
        TreeMap<K, V>[] newHashTable = new TreeMap[newM];
        for (int i = 0; i < newM; i++) {
            newHashTable[i] = new TreeMap<>();
        }
        this.M = newM;
        for (int i = 0; i < hashtable.length; i++) {
            TreeMap<K, V> treeMap = hashtable[i];
            treeMap.forEach((key,value) -> {
                newHashTable[hash(key)].put(key,value);
            });
        }
        this.hashtable = newHashTable;
    }
}
