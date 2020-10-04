package com.yibo.datastructure.linkedlist;

/**
 * @Author: huangyibo
 * @Date: 2020/9/211:25
 * @Description:
 *
 * 删除链表中等于给定值 val 的所有节点。
 *
 * 示例:
 * 输入: 1->2->6->3->4->5->6, val = 6
 * 输出: 1->2->3->4->5
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

//不使用虚拟头结点
public class LeetCode {

    private static class ListNode {

        public int val;

        public ListNode next;

        public ListNode(int x) {
            val = x;
        }

        //链表节点的构造函数
        //使用arr为参数，创建一个链表，当前的ListNode为链表头结点
        public ListNode(int[] arr) {
            if(arr == null || arr.length == 0){
                throw new IllegalArgumentException("arr can not be empty");
            }
            this.val = arr[0];
            ListNode cur = this;
            for (int i = 1; i < arr.length; i++) {
                cur.next = new ListNode(arr[i]);
                cur = cur.next;
            }
        }

        //以当前节点为头结点的链表的信息字符串
        @Override
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            ListNode cur = this;
            while(cur != null){
                stringBuilder.append(cur.val +"->");
                cur = cur.next;
            }
            stringBuilder.append("NULL");
            return stringBuilder.toString();
        }
    }

    public ListNode removeElements(ListNode head, int val) {
        //删除链表开头是需要删除的元素
        while(head != null && head.val == val){
            ListNode delNode = head;
            head = head.next;
            delNode.next = null;
        }

        //如果链表为空
        if(head == null){
            return null;
        }

        //删除链表中间是需要删除的元素
        ListNode prev = head;
        while(prev.next != null){
            if(prev.next.val == val){
                ListNode delNode = prev.next;
                prev.next = delNode.next;
                delNode.next = null;
            }else {
                prev = prev.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,6,3,4,5,6};
        ListNode head = new ListNode(nums);
        System.out.println(head);

        ListNode res = new LeetCode().removeElements(head, 6);
        System.out.println(res);
    }
}
