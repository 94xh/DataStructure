package com.data.structure.linkedList;

import java.util.HashSet;

/**
 * 1) 单链表反转
 * 2) 链表中环的检测
 * 3) 两个有序的链表合并
 * 4) 删除链表倒数第n个结点
 * 5) 求链表的中间结点
 * 6) 去除链表中的重复数据
 * <p>
 * Author: xiaohao
 */
public class LinkedListAlgo {

    // 单链表反转
    public static Node reverse(Node list) {
        Node curr = list, pre = null;
        while (curr != null) {
            Node next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        return pre;
    }

    // 检测环
    public static boolean checkCircle(Node list) {
        if (list == null) return false;

        Node fast = list;
        Node slow = list;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if (fast == slow) {
                return true;
            }
        }

        return false;
    }

    // 有序链表合并
    // public static Node mergeSortedLists(Node la, Node lb) {
    // if (la == null) return lb;
    // if (lb == null) return la;

    // Node p = la;
    // Node q = lb;
    // Node head;
    // if (p.data < q.data) {
    //   head = p;
    //   p = p.next;
    // } else {
    //   head = q;
    //   q = q.next;
    // }
    // Node r = head;

    // while (p != null && q != null) {
    //   if (p.data < q.data) {
    //     r.next = p;
    //     p = p.next;
    //   } else {
    //     r.next = q;
    //     q = q.next;
    //   }
    //   r = r.next;
    // }

    // if (p != null) {
    //   r.next = p;
    // } else {
    //   r.next = q;
    // }

    // return head;
    //}

    //-----------------------------------------

    // 有序链表合并 Leetcode 21 

    /**
     * Definition for singly-linked list.
     * public class Node {
     * int val;
     * Node next;
     * Node(int x) { val = x; }
     * }
     */
    public static Node mergeTwoLists(Node l1, Node l2) {
        Node soldier = new Node(0); //利用哨兵结点简化实现难度 技巧三
        Node p = soldier;

        while (l1 != null && l2 != null) {
            if (l1.data < l2.data) {
                p.next = l1;
                l1 = l1.next;
            } else {
                p.next = l2;
                l2 = l2.next;
            }
            p = p.next;
        }

        if (l1 != null) {
            p.next = l1;
        }
        if (l2 != null) {
            p.next = l2;
        }
        return soldier.next;
    }

    //查找倒数第K个结点
    public static Node findLastKth(Node list, int k) {
        Node f = list;
        Node b = list;
        //先让FAST走K步
        while (--k != 0) {
            f = f.next;
        }

        while (f.next != null) {
            f = f.next;
            b = b.next;
        }
        return b;
    }

    // 删除倒数第K个结点
    public static Node deleteLastKth(Node list, int k) {
        Node pre = findLastKth(list, k + 1);
        pre.next = pre.next.next;
        return list;
    }

    // 求中间结点
    public static Node findMiddleNode(Node list) {
        if (list == null) return null;
        Node fast = list;
        Node slow = list;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;
    }

    public static void printAll(Node list) {
        Node p = list;
        while (p != null) {
            System.out.print(p.data + " ");
            p = p.next;
        }
        System.out.println();
    }

    public static Node createNode(int value) {
        return new Node(value, null);
    }

    public static Node arrayToNode(int[] ints) {
        Node headNode = new Node(ints[0]);
        Node other = headNode;
        for (int i = 1; i < ints.length; i++) {
            other.setNext(new Node(ints[i]));
            other = other.next;
        }
        return headNode;
    }

    /**
     * 面试题 02.01. 移除重复节点
     * 输入：[1, 2, 3, 3, 2, 1]
     * 输出：[1, 2, 3]
     *
     * @param head
     * @return
     */
    public static Node removeDuplicateNodes(Node head) {
        HashSet set = new HashSet();
        Node cur = head;
        while (cur != null && cur.next != null) {
            set.add(cur.data);
            if (set.contains(cur.next.data)) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        int[] ints = {1, 3, 5, 7, 9, 11};
        int[] ints2 = {2, 4, 6, 8, 10, 12};
        //翻转链表测试
        Node headNode = arrayToNode(ints);
        printAll(headNode);
        printAll(reverse(headNode));

        //有序链表合并测试。思想 加个临时哨兵结点
        Node l1 = arrayToNode(ints);
        Node l2 = arrayToNode(ints2);
        printAll(mergeTwoLists(l1, l2));

        //倒数K结点测试，思想先走K步
        Node k = arrayToNode(ints);
        printAll(k);
        System.out.println("查找倒数第二个结点是：" + findLastKth(k, 2).data + "删除后的链表");
        printAll(deleteLastKth(k, 2));

        //求中间结点
        System.out.println(findMiddleNode(k).data);

        //测试链表是否有环
        Node node1 = new Node(1);
        Node node2 = new Node(1);
        Node node3 = new Node(1);
        Node node4 = new Node(1);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = null;
        System.out.println(checkCircle(node1));

        int[] ints3 = {1, 2, 3, 3, 2, 1};
        //移除重复节点
        Node headNode2 = arrayToNode(ints3);
        Node newNode = removeDuplicateNodes(headNode2);
        printAll(newNode);
    }

    public static class Node {
        private int data;
        private Node next;

        public Node(int data) {
            this.data = data;
        }

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }

        public int getData() {
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


}
