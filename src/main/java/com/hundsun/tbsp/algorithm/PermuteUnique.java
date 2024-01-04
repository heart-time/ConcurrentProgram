package com.hundsun.tbsp.algorithm;

import org.junit.Test;

import java.util.*;

/**
 * @author ouyzh49490
 * @PackageName com.hundsun.tbsp.algorithm
 * @Description
 * @date 2023/12/4 13:31
 */
public class PermuteUnique {
    /**
     * 给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
     * <p>
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入：nums = [1,1,2]
     * 输出：
     * [[1,1,2],
     * [1,2,1],
     * [2,1,1]]
     * 示例 2：
     * <p>
     * 输入：nums = [1,2,3]
     * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
     */
    List<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> list = new LinkedList<>();
    boolean[] flag;

    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        flag = new boolean[nums.length];
        handle(nums, 0);
        return result;
    }

    public void handle(int[] nums, int startIndex) {
        if (list.size() == nums.length) {
            result.add(new ArrayList<>(list));
            return;
        }
        //{1,1,2};
        HashMap<Integer, Integer> hs = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (hs.getOrDefault(nums[i], 0) > 0) {
                continue;
            }
            if (flag[i]) {
                continue;
            }
            flag[i] = true;
            hs.put(nums[i], hs.getOrDefault(nums[i], 0) + 1);
            list.offer(nums[i]);
            handle(nums, i + 1);
            list.removeLast();
            flag[i] = false;
        }
    }

    @Test
    public void test2(){
        int[] nums ={1,1,2};
        System.out.println(permuteUnique(nums));
    }
}
