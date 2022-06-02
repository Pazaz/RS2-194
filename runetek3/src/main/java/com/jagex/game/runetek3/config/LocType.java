package com.jagex.game.runetek3.config;

// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

import com.jagex.core.io.Buffer;
import com.jagex.core.io.FileArchive;
import com.jagex.core.utils.Cache;
import com.jagex.game.runetek3.graphics.model.Model;

public class LocType {

    public static void decode(FileArchive class36) {
        aClass35_Sub2_Sub3_532 = new Buffer(class36.method417((byte) 6, null, "loc.dat"));
        Buffer class35_sub2_sub3 = new Buffer(class36.method417((byte) 6, null, "loc.idx"));
        anInt530 = class35_sub2_sub3.g2();
        anIntArray531 = new int[anInt530];
        int i = 2;
        for (int j = 0; j < anInt530; j++) {
            anIntArray531[j] = i;
            i += class35_sub2_sub3.g2();
        }

        aLocTypeArray533 = new LocType[10];
        for (int k = 0; k < 10; k++)
            aLocTypeArray533[k] = new LocType();

    }

    public static void method427(int i) {
        aCache_568 = null;
        aCache_569 = null;
        anIntArray531 = null;
        if (i <= 0)
            aBoolean528 = !aBoolean528;
        aLocTypeArray533 = null;
        aClass35_Sub2_Sub3_532 = null;
    }

    public static LocType method428(int i) {
        for (int j = 0; j < 10; j++)
            if (aLocTypeArray533[j].anInt535 == i)
                return aLocTypeArray533[j];

        anInt534 = (anInt534 + 1) % 10;
        LocType class39 = aLocTypeArray533[anInt534];
        aClass35_Sub2_Sub3_532.pos = anIntArray531[i];
        class39.anInt535 = i;
        class39.method429();
        class39.method430(213, aClass35_Sub2_Sub3_532);
        return class39;
    }

    public void method429() {
        anIntArray536 = null;
        anIntArray537 = null;
        aString538 = null;
        aByteArray539 = null;
        anIntArray540 = null;
        anIntArray541 = null;
        anInt542 = 1;
        anInt543 = 1;
        aBoolean544 = true;
        aBoolean545 = true;
        aBoolean546 = false;
        aBoolean547 = false;
        aBoolean548 = false;
        aBoolean549 = false;
        anInt550 = -1;
        anInt551 = 16;
        aByte552 = 0;
        aByte553 = 0;
        aStringArray554 = null;
        aBoolean555 = false;
        anInt556 = -1;
        anInt557 = -1;
        aBoolean558 = false;
        aBoolean559 = true;
        anInt560 = 128;
        anInt561 = 128;
        anInt562 = 128;
        anInt566 = 0;
        anInt563 = 0;
        anInt564 = 0;
        anInt565 = 0;
        aBoolean567 = false;
    }

