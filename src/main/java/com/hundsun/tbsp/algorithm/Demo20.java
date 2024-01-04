package com.hundsun.tbsp.algorithm;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author ouyzh49490
 * @PackageName com.hundsun.tbsp.algorithm
 * @Description
 * @date 2023/11/30 10:54
 */
public class Demo20 {
    /**
     * 有效 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。
     * <p>
     * 例如："0.1.2.201" 和 "192.168.1.1" 是 有效 IP 地址，但是 "0.011.255.245"、"192.168.1.312" 和 "192.168@1.1" 是 无效 IP 地址。
     * 给定一个只包含数字的字符串 s ，用以表示一个 IP 地址，返回所有可能的有效 IP 地址，这些地址可以通过在 s 中插入 '.' 来形成。
     * 你 不能 重新排序或删除 s 中的任何数字。你可以按 任何 顺序返回答案。
     * <p>
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入：s = "25525511135"
     * 输出：["255.255.11.135","255.255.111.35"]
     * <p>
     * 示例 2：
     * <p>
     * 输入：s = "0000"
     * 输出：["0.0.0.0"]
     * 示例 3：
     * <p>
     * 输入：s = "101023"
     * 输出：["1.0.10.23","1.0.102.3","10.1.0.23","10.10.2.3","101.0.2.3"]
     */
    List<String> result = new ArrayList<>();
    List<List<String>> tmepList = new ArrayList<>();
    LinkedList<String> linkedList = new LinkedList<>();

    public List<String> restoreIpAddresses(String s) {
        handle(s, 0);

        return result;
    }

    public void handle(String s, int startIndex) {
        if (startIndex >= 4) {
            return;
        }
        if (linkedList.size() == 4 && linkedList.peekLast().length() <= 3) {
            tmepList.add(new ArrayList<>(linkedList));
            return;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = startIndex; i < startIndex + 3; i++) {
            if (!startWithZero(s, startIndex, i) && !lengthMoreThanThree(s, startIndex, i)) {
                linkedList.offer(s.substring(startIndex, i + 1));
            } else {
                continue;
            }
            handle(s, i + 1);
            linkedList.removeLast();
        }
    }

    public boolean startWithZero(String s, int startIndex, int end) {
        if (s.charAt(startIndex) == '0' && (end - startIndex) != 0) {
            return true;
        }
        return false;
    }

    public boolean lengthMoreThanThree(String s, int startIndex, int end) {
        if ((end - startIndex) > 3) {
            return true;
        }
        return false;
    }

    @Test
    public void test1() {
        System.out.println(restoreIpAddresses("101023"));
    }
}
