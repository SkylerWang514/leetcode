package Calculation;

/**
 * @program: leetcode
 * @description: leetcode55
 * @author: Skyler
 * @create: 2024-02-01 14:46
 **/

public class JumpGame {
    public int jump(int[] nums) {
        int end = 0;
        int maxPosition = 0;
        int steps = 0;
        for(int i = 0; i < nums.length - 1; i++){
            //找能跳的最远的
            maxPosition = Math.max(maxPosition, nums[i] + i);
            if( i == end){ //遇到边界，就更新边界，并且步数加一
                end = maxPosition;
                steps++;
            }
        }
        return steps;
    }

    public static boolean canJump(int[] nums) {
        if (nums.length == 1) return true;
        int coverRange = nums[0];
        for (int i = 0; i <= coverRange; i++) {
            coverRange = Math.max(coverRange, i + nums[i]);
            if (coverRange >= nums.length - 1) return true;
        }
        return false;
    }

    public static int canJump1(int[] nums) {
        if (nums.length == 1) return 0;
        int location = nums.length - 1;
        return reach(nums, location, 1);
    }

    public static int reach(int[] nums, int location, int jumpTime) {
        for (int i = 0; i < location; i++) {
//            System.out.println(i);
            if (nums[i] + i >= location) {
//                System.out.println("第" + i + "个元素+" + nums[i] + ">=" + location);
                if (i == 0) return jumpTime;
                else{
                    jumpTime += 1;
                    return reach(nums, i, jumpTime);
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(canJump(new int[]{2,3,1,1,4}));
    }
}
