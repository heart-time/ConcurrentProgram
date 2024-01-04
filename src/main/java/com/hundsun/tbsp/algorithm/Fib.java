package com.hundsun.tbsp.algorithm;

import org.junit.Test;

/**
 * @author ouyzh49490
 * @PackageName com.hundsun.tbsp.algorithm
 * @Description
 * @date 2023/12/4 21:32
 */
public class Fib {
    public int fib(int n) {
        if (n<2){
            return n;
        }
        int[] dp = new int[n];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i < n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n-1];
    }

    @Test
    public void test() {
        System.out.println(fib(8));
    }
}
