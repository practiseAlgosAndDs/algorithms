package com.solve.java.day1;

//https://leetcode.com/problems/counting-bits/
public class CountingBits {

    public int[] countBits(int num) {
        int j,count=0;
        int[] result = new int[num+1];
        for(int i=0;i<=num;i++){
            j=i;
            count=0;
            while(j>0){
                count +=j&1;
                j>>=1;
            }
            result[i]=count;
        }
      return result;
    }

    public static void main(String[] args){
        CountingBits cb = new CountingBits();
        int[] result = cb.countBits(2);
        for(int i=0;i<result.length;i++){
            System.out.println("result:"+result[i]);
        }
    }
}
