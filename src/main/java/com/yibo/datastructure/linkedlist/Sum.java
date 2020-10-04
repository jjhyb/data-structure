package com.yibo.datastructure.linkedlist;

/**
 * @Author: huangyibo
 * @Date: 2020/9/2123:31
 * @Description:
 */
public class Sum {

    public static int sum(int[] arr){
        return sum(arr,0);
    }

    //计算arr[l...n]这个区间内所有的数字的和
    public static int sum(int[] arr,int l){
        if(l == arr.length){
            return 0;
        }
        return arr[l] + sum(arr,l+1);
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7,8};
        System.out.println(sum(nums));
    }
}
