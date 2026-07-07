package com.dsa.arrays;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

/**
 * Find the kth maximum and minimum element in an array
 * https://leetcode.com/problems/kth-largest-element-in-an-array/description/
 */
public class Problem3 {

    public static void main(String[] args) {
        int[] arr = {-1, 100, -10, 50, 5};
        int k = 2;

        System.out.println("Approach 1: Sorting" );
        approach1(arr, k);

        System.out.println("Approach 2: Stream" );
        approach2(arr, k);

        System.out.println("Approach 3: Heap" );
        approach3(arr, k);

    }

    /**
    * Sorting Approach (⭐⭐⭐)
    * Time: O(n log n)
    * Space: O(1)
    */
    private static void approach1(int[] arr, int k) {
        Arrays.sort(arr);
        System.out.println(k + "th Maximum element: " + arr[arr.length - k]);
        System.out.println(k + "th Minimum element: " + arr[k - 1]);
    }

    /**
    * Stream Approach (⭐⭐)
    * Time: O(n log k)
    * Space: O(k)
    */
    private static void approach2(int[] arr, int k) {
        int kthMax = Arrays.stream(arr)
                .boxed()
                .sorted(Collections.reverseOrder())
                .distinct()
                .skip(k - 1)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("k is larger than the number of distinct elements"));

        int kthMin = Arrays.stream(arr)
                .boxed()
                .sorted()
                .distinct()
                .skip(k - 1)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("k is larger than the number of distinct elements"));

        System.out.println(k + "th Maximum element: " + kthMax);
        System.out.println(k + "th Minimum element: " + kthMin);
        
    }

    /**
    * Heap Approach (⭐⭐⭐⭐⭐)
    * What is heap?
    *   A Heap is a specialized, tree-based data structure that satisfies two main rules: 
    *   it must be a complete binary tree (all levels are fully filled except possibly the last) and 
    *   it must follow the "heap property" (parents are either strictly greater or less than their children)
    * 
    * What is a min-heap?
    *   A min-heap is a binary tree where the value of each parent node is less than or equal to the values of its children.
    * 
    * What is a max-heap?
    *   A max-heap is a binary tree where the value of each parent node is greater than or equal to the values of its children.
    * 
    * What is heapify?
    *   Heapify is the process of converting an array into a heap data structure.   
    *   heapify-up: If a node violates the heap property, we can swap it with its parent and continue this process until the heap property is restored.
    *   heapify-down: If a node violates the heap property, we can swap it with its child and continue this process until the heap property is restored.
    * 
    * Time: O(n log k)
    * Space: O(k)
    */
    private static void approach3(int[] arr, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(); // min-heap: parents are less than children
        for(int num : arr) {
            minHeap.offer(num);
            if(minHeap.size() > k) {
                minHeap.poll(); // remove the smallest element
            }
        }
        System.out.println(k + "th Maximum element: " + minHeap.peek());

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder()); // max-heap: parents are greater than children
        for(int num : arr) {
            maxHeap.offer(num);
            if(maxHeap.size() > k) {
                maxHeap.poll(); // remove the largest element
            }
        }
        System.out.println(k + "th Minimum element: " + maxHeap.peek());

    }

    /**
    * Quick Select Approach (⭐⭐)
    * Time: O(n)
    * Space: O(1)
    */
    private static void approach4(int[] arr, int k) {
    
    }


    
}
