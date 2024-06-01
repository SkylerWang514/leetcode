package mul_dim_dynamic;

/**
 * @program: leetcode
 * @description: 70
 * @author: Skyler
 * @create: 2024-03-12 16:32
 **/

public class ClimbStairs {
    public static int climbStairs(int n) {
        if (n == 1) return 1;
        int[] array = new int[n];
        array[0] = 1;
        array[1] = 2;
        for (int i = 2; i < n; i++) {
            array[i] = Math.max(array[i - 2], array[i - 1]) + 1;
        }
        System.out.println(array[n - 1]);
        return array[n - 1];
    }

    public static void main(String[] args) {
        climbStairs(2);
    }
}
