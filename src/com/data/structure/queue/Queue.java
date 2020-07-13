package com.data.structure.queue;

public interface Queue<E> {

    int getSize();

    boolean isEmpty();

    boolean enqueue(E e);

    E dequeue();

    E getFront();
}