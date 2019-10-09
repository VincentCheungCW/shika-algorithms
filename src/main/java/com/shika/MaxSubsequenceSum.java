package com.shika;

/**
 * 最大子序列和问题
 * 给定一个整数数组，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * 示例:
 * 输入: [-2,1,-3,4,-1,2,1,-5,4],
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 */
public class MaxSubsequenceSum {

    /**
     * 暴力破解法——时间效率O(N^3)
     *
     * @param arr
     * @return
     */
    public int solution1(int[] arr) {
        int maxSum = 0;
        for (int i = 0; i < arr.length; i++) { // 子序列左端点
            for (int j = i; j < arr.length; j++) { // 子序列右端点
                int sum = 0;
                for (int k = i; k <= j; k++) { //暴力计算i-j的和
                    sum += arr[k];
                }
                if (sum > maxSum) {
                    maxSum = sum;
                }
            }
        }
        return maxSum;
    }

    /**
     * 改进暴力法——时间效率O(N^2)
     * 其实我们可以发现，每次我们都是重复计算了一部分子序列，即当我计算前两个时，
     * 第三次我还是会计算前两个在加第三个，这样就造成了O(N^3)，
     * 现在我们根据前一次的进行计算，那么将会减少一层循环。
     *
     * @param arr
     * @return
     */
    public static int solution2(int[] arr) {
        int maxSum = 0;
        for (int i = 0; i < arr.length; i++) { // 子序列左端点
            int curSum = 0;
            for (int j = i; j < arr.length; j++) { // 子序列右端点
                curSum += arr[j];  // 这里就相当于每次根据前一次的序列来计算新的序列
                if (curSum > maxSum) {
                    maxSum = curSum;
                    //可以记录此时的i,j即最大和子序列的起始位置
                }
            }
        }
        return maxSum;
    }

    /**
     * 分治思想
     * 分为三种情况：1最大子序列和在左半部分；2.在右半部分；3.横跨。复杂度为O(NlogN)
     * 前两种情况可以递归求解，第三种情况的最大和可以通过求出前半部分（包含前半部分的最后一个元素）的最大和
     * 以及后半部分（包括后半部分的第一个元素）的最大和，再将二者相加得到。
     *
     * @param arr
     * @return
     */
    public static int solution3(int[] arr) {
        return maxSubArray(arr, 0, arr.length - 1);
    }

    private static int maxSubArray(int[] arr, int left, int right) {
        if (left == right) {  //Base Case
            if (arr[left] > 0) {
                return arr[left];
            } else {
                return 0;
            }
        }
        int middle = left + (right - left) / 2;
        //左半部分的最大子序列和
        int maxSubOfLeft = maxSubArray(arr, left, middle);  //递归过程调用的一般形式是传递输入的数组和左右边界，它们界定了数组要被处理的部分。
        //右半部分的最大子序列和
        int maxSubOfRight = maxSubArray(arr, middle + 1, right);
        //左半部分包含最右元素的最大子序列和
        int maxLeftBorderSum = 0, leftBorderSum = 0;
        for (int i = middle; i >= left; i--) {
            leftBorderSum += arr[i];
            if (leftBorderSum > maxLeftBorderSum) {
                maxLeftBorderSum = leftBorderSum;
            }
        }
        //右半部分包含最左元素的最大子序列和
        int maxRightBorderSum = 0, rightBorderSum = 0;
        for (int i = middle; i >= left; i--) {
            rightBorderSum += arr[i];
            if (rightBorderSum > maxRightBorderSum) {
                maxRightBorderSum = rightBorderSum;
            }
        }
        return max(maxSubOfLeft, maxSubOfRight, maxLeftBorderSum + maxRightBorderSum);
    }

    public static int max(int a, int b, int c) {
        int max = a;
        if (b > a) {
            max = b;
        }
        if (c > a && c > b) {
            max = c;
        }
        return max;
    }

    /**
     * 复杂度为O(N)
     * 如果a[i]是负数，那么它不可能代表最优序列的起点，因为任何包含a[i]的作为起点的子序列都
     * 可以通过使用a[i+1]作为起点得到改进。类似的，任何负的子序列也不可能是最优子序列的前缀
     *
     * @param a
     * @return
     */
    public static int solution4(int[] a) {
        int maxSum = 0, curSum = 0;
        for (int i = 0; i < a.length; i++) {
            curSum += a[i];
            if (curSum > maxSum) {
                maxSum = curSum;
            }
            if (curSum < 0) { //和为负只会拖后腿，故归零
                curSum = 0;
            }
        }
        return maxSum;
    }


}
