package com.shika;

/**
 * Created by Jiang on 2019/8/4.
 * 题目：数组中重复的数字
 * 在一个长度为n的数组里的所有数字都在0到n-1的范围内。
 * 数组中某些数字是重复的，但不知道有几个数字是重复的。
 * 也不知道每个数字重复几次。请找出数组中任意一个重复的数字。
 * 例如，如果输入长度为7的数组{2,3,1,0,2,5,3}，那么对应的输出是重复的数字2或者3。
 * <p>
 * 思路： 比较容易想到的方法用哈希表存出现过的数，从头到尾遍历一遍，
 * 每遍历一个数字都可以判断哈希表中是否包含当前数字。时间复杂度O(n),同时还用了O(n)的空间。
 * 简化：注意到数字都在0-n-1的范围，如果没有重复的数字，排序后，数字i应该正好在下标为i的位置。
 * 所以我们从头扫描数组，扫到下标为i的位置时，判断值是否为i，是则扫描下一位；
 * 如果不是，比如它为m，我们判断它是否和下标为m的数字相同，相同则说明出现重复数字，
 * 不同我们就交换这两个数字，这样m就到了下标为m的位置。重复这个过程就能找到重复的数字。
 */
public class DuplicationNum {
    public static int duplicateNum(int[] arr) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        for (int i = 0; i < arr.length; i++) {
            while (i != arr[i]) {  //注意这里用while而不是if,因为互换位置后arr[i]的位置正确了，arr[arr[i]]仍不正确
                if (arr[i] == arr[arr[i]]) {
                    return arr[i];
                } else {
                    swap(arr, i, arr[i]);
                }
            }
        }
        return -1;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
