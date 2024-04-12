package com.hundsun.tbsp.algorithm1;

/**
 * @author ouyzh49490
 * @PackageName com.hundsun.tbsp.algorithm1
 * @Description
 * @date 2024/4/9 15:17
 */
public class LargestSumAfterKNegations {
    public static void main(String[] args) {
        int[] nums ={4,2,3};
        System.out.println(largestSumAfterKNegations(nums, 1));

    }
    public static int largestSumAfterKNegations(int[] nums, int k) {
        for (int i = 0; i < k; i++) {
            int index =  0;
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < nums.length; j++) {
                if (nums[j]<min){
                    min = nums[j];
                    index = j;
                }
            }
            nums[index] = - nums[index];
        }
        int total = 0;
        for (int i = 0; i < nums.length; i++) {
            total += nums[i];
        }
        return total;
    }
}
