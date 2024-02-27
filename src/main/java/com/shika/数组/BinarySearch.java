package com.shika.数组;

/**
 * 二分查找
 */
public class BinarySearch {
    public static int bSearch(int[] nums, int target) {
        return bSearch(nums, nums.length, target);
    }

    public static int bSearch(int[] nums, int n, int target) {
        return bSearch(nums, 0, n - 1, target);
    }

    public static int bSearch(int[] nums, int low, int high, int target) {
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] > target) {
                high = mid - 1;
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public static int bSearchRecursion(int[] nums, int low, int high, int target) {
        int mid = low + (high - low) / 2;
        //先判断是否相等
        if (nums[mid] == target) {
            return mid;
        }
        //最终会low >= high，代表没找到
        if (low >= high) {
            return -1;
        } else if (nums[mid] > target) {
            //别忘了“return”，易犯的错误
            return bSearchRecursion(nums, low, mid - 1, target);
        } else if (nums[mid] < target) {
            return bSearchRecursion(nums, mid + 1, high, target);
        }
        return -1;
    }

    /**
     * 自己摸索的写法
     */
    public static int search(int[] nums, int target) {
        int high = nums.length - 1;
        int low = 0;
        int middle;
        while (high >= low) {
            if (high == low) {
                if (nums[high] == target) {
                    return high;
                }
                break;
            }
            if (high == low + 1) {
                if (nums[high] == target) {
                    return high;
                }
                if (nums[low] == target) {
                    return low;
                }
                break;
            }
            middle = (high + low) / 2;
            if (nums[middle] > target) {
                high = middle;
            } else if (nums[middle] < target) {
                low = middle;
            } else {
                return middle;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {-1, 0, 3, 5, 9, 12};
        assert bSearch(nums, 9) == 4;
        assert bSearch(nums, 2) == -1;
        assert search(nums, 9) == 4;
        assert search(nums, 2) == -1;
    }
}
