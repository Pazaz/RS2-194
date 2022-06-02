package com.jagex.game.runetek3.config;

// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

import com.jagex.core.io.Buffer;
import com.jagex.core.io.FileArchive;

public class FloType {

    public static void decode(FileArchive class36) {
        Buffer class35_sub2_sub3 = new Buffer(class36.method417((byte) 6, null, "flo.dat"));
        anInt70 = class35_sub2_sub3.g2();
        if (aFloTypeArray71 == null)
            aFloTypeArray71 = new FloType[anInt70];
        for (int i = 0; i < anInt70; i++) {
            if (aFloTypeArray71[i] == null)
                aFloTypeArray71[i] = new FloType();
            aFloTypeArray71[i].method148(213, class35_sub2_sub3);
        }

    }

    public void method148(int i, Buffer class35_sub2_sub3) {
        i = 8 / i;
        do {
            int j = class35_sub2_sub3.g1();
            if (j == 0)
                return;
            if (j == 1) {
                anInt72 = class35_sub2_sub3.g3();
                method149((byte) 8, anInt72);
            } else if (j == 2)
                anInt73 = class35_sub2_sub3.g1();
            else if (j == 3)
                aBoolean74 = true;
            else if (j == 5)
                aBoolean75 = false;
            else if (j == 6)
                aString76 = class35_sub2_sub3.gstr();
            else
                System.out.println("Error unrecognised config code: " + j);
        } while (true);
    }

    public void method149(byte byte0, int i) {
        double d = (double) (i >> 16 & 0xff) / 256D;
        double d1 = (double) (i >> 8 & 0xff) / 256D;
        double d2 = (double) (i & 0xff) / 256D;
        double d3 = d;
        if (d1 < d3)
            d3 = d1;
        if (d2 < d3)
            d3 = d2;
        double d4 = d;
        if (d1 > d4)
            d4 = d1;
        if (d2 > d4)
            d4 = d2;
        double d5 = 0.0D;
        double d6 = 0.0D;
        double d7 = (d3 + d4) / 2D;
        if (d3 != d4) {
            if (d7 < 0.5D)
                d6 = (d4 - d3) / (d4 + d3);
            if (d7 >= 0.5D)
                d6 = (d4 - d3) / (2D - d4 - d3);
            if (d == d4)
                d5 = (d1 - d2) / (d4 - d3);
            else if (d1 == d4)
                d5 = 2D + (d2 - d) / (d4 - d3);
            else if (d2 == d4)
                d5 = 4D + (d - d1) / (d4 - d3);
        }
        d5 /= 6D;
        anInt77 = (int) (d5 * 256D);
        if (byte0 != 8)
            return;
        anInt78 = (int) (d6 * 256D);
        anInt79 = (int) (d7 * 256D);
        if (anInt78 < 0)
            anInt78 = 0;
        else if (anInt78 > 255)
            anInt78 = 255;
        if (anInt79 < 0)
            anInt79 = 0;
        else if (anInt79 > 255)
            anInt79 = 255;
        if (d7 > 0.5D)
            anInt81 = (int) ((1.0D - d7) * d6 * 512D);
        else
            anInt81 = (int) (d7 * d6 * 512D);
        if (anInt81 < 1)
            anInt81 = 1;
        anInt80 = (int) (d5 * (double) anInt81);
    }

    public FloType() {
        anInt73 = -1;
        aBoolean74 = false;
        aBoolean75 = true;
    }

    public static int anInt70;
    public static FloType[] aFloTypeArray71;
    public int anInt72;
    public int anInt73;
    public boolean aBoolean74;
    public boolean aBoolean75;
    public String aString76;
    public int anInt77;
    public int anInt78;
    public int anInt79;
    public int anInt80;
    public int anInt81;
}
