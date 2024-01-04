package com.hundsun.tbsp.algorithm;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ouyzh49490
 * @PackageName com.hundsun.tbsp.algorithm
 * @Description
 * @date 2023/12/20 14:01
 */
public class LastStoneWeight {
    /**
     * 有一堆石头，用整数数组 stones 表示。其中 stones[i] 表示第 i 块石头的重量。
     * <p>
     * 每一回合，从中选出任意两块石头，然后将它们一起粉碎。假设石头的重量分别为 x 和 y，
     * 且 x <= y。那么粉碎的可能结果如下：
     * <p>
     * 如果 x == y，那么两块石头都会被完全粉碎；
     * 如果 x != y，那么重量为 x 的石头将会完全粉碎，而重量为 y 的石头新重量为 y-x。
     * 最后，最多只会剩下一块 石头。返回此石头 最小的可能重量 。如果没有石头剩下，就返回 0。
     * <p>
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入：stones = [2,7,4,1,8,1]
     * 输出：1
     * 解释：
     * 组合 2 和 4，得到 2，所以数组转化为 [2,7,1,8,1]，
     * 组合 7 和 8，得到 1，所以数组转化为 [2,1,1,1]，
     * 组合 2 和 1，得到 1，所以数组转化为 [1,1,1]，
     * 组合 1 和 1，得到 0，所以数组转化为 [1]，这就是最优值。
     * <p>
     * 示例 2：
     * 输入：stones = [31,26,33,21,40]
     * 输出：5
     */
    public int lastStoneWeightII(int[] stones) {
        int total = 0;
        for (int i = 0; i < stones.length; i++) {
            total += stones[i];
        }
        int sum = total / 2;
        int dp[] = new int[sum+1];
        for (int i = 0; i < stones.length; i++) {
            for (int j = sum; j >= stones[i] ; j--) {
                dp[j] = Math.max(dp[j],dp[j-stones[i]]+stones[i]);
            }
        }
        return  total - 2*dp[sum];
    }

    @Test
    public void test() {
        int stones[] = {2,7,4,1,8,1};
        int result = lastStoneWeightII(stones);
        System.out.println(result);
    }
}