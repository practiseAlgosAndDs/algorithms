package com.practise.java.day1;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

//https://leetcode.com/problems/majority-element/

public class MajorityElement {

    // Implement Using Moore's Voting Algorithm
    public int findCandidate(int[] nums){
        if(nums==null) return -1;
        int majElementIndex=0;
        int count =1;
        for(int i=1;i<nums.length;i++){
            if(nums[majElementIndex]==nums[i]){
                count++;
            }else {
                count--;
            }
            if(count==0) {
                majElementIndex = i;
                count=1;
            }
        }
        return nums[majElementIndex];
    }

    private boolean isMajorityElement(int[] nums,int majElement){
        int count =0;
        int length=nums.length;
        for(int i=0;i<length;i++){
            if(majElement==nums[i]){
                count++;
            }
        }
        if(count>(length/2)){
           return true;
        }
        return false;
    }

    public int majorityElement(int[] nums) { //BruteForce Way
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

        int occurrence=nums.length/2;
        int maxOccurrence=0;
        int occurrenceKey=-1;
        for (Map.Entry mapElement : hMap.entrySet()) {
            Integer key = (Integer)mapElement.getKey();
            int value = (int)mapElement.getValue();
            if(value > occurrence && maxOccurrence < value) {
                maxOccurrence=value;
                occurrenceKey=key;
            }
        }

        return occurrenceKey;
    }
    public static void main(String[] args) {
        int[] nums ={2,2,1,1,1,2,2};
        MajorityElement me = new MajorityElement();
        //System.out.println(me.majorityElement(nums));
        int candidate=me.findCandidate(nums);
        System.out.println( me.isMajorityElement(nums,candidate));
    }
}
