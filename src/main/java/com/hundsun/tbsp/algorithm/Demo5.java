package com.hundsun.tbsp.algorithm;

/**
 * @author ouyzh49490
 * @PackageName com.hundsun.tbsp.algorithm
 * @Description
 * @date 2023/11/19 22:57
 */
public class Demo5 {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        TreeNode node;
        if (root1 == null && root2 == null) {
            return null;
        } else if (root1 == null && root2 != null) {
            node = root2;
        } else if (root1 != null && root2 == null) {
            node = root1;
        }else {
            node = new TreeNode(root1.val + root2.val);
        }
        node.left = mergeTrees(root1.left, root2.left);
        node.right = mergeTrees(root1.right, root2.right);
        return node;
    }
}
