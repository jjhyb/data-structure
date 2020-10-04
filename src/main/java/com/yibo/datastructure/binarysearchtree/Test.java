package com.yibo.datastructure.binarysearchtree;

import java.util.ArrayList;
import java.util.Random;

/**
 * @Author: huangyibo
 * @Date: 2020/9/2221:21
 * @Description:
 */
public class Test {

    public static void main(String[] args) {
//        test1();
//        testRemoveMin();
//        testRemoveMax();

        BinarySearchTree<Integer> bst = new BinarySearchTree<Integer>();
        int[] nums = {5,3,6,8,4,2};
        for(int num : nums){
            bst.add(num);
        }
        bst.preOrder();
        System.out.println("------------------------------------------------");
        bst.remove(5);
        bst.preOrder();
    }

    private static void testRemoveMax() {
        BinarySearchTree<Integer> bst = new BinarySearchTree<Integer>();
        int n = 1000;
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            bst.add(random.nextInt(10000));
        }
        ArrayList<Integer> nums= new ArrayList<Integer>();
        while (!bst.isEmpty()){
            nums.add(bst.removeMax());
        }
        System.out.println(nums);
        for (int i = 1; i < nums.size(); i++) {
            if(nums.get(i) > nums.get(i - 1)){
                throw new IllegalArgumentException("error");
            }
        }
        System.out.println("removeMax test completed.");
    }

    private static void testRemoveMin() {
        BinarySearchTree<Integer> bst = new BinarySearchTree<Integer>();
        int n = 1000;
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            bst.add(random.nextInt(10000));
        }
        ArrayList<Integer> nums= new ArrayList<Integer>();
        while (!bst.isEmpty()){
            nums.add(bst.removeMin());
        }
        System.out.println(nums);
        for (int i = 1; i < nums.size(); i++) {
            if(nums.get(i) < nums.get(i - 1)){
                throw new IllegalArgumentException("error");
            }
        }
        System.out.println("removeMin test completed.");
    }

    private static void test1() {
        BinarySearchTree<Integer> bst = new BinarySearchTree<Integer>();
        int[] nums = {5,3,6,8,4,2};
        for(int num : nums){
            bst.add(num);
        }
        bst.preOrder();
        System.out.println("------------------------------------------------");
        bst.preOrderNR();
        System.out.println("------------------------------------------------");
        bst.inOrder();
        System.out.println("------------------------------------------------");
        bst.postOrder();

        System.out.println("------------------------------------------------");
        bst.levelOrder();

        System.out.println("------------------------------------------------");
        System.out.println(bst);
    }
}
