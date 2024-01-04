package com.hundsun.tbsp.algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ouyzh49490
 * @PackageName com.hundsun.tbsp.algorithm
 * @Description
 * @date 2023/11/21 23:41
 */
public class Demo9 {
    TreeNode node;
    List<Integer> list = new ArrayList<>();

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == null || q == null) {
            return null;
        }
        inorder(root);
        TreeNode min;
        TreeNode max;
        if (p.val > q.val) {
            min = q;
            max = p;
        } else {
            min = p;
            max = q;
        }
        findRoot(root, min, max);
        return null;
    }

    private void findRoot(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return;
        }
        if(p.val<= root.val&&q.val>=root.val){
            node =root;
        }
        findRoot(root.left,p,q);
        findRoot(root.right,p,q);

    }

    private void inorder(TreeNode root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        list.add(root.val);
        inorder(root.right);
    }
}
