package com.yibo.datastructure.set;

import java.util.ArrayList;

/**
 * @Author: huangyibo
 * @Date: 2020/9/2322:01
 * @Description:
 */
public class BinarySearchTreeSet<E extends Comparable<E>> implements Set<E> {

    private BinarySearchTree<E> bst;

    public BinarySearchTreeSet(){
        bst = new BinarySearchTree<E>();
    }

    public int getSize() {
        return bst.size();
    }

    public boolean isEmpty() {
        return bst.isEmpty();
    }

    public void add(E e) {
        bst.add(e);
    }

    public boolean contains(E e) {
        return bst.contains(e);
    }

    public void remove(E e) {
        bst.remove(e);
    }

    public static void main(String[] args) {
        System.out.println("Pride and Prejudice");
        ArrayList<String> words1 = new ArrayList<String>();
        if(FileOperation.readFile("E:\\project\\data-structure\\src\\main\\resources\\set\\pride-and-prejudice.txt",words1)){
            System.out.println("Total words: " + words1.size());

            BinarySearchTreeSet<String> bstSet = new BinarySearchTreeSet<String>();
            words1.forEach(word -> {
                bstSet.add(word);
            });
            System.out.println("Total different words: " + bstSet.getSize());
        }
        System.out.println("--------------------------------------------");
        System.out.println("A Tale of Two Cities");
        ArrayList<String> words2 = new ArrayList<>();
        if(FileOperation.readFile("E:\\project\\data-structure\\src\\main\\resources\\set\\a-tale-of-two-cities.txt",words2)){
            System.out.println("Total words: " + words2.size());

            BinarySearchTreeSet<String> bstSet = new BinarySearchTreeSet<String>();
            words2.forEach(word -> {
                bstSet.add(word);
            });
            System.out.println("Total different words: " + bstSet.getSize());
        }
    }
}
