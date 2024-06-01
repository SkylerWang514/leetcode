package mul_dim_dynamic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @program: leetcode
 * @description: 118
 * @author: Skyler
 * @create: 2024-03-12 17:00
 **/

public class Generate {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> yanghui = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            if (i == 0) yanghui.add(Arrays.stream(new int[]{1}).boxed().collect(Collectors.toList()));
            else if (i == 1) yanghui.add(Arrays.stream(new int[]{1, 1}).boxed().collect(Collectors.toList()));
            else {
                System.out.println("第" + i + "行");
                List<Integer> integers = new ArrayList<>();
                for (int j = 0; j <= i; j++) {
                    System.out.println("第" + j + "个");
                    if (j == 0 || j == i) integers.add(1);
                    else {
                        integers.add(yanghui.get(i - 1).get(j - 1) + yanghui.get(i - 1).get(j));
                    }
                }
                yanghui.add(integers);
            }
        }
        return yanghui;
    }
}
