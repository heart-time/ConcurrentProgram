package com.hundsun.tbsp.algorithm;

/**
 * @author ouyzh49490
 * @PackageName com.hundsun.tbsp.algorithm
 * @Description
 * @date 2023/11/18 16:11
 */
public class Demo2 {
    private static boolean flag = false;
   static int total = 0;

    public static void main(String[] args) {
        TreeNode left= new TreeNode(1);
        TreeNode right = new TreeNode(1);
        TreeNode root = new TreeNode(left,right,0);
        int total=0;
        int targetSum = 0;
        trvesal(root,targetSum);
        System.out.println( flag);
    }
    public static  void trvesal(TreeNode root , int targetSum){
        if(root==null){
            return ;
        }
        total+=root.val;
        if(root.left==null && root.right==null){
            if(total==targetSum){
                flag =true;
            }
            return ;
        }
        trvesal(root.left,targetSum);

        if(root.left!=null)total-=root.left.val;
        trvesal(root.right,targetSum);
        if(root.right!=null)total-=root.right.val;


    }
}
class TreeNode{
    public TreeNode left;
    public TreeNode right;

    public int val;

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public TreeNode(TreeNode left, TreeNode right, int val) {
        this.left = left;
        this.right = right;
        this.val = val;
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode() {
    }
}
