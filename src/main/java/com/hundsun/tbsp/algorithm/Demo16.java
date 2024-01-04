package com.hundsun.tbsp.algorithm;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ouyzh49490
 * @PackageName com.hundsun.tbsp.algorithm
 * @Description
 * @date 2023/11/27 11:10
 */
public class Demo16 {
    String[] str = {"","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    List<String> result = new ArrayList<>();
    @Test
    public void test(){
        System.out.println(letterCombinations("23"));
    }
    public List<String> letterCombinations(String digits) {
        if(digits.length() == 0 || digits.equals("")){
            return null;
        }
        handle(str,0,digits);
        return result;
    }
    StringBuilder sb = new StringBuilder();
    public void handle(String[] str,int num,String digits){
        if (sb.length()==digits.length()){
            result.add(sb.toString());
            return;
        }
        String temp = str[digits.charAt(num)-'1'];
        for (int i = 0; i < temp.length(); i++) {
            sb.append(temp.charAt(i));
            handle(str,num+1,digits);
            sb.deleteCharAt(sb.length()-1);
        }
    }

}
