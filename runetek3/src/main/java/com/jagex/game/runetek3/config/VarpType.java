package com.jagex.game.runetek3.config;

// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

import com.jagex.core.io.Buffer;
import com.jagex.core.io.FileArchive;

public class VarpType {

    public static void decode(FileArchive class36) {
        Buffer class35_sub2_sub3 = new Buffer(class36.method417((byte) 6, null, "varp.dat"));
        anInt248 = 0;
        anInt246 = class35_sub2_sub3.g2();
        if (aVarpTypeArray247 == null)
            aVarpTypeArray247 = new VarpType[anInt246];
        if (anIntArray249 == null)
            anIntArray249 = new int[anInt246];
        for (int i = 0; i < anInt246; i++) {
            if (aVarpTypeArray247[i] == null)
                aVarpTypeArray247[i] = new VarpType();
            aVarpTypeArray247[i].method185(i, class35_sub2_sub3, aBoolean245);
        }

    }

    public void method185(int i, Buffer class35_sub2_sub3, boolean flag) {
        if (!flag)
            return;
        do {
            int j = class35_sub2_sub3.g1();
            if (j == 0)
                return;
            if (j == 1)
                anInt251 = class35_sub2_sub3.g1();
            else if (j == 2)
                anInt252 = class35_sub2_sub3.g1();
            else if (j == 3) {
                aBoolean253 = true;
                anIntArray249[anInt248++] = i;
            } else if (j == 4)
                aBoolean254 = false;
            else if (j == 5)
                anInt255 = class35_sub2_sub3.g2();
            else if (j == 10)
                aString250 = class35_sub2_sub3.gstr();
            else
                System.out.println("Error unrecognised config code: " + j);
        } while (true);
    }

    public VarpType() {
        aBoolean253 = false;
        aBoolean254 = true;
    }

    public static boolean aBoolean245 = true;
    public static int anInt246;
    public static VarpType[] aVarpTypeArray247;
    public static int anInt248;
    public static int[] anIntArray249;
    public String aString250;
    public int anInt251;
    public int anInt252;
    public boolean aBoolean253;
    public boolean aBoolean254;
    public int anInt255;

}
