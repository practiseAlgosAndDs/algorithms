package com.solve.java.day2;

// https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array
public class FindFirstFindLast {
    public int[] searchRange(int[] nums, int target) {
        if(nums.length==0 && target==0) return new int[]{-1,-1};
        int[] output = new int[]{-1,-1};
        int low=0,mid=0,high=nums.length,index=0;
        mid = (low +(high-low))/2;

        while(low<mid) {
            if(nums[low]==target) {
                output[index]=low;
                index++;
            }
            low++;
        }
        while(mid<high){
            if(nums[mid]>target)
                break;
            if(nums[mid]==target) {
                output[index]=mid;
                index++;
            }
            mid++;
        }
        return null;
    }

    public static void main(String[] args) {

    }

}
