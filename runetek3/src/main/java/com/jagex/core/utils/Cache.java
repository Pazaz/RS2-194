package com.jagex.core.utils;

// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

import rs2.sign.signlink;

public class Cache {

    public Cache(int i, int j) {
        aBoolean445 = false;
        anInt446 = 930;
        aHashtable_449 = new Hashtable((byte) 1, 1024);
        aStack_450 = new Stack(0);
        anInt447 = j;
        anInt448 = j;
        if (i != -24094)
            aBoolean445 = !aBoolean445;
    }

    public CacheableNode method295(long l) {
        CacheableNode class35_sub2 = (CacheableNode) aHashtable_449.method298(l);
        if (class35_sub2 != null)
            aStack_450.method232(class35_sub2);
        return class35_sub2;
    }

    public void method296(long l, int i, CacheableNode class35_sub2) {
        try {
            i = 94 / i;
            if (anInt448 == 0) {
                CacheableNode class35_sub2_1 = aStack_450.method233();
                class35_sub2_1.method303();
                class35_sub2_1.method304();
            } else {
                anInt448--;
            }
            aHashtable_449.method299(class35_sub2, -99, l);
            aStack_450.method232(class35_sub2);
            return;
        } catch (RuntimeException runtimeexception) {
            signlink.reporterror("76121, " + l + ", " + i + ", " + class35_sub2 + ", " + runtimeexception);
        }
        throw new RuntimeException();
    }

    public void method297() {
        do {
            CacheableNode class35_sub2 = aStack_450.method233();
            if (class35_sub2 != null) {
                class35_sub2.method303();
                class35_sub2.method304();
            } else {
                anInt448 = anInt447;
                return;
            }
        } while (true);
    }

    public boolean aBoolean445;
    public int anInt446;
    public int anInt447;
    public int anInt448;
    public Hashtable aHashtable_449;
    public Stack aStack_450;
}
