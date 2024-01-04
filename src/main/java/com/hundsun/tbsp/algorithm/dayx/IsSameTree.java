package com.hundsun.tbsp.algorithm.dayx;

/**
 * @author ouyzh49490
 * @PackageName com.hundsun.tbsp.algorithm.dayx
 * @Description
 * @date 2023/12/25 14:49
 */
public class IsSameTree {
    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
            if (root.left != null) {
                root.left.next = root.right;
                if (root.next != null) {
                    root.right.next = root.next.left;
                } else {
                    root.right.next = null;
                }
            }
        connect(root.left);
        connect(root.right);
        return root;
    }


}

class Node {
    public Node left;
    public Node right;
    public Node next;
    public int val;


    public Node(int val) {
        this.val = val;
    }


    public Node() {
    }

    public Node(Node left, Node right, Node next, int val) {
        this.left = left;
        this.right = right;
        this.next = next;
        this.val = val;
    }

    /**
     * 获取
     *
     * @return left
     */
    public Node getLeft() {
        return left;
    }

    /**
     * 设置
     *
     * @param left
     */
    public void setLeft(Node left) {
        this.left = left;
    }

    /**
     * 获取
     *
     * @return right
     */
    public Node getRight() {
        return right;
    }

    /**
     * 设置
     *
     * @param right
     */
    public void setRight(Node right) {
        this.right = right;
    }

    /**
     * 获取
     *
     * @return next
     */
    public Node getNext() {
        return next;
    }

    /**
     * 设置
     *
     * @param next
     */
    public void setNext(Node next) {
        this.next = next;
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
        return "Node{left = " + left + ", right = " + right + ", next = " + next + ", val = " + val + "}";
    }
}