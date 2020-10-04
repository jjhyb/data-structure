package com.yibo.datastructure.map;

import java.util.ArrayList;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * @Author: huangyibo
 * @Date: 2020/9/251:51
 * @Description:
 *
 * 350. 两个数组的交集 II
 * 给定两个数组，编写一个函数来计算它们的交集。
 *
 * 输入：nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出：[2,2]
 *
 * 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出：[4,9]
 */
public class LeetCode {

    public static int[] intersect(int[] nums1, int[] nums2) {
        ArrayList<Integer> list = new ArrayList<>();
        TreeMap<Integer,Integer> treeMap = new TreeMap<>();
        for (int num : nums1) {
            if(treeMap.containsKey(num)) {
                treeMap.replace(num,treeMap.get(num)+1);
            }else{
                treeMap.put(num,1);
            }
        }

        for (int num : nums2) {
            if(treeMap.containsKey(num)){
                treeMap.replace(num,treeMap.get(num)-1);
                if(treeMap.get(num) <= 0){
                    treeMap.remove(num);
                }
                list.add(num);
            }
        }
        int[] results = list.stream().mapToInt(Integer::valueOf).toArray();
        return results;
    }

    public static void main(String[] args) {
        int[] nums1 = {1,2,2,1};
        int[] nums2 = {2,2};
        int[] results1 = intersect(nums1, nums2);
        for (int result : results1) {
            System.out.println(result);
        }
        System.out.println("-----------------------------");
        int[] nums3 = {4,9,5};
        int[] nums4 = {9,4,9,8,4};
        int[] results2 = intersect(nums3, nums4);
        for (int result : results2) {
            System.out.println(result);
        }
    }
}
