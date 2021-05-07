package com.practise.java.day3;

//https://leetcode.com/problems/rotting-oranges/
/*
Approach 1: to Iterate through the array and check if any cel next to the current cell and below current cell can be marlked rotten
provided the current cell has a rotten orange
Approach 2: using BFS (need to explore this)
 */
public class RottingOranges {

    public int orangesRotting(int[][] grid) { //BruteForce // not working for {0,2}
        if (grid ==null) return -1;
       // if(grid[0][0]==0) return 0;
        int count=0;
        for(int i=0;i<grid.length;i++) {
            int rowLength=grid[0].length;
            for(int j=0;j<rowLength;j++) {
                boolean markedRotten = false;
                if(grid[i][j]==2) {
                    if(j+1 < rowLength && grid[i][j+1]==1) {
                        grid[i][j+1] =2;
                        markedRotten=true;
                    }
                    if(i+1 < rowLength && grid[i+1][j]==1) {
                        grid[i+1][j]=2;
                        markedRotten=true;
                    }
                }
                if(markedRotten) {
                    count++;
                }
            }
        }
        boolean isAllRotten = true;
        for(int i=0;i<grid.length;i++) {
            for (int j = 0; j < grid[0].length; j++) {
              if(grid[i][j]==1) {
                  isAllRotten=false;
                  break;
              }
            }
        }
       return (isAllRotten?count:-1);
    }

    public static void main(String[] args){
     //int[][] nums = {{2,1,1},{1,1,0},{0,1,1}};
     //int[][] nums = {{2,1,1},{0,1,1},{1,0,1}};
     int[][] nums={{0,2}};
     RottingOranges ro = new RottingOranges();
     System.out.println(ro.orangesRotting(nums));

    }
}
