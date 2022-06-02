package com.jagex.core.utils;

// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

public class Stack {

    public Stack(int i) {
        aBoolean354 = true;
        aBoolean355 = true;
        aCacheableNode_356 = new CacheableNode();
        aCacheableNode_356.aCacheableNode_1017 = aCacheableNode_356;
        if (i != 0) {
            for (int j = 1; j > 0; j++) ;
        }
        aCacheableNode_356.aCacheableNode_1018 = aCacheableNode_356;
    }

    public void method232(CacheableNode class35_sub2) {
        if (class35_sub2.aCacheableNode_1018 != null)
            class35_sub2.method304();
        class35_sub2.aCacheableNode_1018 = aCacheableNode_356.aCacheableNode_1018;
        class35_sub2.aCacheableNode_1017 = aCacheableNode_356;
        class35_sub2.aCacheableNode_1018.aCacheableNode_1017 = class35_sub2;
        class35_sub2.aCacheableNode_1017.aCacheableNode_1018 = class35_sub2;
    }

    public CacheableNode method233() {
        CacheableNode class35_sub2 = aCacheableNode_356.aCacheableNode_1017;
        if (class35_sub2 == aCacheableNode_356) {
            return null;
        } else {
            class35_sub2.method304();
            return class35_sub2;
        }
    }

    public boolean aBoolean354;
    public boolean aBoolean355;
    public CacheableNode aCacheableNode_356;
}
