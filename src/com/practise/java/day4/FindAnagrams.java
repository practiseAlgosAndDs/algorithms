package com.practise.java.day4;

import java.util.List;
import java.util.ArrayList;

public class FindAnagrams {

    public List<Integer> findAnagrams(String s, String p) {
        if(s==null || p==null ) {
            return null;
        }

        List<Integer> result = new ArrayList<Integer>();
        int k=0;
        for(int index=0;index<s.length();index++){
            k=index+p.length();
            if(k <=s.length() && isValidAnagram(s.substring(index,k),p)){
                result.add(index);
            }

        }
        return result;
    }

    private boolean isValidAnagram(String substr, String p) {
        int[]  isVisited = new int[128];
        for(int i=0;i<substr.length();i++) {
            isVisited[substr.charAt(i)] ++;
        }

        for(int index=0;index<p.length();index++)
        {
            isVisited[p.charAt(index)]--;
            if(isVisited[p.charAt(index)] ==-1) {
                return false ;
            }
        }

        return true;
    }
}
