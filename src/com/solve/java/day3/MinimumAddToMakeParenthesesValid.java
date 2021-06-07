package com.solve.java.day3;

// LC # medium:  921: https://leetcode.com/problems/minimum-add-to-make-parentheses-valid/

import java.util.Stack;

public class MinimumAddToMakeParenthesesValid {

    public int minAddToMakeValid(String s) {
        if(s.length()==0) return 0;

        int count =0;
        Stack<Character> stack = new Stack<Character>();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='(') {
                stack.push(s.charAt(i));
                count++;
            }
            else if( s.charAt(i)==')'){
                if(!stack.isEmpty() && stack.peek()=='(') {
                    stack.pop();
                    count--;
                }
                else {
                    count++;
                }
            }
        }
        return count;

    }

    public int minAddToMakeValidApp2(String s) { // more cleaner approach
        if(s.length()==0) return 0;
        int count =0;
        //TC O(n), SC L O(n)
        Stack<Character> stack = new Stack<Character>();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='(') {
                stack.push(s.charAt(i));
            }
            else if(stack.isEmpty()) {
                count++;
                continue;
            }
            else {
                stack.pop();
            }
        }
        return (count+stack.size());
    }



    public static void main(String[] args) {
        MinimumAddToMakeParenthesesValid mAddTMakeParan = new MinimumAddToMakeParenthesesValid();

        System.out.println(mAddTMakeParan.minAddToMakeValidApp2("()("));
        System.out.println(mAddTMakeParan.minAddToMakeValidApp2("()))(("));

    }

}
