package com.dsa.arrays;

public class Temp {

    public static void main(String[] args){
        ///////////////////////{0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18};
        int[] nums = new int[] {0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1};
        System.out.println(longestOnes(nums, 3));
    }

    public static int longestOnes(int[] nums, int k) {

        int flipCount = k;
        int i = 0;
        int j = 0;
        int result = 0;

        while(j < nums.length) {

            if(nums[i] == 0 && nums[j] == 0 && flipCount == 0) {
                flipCount++; i++;
            } else {
                j++;
            }

            while(j < nums.length && (nums[j] == 1 || flipCount > 0)) {
                if(nums[j] == 0){
                    flipCount--;
                }
                result = Math.max(result, j - i + 1);
                j++;
            }
            
        }   
        return result;
    }
}
