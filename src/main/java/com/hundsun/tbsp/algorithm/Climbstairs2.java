package com.hundsun.tbsp.algorithm;

import java.util.Scanner;

/**
 * @author ouyzh49490
 * @PackageName com.hundsun.tbsp.algorithm
 * @Description
 * @date 2023/12/22 16:13
 */
public class Climbstairs2 {
    /**
     * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
     * <p>
     * 每次你可以爬至多m (1 <= m < n)个台阶。你有多少种不同的方法可以爬到楼顶呢？
     * <p>
     * 注意：给定 n 是一个正整数。
     * <p>
     * 输入描述
     * 输入共一行，包含两个正整数，分别表示n, m
     * 输出描述
     * 输出一个整数，表示爬到楼顶的方法数。
     * 输入示例
     * 3 2
     * 输出示例
     * 3
     * 提示信息
     * 数据范围：
     * 1 <= m < n <= 32;
     * <p>
     * 当 m = 2，n = 3 时，n = 3 这表示一共有三个台阶，m = 2 代表你每次可以爬一个台阶或者两个台阶。
     * <p>
     * 此时你有三种方法可以爬到楼顶。
     * <p>
     * 1 阶 + 1 阶 + 1 阶段
     * 1 阶 + 2 阶
     * 2 阶 + 1 阶
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n  = sc.nextInt();
        int m = sc.nextInt();
        System.out.println(climbStairs(m, n));
    }
    public static int climbStairs(int m, int n) {
        if (n==1){
            return 1;
        }
        int dp[] = new int[n + 1];

        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (i-j<0){
                    break;
                }
                dp[i] += dp[i - j];
            }
        }
        return dp[n];
    }
}
