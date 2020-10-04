package com.yibo.datastructure.set;

import java.util.ArrayList;

/**
 * @Author: huangyibo
 * @Date: 2020/9/2323:39
 * @Description:
 */
public class LinkedListSet<E> implements Set<E> {

    private LinkedList<E> list;

    public LinkedListSet(){
        list = new LinkedList<>();
    }

    @Override
    public int getSize() {
        return list.getSize();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public boolean contains(E e) {
        return list.contains(e);
    }

    @Override
    public void add(E e) {
        if(!list.contains(e)){
            list.addFirst(e);
        }
    }

    @Override
    public void remove(E e) {
        list.removeElement(e);
    }

    public static void main(String[] args) {
        System.out.println("Pride and Prejudice");
        ArrayList<String> words1 = new ArrayList<String>();
        if(FileOperation.readFile("E:\\project\\data-structure\\src\\main\\resources\\set\\pride-and-prejudice.txt",words1)){
            System.out.println("Total words: " + words1.size());

            LinkedListSet<String> linkedListSet = new LinkedListSet<String>();
            words1.forEach(word -> {
                linkedListSet.add(word);
            });
            System.out.println("Total different words: " + linkedListSet.getSize());
        }
        System.out.println("--------------------------------------------");
        System.out.println("A Tale of Two Cities");
        ArrayList<String> words2 = new ArrayList<>();
        if(FileOperation.readFile("E:\\project\\data-structure\\src\\main\\resources\\set\\a-tale-of-two-cities.txt",words2)){
            System.out.println("Total words: " + words2.size());

            LinkedListSet<String> linkedListSet = new LinkedListSet<String>();
            words2.forEach(word -> {
                linkedListSet.add(word);
            });
            System.out.println("Total different words: " + linkedListSet.getSize());
        }
    }
}
