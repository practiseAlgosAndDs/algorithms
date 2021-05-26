package com.solve.java.day2;

import java.util.HashSet;
import java.util.HashMap;
import java.util.Map;

public class CinemaSeatAllocation {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) { //BruteForce
        if(reservedSeats==null) return n*2;
        int result=0;

        //Step1. TO construct 2d array
        int[][] seatsArray = new int[n][10];
        //Step2 . Marking the reserved seats
        for(int i=0;i<reservedSeats.length;i++){
            int row=reservedSeats[i][0];
            int col=reservedSeats[i][1];
            seatsArray[row-1][col-1]=-1;

        }

        //Step3 . Calculate number of 4 person Groups
        for(int i=0;i<seatsArray.length;i++){
           int count=0;
            for(int j=1;j<seatsArray[0].length-1;j++){
                if(count==4) {
                    result++;
                    count=0;
                }

                if(seatsArray[i][j]==-1) {
                    count=0;
                }
                else{
                    count++;
                }
            }
        }
        return result;
    }
    //Approach2.
    public int maxNumberOfFamiliesOptimised(int n, int[][] reservedSeats){
        int numOfReservedSeats = reservedSeats.length;
        Map<Integer, HashSet<Integer>> map = new HashMap<>();
        for(int i = 0; i < numOfReservedSeats; i++) {
            if(!map.containsKey(reservedSeats[i][0])) {
                map.put(reservedSeats[i][0], new HashSet<>());
            }
            map.get(reservedSeats[i][0]).add(reservedSeats[i][1]);
        }
        int count = 2 * n - 2 * map.size();
        /*for(Integer i : map.keySet()) {
            boolean flag = false;
            Set<Integer> reserved = map.get(i);
            if(!reserved.contains(2) && !reserved.contains(3) && !reserved.contains(4) && !reserved.contains(5)) {
                count++;
                flag = true;
            }
            if(!reserved.contains(6) && !reserved.contains(7) && !reserved.contains(8) && !reserved.contains(9)) {
                count++;
                flag = true;
            }
            if(!flag && !reserved.contains(4) && !reserved.contains(5) && !reserved.contains(6) && !reserved.contains(7)) {
                count++;
            }
        }*/
        return count;
    }
    public static void main(String[] args)
    {
        //int[][] nums = {{1,2},{1,3},{1,8},{2,6},{3,1},{3,10}};
        //int[][] nums={{2,1},{1,8},{2,6}};
        int[][] nums={{4,3},{1,4},{4,6},{1,7}};
        //int[][] nums={{2,10},{3,1},{1,2},{2,2},{3,5},{4,1},{4,9},{2,7}};
        CinemaSeatAllocation csa = new CinemaSeatAllocation();
        System.out.println(""+csa.maxNumberOfFamilies(4,nums));
    }
}
