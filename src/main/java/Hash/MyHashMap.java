package Hash;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * @program: leetcode
 * @description: 706
 * @author: Skyler
 * @create: 2024-04-15 15:41
 **/

public class MyHashMap {
    private static final int finalSize = 769;
    private LinkedList[] linkedLists;
    public MyHashMap() {
        linkedLists = new LinkedList[finalSize];
        for (int i = 0; i < finalSize; i++) {
            linkedLists[i] = new LinkedList<int[]>();
        }
    }

    public int hash(int key){
        return key % finalSize;
    }

    public void put(int key, int value) {
        int h = hash(key);
        Iterator<int[]> iterator = linkedLists[h].iterator();
        while (iterator.hasNext()){
            int[] now = iterator.next();
            if (now[0] == key){
                now[1] = value;
                return;
            }
        }
        linkedLists[h].offerLast(new int[]{key, value});
    }

    public int get(int key) {
        int h = hash(key);
        Iterator<int[]> iterator = linkedLists[h].iterator();
        while (iterator.hasNext()){
            int[] now = iterator.next();
            if (now[0] == key){
                return now[1];
            }
        }
        return -1;
    }

    public void remove(int key) {
        int h = hash(key);
        Iterator<int[]> iterator = linkedLists[h].iterator();
        while (iterator.hasNext()){
            int[] now = iterator.next();
            if (now[0] == key){
                linkedLists[h].remove(now);
                return;
            }
        }
    }
}
