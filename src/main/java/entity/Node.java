package entity;

import lombok.AllArgsConstructor;

import java.util.List;

/**
 * @program: leetcode
 * @description:
 * @author: Skyler
 * @create: 2024-03-01 15:34
 **/

public class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}
