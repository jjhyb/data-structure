package com.yibo.datastructure.set;

import java.util.ArrayList;

/**
 * @Author: huangyibo
 * @Date: 2020/9/2322:22
 * @Description:
 */
public class Test {

    public static double testSet(Set<String> set,String filename){
        long startTime = System.nanoTime();
        System.out.println(filename);
        ArrayList<String> words = new ArrayList<String>();
        if(FileOperation.readFile(filename,words)){
            System.out.println("Total words: " + words.size());
            words.forEach(word -> {
                set.add(word);
            });
            System.out.println("Total different words: " + set.getSize());
        }
        long endTime = System.nanoTime();
        return (endTime - startTime) / 1000000000.0;
    }

    public static void main(String[] args) {
        String fimename = "E:\\project\\data-structure\\src\\main\\resources\\set\\pride-and-prejudice.txt";
        BinarySearchTreeSet<String> bstSet = new BinarySearchTreeSet<>();

        double time1 = testSet(bstSet, fimename);
        System.out.println("BinarySearchTreeSet : "+time1+"s");

        System.out.println("-------------------------------------------");
        LinkedListSet<String> linkedListSet = new LinkedListSet<>();
        double time2 = testSet(linkedListSet, fimename);
        System.out.println("LinkedListSet : "+time2+"s");

        System.out.println("-------------------------------------------");
        AVLSet<String> avlSet = new AVLSet<>();
        double time3 = testSet(avlSet, fimename);
        System.out.println("AVLSet : "+time3+"s");
    }
}
