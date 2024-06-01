package Array;

import java.util.*;

/**
 * @program: leetcode
 * @description: 1636
 * @author: Skyler
 * @create: 2024-03-06 16:05
 **/

public class SortArray {
    public static void sortArray(int[] array){
        Map<Integer, Integer> map = new HashMap<>();
        for (int a:
                array) {
            if (map.containsKey(a)) map.computeIfPresent(a, (k, v) -> v = v + 1);
            else map.put(a, 1);
        }
        List<Map.Entry<Integer, Integer>> mapList = new ArrayList<>(map.entrySet());
        mapList.sort((o1, o2) -> {
            if (!o1.getValue().equals(o2.getValue())) return o2.getValue() - o1.getValue();
            else return o2.getKey() - o1.getKey();
        });
        for (Map.Entry<Integer, Integer> set:
             mapList) {
            for (int i = 0; i < set.getValue(); i++) {
                System.out.print(set.getKey());
            }
        }
    }

    public static void sortArray1(int[] array){
        Map<Integer, Integer> map = new HashMap<>();
        for (int a:
                array) {
            if (map.containsKey(a)) map.computeIfPresent(a, (k, v) -> v = v + 1);
            else map.put(a, 1);
        }
        System.out.println(map.entrySet());
        System.out.println(Arrays.toString(Arrays.stream(array).boxed().sorted((o1, o2) -> 0).toArray()));

        System.out.println(Arrays.toString(Arrays.stream(array).boxed().sorted((o1, o2) -> {
            int num1 = map.get(o1);
            int num2 = map.get(o2);
            if (num1 != num2) return num2 - num1;
            else return o2 - o1;
        }).toArray()));
    }

    public static void sortArray2(int[] ints){
        Map<Integer, Integer> hashMap = new TreeMap<>();
        for (int a:
             ints) {
            if (hashMap.containsKey(a)) hashMap.computeIfPresent(a, (k, v) -> v = v + 1);
            else hashMap.put(a, 1);
        }
        System.out.println(Arrays.toString(Arrays.stream(ints).boxed().sorted((o1, o2) -> {
            int o1n = hashMap.get(o1);
            int o2n = hashMap.get(o2);
            if (o2n == o1n) return o2 - o1;
            return o2n - o1n;
        }).toArray()));

    }

    public static void main(String[] args) {
        sortArray2(new int[]{1,1,1,2,2,3,3,4});
    }
}
