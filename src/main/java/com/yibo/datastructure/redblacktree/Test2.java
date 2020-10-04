package com.yibo.datastructure.redblacktree;

import com.yibo.datastructure.set.FileOperation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * @Author: huangyibo
 * @Date: 2020/10/316:26
 * @Description:
 */
public class Test2 {

    public static void main(String[] args) {
        int n = 10000000;
        Random random = new Random();
        ArrayList<Integer> data = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            data.add(random.nextInt(Integer.MAX_VALUE));
        }

        testBinarySearchTree(data);
        testAVLTree(data);
        testRedBlackTree(data);
    }

    public static void testBinarySearchTree(ArrayList<Integer> data){
        //Test BinarySearchTree
        long startTime = System.nanoTime();
        BinarySearchTree<Integer,Integer> bst = new BinarySearchTree<>();
        data.forEach(e -> bst.add(e,null));
        long endTime = System.nanoTime();
        double time = (endTime - startTime) / 1000000000.0;
        System.out.println("BinarySearchTree : "+time+" s");
    }

    public static void testAVLTree(ArrayList<Integer> data){
        //Test AVLTree
        long startTime = System.nanoTime();
        AVLTree<Integer,Integer> avlTree = new AVLTree<>();
        data.forEach(e -> avlTree.add(e,null));
        long endTime = System.nanoTime();
        double time = (endTime - startTime) / 1000000000.0;
        System.out.println("AVLTree : "+time+" s");
    }

    public static void testRedBlackTree(ArrayList<Integer> data){
        //Test RedBlackTree
        long startTime = System.nanoTime();
        RedBlackTree<Integer,Integer> redBlackTree = new RedBlackTree<>();
        data.forEach(e -> redBlackTree.add(e,null));
        long endTime = System.nanoTime();
        double time = (endTime - startTime) / 1000000000.0;
        System.out.println("RedBlackTree : "+time+" s");
    }
}
