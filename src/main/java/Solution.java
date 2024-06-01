import entity.ListNode;
import entity.UserDto;
import io.swagger.models.auth.In;
import lombok.val;
import org.hibernate.validator.constraints.Length;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.constraints.NotNull;
import java.awt.*;
import java.lang.reflect.Array;
import java.util.*;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @program: leetcode
 * @description:
 * @author: Skyler
 * @create: 2023-03-31 19:18
 **/

public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * <p>
     * 分解质因数
     *
     * @param n int整型 待分解的正整数
     * @return int整型ArrayList<ArrayList <>>
     */
    public ArrayList<ArrayList<Integer>> factorization(int n) {
        // write code here
        ArrayList<ArrayList<Integer>> arrayLists = new ArrayList<>();

        List<Integer> integers1 = new ArrayList<>();
        integers1 = getAll(n);
        for (Integer i :
                integers1) {
            int flag = 1;
            for (ArrayList<Integer> arrayList : arrayLists) {
                if (arrayList.get(0).equals(i)) {
                    int i1 = arrayList.get(1);
                    i1++;
                    arrayList.remove(1);
                    arrayList.add(i1);
                    flag = 0;
                }
            }

            if (flag == 1) {
                ArrayList<Integer> integers = new ArrayList<>();
                integers.add(i);
                integers.add(1);
                arrayLists.add(integers);
            }
        }
        return arrayLists;

    }

    public List<Integer> getAll(int n) {
        int num = 2;
        List<Integer> integers = new ArrayList<>();
        if (n == 1) return integers;
        while (true) {
            if (n % num == 0) {
                integers.add(num);
                n = n / num;
                integers.addAll(getAll(n));
                break;
            }
            num = nextPRime(num);
        }
        return integers;
    }

    public int nextPRime(int n) {
        n = n + 1;
        while (true) {
            if (isPRime(n)) return n;
            else n = n + 1;
        }
    }

    public boolean isPRime(int n) {
        boolean a = true;
        if (n < 2) a = false;
        else if (n == 2) a = false;
        else {
            for (int i = 2; i < Math.sqrt(n); i++) {
                if (n % i == 0) {
                    a = false;
                    break;
                }
            }
        }
        return a;
    }


    // leetcode3 最大长度子串
    public int lengthOfLongestSubstring(String s) {
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int end = 0, start = 0; end < n; end++) {
            char alpha = s.charAt(end);
            if (map.containsKey(alpha)) {
                start = Math.max(map.get(alpha), start);
            }
            ans = Math.max(ans, end - start + 1);
            map.put(s.charAt(end), end + 1);
        }
        return ans;
    }

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param points Point类ArrayList
     * @return int整型
     */
    public int triangles(ArrayList<Point> points) {
        return 1;
    }


    public int findKthLargest(int[] nums, int k) {
        ArrayList<Integer> num = (ArrayList<Integer>) Arrays.stream(nums).boxed().collect(Collectors.toList());
        num = sortIntegers(num);
        return num.get(k - 1);
    }

    public ArrayList<Integer> sortIntegers(ArrayList<Integer> num) {
        if (num.size() <= 1) return num;
        int k = num.get(0);
        ArrayList<Integer> integersLeft = new ArrayList<>();
        ArrayList<Integer> integersRight = new ArrayList<>();
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 1; i < num.size(); i++) {
            if (num.get(i) > k) integersLeft.add(num.get(i));
            else integersRight.add(num.get(i));
        }
        integersLeft = sortIntegers(integersLeft);
        integersRight = sortIntegers(integersRight);
        result.addAll(integersLeft);
        result.add(k);
        result.addAll(integersRight);
        return result;
    }

    // 输入一个数组，每次选两个相邻元素，把它们合并，求合并一次后最小的极差
    public int getMin() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] ints = new int[n];
        for (int i = 0; i < n; i++) {
            int a = sc.nextInt();
            ints[i] = a;
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n - 1; i++) {
            int[] ints1 = new int[n];
            int[] ints2 = new int[n - 1];
            System.arraycopy(ints, 0, ints1, 0, n);
//            System.out.println(Arrays.toString(ints1));
            int i1 = ints1[i];
            int i2 = ints1[i + 1];
            int all = i1 + i2;
            ints1[i] = all;
            for (int j = i + 1; j < n - 1; j++) {
                ints1[j] = ints1[j + 1];
            }
            System.arraycopy(ints1, 0, ints2, 0, n - 1);
//            System.out.println(Arrays.toString(ints2));
            ArrayList<Integer> integers = new ArrayList<>();
            for (int s :
                    ints2) {
                integers.add(s);
            }
            Collections.sort(integers);
//            System.out.println(integers);
            min = Math.min(min, Math.abs(integers.get(integers.size() - 1) - integers.get(0)));
//            System.out.println(min);
        }
        System.out.println(min);
        return min;
    }

    //1647. 字符频次唯一的最小删除次数
    //如果字符串 s 中 不存在 两个不同字符 频次 相同的情况，就称 s 是 优质字符串 。
    //
    //给你一个字符串 s，返回使 s 成为 优质字符串 需要删除的 最小 字符数。
    //
    //字符串中字符的 频次 是该字符在字符串中的出现次数。例如，在字符串 "aab" 中，'a' 的频次是 2，而 'b' 的频次是 1 。
    //自己写的 烂 跑不出来
    public int minDeletions(String s) {
        List<Character> characters = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            characters.add(s.charAt(i));
        }
        Map<Character, Integer> map = new HashMap<>();
        for (Character c :
                characters) {
            if (map.containsKey(c)) {
                map.replace(c, map.get(c) + 1);
            } else map.put(c, 1);
        }
        System.out.println(map);

        Map<Integer, Integer> integerIntegerMap = new HashMap<>();
        for (Map.Entry<Character, Integer> characterIntegerEntry : map.entrySet()) {
            if (integerIntegerMap.containsKey(characterIntegerEntry.getValue())) {
                integerIntegerMap.replace(characterIntegerEntry.getValue(), integerIntegerMap.get(characterIntegerEntry.getValue()) + 1);
            } else integerIntegerMap.put(characterIntegerEntry.getValue(), 1);
        }

        Map<Integer, Integer> integerIntegerMapAfterSort = new LinkedHashMap<>();
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.size());
        list.addAll(integerIntegerMap.entrySet());
        // 对value进行排序
        list.sort((o1, o2) -> {
            return o2.getKey() - o1.getKey();        // 升序
        });
        System.out.println(list);
        int max = list.get(0).getKey();
        //修正当前list
        for (int i = max - 1; i > 0; i--) {
            int flag = 0;
            for (Map.Entry<Integer, Integer> integerIntegerEntry:
                 list) {
                if (integerIntegerEntry.getKey() == i) {
                    flag = 1;
                    break;
                }
            }
            if (flag == 0) {
                Map<Integer, Integer> integerIntegerMap1 = new HashMap<>();
                integerIntegerMap.put(i,0);
                list.add((Map.Entry<Integer, Integer>) integerIntegerMap1.entrySet());
            }
        }
        list.sort((o1, o2) -> {
            return o2.getKey() - o1.getKey();        // 升序
        });
        System.out.println(list);
        for (Map.Entry<Integer, Integer> entry : list) {
            integerIntegerMapAfterSort.put(entry.getKey(), entry.getValue());
        }
        System.out.println(integerIntegerMapAfterSort);

        int all = 0;
        for (Map.Entry<Integer, Integer> characterIntegerEntry : integerIntegerMapAfterSort.entrySet()) {
            if (characterIntegerEntry.getValue() > 1) {
                System.out.println("本次处理的key：" + characterIntegerEntry.getKey());
                if (characterIntegerEntry.getKey() == 1){
                    all += characterIntegerEntry.getValue() - 1;
                }else {
//                    all += (characterIntegerEntry.getKey() - 1) * (characterIntegerEntry.getValue() - 1);
                    all += (characterIntegerEntry.getValue() - 1);
                    if (integerIntegerMapAfterSort.containsKey(characterIntegerEntry.getKey() - 1)){
                        integerIntegerMapAfterSort.replace(characterIntegerEntry.getKey() - 1, integerIntegerMapAfterSort.get(characterIntegerEntry.getKey() - 1) + characterIntegerEntry.getValue() - 1);
                        System.out.println("修改的键值对为：key - " + (characterIntegerEntry.getKey() - 1) + "value - " + (integerIntegerMapAfterSort.get(characterIntegerEntry.getKey() - 1) + characterIntegerEntry.getValue() - 1));
                    }
                    else {
                    if (characterIntegerEntry.getKey() > 1)
                        integerIntegerMapAfterSort.put(characterIntegerEntry.getKey() - 1, characterIntegerEntry.getValue() - 1);
                    }
                    integerIntegerMapAfterSort.replace(characterIntegerEntry.getKey(), 1);
                }
            }
            System.out.println("每次遍历完：" + integerIntegerMapAfterSort);
            System.out.println("遍历完的all: " + all);
        }
        System.out.println(all);
        return all;
    }

    //别人写的
    public int minDeletions1(String s) {
        char[] cs = s.toCharArray();
        int[] dics = new int[26];
        for (int i = 0; i < cs.length; i++) {
            dics[cs[i] - 'a']++;
        }
        System.out.println(Arrays.toString(dics));
        int ans = 0;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < dics.length; i++) {
            int cur = dics[i];
            while (cur != 0 && !set.add(cur)) {
                cur--;
                ans++;
            }
        }
        System.out.println(ans);
        return ans;
    }

    public int solution(int[] A) {
        ArrayList<Integer> integers = new ArrayList<>();
        for (int a:
             A) {
            integers.add(a);
        }
        Collections.sort(integers);
        int result = 1;
        for (int i = 1; i < Integer.MAX_VALUE; i++) {
            if (!integers.contains(i)) {
                result = i;
                break;
            }
        }
        return result;
    }

    @PostMapping
    public ResponseEntity<UserDto> create(@RequestBody @NotNull UserDto user) {
        if (user.getName() == null || user.getAge() == null){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .build();
        }
        String name = user.getName();
        Integer age = user.getAge();
        if (name.equals("") || age.toString().equals("") ){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .build();
        }
        if (name.length() > 32 || age < 16){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .build();
        }
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(user);
    }


    public int solution(int n) {
            int[] dp = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                if (i != n) dp[i] = i;
                for (int j = 1; j <= i / 2; j++) {
                    dp[i] = Math.max(dp[i], dp[j] * dp[i - j]);
                }
            }
            return dp[n];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solution(7);
    }
}
