package com.jagex.game.runetek3.scenegraph;

// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

import com.jagex.core.io.Buffer;
import com.jagex.core.utils.LinkedList;
import com.jagex.game.runetek3.config.FloType;
import com.jagex.game.runetek3.config.LocType;
import com.jagex.game.runetek3.config.SeqType;
import com.jagex.game.runetek3.entity.LocEntity;
import com.jagex.game.runetek3.graphics.Draw3D;
import com.jagex.game.runetek3.graphics.model.Model;

public class Scene {

    public Scene(byte[][][] abyte0, int i, int j, int[][][] ai, int k) {
        aByte46 = 80;
        anInt50 = i;
        anInt51 = j;
        k = 89 / k;
        anIntArrayArrayArray52 = ai;
        aByteArrayArrayArray53 = abyte0;
        aByteArrayArrayArray54 = new byte[4][anInt50][anInt51];
        aByteArrayArrayArray55 = new byte[4][anInt50][anInt51];
        aByteArrayArrayArray56 = new byte[4][anInt50][anInt51];
        aByteArrayArrayArray57 = new byte[4][anInt50][anInt51];
        anIntArrayArrayArray65 = new int[4][anInt50 + 1][anInt51 + 1];
        aByteArrayArrayArray58 = new byte[4][anInt50 + 1][anInt51 + 1];
        anIntArrayArray59 = new int[anInt50 + 1][anInt51 + 1];
        anIntArray60 = new int[anInt51];
        anIntArray61 = new int[anInt51];
        anIntArray62 = new int[anInt51];
        anIntArray63 = new int[anInt51];
        anIntArray64 = new int[anInt51];
    }

    public void method133(int i, int j, int k, int l, int i1) {
        i = 88 / i;
        byte byte0 = 0;
        for (int j1 = 0; j1 < FloType.anInt70; j1++) {
            if (!FloType.aFloTypeArray71[j1].aString76.equalsIgnoreCase("water"))
                continue;
            byte0 = (byte) (j1 + 1);
            break;
        }

        for (int k1 = j; k1 < j + k; k1++) {
            for (int l1 = l; l1 < l + i1; l1++)
                if (l1 >= 0 && l1 < anInt50 && k1 >= 0 && k1 < anInt51) {
                    aByteArrayArrayArray55[0][l1][k1] = byte0;
                    for (int i2 = 0; i2 < 4; i2++) {
                        anIntArrayArrayArray52[i2][l1][k1] = 0;
                        aByteArrayArrayArray53[i2][l1][k1] = 0;
                    }

                }

        }

    }

    public void method134(int i, int j, int k, int l, byte[] abyte0, int i1) {
        Buffer class35_sub2_sub3;
        for (class35_sub2_sub3 = new Buffer(abyte0); j >= 0; )
            return;

        for (int j1 = 0; j1 < 4; j1++) {
            for (int k1 = 0; k1 < 64; k1++) {
                for (int l1 = 0; l1 < 64; l1++) {
                    int i2 = k1 + i1;
                    int j2 = l1 + i;
                    if (i2 >= 0 && i2 < 104 && j2 >= 0 && j2 < 104) {
                        aByteArrayArrayArray53[j1][i2][j2] = 0;
                        do {
                            int k2 = class35_sub2_sub3.g1();
                            if (k2 == 0) {
                                if (j1 == 0)
                                    anIntArrayArrayArray52[0][i2][j2] = -method138(0xe3b7b + i2 + k, 0x87cce + j2 + l) * 8;
                                else
                                    anIntArrayArrayArray52[j1][i2][j2] = anIntArrayArrayArray52[j1 - 1][i2][j2] - 240;
                                break;
                            }
                            if (k2 == 1) {
                                int i3 = class35_sub2_sub3.g1();
                                if (i3 == 1)
                                    i3 = 0;
                                if (j1 == 0)
                                    anIntArrayArrayArray52[0][i2][j2] = -i3 * 8;
                                else
                                    anIntArrayArrayArray52[j1][i2][j2] = anIntArrayArrayArray52[j1 - 1][i2][j2] - i3 * 8;
                                break;
                            }
                            if (k2 <= 49) {
                                aByteArrayArrayArray55[j1][i2][j2] = class35_sub2_sub3.g1b();
                                aByteArrayArrayArray56[j1][i2][j2] = (byte) ((k2 - 2) / 4);
                                aByteArrayArrayArray57[j1][i2][j2] = (byte) (k2 - 2 & 3);
                            } else if (k2 <= 81)
                                aByteArrayArrayArray53[j1][i2][j2] = (byte) (k2 - 49);
                            else
                                aByteArrayArrayArray54[j1][i2][j2] = (byte) (k2 - 81);
                        } while (true);
                    } else {
                        do {
                            int l2 = class35_sub2_sub3.g1();
                            if (l2 == 0)
                                break;
                            if (l2 == 1) {
                                class35_sub2_sub3.g1();
                                break;
                            }
                            if (l2 <= 49)
                                class35_sub2_sub3.g1();
                        } while (true);
                    }
                }

            }

        }

    }

