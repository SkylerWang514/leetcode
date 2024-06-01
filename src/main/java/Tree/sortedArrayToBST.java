package Tree;

import entity.TreeNode;

/**
 * @program: leetcode
 * @description: 108
 * @author: Skyler
 * @create: 2024-03-15 22:01
 **/

public class sortedArrayToBST {
    public TreeNode sortedArrayToBST(int[] nums) {
        return generate(nums, 0, nums.length - 1);
    }

    public TreeNode generate(int[] nums, int head, int tail){
        if (head > tail) return null;
        if (head == tail) return new TreeNode(nums[head]);
        int mid = (head + tail) / 2;
        TreeNode treeNode = new TreeNode(nums[mid]);
        treeNode.left = generate(nums, head, mid - 1);
        treeNode.right = generate(nums, mid + 1, tail);
        return treeNode;
    }
}
