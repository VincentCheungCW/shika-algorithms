package com.shika;


/**
 * 题目：旋转数组的最小元素
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
 * NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 */
public class MinNumInRotateArray {

    /**
     * 正确做法需要分为：
     * 1.数组为空
     * 2.部分旋转，例如由（1,2,3,4,5）旋转为（3,4,5,1,2），此时只需要遍历数组，找到当前数比前面的数小的数即可。
     * 3.完全旋转，例如由（1,2,3,4,5）旋转为（1,2,3,4,5），此时第一个数最小。
     */
    public int minNumberInRotateArray(int[] rotateArray) {
        //数组为空时
        if (rotateArray.length == 0)
            return -1;
        //前部分数据旋转
        for (int i = 0; i < rotateArray.length - 1; i++) {
            if (rotateArray[i] > rotateArray[i + 1])
                return rotateArray[i + 1];
        }
        //全部数据旋转，相当于没有旋转，最小数即为第一个数
        return rotateArray[0];
    }

    /**
     * 优化：二分查找的变形
     *
     * @param rotateArray
     * @return
     */
    public int minNumberInRotateArrayBS(int[] rotateArray) {
        int low = 0;
        int high = rotateArray.length - 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (rotateArray[mid] > rotateArray[high]) {
                low = mid + 1;
            } else if (rotateArray[mid] == rotateArray[high]) {
                high = high - 1;
            } else {
                high = mid;
            }
        }
        return rotateArray[low];
    }





    public static void main(String[] args) {
        String s = "test";
        StringBuilder sb = new StringBuilder("test");
        test(s);
        testSb(sb);
        System.out.println(s);
        System.out.println(sb);
    }

    private static void testSb(StringBuilder sb1) {
        sb1.append("sj");
    }

    private static String test(String s1) {
        s1 = s1 + "sj";
        return s1;
    }
}
