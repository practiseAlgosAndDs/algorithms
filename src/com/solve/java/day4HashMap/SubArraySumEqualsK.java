package com.solve.java.day4HashMap;

// LC 560 medium https://leetcode.com/problems/subarray-sum-equals-k/
import java.util.HashMap;

public class SubArraySumEqualsK {
    public int subarraySum(int[] nums, int k) {
        if(nums==null) return -1;
        HashMap<Integer,Integer> hMap = new HashMap<Integer,Integer>();
        hMap.put(0,1);
        int sum=0,count=0;
        for(int i=0;i<nums.length;i++) {
            sum +=nums[i];
            if(hMap.containsKey(sum-k)) {
                count += hMap.get(sum-k);
            }
            hMap.put(sum, hMap.getOrDefault(sum, 0)+1);
        }
        return count;
    }
    public static void main(String[] args) {
        SubArraySumEqualsK sub = new SubArraySumEqualsK();
        int[] nums = {1,2,1,2,1,2,1};
        System.out.println(sub.subarraySum(nums,3));
    }
}
