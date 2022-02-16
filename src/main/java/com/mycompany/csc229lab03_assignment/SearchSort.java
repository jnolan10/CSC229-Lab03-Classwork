package com.mycompany.csc229lab03_assignment;

import java.time.Duration;
import java.time.Instant;

public class SearchSort {
    
    public static void main(String[] args) {
        
        int[] testArr = {5,4,20,3,7,9,11,23,14,82};
        int[] testArr1 = {5,4,20,3,7,9,11,23,14,82};
        
        bubbleSort(testArr,testArr.length);
        selectionSort(testArr1,testArr1.length);
        
        Instant startLinear = Instant.now();
        linearSearch(23,testArr);
        Instant finishLinear = Instant.now();
        
        long timeElapsedLinear = Duration.between(startLinear,finishLinear).toMillis(); //in millis
        
        System.out.println("Time (in millis) elapsed for Linear Search: " + timeElapsedLinear);
        
        Instant startBinary = Instant.now();
        binarySearch(23,testArr);
        Instant finisBinary = Instant.now();
        
        long timeElapsedBinary = Duration.between(startLinear,finishLinear).toMillis(); //in millis
        
        System.out.println("Time (in millis) elapsed for Binary Search: " + timeElapsedBinary);
        
    }
    
    public static int linearSearch(int search, int[] array) {

        for (int i = 0; i < array.length; i++) {
            if (array[i] == search) {
                return i;
            }
        }
        return -1;
    }
    
    public static int binarySearch(int search, int[] array) {
        int start = 0;
        int end = array.length - 1;

        while (start <= end) {
            int middle = (start + end) / 2;
            if (search < array[middle]) {
                end = middle - 1;
            }
            if (search > array[middle]) {
                start = middle + 1;
            }

            if (search == array[middle]) {
                return middle;
            }

        }
        return -1;
    }
    
    public static void bubbleSort(int[] a, int size) {
        int outer, inner, temp;
        for (outer = size - 1; outer > 0; outer--) {
            for (inner = 0; inner < outer; inner++) {
                if (a[inner] > a[inner + 1]) {
                    temp = a[inner];
                    a[inner] = a[inner + 1];
                    a[inner + 1] = temp;
                }
            }
        }
    }
    
    public static void selectionSort(int[] a, int size) {
        int outer, inner, min;
        for (outer = 0; outer < size
                - 1; outer++) {
            min = outer;
            for (inner = outer + 1; inner < size; inner++) {
                if (a[inner] < a[min]) {
                    min = inner;
                }
            }
            int temp = a[outer];
            a[outer] = a[min];
            a[min] = temp;
        }
    }

}
