package Array;

import io.swagger.models.auth.In;

import java.util.*;

/**
 * @program: leetcode
 * @description: 3072
 * @author: Skyler
 * @create: 2024-06-03 17:56
 **/

// 树状数组，存的是 整个数组里小于等于第i个数 的个数
class BinaryIndexedTree {
    private int[] tree;

    //初始化树状数组
    public BinaryIndexedTree(int n) {
        tree = new int[n + 1];
    }

    //加一个第i大的数（循环更新相关数据）
    public void add(int i) {
        while (i < tree.length) {
            tree[i]++;
            i += i & -i;
        }
    }

    //获取小于等于第i个数的个数
    public int get(int i) {
        int sum = 0;
        while (i > 0) {
            sum += tree[i];
            i -= i & -i;
        }
        return sum;
    }
}

public class ResultArray {
    public int[] resultArray(int[] nums) {
        int n = nums.length;

        //新建一个排序好的数组
        int[] sortedNums = Arrays.copyOf(nums, n);
        Arrays.sort(sortedNums);

//        存储各个数字对应的排序
        Map<Integer, Integer> index = new HashMap<>();
        for (int i = 0; i < n; i++) {
            index.put(sortedNums[i], i + 1);
        }

//        新建要存放的两个数组并放入前两个数
        List<Integer> arr1 = new ArrayList<>();
        List<Integer> arr2 = new ArrayList<>();
        arr1.add(nums[0]);
        arr1.add(nums[1]);

//        建立两个数组对应的树状数组并放入前两个数
        BinaryIndexedTree tree1 = new BinaryIndexedTree(n);
        BinaryIndexedTree tree2 = new BinaryIndexedTree(n);
        tree1.add(index.get(nums[0]));
        tree2.add(index.get(nums[1]));

        for (int i = 2; i < n; i++) {
            int count1 = arr1.size() - tree1.get(index.get(nums[i]));
            int count2 = arr2.size() - tree2.get(index.get(nums[i]));
            if (count1 > count2 || (count1 == count2 && arr1.size() <= arr2.size())) {
                arr1.add(nums[i]);
                tree1.add(index.get(nums[i]));
            } else {
                arr2.add(nums[i]);
                tree2.add(index.get(nums[i]));
            }
        }

//        将两个数组合并到结果数组中
        int i = 0;
        for (int a: arr1) {
            nums[i++] = a;
        }
        for (int a: arr2) {
            nums[i++] = a;
        }
        return nums;
    }
}
