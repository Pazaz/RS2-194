package com.jagex.game.runetek3.client;

// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

import com.jagex.core.io.Buffer;

public class InputTracking {

    public static void method159(int i) {
        aClass35_Sub2_Sub3_104 = Buffer.reserve(1);
        aLong106 = System.currentTimeMillis();
        if (i >= 0)
            anInt101 = -286;
        aBoolean103 = true;
    }

    public static void method160(int i) {
        if (i < 6 || i > 6) {
            return;
        } else {
            aBoolean103 = false;
            return;
        }
    }

    public static Buffer method161(int i) {
        Buffer class35_sub2_sub3;
        for (class35_sub2_sub3 = null; i >= 0; )
            throw new NullPointerException();

        if (aClass35_Sub2_Sub3_105 != null) {
            class35_sub2_sub3 = aClass35_Sub2_Sub3_105;
            aClass35_Sub2_Sub3_105 = null;
        }
        return class35_sub2_sub3;
    }

    public static void method162(int i, byte byte0, int j) {
        if (j < 0 || j >= 789 || i < 0 || i >= 532)
            return;
        int k = method171(34564);
        method172(-178, 5);
        aClass35_Sub2_Sub3_104.p1(1);
        if (byte0 != -58) {
            for (int l = 1; l > 0; l++) ;
        }
        aClass35_Sub2_Sub3_104.p1(k);
        aClass35_Sub2_Sub3_104.p3(j + (i << 10));
    }

    public static void method163(boolean flag) {
        int i = method171(34564);
        method172(-178, 2);
        if (!flag)
            anInt101 = -325;
        aClass35_Sub2_Sub3_104.p1(3);
        aClass35_Sub2_Sub3_104.p1(i);
    }

    public static void method164(boolean flag, int i, int j) {
        if (!flag)
            anInt102 = 142;
        if (j < 0 || j >= 789 || i < 0 || i >= 532)
            return;
        int k = method171(34564);
        if (anInt107 - j < 8 && anInt107 - j >= -8 && anInt108 - i < 8 && anInt108 - i >= -8) {
            method172(-178, 3);
            aClass35_Sub2_Sub3_104.p1(5);
            aClass35_Sub2_Sub3_104.p1(k);
            aClass35_Sub2_Sub3_104.p1((anInt107 - j) + 8 + ((anInt108 - i) + 8 << 4));
            return;
        }
        if (anInt107 - j < 128 && anInt107 - j >= -128 && anInt108 - i < 128 && anInt108 - i >= -128) {
            method172(-178, 4);
            aClass35_Sub2_Sub3_104.p1(6);
            aClass35_Sub2_Sub3_104.p1(k);
            aClass35_Sub2_Sub3_104.p1((anInt107 - j) + 128);
            aClass35_Sub2_Sub3_104.p1((anInt108 - i) + 128);
            return;
        } else {
            method172(-178, 5);
            aClass35_Sub2_Sub3_104.p1(7);
            aClass35_Sub2_Sub3_104.p1(k);
            aClass35_Sub2_Sub3_104.p3(j + (i << 10));
            return;
        }
    }

    public static void method165(int i, boolean flag) {
        int j = method171(34564);
        if (i == 1000)
            i = 11;
        if (i == 1001)
            i = 12;
        if (i == 1002)
            i = 14;
        if (i == 1003)
            i = 15;
        if (i >= 1008)
            i -= 992;
        method172(-178, 3);
        if (!flag) {
            return;
        } else {
            aClass35_Sub2_Sub3_104.p1(8);
            aClass35_Sub2_Sub3_104.p1(j);
            aClass35_Sub2_Sub3_104.p1(i);
            return;
        }
    }

    public static void method166(byte byte0, int i) {
        int j = method171(34564);
        if (i == 1000)
            i = 11;
        if (i == 1001)
            i = 12;
        if (i == 1002)
            i = 14;
        if (i == 1003)
            i = 15;
        if (i >= 1008)
            i -= 992;
        method172(-178, 3);
        if (byte0 != -63) {
            return;
        } else {
            aClass35_Sub2_Sub3_104.p1(9);
            aClass35_Sub2_Sub3_104.p1(j);
            aClass35_Sub2_Sub3_104.p1(i);
            return;
        }
    }

    public static void method167(boolean flag) {
        int i = method171(34564);
        method172(-178, 2);
        aClass35_Sub2_Sub3_104.p1(10);
        if (flag)
            aBoolean100 = !aBoolean100;
        aClass35_Sub2_Sub3_104.p1(i);
    }

    public static void method168(byte byte0) {
        if (byte0 == 9)
            byte0 = 0;
        else
            anInt101 = 107;
        int i = method171(34564);
        method172(-178, 2);
        aClass35_Sub2_Sub3_104.p1(11);
        aClass35_Sub2_Sub3_104.p1(i);
    }

    public static void method169(int i) {
        if (i >= 0) {
            return;
        } else {
            int j = method171(34564);
            method172(-178, 2);
            aClass35_Sub2_Sub3_104.p1(12);
            aClass35_Sub2_Sub3_104.p1(j);
            return;
        }
    }

    public static void method170(byte byte0) {
        int i = method171(34564);
        method172(-178, 2);
        if (byte0 != 66)
            anInt102 = -423;
        aClass35_Sub2_Sub3_104.p1(13);
        aClass35_Sub2_Sub3_104.p1(i);
    }

    public static int method171(int i) {
        long l = System.currentTimeMillis();
        if (i != 34564)
            anInt102 = 454;
        long l1 = (l - aLong106) / 10L;
        if (l1 > 250L)
            l1 = 250L;
        aLong106 = l;
        return (int) l1;
    }

    public static void method172(int i, int j) {
        while (i >= 0)
            return;
        if (aClass35_Sub2_Sub3_104.pos + j >= 500) {
            Buffer class35_sub2_sub3 = aClass35_Sub2_Sub3_104;
            aClass35_Sub2_Sub3_104 = Buffer.reserve(1);
            aClass35_Sub2_Sub3_105 = class35_sub2_sub3;
        }
    }

    public static boolean aBoolean100;
    public static int anInt101 = -992;
    public static int anInt102;
    public static boolean aBoolean103;
    public static Buffer aClass35_Sub2_Sub3_104 = null;
    public static Buffer aClass35_Sub2_Sub3_105 = null;
    public static long aLong106;
    public static int anInt107;
    public static int anInt108;

}
