package com.jagex.game.runetek3.config;

// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

import com.jagex.core.io.Buffer;
import com.jagex.core.io.FileArchive;
import com.jagex.core.utils.Cache;
import com.jagex.game.runetek3.graphics.model.Model;

public class NpcType {

    public static void decode(FileArchive class36) {
        aClass35_Sub2_Sub3_572 = new Buffer(class36.read(null, "npc.dat"));
        Buffer class35_sub2_sub3 = new Buffer(class36.read(null, "npc.idx"));
        anInt570 = class35_sub2_sub3.g2();
        anIntArray571 = new int[anInt570];
        int i = 2;
        for (int j = 0; j < anInt570; j++) {
            anIntArray571[j] = i;
            i += class35_sub2_sub3.g2();
        }

        aNpcTypeArray573 = new NpcType[20];
        for (int k = 0; k < 20; k++)
            aNpcTypeArray573[k] = new NpcType();

    }

    public static void method433(int i) {
        if (i <= 0) {
            for (int j = 1; j > 0; j++) ;
        }
        aCache_597 = null;
        anIntArray571 = null;
        aNpcTypeArray573 = null;
        aClass35_Sub2_Sub3_572 = null;
    }

    public static NpcType method434(int i) {
        for (int j = 0; j < 20; j++)
            if (aNpcTypeArray573[j].aLong575 == (long) i)
                return aNpcTypeArray573[j];

        anInt574 = (anInt574 + 1) % 20;
        NpcType class40 = aNpcTypeArray573[anInt574] = new NpcType();
        aClass35_Sub2_Sub3_572.pos = anIntArray571[i];
        class40.aLong575 = i;
        class40.method435(213, aClass35_Sub2_Sub3_572);
        return class40;
    }

    public void method435(int i, Buffer class35_sub2_sub3) {
        if (i <= 0) {
            for (int j = 1; j > 0; j++) ;
        }
        do {
            int k = class35_sub2_sub3.g1();
            if (k == 0)
                return;
            if (k == 1) {
                int l = class35_sub2_sub3.g1();
                anIntArray579 = new int[l];
                for (int k1 = 0; k1 < l; k1++)
                    anIntArray579[k1] = class35_sub2_sub3.g2();

            } else if (k == 2)
                aString576 = class35_sub2_sub3.gstr();
            else if (k == 3)
                aByteArray577 = class35_sub2_sub3.gstrbyte();
            else if (k == 12)
                size = class35_sub2_sub3.g1b();
            else if (k == 13)
                anInt581 = class35_sub2_sub3.g2();
            else if (k == 14)
                anInt582 = class35_sub2_sub3.g2();
            else if (k == 16)
                aBoolean586 = true;
            else if (k == 17) {
                anInt582 = class35_sub2_sub3.g2();
                anInt583 = class35_sub2_sub3.g2();
                anInt584 = class35_sub2_sub3.g2();
                anInt585 = class35_sub2_sub3.g2();
            } else if (k >= 30 && k < 40) {
                if (aStringArray589 == null)
                    aStringArray589 = new String[5];
                aStringArray589[k - 30] = class35_sub2_sub3.gstr();
            } else if (k == 40) {
                int i1 = class35_sub2_sub3.g1();
                anIntArray587 = new int[i1];
                anIntArray588 = new int[i1];
                for (int l1 = 0; l1 < i1; l1++) {
                    anIntArray587[l1] = class35_sub2_sub3.g2();
                    anIntArray588[l1] = class35_sub2_sub3.g2();
                }

            } else if (k == 60) {
                int j1 = class35_sub2_sub3.g1();
                anIntArray580 = new int[j1];
                for (int i2 = 0; i2 < j1; i2++)
                    anIntArray580[i2] = class35_sub2_sub3.g2();

            } else if (k == 90)
                anInt590 = class35_sub2_sub3.g2();
            else if (k == 91)
                anInt591 = class35_sub2_sub3.g2();
            else if (k == 92)
                anInt592 = class35_sub2_sub3.g2();
            else if (k == 93)
                aBoolean593 = false;
            else if (k == 95)
                anInt594 = class35_sub2_sub3.g2();
            else if (k == 97)
                anInt595 = class35_sub2_sub3.g2();
            else if (k == 98)
                anInt596 = class35_sub2_sub3.g2();
        } while (true);
    }

