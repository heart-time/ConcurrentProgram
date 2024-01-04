package com.hundsun.tbsp.algorithm;

import org.junit.Test;

/**
 * @author ouyzh49490
 * @PackageName com.hundsun.tbsp.algorithm
 * @Description
 * @date 2023/12/6 9:58
 */
public class IntegerBreak {
    /**
     * 给定一个正整数 n ，将其拆分为 k 个 正整数 的和（ k >= 2 ），并使这些整数的乘积最大化。
     * 返回 你可以获得的最大乘积 。
     * 示例 1:
     * 输入: n = 2
     * 输出: 1
     * 解释: 2 = 1 + 1, 1 × 1 = 1。
     * 示例 2:
     * <p>
     * 输入: n = 10
     * 输出: 36
     * 解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36。
     *
     * @param n
     * @return
     */
    public int integerBreak(int n) {

        int dp[] = new int[n+1];
        for (int i = 1; i <=n ; i++) {
            for (int j = 1; j <= i/2 ; j++) {
                if(i<=4){
                    dp[i] = i ;
                    break;
                }else {
                    dp[i] = Math.max(dp[i],dp[i-j]*dp[j]);
                }
            }
        }
        dp[1]=1;
        dp[2]=1;
        if(n>2){
            dp[3]=2;
        }
        return dp[n];
    }
    @Test
    public void test(){
        System.out.println(integerBreak(3));
    }
}
