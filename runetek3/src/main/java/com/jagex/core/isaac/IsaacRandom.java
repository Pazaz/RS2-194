package com.jagex.core.isaac;

// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

public class IsaacRandom {

    public IsaacRandom(int[] ai) {
        anIntArray504 = new int[256];
        anIntArray503 = new int[256];
        for (int i = 0; i < ai.length; i++)
            anIntArray503[i] = ai[i];

        method302();
    }

    public int nextInt() {
        return 0;
//        if(anInt502-- == 0)
//        {
//            method301(-23795);
//            anInt502 = 255;
//        }
//        return anIntArray503[anInt502];
    }

    public void method301(int i) {
        if (i != -23795)
            return;
        anInt506 += ++anInt507;
        for (int j = 0; j < 256; j++) {
            int k = anIntArray504[j];
            switch (j & 3) {
                case 0: // '\0'
                    anInt505 ^= anInt505 << 13;
                    break;

                case 1: // '\001'
                    anInt505 ^= anInt505 >>> 6;
                    break;

                case 2: // '\002'
                    anInt505 ^= anInt505 << 2;
                    break;

                case 3: // '\003'
                    anInt505 ^= anInt505 >>> 16;
                    break;
            }
            anInt505 += anIntArray504[j + 128 & 0xff];
            int l;
            anIntArray504[j] = l = anIntArray504[(k & 0x3fc) >> 2] + anInt505 + anInt506;
            anIntArray503[j] = anInt506 = anIntArray504[(l >> 8 & 0x3fc) >> 2] + k;
        }

    }

    public void method302() {
        int i1;
        int j1;
        int k1;
        int l1;
        int i2;
        int j2;
        int k2;
        int l = i1 = j1 = k1 = l1 = i2 = j2 = k2 = 0x9e3779b9;
        for (int i = 0; i < 4; i++) {
            l ^= i1 << 11;
            k1 += l;
            i1 += j1;
            i1 ^= j1 >>> 2;
            l1 += i1;
            j1 += k1;
            j1 ^= k1 << 8;
            i2 += j1;
            k1 += l1;
            k1 ^= l1 >>> 16;
            j2 += k1;
            l1 += i2;
            l1 ^= i2 << 10;
            k2 += l1;
            i2 += j2;
            i2 ^= j2 >>> 4;
            l += i2;
            j2 += k2;
            j2 ^= k2 << 8;
            i1 += j2;
            k2 += l;
            k2 ^= l >>> 9;
            j1 += k2;
            l += i1;
        }

        for (int j = 0; j < 256; j += 8) {
            l += anIntArray503[j];
            i1 += anIntArray503[j + 1];
            j1 += anIntArray503[j + 2];
            k1 += anIntArray503[j + 3];
            l1 += anIntArray503[j + 4];
            i2 += anIntArray503[j + 5];
            j2 += anIntArray503[j + 6];
            k2 += anIntArray503[j + 7];
            l ^= i1 << 11;
            k1 += l;
            i1 += j1;
            i1 ^= j1 >>> 2;
            l1 += i1;
            j1 += k1;
            j1 ^= k1 << 8;
            i2 += j1;
            k1 += l1;
            k1 ^= l1 >>> 16;
            j2 += k1;
            l1 += i2;
            l1 ^= i2 << 10;
            k2 += l1;
            i2 += j2;
            i2 ^= j2 >>> 4;
            l += i2;
            j2 += k2;
            j2 ^= k2 << 8;
            i1 += j2;
            k2 += l;
            k2 ^= l >>> 9;
            j1 += k2;
            l += i1;
            anIntArray504[j] = l;
            anIntArray504[j + 1] = i1;
            anIntArray504[j + 2] = j1;
            anIntArray504[j + 3] = k1;
            anIntArray504[j + 4] = l1;
            anIntArray504[j + 5] = i2;
            anIntArray504[j + 6] = j2;
            anIntArray504[j + 7] = k2;
        }

        for (int k = 0; k < 256; k += 8) {
            l += anIntArray504[k];
            i1 += anIntArray504[k + 1];
            j1 += anIntArray504[k + 2];
            k1 += anIntArray504[k + 3];
            l1 += anIntArray504[k + 4];
            i2 += anIntArray504[k + 5];
            j2 += anIntArray504[k + 6];
            k2 += anIntArray504[k + 7];
            l ^= i1 << 11;
            k1 += l;
            i1 += j1;
            i1 ^= j1 >>> 2;
            l1 += i1;
            j1 += k1;
            j1 ^= k1 << 8;
            i2 += j1;
            k1 += l1;
            k1 ^= l1 >>> 16;
            j2 += k1;
            l1 += i2;
            l1 ^= i2 << 10;
            k2 += l1;
            i2 += j2;
            i2 ^= j2 >>> 4;
            l += i2;
            j2 += k2;
            j2 ^= k2 << 8;
            i1 += j2;
            k2 += l;
            k2 ^= l >>> 9;
            j1 += k2;
            l += i1;
            anIntArray504[k] = l;
            anIntArray504[k + 1] = i1;
            anIntArray504[k + 2] = j1;
            anIntArray504[k + 3] = k1;
            anIntArray504[k + 4] = l1;
            anIntArray504[k + 5] = i2;
            anIntArray504[k + 6] = j2;
            anIntArray504[k + 7] = k2;
        }

        method301(-23795);
        anInt502 = 256;
    }

    public int anInt502;
    public int[] anIntArray503;
    public int[] anIntArray504;
    public int anInt505;
    public int anInt506;
    public int anInt507;
}
