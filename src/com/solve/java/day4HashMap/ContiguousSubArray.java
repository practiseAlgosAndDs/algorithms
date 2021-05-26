package com.solve.java.day4HashMap;

import java.util.HashMap;

//https://leetcode.com/problems/contiguous-array/
//Appraoch1: Bruteforce , using 2 forloops iterate through the array and check the count of the number of 0's & 1's

public class ContiguousSubArray {

    public int findMaxLength(int[] nums) { // gives Time limit exceeded in LC , need to find a better approach to do it

        int sum=0;
        int maxSubArrayLength=0;
        int currLength=0;
        for(int i=0;i<nums.length;i++) {
            sum =nums[i]==0 ? -1:1;
            currLength=1;
            for(int j=i+1;j<nums.length;j++) {
                sum = sum+ (nums[j]==1?1:-1);
                currLength++;
                if(sum==0)
                {
                   if (maxSubArrayLength<currLength)
                   {
                       maxSubArrayLength=currLength;
                   }
                }
            }
        }
        System.out.println("findMaxLength:"+maxSubArrayLength);
        return maxSubArrayLength;
    }

    public int findMaxLengthApproach2(int[] nums) { // what will be the approach
      HashMap hMap = new HashMap();
      int maxSubArrayLength=0;
      int sum=0;
      int length=0;
      for(int i=0;i<nums.length;i++) {
          sum +=(nums[i]==0?-1:1);
          if(sum!=0 && !hMap.containsKey(sum)) {
              hMap.put(sum,i);
          }
          else{
              if(sum==0){
                  length=i+1;
              }
              else {
                  length=i-(int)hMap.get(sum);
              }

              if(maxSubArrayLength<length) {
                  maxSubArrayLength =length;
              }
          }
      }
      System.out.println("longestContiguousSubArrayLength: "+maxSubArrayLength);
      return -1;
    }
    public static void main(String[] args) {
       //int[] nums={1,1,1,0,0,1,1};
       int[] nums={1,1,0,0,1,1,0,1,1};
        ContiguousSubArray csa = new ContiguousSubArray();
        //csa.findMaxLength(nums);
        csa.findMaxLengthApproach2(nums);
    }
}
