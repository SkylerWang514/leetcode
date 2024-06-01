package Calculation;

import org.apache.ibatis.annotations.Mapper;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @program: leetcode
 * @description: 205
 * @author: Skyler
 * @create: 2024-02-06 11:27
 **/

public class Isomorphic {
    public static boolean isIsomorphic(String s, String t) {
        Map<Character, Character> s2t = new HashMap<>();
        Map<Character, Character> t2s = new HashMap<>();
        char[] sArray = s.toCharArray();
        char[] tArray = t.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            char cs = sArray[i];
            char ct = tArray[i];
            if (s2t.containsKey(cs) && s2t.get(cs) != ct || t2s.containsKey(ct) && t2s.get(ct) != cs) return false;
            s2t.put(cs, ct);
            t2s.put(ct, cs);
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isIsomorphic("bbbaaaba","aaabbbba"));
    }
}
