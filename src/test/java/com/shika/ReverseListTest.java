package com.shika;

import org.junit.Test;

import java.util.List;

public class ReverseListTest {
    @Test
    public void reverseList() throws Exception {
        ReverseList.Node node = new ReverseList.Node(1);
        ReverseList.Node temp = node;
        for (int i = 1; i < 10;) {
            temp.next = new ReverseList.Node(++i);
            temp = temp.next;
        }
        //ReverseList.Node ReverseList = ReverseList.ReverseList(node);
        //while (ReverseList != null){
        //    System.out.println(ReverseList.val);
        //    ReverseList = ReverseList.next;
        //}

        List<Integer> list = ReverseList.reverseListRecursion(node);
        System.out.println(list);

        List<Integer> list1 = ReverseList.reverseListStack(node);
        System.out.println(list1);
    }

}