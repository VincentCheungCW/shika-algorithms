package com.shika;

/**
 * 二分查找
 */
public class BinarySearch {
    public static int bSearch(int[] arr, int key) {
        return bSearch(arr, arr.length, key);
    }

    public static int bSearch(int[] arr, int n, int key) {
        return bSearch(arr, 0, n - 1, key);
    }

    public static int bSearch(int[] arr, int low, int high, int key) {
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] > key) {
                high = mid - 1;
            } else if (arr[mid] < key) {
                low = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public static int bSearchRecursion(int[] arr, int low, int high, int key) {
        int mid = low + (high - low) / 2;
        //先判断是否相等
        if (arr[mid] == key) {
            return mid;
        }
        //最终会low >= high，代表没找到
        if (low >= high) {
            return -1;
        } else if (arr[mid] > key) {
            //别忘了“return”，易犯的错误
            return bSearchRecursion(arr, low, mid - 1, key);
        } else if (arr[mid] < key) {
            return bSearchRecursion(arr, mid + 1, high, key);
        }
        return -1;
    }
}
