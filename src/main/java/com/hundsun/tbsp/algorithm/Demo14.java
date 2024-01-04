package com.hundsun.tbsp.algorithm;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author ouyzh49490
 * @PackageName com.hundsun.tbsp.algorithm
 * @Description
 * @date 2023/11/26 15:49
 */
public class Demo14 {
    List<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> tempList = new LinkedList<>();
    public void backTracking(int n ,int k,int startIndex){
        if(tempList.size()==k){
            result.add(new ArrayList<>(tempList));
        }
        for (int i = startIndex; i < n; i++) {
            tempList.offer(i);
            backTracking(n,k,i+1);
            tempList.removeLast();
        }
    }
}
