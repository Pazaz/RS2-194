package com.jagex.game.runetek3.entity;

// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

import com.jagex.game.runetek3.config.SpotAnimType;
import com.jagex.game.runetek3.graphics.model.Model;

public class SpotAnimEntity extends Entity {

    public SpotAnimEntity(int i, boolean flag, int j, int k, int l, int i1, int j1,
                          int k1) {
        aBoolean1197 = false;
        aBoolean1206 = false;
        if (flag)
            aBoolean1197 = !aBoolean1197;
        aSpotAnimType_1198 = SpotAnimType.aSpotAnimTypeArray212[i1];
        anInt1200 = k1;
        anInt1201 = k;
        anInt1202 = i;
        anInt1203 = j;
        anInt1199 = j1 + l;
        aBoolean1206 = false;
    }

    public void method408(int i, boolean flag) {
        if (flag)
            return;
        for (anInt1205 += i; anInt1205 > aSpotAnimType_1198.aSeqType_215.anIntArray194[anInt1204]; ) {
            anInt1205 -= aSpotAnimType_1198.aSeqType_215.anIntArray194[anInt1204] + 1;
            anInt1204++;
            if (anInt1204 >= aSpotAnimType_1198.aSeqType_215.anInt191) {
                anInt1204 = 0;
                aBoolean1206 = true;
            }
        }

    }

    public Model getDrawMethod(int i, int cycle) {
        if (i != 0) {
            for (int j = 1; j > 0; j++) ;
        }
        Model class35_sub2_sub1 = aSpotAnimType_1198.method183();
        Model class35_sub2_sub1_1 = new Model(-428, true, class35_sub2_sub1, true, false, !aSpotAnimType_1198.aBoolean216);
        if (!aBoolean1206) {
            class35_sub2_sub1_1.method310((byte) 3);
            class35_sub2_sub1_1.applyFrame(7, aSpotAnimType_1198.aSeqType_215.anIntArray192[anInt1204]);
            class35_sub2_sub1_1.skinTriangle = null;
            class35_sub2_sub1_1.anIntArrayArray1083 = null;
        }
        class35_sub2_sub1_1.method320(64, 850, -30, -50, -30, true);
        return class35_sub2_sub1_1;
    }

    public boolean aBoolean1197;
    public SpotAnimType aSpotAnimType_1198;
    public int anInt1199;
    public int anInt1200;
    public int anInt1201;
    public int anInt1202;
    public int anInt1203;
    public int anInt1204;
    public int anInt1205;
    public boolean aBoolean1206;
}
