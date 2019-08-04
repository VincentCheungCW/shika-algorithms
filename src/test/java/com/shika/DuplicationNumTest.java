package com.shika;

import static com.shika.DuplicationNum.duplicateNum;

/**
 * Created by Jiang on 2019/8/4.
 */
public class DuplicationNumTest {
    public static void main(String[] args) {
        int[] arr = {2, 3, 1, 0, 1, 5, 4};
        int i = duplicateNum(arr);
        System.out.println(i);
    }

}