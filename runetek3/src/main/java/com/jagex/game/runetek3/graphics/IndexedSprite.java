package com.jagex.game.runetek3.graphics;

// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

import com.jagex.core.io.Buffer;
import com.jagex.core.io.FileArchive;

public class IndexedSprite extends Draw2D {

    public IndexedSprite(FileArchive class36, String s, int i) {
        aBoolean1299 = false;
        aBoolean1300 = false;
        anInt1301 = 129;
        anInt1302 = -25737;
        aBoolean1303 = false;
        Buffer class35_sub2_sub3 = new Buffer(class36.method417((byte) 6, null, s + ".dat"));
        Buffer class35_sub2_sub3_1 = new Buffer(class36.method417((byte) 6, null, "index.dat"));
        class35_sub2_sub3_1.pos = class35_sub2_sub3.g2();
        anInt1310 = class35_sub2_sub3_1.g2();
        anInt1311 = class35_sub2_sub3_1.g2();
        int j = class35_sub2_sub3_1.g1();
        anIntArray1305 = new int[j];
        for (int k = 0; k < j - 1; k++)
            anIntArray1305[k + 1] = class35_sub2_sub3_1.g3();

        for (int l = 0; l < i; l++) {
            class35_sub2_sub3_1.pos += 2;
            class35_sub2_sub3.pos += class35_sub2_sub3_1.g2() * class35_sub2_sub3_1.g2();
            class35_sub2_sub3_1.pos++;
        }

        anInt1308 = class35_sub2_sub3_1.g1();
        anInt1309 = class35_sub2_sub3_1.g1();
        anInt1306 = class35_sub2_sub3_1.g2();
        anInt1307 = class35_sub2_sub3_1.g2();
        int i1 = class35_sub2_sub3_1.g1();
        int j1 = anInt1306 * anInt1307;
        aByteArray1304 = new byte[j1];
        if (i1 == 0) {
            for (int k1 = 0; k1 < j1; k1++)
                aByteArray1304[k1] = class35_sub2_sub3.g1b();

            return;
        }
        if (i1 == 1) {
            for (int l1 = 0; l1 < anInt1306; l1++) {
                for (int i2 = 0; i2 < anInt1307; i2++)
                    aByteArray1304[l1 + i2 * anInt1306] = class35_sub2_sub3.g1b();

            }

        }
    }

    public void method364(int i) {
        anInt1310 /= 2;
        anInt1311 /= 2;
        byte[] abyte0 = new byte[anInt1310 * anInt1311];
        int j = 0;
        for (int k = 0; k < anInt1307; k++) {
            for (int l = 0; l < anInt1306; l++)
                abyte0[(l + anInt1308 >> 1) + (k + anInt1309 >> 1) * anInt1310] = aByteArray1304[j++];

        }

        aByteArray1304 = abyte0;
        anInt1306 = anInt1310;
        anInt1307 = anInt1311;
        anInt1308 = 0;
        i = 43 / i;
        anInt1309 = 0;
    }

    public void method365(int i) {
        if (anInt1306 == anInt1310 && anInt1307 == anInt1311)
            return;
        byte[] abyte0 = new byte[anInt1310 * anInt1311];
        int j = 0;
        for (int k = 0; k < anInt1307; k++) {
            for (int l = 0; l < anInt1306; l++)
                abyte0[l + anInt1308 + (k + anInt1309) * anInt1310] = aByteArray1304[j++];

        }

        aByteArray1304 = abyte0;
        anInt1306 = anInt1310;
        anInt1307 = anInt1311;
        while (i >= 0)
            aBoolean1299 = !aBoolean1299;
        anInt1308 = 0;
        anInt1309 = 0;
    }

    public void method366(int i) {
        byte[] abyte0 = new byte[anInt1306 * anInt1307];
        int j = 0;
        if (i != anInt1302)
            aBoolean1299 = !aBoolean1299;
        for (int k = 0; k < anInt1307; k++) {
            for (int l = anInt1306 - 1; l >= 0; l--)
                abyte0[j++] = aByteArray1304[l + k * anInt1306];

        }

        aByteArray1304 = abyte0;
        anInt1308 = anInt1310 - anInt1306 - anInt1308;
    }

