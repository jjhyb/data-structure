package com.yibo.datastructure.map;

import com.yibo.datastructure.set.FileOperation;

import java.util.ArrayList;

/**
 * @Author: huangyibo
 * @Date: 2020/9/250:05
 * @Description:
 */
public class Test {

    private static double testMap(Map<String,Integer> map,String filename){
        long startTime = System.nanoTime();
        System.out.println(filename);
        ArrayList<String> words = new ArrayList<String>();
        if(FileOperation.readFile(filename,words)){
            System.out.println("Total words: " + words.size());
            words.forEach(word -> {
                if(map.contains(word)){
                    map.set(word,map.get(word)+1);
                }else {
                    map.add(word,1);
                }
            });
            System.out.println("Total different words: " + map.getSize());
            System.out.println("Frequency  of pride: " + map.get("pride"));
            System.out.println("Frequency  of prejudice: " + map.get("prejudice"));
        }
        long endTime = System.nanoTime();
        return (endTime - startTime) / 1000000000.0;
    }

    public static void main(String[] args) {
        String fimename = "E:\\project\\data-structure\\src\\main\\resources\\set\\pride-and-prejudice.txt";
        LinkedListMap<String,Integer> linkedListMap = new LinkedListMap<>();
        double time1 = testMap(linkedListMap, fimename);
        System.out.println("LinkedListMap : "+time1+"s");

        System.out.println("-------------------------------------------");

        BinarySearchTreeMap<String,Integer> binarySearchTreeMap = new BinarySearchTreeMap<>();
        double time2 = testMap(binarySearchTreeMap, fimename);
        System.out.println("BinarySearchTreeMap : "+time2+"s");

        System.out.println("-------------------------------------------");

        AVLMap<String,Integer> avlMap = new AVLMap<>();
        double time3 = testMap(avlMap, fimename);
        System.out.println("AVLMap : "+time3+"s");
    }
}
