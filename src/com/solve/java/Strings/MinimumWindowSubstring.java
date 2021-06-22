package com.solve.java.Strings;

// LC 76 : hard https://leetcode.com/problems/minimum-window-substring/

import java.util.HashMap;

public class MinimumWindowSubstring {

    public String minWindow(String s, String t) {
        if(s=="" || t=="") {
            return "";
        }

        int[] charArr = new int[128];
        String res="";

        for(int i=0;i<t.length();i++) {
            charArr[t.charAt(i)]++;
        }
        int left=0,count=0,minLen=Integer.MAX_VALUE;
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

    public String minWindowApp2(String s, char[] t) {
        if(s=="" || t==null) {
            return "";
        }

        int[] charArr = new int[128];
        String res="";

        for(int i=0;i<t.length;i++) {
            charArr[(int)t[i]]++;
        }
        int left=0,count=0,minLen=Integer.MAX_VALUE;
        for(int right=0;right<s.length();right++) {
            charArr[s.charAt(right)] =  charArr[s.charAt(right)]-1;
            if(charArr[s.charAt(right)]>=0) {
                count++;
            }

            while(count==t.length) {
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

    public static void main(String[] args) {
        MinimumWindowSubstring minWSubst = new MinimumWindowSubstring();
        //System.out.println(minWSubst.minWindow("ADOBECODEBANC","ABC"));
        //char[] t = {'A','B','C'};
        char[] t = {'x','y','z'};
       // System.out.println(minWSubst.minWindowApp2("ADOBECODEBANC",t));
        System.out.println(minWSubst.minWindowApp2("xyyzyzyx",t));

    }
}
