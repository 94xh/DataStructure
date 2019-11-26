package com.data.structure.stack;

/**
 * 使用链表生成栈
 */
public class StackBaseOnLinkedList {
    Node top  = null;

    public void push(int value){
        if (top == null){
            top = new Node(value, null);
        }else{
            Node newNode = new Node(value, null);
            newNode.next = top;
            top = newNode;
        }
    }

    public int pop(){
        if (top == null) return -1;
        int value = top.data;
        top = top.next;
        return value;
    }

    public void printAll() {
        Node p = top;
        while (p != null) {
            System.out.print(p.data + " ");
            p = p.next;
        }
        System.out.println();
    }

    private static class Node{
        private int data;
        private Node next;

        public Node(int data, Node next){
            this.data = data;
            this.next = next;
        }

        public int getData(){
            return data;
        }

        public void setData(int data) {
            this.data = data;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }

    public static void main(String[] args) {

        StackBaseOnLinkedList stackBaseOnLinkedList = new StackBaseOnLinkedList();
        stackBaseOnLinkedList.push(1);
        stackBaseOnLinkedList.push(2);
        stackBaseOnLinkedList.push(3);
        stackBaseOnLinkedList.push(4);
        stackBaseOnLinkedList.push(5);
        stackBaseOnLinkedList.push(6);
        stackBaseOnLinkedList.printAll();
        stackBaseOnLinkedList.pop();
        stackBaseOnLinkedList.pop();
        stackBaseOnLinkedList.printAll();
    }
}
