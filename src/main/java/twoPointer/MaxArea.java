package twoPointer;

/**
 * @program: leetcode
 * @description: 11
 * @author: Skyler
 * @create: 2024-03-15 15:54
 **/

class MaxArea {
    public int maxArea(int[] height) {
        int i = 0, j = height.length - 1, res = 0;
        while(i < j) {
            res = height[i] < height[j] ?
                    Math.max(res, (j - i) * height[i++]):
                    Math.max(res, (j - i) * height[j--]);
        }
        return res;
    }
}
