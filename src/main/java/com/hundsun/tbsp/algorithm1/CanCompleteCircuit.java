package com.hundsun.tbsp.algorithm1;

import java.util.ArrayList;

/**
 * @author ouyzh49490
 * @PackageName com.hundsun.tbsp.algorithm1
 * @Description
 * @date 2024/4/9 15:42
 */
public class CanCompleteCircuit {
    public static void main(String[] args) {
        int gas[] = {5, 8, 2, 8};
        int cost[] = {6, 5, 6, 6};
        System.out.println(canCompleteCircuit(gas, cost));
    }
    public static int canCompleteCircuit(int[] gas, int[] cost) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < gas.length; i++) {
            if (gas[i] - cost[i] >= 0) {
                list.add(i);
            }
        }
        int result = -1;
        for (int i = 0; i < list.size(); i++) {
            int startIndex = list.get(i);
            int currentIndex = list.get(i);
            int remainGaps = 0;
            while (true) {
                remainGaps += gas[currentIndex] - cost[currentIndex];
                if (remainGaps < 0) {
                    break;
                }
                currentIndex++;
                if (currentIndex == gas.length) {
                    currentIndex = 0;
                }
                if (currentIndex == startIndex) {
                    result = list.get(i);
                    break;
                }
            }

        }

        return result;
    }

}