    public void method367(boolean flag) {
        byte[] abyte0 = new byte[anInt1306 * anInt1307];
        int i = 0;
        for (int j = anInt1307 - 1; j >= 0; j--) {
            for (int k = 0; k < anInt1306; k++)
                abyte0[i++] = aByteArray1304[k + j * anInt1306];

        }

        aByteArray1304 = abyte0;
        anInt1309 = anInt1311 - anInt1307 - anInt1309;
        if (flag)
            aBoolean1303 = !aBoolean1303;
    }

    public void method368(int i, int j, int k) {
        k += anInt1308;
        i += anInt1309;
        int l = k + i * Draw2D.anInt1138;
        int i1 = 0;
        int j1 = anInt1307;
        int k1 = anInt1306;
        int l1 = Draw2D.anInt1138 - k1;
        int i2 = 0;
        if (i < Draw2D.anInt1140) {
            int j2 = Draw2D.anInt1140 - i;
            j1 -= j2;
            i = Draw2D.anInt1140;
            i1 += j2 * k1;
            l += j2 * Draw2D.anInt1138;
        }
        if (i + j1 > Draw2D.anInt1141)
            j1 -= (i + j1) - Draw2D.anInt1141;
        if (k < Draw2D.anInt1142) {
            int k2 = Draw2D.anInt1142 - k;
            k1 -= k2;
            k = Draw2D.anInt1142;
            i1 += k2;
            l += k2;
            i2 += k2;
            l1 += k2;
        }
        if (k + k1 > Draw2D.anInt1143) {
            int l2 = (k + k1) - Draw2D.anInt1143;
            k1 -= l2;
            i2 += l2;
            l1 += l2;
        }
        if (k1 <= 0 || j1 <= 0) {
            return;
        } else {
            method369(j1, i1, i2, Draw2D.anIntArray1137, anIntArray1305, aByteArray1304, (byte) 0, l1, l, k1);
            j = 3 / j;
            return;
        }
    }

    public void method369(int i, int j, int k, int[] ai, int[] ai1, byte[] abyte0, byte byte0,
                          int l, int i1, int j1) {
        if (byte0 == 0)
            byte0 = 0;
        else
            aBoolean1299 = !aBoolean1299;
        int k1 = -(j1 >> 2);
        j1 = -(j1 & 3);
        for (int l1 = -i; l1 < 0; l1++) {
            for (int i2 = k1; i2 < 0; i2++) {
                byte byte1 = abyte0[j++];
                if (byte1 != 0)
                    ai[i1++] = ai1[byte1 & 0xff];
                else
                    i1++;
                byte1 = abyte0[j++];
                if (byte1 != 0)
                    ai[i1++] = ai1[byte1 & 0xff];
                else
                    i1++;
                byte1 = abyte0[j++];
                if (byte1 != 0)
                    ai[i1++] = ai1[byte1 & 0xff];
                else
                    i1++;
                byte1 = abyte0[j++];
                if (byte1 != 0)
                    ai[i1++] = ai1[byte1 & 0xff];
                else
                    i1++;
            }

            for (int j2 = j1; j2 < 0; j2++) {
                byte byte2 = abyte0[j++];
                if (byte2 != 0)
                    ai[i1++] = ai1[byte2 & 0xff];
                else
                    i1++;
            }

            i1 += l;
            j += k;
        }

    }

    public boolean aBoolean1299;
    public boolean aBoolean1300;
    public int anInt1301;
    public int anInt1302;
    public boolean aBoolean1303;
    public byte[] aByteArray1304;
    public int[] anIntArray1305;
    public int anInt1306;
    public int anInt1307;
    public int anInt1308;
    public int anInt1309;
    public int anInt1310;
    public int anInt1311;
}
