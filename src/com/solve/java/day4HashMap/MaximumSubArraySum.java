package com.solve.java.day4HashMap;

// LC 325 Medium https://leetcode.com/problems/maximum-size-subarray-sum-equals-k/
import java.util.HashMap;

//Approach : Using hashmap to store the sum and the index
public class MaximumSubArraySum {

    public int maxSubArrayLen(int[] nums, int k) {

        HashMap<Integer,Integer> hMap = new HashMap<Integer,Integer>();
        hMap.put(0,-1);
        int sum=0, max =0;
        for(int i=0;i<nums.length;i++) {
            sum +=nums[i];
            if(hMap.containsKey(sum-k)) {
                max=Math.max(max, i-hMap.get(sum-k));
            }
            if(!hMap.containsKey(sum)) hMap.put(sum,i);
        }
        return max;
    }

    public static void main(String[] args) {

    }
}
