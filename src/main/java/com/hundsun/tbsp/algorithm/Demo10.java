package com.hundsun.tbsp.algorithm;

import org.junit.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author ouyzh49490
 * @PackageName com.hundsun.tbsp.algorithm
 * @Description
 * @date 2023/11/22 0:08
 */
public class Demo10 {
    List<Integer> list1 = new ArrayList<>();

    public TreeNode insertIntoBST(TreeNode root, int val) {
        Collections.sort(list1, (o1, o2) -> {
            return o1 - o2;
        });
        return handlsse(root, list1);
    }
    private TreeNode handlsse(TreeNode root, List<Integer> list) {
        if (root == null  || list.size()==0) {
            return null;
        }
        TreeNode node = new TreeNode(root.val);
        if (list.size() == 1) {
            return node;
        }
        int indexOfRoot = list.indexOf(root.val);
        List<Integer> leftList = list.subList(0, indexOfRoot);
        List<Integer> rightList = list.subList(indexOfRoot + 1, list.size());
        node.left = handlsse(root.left, leftList);
        node.right = handlsse(root.right, rightList);
        return  node;
    }

    public void inorder(TreeNode root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        list1.add(root.val);
        inorder(root.right);
    }

    @Test
    public void test1(){
        LocalDateTime localDateTime = LocalDateTime.now();
        DateTimeFormatter ds = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        System.out.println(ds.format(localDateTime));
    }

}
