package Hash;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * @program: leetcode
 * @description: 705
 * @author: Skyler
 * @create: 2024-04-14 14:57
 **/

class MyHashSet {
    private static final int finalSize = 769;
    private LinkedList[] linkedLists;
    public MyHashSet() {
        linkedLists = new LinkedList[finalSize];
        for (int i = 0; i < finalSize; i++) {
            linkedLists[i] = new LinkedList<Integer>();
        }
    }

    public void add(int key) {
        int h = hash(key);
        Iterator<Integer> integerIterator = linkedLists[h].iterator();
        while (integerIterator.hasNext()){
            Integer value = integerIterator.next();
            if (value == key) return;
        }
        linkedLists[h].offerLast(key);
    }

    public void remove(int key) {
        int h = hash(key);
        Iterator<Integer> integerIterator = linkedLists[h].iterator();
        while (integerIterator.hasNext()){
            Integer value = integerIterator.next();
            if (value == key){
                linkedLists[h].remove(Integer.valueOf(key));
                return;
            }
        }
    }

    public boolean contains(int key) {
        int h = hash(key);
        Iterator<Integer> integerIterator = linkedLists[h].iterator();
        while (integerIterator.hasNext()){
            Integer value = integerIterator.next();
            if (value == key){
                return true;
            }
        }
        return false;
    }

    public int hash(int key){
        return key % finalSize;
    }
}
