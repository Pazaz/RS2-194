package com.jagex.core.utils;

public class Cache {

    public Cache(int j) {
        aBoolean445 = false;
        anInt446 = 930;
        hastable = new Hashtable((byte) 1, 1024);
        history = new Stack(0);
        capacity = j;
        available = j;
    }

    public CacheableNode get(long key) {
        CacheableNode node = (CacheableNode) hastable.get(key);
        if (node != null) {
            history.push(node);
        }
        return node;
    }

    public void put(long key, CacheableNode node) {
        if (available == 0) {
            CacheableNode last = history.pop();
            last.unlink();
            last.uncache();
        } else {
            available--;
        }
        hastable.put(node, -99, key);
        history.push(node);
    }

    public void method297() {
        do {
            CacheableNode last = history.pop();
            if (last == null) {
                available = capacity;
                return;
            }
            last.unlink();
            last.uncache();
        } while (true);
    }

    public boolean aBoolean445;
    public int anInt446;
    public int capacity;
    public int available;
    public Hashtable hastable;
    public Stack history;
}
