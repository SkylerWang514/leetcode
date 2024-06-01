package sonArray;

/**
 * @program: leetcode
 * @description: 76
 * @author: Skyler
 * @create: 2024-03-27 15:09
 **/

public class MinWindow {
    public String minWindow(String s, String t) {
        if(s == null || t == null || s.length() < t.length() ) {
            return "";
        }
        int[] tRecord = new int[256];
        int[] sRecord = new int[256];
        int flag = 0, sign = 0;
        for (int i = 0; i < t.length(); i++) {
            if (tRecord[t.charAt(i)] == 0)  sign++;
            tRecord[t.charAt(i)]++;
        }
        int i = 0, j = 0;
        int start = 0, minLength = Integer.MAX_VALUE;
        char now;
        while (j < s.length()){
            now = s.charAt(j);
            if (tRecord[now] > 0){
                sRecord[now]++;
                if (sRecord[now] == tRecord[now])
                    flag++;
            }
            j++;

            while (flag == sign){
                if (j - i < minLength){
                    minLength = j - i;
                    start = i;
                }
                char left = s.charAt(i);
                if (tRecord[left] > 0){
                    if (sRecord[left] == tRecord[left])
                        flag--;
                    sRecord[left]--;
                }
                i++;
            }
        }
        return minLength == Integer.MAX_VALUE ? "" : s.substring(start, start + minLength);
    }
}
