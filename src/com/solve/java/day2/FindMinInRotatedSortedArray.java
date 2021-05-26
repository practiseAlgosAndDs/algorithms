package com.solve.java.day2;

import java.util.Arrays;

public class FindMinInRotatedSortedArray {

    //https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
 /*
 * Approach1:
 * Approach2: using Arrays.sort
 * Approach3:
  */
    public int findMin(int[] nums) {
        if(nums==null) return -1;
        int left = 0 , right=nums.length -1;
        while(left < right)
        {
            int mid = left + ( right-left)/2;
            if(nums[mid] > nums[right]){
                left = mid+1;
            }
            else right =mid;
        }
        return nums[left];
    }
    public int findMinUsingArrays(int[] nums) {
        if(nums==null) return -1;
        Arrays.sort(nums);
        return nums[0];
    }

    public int findMinAnotherApproach(int[] nums){
        if(nums==null) return -1;
        int left=0,right=nums.length-1,mid=0;
        while(left<right){
            mid =(left+right)/2;
            if(nums[mid]>nums[right]) {
                left=mid+1;
            }
            else {
                right=mid;
            }
        }
        return nums[left];
    }

    public static void main(String[] args){

        int[] nums = {4,5,6,7,0,1,2};
        FindMinInRotatedSortedArray findMin = new FindMinInRotatedSortedArray();
        System.out.println(findMin.findMin(nums));

    }
}
