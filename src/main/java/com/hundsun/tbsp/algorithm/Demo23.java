package com.hundsun.tbsp.algorithm;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * @author ouyzh49490
 * @PackageName com.hundsun.tbsp.algorithm
 * @Description
 * @date 2023/12/1 14:31
 */
public class Demo23 {
    /**
     * 给你一个整数数组 nums ，找出并返回所有该数组中不同的递增子序列，递增子序列中 至少有两个元素 。你可以按 任意顺序 返回答案。
     * <p>
     * 数组中可能含有重复元素，如出现两个整数相等，也可以视作递增序列的一种特殊情况。
     * <p>
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入：nums = [4,6,7,7]
     * 输出：[[4,6],[4,6,7],[4,6,7,7],[4,7],[4,7,7],[6,7],[6,7,7],[7,7]]
     * 示例 2：
     * <p>
     * 输入：nums = [4,4,3,2,1]
     * 输出：[[4,4]]
     */
    List<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> list = new LinkedList<>();

    public List<List<Integer>> findSubsequences(int[] nums) {
        handle(nums, 0);
        return result;
    }

    public void handle(int[] nums, int startIndex) {


        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = startIndex; i < nums.length; i++) {
            if (map.getOrDefault(nums[i], 0) >= 1) {
                continue;
            }
            if (!list.isEmpty()&&list.getLast() > nums[i]) {
                continue;
            }
            list.offer(nums[i]);
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            if (list.size() > 1) {
                result.add(new ArrayList<>(list));
            }
            handle(nums, i + 1);
            list.removeLast();
        }

    }

    @Test
    public void test1() {
        int nums[] = {4, 6, 7, 7};
        System.out.println(findSubsequences(nums));
    }


}
