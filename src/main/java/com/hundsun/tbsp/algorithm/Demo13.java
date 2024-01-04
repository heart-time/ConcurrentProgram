package com.hundsun.tbsp.algorithm;

/**
 * @author ouyzh49490
 * @PackageName com.hundsun.tbsp.algorithm
 * @Description
 * @date 2023/11/23 21:04
 */
public class Demo13 {
    public TreeNode sortedArrayToBST(int[] nums) {

        if(nums.length == 0){
            return null;
        }
        return ToBSTHandle(nums,0,nums.length);
    }
    public TreeNode ToBSTHandle(int[] nums,int left,int right){
        if((right-left) == 0){
            return  new TreeNode(nums[left]);
        }

        int mid = (right - left);
        TreeNode root = new TreeNode(nums[mid]);

        root.left  = ToBSTHandle(nums,0,mid-1);
        root.right = ToBSTHandle(nums,mid+1,right);
        return root;
    }
}
