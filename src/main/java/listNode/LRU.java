package listNode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @program: leetcode
 * @description: 146
 * @author: Skyler
 * @create: 2024-03-06 17:08
 **/

class LRU {
    static class Node{
        int key;
        int value;
        Node prev;
        Node next;
        public Node(){}
        public Node(int key, int value){
            this.key = key;
            this.value = value;
        }
    }

    private int size;
    private int capacity;
    private Map<Integer, Node> map;
    private Node begin;
    private Node end;

    public LRU(int capacity) {
        this.size = 0;
        this.map = new HashMap<>();
        this.begin = new Node();
        this.end = new Node();
        this.begin.next = end;
        this.end.prev = begin;
        this.capacity = capacity;
    }

    public int get(int key) {
        if (!map.containsKey(key)) return -1;
        Node node = map.get(key);
        moveToBegin(node);
        return node.value;
    }

    public void put(int key, int value) {
        if (!map.containsKey(key)){
            Node node = new Node(key, value);
            insertToHead(node);
            map.put(key, node);
            size++;
            if (size > capacity){
                Node tail = deleteTail();
                map.remove(tail.key);
                size--;
            }
        }else {
            Node node = map.get(key);
            node.value = value;
            moveToBegin(node);
        }
    }

    public void moveToBegin(Node node){
        node.next.prev = node.prev;
        node.prev.next = node.next;
        insertToHead(node);
    }

    public void insertToHead(Node node){
        node.next = begin.next;
        begin.next.prev = node;
        node.prev = begin;
        begin.next = node;
    }

    public Node deleteTail(){
        Node tail = end.prev;
        tail.prev.next = end;
        end.prev = tail.prev;
        return tail;
    }
}