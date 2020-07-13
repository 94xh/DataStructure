package com.data.structure.linkedList;

import java.util.Scanner;

/**
 * 基于单链表LRU算法（java）
 *
 * @author xiaohao
 * @create 2018-12-17
 */
public class LRUBaseLinkedList<T> {

    /**
     * 默认链表容量
     */
    private final static Integer DEFAULT_CAPACITY = 10;

    /**
     * 头结点
     */
    private SNode<T> headNode;

    /**
     * 链表长度
     */
    private Integer length;

    /**
     * 链表容量
     */
    private Integer capacity;

    public LRUBaseLinkedList() {
        this.headNode = new SNode<>();
        this.capacity = DEFAULT_CAPACITY;
        this.length = 0;
    }

    public LRUBaseLinkedList(Integer capacity) {
        this.headNode = new SNode<>();
        this.capacity = capacity;
        this.length = 0;
    }

    public static void main(String[] args) {
        LRUBaseLinkedList list = new LRUBaseLinkedList();
        Scanner sc = new Scanner(System.in);
        while (true) {
            list.add(sc.nextInt());
            list.printAll();
        }
    }

    public void add(T data) {
        SNode preNode = findPreNode(data);
        if (preNode != null) {
            deleteElemOptim(preNode);
            insertelematbegin(data);
        } else {
            if (length >= this.capacity) {
                deleteElemAtEnd();
            }
            insertelematbegin(data);
        }
    }

    /**
     * 删除preNode结点下一个元素
     *
     * @param preNode
     */
    private void deleteElemOptim(SNode preNode) {
        SNode next = preNode.getNext();
        preNode.setNext(next.getNext());
        next = null;
        length--;
    }

    /**
     * 链表头部插入节点
     *
     * @param data
     */
    private void insertelematbegin(T data) {
        SNode next = headNode.getNext();
        headNode.setNext(new SNode(data, next));
        length++;
    }

    /**
     * 获取查找到元素的前一个结点
     *
     * @param data
     * @return
     */
    private SNode findPreNode(T data) {
        SNode node = headNode;
        while (node.getNext() != null) {
            if (node.getNext().getElement().equals(data)) {
                return node;
            }
            node = node.getNext();
        }
        return null;
    }

    /**
     * 删除尾结点
     */
    private void deleteElemAtEnd() {
        SNode ptr = headNode;
        if (ptr.getNext() == null) {
            return;
        }
        while (ptr.getNext().getNext() != null) {
            ptr = ptr.getNext();
        }
        SNode tmp = ptr.getNext();
        ptr.setNext(null);
        tmp = null;
        length--;
    }

    private void printAll() {
        SNode node = headNode.getNext();
        while (node != null) {
            System.out.print(node.getElement() + ",");
            node = node.getNext();
        }
        System.out.println();
    }

    public class SNode<T> {
        private T element;
        private SNode next;

        public SNode() {
            this.next = null;
        }

        public SNode(T element) {
            this.element = element;
        }

        public SNode(T element, SNode next) {
            this.element = element;
            this.next = next;
        }

        public T getElement() {
            return element;
        }

        public void setElement(T element) {
            this.element = element;
        }

        public SNode getNext() {
            return next;
        }

        public void setNext(SNode next) {
            this.next = next;
        }
    }
}

