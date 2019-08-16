package com.shika;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * 链表逆序
 * 使用栈
 */
public class InverseList {
    public static ArrayList<Integer> inverseList(ArrayList<Integer> in) {
        Iterator<Integer> iterator = in.iterator();
        LinkedList<Integer> stack = new LinkedList<>(); //使用栈
        while (iterator.hasNext()) {
            stack.push(iterator.next());
        }
        ArrayList<Integer> ret = new ArrayList<>();
        while (!stack.isEmpty()) {
            ret.add(stack.pop());
        }
        return ret;
    }
}
