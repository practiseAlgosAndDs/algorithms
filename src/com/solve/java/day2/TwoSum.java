package com.solve.java.day2;

import java.util.HashMap;

public class TwoSum {

    public int[] twoSums(int[] nums, int target){
        if (nums == null || nums.length ==0) {
            return null;
        }

        HashMap hMap = new HashMap();
        for (int index=0;index<nums.length;index++)
        {
            int temp = target - nums[index];
            if(hMap.containsKey(temp))
            {
                return new int[]{(int) hMap.get(temp), index};
            }
            hMap.put(nums[index], index);
        }
        return null;
    }

    public static void main(String[] args){
      int[] nums={3,2,4};
      TwoSum twoSum = new TwoSum();
      System.out.println("test:"+twoSum.twoSums(nums,6));
    }
}
