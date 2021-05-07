package com.practise.java.day2;

public class FindMinInRotatedSortedArray {

    //https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
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
    public static void main(String[] args){

        int[] nums = {4,5,6,7,0,1,2};
        FindMinInRotatedSortedArray findMin = new FindMinInRotatedSortedArray();
        System.out.println(findMin.findMin(nums));

    }
}
