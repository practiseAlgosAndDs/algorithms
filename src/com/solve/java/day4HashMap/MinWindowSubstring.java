package com.solve.java.day4HashMap;


// LC 76 hard  https://leetcode.com/problems/minimum-window-substring/

public class MinWindowSubstring {

    public String minWindow(String s, String t) {
        if(s=="" || t=="") {
            return "";
        }

        int[] charArr = new int[128];
        String res="";
        for(int i=0;i<t.length();i++) {
            charArr[t.charAt(i)]++;
        }
        int left=0,count=0;
        int minLen= Integer.MAX_VALUE;
        for(int right=0;right<s.length();right++) {
            charArr[s.charAt(right)] =  charArr[s.charAt(right)]-1;
            if(charArr[s.charAt(right)]>=0) {
                count++;
            }

            while(count==t.length()) {
               if(minLen> right-left+1) {
                   minLen=right -left+1;
                   res = s.substring(left,right+1);
               }
                ++charArr[s.charAt(left)];
                if(charArr[s.charAt(left)]>0) {
                    --count;
                }
               ++left;
            }
        }
       return res;
    }

    public static void main(String[] args){
        MinWindowSubstring mws = new MinWindowSubstring();
        String result = mws.minWindow("ADOBECODEBANC","ABC");
        System.out.println("result :"+result);
    }
}
