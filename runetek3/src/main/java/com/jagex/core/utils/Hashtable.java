package com.jagex.core.utils;

public class Hashtable {

    public int size;

    public Node[] nodes;

    public Hashtable(int size) {
        this.size = size;
        nodes = new Node[size];
        for (int i = 0; i < size; i++) {
            Node node = nodes[i] = new Node();
            node.prev = node;
            node.next = node;
        }
    }

    public Node get(long key) {
        Node start = nodes[(int) (key & (long) (size - 1))];
        for (Node last = start.prev; last != start; last = last.prev) {
            if (last.key == key) {
                return last;
            }
        }
        return null;
    }

    public void put(Node node, long key) {
        if (node.next != null) {
            node.unlink();
        }
        Node class35_1 = nodes[(int) (key & (long) (size - 1))];
        node.next = class35_1.next;
        node.prev = class35_1;
        node.next.prev = node;
        node.key = key;
    }
}
