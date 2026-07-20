package com.dsa.arrays;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import lombok.val;

public class Temp {

    public static void main(String[] args){
        int[] nums = {2,3,1,2,4,3};
        int target = 7;
        System.out.println(minSubArrayLen(target, nums));
    }

    public static int minSubArrayLen(int target, int[] nums) {

        int result = 0;

        int i = 0;
        int j = 0;
        int sum = 0;

        while(j < nums.length) {
            sum += nums[j];
            if(sum >= target) {
                result = j - i + 1;
            }
            while(sum >= target) {
                sum -= nums[i];
                i++;
                if(sum >= target) {
                    result = j - i + 1;
                }
            }
            j++;
        }

        return result;
        
    }
}
