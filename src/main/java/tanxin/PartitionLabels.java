package tanxin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: leetcode
 * @description: 763
 * @author: Skyler
 * @create: 2024-03-18 19:55
 **/

public class PartitionLabels {
    public List<Integer> partitionLabels(String s) {
        List<Integer> resultMap = new ArrayList<>();
        Map<Character, int[]> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                int[] newInt = map.get(s.charAt(i));
                newInt[1] = i;
                map.computeIfPresent(s.charAt(i), (key, value) -> value = newInt);
            }else map.put(s.charAt(i), new int[]{i, i});
        }
        for (Map.Entry<Character, int[]> mapset:
             map.entrySet()) {
            System.out.print(mapset.getKey());
            System.out.print(mapset.getValue()[0]);
            System.out.println(mapset.getValue()[1]);
        }
        List<int[]> resultInts = new ArrayList<>();
        List<int[]> ints = new ArrayList<>(map.values());
        resultInts.add(ints.get(0));
        for (int i = 1; i < ints.size(); i++) {
            if (ints.get(i)[0] < resultInts.get(resultInts.size() - 1)[1]) resultInts.get(resultInts.size() - 1)[1] = ints.get(i)[1];
            else resultInts.add(ints.get(i));
        }
        for (int[] i:
             resultInts) {
            resultMap.add(i[1] - i[0] + 1);
        }
        return resultMap;
    }
}
