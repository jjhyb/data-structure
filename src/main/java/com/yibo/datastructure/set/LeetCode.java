package com.yibo.datastructure.set;

import java.util.ArrayList;
import java.util.TreeSet;

/**
 * @Author: huangyibo
 * @Date: 2020/9/251:51
 * @Description:
 *
 * 349. 两个数组的交集
 * 给定两个数组，编写一个函数来计算它们的交集。
 *
 * 示例 1：
 * 输入：nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出：[2]
 */
public class LeetCode {

    public static int[] intersection(int[] nums1, int[] nums2) {
        TreeSet<Integer> treeSet = new TreeSet<>();
        for (int num : nums1) {
            treeSet.add(num);
        }
        ArrayList<Integer> list = new ArrayList<>();
        for (int num : nums2) {
            if(treeSet.contains(num)){
                list.add(num);
                treeSet.remove(num);
            }
        }
        int[] results = list.stream().mapToInt(Integer::valueOf).toArray();
        return results;
    }

    public static void main(String[] args) {
        int[] nums1 = {1,2,2,1};
        int[] nums2 = {2,2};
        int[] result = intersection(nums1, nums2);
        for (int re : result) {
            System.out.println(re);
        }
    }
}
