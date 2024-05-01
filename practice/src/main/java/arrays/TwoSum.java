package main.java.arrays;

import java.util.Arrays;
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
        System.out.println(Arrays.toString(twoSum(new int[]{2, 7, 11, 15}, 9)));
        System.out.println(Arrays.toString(twoSum2(new int[]{2, 7, 11, 15}, 9)));
    }

    private static int[] twoSum(int[] arr, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i=0; i < arr.length; i++) {
            int diff = target - arr[i];
            if (map.containsKey(diff)) {
                return new int[]{map.get(diff), i};
            }
            map.put(arr[i], i); //put current element, index in map
        }
        throw new IllegalArgumentException("target not found");
    }

    public static int[] twoSum2(int[] numbers, int target) { // sort copy of array, start+end==target / if greater then end-- else start++ , find the elements in og array for index positions
        int arr[]=new int[2];
        int n=numbers.length;
        int arr2[]=new int[n];
        for(int i=0;i<n;i++)
        {
            arr2[i]=numbers[i];  //copying array to a newer array
        }

        Arrays.sort(arr2); //sorting new array to apply 2 pointers
        boolean flag=false;

        int start=0, end=n-1;

        while (start<end)
        {
            int sum=arr2[start]+arr2[end];
            if(sum==target)
            {
                flag=true;
                arr[0]=arr2[start]; //copy values not index
                arr[1]=arr2[end];
                break;
            }
            else if(sum>target) end--;
            else start++;
        }
        if(flag==true)
        {
            for(int i=0;i<n;i++)
            {
                if(arr[0]==numbers[i])
                {
                    arr[0]=i;
                    break;
                }
            }
            for(int i=0;i<n;i++)
            {
                if(i!=arr[0] && arr[1]==numbers[i])
                {
                    arr[1]=i;
                    break;
                }
            }
        }
        return arr;
    }
}