    public void method135(byte[] abyte0, byte byte0, MapSquare class29, CollisionMap[] aclass2, int i, int j, LinkedList class24) {
        label0:
        {
            Buffer class35_sub2_sub3 = new Buffer(abyte0);
            if (byte0 != 4) {
                for (int k = 1; k > 0; k++) ;
            }
            int l = -1;
            do {
                int i1 = class35_sub2_sub3.gsmarts();
                if (i1 == 0)
                    break label0;
                l += i1;
                int j1 = 0;
                do {
                    int k1 = class35_sub2_sub3.gsmarts();
                    if (k1 == 0)
                        break;
                    j1 += k1 - 1;
                    int l1 = j1 & 0x3f;
                    int i2 = j1 >> 6 & 0x3f;
                    int j2 = j1 >> 12;
                    int k2 = class35_sub2_sub3.g1();
                    int l2 = k2 >> 2;
                    int i3 = k2 & 3;
                    int j3 = i2 + j;
                    int k3 = l1 + i;
                    if (j3 > 0 && k3 > 0 && j3 < 103 && k3 < 103)
                        method136(l, i3, k3, l2, anInt44, aclass2[j2], j3, j2, class24, class29);
                } while (true);
            } while (true);
        }
    }

    public void method136(int i, int j, int k, int l, int i1, CollisionMap class2, int j1,
                          int k1, LinkedList class24, MapSquare class29) {
        if (aBoolean47) {
            int l1 = k1;
            if (l1 > 0 && (aByteArrayArrayArray53[1][j1][k] & 2) != 0)
                l1--;
            if ((aByteArrayArrayArray53[k1][j1][k] & 8) != 0)
                l1 = 0;
            if (l1 != anInt48)
                return;
            if ((aByteArrayArrayArray53[k1][j1][k] & 0x10) != 0)
                return;
        }
        int i2 = anIntArrayArrayArray52[k1][j1][k];
        int j2 = anIntArrayArrayArray52[k1][j1 + 1][k];
        int k2 = anIntArrayArrayArray52[k1][j1 + 1][k + 1];
        int l2 = anIntArrayArrayArray52[k1][j1][k + 1];
        if (i1 != 0)
            return;
        int i3 = i2 + j2 + k2 + l2 >> 2;
        LocType class39 = LocType.method428(i);
        int j3 = j1 + (k << 7) + (i << 14) + 0x40000000;
        if (!class39.aBoolean546)
            j3 += 0x80000000;
        byte byte0 = (byte) ((j << 6) + l);
        if (l == 22) {
            if (aBoolean47 && !class39.aBoolean546 && !class39.aBoolean567)
                return;
            Model class35_sub2_sub1 = class39.method431(22, j, i2, j2, k2, l2, -1);
            class29.method244(j3, k, byte0, class35_sub2_sub1, j1, i3, true, k1);
            if (class39.aBoolean544 && class39.aBoolean546)
                class2.method124(2, k, j1);
            return;
        }
        if (l == 10 || l == 11) {
            Model class35_sub2_sub1_1 = class39.method431(10, j, i2, j2, k2, l2, -1);
            if (class35_sub2_sub1_1 != null) {
                int l4 = 0;
                if (l == 11)
                    l4 += 256;
                int i4;
                int k4;
                if (j == 1 || j == 3) {
                    i4 = class39.anInt543;
                    k4 = class39.anInt542;
                } else {
                    i4 = class39.anInt542;
                    k4 = class39.anInt543;
                }
                if (class29.method248(class35_sub2_sub1_1, byte0, null, i3, j1, k4, i4, k1, j3, k, 0, l4) && class39.aBoolean559) {
                    for (int i5 = 0; i5 <= i4; i5++) {
                        for (int j5 = 0; j5 <= k4; j5++) {
                            int k5 = class35_sub2_sub1_1.anInt1075 / 4;
                            if (k5 > 30)
                                k5 = 30;
                            if (k5 > aByteArrayArrayArray58[k1][j1 + i5][k + j5])
                                aByteArrayArrayArray58[k1][j1 + i5][k + j5] = (byte) k5;
                        }

                    }

                }
            }
            if (class39.aBoolean544)
                class2.method123(j1, class39.anInt543, class39.aBoolean545, class39.anInt542, -532, k, j);
            if (class39.anInt550 != -1)
                class24.pushNext(new LocEntity(2, -69, k1, i, true, SeqType.aSeqTypeArray190[class39.anInt550], k, j1));
            return;
        }
        if (l >= 12) {
            Model class35_sub2_sub1_2 = class39.method431(l, j, i2, j2, k2, l2, -1);
            class29.method248(class35_sub2_sub1_2, byte0, null, i3, j1, 1, 1, k1, j3, k, 0, 0);
            if (l >= 12 && l <= 17 && l != 13 && k1 > 0)
                anIntArrayArrayArray65[k1][j1][k] |= 0x924;
            if (class39.aBoolean544)
                class2.method123(j1, class39.anInt543, class39.aBoolean545, class39.anInt542, -532, k, j);
            if (class39.anInt550 != -1)
                class24.pushNext(new LocEntity(2, -69, k1, i, true, SeqType.aSeqTypeArray190[class39.anInt550], k, j1));
            return;
        }
        if (l == 0) {
            Model class35_sub2_sub1_3 = class39.method431(0, j, i2, j2, k2, l2, -1);
            class29.method246(431, j3, 0, i3, class35_sub2_sub1_3, k, j1, null, byte0, anIntArray66[j], k1);
            if (j == 0) {
                if (class39.aBoolean559) {
                    aByteArrayArrayArray58[k1][j1][k] = 50;
                    aByteArrayArrayArray58[k1][j1][k + 1] = 50;
                }
                if (class39.aBoolean549)
                    anIntArrayArrayArray65[k1][j1][k] |= 0x249;
            } else if (j == 1) {
                if (class39.aBoolean559) {
                    aByteArrayArrayArray58[k1][j1][k + 1] = 50;
                    aByteArrayArrayArray58[k1][j1 + 1][k + 1] = 50;
                }
                if (class39.aBoolean549)
                    anIntArrayArrayArray65[k1][j1][k + 1] |= 0x492;
            } else if (j == 2) {
                if (class39.aBoolean559) {
                    aByteArrayArrayArray58[k1][j1 + 1][k] = 50;
                    aByteArrayArrayArray58[k1][j1 + 1][k + 1] = 50;
                }
                if (class39.aBoolean549)
                    anIntArrayArrayArray65[k1][j1 + 1][k] |= 0x249;
            } else if (j == 3) {
                if (class39.aBoolean559) {
                    aByteArrayArrayArray58[k1][j1][k] = 50;
                    aByteArrayArrayArray58[k1][j1 + 1][k] = 50;
                }
                if (class39.aBoolean549)
                    anIntArrayArrayArray65[k1][j1][k] |= 0x492;
            }
            if (class39.aBoolean544)
                class2.method122(l, k, j, j1, 757, class39.aBoolean545);
            if (class39.anInt550 != -1)
                class24.pushNext(new LocEntity(0, -69, k1, i, true, SeqType.aSeqTypeArray190[class39.anInt550], k, j1));
            return;
        }
        if (l == 1) {
            Model class35_sub2_sub1_4 = class39.method431(1, j, i2, j2, k2, l2, -1);
            class29.method246(431, j3, 0, i3, class35_sub2_sub1_4, k, j1, null, byte0, anIntArray67[j], k1);
            if (class39.aBoolean559)
                if (j == 0)
                    aByteArrayArrayArray58[k1][j1][k + 1] = 50;
                else if (j == 1)
                    aByteArrayArrayArray58[k1][j1 + 1][k + 1] = 50;
                else if (j == 2)
                    aByteArrayArrayArray58[k1][j1 + 1][k] = 50;
                else if (j == 3)
                    aByteArrayArrayArray58[k1][j1][k] = 50;
            if (class39.aBoolean544)
                class2.method122(l, k, j, j1, 757, class39.aBoolean545);
            if (class39.anInt550 != -1)
                class24.pushNext(new LocEntity(0, -69, k1, i, true, SeqType.aSeqTypeArray190[class39.anInt550], k, j1));
            return;
        }
        if (l == 2) {
            int k3 = j + 1 & 3;
            Model class35_sub2_sub1_11 = class39.method431(2, 4 + j, i2, j2, k2, l2, -1);
            Model class35_sub2_sub1_12 = class39.method431(2, k3, i2, j2, k2, l2, -1);
            class29.method246(431, j3, anIntArray66[k3], i3, class35_sub2_sub1_11, k, j1, class35_sub2_sub1_12, byte0, anIntArray66[j], k1);
            if (class39.aBoolean549)
                if (j == 0) {
                    anIntArrayArrayArray65[k1][j1][k] |= 0x249;
                    anIntArrayArrayArray65[k1][j1][k + 1] |= 0x492;
                } else if (j == 1) {
                    anIntArrayArrayArray65[k1][j1][k + 1] |= 0x492;
                    anIntArrayArrayArray65[k1][j1 + 1][k] |= 0x249;
                } else if (j == 2) {
                    anIntArrayArrayArray65[k1][j1 + 1][k] |= 0x249;
                    anIntArrayArrayArray65[k1][j1][k] |= 0x492;
                } else if (j == 3) {
                    anIntArrayArrayArray65[k1][j1][k] |= 0x492;
                    anIntArrayArrayArray65[k1][j1][k] |= 0x249;
                }
            if (class39.aBoolean544)
                class2.method122(l, k, j, j1, 757, class39.aBoolean545);
            return;
        }
        if (l == 3) {
            Model class35_sub2_sub1_5 = class39.method431(3, j, i2, j2, k2, l2, -1);
            class29.method246(431, j3, 0, i3, class35_sub2_sub1_5, k, j1, null, byte0, anIntArray67[j], k1);
            if (class39.aBoolean559)
                if (j == 0)
                    aByteArrayArrayArray58[k1][j1][k + 1] = 50;
                else if (j == 1)
                    aByteArrayArrayArray58[k1][j1 + 1][k + 1] = 50;
                else if (j == 2)
                    aByteArrayArrayArray58[k1][j1 + 1][k] = 50;
                else if (j == 3)
                    aByteArrayArrayArray58[k1][j1][k] = 50;
            if (class39.aBoolean544)
                class2.method122(l, k, j, j1, 757, class39.aBoolean545);
            if (class39.anInt550 != -1)
                class24.pushNext(new LocEntity(0, -69, k1, i, true, SeqType.aSeqTypeArray190[class39.anInt550], k, j1));
            return;
        }
        if (l == 9) {
            Model class35_sub2_sub1_6 = class39.method431(l, j, i2, j2, k2, l2, -1);
            class29.method248(class35_sub2_sub1_6, byte0, null, i3, j1, 1, 1, k1, j3, k, 0, 0);
            if (class39.aBoolean544)
                class2.method123(j1, class39.anInt543, class39.aBoolean545, class39.anInt542, -532, k, j);
            if (class39.anInt550 != -1)
                class24.pushNext(new LocEntity(2, -69, k1, i, true, SeqType.aSeqTypeArray190[class39.anInt550], k, j1));
            return;
        }
        if (l == 4) {
            Model class35_sub2_sub1_7 = class39.method431(4, 0, i2, j2, k2, l2, -1);
            class29.method247(j1, byte0, i3, 0, j3, anIntArray66[j], 414, j * 512, 0, class35_sub2_sub1_7, k, k1);
            if (class39.anInt550 != -1)
                class24.pushNext(new LocEntity(1, -69, k1, i, true, SeqType.aSeqTypeArray190[class39.anInt550], k, j1));
            return;
        }
        if (l == 5) {
            int l3 = 16;
            int j4 = class29.method262(k1, j1, k);
            if (j4 > 0)
                l3 = LocType.method428(j4 >> 14 & 0x7fff).anInt551;
            Model class35_sub2_sub1_13 = class39.method431(4, 0, i2, j2, k2, l2, -1);
            class29.method247(j1, byte0, i3, anIntArray69[j] * l3, j3, anIntArray66[j], 414, j * 512, anIntArray68[j] * l3, class35_sub2_sub1_13, k, k1);
            if (class39.anInt550 != -1)
                class24.pushNext(new LocEntity(1, -69, k1, i, true, SeqType.aSeqTypeArray190[class39.anInt550], k, j1));
            return;
        }
        if (l == 6) {
            Model class35_sub2_sub1_8 = class39.method431(4, 0, i2, j2, k2, l2, -1);
            class29.method247(j1, byte0, i3, 0, j3, 256, 414, j, 0, class35_sub2_sub1_8, k, k1);
            if (class39.anInt550 != -1)
                class24.pushNext(new LocEntity(1, -69, k1, i, true, SeqType.aSeqTypeArray190[class39.anInt550], k, j1));
            return;
        }
        if (l == 7) {
            Model class35_sub2_sub1_9 = class39.method431(4, 0, i2, j2, k2, l2, -1);
            class29.method247(j1, byte0, i3, 0, j3, 512, 414, j, 0, class35_sub2_sub1_9, k, k1);
            if (class39.anInt550 != -1)
                class24.pushNext(new LocEntity(1, -69, k1, i, true, SeqType.aSeqTypeArray190[class39.anInt550], k, j1));
            return;
        }
        if (l == 8) {
            Model class35_sub2_sub1_10 = class39.method431(4, 0, i2, j2, k2, l2, -1);
            class29.method247(j1, byte0, i3, 0, j3, 768, 414, j, 0, class35_sub2_sub1_10, k, k1);
            if (class39.anInt550 != -1)
                class24.pushNext(new LocEntity(1, -69, k1, i, true, SeqType.aSeqTypeArray190[class39.anInt550], k, j1));
        }
    }

