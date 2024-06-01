package Hash;

import java.util.*;

/**
 * @program: leetcode
 * @description: 49
 * @author: Skyler
 * @create: 2024-03-15 13:06
 **/

public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> stringListMap = new HashMap<>();
        char[] sArray;
        for (String s:
             strs) {
            sArray = s.toCharArray();
            Arrays.sort(sArray);
            String a = Arrays.toString(sArray);
            if (stringListMap.containsKey(a)) stringListMap.get(a).add(s);
            else {
                List<String> stringList = new ArrayList<>();
                stringList.add(s);
                stringListMap.put(a, stringList);
            }
        }
        return new ArrayList<List<String>>(stringListMap.values());
    }
}