    public Model getModel(int primaryFrame, int secondaryFrame, int[] labelGroups) {
        Model class35_sub2_sub1 = null;
        Model class35_sub2_sub1_1 = (Model) aCache_597.method295(aLong575);
        if (class35_sub2_sub1_1 == null) {
            Model[] aclass35_sub2_sub1 = new Model[anIntArray579.length];
            for (int k = 0; k < anIntArray579.length; k++)
                aclass35_sub2_sub1[k] = new Model(anIntArray579[k], 298);

            if (aclass35_sub2_sub1.length == 1)
                class35_sub2_sub1_1 = aclass35_sub2_sub1[0];
            else
                class35_sub2_sub1_1 = new Model(false, aclass35_sub2_sub1.length, aclass35_sub2_sub1);
            if (anIntArray587 != null) {
                for (int l = 0; l < anIntArray587.length; l++)
                    class35_sub2_sub1_1.recolor(anIntArray587[l], anIntArray588[l]);

            }
            class35_sub2_sub1_1.applyGroups();
            class35_sub2_sub1_1.applyLighting(64, 850, -30, -50, -30, true);
            aCache_597.method296(aLong575, 7, class35_sub2_sub1_1);
        }
        class35_sub2_sub1 = new Model(false, !aBoolean586, class35_sub2_sub1_1);
        if (primaryFrame != -1 && secondaryFrame != -1)
            class35_sub2_sub1.applyFrames(primaryFrame, secondaryFrame, labelGroups);
        else if (primaryFrame != -1)
            class35_sub2_sub1.applyFrame(primaryFrame);
        if (anInt595 != 128 || anInt596 != 128)
            class35_sub2_sub1.method319(728, anInt595, anInt596, anInt595);
        class35_sub2_sub1.method308(569);
        class35_sub2_sub1.skinTriangle = null;
        class35_sub2_sub1.labelVertices = null;
        if (size == 1)
            class35_sub2_sub1.pickable = true;
        return class35_sub2_sub1;
    }

    public Model method437(int i) {
        if (anIntArray580 == null)
            return null;
        Model[] aclass35_sub2_sub1 = new Model[anIntArray580.length];
        if (i != 0)
            throw new NullPointerException();
        for (int j = 0; j < anIntArray580.length; j++)
            aclass35_sub2_sub1[j] = new Model(anIntArray580[j], 298);

        Model class35_sub2_sub1;
        if (aclass35_sub2_sub1.length == 1)
            class35_sub2_sub1 = aclass35_sub2_sub1[0];
        else
            class35_sub2_sub1 = new Model(false, aclass35_sub2_sub1.length, aclass35_sub2_sub1);
        if (anIntArray587 != null) {
            for (int k = 0; k < anIntArray587.length; k++)
                class35_sub2_sub1.recolor(anIntArray587[k], anIntArray588[k]);

        }
        return class35_sub2_sub1;
    }

    public NpcType() {
        aLong575 = -1L;
        size = 1;
        anInt581 = -1;
        anInt582 = -1;
        anInt583 = -1;
        anInt584 = -1;
        anInt585 = -1;
        aBoolean586 = false;
        anInt590 = -1;
        anInt591 = -1;
        anInt592 = -1;
        aBoolean593 = true;
        anInt594 = -1;
        anInt595 = 128;
        anInt596 = 128;
    }

    public static int anInt570;
    public static int[] anIntArray571;
    public static Buffer aClass35_Sub2_Sub3_572;
    public static NpcType[] aNpcTypeArray573;
    public static int anInt574;
    public long aLong575;
    public String aString576;
    public byte[] aByteArray577;
    public byte size;
    public int[] anIntArray579;
    public int[] anIntArray580;
    public int anInt581;
    public int anInt582;
    public int anInt583;
    public int anInt584;
    public int anInt585;
    public boolean aBoolean586;
    public int[] anIntArray587;
    public int[] anIntArray588;
    public String[] aStringArray589;
    public int anInt590;
    public int anInt591;
    public int anInt592;
    public boolean aBoolean593;
    public int anInt594;
    public int anInt595;
    public int anInt596;
    public static Cache aCache_597 = new Cache(-24094, 30);

}
