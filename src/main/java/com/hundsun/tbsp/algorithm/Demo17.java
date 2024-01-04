package com.hundsun.tbsp.algorithm;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author ouyzh49490
 * @PackageName com.hundsun.tbsp.algorithm
 * @Description
 * @date 2023/11/28 21:49
 */
public class Demo17 {
    List<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> linkedList = new LinkedList<>();
    int temp = 0 ;
    @Test
    public  void test1(){
        int [] arrays = {2,3,6,7};
        int target = 7;
        System.out.println(combinationSum(arrays, target));

    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        handle(candidates,target,0);
        return result;
    }
    public void handle(int [] candidates,int target,int startIndex){

        if(temp==target){
            result.add(new ArrayList<>(linkedList));
            return ;
        }
        if(temp>target){
            return;
        }
        for (int i = startIndex; i < candidates.length; i++) {
            linkedList.offer(candidates[i]);
            temp+=candidates[i];
            handle(candidates,target,i);
            temp-=candidates[i];
            linkedList.removeLast();
        }
    }
}
