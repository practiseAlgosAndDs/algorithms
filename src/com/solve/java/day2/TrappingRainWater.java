package com.solve.java.day2;

//https://leetcode.com/problems/trapping-rain-water/

/*Approach1: O(n square)
  Approach2:
   a. have a maxLeft array , for each value in the height array calculate and store max left in the maxleft array for each value in the height array
   b. have a maxLeft array , for each value in the height array calculate and store max right in the maxright array for each value in the height arrayO(N)
  Approach3: using 2 pointers ( reduces space coplexity than approach2 )
*/

public class TrappingRainWater {

    // Using Approach2
    public int trap(int[] height) {
        if(height==null || height.length==0) return 0;// base case

        int[] maxLeftArr = new int[height.length];
        int[] maxRightArr = new int[height.length];
        // Step1. Calculate maxLeft for each element in the height array
        int maxLeft=height[0];
        for(int i=1;i<height.length;i++) {
            if(height[i]<maxLeft) {
                maxLeftArr[i]=maxLeft;
            }
            else {
                maxLeft=height[i];
                maxLeftArr[i]=maxLeft;

            }
        }
        // Step2. Calculate maxRight for each element in the height array
        int maxRight = height[height.length-1];
        for(int i=height.length-2;i>=0;i--){
            if(maxRight<height[i]) {
                maxRight = height[i];
                maxRightArr[i] = maxRight;
            }
            else {
                maxRightArr[i] = maxRight;
            }
        }
        //Step3.Calculate Trapped water
        int min =-1;
        int countTrapWater=0;
        // we are not starting with first element and end with last element because they both don't store any water by themselves
        for(int i=1;i<height.length-1;i++) {
            // for each value in the check get the min of (maxleft & max right)
           min = Math.min(maxLeftArr[i],maxRightArr[i]);
            countTrapWater = countTrapWater + (min-height[i]) * 1;
        }
        return countTrapWater;
    }
    //
    public int trapWater(int[] height) {
        int length =height.length;
        if(height==null || length==0) return 0;// base case
        int maxLeft=height[0];
        int maxRight=height[length-1];
        int trappedWater=0;
        int left = 1;
        int right = length-2;
        while(left<=right)
            if(height[left]<maxLeft){
                trappedWater =trappedWater + (maxLeft-height[left]) * 1;
                left++;
            }
            else {
                maxLeft = height[left];
                if(maxLeft>maxRight) {
                    trappedWater =trappedWater +(maxRight-height[right]) * 1;
                    right--;
            }

        }
      return trappedWater;
    }
    public static void main(String[] args) {
        int[] height = {4,2,0,3,2,5};
        TrappingRainWater trw = new TrappingRainWater();
        //System.out.println("TrapWater: "+trw.trapWater(height));
        int[] height2 = {0,1,0,2,1,0,1,3,2,1,2,1};
        int[] height3= {4,2,0,6,3,2,5};
        System.out.println("TrapWater: "+trw.trapWater(height3));
    }
}
