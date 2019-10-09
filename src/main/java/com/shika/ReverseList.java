package com.shika;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 题目：逆序链表
 * 从尾到头反过来打印出每个结点的值。
 */
public class ReverseList {
    static class Node {
        int val;
        Node next;

        public Node(int val) {
            this.val = val;
        }
    }

    /**
     * 1.头插法
     */
    public static Node reverseList(Node node) {
        Node head = new Node(-1);
        while (node != null) {
            //标记
            Node memo = node.next;
            //下面两句是关键：1->2->3  =>  head->1->null  => head->2->1->null  …
            node.next = head.next;
            head.next = node;
            node = memo;
        }
        return head.next;
    }

    /**
     * 2.递归
     */
    public static List<Integer> reverseListRecursion(Node node) {
        List<Integer> ret = new ArrayList<>();
        if (node != null) {
            ret.addAll(reverseListRecursion(node.next));
            ret.add(node.val);
        }
        return ret;
    }

    /**
     * 3.使用栈
     */
    public static List<Integer> reverseListStack(Node node) {
        LinkedList<Integer> stack = new LinkedList<>();
        while (node != null) {
            stack.push(node.val);
            node = node.next;
        }
        List<Integer> ret = new ArrayList<>();
        while (!stack.isEmpty()) {
            ret.add(stack.pop());
        }
        return ret;
    }
}
