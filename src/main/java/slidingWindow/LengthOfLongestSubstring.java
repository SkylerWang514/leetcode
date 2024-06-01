package slidingWindow;

/**
 * @program: leetcode
 * @description: 3
 * @author: Skyler
 * @create: 2024-02-28 15:37
 **/

public class LengthOfLongestSubstring {
    //重复一遍牛逼的
    public int lengthOfLongestSubstring(String s) {
        int ans = 0;
        int i = 0, j = 0;
        int[] n = new int[200];
        while (i < s.length() && j < s.length()){
            n[s.charAt(j)]++;
            if (n[s.charAt(j)] > 1){
                n[s.charAt(i)]--;
                i++;
            }
            ans = Math.max(ans, j - i + 1);
            j++;
        }
        return ans;
    }
    //我自己写的屎
    public int lengthOfLongestSubstring1(String s) {
        if(s.length() == 0) return 0;
        int begin = 0, end = 1;
        int length = 1;
        int result = -1;
        while (end < s.length()){
            result = ifHasSame(s, begin, end);
            if (result > 0){
                begin = result + 1;
            }else length = Math.max(length, end - begin + 1);
            end++;
        }
        return length;
    }

    // 这个比底下那个慢
    public int ifHasSame1(String s, int begin, int end){
        char[] chars = s.toCharArray();
        char now, other;
        for (int i = begin; i <= end; i++) {
            now = chars[i];
            for (int j = i + 1; j <= end; j++) {
                other = chars[j];
                if (now == other) return i;
            }
        }
        return -1;
    }
    public int ifHasSame(String s, int begin, int end){
        for (int i = begin; i <= end; i++) {
            for (int j = i + 1; j <= end; j++) {
                if (s.charAt(i) == s.charAt(j)) return i;
            }
        }
        return -1;
    }

}
