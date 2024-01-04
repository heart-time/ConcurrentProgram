package com.hundsun.tbsp.algorithm;

import java.util.Scanner;

/**
 * @author ouyzh49490
 * @PackageName com.hundsun.tbsp.algorithm
 * @Description
 * @date 2023/12/5 16:42
 */
public class Demo24 {
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
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] result = new int[n + 1];
        result[1] = 1;
        result[2] = 1;
        for (int i = 3; i <= n; i++) {
            for (int j = 1; j <= m && (i - j) >= 0; j++) {
                result[i] += result[i - j];
            }
        }
        System.out.println(result[n]);
    }
}
