package com.solve.java.day1;

import java.util.ArrayList;

public class Subsets {

    public void geberateSubsets(int n){

    }

    public static void main(String[] args) {

        int n=3;
        ArrayList result= new ArrayList();
         int count=0;
        for (int i=1;i<(1<<n);i++){
            ArrayList subsets= new ArrayList();
            for(int j=1;j<n;j++){
                int b=(i&(1<<(j-1))) ;
                count++;
            }
        }
    }
}
