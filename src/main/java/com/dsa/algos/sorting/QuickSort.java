package com.dsa.algos.sorting;

/**
 * QuickSort
 * https://www.geeksforgeeks.org/dsa/quick-sort-algorithm/
 */
public class QuickSort {
    
    int partition(int array[], int start, int end) {
        int pivot = array[end]; 
        int i = (start - 1);
        for (int j = start; j < end; j++){
          
            // If current element is smaller than or
            // equal to pivot
            if (array[j] <= pivot){
                i++;

                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }

        int temp = array[i+1];
        array[i+1] = array[end];
        array[end] = temp;

        return i+1;
    }

    /**
     * The main function that implements QuickSort()
     * array[] --> Array to be sorted,
     * start  --> Starting index,
     * end  --> Ending index
     * 
     */
    void sort(int array[], int start, int end){
        if (start < end) {
            int pi = partition(array, start, end);

            // Recursively sort elements before
            // partition and after partition
            sort(array, start, pi-1);
            sort(array, pi+1, end);
        }
    }

    // Driver program
    public static void main(String args[]) {
        int[] array = {10, 7, 8, 9, 1, 5};
        int n = array.length;

        QuickSort ob = new QuickSort();
        ob.sort(array, 0, n-1);

        for (int i=0; i<n; ++i) {
            System.out.print(array[i]+" ");
        }
    }
}
