package com.yibo.datastructure.queue;

import java.util.Date;

/**
 * @Author: huangyibo
 * @Date: 2020/9/2017:04
 * @Description:
 */
public class LoopQueue<E> implements Queue<E> {

    private E[] data;
    private int front, tail;
    private int size;

    public LoopQueue(){
        this(10);
    }

    public LoopQueue(int capacity){
        data = (E[])new Object[capacity + 1];
        front = 0;
        tail = 0;
        size = 0;
    }

    public int getCapacity(){
        return data.length - 1;
    }

    public boolean isEmpty(){
        return front == tail;
    }

    public int getSize(){
        return size;
    }

    public void enQueue(E e) {
        if((tail + 1) % data.length == front){
            resize(getCapacity() * 2);
        }
        data[tail] = e;
        tail = (tail + 1) % data.length;
        size++;
    }

    public E deQueue() {
        if(isEmpty()){
            throw new IllegalArgumentException("Cannot dequeue from an empty queue.");
        }
        E element = data[front];
        data[front] = null;
        front = (front + 1) % data.length;
        size --;
        if(size == getCapacity() / 4 && getCapacity() / 2 != 0){
            resize(getCapacity() / 2);
        }
        return element;
    }

    private void resize(int newCapacity){
        E[] newData = (E[])new Object[newCapacity + 1];
        for (int i = 0; i < size; i++) {
            newData[i] = data[(i + front) % data.length];
        }
        data = newData;
        front = 0;
        tail = size;
    }

    public E getFront() {
        if(isEmpty()){
            throw new IllegalArgumentException("Queue is Empty.");
        }
        return data[front];
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.format("Queue：size=%d, capacity=%d\n",size,getCapacity()));
        stringBuilder.append("front [");
        for (int i = front; i != tail; i = (i+1) % data.length) {
            stringBuilder.append(data[i]);
            if((i+1)%data.length != tail){
                stringBuilder.append(", ");
            }
        }
        stringBuilder.append("] tail");
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        LoopQueue<Integer> loopQueue = new LoopQueue<Integer>();
        for (int i = 0; i < 10; i++) {
            loopQueue.enQueue(i);
            System.out.println(loopQueue);
            if(i % 3 == 0){
                loopQueue.deQueue();
                System.out.println(loopQueue);
            }
        }
    }
}
