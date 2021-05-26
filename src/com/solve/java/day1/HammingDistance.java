package com.solve.java.day1;

//https://leetcode.com/problems/hamming-distance/
/*
  This Problem can be solved using 2 approaches
  Approach: Using & operation
  Approach2 : apply xor on the two numbers , from the result count the number of bits
 */

public class HammingDistance {
    // using XOR operation
    public int hammingDistance(int x, int y) {
        if(x==y) return 0;
        int res = x ^ y;
        int count=0;
        while(res>0){
            count +=res &1;
            res>>=1;
        }
       return count;
    }

    public static void main(String[] args) {
        HammingDistance hd = new HammingDistance();
        System.out.println(hd.hammingDistance(4,7));
    }
}
