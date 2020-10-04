package com.yibo.datastructure.set;

/**
 * @Author: huangyibo
 * @Date: 2020/9/2020:05
 * @Description:
 */
public class LinkedList<E> {

    private class Node{
        public E e;
        public Node next;

        public Node(E e,Node next){
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

    private Node dummyHead;
    private int size;

    public LinkedList(){
        dummyHead = new Node(null,null);
        size = 0;
    }

    //获取链表中元素的个数
    public int getSize(){
        return size;
    }

    //返回链表是否为空
    public boolean isEmpty(){
        return size == 0;
    }

    //在链表的index(0-based)位置添加新的元素e
    //在链表中不是一个常用的操作，练习用
    public void add(int index,E e){
        if(index < 0 || index > size){
            throw new IllegalArgumentException("Add failed. Illegal index.");
        }

        Node prev = dummyHead;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        /*Node node = new Node(e);
        node.next = prev.next;
        prev.next = node;*/
        //这句代码和上面三行效果一样
        prev.next = new Node(e,prev.next);
        size++;
    }

    //在链表头添加元素
    public void addFirst(E e){
        /*Node node = new Node(e);
        node.next = head;
        head = node;*/
        //上面三行代码和这一行效果一样
        //head = new Node(e,head);
        add(0,e);
    }

    //在链表末尾添加新的元素
    public void addLast(E e){
        add(size,e);
    }

    //获取链表的第index(0-based)位置的元素e
    //在链表中不是一个常用的操作，练习用
    public E get(int index){
        if(index < 0 || index >= size){
            throw new IllegalArgumentException("Get failed. Illegal index.");
        }
        Node current = dummyHead.next;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.e;
    }

    //获得链表的第一个元素
    public E getFirst(){
        return get(0);
    }

    //获取链表的最后一个元素
    public E getLast(){
        return get(size);
    }

    //修改链表的第index(0-based)位置的元素为e
    //在链表中不是一个常用的操作，练习用
    public void set(int index,E e){
        if(index < 0 || index >= size){
            throw new IllegalArgumentException("Set failed. Illegal index.");
        }
        Node current = dummyHead.next;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        current.e = e;
    }

    //查找链表中是否有元素e
    public boolean contains(E e){
        Node current = dummyHead.next;
        while(current != null){
            if(current.e.equals(e)){
                return true;
            }
            current = current.next;
        }
        return false;
    }

    //从链表中删除index(0-based)位置的元素，并返回删除的元素
    //在链表中不是一个常用的操作，练习用
    public E remove(int index){
        if(index < 0 || index >= size){
            throw new IllegalArgumentException("Remove failed. Illegal index.");
        }

        Node prev = dummyHead;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        Node retNode = prev.next;
        prev.next = retNode.next;
        retNode.next = null;
        size--;
        return retNode.e;
    }

    //从链表中删除第一个元素，返回删除的元素
    public E removeFirst(){
        return remove(0);
    }

    //从链表中删除最后一个元素，返回删除的元素
    public E removeLast(){
        return remove(size-1);
    }

    //从链表中删除元素E
    public void removeElement(E e){
        LinkedList.Node prev = dummyHead;
        while(prev.next != null){
            if(prev.next.e.equals(e)){
                break;
            }
            prev = prev.next;
        }
        if(prev.next != null){
            LinkedList.Node delNode = prev.next;
            prev.next = delNode.next;
            delNode.next = null;
            size--;
        }
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        /*Node current = dummyHead.next;
        while(current != null){
            stringBuilder.append(current+"->");
            current = current.next;
        }*/
        //两种循环都可以
        for(Node cur=dummyHead.next;cur != null;cur=cur.next){
            stringBuilder.append(cur+"->");
        }

        stringBuilder.append("Null");
        return stringBuilder.toString();
    }
}