package com.jagex.game.runetek3.graphics;

// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

import com.jagex.core.io.Buffer;
import com.jagex.core.io.FileArchive;

import java.awt.*;
import java.awt.image.PixelGrabber;

public class Sprite extends Draw2D {

    public Sprite(int i, int j) {
        anInt1285 = -40161;
        aBoolean1286 = false;
        aBoolean1288 = false;
        aByte1289 = 4;
        aBoolean1290 = true;
        anIntArray1292 = new int[i * j];
        anInt1293 = anInt1297 = i;
        anInt1294 = anInt1298 = j;
        anInt1295 = anInt1296 = 0;
    }

    public Sprite(byte[] abyte0, Component component) {
        anInt1285 = -40161;
        aBoolean1286 = false;
        aBoolean1288 = false;
        aByte1289 = 4;
        aBoolean1290 = true;
        try {
            Image image = Toolkit.getDefaultToolkit().createImage(abyte0);
            MediaTracker mediatracker = new MediaTracker(component);
            mediatracker.addImage(image, 0);
            mediatracker.waitForAll();
            anInt1293 = image.getWidth(component);
            anInt1294 = image.getHeight(component);
            anInt1297 = anInt1293;
            anInt1298 = anInt1294;
            anInt1295 = 0;
            anInt1296 = 0;
            anIntArray1292 = new int[anInt1293 * anInt1294];
            PixelGrabber pixelgrabber = new PixelGrabber(image, 0, 0, anInt1293, anInt1294, anIntArray1292, 0, anInt1293);
            pixelgrabber.grabPixels();
            return;
        } catch (Exception _ex) {
            System.out.println("Error converting jpg");
        }
    }

    public Sprite(FileArchive class36, String s, int i) {
        anInt1285 = -40161;
        aBoolean1286 = false;
        aBoolean1288 = false;
        aByte1289 = 4;
        aBoolean1290 = true;
        Buffer class35_sub2_sub3 = new Buffer(class36.read(null, s + ".dat"));
        Buffer class35_sub2_sub3_1 = new Buffer(class36.read(null, "index.dat"));
        class35_sub2_sub3_1.pos = class35_sub2_sub3.g2();
        anInt1297 = class35_sub2_sub3_1.g2();
        anInt1298 = class35_sub2_sub3_1.g2();
        int j = class35_sub2_sub3_1.g1();
        int[] ai = new int[j];
        for (int k = 0; k < j - 1; k++) {
            ai[k + 1] = class35_sub2_sub3_1.g3();
            if (ai[k + 1] == 0)
                ai[k + 1] = 1;
        }

        for (int l = 0; l < i; l++) {
            class35_sub2_sub3_1.pos += 2;
            class35_sub2_sub3.pos += class35_sub2_sub3_1.g2() * class35_sub2_sub3_1.g2();
            class35_sub2_sub3_1.pos++;
        }

        anInt1295 = class35_sub2_sub3_1.g1();
        anInt1296 = class35_sub2_sub3_1.g1();
        anInt1293 = class35_sub2_sub3_1.g2();
        anInt1294 = class35_sub2_sub3_1.g2();
        int i1 = class35_sub2_sub3_1.g1();
        int j1 = anInt1293 * anInt1294;
        anIntArray1292 = new int[j1];
        if (i1 == 0) {
            for (int k1 = 0; k1 < j1; k1++)
                anIntArray1292[k1] = ai[class35_sub2_sub3.g1()];

            return;
        }
        if (i1 == 1) {
            for (int l1 = 0; l1 < anInt1293; l1++) {
                for (int i2 = 0; i2 < anInt1294; i2++)
                    anIntArray1292[l1 + i2 * anInt1293] = ai[class35_sub2_sub3.g1()];

            }

        }
    }

    public void method354(int i) {
        Draw2D.method329(anInt1293, anIntArray1292, anInt1294, -810);
        if (i >= 0)
            anInt1285 = -63;
    }

