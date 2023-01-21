package main.java;

import java.util.HashMap;
import java.util.Map;

/*
Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

        You may assume that each input would have exactly one solution, and you may not use the same element twice.

        You can return the answer in any order.

Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].


2 <= nums.length <= 104
-109 <= nums[i] <= 109
-109 <= target <= 109
Only one valid answer exists.
        */
public class TwoSum {
    public static void main(String[] args) {
        int[] arr = twoSum(new int[]{2,7,11,15},9);
    }

    private static int[] twoSum(int[] arr, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i=0; i < arr.length; i++) {
            int diff = target - arr[i];
            if (map.containsKey(diff)) {
                return new int[]{map.get(diff), i};
            }
            map.put(arr[i], i);
        }
        throw new IllegalArgumentException("target not found");
    }
}
