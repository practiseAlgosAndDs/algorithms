package com.solve.java.heap;

import java.util.ArrayList;
//https://leetcode.com/problems/sliding-window-maximum/

//Approach1: Bruteforce
//Approach2: Using Heap

public class SlidingWindowMaximum {

    public int[] maxSlidingWindow(int[] nums, int k) { //bruteForce
        int max=0;
        int[] result = new int[nums.length-2];
        int count=0;
        for(int i=0;i<nums.length-2;i++){
            max=0;
            count=0;
            for(int j=i;count<k;j++){
              if(nums[j]>max) {
                  max=nums[j];
              }
              count++;
            }
            result[i]=max;
        }
       return result;
    }

    public static void main(String[] args) {
      int[] nums = {1,3,-1,-3,5,3,6,7};
      int k = 3; // o/p : [3,3,5,5,6,7]
      SlidingWindowMaximum sm = new SlidingWindowMaximum();
      int [] output=sm.maxSlidingWindow(nums,k);
      System.out.println("result:"+output);
      for(int i=0;i<output.length;i++)
      {
          System.out.println(output[i]);
      }
    }
}
