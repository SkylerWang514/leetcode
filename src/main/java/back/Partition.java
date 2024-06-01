package back;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: leetcode
 * @description: 131
 * @author: Skyler
 * @create: 2024-03-28 12:41
 **/

public class Partition {
    public static List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        backTrack(s, result, 0, new ArrayList<>());
        return result;
    }
    public static void backTrack(String s, List<List<String>> result, int now, List<String> nowList) {
        if (now == s.length() + 1){
            result.add(new ArrayList<>(nowList));
            return;
        }
        for (int i = now; i <= s.length(); i++) {
            String nowS = s.substring(now, i);
            if (judgeIfReverse(nowS)){
                nowList.add(nowS);
                backTrack(s, result, i + 1, nowList);
                nowList.remove(nowList.size() - 1);
            }
        }
    }
    public static boolean judgeIfReverse(String s){
        if (s.length() == 0) return false;
        if (s.length() == 1) return true;
        StringBuilder stringBuilder = new StringBuilder();
        for (char c:
                s.toCharArray()) {
            stringBuilder.append(c);
        }
        return stringBuilder.reverse().toString().equals(s);
    }

    public static void main(String[] args) {
        System.out.println(partition("abcdef"));
    }
}
