package com.hundsun.tbsp.algorithm;

import org.junit.Test;

/**
 * @author ouyzh49490
 * @PackageName com.hundsun.tbsp.algorithm.DynamicProgram
 * @Description
 * @date 2023/12/11 10:16
 */
public class CanPartition {
    /**
     * 给你一个 只包含正整数 的 非空 数组 nums 。
     * 请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
     * <p>
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入：nums = [1,5,11,5]
     * 输出：true
     * 解释：数组可以分割成 [1, 5, 5] 和 [11] 。
     * 示例 2：
     * <p>
     * 输入：nums = [1,2,3,5]
     * 输出：false
     * 解释：数组不能分割成两个元素和相等的子集。
     */

    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        if (sum%2!=0){
            return false;
        }
        int dp[] = new int[sum/2+1];
        for (int i = 0; i < nums.length; i++) {
            for (int j = sum/2; j >= nums[i]; j--) {
                dp[j] =Math.max(dp[j],dp[j-nums[i]]+nums[i]);
            }
        }
        return dp[sum/2] == sum/2;
    }

    @Test
    public void test98() {
        int nums[] = {1, 1};
        System.out.println(canPartition(nums));
    }
}
