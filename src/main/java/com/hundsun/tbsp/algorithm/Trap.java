package com.hundsun.tbsp.algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ouyzh49490
 * @PackageName com.hundsun.tbsp.algorithm
 * @Description
 * @date 2024/1/5 15:47
 */
public class Trap {
    /**给你一个数组 nums，对于其中每个元素 nums[i]，请你统计数组中比它小的所有数字的数目。

     换而言之，对于每个 nums[i] 你必须计算出有效的 j 的数量，其中 j 满足 j != i 且 nums[j] < nums[i] 。

     以数组形式返回答案。



     示例 1：

     输入：nums = [8,1,2,2,3]
     输出：[4,0,1,1,3]
     解释：
     对于 nums[0]=8 存在四个比它小的数字：（1，2，2 和 3）。
     对于 nums[1]=1 不存在比它小的数字。
     对于 nums[2]=2 存在一个比它小的数字：（1）。
     对于 nums[3]=2 存在一个比它小的数字：（1）。
     对于 nums[4]=3 存在三个比它小的数字：（1，2 和 2）。
     示例 2：

     输入：nums = [6,5,4,8]
     输出：[2,1,0,3]
     示例 3：

     输入：nums = [7,7,7,7]
     输出：[0,0,0,0]】*/
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode next = headA;
        List<ListNode> list =new ArrayList();
        while(next!=null){
            list.add(next);
            next = next.next;
        }
        ListNode next1 = headB;
        while(next1 != null){
            if (list.contains(next1)){
                return  next1 ;
            }
            next1 = next1.next;
        }
         return null;
    }
}
 class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {
    }

     public ListNode(int val) {
         this.val = val;
     }

     public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    /**
     * 获取
     * @return val
     */
    public int getVal() {
        return val;
    }

    /**
     * 设置
     * @param val
     */
    public void setVal(int val) {
        this.val = val;
    }

    /**
     * 获取
     * @return next
     */
    public ListNode getNext() {
        return next;
    }

    /**
     * 设置
     * @param next
     */
    public void setNext(ListNode next) {
        this.next = next;
    }

    public String toString() {
        return "ListNode{val = " + val + ", next = " + next + "}";
    }
}
