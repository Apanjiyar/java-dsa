package com.dsa.arrays;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Stack;
import java.util.stream.IntStream;

/**
 * Reverse The Array
 * https://www.geeksforgeeks.org/dsa/program-to-reverse-an-array/
 */
public class Problem1 {
  public static void main(String[] args) {
    int[] arr = {1,2,3,4,5};
    
    approach1(arr);
    System.out.println("After Two Pointer Approach:");
    printArray(arr);

    approach2(arr);
    System.out.println("After Extra Array Approach:");
    printArray(arr);

    approach3(arr, 0, arr.length - 1);
    System.out.println("After Recursion Approach:");
    printArray(arr);

    approach4(arr);
    System.out.println("After Stack Approach:"); 
    printArray(arr);

    approach5(arr);
    System.out.println("After Collections Approach:");
    printArray(arr);

    approach6(arr);
    System.out.println("After Stream Approach:");
    printArray(arr);
  }

  private static void printArray(int[] arr) {
    for (int i = 0; i < arr.length; i++) {
      System.out.print(arr[i] + " ");
    }
    System.out.println();
  }

  /**
   * Two Pointer Approach (⭐⭐⭐⭐⭐)
   * Time: O(n)
   * Space: O(1)
   */
  private static void approach1(int[] arr) {
    int i = 0, j = arr.length - 1;
    while (i < j) {
      int temp = arr[i];
      arr[i] = arr[j];
      arr[j] = temp;
      i++;
      j--;
    }
  }

  /**
   * Extra Array Approach (⭐⭐⭐)
   * Time: O(n)
   * Space: O(n)
   */
  private static void approach2(int[] arr) {
    int[] temp = new int[arr.length];
    for (int i = 0; i < arr.length; i++) {
      temp[i] = arr[arr.length - 1 - i];
    }
    for (int i = 0; i < arr.length; i++) {
      arr[i] = temp[i];
    }
  }

  /**
   * Recursion Approach (⭐⭐⭐)
   * Time: O(n)
   * Space: O(n)
   */
  private static void approach3(int[] arr, int start, int end) {
    if (start >= end) {
      return;
    }
    int temp = arr[start];
    arr[start] = arr[end];
    arr[end] = temp;
    approach3(arr, start + 1, end - 1);
  }

  /**
   * Stack Approach (⭐⭐)
   * Time: O(n)
   * Space: O(n)
   */
  private static void approach4(int[] arr) {
    Stack<Integer> stack = new java.util.Stack<>();
    for (int i = 0; i < arr.length; i++) {
      stack.push(arr[i]);
    }
    for (int i = 0; i < arr.length; i++) {
      arr[i] = stack.pop();
    }
  }

  /**
   * Collections Approach (⭐⭐)
   * Time: O(n)
   * Space: O(n)
   */
  private static void approach5(int[] arr) {
    List<Integer> list = Arrays.asList(Arrays.stream(arr).boxed().toArray(Integer[]::new));
    // Works only with objects, not int[].
    Collections.reverse(list);
    for (int i = 0; i < arr.length; i++) {
      arr[i] = list.get(i);
    }
  }

  /**
   * Stream Approach (⭐⭐)
   * Time: O(n)
   * Space: O(n)
   */
  private static void approach6(int[] arr) {
    int[] reversed = IntStream.range(0, arr.length)
        .map(i -> arr[arr.length - 1 - i])
        .toArray();
    for (int i = 0; i < arr.length; i++) {
      arr[i] = reversed[i];
    }
  }
}
