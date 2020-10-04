package com.yibo.datastructure.maxheap;

import com.yibo.datastructure.array.Array;

/**
 * @Author: huangyibo
 * @Date: 2020/9/261:31
 * @Description:
 */

public class MaxHeap<E extends Comparable<E>> {

    private Array<E> data;

    public MaxHeap(){
        data = new Array<>();
    }

    public MaxHeap(int capacity){
        data = new Array<>(capacity);
    }

    public MaxHeap(E[] arr){
        data = new Array<>(arr);
        for (int i = parent(arr.length-1) ; i >= 0;i--){
            siftDown(i);
        }
    }

    //返回堆中的元素个数
    public int size(){
        return data.getSize();
    }

    //返回一个布尔值，标识堆中是否为空
    public boolean isEmpty(){
        return data.isEmpty();
    }

    //返回完全二叉树的数组表示中，一个索引所表示的元素的父亲节点的索引
    private int parent(int index){
        if(index == 0){
            throw new IllegalArgumentException("index-0 doesn't have parent.");
        }
        return (index - 1) / 2;
    }

    //返回完全二叉树的数组表示中，一个索引所表示的元素的左孩子节点的索引
    private int leftChild(int index){
        return index * 2 + 1;
    }

    //返回完全二叉树的数组表示中，一个索引所表示的元素的右孩子节点的索引
    private int rightChild(int index){
        return index * 2 + 2;
    }

    //向堆中添加元素
    public void add(E e){
        data.addLast(e);
        siftUp(data.getSize()-1);
    }

    private void siftUp(int k) {
        while(k > 0 && data.get(parent(k)).compareTo(data.get(k)) < 0){
            data.swap(k,parent(k));
            k = parent(k);
        }
    }

    //看堆中最大元素
    public E findMax(){
        if(data.getSize() == 0){
            throw new IllegalArgumentException("Can not findMax when heap is empty.");
        }
        return data.get(0);
    }

    //取出堆中最大元素
    public E extractMax(){
        E ret = findMax();
        data.swap(0,data.getSize() - 1);
        data.removeLast();
        siftDown(0);
        return ret;
    }

    private void siftDown(int k){
        //如果节点k的左孩子的索引比data的总数还大就停止循环
        while(leftChild(k) < data.getSize()){
            int j = leftChild(k);
            //如果存在右孩子，并且右孩子比左孩子大
            if(j + 1 <  data.getSize() && data.get(j+1).compareTo(data.get(j)) > 0){
                j = rightChild(k);
            }
            //data[j]是leftChild和rightChild中的最大值
            if(data.get(k).compareTo(data.get(j)) >= 0){
                break;
            }
            data.swap(k, j);
            k = j;
        }
    }

    //取出堆中的最大元素，并替换成元素E
    public E replace(E e){
        E ret = findMax();
        data.set(0, e);
        //堆顶的元素有可能不是最大的
        siftDown(0);
        return ret;
    }
}
