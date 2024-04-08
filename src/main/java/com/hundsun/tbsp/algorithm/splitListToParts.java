package com.hundsun.tbsp.algorithm;

import org.junit.Test;

/**
 * @author ouyzh49490
 * @PackageName com.hundsun.tbsp.algorithm
 * @Description
 * @date 2024/4/2 10:15
 */
public class splitListToParts {
    @Test
    public void test(){
        ListNode head = new ListNode();
        ListNode listNode = initList(head);
        ListNode[] listNodes = splitListToParts(listNode, 3);
        for (int i = 0; i < 3; i++) {
            System.out.println(listNodes[i]);
        }
    }
    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode[] result = new ListNode[k];
        if (head == null) {
            return null;
        }
        ListNode temp = head;
        int count = 0;
        while (temp != null) {
            count++;
            temp = temp.next;
        }

        int mod = Math.max(count % k, 0);
        int avgEveryPartSize = count / k;
        int realEvertPartSize[] = new int[k];

        for (int i = 0; i < k; i++) {
            mod--;
            if (mod >= 0) {
                realEvertPartSize[i] = avgEveryPartSize + 1;
            } else {
                realEvertPartSize[i] = avgEveryPartSize;
            }
        }
        int realEvertPartIndex[] = new int[k];

        for (int i = 0; i < k; i++){
            if (i==0){
                realEvertPartIndex[0] = 0;
            }else{
                realEvertPartIndex[i] = realEvertPartIndex[i-1]+realEvertPartSize[i-1];
            }
        }
        temp =head;

            int num = 0;
            int index = 0;
            while(temp!=null){
                if (index<k&&realEvertPartIndex[index] == num) {
                    result[index] = temp;
                    index++;
                }
                if (index<k&&(num+1)==realEvertPartIndex[index]){
                    ListNode temp2 = temp.next;
                    temp.next = null;
                    temp = temp2;
                    num++;
                    continue;
                }
                temp = temp.next;
                num ++;
            }
        return result;
    }

    public ListNode initList(ListNode head){
        ListNode temp = head;
        for (int i = 1; i <= 10; i++) {
            ListNode listnode  =new ListNode(i);
            temp.next = listnode;
            temp = temp.next;
        }
        return head.next;
    }

}
