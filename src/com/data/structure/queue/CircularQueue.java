package com.data.structure.queue;

/**
 * 循环队列
 *
 * @param <T>
 */
public class CircularQueue<T> implements Queue<T> {

    private T[] items;
    private int size;
    private int head;
    private int tail;

    public CircularQueue(int capacity) {
        this.size = capacity;
        this.items = (T[]) new Object[capacity];
    }

    public static void main(String[] args) {
        CircularQueue circularQueue = new CircularQueue(7);
        circularQueue.enqueue(1);
        circularQueue.enqueue(2);
        circularQueue.enqueue(3);
        circularQueue.enqueue(4);
        circularQueue.enqueue(5);
        circularQueue.enqueue(6);
        circularQueue.printAll();
        circularQueue.dequeue();
        circularQueue.dequeue();
        circularQueue.dequeue();
        circularQueue.dequeue();
        circularQueue.printAll();
    }

    /**
     * 获取实际的数组下标
     *
     * @param location
     * @return
     */
    private int getActualLocation(int location) {
        return (location + 1) % size;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        if (size == 0) return true;
        return false;
    }

    @Override
    public boolean enqueue(Object o) {
        if (getActualLocation(tail) == head) return false;
        items[tail] = (T) o;
        tail = getActualLocation(tail);
        return true;
    }

    @Override
    public T dequeue() {
        if (head == tail) return null;
        T temp = items[head];
        head = getActualLocation(head);
        return temp;
    }

    @Override
    public T getFront() {
        return items[head];
    }

    public void printAll() {
        if (0 == size) return;
        for (int i = head; i % size != tail; i = (i + 1) % size) {
            System.out.print(items[i] + " ");
        }
        System.out.println();
    }
}
