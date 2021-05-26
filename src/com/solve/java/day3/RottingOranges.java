package com.solve.java.day3;

import java.util.Queue;
import java.util.LinkedList;

//https://leetcode.com/problems/rotting-oranges/
/*
Approach 1: to Iterate through the array and check if any cel next to the current cell and below current cell can be marked rotten
provided the current cell has a rotten orange
Approach 2: using BFS (need to explore this)
 */
public class RottingOranges {
  //TODO
    public int orangesRotting(int[][] grid) { //BruteForce // not working for {0,2}
        if (grid ==null) return -1;
       // if(grid[0][0]==0) return 0;
        int count=0;
        for(int i=0;i<grid.length;i++) {
            int rowLength=grid[0].length-1;
            //System.out.println("rowLength:"+rowLength);
            for(int j=0;j<rowLength;j++) {
                boolean markedRotten = false;
                if(grid[i][j]==2) {
                    //1.top
                    //System.out.println("top : "+(i-1));
                    if(i-1!=-1 && i-1<grid.length && grid[i-1][j]==1){
                        grid[i-1][j]=2;
                        markedRotten=true;
                    }
                    //2.left
                    //System.out.println("left: "+(j-1));
                    if(j-1!=-1 && j-1<rowLength && grid[i][j-1]==1){
                        grid[i][j-1]=2;
                        markedRotten=true;
                    }
                    //3.right
                    //System.out.println("right: ");
                    if(j+1 <rowLength && grid[i][j+1]==1) {
                        grid[i][j+1] =2;
                        markedRotten=true;
                    }
                    //4.bottom
                    //System.out.println("bottom:"+(i+1)+" J:"+j);
                    if(i+1 < grid.length && j<rowLength && grid[i+1][j]==1) {
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
    // implement is using Queue
    public int rottingOranges(int[][] grid){ // not working for {0,2}
        if (grid ==null) return -1;
        if(grid.length==1 && grid[0].length==1)  {
            if(grid[0][0]==0) return 0;
            if(grid[0][0]==1) return-1;
        }
        Queue<Node> q = new LinkedList<Node>();
        // collect indices  where the oranges are rotten
        for(int i=0;i<grid.length;i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if(grid[i][j]==2) {
                    q.add(new Node(i,j,0));
                }
            }
        }
        int result=0;
        // visit the neighbours
        Node n;
        // TODO compare the minutes with the max Value
        while (!q.isEmpty()) {
            // Retrieve top of queue and then visit its adjacent oranges
             n = q.poll();
            int row = n.i;
            int col = n.j;
            int minutes = n.minutes;

            if(row-1 !=-1 && row-1<grid.length && grid[row-1][col]==1) {
                Node newNode = new Node(row-1,col,minutes+1);
                q.add(newNode);
                grid[row-1][col]=2;
            }

            if(col+1<grid.length && grid[row][col+1]==1) {
                Node newNode = new Node(row,col+1,minutes+1);
                q.add(newNode);
                grid[row][col+1]=2;
            }

            if(col-1!=-1 && col-1>grid[0].length && grid[row][col-1]==1) {
                Node newNode = new Node(row,col-1,minutes+1);
                q.add(newNode);
                grid[row][col-1]=2;
            }
            if(row+1<grid.length && grid[row+1][col]==1) {
                Node newNode = new Node(row+1,col,minutes+1);
                q.add(newNode);
                grid[row+1][col]=2;
            }
            result=minutes;
        }
        boolean isAllRotten = true;
        for(int i=0;i<grid.length;i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if(grid[i][j]==1) {
                    return -1;
                }
            }
        }
        return (isAllRotten?result:0);
    }

    class Node {
        int i;
        int j;
        int minutes;
        Node(int i, int j, int mins) {
            this.i=i;
            this.j=j;
            this.minutes=mins;
        }
    }


    public static void main(String[] args){
     //int[][] nums = {{2,1,1},{1,1,0},{0,1,1}}; //o/p : 4
    // int[][] nums = {{2,1,1},{0,1,1},{1,0,1}}; //o/p: -1
     //int[][] nums={{0,2}};//0/p : 0
     //int[][] nums={{0,1}};
    // int[][] nums={{0,0,0,0}};
      int[][] nums={{1,2}};
     RottingOranges ro = new RottingOranges();
     System.out.println("Number of minutes to get oranges rotten: "+ro.rottingOranges(nums));

    }
}
