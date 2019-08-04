package com.shika;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Jiang on 2019/8/4.
 */
public class FindInMatrixTest {
    @Test
    public void findInMatrix() throws Exception {
        int[][] arr = {
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };
        Assert.assertFalse(FindInMatrix.findInMatrix(arr, 20));
        boolean inMatrix = FindInMatrix.findInMatrix(arr, 20);
        boolean inMatrix2 = FindInMatrix.findInMatrix(arr, 5);
        System.out.println(inMatrix);
        System.out.println(inMatrix2);
    }

}