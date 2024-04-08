package com.hundsun.tbsp.algorithm;

import org.junit.Test;

import java.util.*;

/**
 * @author ouyzh49490
 * @PackageName com.hundsun.tbsp.algorithm
 * @Description
 * @date 2024/3/8 15:56
 */
public class Demo29 {
    /**
     * 给你一个整数数组 nums ，找出并返回所有该数组中不同的递增子序列，递增子序列中 至少有两个元素 。你可以按 任意顺序 返回答案。
     * <p>
     * 数组中可能含有重复元素，如出现两个整数相等，也可以视作递增序列的一种特殊情况。
     * 输入：nums = [4,6,7,7]
     * 输出：[[4,6],[4,6,7],[4,6,7,7],[4,7],[4,7,7],[6,7],[6,7,7],[7,7]]
     * 示例 2：
     * <p>
     * 输入：nums = [4,4,3,2,1]
     * 输出：[[4,4]]
     */
    ArrayList<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> temp = new LinkedList<>();
    boolean[] isUsed;

    public List<List<Integer>> findSubsequences(int[] nums) {
        if (nums == null) {
            return result;
        }
        isUsed = new boolean[nums.length];
        findIncreaseSub(nums, 0);
        return result;
    }

    private void findIncreaseSub(int[] nums, int startIndex) {
        if (startIndex > nums.length - 1) {
            return;
        }

        for (int i = startIndex; i < nums.length; i++) {
            int theSameEleIndex = findTheSameEleIndex(nums, nums[i], i);
            if (i > 0 && theSameEleIndex != -1 && !isUsed[theSameEleIndex]) {
                continue;
            }
            isUsed[i] = true;
            if (!temp.isEmpty() && nums[i] >= temp.peekLast()) {
                temp.add(nums[i]);
            } else if (temp.isEmpty()) {
                temp.add(nums[i]);
            } else {
                continue;
            }

            if (temp.size() >= 2) {
                result.add(new ArrayList<>(temp));
            }
            findIncreaseSub(nums, i + 1);
            isUsed[i] = false;
            temp.pollLast();
        }
    }

    private int findTheSameEleIndex(int[] nums, int num, int index) {
        int eleIndex = -1;
        for (int i = 0; i < index; i++) {
            if (nums[i] == num) {
                 eleIndex = i;
                 break;
            }
        }
        return eleIndex;
    }

    @Test
    public void main() {
        int nums[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 1, 1, 1, 1, 1};

        findSubsequences(nums);
        System.out.println(result);
    }
}

