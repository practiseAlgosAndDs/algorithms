package com.solve.java.other;

import java.util.HashMap;
// LC # 290 : https://leetcode.com/problems/word-pattern/
public class WordPattern {

    public boolean wordPattern(String pattern, String s) {

        String[] words = s.split(" ");
        if(words.length!=pattern.length()) return false;

        HashMap<Character,String> patternWordMap = new HashMap<Character,String>();
        for(int i=0;i<words.length;i++) {
            if(patternWordMap.containsKey(pattern.charAt(i))) {
                if(!patternWordMap.get(pattern.charAt(i)).equalsIgnoreCase(words[i])) {
                    return false;
                }
            }
            else {
                if(patternWordMap.containsValue(words[i])){
                   return false;
                }
                patternWordMap.put(pattern.charAt(i),words[i]);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String pattern="abba";
        String s="dog cat cat dog";
        WordPattern wp = new WordPattern();
        System.out.println("wordPattern: "+wp.wordPattern(pattern,s));
    }
}
