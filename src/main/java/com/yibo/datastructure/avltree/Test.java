package com.yibo.datastructure.avltree;

import com.yibo.datastructure.set.FileOperation;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @Author: huangyibo
 * @Date: 2020/10/218:26
 * @Description:
 */
public class Test {

    public static void main(String[] args) {
        System.out.println("Pride and Prejudice");
        String filename = "E:\\project\\data-structure\\src\\main\\resources\\set\\pride-and-prejudice.txt";
        ArrayList<String> words = new ArrayList<>();
        if(FileOperation.readFile(filename,words)){
            Collections.sort(words);//最坏的情况
            long startTime = System.nanoTime();
            BinarySearchTree<String,Integer> bst = new BinarySearchTree<>();
            words.forEach(word -> {
                if(bst.contains(word)){
                    bst.set(word,bst.get(word)+1);
                }else {
                    bst.add(word,1);
                }
            });
            words.forEach(word -> {
                bst.contains(word);
            });
            long endTime = System.nanoTime();
            double time = (endTime - startTime) / 1000000000.0;
            System.out.println("BinarySearchTree : "+time+" s");

            startTime = System.nanoTime();
            AVLTree<String,Integer> avlTree = new AVLTree<>();
            words.forEach(word -> {
                if(avlTree.contains(word)){
                    avlTree.set(word,bst.get(word)+1);
                }else {
                    avlTree.add(word,1);
                }
            });
            words.forEach(word -> {
                avlTree.contains(word);
            });
            endTime = System.nanoTime();
            time = (endTime - startTime) / 1000000000.0;
            System.out.println("AVLTree : "+time+" s");
        }
    }
}
