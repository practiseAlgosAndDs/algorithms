package com.solve.java.other;

// LC # 205 https://leetcode.com/problems/isomorphic-strings/
import java.util.HashMap;

public class IsomorphicStrings {
    public boolean isIsomorphic(String s, String t) {
        if(s.length()!=t.length()) return false;
        HashMap<Character,Integer> sMap = new HashMap<Character,Integer>();
        HashMap<Character,Integer> tMap = new HashMap<Character,Integer>();
        for(int i=0;i<s.length();i++) {
            if(sMap.containsKey(s.charAt(i))) {
              sMap.put(s.charAt(i),sMap.getOrDefault(s.charAt(i),0)+1);
            }
            else {
                sMap.put(s.charAt(i),1);
            }

            if(tMap.containsKey(t.charAt(i))) {
                tMap.put(t.charAt(i),tMap.getOrDefault(t.charAt(i),0)+1);
            }
            else {
                tMap.put(t.charAt(i),1);
            }
        }
        if(sMap.size()!=tMap.size())
            return false;
        return true;
    }
    public static void main(String[] args) {
        IsomorphicStrings is = new IsomorphicStrings();
        System.out.println("Isomorphic:"+is.isIsomorphic("egg","add"));
        // "bbbaaaba" "aaabbbba"
    }
}
