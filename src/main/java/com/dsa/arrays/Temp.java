package com.dsa.arrays;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import lombok.val;

public class Temp {

    public static void main(String[] args){
        char[] chars = {'a','a','b','b','c','c','c'};
        System.out.println(compress(chars));
    }

    public static boolean increasingTriplet(int[] nums) {
        
        for(int i = 0; i < nums.length; i++) {
            int left = i + 1;
            int right = nums.length - 1; 
            
            while(left < right) {
                if(nums[i] < nums[left] && nums[left] < nums[right]) {
                    return true;
                } else if (nums[i] > nums[left]){
                    left++;
                } else {
                    right--;
                }
            }
        }
        return false;
    }
}
