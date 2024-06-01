package sonArray;

import entity.ListNode;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @program: leetcode
 * @description: 438
 * @author: Skyler
 * @create: 2024-03-21 22:02
 **/

public class FindAnagrams {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> integers = new ArrayList<>();
        if (s.length() < p.length()) return integers;
        int[] sArray = new int[26];
        int[] pArray = new int[26];
        for (int i = 0; i < p.length(); i++) {
            ++sArray[s.charAt(i) - 'a'];
            ++pArray[p.charAt(i) - 'a'];
        }
        if (Arrays.equals(sArray, pArray)) integers.add(0);
        for (int i = 1; i <= s.length() - p.length(); i++) {
            --sArray[s.charAt(i - 1) - 'a'];
            ++sArray[s.charAt(i + p.length() - 1) - 'a'];
            if (Arrays.equals(sArray, pArray)) integers.add(i);
        }
        return integers;
    }
}
