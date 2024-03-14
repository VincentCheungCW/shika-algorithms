package com.shika.leetcode;

import java.util.HashMap;
import java.util.Map;

class TwoSum {
  public int[] twoSum(int[] nums, int target) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      map.put(nums[i], i);
    }
    for (int i = 0; i < nums.length; i++) {
      int j = target - nums[i];
      if (map.containsKey(j) && map.get(j) != i) {  //注意点1：map.containsKey而非hasKey
        //注意点2 map.get(j) != i，同一个元素不能用两次
        return new int[]{i, map.get(j)};
      }
    }
    return new int[]{};
  }
}

//判断元素在不在 hash 的 key 里的时间复杂度仅为 O（1）！
//time complexity：big O of n
//space complexity：所谓的空间换时间，开辟了一个 hash map ，空间复杂度变为 O（n）