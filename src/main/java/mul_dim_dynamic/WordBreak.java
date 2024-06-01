package mul_dim_dynamic;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @program: leetcode
 * @description: 139
 * @author: Skyler
 * @create: 2024-03-12 17:53
 **/

public class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> strings = new HashSet<>(wordDict);
        boolean[] sb = new boolean[s.length() + 1];
        sb[0] = true;
        for (int i = 1; i < s.length() + 1; i++) {
            for (int j = 0; j < i; j++) {
                String sNew = s.substring(j, i);
                System.out.println(sNew );
                sb[i] = strings.contains(sNew) && sb[i - j - 1];
                System.out.println("i:" + i);
                System.out.println("j:" + j);
                System.out.println("sb[i]:" + sb[i]);
                if (sb[i]) break;
            }
        }
        return sb[s.length()];
    }

    public static void main(String[] args) {
        System.out.println("abc".substring(0,1));
    }
}
