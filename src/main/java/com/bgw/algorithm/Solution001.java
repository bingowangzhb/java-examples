package com.bgw.algorithm;

import java.util.Arrays;

/**
 * Solution001
 *
 * @author zhibin.wang
 * @since 2021/03/22 16:52
 */
public class Solution001 {


    public static void main(String[] args) {
        int[] a = {-1,-2,-3,-4,-5};
        int b = -8;
        System.out.println(Arrays.toString(twoSum(a, b)));
    }


    public static int[] twoSum(int[] nums, int target) {

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }

        return null;
    }
}
