package com.shika;

import static com.shika.BinarySearch.bSearch;
import static com.shika.BinarySearch.bSearchRecursion;

public class BinarySearchTest {
    public static void main(String[] args) {
        int[] a = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int i = bSearch(a, 9);
        int j = bSearchRecursion(a, 0, 10, 9);
        System.out.println(i);
    }

}