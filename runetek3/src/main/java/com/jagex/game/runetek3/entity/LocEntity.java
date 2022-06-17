package com.jagex.game.runetek3.entity;

// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

import com.jagex.core.utils.Node;
import com.jagex.game.runetek3.config.SeqType;

public class LocEntity extends Node {

    public int anInt1039;
    public int anInt1040;
    public int anInt1041;
    public int anInt1042;
    public int anInt1043;
    public SeqType seq;
    public int seqFrame;
    public int seqCycle;

    public LocEntity(int i, int k, int l, boolean animated, SeqType seq, int i1, int j1) {
        anInt1039 = k;
        anInt1040 = i;
        anInt1041 = j1;
        anInt1042 = i1;
        anInt1043 = l;
        this.seq = seq;

        if (animated) {
            seqFrame = (int) (Math.random() * (double) this.seq.frameCount);
            seqCycle = (int) (Math.random() * (double) this.seq.frameDelay[seqFrame]);
        } else {
            seqFrame = -1;
            seqCycle = 0;
        }
    }


}
