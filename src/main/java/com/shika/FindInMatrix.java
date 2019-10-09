package com.shika;

/**
 * Created by Jiang on 2019/8/4.
 * 题目：二维数组中的查找
 * 在一个二维数组中，每一行都按照从左到右递增的顺序排序，
 * 每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，
 * 判断数组中是否含有该整数。
 * 思路：首先选取数组中右上角的数字。如果该数字等于要查找的数字，查找过程结束；
 * 如果该数字大于要查找的数字，剔除这个数字所在的列；
 * 如果该数字小于要查找的数字，剔除这个数字所在的行。
 */
public class FindInMatrix {
    public static boolean findInMatrix(int[][] arr, int target) {
        if (arr == null || arr.length == 0 || arr[0].length == 0) {
            return false;
        }
        int row = 0, column = arr[0].length;
        while (row < arr.length && column > 0) {
            if (arr[row][column - 1] == target) {  //注意每次遍历下标row\column要相应变化
                return true;
            } else if (arr[row][column - 1] > target) {
                column--;
            } else {
                row++;
            }
        }
        return false;
    }
}
