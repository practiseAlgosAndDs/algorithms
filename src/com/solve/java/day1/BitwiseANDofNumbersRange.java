package com.solve.java.day1;

//https://leetcode.com/problems/bitwise-and-of-numbers-range/submissions/
public class BitwiseANDofNumbersRange {
   // I get Time limit exceeded with the following approach
    public int rangeBitwiseAnd(int left, int right) {
        int res=0|left;
        left++;
        while(left<=right){
           res = res & left;
           left++;
        }
      return res;
    }

    public static void main(String[] args){
        BitwiseANDofNumbersRange ban = new BitwiseANDofNumbersRange();
        System.out.println("ban :"+ban.rangeBitwiseAnd(4,7));
    }
}
