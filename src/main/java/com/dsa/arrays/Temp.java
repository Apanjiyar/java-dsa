package com.dsa.arrays;

public class Temp {

    public static void main(String[] args){
        int[] nums1 = {0};
        int m = 0; 
        int[] nums2 = {1}; 
        int n = 1;
        merge(nums1, m, nums2, n);

    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        while(i >= 0 && j >= 0) {
            if(nums1[i] < nums2[j]) {
                nums1[i + j + 1] = nums2[j];
                j--;
            } else {
                int temp = nums2[j];
                nums1[i + j + 1] = nums1[i];
                nums1[i] = temp;
                j--; i++;
            } 
        }

        while (j >= 0) {
            nums1[j] = 
        }
    }
}
