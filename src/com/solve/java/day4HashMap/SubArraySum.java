package com.solve.java.day4HashMap;

// LC 560 https://leetcode.com/problems/subarray-sum-equals-k/

public class SubArraySum {
    public int subarraySum(int[] nums, int k) { // doesnt work need to think about an alternative appraoch
        int sum=0;
        int idxCount=0;
        int result=0;
     for(int i=0;i<nums.length;i++) {
         idxCount++;
         sum = sum+nums[i];
         if(sum==k)
         {
             result= (result==0) ?idxCount: result+idxCount;
             idxCount=0;
             sum=0;
         }
     }
     System.out.println("SubArraySum :"+result);
      return -1;
    }

    public static void main(String[] args) {
      int[] nums={1,1,1}; //k=2 , result=2
      int[] nums0={1,2,3};//k=3 ,result=2;
      int[] nums1={1,2,1,2,1};// k=3 , result =4
      int[] nums2={1};//k=1,result=1
        int[] nums3={1};//k=0,result=0
        SubArraySum sas = new SubArraySum();
        sas.subarraySum(nums0,3);
    }
}
