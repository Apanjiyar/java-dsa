package com.dsa.arrays;

import java.util.Arrays;
import java.util.Collections;

/**
 * Find the maximum and minimum element in an array
 * https://www.geeksforgeeks.org/dsa/maximum-and-minimum-in-an-array/
 */
public class Problem2 {

    public static void main(String[] args) {
        int[] arr = {-1, 100, -10, 50, 5};

        System.out.println("Approach 1: Linear Traversal" );
        approach1(arr);

        System.out.println("Approach 2: Sorting" );
        approach2(arr);

        System.out.println("Approach 3: Stream" );
        approach3(arr);
    }

    /**
    * Linear Traversal Approach (⭐⭐⭐⭐⭐)
    * Time: O(n)
    * Space: O(1)
    */
    private static void approach1(int[] arr) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
            if (arr[i] < min) {
                min = arr[i];
            }
        }

        System.out.println("Maximum element: " + max);
        System.out.println("Minimum element: " + min);
    }

    /**
    * Sorting Approach (⭐⭐)
    * Time: O(n log n)
    * Space: O(1)
    */
    private static void approach2(int[] arr) {
        Arrays.sort(arr);
        System.out.println("Maximum element: " + arr[arr.length - 1]);
        System.out.println("Minimum element: " + arr[0]);
    }

    /**
    * Stream Approach (⭐⭐⭐)
    * Time: O(n)
    * Space: O(1)
    */
    private static void approach3(int[] arr) {
        int max = Arrays.stream(arr).max().getAsInt();
        int min = Arrays.stream(arr).min().getAsInt();

        System.out.println("Maximum element: " + max);
        System.out.println("Minimum element: " + min);
    }

    /**
    * Collections Approach (⭐⭐⭐)
    * Time: O(n)
    * Space: O(n)
    */
    private static void approach4(int[] arr) {
        int max = Collections.max(Arrays.asList(Arrays.stream(arr).boxed().toArray(Integer[]::new)));
        int min = Collections.min(Arrays.asList(Arrays.stream(arr).boxed().toArray(Integer[]::new)));

        System.out.println("Maximum element: " + max);
        System.out.println("Minimum element: " + min);
    }


    
}
