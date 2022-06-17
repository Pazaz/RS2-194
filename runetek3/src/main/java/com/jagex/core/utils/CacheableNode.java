package com.jagex.core.utils;

// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3)

public class CacheableNode extends Node {

    public void uncache() {
        if (aCacheableNode_1018 == null) {
            return;
        } else {
            aCacheableNode_1018.aCacheableNode_1017 = aCacheableNode_1017;
            aCacheableNode_1017.aCacheableNode_1018 = aCacheableNode_1018;
            aCacheableNode_1017 = null;
            aCacheableNode_1018 = null;
            return;
        }
    }

    public CacheableNode() {
    }

    public CacheableNode aCacheableNode_1017;
    public CacheableNode aCacheableNode_1018;
    public static int anInt1019;
}
