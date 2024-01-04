package com.hundsun.tbsp.algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ouyzh49490
 * @PackageName com.hundsun.tbsp.algorithm
 * @Description
 * @date 2023/11/20 20:55
 */
public class Demo8 {
    List<Integer> list = new ArrayList<>();
    TreeNode result ;

    public static void main(String[] args) {
        List<Integer> list1 =new ArrayList<>();
        list1.add(1);
        list1.add(2);
        list1.add(3);
        list1.add(4);
        list1.add(5);
        list1.add(6);
        List<Integer> leftList = list1.subList(0, 3);
        List<Integer> rightList = list1.subList(4, list1.size());
        System.out.println(leftList);
        System.out.println(rightList);
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        inOrder(root);



        findAncestor(root,p,q);

        return result;
    }
    public void findAncestor(TreeNode root, TreeNode p, TreeNode q){
        if(root == null){
            return ;
        }
        int indexOfRoot = list.indexOf(root.val);
        List<Integer> leftList = list.subList(0, indexOfRoot);
        List<Integer> rightList = list.subList(indexOfRoot + 1, list.size());
        if (!(leftList.contains(p.val)&&leftList.contains(q.val))
                ||!(rightList.contains(p.val)&&rightList.contains(q.val))){
            result = root;
        }
        if(leftList.contains(p.val)&&leftList.contains(q.val)){
               findAncestor(root.left,p,q);
        }
        if(rightList.contains(p.val)&&rightList.contains(q.val)){
            findAncestor(root.right,p,q);
        }
    }

    public void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        list.add(root.val);
        inOrder(root.right);
    }
}
