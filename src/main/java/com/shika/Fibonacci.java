package com.shika;

/**
 * 题目：斐波那契数列
 * 求斐波那契数列的第 n 项，n <= 39。
 */
public class Fibonacci {
    /**
     * 1.从头计算所有项
     *
     * @param n
     * @return
     */
    public static int fibonacci(int n) {
        if (n <= 3) {
            return n-1;
        }
        int[] fibo = new int[n + 1];
        fibo[0] = 0;
        fibo[1] = 1;
        fibo[2] = 2;
        for (int i = 3; i < n; i++) {
            fibo[i] = fibo[i - 1] + fibo[i - 2];
        }
        return fibo[n - 1];
    }

    /**
     * 2.缓存所有项，查询速度O(1)
     */
    private int[] fibo = new int[40];

    public Fibonacci() {
        fibo[0] = 0;
        fibo[1] = 1;
        fibo[2] = 2;
        for (int i = 3; i < fibo.length; i++) {
            fibo[i] = fibo[i - 1] + fibo[i - 2];
        }
    }

    public int fibonacci2(int n) {
        return fibo[n - 1];
    }

    /**
     * 3.优化：仅缓存前两项
     */
    public static int fibonacci3(int n) {
        if (n <= 3) {
            return n-1;
        }
        int pre2 = 1, pre1 = 2, ret = 0;
        for (int i = 3; i < n; i++) {
            ret = pre1 + pre2;
            pre2 = pre1;
            pre1 = ret;
        }
        return ret;
    }
}
