package com.solve.java.Strings;

// LC 76 : hard https://leetcode.com/problems/minimum-window-substring/

import java.util.HashMap;

public class MinimumWindowSubstring {

    public String minWindow(String s, String t) {
        HashMap map = new HashMap();

        for(int i=0;i<t.length();i++) {
            map.put(s.charAt(i),(int)map.getOrDefault(s.charAt(i),0)+1);
        }

        int left=0,right=0,count=0;

        return "";
    }

    public static void main(String[] args) {

    }
}
