package com.solve.java.dp;

//LC medium 139 : https://leetcode.com/problems/word-break/
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.HashSet;

public class WordBreak {
    // this is recursive + memoization
    public boolean wordBreak(String s, List<String> wordDict) { // submission leads to timelimit exceeded
        HashMap<String,Boolean> map = new HashMap();
        if(s.equals(""))
            return true;
        if(map.containsKey(s))
            return map.get(s);
        for(int i=1;i<s.length();i++) {
            String left =s.substring(0,i);
            if(wordDict.contains(left) && wordBreak(s.substring(i),wordDict)) {
                map.put(s,true);
                return true;
            }
        }
        map.put(s,false);
        return false;
    }

    public boolean wordBreakApproach2(String str, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>();
        for(String s: wordDict){
            wordSet.add(s);
        }

        return dfs(str,wordSet);
    }

    public boolean dfs(String s, Set wordSet) { // even this one as well

        if(s.equals("")) {
            return true; // basecase
        }
        for(int i=1;i<=s.length();i++) {
            if(wordSet.contains(s.substring(0,i)) && dfs(s.substring(i),wordSet)) {
                return true;
            }
        }
        return false;
    }

    public boolean df2(String s, Set wordSet){
        return false;
    }

    public boolean wordBreakApp3(String s, List<String> wordDict) {
        Set<String> words = new HashSet<>();
        for(String word: wordDict) {
            words.add(word);
        }
        int n = s.length();
        boolean dp[] = new boolean[n+1];
        dp[0] = true;

        for(int i = 1; i <= n; i++) {
            for(int j = 0; j < i; j++) {

                if(dp[j] == true) {
                    String word = s.substring(j, i);
                    if(words.contains(word)) {
                        dp[i] = true;
                        break;
                    }
                }
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        WordBreak wb = new WordBreak();
        List<String> wordDict = new ArrayList<String>();
        wordDict.add("leet");
        wordDict.add("code");
        String input="aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab";
        String[] wordDictArr= {"a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa"};
        List<String> testDict=Arrays.asList(wordDictArr);
       // System.out.println(wb.wordBreak(input,testDict));
        //System.out.println(wb.wordBreakApproach2(input,testDict));
        System.out.println(wb.wordBreakApp3(input,testDict));
    }

}
