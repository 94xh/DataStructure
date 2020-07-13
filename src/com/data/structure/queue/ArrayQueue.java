package com.data.structure.queue;

import com.data.structure.array.GenericArray;

/**
 * 动态队列
 *
 * @param <E>
 */
public class ArrayQueue<E> implements Queue<E> {

    //创建私有GenericArray对象
    private com.data.structure.array.GenericArray<E> GenericArray;

    //基于动态数组的实现，传入容量变量
    public ArrayQueue(int capacity) {
        //知道要容量为多少，在这里由用户设置
        GenericArray = new GenericArray<>(capacity);
    }

    public ArrayQueue() {
        //不知道容量为多少
        GenericArray = new GenericArray<>();
    }

    public static void main(String[] args) {

        ArrayQueue<Integer> queue = new ArrayQueue<>();
        for (int i = 0; i < 10; i++) {
            queue.enqueue(i);
            System.out.println(queue);
            if (i % 3 == 2) {
                queue.dequeue();
                System.out.println(queue);
            }
        }
    }

    @Override
    public int getSize() {
        return GenericArray.count();
    }

    @Override
    public boolean isEmpty() {
        return GenericArray.isEmpty();
    }

    public int getCapacity() {
        return GenericArray.getCapacity();
    }

    @Override
    public boolean enqueue(E e) {
        //基于动态数组实现的队列，如果容量不足，则会触发动态数组方法进行扩容
        GenericArray.addLast(e);
        return true;
    }

    @Override
    public E dequeue() {
        //相应的此操作也会触发减容的操作
        return GenericArray.removeFirst();
    }

    @Override
    public E getFront() {
        return GenericArray.getFirst();
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("Queue: ");
        res.append("front [");
        //遍历GenericArray元素，逐次加入队列中
        for (int i = 0; i < GenericArray.count(); i++) {
            res.append(GenericArray.get(i));
            if (i != GenericArray.count() - 1) {
                res.append(", ");
            }
        }
        res.append("] tail");
        return res.toString();
    }
}