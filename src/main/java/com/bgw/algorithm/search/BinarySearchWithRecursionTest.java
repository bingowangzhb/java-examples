package com.bgw.algorithm.search;

/**
 * BinarySearch
 *
 * @author wang
 * @since 2020/8/10 22:48
 **/
public class BinarySearchWithRecursionTest {

    public static void main(String[] args) {
        int[] nums = {8, 11, 19, 23, 27, 33, 45, 55, 67, 98, 100};

        BinarySearchWithRecursionTest bsTest = new BinarySearchWithRecursionTest();
        System.out.println("bsTest.bsearch(nums, 11) = " + bsTest.bsearch(nums, 10));
    }

    public int bsearch(int[] a, int value) {
        return searchInternally(a, value, 0, a.length - 1);
    }

    private int searchInternally(int[] a, int value, int low, int high) {
        // 递归的终止条件
        if (low > high) {
            return -1;
        }
        // 这里容易产生精度问题
        int mid = (low + high) >> 1;
        if (a[mid] == value) {
            return mid;
        } else if (a[mid] > value) {
            return searchInternally(a, value, low, mid - 1);
        } else {
            return searchInternally(a, value, mid + 1, high);
        }
    }





}
