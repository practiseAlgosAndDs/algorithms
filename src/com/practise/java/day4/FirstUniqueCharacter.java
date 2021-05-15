package com.practise.java.day4;

// https://leetcode.com/problems/first-unique-character-in-a-string/
import java.util.HashMap;

public class FirstUniqueCharacter {

    public int firstUniqChar(String s) {
        if (s == null || s.length() == 0) return -1;
        HashMap map = new HashMap();
        for(int index=0;index<s.length();index++)
        {
            char c = s.charAt(index);
            map.put(c, (Integer) map.getOrDefault(c, 0) + 1);
        }

        for(int index=0; index <s.length();index++)
        {
            if ((Integer) map.get(s.charAt(index)) == 1)
            {
                return index;
            }
        }
        return -1;
    }
}