    public void method430(int i, Buffer class35_sub2_sub3) {
        int j = -1;
        if (i <= 0)
            anInt527 = 167;
        do {
            int k = class35_sub2_sub3.g1();
            if (k == 0)
                break;
            if (k == 1) {
                int l = class35_sub2_sub3.g1();
                anIntArray537 = new int[l];
                anIntArray536 = new int[l];
                for (int j1 = 0; j1 < l; j1++) {
                    anIntArray536[j1] = class35_sub2_sub3.g2();
                    anIntArray537[j1] = class35_sub2_sub3.g1();
                }

            } else if (k == 2)
                aString538 = class35_sub2_sub3.gstr();
            else if (k == 3)
                aByteArray539 = class35_sub2_sub3.gstrbyte();
            else if (k == 14)
                anInt542 = class35_sub2_sub3.g1();
            else if (k == 15)
                anInt543 = class35_sub2_sub3.g1();
            else if (k == 17)
                aBoolean544 = false;
            else if (k == 18)
                aBoolean545 = false;
            else if (k == 19) {
                j = class35_sub2_sub3.g1();
                if (j == 1)
                    aBoolean546 = true;
            } else if (k == 21)
                aBoolean547 = true;
            else if (k == 22)
                aBoolean548 = true;
            else if (k == 23)
                aBoolean549 = true;
            else if (k == 24) {
                anInt550 = class35_sub2_sub3.g2();
                if (anInt550 == 65535)
                    anInt550 = -1;
            } else if (k == 25)
                aBoolean555 = true;
            else if (k == 28)
                anInt551 = class35_sub2_sub3.g1();
            else if (k == 29)
                aByte552 = class35_sub2_sub3.g1b();
            else if (k == 39)
                aByte553 = class35_sub2_sub3.g1b();
            else if (k >= 30 && k < 39) {
                if (aStringArray554 == null)
                    aStringArray554 = new String[5];
                aStringArray554[k - 30] = class35_sub2_sub3.gstr();
            } else if (k == 40) {
                int i1 = class35_sub2_sub3.g1();
                anIntArray540 = new int[i1];
                anIntArray541 = new int[i1];
                for (int k1 = 0; k1 < i1; k1++) {
                    anIntArray540[k1] = class35_sub2_sub3.g2();
                    anIntArray541[k1] = class35_sub2_sub3.g2();
                }

            } else if (k == 60)
                anInt556 = class35_sub2_sub3.g2();
            else if (k == 62)
                aBoolean558 = true;
            else if (k == 64)
                aBoolean559 = false;
            else if (k == 65)
                anInt560 = class35_sub2_sub3.g2();
            else if (k == 66)
                anInt561 = class35_sub2_sub3.g2();
            else if (k == 67)
                anInt562 = class35_sub2_sub3.g2();
            else if (k == 68)
                anInt557 = class35_sub2_sub3.g2();
            else if (k == 69)
                anInt566 = class35_sub2_sub3.g1();
            else if (k == 70)
                anInt563 = class35_sub2_sub3.g2b();
            else if (k == 71)
                anInt564 = class35_sub2_sub3.g2b();
            else if (k == 72)
                anInt565 = class35_sub2_sub3.g2b();
            else if (k == 73)
                aBoolean567 = true;
        } while (true);
        if (anIntArray537 == null)
            anIntArray537 = new int[0];
        if (j == -1) {
            aBoolean546 = anIntArray537.length > 0 && anIntArray537[0] == 10;
            if (aStringArray554 != null)
                aBoolean546 = true;
        }
    }

