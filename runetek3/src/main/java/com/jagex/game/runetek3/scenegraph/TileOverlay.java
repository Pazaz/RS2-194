package com.jagex.game.runetek3.scenegraph;

// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

public class TileOverlay {

    public TileOverlay(int i, int j, int k, int l, int i1, int j1, int k1,
                       int l1, int i2, int j2, int k2, int l2, int i3, int j3,
                       int k3, int l3, int i4, int j4, int k4, int l4) {
        aBoolean230 = i2 == l2 && i2 == l4 && i2 == k3;
        anInt231 = k;
        anInt232 = k1;
        anInt233 = j3;
        anInt234 = j1;
        char c = '\200';
        int i5 = c / 2;
        int j5 = c / 4;
        int k5 = (c * 3) / 4;
        int[] ai = anIntArrayArray243[k];
        int l5 = ai.length;
        anIntArray220 = new int[l5];
        anIntArray221 = new int[l5];
        anIntArray222 = new int[l5];
        int[] ai1 = new int[l5];
        int[] ai2 = new int[l5];
        int i6 = j2 * c;
        int j6 = i1 * c;
        for (int k6 = 0; k6 < l5; k6++) {
            int l6 = ai[k6];
            if ((l6 & 1) == 0 && l6 <= 8)
                l6 = (l6 - k1 - k1 - 1 & 7) + 1;
            if (l6 > 8 && l6 <= 12)
                l6 = (l6 - 9 - k1 & 3) + 9;
            if (l6 > 12 && l6 <= 16)
                l6 = (l6 - 13 - k1 & 3) + 13;
            int i7;
            int k7;
            int i8;
            int k8;
            int j9;
            if (l6 == 1) {
                i7 = i6;
                k7 = j6;
                i8 = i2;
                k8 = i;
                j9 = l3;
            } else if (l6 == 2) {
                i7 = i6 + i5;
                k7 = j6;
                i8 = i2 + l2 >> 1;
                k8 = i + l1 >> 1;
                j9 = l3 + k2 >> 1;
            } else if (l6 == 3) {
                i7 = i6 + c;
                k7 = j6;
                i8 = l2;
                k8 = l1;
                j9 = k2;
            } else if (l6 == 4) {
                i7 = i6 + c;
                k7 = j6 + i5;
                i8 = l2 + l4 >> 1;
                k8 = l1 + i4 >> 1;
                j9 = k2 + j >> 1;
            } else if (l6 == 5) {
                i7 = i6 + c;
                k7 = j6 + c;
                i8 = l4;
                k8 = i4;
                j9 = j;
            } else if (l6 == 6) {
                i7 = i6 + i5;
                k7 = j6 + c;
                i8 = l4 + k3 >> 1;
                k8 = i4 + i3 >> 1;
                j9 = j + j4 >> 1;
            } else if (l6 == 7) {
                i7 = i6;
                k7 = j6 + c;
                i8 = k3;
                k8 = i3;
                j9 = j4;
            } else if (l6 == 8) {
                i7 = i6;
                k7 = j6 + i5;
                i8 = k3 + i2 >> 1;
                k8 = i3 + i >> 1;
                j9 = j4 + l3 >> 1;
            } else if (l6 == 9) {
                i7 = i6 + i5;
                k7 = j6 + j5;
                i8 = i2 + l2 >> 1;
                k8 = i + l1 >> 1;
                j9 = l3 + k2 >> 1;
            } else if (l6 == 10) {
                i7 = i6 + k5;
                k7 = j6 + i5;
                i8 = l2 + l4 >> 1;
                k8 = l1 + i4 >> 1;
                j9 = k2 + j >> 1;
            } else if (l6 == 11) {
                i7 = i6 + i5;
                k7 = j6 + k5;
                i8 = l4 + k3 >> 1;
                k8 = i4 + i3 >> 1;
                j9 = j + j4 >> 1;
            } else if (l6 == 12) {
                i7 = i6 + j5;
                k7 = j6 + i5;
                i8 = k3 + i2 >> 1;
                k8 = i3 + i >> 1;
                j9 = j4 + l3 >> 1;
            } else if (l6 == 13) {
                i7 = i6 + j5;
                k7 = j6 + j5;
                i8 = i2;
                k8 = i;
                j9 = l3;
            } else if (l6 == 14) {
                i7 = i6 + k5;
                k7 = j6 + j5;
                i8 = l2;
                k8 = l1;
                j9 = k2;
            } else if (l6 == 15) {
                i7 = i6 + k5;
                k7 = j6 + k5;
                i8 = l4;
                k8 = i4;
                j9 = j;
            } else {
                i7 = i6 + j5;
                k7 = j6 + k5;
                i8 = k3;
                k8 = i3;
                j9 = j4;
            }
            anIntArray220[k6] = i7;
            anIntArray221[k6] = i8;
            anIntArray222[k6] = k7;
            ai1[k6] = k8;
            ai2[k6] = j9;
        }

        int[] ai3 = anIntArrayArray244[k];
        int j7 = ai3.length / 4;
        anIntArray226 = new int[j7];
        anIntArray227 = new int[j7];
        anIntArray228 = new int[j7];
        anIntArray223 = new int[j7];
        anIntArray224 = new int[j7];
        if (l != 0)
            throw new NullPointerException();
        anIntArray225 = new int[j7];
        if (k4 != -1)
            anIntArray229 = new int[j7];
        int l7 = 0;
        for (int j8 = 0; j8 < j7; j8++) {
            int l8 = ai3[l7];
            int k9 = ai3[l7 + 1];
            int i10 = ai3[l7 + 2];
            int j10 = ai3[l7 + 3];
            l7 += 4;
            if (k9 < 4)
                k9 = k9 - k1 & 3;
            if (i10 < 4)
                i10 = i10 - k1 & 3;
            if (j10 < 4)
                j10 = j10 - k1 & 3;
            anIntArray226[j8] = k9;
            anIntArray227[j8] = i10;
            anIntArray228[j8] = j10;
            if (l8 == 0) {
                anIntArray223[j8] = ai1[k9];
                anIntArray224[j8] = ai1[i10];
                anIntArray225[j8] = ai1[j10];
                if (anIntArray229 != null)
                    anIntArray229[j8] = -1;
            } else {
                anIntArray223[j8] = ai2[k9];
                anIntArray224[j8] = ai2[i10];
                anIntArray225[j8] = ai2[j10];
                if (anIntArray229 != null)
                    anIntArray229[j8] = k4;
            }
        }

        int i9 = i2;
        int l9 = l2;
        if (l2 < i9)
            i9 = l2;
        if (l2 > l9)
            l9 = l2;
        if (l4 < i9)
            i9 = l4;
        if (l4 > l9)
            l9 = l4;
        if (k3 < i9)
            i9 = k3;
        if (k3 > l9)
            l9 = k3;
        i9 /= 14;
        l9 /= 14;
    }

