package com.practise.day5;

//https://leetcode.com/problems/range-sum-query-mutable/submissions/
//Approach1 : using Segment Trees
//Apprach2: can use FenwickTrees as well ( need to explore this)

public class RangeSum {

    int [] segmentTree =null;
    void buildSegmentTree(int stIndex,int[] array,int start,int end) {
        if(start>end) { // base case , invalid case
           return;
        }
        if(start==end) { // leaf Nodes
            if(stIndex >-1 && stIndex<segmentTree.length)
              segmentTree[stIndex]=array[start];
            return;
        }

        //Internal Nodes
        int middle = start + (end-start)/2; // this is done to avoid overhead
        buildSegmentTree(2*stIndex+1,array,start,middle);// left Node or left subtree
        buildSegmentTree(2*stIndex+2,array,middle+1,end); // right Node  or rightsubtree
        segmentTree[stIndex]=segmentTree[2*stIndex+1]+segmentTree[2*stIndex+2];
    }

    private int querySum(int queryStart, int queryEnd, int stIndex,int start,int end){

        if(queryStart>end || queryEnd<start) { // nonOverlapCase
            return 0;
        }
        if(start>=queryStart && end<=queryEnd) // fullOverlapcase
            return segmentTree[stIndex];

        // partialOverlap case
        int middle =start+(end-start)/2; // to avoid overflow
        int leftSum = querySum(queryStart,queryEnd,2*stIndex+1,start,middle);
        //System.out.println("leftSum:"+leftSum);
        int rightSum=querySum(queryStart,queryEnd,2*stIndex+2,middle+1,end);
        //System.out.println("rightSum:"+rightSum);
        return leftSum+rightSum;
    }

    private void update(int stIndex,int start, int end,int pos, int newValue) {
        if(start>pos|| end <pos){
            return;
        }
        if(start==end) { // leafNode
            segmentTree[stIndex] = newValue;
            return;
        }
        //InternalNode case
        int middle = start+(end-start)/2;
        update(2*stIndex+1,start,middle,pos, newValue);
        update(2*stIndex+2,middle+1,end,pos, newValue);
        segmentTree[stIndex]=segmentTree[2*stIndex+1]+segmentTree[2*stIndex+2];

    }

    public static void main(String[] args) {

        int[] arr = {1,3,2,-2,4,5};
        int n=arr.length;
        RangeSum rs = new RangeSum();
        rs.segmentTree = new int[4*n+1];
        int stIndex=0;
        int start=0 , end=n-1;
        // print out the segment tree
        rs.buildSegmentTree(stIndex,arr,start,end);
        for(int i=0;i<rs.segmentTree.length;i++) {
            System.out.print(rs.segmentTree[i]);
        }
        //System.out.println(rs.querySum(0,2,stIndex,start,end));
        System.out.println("******************");
        arr[2]=100;
        rs.update(stIndex,start,end,2,100);
        for(int i=0;i<rs.segmentTree.length;i++) {
            System.out.print(rs.segmentTree[i]);
        }
        //System.out.println(rs.querySum(2,4,stIndex,start,end));
        System.out.println("******************");



    }
}
