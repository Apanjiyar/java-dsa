package com.dsa.arrays;

import java.util.Arrays;

public class Temp {

    public static void main(String[] args){
        
        int[] arr = new int[]{1, 3, 6, 7, 8, 9, 10, 19, 20, 21, 23, 25, 26, 27, 28, 30, 31, 33};
        countTriplets(86, arr);

    }

    public static int countTriplets(int sum, int arr[]) {
        // code here
        
        int result = 0;
        
        // Sorting 
        Arrays.sort(arr);
        
        for(int i = 0; i < arr.length - 2; i++) {
            int left = i + 1;
            int right = arr.length - 1;
            
           while(left < right) {
                int s = arr[i] + arr[left] + arr[right];
                
                if(s < sum) {
                    result++;
                } 
                right--;
            }
        }
        return result;
    }
}
