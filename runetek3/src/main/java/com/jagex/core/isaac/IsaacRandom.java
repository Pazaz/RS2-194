package com.jagex.core.isaac;

// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

public class IsaacRandom {

    public IsaacRandom(int[] seed) {
        mem = new int[256];
        rsl = new int[256];
        for (int i = 0; i < seed.length; i++) {
            rsl[i] = seed[i];
        }

        init();
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

    public void isaac() {
        b += ++c;
        for (int j = 0; j < 256; j++) {
            int k = mem[j];
            switch (j & 3) {
                case 0: // '\0'
                    a ^= a << 13;
                    break;

                case 1: // '\001'
                    a ^= a >>> 6;
                    break;

                case 2: // '\002'
                    a ^= a << 2;
                    break;

                case 3: // '\003'
                    a ^= a >>> 16;
                    break;
            }
            a += mem[j + 128 & 0xFF];
            int l;
            mem[j] = l = mem[(k & 0x3FC) >> 2] + a + b;
            rsl[j] = b = mem[(l >> 8 & 0x3FC) >> 2] + k;
        }

    }

    public void init() {
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
            l += rsl[j];
            i1 += rsl[j + 1];
            j1 += rsl[j + 2];
            k1 += rsl[j + 3];
            l1 += rsl[j + 4];
            i2 += rsl[j + 5];
            j2 += rsl[j + 6];
            k2 += rsl[j + 7];
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
            mem[j] = l;
            mem[j + 1] = i1;
            mem[j + 2] = j1;
            mem[j + 3] = k1;
            mem[j + 4] = l1;
            mem[j + 5] = i2;
            mem[j + 6] = j2;
            mem[j + 7] = k2;
        }

        for (int k = 0; k < 256; k += 8) {
            l += mem[k];
            i1 += mem[k + 1];
            j1 += mem[k + 2];
            k1 += mem[k + 3];
            l1 += mem[k + 4];
            i2 += mem[k + 5];
            j2 += mem[k + 6];
            k2 += mem[k + 7];
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
            mem[k] = l;
            mem[k + 1] = i1;
            mem[k + 2] = j1;
            mem[k + 3] = k1;
            mem[k + 4] = l1;
            mem[k + 5] = i2;
            mem[k + 6] = j2;
            mem[k + 7] = k2;
        }

        isaac();
        anInt502 = 256;
    }

    public int anInt502;
    public int[] rsl;
    public int[] mem;
    public int a;
    public int b;
    public int c;
}
