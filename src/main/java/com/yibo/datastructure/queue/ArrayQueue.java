package com.yibo.datastructure.queue;

/**
 * @Author: huangyibo
 * @Date: 2020/9/2016:39
 * @Description:
 */
public class ArrayQueue<E> implements Queue<E> {

    private Array<E> array;

    public ArrayQueue(int capacity){
        this.array = new Array<E>(capacity);
    }

    public ArrayQueue(){
        this.array = new Array<E>();
    }

    public int getSize() {
        return this.array.getSize();
    }

    public boolean isEmpty() {
        return this.array.isEmpty();
    }

    public int getCapacity(){
        return this.array.getCapacity();
    }

    public void enQueue(E e) {
        this.array.addLast(e);
    }

    public E deQueue() {
        return this.array.removeFirst();
    }

    public E getFront() {
        return this.array.getFirst();
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Queue：");
        stringBuilder.append("front [");
        for (int i = 0; i < array.getSize(); i++) {
            stringBuilder.append(array.get(i));
            if(i != array.getSize()-1){
                stringBuilder.append(", ");
            }
        }
        stringBuilder.append("] tail");
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        ArrayQueue<Integer> arrayQueue = new ArrayQueue<Integer>();
        for (int i = 0; i < 10; i++) {
            arrayQueue.enQueue(i);
            System.out.println(arrayQueue);
            if(i % 3 == 0){
                arrayQueue.deQueue();
                System.out.println(arrayQueue);
            }
        }
    }
}
