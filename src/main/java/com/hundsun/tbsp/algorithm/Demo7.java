package com.hundsun.tbsp.algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author ouyzh49490
 * @PackageName com.hundsun.tbsp.algorithm
 * @Description
 * @date 2023/11/20 19:53
 */
public class Demo7 {
    static HashMap<Integer, Integer> hashMap = new HashMap<>();
    static Integer count;
    int max = -1;
    static List<Integer> list = new ArrayList<>();
    TreeNode pre;
    static int maxKey;

    public int[] findMode(TreeNode root) {
        handleMethod(root);
        hashMap.forEach((key, value) -> {
            if (value > max) {
                max = value;
                maxKey = key;
            }
        });
        list.add(maxKey);
        hashMap.forEach((key, value) -> {
            if (value == hashMap.get(list.get(0)) && !list.contains(key)) {
                list.add(key);
            }
        });
        int result[] = new int[list.size()];
        int i = 0;
        for (int j = 0; j < list.size(); j++) {
            result[i] = list.get(i);
        }
        return result;
    }

    private void handleMethod(TreeNode root) {
        if (root == null) {
            return;
        }
        handleMethod(root.left);
        if (pre == null) {
            count = 1;
        } else if (pre.val == root.val) {
            count += 1;
        } else {
            count = 1;
        }
        pre = root;
        if(count == max){
            list.add(root.val);
        }else  if(count > max){
            max = count;
            list.clear();;
            list.add(root.val);
        }
        handleMethod(root.right);
    }

    /**
     * @author ouyzh49490
     * @PackageName com.hundsun.tbsp
     * @Description
     * @date 2023/11/20 20:54
     */

}
