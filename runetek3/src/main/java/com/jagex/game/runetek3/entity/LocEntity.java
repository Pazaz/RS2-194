package com.jagex.game.runetek3.entity;

// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

import com.jagex.core.utils.Node;
import com.jagex.game.runetek3.config.SeqType;

public class LocEntity extends Node {

    public LocEntity(int i, int j, int k, int l, boolean flag, SeqType class12, int i1,
                     int j1) {
        anInt1038 = 49498;
        anInt1039 = k;
        anInt1040 = i;
        anInt1041 = j1;
        if (j >= 0)
            anInt1038 = 25;
        anInt1042 = i1;
        anInt1043 = l;
        aSeqType_1044 = class12;
        if (flag) {
            anInt1045 = (int) (Math.random() * (double) aSeqType_1044.anInt191);
            anInt1046 = (int) (Math.random() * (double) aSeqType_1044.anIntArray194[anInt1045]);
            return;
        } else {
            anInt1045 = -1;
            anInt1046 = 0;
            return;
        }
    }

    public int anInt1038;
    public int anInt1039;
    public int anInt1040;
    public int anInt1041;
    public int anInt1042;
    public int anInt1043;
    public SeqType aSeqType_1044;
    public int anInt1045;
    public int anInt1046;
}
