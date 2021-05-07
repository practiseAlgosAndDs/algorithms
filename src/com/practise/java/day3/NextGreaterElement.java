package com.practise.java.day3;

public class NextGreaterElement {

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        // handle edge case
        int[] result = new int[nums1.length];
        int index=0;
        int temp=0;
        for(int i=0;i<nums1.length;i++){
            int element = nums1[i];
            temp=-1;
            index=-1;
            for(int j=0;j<nums2.length;j++){
                if(nums2[j]==element) {
                    index=j;
                    continue;
                }
                else if (index!=-1 && j>index && nums2[j]>element) {
                   temp=nums2[j];
                   break;
               }
            }
            result[i]=temp;
        }
      return result;
    }

    public static void main(String[] args){
      //int[] nums1 = {4,1,2};
      //int[] nums2 = {1,3,4,2};
      int[]nums1={2,4};
      int[] nums2 = {1,2,3,4};

      NextGreaterElement nge = new NextGreaterElement();
      int[] result = nge.nextGreaterElement(nums1,nums2);
      for(int i=0;i<result.length;i++){
          System.out.println(""+result[i]);
      }
    }
}
