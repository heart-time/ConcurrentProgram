package com.hundsun.tbsp.algorithm;

import org.junit.Test;

import java.util.LinkedList;

/**
 * @author ouyzh49490
 * @PackageName com.hundsun.tbsp.algorithm
 * @Description
 * @date 2024/4/2 14:16
 */
public class RestoreArray {
    @Test
    public void test() {
        int[][] a = {{4, -2}, {1, 4}, {-3, 1}};
        int[] ints = restoreArray(a);
        for (int i = 0; i < ints.length; i++) {
            System.out.println(ints[i] + " ");
        }
    }

    public int[] restoreArray(int[][] adjacentPairs) {
        int result[] = new int[adjacentPairs.length + 1];
        int length = adjacentPairs.length + 1;
        boolean isUsed[] = new boolean[length - 1];

        LinkedList<Integer> list = new LinkedList<>();
        if (adjacentPairs == null) {
            return result;
        }
        /**
         *  4 -2
         *  1 4
         *  -3 1
         *
         *
         *  2 1
         *  3 4
         *  3 2
         */
        for (int i = 0; i < adjacentPairs.length; i++) {
            list.offer(adjacentPairs[i][0]);
            list.offer(adjacentPairs[i][1]);
            isUsed[i] = true;
            for (int j = 0; j < length - list.size(); j++) {
                int num = 0;
                for (int k = 0; k < length - 1 ; k++) {
                    if (k == i) {
                        continue;
                    }
                    if (!isUsed[k] && list.peekLast() == adjacentPairs[k][0]) {
                        list.offer(adjacentPairs[k][1]);
                        isUsed[k] = true;
                    } else if (!isUsed[k] && list.peekLast() == adjacentPairs[k][1]) {
                        list.offer(adjacentPairs[k][0]);
                        isUsed[k] = true;
                    }
                }
            }
            if (list.size() != adjacentPairs.length + 1) {
                list.clear();
                isUsed = new boolean[length - 1];
            }else {
                break;
            }
        }
        Integer[] array = new Integer[length + 1];
        list.toArray(array);
        for (int i = 0; i < length; i++) {
            result[i] = array[i];
        }
        return result;
    }

}
