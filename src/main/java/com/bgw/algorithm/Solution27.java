package com.bgw.algorithm;

import java.util.Random;

/**
 * Solution27
 *
 * @author zhibin.wang
 * @since 2021/03/30 15:17
 */
public class Solution27 {

    public int removeElement(int[] nums, int val) {
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != val) {
                nums[i] = nums[j];
                i++;
            }
        }
        return i;
    }

    public static void main(String[] args) {
        Solution27 solution = new Solution27();
        int[] a = {1,3,3,4,4,5,1,3,3};

        int result = solution.removeElement(a, 3);
        System.out.println("result = " + result);

        Random r = new Random();
        System.out.println("r.nextInt(1) = " + r.nextInt(1));

    }
}
