package com.yibo.datastructure.queue;

import com.yibo.datastructure.linkedlist.LinkedList;

/**
 * @Author: huangyibo
 * @Date: 2020/9/210:28
 * @Description:
 */
public class LinkedListQueue<E> implements Queue<E> {

    private class Node{
        public E e;
        public Node next;

        public Node(E e, Node next){
            this.e = e;
            this.next = next;
        }

        public Node(E e){
            this(e,null);
        }

        public Node(){
            this(null,null);
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }

    private Node head,tail;
    private int size;

    public LinkedListQueue(){
        head = null;
        tail = null;
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void enQueue(E e) {
        if(tail == null){
            tail = new Node(e);
            head = tail;
        }else {
            tail.next = new Node(e);
            tail = tail.next;
        }
        size++;
    }

    public E deQueue() {
        if(isEmpty()){
            throw new IllegalArgumentException("Cannot dequeue from an empty queue.");
        }
        Node retNode = head;
        head = head.next;
        retNode.next = null;
        if(head == null){
            tail = null;
        }
        size--;
        return retNode.e;
    }

    public E getFront() {
        if(isEmpty()){
            throw new IllegalArgumentException("Queue is empty");
        }
        return head.e;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Queue: front ");
        Node current = head;
        while(current != null){
            stringBuilder.append(current +"->");
            current = current.next;
        }
        stringBuilder.append("NULL tail");
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        LinkedListQueue<Integer> linkedListQueue = new LinkedListQueue<Integer>();
        for (int i = 0; i < 10; i++) {
            linkedListQueue.enQueue(i);
            System.out.println(linkedListQueue);
            if(i % 3 == 0){
                linkedListQueue.deQueue();
                System.out.println(linkedListQueue);
            }
        }
    }
}
