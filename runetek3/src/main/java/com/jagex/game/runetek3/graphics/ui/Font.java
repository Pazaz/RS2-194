package com.jagex.game.runetek3.graphics.ui;

// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

import com.jagex.core.io.Buffer;
import com.jagex.core.io.FileArchive;
import com.jagex.game.runetek3.graphics.Draw2D;

public class Font extends Draw2D {

    public Font(FileArchive class36, String s) {
        anInt1312 = -886;
        aBoolean1313 = false;
        aByteArrayArray1314 = new byte[94][];
        anIntArray1315 = new int[94];
        anIntArray1316 = new int[94];
        anIntArray1317 = new int[94];
        anIntArray1318 = new int[94];
        anIntArray1319 = new int[95];
        anIntArray1320 = new int[256];
        Buffer class35_sub2_sub3 = new Buffer(class36.read(null, s + ".dat"));
        Buffer class35_sub2_sub3_1 = new Buffer(class36.read(null, "index.dat"));
        class35_sub2_sub3_1.pos = class35_sub2_sub3.g2() + 4;
        int i = class35_sub2_sub3_1.g1();
        if (i > 0)
            class35_sub2_sub3_1.pos += 3 * (i - 1);
        for (int j = 0; j < 94; j++) {
            anIntArray1317[j] = class35_sub2_sub3_1.g1();
            anIntArray1318[j] = class35_sub2_sub3_1.g1();
            int k = anIntArray1315[j] = class35_sub2_sub3_1.g2();
            int i1 = anIntArray1316[j] = class35_sub2_sub3_1.g2();
            int j1 = class35_sub2_sub3_1.g1();
            int k1 = k * i1;
            aByteArrayArray1314[j] = new byte[k1];
            if (j1 == 0) {
                for (int l1 = 0; l1 < k1; l1++)
                    aByteArrayArray1314[j][l1] = class35_sub2_sub3.g1b();

            } else if (j1 == 1) {
                for (int i2 = 0; i2 < k; i2++) {
                    for (int k2 = 0; k2 < i1; k2++)
                        aByteArrayArray1314[j][i2 + k2 * k] = class35_sub2_sub3.g1b();

                }

            }
            if (i1 > anInt1321)
                anInt1321 = i1;
            anIntArray1317[j] = 1;
            anIntArray1319[j] = k + 2;
            int j2 = 0;
            for (int l2 = i1 / 7; l2 < i1; l2++)
                j2 += aByteArrayArray1314[j][l2 * k];

            if (j2 <= i1 / 7) {
                anIntArray1319[j]--;
                anIntArray1317[j] = 0;
            }
            j2 = 0;
            for (int i3 = i1 / 7; i3 < i1; i3++)
                j2 += aByteArrayArray1314[j][(k - 1) + i3 * k];

            if (j2 <= i1 / 7)
                anIntArray1319[j]--;
        }

        anIntArray1319[94] = anIntArray1319[8];
        for (int l = 0; l < 256; l++)
            anIntArray1320[l] = anIntArray1319[anIntArray1322[l]];

    }

    public void method370(boolean flag, int i, int j, int k, String s) {
        if (!flag)
            aBoolean1313 = !aBoolean1313;
        method373(s, k - method372(s, true) / 2, j, true, i);
    }

    public void method371(int i, int j, int k, String s, int l, boolean flag) {
        if (l != 26631) {
            for (int i1 = 1; i1 > 0; i1++) ;
        }
        method375(-886, flag, j - method372(s, true) / 2, k, i, s);
    }

    public int method372(String s, boolean flag) {
        if (!flag)
            return 1;
        if (s == null)
            return 0;
        int i = 0;
        for (int j = 0; j < s.length(); j++)
            if (s.charAt(j) == '@' && j + 4 < s.length() && s.charAt(j + 4) == '@')
                j += 4;
            else
                i += anIntArray1320[s.charAt(j)];

        return i;
    }

    public void method373(String s, int i, int j, boolean flag, int k) {
        if (s == null)
            return;
        k -= anInt1321;
        for (int l = 0; l < s.length(); l++) {
            int i1 = anIntArray1322[s.charAt(l)];
            if (i1 != 94)
                method376(aByteArrayArray1314[i1], i + anIntArray1317[i1], k + anIntArray1318[i1], anIntArray1315[i1], anIntArray1316[i1], j);
            i += anIntArray1319[i1];
        }

        if (flag) ;
    }

    public void method374(int i, int j, int k, String s, int l, int i1) {
        if (i < 9 || i > 9)
            anInt1312 = 32;
        if (s == null)
            return;
        i1 -= method372(s, true) / 2;
        j -= anInt1321;
        for (int j1 = 0; j1 < s.length(); j1++) {
            int k1 = anIntArray1322[s.charAt(j1)];
            if (k1 != 94)
                method376(aByteArrayArray1314[k1], i1 + anIntArray1317[k1], j + anIntArray1318[k1] + (int) (Math.sin((double) j1 / 2D + (double) l / 5D) * 5D), anIntArray1315[k1], anIntArray1316[k1], k);
            i1 += anIntArray1319[k1];
        }

    }

