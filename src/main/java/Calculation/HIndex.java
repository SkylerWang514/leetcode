package Calculation;

import javax.crypto.spec.PSource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;

/**
 * @program: leetcode
 * @description: 274
 * @author: Skyler
 * @create: 2024-02-25 12:09
 **/

public class HIndex {
    public static int hIndex(int[] citations) {
        ArrayList<Integer> integers = Arrays.stream(citations).boxed().collect(Collectors.toCollection(ArrayList::new));
        Collections.sort(integers);
        if (citations.length == 1 && citations[0] == 0) return 0;
        int hIndex = 1;
        System.out.println("integers:" + Arrays.toString(integers.toArray()));
        for (int i = 0; i < integers.size(); i++) {
            if (integers.get(i) >= integers.size() - i)
                hIndex = Math.max(hIndex, integers.size() - i);
            if (integers.get(i) <= integers.size() - i)
                hIndex = Math.max(hIndex, integers.get(i));
        }
        return hIndex;
    }

    public static void main(String[] args) {
        System.out.println(hIndex(new int[]{1,3,1}));
    }
}
