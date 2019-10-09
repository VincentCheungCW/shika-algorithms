package com.shika;

/**
 * 题目：跳台阶
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。
 * 求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
 * 实际就是斐波那契数列
 */
public class JumpFloor {
    public static int fibonacci3(int n) {
        if (n <= 3) {
            return n;
        }
        int pre2 = 2, pre1 = 3, ret = 0;
        for (int i = 3; i < n; i++) {
            ret = pre1 + pre2;
            pre2 = pre1;
            pre1 = ret;
        }
        return ret;
    }
}