    public void method375(int i, boolean flag, int j, int k, int l, String s) {
        while (i >= 0) {
            for (int i1 = 1; i1 > 0; i1++) ;
        }
        if (s == null)
            return;
        l -= anInt1321;
        for (int j1 = 0; j1 < s.length(); j1++)
            if (s.charAt(j1) == '@' && j1 + 4 < s.length() && s.charAt(j1 + 4) == '@') {
                String s1 = s.substring(j1 + 1, j1 + 4);
                if (s1.equals("red"))
                    k = 0xff0000;
                if (s1.equals("gre"))
                    k = 65280;
                if (s1.equals("blu"))
                    k = 255;
                if (s1.equals("yel"))
                    k = 0xffff00;
                if (s1.equals("cya"))
                    k = 65535;
                if (s1.equals("mag"))
                    k = 0xff00ff;
                if (s1.equals("whi"))
                    k = 0xffffff;
                if (s1.equals("bla"))
                    k = 0;
                if (s1.equals("lre"))
                    k = 0xff9040;
                if (s1.equals("dre"))
                    k = 0x800000;
                if (s1.equals("dbl"))
                    k = 128;
                if (s1.equals("or1"))
                    k = 0xffb000;
                if (s1.equals("or2"))
                    k = 0xff7000;
                if (s1.equals("or3"))
                    k = 0xff3000;
                if (s1.equals("gr1"))
                    k = 0xc0ff00;
                if (s1.equals("gr2"))
                    k = 0x80ff00;
                if (s1.equals("gr3"))
                    k = 0x40ff00;
                j1 += 4;
            } else {
                int k1 = anIntArray1322[s.charAt(j1)];
                if (k1 != 94) {
                    if (flag)
                        method376(aByteArrayArray1314[k1], j + anIntArray1317[k1] + 1, l + anIntArray1318[k1] + 1, anIntArray1315[k1], anIntArray1316[k1], 0);
                    method376(aByteArrayArray1314[k1], j + anIntArray1317[k1], l + anIntArray1318[k1], anIntArray1315[k1], anIntArray1316[k1], k);
                }
                j += anIntArray1319[k1];
            }

    }

    public void method376(byte[] abyte0, int i, int j, int k, int l, int i1) {
        int j1 = i + j * Draw2D.width;
        int k1 = Draw2D.width - k;
        int l1 = 0;
        int i2 = 0;
        if (j < Draw2D.top) {
            int j2 = Draw2D.top - j;
            l -= j2;
            j = Draw2D.top;
            i2 += j2 * k;
            j1 += j2 * Draw2D.width;
        }
        if (j + l >= Draw2D.bottom)
            l -= ((j + l) - Draw2D.bottom) + 1;
        if (i < Draw2D.left) {
            int k2 = Draw2D.left - i;
            k -= k2;
            i = Draw2D.left;
            i2 += k2;
            j1 += k2;
            l1 += k2;
            k1 += k2;
        }
        if (i + k >= Draw2D.right) {
            int l2 = ((i + k) - Draw2D.right) + 1;
            k -= l2;
            l1 += l2;
            k1 += l2;
        }
        if (k <= 0 || l <= 0) {
            return;
        } else {
            method377(Draw2D.data, abyte0, i1, i2, j1, k, l, k1, l1);
            return;
        }
    }

    public void method377(int[] ai, byte[] abyte0, int i, int j, int k, int l, int i1,
                          int j1, int k1) {
        int l1 = -(l >> 2);
        l = -(l & 3);
        for (int i2 = -i1; i2 < 0; i2++) {
            for (int j2 = l1; j2 < 0; j2++) {
                if (abyte0[j++] != 0)
                    ai[k++] = i;
                else
                    k++;
                if (abyte0[j++] != 0)
                    ai[k++] = i;
                else
                    k++;
                if (abyte0[j++] != 0)
                    ai[k++] = i;
                else
                    k++;
                if (abyte0[j++] != 0)
                    ai[k++] = i;
                else
                    k++;
            }

            for (int k2 = l; k2 < 0; k2++)
                if (abyte0[j++] != 0)
                    ai[k++] = i;
                else
                    k++;

            k += j1;
            j += k1;
        }

    }

    public int anInt1312;
    public boolean aBoolean1313;
    public byte[][] aByteArrayArray1314;
    public int[] anIntArray1315;
    public int[] anIntArray1316;
    public int[] anIntArray1317;
    public int[] anIntArray1318;
    public int[] anIntArray1319;
    public int[] anIntArray1320;
    public int anInt1321;
    public static int[] anIntArray1322;

    static {
        anIntArray1322 = new int[256];
        String s = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"\243$%^&*()-_=+[{]};:'@#~,<.>/?\\| ";
        for (int i = 0; i < 256; i++) {
            int j = s.indexOf(i);
            if (j == -1)
                j = 74;
            anIntArray1322[i] = j;
        }

    }
}
