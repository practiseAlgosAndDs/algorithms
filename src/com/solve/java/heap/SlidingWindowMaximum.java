package com.solve.java.heap;

import java.util.*;
//https://leetcode.com/problems/sliding-window-maximum/

//Approach1: Bruteforce (didnt work)
//Approach2: Using PrioriyQueue (doesnt work for couple of cases)
//Approach3: UsingDequeue (works)
//Approach4: Using Heap (yet to implement)

public class SlidingWindowMaximum {

    public int[] maxSlidingWindow(int[] nums, int k) { //bruteForce
        int max=0;
        int[] result = new int[nums.length-k+1];
        int count=0;
        for(int i=0;i<nums.length-2;i++){
            max=0;
            count=0;
            for(int j=i;count<k;j++){
              if(nums[j]>max) {
                  max=nums[j];
              }
              count++;
            }
            result[i]=max;
        }
       return result;
    }
    public int[] maxSlidingWindowApp2(int[] nums, int k) { // doesnt work for array size<=2

        if(nums.length==1) return new int[]{nums[0]};
        ArrayList<Integer> resultList = new ArrayList<Integer>();
        int count;
        PriorityQueue<Integer> pq = null;
        for(int i=0;i<nums.length;i++){
            count=1;
             pq = new PriorityQueue<Integer>(Collections.reverseOrder());
            for(int j=i;i+2<nums.length && count<=k;j++){
                count++;
                pq.add(nums[j]);
            }
            if(pq.size()>0)
                resultList.add(pq.poll());
        }
        int index=0;
        int[] result = new int[resultList.size()];
        for (Integer num : resultList) {
           result[index]=num;
           index++;
        }
        return result;
    }
    public int[] maxSlidingWindowApp3(int[] nums, int k) {// using Dequeue
        if(nums.length==1) return new int[]{nums[0]};
        int[] result = new int[nums.length-k+1];
        Deque<Integer> dq = new LinkedList<>();
        for(int i=0;i<nums.length;i++) {
            if(i!=0 && dq.peek()<=i-k) dq.removeFirst();
            while(!dq.isEmpty() && nums[dq.peekLast()]<nums[i]) {
                dq.removeLast();
            }
            dq.offerLast(i);
            if(i>k-2) result[i-k+1]= nums[dq.peekFirst()];
        }

        return result;
    }

    public static void main(String[] args) {
      int[] nums = {1,3,-1,-3,5,3,6,7}; // k=3 ,o/p : [3,3,5,5,6,7]
      //int k = 3; // o/p : [3,3,5,5,6,7]
      //int[] nums1 = {1}; // k=1 , o/p[1]
      int[] nums2={9,11}; // k=2, o/p 11
      int k=2;
      SlidingWindowMaximum sm = new SlidingWindowMaximum();
      int [] output=sm.maxSlidingWindowApp3(nums2,k);
      //System.out.println("result:"+output);
      for(int i=0;i<output.length;i++)
      {
          System.out.println(output[i]);
      }
    }
}
