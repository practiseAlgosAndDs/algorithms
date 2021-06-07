package com.solve.java.backTracking;

// LC 22 Medium https://leetcode.com/problems/generate-parentheses/submissions/

//Approach1 : to use backtracking
import java.util.ArrayList;
import java.util.List;

public class GenerateParanthesis {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<String>();
        backTrack(result,"",n,n);
        return result;
    }

    public void backTrack(List result,String s , int left, int right) {
        if(left > right) {
            return;
        }

        if(left==0 && right==0) {
            result.add(s);
            return;
        }

        if(left >0) {
            backTrack(result, s+"(",left-1,right);
        }
        if(right>0) {
            backTrack(result, s+")",left,right-1);
        }
    }

    public static void main(String[] args){
        GenerateParanthesis gp = new GenerateParanthesis();
        List  result = gp.generateParenthesis(3);
        System.out.println("result :"+result.toString());
    }
}
