package com.dsa.arrays;

public class Temp {

    public static void main(String[] args){
        int[] nums1 = {0};
        segregate0and1()

    }

    void segregate0and1(int[] arr) {
        // code here
        int left = 0;
        int right = 0;
        while (left <= right) {
            if(arr[left] == 1 && arr[right] == 0) {
                arr[left] = 0;
                arr[right] = 1;
                left++; right--;
            }
            else if(arr[left] == 0) {
                left++;
            } else if(arr[right] == 1) {
                right--;
            }
        }
    }
}
