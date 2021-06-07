package com.solve.java.day3;

//LC medium 1249 https://leetcode.com/problems/minimum-remove-to-make-valid-parentheses/

import java.util.Stack;

public class MinimumRemoveToMakeValidParanthesis {

    public String minRemoveToMakeValid(String s) {
        //Approach is to take
        Stack<Integer> stack = new Stack<Integer>();
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<s.length();i++){
            sb.append(s.charAt(i));
            if(s.charAt(i)=='(') {
                stack.push(i);
            }
            else if(s.charAt(i)==')') {
                if( stack.isEmpty()) {
                    sb.setCharAt(i,'*');
                }
                else {
                    stack.pop();
                }
            }
        }
        while(!stack.empty()) {
            sb.setCharAt(stack.pop(),'*');
        }

        return sb.toString().replaceAll("\\*","");
    }

    public static void main(String[] args) {

        MinimumRemoveToMakeValidParanthesis mrm = new MinimumRemoveToMakeValidParanthesis();
        String s = "lee(t(c)o)de)";

        System.out.println(mrm.minRemoveToMakeValid("))(("));
    }
}
