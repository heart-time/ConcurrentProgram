package com.hundsun.tbsp.algorithm;

/**
 * @author ouyzh49490
 * @PackageName com.hundsun.tbsp.algorithm.DynamicProgram
 * @Description
 * @date 2023/12/11 10:08
 */
public class Demo12 {
    public static void main(String[] args) {
        int[] weight = {1, 3, 4};
        int[] value = {15, 20, 30};
        int bagWight = 4;
        testWeightBagProblem(weight, value, bagWight);
    }

    public  static void testWeightBagProblem(int[] weight, int[] value, int bagWight) {
        int result[] = new int[weight.length + 1];
        for (int i = 0; i < weight.length; i++) {
            for (int j = bagWight; j >=value[i] ; j--) {
                result[j] = Math.max(result[j],result[j-weight[i]]+value[i]);
            }
        }
        for (int i = 0; i <= bagWight; i++) {
            System.out.print(result[i]+" ");
        }
    }
}
