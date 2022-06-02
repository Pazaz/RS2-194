package com.jagex.game.runetek3.config;

// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

import com.jagex.core.io.Buffer;
import com.jagex.core.io.FileArchive;
import com.jagex.game.runetek3.graphics.seq.SeqFrame;

public class SeqType {

    public static void decode(FileArchive class36) {
        Buffer class35_sub2_sub3 = new Buffer(class36.method417((byte) 6, null, "seq.dat"));
        anInt189 = class35_sub2_sub3.g2();
        if (aSeqTypeArray190 == null)
            aSeqTypeArray190 = new SeqType[anInt189];
        for (int i = 0; i < anInt189; i++) {
            if (aSeqTypeArray190[i] == null)
                aSeqTypeArray190[i] = new SeqType();
            aSeqTypeArray190[i].method180(213, class35_sub2_sub3);
        }

    }

    public void method180(int i, Buffer class35_sub2_sub3) {
        i = 81 / i;
        do {
            int j = class35_sub2_sub3.g1();
            if (j == 0)
                break;
            if (j == 1) {
                anInt191 = class35_sub2_sub3.g1();
                anIntArray192 = new int[anInt191];
                anIntArray193 = new int[anInt191];
                anIntArray194 = new int[anInt191];
                for (int k = 0; k < anInt191; k++) {
                    anIntArray192[k] = class35_sub2_sub3.g2();
                    anIntArray193[k] = class35_sub2_sub3.g2();
                    if (anIntArray193[k] == 65535)
                        anIntArray193[k] = -1;
                    anIntArray194[k] = class35_sub2_sub3.g2();
                    if (anIntArray194[k] == 0)
                        anIntArray194[k] = SeqFrame.aSeqFrameArray180[anIntArray192[k]].anInt181;
                    if (anIntArray194[k] == 0)
                        anIntArray194[k] = 1;
                }

            } else if (j == 2)
                anInt195 = class35_sub2_sub3.g2();
            else if (j == 3) {
                int l = class35_sub2_sub3.g1();
                anIntArray196 = new int[l + 1];
                for (int i1 = 0; i1 < l; i1++)
                    anIntArray196[i1] = class35_sub2_sub3.g1();

                anIntArray196[l] = 0x98967f;
            } else if (j == 4)
                anInt197 = class35_sub2_sub3.g2();
            else if (j == 5)
                anInt198 = class35_sub2_sub3.g1();
            else if (j == 6)
                anInt199 = class35_sub2_sub3.g2();
            else if (j == 7)
                anInt200 = class35_sub2_sub3.g2();
            else if (j == 8)
                anInt201 = class35_sub2_sub3.g1();
            else
                System.out.println("Error unrecognised seq config code: " + j);
        } while (true);
        if (anInt191 == 0) {
            anInt191 = 1;
            anIntArray192 = new int[1];
            anIntArray192[0] = -1;
            anIntArray193 = new int[1];
            anIntArray193[0] = -1;
            anIntArray194 = new int[1];
            anIntArray194[0] = -1;
        }
    }

    public SeqType() {
        anInt195 = -1;
        anInt198 = 5;
        anInt199 = -1;
        anInt200 = -1;
        anInt201 = 99;
    }

    public static boolean aBoolean188 = true;
    public static int anInt189;
    public static SeqType[] aSeqTypeArray190;
    public int anInt191;
    public int[] anIntArray192;
    public int[] anIntArray193;
    public int[] anIntArray194;
    public int anInt195;
    public int[] anIntArray196;
    public int anInt197;
    public int anInt198;
    public int anInt199;
    public int anInt200;
    public int anInt201;
    public static int anInt202;

}
