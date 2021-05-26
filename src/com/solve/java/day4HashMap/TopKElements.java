package com.solve.java.day4HashMap;

import java.util.HashMap;
import java.util.PriorityQueue;

//https://leetcode.com/problems/top-k-frequent-elements/

/*
Approach (1) : using Hashmap with streams
Appraoch(2) : using Priority Quueue
 */

public class TopKElements {

    public int[] topKFrequent(int[] nums, int k) {

        if(nums.length ==1)
        {
            return new int[]{nums[0]};
        }

        HashMap<Integer,Integer> elementMap = new HashMap<Integer,Integer>();
        for(int i=0;i<nums.length;i++){
            elementMap.put(nums[i],(int)elementMap.getOrDefault(nums[i],0)+1);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<Integer>((e1, e2)->elementMap.get(e1)-elementMap.get(e2));
        for(int num: elementMap.keySet()){
            pq.add(num);
            if(pq.size()>k) {
                pq.poll();
            }
        }

        int[] result = new int[k];
        for(int i=0;i<result.length;i++){
            result[i] = pq.poll();
        }
       return result;
    }

    public static void main(String[] args){
      int [] nums = {1,1,1,2,2,3};
      TopKElements tke = new TopKElements();
      int [] result = tke.topKFrequent(nums,2);
      for(int i=0;i<result.length;i++) {
          System.out.println(result[i]);
      }

    }
}
