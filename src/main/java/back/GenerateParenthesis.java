package back;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: leetcode
 * @description: 22
 * @author: Skyler
 * @create: 2024-03-17 15:30
 **/

public class GenerateParenthesis {
    public List<String> generateParenthesis(int n) {
        List<String> stringList = new ArrayList<>();
        getList(stringList, new StringBuffer(), 0, 0, n);
        return stringList;
    }
    public void getList(List<String> strings, StringBuffer sb, int left, int right, int all){
        if (left + right == all * 2) strings.add(sb.toString());
        else {
            if (right == left){
                sb.append("(");
                getList(strings, sb, left + 1, right, all);
                sb.deleteCharAt(sb.length() - 1);
            }else if (right == all || left == all){
                int leftORRight = 0;
                if (right == all){
                    leftORRight = 1;
                    sb.append("(");
                }
                else sb.append(")");
                getList(strings, sb, leftORRight == 1 ? left + 1 : left, leftORRight == 0 ? right + 1 : right, all);
                sb.deleteCharAt(sb.length() - 1);
            }else {
                for (int i = 0; i <= 1; i++) {
                    sb.append(i == 0 ? "(" : ")");
                    getList(strings, sb, i == 0 ? left + 1 : left, i == 1? right + 1: right, all);
                    sb.deleteCharAt(sb.length() - 1);
                }
            }
        }
    }
}
