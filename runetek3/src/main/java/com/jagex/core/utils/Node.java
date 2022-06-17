package com.jagex.core.utils;

// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3)

public class Node {

    public void unlink() {
        if (aNode_510 == null) {
            return;
        } else {
            aNode_510.aNode_509 = aNode_509;
            aNode_509.aNode_510 = aNode_510;
            aNode_509 = null;
            aNode_510 = null;
            return;
        }
    }

    public Node() {
    }

    public long aLong508;
    public Node aNode_509;
    public Node aNode_510;
    public static boolean aBoolean511;
}
