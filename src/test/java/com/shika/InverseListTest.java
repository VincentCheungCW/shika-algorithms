package com.shika;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class InverseListTest {
    @Test
    public void inverseList() throws Exception {
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        ArrayList<Integer> inverseList = InverseList.inverseList(list);
        System.out.println(inverseList);
    }

}