package Hash;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @program: leetcode
 * @description: 290
 * @author: Skyler
 * @create: 2024-02-10 18:36
 **/

public class WordPattern {
    public static boolean wordPattern(String pattern, String s) {
        char[] patternCharArray = pattern.toCharArray();
        String[] stringArrayList = s.split(" ");
        if (patternCharArray.length != stringArrayList.length) return false;
        Map<Character, String> p2s = new HashMap<>();
        Map<String, Character> s2p = new HashMap<>();
        for (int i = 0; i < patternCharArray.length; i++) {
            if (!p2s.containsKey(patternCharArray[i]) && !s2p.containsKey(stringArrayList[i])){
                p2s.put(patternCharArray[i], stringArrayList[i]);
                s2p.put(stringArrayList[i], patternCharArray[i]);
            }else if (p2s.containsKey(patternCharArray[i]) && !p2s.get(patternCharArray[i]).equals(stringArrayList[i]) || s2p.containsKey(stringArrayList[i]) && s2p.get(stringArrayList[i]) != patternCharArray[i]){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(wordPattern("a", "a"));
    }
}
