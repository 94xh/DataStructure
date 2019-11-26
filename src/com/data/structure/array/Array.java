package com.data.structure.array;

/**
 * 常规数组实现
 * 1、实现数组插入、删除、按照下标随机访问
 * 2、数组中的数据是int类型
 */
public class Array {
    //定义数组data保存数据
    public int data[];
    //定义数组的长度
    private int n;
    //定义实际的个数
    private int count;

    public Array(int capacity) {
        this.data = new int[capacity];
        this.n = capacity;
        this.count = 0;
    }

    //根据索引，找到数据中的元素并返回
    public int find(int index) {
        if (index < 0 || index >= count) return -1;
        return data[index];
    }

    //插入元素:头部插入，尾部插入
    public boolean insert(int index, int value) {

        if (count == n) {
            System.out.println("没有可插入的位置");
            return false;
        }

        if (index < 0 || index > count) {
            System.out.println("位置不合法");
            return false;
        }
        //位置合法
        if (count - index >= 0) System.arraycopy(data, index, data, index + 1, count - index);
        data[index] = value;
        ++count;
        return true;
    }

    //根据索引，删除数组中元素
    public boolean delete(int index) {
        if (index < 0 || index >= count) return false;
        if (count - index + 1 >= 0) System.arraycopy(data, index + 1, data, index + 1 - 1, count - index + 1);
        --count;
        return true;
    }

    public void printAll() {
        for (int i = 0; i < count; i++) {
            System.out.println(data[i]);
        }
    }

    public static void main(String[] args) {
        Array array = new Array(5);
        array.printAll();
        array.insert(0, 3);
        array.insert(0, 4);
        array.insert(1, 5);
        array.insert(3, 9);
        array.insert(3, 10);
        //array.insert(3, 11);
        array.printAll();
    }


}
