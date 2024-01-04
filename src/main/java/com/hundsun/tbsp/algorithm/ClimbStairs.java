package com.hundsun.tbsp.algorithm;

import org.junit.Test;

/**
 * @author ouyzh49490
 * @PackageName com.hundsun.tbsp.algorithm
 * @Description
 * @date 2023/12/4 21:52
 */
public class ClimbStairs {
    public int climbStairs(int n) {
        int dp[] = new int[n+1];
        dp[1]=1;
        dp[2]=2;
        for (int i = 3; i <=n ; i++) {
            dp[i] = dp[i-1]+dp[i-2];
        }
       return  dp[n];
    }
    @Test
    public void test1(){
        System.out.println(climbStairs(3));
    }
}
