package com.solve.java.day1;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/single-number-ii/

public class SingleNumberII {

    public int findSingleNumber(int[] nums) { //BruteForce Way // solved using HashMap
        if(nums==null) return -1;

        HashMap<Integer,Integer> hMap = new HashMap<Integer,Integer>();
        int count=0;
        for(int i=0;i<nums.length;i++) {
            if(hMap.containsKey(nums[i])) {
                count = (int)hMap.get(nums[i]);
                hMap.put(nums[i],++count);
            }
            else
            {
                count=0;
                hMap.put(nums[i],++count);
            }
        }
        int minOccurrence=-1;
        int result=-1;
        for (Map.Entry mapElement : hMap.entrySet()) {
            Integer key = (Integer)mapElement.getKey();
            int value = (int)mapElement.getValue();
            if(minOccurrence==-1) {
                minOccurrence=value;
                result=key;
            }
            if(value<minOccurrence) {
                minOccurrence=value;
                result=key;
            }
        }

        return result;
    }

    public static void main(String[] args)
    {
        SingleNumberII sn = new SingleNumberII();
        int[] nums={4,1,2,1,2,1,2};
        System.out.println(sn.findSingleNumber(nums));
    }
}
