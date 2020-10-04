package com.yibo.datastructure.array;

/**
 * @Author: huangyibo
 * @Date: 2020/7/2321:39
 * @Description:
 */
public class ArrayDemo1 {

    public static void main(String[] args) {
        Array<Integer> array = new Array<Integer>();
        for (int i = 0; i < 10; i++) {
            array.addLast(i);
        }
        System.out.println(array);

        array.add(1,200);
        System.out.println(array);

        array.addFirst(-1);
        System.out.println(array);

        array.remove(2);
        System.out.println(array);

        array.removeElement(4);
        System.out.println(array);

        array.removeFirst();
        System.out.println(array);

        array.removeLast();
        System.out.println(array);
    }

}
