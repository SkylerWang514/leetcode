package mul_dim_dynamic;

import java.util.LinkedList;

/**
 * @program: leetcode
 * @description: 5
 * @author: Skyler
 * @create: 2024-03-05 12:42
 **/

public class LongestPalindrome {

    public String longestPalindrome(String s) {
        int begin, length = 0;
        int l = 0, r = 0;
        if (s.length() < 3) return s;
        boolean[][] dp = new boolean[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            dp[i][i] = true;
        }
        int j;
        char[] sArray = new char[s.length()];
        sArray = s.toCharArray();
        for (int L = 2; L < s.length(); L++) {
            for (int i = 0; i < s.length(); i++) {
                j = i + L - 1;
                if (j > s.length() - 1) break;
                if (sArray[i] != sArray[j]) dp[i][j] = false;
                else {
                    if (j - i < 3) dp[i][j] = true;
                    else dp[i][j] = dp[i + 1][j - 1];
                }
                if (dp[i][j] && L > length){
                    length = L;
                    l = i;
                    r = j;
                }
            }
        }
        return s.substring(l, r);
    }

}

