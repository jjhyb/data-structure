package com.yibo.datastructure.segmenttree;

import java.util.Arrays;

/**
 * @Author: huangyibo
 * @Date: 2020/9/2623:00
 * @Description:
 */
public class SegmentTree<E> {

    private E[] tree;//用数组表示线段树
    private E[] data;
    private Merger<E> merger;

    public SegmentTree(E[] arr, Merger<E> merger){
        this.merger = merger;
        data = (E[]) new Object[arr.length];
        for (int i = 0; i < arr.length; i++) {
            data[i] = arr[i];
        }
        //开辟线段树的空间
        tree = (E[]) new Object[4 * arr.length];
        buildSegmentTree(0,0,data.length-1);
    }

    //在treeIndex的位置创建表示区间[l...r]的线段树
    private void buildSegmentTree(int treeIndex,int l,int r){
        if(l == r){
            tree[treeIndex] = data[l];
            return;
        }
        int leftTreeIndex = leftChild(treeIndex);
        int rightTreeIndex = rightChild(treeIndex);

        int mid = l + (r - l) / 2;
        buildSegmentTree(leftTreeIndex,l,mid);
        buildSegmentTree(rightTreeIndex,mid+1,r);
        tree[treeIndex] = merger.merge(tree[leftTreeIndex],tree[rightTreeIndex]);
    }

    public int getSize(){
        return data.length;
    }

    public E get(int index){
        if(index < 0 || index >= data.length){
            throw new IllegalArgumentException("Index is illegal.");
        }
        return data[index];
    }

    //返回完全二叉树的数组表示中，一个索引所表示的元素的左孩子节点的索引
    private int leftChild(int index){
        return 2 * index + 1;
    }

    //返回完全二叉树的数组表示中，一个索引所表示的元素的右孩子节点的索引
    private int rightChild(int index){
        return 2 * index + 2;
    }

    //返回区间[queryL,queryR]的值
    public E query(int queryL, int queryR){
        if(queryL < 0 || queryL >= data.length ||
            queryR < 0 || queryR >= data.length || queryL > queryR){
            throw new IllegalArgumentException("Index is illegal.");
        }
        return query(0,0,data.length-1,queryL,queryR);
    }

    //在以TreeID为根的线段树中[l...r]的范围里，搜索区间[queryL...queryR]的值
    private E query(int treeIndex,int l, int r,int queryL, int queryR){
        if(l == queryL && r == queryR){
            return tree[treeIndex];
        }

        // treeIndex的节点分为[l...mid]和[mid+1...r]两部分
        int mid = l + (r - l) / 2;
        int leftTreeIndex = leftChild(treeIndex);
        int rightTreeIndex = rightChild(treeIndex);
        if(queryL >= mid + 1){
            return query(rightTreeIndex,mid+1,r,queryL,queryR);
        }else if(queryR <= mid){
            return query(leftTreeIndex,l,mid,queryL,queryR);
        }
        E leftResult = query(leftTreeIndex, l, mid, queryL, mid);
        E rightResult = query(rightTreeIndex,mid+1,r,mid+1,queryR);
        return merger.merge(leftResult,rightResult);
    }

    //将index位置的值更新为e
    public void set(int index,E e){
        if(index < 0 || index >= data.length){
            throw new IllegalArgumentException("Index is illegal.");
        }
        data[index] = e;
        set(0,0,data.length-1,index,e);
    }

    //在treeIndex为根的线段树中更新Index的值为e
    private void set(int treeIndex, int l, int r, int index, E e){
        if(l == r){
            tree[treeIndex] = e;
            return;
        }
        int mid = l + (r - l) / 2;
        int leftTreeIndex = leftChild(treeIndex);
        int rightTreeIndex = rightChild(treeIndex);
        if(index >= mid + 1){
            set(rightTreeIndex,mid + 1,r,index,e);
        }else {
            set(leftTreeIndex,l,mid,index,e);
        }
        tree[treeIndex] = merger.merge(tree[leftTreeIndex],tree[rightTreeIndex]);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < tree.length; i++) {
            if(tree[i] != null){
                sb.append(tree[i]);
            }else {
                sb.append("null");
            }
            if(i != tree.length - 1){
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
