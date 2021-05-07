package com.practise.java.day2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        if(nums==null) return null;
        Arrays.sort(nums); // this sorts the given array to arrive at n logn time
        // {3,0,-2,-1,1,2}
        // {-2,-1,0,1,2,3}
        List<List<Integer>> outputList = new ArrayList<>();
        for(int i=0;i<nums.length-2;i++) {
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int total = nums[i] + nums[left] + nums[right];
                if (0 == total) {
                    List tempList = Arrays.asList(nums[i], nums[left], nums[right]);
                    outputList.add(tempList);

                    left++;
                    right--;
                } else {
                    if (total < 0)
                        left++;
                    else
                        right--;
                }
            }
        }
        return outputList;
    }
    public static void main(String[] args){
     int[] nums={3,0,-2,-1,1,2};
     ThreeSum ts=new ThreeSum();
     List<List<Integer>> result=ts.threeSum(nums);
     //System.out.println(""+result.size());
    }
}