    public void method137(MapSquare class29, boolean flag, CollisionMap[] aclass2) {
        CollisionMap class2 = null;
        for (int i = 0; i < 4; i++) {
            CollisionMap class2_1 = aclass2[i];
            for (int k = 0; k < 104; k++) {
                for (int i1 = 0; i1 < 104; i1++) {
                    if ((aByteArrayArrayArray53[i][k][i1] & 1) == 1)
                        class2_1.method124(2, i1, k);
                    if (i > 0 && (aByteArrayArrayArray53[1][k][i1] & 2) == 2)
                        class2.anIntArrayArray43[k][i1] = class2_1.anIntArrayArray43[k][i1];
                }

            }

            class2 = class2_1;
        }

        for (int j = 0; j < 4; j++) {
            byte[][] abyte0 = aByteArrayArrayArray58[j];
            byte byte0 = 96;
            char c = '\u0300';
            byte byte1 = -50;
            byte byte2 = -10;
            byte byte3 = -50;
            int l2 = (int) Math.sqrt(byte1 * byte1 + byte2 * byte2 + byte3 * byte3);
            int j3 = c * l2 >> 8;
            for (int l3 = 1; l3 < anInt51 - 1; l3++) {
                for (int l4 = 1; l4 < anInt50 - 1; l4++) {
                    int i6 = anIntArrayArrayArray52[j][l4 + 1][l3] - anIntArrayArrayArray52[j][l4 - 1][l3];
                    int j7 = anIntArrayArrayArray52[j][l4][l3 + 1] - anIntArrayArrayArray52[j][l4][l3 - 1];
                    int l8 = (int) Math.sqrt(i6 * i6 + 0x10000 + j7 * j7);
                    int i12 = (i6 << 8) / l8;
                    int k13 = 0x10000 / l8;
                    int i15 = (j7 << 8) / l8;
                    int i16 = byte0 + (byte1 * i12 + byte2 * k13 + byte3 * i15) / j3;
                    int i17 = (abyte0[l4 - 1][l3] >> 2) + (abyte0[l4 + 1][l3] >> 3) + (abyte0[l4][l3 - 1] >> 2) + (abyte0[l4][l3 + 1] >> 3) + (abyte0[l4][l3] >> 1);
                    anIntArrayArray59[l4][l3] = i16 - i17;
                }

            }

            for (int i5 = 0; i5 < anInt51; i5++) {
                anIntArray60[i5] = 0;
                anIntArray61[i5] = 0;
                anIntArray62[i5] = 0;
                anIntArray63[i5] = 0;
                anIntArray64[i5] = 0;
            }

            for (int j6 = -5; j6 < anInt50 + 5; j6++) {
                for (int k7 = 0; k7 < anInt51; k7++) {
                    int i9 = j6 + 5;
                    if (i9 >= 0 && i9 < anInt50) {
                        int j12 = aByteArrayArrayArray54[j][i9][k7] & 0xff;
                        if (j12 > 0) {
                            FloType class4 = FloType.aFloTypeArray71[j12 - 1];
                            anIntArray60[k7] += class4.anInt80;
                            anIntArray61[k7] += class4.anInt78;
                            anIntArray62[k7] += class4.anInt79;
                            anIntArray63[k7] += class4.anInt81;
                            anIntArray64[k7]++;
                        }
                    }
                    int k12 = j6 - 5;
                    if (k12 >= 0 && k12 < anInt50) {
                        int l13 = aByteArrayArrayArray54[j][k12][k7] & 0xff;
                        if (l13 > 0) {
                            FloType class4_1 = FloType.aFloTypeArray71[l13 - 1];
                            anIntArray60[k7] -= class4_1.anInt80;
                            anIntArray61[k7] -= class4_1.anInt78;
                            anIntArray62[k7] -= class4_1.anInt79;
                            anIntArray63[k7] -= class4_1.anInt81;
                            anIntArray64[k7]--;
                        }
                    }
                }

                if (j6 >= 1 && j6 < anInt50 - 1) {
                    int j9 = 0;
                    int l12 = 0;
                    int i14 = 0;
                    int j15 = 0;
                    int j16 = 0;
                    for (int j17 = -5; j17 < anInt51 + 5; j17++) {
                        int i18 = j17 + 5;
                        if (i18 >= 0 && i18 < anInt51) {
                            j9 += anIntArray60[i18];
                            l12 += anIntArray61[i18];
                            i14 += anIntArray62[i18];
                            j15 += anIntArray63[i18];
                            j16 += anIntArray64[i18];
                        }
                        int j18 = j17 - 5;
                        if (j18 >= 0 && j18 < anInt51) {
                            j9 -= anIntArray60[j18];
                            l12 -= anIntArray61[j18];
                            i14 -= anIntArray62[j18];
                            j15 -= anIntArray63[j18];
                            j16 -= anIntArray64[j18];
                        }
                        if (j17 < 1 || j17 >= anInt51 - 1)
                            continue;
                        if (aBoolean47) {
                            int k18 = j;
                            if (j > 0 && (aByteArrayArrayArray53[1][j6][j17] & 2) != 0)
                                k18--;
                            if ((aByteArrayArrayArray53[j][j6][j17] & 8) != 0)
                                k18 = 0;
                            if (k18 != anInt48 || (aByteArrayArrayArray53[j][j6][j17] & 0x10) != 0)
                                continue;
                        }
                        int l18 = aByteArrayArrayArray54[j][j6][j17] & 0xff;
                        int i19 = aByteArrayArrayArray55[j][j6][j17] & 0xff;
                        if (l18 > 0 || i19 > 0) {
                            int j19 = anIntArrayArrayArray52[j][j6][j17];
                            int k19 = anIntArrayArrayArray52[j][j6 + 1][j17];
                            int l19 = anIntArrayArrayArray52[j][j6 + 1][j17 + 1];
                            int i20 = anIntArrayArrayArray52[j][j6][j17 + 1];
                            int j20 = anIntArrayArray59[j6][j17];
                            int k20 = anIntArrayArray59[j6 + 1][j17];
                            int l20 = anIntArrayArray59[j6 + 1][j17 + 1];
                            int i21 = anIntArrayArray59[j6][j17 + 1];
                            int j21 = -1;
                            if (l18 > 0)
                                j21 = method145((j9 * 256) / j15, l12 / j16, i14 / j16);
                            if (j > 0) {
                                boolean flag1 = l18 != 0 || aByteArrayArrayArray56[j][j6][j17] == 0;
                                if (i19 > 0 && !FloType.aFloTypeArray71[i19 - 1].aBoolean75)
                                    flag1 = false;
                                if (flag1 && j19 == k19 && j19 == l19 && j19 == i20)
                                    anIntArrayArrayArray65[j][j6][j17] |= 0x924;
                            }
                            int k21 = 0;
                            if (j21 != -1)
                                k21 = Draw3D.anIntArray1283[method143(j21, 96)];
                            if (i19 == 0) {
                                class29.method243(j, j6, j17, 0, 0, -1, j19, k19, l19, i20, method143(j21, j20), method143(j21, k20), method143(j21, l20), method143(j21, i21), 0, 0, 0, 0, k21, 0);
                            } else {
                                int l21 = aByteArrayArrayArray56[j][j6][j17] + 1;
                                byte byte4 = aByteArrayArrayArray57[j][j6][j17];
                                FloType class4_2 = FloType.aFloTypeArray71[i19 - 1];
                                int i22 = class4_2.anInt73;
                                int j22;
                                int k22;
                                if (i22 >= 0) {
                                    k22 = Draw3D.method343((byte) -29, i22);
                                    j22 = -1;
                                } else if (class4_2.anInt72 == 0xff00ff) {
                                    k22 = 0;
                                    j22 = -2;
                                    i22 = -1;
                                } else {
                                    j22 = method145(class4_2.anInt77, class4_2.anInt78, class4_2.anInt79);
                                    k22 = Draw3D.anIntArray1283[method144(j22, 96)];
                                }
                                class29.method243(j, j6, j17, l21, byte4, i22, j19, k19, l19, i20, method143(j21, j20), method143(j21, k20), method143(j21, l20), method143(j21, i21), method144(j22, j20), method144(j22, k20), method144(j22, l20), method144(j22, i21), k21, k22);
                            }
                        }
                    }

                }
            }

            for (int l7 = 1; l7 < anInt51 - 1; l7++) {
                for (int k9 = 1; k9 < anInt50 - 1; k9++) {
                    int i13 = j;
                    if (i13 > 0 && (aByteArrayArrayArray53[1][k9][l7] & 2) != 0)
                        i13--;
                    if ((aByteArrayArrayArray53[j][k9][l7] & 8) != 0)
                        i13 = 0;
                    class29.method242(j, k9, l7, i13);
                }

            }

        }

        if (!aBoolean49)
            class29.method267(64, 768, -10, -50, -50, 0);
        for (int l = 0; l < anInt50; l++) {
            for (int j1 = 0; j1 < anInt51; j1++)
                if ((aByteArrayArrayArray53[1][l][j1] & 2) == 2)
                    class29.method240(j1, l, 9);

        }

        if (aBoolean49)
            return;
        int k1 = 1;
        int l1 = 2;
        int i2 = 4;
        for (int j2 = 0; j2 < 4; j2++) {
            if (j2 > 0) {
                k1 <<= 3;
                l1 <<= 3;
                i2 <<= 3;
            }
            for (int k2 = 0; k2 <= j2; k2++) {
                for (int i3 = 0; i3 <= anInt51; i3++) {
                    for (int k3 = 0; k3 <= anInt50; k3++) {
                        if ((anIntArrayArrayArray65[k2][k3][i3] & k1) != 0) {
                            int i4 = i3;
                            int j5 = i3;
                            int k6 = k2;
                            int i8 = k2;
                            for (; i4 > 0 && (anIntArrayArrayArray65[k2][k3][i4 - 1] & k1) != 0; i4--) ;
                            for (; j5 < anInt51 && (anIntArrayArrayArray65[k2][k3][j5 + 1] & k1) != 0; j5++) ;
                            label0:
                            for (; k6 > 0; k6--) {
                                for (int l9 = i4; l9 <= j5; l9++)
                                    if ((anIntArrayArrayArray65[k6 - 1][k3][l9] & k1) == 0)
                                        break label0;

                            }

                            label1:
                            for (; i8 < j2; i8++) {
                                for (int i10 = i4; i10 <= j5; i10++)
                                    if ((anIntArrayArrayArray65[i8 + 1][k3][i10] & k1) == 0)
                                        break label1;

                            }

                            int j10 = ((i8 + 1) - k6) * ((j5 - i4) + 1);
                            if (j10 >= 8) {
                                char c1 = '\360';
                                int j14 = anIntArrayArrayArray52[i8][k3][i4] - c1;
                                int k15 = anIntArrayArrayArray52[k6][k3][i4];
                                MapSquare.method241(k3 * 128, j14, k3 * 128, aByte46, j5 * 128 + 128, i4 * 128, 1, k15, j2);
                                for (int k16 = k6; k16 <= i8; k16++) {
                                    for (int k17 = i4; k17 <= j5; k17++)
                                        anIntArrayArrayArray65[k16][k3][k17] &= ~k1;

                                }

                            }
                        }
                        if ((anIntArrayArrayArray65[k2][k3][i3] & l1) != 0) {
                            int j4 = k3;
                            int k5 = k3;
                            int l6 = k2;
                            int j8 = k2;
                            for (; j4 > 0 && (anIntArrayArrayArray65[k2][j4 - 1][i3] & l1) != 0; j4--) ;
                            for (; k5 < anInt50 && (anIntArrayArrayArray65[k2][k5 + 1][i3] & l1) != 0; k5++) ;
                            label2:
                            for (; l6 > 0; l6--) {
                                for (int k10 = j4; k10 <= k5; k10++)
                                    if ((anIntArrayArrayArray65[l6 - 1][k10][i3] & l1) == 0)
                                        break label2;

                            }

                            label3:
                            for (; j8 < j2; j8++) {
                                for (int l10 = j4; l10 <= k5; l10++)
                                    if ((anIntArrayArrayArray65[j8 + 1][l10][i3] & l1) == 0)
                                        break label3;

                            }

                            int i11 = ((j8 + 1) - l6) * ((k5 - j4) + 1);
                            if (i11 >= 8) {
                                char c2 = '\360';
                                int k14 = anIntArrayArrayArray52[j8][j4][i3] - c2;
                                int l15 = anIntArrayArrayArray52[l6][j4][i3];
                                MapSquare.method241(j4 * 128, k14, k5 * 128 + 128, aByte46, i3 * 128, i3 * 128, 2, l15, j2);
                                for (int l16 = l6; l16 <= j8; l16++) {
                                    for (int l17 = j4; l17 <= k5; l17++)
                                        anIntArrayArrayArray65[l16][l17][i3] &= ~l1;

                                }

                            }
                        }
                        if ((anIntArrayArrayArray65[k2][k3][i3] & i2) != 0) {
                            int k4 = k3;
                            int l5 = k3;
                            int i7 = i3;
                            int k8 = i3;
                            for (; i7 > 0 && (anIntArrayArrayArray65[k2][k3][i7 - 1] & i2) != 0; i7--) ;
                            for (; k8 < anInt51 && (anIntArrayArrayArray65[k2][k3][k8 + 1] & i2) != 0; k8++) ;
                            label4:
                            for (; k4 > 0; k4--) {
                                for (int j11 = i7; j11 <= k8; j11++)
                                    if ((anIntArrayArrayArray65[k2][k4 - 1][j11] & i2) == 0)
                                        break label4;

                            }

                            label5:
                            for (; l5 < anInt50; l5++) {
                                for (int k11 = i7; k11 <= k8; k11++)
                                    if ((anIntArrayArrayArray65[k2][l5 + 1][k11] & i2) == 0)
                                        break label5;

                            }

                            if (((l5 - k4) + 1) * ((k8 - i7) + 1) >= 4) {
                                int l11 = anIntArrayArrayArray52[k2][k4][i7];
                                MapSquare.method241(k4 * 128, l11, l5 * 128 + 128, aByte46, k8 * 128 + 128, i7 * 128, 4, l11, j2);
                                for (int j13 = k4; j13 <= l5; j13++) {
                                    for (int l14 = i7; l14 <= k8; l14++)
                                        anIntArrayArrayArray65[k2][j13][l14] &= ~i2;

                                }

                            }
                        }
                    }

                }

            }

        }

        if (!flag) ;
    }