    public Model method431(int i, int j, int k, int l, int i1, int j1, int k1) {
        int l1 = -1;
        for (int i2 = 0; i2 < anIntArray537.length; i2++) {
            if (anIntArray537[i2] != i)
                continue;
            l1 = i2;
            break;
        }

        if (l1 == -1)
            return null;
        long l2 = (long) ((anInt535 << 6) + (l1 << 3) + j) + ((long) (k1 + 1) << 32);
        if (aBoolean529)
            l2 = 0L;
        if (!aBoolean547 && !aBoolean548) {
            Model class35_sub2_sub1 = (Model) aCache_569.method295(l2);
            if (class35_sub2_sub1 != null)
                return class35_sub2_sub1;
        }
        if (l1 >= anIntArray536.length)
            return null;
        int j2 = anIntArray536[l1];
        if (j2 == -1)
            return null;
        boolean flag = aBoolean558 ^ (j > 3);
        if (flag)
            j2 += 0x10000;
        Model class35_sub2_sub1_1 = (Model) aCache_568.method295(j2);
        if (class35_sub2_sub1_1 == null) {
            class35_sub2_sub1_1 = new Model(j2 & 0xffff, 298);
            if (flag)
                class35_sub2_sub1_1.method318(-25737);
            aCache_568.method296(j2, 7, class35_sub2_sub1_1);
        }
        boolean flag1;
        flag1 = anInt560 != 128 || anInt561 != 128 || anInt562 != 128;
        boolean flag2;
        flag2 = anInt563 != 0 || anInt564 != 0 || anInt565 != 0;
        Model class35_sub2_sub1_2 = new Model(-428, !aBoolean548, class35_sub2_sub1_1, anIntArray540 == null, j == 0 && !aBoolean547 && k1 == -1 && !flag1 && !flag2, !aBoolean555);
        if (k1 != -1) {
            class35_sub2_sub1_2.method310((byte) 3);
            class35_sub2_sub1_2.applyFrame(7, k1);
            class35_sub2_sub1_2.anIntArrayArray1084 = null;
            class35_sub2_sub1_2.anIntArrayArray1083 = null;
        }
        while (j-- > 0)
            class35_sub2_sub1_2.method314((byte) 0);
        if (anIntArray540 != null) {
            for (int k2 = 0; k2 < anIntArray540.length; k2++)
                class35_sub2_sub1_2.method317(anIntArray540[k2], anIntArray541[k2]);

        }
        if (flag1)
            class35_sub2_sub1_2.method319(728, anInt560, anInt561, anInt562);
        if (aBoolean547) {
            int i3 = (k + l + i1 + j1) / 4;
            for (int j3 = 0; j3 < class35_sub2_sub1_2.anInt1051; j3++) {
                int k3 = class35_sub2_sub1_2.anIntArray1052[j3];
                int l3 = class35_sub2_sub1_2.anIntArray1054[j3];
                int i4 = k + ((l - k) * (k3 + 64)) / 128;
                int j4 = j1 + ((i1 - j1) * (k3 + 64)) / 128;
                int k4 = i4 + ((j4 - i4) * (l3 + 64)) / 128;
                class35_sub2_sub1_2.anIntArray1053[j3] += k4 - i3;
            }

        }
        if (flag2)
            class35_sub2_sub1_2.method316(anInt565, 0, anInt563, anInt564);
        class35_sub2_sub1_2.method320(64 + aByte552, 768 + aByte553 * 5, -50, -10, -50, !aBoolean548);
        if (aBoolean544)
            class35_sub2_sub1_2.anInt1080 = class35_sub2_sub1_2.anInt1076;
        if (!aBoolean547 && !aBoolean548)
            aCache_569.method296(l2, 7, class35_sub2_sub1_2);
        return class35_sub2_sub1_2;
    }

    public LocType() {
        anInt535 = -1;
    }

    public static int anInt527 = -494;
    public static boolean aBoolean528 = true;
    public static boolean aBoolean529;
    public static int anInt530;
    public static int[] anIntArray531;
    public static Buffer aClass35_Sub2_Sub3_532;
    public static LocType[] aLocTypeArray533;
    public static int anInt534;
    public int anInt535;
    public int[] anIntArray536;
    public int[] anIntArray537;
    public String aString538;
    public byte[] aByteArray539;
    public int[] anIntArray540;
    public int[] anIntArray541;
    public int anInt542;
    public int anInt543;
    public boolean aBoolean544;
    public boolean aBoolean545;
    public boolean aBoolean546;
    public boolean aBoolean547;
    public boolean aBoolean548;
    public boolean aBoolean549;
    public int anInt550;
    public int anInt551;
    public byte aByte552;
    public byte aByte553;
    public String[] aStringArray554;
    public boolean aBoolean555;
    public int anInt556;
    public int anInt557;
    public boolean aBoolean558;
    public boolean aBoolean559;
    public int anInt560;
    public int anInt561;
    public int anInt562;
    public int anInt563;
    public int anInt564;
    public int anInt565;
    public int anInt566;
    public boolean aBoolean567;
    public static Cache aCache_568 = new Cache(-24094, 500);
    public static Cache aCache_569 = new Cache(-24094, 30);

}
