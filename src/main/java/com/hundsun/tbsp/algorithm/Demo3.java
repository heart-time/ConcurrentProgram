package com.hundsun.tbsp.algorithm;

import com.hundsun.tbsp.utils.ThreadUtils;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * @author ouyzh49490
 * @PackageName com.hundsun.tbsp.algorithm
 * @Description
 * @date 2023/11/18 16:41
 */
@Slf4j
public class Demo3 {
    public static void main(String[] args) {

        CustomLock lock = new CustomLock();
        new Thread(()->{
            try {
                lock.lock();
                log.info("locking...");
                lock.lock();
                log.info("locking...");
                ThreadUtils.sleep(2);

            } finally {
                lock.unlock();
                log.info("unlocking...");
                lock.unlock();
                log.info("unlocking...");
            }
        },"t1").start();
        new Thread(()->{
            try {
                lock.lock();
                log.info("locking...");
            } finally {
                lock.unlock();
                log.info("unlocking...");
            }
        },"t2").start();
        ThreadUtils.sleep(1);
        lock.unlock();
    }
    public  static TreeNode  buildTreeNode(int[] inOrder,int[] postOrder){
        if(inOrder.length==0){
            return null;
        }

        int rootIndex=postOrder.length-1;
        int rootIndexOfInOrder;
        TreeNode root =new TreeNode(postOrder[rootIndex]);
        if(inOrder.length==1){
            return  root;
        }
        for (rootIndexOfInOrder = 0; rootIndexOfInOrder < inOrder.length; rootIndexOfInOrder++) {
            if(inOrder[rootIndexOfInOrder]==postOrder[rootIndex]){
                break;
            }
        }
        int [] leftNewInOrder = Arrays.copyOfRange(inOrder,0,rootIndexOfInOrder);

        int[] leftNewPostOrder=Arrays.copyOfRange(postOrder,0,leftNewInOrder.length);
        int [] rightNewInOrder = Arrays.copyOfRange(inOrder,rootIndexOfInOrder+1,inOrder.length);

        int[] rightNewPostOrder=Arrays.copyOfRange(postOrder,leftNewPostOrder.length,rootIndex);
        root.left=buildTreeNode(leftNewInOrder,leftNewPostOrder);
        root.right=buildTreeNode(rightNewInOrder,rightNewPostOrder);
        return  root;

    }

    public static TreeNode buildTreeNodeByPreOrder(int [] preOrder,int [] inOrder){
        if(inOrder.length==0){
            return null;
        }
        TreeNode root =new TreeNode(preOrder[0]);
        if(inOrder.length==1){
            return root;
        }
        int indexOfRoot ;
        for (indexOfRoot=0 ; indexOfRoot<inOrder.length;indexOfRoot++){
            if(inOrder[indexOfRoot]==preOrder[0]){
                break;
            }
        }
        int leftNewInOrder[] = Arrays.copyOfRange(inOrder,0,indexOfRoot);
        int leftNewPreOrder[] = Arrays.copyOfRange(preOrder,1,leftNewInOrder.length+1);
        int rightNewInOrder[] = Arrays.copyOfRange(inOrder,indexOfRoot+1,inOrder.length);
        int rightNewPreOrder[] = Arrays.copyOfRange(preOrder,leftNewPreOrder.length+1,preOrder.length);
        root.left = buildTreeNodeByPreOrder(leftNewPreOrder,leftNewInOrder);
        root.right = buildTreeNodeByPreOrder(rightNewPreOrder, rightNewInOrder);
        return root;

    }
}
