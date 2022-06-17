package com.jagex.core.utils;

public class LinkedList {

    public LinkedList() {
        anInt334 = 962;
        aBoolean335 = true;
        anInt336 = 947;
        head = new Node();
        head.prev = head;
        head.next = head;
    }

    public void pushNext(Node node) {
        if (node.next != null) {
            node.unlink();
        }
        node.next = head.next;
        node.prev = head;
        node.next.prev = node;
        node.prev.next = node;
    }

    public void method225(Node node) {
        if (node.next != null) {
            node.unlink();
        }
        node.next = head;
        node.prev = head.prev;
        node.next.prev = node;
        node.prev.next = node;
    }

    public Node poll() {
        Node node = head.prev;
        if (node == head) {
            return null;
        } else {
            node.unlink();
            return node;
        }
    }

    public Node method227() {
        Node node = head.prev;
        if (node == head) {
            aNode_338 = null;
            return null;
        } else {
            aNode_338 = node.prev;
            return node;
        }
    }

    public Node method228() {
        Node class35 = head.next;
        if (class35 == head) {
            aNode_338 = null;
            return null;
        }
        aNode_338 = class35.next;
        return class35;
    }

    public Node method229() {
        Node node = aNode_338;

        if (node == head) {
            aNode_338 = null;
            return null;
        } else {
            aNode_338 = node.prev;
            return node;
        }
    }

    public Node method230() {
        Node class35 = aNode_338;
        if (class35 == head) {
            aNode_338 = null;
            return null;
        }
        aNode_338 = class35.next;

        return class35;
    }

    public void method231() {
        while (true) {
            Node class35 = head.prev;
            if (class35 == head) {
                return;
            }
            class35.unlink();
        }
    }

    public int anInt334;
    public boolean aBoolean335;
    public int anInt336;
    public Node head;
    public Node aNode_338;
}
