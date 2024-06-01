package String;

/**
 * @program: leetcode
 * @description: 67
 * @author: Skyler
 * @create: 2024-03-11 14:05
 **/

public class AddBinary {
    public String addBinary(String a, String b) {
        int al = a.length() - 1;
        int bl = b.length() - 1;
        StringBuilder stringBuffer = new StringBuilder();
        int mark = 0, aNow, bNow;
        while (al >= 0 || bl >= 0 || mark > 0){
            aNow = al >= 0 ? a.charAt(al) - '0' : 0;
            bNow = bl >= 0 ? b.charAt(bl) - '0' : 0;
            stringBuffer.append((aNow + bNow + mark) % 2);
            mark = (aNow + bNow + mark) / 2;
            al--;
            bl--;
        }
        return stringBuffer.reverse().toString();
    }
}
