package com.shika.数组;

public class RemoveDuplicates {

    /**
     题目：给你一个有序数组 nums ，请你 原地 删除重复出现的元素，
     使得出现次数超过两次的元素只出现两次 ，返回删除后数组的新长度。
     不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
     示例 1：
     输入：nums = [1,1,1,2,2,3]
     输出：5, nums = [1,1,2,2,3]
     解释：函数应返回新长度 length = 5, 并且原数组的前五个元素被修改为 1, 1, 2, 2, 3。 不需要考虑数组中超出新长度后面的元素。

     示例 2：
     输入：nums = [0,0,1,1,1,1,2,3,3]
     输出：7, nums = [0,0,1,1,2,3,3]
     解释：函数应返回新长度 length = 7, 并且原数组的前七个元素被修改为 0, 0, 1, 1, 2, 3, 3。不需要考虑数组中超出新长度后面的元素。
     */


    /**
     * 自己摸索的写法
     *
     * @param nums
     * @return
     */
    public static int removeDuplicates(int[] nums) {
        int i = 0;
        int j = 1;
        int shorted = 0;
        while (j < nums.length) {
            if (nums[i] == nums[j]) {
                int k = j + 1;
                while (k < nums.length - shorted && nums[k] == nums[j]) {
                    k++;
                }
                int count = k - j - 1;
                if (count > 0) {
                    shorted += count;
                    for (int m = j + 1; m + count < nums.length; m++) {
                        nums[m] = nums[m + count];
                    }
                }
            }
            i += 1;
            j += 1;
        }
        for (int n = 0; n < nums.length - shorted; n++) {
            System.out.print(nums[n]);
        }
        return nums.length - shorted;
    }

    /**
     * 因为给定数组是有序的，所以相同元素必然连续。
     * 我们可以使用双指针解决本题，遍历数组检查每一个元素是否应该被保留，
     * 如果应该被保留，就将其移动到指定位置。
     * 具体地，我们定义两个指针分别为慢指针和快指针
     *
     * @param nums
     * @return
     */
    public static int removeDuplicates2(int[] nums) {
        int n = nums.length;
        if (n <= 2) {
            return n;
        }
        int slow = 0, fast = 2;
        while (fast < n) {
            if (nums[fast] != nums[slow]) {
                nums[slow + 2] = nums[fast];
                slow++;
            }
            fast++;
        }
        return slow + 2;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2, 2, 3};
//        int res = removeDuplicates(nums);
        int[] nums2 = {0, 0, 1, 1, 1, 1, 2, 3, 3};
        int res2 = removeDuplicates2(nums2);
        System.out.println();
        System.out.println(res2);
    }
}
