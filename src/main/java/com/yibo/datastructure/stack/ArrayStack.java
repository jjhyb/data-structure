package com.yibo.datastructure.stack;

/**
 * @Author: huangyibo
 * @Date: 2020/9/2014:25
 * @Description:
 */
public class ArrayStack<E> implements Stack<E> {

    private Array<E> array;

    public ArrayStack(int capacity){
        this.array = new Array<E>(capacity);
    }

    public ArrayStack(){
        this.array = new Array<E>();
    }

    public int getSize() {
        return this.array.getSize();
    }

    public boolean isEmpty() {
        return this.array.isEmpty();
    }

    //栈的容量大小
    public int getCapacity(){
        return this.array.getCapacity();
    }

    public void push(E e) {
        this.array.addLast(e);
    }

    public E pop() {
        return this.array.removeLast();
    }

    public E peek() {
        return null;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Stack：");
        stringBuilder.append("[");
        for (int i = 0; i < array.getSize(); i++) {
            stringBuilder.append(array.get(i));
            if(i != array.getSize()-1){
                stringBuilder.append(", ");
            }
        }
        stringBuilder.append("] top");
        return stringBuilder.toString();
    }
}
