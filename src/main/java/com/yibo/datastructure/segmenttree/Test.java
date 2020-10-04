package com.yibo.datastructure.segmenttree;

/**
 * @Author: huangyibo
 * @Date: 2020/9/270:53
 * @Description:
 */
public class Test {

    public static void main(String[] args) {
        Integer[] nums = {-2, 0, 3, -5, 2, -1};
        SegmentTree<Integer> segmentTree = new SegmentTree<>(nums, (a, b) -> a + b);

//        System.out.println(segmentTree);

        System.out.println(segmentTree.query(0,2));
        System.out.println(segmentTree.query(2,5));
        System.out.println(segmentTree.query(0,5));
    }
}
