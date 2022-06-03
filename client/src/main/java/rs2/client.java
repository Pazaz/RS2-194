package rs2;

// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

import com.itspazaz.lostcity.Server;
import com.jagex.core.bzip2.BZip2InputStream;
import com.jagex.core.io.Buffer;
import com.jagex.core.io.FileArchive;
import com.jagex.core.isaac.IsaacRandom;
import com.jagex.core.network.BufferedStream;
import com.jagex.core.stringutils.StringUtils;
import com.jagex.core.stringutils.TextEncoder;
import com.jagex.core.stringutils.WordPack;
import com.jagex.core.utils.LinkedList;
import com.jagex.core.utils.Node;
import com.jagex.game.runetek3.client.GameShell;
import com.jagex.game.runetek3.client.InputTracking;
import com.jagex.game.runetek3.config.*;
import com.jagex.game.runetek3.entity.*;
import com.jagex.game.runetek3.graphics.*;
import com.jagex.game.runetek3.graphics.model.Model;
import com.jagex.game.runetek3.graphics.seq.SeqBase;
import com.jagex.game.runetek3.graphics.seq.SeqFrame;
import com.jagex.game.runetek3.graphics.ui.Font;
import com.jagex.game.runetek3.graphics.ui.Component;
import com.jagex.game.runetek3.scenegraph.CollisionMap;
import com.jagex.game.runetek3.scenegraph.MapSquare;
import com.jagex.game.runetek3.scenegraph.Scene;
import rs2.sign.signlink;

import java.awt.*;
import java.io.DataInputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.net.InetAddress;
import java.net.Socket;
import java.net.URL;
import java.util.zip.CRC32;

public class client extends GameShell {

    public void method14(boolean flag) {
        char c = '\u0100';
        if (anInt932 > 0) {
            for (int i = 0; i < 256; i++)
                if (anInt932 > 768)
                    anIntArray797[i] = method114(746, anIntArray798[i], 1024 - anInt932, anIntArray799[i]);
                else if (anInt932 > 256)
                    anIntArray797[i] = anIntArray799[i];
                else
                    anIntArray797[i] = method114(746, anIntArray799[i], 256 - anInt932, anIntArray798[i]);

        } else if (anInt933 > 0) {
            for (int j = 0; j < 256; j++)
                if (anInt933 > 768)
                    anIntArray797[j] = method114(746, anIntArray798[j], 1024 - anInt933, anIntArray800[j]);
                else if (anInt933 > 256)
                    anIntArray797[j] = anIntArray800[j];
                else
                    anIntArray797[j] = method114(746, anIntArray800[j], 256 - anInt933, anIntArray798[j]);

        } else {
            for (int k = 0; k < 256; k++)
                anIntArray797[k] = anIntArray798[k];

        }
        for (int l = 0; l < 33920; l++)
            aFrameBuffer_892.anIntArray368[l] = aSprite_687.anIntArray1292[l];

        int i1 = 0;
        int j1 = 1152;
        for (int k1 = 1; k1 < c - 1; k1++) {
            int l1 = (anIntArray721[k1] * (c - k1)) / c;
            int j2 = 22 + l1;
            if (j2 < 0)
                j2 = 0;
            i1 += j2;
            for (int l2 = j2; l2 < 128; l2++) {
                int j3 = anIntArray795[i1++];
                if (j3 != 0) {
                    int l3 = j3;
                    int j4 = 256 - j3;
                    j3 = anIntArray797[j3];
                    int l4 = aFrameBuffer_892.anIntArray368[j1];
                    aFrameBuffer_892.anIntArray368[j1++] = ((j3 & 0xff00ff) * l3 + (l4 & 0xff00ff) * j4 & 0xff00ff00) + ((j3 & 0xff00) * l3 + (l4 & 0xff00) * j4 & 0xff0000) >> 8;
                } else {
                    j1++;
                }
            }

            j1 += j2;
        }

        aFrameBuffer_892.method235(0, super.aGraphics13, 0, aByte930);
        for (int i2 = 0; i2 < 33920; i2++)
            aFrameBuffer_893.anIntArray368[i2] = aSprite_688.anIntArray1292[i2];

        i1 = 0;
        j1 = 1176;
        for (int k2 = 1; k2 < c - 1; k2++) {
            int i3 = (anIntArray721[k2] * (c - k2)) / c;
            int k3 = 103 - i3;
            j1 += i3;
            for (int i4 = 0; i4 < k3; i4++) {
                int k4 = anIntArray795[i1++];
                if (k4 != 0) {
                    int i5 = k4;
                    int j5 = 256 - k4;
                    k4 = anIntArray797[k4];
                    int k5 = aFrameBuffer_893.anIntArray368[j1];
                    aFrameBuffer_893.anIntArray368[j1++] = ((k4 & 0xff00ff) * i5 + (k5 & 0xff00ff) * j5 & 0xff00ff00) + ((k4 & 0xff00) * i5 + (k5 & 0xff00) * j5 & 0xff0000) >> 8;
                } else {
                    j1++;
                }
            }

            i1 += 128 - k3;
            j1 += 128 - k3 - i3;
        }

        aBoolean734 &= flag;
        aFrameBuffer_893.method235(661, super.aGraphics13, 0, aByte930);
    }

    public int method15(int i, int j, int k, byte byte0) {
        int l = i >> 7;
        int i1 = j >> 7;
        int j1 = k;
        if (j1 < 3 && (levelRenderFlags[1][l][i1] & 2) == 2)
            j1++;
        int k1 = i & 0x7f;
        int l1 = j & 0x7f;
        if (byte0 == 9)
            byte0 = 0;
        else
            outBuffer.p1(6);
        int i2 = anIntArrayArrayArray725[j1][l][i1] * (128 - k1) + anIntArrayArrayArray725[j1][l + 1][i1] * k1 >> 7;
        int j2 = anIntArrayArrayArray725[j1][l][i1 + 1] * (128 - k1) + anIntArrayArrayArray725[j1][l + 1][i1 + 1] * k1 >> 7;
        return i2 * (128 - l1) + j2 * l1 >> 7;
    }

    public void method16(int i, int j) {
        LinkedList class24 = aLinkedListArrayArrayArray665[anInt722][i][j];
        if (class24 == null) {
            aMapSquare_741.method261(anInt722, i, j);
            return;
        }
        int k = 0xfa0a1f01;
        Object obj = null;
        for (ObjStackEntity class35_sub6 = (ObjStackEntity) class24.method227(); class35_sub6 != null; class35_sub6 = (ObjStackEntity) class24.method229(35239)) {
            ObjType class41 = ObjType.method440(class35_sub6.anInt1047);
            int i1 = class41.anInt619;
            if (class41.aBoolean618)
                i1 *= 10;
            if (i1 > k) {
                k = i1;
                obj = class35_sub6;
            }
        }

        class24.method225(((Node) (obj)), 0);
        int l = -1;
        int j1 = -1;
        for (ObjStackEntity class35_sub6_1 = (ObjStackEntity) class24.method227(); class35_sub6_1 != null; class35_sub6_1 = (ObjStackEntity) class24.method229(35239)) {
            if (class35_sub6_1.anInt1047 != ((ObjStackEntity) (obj)).anInt1047 && l == -1)
                l = class35_sub6_1.anInt1047;
            if (class35_sub6_1.anInt1047 != ((ObjStackEntity) (obj)).anInt1047 && class35_sub6_1.anInt1047 != l && j1 == -1)
                j1 = class35_sub6_1.anInt1047;
        }

        Model class35_sub2_sub1 = null;
        if (l != -1)
            class35_sub2_sub1 = ObjType.method440(l).method443();
        Model class35_sub2_sub1_1 = null;
        if (j1 != -1)
            class35_sub2_sub1_1 = ObjType.method440(j1).method443();
        int k1 = i + (j << 7) + 0x60000000;
        ObjType class41_1 = ObjType.method440(((ObjStackEntity) (obj)).anInt1047);
        aMapSquare_741.method245(i, method15(i * 128 + 64, j * 128 + 64, anInt722, (byte) 9), class41_1.method443(), class35_sub2_sub1, k1, class35_sub2_sub1_1, j, false, anInt722);
    }

    public int method17(boolean flag) {
        int i = 3;
        if (flag)
            return 1;
        if (anInt921 < 310) {
            int j = anInt918 >> 7;
            int k = anInt920 >> 7;
            int l = self.x >> 7;
            int i1 = self.z >> 7;
            if ((levelRenderFlags[anInt722][j][k] & 4) != 0)
                i = anInt722;
            int j1;
            if (l > j)
                j1 = l - j;
            else
                j1 = j - l;
            int k1;
            if (i1 > k)
                k1 = i1 - k;
            else
                k1 = k - i1;
            if (j1 > k1) {
                int l1 = (k1 * 0x10000) / j1;
                int j2 = 32768;
                while (j != l) {
                    if (j < l)
                        j++;
                    else if (j > l)
                        j--;
                    if ((levelRenderFlags[anInt722][j][k] & 4) != 0)
                        i = anInt722;
                    j2 += l1;
                    if (j2 >= 0x10000) {
                        j2 -= 0x10000;
                        if (k < i1)
                            k++;
                        else if (k > i1)
                            k--;
                        if ((levelRenderFlags[anInt722][j][k] & 4) != 0)
                            i = anInt722;
                    }
                }
            } else {
                int i2 = (j1 * 0x10000) / k1;
                int k2 = 32768;
                while (k != i1) {
                    if (k < i1)
                        k++;
                    else if (k > i1)
                        k--;
                    if ((levelRenderFlags[anInt722][j][k] & 4) != 0)
                        i = anInt722;
                    k2 += i2;
                    if (k2 >= 0x10000) {
                        k2 -= 0x10000;
                        if (j < l)
                            j++;
                        else if (j > l)
                            j--;
                        if ((levelRenderFlags[anInt722][j][k] & 4) != 0)
                            i = anInt722;
                    }
                }
            }
        }
        if ((levelRenderFlags[anInt722][self.x >> 7][self.z >> 7] & 4) != 0)
            i = anInt722;
        return i;
    }

    public int method18(int i) {
        if (i < 5 || i > 5)
            aLinkedListArrayArrayArray665 = null;
        int j = method15(anInt918, anInt920, anInt722, (byte) 9);
        if (j - anInt919 < 800 && (levelRenderFlags[anInt722][anInt918 >> 7][anInt920 >> 7] & 4) != 0)
            return anInt722;
        else
            return 3;
    }

    public void method19(int i) {
        if (i != 0)
            aLinkedListArrayArrayArray665 = null;
        if (anInt712 == 0 && anInt706 == 0) {
            aStringArray720[anInt710] = "Walk here";
            anIntArray848[anInt710] = 404;
            anIntArray846[anInt710] = super.anInt20;
            anIntArray847[anInt710] = super.anInt21;
            anInt710++;
        }
        int j = -1;
        for (int k = 0; k < Model.anInt1127; k++) {
            int l = Model.anIntArray1128[k];
            int i1 = l & 0x7f;
            int j1 = l >> 7 & 0x7f;
            int k1 = l >> 29 & 3;
            int l1 = l >> 14 & 0x7fff;
            if (l != j) {
                j = l;
                if (k1 == 2 && aMapSquare_741.method266(anInt722, i1, j1, l) >= 0) {
                    LocType class39 = LocType.method428(l1);
                    if (anInt712 == 1) {
                        aStringArray720[anInt710] = "Use " + aString716 + " with @cya@" + class39.aString538;
                        anIntArray848[anInt710] = 174;
                        anIntArray849[anInt710] = l;
                        anIntArray846[anInt710] = i1;
                        anIntArray847[anInt710] = j1;
                        anInt710++;
                    } else if (anInt706 == 1) {
                        if ((anInt708 & 4) == 4) {
                            aStringArray720[anInt710] = aString709 + " @cya@" + class39.aString538;
                            anIntArray848[anInt710] = 792;
                            anIntArray849[anInt710] = l;
                            anIntArray846[anInt710] = i1;
                            anIntArray847[anInt710] = j1;
                            anInt710++;
                        }
                    } else {
                        if (class39.aStringArray554 != null) {
                            for (int i2 = 4; i2 >= 0; i2--)
                                if (class39.aStringArray554[i2] != null) {
                                    aStringArray720[anInt710] = class39.aStringArray554[i2] + " @cya@" + class39.aString538;
                                    if (i2 == 0)
                                        anIntArray848[anInt710] = 447;
                                    if (i2 == 1)
                                        anIntArray848[anInt710] = 846;
                                    if (i2 == 2)
                                        anIntArray848[anInt710] = 34;
                                    if (i2 == 3)
                                        anIntArray848[anInt710] = 310;
                                    if (i2 == 4)
                                        anIntArray848[anInt710] = 647;
                                    anIntArray849[anInt710] = l;
                                    anIntArray846[anInt710] = i1;
                                    anIntArray847[anInt710] = j1;
                                    anInt710++;
                                }

                        }
                        aStringArray720[anInt710] = "Examine @cya@" + class39.aString538;
                        anIntArray848[anInt710] = 1419;
                        anIntArray849[anInt710] = l;
                        anIntArray846[anInt710] = i1;
                        anIntArray847[anInt710] = j1;
                        anInt710++;
                    }
                }
                if (k1 == 1) {
                    NpcEntity class35_sub7_sub3_sub1 = aClass35_Sub7_Sub3_Sub1Array964[l1];
                    if (class35_sub7_sub3_sub1.aNpcType_1325.aByte578 == 1 && (class35_sub7_sub3_sub1.x & 0x7f) == 64 && (class35_sub7_sub3_sub1.z & 0x7f) == 64) {
                        for (int j2 = 0; j2 < anInt965; j2++) {
                            NpcEntity class35_sub7_sub3_sub1_1 = aClass35_Sub7_Sub3_Sub1Array964[anIntArray966[j2]];
                            if (class35_sub7_sub3_sub1_1 != null && class35_sub7_sub3_sub1_1 != class35_sub7_sub3_sub1 && class35_sub7_sub3_sub1_1.aNpcType_1325.aByte578 == 1 && class35_sub7_sub3_sub1_1.x == class35_sub7_sub3_sub1.x && class35_sub7_sub3_sub1_1.z == class35_sub7_sub3_sub1.z)
                                method91(j1, anIntArray966[j2], i1, class35_sub7_sub3_sub1_1.aNpcType_1325, -687);
                        }

                    }
                    method91(j1, l1, i1, class35_sub7_sub3_sub1.aNpcType_1325, -687);
                }
                if (k1 == 0) {
                    PlayerEntity class35_sub7_sub3_sub2 = aPlayerEntityArray751[l1];
                    if ((class35_sub7_sub3_sub2.x & 0x7f) == 64 && (class35_sub7_sub3_sub2.z & 0x7f) == 64) {
                        for (int k2 = 0; k2 < anInt965; k2++) {
                            NpcEntity class35_sub7_sub3_sub1_2 = aClass35_Sub7_Sub3_Sub1Array964[anIntArray966[k2]];
                            if (class35_sub7_sub3_sub1_2 != null && class35_sub7_sub3_sub1_2.aNpcType_1325.aByte578 == 1 && class35_sub7_sub3_sub1_2.x == class35_sub7_sub3_sub2.x && class35_sub7_sub3_sub1_2.z == class35_sub7_sub3_sub2.z)
                                method91(j1, anIntArray966[k2], i1, class35_sub7_sub3_sub1_2.aNpcType_1325, -687);
                        }

                        for (int l2 = 0; l2 < anInt752; l2++) {
                            PlayerEntity class35_sub7_sub3_sub2_1 = aPlayerEntityArray751[anIntArray753[l2]];
                            if (class35_sub7_sub3_sub2_1 != null && class35_sub7_sub3_sub2_1 != class35_sub7_sub3_sub2 && class35_sub7_sub3_sub2_1.x == class35_sub7_sub3_sub2.x && class35_sub7_sub3_sub2_1.z == class35_sub7_sub3_sub2.z)
                                method113(0, class35_sub7_sub3_sub2_1, anIntArray753[l2], j1, i1);
                        }

                    }
                    method113(0, class35_sub7_sub3_sub2, l1, j1, i1);
                }
                if (k1 == 3) {
                    LinkedList class24 = aLinkedListArrayArrayArray665[anInt722][i1][j1];
                    if (class24 != null) {
                        for (ObjStackEntity class35_sub6 = (ObjStackEntity) class24.method228(8); class35_sub6 != null; class35_sub6 = (ObjStackEntity) class24.method230(true)) {
                            ObjType class41 = ObjType.method440(class35_sub6.anInt1047);
                            if (anInt712 == 1) {
                                aStringArray720[anInt710] = "Use " + aString716 + " with @lre@" + class41.aString606;
                                anIntArray848[anInt710] = 652;
                                anIntArray849[anInt710] = class35_sub6.anInt1047;
                                anIntArray846[anInt710] = i1;
                                anIntArray847[anInt710] = j1;
                                anInt710++;
                            } else if (anInt706 == 1) {
                                if ((anInt708 & 1) == 1) {
                                    aStringArray720[anInt710] = aString709 + " @lre@" + class41.aString606;
                                    anIntArray848[anInt710] = 926;
                                    anIntArray849[anInt710] = class35_sub6.anInt1047;
                                    anIntArray846[anInt710] = i1;
                                    anIntArray847[anInt710] = j1;
                                    anInt710++;
                                }
                            } else {
                                for (int i3 = 4; i3 >= 0; i3--)
                                    if (class41.aStringArray621 != null && class41.aStringArray621[i3] != null) {
                                        aStringArray720[anInt710] = class41.aStringArray621[i3] + " @lre@" + class41.aString606;
                                        if (i3 == 0)
                                            anIntArray848[anInt710] = 533;
                                        if (i3 == 1)
                                            anIntArray848[anInt710] = 947;
                                        if (i3 == 2)
                                            anIntArray848[anInt710] = 705;
                                        if (i3 == 3)
                                            anIntArray848[anInt710] = 912;
                                        if (i3 == 4)
                                            anIntArray848[anInt710] = 603;
                                        anIntArray849[anInt710] = class35_sub6.anInt1047;
                                        anIntArray846[anInt710] = i1;
                                        anIntArray847[anInt710] = j1;
                                        anInt710++;
                                    } else if (i3 == 2) {
                                        aStringArray720[anInt710] = "Take @lre@" + class41.aString606;
                                        anIntArray848[anInt710] = 705;
                                        anIntArray849[anInt710] = class35_sub6.anInt1047;
                                        anIntArray846[anInt710] = i1;
                                        anIntArray847[anInt710] = j1;
                                        anInt710++;
                                    }

                                aStringArray720[anInt710] = "Examine @lre@" + class41.aString606;
                                anIntArray848[anInt710] = 1585;
                                anIntArray849[anInt710] = class35_sub6.anInt1047;
                                anIntArray846[anInt710] = i1;
                                anIntArray847[anInt710] = j1;
                                anInt710++;
                            }
                        }

                    }
                }
            }
        }

    }

    public void method20(int i) {
        if (anInt819 == 1)
            aSpriteArray958[anInt818 / 100].method357(anInt817 - 8 - 11, anInt861, anInt816 - 8 - 8);
        if (anInt819 == 2)
            aSpriteArray958[4 + anInt818 / 100].method357(anInt817 - 8 - 11, anInt861, anInt816 - 8 - 8);
        if (anInt962 != -1)
            method53(aBoolean770, Component.aComponentArray110[anInt962], 0, 0, 0);
        int j = (self.x >> 7) + anInt855;
        int k = (self.z >> 7) + anInt856;
        if (i < 8 || i > 8)
            return;
        if (j >= 2944 && j < 3392 && k >= 3520 && k < 6400)
            anInt735 = 1 + (k - 3520) / 8;
        else
            anInt735 = 0;
        if (!aBoolean838) {
            method80(0);
            method117(anInt779);
        } else if (anInt667 == 0)
            method76(9);
        if (anInt703 == 1)
            aSpriteArray843[1].method357(296, anInt861, 5);
        if (anInt735 > 0) {
            aSpriteArray843[0].method357(296, anInt861, 472);
            p12.method370(true, 329, 0xffff00, 484, "Level: " + anInt735);
        } else if (aBoolean663) {
            int l = 0xffff00;
            Runtime runtime = Runtime.getRuntime();
            long l1 = runtime.totalMemory();
            long l2 = runtime.freeMemory();
            if (!signlink.sunjava && l1 - l2 > 0x2000000L && anInt759 > anInt808 + 500) {
                method57(anInt952);
                runtime.gc();
                int i1 = 0xff0000;
                anInt808 = anInt759;
            }
        }
        if (anInt738 != 0) {
            int j1 = anInt738 / 50;
            int k1 = j1 / 60;
            j1 %= 60;
            if (j1 < 10) {
                p12.method370(true, 329, 0xffff00, 256, "System update in: " + k1 + ":0" + j1);
                return;
            }
            p12.method370(true, 329, 0xffff00, 256, "System update in: " + k1 + ":" + j1);
        }
    }

    public void method21(int i) {
        SpotAnimEntity class35_sub7_sub2 = (SpotAnimEntity) aLinkedList_657.method227();
        if (i < 9 || i > 9)
            aBoolean828 = !aBoolean828;
        for (; class35_sub7_sub2 != null; class35_sub7_sub2 = (SpotAnimEntity) aLinkedList_657.method229(35239))
            if (class35_sub7_sub2.anInt1200 != anInt722 || class35_sub7_sub2.aBoolean1206)
                class35_sub7_sub2.method303();
            else if (anInt759 >= class35_sub7_sub2.anInt1199) {
                class35_sub7_sub2.method408(anInt742, false);
                if (class35_sub7_sub2.aBoolean1206)
                    class35_sub7_sub2.method303();
                else
                    aMapSquare_741.method249(null, class35_sub7_sub2.anInt1203, 5, class35_sub7_sub2.anInt1202, 0, class35_sub7_sub2.anInt1201, class35_sub7_sub2.anInt1200, 0, class35_sub7_sub2, 60, -1);
            }

    }

    public int method22() {
        return signlink.jinglelen;
    }

    public int method23(int i, Component class8, int j) {
        if (j != -6815)
            anInt809 = 400;
        if (class8.anIntArrayArray124 == null || i >= class8.anIntArrayArray124.length)
            return -2;
        try {
            int[] ai = class8.anIntArrayArray124[i];
            int k = 0;
            int l = 0;
            do {
                int i1;
                do {
                    i1 = ai[l++];
                    if (i1 == 0)
                        return k;
                    if (i1 == 1)
                        k += anIntArray948[ai[l++]];
                    if (i1 == 2)
                        k += anIntArray840[ai[l++]];
                    if (i1 == 3)
                        k += anIntArray777[ai[l++]];
                    if (i1 == 4) {
                        Component class8_1 = Component.aComponentArray110[ai[l++]];
                        int k1 = ai[l++] + 1;
                        for (int i2 = 0; i2 < class8_1.anIntArray111.length; i2++)
                            if (class8_1.anIntArray111[i2] == k1)
                                k += class8_1.anIntArray112[i2];

                    }
                    if (i1 == 5)
                        k += anIntArray822[ai[l++]];
                    if (i1 == 6)
                        k += anIntArray678[anIntArray840[ai[l++]] - 1];
                    if (i1 == 7)
                        k += (anIntArray822[ai[l++]] * 100) / 46875;
                    if (i1 == 8)
                        k += self.combatLevel;
                    if (i1 == 9) {
                        for (int j1 = 0; j1 < 19; j1++) {
                            if (j1 == 18)
                                j1 = 20;
                            k += anIntArray840[j1];
                        }

                    }
                    if (i1 == 10) {
                        Component class8_2 = Component.aComponentArray110[ai[l++]];
                        int l1 = ai[l++] + 1;
                        for (int j2 = 0; j2 < class8_2.anIntArray111.length; j2++) {
                            if (class8_2.anIntArray111[j2] != l1)
                                continue;
                            k += 0x3b9ac9ff;
                            break;
                        }

                    }
                    if (i1 == 11)
                        k += anInt955;
                } while (i1 != 12);
                k += anInt909;
            } while (true);
        } catch (Exception _ex) {
            return -1;
        }
    }

    public FileArchive loadArchive(int i, boolean flag, String s, int j, String s1) {
        if (flag)
            anInt841 = -388;
        int k = 5;
        byte[] abyte0 = signlink.cacheload(s1);
        if (abyte0 != null) {
            aCRC32_639.reset();
            aCRC32_639.update(abyte0);
            int l = (int) aCRC32_639.getValue();
            if (l != i)
                abyte0 = null;
        }
        if (abyte0 != null) {
            FileArchive class36 = new FileArchive(abyte0);
            return class36;
        }
        while (abyte0 == null) {
            showProgress((byte) -75, j, "Requesting " + s);
            try {
                int i1 = 0;
                DataInputStream datainputstream = method104(s1 + i);
                byte[] abyte1 = new byte[6];
                datainputstream.readFully(abyte1, 0, 6);
                Buffer class35_sub2_sub3 = new Buffer(abyte1);
                class35_sub2_sub3.pos = 3;
                int k1 = class35_sub2_sub3.g3() + 6;
                int l1 = 6;
                abyte0 = new byte[k1];
                for (int i2 = 0; i2 < 6; i2++)
                    abyte0[i2] = abyte1[i2];

                while (l1 < k1) {
                    int j2 = k1 - l1;
                    if (j2 > 1000)
                        j2 = 1000;
                    l1 += datainputstream.read(abyte0, l1, j2);
                    int k2 = (l1 * 100) / k1;
                    if (k2 != i1)
                        showProgress((byte) -75, j, "Loading " + s + " - " + k2 + "%");
                    i1 = k2;
                }
                datainputstream.close();
            } catch (IOException _ex) {
                abyte0 = null;
                for (int j1 = k; j1 > 0; j1--) {
                    showProgress((byte) -75, j, "Error loading - Will retry in " + j1 + " secs.");
                    try {
                        Thread.sleep(1000L);
                    } catch (Exception _ex2) {
                    }
                }

                k *= 2;
                if (k > 60)
                    k = 60;
            }
        }
        signlink.cachesave(s1, abyte0);
        FileArchive class36_1 = new FileArchive(abyte0);
        return class36_1;
    }

    public void method25(int i) {
        if (i != 42545) {
            for (int j = 1; j > 0; j++) ;
        }
        Graphics g = method11(-36374).getGraphics();
        g.setColor(Color.black);
        g.fillRect(0, 0, 789, 532);
        method4((byte) 7, 1);
        if (errorLoading) {
            aBoolean906 = false;
            g.setFont(new java.awt.Font("Helvetica", 1, 16));
            g.setColor(Color.yellow);
            int k = 35;
            g.drawString("Sorry, an error has occured whilst loading RuneScape", 30, k);
            k += 50;
            g.setColor(Color.white);
            g.drawString("To fix this try the following (in order):", 30, k);
            k += 50;
            g.setColor(Color.white);
            g.setFont(new java.awt.Font("Helvetica", 1, 12));
            g.drawString("1: Try closing ALL open web-browser windows, and reloading", 30, k);
            k += 30;
            g.drawString("2: Try clearing your web-browsers cache from tools->internet options", 30, k);
            k += 30;
            g.drawString("3: Try using a different game-world", 30, k);
            k += 30;
            g.drawString("4: Try rebooting your computer", 30, k);
            k += 30;
            g.drawString("5: Try selecting a different version of Java from the play-game menu", 30, k);
        }
        if (errorHost) {
            aBoolean906 = false;
            g.setFont(new java.awt.Font("Helvetica", 1, 20));
            g.setColor(Color.white);
            g.drawString("Error - unable to load game!", 50, 50);
            g.drawString("To play RuneScape make sure you play from", 50, 100);
            g.drawString("http://www.runescape.com", 50, 150);
        }
        if (errorStarted) {
            aBoolean906 = false;
            g.setColor(Color.yellow);
            int l = 35;
            g.drawString("Error a copy of RuneScape already appears to be loaded", 30, l);
            l += 50;
            g.setColor(Color.white);
            g.drawString("To fix this try the following (in order):", 30, l);
            l += 50;
            g.setColor(Color.white);
            g.setFont(new java.awt.Font("Helvetica", 1, 12));
            g.drawString("1: Try closing ALL open web-browser windows, and reloading", 30, l);
            l += 30;
            g.drawString("2: Try rebooting your computer, and reloading", 30, l);
            l += 30;
        }
    }

    public boolean method26(int i) {
        if (i != 0)
            aBoolean828 = !aBoolean828;
        if (stream == null)
            return false;
        try {
            int j = stream.method152();
            if (j == 0)
                return false;
            if (packetOpcode == -1) {
                stream.method153(inBuffer.data, 0, 1);
                packetOpcode = inBuffer.data[0] & 0xff;
                if (isaac != null)
                    packetOpcode = packetOpcode - isaac.nextInt() & 0xff;
                packetLength = ServerProt.anIntArray33[packetOpcode];
                j--;
            }
            if (packetLength == -1)
                if (j > 0) {
                    stream.method153(inBuffer.data, 0, 1);
                    packetLength = inBuffer.data[0] & 0xff;
                    j--;
                } else {
                    return false;
                }
            if (packetLength == -2)
                if (j > 1) {
                    stream.method153(inBuffer.data, 0, 2);
                    inBuffer.pos = 0;
                    packetLength = inBuffer.g2();
                    j -= 2;
                } else {
                    return false;
                }
            if (j < packetLength)
                return false;
            inBuffer.pos = 0;
            stream.method153(inBuffer.data, 0, packetLength);
            anInt812 = 0;
            anInt905 = anInt904;
            anInt904 = anInt903;
            anInt903 = packetOpcode;
            if (packetOpcode == 55) {
                int k = inBuffer.g1();
                int j9 = inBuffer.g1();
                int k14 = inBuffer.g2();
                int i19 = inBuffer.g2();
                int l21 = -1;
                for (int j24 = 0; j24 < anIntArray854.length; j24++)
                    if (anIntArray854[j24] == (k << 8) + j9)
                        l21 = j24;

                if (l21 != -1) {
                    if (aByteArrayArray963[l21] == null || aByteArrayArray963[l21].length != i19)
                        aByteArrayArray963[l21] = new byte[i19];
                    inBuffer.gdata(aByteArrayArray963[l21], k14, packetLength - 6);
                }
                packetOpcode = -1;
                return true;
            }
            if (packetOpcode == 74) {
                aBoolean739 = false;
                aBoolean763 = true;
                aString947 = "";
                aBoolean653 = true;
                packetOpcode = -1;
                return true;
            }
            if (packetOpcode == 1) {
                int l = inBuffer.g1();
                int k9 = inBuffer.g1();
                int l14 = inBuffer.g1();
                int j19 = inBuffer.g1();
                aBooleanArray765[l] = true;
                anIntArray869[l] = k9;
                anIntArray829[l] = l14;
                anIntArray949[l] = j19;
                anIntArray967[l] = 0;
                packetOpcode = -1;
                return true;
            }
            if (packetOpcode == 86) {
                if (anInt907 == 12)
                    sidebarRedraw = true;
                anInt909 = inBuffer.g2();
                packetOpcode = -1;
                return true;
            }
            if (packetOpcode == 199) {
                int i1 = inBuffer.g2();
                int l9 = inBuffer.g2();
                NpcType class40 = NpcType.method434(l9);
                Component.aComponentArray110[i1].aModel_156 = class40.method437(0);
                packetOpcode = -1;
                return true;
            }
            if (packetOpcode == 78) {
                int j1 = inBuffer.g1();
                int i10 = inBuffer.g1();
                int i15 = -1;
                for (int k19 = 0; k19 < anIntArray854.length; k19++)
                    if (anIntArray854[k19] == (j1 << 8) + i10)
                        i15 = k19;

                if (i15 != -1) {
                    signlink.cachesave("l" + j1 + "_" + i10, aByteArrayArray880[i15]);
                    anInt969 = 1;
                }
                packetOpcode = -1;
                return true;
            }
            if (packetOpcode == 44 || packetOpcode == 19 || packetOpcode == 114 || packetOpcode == 17 || packetOpcode == 144 || packetOpcode == 96 || packetOpcode == 217 || packetOpcode == 171 || packetOpcode == 140) {
                method28(inBuffer, false, packetOpcode);
                packetOpcode = -1;
                return true;
            }
            if (packetOpcode == 136) {
                int k1 = inBuffer.g2();
                int j10 = inBuffer.g2();
                int j15 = j10 >> 10 & 0x1f;
                int l19 = j10 >> 5 & 0x1f;
                int i22 = j10 & 0x1f;
                Component.aComponentArray110[k1].anInt151 = (j15 << 19) + (l19 << 11) + (i22 << 3);
                packetOpcode = -1;
                return true;
            }
            if (packetOpcode == 187) {
                int l1 = inBuffer.g2();
                int k10 = inBuffer.g2();
                Component.aComponentArray110[l1].aModel_156 = new Model(k10, 298);
                packetOpcode = -1;
                return true;
            }
            if (packetOpcode == 168) {
                updatePlayers(15093, inBuffer, packetLength);
                if (anInt969 == 1) {
                    anInt969 = 2;
                    Scene.anInt48 = anInt722;
                    method77(0);
                }
                if (aBoolean663 && anInt969 == 2 && Scene.anInt48 != anInt722) {
                    aFrameBuffer_644.method234(-510);
                    p12.method370(true, 151, 0, 257, "Loading - please wait.");
                    p12.method370(true, 150, 0xffffff, 256, "Loading - please wait.");
                    aFrameBuffer_644.method235(8, super.aGraphics13, 11, aByte930);
                    Scene.anInt48 = anInt722;
                    method77(0);
                }
                if (anInt722 != anInt878 && anInt969 == 2) {
                    anInt878 = anInt722;
                    method108(false, anInt722);
                }
                packetOpcode = -1;
                return true;
            }
            if (packetOpcode == 76) {
                aBoolean682 = false;
                for (int i2 = 0; i2 < 5; i2++)
                    aBooleanArray765[i2] = false;

                packetOpcode = -1;
                return true;
            }
            if (packetOpcode == 200) {
                anInt907 = inBuffer.g1();
                sidebarRedraw = true;
                aBoolean992 = true;
                packetOpcode = -1;
                return true;
            }
            if (packetOpcode == 34) {
                aBoolean682 = true;
                anInt864 = inBuffer.g1();
                anInt865 = inBuffer.g1();
                anInt866 = inBuffer.g2();
                anInt867 = inBuffer.g1();
                anInt868 = inBuffer.g1();
                if (anInt868 >= 100) {
                    anInt918 = anInt864 * 128 + 64;
                    anInt920 = anInt865 * 128 + 64;
                    anInt919 = method15(anInt864, anInt865, anInt722, (byte) 9) - anInt866;
                }
                packetOpcode = -1;
                return true;
            }
            if (packetOpcode == 227) {
                int j2 = inBuffer.g2();
                int l10 = inBuffer.g2();
                if (anInt699 == j2 && anInt700 == l10 && anInt969 != 0) {
                    packetOpcode = -1;
                    return true;
                }
                anInt699 = j2;
                anInt700 = l10;
                anInt855 = (anInt699 - 6) * 8;
                anInt856 = (anInt700 - 6) * 8;
                anInt969 = 1;
                aFrameBuffer_644.method234(-510);
                p12.method370(true, 151, 0, 257, "Loading - please wait.");
                p12.method370(true, 150, 0xffffff, 256, "Loading - please wait.");
                aFrameBuffer_644.method235(8, super.aGraphics13, 11, aByte930);
                signlink.looprate(5);
                int k15 = (packetLength - 2) / 10;
                aByteArrayArray963 = new byte[k15][];
                aByteArrayArray880 = new byte[k15][];
                anIntArray854 = new int[k15];
                outBuffer.p1isaac(188);
                outBuffer.p1(0);
                int i20 = 0;
                for (int j22 = 0; j22 < k15; j22++) {
                    int k24 = inBuffer.g1();
                    int i26 = inBuffer.g1();
                    int i27 = inBuffer.g4();
                    int l27 = inBuffer.g4();
                    anIntArray854[j22] = (k24 << 8) + i26;
                    if (i27 != 0) {
                        byte[] abyte0 = signlink.cacheload("m" + k24 + "_" + i26);
                        if (abyte0 != null) {
                            aCRC32_639.reset();
                            aCRC32_639.update(abyte0);
                            if ((int) aCRC32_639.getValue() != i27)
                                abyte0 = null;
                        }
                        if (abyte0 != null) {
                            aByteArrayArray963[j22] = abyte0;
                        } else {
                            anInt969 = 0;
                            outBuffer.p1(0);
                            outBuffer.p1(k24);
                            outBuffer.p1(i26);
                            i20 += 3;
                        }
                    }
                    if (l27 != 0) {
                        byte[] abyte1 = signlink.cacheload("l" + k24 + "_" + i26);
                        if (abyte1 != null) {
                            aCRC32_639.reset();
                            aCRC32_639.update(abyte1);
                            if ((int) aCRC32_639.getValue() != l27)
                                abyte1 = null;
                        }
                        if (abyte1 != null) {
                            aByteArrayArray880[j22] = abyte1;
                        } else {
                            anInt969 = 0;
                            outBuffer.p1(1);
                            outBuffer.p1(k24);
                            outBuffer.p1(i26);
                            i20 += 3;
                        }
                    }
                }

                outBuffer.psize1(i20);
                signlink.looprate(100);
                int l24 = anInt855 - anInt857;
                int j26 = anInt856 - anInt858;
                anInt857 = anInt855;
                anInt858 = anInt856;
                for (int j27 = 0; j27 < 8192; j27++) {
                    NpcEntity class35_sub7_sub3_sub1 = aClass35_Sub7_Sub3_Sub1Array964[j27];
                    if (class35_sub7_sub3_sub1 != null) {
                        for (int j28 = 0; j28 < 10; j28++) {
                            class35_sub7_sub3_sub1.pathTileX[j28] -= l24;
                            class35_sub7_sub3_sub1.pathTileZ[j28] -= j26;
                        }

                        class35_sub7_sub3_sub1.x -= l24 * 128;
                        class35_sub7_sub3_sub1.z -= j26 * 128;
                    }
                }

                for (int i28 = 0; i28 < anInt749; i28++) {
                    PlayerEntity class35_sub7_sub3_sub2 = aPlayerEntityArray751[i28];
                    if (class35_sub7_sub3_sub2 != null) {
                        for (int k28 = 0; k28 < 10; k28++) {
                            class35_sub7_sub3_sub2.pathTileX[k28] -= l24;
                            class35_sub7_sub3_sub2.pathTileZ[k28] -= j26;
                        }

                        class35_sub7_sub3_sub2.x -= l24 * 128;
                        class35_sub7_sub3_sub2.z -= j26 * 128;
                    }
                }

                byte byte1 = 0;
                byte byte2 = 104;
                byte byte3 = 1;
                if (l24 < 0) {
                    byte1 = 103;
                    byte2 = -1;
                    byte3 = -1;
                }
                byte byte4 = 0;
                byte byte5 = 104;
                byte byte6 = 1;
                if (j26 < 0) {
                    byte4 = 103;
                    byte5 = -1;
                    byte6 = -1;
                }
                for (int i29 = byte1; i29 != byte2; i29 += byte3) {
                    for (int j29 = byte4; j29 != byte5; j29 += byte6) {
                        int k29 = i29 + l24;
                        int l29 = j29 + j26;
                        for (int i30 = 0; i30 < 4; i30++)
                            if (k29 >= 0 && l29 >= 0 && k29 < 104 && l29 < 104)
                                aLinkedListArrayArrayArray665[i30][i29][j29] = aLinkedListArrayArrayArray665[i30][k29][l29];
                            else
                                aLinkedListArrayArrayArray665[i30][i29][j29] = null;

                    }

                }

                for (SpawnedLoc class35_sub3_1 = (SpawnedLoc) aLinkedList_746.method227(); class35_sub3_1 != null; class35_sub3_1 = (SpawnedLoc) aLinkedList_746.method229(35239)) {
                    class35_sub3_1.anInt1022 -= l24;
                    class35_sub3_1.anInt1023 -= j26;
                    if (class35_sub3_1.anInt1022 < 0 || class35_sub3_1.anInt1023 < 0 || class35_sub3_1.anInt1022 >= 104 || class35_sub3_1.anInt1023 >= 104)
                        class35_sub3_1.method303();
                }

                aBoolean682 = false;
                packetOpcode = -1;
                return true;
            }
            if (packetOpcode == 197) {
                sidebarRedraw = true;
                int k2 = inBuffer.g2();
                byte byte0 = inBuffer.g1b();
                if (anIntArray822[k2] != byte0) {
                    anIntArray822[k2] = byte0;
                    method38(k2, (byte) 7);
                }
                packetOpcode = -1;
                return true;
            }
            if (packetOpcode == 141) {
                for (int l2 = 0; l2 < aPlayerEntityArray751.length; l2++)
                    if (aPlayerEntityArray751[l2] != null)
                        aPlayerEntityArray751[l2].anInt1235 = -1;

                for (int i11 = 0; i11 < aClass35_Sub7_Sub3_Sub1Array964.length; i11++)
                    if (aClass35_Sub7_Sub3_Sub1Array964[i11] != null)
                        aClass35_Sub7_Sub3_Sub1Array964[i11].anInt1235 = -1;

                packetOpcode = -1;
                return true;
            }
            if (packetOpcode == 38) {
                int i3 = inBuffer.g2();
                int j11 = inBuffer.g2();
                Component.aComponentArray110[i3].anInt158 = j11;
                packetOpcode = -1;
                return true;
            }
            if (packetOpcode == 134) {
                anInt851 = inBuffer.g1();
                anInt852 = inBuffer.g1();
                while (inBuffer.pos < packetLength) {
                    int j3 = inBuffer.g1();
                    method28(inBuffer, false, j3);
                }
                packetOpcode = -1;
                return true;
            }
            if (packetOpcode == 204) {
                anInt851 = inBuffer.g1();
                anInt852 = inBuffer.g1();
                for (int k3 = anInt851; k3 < anInt851 + 8; k3++) {
                    for (int k11 = anInt852; k11 < anInt852 + 8; k11++)
                        if (aLinkedListArrayArrayArray665[anInt722][k3][k11] != null) {
                            aLinkedListArrayArrayArray665[anInt722][k3][k11] = null;
                            method16(k3, k11);
                        }

                }

                for (SpawnedLoc class35_sub3 = (SpawnedLoc) aLinkedList_746.method227(); class35_sub3 != null; class35_sub3 = (SpawnedLoc) aLinkedList_746.method229(35239))
                    if (class35_sub3.anInt1022 >= anInt851 && class35_sub3.anInt1022 < anInt851 + 8 && class35_sub3.anInt1023 >= anInt852 && class35_sub3.anInt1023 < anInt852 + 8 && class35_sub3.anInt1020 == anInt722) {
                        method112(true, class35_sub3.anInt1020, class35_sub3.anInt1029, class35_sub3.anInt1023, class35_sub3.anInt1022, class35_sub3.anInt1021, class35_sub3.anInt1027, class35_sub3.anInt1028);
                        class35_sub3.method303();
                    }

                packetOpcode = -1;
                return true;
            }
            if (packetOpcode == 163) {
                anInt851 = inBuffer.g1();
                anInt852 = inBuffer.g1();
                packetOpcode = -1;
                return true;
            }
            if (packetOpcode == 157) {
                int l3 = inBuffer.g1();
                int l11 = inBuffer.g1();
                int l15 = inBuffer.g2();
                int j20 = inBuffer.g2();
                int k22 = -1;
                for (int i25 = 0; i25 < anIntArray854.length; i25++)
                    if (anIntArray854[i25] == (l3 << 8) + l11)
                        k22 = i25;

                if (k22 != -1) {
                    if (aByteArrayArray880[k22] == null || aByteArrayArray880[k22].length != j20)
                        aByteArrayArray880[k22] = new byte[j20];
                    inBuffer.gdata(aByteArrayArray880[k22], l15, packetLength - 6);
                }
                packetOpcode = -1;
                return true;
            }
            if (packetOpcode == 24) {
                anInt738 = inBuffer.g2() * 30;
                packetOpcode = -1;
                return true;
            }
            if (packetOpcode == 131) {
                int i4 = inBuffer.g2();
                int i12 = inBuffer.g2();
                int i16 = inBuffer.g2();
                Component class8_3 = Component.aComponentArray110[i4];
                Model class35_sub2_sub1 = class8_3.aModel_156;
                if (class35_sub2_sub1 != null)
                    class35_sub2_sub1.method317(i12, i16);
                packetOpcode = -1;
                return true;
            }
            if (packetOpcode == 20) {
                long l4 = inBuffer.g8();
                int j16 = inBuffer.g4();
                boolean flag1 = false;
                for (int l22 = 0; l22 < 100; l22++) {
                    if (anIntArray831[l22] != j16)
                        continue;
                    flag1 = true;
                    break;
                }

                for (int j25 = 0; j25 < anInt910; j25++) {
                    if (aLongArray685[j25] != l4)
                        continue;
                    flag1 = true;
                    break;
                }

                if (!flag1) {
                    anIntArray831[anInt683] = j16;
                    anInt683 = (anInt683 + 1) % 100;
                    String s6 = TextEncoder.method424(-17950, packetLength - 12, inBuffer);
                    s6 = WordPack.method196((byte) -82, s6);
                    method75(s6, 3, anInt853, StringUtils.method421(-580, StringUtils.fromBase37(true, l4)));
                }
                packetOpcode = -1;
                return true;
            }
            if (packetOpcode == 85) {
                sidebarRedraw = true;
                int j4 = inBuffer.g1();
                int j12 = inBuffer.g4();
                int k16 = inBuffer.g1();
                anIntArray777[j4] = j12;
                anIntArray948[j4] = k16;
                anIntArray840[j4] = 1;
                for (int k20 = 0; k20 < 98; k20++)
                    if (j12 >= anIntArray678[k20])
                        anIntArray840[j4] = k20 + 2;

                packetOpcode = -1;
                return true;
            }
            if (packetOpcode == 95) {
                anInt703 = inBuffer.g1();
                packetOpcode = -1;
                return true;
            }
            if (packetOpcode == 248) {
                int k4 = inBuffer.g2();
                boolean flag = inBuffer.g1() == 1;
                Component.aComponentArray110[k4].aBoolean130 = flag;
                packetOpcode = -1;
                return true;
            }
            if (packetOpcode == 253) {
                sidebarRedraw = true;
                int i5 = inBuffer.g2();
                Component class8 = Component.aComponentArray110[i5];
                int l16 = inBuffer.g1();
                for (int l20 = 0; l20 < l16; l20++) {
                    class8.anIntArray111[l20] = inBuffer.g2();
                    int i23 = inBuffer.g1();
                    if (i23 == 255)
                        i23 = inBuffer.g4();
                    class8.anIntArray112[l20] = i23;
                }

                for (int j23 = l16; j23 < class8.anIntArray111.length; j23++) {
                    class8.anIntArray111[j23] = 0;
                    class8.anIntArray112[j23] = 0;
                }

                packetOpcode = -1;
                return true;
            }
            if (packetOpcode == 210) {
                int component = inBuffer.g2();
                int sidebar = inBuffer.g1();
                tabComponentId[sidebar] = component;
                sidebarRedraw = true;
                packetOpcode = -1;
                return true;
            }
            if (packetOpcode == 192) {
                logout(anInt839);
                packetOpcode = -1;
                return false;
            }
            if (packetOpcode == 21) {
                if (aBoolean661) {
                    signlink.jingle = inBuffer.gstr();
                    signlink.jinglelen = inBuffer.g2();
                }
                packetOpcode = -1;
                return true;
            }
            if (packetOpcode == 243) {
                int k5 = inBuffer.g2();
                Component class8_1 = Component.aComponentArray110[k5];
                for (int i17 = 0; i17 < class8_1.anIntArray111.length; i17++) {
                    class8_1.anIntArray111[i17] = -1;
                    class8_1.anIntArray111[i17] = 0;
                }

                packetOpcode = -1;
                return true;
            }
            if (packetOpcode == 115) {
                int l5 = inBuffer.g2();
                method46(-553, l5);
                if (anInt702 != -1) {
                    anInt702 = -1;
                    aBoolean653 = true;
                }
                if (aBoolean763) {
                    aBoolean763 = false;
                    aBoolean653 = true;
                }
                anInt981 = l5;
                sidebarRedraw = true;
                aBoolean992 = true;
                anInt962 = -1;
                aBoolean888 = false;
                packetOpcode = -1;
                return true;
            }
            if (packetOpcode == 183) {
                method39(inBuffer, packetLength, 0);
                packetOpcode = -1;
                return true;
            }
            if (packetOpcode == 87) {
                int i6 = inBuffer.g2();
                Component.aComponentArray110[i6].aModel_156 = self.method415(true);
                packetOpcode = -1;
                return true;
            }
            if (packetOpcode == 137) {
                int j6 = inBuffer.g2();
                method46(-553, j6);
                if (anInt981 != -1) {
                    anInt981 = -1;
                    sidebarRedraw = true;
                    aBoolean992 = true;
                }
                if (anInt702 != -1) {
                    anInt702 = -1;
                    aBoolean653 = true;
                }
                if (aBoolean763) {
                    aBoolean763 = false;
                    aBoolean653 = true;
                }
                anInt962 = j6;
                aBoolean888 = false;
                packetOpcode = -1;
                return true;
            }
            if (packetOpcode == 50) {
                int k6 = inBuffer.g1();
                int l12 = inBuffer.g1();
                int j17 = -1;
                for (int i21 = 0; i21 < anIntArray854.length; i21++)
                    if (anIntArray854[i21] == (k6 << 8) + l12)
                        j17 = i21;

                if (j17 != -1) {
                    signlink.cachesave("m" + k6 + "_" + l12, aByteArrayArray963[j17]);
                    anInt969 = 1;
                }
                packetOpcode = -1;
                return true;
            }
            if (packetOpcode == 213) {
                long l6 = inBuffer.g8();
                int k17 = inBuffer.g1();
                String s5 = StringUtils.method421(-580, StringUtils.fromBase37(true, l6));
                for (int k23 = 0; k23 < anInt638; k23++) {
                    if (l6 != aLongArray971[k23])
                        continue;
                    if (anIntArray783[k23] != k17) {
                        anIntArray783[k23] = k17;
                        sidebarRedraw = true;
                        if (k17 > 0)
                            method75(s5 + " has logged in.", 5, anInt853, "");
                        if (k17 == 0)
                            method75(s5 + " has logged out.", 5, anInt853, "");
                    }
                    s5 = null;
                    break;
                }

                if (s5 != null && anInt638 < 100) {
                    aLongArray971[anInt638] = l6;
                    aStringArray701[anInt638] = s5;
                    anIntArray783[anInt638] = k17;
                    anInt638++;
                    sidebarRedraw = true;
                }
                for (boolean flag3 = false; !flag3; ) {
                    flag3 = true;
                    for (int k26 = 0; k26 < anInt638 - 1; k26++)
                        if (anIntArray783[k26] != anInt719 && anIntArray783[k26 + 1] == anInt719 || anIntArray783[k26] == 0 && anIntArray783[k26 + 1] != 0) {
                            int k27 = anIntArray783[k26];
                            anIntArray783[k26] = anIntArray783[k26 + 1];
                            anIntArray783[k26 + 1] = k27;
                            String s7 = aStringArray701[k26];
                            aStringArray701[k26] = aStringArray701[k26 + 1];
                            aStringArray701[k26 + 1] = s7;
                            long l28 = aLongArray971[k26];
                            aLongArray971[k26] = aLongArray971[k26 + 1];
                            aLongArray971[k26 + 1] = l28;
                            sidebarRedraw = true;
                            flag3 = false;
                        }

                }

                packetOpcode = -1;
                return true;
            }
            if (packetOpcode == 212) {
                if (anInt907 == 12)
                    sidebarRedraw = true;
                anInt955 = inBuffer.g1();
                packetOpcode = -1;
                return true;
            }
            if (packetOpcode == 54) {
                int i7 = inBuffer.g2();
                method46(-553, i7);
                if (anInt981 != -1) {
                    anInt981 = -1;
                    sidebarRedraw = true;
                    aBoolean992 = true;
                }
                anInt702 = i7;
                aBoolean653 = true;
                anInt962 = -1;
                aBoolean888 = false;
                packetOpcode = -1;
                return true;
            }
            if (packetOpcode == 98) {
                anInt976 = inBuffer.g1();
                anInt762 = inBuffer.g1();
                anInt821 = inBuffer.g1();
                aBoolean655 = true;
                aBoolean653 = true;
                packetOpcode = -1;
                return true;
            }
            if (packetOpcode == 16) {
                sidebarRedraw = true;
                int j7 = inBuffer.g2();
                Component class8_2 = Component.aComponentArray110[j7];
                while (inBuffer.pos < packetLength) {
                    int l17 = inBuffer.g1();
                    int j21 = inBuffer.g2();
                    int l23 = inBuffer.g1();
                    if (l23 == 255)
                        l23 = inBuffer.g4();
                    if (l17 >= 0 && l17 < class8_2.anIntArray111.length) {
                        class8_2.anIntArray111[l17] = j21;
                        class8_2.anIntArray112[l17] = l23;
                    }
                }
                packetOpcode = -1;
                return true;
            }
            if (packetOpcode == 128) {
                int k7 = inBuffer.g2();
                int i13 = inBuffer.g2();
                if (anInt702 != -1) {
                    anInt702 = -1;
                    aBoolean653 = true;
                }
                if (aBoolean763) {
                    aBoolean763 = false;
                    aBoolean653 = true;
                }
                anInt962 = k7;
                anInt981 = i13;
                sidebarRedraw = true;
                aBoolean992 = true;
                aBoolean888 = false;
                packetOpcode = -1;
                return true;
            }
            if (packetOpcode == 206) {
                String s = inBuffer.gstr();
                if (!s.equals(aString666)) {
                    aString666 = s;
                    if (aBoolean661)
                        signlink.midi = s;
                }
                packetOpcode = -1;
                return true;
            }
            if (packetOpcode == 108) {
                anInt686 = inBuffer.g2();
                packetOpcode = -1;
                return true;
            }
            if (packetOpcode == 240) {
                if (anInt981 != -1) {
                    anInt981 = -1;
                    sidebarRedraw = true;
                    aBoolean992 = true;
                }
                if (anInt702 != -1) {
                    anInt702 = -1;
                    aBoolean653 = true;
                }
                if (aBoolean763) {
                    aBoolean763 = false;
                    aBoolean653 = true;
                }
                anInt962 = -1;
                aBoolean888 = false;
                packetOpcode = -1;
                return true;
            }
            if (packetOpcode == 30) {
                sidebarRedraw = true;
                int l7 = inBuffer.g2();
                int j13 = inBuffer.g4();
                if (anIntArray822[l7] != j13) {
                    anIntArray822[l7] = j13;
                    method38(l7, (byte) 7);
                }
                packetOpcode = -1;
                return true;
            }
            if (packetOpcode == 93) {
                aBoolean682 = true;
                anInt790 = inBuffer.g1();
                anInt791 = inBuffer.g1();
                anInt792 = inBuffer.g2();
                anInt793 = inBuffer.g1();
                anInt794 = inBuffer.g1();
                if (anInt794 >= 100) {
                    int i8 = anInt790 * 128 + 64;
                    int k13 = anInt791 * 128 + 64;
                    int i18 = method15(anInt790, anInt791, anInt722, (byte) 9) - anInt792;
                    int k21 = i8 - anInt918;
                    int i24 = i18 - anInt919;
                    int k25 = k13 - anInt920;
                    int l26 = (int) Math.sqrt(k21 * k21 + k25 * k25);
                    anInt921 = (int) (Math.atan2(i24, l26) * 325.94900000000001D) & 0x7ff;
                    anInt922 = (int) (Math.atan2(k21, k25) * -325.94900000000001D) & 0x7ff;
                    if (anInt921 < 128)
                        anInt921 = 128;
                    if (anInt921 > 383)
                        anInt921 = 383;
                }
                packetOpcode = -1;
                return true;
            }
            if (packetOpcode == 138) {
                int j8 = inBuffer.g2();
                String s3 = inBuffer.gstr();
                Component.aComponentArray110[j8].aString149 = s3;
                packetOpcode = -1;
                return true;
            }
            if (packetOpcode == 10) {
                int k8 = inBuffer.g2();
                int l13 = inBuffer.g2();
                int j18 = inBuffer.g2();
                ObjType class41 = ObjType.method440(l13);
                Component.aComponentArray110[k8].aModel_156 = class41.method443();
                Component.aComponentArray110[k8].anInt161 = class41.anInt611;
                Component.aComponentArray110[k8].anInt162 = class41.anInt612;
                Component.aComponentArray110[k8].anInt160 = (class41.anInt610 * 100) / j18;
                packetOpcode = -1;
                return true;
            }
            if (packetOpcode == 164) {
                String s1 = inBuffer.gstr();
                if (s1.endsWith(":tradereq:")) {
                    String s4 = s1.substring(0, s1.indexOf(":"));
                    long l18 = StringUtils.toBase37(s4);
                    boolean flag2 = false;
                    for (int l25 = 0; l25 < anInt910; l25++) {
                        if (aLongArray685[l25] != l18)
                            continue;
                        flag2 = true;
                        break;
                    }

                    if (!flag2)
                        method75("wishes to trade with you.", 4, anInt853, s4);
                } else {
                    method75(s1, 0, anInt853, "");
                }
                packetOpcode = -1;
                return true;
            }
            if (packetOpcode == 175) {
                anInt910 = packetLength / 8;
                for (int l8 = 0; l8 < anInt910; l8++)
                    aLongArray685[l8] = inBuffer.g8();

                packetOpcode = -1;
                return true;
            }
            if (packetOpcode == 101) {
                int i9 = inBuffer.g2();
                int i14 = inBuffer.g2b();
                int k18 = inBuffer.g2b();
                Component class8_4 = Component.aComponentArray110[i9];
                class8_4.anInt122 = i14;
                class8_4.anInt123 = k18;
                packetOpcode = -1;
                return true;
            }
            signlink.reporterror("T1 - " + packetOpcode + "," + packetLength + " - " + anInt904 + "," + anInt905);
            logout(anInt839);
        } catch (IOException _ex) {
            method34(0);
        } catch (Exception exception) {
            String s2 = "T2 - " + packetOpcode + "," + anInt904 + "," + anInt905 + " - " + packetLength + "," + (anInt855 + self.pathTileX[0]) + "," + (anInt856 + self.pathTileZ[0]) + " - ";
            for (int j14 = 0; j14 < packetLength && j14 < 50; j14++)
                s2 = s2 + inBuffer.data[j14] + ",";

            signlink.reporterror(s2);
            logout(anInt839);
        }
        return true;
    }

    public void logout(int i) {
        try {
            if (stream != null)
                stream.method150();
        } catch (Exception _ex) {
        }
        stream = null;
        aBoolean734 = false;
        anInt915 = 0;
        while (i >= 0)
            outBuffer.p1(253);
        InputTracking.method160(6);
        aString743 = "";
        aString744 = "";
        aString745 = "";
        method57(anInt952);
        aMapSquare_741.method238(true);
        for (int j = 0; j < 4; j++)
            aCollisionMapArray737[j].method121((byte) 5);

        System.gc();
        if (aBoolean661)
            signlink.midi = "null";
        aString666 = null;
    }

    public void method28(Buffer class35_sub2_sub3, boolean flag, int i) {
        if (flag)
            aLinkedListArrayArrayArray665 = null;
        if (i == 140 || i == 171) {
            int j = class35_sub2_sub3.g1();
            int j2 = anInt851 + (j >> 4 & 7);
            int j4 = anInt852 + (j & 7);
            int j6 = class35_sub2_sub3.g1();
            int j8 = j6 >> 2;
            int l9 = j6 & 3;
            int i11 = anIntArray900[j8];
            int i12;
            if (i == 171)
                i12 = -1;
            else
                i12 = class35_sub2_sub3.g2();
            if (j2 >= 0 && j4 >= 0 && j2 < 104 && j4 < 104) {
                SpawnedLoc class35_sub3 = null;
                for (SpawnedLoc class35_sub3_1 = (SpawnedLoc) aLinkedList_746.method227(); class35_sub3_1 != null; class35_sub3_1 = (SpawnedLoc) aLinkedList_746.method229(35239)) {
                    if (class35_sub3_1.anInt1020 != anInt722 || class35_sub3_1.anInt1022 != j2 || class35_sub3_1.anInt1023 != j4 || class35_sub3_1.anInt1021 != i11)
                        continue;
                    class35_sub3 = class35_sub3_1;
                    break;
                }

                if (class35_sub3 == null) {
                    int i14 = 0;
                    int l14 = -1;
                    int j15 = 0;
                    int l15 = 0;
                    if (i11 == 0)
                        i14 = aMapSquare_741.method262(anInt722, j2, j4);
                    if (i11 == 1)
                        i14 = aMapSquare_741.method263(j2, j4, anInt845, anInt722);
                    if (i11 == 2)
                        i14 = aMapSquare_741.method264(anInt722, j2, j4);
                    if (i11 == 3)
                        i14 = aMapSquare_741.method265(anInt722, j2, j4);
                    if (i14 != 0) {
                        int i16 = aMapSquare_741.method266(anInt722, j2, j4, i14);
                        l14 = i14 >> 14 & 0x7fff;
                        j15 = i16 & 0x1f;
                        l15 = i16 >> 6;
                    }
                    class35_sub3 = new SpawnedLoc();
                    class35_sub3.anInt1020 = anInt722;
                    class35_sub3.anInt1021 = i11;
                    class35_sub3.anInt1022 = j2;
                    class35_sub3.anInt1023 = j4;
                    class35_sub3.anInt1027 = l14;
                    class35_sub3.anInt1029 = j15;
                    class35_sub3.anInt1028 = l15;
                    aLinkedList_746.pushNext(class35_sub3);
                }
                class35_sub3.anInt1024 = i12;
                class35_sub3.anInt1026 = j8;
                class35_sub3.anInt1025 = l9;
                method112(true, anInt722, j8, j4, j2, i11, i12, l9);
            }
            return;
        }
        if (i == 217) {
            int k = class35_sub2_sub3.g1();
            int k2 = anInt851 + (k >> 4 & 7);
            int k4 = anInt852 + (k & 7);
            int k6 = class35_sub2_sub3.g1();
            int k8 = k6 >> 2;
            int i10 = anIntArray900[k8];
            int j11 = class35_sub2_sub3.g2();
            if (k2 >= 0 && k4 >= 0 && k2 < 104 && k4 < 104) {
                int j12 = 0;
                if (i10 == 1)
                    j12 = aMapSquare_741.method263(k2, k4, anInt845, anInt722);
                if (i10 == 2)
                    j12 = aMapSquare_741.method264(anInt722, k2, k4);
                if (j12 != 0) {
                    LocEntity class35_sub5 = new LocEntity(i10, -69, anInt722, j12 >> 14 & 0x7fff, false, SeqType.aSeqTypeArray190[j11], k4, k2);
                    aLinkedList_943.pushNext(class35_sub5);
                }
            }
            return;
        }
        if (i == 96) {
            int l = class35_sub2_sub3.g1();
            int l2 = anInt851 + (l >> 4 & 7);
            int l4 = anInt852 + (l & 7);
            int l6 = class35_sub2_sub3.g2();
            if (l2 >= 0 && l4 >= 0 && l2 < 104 && l4 < 104) {
                ObjStackEntity class35_sub6 = new ObjStackEntity();
                class35_sub6.anInt1047 = l6;
                if (aLinkedListArrayArrayArray665[anInt722][l2][l4] == null)
                    aLinkedListArrayArrayArray665[anInt722][l2][l4] = new LinkedList(5);
                aLinkedListArrayArrayArray665[anInt722][l2][l4].pushNext(class35_sub6);
                method16(l2, l4);
            }
            return;
        }
        if (i == 144) {
            int i1 = class35_sub2_sub3.g1();
            int i3 = anInt851 + (i1 >> 4 & 7);
            int i5 = anInt852 + (i1 & 7);
            int i7 = class35_sub2_sub3.g2();
            if (i3 >= 0 && i5 >= 0 && i3 < 104 && i5 < 104) {
                LinkedList class24 = aLinkedListArrayArrayArray665[anInt722][i3][i5];
                if (class24 != null) {
                    for (ObjStackEntity class35_sub6_1 = (ObjStackEntity) class24.method227(); class35_sub6_1 != null; class35_sub6_1 = (ObjStackEntity) class24.method229(35239)) {
                        if (class35_sub6_1.anInt1047 != (i7 & 0x7fff))
                            continue;
                        class35_sub6_1.method303();
                        break;
                    }

                    if (class24.method227() == null)
                        aLinkedListArrayArrayArray665[anInt722][i3][i5] = null;
                    method16(i3, i5);
                }
            }
            return;
        }
        if (i == 17) {
            int j1 = class35_sub2_sub3.g1();
            int j3 = anInt851 + (j1 >> 4 & 7);
            int j5 = anInt852 + (j1 & 7);
            int j7 = j3 + class35_sub2_sub3.g1b();
            int l8 = j5 + class35_sub2_sub3.g1b();
            int j10 = class35_sub2_sub3.g2b();
            int k11 = class35_sub2_sub3.g2();
            int k12 = class35_sub2_sub3.g1();
            int i13 = class35_sub2_sub3.g1();
            int k13 = class35_sub2_sub3.g2();
            int j14 = class35_sub2_sub3.g2();
            int i15 = class35_sub2_sub3.g1();
            int k15 = class35_sub2_sub3.g1();
            if (j3 >= 0 && j5 >= 0 && j3 < 104 && j5 < 104 && j7 >= 0 && l8 >= 0 && j7 < 104 && l8 < 104) {
                j3 = j3 * 128 + 64;
                j5 = j5 * 128 + 64;
                j7 = j7 * 128 + 64;
                l8 = l8 * 128 + 64;
                ProjectileEntity class35_sub7_sub1 = new ProjectileEntity(j3, -35843, j14 + anInt759, k15, k11, method15(j3, j5, anInt722, (byte) 9) - k12, anInt722, j10, k13 + anInt759, i15, j5, i13);
                class35_sub7_sub1.method406(method15(j7, l8, anInt722, (byte) 9) - i13, l8, k13 + anInt759, j7, aBoolean908);
                aLinkedList_863.pushNext(class35_sub7_sub1);
            }
            return;
        }
        if (i == 114) {
            int k1 = class35_sub2_sub3.g1();
            int k3 = anInt851 + (k1 >> 4 & 7);
            int k5 = anInt852 + (k1 & 7);
            int k7 = class35_sub2_sub3.g2();
            int i9 = class35_sub2_sub3.g1();
            int k10 = class35_sub2_sub3.g2();
            if (k3 >= 0 && k5 >= 0 && k3 < 104 && k5 < 104) {
                k3 = k3 * 128 + 64;
                k5 = k5 * 128 + 64;
                SpotAnimEntity class35_sub7_sub2 = new SpotAnimEntity(k5, false, method15(k3, k5, anInt722, (byte) 9) - i9, k3, k10, k7, anInt759, anInt722);
                aLinkedList_657.pushNext(class35_sub7_sub2);
            }
            return;
        }
        if (i == 19) {
            int l1 = class35_sub2_sub3.g1();
            int l3 = anInt851 + (l1 >> 4 & 7);
            int l5 = anInt852 + (l1 & 7);
            int l7 = class35_sub2_sub3.g2();
            int j9 = class35_sub2_sub3.g2();
            if (l3 >= 0 && l5 >= 0 && l3 < 104 && l5 < 104 && j9 != anInt686) {
                ObjStackEntity class35_sub6_2 = new ObjStackEntity();
                class35_sub6_2.anInt1047 = l7;
                if (aLinkedListArrayArrayArray665[anInt722][l3][l5] == null)
                    aLinkedListArrayArrayArray665[anInt722][l3][l5] = new LinkedList(5);
                aLinkedListArrayArrayArray665[anInt722][l3][l5].pushNext(class35_sub6_2);
                method16(l3, l5);
            }
            return;
        }
        if (i == 44) {
            int i2 = class35_sub2_sub3.g1();
            int i4 = anInt851 + (i2 >> 4 & 7);
            int i6 = anInt852 + (i2 & 7);
            int i8 = class35_sub2_sub3.g1();
            int k9 = i8 >> 2;
            int l10 = i8 & 3;
            int l11 = anIntArray900[k9];
            int l12 = class35_sub2_sub3.g2();
            int j13 = class35_sub2_sub3.g2();
            int l13 = class35_sub2_sub3.g2();
            int k14 = class35_sub2_sub3.g2();
            byte byte0 = class35_sub2_sub3.g1b();
            byte byte1 = class35_sub2_sub3.g1b();
            byte byte2 = class35_sub2_sub3.g1b();
            byte byte3 = class35_sub2_sub3.g1b();
            PlayerEntity class35_sub7_sub3_sub2;
            if (k14 == anInt686)
                class35_sub7_sub3_sub2 = self;
            else
                class35_sub7_sub3_sub2 = aPlayerEntityArray751[k14];
            if (class35_sub7_sub3_sub2 != null) {
                TemporaryLoc class35_sub4 = new TemporaryLoc(j13 + anInt759, i4, i6, k9, false, l11, anInt722, l10, -1);
                aLinkedList_652.pushNext(class35_sub4);
                TemporaryLoc class35_sub4_1 = new TemporaryLoc(l13 + anInt759, i4, i6, k9, false, l11, anInt722, l10, l12);
                aLinkedList_652.pushNext(class35_sub4_1);
                int j16 = anIntArrayArrayArray725[anInt722][i4][i6];
                int k16 = anIntArrayArrayArray725[anInt722][i4 + 1][i6];
                int l16 = anIntArrayArrayArray725[anInt722][i4 + 1][i6 + 1];
                int i17 = anIntArrayArrayArray725[anInt722][i4][i6 + 1];
                LocType class39 = LocType.method428(l12);
                class35_sub7_sub3_sub2.anInt1337 = j13 + anInt759;
                class35_sub7_sub3_sub2.anInt1338 = l13 + anInt759;
                class35_sub7_sub3_sub2.aModel_1342 = class39.method431(k9, l10, j16, k16, l16, i17, -1);
                int j17 = class39.anInt542;
                int k17 = class39.anInt543;
                if (l10 == 1 || l10 == 3) {
                    j17 = class39.anInt543;
                    k17 = class39.anInt542;
                }
                class35_sub7_sub3_sub2.anInt1339 = i4 * 128 + j17 * 64;
                class35_sub7_sub3_sub2.anInt1341 = i6 * 128 + k17 * 64;
                class35_sub7_sub3_sub2.anInt1340 = method15(class35_sub7_sub3_sub2.anInt1339, class35_sub7_sub3_sub2.anInt1341, anInt722, (byte) 9);
                if (byte0 > byte2) {
                    byte byte4 = byte0;
                    byte0 = byte2;
                    byte2 = byte4;
                }
                if (byte1 > byte3) {
                    byte byte5 = byte1;
                    byte1 = byte3;
                    byte3 = byte5;
                }
                class35_sub7_sub3_sub2.anInt1343 = i4 + byte0;
                class35_sub7_sub3_sub2.anInt1345 = i4 + byte2;
                class35_sub7_sub3_sub2.anInt1344 = i6 + byte1;
                class35_sub7_sub3_sub2.anInt1346 = i6 + byte3;
            }
        }
    }

    public void run() {
        if (!aBoolean740) {
            super.run();
            return;
        }
        aBoolean726 = true;
        try {
            long l = System.currentTimeMillis();
            int i = 0;
            int j = 20;
            while (aBoolean906) {
                method49((byte) 71);
                method49((byte) 71);
                method14(true);
                if (++i > 10) {
                    long l1 = System.currentTimeMillis();
                    int k = (int) (l1 - l) / 10 - j;
                    j = 40 - k;
                    if (j < 5)
                        j = 5;
                    i = 0;
                    l = l1;
                }
                try {
                    Thread.sleep(j);
                } catch (Exception _ex) {
                }
            }
        } catch (Exception _ex) {
        }
        aBoolean726 = false;
    }

    public void updateNewPlayers(Buffer class35_sub2_sub3, int i, int j) {
        while (class35_sub2_sub3.bitOffset + 10 < i * 8) {
            int k = class35_sub2_sub3.gBit(11);
            if (k == 2047)
                break;
            if (aPlayerEntityArray751[k] == null) {
                aPlayerEntityArray751[k] = new PlayerEntity();
                if (aClass35_Sub2_Sub3Array756[k] != null)
                    aPlayerEntityArray751[k].method413(aClass35_Sub2_Sub3Array756[k], true);
            }
            anIntArray753[anInt752++] = k;
            PlayerEntity class35_sub7_sub3_sub2 = aPlayerEntityArray751[k];
            class35_sub7_sub3_sub2.anInt1252 = anInt759;
            int i1 = class35_sub2_sub3.gBit(5);
            if (i1 > 15)
                i1 -= 32;
            int j1 = class35_sub2_sub3.gBit(5);
            if (j1 > 15)
                j1 -= 32;
            class35_sub7_sub3_sub2.method409((byte) 28, self.pathTileX[0] + i1, self.pathTileZ[0] + j1);
            anIntArray755[anInt754++] = k;
        }
        class35_sub2_sub3.accessBytes();
        if (j >= 0) {
            for (int l = 1; l > 0; l++) ;
        }
    }

    public void method30(int i) {
        int j = b12.method372("Choose Option", true);
        for (int k = 0; k < anInt710; k++) {
            int l = b12.method372(aStringArray720[k], true);
            if (l > j)
                j = l;
        }

        if (i != anInt781)
            packetOpcode = inBuffer.g1();
        j += 8;
        int i1 = 15 * anInt710 + 21;
        if (super.anInt23 > 8 && super.anInt24 > 11 && super.anInt23 < 520 && super.anInt24 < 345) {
            int j1 = super.anInt23 - 8 - j / 2;
            if (j1 + j > 512)
                j1 = 512 - j;
            if (j1 < 0)
                j1 = 0;
            int l1 = super.anInt24 - 11;
            if (l1 + i1 > 334)
                l1 = 334 - i1;
            if (l1 < 0)
                l1 = 0;
            aBoolean838 = true;
            anInt667 = 0;
            anInt668 = j1;
            anInt669 = l1;
            anInt670 = j;
            anInt671 = 15 * anInt710 + 22;
        }
        if (super.anInt23 > 562 && super.anInt24 > 231 && super.anInt23 < 752 && super.anInt24 < 492) {
            int k1 = super.anInt23 - 562 - j / 2;
            if (k1 < 0)
                k1 = 0;
            else if (k1 + j > 190)
                k1 = 190 - j;
            int i2 = super.anInt24 - 231;
            if (i2 < 0)
                i2 = 0;
            else if (i2 + i1 > 261)
                i2 = 261 - i1;
            aBoolean838 = true;
            anInt667 = 1;
            anInt668 = k1;
            anInt669 = i2;
            anInt670 = j;
            anInt671 = 15 * anInt710 + 22;
        }
    }

    public void method31(boolean flag) {
        if (flag)
            anInt711 = isaac.nextInt();
        if (anInt969 == 2) {
            for (TemporaryLoc class35_sub4 = (TemporaryLoc) aLinkedList_652.method227(); class35_sub4 != null; class35_sub4 = (TemporaryLoc) aLinkedList_652.method229(35239))
                if (anInt759 >= class35_sub4.anInt1037) {
                    method112(true, class35_sub4.anInt1030, class35_sub4.anInt1036, class35_sub4.anInt1033, class35_sub4.anInt1032, class35_sub4.anInt1031, class35_sub4.anInt1034, class35_sub4.anInt1035);
                    class35_sub4.method303();
                }

        }
    }

    public void method32(int i) {
        i = 49 / i;
        do {
            int j = method5(6542);
            if (j == -1)
                break;
            if (aBoolean739) {
                if (j >= 32 && j <= 122 && aString887.length() < 80) {
                    aString887 += (char) j;
                    aBoolean653 = true;
                }
                if (j == 8 && aString887.length() > 0) {
                    aString887 = aString887.substring(0, aString887.length() - 1);
                    aBoolean653 = true;
                }
                if (j == 13 || j == 10) {
                    aBoolean739 = false;
                    aBoolean653 = true;
                    if (anInt975 == 1 && anInt638 < 100) {
                        long l = StringUtils.toBase37(aString887);
                        aString887 = StringUtils.method421(-580, StringUtils.fromBase37(true, l));
                        if (l != 0L) {
                            boolean flag = false;
                            for (int i3 = 0; i3 < anInt638; i3++) {
                                if (aLongArray971[i3] != l)
                                    continue;
                                method75(aString887 + " is already on your friend list", 0, anInt853, "");
                                flag = true;
                                break;
                            }

                            for (int j4 = 0; j4 < anInt910; j4++) {
                                if (aLongArray685[j4] != l)
                                    continue;
                                method75("Please remove " + aString887 + " from your ignore list first", 0, anInt853, "");
                                flag = true;
                                break;
                            }

                            if (aString887.equals(self.name))
                                flag = true;
                            if (!flag) {
                                aStringArray701[anInt638] = aString887;
                                aLongArray971[anInt638] = l;
                                anIntArray783[anInt638] = 0;
                                anInt638++;
                                sidebarRedraw = true;
                                outBuffer.p1isaac(28);
                                outBuffer.p8(l);
                            }
                        }
                    }
                    if (anInt975 == 2 && anInt638 > 0) {
                        long l1 = StringUtils.toBase37(aString887);
                        aString887 = StringUtils.method421(-580, StringUtils.fromBase37(true, l1));
                        if (l1 != 0L) {
                            for (int i2 = 0; i2 < anInt638; i2++) {
                                if (aLongArray971[i2] != l1)
                                    continue;
                                anInt638--;
                                sidebarRedraw = true;
                                for (int j3 = i2; j3 < anInt638; j3++) {
                                    aStringArray701[j3] = aStringArray701[j3 + 1];
                                    anIntArray783[j3] = anIntArray783[j3 + 1];
                                    aLongArray971[j3] = aLongArray971[j3 + 1];
                                }

                                outBuffer.p1isaac(195);
                                outBuffer.p8(l1);
                                break;
                            }

                        }
                    }
                    if (anInt975 == 3 && aString887.length() > 0 && anInt641 >= 0 && anInt641 < anInt638) {
                        outBuffer.p1isaac(74);
                        outBuffer.p1(0);
                        int k = outBuffer.pos;
                        outBuffer.p8(aLongArray971[anInt641]);
                        TextEncoder.method425(aString887, true, outBuffer);
                        outBuffer.psize1(outBuffer.pos - k);
                        aString887 = StringUtils.method422(-4442, aString887);
                        aString887 = WordPack.method196((byte) -82, aString887);
                        method75(aString887, 6, anInt853, aStringArray701[anInt641]);
                        if (anInt762 == 2) {
                            anInt762 = 1;
                            aBoolean655 = true;
                            outBuffer.p1isaac(227);
                            outBuffer.p1(anInt976);
                            outBuffer.p1(anInt762);
                            outBuffer.p1(anInt821);
                        }
                    }
                    if (anInt975 == 4 && anInt910 < 100 && aString887.length() > 0) {
                        long l2 = StringUtils.toBase37(aString887);
                        boolean flag1 = false;
                        for (int k3 = 0; k3 < anInt910; k3++) {
                            if (aLongArray685[k3] != l2)
                                continue;
                            method75(aString887 + " is already on your ignore list", 0, anInt853, "");
                            flag1 = true;
                            break;
                        }

                        for (int k4 = 0; k4 < anInt638; k4++) {
                            if (aLongArray971[k4] != l2)
                                continue;
                            method75("Please remove " + aString887 + " from your friend list first", 0, anInt853, "");
                            flag1 = true;
                            break;
                        }

                        if (!flag1) {
                            aLongArray685[anInt910++] = l2;
                            sidebarRedraw = true;
                            outBuffer.p1isaac(170);
                            outBuffer.p8(l2);
                        }
                    }
                    if (anInt975 == 5 && anInt910 > 0 && aString887.length() > 0) {
                        long l3 = StringUtils.toBase37(aString887);
                        for (int j2 = 0; j2 < anInt910; j2++) {
                            if (aLongArray685[j2] != l3)
                                continue;
                            anInt910--;
                            sidebarRedraw = true;
                            for (int i4 = j2; i4 < anInt910; i4++)
                                aLongArray685[i4] = aLongArray685[i4 + 1];

                            outBuffer.p1isaac(97);
                            outBuffer.p8(l3);
                            break;
                        }

                    }
                }
            } else if (aBoolean763) {
                if (j >= 48 && j <= 57 && aString947.length() < 10) {
                    aString947 += (char) j;
                    aBoolean653 = true;
                }
                if (j == 8 && aString947.length() > 0) {
                    aString947 = aString947.substring(0, aString947.length() - 1);
                    aBoolean653 = true;
                }
                if (j == 13 || j == 10) {
                    if (aString947.length() > 0) {
                        int i1 = 0;
                        try {
                            i1 = Integer.parseInt(aString947);
                        } catch (Exception _ex) {
                        }
                        outBuffer.p1isaac(41);
                        outBuffer.p4(i1);
                    }
                    aBoolean763 = false;
                    aBoolean653 = true;
                }
            } else if (anInt702 == -1) {
                if (j >= 32 && j <= 122 && aString784.length() < 80) {
                    aString784 += (char) j;
                    aBoolean653 = true;
                }
                if (j == 8 && aString784.length() > 0) {
                    aString784 = aString784.substring(0, aString784.length() - 1);
                    aBoolean653 = true;
                }
                if ((j == 13 || j == 10) && aString784.length() > 0) {
                    if (aString784.equals("::clientdrop") && super.aGameFrame__16 != null)
                        method34(0);
                    else if (aString784.startsWith("::")) {
                        outBuffer.p1isaac(237);
                        outBuffer.p1(aString784.length() - 1);
                        outBuffer.pjstr(aString784.substring(2));
                    } else {
                        int j1 = 0;
                        if (aString784.startsWith("yellow:")) {
                            j1 = 0;
                            aString784 = aString784.substring(7);
                        }
                        if (aString784.startsWith("red:")) {
                            j1 = 1;
                            aString784 = aString784.substring(4);
                        }
                        if (aString784.startsWith("green:")) {
                            j1 = 2;
                            aString784 = aString784.substring(6);
                        }
                        if (aString784.startsWith("cyan:")) {
                            j1 = 3;
                            aString784 = aString784.substring(5);
                        }
                        if (aString784.startsWith("purple:")) {
                            j1 = 4;
                            aString784 = aString784.substring(7);
                        }
                        if (aString784.startsWith("white:")) {
                            j1 = 5;
                            aString784 = aString784.substring(6);
                        }
                        if (aString784.startsWith("flash1:")) {
                            j1 = 6;
                            aString784 = aString784.substring(7);
                        }
                        if (aString784.startsWith("flash2:")) {
                            j1 = 7;
                            aString784 = aString784.substring(7);
                        }
                        if (aString784.startsWith("flash3:")) {
                            j1 = 8;
                            aString784 = aString784.substring(7);
                        }
                        if (aString784.startsWith("glow1:")) {
                            j1 = 9;
                            aString784 = aString784.substring(6);
                        }
                        if (aString784.startsWith("glow2:")) {
                            j1 = 10;
                            aString784 = aString784.substring(6);
                        }
                        if (aString784.startsWith("glow3:")) {
                            j1 = 11;
                            aString784 = aString784.substring(6);
                        }
                        int k1 = 0;
                        if (aString784.startsWith("wave:")) {
                            k1 = 1;
                            aString784 = aString784.substring(5);
                        }
                        if (aString784.startsWith("scroll:")) {
                            k1 = 2;
                            aString784 = aString784.substring(7);
                        }
                        outBuffer.p1isaac(54);
                        outBuffer.p1(0);
                        int k2 = outBuffer.pos;
                        outBuffer.p1(j1);
                        outBuffer.p1(k1);
                        TextEncoder.method425(aString784, true, outBuffer);
                        outBuffer.psize1(outBuffer.pos - k2);
                        aString784 = StringUtils.method422(-4442, aString784);
                        aString784 = WordPack.method196((byte) -82, aString784);
                        self.aString1220 = aString784;
                        self.anInt1222 = j1;
                        self.anInt1223 = k1;
                        self.anInt1221 = 150;
                        method75(self.aString1220, 2, anInt853, self.name);
                        if (anInt976 == 2) {
                            anInt976 = 1;
                            aBoolean655 = true;
                            outBuffer.p1isaac(227);
                            outBuffer.p1(anInt976);
                            outBuffer.p1(anInt762);
                            outBuffer.p1(anInt821);
                        }
                    }
                    aString784 = "";
                    aBoolean653 = true;
                }
            }
        } while (true);
    }

    public void method33(byte byte0, int i) {
        if (byte0 != 6)
            anInt882 = 80;
        if (!aBoolean663 && Draw3D.anIntArray1281[17] >= i) {
            IndexedSprite class35_sub2_sub2_sub3 = Draw3D.aClass35_Sub2_Sub2_Sub3Array1275[17];
            int j = class35_sub2_sub2_sub3.anInt1306 * class35_sub2_sub2_sub3.anInt1307 - 1;
            int k = class35_sub2_sub2_sub3.anInt1306 * anInt742 * 2;
            byte[] abyte0 = class35_sub2_sub2_sub3.aByteArray1304;
            byte[] abyte1 = aByteArray850;
            for (int l = 0; l <= j; l++)
                abyte1[l] = abyte0[l - k & j];

            class35_sub2_sub2_sub3.aByteArray1304 = abyte1;
            aByteArray850 = abyte0;
            Draw3D.method344(28230, 17);
        }
    }

    public void method34(int i) {
        aFrameBuffer_644.method234(-510);
        p12.method370(true, 144, 0, 257, "Connection lost");
        p12.method370(true, 143, 0xffffff, 256, "Connection lost");
        p12.method370(true, 159, 0, 257, "Please wait - attempting to reestablish");
        p12.method370(true, 158, 0xffffff, 256, "Please wait - attempting to reestablish");
        aFrameBuffer_644.method235(8, super.aGraphics13, 11, aByte930);
        BufferedStream class5 = stream;
        aBoolean734 = false;
        if (i < 0 || i > 0) {
            for (int j = 1; j > 0; j++) ;
        }
        login(aString743, aString744, method71(-31414), true);
        if (!aBoolean734)
            logout(anInt839);
        try {
            class5.method150();
            return;
        } catch (Exception _ex) {
            return;
        }
    }

    public void method35(int i, byte byte0, Buffer class35_sub2_sub3) {
        class35_sub2_sub3.accessBits();
        if (byte0 != 6)
            return;
        int j = class35_sub2_sub3.gBit(8);
        if (j < anInt965) {
            for (int k = j; k < anInt965; k++)
                anIntArray834[anInt833++] = anIntArray966[k];

        }
        if (j > anInt965) {
            signlink.reporterror(aString743 + " Too many npcs");
            throw new RuntimeException("eek");
        }
        anInt965 = 0;
        for (int l = 0; l < j; l++) {
            int i1 = anIntArray966[l];
            NpcEntity class35_sub7_sub3_sub1 = aClass35_Sub7_Sub3_Sub1Array964[i1];
            int j1 = class35_sub2_sub3.gBit(1);
            if (j1 == 0) {
                anIntArray966[anInt965++] = i1;
                class35_sub7_sub3_sub1.anInt1252 = anInt759;
            } else {
                int k1 = class35_sub2_sub3.gBit(2);
                if (k1 == 0) {
                    anIntArray966[anInt965++] = i1;
                    class35_sub7_sub3_sub1.anInt1252 = anInt759;
                    anIntArray755[anInt754++] = i1;
                } else if (k1 == 1) {
                    anIntArray966[anInt965++] = i1;
                    class35_sub7_sub3_sub1.anInt1252 = anInt759;
                    int l1 = class35_sub2_sub3.gBit(3);
                    class35_sub7_sub3_sub1.method410(false, l1, 112);
                    int j2 = class35_sub2_sub3.gBit(1);
                    if (j2 == 1)
                        anIntArray755[anInt754++] = i1;
                } else if (k1 == 2) {
                    anIntArray966[anInt965++] = i1;
                    class35_sub7_sub3_sub1.anInt1252 = anInt759;
                    int i2 = class35_sub2_sub3.gBit(3);
                    class35_sub7_sub3_sub1.method410(true, i2, 112);
                    int k2 = class35_sub2_sub3.gBit(3);
                    class35_sub7_sub3_sub1.method410(true, k2, 112);
                    int l2 = class35_sub2_sub3.gBit(1);
                    if (l2 == 1)
                        anIntArray755[anInt754++] = i1;
                } else if (k1 == 3)
                    anIntArray834[anInt833++] = i1;
            }
        }

    }

    public void method36(boolean flag) {
        for (int i = -1; i < anInt752 + anInt965; i++) {
            Object obj;
            if (i == -1)
                obj = self;
            else if (i < anInt752)
                obj = aPlayerEntityArray751[anIntArray753[i]];
            else
                obj = aClass35_Sub7_Sub3_Sub1Array964[anIntArray966[i - anInt752]];
            if (obj != null && ((PathingEntity) (obj)).method411(0)) {
                if (i < anInt752) {
                    PlayerEntity class35_sub7_sub3_sub2 = (PlayerEntity) obj;
                    if (class35_sub7_sub3_sub2.headicons != 0) {
                        method43(((PathingEntity) (obj)).anInt1253 + 15, aByte680, ((PathingEntity) (obj)));
                        if (anInt757 > -1) {
                            int l = 28;
                            for (int i2 = 0; i2 < 8; i2++)
                                if ((class35_sub7_sub3_sub2.headicons & 1 << i2) != 0) {
                                    aSpriteArray843[i2].method357(anInt758 - l, anInt861, anInt757 - 12);
                                    l -= 25;
                                }

                        }
                    }
                }
                if (((PathingEntity) (obj)).aString1220 != null && (i >= anInt752 || anInt976 == 0 || anInt976 == 1 && method72(7, ((PlayerEntity) obj).name))) {
                    method43(((PathingEntity) (obj)).anInt1253, aByte680, ((PathingEntity) (obj)));
                    if (anInt757 > -1)
                        if (anInt942 == 0) {
                            int j = 0xffff00;
                            if (((PathingEntity) (obj)).anInt1222 < 6)
                                j = anIntArray860[((PathingEntity) (obj)).anInt1222];
                            if (((PathingEntity) (obj)).anInt1222 == 6)
                                j = anInt778 % 20 >= 10 ? 0xffff00 : 0xff0000;
                            if (((PathingEntity) (obj)).anInt1222 == 7)
                                j = anInt778 % 20 >= 10 ? 65535 : 255;
                            if (((PathingEntity) (obj)).anInt1222 == 8)
                                j = anInt778 % 20 >= 10 ? 0x80ff80 : 45056;
                            if (((PathingEntity) (obj)).anInt1222 == 9) {
                                int i1 = 150 - ((PathingEntity) (obj)).anInt1221;
                                if (i1 < 50)
                                    j = 0xff0000 + 1280 * i1;
                                else if (i1 < 100)
                                    j = 0xffff00 - 0x50000 * (i1 - 50);
                                else if (i1 < 150)
                                    j = 65280 + 5 * (i1 - 100);
                            }
                            if (((PathingEntity) (obj)).anInt1222 == 10) {
                                int j1 = 150 - ((PathingEntity) (obj)).anInt1221;
                                if (j1 < 50)
                                    j = 0xff0000 + 5 * j1;
                                else if (j1 < 100)
                                    j = 0xff00ff - 0x50000 * (j1 - 50);
                                else if (j1 < 150)
                                    j = (255 + 0x50000 * (j1 - 100)) - 5 * (j1 - 100);
                            }
                            if (((PathingEntity) (obj)).anInt1222 == 11) {
                                int k1 = 150 - ((PathingEntity) (obj)).anInt1221;
                                if (k1 < 50)
                                    j = 0xffffff - 0x50005 * k1;
                                else if (k1 < 100)
                                    j = 65280 + 0x50005 * (k1 - 50);
                                else if (k1 < 150)
                                    j = 0xffffff - 0x50000 * (k1 - 100);
                            }
                            if (((PathingEntity) (obj)).anInt1223 == 0) {
                                b12.method370(true, anInt758 + 1, 0, anInt757, ((PathingEntity) (obj)).aString1220);
                                b12.method370(true, anInt758, j, anInt757, ((PathingEntity) (obj)).aString1220);
                            }
                            if (((PathingEntity) (obj)).anInt1223 == 1) {
                                b12.method374(9, anInt758 + 1, 0, ((PathingEntity) (obj)).aString1220, anInt778, anInt757);
                                b12.method374(9, anInt758, j, ((PathingEntity) (obj)).aString1220, anInt778, anInt757);
                            }
                            if (((PathingEntity) (obj)).anInt1223 == 2) {
                                int l1 = b12.method372(((PathingEntity) (obj)).aString1220, true);
                                int j2 = ((150 - ((PathingEntity) (obj)).anInt1221) * (l1 + 100)) / 150;
                                Draw2D.method331(334, anInt757 + 50, 0, anInt757 - 50, 17913);
                                b12.method373(((PathingEntity) (obj)).aString1220, (anInt757 + 50) - j2, 0, true, anInt758 + 1);
                                b12.method373(((PathingEntity) (obj)).aString1220, (anInt757 + 50) - j2, j, true, anInt758);
                                Draw2D.method330(-971);
                            }
                        } else {
                            b12.method370(true, anInt758 + 1, 0, anInt757, ((PathingEntity) (obj)).aString1220);
                            b12.method370(true, anInt758, 0xffff00, anInt757, ((PathingEntity) (obj)).aString1220);
                        }
                }
                if (((PathingEntity) (obj)).anInt1226 > anInt759 + 100) {
                    method43(((PathingEntity) (obj)).anInt1253 + 15, aByte680, ((PathingEntity) (obj)));
                    if (anInt757 > -1) {
                        int k = (((PathingEntity) (obj)).anInt1227 * 30) / ((PathingEntity) (obj)).anInt1228;
                        if (k > 30)
                            k = 30;
                        Draw2D.method333(65280, anInt807, 5, anInt758 - 3, k, anInt757 - 15);
                        Draw2D.method333(0xff0000, anInt807, 5, anInt758 - 3, 30 - k, (anInt757 - 15) + k);
                    }
                }
                if (((PathingEntity) (obj)).anInt1226 > anInt759 + 330) {
                    method43(((PathingEntity) (obj)).anInt1253 / 2, aByte680, ((PathingEntity) (obj)));
                    if (anInt757 > -1) {
                        aSpriteArray980[((PathingEntity) (obj)).anInt1225].method357(anInt758 - 12, anInt861, anInt757 - 12);
                        p11.method370(true, anInt758 + 4, 0, anInt757, String.valueOf(((PathingEntity) (obj)).anInt1224));
                        p11.method370(true, anInt758 + 3, 0xffffff, anInt757 - 1, String.valueOf(((PathingEntity) (obj)).anInt1224));
                    }
                }
            }
        }

        if (!flag) ;
    }

    public void updatePlayers(int i, Buffer class35_sub2_sub3, int j) {
        anInt833 = 0;
        if (i != 15093)
            anInt771 = isaac.nextInt();
        anInt754 = 0;
        updateLocalPlayer(j, class35_sub2_sub3, -721);
        updateOtherPlayers(class35_sub2_sub3, j, true);
        updateNewPlayers(class35_sub2_sub3, j, -292);
        updatePlayerMasks(class35_sub2_sub3, 7, j);
        for (int k = 0; k < anInt833; k++) {
            int l = anIntArray834[k];
            if (aPlayerEntityArray751[l].anInt1252 != anInt759)
                aPlayerEntityArray751[l] = null;
        }

        if (class35_sub2_sub3.pos != j) {
            signlink.reporterror("Error packet size mismatch in getplayer pos:" + class35_sub2_sub3.pos + " psize:" + j);
            throw new RuntimeException("eek");
        }
        for (int i1 = 0; i1 < anInt752; i1++)
            if (aPlayerEntityArray751[anIntArray753[i1]] == null) {
                signlink.reporterror(aString743 + " null entry in pl list - pos:" + i1 + " size:" + anInt752);
                throw new RuntimeException("eek");
            }

    }

    public void method38(int i, byte byte0) {
        if (byte0 != 7)
            return;
        int j = VarpType.aVarpTypeArray247[i].anInt255;
        if (j == 0)
            return;
        int k = anIntArray822[i];
        if (j == 1) {
            if (k == 1)
                Draw3D.method346(0.90000000000000002D, -433);
            if (k == 2)
                Draw3D.method346(0.80000000000000004D, -433);
            if (k == 3)
                Draw3D.method346(0.69999999999999996D, -433);
            if (k == 4)
                Draw3D.method346(0.59999999999999998D, -433);
            ObjType.aCache_634.method297();
            aBoolean681 = true;
        }
        if (j == 3) {
            if (k == 1 && aBoolean661) {
                aBoolean661 = false;
                signlink.midi = "null";
            }
            if (k == 0 && !aBoolean661) {
                aBoolean661 = true;
                signlink.midi = aString666;
            }
        }
        if (j == 5)
            anInt748 = k;
        if (j == 6)
            anInt942 = k;
    }

    public void method39(Buffer class35_sub2_sub3, int i, int j) {
        anInt833 = 0;
        anInt754 = 0;
        method35(i, (byte) 6, class35_sub2_sub3);
        method90(2, class35_sub2_sub3, i);
        i += j;
        method93(787, i, class35_sub2_sub3);
        for (int k = 0; k < anInt833; k++) {
            int l = anIntArray834[k];
            if (aClass35_Sub7_Sub3_Sub1Array964[l].anInt1252 != anInt759) {
                aClass35_Sub7_Sub3_Sub1Array964[l].aNpcType_1325 = null;
                aClass35_Sub7_Sub3_Sub1Array964[l] = null;
            }
        }

        if (class35_sub2_sub3.pos != i) {
            signlink.reporterror(aString743 + " size mismatch in getnpcpos - pos:" + class35_sub2_sub3.pos + " psize:" + i);
            throw new RuntimeException("eek");
        }
        for (int i1 = 0; i1 < anInt965; i1++)
            if (aClass35_Sub7_Sub3_Sub1Array964[anIntArray966[i1]] == null) {
                signlink.reporterror(aString743 + " null entry in npc list - pos:" + i1 + " size:" + anInt965);
                throw new RuntimeException("eek");
            }

    }

    public void method40(int i) {
        while (i >= 0)
            aLinkedListArrayArrayArray665 = null;
        for (int j = -1; j < anInt752; j++) {
            int k;
            if (j == -1)
                k = anInt750;
            else
                k = anIntArray753[j];
            PlayerEntity class35_sub7_sub3_sub2 = aPlayerEntityArray751[k];
            if (class35_sub7_sub3_sub2 != null && class35_sub7_sub3_sub2.anInt1221 > 0) {
                class35_sub7_sub3_sub2.anInt1221--;
                if (class35_sub7_sub3_sub2.anInt1221 == 0)
                    class35_sub7_sub3_sub2.aString1220 = null;
            }
        }

        for (int l = 0; l < anInt965; l++) {
            int i1 = anIntArray966[l];
            NpcEntity class35_sub7_sub3_sub1 = aClass35_Sub7_Sub3_Sub1Array964[i1];
            if (class35_sub7_sub3_sub1 != null && class35_sub7_sub3_sub1.anInt1221 > 0) {
                class35_sub7_sub3_sub1.anInt1221--;
                if (class35_sub7_sub3_sub1.anInt1221 == 0)
                    class35_sub7_sub3_sub1.aString1220 = null;
            }
        }

    }

    public void method41(int i) {
        if (aFrameBuffer_645 != null)
            return;
        method118(-43634);
        super.aFrameBuffer_14 = null;
        aFrameBuffer_889 = null;
        aFrameBuffer_890 = null;
        aFrameBuffer_891 = null;
        aFrameBuffer_892 = null;
        aFrameBuffer_893 = null;
        aFrameBuffer_894 = null;
        aFrameBuffer_895 = null;
        aFrameBuffer_896 = null;
        aFrameBuffer_897 = null;
        aFrameBuffer_645 = new FrameBuffer(96, (byte) -58, method11(-36374), 479);
        aFrameBuffer_643 = new FrameBuffer(160, (byte) -58, method11(-36374), 168);
        if (i >= 0) {
            return;
        } else {
            Draw2D.method332(2);
            aClass35_Sub2_Sub2_Sub3_692.method368(0, anInt861, 0);
            aFrameBuffer_642 = new FrameBuffer(261, (byte) -58, method11(-36374), 190);
            aFrameBuffer_644 = new FrameBuffer(334, (byte) -58, method11(-36374), 512);
            Draw2D.method332(2);
            aFrameBuffer_939 = new FrameBuffer(61, (byte) -58, method11(-36374), 501);
            aFrameBuffer_940 = new FrameBuffer(40, (byte) -58, method11(-36374), 288);
            aFrameBuffer_941 = new FrameBuffer(66, (byte) -58, method11(-36374), 269);
            aBoolean681 = true;
            return;
        }
    }

    public void method42(int i) {
        if (i != 1)
            packetOpcode = inBuffer.g1();
        aBoolean660 = true;
        for (int j = 0; j < 7; j++) {
            anIntArray883[j] = -1;
            for (int k = 0; k < IdkType.count; k++) {
                if (IdkType.instances[k].type != j + (aBoolean970 ? 0 : 7))
                    continue;
                anIntArray883[j] = k;
                break;
            }

        }

    }

    public void method43(int i, byte byte0, PathingEntity class35_sub7_sub3) {
        int j = class35_sub7_sub3.x;
        int k = class35_sub7_sub3.z;
        if (j < 128 || k < 128 || j > 13056 || k > 13056) {
            anInt757 = -1;
            anInt758 = -1;
            return;
        }
        int l = method15(j, k, anInt722, (byte) 9) - i;
        j -= anInt918;
        l -= anInt919;
        if (byte0 == 0)
            byte0 = 0;
        else
            aLinkedListArrayArrayArray665 = null;
        k -= anInt920;
        int i1 = Model.anIntArray1129[anInt921];
        int j1 = Model.anIntArray1130[anInt921];
        int k1 = Model.anIntArray1129[anInt922];
        int l1 = Model.anIntArray1130[anInt922];
        int i2 = k * k1 + j * l1 >> 16;
        k = k * l1 - j * k1 >> 16;
        j = i2;
        i2 = l * j1 - k * i1 >> 16;
        k = l * i1 + k * j1 >> 16;
        l = i2;
        if (k >= 50) {
            anInt757 = Draw3D.anInt1267 + (j << 9) / k;
            anInt758 = Draw3D.anInt1268 + (l << 9) / k;
            return;
        } else {
            anInt757 = -1;
            anInt758 = -1;
            return;
        }
    }

    public String method44(int i, int j) {
        if (j < 2 || j > 2)
            anInt861 = -265;
        if (i < 0x3b9ac9ff)
            return String.valueOf(i);
        else
            return "*";
    }

    public void method45(byte byte0) {
        anInt778++;
        method95(7);
        method78(true);
        method92(-497);
        method21(9);
        method61(7);
        if (!aBoolean682) {
            int i = anInt923;
            if (anInt929 / 256 > i)
                i = anInt929 / 256;
            if (aBooleanArray765[4] && anIntArray829[4] + 128 > i)
                i = anIntArray829[4] + 128;
            int k = anInt924 + anInt874 & 0x7ff;
            method79(method15(anInt927, anInt928, anInt722, (byte) 9) - 50, i, anInt928, (byte) 9, 600 + i * 3, anInt927, k);
        }
        int j;
        if (!aBoolean682)
            j = method17(false);
        else
            j = method18(5);
        int l = anInt918;
        int i1 = anInt919;
        int j1 = anInt920;
        int k1 = anInt921;
        int l1 = anInt922;
        for (int i2 = 0; i2 < 5; i2++)
            if (aBooleanArray765[i2]) {
                int j2 = (int) ((Math.random() * (double) (anIntArray869[i2] * 2 + 1) - (double) anIntArray869[i2]) + Math.sin((double) anIntArray967[i2] * ((double) anIntArray949[i2] / 100D)) * (double) anIntArray829[i2]);
                if (i2 == 0)
                    anInt918 += j2;
                if (i2 == 1)
                    anInt919 += j2;
                if (i2 == 2)
                    anInt920 += j2;
                if (i2 == 3)
                    anInt922 = anInt922 + j2 & 0x7ff;
                if (i2 == 4) {
                    anInt921 += j2;
                    if (anInt921 < 128)
                        anInt921 = 128;
                    if (anInt921 > 383)
                        anInt921 = 383;
                }
            }

        int k2 = Draw3D.anInt1282;
        Model.aBoolean1124 = true;
        Model.anInt1127 = 0;
        Model.anInt1125 = super.anInt20 - 8;
        Model.anInt1126 = super.anInt21 - 11;
        Draw2D.method332(2);
        aMapSquare_741.method275(anInt918, j, 2, anInt919, anInt920, anInt921, anInt922, anInt759);
        aMapSquare_741.method252(7);
        method36(false);
        method33((byte) 6, k2);
        if (byte0 != -95)
            packetOpcode = -1;
        method20(8);
        aFrameBuffer_644.method235(8, super.aGraphics13, 11, aByte930);
        anInt918 = l;
        anInt919 = i1;
        anInt920 = j1;
        anInt921 = k1;
        anInt922 = l1;
    }

    public void method46(int i, int j) {
        Component class8 = Component.aComponentArray110[j];
        for (int k = 0; k < class8.anIntArray131.length; k++) {
            if (class8.anIntArray131[k] == -1)
                break;
            Component class8_1 = Component.aComponentArray110[class8.anIntArray131[k]];
            if (class8_1.anInt117 == 1)
                method46(-553, class8_1.anInt115);
            class8_1.anInt113 = 0;
            class8_1.anInt114 = 0;
        }

        while (i >= 0)
            return;
    }

    public boolean method47(int i, boolean flag, int j) {
        boolean flag1 = false;
        Component class8 = Component.aComponentArray110[i];
        for (int k = 0; k < class8.anIntArray131.length; k++) {
            if (class8.anIntArray131[k] == -1)
                break;
            Component class8_1 = Component.aComponentArray110[class8.anIntArray131[k]];
            if (class8_1.anInt117 == 1)
                flag1 |= method47(class8_1.anInt115, true, j);
            if (class8_1.anInt158 != -1) {
                SeqType class12 = SeqType.aSeqTypeArray190[class8_1.anInt158];
                for (class8_1.anInt114 += j; class8_1.anInt114 > class12.anIntArray194[class8_1.anInt113]; ) {
                    class8_1.anInt114 -= class12.anIntArray194[class8_1.anInt113] + 1;
                    class8_1.anInt113++;
                    if (class8_1.anInt113 >= class12.anInt191) {
                        class8_1.anInt113 -= class12.anInt195;
                        if (class8_1.anInt113 < 0 || class8_1.anInt113 >= class12.anInt191)
                            class8_1.anInt113 = 0;
                    }
                    flag1 = true;
                }

            }
        }

        if (!flag)
            throw new NullPointerException();
        else
            return flag1;
    }

    public void method48(String username, String password, int uid) {
        try {
            aString973 = "";
            aString974 = "Connecting to server...";
            method74(false);
            stream = new BufferedStream(this, 994, method98(43594 + nodeOffset));
            stream.method153(inBuffer.data, 0, 8);
            inBuffer.pos = 0;
            serverSeed = inBuffer.g8();
            outBuffer.pos = 0;
            outBuffer.p1(10);
            outBuffer.p4((int) Math.random() * 99999999);
            outBuffer.p4((int) Math.random() * 99999999);
            outBuffer.p8(serverSeed);
            outBuffer.p4(uid);
            outBuffer.pjstr(username);
            outBuffer.pjstr(password);
            outBuffer.rsaenc(RSA_MODULUS, RSA_EXPONENT);
            loginBuffer.pos = 0;
            loginBuffer.p1(17);
            loginBuffer.p1(outBuffer.pos);
            loginBuffer.pdata(outBuffer.data, 0, outBuffer.pos);
            stream.write(loginBuffer.data, loginBuffer.pos, false, 0);
            int j = stream.read();
            if (j == 1) {
                try {
                    Thread.sleep(2000L);
                } catch (Exception _ex) {
                }
                method48(username, password, uid);
                return;
            }
            if (j == 2) {
                aString973 = "Username already taken.";
                aString974 = "Please choose a different name.";
                return;
            }
            if (j == 3) {
                anInt915 = 2;
                login(aString743, aString744, uid, false);
                return;
            }
        } catch (IOException _ex) {
            aString973 = "";
            aString974 = "Error connecting to server.";
        }
    }

    public void method49(byte byte0) {
        char c = '\u0100';
        for (int i = 10; i < 117; i++) {
            int j = (int) (Math.random() * 100D);
            if (j < 50)
                anIntArray795[i + (c - 2 << 7)] = 255;
        }

        for (int k = 0; k < 100; k++) {
            int l = (int) (Math.random() * 124D) + 2;
            int j1 = (int) (Math.random() * 128D) + 128;
            int j2 = l + (j1 << 7);
            anIntArray795[j2] = 192;
        }

        for (int i1 = 1; i1 < c - 1; i1++) {
            for (int k1 = 1; k1 < 127; k1++) {
                int k2 = k1 + (i1 << 7);
                anIntArray796[k2] = (anIntArray795[k2 - 1] + anIntArray795[k2 + 1] + anIntArray795[k2 - 128] + anIntArray795[k2 + 128]) / 4;
            }

        }

        if (byte0 != aByte679)
            packetOpcode = -1;
        anInt968 += 128;
        if (anInt968 > anIntArray956.length) {
            anInt968 -= anIntArray956.length;
            int l1 = (int) (Math.random() * 12D);
            method97((byte) 57, aClass35_Sub2_Sub2_Sub3Array914[l1]);
        }
        for (int i2 = 1; i2 < c - 1; i2++) {
            for (int l2 = 1; l2 < 127; l2++) {
                int j3 = l2 + (i2 << 7);
                int l3 = anIntArray796[j3 + 128] - anIntArray956[j3 + anInt968 & anIntArray956.length - 1] / 5;
                if (l3 < 0)
                    l3 = 0;
                anIntArray795[j3] = l3;
            }

        }

        for (int i3 = 0; i3 < c - 1; i3++)
            anIntArray721[i3] = anIntArray721[i3 + 1];

        anIntArray721[c - 1] = (int) (Math.sin((double) anInt759 / 14D) * 16D + Math.sin((double) anInt759 / 15D) * 14D + Math.sin((double) anInt759 / 16D) * 12D);
        if (anInt932 > 0)
            anInt932 -= 4;
        if (anInt933 > 0)
            anInt933 -= 4;
        if (anInt932 == 0 && anInt933 == 0) {
            int k3 = (int) (Math.random() * 2000D);
            if (k3 == 0)
                anInt932 = 1024;
            if (k3 == 1)
                anInt933 = 1024;
        }
    }

    public void method50(boolean flag) {
        if (aFrameBuffer_889 != null)
            return;
        super.aFrameBuffer_14 = null;
        aFrameBuffer_645 = null;
        aFrameBuffer_643 = null;
        aFrameBuffer_642 = null;
        aFrameBuffer_644 = null;
        aFrameBuffer_939 = null;
        aFrameBuffer_940 = null;
        aFrameBuffer_941 = null;
        aFrameBuffer_892 = new FrameBuffer(265, (byte) -58, method11(-36374), 128);
        Draw2D.method332(2);
        aFrameBuffer_893 = new FrameBuffer(265, (byte) -58, method11(-36374), 128);
        Draw2D.method332(2);
        aFrameBuffer_889 = new FrameBuffer(186, (byte) -58, method11(-36374), 533);
        Draw2D.method332(2);
        aFrameBuffer_890 = new FrameBuffer(146, (byte) -58, method11(-36374), 360);
        Draw2D.method332(2);
        aFrameBuffer_891 = new FrameBuffer(200, (byte) -58, method11(-36374), 360);
        Draw2D.method332(2);
        aFrameBuffer_894 = new FrameBuffer(267, (byte) -58, method11(-36374), 214);
        Draw2D.method332(2);
        aFrameBuffer_895 = new FrameBuffer(267, (byte) -58, method11(-36374), 215);
        Draw2D.method332(2);
        aFrameBuffer_896 = new FrameBuffer(79, (byte) -58, method11(-36374), 86);
        aBoolean734 &= flag;
        Draw2D.method332(2);
        aFrameBuffer_897 = new FrameBuffer(79, (byte) -58, method11(-36374), 87);
        Draw2D.method332(2);
        if (title != null) {
            method106(false);
            method56(0);
        }
        aBoolean681 = true;
    }

    public void updateOtherPlayers(Buffer class35_sub2_sub3, int i, boolean flag) {
        aBoolean734 &= flag;
        int j = class35_sub2_sub3.gBit(8);
        if (j < anInt752) {
            for (int k = j; k < anInt752; k++)
                anIntArray834[anInt833++] = anIntArray753[k];

        }
        if (j > anInt752) {
            signlink.reporterror(aString743 + " Too many players");
            throw new RuntimeException("eek");
        }
        anInt752 = 0;
        for (int l = 0; l < j; l++) {
            int i1 = anIntArray753[l];
            PlayerEntity class35_sub7_sub3_sub2 = aPlayerEntityArray751[i1];
            int j1 = class35_sub2_sub3.gBit(1);
            if (j1 == 0) {
                anIntArray753[anInt752++] = i1;
                class35_sub7_sub3_sub2.anInt1252 = anInt759;
            } else {
                int k1 = class35_sub2_sub3.gBit(2);
                if (k1 == 0) {
                    anIntArray753[anInt752++] = i1;
                    class35_sub7_sub3_sub2.anInt1252 = anInt759;
                    anIntArray755[anInt754++] = i1;
                } else if (k1 == 1) {
                    anIntArray753[anInt752++] = i1;
                    class35_sub7_sub3_sub2.anInt1252 = anInt759;
                    int l1 = class35_sub2_sub3.gBit(3);
                    class35_sub7_sub3_sub2.method410(false, l1, 112);
                    int j2 = class35_sub2_sub3.gBit(1);
                    if (j2 == 1)
                        anIntArray755[anInt754++] = i1;
                } else if (k1 == 2) {
                    anIntArray753[anInt752++] = i1;
                    class35_sub7_sub3_sub2.anInt1252 = anInt759;
                    int i2 = class35_sub2_sub3.gBit(3);
                    class35_sub7_sub3_sub2.method410(true, i2, 112);
                    int k2 = class35_sub2_sub3.gBit(3);
                    class35_sub7_sub3_sub2.method410(true, k2, 112);
                    int l2 = class35_sub2_sub3.gBit(1);
                    if (l2 == 1)
                        anIntArray755[anInt754++] = i1;
                } else if (k1 == 3)
                    anIntArray834[anInt833++] = i1;
            }
        }

    }

    public void method52(byte byte0) {
        int i = self.x + anInt912;
        int j = self.z + anInt689;
        if (anInt927 - i < -500 || anInt927 - i > 500 || anInt928 - j < -500 || anInt928 - j > 500) {
            anInt927 = i;
            anInt928 = j;
        }
        if (anInt927 != i)
            anInt927 += (i - anInt927) / 16;
        if (anInt928 != j)
            anInt928 += (j - anInt928) / 16;
        if (super.anIntArray25[1] == 1)
            anInt925 += (-24 - anInt925) / 2;
        else if (super.anIntArray25[2] == 1)
            anInt925 += (24 - anInt925) / 2;
        else
            anInt925 /= 2;
        if (super.anIntArray25[3] == 1)
            anInt926 += (12 - anInt926) / 2;
        else if (super.anIntArray25[4] == 1)
            anInt926 += (-12 - anInt926) / 2;
        else
            anInt926 /= 2;
        anInt924 = anInt924 + anInt925 / 2 & 0x7ff;
        anInt923 += anInt926 / 2;
        if (anInt923 < 128)
            anInt923 = 128;
        if (anInt923 > 383)
            anInt923 = 383;
        int k = anInt927 >> 7;
        int l = anInt928 >> 7;
        int i1 = method15(anInt927, anInt928, anInt722, (byte) 9);
        int j1 = 0;
        if (byte0 != 2)
            packetOpcode = -1;
        if (k > 3 && l > 3 && k < 100 && l < 100) {
            for (int k1 = k - 4; k1 <= k + 4; k1++) {
                for (int i2 = l - 4; i2 <= l + 4; i2++) {
                    int j2 = anInt722;
                    if (j2 < 3 && (levelRenderFlags[1][k1][i2] & 2) == 2)
                        j2++;
                    int k2 = i1 - anIntArrayArrayArray725[j2][k1][i2];
                    if (k2 > j1)
                        j1 = k2;
                }

            }

        }
        int l1 = j1 * 192;
        if (l1 > 0x17f00)
            l1 = 0x17f00;
        if (l1 < 32768)
            l1 = 32768;
        if (l1 > anInt929) {
            anInt929 += (l1 - anInt929) / 24;
            return;
        }
        if (l1 < anInt929)
            anInt929 += (l1 - anInt929) / 80;
    }

    public void method53(boolean flag, Component class8, int i, int j, int k) {
        if (class8.anInt117 != 0 || class8.anIntArray131 == null)
            return;
        if (class8.aBoolean130 && anInt806 != class8.anInt115 && anInt931 != class8.anInt115 && anInt782 != class8.anInt115)
            return;
        int l = Draw2D.anInt1142;
        int i1 = Draw2D.anInt1140;
        int j1 = Draw2D.anInt1143;
        int k1 = Draw2D.anInt1141;
        Draw2D.method331(i + class8.anInt121, k + class8.anInt120, i, k, 17913);
        int l1 = class8.anIntArray131.length;
        if (flag)
            anInt809 = 358;
        for (int i2 = 0; i2 < l1; i2++) {
            int j2 = class8.anIntArray132[i2] + k;
            int k2 = (class8.anIntArray133[i2] + i) - j;
            Component class8_1 = Component.aComponentArray110[class8.anIntArray131[i2]];
            j2 += class8_1.anInt122;
            k2 += class8_1.anInt123;
            if (class8_1.anInt119 > 0)
                method67((byte) 36, class8_1);
            if (class8_1.anInt117 == 0) {
                if (class8_1.anInt129 > class8_1.anInt128 - class8_1.anInt121)
                    class8_1.anInt129 = class8_1.anInt128 - class8_1.anInt121;
                if (class8_1.anInt129 < 0)
                    class8_1.anInt129 = 0;
                method53(aBoolean770, class8_1, k2, class8_1.anInt129, j2);
                if (class8_1.anInt128 > class8_1.anInt121)
                    method96(k2, false, j2 + class8_1.anInt120, class8_1.anInt128, class8_1.anInt129, class8_1.anInt121);
            } else if (class8_1.anInt117 != 1)
                if (class8_1.anInt117 == 2) {
                    int l2 = 0;
                    for (int j3 = 0; j3 < class8_1.anInt121; j3++) {
                        for (int j4 = 0; j4 < class8_1.anInt120; j4++) {
                            int i5 = j2 + j4 * (32 + class8_1.anInt139);
                            int l5 = k2 + j3 * (32 + class8_1.anInt140);
                            if (l2 < 20) {
                                i5 += class8_1.anIntArray142[l2];
                                l5 += class8_1.anIntArray143[l2];
                            }
                            if (class8_1.anIntArray111[l2] > 0) {
                                int j6 = 0;
                                int i8 = 0;
                                int k8 = class8_1.anIntArray111[l2] - 1;
                                Sprite class35_sub2_sub2_sub2_2 = ObjType.method444(k8, (byte) -11);
                                if (anInt774 != 0 && anInt773 == l2 && anInt772 == class8_1.anInt115) {
                                    j6 = super.anInt20 - anInt775;
                                    i8 = super.anInt21 - anInt776;
                                    if (j6 < 5 && j6 > -5)
                                        j6 = 0;
                                    if (i8 < 5 && i8 > -5)
                                        i8 = 0;
                                    class35_sub2_sub2_sub2_2.method359(false, i5 + j6, 128, l5 + i8);
                                } else if (anInt805 != 0 && anInt804 == l2 && anInt803 == class8_1.anInt115)
                                    class35_sub2_sub2_sub2_2.method359(false, i5, 128, l5);
                                else
                                    class35_sub2_sub2_sub2_2.method357(l5, anInt861, i5);
                                if (class35_sub2_sub2_sub2_2.anInt1297 == 33 || class8_1.anIntArray112[l2] != 1) {
                                    int i9 = class8_1.anIntArray112[l2];
                                    p11.method373(String.valueOf(i9), i5 + 1 + j6, 0, true, l5 + 10 + i8);
                                    p11.method373(String.valueOf(i9), i5 + j6, 0xffff00, true, l5 + 9 + i8);
                                }
                            } else if (class8_1.aSpriteArray141 != null && l2 < 20) {
                                Sprite class35_sub2_sub2_sub2_1 = class8_1.aSpriteArray141[l2];
                                if (class35_sub2_sub2_sub2_1 != null)
                                    class35_sub2_sub2_sub2_1.method357(l5, anInt861, i5);
                            }
                            l2++;
                        }

                    }

                } else if (class8_1.anInt117 == 3) {
                    if (class8_1.aBoolean145)
                        Draw2D.method333(class8_1.anInt151, anInt807, class8_1.anInt121, k2, class8_1.anInt120, j2);
                    else
                        Draw2D.method334(class8_1.anInt151, k2, 0, class8_1.anInt120, class8_1.anInt121, j2);
                } else if (class8_1.anInt117 == 4) {
                    Font class35_sub2_sub2_sub4 = class8_1.aClass35_Sub2_Sub2_Sub4_148;
                    int k3 = class8_1.anInt151;
                    String s = class8_1.aString149;
                    if ((anInt782 == class8_1.anInt115 || anInt931 == class8_1.anInt115 || anInt806 == class8_1.anInt115) && class8_1.anInt153 != 0)
                        k3 = class8_1.anInt153;
                    if (method109((byte) 3, class8_1)) {
                        k3 = class8_1.anInt152;
                        if (class8_1.aString150.length() > 0)
                            s = class8_1.aString150;
                    }
                    if (class8_1.anInt118 == 6 && aBoolean888) {
                        s = "Please wait...";
                        k3 = class8_1.anInt151;
                    }
                    for (int i6 = k2 + class35_sub2_sub2_sub4.anInt1321; s.length() > 0; i6 += class35_sub2_sub2_sub4.anInt1321) {
                        if (s.indexOf("%") != -1) {
                            do {
                                int k6 = s.indexOf("%1");
                                if (k6 == -1)
                                    break;
                                s = s.substring(0, k6) + method44(method23(0, class8_1, -6815), 2) + s.substring(k6 + 2);
                            } while (true);
                            do {
                                int l6 = s.indexOf("%2");
                                if (l6 == -1)
                                    break;
                                s = s.substring(0, l6) + method44(method23(1, class8_1, -6815), 2) + s.substring(l6 + 2);
                            } while (true);
                            do {
                                int i7 = s.indexOf("%3");
                                if (i7 == -1)
                                    break;
                                s = s.substring(0, i7) + method44(method23(2, class8_1, -6815), 2) + s.substring(i7 + 2);
                            } while (true);
                            do {
                                int j7 = s.indexOf("%4");
                                if (j7 == -1)
                                    break;
                                s = s.substring(0, j7) + method44(method23(3, class8_1, -6815), 2) + s.substring(j7 + 2);
                            } while (true);
                            do {
                                int k7 = s.indexOf("%5");
                                if (k7 == -1)
                                    break;
                                s = s.substring(0, k7) + method44(method23(4, class8_1, -6815), 2) + s.substring(k7 + 2);
                            } while (true);
                        }
                        int l7 = s.indexOf("\\n");
                        String s1;
                        if (l7 != -1) {
                            s1 = s.substring(0, l7);
                            s = s.substring(l7 + 2);
                        } else {
                            s1 = s;
                            s = "";
                        }
                        if (class8_1.aBoolean146)
                            class35_sub2_sub2_sub4.method371(i6, j2 + class8_1.anInt120 / 2, k3, s1, 26631, class8_1.aBoolean147);
                        else
                            class35_sub2_sub2_sub4.method375(-886, class8_1.aBoolean147, j2, k3, i6, s1);
                    }

                } else if (class8_1.anInt117 == 5) {
                    Sprite class35_sub2_sub2_sub2;
                    if (method109((byte) 3, class8_1))
                        class35_sub2_sub2_sub2 = class8_1.aSprite_155;
                    else
                        class35_sub2_sub2_sub2 = class8_1.aSprite_154;
                    if (class35_sub2_sub2_sub2 != null)
                        class35_sub2_sub2_sub2.method357(k2, anInt861, j2);
                } else if (class8_1.anInt117 == 6) {
                    int i3 = Draw3D.anInt1267;
                    int l3 = Draw3D.anInt1268;
                    Draw3D.anInt1267 = j2 + class8_1.anInt120 / 2;
                    Draw3D.anInt1268 = k2 + class8_1.anInt121 / 2;
                    int k4 = Draw3D.anIntArray1271[class8_1.anInt161] * class8_1.anInt160 >> 16;
                    int j5 = Draw3D.anIntArray1272[class8_1.anInt161] * class8_1.anInt160 >> 16;
                    Model class35_sub2_sub1;
                    if (class8_1.anInt158 == -1) {
                        class35_sub2_sub1 = class8_1.method174(-1, -1, method109((byte) 3, class8_1));
                    } else {
                        SeqType class12 = SeqType.aSeqTypeArray190[class8_1.anInt158];
                        class35_sub2_sub1 = class8_1.method174(class12.anIntArray192[class8_1.anInt113], class12.anIntArray193[class8_1.anInt113], method109((byte) 3, class8_1));
                    }
                    if (class35_sub2_sub1 != null)
                        class35_sub2_sub1.method323(0, class8_1.anInt162, 0, class8_1.anInt161, 0, k4, j5);
                    Draw3D.anInt1267 = i3;
                    Draw3D.anInt1268 = l3;
                } else if (class8_1.anInt117 == 7) {
                    Font class35_sub2_sub2_sub4_1 = class8_1.aClass35_Sub2_Sub2_Sub4_148;
                    int i4 = 0;
                    for (int l4 = 0; l4 < class8_1.anInt121; l4++) {
                        for (int k5 = 0; k5 < class8_1.anInt120; k5++) {
                            if (class8_1.anIntArray111[i4] > 0) {
                                ObjType class41 = ObjType.method440(class8_1.anIntArray111[i4] - 1);
                                String s2 = class41.aString606;
                                if (class41.aBoolean618 || class8_1.anIntArray112[i4] != 1)
                                    s2 = class8_1.anIntArray112[i4] + "x " + s2;
                                int j8 = j2 + k5 * (115 + class8_1.anInt139);
                                int l8 = k2 + l4 * (12 + class8_1.anInt140);
                                if (class8_1.aBoolean146) {
                                    if (class8_1.aBoolean147)
                                        class35_sub2_sub2_sub4_1.method370(true, l8 + 1, 0, j8 + 1 + class8_1.anInt120 / 2, s2);
                                    class35_sub2_sub2_sub4_1.method370(true, l8, class8_1.anInt151, j8 + class8_1.anInt120 / 2, s2);
                                } else {
                                    if (class8_1.aBoolean147)
                                        class35_sub2_sub2_sub4_1.method373(s2, j8 + 1, 0, true, l8 + 1);
                                    class35_sub2_sub2_sub4_1.method373(s2, j8, class8_1.anInt151, true, l8);
                                }
                            }
                            i4++;
                        }

                    }

                }
        }

        Draw2D.method331(k1, j1, i1, l, 17913);
    }

    public void showProgress(byte byte0, int i, String s) {
        method50(true);
        if (byte0 != -75)
            anInt676 = 212;
        if (title == null) {
            super.showProgress((byte) -75, i, s);
            return;
        }
        aFrameBuffer_891.method234(-510);
        char c = '\u0168';
        char c1 = '\310';
        byte byte1 = 20;
        b12.method370(true, c1 / 2 - 26 - byte1, 0xffffff, c / 2, "RuneScape is loading - please wait...");
        int j = c1 / 2 - 18 - byte1;
        Draw2D.method334(0x8c1111, j, 0, 304, 34, c / 2 - 152);
        Draw2D.method334(0, j + 1, 0, 302, 32, c / 2 - 151);
        Draw2D.method333(0x8c1111, anInt807, 30, j + 2, i * 3, c / 2 - 150);
        Draw2D.method333(0, anInt807, 30, j + 2, 300 - i * 3, (c / 2 - 150) + i * 3);
        b12.method370(true, (c1 / 2 + 5) - byte1, 0xffffff, c / 2, s);
        aFrameBuffer_891.method235(214, super.aGraphics13, 186, aByte930);
        if (aBoolean681) {
            aBoolean681 = false;
            if (!aBoolean906) {
                aFrameBuffer_892.method235(0, super.aGraphics13, 0, aByte930);
                aFrameBuffer_893.method235(661, super.aGraphics13, 0, aByte930);
            }
            aFrameBuffer_889.method235(128, super.aGraphics13, 0, aByte930);
            aFrameBuffer_890.method235(214, super.aGraphics13, 386, aByte930);
            aFrameBuffer_894.method235(0, super.aGraphics13, 265, aByte930);
            aFrameBuffer_895.method235(574, super.aGraphics13, 265, aByte930);
            aFrameBuffer_896.method235(128, super.aGraphics13, 186, aByte930);
            aFrameBuffer_897.method235(574, super.aGraphics13, 186, aByte930);
        }
    }

    public void method9(int i) {
        if (i != -14379)
            return;
        if (errorStarted || errorLoading || errorHost) {
            method25(42545);
            return;
        }
        if (!aBoolean734)
            method74(false);
        else
            method88(anInt684);
        anInt766 = 0;
    }

    public void updatePlayerMask(PlayerEntity class35_sub7_sub3_sub2, byte byte0, int i, Buffer class35_sub2_sub3, int j) {
        if (byte0 == 2)
            byte0 = 0;
        else
            anInt676 = isaac.nextInt();
        if ((j & 1) == 1) {
            int k = class35_sub2_sub3.g1();
            byte[] abyte0 = new byte[k];
            Buffer class35_sub2_sub3_1 = new Buffer(abyte0);
            class35_sub2_sub3.gdata(abyte0, 0, k);
            aClass35_Sub2_Sub3Array756[i] = class35_sub2_sub3_1;
            class35_sub7_sub3_sub2.method413(class35_sub2_sub3_1, true);
        }
        if ((j & 2) == 2) {
            int l = class35_sub2_sub3.g2();
            if (l == 65535)
                l = -1;
            if (l == class35_sub7_sub3_sub2.anInt1235)
                class35_sub7_sub3_sub2.anInt1239 = 0;
            int k1 = class35_sub2_sub3.g1();
            if (l == -1 || class35_sub7_sub3_sub2.anInt1235 == -1 || SeqType.aSeqTypeArray190[l].anInt198 > SeqType.aSeqTypeArray190[class35_sub7_sub3_sub2.anInt1235].anInt198 || SeqType.aSeqTypeArray190[class35_sub7_sub3_sub2.anInt1235].anInt198 == 0) {
                class35_sub7_sub3_sub2.anInt1235 = l;
                class35_sub7_sub3_sub2.anInt1236 = 0;
                class35_sub7_sub3_sub2.anInt1237 = 0;
                class35_sub7_sub3_sub2.anInt1238 = k1;
                class35_sub7_sub3_sub2.anInt1239 = 0;
            }
        }
        if ((j & 4) == 4) {
            class35_sub7_sub3_sub2.anInt1229 = class35_sub2_sub3.g2();
            if (class35_sub7_sub3_sub2.anInt1229 == 65535)
                class35_sub7_sub3_sub2.anInt1229 = -1;
        }
        if ((j & 8) == 8) {
            class35_sub7_sub3_sub2.aString1220 = class35_sub2_sub3.gstr();
            class35_sub7_sub3_sub2.anInt1222 = 0;
            class35_sub7_sub3_sub2.anInt1223 = 0;
            class35_sub7_sub3_sub2.anInt1221 = 150;
            method75(class35_sub7_sub3_sub2.aString1220, 2, anInt853, class35_sub7_sub3_sub2.name);
        }
        if ((j & 0x10) == 16) {
            class35_sub7_sub3_sub2.anInt1224 = class35_sub2_sub3.g1();
            class35_sub7_sub3_sub2.anInt1225 = class35_sub2_sub3.g1();
            class35_sub7_sub3_sub2.anInt1226 = anInt759 + 400;
            class35_sub7_sub3_sub2.anInt1227 = class35_sub2_sub3.g1();
            class35_sub7_sub3_sub2.anInt1228 = class35_sub2_sub3.g1();
        }
        if ((j & 0x20) == 32) {
            class35_sub7_sub3_sub2.anInt1230 = class35_sub2_sub3.g2();
            class35_sub7_sub3_sub2.anInt1231 = class35_sub2_sub3.g2();
        }
        if ((j & 0x40) == 64) {
            int i1 = class35_sub2_sub3.g2();
            int l1 = class35_sub2_sub3.g1();
            int i2 = class35_sub2_sub3.pos;
            if (class35_sub7_sub3_sub2.name != null) {
                long l2 = StringUtils.toBase37(class35_sub7_sub3_sub2.name);
                boolean flag = false;
                for (int j2 = 0; j2 < anInt910; j2++) {
                    if (aLongArray685[j2] != l2)
                        continue;
                    flag = true;
                    break;
                }

                if (!flag) {
                    String s = TextEncoder.method424(-17950, l1, class35_sub2_sub3);
                    s = WordPack.method196((byte) -82, s);
                    class35_sub7_sub3_sub2.aString1220 = s;
                    class35_sub7_sub3_sub2.anInt1222 = i1 >> 8;
                    class35_sub7_sub3_sub2.anInt1223 = i1 & 0xff;
                    class35_sub7_sub3_sub2.anInt1221 = 150;
                    method75(s, 2, anInt853, class35_sub7_sub3_sub2.name);
                }
            }
            class35_sub2_sub3.pos = i2 + l1;
        }
        if ((j & 0x100) == 256) {
            class35_sub7_sub3_sub2.anInt1240 = class35_sub2_sub3.g2();
            int j1 = class35_sub2_sub3.g4();
            class35_sub7_sub3_sub2.anInt1244 = j1 >> 16;
            class35_sub7_sub3_sub2.anInt1243 = anInt759 + (j1 & 0xffff);
            class35_sub7_sub3_sub2.anInt1241 = 0;
            class35_sub7_sub3_sub2.anInt1242 = 0;
            if (class35_sub7_sub3_sub2.anInt1243 > anInt759)
                class35_sub7_sub3_sub2.anInt1241 = -1;
            if (class35_sub7_sub3_sub2.anInt1240 == 65535)
                class35_sub7_sub3_sub2.anInt1240 = -1;
        }
        if ((j & 0x200) == 512) {
            class35_sub7_sub3_sub2.anInt1245 = class35_sub2_sub3.g1();
            class35_sub7_sub3_sub2.anInt1247 = class35_sub2_sub3.g1();
            class35_sub7_sub3_sub2.anInt1246 = class35_sub2_sub3.g1();
            class35_sub7_sub3_sub2.anInt1248 = class35_sub2_sub3.g1();
            class35_sub7_sub3_sub2.anInt1249 = class35_sub2_sub3.g2() + anInt759;
            class35_sub7_sub3_sub2.anInt1250 = class35_sub2_sub3.g2() + anInt759;
            class35_sub7_sub3_sub2.anInt1251 = class35_sub2_sub3.g1();
            class35_sub7_sub3_sub2.pathRemaining = 0;
            class35_sub7_sub3_sub2.pathTileX[0] = class35_sub7_sub3_sub2.anInt1246;
            class35_sub7_sub3_sub2.pathTileZ[0] = class35_sub7_sub3_sub2.anInt1248;
        }
    }

    public void method55(boolean flag) {
        aBoolean734 &= flag;
        if (anInt915 == 0) {
            int i = super.anInt11 / 2;
            int k = super.anInt12 / 2 + 90;
            if (super.anInt22 == 1 && super.anInt23 >= i - 75 && super.anInt23 <= i + 75 && super.anInt24 >= k - 20 && super.anInt24 <= k + 20) {
                aString973 = "";
                aString974 = "Enter your username & password.";
                anInt915 = 2;
                anInt871 = 0;
                return;
            }
        } else if (anInt915 == 1 || anInt915 == 2) {
            int j = super.anInt12 / 2 - 30;
            j += 30;
            if (super.anInt22 == 1 && super.anInt24 >= j - 15 && super.anInt24 < j)
                anInt871 = 0;
            j += 15;
            if (super.anInt22 == 1 && super.anInt24 >= j - 15 && super.anInt24 < j)
                anInt871 = 1;
            j += 15;
            if (super.anInt22 == 1 && super.anInt24 >= j - 15 && super.anInt24 < j && anInt915 == 1)
                anInt871 = 2;
            int l = super.anInt11 / 2 - 80;
            int i1 = super.anInt12 / 2 + 60;
            if (super.anInt22 == 1 && super.anInt23 >= l - 75 && super.anInt23 <= l + 75 && super.anInt24 >= i1 - 20 && super.anInt24 <= i1 + 20)
                if (anInt915 == 1)
                    method48(aString743, aString744, method71(-31414));
                else
                    login(aString743, aString744, method71(-31414), false);
            l = super.anInt11 / 2 + 80;
            if (super.anInt22 == 1 && super.anInt23 >= l - 75 && super.anInt23 <= l + 75 && super.anInt24 >= i1 - 20 && super.anInt24 <= i1 + 20)
                anInt915 = 0;
            do {
                int j1 = method5(6542);
                if (j1 == -1)
                    break;
                boolean flag1 = false;
                for (int k1 = 0; k1 < aString760.length(); k1++) {
                    if (j1 != aString760.charAt(k1))
                        continue;
                    flag1 = true;
                    break;
                }

                if (anInt871 == 0) {
                    if (j1 == 8 && aString743.length() > 0)
                        aString743 = aString743.substring(0, aString743.length() - 1);
                    if (j1 == 9 || j1 == 10 || j1 == 13)
                        anInt871 = 1;
                    if (flag1)
                        aString743 += (char) j1;
                    if (aString743.length() > 12)
                        aString743 = aString743.substring(0, 12);
                } else if (anInt871 == 1) {
                    if (j1 == 8 && aString744.length() > 0)
                        aString744 = aString744.substring(0, aString744.length() - 1);
                    if (j1 == 9 || j1 == 10 || j1 == 13)
                        if (anInt915 == 1)
                            anInt871 = 2;
                        else
                            anInt871 = 0;
                    if (flag1)
                        aString744 += (char) j1;
                    if (aString744.length() > 20)
                        aString744 = aString744.substring(0, 20);
                } else if (anInt871 == 2) {
                    if (j1 == 8 && aString745.length() > 0)
                        aString745 = aString745.substring(0, aString745.length() - 1);
                    if (j1 == 9 || j1 == 10 || j1 == 13)
                        anInt871 = 0;
                    if (flag1)
                        aString745 += (char) j1;
                    if (aString745.length() > 20)
                        aString745 = aString745.substring(0, 20);
                }
            } while (true);
        }
    }

    public void method56(int i) {
        if (i != 0)
            packetOpcode = -1;
        aClass35_Sub2_Sub2_Sub3_960 = new IndexedSprite(title, "titlebox", 0);
        aClass35_Sub2_Sub2_Sub3_961 = new IndexedSprite(title, "titlebutton", 0);
        aClass35_Sub2_Sub2_Sub3Array914 = new IndexedSprite[12];
        for (int j = 0; j < 12; j++)
            aClass35_Sub2_Sub2_Sub3Array914[j] = new IndexedSprite(title, "runes", j);

        aSprite_687 = new Sprite(128, 265);
        aSprite_688 = new Sprite(128, 265);
        for (int k = 0; k < 33920; k++)
            aSprite_687.anIntArray1292[k] = aFrameBuffer_892.anIntArray368[k];

        for (int l = 0; l < 33920; l++)
            aSprite_688.anIntArray1292[l] = aFrameBuffer_893.anIntArray368[l];

        anIntArray798 = new int[256];
        for (int i1 = 0; i1 < 64; i1++)
            anIntArray798[i1] = i1 * 0x40000;

        for (int j1 = 0; j1 < 64; j1++)
            anIntArray798[j1 + 64] = 0xff0000 + 1024 * j1;

        for (int k1 = 0; k1 < 64; k1++)
            anIntArray798[k1 + 128] = 0xffff00 + 4 * k1;

        for (int l1 = 0; l1 < 64; l1++)
            anIntArray798[l1 + 192] = 0xffffff;

        anIntArray799 = new int[256];
        for (int i2 = 0; i2 < 64; i2++)
            anIntArray799[i2] = i2 * 1024;

        for (int j2 = 0; j2 < 64; j2++)
            anIntArray799[j2 + 64] = 65280 + 4 * j2;

        for (int k2 = 0; k2 < 64; k2++)
            anIntArray799[k2 + 128] = 65535 + 0x40000 * k2;

        for (int l2 = 0; l2 < 64; l2++)
            anIntArray799[l2 + 192] = 0xffffff;

        anIntArray800 = new int[256];
        for (int i3 = 0; i3 < 64; i3++)
            anIntArray800[i3] = i3 * 4;

        for (int j3 = 0; j3 < 64; j3++)
            anIntArray800[j3 + 64] = 255 + 0x40000 * j3;

        for (int k3 = 0; k3 < 64; k3++)
            anIntArray800[k3 + 128] = 0xff00ff + 1024 * k3;

        for (int l3 = 0; l3 < 64; l3++)
            anIntArray800[l3 + 192] = 0xffffff;

        anIntArray797 = new int[256];
        anIntArray956 = new int[32768];
        anIntArray957 = new int[32768];
        method97((byte) 57, null);
        anIntArray795 = new int[32768];
        anIntArray796 = new int[32768];
        showProgress((byte) -75, 10, "Connecting to fileserver");
        if (!aBoolean906) {
            aBoolean740 = true;
            aBoolean906 = true;
            method12(this, 2);
        }
    }

    public void method57(int i) {
        LocType.aCache_568.method297();
        LocType.aCache_569.method297();
        if (i != -40161) {
            for (int j = 1; j > 0; j++) ;
        }
        NpcType.aCache_597.method297();
        ObjType.aCache_633.method297();
        ObjType.aCache_634.method297();
        PlayerEntity.aCache_1348.method297();
        SpotAnimType.aCache_219.method297();
    }

    public void method58(int i, int j, int k, int l, Component class8, int i1, int j1) {
        if (class8.anInt117 != 0 || class8.anIntArray131 == null || class8.aBoolean130)
            return;
        if (l < k || i1 < j1 || l > k + class8.anInt120 || i1 > j1 + class8.anInt121)
            return;
        int k1 = class8.anIntArray131.length;
        if (i != anInt953)
            anInt845 = 313;
        for (int l1 = 0; l1 < k1; l1++) {
            int i2 = class8.anIntArray132[l1] + k;
            int j2 = (class8.anIntArray133[l1] + j1) - j;
            Component class8_1 = Component.aComponentArray110[class8.anIntArray131[l1]];
            i2 += class8_1.anInt122;
            j2 += class8_1.anInt123;
            if ((class8_1.anInt127 >= 0 || class8_1.anInt153 != 0) && l >= i2 && i1 >= j2 && l < i2 + class8_1.anInt120 && i1 < j2 + class8_1.anInt121)
                if (class8_1.anInt127 >= 0)
                    anInt823 = class8_1.anInt127;
                else
                    anInt823 = class8_1.anInt115;
            if (class8_1.anInt117 == 0) {
                method58(4, class8_1.anInt129, i2, l, class8_1, i1, j2);
                if (class8_1.anInt128 > class8_1.anInt121)
                    method100(true, class8_1.anInt128, l, class8_1, i2 + class8_1.anInt120, aByte656, class8_1.anInt121, i1, j2);
            } else {
                if (class8_1.anInt118 == 1 && l >= i2 && i1 >= j2 && l < i2 + class8_1.anInt120 && i1 < j2 + class8_1.anInt121) {
                    aStringArray720[anInt710] = class8_1.aString166;
                    anIntArray848[anInt710] = 508;
                    anIntArray847[anInt710] = class8_1.anInt115;
                    anInt710++;
                }
                if (class8_1.anInt118 == 2 && anInt706 == 0 && l >= i2 && i1 >= j2 && l < i2 + class8_1.anInt120 && i1 < j2 + class8_1.anInt121) {
                    String s = class8_1.aString163;
                    if (s.indexOf(" ") != -1)
                        s = s.substring(0, s.indexOf(" "));
                    aStringArray720[anInt710] = s + " @gre@" + class8_1.aString164;
                    anIntArray848[anInt710] = 458;
                    anIntArray847[anInt710] = class8_1.anInt115;
                    anInt710++;
                }
                if (class8_1.anInt118 == 3 && l >= i2 && i1 >= j2 && l < i2 + class8_1.anInt120 && i1 < j2 + class8_1.anInt121) {
                    aStringArray720[anInt710] = "Close";
                    anIntArray848[anInt710] = 850;
                    anIntArray847[anInt710] = class8_1.anInt115;
                    anInt710++;
                }
                if (class8_1.anInt118 == 4 && l >= i2 && i1 >= j2 && l < i2 + class8_1.anInt120 && i1 < j2 + class8_1.anInt121) {
                    aStringArray720[anInt710] = class8_1.aString166;
                    anIntArray848[anInt710] = 170;
                    anIntArray847[anInt710] = class8_1.anInt115;
                    anInt710++;
                }
                if (class8_1.anInt118 == 5 && l >= i2 && i1 >= j2 && l < i2 + class8_1.anInt120 && i1 < j2 + class8_1.anInt121) {
                    aStringArray720[anInt710] = class8_1.aString166;
                    anIntArray848[anInt710] = 638;
                    anIntArray847[anInt710] = class8_1.anInt115;
                    anInt710++;
                }
                if (class8_1.anInt118 == 6 && !aBoolean888 && l >= i2 && i1 >= j2 && l < i2 + class8_1.anInt120 && i1 < j2 + class8_1.anInt121) {
                    aStringArray720[anInt710] = class8_1.aString166;
                    anIntArray848[anInt710] = 199;
                    anIntArray847[anInt710] = class8_1.anInt115;
                    anInt710++;
                }
                if (class8_1.anInt117 == 2) {
                    int k2 = 0;
                    for (int l2 = 0; l2 < class8_1.anInt121; l2++) {
                        for (int i3 = 0; i3 < class8_1.anInt120; i3++) {
                            int j3 = i2 + i3 * (32 + class8_1.anInt139);
                            int k3 = j2 + l2 * (32 + class8_1.anInt140);
                            if (k2 < 20) {
                                j3 += class8_1.anIntArray142[k2];
                                k3 += class8_1.anIntArray143[k2];
                            }
                            if (l >= j3 && i1 >= k3 && l < j3 + 32 && i1 < k3 + 32) {
                                anInt658 = k2;
                                anInt659 = class8_1.anInt115;
                                if (class8_1.anIntArray111[k2] > 0) {
                                    ObjType class41 = ObjType.method440(class8_1.anIntArray111[k2] - 1);
                                    if (anInt712 == 1 && class8_1.aBoolean137) {
                                        if (class8_1.anInt115 != anInt714 || k2 != anInt713) {
                                            aStringArray720[anInt710] = "Use " + aString716 + " with @lre@" + class41.aString606;
                                            anIntArray848[anInt710] = 786;
                                            anIntArray849[anInt710] = class41.anInt604;
                                            anIntArray846[anInt710] = k2;
                                            anIntArray847[anInt710] = class8_1.anInt115;
                                            anInt710++;
                                        }
                                    } else if (anInt706 == 1 && class8_1.aBoolean137) {
                                        if ((anInt708 & 0x10) == 16) {
                                            aStringArray720[anInt710] = aString709 + " @lre@" + class41.aString606;
                                            anIntArray848[anInt710] = 602;
                                            anIntArray849[anInt710] = class41.anInt604;
                                            anIntArray846[anInt710] = k2;
                                            anIntArray847[anInt710] = class8_1.anInt115;
                                            anInt710++;
                                        }
                                    } else {
                                        if (class8_1.aBoolean137) {
                                            for (int l3 = 4; l3 >= 3; l3--)
                                                if (class41.aStringArray622 != null && class41.aStringArray622[l3] != null) {
                                                    aStringArray720[anInt710] = class41.aStringArray622[l3] + " @lre@" + class41.aString606;
                                                    if (l3 == 3)
                                                        anIntArray848[anInt710] = 294;
                                                    if (l3 == 4)
                                                        anIntArray848[anInt710] = 622;
                                                    anIntArray849[anInt710] = class41.anInt604;
                                                    anIntArray846[anInt710] = k2;
                                                    anIntArray847[anInt710] = class8_1.anInt115;
                                                    anInt710++;
                                                } else if (l3 == 4) {
                                                    aStringArray720[anInt710] = "Drop @lre@" + class41.aString606;
                                                    anIntArray848[anInt710] = 622;
                                                    anIntArray849[anInt710] = class41.anInt604;
                                                    anIntArray846[anInt710] = k2;
                                                    anIntArray847[anInt710] = class8_1.anInt115;
                                                    anInt710++;
                                                }

                                        }
                                        if (class8_1.aBoolean138) {
                                            aStringArray720[anInt710] = "Use @lre@" + class41.aString606;
                                            anIntArray848[anInt710] = 517;
                                            anIntArray849[anInt710] = class41.anInt604;
                                            anIntArray846[anInt710] = k2;
                                            anIntArray847[anInt710] = class8_1.anInt115;
                                            anInt710++;
                                        }
                                        if (class8_1.aBoolean137 && class41.aStringArray622 != null) {
                                            for (int i4 = 2; i4 >= 0; i4--)
                                                if (class41.aStringArray622[i4] != null) {
                                                    aStringArray720[anInt710] = class41.aStringArray622[i4] + " @lre@" + class41.aString606;
                                                    if (i4 == 0)
                                                        anIntArray848[anInt710] = 649;
                                                    if (i4 == 1)
                                                        anIntArray848[anInt710] = 408;
                                                    if (i4 == 2)
                                                        anIntArray848[anInt710] = 176;
                                                    anIntArray849[anInt710] = class41.anInt604;
                                                    anIntArray846[anInt710] = k2;
                                                    anIntArray847[anInt710] = class8_1.anInt115;
                                                    anInt710++;
                                                }

                                        }
                                        if (class8_1.aStringArray144 != null) {
                                            for (int j4 = 4; j4 >= 0; j4--)
                                                if (class8_1.aStringArray144[j4] != null) {
                                                    aStringArray720[anInt710] = class8_1.aStringArray144[j4] + " @lre@" + class41.aString606;
                                                    if (j4 == 0)
                                                        anIntArray848[anInt710] = 288;
                                                    if (j4 == 1)
                                                        anIntArray848[anInt710] = 776;
                                                    if (j4 == 2)
                                                        anIntArray848[anInt710] = 857;
                                                    if (j4 == 3)
                                                        anIntArray848[anInt710] = 881;
                                                    if (j4 == 4)
                                                        anIntArray848[anInt710] = 688;
                                                    anIntArray849[anInt710] = class41.anInt604;
                                                    anIntArray846[anInt710] = k2;
                                                    anIntArray847[anInt710] = class8_1.anInt115;
                                                    anInt710++;
                                                }

                                        }
                                        aStringArray720[anInt710] = "Examine @lre@" + class41.aString606;
                                        anIntArray848[anInt710] = 1685;
                                        anIntArray849[anInt710] = class41.anInt604;
                                        anInt710++;
                                    }
                                }
                            }
                            k2++;
                        }

                    }

                }
            }
        }

    }

    public void method59(int i, int j) {
        if (j < 0)
            return;
        if (aBoolean763) {
            aBoolean763 = false;
            aBoolean653 = true;
        }
        int k = anIntArray846[j];
        int l = anIntArray847[j];
        int i1 = anIntArray848[j];
        int j1 = anIntArray849[j];
        if (i1 == 170) {
            outBuffer.p1isaac(167);
            outBuffer.p2(l);
            Component class8 = Component.aComponentArray110[l];
            if (class8.anIntArrayArray124 != null && class8.anIntArrayArray124[0][0] == 5) {
                int l1 = class8.anIntArrayArray124[0][1];
                anIntArray822[l1] = 1 - anIntArray822[l1];
                method38(l1, (byte) 7);
                sidebarRedraw = true;
            }
        }
        if (i1 == 647)
            method70(l, k, j1, 734, 249);
        if (i1 == 517) {
            anInt712 = 1;
            anInt713 = k;
            anInt714 = l;
            anInt715 = j1;
            aString716 = ObjType.method440(j1).aString606;
            anInt706 = 0;
            return;
        }
        if (i1 == 310)
            method70(l, k, j1, 734, 82);
        if (i1 == 490 || i1 == 914 || i1 == 75 || i1 == 486 || i1 == 772) {
            NpcEntity class35_sub7_sub3_sub1 = aClass35_Sub7_Sub3_Sub1Array964[j1];
            if (class35_sub7_sub3_sub1 != null) {
                method73(class35_sub7_sub3_sub1.pathTileZ[0], true, 0, false, 1, 1, 0, 0, self.pathTileZ[0], self.pathTileX[0], class35_sub7_sub3_sub1.pathTileX[0]);
                anInt816 = super.anInt23;
                anInt817 = super.anInt24;
                anInt819 = 2;
                anInt818 = 0;
                if (i1 == 75)
                    outBuffer.p1isaac(228);
                if (i1 == 914)
                    outBuffer.p1isaac(55);
                if (i1 == 490)
                    outBuffer.p1isaac(160);
                if (i1 == 486)
                    outBuffer.p1isaac(88);
                if (i1 == 772)
                    outBuffer.p1isaac(37);
                outBuffer.p2(j1);
            }
        }
        if (i1 == 792 && method70(l, k, j1, 734, 177))
            outBuffer.p2(anInt707);
        if (i1 == 174 && method70(l, k, j1, 734, 7)) {
            outBuffer.p2(anInt715);
            outBuffer.p2(anInt713);
            outBuffer.p2(anInt714);
        }
        if (i1 == 1318) {
            NpcEntity class35_sub7_sub3_sub1_1 = aClass35_Sub7_Sub3_Sub1Array964[j1];
            if (class35_sub7_sub3_sub1_1 != null) {
                String s;
                if (class35_sub7_sub3_sub1_1.aNpcType_1325.aByteArray577 != null)
                    s = new String(class35_sub7_sub3_sub1_1.aNpcType_1325.aByteArray577);
                else
                    s = "It's a " + class35_sub7_sub3_sub1_1.aNpcType_1325.aString576 + ".";
                method75(s, 0, anInt853, "");
            }
        }
        if (i1 == 404)
            if (!aBoolean838)
                aMapSquare_741.method274(0, super.anInt23 - 8, super.anInt24 - 11);
            else
                aMapSquare_741.method274(0, k - 8, l - 11);
        if (i1 == 652) {
            boolean flag = method73(l, true, 0, false, 0, 0, 0, 0, self.pathTileZ[0], self.pathTileX[0], k);
            if (!flag)
                flag = method73(l, true, 0, false, 1, 1, 0, 0, self.pathTileZ[0], self.pathTileX[0], k);
            anInt816 = super.anInt23;
            anInt817 = super.anInt24;
            anInt819 = 2;
            anInt818 = 0;
            outBuffer.p1isaac(209);
            outBuffer.p2(k + anInt855);
            outBuffer.p2(l + anInt856);
            outBuffer.p2(j1);
            outBuffer.p2(anInt715);
            outBuffer.p2(anInt713);
            outBuffer.p2(anInt714);
        }
        if (i1 == 786) {
            outBuffer.p1isaac(40);
            outBuffer.p2(j1);
            outBuffer.p2(k);
            outBuffer.p2(l);
            outBuffer.p2(anInt715);
            outBuffer.p2(anInt713);
            outBuffer.p2(anInt714);
            anInt802 = 0;
            anInt803 = l;
            anInt804 = k;
            anInt805 = 2;
            if (Component.aComponentArray110[l].anInt116 == anInt962)
                anInt805 = 1;
            if (Component.aComponentArray110[l].anInt116 == anInt702)
                anInt805 = 3;
        }
        if (i1 == 364 || i1 == 900 || i1 == 487 || i1 == 953) {
            PlayerEntity class35_sub7_sub3_sub2 = aPlayerEntityArray751[j1];
            if (class35_sub7_sub3_sub2 != null) {
                method73(class35_sub7_sub3_sub2.pathTileZ[0], true, 0, false, 1, 1, 0, 0, self.pathTileZ[0], self.pathTileX[0], class35_sub7_sub3_sub2.pathTileX[0]);
                anInt816 = super.anInt23;
                anInt817 = super.anInt24;
                anInt819 = 2;
                anInt818 = 0;
                if (i1 == 900)
                    outBuffer.p1isaac(3);
                if (i1 == 953)
                    outBuffer.p1isaac(232);
                if (i1 == 364)
                    outBuffer.p1isaac(216);
                if (i1 == 487)
                    outBuffer.p1isaac(13);
                outBuffer.p2(j1);
            }
        }
        if (i1 == 1419) {
            int k1 = j1 >> 14 & 0x7fff;
            LocType class39 = LocType.method428(k1);
            String s3;
            if (class39.aByteArray539 != null)
                s3 = new String(class39.aByteArray539);
            else
                s3 = "It's a " + class39.aString538 + ".";
            method75(s3, 0, anInt853, "");
        }
        if (i1 == 34)
            method70(l, k, j1, 734, 229);
        if (i1 == 288 || i1 == 776 || i1 == 857 || i1 == 881 || i1 == 688) {
            if (i1 == 776)
                outBuffer.p1isaac(53);
            if (i1 == 688)
                outBuffer.p1isaac(220);
            if (i1 == 857)
                outBuffer.p1isaac(146);
            if (i1 == 288)
                outBuffer.p1isaac(184);
            if (i1 == 881)
                outBuffer.p1isaac(240);
            outBuffer.p2(j1);
            outBuffer.p2(k);
            outBuffer.p2(l);
            anInt802 = 0;
            anInt803 = l;
            anInt804 = k;
            anInt805 = 2;
            if (Component.aComponentArray110[l].anInt116 == anInt962)
                anInt805 = 1;
            if (Component.aComponentArray110[l].anInt116 == anInt702)
                anInt805 = 3;
        }
        if (i1 == 199 && !aBoolean888) {
            outBuffer.p1isaac(194);
            outBuffer.p2(l);
            aBoolean888 = true;
        }
        if (i1 == 985) {
            NpcEntity class35_sub7_sub3_sub1_2 = aClass35_Sub7_Sub3_Sub1Array964[j1];
            if (class35_sub7_sub3_sub1_2 != null) {
                method73(class35_sub7_sub3_sub1_2.pathTileZ[0], true, 0, false, 1, 1, 0, 0, self.pathTileZ[0], self.pathTileX[0], class35_sub7_sub3_sub1_2.pathTileX[0]);
                anInt816 = super.anInt23;
                anInt817 = super.anInt24;
                anInt819 = 2;
                anInt818 = 0;
                outBuffer.p1isaac(144);
                outBuffer.p2(j1);
                outBuffer.p2(anInt715);
                outBuffer.p2(anInt713);
                outBuffer.p2(anInt714);
            }
        }
        if (i1 == 850) {
            outBuffer.p1isaac(122);
            if (anInt981 != -1) {
                anInt981 = -1;
                sidebarRedraw = true;
                aBoolean888 = false;
                aBoolean992 = true;
            }
            if (anInt702 != -1) {
                anInt702 = -1;
                aBoolean653 = true;
                aBoolean888 = false;
            }
            anInt962 = -1;
        }
        if (i1 == 926) {
            boolean flag1 = method73(l, true, 0, false, 0, 0, 0, 0, self.pathTileZ[0], self.pathTileX[0], k);
            if (!flag1)
                flag1 = method73(l, true, 0, false, 1, 1, 0, 0, self.pathTileZ[0], self.pathTileX[0], k);
            anInt816 = super.anInt23;
            anInt817 = super.anInt24;
            anInt819 = 2;
            anInt818 = 0;
            outBuffer.p1isaac(45);
            outBuffer.p2(k + anInt855);
            outBuffer.p2(l + anInt856);
            outBuffer.p2(j1);
            outBuffer.p2(anInt707);
        }
        if (i1 == 602) {
            outBuffer.p1isaac(231);
            outBuffer.p2(j1);
            outBuffer.p2(k);
            outBuffer.p2(l);
            outBuffer.p2(anInt707);
            anInt802 = 0;
            anInt803 = l;
            anInt804 = k;
            anInt805 = 2;
            if (Component.aComponentArray110[l].anInt116 == anInt962)
                anInt805 = 1;
            if (Component.aComponentArray110[l].anInt116 == anInt702)
                anInt805 = 3;
        }
        if (i1 == 649 || i1 == 408 || i1 == 176 || i1 == 294 || i1 == 622) {
            if (i1 == 176)
                outBuffer.p1isaac(9);
            if (i1 == 622)
                outBuffer.p1isaac(110);
            if (i1 == 649)
                outBuffer.p1isaac(80);
            if (i1 == 408)
                outBuffer.p1isaac(139);
            if (i1 == 294)
                outBuffer.p1isaac(26);
            outBuffer.p2(j1);
            outBuffer.p2(k);
            outBuffer.p2(l);
            anInt802 = 0;
            anInt803 = l;
            anInt804 = k;
            anInt805 = 2;
            if (Component.aComponentArray110[l].anInt116 == anInt962)
                anInt805 = 1;
            if (Component.aComponentArray110[l].anInt116 == anInt702)
                anInt805 = 3;
        }
        if (i1 == 533 || i1 == 947 || i1 == 705 || i1 == 912 || i1 == 603) {
            boolean flag2 = method73(l, true, 0, false, 0, 0, 0, 0, self.pathTileZ[0], self.pathTileX[0], k);
            if (!flag2)
                flag2 = method73(l, true, 0, false, 1, 1, 0, 0, self.pathTileZ[0], self.pathTileX[0], k);
            anInt816 = super.anInt23;
            anInt817 = super.anInt24;
            anInt819 = 2;
            anInt818 = 0;
            if (i1 == 912)
                outBuffer.p1isaac(142);
            if (i1 == 705)
                outBuffer.p1isaac(96);
            if (i1 == 603)
                outBuffer.p1isaac(131);
            if (i1 == 947)
                outBuffer.p1isaac(251);
            if (i1 == 533)
                outBuffer.p1isaac(91);
            outBuffer.p2(k + anInt855);
            outBuffer.p2(l + anInt856);
            outBuffer.p2(j1);
        }
        if (i1 == 1585 || i1 == 1685) {
            ObjType class41 = ObjType.method440(j1);
            String s1;
            if (class41.aByteArray607 != null)
                s1 = new String(class41.aByteArray607);
            else
                s1 = "It's a " + class41.aString606 + ".";
            method75(s1, 0, anInt853, "");
        }
        if (i1 == 638) {
            outBuffer.p1isaac(167);
            outBuffer.p2(l);
            Component class8_1 = Component.aComponentArray110[l];
            if (class8_1.anIntArrayArray124 != null && class8_1.anIntArrayArray124[0][0] == 5) {
                int i2 = class8_1.anIntArrayArray124[0][1];
                if (anIntArray822[i2] != class8_1.anIntArray126[0]) {
                    anIntArray822[i2] = class8_1.anIntArray126[0];
                    method38(i2, (byte) 7);
                    sidebarRedraw = true;
                }
            }
        }
        if (i1 == 447)
            method70(l, k, j1, 734, 16);
        if (i1 == 458) {
            Component class8_2 = Component.aComponentArray110[l];
            anInt706 = 1;
            anInt707 = l;
            anInt708 = class8_2.anInt165;
            anInt712 = 0;
            String s2 = class8_2.aString163;
            if (s2.indexOf(" ") != -1)
                s2 = s2.substring(0, s2.indexOf(" "));
            String s4 = class8_2.aString163;
            if (s4.indexOf(" ") != -1)
                s4 = s4.substring(s4.indexOf(" ") + 1);
            aString709 = s2 + " " + class8_2.aString164 + " " + s4;
            if (anInt708 == 16) {
                sidebarRedraw = true;
                anInt907 = 3;
                aBoolean992 = true;
            }
            return;
        }
        if (i1 == 508) {
            Component class8_3 = Component.aComponentArray110[l];
            boolean flag3 = true;
            if (class8_3.anInt119 > 0)
                flag3 = method68(class8_3, (byte) 3);
            if (flag3) {
                outBuffer.p1isaac(167);
                outBuffer.p2(l);
            }
        }
        if (i1 == 846)
            method70(l, k, j1, 734, 171);
        if (i1 == 946) {
            NpcEntity class35_sub7_sub3_sub1_3 = aClass35_Sub7_Sub3_Sub1Array964[j1];
            if (class35_sub7_sub3_sub1_3 != null) {
                method73(class35_sub7_sub3_sub1_3.pathTileZ[0], true, 0, false, 1, 1, 0, 0, self.pathTileZ[0], self.pathTileX[0], class35_sub7_sub3_sub1_3.pathTileX[0]);
                anInt816 = super.anInt23;
                anInt817 = super.anInt24;
                anInt819 = 2;
                anInt818 = 0;
                outBuffer.p1isaac(213);
                outBuffer.p2(j1);
                outBuffer.p2(anInt707);
            }
        }
        if (i1 == 989) {
            PlayerEntity class35_sub7_sub3_sub2_1 = aPlayerEntityArray751[j1];
            if (class35_sub7_sub3_sub2_1 != null) {
                method73(class35_sub7_sub3_sub2_1.pathTileZ[0], true, 0, false, 1, 1, 0, 0, self.pathTileZ[0], self.pathTileX[0], class35_sub7_sub3_sub2_1.pathTileX[0]);
                anInt816 = super.anInt23;
                anInt817 = super.anInt24;
                anInt819 = 2;
                anInt818 = 0;
                outBuffer.p1isaac(172);
                outBuffer.p2(j1);
                outBuffer.p2(anInt707);
            }
        }
        if (i1 == 933) {
            PlayerEntity class35_sub7_sub3_sub2_2 = aPlayerEntityArray751[j1];
            if (class35_sub7_sub3_sub2_2 != null) {
                method73(class35_sub7_sub3_sub2_2.pathTileZ[0], true, 0, false, 1, 1, 0, 0, self.pathTileZ[0], self.pathTileX[0], class35_sub7_sub3_sub2_2.pathTileX[0]);
                anInt816 = super.anInt23;
                anInt817 = super.anInt24;
                anInt819 = 2;
                anInt818 = 0;
                outBuffer.p1isaac(10);
                outBuffer.p2(j1);
                outBuffer.p2(anInt715);
                outBuffer.p2(anInt713);
                outBuffer.p2(anInt714);
            }
        }
        anInt712 = 0;
        anInt706 = 0;
        if (i != anInt711)
            packetOpcode = inBuffer.g1();
    }

    public void method60(int i) {
        if (anInt738 > 1)
            anInt738--;
        for (int j = 0; j < 5; j++)
            if (!method26(0))
                break;

        if (!aBoolean734)
            return;
        if (InputTracking.aBoolean103) {
            Buffer class35_sub2_sub3 = InputTracking.method161(-800);
            if (class35_sub2_sub3 != null) {
                outBuffer.p1isaac(35);
                outBuffer.p2(class35_sub2_sub3.pos);
                outBuffer.pdata(class35_sub2_sub3.data, 0, class35_sub2_sub3.pos);
                class35_sub2_sub3.release();
            }
        }
        anInt812++;
        if (anInt812 > 750)
            method34(0);
        method116(116);
        method81(false);
        method40(-888);
        if (i >= 0)
            aBoolean835 = !aBoolean835;
        method31(false);
        anInt742++;
        if (anInt819 != 0) {
            anInt818 += 20;
            if (anInt818 >= 400)
                anInt819 = 0;
        }
        if (anInt805 != 0) {
            anInt802++;
            if (anInt802 >= 15) {
                if (anInt805 == 2)
                    sidebarRedraw = true;
                if (anInt805 == 3)
                    aBoolean653 = true;
                anInt805 = 0;
            }
        }
        if (anInt774 != 0) {
            if (super.anInt20 > anInt775 + 5 || super.anInt20 < anInt775 - 5 || super.anInt21 > anInt776 + 5 || super.anInt21 < anInt776 - 5)
                aBoolean704 = true;
            if (super.anInt19 == 0) {
                if (anInt774 == 2)
                    sidebarRedraw = true;
                if (anInt774 == 3)
                    aBoolean653 = true;
                anInt774 = 0;
                if (aBoolean704) {
                    anInt659 = -1;
                    method80(0);
                    if (anInt659 == anInt772 && anInt658 != anInt773) {
                        Component class8 = Component.aComponentArray110[anInt772];
                        int i1 = class8.anIntArray111[anInt658];
                        class8.anIntArray111[anInt658] = class8.anIntArray111[anInt773];
                        class8.anIntArray111[anInt773] = i1;
                        i1 = class8.anIntArray112[anInt658];
                        class8.anIntArray112[anInt658] = class8.anIntArray112[anInt773];
                        class8.anIntArray112[anInt773] = i1;
                        outBuffer.p1isaac(61);
                        outBuffer.p2(anInt772);
                        outBuffer.p2(anInt773);
                        outBuffer.p2(anInt658);
                    }
                } else if (anInt748 == 1 && anInt710 > 2)
                    method30(-23085);
                else if (anInt710 > 0)
                    method59(anInt711, anInt710 - 1);
                anInt802 = 10;
                super.anInt22 = 0;
            }
        }
        if (MapSquare.anInt416 != -1) {
            int k = MapSquare.anInt416;
            int j1 = MapSquare.anInt417;
            boolean flag = method73(j1, true, 0, true, 0, 0, 0, 0, self.pathTileZ[0], self.pathTileX[0], k);
            MapSquare.anInt416 = -1;
            if (flag) {
                anInt816 = super.anInt23;
                anInt817 = super.anInt24;
                anInt819 = 1;
                anInt818 = 0;
            }
        }
        method101(0);
        method69(anInt780);
        method65(7);
        method64(962);
        if (super.anInt19 == 1 || super.anInt22 == 1)
            anInt766++;
        if (anInt969 == 2)
            method52((byte) 2);
        if (anInt969 == 2 && aBoolean682)
            method63(1);
        for (int l = 0; l < 5; l++)
            anIntArray967[l]++;

        method32(206);
        super.anInt18++;
        if (super.anInt18 > 4500) {
            super.anInt18 -= 500;
            outBuffer.p1isaac(126);
        }
        anInt951++;
        if (anInt951 > 500) {
            anInt951 = 0;
            int k1 = (int) (Math.random() * 8D);
            if ((k1 & 1) == 1)
                anInt912 += anInt913;
            if ((k1 & 2) == 2)
                anInt689 += anInt690;
            if ((k1 & 4) == 4)
                anInt874 += anInt875;
        }
        if (anInt912 < -50)
            anInt913 = 2;
        if (anInt912 > 50)
            anInt913 = -2;
        if (anInt689 < -55)
            anInt690 = 2;
        if (anInt689 > 55)
            anInt690 = -2;
        if (anInt874 < -40)
            anInt875 = 1;
        if (anInt874 > 40)
            anInt875 = -1;
        anInt813++;
        if (anInt813 > 50)
            outBuffer.p1isaac(87);
        try {
            if (stream != null && outBuffer.pos > 0) {
                stream.write(outBuffer.data, outBuffer.pos, false, 0);
                outBuffer.pos = 0;
                anInt813 = 0;
                return;
            }
        } catch (IOException _ex) {
            method34(0);
            return;
        } catch (Exception exception) {
            logout(anInt839);
        }
    }

    public void method61(int i) {
        if (i != 7)
            packetOpcode = -1;
        for (LocEntity class35_sub5 = (LocEntity) aLinkedList_943.method227(); class35_sub5 != null; class35_sub5 = (LocEntity) aLinkedList_943.method229(35239)) {
            boolean flag = false;
            class35_sub5.anInt1046 += anInt742;
            if (class35_sub5.anInt1045 == -1) {
                class35_sub5.anInt1045 = 0;
                flag = true;
            }
            while (class35_sub5.anInt1046 > class35_sub5.aSeqType_1044.anIntArray194[class35_sub5.anInt1045]) {
                class35_sub5.anInt1046 -= class35_sub5.aSeqType_1044.anIntArray194[class35_sub5.anInt1045] + 1;
                class35_sub5.anInt1045++;
                flag = true;
                if (class35_sub5.anInt1045 < class35_sub5.aSeqType_1044.anInt191)
                    continue;
                class35_sub5.anInt1045 -= class35_sub5.aSeqType_1044.anInt195;
                if (class35_sub5.anInt1045 >= 0 && class35_sub5.anInt1045 < class35_sub5.aSeqType_1044.anInt191)
                    continue;
                class35_sub5.method303();
                flag = false;
                break;
            }
            if (flag) {
                int j = class35_sub5.anInt1039;
                int k = class35_sub5.anInt1041;
                int l = class35_sub5.anInt1042;
                int i1 = 0;
                if (class35_sub5.anInt1040 == 0)
                    i1 = aMapSquare_741.method262(j, k, l);
                if (class35_sub5.anInt1040 == 1)
                    i1 = aMapSquare_741.method263(k, l, anInt845, j);
                if (class35_sub5.anInt1040 == 2)
                    i1 = aMapSquare_741.method264(j, k, l);
                if (i1 == 0 || (i1 >> 14 & 0x7fff) != class35_sub5.anInt1043) {
                    class35_sub5.method303();
                } else {
                    int j1 = anIntArrayArrayArray725[j][k][l];
                    int k1 = anIntArrayArrayArray725[j][k + 1][l];
                    int l1 = anIntArrayArrayArray725[j][k + 1][l + 1];
                    int i2 = anIntArrayArrayArray725[j][k][l + 1];
                    LocType class39 = LocType.method428(class35_sub5.anInt1043);
                    int j2 = -1;
                    if (class35_sub5.anInt1045 != -1)
                        j2 = class35_sub5.aSeqType_1044.anIntArray192[class35_sub5.anInt1045];
                    if (class35_sub5.anInt1040 == 2) {
                        int k2 = aMapSquare_741.method266(j, k, l, i1);
                        int i3 = k2 & 0x1f;
                        int k3 = k2 >> 6;
                        Model class35_sub2_sub1_1 = class39.method431(i3, k3, j1, k1, l1, i2, j2);
                        aMapSquare_741.method254(class35_sub2_sub1_1, 959, l, k, j);
                    } else if (class35_sub5.anInt1040 == 1) {
                        Model class35_sub2_sub1 = class39.method431(4, 0, j1, k1, l1, i2, j2);
                        aMapSquare_741.method255(38499, k, l, class35_sub2_sub1, j);
                    } else if (class35_sub5.anInt1040 == 0) {
                        int l2 = aMapSquare_741.method266(j, k, l, i1);
                        int j3 = l2 & 0x1f;
                        int l3 = l2 >> 6;
                        Model class35_sub2_sub1_2 = class39.method431(j3, l3, j1, k1, l1, i2, j2);
                        aMapSquare_741.method256(class35_sub2_sub1_2, aByte950, j, l, k);
                    }
                }
            }
        }

    }

    public static String method62(int i, byte byte0, int j) {
        if (byte0 != -102)
            aBoolean835 = !aBoolean835;
        int k = j - i;
        if (k < -9)
            return "@red@";
        if (k < -6)
            return "@or3@";
        if (k < -3)
            return "@or2@";
        if (k < 0)
            return "@or1@";
        if (k > 9)
            return "@gre@";
        if (k > 6)
            return "@gr3@";
        if (k > 3)
            return "@gr2@";
        if (k > 0)
            return "@gr1@";
        else
            return "@yel@";
    }

    public void method63(int i) {
        if (i != 1)
            packetOpcode = -1;
        int j = anInt864 * 128 + 64;
        int k = anInt865 * 128 + 64;
        int l = method15(anInt864, anInt865, anInt722, (byte) 9) - anInt866;
        if (anInt918 < j) {
            anInt918 += anInt867 + ((j - anInt918) * anInt868) / 1000;
            if (anInt918 > j)
                anInt918 = j;
        }
        if (anInt918 > j) {
            anInt918 -= anInt867 + ((anInt918 - j) * anInt868) / 1000;
            if (anInt918 < j)
                anInt918 = j;
        }
        if (anInt919 < l) {
            anInt919 += anInt867 + ((l - anInt919) * anInt868) / 1000;
            if (anInt919 > l)
                anInt919 = l;
        }
        if (anInt919 > l) {
            anInt919 -= anInt867 + ((anInt919 - l) * anInt868) / 1000;
            if (anInt919 < l)
                anInt919 = l;
        }
        if (anInt920 < k) {
            anInt920 += anInt867 + ((k - anInt920) * anInt868) / 1000;
            if (anInt920 > k)
                anInt920 = k;
        }
        if (anInt920 > k) {
            anInt920 -= anInt867 + ((anInt920 - k) * anInt868) / 1000;
            if (anInt920 < k)
                anInt920 = k;
        }
        j = anInt790 * 128 + 64;
        k = anInt791 * 128 + 64;
        l = method15(anInt790, anInt791, anInt722, (byte) 9) - anInt792;
        int i1 = j - anInt918;
        int j1 = l - anInt919;
        int k1 = k - anInt920;
        int l1 = (int) Math.sqrt(i1 * i1 + k1 * k1);
        int i2 = (int) (Math.atan2(j1, l1) * 325.94900000000001D) & 0x7ff;
        int j2 = (int) (Math.atan2(i1, k1) * -325.94900000000001D) & 0x7ff;
        if (i2 < 128)
            i2 = 128;
        if (i2 > 383)
            i2 = 383;
        if (anInt921 < i2) {
            anInt921 += anInt793 + ((i2 - anInt921) * anInt794) / 1000;
            if (anInt921 > i2)
                anInt921 = i2;
        }
        if (anInt921 > i2) {
            anInt921 -= anInt793 + ((anInt921 - i2) * anInt794) / 1000;
            if (anInt921 < i2)
                anInt921 = i2;
        }
        int k2 = j2 - anInt922;
        if (k2 > 1024)
            k2 -= 2048;
        if (k2 < -1024)
            k2 += 2048;
        if (k2 > 0)
            anInt922 += anInt793 + (k2 * anInt794) / 1000;
        if (k2 < 0)
            anInt922 -= anInt793 + (-k2 * anInt794) / 1000;
        int l2 = j2 - anInt922;
        if (l2 > 1024)
            l2 -= 2048;
        if (l2 < -1024)
            l2 += 2048;
        if (l2 < 0 && k2 > 0 || l2 > 0 && k2 < 0)
            anInt922 = j2;
    }

    public void method64(int i) {
        i = 82 / i;
        if (super.anInt22 == 1) {
            if (super.anInt23 >= 8 && super.anInt23 <= 108 && super.anInt24 >= 490 && super.anInt24 <= 522) {
                anInt976 = (anInt976 + 1) % 3;
                aBoolean655 = true;
                aBoolean653 = true;
                outBuffer.p1isaac(227);
                outBuffer.p1(anInt976);
                outBuffer.p1(anInt762);
                outBuffer.p1(anInt821);
            }
            if (super.anInt23 >= 137 && super.anInt23 <= 237 && super.anInt24 >= 490 && super.anInt24 <= 522) {
                anInt762 = (anInt762 + 1) % 3;
                aBoolean655 = true;
                aBoolean653 = true;
                outBuffer.p1isaac(227);
                outBuffer.p1(anInt976);
                outBuffer.p1(anInt762);
                outBuffer.p1(anInt821);
            }
            if (super.anInt23 >= 275 && super.anInt23 <= 375 && super.anInt24 >= 490 && super.anInt24 <= 522) {
                anInt821 = (anInt821 + 1) % 3;
                aBoolean655 = true;
                aBoolean653 = true;
                outBuffer.p1isaac(227);
                outBuffer.p1(anInt976);
                outBuffer.p1(anInt762);
                outBuffer.p1(anInt821);
            }
            boolean _tmp = super.anInt23 >= 416 && super.anInt23 <= 516 && super.anInt24 >= 490 && super.anInt24 <= 522;
        }
    }

    public void method65(int i) {
        if (i != 7)
            packetOpcode = -1;
        if (super.anInt22 == 1) {
            if (super.anInt23 >= 549 && super.anInt23 <= 583 && super.anInt24 >= 195 && super.anInt24 < 231) {
                sidebarRedraw = true;
                anInt907 = 0;
                aBoolean992 = true;
            }
            if (super.anInt23 >= 579 && super.anInt23 <= 609 && super.anInt24 >= 194 && super.anInt24 < 231) {
                sidebarRedraw = true;
                anInt907 = 1;
                aBoolean992 = true;
            }
            if (super.anInt23 >= 607 && super.anInt23 <= 637 && super.anInt24 >= 194 && super.anInt24 < 231) {
                sidebarRedraw = true;
                anInt907 = 2;
                aBoolean992 = true;
            }
            if (super.anInt23 >= 635 && super.anInt23 <= 679 && super.anInt24 >= 194 && super.anInt24 < 229) {
                sidebarRedraw = true;
                anInt907 = 3;
                aBoolean992 = true;
            }
            if (super.anInt23 >= 676 && super.anInt23 <= 706 && super.anInt24 >= 194 && super.anInt24 < 231) {
                sidebarRedraw = true;
                anInt907 = 4;
                aBoolean992 = true;
            }
            if (super.anInt23 >= 704 && super.anInt23 <= 734 && super.anInt24 >= 194 && super.anInt24 < 231) {
                sidebarRedraw = true;
                anInt907 = 5;
                aBoolean992 = true;
            }
            if (super.anInt23 >= 732 && super.anInt23 <= 766 && super.anInt24 >= 195 && super.anInt24 < 231) {
                sidebarRedraw = true;
                anInt907 = 6;
                aBoolean992 = true;
            }
            if (super.anInt23 >= 582 && super.anInt23 <= 612 && super.anInt24 >= 492 && super.anInt24 < 529) {
                sidebarRedraw = true;
                anInt907 = 8;
                aBoolean992 = true;
            }
            if (super.anInt23 >= 609 && super.anInt23 <= 639 && super.anInt24 >= 492 && super.anInt24 < 529) {
                sidebarRedraw = true;
                anInt907 = 9;
                aBoolean992 = true;
            }
            if (super.anInt23 >= 637 && super.anInt23 <= 681 && super.anInt24 >= 493 && super.anInt24 < 528) {
                sidebarRedraw = true;
                anInt907 = 10;
                aBoolean992 = true;
            }
            if (super.anInt23 >= 679 && super.anInt23 <= 709 && super.anInt24 >= 492 && super.anInt24 < 529) {
                sidebarRedraw = true;
                anInt907 = 11;
                aBoolean992 = true;
            }
            if (super.anInt23 >= 706 && super.anInt23 <= 736 && super.anInt24 >= 492 && super.anInt24 < 529) {
                sidebarRedraw = true;
                anInt907 = 12;
                aBoolean992 = true;
            }
        }
    }

    public void updatePlayerMasks(Buffer b, int i, int j) {
        for (int k = 0; k < anInt754; k++) {
            int l = anIntArray755[k];
            PlayerEntity p = aPlayerEntityArray751[l];
            int mask = b.g1();
            if ((mask & 0x80) == 128)
                mask += b.g1() << 8;
            updatePlayerMask(p, (byte) 2, l, b, mask);
        }

        if (i < 7 || i > 7)
            anInt684 = isaac.nextInt();
    }

    public void method67(byte byte0, Component class8) {
        int i = class8.anInt119;
        if (byte0 != 36)
            aBoolean640 = !aBoolean640;
        if (i >= 1 && i <= 100) {
            if (--i >= anInt638) {
                class8.aString149 = "";
                class8.anInt118 = 0;
                return;
            }
            class8.aString149 = aStringArray701[i];
            class8.anInt118 = 1;
            if (class8.aString166 == null)
                class8.anInt118 = 0;
            return;
        }
        if (i >= 101 && i <= 200) {
            if ((i -= 101) >= anInt638) {
                class8.aString149 = "";
                class8.anInt118 = 0;
                return;
            }
            if (anIntArray783[i] == 0)
                class8.aString149 = "@red@Offline";
            else if (anIntArray783[i] == anInt719)
                class8.aString149 = "@gre@World-" + (anIntArray783[i] - 9);
            else
                class8.aString149 = "@yel@World-" + (anIntArray783[i] - 9);
            class8.anInt118 = 1;
            if (class8.aString166 == null)
                class8.anInt118 = 0;
            return;
        }
        if (i == 203) {
            class8.anInt128 = anInt638 * 15 + 20;
            if (class8.anInt128 <= class8.anInt121)
                class8.anInt128 = class8.anInt121 + 1;
            return;
        }
        if (i >= 401 && i <= 500)
            if ((i -= 401) >= anInt910) {
                class8.aString149 = "";
                class8.anInt118 = 0;
                return;
            } else {
                class8.aString149 = StringUtils.method421(-580, StringUtils.fromBase37(true, aLongArray685[i]));
                return;
            }
        if (i == 503) {
            class8.anInt128 = anInt910 * 15 + 20;
            if (class8.anInt128 <= class8.anInt121)
                class8.anInt128 = class8.anInt121 + 1;
            return;
        }
        if (i == 327) {
            class8.anInt161 = 150;
            class8.anInt162 = (int) (Math.sin((double) anInt759 / 40D) * 256D) & 0x7ff;
            if (aBoolean660) {
                aBoolean660 = false;
                Model[] aclass35_sub2_sub1 = new Model[7];
                int j = 0;
                for (int k = 0; k < 7; k++) {
                    int l = anIntArray883[k];
                    if (l >= 0)
                        aclass35_sub2_sub1[j++] = IdkType.instances[l].method157();
                }

                Model class35_sub2_sub1 = new Model(false, j, aclass35_sub2_sub1);
                for (int i1 = 0; i1 < 5; i1++)
                    if (anIntArray789[i1] != 0) {
                        class35_sub2_sub1.method317(PlayerEntity.anIntArrayArray938[i1][0], PlayerEntity.anIntArrayArray938[i1][anIntArray789[i1]]);
                        if (i1 == 1)
                            class35_sub2_sub1.method317(PlayerEntity.anIntArray664[0], PlayerEntity.anIntArray664[anIntArray789[i1]]);
                    }

                class35_sub2_sub1.method310((byte) 3);
                class35_sub2_sub1.applyFrame(7, SeqType.aSeqTypeArray190[self.anInt1213].anIntArray192[0]);
                class35_sub2_sub1.method320(64, 850, -30, -50, -30, true);
                class8.aModel_156 = class35_sub2_sub1;
            }
            return;
        }
        if (i == 324) {
            if (aSprite_836 == null) {
                aSprite_836 = class8.aSprite_154;
                aSprite_837 = class8.aSprite_155;
            }
            if (aBoolean970) {
                class8.aSprite_154 = aSprite_837;
                return;
            } else {
                class8.aSprite_154 = aSprite_836;
                return;
            }
        }
        if (i == 325) {
            if (aSprite_836 == null) {
                aSprite_836 = class8.aSprite_154;
                aSprite_837 = class8.aSprite_155;
            }
            if (aBoolean970) {
                class8.aSprite_154 = aSprite_836;
                return;
            }
            class8.aSprite_154 = aSprite_837;
        }
    }

    public String getParameter(String s) {
        if (signlink.mainapp != null)
            return signlink.mainapp.getParameter(s);
        else
            return super.getParameter(s);
    }

    public boolean method68(Component class8, byte byte0) {
        if (byte0 == 3) {
            byte0 = 0;
        } else {
            for (int i = 1; i > 0; i++) ;
        }
        int j = class8.anInt119;
        if (j == 201) {
            aBoolean653 = true;
            aBoolean763 = false;
            aBoolean739 = true;
            aString887 = "";
            anInt975 = 1;
            aString695 = "Enter name of friend to add to list";
        }
        if (j == 202) {
            aBoolean653 = true;
            aBoolean763 = false;
            aBoolean739 = true;
            aString887 = "";
            anInt975 = 2;
            aString695 = "Enter name of friend to delete from list";
        }
        if (j >= 1 && j <= 200) {
            if (j >= 101)
                j -= 101;
            else
                j--;
            if (anIntArray783[j] > 0) {
                aBoolean653 = true;
                aBoolean763 = false;
                aBoolean739 = true;
                aString887 = "";
                anInt975 = 3;
                anInt641 = j;
                aString695 = "Enter message to send to " + aStringArray701[j];
            }
        }
        if (j == 501) {
            aBoolean653 = true;
            aBoolean763 = false;
            aBoolean739 = true;
            aString887 = "";
            anInt975 = 4;
            aString695 = "Enter name of player to add to list";
        }
        if (j == 502) {
            aBoolean653 = true;
            aBoolean763 = false;
            aBoolean739 = true;
            aString887 = "";
            anInt975 = 5;
            aString695 = "Enter name of player to delete from list";
        }
        if (j >= 300 && j <= 313) {
            int k = (j - 300) / 2;
            int j1 = j & 1;
            int i2 = anIntArray883[k];
            if (i2 != -1) {
                do {
                    if (j1 == 0 && --i2 < 0)
                        i2 = IdkType.count - 1;
                    if (j1 == 1 && ++i2 >= IdkType.count)
                        i2 = 0;
                } while (IdkType.instances[i2].type != k + (aBoolean970 ? 0 : 7));
                anIntArray883[k] = i2;
                aBoolean660 = true;
            }
        }
        if (j >= 314 && j <= 323) {
            int l = (j - 314) / 2;
            int k1 = j & 1;
            int j2 = anIntArray789[l];
            if (k1 == 0 && --j2 < 0)
                j2 = PlayerEntity.anIntArrayArray938[l].length - 1;
            if (k1 == 1 && ++j2 >= PlayerEntity.anIntArrayArray938[l].length)
                j2 = 0;
            anIntArray789[l] = j2;
            aBoolean660 = true;
        }
        if (j == 324 && !aBoolean970) {
            aBoolean970 = true;
            method42(1);
        }
        if (j == 325 && aBoolean970) {
            aBoolean970 = false;
            method42(1);
        }
        if (j == 326) {
            outBuffer.p1isaac(134);
            outBuffer.p1(aBoolean970 ? 0 : 1);
            for (int i1 = 0; i1 < 7; i1++)
                outBuffer.p1(anIntArray883[i1]);

            for (int l1 = 0; l1 < 5; l1++)
                outBuffer.p1(anIntArray789[l1]);

            return true;
        } else {
            return false;
        }
    }

    public void method7(byte byte0) {
        if (errorStarted || errorLoading || errorHost)
            return;
        anInt759++;
        if (byte0 != 3)
            aBoolean828 = !aBoolean828;
        if (!aBoolean734) {
            method55(true);
            return;
        } else {
            method60(-595);
            return;
        }
    }

    public void method69(int i) {
        if (i != 42788)
            method6();
        if (super.anInt22 == 1) {
            int j = super.anInt23 - 21 - 561;
            int k = super.anInt24 - 9 - 5;
            if (j >= 0 && k >= 0 && j < 146 && k < 151) {
                j -= 73;
                k -= 75;
                int l = Draw3D.anIntArray1271[anInt924];
                int i1 = Draw3D.anIntArray1272[anInt924];
                int j1 = k * l + j * i1 >> 11;
                int k1 = k * i1 - j * l >> 11;
                int l1 = self.x + j1 >> 7;
                int i2 = self.z - k1 >> 7;
                method73(i2, true, 0, true, 0, 0, 0, 0, self.pathTileZ[0], self.pathTileX[0], l1);
            }
        }
    }

    public URL getCodeBase() {
        if (signlink.mainapp != null)
            return signlink.mainapp.getCodeBase();
        try {
            if (super.aGameFrame__16 != null)
                return new URL("http://" + aString993 + ":" + (80 + nodeOffset + httpPortOffset));
        } catch (Exception _ex) {
        }
        return super.getCodeBase();
    }

    public boolean method70(int i, int j, int k, int l, int i1) {
        l = 92 / l;
        int j1 = k >> 14 & 0x7fff;
        int k1 = aMapSquare_741.method266(anInt722, j, i, k);
        if (k1 == -1)
            return false;
        int l1 = k1 & 0x1f;
        int i2 = k1 >> 6 & 3;
        if (l1 == 10 || l1 == 11 || l1 == 22) {
            LocType class39 = LocType.method428(j1);
            int j2;
            int k2;
            if (i2 == 0 || i2 == 2) {
                j2 = class39.anInt542;
                k2 = class39.anInt543;
            } else {
                j2 = class39.anInt543;
                k2 = class39.anInt542;
            }
            int l2 = class39.anInt566;
            if (i2 != 0)
                l2 = (l2 << i2 & 0xf) + (l2 >> 4 - i2);
            method73(i, true, 0, false, k2, j2, l2, 0, self.pathTileZ[0], self.pathTileX[0], j);
        } else {
            method73(i, true, l1 + 1, false, 0, 0, 0, i2, self.pathTileZ[0], self.pathTileX[0], j);
        }
        anInt816 = super.anInt23;
        anInt817 = super.anInt24;
        anInt819 = 2;
        anInt818 = 0;
        outBuffer.p1isaac(i1);
        outBuffer.p2(j + anInt855);
        outBuffer.p2(i + anInt856);
        outBuffer.p2(j1);
        return true;
    }

    public int method71(int i) {
        if (i != -31414)
            outBuffer.p1(236);
        return 0;
    }

    public boolean method72(int i, String s) {
        if (s == null)
            return false;
        for (int j = 0; j < anInt638; j++)
            if (s.equalsIgnoreCase(aStringArray701[j]))
                return true;

        if (i < 7 || i > 7)
            aBoolean828 = !aBoolean828;
        return s.equalsIgnoreCase(self.name);
    }

    public boolean method73(int i, boolean flag, int j, boolean flag1, int k, int l, int i1,
                            int j1, int k1, int l1, int i2) {
        byte byte0 = 104;
        byte byte1 = 104;
        for (int j2 = 0; j2 < byte0; j2++) {
            for (int k2 = 0; k2 < byte1; k2++) {
                anIntArrayArray859[j2][k2] = 0;
                anIntArrayArray911[j2][k2] = 0x5f5e0ff;
            }

        }

        int l2 = l1;
        int i3 = k1;
        anIntArrayArray859[l1][k1] = 99;
        anIntArrayArray911[l1][k1] = 0;
        int j3 = 0;
        int k3 = 0;
        anIntArray723[j3] = l1;
        aBoolean734 &= flag;
        anIntArray724[j3++] = k1;
        boolean flag2 = false;
        int l3 = anIntArray723.length;
        int[][] ai = aCollisionMapArray737[anInt722].anIntArrayArray43;
        while (k3 != j3) {
            l2 = anIntArray723[k3];
            i3 = anIntArray724[k3];
            k3 = (k3 + 1) % l3;
            if (l2 == i2 && i3 == i) {
                flag2 = true;
                break;
            }
            if (j != 0) {
                if ((j < 5 || j == 10) && aCollisionMapArray737[anInt722].method130(i3, j - 1, j1, i, i2, 7, l2)) {
                    flag2 = true;
                    break;
                }
                if (j < 10 && aCollisionMapArray737[anInt722].method131(i2, i3, (byte) -14, l2, j - 1, i, j1)) {
                    flag2 = true;
                    break;
                }
            }
            if (l != 0 && k != 0 && aCollisionMapArray737[anInt722].method132(i1, anInt809, l, i, k, i2, l2, i3)) {
                flag2 = true;
                break;
            }
            int j4 = anIntArrayArray911[l2][i3] + 1;
            if (l2 > 0 && anIntArrayArray859[l2 - 1][i3] == 0 && (ai[l2 - 1][i3] & 0x280108) == 0) {
                anIntArray723[j3] = l2 - 1;
                anIntArray724[j3] = i3;
                j3 = (j3 + 1) % l3;
                anIntArrayArray859[l2 - 1][i3] = 2;
                anIntArrayArray911[l2 - 1][i3] = j4;
            }
            if (l2 < byte0 - 1 && anIntArrayArray859[l2 + 1][i3] == 0 && (ai[l2 + 1][i3] & 0x280180) == 0) {
                anIntArray723[j3] = l2 + 1;
                anIntArray724[j3] = i3;
                j3 = (j3 + 1) % l3;
                anIntArrayArray859[l2 + 1][i3] = 8;
                anIntArrayArray911[l2 + 1][i3] = j4;
            }
            if (i3 > 0 && anIntArrayArray859[l2][i3 - 1] == 0 && (ai[l2][i3 - 1] & 0x280102) == 0) {
                anIntArray723[j3] = l2;
                anIntArray724[j3] = i3 - 1;
                j3 = (j3 + 1) % l3;
                anIntArrayArray859[l2][i3 - 1] = 1;
                anIntArrayArray911[l2][i3 - 1] = j4;
            }
            if (i3 < byte1 - 1 && anIntArrayArray859[l2][i3 + 1] == 0 && (ai[l2][i3 + 1] & 0x280120) == 0) {
                anIntArray723[j3] = l2;
                anIntArray724[j3] = i3 + 1;
                j3 = (j3 + 1) % l3;
                anIntArrayArray859[l2][i3 + 1] = 4;
                anIntArrayArray911[l2][i3 + 1] = j4;
            }
            if (l2 > 0 && i3 > 0 && anIntArrayArray859[l2 - 1][i3 - 1] == 0 && (ai[l2 - 1][i3 - 1] & 0x28010e) == 0 && (ai[l2 - 1][i3] & 0x280108) == 0 && (ai[l2][i3 - 1] & 0x280102) == 0) {
                anIntArray723[j3] = l2 - 1;
                anIntArray724[j3] = i3 - 1;
                j3 = (j3 + 1) % l3;
                anIntArrayArray859[l2 - 1][i3 - 1] = 3;
                anIntArrayArray911[l2 - 1][i3 - 1] = j4;
            }
            if (l2 < byte0 - 1 && i3 > 0 && anIntArrayArray859[l2 + 1][i3 - 1] == 0 && (ai[l2 + 1][i3 - 1] & 0x280183) == 0 && (ai[l2 + 1][i3] & 0x280180) == 0 && (ai[l2][i3 - 1] & 0x280102) == 0) {
                anIntArray723[j3] = l2 + 1;
                anIntArray724[j3] = i3 - 1;
                j3 = (j3 + 1) % l3;
                anIntArrayArray859[l2 + 1][i3 - 1] = 9;
                anIntArrayArray911[l2 + 1][i3 - 1] = j4;
            }
            if (l2 > 0 && i3 < byte1 - 1 && anIntArrayArray859[l2 - 1][i3 + 1] == 0 && (ai[l2 - 1][i3 + 1] & 0x280138) == 0 && (ai[l2 - 1][i3] & 0x280108) == 0 && (ai[l2][i3 + 1] & 0x280120) == 0) {
                anIntArray723[j3] = l2 - 1;
                anIntArray724[j3] = i3 + 1;
                j3 = (j3 + 1) % l3;
                anIntArrayArray859[l2 - 1][i3 + 1] = 6;
                anIntArrayArray911[l2 - 1][i3 + 1] = j4;
            }
            if (l2 < byte0 - 1 && i3 < byte1 - 1 && anIntArrayArray859[l2 + 1][i3 + 1] == 0 && (ai[l2 + 1][i3 + 1] & 0x2801e0) == 0 && (ai[l2 + 1][i3] & 0x280180) == 0 && (ai[l2][i3 + 1] & 0x280120) == 0) {
                anIntArray723[j3] = l2 + 1;
                anIntArray724[j3] = i3 + 1;
                j3 = (j3 + 1) % l3;
                anIntArrayArray859[l2 + 1][i3 + 1] = 12;
                anIntArrayArray911[l2 + 1][i3 + 1] = j4;
            }
        }
        if (!flag2) {
            if (flag1) {
                int k4 = 100;
                for (int i5 = 1; i5 < 2; i5++) {
                    for (int k5 = i2 - i5; k5 <= i2 + i5; k5++) {
                        for (int i6 = i - i5; i6 <= i + i5; i6++)
                            if (k5 >= 0 && i6 >= 0 && k5 < 104 && i6 < 104 && anIntArrayArray911[k5][i6] < k4) {
                                k4 = anIntArrayArray911[k5][i6];
                                l2 = k5;
                                i3 = i6;
                                flag2 = true;
                            }

                    }

                    if (flag2)
                        break;
                }

            }
            if (!flag2)
                return false;
        }
        k3 = 0;
        anIntArray723[k3] = l2;
        anIntArray724[k3++] = i3;
        int j5;
        for (int l4 = j5 = anIntArrayArray859[l2][i3]; l2 != l1 || i3 != k1; l4 = anIntArrayArray859[l2][i3]) {
            if (l4 != j5) {
                j5 = l4;
                anIntArray723[k3] = l2;
                anIntArray724[k3++] = i3;
            }
            if ((l4 & 2) != 0)
                l2++;
            else if ((l4 & 8) != 0)
                l2--;
            if ((l4 & 1) != 0)
                i3++;
            else if ((l4 & 4) != 0)
                i3--;
        }

        if (k3 > 0) {
            int i4 = k3;
            if (i4 > 25)
                i4 = 25;
            k3--;
            int l5 = anIntArray723[k3];
            int j6 = anIntArray724[k3];
            if (super.anIntArray25[5] == 1)
                outBuffer.p1isaac(230);
            else
                outBuffer.p1isaac(204);
            outBuffer.p1(i4 + i4 + 2);
            outBuffer.p2(l5 + anInt855);
            outBuffer.p2(j6 + anInt856);
            for (int k6 = 1; k6 < i4; k6++) {
                k3--;
                outBuffer.p1(anIntArray723[k3] - l5);
                outBuffer.p1(anIntArray724[k3] - j6);
            }

        }
        return true;
    }

    public void method74(boolean flag) {
        method50(true);
        aFrameBuffer_891.method234(-510);
        aClass35_Sub2_Sub2_Sub3_960.method368(0, anInt861, 0);
        char c = '\u0168';
        char c1 = '\310';
        if (anInt915 == 0) {
            int i = c1 / 2 - 80;
            b12.method371(i, c / 2, 0xffff00, "Welcome to the RuneScape-2 BETA test.", 26631, true);
            i += 15;
            i += 15;
            p11.method371(i, c / 2, 0xffffff, "Please note this test version of the game is provided for ", 26631, true);
            i += 15;
            p11.method371(i, c / 2, 0xffffff, "testing/preview purposes only. As such please bear in mind that:", 26631, true);
            i += 15;
            i += 10;
            p11.method371(i, c / 2, 0xffffff, "a) Everything you do/gain here will be forgotten when the beta ends.", 26631, true);
            i += 15;
            p11.method371(i, c / 2, 0xffffff, "b) No customer support is available for the beta.", 26631, true);
            i += 15;
            p11.method371(i, c / 2, 0xffffff, "c) The beta may be incomplete/buggy, we're still working on it.", 26631, true);
            i += 15;
            p11.method371(i, c / 2, 0xffffff, "d) The beta may be totally unavailable at times.", 26631, true);
            i += 15;
            int k = c / 2;
            int i1 = c1 / 2 + 65;
            aClass35_Sub2_Sub2_Sub3_961.method368(i1 - 20, anInt861, k - 73);
            b12.method371(i1 + 5, c / 2, 0xffffff, "Click here to login.", 26631, true);
        }
        if (anInt915 == 1 || anInt915 == 2) {
            int j = c1 / 2 - 50;
            if (aString973.length() > 0) {
                b12.method371(j - 15, c / 2, 0xffff00, aString973, 26631, true);
                b12.method371(j, c / 2, 0xffff00, aString974, 26631, true);
                j += 30;
            } else {
                b12.method371(j - 7, c / 2, 0xffff00, aString974, 26631, true);
                j += 30;
            }
            b12.method375(-886, true, c / 2 - 90, 0xffffff, j, "Username: " + aString743 + ((anInt871 == 0) & (anInt759 % 40 < 20) ? "@yel@|" : ""));
            j += 15;
            b12.method375(-886, true, c / 2 - 88, 0xffffff, j, "Password: " + StringUtils.method423((byte) 1, aString744) + ((anInt871 == 1) & (anInt759 % 40 < 20) ? "@yel@|" : ""));
            j += 15;
            if (anInt915 == 1)
                b12.method375(-886, true, c / 2 - 143, 0xffffff, j, "Confirm Password: " + StringUtils.method423((byte) 1, aString745) + ((anInt871 == 2) & (anInt759 % 40 < 20) ? "@yel@|" : ""));
            int l = c / 2 - 80;
            int j1 = c1 / 2 + 40;
            aClass35_Sub2_Sub2_Sub3_961.method368(j1 - 20, anInt861, l - 73);
            if (anInt915 == 1)
                b12.method371(j1 + 5, l, 0xffffff, "Create", 26631, true);
            else
                b12.method371(j1 + 5, l, 0xffffff, "Login", 26631, true);
            l = c / 2 + 80;
            aClass35_Sub2_Sub2_Sub3_961.method368(j1 - 20, anInt861, l - 73);
            b12.method371(j1 + 5, l, 0xffffff, "Cancel", 26631, true);
        }
        aFrameBuffer_891.method235(214, super.aGraphics13, 186, aByte930);
        if (flag)
            return;
        if (aBoolean681) {
            aBoolean681 = false;
            aFrameBuffer_889.method235(128, super.aGraphics13, 0, aByte930);
            aFrameBuffer_890.method235(214, super.aGraphics13, 386, aByte930);
            aFrameBuffer_894.method235(0, super.aGraphics13, 265, aByte930);
            aFrameBuffer_895.method235(574, super.aGraphics13, 265, aByte930);
            aFrameBuffer_896.method235(128, super.aGraphics13, 186, aByte930);
            aFrameBuffer_897.method235(574, super.aGraphics13, 186, aByte930);
        }
    }

    public void method75(String s, int i, int j, String s1) {
        if (anInt702 == -1)
            aBoolean653 = true;
        for (int k = 99; k > 0; k--) {
            anIntArray662[k] = anIntArray662[k - 1];
            aStringArray870[k] = aStringArray870[k - 1];
            aStringArray814[k] = aStringArray814[k - 1];
        }

        anIntArray662[0] = i;
        aStringArray870[0] = s1;
        aStringArray814[0] = s;
        if (j < 2 || j > 2)
            anInt676 = isaac.nextInt();
    }

    public void method76(int i) {
        int j = anInt668;
        int k = anInt669;
        int l = anInt670;
        int i1 = anInt671;
        int j1 = 0x5d5447;
        Draw2D.method333(j1, anInt807, i1, k, l, j);
        Draw2D.method333(0, anInt807, 16, k + 1, l - 2, j + 1);
        Draw2D.method334(0, k + 18, 0, l - 2, i1 - 19, j + 1);
        b12.method373("Choose Option", j + 3, j1, true, k + 14);
        int k1 = super.anInt20;
        int l1 = super.anInt21;
        if (anInt667 == 0) {
            k1 -= 8;
            l1 -= 11;
        }
        if (anInt667 == 1) {
            k1 -= 562;
            l1 -= 231;
        }
        for (int i2 = 0; i2 < anInt710; i2++) {
            int j2 = k + 31 + (anInt710 - 1 - i2) * 15;
            int k2 = 0xffffff;
            if (k1 > j && k1 < j + l && l1 > j2 - 13 && l1 < j2 + 3)
                k2 = 0xffff00;
            b12.method375(-886, true, j + 3, k2, j2, aStringArray720[i2]);
        }

        if (i == 9) ;
    }

    public void method77(int i) {
        try {
            anInt878 = -1;
            aLinkedList_652.method231();
            aLinkedList_943.method231();
            aLinkedList_657.method231();
            aLinkedList_863.method231();
            Draw3D.method340(43753);
            method57(anInt952);
            aMapSquare_741.method238(true);
            for (int j = 0; j < 4; j++)
                aCollisionMapArray737[j].method121((byte) 5);

            System.gc();
            Scene class3 = new Scene(levelRenderFlags, 104, 104, anIntArrayArrayArray725, 362);
            byte[] abyte0 = new byte[0x186a0];
            int k = aByteArrayArray963.length;
            Scene.aBoolean47 = MapSquare.aBoolean382;
            for (int l = 0; l < k; l++) {
                int i1 = anIntArray854[l] >> 8;
                int k1 = anIntArray854[l] & 0xff;
                if (i1 == 33 && k1 >= 71 && k1 <= 73)
                    Scene.aBoolean47 = false;
            }

            if (aBoolean663)
                aMapSquare_741.method239(anInt722, 0);
            else
                aMapSquare_741.method239(0, 0);
            for (int j1 = 0; j1 < k; j1++) {
                int l1 = (anIntArray854[j1] >> 8) * 64 - anInt855;
                int j2 = (anIntArray854[j1] & 0xff) * 64 - anInt856;
                byte[] abyte2 = aByteArrayArray963[j1];
                if (abyte2 != null) {
                    int i3 = (new Buffer(abyte2)).g4();
                    BZip2InputStream.method287(abyte0, i3, abyte2, abyte2.length - 4, 4);
                    class3.method134(j2, -519, (anInt699 - 6) * 8, (anInt700 - 6) * 8, abyte0, l1);
                } else if (anInt700 < 800)
                    class3.method133(695, j2, 64, l1, 64);
            }

            for (int i2 = 0; i2 < k; i2++) {
                byte[] abyte1 = aByteArrayArray880[i2];
                if (abyte1 != null) {
                    int k2 = (new Buffer(abyte1)).g4();
                    BZip2InputStream.method287(abyte0, k2, abyte1, abyte1.length - 4, 4);
                    int j3 = (anIntArray854[i2] >> 8) * 64 - anInt855;
                    int l3 = (anIntArray854[i2] & 0xff) * 64 - anInt856;
                    class3.method135(abyte0, (byte) 4, aMapSquare_741, aCollisionMapArray737, l3, j3, aLinkedList_943);
                }
            }

            class3.method137(aMapSquare_741, false, aCollisionMapArray737);
            aFrameBuffer_644.method234(-510);
            for (LocEntity class35_sub5 = (LocEntity) aLinkedList_943.method227(); class35_sub5 != null; class35_sub5 = (LocEntity) aLinkedList_943.method229(35239))
                if ((levelRenderFlags[1][class35_sub5.anInt1041][class35_sub5.anInt1042] & 2) == 2) {
                    class35_sub5.anInt1039--;
                    if (class35_sub5.anInt1039 < 0)
                        class35_sub5.method303();
                }

            for (int l2 = 0; l2 < 104; l2++) {
                for (int k3 = 0; k3 < 104; k3++)
                    method16(l2, k3);

            }

            for (SpawnedLoc class35_sub3 = (SpawnedLoc) aLinkedList_746.method227(); class35_sub3 != null; class35_sub3 = (SpawnedLoc) aLinkedList_746.method229(35239))
                method112(true, class35_sub3.anInt1020, class35_sub3.anInt1026, class35_sub3.anInt1023, class35_sub3.anInt1022, class35_sub3.anInt1021, class35_sub3.anInt1024, class35_sub3.anInt1025);

        } catch (Exception exception) {
        }
        LocType.aCache_568.method297();
        System.gc();
        if (i != 0) {
            return;
        } else {
            Draw3D.method341((byte) 3, 20);
            return;
        }
    }

    public void method78(boolean flag) {
        for (int i = 0; i < anInt965; i++) {
            NpcEntity class35_sub7_sub3_sub1 = aClass35_Sub7_Sub3_Sub1Array964[anIntArray966[i]];
            int j = 0x20000000 + (anIntArray966[i] << 14);
            if (class35_sub7_sub3_sub1 == null || !class35_sub7_sub3_sub1.method411(0))
                continue;
            int k = class35_sub7_sub3_sub1.x >> 7;
            int l = class35_sub7_sub3_sub1.z >> 7;
            if (k < 0 || k >= 104 || l < 0 || l >= 104)
                continue;
            if (class35_sub7_sub3_sub1.index == 1 && (class35_sub7_sub3_sub1.x & 0x7f) == 64 && (class35_sub7_sub3_sub1.z & 0x7f) == 64) {
                if (anIntArrayArray879[k][l] == anInt778)
                    continue;
                anIntArrayArray879[k][l] = anInt778;
            }
            aMapSquare_741.method249(null, method15(class35_sub7_sub3_sub1.x, class35_sub7_sub3_sub1.z, anInt722, (byte) 9), 5, class35_sub7_sub3_sub1.z, class35_sub7_sub3_sub1.anInt1210, class35_sub7_sub3_sub1.x, anInt722, class35_sub7_sub3_sub1.anInt1211, class35_sub7_sub3_sub1, (class35_sub7_sub3_sub1.index - 1) * 64 + 60, j);
        }

        if (!flag)
            packetOpcode = -1;
    }

    public void method79(int i, int j, int k, byte byte0, int l, int i1, int j1) {
        int k1 = 2048 - j & 0x7ff;
        int l1 = 2048 - j1 & 0x7ff;
        int i2 = 0;
        int j2 = 0;
        int k2 = l;
        if (byte0 != 9)
            return;
        if (k1 != 0) {
            int l2 = Model.anIntArray1129[k1];
            int j3 = Model.anIntArray1130[k1];
            int l3 = j2 * j3 - k2 * l2 >> 16;
            k2 = j2 * l2 + k2 * j3 >> 16;
            j2 = l3;
        }
        if (l1 != 0) {
            int i3 = Model.anIntArray1129[l1];
            int k3 = Model.anIntArray1130[l1];
            int i4 = k2 * i3 + i2 * k3 >> 16;
            k2 = k2 * k3 - i2 * i3 >> 16;
            i2 = i4;
        }
        anInt918 = i1 - i2;
        anInt919 = i - j2;
        anInt920 = k - k2;
        anInt921 = j;
        anInt922 = j1;
    }

    public void method80(int i) {
        if (anInt774 != 0)
            return;
        aStringArray720[0] = "Cancel";
        anIntArray848[0] = 1005;
        anInt710 = 1;
        if (super.anInt20 > 8 && super.anInt21 > 11 && super.anInt20 < 520 && super.anInt21 < 345)
            if (anInt962 != -1)
                method58(4, 0, 8, super.anInt20, Component.aComponentArray110[anInt962], super.anInt21, 11);
            else
                method19(0);
        if (anInt823 != anInt806)
            anInt806 = anInt823;
        anInt823 = 0;
        if (super.anInt20 > 562 && super.anInt21 > 231 && super.anInt20 < 752 && super.anInt21 < 492)
            if (anInt981 != -1)
                method58(4, 0, 562, super.anInt20, Component.aComponentArray110[anInt981], super.anInt21, 231);
            else if (tabComponentId[anInt907] != -1)
                method58(4, 0, 562, super.anInt20, Component.aComponentArray110[tabComponentId[anInt907]], super.anInt21, 231);
        if (anInt823 != anInt931) {
            sidebarRedraw = true;
            anInt931 = anInt823;
        }
        anInt823 = 0;
        if (super.anInt20 > 22 && super.anInt21 > 375 && super.anInt20 < 501 && super.anInt21 < 471 && anInt702 != -1)
            method58(4, 0, 22, super.anInt20, Component.aComponentArray110[anInt702], super.anInt21, 375);
        if (anInt702 != -1 && anInt823 != anInt782) {
            aBoolean653 = true;
            anInt782 = anInt823;
        }
        boolean flag = false;
        if (i != 0)
            packetOpcode = inBuffer.g1();
        while (!flag) {
            flag = true;
            for (int j = 0; j < anInt710 - 1; j++)
                if (anIntArray848[j] < 1000 && anIntArray848[j + 1] > 1000) {
                    String s = aStringArray720[j];
                    aStringArray720[j] = aStringArray720[j + 1];
                    aStringArray720[j + 1] = s;
                    int k = anIntArray848[j];
                    anIntArray848[j] = anIntArray848[j + 1];
                    anIntArray848[j + 1] = k;
                    k = anIntArray846[j];
                    anIntArray846[j] = anIntArray846[j + 1];
                    anIntArray846[j + 1] = k;
                    k = anIntArray847[j];
                    anIntArray847[j] = anIntArray847[j + 1];
                    anIntArray847[j + 1] = k;
                    k = anIntArray849[j];
                    anIntArray849[j] = anIntArray849[j + 1];
                    anIntArray849[j + 1] = k;
                    flag = false;
                }

        }
    }

    public void method81(boolean flag) {
        if (flag)
            return;
        for (int i = 0; i < anInt965; i++) {
            int j = anIntArray966[i];
            NpcEntity class35_sub7_sub3_sub1 = aClass35_Sub7_Sub3_Sub1Array964[j];
            if (class35_sub7_sub3_sub1 != null)
                method82(true, class35_sub7_sub3_sub1.aNpcType_1325.aByte578, class35_sub7_sub3_sub1);
        }

    }

    public void method82(boolean flag, int i, PathingEntity class35_sub7_sub3) {
        if (class35_sub7_sub3.x < 128 || class35_sub7_sub3.z < 128 || class35_sub7_sub3.x >= 13184 || class35_sub7_sub3.z >= 13184) {
            class35_sub7_sub3.anInt1235 = -1;
            class35_sub7_sub3.anInt1240 = -1;
            class35_sub7_sub3.anInt1249 = 0;
            class35_sub7_sub3.anInt1250 = 0;
            class35_sub7_sub3.x = class35_sub7_sub3.pathTileX[0] * 128 + class35_sub7_sub3.index * 64;
            class35_sub7_sub3.z = class35_sub7_sub3.pathTileZ[0] * 128 + class35_sub7_sub3.index * 64;
            class35_sub7_sub3.pathRemaining = 0;
        }
        if (class35_sub7_sub3 == self && (class35_sub7_sub3.x < 1536 || class35_sub7_sub3.z < 1536 || class35_sub7_sub3.x >= 11776 || class35_sub7_sub3.z >= 11776)) {
            class35_sub7_sub3.anInt1235 = -1;
            class35_sub7_sub3.anInt1240 = -1;
            class35_sub7_sub3.anInt1249 = 0;
            class35_sub7_sub3.anInt1250 = 0;
            class35_sub7_sub3.x = class35_sub7_sub3.pathTileX[0] * 128 + class35_sub7_sub3.index * 64;
            class35_sub7_sub3.z = class35_sub7_sub3.pathTileZ[0] * 128 + class35_sub7_sub3.index * 64;
            class35_sub7_sub3.pathRemaining = 0;
        }
        if (class35_sub7_sub3.anInt1249 > anInt759)
            method83(false, class35_sub7_sub3);
        else if (class35_sub7_sub3.anInt1250 >= anInt759)
            method84(class35_sub7_sub3, false);
        else
            method85(0, class35_sub7_sub3);
        method86(class35_sub7_sub3, 1);
        method87(true, class35_sub7_sub3);
        if (!flag)
            outBuffer.p1(119);
    }

    public void method83(boolean flag, PathingEntity class35_sub7_sub3) {
        int i = class35_sub7_sub3.anInt1249 - anInt759;
        int j = class35_sub7_sub3.anInt1245 * 128 + class35_sub7_sub3.index * 64;
        int k = class35_sub7_sub3.anInt1247 * 128 + class35_sub7_sub3.index * 64;
        if (flag)
            return;
        class35_sub7_sub3.x += (j - class35_sub7_sub3.x) / i;
        class35_sub7_sub3.z += (k - class35_sub7_sub3.z) / i;
        class35_sub7_sub3.anInt1259 = 0;
        if (class35_sub7_sub3.anInt1251 == 0)
            class35_sub7_sub3.anInt1254 = 1024;
        if (class35_sub7_sub3.anInt1251 == 1)
            class35_sub7_sub3.anInt1254 = 1536;
        if (class35_sub7_sub3.anInt1251 == 2)
            class35_sub7_sub3.anInt1254 = 0;
        if (class35_sub7_sub3.anInt1251 == 3)
            class35_sub7_sub3.anInt1254 = 512;
    }

    public void method84(PathingEntity class35_sub7_sub3, boolean flag) {
        if (class35_sub7_sub3.anInt1250 == anInt759 || class35_sub7_sub3.anInt1235 == -1 || class35_sub7_sub3.anInt1238 != 0 || class35_sub7_sub3.anInt1237 + 1 > SeqType.aSeqTypeArray190[class35_sub7_sub3.anInt1235].anIntArray194[class35_sub7_sub3.anInt1236]) {
            int i = class35_sub7_sub3.anInt1250 - class35_sub7_sub3.anInt1249;
            int j = anInt759 - class35_sub7_sub3.anInt1249;
            int k = class35_sub7_sub3.anInt1245 * 128 + class35_sub7_sub3.index * 64;
            int l = class35_sub7_sub3.anInt1247 * 128 + class35_sub7_sub3.index * 64;
            int i1 = class35_sub7_sub3.anInt1246 * 128 + class35_sub7_sub3.index * 64;
            int j1 = class35_sub7_sub3.anInt1248 * 128 + class35_sub7_sub3.index * 64;
            class35_sub7_sub3.x = (k * (i - j) + i1 * j) / i;
            class35_sub7_sub3.z = (l * (i - j) + j1 * j) / i;
        }
        class35_sub7_sub3.anInt1259 = 0;
        if (class35_sub7_sub3.anInt1251 == 0)
            class35_sub7_sub3.anInt1254 = 1024;
        if (class35_sub7_sub3.anInt1251 == 1)
            class35_sub7_sub3.anInt1254 = 1536;
        if (class35_sub7_sub3.anInt1251 == 2)
            class35_sub7_sub3.anInt1254 = 0;
        if (class35_sub7_sub3.anInt1251 == 3)
            class35_sub7_sub3.anInt1254 = 512;
        class35_sub7_sub3.anInt1210 = class35_sub7_sub3.anInt1254;
        if (!flag) ;
    }

    public void method85(int i, PathingEntity class35_sub7_sub3) {
        class35_sub7_sub3.anInt1232 = class35_sub7_sub3.anInt1213;
        if (class35_sub7_sub3.pathRemaining == 0) {
            class35_sub7_sub3.anInt1259 = 0;
            return;
        }
        if (class35_sub7_sub3.anInt1235 != -1 && class35_sub7_sub3.anInt1238 == 0) {
            SeqType class12 = SeqType.aSeqTypeArray190[class35_sub7_sub3.anInt1235];
            if (class12.anIntArray196 == null) {
                class35_sub7_sub3.anInt1259++;
                return;
            }
        }
        int j = class35_sub7_sub3.x;
        int k = class35_sub7_sub3.z;
        int l = class35_sub7_sub3.pathTileX[class35_sub7_sub3.pathRemaining - 1] * 128 + class35_sub7_sub3.index * 64;
        int i1 = class35_sub7_sub3.pathTileZ[class35_sub7_sub3.pathRemaining - 1] * 128 + class35_sub7_sub3.index * 64;
        if (l - j > 256 || l - j < -256 || i1 - k > 256 || i1 - k < -256) {
            class35_sub7_sub3.x = l;
            class35_sub7_sub3.z = i1;
            return;
        }
        if (j < l) {
            if (k < i1)
                class35_sub7_sub3.anInt1254 = 1280;
            else if (k > i1)
                class35_sub7_sub3.anInt1254 = 1792;
            else
                class35_sub7_sub3.anInt1254 = 1536;
        } else if (j > l) {
            if (k < i1)
                class35_sub7_sub3.anInt1254 = 768;
            else if (k > i1)
                class35_sub7_sub3.anInt1254 = 256;
            else
                class35_sub7_sub3.anInt1254 = 512;
        } else if (k < i1)
            class35_sub7_sub3.anInt1254 = 1024;
        else
            class35_sub7_sub3.anInt1254 = 0;
        int j1 = class35_sub7_sub3.anInt1254 - class35_sub7_sub3.anInt1210 & 0x7ff;
        if (j1 > 1024)
            j1 -= 2048;
        int k1 = class35_sub7_sub3.anInt1216;
        if (j1 >= -256 && j1 <= 256)
            k1 = class35_sub7_sub3.anInt1215;
        else if (j1 >= 256 && j1 < 768)
            k1 = class35_sub7_sub3.anInt1218;
        else if (j1 >= -768 && j1 <= -256)
            k1 = class35_sub7_sub3.anInt1217;
        if (k1 == -1)
            k1 = class35_sub7_sub3.anInt1215;
        class35_sub7_sub3.anInt1232 = k1;
        packetLength += i;
        int l1 = 4;
        if (class35_sub7_sub3.anInt1210 != class35_sub7_sub3.anInt1254 && class35_sub7_sub3.anInt1229 == -1)
            l1 = 2;
        if (class35_sub7_sub3.pathRemaining > 2)
            l1 = 6;
        if (class35_sub7_sub3.pathRemaining > 3)
            l1 = 8;
        if (class35_sub7_sub3.anInt1259 > 0 && class35_sub7_sub3.pathRemaining > 1) {
            l1 = 8;
            class35_sub7_sub3.anInt1259--;
        }
        if (class35_sub7_sub3.aBooleanArray1258[class35_sub7_sub3.pathRemaining - 1])
            l1 <<= 1;
        if (l1 >= 8 && class35_sub7_sub3.anInt1232 == class35_sub7_sub3.anInt1215 && class35_sub7_sub3.anInt1219 != -1)
            class35_sub7_sub3.anInt1232 = class35_sub7_sub3.anInt1219;
        if (j < l) {
            class35_sub7_sub3.x += l1;
            if (class35_sub7_sub3.x > l)
                class35_sub7_sub3.x = l;
        } else if (j > l) {
            class35_sub7_sub3.x -= l1;
            if (class35_sub7_sub3.x < l)
                class35_sub7_sub3.x = l;
        }
        if (k < i1) {
            class35_sub7_sub3.z += l1;
            if (class35_sub7_sub3.z > i1)
                class35_sub7_sub3.z = i1;
        } else if (k > i1) {
            class35_sub7_sub3.z -= l1;
            if (class35_sub7_sub3.z < i1)
                class35_sub7_sub3.z = i1;
        }
        if (class35_sub7_sub3.x == l && class35_sub7_sub3.z == i1)
            class35_sub7_sub3.pathRemaining--;
    }

    public void method86(PathingEntity class35_sub7_sub3, int i) {
        if (i < 1 || i > 1)
            return;
        if (class35_sub7_sub3.anInt1229 != -1 && class35_sub7_sub3.anInt1229 < 32768) {
            NpcEntity class35_sub7_sub3_sub1 = aClass35_Sub7_Sub3_Sub1Array964[class35_sub7_sub3.anInt1229];
            if (class35_sub7_sub3_sub1 != null) {
                int i1 = class35_sub7_sub3.x - class35_sub7_sub3_sub1.x;
                int k1 = class35_sub7_sub3.z - class35_sub7_sub3_sub1.z;
                if (i1 != 0 || k1 != 0)
                    class35_sub7_sub3.anInt1254 = (int) (Math.atan2(i1, k1) * 325.94900000000001D) & 0x7ff;
            }
        }
        if (class35_sub7_sub3.anInt1229 >= 32768) {
            int j = class35_sub7_sub3.anInt1229 - 32768;
            if (j == anInt686)
                j = anInt750;
            PlayerEntity class35_sub7_sub3_sub2 = aPlayerEntityArray751[j];
            if (class35_sub7_sub3_sub2 != null) {
                int l1 = class35_sub7_sub3.x - class35_sub7_sub3_sub2.x;
                int i2 = class35_sub7_sub3.z - class35_sub7_sub3_sub2.z;
                if (l1 != 0 || i2 != 0)
                    class35_sub7_sub3.anInt1254 = (int) (Math.atan2(l1, i2) * 325.94900000000001D) & 0x7ff;
            }
        }
        if ((class35_sub7_sub3.anInt1230 != 0 || class35_sub7_sub3.anInt1231 != 0) && (class35_sub7_sub3.pathRemaining == 0 || class35_sub7_sub3.anInt1259 > 0)) {
            int k = class35_sub7_sub3.x - (class35_sub7_sub3.anInt1230 - anInt855 - anInt855) * 64;
            int j1 = class35_sub7_sub3.z - (class35_sub7_sub3.anInt1231 - anInt856 - anInt856) * 64;
            if (k != 0 || j1 != 0)
                class35_sub7_sub3.anInt1254 = (int) (Math.atan2(k, j1) * 325.94900000000001D) & 0x7ff;
            class35_sub7_sub3.anInt1230 = 0;
            class35_sub7_sub3.anInt1231 = 0;
        }
        int l = class35_sub7_sub3.anInt1254 - class35_sub7_sub3.anInt1210 & 0x7ff;
        if (l != 0) {
            if (l < 32 || l > 2016)
                class35_sub7_sub3.anInt1210 = class35_sub7_sub3.anInt1254;
            else if (l > 1024)
                class35_sub7_sub3.anInt1210 -= 32;
            else
                class35_sub7_sub3.anInt1210 += 32;
            class35_sub7_sub3.anInt1210 &= 0x7ff;
            if (class35_sub7_sub3.anInt1232 == class35_sub7_sub3.anInt1213 && class35_sub7_sub3.anInt1210 != class35_sub7_sub3.anInt1254) {
                if (class35_sub7_sub3.anInt1214 != -1) {
                    class35_sub7_sub3.anInt1232 = class35_sub7_sub3.anInt1214;
                    return;
                }
                class35_sub7_sub3.anInt1232 = class35_sub7_sub3.anInt1215;
            }
        }
    }

    public void method87(boolean flag, PathingEntity class35_sub7_sub3) {
        aBoolean734 &= flag;
        class35_sub7_sub3.anInt1211 = 0;
        if (class35_sub7_sub3.anInt1232 != -1) {
            SeqType class12 = SeqType.aSeqTypeArray190[class35_sub7_sub3.anInt1232];
            class35_sub7_sub3.anInt1234++;
            if (class35_sub7_sub3.anInt1233 < class12.anInt191 && class35_sub7_sub3.anInt1234 > class12.anIntArray194[class35_sub7_sub3.anInt1233]) {
                class35_sub7_sub3.anInt1234 = 0;
                class35_sub7_sub3.anInt1233++;
            }
            if (class35_sub7_sub3.anInt1233 >= class12.anInt191) {
                class35_sub7_sub3.anInt1234 = 0;
                class35_sub7_sub3.anInt1233 = 0;
            }
        }
        if (class35_sub7_sub3.anInt1235 != -1 && class35_sub7_sub3.anInt1238 == 0) {
            SeqType class12_1 = SeqType.aSeqTypeArray190[class35_sub7_sub3.anInt1235];
            for (class35_sub7_sub3.anInt1237++; class35_sub7_sub3.anInt1236 < class12_1.anInt191 && class35_sub7_sub3.anInt1237 > class12_1.anIntArray194[class35_sub7_sub3.anInt1236]; class35_sub7_sub3.anInt1236++)
                class35_sub7_sub3.anInt1237 -= class12_1.anIntArray194[class35_sub7_sub3.anInt1236];

            if (class35_sub7_sub3.anInt1236 >= class12_1.anInt191) {
                class35_sub7_sub3.anInt1236 -= class12_1.anInt195;
                class35_sub7_sub3.anInt1239++;
                if (class35_sub7_sub3.anInt1239 >= class12_1.anInt201)
                    class35_sub7_sub3.anInt1235 = -1;
                if (class35_sub7_sub3.anInt1236 < 0 || class35_sub7_sub3.anInt1236 >= class12_1.anInt191)
                    class35_sub7_sub3.anInt1235 = -1;
            }
            class35_sub7_sub3.anInt1211 = class12_1.anInt197;
        }
        if (class35_sub7_sub3.anInt1238 > 0)
            class35_sub7_sub3.anInt1238--;
        if (class35_sub7_sub3.anInt1240 != -1 && anInt759 >= class35_sub7_sub3.anInt1243) {
            if (class35_sub7_sub3.anInt1241 < 0)
                class35_sub7_sub3.anInt1241 = 0;
            SeqType class12_2 = SpotAnimType.aSpotAnimTypeArray212[class35_sub7_sub3.anInt1240].aSeqType_215;
            for (class35_sub7_sub3.anInt1242++; class35_sub7_sub3.anInt1241 < class12_2.anInt191 && class35_sub7_sub3.anInt1242 > class12_2.anIntArray194[class35_sub7_sub3.anInt1241]; class35_sub7_sub3.anInt1241++)
                class35_sub7_sub3.anInt1242 -= class12_2.anIntArray194[class35_sub7_sub3.anInt1241];

            if (class35_sub7_sub3.anInt1241 >= class12_2.anInt191)
                class35_sub7_sub3.anInt1240 = -1;
        }
    }

    public void method88(int i) {
        if (i != 3073)
            method6();
        if (aBoolean681) {
            aBoolean681 = false;
            aFrameBuffer_982.method235(0, super.aGraphics13, 11, aByte930);
            aFrameBuffer_983.method235(0, super.aGraphics13, 375, aByte930);
            aFrameBuffer_984.method235(729, super.aGraphics13, 5, aByte930);
            aFrameBuffer_985.method235(752, super.aGraphics13, 231, aByte930);
            aFrameBuffer_986.method235(0, super.aGraphics13, 0, aByte930);
            aFrameBuffer_987.method235(561, super.aGraphics13, 0, aByte930);
            aFrameBuffer_988.method235(520, super.aGraphics13, 11, aByte930);
            aFrameBuffer_989.method235(520, super.aGraphics13, 231, aByte930);
            aFrameBuffer_990.method235(501, super.aGraphics13, 375, aByte930);
            aFrameBuffer_991.method235(0, super.aGraphics13, 345, aByte930);
            sidebarRedraw = true;
            aBoolean653 = true;
            aBoolean992 = true;
            aBoolean655 = true;
            if (anInt969 != 2) {
                aFrameBuffer_644.method235(8, super.aGraphics13, 11, aByte930);
                aFrameBuffer_643.method235(561, super.aGraphics13, 5, aByte930);
            }
        }
        if (anInt969 == 2)
            method45((byte) -95);
        if (aBoolean838 && anInt667 == 1)
            sidebarRedraw = true;
        if (anInt981 != -1) {
            boolean flag = method47(anInt981, true, anInt742);
            if (flag)
                sidebarRedraw = true;
        }
        if (anInt805 == 2)
            sidebarRedraw = true;
        if (anInt774 == 2)
            sidebarRedraw = true;
        if (sidebarRedraw) {
            method105((byte) 7);
            sidebarRedraw = false;
        }
        if (anInt702 == -1) {
            aComponent_885.anInt129 = anInt677 - anInt736 - 77;
            if (super.anInt20 > 453 && super.anInt20 < 565 && super.anInt21 > 350)
                method100(false, anInt677, super.anInt20 - 22, aComponent_885, 463, aByte656, 77, super.anInt21 - 375, 0);
            int j = anInt677 - 77 - aComponent_885.anInt129;
            if (j < 0)
                j = 0;
            if (j > anInt677 - 77)
                j = anInt677 - 77;
            if (anInt736 != j) {
                anInt736 = j;
                aBoolean653 = true;
            }
        }
        if (anInt702 != -1) {
            boolean flag1 = method47(anInt702, true, anInt742);
            if (flag1)
                aBoolean653 = true;
        }
        if (anInt805 == 3)
            aBoolean653 = true;
        if (anInt774 == 3)
            aBoolean653 = true;
        if (aBoolean653) {
            method120((byte) 7);
            aBoolean653 = false;
        }
        if (anInt969 == 2) {
            if (aBoolean663 && anInt925 == 0 && anInt759 - anInt637 > 25) {
                anInt637 = anInt759;
                anInt636 = 1 - anInt636;
                if (anInt636 == 0)
                    method102(true);
                else
                    aFrameBuffer_643.method235(561, super.aGraphics13, 5, aByte930);
            }
            if (!aBoolean663) {
                method102(true);
                aFrameBuffer_643.method235(561, super.aGraphics13, 5, aByte930);
            }
        }
        if (aBoolean992) {
            aBoolean992 = false;
            aFrameBuffer_941.method234(-510);
            aClass35_Sub2_Sub2_Sub3_946.method368(0, anInt861, 0);
            if (anInt981 == -1) {
                if (anInt907 == 0)
                    aClass35_Sub2_Sub2_Sub3_647.method368(30, anInt861, 29);
                if (anInt907 == 1)
                    aClass35_Sub2_Sub2_Sub3_648.method368(29, anInt861, 59);
                if (anInt907 == 2)
                    aClass35_Sub2_Sub2_Sub3_648.method368(29, anInt861, 87);
                if (anInt907 == 3)
                    aClass35_Sub2_Sub2_Sub3_649.method368(29, anInt861, 115);
                if (anInt907 == 4)
                    aClass35_Sub2_Sub2_Sub3_651.method368(29, anInt861, 156);
                if (anInt907 == 5)
                    aClass35_Sub2_Sub2_Sub3_651.method368(29, anInt861, 184);
                if (anInt907 == 6)
                    aClass35_Sub2_Sub2_Sub3_650.method368(30, anInt861, 212);
                aClass35_Sub2_Sub2_Sub3_872.method368(33, anInt861, 39);
            }
            aFrameBuffer_941.method235(520, super.aGraphics13, 165, aByte930);
            aFrameBuffer_940.method234(-510);
            aClass35_Sub2_Sub2_Sub3_945.method368(0, anInt861, 0);
            if (anInt981 == -1) {
                if (anInt907 == 7)
                    aClass35_Sub2_Sub2_Sub3_727.method368(0, anInt861, 49);
                if (anInt907 == 8)
                    aClass35_Sub2_Sub2_Sub3_728.method368(0, anInt861, 81);
                if (anInt907 == 9)
                    aClass35_Sub2_Sub2_Sub3_728.method368(0, anInt861, 108);
                if (anInt907 == 10)
                    aClass35_Sub2_Sub2_Sub3_729.method368(1, anInt861, 136);
                if (anInt907 == 11)
                    aClass35_Sub2_Sub2_Sub3_731.method368(0, anInt861, 178);
                if (anInt907 == 12)
                    aClass35_Sub2_Sub2_Sub3_731.method368(0, anInt861, 205);
                if (anInt907 == 13)
                    aClass35_Sub2_Sub2_Sub3_730.method368(0, anInt861, 233);
                aClass35_Sub2_Sub2_Sub3_873.method368(4, anInt861, 83);
            }
            aFrameBuffer_940.method235(501, super.aGraphics13, 492, aByte930);
            aFrameBuffer_644.method234(-510);
        }
        if (aBoolean655) {
            aBoolean655 = false;
            aFrameBuffer_939.method234(-510);
            aClass35_Sub2_Sub2_Sub3_944.method368(0, anInt861, 0);
            p12.method371(33, 57, 0xffffff, "Public chat", 26631, true);
            if (anInt976 == 0)
                p12.method371(46, 57, 65280, "On", 26631, true);
            if (anInt976 == 1)
                p12.method371(46, 57, 0xffff00, "Friends", 26631, true);
            if (anInt976 == 2)
                p12.method371(46, 57, 0xff0000, "Off", 26631, true);
            p12.method371(33, 186, 0xffffff, "Private chat", 26631, true);
            if (anInt762 == 0)
                p12.method371(46, 186, 65280, "On", 26631, true);
            if (anInt762 == 1)
                p12.method371(46, 186, 0xffff00, "Friends", 26631, true);
            if (anInt762 == 2)
                p12.method371(46, 186, 0xff0000, "Off", 26631, true);
            p12.method371(33, 326, 0xffffff, "Trade/duel", 26631, true);
            if (anInt821 == 0)
                p12.method371(46, 326, 65280, "On", 26631, true);
            if (anInt821 == 1)
                p12.method371(46, 326, 0xffff00, "Friends", 26631, true);
            if (anInt821 == 2)
                p12.method371(46, 326, 0xff0000, "Off", 26631, true);
            aFrameBuffer_939.method235(0, super.aGraphics13, 471, aByte930);
            aFrameBuffer_644.method234(-510);
        }
        anInt742 = 0;
    }

    public String method89(byte byte0) {
        if (byte0 == 2)
            byte0 = 0;
        else
            outBuffer.p1(144);
        if (signlink.mainapp != null)
            return signlink.mainapp.getDocumentBase().getHost().toLowerCase();
        if (super.aGameFrame__16 != null)
            return "runescape.com";
        else
            return super.getDocumentBase().getHost().toLowerCase();
    }

    public void method90(int i, Buffer class35_sub2_sub3, int j) {
        if (i < 2 || i > 2)
            packetOpcode = -1;
        do {
            if (class35_sub2_sub3.bitOffset + 21 >= j * 8)
                break;
            int k = class35_sub2_sub3.gBit(13);
            if (k == 8191)
                break;
            if (aClass35_Sub7_Sub3_Sub1Array964[k] == null)
                aClass35_Sub7_Sub3_Sub1Array964[k] = new NpcEntity();
            NpcEntity class35_sub7_sub3_sub1 = aClass35_Sub7_Sub3_Sub1Array964[k];
            anIntArray966[anInt965++] = k;
            class35_sub7_sub3_sub1.anInt1252 = anInt759;
            class35_sub7_sub3_sub1.aNpcType_1325 = NpcType.method434(class35_sub2_sub3.gBit(11));
            class35_sub7_sub3_sub1.index = class35_sub7_sub3_sub1.aNpcType_1325.aByte578;
            class35_sub7_sub3_sub1.anInt1215 = class35_sub7_sub3_sub1.aNpcType_1325.anInt582;
            class35_sub7_sub3_sub1.anInt1216 = class35_sub7_sub3_sub1.aNpcType_1325.anInt583;
            class35_sub7_sub3_sub1.anInt1217 = class35_sub7_sub3_sub1.aNpcType_1325.anInt584;
            class35_sub7_sub3_sub1.anInt1218 = class35_sub7_sub3_sub1.aNpcType_1325.anInt585;
            class35_sub7_sub3_sub1.anInt1213 = class35_sub7_sub3_sub1.aNpcType_1325.anInt581;
            int l = class35_sub2_sub3.gBit(5);
            if (l > 15)
                l -= 32;
            int i1 = class35_sub2_sub3.gBit(5);
            if (i1 > 15)
                i1 -= 32;
            class35_sub7_sub3_sub1.method409((byte) 28, self.pathTileX[0] + l, self.pathTileZ[0] + i1);
            int j1 = class35_sub2_sub3.gBit(1);
            if (j1 == 1)
                anIntArray755[anInt754++] = k;
        } while (true);
        class35_sub2_sub3.accessBytes();
    }

    public static boolean startServer = true;
    public static int httpPortOffset = 0;

    public static void main(String[] args) {
        try {
            signlink.startpriv(InetAddress.getLocalHost());
            client client1 = new client();
            if (args.length > 0)
                client1.anInt719 = Integer.parseInt(args[0]);
            if (args.length > 1)
                client1.nodeOffset = Integer.parseInt(args[1]);
            if (args.length > 2 && args[2].equalsIgnoreCase("lowmem"))
                method94(26953);
            else
                method115(-229);

            if (startServer) {
                httpPortOffset = 1000 + (int)(Math.random() * 30000);
                Server.httpPort = httpPortOffset + 80;
                Server.main(new String[] { "client" });
            }

            client1.method1(0, 789, 532);
            return;
        } catch (Exception exception) {
            return;
        }
    }

    public void method91(int i, int j, int k, NpcType class40, int l) {
        if (anInt710 >= 400)
            return;
        String s = class40.aString576;
        while (l >= 0)
            aLinkedListArrayArrayArray665 = null;
        if (class40.anInt594 != 0)
            s = s + method62(class40.anInt594, (byte) -102, self.combatLevel) + " (level-" + class40.anInt594 + ")";
        if (anInt712 == 1) {
            aStringArray720[anInt710] = "Use " + aString716 + " with @yel@" + s;
            anIntArray848[anInt710] = 985;
            anIntArray849[anInt710] = j;
            anIntArray846[anInt710] = k;
            anIntArray847[anInt710] = i;
            anInt710++;
            return;
        }
        if (anInt706 == 1) {
            if ((anInt708 & 2) == 2) {
                aStringArray720[anInt710] = aString709 + " @yel@" + s;
                anIntArray848[anInt710] = 946;
                anIntArray849[anInt710] = j;
                anIntArray846[anInt710] = k;
                anIntArray847[anInt710] = i;
                anInt710++;
                return;
            }
        } else {
            if (class40.aStringArray589 != null) {
                for (int i1 = 4; i1 >= 0; i1--)
                    if (class40.aStringArray589[i1] != null) {
                        aStringArray720[anInt710] = class40.aStringArray589[i1] + " @yel@" + s;
                        if (i1 == 0)
                            anIntArray848[anInt710] = 490;
                        if (i1 == 1)
                            anIntArray848[anInt710] = 914;
                        if (i1 == 2)
                            anIntArray848[anInt710] = 75;
                        if (i1 == 3)
                            anIntArray848[anInt710] = 486;
                        if (i1 == 4)
                            anIntArray848[anInt710] = 772;
                        anIntArray849[anInt710] = j;
                        anIntArray846[anInt710] = k;
                        anIntArray847[anInt710] = i;
                        anInt710++;
                    }

            }
            aStringArray720[anInt710] = "Examine @yel@" + s;
            anIntArray848[anInt710] = 1318;
            anIntArray849[anInt710] = j;
            anIntArray846[anInt710] = k;
            anIntArray847[anInt710] = i;
            anInt710++;
        }
    }

    public void method92(int i) {
        while (i >= 0)
            anInt839 = isaac.nextInt();
        for (ProjectileEntity class35_sub7_sub1 = (ProjectileEntity) aLinkedList_863.method227(); class35_sub7_sub1 != null; class35_sub7_sub1 = (ProjectileEntity) aLinkedList_863.method229(35239))
            if (class35_sub7_sub1.anInt1174 != anInt722 || anInt759 > class35_sub7_sub1.anInt1180)
                class35_sub7_sub1.method303();
            else if (anInt759 >= class35_sub7_sub1.anInt1179) {
                if (class35_sub7_sub1.anInt1183 > 0) {
                    NpcEntity class35_sub7_sub3_sub1 = aClass35_Sub7_Sub3_Sub1Array964[class35_sub7_sub1.anInt1183 - 1];
                    if (class35_sub7_sub3_sub1 != null)
                        class35_sub7_sub1.method406(method15(class35_sub7_sub3_sub1.x, class35_sub7_sub3_sub1.z, class35_sub7_sub1.anInt1174, (byte) 9) - class35_sub7_sub1.anInt1178, class35_sub7_sub3_sub1.z, anInt759, class35_sub7_sub3_sub1.x, aBoolean908);
                }
                if (class35_sub7_sub1.anInt1183 < 0) {
                    int j = -class35_sub7_sub1.anInt1183 - 1;
                    PlayerEntity class35_sub7_sub3_sub2;
                    if (j == anInt686)
                        class35_sub7_sub3_sub2 = self;
                    else
                        class35_sub7_sub3_sub2 = aPlayerEntityArray751[j];
                    if (class35_sub7_sub3_sub2 != null)
                        class35_sub7_sub1.method406(method15(class35_sub7_sub3_sub2.x, class35_sub7_sub3_sub2.z, class35_sub7_sub1.anInt1174, (byte) 9) - class35_sub7_sub1.anInt1178, class35_sub7_sub3_sub2.z, anInt759, class35_sub7_sub3_sub2.x, aBoolean908);
                }
                class35_sub7_sub1.method407(-877, anInt742);
                aMapSquare_741.method249(null, (int) class35_sub7_sub1.aDouble1187, 5, (int) class35_sub7_sub1.aDouble1186, class35_sub7_sub1.anInt1193, (int) class35_sub7_sub1.aDouble1185, anInt722, 0, class35_sub7_sub1, 60, -1);
            }

    }

    public void method93(int i, int j, Buffer class35_sub2_sub3) {
        for (int k = 0; k < anInt754; k++) {
            int l = anIntArray755[k];
            NpcEntity class35_sub7_sub3_sub1 = aClass35_Sub7_Sub3_Sub1Array964[l];
            int i1 = class35_sub2_sub3.g1();
            if ((i1 & 2) == 2) {
                int j1 = class35_sub2_sub3.g2();
                if (j1 == 65535)
                    j1 = -1;
                if (j1 == class35_sub7_sub3_sub1.anInt1235)
                    class35_sub7_sub3_sub1.anInt1239 = 0;
                int l1 = class35_sub2_sub3.g1();
                if (j1 == -1 || class35_sub7_sub3_sub1.anInt1235 == -1 || SeqType.aSeqTypeArray190[j1].anInt198 > SeqType.aSeqTypeArray190[class35_sub7_sub3_sub1.anInt1235].anInt198 || SeqType.aSeqTypeArray190[class35_sub7_sub3_sub1.anInt1235].anInt198 == 0) {
                    class35_sub7_sub3_sub1.anInt1235 = j1;
                    class35_sub7_sub3_sub1.anInt1236 = 0;
                    class35_sub7_sub3_sub1.anInt1237 = 0;
                    class35_sub7_sub3_sub1.anInt1238 = l1;
                    class35_sub7_sub3_sub1.anInt1239 = 0;
                }
            }
            if ((i1 & 4) == 4) {
                class35_sub7_sub3_sub1.anInt1229 = class35_sub2_sub3.g2();
                if (class35_sub7_sub3_sub1.anInt1229 == 65535)
                    class35_sub7_sub3_sub1.anInt1229 = -1;
            }
            if ((i1 & 8) == 8) {
                class35_sub7_sub3_sub1.aString1220 = class35_sub2_sub3.gstr();
                class35_sub7_sub3_sub1.anInt1221 = 100;
            }
            if ((i1 & 0x10) == 16) {
                class35_sub7_sub3_sub1.anInt1224 = class35_sub2_sub3.g1();
                class35_sub7_sub3_sub1.anInt1225 = class35_sub2_sub3.g1();
                class35_sub7_sub3_sub1.anInt1226 = anInt759 + 400;
                class35_sub7_sub3_sub1.anInt1227 = class35_sub2_sub3.g1();
                class35_sub7_sub3_sub1.anInt1228 = class35_sub2_sub3.g1();
            }
            if ((i1 & 0x20) == 32) {
                class35_sub7_sub3_sub1.aNpcType_1325 = NpcType.method434(class35_sub2_sub3.g2());
                class35_sub7_sub3_sub1.anInt1215 = class35_sub7_sub3_sub1.aNpcType_1325.anInt582;
                class35_sub7_sub3_sub1.anInt1216 = class35_sub7_sub3_sub1.aNpcType_1325.anInt583;
                class35_sub7_sub3_sub1.anInt1217 = class35_sub7_sub3_sub1.aNpcType_1325.anInt584;
                class35_sub7_sub3_sub1.anInt1218 = class35_sub7_sub3_sub1.aNpcType_1325.anInt585;
                class35_sub7_sub3_sub1.anInt1213 = class35_sub7_sub3_sub1.aNpcType_1325.anInt581;
            }
            if ((i1 & 0x40) == 64) {
                class35_sub7_sub3_sub1.anInt1240 = class35_sub2_sub3.g2();
                int k1 = class35_sub2_sub3.g4();
                class35_sub7_sub3_sub1.anInt1244 = k1 >> 16;
                class35_sub7_sub3_sub1.anInt1243 = anInt759 + (k1 & 0xffff);
                class35_sub7_sub3_sub1.anInt1241 = 0;
                class35_sub7_sub3_sub1.anInt1242 = 0;
                if (class35_sub7_sub3_sub1.anInt1243 > anInt759)
                    class35_sub7_sub3_sub1.anInt1241 = -1;
                if (class35_sub7_sub3_sub1.anInt1240 == 65535)
                    class35_sub7_sub3_sub1.anInt1240 = -1;
            }
            if ((i1 & 0x80) == 128) {
                class35_sub7_sub3_sub1.anInt1230 = class35_sub2_sub3.g2();
                class35_sub7_sub3_sub1.anInt1231 = class35_sub2_sub3.g2();
            }
        }

        if (i <= 0)
            anInt676 = -106;
    }

    public static void method94(int i) {
        MapSquare.aBoolean382 = true;
        Draw3D.aBoolean1262 = true;
        aBoolean663 = true;
        if (i != 26953) {
            return;
        } else {
            Scene.aBoolean47 = true;
            return;
        }
    }

    public void method95(int i) {
        for (int j = -1; j < anInt752; j++) {
            PlayerEntity class35_sub7_sub3_sub2;
            int k;
            if (j == -1) {
                class35_sub7_sub3_sub2 = self;
                k = anInt750 << 14;
            } else {
                class35_sub7_sub3_sub2 = aPlayerEntityArray751[anIntArray753[j]];
                k = anIntArray753[j] << 14;
            }
            if (class35_sub7_sub3_sub2 == null || !class35_sub7_sub3_sub2.method411(0))
                continue;
            class35_sub7_sub3_sub2.aBoolean1347 = (aBoolean663 && anInt752 > 50 || anInt752 > 200) && j != -1 && class35_sub7_sub3_sub2.anInt1232 == class35_sub7_sub3_sub2.anInt1213;
            int l = class35_sub7_sub3_sub2.x >> 7;
            int i1 = class35_sub7_sub3_sub2.z >> 7;
            if (l < 0 || l >= 104 || i1 < 0 || i1 >= 104)
                continue;
            if (class35_sub7_sub3_sub2.aModel_1342 != null && anInt759 >= class35_sub7_sub3_sub2.anInt1337 && anInt759 < class35_sub7_sub3_sub2.anInt1338) {
                class35_sub7_sub3_sub2.aBoolean1347 = false;
                class35_sub7_sub3_sub2.plane = method15(class35_sub7_sub3_sub2.x, class35_sub7_sub3_sub2.z, anInt722, (byte) 9);
                aMapSquare_741.method250(60, class35_sub7_sub3_sub2.anInt1344, null, class35_sub7_sub3_sub2.anInt1343, class35_sub7_sub3_sub2.anInt1210, class35_sub7_sub3_sub2.x, class35_sub7_sub3_sub2.z, aByte705, k, class35_sub7_sub3_sub2.plane, class35_sub7_sub3_sub2, class35_sub7_sub3_sub2.anInt1345, class35_sub7_sub3_sub2.anInt1346, anInt722);
                continue;
            }
            if ((class35_sub7_sub3_sub2.x & 0x7f) == 64 && (class35_sub7_sub3_sub2.z & 0x7f) == 64) {
                if (anIntArrayArray879[l][i1] == anInt778)
                    continue;
                anIntArrayArray879[l][i1] = anInt778;
            }
            class35_sub7_sub3_sub2.plane = method15(class35_sub7_sub3_sub2.x, class35_sub7_sub3_sub2.z, anInt722, (byte) 9);
            aMapSquare_741.method249(null, class35_sub7_sub3_sub2.plane, 5, class35_sub7_sub3_sub2.z, class35_sub7_sub3_sub2.anInt1210, class35_sub7_sub3_sub2.x, anInt722, class35_sub7_sub3_sub2.anInt1211, class35_sub7_sub3_sub2, 60, k);
        }

        if (i < 7 || i > 7)
            anInt684 = isaac.nextInt();
    }

    public void method8(boolean flag) {
        signlink.reporterror = false;
        try {
            if (stream != null)
                stream.method150();
        } catch (Exception _ex) {
        }
        stream = null;
        signlink.midi = "null";
        outBuffer = null;
        loginBuffer = null;
        inBuffer = null;
        anIntArray854 = null;
        aByteArrayArray963 = null;
        aByteArrayArray880 = null;
        anIntArrayArrayArray725 = null;
        levelRenderFlags = null;
        aMapSquare_741 = null;
        aCollisionMapArray737 = null;
        anIntArrayArray859 = null;
        anIntArrayArray911 = null;
        anIntArray723 = null;
        anIntArray724 = null;
        aByteArray850 = null;
        aFrameBuffer_642 = null;
        aFrameBuffer_643 = null;
        aFrameBuffer_644 = null;
        aFrameBuffer_645 = null;
        aFrameBuffer_939 = null;
        aFrameBuffer_940 = null;
        aFrameBuffer_941 = null;
        aFrameBuffer_982 = null;
        aFrameBuffer_983 = null;
        aFrameBuffer_984 = null;
        aFrameBuffer_985 = null;
        aFrameBuffer_986 = null;
        aFrameBuffer_987 = null;
        aFrameBuffer_988 = null;
        aFrameBuffer_989 = null;
        aFrameBuffer_990 = null;
        aFrameBuffer_991 = null;
        if (flag)
            anInt861 = isaac.nextInt();
        aClass35_Sub2_Sub2_Sub3_691 = null;
        aClass35_Sub2_Sub2_Sub3_692 = null;
        aClass35_Sub2_Sub2_Sub3_693 = null;
        aClass35_Sub2_Sub2_Sub3_944 = null;
        aClass35_Sub2_Sub2_Sub3_945 = null;
        aClass35_Sub2_Sub2_Sub3_946 = null;
        aClass35_Sub2_Sub2_Sub3_872 = null;
        aClass35_Sub2_Sub2_Sub3_873 = null;
        aClass35_Sub2_Sub2_Sub3_647 = null;
        aClass35_Sub2_Sub2_Sub3_648 = null;
        aClass35_Sub2_Sub2_Sub3_649 = null;
        aClass35_Sub2_Sub2_Sub3_650 = null;
        aClass35_Sub2_Sub2_Sub3_651 = null;
        aClass35_Sub2_Sub2_Sub3_727 = null;
        aClass35_Sub2_Sub2_Sub3_728 = null;
        aClass35_Sub2_Sub2_Sub3_729 = null;
        aClass35_Sub2_Sub2_Sub3_730 = null;
        aClass35_Sub2_Sub2_Sub3_731 = null;
        aSprite_898 = null;
        aSpriteArray980 = null;
        aSpriteArray843 = null;
        aSpriteArray958 = null;
        aSprite_824 = null;
        aSprite_825 = null;
        aSprite_826 = null;
        aSprite_827 = null;
        aClass35_Sub2_Sub2_Sub3Array718 = null;
        aSpriteArray884 = null;
        anIntArrayArray879 = null;
        aPlayerEntityArray751 = null;
        anIntArray753 = null;
        anIntArray755 = null;
        aClass35_Sub2_Sub3Array756 = null;
        anIntArray834 = null;
        aClass35_Sub7_Sub3_Sub1Array964 = null;
        anIntArray966 = null;
        aLinkedListArrayArrayArray665 = null;
        aLinkedList_746 = null;
        aLinkedList_652 = null;
        aLinkedList_863 = null;
        aLinkedList_657 = null;
        aLinkedList_943 = null;
        anIntArray846 = null;
        anIntArray847 = null;
        anIntArray848 = null;
        anIntArray849 = null;
        aStringArray720 = null;
        anIntArray822 = null;
        anIntArray768 = null;
        anIntArray769 = null;
        aSpriteArray877 = null;
        aSprite_954 = null;
        aStringArray701 = null;
        aLongArray971 = null;
        anIntArray783 = null;
        aFrameBuffer_892 = null;
        aFrameBuffer_893 = null;
        aFrameBuffer_889 = null;
        aFrameBuffer_890 = null;
        aFrameBuffer_891 = null;
        aFrameBuffer_894 = null;
        aFrameBuffer_895 = null;
        aFrameBuffer_896 = null;
        aFrameBuffer_897 = null;
        method118(-43634);
        LocType.method427(300);
        NpcType.method433(300);
        ObjType.method439(300);
        FloType.aFloTypeArray71 = null;
        IdkType.instances = null;
        Component.aComponentArray110 = null;
        DeadClass.aDeadClassArray174 = null;
        SeqType.aSeqTypeArray190 = null;
        SpotAnimType.aSpotAnimTypeArray212 = null;
        SpotAnimType.aCache_219 = null;
        VarpType.aVarpTypeArray247 = null;
        super.aFrameBuffer_14 = null;
        PlayerEntity.aCache_1348 = null;
        Draw3D.method337(300);
        MapSquare.method237(300);
        Model.method305(300);
        SeqBase.aSeqBaseArray169 = null;
        SeqFrame.aSeqFrameArray180 = null;
        System.gc();
    }

    public void method96(int i, boolean flag, int j, int k, int l, int i1) {
        aClass35_Sub2_Sub2_Sub3_978.method368(i, anInt861, j);
        aClass35_Sub2_Sub2_Sub3_979.method368((i + i1) - 16, anInt861, j);
        Draw2D.method333(anInt881, anInt807, i1 - 32, i + 16, 16, j);
        int j1 = ((i1 - 32) * i1) / k;
        if (j1 < 8)
            j1 = 8;
        int k1 = ((i1 - 32 - j1) * l) / (k - i1);
        Draw2D.method333(anInt902, anInt807, j1, i + 16 + k1, 16, j);
        Draw2D.method336(31405, anInt876, i + 16 + k1, j, j1);
        Draw2D.method336(31405, anInt876, i + 16 + k1, j + 1, j1);
        Draw2D.method335(16, false, j, i + 16 + k1, anInt876);
        if (flag)
            method6();
        Draw2D.method335(16, false, j, i + 17 + k1, anInt876);
        Draw2D.method336(31405, anInt844, i + 16 + k1, j + 15, j1);
        Draw2D.method336(31405, anInt844, i + 17 + k1, j + 14, j1 - 1);
        Draw2D.method335(16, false, j, i + 15 + k1 + j1, anInt844);
        Draw2D.method335(15, false, j + 1, i + 14 + k1 + j1, anInt844);
    }

    public void method97(byte byte0, IndexedSprite class35_sub2_sub2_sub3) {
        int i = 256;
        for (int j = 0; j < anIntArray956.length; j++)
            anIntArray956[j] = 0;

        for (int k = 0; k < 5000; k++) {
            int l = (int) (Math.random() * 128D * (double) i);
            anIntArray956[l] = (int) (Math.random() * 256D);
        }

        if (byte0 != 57) {
            for (int i1 = 1; i1 > 0; i1++) ;
        }
        for (int j1 = 0; j1 < 20; j1++) {
            for (int k1 = 1; k1 < i - 1; k1++) {
                for (int i2 = 1; i2 < 127; i2++) {
                    int k2 = i2 + (k1 << 7);
                    anIntArray957[k2] = (anIntArray956[k2 - 1] + anIntArray956[k2 + 1] + anIntArray956[k2 - 128] + anIntArray956[k2 + 128]) / 4;
                }

            }

            int[] ai = anIntArray956;
            anIntArray956 = anIntArray957;
            anIntArray957 = ai;
        }

        if (class35_sub2_sub2_sub3 != null) {
            int l1 = 0;
            for (int j2 = 0; j2 < class35_sub2_sub2_sub3.anInt1307; j2++) {
                for (int l2 = 0; l2 < class35_sub2_sub2_sub3.anInt1306; l2++)
                    if (class35_sub2_sub2_sub3.aByteArray1304[l1++] != 0) {
                        int i3 = l2 + 16 + class35_sub2_sub2_sub3.anInt1308;
                        int j3 = j2 + 16 + class35_sub2_sub2_sub3.anInt1309;
                        int k3 = i3 + (j3 << 7);
                        anIntArray956[k3] = 0;
                    }

            }

        }
    }

    public void method6() {
        if (signlink.sunjava)
            super.anInt8 = 5;
        signlink.midi = "scape_main";
        if (aBoolean788) {
            errorStarted = true;
            return;
        }
        aBoolean788 = true;
        boolean flag = false;
        String s = method89((byte) 2);
        if (s.endsWith("jagex.com"))
            flag = true;
        if (s.endsWith("runescape.com"))
            flag = true;
        if (s.endsWith("192.168.1.252"))
            flag = true;
        if (s.endsWith("192.168.1.2"))
            flag = true;
        if (s.endsWith("69.1.68.43"))
            flag = true;
        if (s.endsWith("127.0.0.1"))
            flag = true;
        if (!flag) {
            errorHost = true;
            return;
        }
        try {
            int i = 5;
            for (archiveChecksums[7] = 0; archiveChecksums[7] == 0; ) {
                showProgress((byte) -75, 10, "Connecting to fileserver");
                try {
                    DataInputStream datainputstream = method104("crc" + (int) (Math.random() * 99999999D));
                    Buffer class35_sub2_sub3 = new Buffer(new byte[32]);
                    datainputstream.readFully(class35_sub2_sub3.data, 0, 32);
                    for (int k = 0; k < 8; k++)
                        archiveChecksums[k] = class35_sub2_sub3.g4();

                    datainputstream.close();
                } catch (IOException _ex) {
                    for (int j = i; j > 0; j--) {
                        showProgress((byte) -75, 10, "Error loading - Will retry in " + j + " secs.");
                        try {
                            Thread.sleep(1000L);
                        } catch (Exception _ex2) {
                        }
                    }

                    i *= 2;
                    if (i > 60)
                        i = 60;
                }
            }

            title = loadArchive(archiveChecksums[1], false, "title screen", 10, "title");
            p11 = new Font(title, "p11");
            p12 = new Font(title, "p12");
            b12 = new Font(title, "b12");
            q8 = new Font(title, "q8");
            method106(false);
            method56(0);
            FileArchive config = loadArchive(archiveChecksums[2], false, "config", 20, "config");
            FileArchive interfaces = loadArchive(archiveChecksums[3], false, "interface", 30, "interface");
            FileArchive media = loadArchive(archiveChecksums[4], false, "2d graphics", 40, "media");
            FileArchive models = loadArchive(archiveChecksums[5], false, "3d graphics", 50, "models");
            FileArchive textures = loadArchive(archiveChecksums[6], false, "textures", 60, "textures");
            FileArchive wordenc = loadArchive(archiveChecksums[7], false, "chat system", 70, "wordenc");
            levelRenderFlags = new byte[4][104][104];
            anIntArrayArrayArray725 = new int[4][105][105];
            aMapSquare_741 = new MapSquare(anIntArrayArrayArray725, -4278, 4, 104, 104);
            for (int l = 0; l < 4; l++)
                aCollisionMapArray737[l] = new CollisionMap(104, anInt676, 104);

            aSprite_954 = new Sprite(512, 512);
            showProgress((byte) -75, 80, "Unpacking media");
            aClass35_Sub2_Sub2_Sub3_691 = new IndexedSprite(media, "invback", 0);
            aClass35_Sub2_Sub2_Sub3_693 = new IndexedSprite(media, "chatback", 0);
            aClass35_Sub2_Sub2_Sub3_692 = new IndexedSprite(media, "mapback", 0);
            aClass35_Sub2_Sub2_Sub3_944 = new IndexedSprite(media, "backbase1", 0);
            aClass35_Sub2_Sub2_Sub3_945 = new IndexedSprite(media, "backbase2", 0);
            aClass35_Sub2_Sub2_Sub3_946 = new IndexedSprite(media, "backhmid1", 0);
            aClass35_Sub2_Sub2_Sub3_872 = new IndexedSprite(media, "sideicons1", 0);
            aClass35_Sub2_Sub2_Sub3_873 = new IndexedSprite(media, "sideicons2", 0);
            aSprite_898 = new Sprite(media, "compass", 0);
            try {
                for (int i1 = 0; i1 < 50; i1++)
                    aClass35_Sub2_Sub2_Sub3Array718[i1] = new IndexedSprite(media, "mapscene", i1);

            } catch (Exception _ex) {
            }
            try {
                for (int j1 = 0; j1 < 50; j1++)
                    aSpriteArray884[j1] = new Sprite(media, "mapfunction", j1);

            } catch (Exception _ex) {
            }
            try {
                for (int k1 = 0; k1 < 20; k1++)
                    aSpriteArray980[k1] = new Sprite(media, "hitmarks", k1);

            } catch (Exception _ex) {
            }
            try {
                for (int l1 = 0; l1 < 20; l1++)
                    aSpriteArray843[l1] = new Sprite(media, "headicons", l1);

            } catch (Exception _ex) {
            }
            for (int i2 = 0; i2 < 8; i2++)
                aSpriteArray958[i2] = new Sprite(media, "cross", i2);

            aSprite_824 = new Sprite(media, "mapdots", 0);
            aSprite_825 = new Sprite(media, "mapdots", 1);
            aSprite_826 = new Sprite(media, "mapdots", 2);
            aSprite_827 = new Sprite(media, "mapdots", 3);
            aClass35_Sub2_Sub2_Sub3_978 = new IndexedSprite(media, "scrollbar", 0);
            aClass35_Sub2_Sub2_Sub3_979 = new IndexedSprite(media, "scrollbar", 1);
            aClass35_Sub2_Sub2_Sub3_647 = new IndexedSprite(media, "redstone1", 0);
            aClass35_Sub2_Sub2_Sub3_648 = new IndexedSprite(media, "redstone2", 0);
            aClass35_Sub2_Sub2_Sub3_649 = new IndexedSprite(media, "redstone3", 0);
            aClass35_Sub2_Sub2_Sub3_650 = new IndexedSprite(media, "redstone1", 0);
            aClass35_Sub2_Sub2_Sub3_650.method366(-25737);
            aClass35_Sub2_Sub2_Sub3_651 = new IndexedSprite(media, "redstone2", 0);
            aClass35_Sub2_Sub2_Sub3_651.method366(-25737);
            aClass35_Sub2_Sub2_Sub3_727 = new IndexedSprite(media, "redstone1", 0);
            aClass35_Sub2_Sub2_Sub3_727.method367(false);
            aClass35_Sub2_Sub2_Sub3_728 = new IndexedSprite(media, "redstone2", 0);
            aClass35_Sub2_Sub2_Sub3_728.method367(false);
            aClass35_Sub2_Sub2_Sub3_729 = new IndexedSprite(media, "redstone3", 0);
            aClass35_Sub2_Sub2_Sub3_729.method367(false);
            aClass35_Sub2_Sub2_Sub3_730 = new IndexedSprite(media, "redstone1", 0);
            aClass35_Sub2_Sub2_Sub3_730.method366(-25737);
            aClass35_Sub2_Sub2_Sub3_730.method367(false);
            aClass35_Sub2_Sub2_Sub3_731 = new IndexedSprite(media, "redstone2", 0);
            aClass35_Sub2_Sub2_Sub3_731.method366(-25737);
            aClass35_Sub2_Sub2_Sub3_731.method367(false);
            Sprite class35_sub2_sub2_sub2 = new Sprite(media, "backleft1", 0);
            aFrameBuffer_982 = new FrameBuffer(class35_sub2_sub2_sub2.anInt1294, (byte) -58, method11(-36374), class35_sub2_sub2_sub2.anInt1293);
            class35_sub2_sub2_sub2.method355(0, anInt841, 0);
            class35_sub2_sub2_sub2 = new Sprite(media, "backleft2", 0);
            aFrameBuffer_983 = new FrameBuffer(class35_sub2_sub2_sub2.anInt1294, (byte) -58, method11(-36374), class35_sub2_sub2_sub2.anInt1293);
            class35_sub2_sub2_sub2.method355(0, anInt841, 0);
            class35_sub2_sub2_sub2 = new Sprite(media, "backright1", 0);
            aFrameBuffer_984 = new FrameBuffer(class35_sub2_sub2_sub2.anInt1294, (byte) -58, method11(-36374), class35_sub2_sub2_sub2.anInt1293);
            class35_sub2_sub2_sub2.method355(0, anInt841, 0);
            class35_sub2_sub2_sub2 = new Sprite(media, "backright2", 0);
            aFrameBuffer_985 = new FrameBuffer(class35_sub2_sub2_sub2.anInt1294, (byte) -58, method11(-36374), class35_sub2_sub2_sub2.anInt1293);
            class35_sub2_sub2_sub2.method355(0, anInt841, 0);
            class35_sub2_sub2_sub2 = new Sprite(media, "backtop1", 0);
            aFrameBuffer_986 = new FrameBuffer(class35_sub2_sub2_sub2.anInt1294, (byte) -58, method11(-36374), class35_sub2_sub2_sub2.anInt1293);
            class35_sub2_sub2_sub2.method355(0, anInt841, 0);
            class35_sub2_sub2_sub2 = new Sprite(media, "backtop2", 0);
            aFrameBuffer_987 = new FrameBuffer(class35_sub2_sub2_sub2.anInt1294, (byte) -58, method11(-36374), class35_sub2_sub2_sub2.anInt1293);
            class35_sub2_sub2_sub2.method355(0, anInt841, 0);
            class35_sub2_sub2_sub2 = new Sprite(media, "backvmid1", 0);
            aFrameBuffer_988 = new FrameBuffer(class35_sub2_sub2_sub2.anInt1294, (byte) -58, method11(-36374), class35_sub2_sub2_sub2.anInt1293);
            class35_sub2_sub2_sub2.method355(0, anInt841, 0);
            class35_sub2_sub2_sub2 = new Sprite(media, "backvmid2", 0);
            aFrameBuffer_989 = new FrameBuffer(class35_sub2_sub2_sub2.anInt1294, (byte) -58, method11(-36374), class35_sub2_sub2_sub2.anInt1293);
            class35_sub2_sub2_sub2.method355(0, anInt841, 0);
            class35_sub2_sub2_sub2 = new Sprite(media, "backvmid3", 0);
            aFrameBuffer_990 = new FrameBuffer(class35_sub2_sub2_sub2.anInt1294, (byte) -58, method11(-36374), class35_sub2_sub2_sub2.anInt1293);
            class35_sub2_sub2_sub2.method355(0, anInt841, 0);
            class35_sub2_sub2_sub2 = new Sprite(media, "backhmid2", 0);
            aFrameBuffer_991 = new FrameBuffer(class35_sub2_sub2_sub2.anInt1294, (byte) -58, method11(-36374), class35_sub2_sub2_sub2.anInt1293);
            class35_sub2_sub2_sub2.method355(0, anInt841, 0);
            showProgress((byte) -75, 85, "Unpacking textures");
            Draw3D.method342(aBoolean828, textures);
            Draw3D.method346(0.80000000000000004D, -433);
            Draw3D.method341((byte) 3, 20);
            showProgress((byte) -75, 85, "Unpacking models");
            Model.decode(models);
            SeqBase.decode(models);
            SeqFrame.decode(models);
            showProgress((byte) -75, 85, "Unpacking config");
            SeqType.decode(config);
            LocType.decode(config);
            FloType.decode(config);
            ObjType.decode(config);
            NpcType.decode(config);
            IdkType.decode(config);
            SpotAnimType.decode(config);
            VarpType.decode(config);
            showProgress((byte) -75, 90, "Unpacking interfaces");
            Font[] fonts = {
                    p11, p12, b12, q8
            };
            Component.decode(media, interfaces, fonts);
            showProgress((byte) -75, 95, "Preparing game engine");
            for (int j2 = 0; j2 < 33; j2++) {
                int k2 = 999;
                int i3 = 0;
                for (int k3 = 0; k3 < 35; k3++) {
                    if (aClass35_Sub2_Sub2_Sub3_692.aByteArray1304[k3 + j2 * aClass35_Sub2_Sub2_Sub3_692.anInt1306] == 0) {
                        if (k2 == 999)
                            k2 = k3;
                        continue;
                    }
                    if (k2 == 999)
                        continue;
                    i3 = k3;
                    break;
                }

                anIntArray815[j2] = k2;
                anIntArray787[j2] = i3 - k2;
            }

            for (int l2 = 9; l2 < 160; l2++) {
                int j3 = 999;
                int l3 = 0;
                for (int j4 = 10; j4 < 168; j4++) {
                    if (aClass35_Sub2_Sub2_Sub3_692.aByteArray1304[j4 + l2 * aClass35_Sub2_Sub2_Sub3_692.anInt1306] == 0 && (j4 > 34 || l2 > 34)) {
                        if (j3 == 999)
                            j3 = j4;
                        continue;
                    }
                    if (j3 == 999)
                        continue;
                    l3 = j4;
                    break;
                }

                anIntArray801[l2 - 9] = j3 - 21;
                anIntArray862[l2 - 9] = l3 - j3;
            }

            Draw3D.method339(479, aBoolean835, 96);
            anIntArray934 = Draw3D.anIntArray1273;
            Draw3D.method339(190, aBoolean835, 261);
            anIntArray935 = Draw3D.anIntArray1273;
            Draw3D.method339(512, aBoolean835, 334);
            anIntArray936 = Draw3D.anIntArray1273;
            int[] ai = new int[9];
            for (int i4 = 0; i4 < 9; i4++) {
                int k4 = 128 + i4 * 32 + 15;
                int l4 = 600 + k4 * 3;
                int i5 = Draw3D.anIntArray1271[k4];
                ai[i4] = l4 * i5 >> 16;
            }

            MapSquare.method272(512, 6, 334, ai, 800, 500);
            WordPack.decode(wordenc);

            if (startServer) {
                Server.ready = true;
            }
        } catch (Exception exception) {
            errorLoading = true;
            exception.printStackTrace();
        }
    }

    public Socket method98(int i)
            throws IOException {
        if (signlink.mainapp != null)
            return signlink.opensocket(i);
        else
            return new Socket(InetAddress.getByName(getCodeBase().getHost()), i);
    }

    public String method99() {
        if (signlink.jingle == null) {
            return "none";
        } else {
            String s = signlink.jingle + ".mid.gz";
            signlink.jingle = null;
            return s;
        }
    }

    public void method100(boolean flag, int i, int j, Component class8, int k, byte byte0, int l,
                          int i1, int j1) {
        if (byte0 != 9)
            return;
        if (aBoolean761)
            anInt899 = 32;
        else
            anInt899 = 0;
        aBoolean761 = false;
        if (j >= k && j < k + 16 && i1 >= j1 && i1 < j1 + 16) {
            class8.anInt129 -= anInt766 * 4;
            if (flag) {
                sidebarRedraw = true;
                return;
            }
        } else if (j >= k && j < k + 16 && i1 >= (j1 + l) - 16 && i1 < j1 + l) {
            class8.anInt129 += anInt766 * 4;
            if (flag) {
                sidebarRedraw = true;
                return;
            }
        } else if (j >= k - anInt899 && j < k + 16 + anInt899 && i1 >= j1 + 16 && i1 < (j1 + l) - 16 && anInt766 > 0) {
            int k1 = ((l - 32) * l) / i;
            if (k1 < 8)
                k1 = 8;
            int l1 = i1 - j1 - 16 - k1 / 2;
            int i2 = l - 32 - k1;
            class8.anInt129 = ((i - l) * l1) / i2;
            if (flag)
                sidebarRedraw = true;
            aBoolean761 = true;
        }
    }

    public void method101(int i) {
        if (anInt774 != 0)
            return;
        int j = super.anInt22;
        packetLength += i;
        if (anInt706 == 1 && super.anInt23 >= 520 && super.anInt24 >= 165 && super.anInt23 <= 788 && super.anInt24 <= 230)
            j = 0;
        if (aBoolean838) {
            if (j != 1) {
                int k = super.anInt20;
                int j1 = super.anInt21;
                if (anInt667 == 0) {
                    k -= 8;
                    j1 -= 11;
                }
                if (anInt667 == 1) {
                    k -= 562;
                    j1 -= 231;
                }
                if (k < anInt668 - 10 || k > anInt668 + anInt670 + 10 || j1 < anInt669 - 10 || j1 > anInt669 + anInt671 + 10) {
                    aBoolean838 = false;
                    if (anInt667 == 1)
                        sidebarRedraw = true;
                }
            }
            if (j == 1) {
                int l = anInt668;
                int k1 = anInt669;
                int i2 = anInt670;
                int k2 = super.anInt23;
                int l2 = super.anInt24;
                if (anInt667 == 0) {
                    k2 -= 8;
                    l2 -= 11;
                }
                if (anInt667 == 1) {
                    k2 -= 562;
                    l2 -= 231;
                }
                int i3 = -1;
                for (int j3 = 0; j3 < anInt710; j3++) {
                    int k3 = k1 + 31 + (anInt710 - 1 - j3) * 15;
                    if (k2 > l && k2 < l + i2 && l2 > k3 - 13 && l2 < k3 + 3)
                        i3 = j3;
                }

                if (i3 != -1)
                    method59(anInt711, i3);
                aBoolean838 = false;
                if (anInt667 == 1) {
                    sidebarRedraw = true;
                    return;
                }
            }
        } else {
            if (j == 1 && anInt710 > 0) {
                int i1 = anIntArray848[anInt710 - 1];
                if (i1 == 288 || i1 == 776 || i1 == 857 || i1 == 881 || i1 == 688 || i1 == 649 || i1 == 408 || i1 == 176 || i1 == 294 || i1 == 622 || i1 == 517) {
                    int l1 = anIntArray846[anInt710 - 1];
                    int j2 = anIntArray847[anInt710 - 1];
                    Component class8 = Component.aComponentArray110[j2];
                    if (class8.aBoolean136) {
                        aBoolean704 = false;
                        anInt772 = j2;
                        anInt773 = l1;
                        anInt774 = 2;
                        anInt775 = super.anInt23;
                        anInt776 = super.anInt24;
                        if (Component.aComponentArray110[j2].anInt116 == anInt962)
                            anInt774 = 1;
                        if (Component.aComponentArray110[j2].anInt116 == anInt702)
                            anInt774 = 3;
                        return;
                    }
                }
            }
            if (j == 1 && anInt748 == 1 && anInt710 > 2)
                j = 2;
            if (j == 1 && anInt710 > 0)
                method59(anInt711, anInt710 - 1);
            if (j == 2 && anInt710 > 0)
                method30(-23085);
        }
    }

    public void method102(boolean flag) {
        aFrameBuffer_643.method234(-510);
        int i = 48 + self.x / 32;
        int j1 = 464 - self.z / 32;
        aSprite_954.method361(anIntArray862, 146, 0, 151, anIntArray801, 21, 9, i, anInt924, j1);
        aSprite_898.method361(anIntArray787, 33, 0, 33, anIntArray815, 0, 0, 25, anInt924, 25);
        for (int k2 = 0; k2 < anInt767; k2++) {
            int j = (anIntArray768[k2] * 4 + 2) - self.x / 32;
            int k1 = (anIntArray769[k2] * 4 + 2) - self.z / 32;
            method111(aByte886, k1, aSpriteArray877[k2], j);
        }

        for (int l2 = 0; l2 < 104; l2++) {
            for (int i3 = 0; i3 < 104; i3++) {
                LinkedList class24 = aLinkedListArrayArrayArray665[anInt722][l2][i3];
                if (class24 != null) {
                    int k = (l2 * 4 + 2) - self.x / 32;
                    int l1 = (i3 * 4 + 2) - self.z / 32;
                    method111(aByte886, l1, aSprite_824, k);
                }
            }

        }

        for (int j3 = 0; j3 < anInt965; j3++) {
            NpcEntity class35_sub7_sub3_sub1 = aClass35_Sub7_Sub3_Sub1Array964[anIntArray966[j3]];
            if (class35_sub7_sub3_sub1 != null && class35_sub7_sub3_sub1.method411(0) && class35_sub7_sub3_sub1.aNpcType_1325.aBoolean593) {
                int l = class35_sub7_sub3_sub1.x / 32 - self.x / 32;
                int i2 = class35_sub7_sub3_sub1.z / 32 - self.z / 32;
                method111(aByte886, i2, aSprite_825, l);
            }
        }

        for (int k3 = 0; k3 < anInt752; k3++) {
            PlayerEntity class35_sub7_sub3_sub2 = aPlayerEntityArray751[anIntArray753[k3]];
            if (class35_sub7_sub3_sub2 != null && class35_sub7_sub3_sub2.method411(0)) {
                int i1 = class35_sub7_sub3_sub2.x / 32 - self.x / 32;
                int j2 = class35_sub7_sub3_sub2.z / 32 - self.z / 32;
                boolean flag1 = false;
                long l3 = StringUtils.toBase37(class35_sub7_sub3_sub2.name);
                for (int i4 = 0; i4 < anInt638; i4++) {
                    if (l3 != aLongArray971[i4] || anIntArray783[i4] == 0)
                        continue;
                    flag1 = true;
                    break;
                }

                if (flag1)
                    method111(aByte886, j2, aSprite_827, i1);
                else
                    method111(aByte886, j2, aSprite_826, i1);
            }
        }

        Draw2D.method333(0xffffff, anInt807, 3, 82, 3, 93);
        aFrameBuffer_644.method234(-510);
        aBoolean734 &= flag;
    }

    public void login(String username, String password, int uid, boolean flag) {
        signlink.errorname = username;
        try {
            if (!flag) {
                aString973 = "";
                aString974 = "Connecting to server...";
                method74(false);
            }
            stream = new BufferedStream(this, 994, method98(43594 + nodeOffset));
            stream.method153(inBuffer.data, 0, 8);
            inBuffer.pos = 0;
            serverSeed = inBuffer.g8();
            int[] seed = new int[4];
            seed[0] = (int) (Math.random() * 99999999D);
            seed[1] = (int) (Math.random() * 99999999D);
            seed[2] = (int) (serverSeed >> 32);
            seed[3] = (int) serverSeed;
            outBuffer.pos = 0;
            outBuffer.p1(10);
            outBuffer.p4(seed[0]);
            outBuffer.p4(seed[1]);
            outBuffer.p4(seed[2]);
            outBuffer.p4(seed[3]);
            outBuffer.p4(uid);
            outBuffer.pjstr(username);
            outBuffer.pjstr(password);
            outBuffer.rsaenc(RSA_MODULUS, RSA_EXPONENT);
            loginBuffer.pos = 0;
            if (flag)
                loginBuffer.p1(18);
            else
                loginBuffer.p1(16);
            loginBuffer.p1(outBuffer.pos + 32 + 1);
            loginBuffer.p1(194);
            for (int j = 0; j < 8; j++)
                loginBuffer.p4(archiveChecksums[j]);
            loginBuffer.pdata(outBuffer.data, 0, outBuffer.pos);
            outBuffer.isaac = new IsaacRandom(seed);
            for (int k = 0; k < 4; k++)
                seed[k] += 50;

            isaac = new IsaacRandom(seed);
            stream.write(loginBuffer.data, loginBuffer.pos, false, 0);
            int l = stream.read();
            if (l == 1) {
                try {
                    Thread.sleep(2000L);
                } catch (Exception _ex) {
                }
                login(username, password, uid, flag);
                return;
            }
            if (l == 2) {
                aBoolean734 = true;
                outBuffer.pos = 0;
                inBuffer.pos = 0;
                packetOpcode = -1;
                anInt903 = -1;
                anInt904 = -1;
                anInt905 = -1;
                packetLength = 0;
                anInt812 = 0;
                anInt738 = 0;
                anInt710 = 0;
                aBoolean838 = false;
                super.anInt18 = 0;
                for (int i1 = 0; i1 < 100; i1++)
                    aStringArray814[i1] = null;

                anInt712 = 0;
                anInt706 = 0;
                anInt969 = 0;
                anInt878 = -1;
                anInt752 = 0;
                anInt965 = 0;
                for (int j1 = 0; j1 < anInt749; j1++) {
                    aPlayerEntityArray751[j1] = null;
                    aClass35_Sub2_Sub3Array756[j1] = null;
                }

                for (int k1 = 0; k1 < 8192; k1++)
                    aClass35_Sub7_Sub3_Sub1Array964[k1] = null;

                self = aPlayerEntityArray751[anInt750] = new PlayerEntity();
                aLinkedList_863.method231();
                aLinkedList_657.method231();
                aLinkedList_652.method231();
                for (int l1 = 0; l1 < 4; l1++) {
                    for (int i2 = 0; i2 < 104; i2++) {
                        for (int k2 = 0; k2 < 104; k2++)
                            aLinkedListArrayArrayArray665[l1][i2][k2] = null;

                    }

                }

                aLinkedList_746 = new LinkedList(5);
                anInt638 = 0;
                anInt702 = -1;
                anInt962 = -1;
                anInt981 = -1;
                aBoolean888 = false;
                anInt907 = 3;
                aBoolean763 = false;
                aBoolean838 = false;
                aBoolean739 = false;
                anInt703 = 0;
                aBoolean970 = true;
                method42(1);
                for (int j2 = 0; j2 < 5; j2++)
                    anIntArray789[j2] = 0;

                method41(-242);
                if (nodeOffset >= 3)
                    InputTracking.method159(-282);
                return;
            }
            if (l == 3) {
                aString973 = "";
                aString974 = "Invalid username or password.";
                return;
            }
            if (l == 4) {
                aString973 = "Your account has been disabled.";
                aString974 = "Please check your message-centre for details.";
                return;
            }
            if (l == 5) {
                aString973 = "Your account is already logged in.";
                aString974 = "Try again in 60 secs...";
                return;
            }
            if (l == 6) {
                aString973 = "RuneScape has been updated!";
                aString974 = "Please reload this page.";
                return;
            }
            if (l == 7) {
                aString973 = "This world is full.";
                aString974 = "Please use a different world.";
                return;
            }
            if (l == 8) {
                aString973 = "Unable to connect.";
                aString974 = "Login server offline.";
                return;
            }
            if (l == 9) {
                aString973 = "Login limit exceeded.";
                aString974 = "Too many connections from your address.";
                return;
            }
            if (l == 10) {
                aString973 = "Unable to connect.";
                aString974 = "Bad session id.";
                return;
            }
            if (l == 11) {
                aString974 = "Login server rejected session.";
                aString974 = "Please try again";
                return;
            }
            if (l == 12) {
                aString973 = "You need a members account to beta-test";
                aString974 = "Please subscribe, or play RS1 instead";
                return;
            }
            if (l == 13) {
                aString973 = "Could not complete login";
                aString974 = "Please try using a different world";
                return;
            }
            if (l == 14) {
                aString973 = "The server is being updated";
                aString974 = "Please wait 1 minute and try again";
                return;
            }
            if (l == 15) {
                aBoolean734 = true;
                outBuffer.pos = 0;
                inBuffer.pos = 0;
                packetOpcode = -1;
                anInt903 = -1;
                anInt904 = -1;
                anInt905 = -1;
                packetLength = 0;
                anInt812 = 0;
                anInt738 = 0;
                anInt710 = 0;
                aBoolean838 = false;
                if (nodeOffset >= 3)
                    InputTracking.method159(-282);
                return;
            }
            if (l == 16) {
                aString973 = "Login attempts exceeded";
                aString974 = "Please wait 1 minute and try again";
                return;
            }
        } catch (IOException _ex) {
            aString973 = "";
            aString974 = "Error connecting to server.";
        }
    }

    public void method12(Runnable runnable, int i) {
        if (signlink.mainapp != null) {
            signlink.startthread(runnable, i);
            return;
        } else {
            super.method12(runnable, i);
            return;
        }
    }

    public DataInputStream method104(String s)
            throws IOException {
        if (signlink.mainapp != null)
            return signlink.openurl(s);
        else
            return new DataInputStream((new URL(getCodeBase(), s)).openStream());
    }

    public void method105(byte byte0) {
        aFrameBuffer_642.method234(-510);
        Draw3D.anIntArray1273 = anIntArray935;
        aClass35_Sub2_Sub2_Sub3_691.method368(0, anInt861, 0);
        if (byte0 == 7)
            byte0 = 0;
        else
            anInt807 = isaac.nextInt();
        if (anInt981 != -1)
            method53(aBoolean770, Component.aComponentArray110[anInt981], 0, 0, 0);
        else if (tabComponentId[anInt907] != -1)
            method53(aBoolean770, Component.aComponentArray110[tabComponentId[anInt907]], 0, 0, 0);
        if (aBoolean838 && anInt667 == 1)
            method76(9);
        aFrameBuffer_642.method235(562, super.aGraphics13, 231, aByte930);
        aFrameBuffer_644.method234(-510);
        Draw3D.anIntArray1273 = anIntArray936;
    }

    public void method106(boolean flag) {
        byte[] abyte0 = title.method417((byte) 6, null, "title.dat");
        Sprite class35_sub2_sub2_sub2 = new Sprite(abyte0, this);
        aFrameBuffer_892.method234(-510);
        class35_sub2_sub2_sub2.method355(0, anInt841, 0);
        if (flag)
            aBoolean828 = !aBoolean828;
        aFrameBuffer_893.method234(-510);
        class35_sub2_sub2_sub2.method355(0, anInt841, -661);
        aFrameBuffer_889.method234(-510);
        class35_sub2_sub2_sub2.method355(0, anInt841, -128);
        aFrameBuffer_890.method234(-510);
        class35_sub2_sub2_sub2.method355(-386, anInt841, -214);
        aFrameBuffer_891.method234(-510);
        class35_sub2_sub2_sub2.method355(-186, anInt841, -214);
        aFrameBuffer_894.method234(-510);
        class35_sub2_sub2_sub2.method355(-265, anInt841, 0);
        aFrameBuffer_895.method234(-510);
        class35_sub2_sub2_sub2.method355(-265, anInt841, -574);
        aFrameBuffer_896.method234(-510);
        class35_sub2_sub2_sub2.method355(-186, anInt841, -128);
        aFrameBuffer_897.method234(-510);
        class35_sub2_sub2_sub2.method355(-186, anInt841, -574);
        int[] ai = new int[class35_sub2_sub2_sub2.anInt1293];
        for (int i = 0; i < class35_sub2_sub2_sub2.anInt1294; i++) {
            for (int j = 0; j < class35_sub2_sub2_sub2.anInt1293; j++)
                ai[j] = class35_sub2_sub2_sub2.anIntArray1292[(class35_sub2_sub2_sub2.anInt1293 - j - 1) + class35_sub2_sub2_sub2.anInt1293 * i];

            for (int k = 0; k < class35_sub2_sub2_sub2.anInt1293; k++)
                class35_sub2_sub2_sub2.anIntArray1292[k + class35_sub2_sub2_sub2.anInt1293 * i] = ai[k];

        }

        aFrameBuffer_892.method234(-510);
        class35_sub2_sub2_sub2.method355(0, anInt841, 394);
        aFrameBuffer_893.method234(-510);
        class35_sub2_sub2_sub2.method355(0, anInt841, -267);
        aFrameBuffer_889.method234(-510);
        class35_sub2_sub2_sub2.method355(0, anInt841, 266);
        aFrameBuffer_890.method234(-510);
        class35_sub2_sub2_sub2.method355(-386, anInt841, 180);
        aFrameBuffer_891.method234(-510);
        class35_sub2_sub2_sub2.method355(-186, anInt841, 180);
        aFrameBuffer_894.method234(-510);
        class35_sub2_sub2_sub2.method355(-265, anInt841, 394);
        aFrameBuffer_895.method234(-510);
        class35_sub2_sub2_sub2.method355(-265, anInt841, -180);
        aFrameBuffer_896.method234(-510);
        class35_sub2_sub2_sub2.method355(-186, anInt841, 212);
        aFrameBuffer_897.method234(-510);
        class35_sub2_sub2_sub2.method355(-186, anInt841, -180);
        class35_sub2_sub2_sub2 = new Sprite(title, "logo", 0);
        aFrameBuffer_889.method234(-510);
        class35_sub2_sub2_sub2.method357(18, anInt861, super.anInt11 / 2 - class35_sub2_sub2_sub2.anInt1293 / 2 - 128);
        class35_sub2_sub2_sub2 = null;
        abyte0 = null;
        ai = null;
        System.gc();
    }

    public void method10(boolean flag) {
        aBoolean681 = true;
        if (flag)
            aLinkedListArrayArrayArray665 = null;
    }

    public void method107(int i, int j, int k, int l) {
        int i1 = aMapSquare_741.method262(l, j, i);
        if (i1 != 0) {
            int j1 = aMapSquare_741.method266(l, j, i, i1);
            int l1 = j1 >> 6 & 3;
            int j2 = j1 & 0x1f;
            int l2 = 0xeeeeee;
            if (i1 > 0)
                l2 = 0xee0000;
            int[] ai = aSprite_954.anIntArray1292;
            int k3 = 24624 + j * 4 + (103 - i) * 512 * 4;
            if (j2 == 0 || j2 == 2)
                if (l1 == 0) {
                    ai[k3] = l2;
                    ai[k3 + 512] = l2;
                    ai[k3 + 1024] = l2;
                    ai[k3 + 1536] = l2;
                } else if (l1 == 1) {
                    ai[k3] = l2;
                    ai[k3 + 1] = l2;
                    ai[k3 + 2] = l2;
                    ai[k3 + 3] = l2;
                } else if (l1 == 2) {
                    ai[k3 + 3] = l2;
                    ai[k3 + 3 + 512] = l2;
                    ai[k3 + 3 + 1024] = l2;
                    ai[k3 + 3 + 1536] = l2;
                } else if (l1 == 3) {
                    ai[k3 + 1536] = l2;
                    ai[k3 + 1536 + 1] = l2;
                    ai[k3 + 1536 + 2] = l2;
                    ai[k3 + 1536 + 3] = l2;
                }
            if (j2 == 3)
                if (l1 == 0)
                    ai[k3] = l2;
                else if (l1 == 1)
                    ai[k3 + 3] = l2;
                else if (l1 == 2)
                    ai[k3 + 3 + 1536] = l2;
                else if (l1 == 3)
                    ai[k3 + 1536] = l2;
            if (j2 == 2)
                if (l1 == 3) {
                    ai[k3] = l2;
                    ai[k3 + 512] = l2;
                    ai[k3 + 1024] = l2;
                    ai[k3 + 1536] = l2;
                } else if (l1 == 0) {
                    ai[k3] = l2;
                    ai[k3 + 1] = l2;
                    ai[k3 + 2] = l2;
                    ai[k3 + 3] = l2;
                } else if (l1 == 1) {
                    ai[k3 + 3] = l2;
                    ai[k3 + 3 + 512] = l2;
                    ai[k3 + 3 + 1024] = l2;
                    ai[k3 + 3 + 1536] = l2;
                } else if (l1 == 2) {
                    ai[k3 + 1536] = l2;
                    ai[k3 + 1536 + 1] = l2;
                    ai[k3 + 1536 + 2] = l2;
                    ai[k3 + 1536 + 3] = l2;
                }
        }
        i1 = aMapSquare_741.method264(l, j, i);
        if (k != -29363)
            return;
        if (i1 != 0) {
            int k1 = aMapSquare_741.method266(l, j, i, i1);
            int i2 = k1 >> 6 & 3;
            int k2 = k1 & 0x1f;
            if (k2 == 9) {
                int i3 = 0xeeeeee;
                if (i1 > 0)
                    i3 = 0xee0000;
                int[] ai1 = aSprite_954.anIntArray1292;
                int l3 = 24624 + j * 4 + (103 - i) * 512 * 4;
                if (i2 == 0 || i2 == 2) {
                    ai1[l3 + 1536] = i3;
                    ai1[l3 + 1024 + 1] = i3;
                    ai1[l3 + 512 + 2] = i3;
                    ai1[l3 + 3] = i3;
                } else {
                    ai1[l3] = i3;
                    ai1[l3 + 512 + 1] = i3;
                    ai1[l3 + 1024 + 2] = i3;
                    ai1[l3 + 1536 + 3] = i3;
                }
            }
            if (k2 == 10 || k2 == 11) {
                int j3 = i1 >> 14 & 0x7fff;
                LocType class39 = LocType.method428(j3);
                if (class39.anInt557 != -1) {
                    IndexedSprite class35_sub2_sub2_sub3 = aClass35_Sub2_Sub2_Sub3Array718[class39.anInt557];
                    int i4 = (class39.anInt542 * 4 - class35_sub2_sub2_sub3.anInt1306) / 2;
                    int j4 = (class39.anInt543 * 4 - class35_sub2_sub2_sub3.anInt1307) / 2;
                    class35_sub2_sub2_sub3.method368(48 + (104 - i - class39.anInt543) * 4 + j4, anInt861, 48 + j * 4 + i4);
                }
            }
        }
    }

    public void method108(boolean flag, int i) {
        int[] ai = aSprite_954.anIntArray1292;
        if (flag)
            outBuffer.p1(234);
        int j = ai.length;
        for (int k = 0; k < j; k++)
            ai[k] = 0;

        for (int l = 1; l < 103; l++) {
            int i1 = 24628 + (103 - l) * 512 * 4;
            for (int k1 = 1; k1 < 103; k1++) {
                if ((levelRenderFlags[i][k1][l] & 0x18) == 0)
                    aMapSquare_741.method271(ai, i1, 512, i, k1, l);
                if (i < 3 && (levelRenderFlags[i + 1][k1][l] & 8) != 0)
                    aMapSquare_741.method271(ai, i1, 512, i + 1, k1, l);
                i1 += 4;
            }

        }

        aSprite_954.method354(-510);
        for (int j1 = 1; j1 < 103; j1++) {
            for (int l1 = 1; l1 < 103; l1++) {
                if ((levelRenderFlags[i][l1][j1] & 0x18) == 0)
                    method107(j1, l1, -29363, i);
                if (i < 3 && (levelRenderFlags[i + 1][l1][j1] & 8) != 0)
                    method107(j1, l1, -29363, i + 1);
            }

        }

        aFrameBuffer_644.method234(-510);
        anInt767 = 0;
        for (int i2 = 0; i2 < 104; i2++) {
            for (int j2 = 0; j2 < 104; j2++) {
                int k2 = aMapSquare_741.method265(anInt722, i2, j2);
                if (k2 != 0) {
                    k2 = k2 >> 14 & 0x7fff;
                    int l2 = LocType.method428(k2).anInt556;
                    if (l2 >= 0) {
                        aSpriteArray877[anInt767] = aSpriteArray884[l2];
                        anIntArray768[anInt767] = i2;
                        anIntArray769[anInt767] = j2;
                        anInt767++;
                    }
                }
            }

        }

    }

    public boolean method109(byte byte0, Component class8) {
        if (byte0 != 3) {
            for (int i = 1; i > 0; i++) ;
        }
        if (class8.anIntArray125 == null)
            return false;
        for (int j = 0; j < class8.anIntArray125.length; j++) {
            int k = method23(j, class8, -6815);
            int l = class8.anIntArray126[j];
            if (class8.anIntArray125[j] == 2) {
                if (k >= l)
                    return false;
            } else if (class8.anIntArray125[j] == 3) {
                if (k <= l)
                    return false;
            } else if (class8.anIntArray125[j] == 4) {
                if (k == l)
                    return false;
            } else if (k != l)
                return false;
        }

        return true;
    }

    public void init() {
        nodeOffset = Integer.parseInt(getParameter("portoff"));
        anInt719 = Integer.parseInt(getParameter("nodeid"));
        String s = getParameter("lowmem");
        if (s != null && s.equals("1"))
            method94(26953);
        else
            method115(-229);
        method2(true, 789, 532);
    }

    public String method110() {
        if (signlink.midi == null) {
            return "none";
        } else {
            String s = signlink.midi + ".mid.gz";
            signlink.midi = null;
            return s;
        }
    }

    public void method111(byte byte0, int i, Sprite class35_sub2_sub2_sub2, int j) {
        int k = j * j + i * i;
        if (byte0 != aByte785) {
            for (int l = 1; l > 0; l++) ;
        }
        if (k > 6400)
            return;
        int i1 = Model.anIntArray1129[anInt924];
        int j1 = Model.anIntArray1130[anInt924];
        int k1 = i * i1 + j * j1 >> 16;
        int l1 = i * j1 - j * i1 >> 16;
        if (k > 2500) {
            class35_sub2_sub2_sub2.method362(0, (94 + k1) - class35_sub2_sub2_sub2.anInt1293 / 2, aClass35_Sub2_Sub2_Sub3_692, 83 - l1 - class35_sub2_sub2_sub2.anInt1294 / 2);
            return;
        } else {
            class35_sub2_sub2_sub2.method357(83 - l1 - class35_sub2_sub2_sub2.anInt1294 / 2, anInt861, (94 + k1) - class35_sub2_sub2_sub2.anInt1293 / 2);
            return;
        }
    }

    public void method112(boolean flag, int i, int j, int k, int l, int i1, int j1,
                          int k1) {
        aBoolean734 &= flag;
        if (l >= 1 && k >= 1 && l <= 102 && k <= 102) {
            if (aBoolean663 && i != anInt722)
                return;
            int l1 = 0;
            byte byte0 = -1;
            boolean flag1 = false;
            boolean flag2 = false;
            if (i1 == 0)
                l1 = aMapSquare_741.method262(i, l, k);
            if (i1 == 1)
                l1 = aMapSquare_741.method263(l, k, anInt845, i);
            if (i1 == 2)
                l1 = aMapSquare_741.method264(i, l, k);
            if (i1 == 3)
                l1 = aMapSquare_741.method265(i, l, k);
            if (l1 != 0) {
                int l2 = aMapSquare_741.method266(i, l, k, l1);
                int i2 = l1 >> 14 & 0x7fff;
                int j2 = l2 & 0x1f;
                int k2 = l2 >> 6;
                if (i1 == 0) {
                    aMapSquare_741.method257(anInt771, i, l, k);
                    LocType class39 = LocType.method428(i2);
                    if (class39.aBoolean544)
                        aCollisionMapArray737[i].method126(918, l, k2, class39.aBoolean545, k, j2);
                }
                if (i1 == 1)
                    aMapSquare_741.method258(l, i, 0, k);
                if (i1 == 2) {
                    aMapSquare_741.method259(533, k, i, l);
                    LocType class39_1 = LocType.method428(i2);
                    if (l + class39_1.anInt542 > 103 || k + class39_1.anInt542 > 103 || l + class39_1.anInt543 > 103 || k + class39_1.anInt543 > 103)
                        return;
                    if (class39_1.aBoolean544)
                        aCollisionMapArray737[i].method127(k, class39_1.anInt543, class39_1.aBoolean545, class39_1.anInt542, k2, l, false);
                }
                if (i1 == 3) {
                    aMapSquare_741.method260((byte) 52, k, l, i);
                    LocType class39_2 = LocType.method428(i2);
                    if (class39_2.aBoolean544 && class39_2.aBoolean546)
                        aCollisionMapArray737[i].method129(99, l, k);
                }
            }
            if (j1 >= 0) {
                int i3 = i;
                if (i3 < 3 && (levelRenderFlags[1][l][k] & 2) == 2)
                    i3++;
                Scene.method146(j1, aMapSquare_741, j, k1, i, l, aCollisionMapArray737[i], aLinkedList_943, anIntArrayArrayArray725, k, (byte) 1, i3);
            }
        }
    }

    public void method113(int i, PlayerEntity class35_sub7_sub3_sub2, int j, int k, int l) {
        packetLength += i;
        if (class35_sub7_sub3_sub2 == self)
            return;
        if (anInt710 >= 400)
            return;
        String s = class35_sub7_sub3_sub2.name + method62(class35_sub7_sub3_sub2.combatLevel, (byte) -102, self.combatLevel) + " (level-" + class35_sub7_sub3_sub2.combatLevel + ")";
        if (anInt712 == 1) {
            aStringArray720[anInt710] = "Use " + aString716 + " with @whi@" + s;
            anIntArray848[anInt710] = 933;
            anIntArray849[anInt710] = j;
            anIntArray846[anInt710] = l;
            anIntArray847[anInt710] = k;
            anInt710++;
            return;
        }
        if (anInt706 == 1) {
            if ((anInt708 & 8) == 8) {
                aStringArray720[anInt710] = aString709 + " @whi@" + s;
                anIntArray848[anInt710] = 989;
                anIntArray849[anInt710] = j;
                anIntArray846[anInt710] = l;
                anIntArray847[anInt710] = k;
                anInt710++;
                return;
            }
        } else {
            aStringArray720[anInt710] = "Follow @whi@" + s;
            anIntArray848[anInt710] = 900;
            anIntArray849[anInt710] = j;
            anIntArray846[anInt710] = l;
            anIntArray847[anInt710] = k;
            anInt710++;
            aStringArray720[anInt710] = "Trade with @whi@" + s;
            anIntArray848[anInt710] = 364;
            anIntArray849[anInt710] = j;
            anIntArray846[anInt710] = l;
            anIntArray847[anInt710] = k;
            anInt710++;
            if (anInt735 > 0) {
                aStringArray720[anInt710] = "Attack @whi@" + s;
                anIntArray848[anInt710] = 487;
                anIntArray849[anInt710] = j;
                anIntArray846[anInt710] = l;
                anIntArray847[anInt710] = k;
                anInt710++;
            }
        }
    }

    public int method114(int i, int j, int k, int l) {
        if (i <= 0)
            anInt676 = 226;
        int i1 = 256 - k;
        return ((j & 0xff00ff) * i1 + (l & 0xff00ff) * k & 0xff00ff00) + ((j & 0xff00) * i1 + (l & 0xff00) * k & 0xff0000) >> 8;
    }

    public static void method115(int i) {
        MapSquare.aBoolean382 = false;
        Draw3D.aBoolean1262 = false;
        aBoolean663 = false;
        Scene.aBoolean47 = false;
        if (i >= 0) {
            for (int j = 1; j > 0; j++) ;
        }
    }

    public void method116(int i) {
        for (int j = -1; j < anInt752; j++) {
            int k;
            if (j == -1)
                k = anInt750;
            else
                k = anIntArray753[j];
            PlayerEntity class35_sub7_sub3_sub2 = aPlayerEntityArray751[k];
            if (class35_sub7_sub3_sub2 != null)
                method82(true, 1, class35_sub7_sub3_sub2);
        }

        if (i > 0) ;
    }

    public void method117(int i) {
        if (anInt710 < 2 && anInt712 == 0 && anInt706 == 0)
            return;
        String s;
        if (anInt712 == 1 && anInt710 < 2)
            s = "Use " + aString716 + " with...";
        else if (anInt706 == 1 && anInt710 < 2)
            s = aString709 + "...";
        else
            s = aStringArray720[anInt710 - 1];
        if (anInt710 > 2)
            s = s + "@whi@ / " + (anInt710 - 2) + " more options";
        b12.method375(-886, true, 4, 0xffffff, 15, s);
        if (i >= 0)
            anInt820 = -499;
    }

    public void method118(int i) {
        aBoolean906 = false;
        while (aBoolean726) {
            aBoolean906 = false;
            try {
                Thread.sleep(50L);
            } catch (Exception _ex) {
            }
        }
        aClass35_Sub2_Sub2_Sub3_960 = null;
        aClass35_Sub2_Sub2_Sub3_961 = null;
        aClass35_Sub2_Sub2_Sub3Array914 = null;
        anIntArray797 = null;
        anIntArray798 = null;
        anIntArray799 = null;
        anIntArray800 = null;
        anIntArray956 = null;
        anIntArray957 = null;
        if (i != -43634)
            anInt684 = isaac.nextInt();
        anIntArray795 = null;
        anIntArray796 = null;
        aSprite_687 = null;
        aSprite_688 = null;
    }

    public void updateLocalPlayer(int i, Buffer class35_sub2_sub3, int j) {
        class35_sub2_sub3.accessBits();
        while (j >= 0)
            anInt845 = 143;
        int k = class35_sub2_sub3.gBit(1);
        if (k == 0)
            return;
        int l = class35_sub2_sub3.gBit(2);
        if (l == 0) {
            anIntArray755[anInt754++] = anInt750;
            return;
        }
        if (l == 1) {
            int i1 = class35_sub2_sub3.gBit(3);
            self.method410(false, i1, 112);
            int l1 = class35_sub2_sub3.gBit(1);
            if (l1 == 1)
                anIntArray755[anInt754++] = anInt750;
            return;
        }
        if (l == 2) {
            int j1 = class35_sub2_sub3.gBit(3);
            self.method410(true, j1, 112);
            int i2 = class35_sub2_sub3.gBit(3);
            self.method410(true, i2, 112);
            int k2 = class35_sub2_sub3.gBit(1);
            if (k2 == 1)
                anIntArray755[anInt754++] = anInt750;
            return;
        }
        if (l == 3) {
            anInt722 = class35_sub2_sub3.gBit(2);
            int k1 = class35_sub2_sub3.gBit(7);
            int j2 = class35_sub2_sub3.gBit(7);
            self.method409((byte) 28, k1, j2);
            int l2 = class35_sub2_sub3.gBit(1);
            if (l2 == 1)
                anIntArray755[anInt754++] = anInt750;
        }
    }

    public java.awt.Component method11(int i) {
        if (i != -36374)
            throw new NullPointerException();
        if (signlink.mainapp != null)
            return signlink.mainapp;
        return this;
    }

    public void method120(byte byte0) {
        aFrameBuffer_645.method234(-510);
        if (byte0 == 7)
            byte0 = 0;
        else
            aLinkedListArrayArrayArray665 = null;
        Draw3D.anIntArray1273 = anIntArray934;
        aClass35_Sub2_Sub2_Sub3_693.method368(0, anInt861, 0);
        if (aBoolean739) {
            b12.method370(true, 40, 0, 239, aString695);
            b12.method370(true, 60, 128, 239, aString887 + "*");
        } else if (aBoolean763) {
            b12.method370(true, 40, 0, 239, "Enter amount to transfer:");
            b12.method370(true, 60, 128, 239, aString947 + "*");
        } else if (anInt702 != -1) {
            method53(aBoolean770, Component.aComponentArray110[anInt702], 0, 0, 0);
        } else {
            int i = 0;
            Draw2D.method331(77, 463, 0, 0, 17913);
            for (int j = 0; j < 50; j++)
                if (aStringArray814[j] != null) {
                    int k = anIntArray662[j];
                    int l = (70 - i * 14) + anInt736;
                    if (k == 0) {
                        if (l > 0 && l < 110)
                            q8.method373(aStringArray814[j], 4, 0, true, l);
                        i++;
                    }
                    if (k == 1) {
                        if (l > 0 && l < 110) {
                            q8.method373(aStringArray870[j] + ":", 4, 0xffffff, true, l);
                            q8.method373(aStringArray814[j], 12 + q8.method372(aStringArray870[j], true), 255, true, l);
                        }
                        i++;
                    }
                    if (k == 2 && (anInt976 == 0 || anInt976 == 1 && method72(7, aStringArray870[j]))) {
                        if (l > 0 && l < 110) {
                            q8.method373(aStringArray870[j] + ":", 4, 0, true, l);
                            q8.method373(aStringArray814[j], 12 + q8.method372(aStringArray870[j], true), 255, true, l);
                        }
                        i++;
                    }
                    if (k == 3 && (anInt762 == 0 || anInt762 == 1 && method72(7, aStringArray870[j]))) {
                        if (l > 0 && l < 110) {
                            q8.method373("From " + aStringArray870[j] + ":", 4, 0, true, l);
                            q8.method373(aStringArray814[j], 12 + q8.method372("From " + aStringArray870[j], true), 0x800000, true, l);
                        }
                        i++;
                    }
                    if (k == 4 && (anInt821 == 0 || anInt821 == 1 && method72(7, aStringArray870[j]))) {
                        if (l > 0 && l < 110)
                            q8.method373(aStringArray870[j] + " " + aStringArray814[j], 4, 0x800080, true, l);
                        i++;
                    }
                    if (k == 5 && anInt762 < 2) {
                        if (l > 0 && l < 110)
                            q8.method373(aStringArray814[j], 4, 0x800000, true, l);
                        i++;
                    }
                    if (k == 6 && anInt762 < 2) {
                        if (l > 0 && l < 110) {
                            q8.method373("To " + aStringArray870[j] + ":", 4, 0, true, l);
                            q8.method373(aStringArray814[j], 12 + q8.method372("To " + aStringArray870[j], true), 0x800000, true, l);
                        }
                        i++;
                    }
                }

            Draw2D.method330(-971);
            anInt677 = i * 14 + 7;
            if (anInt677 < 78)
                anInt677 = 78;
            method96(0, false, 463, anInt677, anInt677 - anInt736 - 77, 77);
            q8.method373(aString784 + "*", 3, 0, true, 90);
            Draw2D.method335(479, false, 0, 77, 0);
        }
        aFrameBuffer_645.method235(22, super.aGraphics13, 375, aByte930);
        aFrameBuffer_644.method234(-510);
        Draw3D.anIntArray1273 = anIntArray936;
    }

    public client() {
        aBoolean635 = false;
        aCRC32_639 = new CRC32();
        aBoolean640 = false;
        aLinkedList_652 = new LinkedList(5);
        aBoolean653 = false;
        aBoolean655 = false;
        aByte656 = 9;
        aLinkedList_657 = new LinkedList(5);
        aBoolean660 = false;
        aBoolean661 = true;
        anIntArray662 = new int[100];
        aLinkedListArrayArrayArray665 = new LinkedList[4][104][104];
        anInt677 = 78;
        aByte679 = 71;
        aByte680 = 0;
        aBoolean681 = false;
        aBoolean682 = false;
        anInt684 = 3073;
        aLongArray685 = new long[100];
        anInt686 = -1;
        anInt690 = 2;
        aString695 = "";
        aByte696 = 7;
        aStringArray701 = new String[100];
        anInt702 = -1;
        aBoolean704 = false;
        aByte705 = 8;
        anInt711 = 7;
        archiveChecksums = new int[8];
        aClass35_Sub2_Sub2_Sub3Array718 = new IndexedSprite[50];
        anInt719 = 10;
        aStringArray720 = new String[500];
        anIntArray721 = new int[256];
        anIntArray723 = new int[4000];
        anIntArray724 = new int[4000];
        aBoolean726 = false;
        anInt733 = 962;
        aBoolean734 = false;
        aCollisionMapArray737 = new CollisionMap[4];
        aBoolean739 = false;
        aBoolean740 = false;
        aString743 = "";
        aString744 = "";
        aString745 = "";
        aLinkedList_746 = new LinkedList(5);
        sidebarRedraw = false;
        anInt749 = 2048;
        anInt750 = 2047;
        aPlayerEntityArray751 = new PlayerEntity[anInt749];
        anIntArray753 = new int[anInt749];
        anIntArray755 = new int[anInt749];
        aClass35_Sub2_Sub3Array756 = new Buffer[anInt749];
        anInt757 = -1;
        anInt758 = -1;
        aBoolean761 = false;
        aBoolean763 = false;
        aBooleanArray765 = new boolean[5];
        anIntArray768 = new int[1000];
        anIntArray769 = new int[1000];
        aBoolean770 = false;
        anIntArray777 = new int[50];
        anInt779 = -374;
        anInt780 = 42788;
        anInt781 = -23085;
        anIntArray783 = new int[100];
        aString784 = "";
        aByte785 = -48;
        anIntArray787 = new int[33];
        anIntArray789 = new int[5];
        anIntArray801 = new int[151];
        anInt807 = -878;
        anInt809 = 647;
        aStringArray814 = new String[100];
        anIntArray815 = new int[33];
        anInt820 = 7;
        anIntArray822 = new int[2000];
        anIntArray829 = new int[5];
        anIntArray831 = new int[100];
        errorLoading = false;
        anIntArray834 = new int[1000];
        aBoolean838 = false;
        anInt839 = -984;
        anIntArray840 = new int[50];
        aSpriteArray843 = new Sprite[20];
        anInt844 = 0x332d25;
        anInt845 = -14722;
        anIntArray846 = new int[500];
        anIntArray847 = new int[500];
        anIntArray848 = new int[500];
        anIntArray849 = new int[500];
        aByteArray850 = new byte[16384];
        anInt853 = 2;
        anIntArrayArray859 = new int[104][104];
        anInt861 = 801;
        anIntArray862 = new int[151];
        aLinkedList_863 = new LinkedList(5);
        anIntArray869 = new int[5];
        aStringArray870 = new String[100];
        anInt875 = 1;
        anInt876 = 0x766654;
        aSpriteArray877 = new Sprite[1000];
        anInt878 = -1;
        anIntArrayArray879 = new int[104][104];
        anInt881 = 0x23201b;
        anInt882 = -984;
        anIntArray883 = new int[7];
        aSpriteArray884 = new Sprite[50];
        aComponent_885 = new Component();
        aByte886 = -48;
        aString887 = "";
        aBoolean888 = false;
        inBuffer = Buffer.reserve(1);
        anInt902 = 0x4d4233;
        aBoolean906 = false;
        anInt907 = 3;
        aBoolean908 = true;
        anIntArrayArray911 = new int[104][104];
        anInt913 = 2;
        errorHost = false;
        anInt923 = 128;
        aByte930 = 7;
        loginBuffer = Buffer.reserve(1);
        aLinkedList_943 = new LinkedList(5);
        aString947 = "";
        anIntArray948 = new int[50];
        anIntArray949 = new int[5];
        aByte950 = 2;
        anInt952 = -40161;
        anInt953 = 4;
        aSpriteArray958 = new Sprite[8];
        outBuffer = Buffer.reserve(1);
        anInt962 = -1;
        aClass35_Sub7_Sub3_Sub1Array964 = new NpcEntity[8192];
        anIntArray966 = new int[8192];
        anIntArray967 = new int[5];
        aBoolean970 = true;
        aLongArray971 = new long[100];
        errorStarted = false;
        aString973 = "";
        aString974 = "";
        aBoolean977 = false;
        aSpriteArray980 = new Sprite[20];
        anInt981 = -1;
        aBoolean992 = false;
        aString993 = "127.0.0.1";
    }

    public boolean aBoolean635;
    public int anInt636;
    public int anInt637;
    public int anInt638;
    public CRC32 aCRC32_639;
    public boolean aBoolean640;
    public int anInt641;
    public FrameBuffer aFrameBuffer_642;
    public FrameBuffer aFrameBuffer_643;
    public FrameBuffer aFrameBuffer_644;
    public FrameBuffer aFrameBuffer_645;
    public IsaacRandom isaac;
    public IndexedSprite aClass35_Sub2_Sub2_Sub3_647;
    public IndexedSprite aClass35_Sub2_Sub2_Sub3_648;
    public IndexedSprite aClass35_Sub2_Sub2_Sub3_649;
    public IndexedSprite aClass35_Sub2_Sub2_Sub3_650;
    public IndexedSprite aClass35_Sub2_Sub2_Sub3_651;
    public LinkedList aLinkedList_652;
    public boolean aBoolean653;
    public byte[][][] levelRenderFlags;
    public boolean aBoolean655;
    public byte aByte656;
    public LinkedList aLinkedList_657;
    public int anInt658;
    public int anInt659;
    public boolean aBoolean660;
    public boolean aBoolean661;
    public int[] anIntArray662;
    public static boolean aBoolean663 = true;
    public LinkedList[][][] aLinkedListArrayArrayArray665;
    public String aString666;
    public int anInt667;
    public int anInt668;
    public int anInt669;
    public int anInt670;
    public int anInt671;
    public Font p11;
    public Font p12;
    public Font b12;
    public Font q8;
    public static int anInt676 = 460;
    public int anInt677;
    public static int[] anIntArray678;
    public byte aByte679;
    public byte aByte680;
    public boolean aBoolean681;
    public boolean aBoolean682;
    public int anInt683;
    public int anInt684;
    public long[] aLongArray685;
    public int anInt686;
    public Sprite aSprite_687;
    public Sprite aSprite_688;
    public int anInt689;
    public int anInt690;
    public IndexedSprite aClass35_Sub2_Sub2_Sub3_691;
    public IndexedSprite aClass35_Sub2_Sub2_Sub3_692;
    public IndexedSprite aClass35_Sub2_Sub2_Sub3_693;
    public static BigInteger RSA_MODULUS = new BigInteger("7162900525229798032761816791230527296329313291232324290237849263501208207972894053929065636522363163621000728841182238772712427862772219676577293600221789");
    public String aString695;
    public byte aByte696;
    public int[] tabComponentId = {
            -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
            -1, -1, -1, -1, -1
    };
    public PlayerEntity self;
    public int anInt699;
    public int anInt700;
    public String[] aStringArray701;
    public int anInt702;
    public int anInt703;
    public boolean aBoolean704;
    public byte aByte705;
    public int anInt706;
    public int anInt707;
    public int anInt708;
    public String aString709;
    public int anInt710;
    public int anInt711;
    public int anInt712;
    public int anInt713;
    public int anInt714;
    public int anInt715;
    public String aString716;
    public int[] archiveChecksums;
    public IndexedSprite[] aClass35_Sub2_Sub2_Sub3Array718;
    public int anInt719;
    public String[] aStringArray720;
    public int[] anIntArray721;
    public int anInt722;
    public int[] anIntArray723;
    public int[] anIntArray724;
    public int[][][] anIntArrayArrayArray725;
    public boolean aBoolean726;
    public IndexedSprite aClass35_Sub2_Sub2_Sub3_727;
    public IndexedSprite aClass35_Sub2_Sub2_Sub3_728;
    public IndexedSprite aClass35_Sub2_Sub2_Sub3_729;
    public IndexedSprite aClass35_Sub2_Sub2_Sub3_730;
    public IndexedSprite aClass35_Sub2_Sub2_Sub3_731;
    public FileArchive title;
    public int anInt733;
    public boolean aBoolean734;
    public int anInt735;
    public int anInt736;
    public CollisionMap[] aCollisionMapArray737;
    public int anInt738;
    public boolean aBoolean739;
    public boolean aBoolean740;
    public MapSquare aMapSquare_741;
    public int anInt742;
    public String aString743;
    public String aString744;
    public String aString745;
    public LinkedList aLinkedList_746;
    public boolean sidebarRedraw;
    public int anInt748;
    public int anInt749;
    public int anInt750;
    public PlayerEntity[] aPlayerEntityArray751;
    public int anInt752;
    public int[] anIntArray753;
    public int anInt754;
    public int[] anIntArray755;
    public Buffer[] aClass35_Sub2_Sub3Array756;
    public int anInt757;
    public int anInt758;
    public static int anInt759;
    public static String aString760 = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"\243$%^&*()-_=+[{]};:'@#~,<.>/?\\| ";
    public boolean aBoolean761;
    public int anInt762;
    public boolean aBoolean763;
    public BufferedStream stream;
    public boolean[] aBooleanArray765;
    public int anInt766;
    public int anInt767;
    public int[] anIntArray768;
    public int[] anIntArray769;
    public boolean aBoolean770;
    public int anInt771;
    public int anInt772;
    public int anInt773;
    public int anInt774;
    public int anInt775;
    public int anInt776;
    public int[] anIntArray777;
    public int anInt778;
    public int anInt779;
    public int anInt780;
    public int anInt781;
    public int anInt782;
    public int[] anIntArray783;
    public String aString784;
    public byte aByte785;
    public static BigInteger RSA_EXPONENT = new BigInteger("58778699976184461502525193738213253649000149147835990136706041084440742975821");
    public int[] anIntArray787;
    public static boolean aBoolean788;
    public int[] anIntArray789;
    public int anInt790;
    public int anInt791;
    public int anInt792;
    public int anInt793;
    public int anInt794;
    public int[] anIntArray795;
    public int[] anIntArray796;
    public int[] anIntArray797;
    public int[] anIntArray798;
    public int[] anIntArray799;
    public int[] anIntArray800;
    public int[] anIntArray801;
    public int anInt802;
    public int anInt803;
    public int anInt804;
    public int anInt805;
    public int anInt806;
    public int anInt807;
    public static int anInt808;
    public int anInt809;
    public int packetLength;
    public int packetOpcode;
    public int anInt812;
    public int anInt813;
    public String[] aStringArray814;
    public int[] anIntArray815;
    public int anInt816;
    public int anInt817;
    public int anInt818;
    public int anInt819;
    public int anInt820;
    public int anInt821;
    public int[] anIntArray822;
    public int anInt823;
    public Sprite aSprite_824;
    public Sprite aSprite_825;
    public Sprite aSprite_826;
    public Sprite aSprite_827;
    public static boolean aBoolean828;
    public int[] anIntArray829;
    public final int anInt830 = 100;
    public int[] anIntArray831;
    public boolean errorLoading;
    public int anInt833;
    public int[] anIntArray834;
    public static boolean aBoolean835 = true;
    public Sprite aSprite_836;
    public Sprite aSprite_837;
    public boolean aBoolean838;
    public int anInt839;
    public int[] anIntArray840;
    public static int anInt841;
    public long serverSeed;
    public Sprite[] aSpriteArray843;
    public int anInt844;
    public int anInt845;
    public int[] anIntArray846;
    public int[] anIntArray847;
    public int[] anIntArray848;
    public int[] anIntArray849;
    public byte[] aByteArray850;
    public int anInt851;
    public int anInt852;
    public int anInt853;
    public int[] anIntArray854;
    public int anInt855;
    public int anInt856;
    public int anInt857;
    public int anInt858;
    public int[][] anIntArrayArray859;
    public int[] anIntArray860 = {
            0xffff00, 0xff0000, 65280, 65535, 0xff00ff, 0xffffff
    };
    public int anInt861;
    public int[] anIntArray862;
    public LinkedList aLinkedList_863;
    public int anInt864;
    public int anInt865;
    public int anInt866;
    public int anInt867;
    public int anInt868;
    public int[] anIntArray869;
    public String[] aStringArray870;
    public int anInt871;
    public IndexedSprite aClass35_Sub2_Sub2_Sub3_872;
    public IndexedSprite aClass35_Sub2_Sub2_Sub3_873;
    public int anInt874;
    public int anInt875;
    public int anInt876;
    public Sprite[] aSpriteArray877;
    public int anInt878;
    public int[][] anIntArrayArray879;
    public byte[][] aByteArrayArray880;
    public int anInt881;
    public int anInt882;
    public int[] anIntArray883;
    public Sprite[] aSpriteArray884;
    public Component aComponent_885;
    public byte aByte886;
    public String aString887;
    public boolean aBoolean888;
    public FrameBuffer aFrameBuffer_889;
    public FrameBuffer aFrameBuffer_890;
    public FrameBuffer aFrameBuffer_891;
    public FrameBuffer aFrameBuffer_892;
    public FrameBuffer aFrameBuffer_893;
    public FrameBuffer aFrameBuffer_894;
    public FrameBuffer aFrameBuffer_895;
    public FrameBuffer aFrameBuffer_896;
    public FrameBuffer aFrameBuffer_897;
    public Sprite aSprite_898;
    public int anInt899;
    public final int[] anIntArray900 = {
            0, 0, 0, 0, 1, 1, 1, 1, 1, 2,
            2, 2, 2, 2, 2, 2, 2, 2, 2, 2,
            2, 2, 3
    };
    public Buffer inBuffer;
    public int anInt902;
    public int anInt903;
    public int anInt904;
    public int anInt905;
    public boolean aBoolean906;
    public int anInt907;
    public boolean aBoolean908;
    public int anInt909;
    public int anInt910;
    public int[][] anIntArrayArray911;
    public int anInt912;
    public int anInt913;
    public IndexedSprite[] aClass35_Sub2_Sub2_Sub3Array914;
    public int anInt915;
    public boolean errorHost;
    public int nodeOffset;
    public int anInt918;
    public int anInt919;
    public int anInt920;
    public int anInt921;
    public int anInt922;
    public int anInt923;
    public int anInt924;
    public int anInt925;
    public int anInt926;
    public int anInt927;
    public int anInt928;
    public int anInt929;
    public byte aByte930;
    public int anInt931;
    public int anInt932;
    public int anInt933;
    public int[] anIntArray934;
    public int[] anIntArray935;
    public int[] anIntArray936;
    public Buffer loginBuffer;
    public FrameBuffer aFrameBuffer_939;
    public FrameBuffer aFrameBuffer_940;
    public FrameBuffer aFrameBuffer_941;
    public int anInt942;
    public LinkedList aLinkedList_943;
    public IndexedSprite aClass35_Sub2_Sub2_Sub3_944;
    public IndexedSprite aClass35_Sub2_Sub2_Sub3_945;
    public IndexedSprite aClass35_Sub2_Sub2_Sub3_946;
    public String aString947;
    public int[] anIntArray948;
    public int[] anIntArray949;
    public byte aByte950;
    public int anInt951;
    public int anInt952;
    public int anInt953;
    public Sprite aSprite_954;
    public int anInt955;
    public int[] anIntArray956;
    public int[] anIntArray957;
    public Sprite[] aSpriteArray958;
    public Buffer outBuffer;
    public IndexedSprite aClass35_Sub2_Sub2_Sub3_960;
    public IndexedSprite aClass35_Sub2_Sub2_Sub3_961;
    public int anInt962;
    public byte[][] aByteArrayArray963;
    public NpcEntity[] aClass35_Sub7_Sub3_Sub1Array964;
    public int anInt965;
    public int[] anIntArray966;
    public int[] anIntArray967;
    public int anInt968;
    public int anInt969;
    public boolean aBoolean970;
    public long[] aLongArray971;
    public boolean errorStarted;
    public String aString973;
    public String aString974;
    public int anInt975;
    public int anInt976;
    public boolean aBoolean977;
    public IndexedSprite aClass35_Sub2_Sub2_Sub3_978;
    public IndexedSprite aClass35_Sub2_Sub2_Sub3_979;
    public Sprite[] aSpriteArray980;
    public int anInt981;
    public FrameBuffer aFrameBuffer_982;
    public FrameBuffer aFrameBuffer_983;
    public FrameBuffer aFrameBuffer_984;
    public FrameBuffer aFrameBuffer_985;
    public FrameBuffer aFrameBuffer_986;
    public FrameBuffer aFrameBuffer_987;
    public FrameBuffer aFrameBuffer_988;
    public FrameBuffer aFrameBuffer_989;
    public FrameBuffer aFrameBuffer_990;
    public FrameBuffer aFrameBuffer_991;
    public boolean aBoolean992;
    public String aString993;

    static {
        anIntArray678 = new int[99];
        int i = 0;
        for (int j = 0; j < 99; j++) {
            int k = j + 1;
            int l = (int) ((double) k + 300D * Math.pow(2D, (double) k / 7D));
            i += l;
            anIntArray678[j] = i / 4;
        }

    }
}
