package com.practise.java.day2;

import java.util.*;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        if(nums==null) return null;
        Arrays.sort(nums); // this sorts the given array to arrive at n logn time
        Set<List<Integer>> outputSet = new HashSet<>();
        int left=0, right=0,total=0;
        for(int i=0;i<nums.length-2;i++) {
            left = i + 1;
            right = nums.length - 1;
            while (left < right) {
                total = nums[i] + nums[left] + nums[right];
                if (0 == total) {
                    List<Integer> targetSet = new ArrayList<>();
                    targetSet.add(nums[i]);
                    targetSet.add(nums[left]);
                    targetSet.add(nums[right]);
                    outputSet.add(targetSet);
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
        List<List<Integer>> outputList = new ArrayList<>(outputSet);
        return outputList;
    }
    public static void main(String[] args){
     int[] nums={3,0,-2,-1,1,2};
     ThreeSum ts=new ThreeSum();
     List<List<Integer>> result=ts.threeSum(nums);
     System.out.println(""+result.size());
     System.out.println(""+result.get(0));
     System.out.println(""+result.get(1));
     System.out.println(""+result.get(2));
    }
}
