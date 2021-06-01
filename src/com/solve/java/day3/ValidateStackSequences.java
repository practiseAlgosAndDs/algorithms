package com.solve.java.day3;

// LC Medium https://leetcode.com/problems/validate-stack-sequences/

import java.util.Stack;

public class ValidateStackSequences {

    public boolean validateStackSequences(int[] pushed, int[] popped) {
        if(pushed.length!=popped.length) return false;

        Stack<Integer> stack = new Stack<Integer>();
        int i=0,j=0;
        while(i<pushed.length) {
            while(!stack.empty() && (j<i)) { // to process multiple pops condition
                if(stack.peek() == popped[j]) {
                    stack.pop();
                    j++;
                }
                else break;
            }
            stack.push(pushed[i]);
            i++;
        }

        while(!stack.empty()) { // just incase if the still have elements from stack which need to be popped out
            if(stack.peek()==popped[j]) {
                stack.pop();
                j++;
            }
            else return false;
        }
        return true;
    }
}
