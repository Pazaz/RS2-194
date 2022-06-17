package com.jagex.game.runetek3.graphics.seq;

// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

import com.jagex.core.io.Buffer;
import com.jagex.core.io.FileArchive;

public class SeqSkeleton {

    public static void decode(FileArchive class36) {
        Buffer class35_sub2_sub3 = new Buffer(class36.read(null, "base_head.dat"));
        Buffer class35_sub2_sub3_1 = new Buffer(class36.read(null, "base_type.dat"));
        Buffer class35_sub2_sub3_2 = new Buffer(class36.read(null, "base_label.dat"));
        int j = class35_sub2_sub3.g2();
        int k = class35_sub2_sub3.g2();
        aSeqBaseArray169 = new SeqSkeleton[k + 1];
        for (int l = 0; l < j; l++) {
            int i1 = class35_sub2_sub3.g2();
            int j1 = class35_sub2_sub3.g1();
            int[] ai = new int[j1];
            int[][] ai1 = new int[j1][];
            for (int k1 = 0; k1 < j1; k1++) {
                ai[k1] = class35_sub2_sub3_1.g1();
                int l1 = class35_sub2_sub3_2.g1();
                ai1[k1] = new int[l1];
                for (int i2 = 0; i2 < l1; i2++)
                    ai1[k1][i2] = class35_sub2_sub3_2.g1();

            }

            aSeqBaseArray169[i1] = new SeqSkeleton();
            aSeqBaseArray169[i1].anInt170 = j1;
            aSeqBaseArray169[i1].transformTypes = ai;
            aSeqBaseArray169[i1].groupLabels = ai1;
        }

    }

    public SeqSkeleton() {
    }

    public static SeqSkeleton[] aSeqBaseArray169;
    public int anInt170;
    public int[] transformTypes;
    public int[][] groupLabels;
}
