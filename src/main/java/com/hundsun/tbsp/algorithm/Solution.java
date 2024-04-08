package com.hundsun.tbsp.algorithm;

/**
 * @author ouyzh49490
 * @PackageName com.hundsun.tbsp.algorithm
 * @Description
 * @date 2024/1/10 11:13
 */
public class Solution {
    StringBuilder sb =new StringBuilder();

    public String decodeString(String s) {
        int index = 0 ;
        handle(s,index);
        return sb.toString();
    }
    public void handle(String s, int index){
        char[] charArray = s.toCharArray();
        int num = 0;
        for (char c : charArray) {
            if (c>='0'&&c<='9'){
                num = num*10 + c -'0';
            }else if(c>='a'&&c<='z'){
                sb.append(c);
            }else  if(c=='['){

            }
        }

    }

}