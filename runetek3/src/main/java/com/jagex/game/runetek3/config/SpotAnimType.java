package com.jagex.game.runetek3.config;

// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

import com.jagex.core.io.Buffer;
import com.jagex.core.io.FileArchive;
import com.jagex.core.utils.Cache;
import com.jagex.game.runetek3.graphics.model.Model;

public class SpotAnimType {

    public static void decode(FileArchive class36) {
        Buffer class35_sub2_sub3 = new Buffer(class36.method417((byte) 6, null, "spotanim.dat"));
        anInt211 = class35_sub2_sub3.g2();
        if (aSpotAnimTypeArray212 == null)
            aSpotAnimTypeArray212 = new SpotAnimType[anInt211];
        for (int i = 0; i < anInt211; i++) {
            if (aSpotAnimTypeArray212[i] == null)
                aSpotAnimTypeArray212[i] = new SpotAnimType();
            aSpotAnimTypeArray212[i].anInt213 = i;
            aSpotAnimTypeArray212[i].method182(213, class35_sub2_sub3);
        }
    }

    public void method182(int i, Buffer class35_sub2_sub3) {
        i = 90 / i;
        do {
            int j = class35_sub2_sub3.g1();
            if (j == 0)
                return;
            if (j == 1)
                anInt214 = class35_sub2_sub3.g2();
            else if (j == 2)
                aSeqType_215 = SeqType.aSeqTypeArray190[class35_sub2_sub3.g2()];
            else if (j == 3)
                aBoolean216 = true;
            else if (j >= 40 && j < 50)
                anIntArray217[j - 40] = class35_sub2_sub3.g2();
            else if (j >= 50 && j < 60)
                anIntArray218[j - 50] = class35_sub2_sub3.g2();
            else
                System.out.println("Error unrecognised spotanim config code: " + j);
        } while (true);
    }

    public Model method183() {
        Model class35_sub2_sub1 = (Model) aCache_219.method295(anInt213);
        if (class35_sub2_sub1 != null)
            return class35_sub2_sub1;
        class35_sub2_sub1 = new Model(anInt214, 298);
        for (int i = 0; i < 6; i++)
            if (anIntArray217[0] != 0)
                class35_sub2_sub1.method317(anIntArray217[i], anIntArray218[i]);

        aCache_219.method296(anInt213, 7, class35_sub2_sub1);
        return class35_sub2_sub1;
    }

    public SpotAnimType() {
        aBoolean216 = false;
        anIntArray217 = new int[6];
        anIntArray218 = new int[6];
    }

    public static int anInt211;
    public static SpotAnimType[] aSpotAnimTypeArray212;
    public int anInt213;
    public int anInt214;
    public SeqType aSeqType_215;
    public boolean aBoolean216;
    public int[] anIntArray217;
    public int[] anIntArray218;
    public static Cache aCache_219 = new Cache(-24094, 30);

}
