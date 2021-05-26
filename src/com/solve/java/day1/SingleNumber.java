package com.solve.java.day1;

public class SingleNumber {

    public int singleNumber(int[] nums) {
        int res=0;
        for (int n: nums)
        {
            res ^=n;
        }
        return res;
    }

    public static void main(String[] args)
    {
        SingleNumber sn = new SingleNumber();
        int[] nums={4,1,2,1,2};
        System.out.println(sn.singleNumber(nums));
    }
}
