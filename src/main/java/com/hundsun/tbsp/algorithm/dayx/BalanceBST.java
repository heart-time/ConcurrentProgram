package com.hundsun.tbsp.algorithm.dayx;

import cn.hutool.core.lang.tree.Tree;
import org.junit.Test;

import java.util.ArrayList;

/**
 * @author ouyzh49490
 * @PackageName com.hundsun.tbsp.algorithm.dayx
 * @Description
 * @date 2023/12/25 14:13
 */
public class BalanceBST {
    ArrayList<Integer> list = new ArrayList<>();

    public TreeNode balanceBST(TreeNode root) {
        order(root);
        return buildBalanceBST(list, 0, list.size());
    }

    private TreeNode buildBalanceBST(ArrayList<Integer> list, int start, int end) {
        if (start >= end) {
            return null;
        }
        int mid = (start + end) / 2;
        TreeNode node = new TreeNode(list.get(mid));
        node.left = buildBalanceBST(list, start, mid);
        node.right = buildBalanceBST(list, mid + 1, end);
        return node;
    }

    public void order(TreeNode node) {
        if (node == null) {
            return;
        }
        order(node.left);
        list.add(node.val);
        order(node.right);
    }

    @Test
    public void test() {
        TreeNode child3 = new TreeNode(4);
        TreeNode child2 = new TreeNode(3, null, child3);
        TreeNode child1 = new TreeNode(2, null, child2);
        TreeNode node = new TreeNode(1, null, child1);
        balanceBST(node);
    }
}
