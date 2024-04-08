//package com.hundsun.tbsp.algorithm;
//
//import org.junit.Test;
//
//import java.util.ArrayList;
//
///**
// * @author ouyzh49490
// * @PackageName com.hundsun.tbsp.algorithm
// * @Description
// * @date 2024/1/10 14:29
// */
//public class CapitalizeTitle {
//    public  String capitalizeTitle(String title) {
//        String[] split = title.split(" ");
//        StringBuilder sb =new StringBuilder();
//        for (int i = 0 ;i<split.length;i++) {
//            if (split[i].length()<=2){
//              sb.append(split[i].toUpperCase());
//            }else{
//                String temp = split[i].toLowerCase();
//                char[] charArray = temp.toCharArray();
//                charArray[0] = Character.toUpperCase(charArray[0]);
//                System.out.println(charArray[0]);
//                sb.append(new String(charArray));
//            }
//            if (i!= split.length-1){
//                sb.append(" ");
//            }
//        }
//
//
//        return sb.toString();
//    }
//
//
//
//
//    @Test
//    public void test(){
//        ArrayList<Integer> list =new ArrayList<>();
//        list.toArray()
//        System.out.println(capitalizeTitle("First leTTeR of EACH Word"));
//    }
//}
