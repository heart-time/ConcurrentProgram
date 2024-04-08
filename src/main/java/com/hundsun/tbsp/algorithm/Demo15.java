//package com.hundsun.tbsp.algorithm;
//
//import org.junit.Test;
//
//import javax.swing.tree.TreeNode;
//import java.util.ArrayList;
//import java.util.LinkedList;
//import java.util.List;
//
///**
// * @author ouyzh49490
// * @PackageName com.hundsun.tbsp.algorithm
// * @Description
// * @date 2023/11/27 10:37
// */
//public class Demo15 {
//    /**
//     * 找出所有相加之和为 n 的 k 个数的组合，且满足下列条件：
//     * 只使用数字1到9
//     * 每个数字 最多使用一次
//     */
//    public List<List<Integer>> decorateRecord(TreeNode root) {
//        if(root==null){
//            return null;
//        }
//        List<List<Integer>> result = new ArrayList<>();
//        LinkedList<TreeNode> list = new LinkedList<>();
//        List<Integer> temp = new ArrayList<>();
//        list.offer(root);
//        while(!list.isEmpty()){
//            int count = list.size();
//            for (int i = 0; i < count; i++) {
//                TreeNode tempNode = list.poll();
//                temp.add(tempNode.val);
//                if(tempNode.left!=null){
//                    list.offer(tempNode.left);
//                }
//                if(tempNode.right!=null){
//                    list.offer(tempNode.right);
//                }
//            }
//            List<Integer> mediumList = new ArrayList<>();
//            if (count%2==0){
//                for (int i = temp.size(); i >=0 ; i--) {
//                    mediumList.add(temp.get(i));
//                    result.add(mediumList);
//                }
//            }else {
//                result.add(temp);
//            }
//        }
//        return result;
//
//    }
//
//}
//
