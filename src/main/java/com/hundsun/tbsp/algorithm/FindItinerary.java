package com.hundsun.tbsp.algorithm;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ouyzh49490
 * @PackageName com.hundsun.tbsp.algorithm
 * @Description
 * @date 2023/12/4 14:01
 */
public class FindItinerary {
    /**
     * 给你一份航线列表 tickets ，其中 tickets[i] = [fromi, toi] 表示飞机出发和降落的机场地点。
     * 请你对该行程进行重新规划排序。
     * <p>
     * 所有这些机票都属于一个从 JFK（肯尼迪国际机场）出发的先生，
     * 所以该行程必须从 JFK 开始。如果存在多种有效的行程，请你按字典排序返回最小的行程组合。
     * 例如，行程 ["JFK", "LGA"] 与 ["JFK", "LGB"] 相比就更小，排序更靠前。
     * 假定所有机票至少存在一种合理的行程。且所有的机票 必须都用一次 且 只能用一次。
     * <p>
     * <p>
     * <p>
     * 示例 1：
     * 输入：tickets = [["MUC","LHR"],["JFK","MUC"],["SFO","SJC"],["LHR","SFO"]]
     * 输出：["JFK","MUC","LHR","SFO","SJC"]
     * <p>
     * 示例 2：
     * 输入：tickets = [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
     * 输出：["JFK","ATL","JFK","SFO","ATL","SFO"]
     * 解释：另一种有效的行程是 ["JFK","SFO","ATL","JFK","ATL","SFO"] ，但是它字典排序更大更靠后。
     *
     * @param tickets
     * @return
     */
    List<String> result = new ArrayList<>();
    boolean[] flag;
    int total = 0 ;

    public List<String> findItinerary(List<List<String>> tickets) {
        flag = new boolean[tickets.size()];
        handle(tickets, "JFK");
        return result;
    }

    public void handle(List<List<String>> tickets, String target) {
        String minToI = new String();
        if (result.size() == tickets.size()) {
            return;
        }
        int minIndex = 0;
        for (int j = 0; j < tickets.size(); j++) {
            if(flag[j]){
                continue;
            }
            List<String> temp = tickets.get(j);
            if (temp.get(0).equals(target)) {
                String toi = temp.get(1);
                //["MUC","LHR"],["JFK","MUC"],["SFO","SJC"],["LHR","SFO"]
                String minString = getMinString(toi, minToI);
                if (minString.equals(toi)&&continuesFromi(minString,tickets)){
                    minIndex = j;
                    minToI = minString;
                }
            }
        }
        flag[minIndex] =true;
        String s = tickets.get(minIndex).get(1);
        result.add(s);
        total++;
        handle(tickets, s);
    }

    private boolean continuesFromi(String minString, List<List<String>> tickets) {
        if (total==tickets.size()-1){
            return  true;
        }

        for (int i = 0; i < tickets.size(); i++) {
            if (minString.equals(tickets.get(i).get(0))) {
                return true;
            }
        }
        return false;
    }

    public String getMinString(String toi, String minToi) {
        if ("".equals(minToi)) {
            return toi;
        }
        int minLength = minToi.length();
        int toiLength = toi.length();

        if (minLength < toiLength) {
            return minToi;
        }
        if (minLength > toiLength) {
            return toi;
        }
        for (int i = 0; i < minLength; i++) {
            if (minToi.charAt(i) > toi.charAt(i)) {
                return toi;
            }
            if (minToi.charAt(i) < toi.charAt(i)) {
                return minToi;
            }
        }
        return minToi;
    }

    @Test
    public void test() {
//        ["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]
        List<List<String>> temp = new ArrayList<>();
//["JFK","KUL"],["JFK","NRT"],["NRT","JFK"]
        //["MUC","LHR"],["JFK","MUC"],["SFO","SJC"],["LHR","SFO"]
        List<String> list = Arrays.asList("MUC","LHR");
        List<String> list1 = Arrays.asList("JFK","MUC");
        List<String> list2 = Arrays.asList("SFO","SJC");
        List<String> list3 = Arrays.asList("LHR","SFO");
//        List<String> list4 = Arrays.asList("ATL", "SFO");
        temp.add(list);
        temp.add(list1);
        temp.add(list2);
        temp.add(list3);
//        temp.add(list4);
        List<String> itinerary = findItinerary(temp);
        itinerary.add(0, "JFK");
        System.out.println(itinerary);
//        System.out.println(getMinString("bbcd", "abcd"));
    }
}
