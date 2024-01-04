package com.hundsun.tbsp.algorithm;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author ouyzh49490
 * @PackageName com.hundsun.tbsp.algorithm
 * @Description
 * @date 2023/12/1 11:18
 */
public class Demo22 {

    /**
     * 给你一个整数数组 nums ，其中可能包含重复元素，请你返回该数组所有可能的子集（幂集）。
     *
     * 解集 不能 包含重复的子集。返回的解集中，子集可以按 任意顺序 排列。
     *
     *
     *
     * 示例 1：
     *
     * 输入：nums = [1,2,2]
     * 输出：[[],[1],[1,2],[1,2,2],[2],[2,2]]
     * 示例 2：
     *
     * 输入：nums = [0]
     * 输出：[[],[0]]
     */
    List<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> list = new LinkedList<>();
    boolean[] flag ;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        flag = new boolean[nums.length];
        Arrays.sort(nums);
        handle(nums,0);
        result.add(new ArrayList<>());
        return result;
    }
    public void handle(int[] nums , int startIndex){
        if(startIndex>nums.length-1){
            return ;
        }
        for (int i = startIndex; i < nums.length; i++) {
            if(i>0&&nums[i]==nums[i-1]&&!flag[i-1]){
                continue;
            }
            flag[i]=true;
            list.offer(nums[i]);
            result.add(new ArrayList<>(list));
            handle(nums,i+1);
            list.removeLast();
            flag[i]=false;
        }
    }
    //[[],[1],[1,4]]
    //[4,4,4,4,1]
    // [4,4,1,4],[4,4,4],[4,1],[4,1,4],[4,4],[1],[1,4],[4],[]]
    @Test
    public void test1(){
        int[] nums ={4,4,4,1,4};
        System.out.println(subsetsWithDup(nums));
    }
}
