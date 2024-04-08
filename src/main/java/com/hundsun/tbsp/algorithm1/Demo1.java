package com.hundsun.tbsp.algorithm1;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author ouyzh49490
 * @PackageName com.hundsun.tbsp.algorithm1
 * @Description
 * @date 2024/3/12 11:15
 */
public class Demo1 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
    }

    int min = 0;

    @Test
    public void test() {
        int coins[] = {1,2,4,2,5,7,2,4,9,0};
        System.out.println(maxProfit(coins));
    }

    /**
     * 给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。
     * <p>
     * 你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
     * <p>
     * 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。
     * <p>
     * 示例 1：
     * <p>
     * 输入：[7,1,5,3,6,4]
     * 输出：5
     * 解释：在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
     * 注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。
     * 示例 2：
     * <p>
     * 输入：prices = [7,6,4,3,1]
     * 输出：0
     * 解释：在这种情况下, 没有交易完成, 所以最大利润为 0。
     */


    public int maxProfit(int[] prices) {

        //3,3,5,0,0,3,1,4
        //print : 6
        int total = 0;
        int buyPrice = prices[0] ;
        int  salePrice = 0;
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] >= prices[i-1]){
                salePrice = prices[i];
                if (i == prices.length-1){
                    list.add(salePrice-buyPrice);
                }
            }else {
                list.add(Math.max(salePrice-buyPrice,0));
                buyPrice = prices[i];
                salePrice = 0;
            }
        }
        list.sort((o1,o2)->{
            return o2-o1;
        });

       if (list.get(0)==0){
           return 0;
       }
       if (list.size()==1){
           return list.get(0);
       }
       return list.get(0)+list.get(1);








//        int total = 0;
//        int buyMoney = prices[0];
//        int saleMoney = 0;
//        for (int i = 1; i < prices.length; i++) {
//            if (prices[i]>=prices[i-1]){
//                saleMoney = prices[i];
//                if (i==prices.length-1){
//                    total+= Math.max(saleMoney - buyMoney, 0);
//                }
//            }else if (prices[i]<prices[i-1]){
//                total+= Math.max(saleMoney - buyMoney, 0);
//                buyMoney = prices[i];
//                saleMoney = 0;
//            }
//        }
//
//        return total;
    }
}
