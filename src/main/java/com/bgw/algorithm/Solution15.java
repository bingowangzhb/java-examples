package com.bgw.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Solution15
 *
 * @author zhibin.wang
 * @since 2021/03/29 17:54
 */
public class Solution15 {


    public List<List<Integer>> threeSum(int[] nums) {
        if (nums.length <= 1) {
            return new ArrayList<>(0);
        }

        List<List<Integer>> result = new ArrayList<>();
        int left, right = nums.length - 1;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                break;
            }

            left = i;
            List<Integer> ll = new ArrayList<>();

            while(left != right) {
                if (nums[i] + nums[left] + nums[right] == 0) {


                }

            }


        }



        return result;

    }

}
