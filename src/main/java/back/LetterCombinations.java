package back;

import java.lang.reflect.Array;
import java.util.*;

/**
 * @program: leetcode
 * @description: 17
 * @author: Skyler
 * @create: 2024-03-15 14:46
 **/

public class LetterCombinations {
    static Map<Integer, String> map = new HashMap<>();
    public static List<String> letterCombinations(String digits) {
        if (digits.equals("")) return new ArrayList<>();
        map.put(2, "abc");
        map.put(3, "def");
        map.put(4, "ghi");
        map.put(5, "jkl");
        map.put(6, "mno");
        map.put(7, "pqrs");
        map.put(8, "tuv");
        map.put(9, "wxyz");
        char[] chars = digits.toCharArray();
        List<String> stringList = new ArrayList<>();
        backTrack(0, chars, stringList, new ArrayList<Character>());
        System.out.println(stringList);
        return stringList;
    }

    public static void backTrack(int now, char[] chars, List<String> res, ArrayList<Character> c) {
        if (now == chars.length){
            StringBuilder stringBuffer = new StringBuilder();
            for (char c1:
                 c) {
                stringBuffer.append(c1);
            }
            res.add(stringBuffer.toString());
        }
        else {
            char[] nowString = map.get(chars[now] - '0').toCharArray();
            for (char value : nowString) {
                c.add(value);
                backTrack(now + 1, chars, res, c);
                c.remove(c.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        letterCombinations("23");
    }
}
