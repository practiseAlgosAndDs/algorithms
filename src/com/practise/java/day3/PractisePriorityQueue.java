package com.practise.java.day3;

import java.util.Comparator;
import java.util.Queue;
import java.util.PriorityQueue;


public class PractisePriorityQueue {
    static class CustomIntegerComparator implements Comparator<Integer> {

        @Override
        public int compare(Integer o1, Integer o2) {
            return o1 < o2 ? 1 : -1;
        }
    }
    public static void main(String[] args){
        Queue<String> testQueue = new PriorityQueue<>();
        testQueue.add("abc");
        testQueue.add("123");
        testQueue.add("ghi");
        testQueue.add("456");

        while(!testQueue.isEmpty())
        {
            System.out.println(""+testQueue.poll()); // natural ordering of Strings is preserved here
        }

        Queue<Integer> testIntegersPQ = new PriorityQueue<>(new CustomIntegerComparator());

        testIntegersPQ.add(11);
        testIntegersPQ.add(5);
        testIntegersPQ.add(-1);
        testIntegersPQ.add(12);
        testIntegersPQ.add(6);

        while(!testIntegersPQ.isEmpty())
        {
            System.out.println(""+testIntegersPQ.poll()); // custom ordering
        }
    }
}
