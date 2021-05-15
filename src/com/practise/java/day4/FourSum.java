package com.practise.java.day4;

import java.util.*;
//https://leetcode.com/problems/4sum/

public class FourSum {

    List<List<List<Integer>>> outputList = new ArrayList<>();
    //approach1
    public void fourSum(int[] nums){
        Arrays.sort(nums); // this sorts the given array to arrive at n logn time
        for(int i=0;i<nums.length;i++){
            List<List<Integer>> temp =threeSum(nums,nums[i],i+1);
            if(!temp.isEmpty())
            {
                System.out.println("fourSum :"+temp.toString());
            }
            //outputList.add(temp);
        }
        System.out.println("fourSum :"+outputList.toString());
    }
    public List<List<Integer>> threeSum(int[] nums,int target , int startIndex) {
        if(nums==null) return null;
        Set<List<Integer>> outputSet = new HashSet<>();
        int left=0, right=0,total=0;
        for(int i=startIndex;i<nums.length-2;i++) {
            left = i + 1;
            right = nums.length - 1;
            while (left < right) {
                total = nums[i] + nums[left] + nums[right] +target;
                if (0 == total) {
                    List<Integer> targetSet = new ArrayList<>();
                    targetSet.add(target);
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

    //Approach2
    public List<List<Integer>> fourSumApproachTwo(int[] nums){ // failed for case  i/p : [-3,-1,0,2,4,5] , target 2 , o/p:[[-3,-1,2,4]]
        Arrays.sort(nums); // this sorts the given array to arrive at n logn time
        Set<List<Integer>> outputSet = new HashSet<>();
        Set<List<Integer>> outputList = new HashSet<>();
        for(int index=0;index<nums.length;index++){

            int left=0, right=0,total=0;
            for(int i=index+1;i<nums.length-2;i++) {
                left = i + 1;
                right = nums.length - 1;
                while (left < right) {
                    total = nums[i] + nums[left] + nums[right] +nums[index];
                    if (0 == total) {
                        List<Integer> targetSet = new ArrayList<>();
                        targetSet.add(nums[index]);
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
            outputList.addAll(outputSet);
        }
        if(!outputList.isEmpty())
        {
            System.out.println("fourSum :"+outputList.toString());
        }
        List<List<Integer>> output = new ArrayList<>(outputList);
        return output;
    }

    public  List<List<Integer>> fourSumApproach3(int[] nums,int target){
        if(nums==null) return null;
        Arrays.sort(nums);
        Set<List<Integer>> outputSet = new HashSet<>();
        Set<List<Integer>> outputList = new HashSet<>();
        int left=0,right=nums.length-1,j=0;
        int total=0;
        for(int i=0;i<nums.length-2;i++) {
            left = i + 1;
            right = nums.length - 1;
            j=right -1;
            while (left < right) {
                total = nums[i] + nums[left] + nums[right] +nums[j];
                if (target == total) {
                    List<Integer> targetSet = new ArrayList<>();
                    targetSet.add(nums[i]);
                    targetSet.add(nums[left]);
                    targetSet.add(nums[j]);
                    targetSet.add(nums[right]);
                    outputSet.add(targetSet);
                    j--;
                    if(j<=left)
                        right--;
                    left++;
                } else {
                    if (total < 0)
                        left++;
                    else
                    { right--; j--;}
                }
            }
            outputList.addAll(outputSet);
        }
        if(!outputList.isEmpty())
        {
            System.out.println("fourSum :"+outputList.toString());
        }
        List<List<Integer>> output = new ArrayList<>(outputList);
        return output;

    }
    public static void main(String[] args) {
        FourSum fs = new FourSum();
       //int[] nums={1,0,-1,0,-2,2};
        int[] nums={-3,-1,0,2,4,5};
        //fs.fourSum(nums);
        fs.fourSumApproach3(nums,0);
    }
}
