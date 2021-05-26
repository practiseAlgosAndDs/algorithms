package com.solve.java.day3;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class LRUCache {
    HashMap<Integer,Integer> hMap;
    Queue<Integer> mruQueue = new LinkedList<>();
    int maxCapacity = 0;
    public LRUCache(int capacity) {
        hMap = new HashMap<>(capacity);
        maxCapacity = capacity;
    }

    public int get(int key) {
        //mruQueue.add(key);
        return hMap.getOrDefault(key,-1);
    }

    public void put(int key, int value) {
        if(!mruQueue.isEmpty()) {
            Iterator<Map.Entry<Integer, Integer>> iterator = hMap.entrySet().iterator();
            while(iterator.hasNext()) {
             Entry entry=   iterator.next();
             if(entry.getValue()!=mruQueue.peek()) {
                 hMap.remove(entry.getKey());
                 break;
             }
            }
        }
        if(hMap.size()==maxCapacity) {
          //remove least recently Used

        }
        hMap.put(key,value);
        //mruQueue.add(value);
    }
    public static void main(String[] args){
        LRUCache lRuCache = new LRUCache(2);
        lRuCache.put(1,1);
        lRuCache.mruQueue.add(1);
        lRuCache.put(2,2);
        lRuCache.mruQueue.add(2);
        System.out.println("Get 1 :"+lRuCache.get(1));
        lRuCache.put(3,3);
        lRuCache.mruQueue.add(3);
        System.out.println("Get 2 :"+lRuCache.get(2));
        lRuCache.put(4,4);
        lRuCache.mruQueue.add(4);
        System.out.println("Get 1 :"+lRuCache.get(1));

    }
}