    public void method355(int i, int j, int k) {
        k += anInt1295;
        i += anInt1296;
        int l = k + i * Draw2D.anInt1138;
        int i1 = 0;
        int j1 = anInt1294;
        int k1 = anInt1293;
        int l1 = Draw2D.anInt1138 - k1;
        int i2 = 0;
        if (j != 0)
            return;
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
            method356(k1, j1, l, Draw2D.anIntArray1137, 14588, anIntArray1292, i1, l1, i2);
            return;
        }
    }

    public void method356(int i, int j, int k, int[] ai, int l, int[] ai1, int i1, int j1, int k1) {
        int l1 = -(i >> 2);
        i = -(i & 3);
        for (int i2 = -j; i2 < 0; i2++) {
            for (int j2 = l1; j2 < 0; j2++) {
                ai[k++] = ai1[i1++];
                ai[k++] = ai1[i1++];
                ai[k++] = ai1[i1++];
                ai[k++] = ai1[i1++];
            }

            for (int k2 = i; k2 < 0; k2++)
                ai[k++] = ai1[i1++];

            k += j1;
            i1 += k1;
        }

        if (l != 14588)
            anInt1287 = -250;
    }

    public void method357(int i, int j, int k) {
        k += anInt1295;
        i += anInt1296;
        int l = k + i * Draw2D.anInt1138;
        int i1 = 0;
        if (j <= 0)
            anInt1285 = 423;
        int j1 = anInt1294;
        int k1 = anInt1293;
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
            method358(Draw2D.anIntArray1137, anIntArray1292, 0, i1, l, k1, j1, l1, i2);
            return;
        }
    }

    public void method358(int[] ai, int[] ai1, int i, int j, int k, int l, int i1,
                          int j1, int k1) {
        int l1 = -(l >> 2);
        l = -(l & 3);
        for (int i2 = -i1; i2 < 0; i2++) {
            for (int j2 = l1; j2 < 0; j2++) {
                i = ai1[j++];
                if (i != 0)
                    ai[k++] = i;
                else
                    k++;
                i = ai1[j++];
                if (i != 0)
                    ai[k++] = i;
                else
                    k++;
                i = ai1[j++];
                if (i != 0)
                    ai[k++] = i;
                else
                    k++;
                i = ai1[j++];
                if (i != 0)
                    ai[k++] = i;
                else
                    k++;
            }

            for (int k2 = l; k2 < 0; k2++) {
                i = ai1[j++];
                if (i != 0)
                    ai[k++] = i;
                else
                    k++;
            }

            k += j1;
            j += k1;
        }

    }

    public void method359(boolean flag, int i, int j, int k) {
        i += anInt1295;
        k += anInt1296;
        int l = i + k * Draw2D.anInt1138;
        int i1 = 0;
        if (flag)
            anInt1291 = 166;
        int j1 = anInt1294;
        int k1 = anInt1293;
        int l1 = Draw2D.anInt1138 - k1;
        int i2 = 0;
        if (k < Draw2D.anInt1140) {
            int j2 = Draw2D.anInt1140 - k;
            j1 -= j2;
            k = Draw2D.anInt1140;
            i1 += j2 * k1;
            l += j2 * Draw2D.anInt1138;
        }
        if (k + j1 > Draw2D.anInt1141)
            j1 -= (k + j1) - Draw2D.anInt1141;
        if (i < Draw2D.anInt1142) {
            int k2 = Draw2D.anInt1142 - i;
            k1 -= k2;
            i = Draw2D.anInt1142;
            i1 += k2;
            l += k2;
            i2 += k2;
            l1 += k2;
        }
        if (i + k1 > Draw2D.anInt1143) {
            int l2 = (i + k1) - Draw2D.anInt1143;
            k1 -= l2;
            i2 += l2;
            l1 += l2;
        }
        if (k1 <= 0 || j1 <= 0) {
            return;
        } else {
            method360(anIntArray1292, k1, j, i1, j1, aByte1289, i2, Draw2D.anIntArray1137, l1, 0, l);
            return;
        }
    }

    public void method360(int[] ai, int i, int j, int k, int l, byte byte0, int i1,
                          int[] ai1, int j1, int k1, int l1) {
        int i2 = 256 - j;
        for (int j2 = -l; j2 < 0; j2++) {
            for (int k2 = -i; k2 < 0; k2++) {
                k1 = ai[k++];
                if (k1 != 0) {
                    int l2 = ai1[l1];
                    ai1[l1++] = ((k1 & 0xff00ff) * j + (l2 & 0xff00ff) * i2 & 0xff00ff00) + ((k1 & 0xff00) * j + (l2 & 0xff00) * i2 & 0xff0000) >> 8;
                } else {
                    l1++;
                }
            }

            l1 += j1;
            k += i1;
        }

        if (byte0 != 4)
            aBoolean1288 = !aBoolean1288;
    }

    public void method361(int[] ai, int i, int j, int k, int[] ai1, int l, int i1,
                          int j1, int k1, int l1) {
        if (j != 0) {
            for (int i2 = 1; i2 > 0; i2++) ;
        }
        try {
            int j2 = -i / 2;
            int k2 = -k / 2;
            int l2 = (int) (Math.sin((double) k1 / 326.11000000000001D) * 65536D);
            int i3 = (int) (Math.cos((double) k1 / 326.11000000000001D) * 65536D);
            int j3 = (j1 << 16) + (k2 * l2 + j2 * i3);
            int k3 = (l1 << 16) + (k2 * i3 - j2 * l2);
            int l3 = l + i1 * Draw2D.anInt1138;
            for (i1 = 0; i1 < k; i1++) {
                int i4 = ai1[i1];
                int j4 = l3 + i4;
                int k4 = j3 + i3 * i4;
                int l4 = k3 - l2 * i4;
                for (l = -ai[i1]; l < 0; l++) {
                    Draw2D.anIntArray1137[j4++] = anIntArray1292[(k4 >> 16) + (l4 >> 16) * anInt1293];
                    k4 += i3;
                    l4 -= l2;
                }

                j3 += l2;
                k3 += i3;
                l3 += Draw2D.anInt1138;
            }

            return;
        } catch (Exception _ex) {
            return;
        }
    }

    public void method362(int i, int j, IndexedSprite class35_sub2_sub2_sub3, int k) {
        j += anInt1295;
        k += anInt1296;
        int l = j + k * Draw2D.anInt1138;
        int i1 = 0;
        if (i != 0)
            return;
        int j1 = anInt1294;
        int k1 = anInt1293;
        int l1 = Draw2D.anInt1138 - k1;
        int i2 = 0;
        if (k < Draw2D.anInt1140) {
            int j2 = Draw2D.anInt1140 - k;
            j1 -= j2;
            k = Draw2D.anInt1140;
            i1 += j2 * k1;
            l += j2 * Draw2D.anInt1138;
        }
        if (k + j1 > Draw2D.anInt1141)
            j1 -= (k + j1) - Draw2D.anInt1141;
        if (j < Draw2D.anInt1142) {
            int k2 = Draw2D.anInt1142 - j;
            k1 -= k2;
            j = Draw2D.anInt1142;
            i1 += k2;
            l += k2;
            i2 += k2;
            l1 += k2;
        }
        if (j + k1 > Draw2D.anInt1143) {
            int l2 = (j + k1) - Draw2D.anInt1143;
            k1 -= l2;
            i2 += l2;
            l1 += l2;
        }
        if (k1 <= 0 || j1 <= 0) {
            return;
        } else {
            method363(i1, 0, Draw2D.anIntArray1137, k1, j1, anIntArray1292, true, i2, l, l1, class35_sub2_sub2_sub3.aByteArray1304);
            return;
        }
    }

    public void method363(int i, int j, int[] ai, int k, int l, int[] ai1, boolean flag,
                          int i1, int j1, int k1, byte[] abyte0) {
        int l1 = -(k >> 2);
        k = -(k & 3);
        for (int i2 = -l; i2 < 0; i2++) {
            for (int j2 = l1; j2 < 0; j2++) {
                j = ai1[i++];
                if (j != 0 && abyte0[j1] == 0)
                    ai[j1++] = j;
                else
                    j1++;
                j = ai1[i++];
                if (j != 0 && abyte0[j1] == 0)
                    ai[j1++] = j;
                else
                    j1++;
                j = ai1[i++];
                if (j != 0 && abyte0[j1] == 0)
                    ai[j1++] = j;
                else
                    j1++;
                j = ai1[i++];
                if (j != 0 && abyte0[j1] == 0)
                    ai[j1++] = j;
                else
                    j1++;
            }

            for (int k2 = k; k2 < 0; k2++) {
                j = ai1[i++];
                if (j != 0 && abyte0[j1] == 0)
                    ai[j1++] = j;
                else
                    j1++;
            }

            j1 += k1;
            i += i1;
        }

        if (flag) ;
    }

    public int anInt1285;
    public boolean aBoolean1286;
    public int anInt1287;
    public boolean aBoolean1288;
    public byte aByte1289;
    public boolean aBoolean1290;
    public int anInt1291;
    public int[] anIntArray1292;
    public int anInt1293;
    public int anInt1294;
    public int anInt1295;
    public int anInt1296;
    public int anInt1297;
    public int anInt1298;
}
