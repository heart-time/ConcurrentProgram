package com.hundsun.tbsp;


import java.util.LinkedList;

/**
 * @author ouyzh49490
 * @PackageName com.hundsun.tbsp
 * @Description
 * @date 2024/4/3 17:02
 */
public class GetTargetCopy {
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
       if (target == null){
           return null;
       }
       LinkedList<TreeNode> list = new LinkedList<>();
       list.offer(original);
       while(!list.isEmpty()){
           int count = list.size();
           for (int i = 0; i < count; i++) {
               TreeNode treeNode = list.pollFirst();
               if (treeNode.val == treeNode.val){
                   TreeNode result = new TreeNode(treeNode.val);
                   return result;
               }
               if (treeNode.left!=null){
                   list.offer(treeNode.left);
               }
               if (treeNode.right!=null){
                   list.offer(treeNode.right);
               }
           }
       }
       return null;
    }
    class  TreeNode {
        private TreeNode left;
        private TreeNode right;
        private int val;

        public TreeNode(int val) {

        }

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
    }
}
