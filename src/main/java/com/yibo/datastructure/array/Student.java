package com.yibo.datastructure.array;

/**
 * @Author: huangyibo
 * @Date: 2020/7/2323:49
 * @Description:
 */
public class Student {

    private String name;

    private int score;

    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", score=" + score +
                '}';
    }

    public static void main(String[] args) {
        Array<Student> array = new Array<Student>();
        array.addLast(new Student("zhangsan",100));
        array.addLast(new Student("lisi",64));
        array.addLast(new Student("wangwu",83));
        System.out.println(array);
    }
}
