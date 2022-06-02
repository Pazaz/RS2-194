package com.jagex.game.runetek3.entity;

// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

import com.jagex.game.runetek3.config.NpcType;
import com.jagex.game.runetek3.config.SeqType;
import com.jagex.game.runetek3.config.SpotAnimType;
import com.jagex.game.runetek3.graphics.model.Model;

public class NpcEntity extends PathingEntity {

    public Model getDrawMethod(int i, int cycle) {
        if (aNpcType_1325 == null)
            return null;
        if (super.anInt1240 == -1 || super.anInt1241 == -1)
            return method412(0);
        Model class35_sub2_sub1 = method412(0);
        SpotAnimType class14 = SpotAnimType.aSpotAnimTypeArray212[super.anInt1240];
        Model class35_sub2_sub1_1 = new Model(-428, true, class14.method183(), true, false, !class14.aBoolean216);
        class35_sub2_sub1_1.method316(0, 0, 0, -super.anInt1244);
        class35_sub2_sub1_1.method310((byte) 3);
        class35_sub2_sub1_1.applyFrame(7, class14.aSeqType_215.anIntArray192[super.anInt1241]);
        if (i != 0)
            anInt1323 = -466;
        class35_sub2_sub1_1.anIntArrayArray1084 = null;
        class35_sub2_sub1_1.anIntArrayArray1083 = null;
        class35_sub2_sub1_1.method320(64, 850, -30, -50, -30, true);
        Model[] aclass35_sub2_sub1 = {
                class35_sub2_sub1, class35_sub2_sub1_1
        };
        Model class35_sub2_sub1_2 = new Model(true, true, aclass35_sub2_sub1, 2);
        if (aNpcType_1325.aByte578 == 1)
            class35_sub2_sub1_2.aBoolean1085 = true;
        return class35_sub2_sub1_2;
    }

    public Model method412(int i) {
        if (super.anInt1235 >= 0 && super.anInt1238 == 0) {
            int j = SeqType.aSeqTypeArray190[super.anInt1235].anIntArray192[super.anInt1236];
            int l = -1;
            if (super.anInt1232 >= 0 && super.anInt1232 != super.anInt1213)
                l = SeqType.aSeqTypeArray190[super.anInt1232].anIntArray192[super.anInt1233];
            return aNpcType_1325.method436(j, l, SeqType.aSeqTypeArray190[super.anInt1235].anIntArray196);
        }
        int k = -1;
        if (super.anInt1232 >= 0)
            k = SeqType.aSeqTypeArray190[super.anInt1232].anIntArray192[super.anInt1233];
        Model class35_sub2_sub1 = aNpcType_1325.method436(k, -1, null);
        if (i != 0)
            anInt1323 = -127;
        super.anInt1253 = class35_sub2_sub1.anInt1076;
        return class35_sub2_sub1;
    }

    public boolean method411(int i) {
        if (i != 0)
            anInt1324 = 188;
        return aNpcType_1325 != null;
    }

    public NpcEntity() {
        anInt1323 = 3073;
        anInt1324 = -1992;
    }

    public int anInt1323;
    public int anInt1324;
    public NpcType aNpcType_1325;
}
