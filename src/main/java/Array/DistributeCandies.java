package Array;

import java.util.Arrays;

/**
 * @program: leetcode
 * @description: 1103
 * @author: Skyler
 * @create: 2024-06-03 17:56
 **/

public class DistributeCandies {
    public static int[] distributeCandies(int candies, int num_people) {
        int[] result = new int[num_people];
        int now_people = 0;
        for (int i = 1; ; i++) {
            if (now_people == num_people) now_people = 0;
            if (candies >= i){
                result[now_people] += i;
                candies -= i;
            }else if (candies == 0) break;
            else {
                result[now_people] += candies;
                candies = 0;
            }
            now_people++;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(distributeCandies(7, 4)));
    }
}
