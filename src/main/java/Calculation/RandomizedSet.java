package Calculation;

import java.lang.reflect.Array;
import java.util.*;

/**
 * @program: leetcode
 * @description: 380
 * @author: Skyler
 * @create: 2024-02-25 13:54
 **/

class RandomizedSet {

    ArrayList<Integer> numsList;
    Map<Integer, Integer> hashMap;
    Random random;

    public RandomizedSet() {
        numsList = new ArrayList<>();
        hashMap = new HashMap<>();
        random = new Random();
    }

    public boolean insert(int val) {
        if (hashMap.containsKey(val)) return false;
        hashMap.put(val, numsList.size());
        numsList.add(val);
        return true;
    }

    public boolean remove(int val) {
        if (!hashMap.containsKey(val)) return false;
        int index = hashMap.get(val);
        numsList.set(index, numsList.get(numsList.size() - 1));
        hashMap.remove(val);
        hashMap.remove(numsList.get(numsList.size() - 1));
        hashMap.put(numsList.size() - 1, numsList.size() - 1);
        return true;
    }

    public int getRandom() {
        int integer = random.nextInt(numsList.size());
        return numsList.get(integer);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */