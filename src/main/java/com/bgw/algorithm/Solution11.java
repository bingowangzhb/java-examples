package com.bgw.algorithm;

/**
 * Solution11
 *
 * @author zhibin.wang
 * @since 2021/03/29 15:34
 */
public class Solution11 {


    public static void main(String[] args) {
    }


    public int maxArea(int[] height) {
        int h = 0, t = height.length - 1;
        int l, s;
        int maxSquare = 0;
        while (h != t) {
            l = Math.min(height[h], height[t]);
            s = l * (t - h);

            maxSquare = Math.max(s, maxSquare);
            if (height[h] >= height[t]) {
                t--;
            }
            else {
                h++;
            }
        }

        return maxSquare;
    }
}
