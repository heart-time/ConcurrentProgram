package com.hundsun.tbsp.algorithm;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author ouyzh49490
 * @PackageName com.hundsun.tbsp.algorithm
 * @Description
 * @date 2024/1/10 14:58
 */
public class Demo93 {
    public int findLHS(int[] nums) {
        Arrays.sort(nums);
        int left = 0;
        int right = 1;
        int max = 0;
        while (left < right && right < nums.length) {
            if (nums[left] + 1 == nums[right]) {
                right++;
                max = max > (right - left) ? max : (right - left);
            } else {
                left++;
            }
        }
        return max;

    }
    @Test
    public void tset1(){
        int nums[] ={1,2,3,4};
        System.out.println(findLHS(nums));
    }
}
