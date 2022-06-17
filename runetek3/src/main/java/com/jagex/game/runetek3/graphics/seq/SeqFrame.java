package com.jagex.game.runetek3.graphics.seq;

// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

import com.jagex.core.io.Buffer;
import com.jagex.core.io.FileArchive;

public class SeqFrame {

    public static void decode(FileArchive class36) {
        Buffer class35_sub2_sub3 = new Buffer(class36.read(null, "frame_head.dat"));
        Buffer class35_sub2_sub3_1 = new Buffer(class36.read(null, "frame_tran1.dat"));
        Buffer class35_sub2_sub3_2 = new Buffer(class36.read(null, "frame_tran2.dat"));
        Buffer class35_sub2_sub3_3 = new Buffer(class36.read(null, "frame_del.dat"));
        int j = class35_sub2_sub3.g2();
        int k = class35_sub2_sub3.g2();
        instances = new SeqFrame[k + 1];
        int[] ai = new int[500];
        int[] ai1 = new int[500];
        int[] ai2 = new int[500];
        int[] ai3 = new int[500];
        for (int l = 0; l < j; l++) {
            int i1 = class35_sub2_sub3.g2();
            SeqFrame class11 = instances[i1] = new SeqFrame();
            class11.anInt181 = class35_sub2_sub3_3.g1();
            int j1 = class35_sub2_sub3.g2();
            SeqSkeleton class9 = SeqSkeleton.aSeqBaseArray169[j1];
            class11.transform = class9;
            int k1 = class35_sub2_sub3.g1();
            int l1 = -1;
            int i2 = 0;
            for (int j2 = 0; j2 < k1; j2++) {
                int k2 = class35_sub2_sub3_1.g1();
                if (k2 > 0) {
                    if (class9.transformTypes[j2] != 0) {
                        for (int i3 = j2 - 1; i3 > l1; i3--) {
                            if (class9.transformTypes[i3] != 0)
                                continue;
                            ai[i2] = i3;
                            ai1[i2] = 0;
                            ai2[i2] = 0;
                            ai3[i2] = 0;
                            i2++;
                            break;
                        }

                    }
                    ai[i2] = j2;
                    char c = '\0';
                    if (class9.transformTypes[ai[i2]] == 3)
                        c = '\200';
                    if ((k2 & 1) != 0)
                        ai1[i2] = class35_sub2_sub3_2.gsmart();
                    else
                        ai1[i2] = c;
                    if ((k2 & 2) != 0)
                        ai2[i2] = class35_sub2_sub3_2.gsmart();
                    else
                        ai2[i2] = c;
                    if ((k2 & 4) != 0)
                        ai3[i2] = class35_sub2_sub3_2.gsmart();
                    else
                        ai3[i2] = c;
                    l1 = j2;
                    i2++;
                }
            }

            class11.groupCount = i2;
            class11.groups = new int[i2];
            class11.anIntArray185 = new int[i2];
            class11.anIntArray186 = new int[i2];
            class11.anIntArray187 = new int[i2];
            for (int l2 = 0; l2 < i2; l2++) {
                class11.groups[l2] = ai[l2];
                class11.anIntArray185[l2] = ai1[l2];
                class11.anIntArray186[l2] = ai2[l2];
                class11.anIntArray187[l2] = ai3[l2];
            }

        }

    }

    public SeqFrame() {
    }

    public static SeqFrame[] instances;
    public int anInt181;
    public SeqSkeleton transform;
    public int groupCount;
    public int[] groups;
    public int[] anIntArray185;
    public int[] anIntArray186;
    public int[] anIntArray187;
}
