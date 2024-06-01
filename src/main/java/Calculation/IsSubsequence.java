package Calculation;

import com.google.common.graph.ImmutableNetwork;

/**
 * @program: leetcode
 * @description: 392
 * @author: Skyler
 * @create: 2024-02-10 18:02
 **/

public class IsSubsequence {
    public static boolean isSubsequence(String s, String t) {
        if (s.length() > t.length()) return false;
        char[] sChar = s.toCharArray();// 子序列
        char[] tChar = t.toCharArray();// 父序列
        int i;
        StringBuilder stringBuilder = new StringBuilder();
        int j = 0;
        for (i = 0; i < sChar.length; i++) {
            while (sChar[i] != tChar[j]){
                System.out.println(j);
                if (j >= tChar.length - 1) break;
                j++;
            }
            if (j > tChar.length - 1) break;
            else if (sChar[i] == tChar[j]){
                System.out.println("append:" + sChar[i]);
                stringBuilder.append(sChar[i]);
            }
            j++;
        }
        System.out.println(i);
        System.out.println(stringBuilder.toString());
        return s.equals(stringBuilder.toString());
    }

    public static void main(String[] args) {
        System.out.println(isSubsequence("acb", "ahbgdc"));
    }
}
