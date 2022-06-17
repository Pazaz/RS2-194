package com.jagex.core.utils;

public class Stack {

    public Stack() {
        head = new CacheableNode();
        head.nextCacheable = head;
        head.prevCacheable = head;
    }

    public void push(CacheableNode class35_sub2) {
        if (class35_sub2.prevCacheable != null) {
            class35_sub2.uncache();
        }
        class35_sub2.prevCacheable = head.prevCacheable;
        class35_sub2.nextCacheable = head;
        class35_sub2.prevCacheable.nextCacheable = class35_sub2;
        class35_sub2.nextCacheable.prevCacheable = class35_sub2;
    }

    public CacheableNode pop() {
        CacheableNode class35_sub2 = head.nextCacheable;
        if (class35_sub2 == head) {
            return null;
        } else {
            class35_sub2.uncache();
            return class35_sub2;
        }
    }

    public CacheableNode head;
}