    public static int method138(int i, int j) {
        int k = (method139(i + 45365, j + 0x16713, 4) - 128) + (method139(i + 10294, j + 37821, 2) - 128 >> 1) + (method139(i, j, 1) - 128 >> 2);
        k = (int) ((double) k * 0.29999999999999999D) + 35;
        if (k < 10)
            k = 10;
        else if (k > 60)
            k = 60;
        return k;
    }

    public static int method139(int i, int j, int k) {
        int l = i / k;
        int i1 = i & k - 1;
        int j1 = j / k;
        int k1 = j & k - 1;
        int l1 = method141(l, j1);
        int i2 = method141(l + 1, j1);
        int j2 = method141(l, j1 + 1);
        int k2 = method141(l + 1, j1 + 1);
        int l2 = method140(l1, i2, i1, k);
        int i3 = method140(j2, k2, i1, k);
        return method140(l2, i3, k1, k);
    }

    public static int method140(int i, int j, int k, int l) {
        int i1 = 0x10000 - Draw3D.anIntArray1272[(k * 1024) / l] >> 1;
        return (i * (0x10000 - i1) >> 16) + (j * i1 >> 16);
    }

    public static int method141(int i, int j) {
        int k = method142(i - 1, j - 1) + method142(i + 1, j - 1) + method142(i - 1, j + 1) + method142(i + 1, j + 1);
        int l = method142(i - 1, j) + method142(i + 1, j) + method142(i, j - 1) + method142(i, j + 1);
        int i1 = method142(i, j);
        return k / 16 + l / 8 + i1 / 4;
    }

