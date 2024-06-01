package Hash;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: leetcode
 * @description: 242
 * @author: Skyler
 * @create: 2024-02-29 16:55
 **/

public class IsAnagram {
    public boolean isAnagram1(String s, String t) {
        Map<Character, Integer> sMap = new HashMap<>();
        Map<Character, Integer> tMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (sMap.containsKey(s.charAt(i))){
                sMap.computeIfPresent(s.charAt(i), (key, value) -> value += 1);
            }else sMap.put(s.charAt(i), 1);
        }
        for (int i = 0; i < t.length(); i++) {
            if (tMap.containsKey(t.charAt(i))){
                tMap.computeIfPresent(t.charAt(i), (key, value) -> value += 1);
            }else tMap.put(t.charAt(i), 1);
        }
        for (Map.Entry<Character, Integer> entry:
             sMap.entrySet()) {
            if (!(tMap.containsKey(entry.getKey()) && tMap.get(entry.getKey()).equals(entry.getValue()))) return false;
        }
        for (Map.Entry<Character, Integer> entry:
                tMap.entrySet()) {
            if (!(sMap.containsKey(entry.getKey()) && sMap.get(entry.getKey()).equals(entry.getValue()))) return false;
        }
        return true;
    }

    public boolean isAnagram(String s, String t) {
        int[] sArray = new int[256];
        int[] tArray = new int[256];
        for (char c:
             s.toCharArray()) {
            sArray[(int)c]++;
        }
        for (char j:
             t.toCharArray()) {
            tArray[(int)j]++;
        }
        for (int i = 0; i < sArray.length; i++) {
            if (sArray[i] != tArray[i]) return false;
        }
        return true;
    }
}
