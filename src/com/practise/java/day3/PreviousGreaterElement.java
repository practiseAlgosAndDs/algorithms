package com.practise.java.day3;

//https://www.geeksforgeeks.org/previous-greater-element/
/*
Approach 1: BruteForce
 */
public class PreviousGreaterElement {

    private int[] findPreviousGreaterElement(int[] nums) // Bruteforce
    {
       if(nums==null) return null;
       int[] result = new int[nums.length];
       int max=nums[0];
       result[0] =-1;
       for(int i=1;i<nums.length;i++) {
           if(nums[i]<max) {
               result[i]=max;
           }
           else {
               result[i]=-1;
           }
           max=nums[i];
       }
       return result;
    }

    public static void main(String[] args){
        //int[] nums= {10, 4, 2, 20, 40, 12, 30};
        //int[] nums ={10, 20, 30, 40};
        int[] nums ={40, 30, 20, 10};
     PreviousGreaterElement pge = new PreviousGreaterElement();
     int[] result = pge.findPreviousGreaterElement(nums);
     for(int i=0;i<result.length;i++){
         System.out.println("result :"+result[i]);
     }

    }
}