    public static int method142(int i, int j) {
        int k = i + j * 57;
        k = k << 13 ^ k;
        int l = k * (k * k * 15731 + 0xc0ae5) + 0x5208dd0d & 0x7fffffff;
        return l >> 19 & 0xff;
    }

    public static int method143(int i, int j) {
        if (i == -1)
            return 0xbc614e;
        j = (j * (i & 0x7f)) / 128;
        if (j < 2)
            j = 2;
        else if (j > 126)
            j = 126;
        return (i & 0xff80) + j;
    }

    public int method144(int i, int j) {
        if (i == -2)
            return 0xbc614e;
        if (i == -1) {
            if (j < 0)
                j = 0;
            else if (j > 127)
                j = 127;
            j = 127 - j;
            return j;
        }
        j = (j * (i & 0x7f)) / 128;
        if (j < 2)
            j = 2;
        else if (j > 126)
            j = 126;
        return (i & 0xff80) + j;
    }

    public int method145(int i, int j, int k) {
        if (k > 179)
            j /= 2;
        if (k > 192)
            j /= 2;
        if (k > 217)
            j /= 2;
        if (k > 243)
            j /= 2;
        int l = (i / 4 << 10) + (j / 32 << 7) + k / 2;
        return l;
    }

    public static void method146(int i, MapSquare class29, int j, int k, int l, int i1, CollisionMap class2, LinkedList class24,
                                 int[][][] ai, int j1, byte byte0, int k1) {
        int l1 = ai[k1][i1][j1];
        int i2 = ai[k1][i1 + 1][j1];
        int j2 = ai[k1][i1 + 1][j1 + 1];
        int k2 = ai[k1][i1][j1 + 1];
        int l2 = l1 + i2 + j2 + k2 >> 2;
        LocType class39 = LocType.method428(i);
        int i3 = i1 + (j1 << 7) + (i << 14) + 0x40000000;
        if (!class39.aBoolean546)
            i3 += 0x80000000;
        byte byte1 = (byte) ((k << 6) + j);
        if (byte0 != 1)
            aBoolean45 = !aBoolean45;
        if (j == 22) {
            Model class35_sub2_sub1 = class39.method431(22, k, l1, i2, j2, k2, -1);
            class29.method244(i3, j1, byte1, class35_sub2_sub1, i1, l2, true, l);
            if (class39.aBoolean544 && class39.aBoolean546)
                class2.method124(2, j1, i1);
            return;
        }
        if (j == 10 || j == 11) {
            Model class35_sub2_sub1_1 = class39.method431(10, k, l1, i2, j2, k2, -1);
            if (class35_sub2_sub1_1 != null) {
                int k4 = 0;
                if (j == 11)
                    k4 += 256;
                int l3;
                int j4;
                if (k == 1 || k == 3) {
                    l3 = class39.anInt543;
                    j4 = class39.anInt542;
                } else {
                    l3 = class39.anInt542;
                    j4 = class39.anInt543;
                }
                class29.method248(class35_sub2_sub1_1, byte1, null, l2, i1, j4, l3, l, i3, j1, 0, k4);
            }
            if (class39.aBoolean544)
                class2.method123(i1, class39.anInt543, class39.aBoolean545, class39.anInt542, -532, j1, k);
            if (class39.anInt550 != -1)
                class24.pushNext(new LocEntity(2, -69, l, i, true, SeqType.aSeqTypeArray190[class39.anInt550], j1, i1));
            return;
        }
        if (j >= 12) {
            Model class35_sub2_sub1_2 = class39.method431(j, k, l1, i2, j2, k2, -1);
            class29.method248(class35_sub2_sub1_2, byte1, null, l2, i1, 1, 1, l, i3, j1, 0, 0);
            if (class39.aBoolean544)
                class2.method123(i1, class39.anInt543, class39.aBoolean545, class39.anInt542, -532, j1, k);
            if (class39.anInt550 != -1)
                class24.pushNext(new LocEntity(2, -69, l, i, true, SeqType.aSeqTypeArray190[class39.anInt550], j1, i1));
            return;
        }
        if (j == 0) {
            Model class35_sub2_sub1_3 = class39.method431(0, k, l1, i2, j2, k2, -1);
            class29.method246(431, i3, 0, l2, class35_sub2_sub1_3, j1, i1, null, byte1, anIntArray66[k], l);
            if (class39.aBoolean544)
                class2.method122(j, j1, k, i1, 757, class39.aBoolean545);
            return;
        }
        if (j == 1) {
            Model class35_sub2_sub1_4 = class39.method431(1, k, l1, i2, j2, k2, -1);
            class29.method246(431, i3, 0, l2, class35_sub2_sub1_4, j1, i1, null, byte1, anIntArray67[k], l);
            if (class39.aBoolean544)
                class2.method122(j, j1, k, i1, 757, class39.aBoolean545);
            return;
        }
        if (j == 2) {
            int j3 = k + 1 & 3;
            Model class35_sub2_sub1_11 = class39.method431(2, 4 + k, l1, i2, j2, k2, -1);
            Model class35_sub2_sub1_12 = class39.method431(2, j3, l1, i2, j2, k2, -1);
            class29.method246(431, i3, anIntArray66[j3], l2, class35_sub2_sub1_11, j1, i1, class35_sub2_sub1_12, byte1, anIntArray66[k], l);
            if (class39.aBoolean544)
                class2.method122(j, j1, k, i1, 757, class39.aBoolean545);
            return;
        }
        if (j == 3) {
            Model class35_sub2_sub1_5 = class39.method431(3, k, l1, i2, j2, k2, -1);
            class29.method246(431, i3, 0, l2, class35_sub2_sub1_5, j1, i1, null, byte1, anIntArray67[k], l);
            if (class39.aBoolean544)
                class2.method122(j, j1, k, i1, 757, class39.aBoolean545);
            return;
        }
        if (j == 9) {
            Model class35_sub2_sub1_6 = class39.method431(j, k, l1, i2, j2, k2, -1);
            class29.method248(class35_sub2_sub1_6, byte1, null, l2, i1, 1, 1, l, i3, j1, 0, 0);
            if (class39.aBoolean544)
                class2.method123(i1, class39.anInt543, class39.aBoolean545, class39.anInt542, -532, j1, k);
            return;
        }
        if (j == 4) {
            Model class35_sub2_sub1_7 = class39.method431(4, 0, l1, i2, j2, k2, -1);
            class29.method247(i1, byte1, l2, 0, i3, anIntArray66[k], 414, k * 512, 0, class35_sub2_sub1_7, j1, l);
            if (class39.anInt550 != -1)
                class24.pushNext(new LocEntity(1, -69, l, i, true, SeqType.aSeqTypeArray190[class39.anInt550], j1, i1));
            return;
        }
        if (j == 5) {
            int k3 = 16;
            int i4 = class29.method262(l, i1, j1);
            if (i4 > 0)
                k3 = LocType.method428(i4 >> 14 & 0x7fff).anInt551;
            Model class35_sub2_sub1_13 = class39.method431(4, 0, l1, i2, j2, k2, -1);
            class29.method247(i1, byte1, l2, anIntArray69[k] * k3, i3, anIntArray66[k], 414, k * 512, anIntArray68[k] * k3, class35_sub2_sub1_13, j1, l);
            if (class39.anInt550 != -1)
                class24.pushNext(new LocEntity(1, -69, l, i, true, SeqType.aSeqTypeArray190[class39.anInt550], j1, i1));
            return;
        }
        if (j == 6) {
            Model class35_sub2_sub1_8 = class39.method431(4, 0, l1, i2, j2, k2, -1);
            class29.method247(i1, byte1, l2, 0, i3, 256, 414, k, 0, class35_sub2_sub1_8, j1, l);
            if (class39.anInt550 != -1)
                class24.pushNext(new LocEntity(1, -69, l, i, true, SeqType.aSeqTypeArray190[class39.anInt550], j1, i1));
            return;
        }
        if (j == 7) {
            Model class35_sub2_sub1_9 = class39.method431(4, 0, l1, i2, j2, k2, -1);
            class29.method247(i1, byte1, l2, 0, i3, 512, 414, k, 0, class35_sub2_sub1_9, j1, l);
            if (class39.anInt550 != -1)
                class24.pushNext(new LocEntity(1, -69, l, i, true, SeqType.aSeqTypeArray190[class39.anInt550], j1, i1));
            return;
        }
        if (j == 8) {
            Model class35_sub2_sub1_10 = class39.method431(4, 0, l1, i2, j2, k2, -1);
            class29.method247(i1, byte1, l2, 0, i3, 768, 414, k, 0, class35_sub2_sub1_10, j1, l);
            if (class39.anInt550 != -1)
                class24.pushNext(new LocEntity(1, -69, l, i, true, SeqType.aSeqTypeArray190[class39.anInt550], j1, i1));
        }
    }

    public int anInt44;
    public static boolean aBoolean45;
    public byte aByte46;
    public static boolean aBoolean47 = true;
    public static int anInt48;
    public static boolean aBoolean49;
    public int anInt50;
    public int anInt51;
    public int[][][] anIntArrayArrayArray52;
    public byte[][][] aByteArrayArrayArray53;
    public byte[][][] aByteArrayArrayArray54;
    public byte[][][] aByteArrayArrayArray55;
    public byte[][][] aByteArrayArrayArray56;
    public byte[][][] aByteArrayArrayArray57;
    public byte[][][] aByteArrayArrayArray58;
    public int[][] anIntArrayArray59;
    public int[] anIntArray60;
    public int[] anIntArray61;
    public int[] anIntArray62;
    public int[] anIntArray63;
    public int[] anIntArray64;
    public int[][][] anIntArrayArrayArray65;
    public static final int[] anIntArray66 = {
            1, 2, 4, 8
    };
    public static final int[] anIntArray67 = {
            16, 32, 64, 128
    };
    public static final int[] anIntArray68 = {
            1, 0, -1, 0
    };
    public static final int[] anIntArray69 = {
            0, -1, 0, 1
    };

}
