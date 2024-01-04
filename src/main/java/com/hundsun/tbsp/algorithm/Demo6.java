package com.hundsun.tbsp.algorithm;

import org.junit.Test;

import java.util.LinkedList;

/**
 * @author ouyzh49490
 * @PackageName com.hundsun.tbsp.algorithm
 * @Description
 * @date 2023/11/19 23:13
 */
public class Demo6 {
    LinkedList<Integer> list = new LinkedList<>();
    int remainTotal;
    int listTotal;
    boolean flag = false;

    public boolean canPartition(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            remainTotal += nums[i];
        }
        handle(nums, 0);
        return flag;
    }

    public void handle(int nums[], int startIndex) {
        if (remainTotal == listTotal) {
            flag = true;
        }

        for (int i = startIndex; i < nums.length; i++) {
            listTotal += nums[i];
            list.offer(nums[i]);
            remainTotal -= nums[i];
            handle(nums, i + 1);
            listTotal -= list.peekLast();
            remainTotal += list.peekLast();
            list.pollLast();
        }
    }

    @Test
    public void test98() {
        int nums[] = {1, 5, 11, 5};
        System.out.println(canPartition(nums));
    }
}
