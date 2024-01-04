package com.hundsun.tbsp.algorithm.dayx;


import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author ouyzh49490
 * @PackageName com.hundsun.tbsp.algorithm.dayx
 * @Description
 * @date 2023/12/25 13:22
 */
public class findSunNumbers {

    LinkedList<Integer> list = new LinkedList<>();
    ArrayList<ArrayList<Integer>> result = new ArrayList();

    int sum = 0;

    public int findSumNumbers(TreeNode root) {
        findLeafNode(root);
        for (int i = 0; i < result.size(); i++) {
            ArrayList temp = result.get(i);
            int count = 0;
            for (int j = 0; j < temp.size(); j++) {
                count = count * 10 + (Integer) temp.get(j);
            }
            sum += count;
        }
        return sum;
    }

    public void findLeafNode(TreeNode node) {
        if (node.left == null && node.right == null) {
            list.offer(node.val);
            result.add(new ArrayList(list));
            return;
        }
        list.offer(node.val);
        if (node.left != null) {
            findLeafNode(node.left);
            list.removeLast();

        }
        if (node.right != null) {
            findLeafNode(node.right);
            list.removeLast();
        }
    }

    @Test
    public void test() {
        TreeNode node = new TreeNode(9,new TreeNode(5),new TreeNode(1));
        TreeNode root = new TreeNode(4, node, new TreeNode(0));
        int sumNumbers = findSumNumbers(root);
        System.out.println(sumNumbers);
    }
}

class TreeNode {
    public TreeNode left;
    public TreeNode right;
    public int val;

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }


    /**
     * 获取
     *
     * @return left
     */
    public TreeNode getLeft() {
        return left;
    }

    /**
     * 设置
     *
     * @param left
     */
    public void setLeft(TreeNode left) {
        this.left = left;
    }

    /**
     * 获取
     *
     * @return right
     */
    public TreeNode getRight() {
        return right;
    }

    /**
     * 设置
     *
     * @param right
     */
    public void setRight(TreeNode right) {
        this.right = right;
    }

    /**
     * 获取
     *
     * @return val
     */
    public int getVal() {
        return val;
    }

    /**
     * 设置
     *
     * @param val
     */
    public void setVal(int val) {
        this.val = val;
    }

    public String toString() {
        return "TreeNode{left = " + left + ", right = " + right + ", val = " + val + "}";
    }
}