package com.solve.java.day3;

import java.util.Stack;

//https://leetcode.com/problems/valid-parentheses/submissions/
public class ValidParanthesis {
    public boolean isValid(String s) { //used Stack to solve this
        if(s==null || s=="")
            return false;

        boolean result = true;
        Stack<Character> stack = new Stack<Character>();
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)=='(' || s.charAt(i)=='[' || s.charAt(i)=='{') {
                stack.push(s.charAt(i));
            }
            else
            {
                if(stack.empty()) return false;
                if((s.charAt(i)==')' && stack.peek()!='(')
                        || (s.charAt(i)==']' && stack.peek()!='[')
                        || (s.charAt(i)=='}' && stack.peek()!='{')){
                    return false;
                }
                stack.pop();
            }
        }

        return stack.empty();
    }
}
