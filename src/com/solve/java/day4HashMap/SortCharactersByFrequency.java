package com.solve.java.day4HashMap;

import java.util.HashMap;

public class SortCharactersByFrequency {

    public String frequencySort(String s) {
      if(s==""||s.length()==0) return "";
      HashMap hMap = new HashMap();
      for(int i=0;i<s.length();i++) {
          char c = s.charAt(i);
          if(hMap.containsKey(c)) {
              hMap.put(c, (Integer) hMap.getOrDefault(c, 0) + 1);
          }
      }

      //hMap.values().stream().sorted()
      return "";
    }
    public static void main(String[] args) {
      SortCharactersByFrequency sCharByFreq = new SortCharactersByFrequency();
      String s="tree";
    }
}
