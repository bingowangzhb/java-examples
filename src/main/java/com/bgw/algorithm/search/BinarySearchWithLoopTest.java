package com.bgw.algorithm.search;

/**
 * BinarySearchWithLoopTest
 *
 * @author wang
 * @since 2020/8/10 23:43
 **/
public class BinarySearchWithLoopTest {

    public static void main(String[] args) {

        int[] nums = {8, 11, 19, 23, 27, 33, 45, 55, 67, 98, 100};

        BinarySearchWithLoopTest loopTest = new BinarySearchWithLoopTest();
        System.out.println("loopTest.binarySearch(nums, 33) = " + loopTest.binarySearch(nums, 33));
    }

    public int binarySearch(int[] a, int val) {
        int low = 0, high = a.length - 1;
        while (low <= high) {
            int mid = (low + high) >> 1;
            if (a[mid] == val) {
                 return mid;
            } else if (a[mid] > val) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return -1;
    }


}
