package com.hundsun.tbsp.algorithm;

import org.junit.Test;

/**
 * @author ouyzh49490
 * @PackageName com.hundsun.tbsp.algorithm
 * @Description
 * @date 2023/12/22 14:25
 */
public class FindTargetSumWay {
    /**
     * 为为什么一维数组的背包问题要倒序遍历？
     * 这是因为背包问题都是依赖于上一层遍历的结果，进行计算的，当正序遍历时，其实已经把上一层的结果覆盖掉了，
     * 所以会导致一个物品被多次放入，而倒序遍历，每次遍历获取的值都是上一层的结果，所以不会出现重复放入物品的情况
     */

    /**
     * 给你一个非负整数数组 nums 和一个整数 target 。
     * <p>
     * 向数组中的每个整数前添加 '+' 或 '-' ，然后串联起所有整数，可以构造一个 表达式 ：
     * <p>
     * 例如，nums = [2, 1] ，可以在 2 之前添加 '+' ，在 1 之前添加 '-' ，然后串联起来得到表达式 "+2-1" 。
     * 返回可以通过上述方法构造的、运算结果等于 target 的不同 表达式 的数目。
     * <p>
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入：nums = [1,1,1,1,1], target = 3
     * 输出：5
     * 解释：一共有 5 种方法让最终目标和为 3 。
     * -1 + 1 + 1 + 1 + 1 = 3
     * +1 - 1 + 1 + 1 + 1 = 3
     * +1 + 1 - 1 + 1 + 1 = 3
     * +1 + 1 + 1 - 1 + 1 = 3
     * +1 + 1 + 1 + 1 - 1 = 3
     * 示例 2：
     * <p>
     * 输入：nums = [1], target = 1
     * 输出：1
     *
     * @param nums
     * @param target
     * @return
     */
    int count = 0;
    int result = 0;

    public int findTargetSumWays(int[] nums, int target) {
        int total = 0;
        for (int i = 0; i < nums.length; i++) {
            total += nums[i];
        }
        if ((total + target) % 2 != 0 || (total + target) < 0) {
            return 0;
        }
        int sum = (total + target) / 2;
        int dp[] = new int[sum + 1];
        dp[0] = 1;
        for (int i = 0; i < nums.length; i++) {
            for (int j = sum; j >=nums[i] ; j--) {
                dp[j] += dp[j-nums[i]];
            }
        }
        return dp[sum];
    }
    @Test
    public void test(){
        int nums[] ={1};
        int target = 1;
        System.out.println(findTargetSumWays(nums, target));
    }

    //    private void tracking(int start, int target, int[] nums) {
//        if (result == target) {
//            count++;
//            if (start < nums.length && nums[start] + result != target) {
//                return;
//            }
//
//        }
//        for (int i = start; i < nums.length; i++) {
//            list.offer(nums[i]);
//            result += nums[i];
//
//            tracking(i + 1, target, nums);
//            list.pollLast();
//            result -= nums[i];
//        }
//    }

}
