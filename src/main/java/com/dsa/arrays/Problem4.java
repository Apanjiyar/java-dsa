package com.dsa.arrays;

/**
 * Find the kth maximum and minimum element in an array
 * https://leetcode.com/problems/sort-colors/description/
 * https://www.geeksforgeeks.org/problems/sort-an-array-of-0s-1s-and-2s4231/1
 */
public class Problem4 {

    public static void main(String[] args){

        int[] nums = new int[]{2,0,2,1,1,0}; // Output: [0,0,1,1,2,2]

        System.out.println("Approach 1: Counting 0s, 1s and 2s" );
        approach1(nums);
        Problem1.printArray(nums);

        nums = new int[]{2,0,2,1,1,0};

        System.out.println("Approach 2: Cutch National Flag" );
        approach2(nums);
        Problem1.printArray(nums);


    }

    /**
     * Counting 0s, 1s and 2s Approach (⭐⭐⭐)
     * Time: O(n)
     * Space: O(1)
     */
    public static void approach1(int[] nums){
        int zeros = 0;
        int ones = 0;
        int twos = 0;
        for(int num : nums) {
            if(num == 0) {
                zeros++;
            }
            else if (num == 1){
                ones++;
            } else if (num ==2){
                twos++;
            }
        }
        int i = 0;
        while(zeros > 0) {
            nums[i] = 0;
            zeros--;
            i++;
        }
        while(ones > 0) {
            nums[i] = 1;
            ones--;
            i++;
        }
        while(twos > 0) {
            nums[i] = 2;
            twos--;
            i++;
        }
    }

    /**
     * Dutch National Flag Approach (⭐⭐⭐⭐⭐)
     * Time: O(n)
     * Space: O(1)
     */
    private static void approach2(int[] nums){

        int start = 0;
        int mid = 0;
        int end = nums.length - 1;

        while (mid <= end) {
            switch (nums[mid]) {
                case 0:
                    swap(nums, start, mid);
                    start++;
                    mid++;
                    break;

                case 1:
                    mid++;
                    break;

                case 2:
                    swap(nums, mid, end);
                    end--;
            }
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
