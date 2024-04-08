//package com.hundsun.tbsp.algorithm;
//
//import org.junit.Test;
//import java.util.ArrayList;
//import java.util.LinkedList;
//import java.util.List;
//
///**
// * @author ouyzh49490
// * @PackageName com.hundsun.tbsp.algorithm
// * @Description
// * @date 2023/11/27 11:10
// */
//public class Demo16 {
//    LinkedList<TreeNode> list =new LinkedList<>();
//    int count = 1;
//    public int goodNodes(javax.swing.tree.TreeNode root) {
//        if(root==null){
//            return 0;
//        }
//        getGoodNodes(root);
//        return  count;
//    }
//    public void getGoodNodes(TreeNode root){
//        if (root==null){
//            return ;
//        }
//        int index = 0 ;
//        for (int i = 0; i < list.size(); i++) {
//            if (list.get(i).val>root.val){
//                break;
//            }else {
//                index++;
//            }
//        }
//        if (++index ==list.size()){
//            count++;
//        }
//        list.offer(root.val);
//        getGoodNodes(root.left);
//        list.pollLast();
//        getGoodNodes(root.right);
//        list.pollLast();
//    }
//}
