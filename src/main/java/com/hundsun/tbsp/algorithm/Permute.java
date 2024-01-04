package com.hundsun.tbsp.algorithm;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author ouyzh49490
 * @PackageName com.hundsun.tbsp.algorithm
 * @Description
 * @date 2023/12/4 10:03
 */
public class Permute {

    /**
     * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
     * <p>
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入：nums = [1,2,3]
     * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
     * 示例 2：
     * <p>
     * 输入：nums = [0,1]
     * 输出：[[0,1],[1,0]]
     * 示例 3：
     * <p>
     * 输入：nums = [1]
     * 输出：[[1]]
     *
     * @param nums
     * @return
     */
    List<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> list = new LinkedList<>();

    public List<List<Integer>> permute(int[] nums) {
        ArrayList<Integer> temp = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            temp.add(nums[i]);
        }
        int length = temp.size();
        handle(temp, 0,length);
        return result;
    }

    public void handle(List<Integer> temp, int startIndex,int length) {

        if (list.size() ==length) {
            result.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < temp.size(); i++) {
            ArrayList<Integer> list1 = getList(temp, i);

            list.add(temp.get(i));
            handle(list1, i + 1,length);
            list.removeLast();
        }
    }

    private static ArrayList<Integer> getList(List<Integer> nums, int i) {
        ArrayList<Integer> tempList = new ArrayList<>();
        for (int j = 0; j < nums.size(); j++) {
            tempList.add(nums.get(j));
        }
        tempList.remove(i);
        return tempList;
    }

    @Test
    public void test1() {
        int[] nums = {1, 2, 3};
        System.out.println(permute(nums));
    }
}
