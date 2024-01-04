package com.hundsun.tbsp.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author ouyzh49490
 * @PackageName com.hundsun.tbsp.algorithm
 * @Description
 * @date 2023/11/29 19:32
 */
public class Demo18 {
    List<List<Integer>> result = new ArrayList<List<Integer>>();
    LinkedList<Integer> temp = new LinkedList<Integer>();
    int total = 0;
    boolean isused[];



    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if (candidates == null || candidates.length == 0) {
            return result;
        }
        isused = new boolean[candidates.length];
        Arrays.sort(candidates);
        handle(candidates, target, 0);
        return result;
    }

    public void handle(int[] candidates, int target, int start) {
        if (total == target) {
            result.add(new ArrayList<>(temp));
            return;
        }
        if (total > target) {
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            if(i>=1&&candidates[i]==candidates[i-1]&&!isused[i-1]){
                continue;
            }
            isused[i] =true;

            temp.offer(candidates[i]);
            total += candidates[i];
            handle(candidates, target, i + 1);
            total -= candidates[i];
            isused[i]=false;
            temp.removeLast();

        }
    }
}
