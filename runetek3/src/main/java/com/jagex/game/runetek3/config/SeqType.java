package com.jagex.game.runetek3.config;

// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

import com.jagex.core.io.Buffer;
import com.jagex.core.io.FileArchive;
import com.jagex.game.runetek3.graphics.seq.SeqFrame;

public class SeqType {

    public static void decode(FileArchive class36) {
        Buffer class35_sub2_sub3 = new Buffer(class36.read(null, "seq.dat"));
        anInt189 = class35_sub2_sub3.g2();
        if (instances == null)
            instances = new SeqType[anInt189];
        for (int i = 0; i < anInt189; i++) {
            if (instances[i] == null)
                instances[i] = new SeqType();
            instances[i].method180(213, class35_sub2_sub3);
        }

    }

    public void method180(int i, Buffer class35_sub2_sub3) {
        i = 81 / i;
        do {
            int j = class35_sub2_sub3.g1();
            if (j == 0)
                break;
            if (j == 1) {
                frameCount = class35_sub2_sub3.g1();
                primaryFrames = new int[frameCount];
                anIntArray193 = new int[frameCount];
                frameDelay = new int[frameCount];
                for (int k = 0; k < frameCount; k++) {
                    primaryFrames[k] = class35_sub2_sub3.g2();
                    anIntArray193[k] = class35_sub2_sub3.g2();
                    if (anIntArray193[k] == 65535)
                        anIntArray193[k] = -1;
                    frameDelay[k] = class35_sub2_sub3.g2();
                    if (frameDelay[k] == 0)
                        frameDelay[k] = SeqFrame.instances[primaryFrames[k]].anInt181;
                    if (frameDelay[k] == 0)
                        frameDelay[k] = 1;
                }

            } else if (j == 2)
                anInt195 = class35_sub2_sub3.g2();
            else if (j == 3) {
                int l = class35_sub2_sub3.g1();
                labelGroups = new int[l + 1];
                for (int i1 = 0; i1 < l; i1++)
                    labelGroups[i1] = class35_sub2_sub3.g1();

                labelGroups[l] = 0x98967f;
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
        if (frameCount == 0) {
            frameCount = 1;
            primaryFrames = new int[1];
            primaryFrames[0] = -1;
            anIntArray193 = new int[1];
            anIntArray193[0] = -1;
            frameDelay = new int[1];
            frameDelay[0] = -1;
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
    public static SeqType[] instances;
    public int frameCount;
    public int[] primaryFrames;
    public int[] anIntArray193;
    public int[] frameDelay;
    public int anInt195;
    public int[] labelGroups;
    public int anInt197;
    public int anInt198;
    public int anInt199;
    public int anInt200;
    public int anInt201;
    public static int anInt202;

}