    public int[] anIntArray220;
    public int[] anIntArray221;
    public int[] anIntArray222;
    public int[] anIntArray223;
    public int[] anIntArray224;
    public int[] anIntArray225;
    public int[] anIntArray226;
    public int[] anIntArray227;
    public int[] anIntArray228;
    public int[] anIntArray229;
    public boolean aBoolean230;
    public int anInt231;
    public int anInt232;
    public int anInt233;
    public int anInt234;
    public static int[] anIntArray235 = new int[6];
    public static int[] anIntArray236 = new int[6];
    public static int[] anIntArray237 = new int[6];
    public static int[] anIntArray238 = new int[6];
    public static int[] anIntArray239 = new int[6];
    public static int[] anIntArray240 = {
            1, 0
    };
    public static int[] anIntArray241 = {
            2, 1
    };
    public static int[] anIntArray242 = {
            3, 3
    };
    public static final int[][] anIntArrayArray243 = {
            {
                    1, 3, 5, 7
            }, {
            1, 3, 5, 7
    }, {
            1, 3, 5, 7
    }, {
            1, 3, 5, 7, 6
    }, {
            1, 3, 5, 7, 6
    }, {
            1, 3, 5, 7, 6
    }, {
            1, 3, 5, 7, 6
    }, {
            1, 3, 5, 7, 2, 6
    }, {
            1, 3, 5, 7, 2, 8
    }, {
            1, 3, 5, 7, 2, 8
    }, {
            1, 3, 5, 7, 11, 12
    }, {
            1, 3, 5, 7, 11, 12
    }, {
            1, 3, 5, 7, 13, 14
    }
    };
    public static final int[][] anIntArrayArray244 = {
            {
                    0, 1, 2, 3, 0, 0, 1, 3
            }, {
            1, 1, 2, 3, 1, 0, 1, 3
    }, {
            0, 1, 2, 3, 1, 0, 1, 3
    }, {
            0, 0, 1, 2, 0, 0, 2, 4, 1, 0,
            4, 3
    }, {
            0, 0, 1, 4, 0, 0, 4, 3, 1, 1,
            2, 4
    }, {
            0, 0, 4, 3, 1, 0, 1, 2, 1, 0,
            2, 4
    }, {
            0, 1, 2, 4, 1, 0, 1, 4, 1, 0,
            4, 3
    }, {
            0, 4, 1, 2, 0, 4, 2, 5, 1, 0,
            4, 5, 1, 0, 5, 3
    }, {
            0, 4, 1, 2, 0, 4, 2, 3, 0, 4,
            3, 5, 1, 0, 4, 5
    }, {
            0, 0, 4, 5, 1, 4, 1, 2, 1, 4,
            2, 3, 1, 4, 3, 5
    }, {
            0, 0, 1, 5, 0, 1, 4, 5, 0, 1,
            2, 4, 1, 0, 5, 3, 1, 5, 4, 3,
            1, 4, 2, 3
    }, {
            1, 0, 1, 5, 1, 1, 4, 5, 1, 1,
            2, 4, 0, 0, 5, 3, 0, 5, 4, 3,
            0, 4, 2, 3
    }, {
            1, 0, 5, 4, 1, 0, 1, 5, 0, 0,
            4, 3, 0, 4, 5, 3, 0, 5, 2, 3,
            0, 1, 2, 5
    }
    };

}
