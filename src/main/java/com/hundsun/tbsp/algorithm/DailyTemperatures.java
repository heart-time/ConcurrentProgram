package com.hundsun.tbsp.algorithm;

import org.junit.Test;

import java.util.LinkedList;

/**
 * @author ouyzh49490
 * @PackageName com.hundsun.tbsp.algorithm
 * @Description
 * @date 2023/12/26 10:09
 */
public class DailyTemperatures {
    /**
     * 给定一个整数数组 temperatures ，表示每天的温度，返回一个数组 answer ，
     * 其中 answer[i] 是指对于第 i 天，下一个更高温度出现在几天后。如果气温在这之后都不会升高，请在该位置用 0 来代替。
     * <p>
     * <p>
     * <p>
     * 示例 1:
     * <p>
     * 输入: temperatures = [73,74,75,71,69,72,76,73]
     * 输出: [1,1,4,2,1,1,0,0]
     * 示例 2:
     * <p>
     * 输入: temperatures = [30,40,50,60]
     * 输出: [1,1,1,0]
     * 示例 3:
     * <p>
     * 输入: temperatures = [30,60,90]
     * 输出: [1,1,0]
     *
     * @param
     * @return
     */
    @Test
    public void tese1() {
        int temperatures[] = {73, 74, 75, 71, 69, 72, 76, 73};
        int[] result = dailyTemperatures(temperatures);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
    }

    public int[] dailyTemperatures(int[] temperatures) {
        LinkedList<Integer> stack = new LinkedList<>();
        int len = temperatures.length;
        int result[] = new int[len];
        stack.offer(0);
        for (int i = 1; i < len; i++) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peekLast()]) {
                int index = stack.pollLast();
                result[index] = i - index;
            }
            stack.offer(i);
        }
        return result;
    }
}
