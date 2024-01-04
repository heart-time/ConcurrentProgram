package com.hundsun.tbsp.algorithm;

/**
 * @author ouyzh49490
 * @PackageName com.hundsun.tbsp.algorithm
 * @Description
 * @date 2023/11/19 18:33
 */
public class Demo4 {
    public static void main(String[] args) {

        int arrays[] = {3, 2, 1, 6, 0, 5};
        buildMaximumBinaryTree(arrays,0,arrays.length);
    }

    private static TreeNode buildMaximumBinaryTree(int[] nums,int leftIndex,int rightIndex) {
        if (rightIndex - leftIndex == 0) {
            return null;
        }
        int max = nums[leftIndex];
        int maxIndex = leftIndex;
        for (int i = leftIndex+1; i < rightIndex; i++) {
            if (nums[i] > max) {
                max = nums[i];
                maxIndex = i;
            }
        }
        TreeNode node = new TreeNode(max);
        if (rightIndex - leftIndex == 1) {
            return node;
        }
        node.left = buildMaximumBinaryTree(nums,leftIndex,maxIndex);
        node.right = buildMaximumBinaryTree(nums,maxIndex+1,rightIndex);
        return node;
    }

}
