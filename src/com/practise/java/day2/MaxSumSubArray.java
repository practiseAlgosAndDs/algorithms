package com.practise.java.day2;

public class MaxSumSubArray {
    // https://leetcode.com/problems/maximum-subarray/
    // Approach
    // this problem can be done using
    //a. Kandanes Algorithm
    //b. Dynamic programming

    public int maxSubArray(int[] nums) { //this solution is implemented using Kadane's Algoithm
        if(nums==null) return 0;
        int maxSum=nums[0];
        int currentSum = maxSum;
        for(int i=1;i<nums.length;i++){
            currentSum = Math.max(nums[i],nums[i]+currentSum);
            maxSum = Math.max(maxSum,currentSum);
        }
        return maxSum;
    }
    public static void main(String[] args) {
     int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
     MaxSumSubArray subArray = new MaxSumSubArray();
     System.out.println("Printing Max SubArray: "+subArray.maxSubArray(nums));
    }
}
