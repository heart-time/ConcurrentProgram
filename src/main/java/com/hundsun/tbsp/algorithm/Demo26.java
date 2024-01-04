package com.hundsun.tbsp.algorithm;

import org.junit.Test;

/**
 * @author ouyzh49490
 * @PackageName com.hundsun.tbsp.algorithm
 * @Description
 * @date 2023/12/5 22:32
 */
public class Demo26 {
    public int uniquePaths(int m, int n) {

        int dp[][] = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i==0){
                    dp[0][j]=1;
                }
                if(j==0){
                    dp[i][j]=1;
                }
            }
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j <n ; j++) {
                dp[i][j] = dp[i-1][j] +dp[i][j-1];
            }
        }

        return dp[m-1][n-1];
    }
    @Test
    public void test1(){
        System.out.println(uniquePaths(3, 7));
    }
}
