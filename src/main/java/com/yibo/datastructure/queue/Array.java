package com.yibo.datastructure.queue;

/**
 * @Author: huangyibo
 * @Date: 2020/7/2321:54
 * @Description:
 */
public class Array<E> {

    private E[] data;

    private int size;

    //无参构造函数，默认数组的容量capacity=10
    public Array(){
        this(10);
    }

    //构造函数，传入的数组容量capacity构造Array
    public Array(int capacity){
        this.data = (E[]) new Object[capacity];
        this.size = 0;
    }

    //获取数组中的元素个数
    public int getSize() {
        return size;
    }

    //获取数组的容量
    public int getCapacity(){
        return this.data.length;
    }

    //返回数组是否为空
    public boolean isEmpty(){
        return this.size == 0;
    }

    //在数组最后位置插入新元素e
    public void addLast(E e){
        add(size,e);
    }

    //在数组最开始位置插入新元素e
    public void addFirst(E e){
        add(0,e);
    }

    //在index位置插入一个新元素e
    public void add(int index,E e){
        if(index < 0 || index > size){
            throw new IllegalArgumentException("Add failed. Require index >= 0 and index <= size.");
        }
        if(size == data.length){
            resize(2 * data.length);
        }
        for(int i = size -1;i >= index;i--){
            data[i+1] = data[i];
        }
        data[index] = e;
        size++;
    }

    //获取index索引位置的元素
    public E get(int index){
        if(index < 0 || index >= size){
            throw new IllegalArgumentException("Get failed. Index is illegal.");
        }
        return data[index];
    }

    public E getLast(){
        return get(size - 1);
    }

    public E getFirst(){
        return get(0);
    }

    //修改index索引位置的元素为e
    public void set(int index,E e){
        if(index < 0 || index >= size){
            throw new IllegalArgumentException("Set failed. Index is illegal.");
        }
        data[index] = e;
    }

    //查找数组中是否有元素e
    public boolean contains(E e){
        for (int i = 0; i < size; i++) {
            if(data[i].equals(e)){
                return true;
            }
        }
        return false;
    }

    //查找数组中元素e所在的索引，如果不存在元素e，则返回-1
    public int find(E e){
        for (int i = 0; i < size; i++) {
            if(data[i].equals(e)){
                return i;
            }
        }
        return -1;
    }

    //从数组中删除index位置的元素，并返回删除的元素
    public E remove(int index){
        if(index < 0 || index >= size){
            throw new IllegalArgumentException("Remove failed. Index is illegal.");
        }
        E result = data[index];
        for(int i = index+1;i<size;i++){
            data[i - 1] = data[i];
        }
        size --;
        data[size] = null;
        if(size < data.length / 4 && data.length / 2 != 0){
            //当数组长度缩小为原数组的4分之一的时候才进行数组的缩容，
            //缩小为原数组的2分之一，预留空间，防止有数据添加导致扩容浪费性能
            resize(data.length / 2);
        }
        return result;
    }

    //从数组中删除第一个位置的元素，并返回删除的元素
    public E removeFirst(){
        return remove(0);
    }

    //从数组中删除第一个位置的元素，并返回删除的元素
    public E removeLast(){
        return remove(size - 1);
    }

    //从数组中删除元素e
    public void removeElement(E e){
        int index = find(e);
        if(index != -1){
            remove(index);
        }
    }

    @Override
    public String toString(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.format("Array: size = %d , capacity = %d\n",size,data.length));
        stringBuilder.append('[');
        for (int i = 0; i < size; i++) {
            stringBuilder.append(data[i]);
            if(i < size - 1){
                stringBuilder.append(", ");
            }
        }
        stringBuilder.append(']');
        return stringBuilder.toString();
    }

    private void resize(int newCapacity){
        E[] newData = (E[])new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        this.data = newData;
    }
}
