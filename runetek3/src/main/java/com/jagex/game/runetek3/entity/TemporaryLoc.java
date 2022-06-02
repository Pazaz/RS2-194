package com.jagex.game.runetek3.entity;

// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

import com.jagex.core.utils.Node;

public class TemporaryLoc extends Node {

    public TemporaryLoc(int i, int j, int k, int l, boolean flag, int i1, int j1,
                        int k1, int l1) {
        anInt1030 = j1;
        if (flag) {
            throw new NullPointerException();
        } else {
            anInt1031 = i1;
            anInt1032 = j;
            anInt1033 = k;
            anInt1034 = l1;
            anInt1035 = k1;
            anInt1036 = l;
            anInt1037 = i;
            return;
        }
    }

    public int anInt1030;
    public int anInt1031;
    public int anInt1032;
    public int anInt1033;
    public int anInt1034;
    public int anInt1035;
    public int anInt1036;
    public int anInt1037;
}
