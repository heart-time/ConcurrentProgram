package com.hundsun.tbsp.algorithm;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author ouyzh49490
 * @PackageName com.hundsun.tbsp.algorithm
 * @Description
 * @date 2023/12/1 11:02
 */
public class Demo21 {
    /**
     * 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
     * <p>
     * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
     * <p>
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入：nums = [1,2,3]
     * 输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
     * 示例 2：
     * <p>
     * 输入：nums = [0]
     * 输出：[[],[0]]
     */
    List<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> list = new LinkedList<>();

    public List<List<Integer>> subsets(int[] nums) {
        handle(nums,0);
        result.add(new ArrayList<>());
        return result;
    }

    public void handle(int[] nums,int startIndex) {

        if(startIndex>=nums.length){
            return;
        }

        for (int i = startIndex; i < nums.length ; i++) {
            list.offer(nums[i]);
            result.add(new ArrayList<>(list));
            handle(nums,i+1);
            list.removeLast();
        }

    }
    @Test
    public void test1(){
        int[] nums = {1,2,3};
        System.out.println(subsets(nums));
    }
}
