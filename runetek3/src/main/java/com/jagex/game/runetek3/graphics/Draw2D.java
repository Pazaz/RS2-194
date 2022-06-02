package com.jagex.game.runetek3.graphics;

// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

import com.jagex.core.utils.CacheableNode;

public class Draw2D extends CacheableNode {

    public static void method329(int i, int[] ai, int j, int k) {
        while (k >= 0)
            aBoolean1136 = !aBoolean1136;
        anIntArray1137 = ai;
        anInt1138 = i;
        anInt1139 = j;
        method331(j, i, 0, 0, 17913);
    }

    public static void method330(int i) {
        anInt1142 = 0;
        if (i >= 0)
            aBoolean1136 = !aBoolean1136;
        anInt1140 = 0;
        anInt1143 = anInt1138;
        anInt1141 = anInt1139;
        anInt1144 = anInt1143 - 1;
        anInt1145 = anInt1143 / 2;
    }

    public static void method331(int i, int j, int k, int l, int i1) {
        if (l < 0)
            l = 0;
        if (k < 0)
            k = 0;
        if (j > anInt1138)
            j = anInt1138;
        if (i > anInt1139)
            i = anInt1139;
        anInt1142 = l;
        anInt1140 = k;
        anInt1143 = j;
        anInt1141 = i;
        anInt1144 = anInt1143 - 1;
        if (i1 != 17913)
            anInt1135 = 337;
        anInt1145 = anInt1143 / 2;
        anInt1146 = anInt1141 / 2;
    }

    public static void method332(int i) {
        int j = anInt1138 * anInt1139;
        if (i != 2)
            return;
        for (int k = 0; k < j; k++)
            anIntArray1137[k] = 0;

    }

    public static void method333(int i, int j, int k, int l, int i1, int j1) {
        if (j1 < anInt1142) {
            i1 -= anInt1142 - j1;
            j1 = anInt1142;
        }
        if (l < anInt1140) {
            k -= anInt1140 - l;
            l = anInt1140;
        }
        if (j1 + i1 > anInt1143)
            i1 = anInt1143 - j1;
        if (l + k > anInt1141)
            k = anInt1141 - l;
        int k1 = anInt1138 - i1;
        int l1 = j1 + l * anInt1138;
        for (int i2 = -k; i2 < 0; i2++) {
            for (int j2 = -i1; j2 < 0; j2++)
                anIntArray1137[l1++] = i;

            l1 += k1;
        }

        while (j >= 0)
            return;
    }

    public static void method334(int i, int j, int k, int l, int i1, int j1) {
        if (k != 0) {
            for (int k1 = 1; k1 > 0; k1++) ;
        }
        method335(l, false, j1, j, i);
        method335(l, false, j1, (j + i1) - 1, i);
        method336(31405, i, j, j1, i1);
        method336(31405, i, j, (j1 + l) - 1, i1);
    }

    public static void method335(int i, boolean flag, int j, int k, int l) {
        if (k < anInt1140 || k >= anInt1141)
            return;
        if (j < anInt1142) {
            i -= anInt1142 - j;
            j = anInt1142;
        }
        if (j + i > anInt1143)
            i = anInt1143 - j;
        int i1 = j + k * anInt1138;
        if (flag)
            anInt1135 = 195;
        for (int j1 = 0; j1 < i; j1++)
            anIntArray1137[i1 + j1] = l;

    }

    public static void method336(int i, int j, int k, int l, int i1) {
        if (i != 31405)
            return;
        if (l < anInt1142 || l >= anInt1143)
            return;
        if (k < anInt1140) {
            i1 -= anInt1140 - k;
            k = anInt1140;
        }
        if (k + i1 > anInt1141)
            i1 = anInt1141 - k;
        int j1 = l + k * anInt1138;
        for (int k1 = 0; k1 < i1; k1++)
            anIntArray1137[j1 + k1 * anInt1138] = j;

    }

    public Draw2D() {
    }

    public static int anInt1134 = -222;
    public static int anInt1135 = 553;
    public static boolean aBoolean1136 = true;
    public static int[] anIntArray1137;
    public static int anInt1138;
    public static int anInt1139;
    public static int anInt1140;
    public static int anInt1141;
    public static int anInt1142;
    public static int anInt1143;
    public static int anInt1144;
    public static int anInt1145;
    public static int anInt1146;
    public static boolean aBoolean1147;

}
