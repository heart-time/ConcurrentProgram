package com.hundsun.tbsp.algorithm;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author ouyzh49490
 * @PackageName com.hundsun.tbsp.algorithm
 * @Description
 * @date 2023/11/27 10:37
 */
public class Demo15 {
    /**
     * 找出所有相加之和为 n 的 k 个数的组合，且满足下列条件：
     * 只使用数字1到9
     * 每个数字 最多使用一次
     */
    List<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> tempList = new LinkedList<>();
    int total = 0;

    public List<List<Integer>> combinationSum3(int k, int n) {
        handle(k, n, 1);
        return result;
    }

    public void handle(int k, int n, int startIndex) {
        if (n == total && tempList.size() == k) {
            result.add(new ArrayList<>(tempList));
            return;
        }
        if (tempList.size() == k) {
            return;
        }
        for (int i = startIndex; i <= 9; i++) {
            tempList.add(i);
            total += i;
            handle(k, n, i + 1);
            tempList.removeLast();
            total -= i;
        }
    }


    @Test
    public void test1() {
        System.out.println(combinationSum3(3, 9));
    }
}
