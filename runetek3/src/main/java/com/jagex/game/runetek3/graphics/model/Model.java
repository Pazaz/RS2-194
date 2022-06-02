package com.jagex.game.runetek3.graphics.model;

// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

import com.jagex.core.io.Buffer;
import com.jagex.core.io.FileArchive;
import com.jagex.core.utils.CacheableNode;
import com.jagex.game.runetek3.graphics.Draw2D;
import com.jagex.game.runetek3.graphics.Draw3D;
import com.jagex.game.runetek3.graphics.seq.SeqBase;
import com.jagex.game.runetek3.graphics.seq.SeqFrame;

public class Model extends CacheableNode {

    public static void method305(int i) {
        aModelMetadataArray1088 = null;
        aClass35_Sub2_Sub3_1089 = null;
        aClass35_Sub2_Sub3_1090 = null;
        aClass35_Sub2_Sub3_1091 = null;
        if (i <= 0) {
            return;
        } else {
            aClass35_Sub2_Sub3_1092 = null;
            aClass35_Sub2_Sub3_1093 = null;
            aClass35_Sub2_Sub3_1094 = null;
            aClass35_Sub2_Sub3_1095 = null;
            aClass35_Sub2_Sub3_1096 = null;
            aClass35_Sub2_Sub3_1097 = null;
            aClass35_Sub2_Sub3_1098 = null;
            aClass35_Sub2_Sub3_1099 = null;
            aClass35_Sub2_Sub3_1100 = null;
            aClass35_Sub2_Sub3_1101 = null;
            aClass35_Sub2_Sub3_1102 = null;
            aBooleanArray1103 = null;
            aBooleanArray1104 = null;
            anIntArray1105 = null;
            anIntArray1106 = null;
            anIntArray1107 = null;
            anIntArray1108 = null;
            anIntArray1109 = null;
            anIntArray1110 = null;
            anIntArray1111 = null;
            anIntArrayArray1112 = null;
            anIntArray1113 = null;
            anIntArrayArray1114 = null;
            anIntArray1115 = null;
            anIntArray1116 = null;
            anIntArray1117 = null;
            anIntArray1129 = null;
            anIntArray1130 = null;
            anIntArray1131 = null;
            anIntArray1132 = null;
            return;
        }
    }

    public static void decode(FileArchive class36) {
        try {
            aClass35_Sub2_Sub3_1089 = new Buffer(class36.method417((byte) 6, null, "ob_head.dat"));
            aClass35_Sub2_Sub3_1090 = new Buffer(class36.method417((byte) 6, null, "ob_face1.dat"));
            aClass35_Sub2_Sub3_1091 = new Buffer(class36.method417((byte) 6, null, "ob_face2.dat"));
            aClass35_Sub2_Sub3_1092 = new Buffer(class36.method417((byte) 6, null, "ob_face3.dat"));
            aClass35_Sub2_Sub3_1093 = new Buffer(class36.method417((byte) 6, null, "ob_face4.dat"));
            aClass35_Sub2_Sub3_1094 = new Buffer(class36.method417((byte) 6, null, "ob_face5.dat"));
            aClass35_Sub2_Sub3_1095 = new Buffer(class36.method417((byte) 6, null, "ob_point1.dat"));
            aClass35_Sub2_Sub3_1096 = new Buffer(class36.method417((byte) 6, null, "ob_point2.dat"));
            aClass35_Sub2_Sub3_1097 = new Buffer(class36.method417((byte) 6, null, "ob_point3.dat"));
            aClass35_Sub2_Sub3_1098 = new Buffer(class36.method417((byte) 6, null, "ob_point4.dat"));
            aClass35_Sub2_Sub3_1099 = new Buffer(class36.method417((byte) 6, null, "ob_point5.dat"));
            aClass35_Sub2_Sub3_1100 = new Buffer(class36.method417((byte) 6, null, "ob_vertex1.dat"));
            aClass35_Sub2_Sub3_1101 = new Buffer(class36.method417((byte) 6, null, "ob_vertex2.dat"));
            aClass35_Sub2_Sub3_1102 = new Buffer(class36.method417((byte) 6, null, "ob_axis.dat"));
            aClass35_Sub2_Sub3_1089.pos = 0;
            aClass35_Sub2_Sub3_1095.pos = 0;
            aClass35_Sub2_Sub3_1096.pos = 0;
            aClass35_Sub2_Sub3_1097.pos = 0;
            aClass35_Sub2_Sub3_1098.pos = 0;
            aClass35_Sub2_Sub3_1100.pos = 0;
            aClass35_Sub2_Sub3_1101.pos = 0;
            int i = aClass35_Sub2_Sub3_1089.g2();
            aModelMetadataArray1088 = new ModelMetadata[i + 100];
            int j = 0;
            int k = 0;
            int l = 0;
            int i1 = 0;
            int j1 = 0;
            int k1 = 0;
            int l1 = 0;
            for (int i2 = 0; i2 < i; i2++) {
                int j2 = aClass35_Sub2_Sub3_1089.g2();
                ModelMetadata class20 = aModelMetadataArray1088[j2] = new ModelMetadata();
                class20.anInt289 = aClass35_Sub2_Sub3_1089.g2();
                class20.anInt290 = aClass35_Sub2_Sub3_1089.g2();
                class20.anInt291 = aClass35_Sub2_Sub3_1089.g1();
                class20.anInt292 = aClass35_Sub2_Sub3_1095.pos;
                class20.anInt293 = aClass35_Sub2_Sub3_1096.pos;
                class20.anInt294 = aClass35_Sub2_Sub3_1097.pos;
                class20.anInt295 = aClass35_Sub2_Sub3_1098.pos;
                class20.anInt297 = aClass35_Sub2_Sub3_1100.pos;
                class20.anInt298 = aClass35_Sub2_Sub3_1101.pos;
                int k2 = aClass35_Sub2_Sub3_1089.g1();
                int l2 = aClass35_Sub2_Sub3_1089.g1();
                int i3 = aClass35_Sub2_Sub3_1089.g1();
                int j3 = aClass35_Sub2_Sub3_1089.g1();
                int k3 = aClass35_Sub2_Sub3_1089.g1();
                for (int l3 = 0; l3 < class20.anInt289; l3++) {
                    int i4 = aClass35_Sub2_Sub3_1095.g1();
                    if ((i4 & 1) != 0)
                        aClass35_Sub2_Sub3_1096.gsmart();
                    if ((i4 & 2) != 0)
                        aClass35_Sub2_Sub3_1097.gsmart();
                    if ((i4 & 4) != 0)
                        aClass35_Sub2_Sub3_1098.gsmart();
                }

                for (int j4 = 0; j4 < class20.anInt290; j4++) {
                    int k4 = aClass35_Sub2_Sub3_1101.g1();
                    if (k4 == 1) {
                        aClass35_Sub2_Sub3_1100.gsmart();
                        aClass35_Sub2_Sub3_1100.gsmart();
                    }
                    aClass35_Sub2_Sub3_1100.gsmart();
                }

                class20.anInt299 = l;
                l += class20.anInt290 * 2;
                if (k2 == 1) {
                    class20.anInt300 = i1;
                    i1 += class20.anInt290;
                } else {
                    class20.anInt300 = -1;
                }
                if (l2 == 255) {
                    class20.anInt301 = j1;
                    j1 += class20.anInt290;
                } else {
                    class20.anInt301 = -l2 - 1;
                }
                if (i3 == 1) {
                    class20.anInt302 = k1;
                    k1 += class20.anInt290;
                } else {
                    class20.anInt302 = -1;
                }
                if (j3 == 1) {
                    class20.anInt303 = l1;
                    l1 += class20.anInt290;
                } else {
                    class20.anInt303 = -1;
                }
                if (k3 == 1) {
                    class20.anInt296 = k;
                    k += class20.anInt289;
                } else {
                    class20.anInt296 = -1;
                }
                class20.anInt304 = j;
                j += class20.anInt291;
            }

            return;
        } catch (Exception exception) {
            System.out.println("Error loading model index");
            exception.printStackTrace();
            return;
        }
    }

    public Model(int i, int j) {
        anInt1048 = -222;
        anInt1049 = -25737;
        aBoolean1050 = false;
        aBoolean1085 = false;
        if (aModelMetadataArray1088 == null)
            return;
        ModelMetadata class20 = aModelMetadataArray1088[i];
        if (class20 == null) {
            System.out.println("Error model:" + i + " not found!");
            return;
        }
        anInt1051 = class20.anInt289;
        anInt1055 = class20.anInt290;
        anInt1067 = class20.anInt291;
        anIntArray1052 = new int[anInt1051];
        anIntArray1053 = new int[anInt1051];
        anIntArray1054 = new int[anInt1051];
        anIntArray1056 = new int[anInt1055];
        anIntArray1057 = new int[anInt1055];
        anIntArray1058 = new int[anInt1055];
        anIntArray1068 = new int[anInt1067];
        anIntArray1069 = new int[anInt1067];
        anIntArray1070 = new int[anInt1067];
        if (class20.anInt296 >= 0)
            anIntArray1081 = new int[anInt1051];
        if (class20.anInt300 >= 0)
            anIntArray1062 = new int[anInt1055];
        if (class20.anInt301 >= 0)
            anIntArray1063 = new int[anInt1055];
        else
            anInt1066 = -class20.anInt301 - 1;
        if (class20.anInt302 >= 0)
            anIntArray1064 = new int[anInt1055];
        if (class20.anInt303 >= 0)
            anIntArray1082 = new int[anInt1055];
        anIntArray1065 = new int[anInt1055];
        aClass35_Sub2_Sub3_1095.pos = class20.anInt292;
        aClass35_Sub2_Sub3_1096.pos = class20.anInt293;
        aClass35_Sub2_Sub3_1097.pos = class20.anInt294;
        aClass35_Sub2_Sub3_1098.pos = class20.anInt295;
        aClass35_Sub2_Sub3_1099.pos = class20.anInt296;
        int k = 0;
        int l = 0;
        int i1 = 0;
        for (int j1 = 0; j1 < anInt1051; j1++) {
            int k1 = aClass35_Sub2_Sub3_1095.g1();
            int i2 = 0;
            if ((k1 & 1) != 0)
                i2 = aClass35_Sub2_Sub3_1096.gsmart();
            int k2 = 0;
            if ((k1 & 2) != 0)
                k2 = aClass35_Sub2_Sub3_1097.gsmart();
            int i3 = 0;
            if ((k1 & 4) != 0)
                i3 = aClass35_Sub2_Sub3_1098.gsmart();
            anIntArray1052[j1] = k + i2;
            anIntArray1053[j1] = l + k2;
            anIntArray1054[j1] = i1 + i3;
            k = anIntArray1052[j1];
            l = anIntArray1053[j1];
            i1 = anIntArray1054[j1];
            if (anIntArray1081 != null)
                anIntArray1081[j1] = aClass35_Sub2_Sub3_1099.g1();
        }

        aClass35_Sub2_Sub3_1090.pos = class20.anInt299;
        if (j <= 0)
            throw new NullPointerException();
        aClass35_Sub2_Sub3_1091.pos = class20.anInt300;
        aClass35_Sub2_Sub3_1092.pos = class20.anInt301;
        aClass35_Sub2_Sub3_1093.pos = class20.anInt302;
        aClass35_Sub2_Sub3_1094.pos = class20.anInt303;
        for (int l1 = 0; l1 < anInt1055; l1++) {
            anIntArray1065[l1] = aClass35_Sub2_Sub3_1090.g2();
            if (anIntArray1062 != null)
                anIntArray1062[l1] = aClass35_Sub2_Sub3_1091.g1();
            if (anIntArray1063 != null)
                anIntArray1063[l1] = aClass35_Sub2_Sub3_1092.g1();
            if (anIntArray1064 != null)
                anIntArray1064[l1] = aClass35_Sub2_Sub3_1093.g1();
            if (anIntArray1082 != null)
                anIntArray1082[l1] = aClass35_Sub2_Sub3_1094.g1();
        }

        aClass35_Sub2_Sub3_1100.pos = class20.anInt297;
        aClass35_Sub2_Sub3_1101.pos = class20.anInt298;
        int j2 = 0;
        int l2 = 0;
        int j3 = 0;
        int k3 = 0;
        for (int l3 = 0; l3 < anInt1055; l3++) {
            int i4 = aClass35_Sub2_Sub3_1101.g1();
            if (i4 == 1) {
                j2 = aClass35_Sub2_Sub3_1100.gsmart() + k3;
                k3 = j2;
                l2 = aClass35_Sub2_Sub3_1100.gsmart() + k3;
                k3 = l2;
                j3 = aClass35_Sub2_Sub3_1100.gsmart() + k3;
                k3 = j3;
                anIntArray1056[l3] = j2;
                anIntArray1057[l3] = l2;
                anIntArray1058[l3] = j3;
            }
            if (i4 == 2) {
                j2 = j2;
                l2 = j3;
                j3 = aClass35_Sub2_Sub3_1100.gsmart() + k3;
                k3 = j3;
                anIntArray1056[l3] = j2;
                anIntArray1057[l3] = l2;
                anIntArray1058[l3] = j3;
            }
            if (i4 == 3) {
                j2 = j3;
                l2 = l2;
                j3 = aClass35_Sub2_Sub3_1100.gsmart() + k3;
                k3 = j3;
                anIntArray1056[l3] = j2;
                anIntArray1057[l3] = l2;
                anIntArray1058[l3] = j3;
            }
            if (i4 == 4) {
                int k4 = j2;
                j2 = l2;
                l2 = k4;
                j3 = aClass35_Sub2_Sub3_1100.gsmart() + k3;
                k3 = j3;
                anIntArray1056[l3] = j2;
                anIntArray1057[l3] = l2;
                anIntArray1058[l3] = j3;
            }
        }

        aClass35_Sub2_Sub3_1102.pos = class20.anInt304 * 6;
        for (int j4 = 0; j4 < anInt1067; j4++) {
            anIntArray1068[j4] = aClass35_Sub2_Sub3_1102.g2();
            anIntArray1069[j4] = aClass35_Sub2_Sub3_1102.g2();
            anIntArray1070[j4] = aClass35_Sub2_Sub3_1102.g2();
        }

    }

    public Model(boolean flag, int i, Model[] aclass35_sub2_sub1) {
        anInt1048 = -222;
        anInt1049 = -25737;
        aBoolean1050 = false;
        aBoolean1085 = false;
        boolean flag1 = false;
        boolean flag2 = false;
        boolean flag3 = false;
        boolean flag4 = false;
        anInt1051 = 0;
        anInt1055 = 0;
        anInt1067 = 0;
        anInt1066 = -1;
        for (int j = 0; j < i; j++) {
            Model class35_sub2_sub1 = aclass35_sub2_sub1[j];
            if (class35_sub2_sub1 != null) {
                anInt1051 += class35_sub2_sub1.anInt1051;
                anInt1055 += class35_sub2_sub1.anInt1055;
                anInt1067 += class35_sub2_sub1.anInt1067;
                flag1 |= class35_sub2_sub1.anIntArray1062 != null;
                if (class35_sub2_sub1.anIntArray1063 != null) {
                    flag2 = true;
                } else {
                    if (anInt1066 == -1)
                        anInt1066 = class35_sub2_sub1.anInt1066;
                    if (anInt1066 != class35_sub2_sub1.anInt1066)
                        flag2 = true;
                }
                flag3 |= class35_sub2_sub1.anIntArray1064 != null;
                flag4 |= class35_sub2_sub1.anIntArray1082 != null;
            }
        }

        anIntArray1052 = new int[anInt1051];
        anIntArray1053 = new int[anInt1051];
        anIntArray1054 = new int[anInt1051];
        if (flag)
            throw new NullPointerException();
        anIntArray1081 = new int[anInt1051];
        anIntArray1056 = new int[anInt1055];
        anIntArray1057 = new int[anInt1055];
        anIntArray1058 = new int[anInt1055];
        anIntArray1068 = new int[anInt1067];
        anIntArray1069 = new int[anInt1067];
        anIntArray1070 = new int[anInt1067];
        if (flag1)
            anIntArray1062 = new int[anInt1055];
        if (flag2)
            anIntArray1063 = new int[anInt1055];
        if (flag3)
            anIntArray1064 = new int[anInt1055];
        if (flag4)
            anIntArray1082 = new int[anInt1055];
        anIntArray1065 = new int[anInt1055];
        anInt1051 = 0;
        anInt1055 = 0;
        anInt1067 = 0;
        for (int k = 0; k < i; k++) {
            Model class35_sub2_sub1_1 = aclass35_sub2_sub1[k];
            if (class35_sub2_sub1_1 != null) {
                for (int l = 0; l < class35_sub2_sub1_1.anInt1055; l++) {
                    if (flag1)
                        if (class35_sub2_sub1_1.anIntArray1062 == null)
                            anIntArray1062[anInt1055] = 0;
                        else
                            anIntArray1062[anInt1055] = class35_sub2_sub1_1.anIntArray1062[l];
                    if (flag2)
                        if (class35_sub2_sub1_1.anIntArray1063 == null)
                            anIntArray1063[anInt1055] = class35_sub2_sub1_1.anInt1066;
                        else
                            anIntArray1063[anInt1055] = class35_sub2_sub1_1.anIntArray1063[l];
                    if (flag3)
                        if (class35_sub2_sub1_1.anIntArray1064 == null)
                            anIntArray1064[anInt1055] = 0;
                        else
                            anIntArray1064[anInt1055] = class35_sub2_sub1_1.anIntArray1064[l];
                    if (flag4 && class35_sub2_sub1_1.anIntArray1082 != null)
                        anIntArray1082[anInt1055] = class35_sub2_sub1_1.anIntArray1082[l];
                    anIntArray1065[anInt1055] = class35_sub2_sub1_1.anIntArray1065[l];
                    anIntArray1056[anInt1055] = method307(class35_sub2_sub1_1, class35_sub2_sub1_1.anIntArray1056[l]);
                    anIntArray1057[anInt1055] = method307(class35_sub2_sub1_1, class35_sub2_sub1_1.anIntArray1057[l]);
                    anIntArray1058[anInt1055] = method307(class35_sub2_sub1_1, class35_sub2_sub1_1.anIntArray1058[l]);
                    anInt1055++;
                }

                for (int i1 = 0; i1 < class35_sub2_sub1_1.anInt1067; i1++) {
                    anIntArray1068[anInt1067] = method307(class35_sub2_sub1_1, class35_sub2_sub1_1.anIntArray1068[i1]);
                    anIntArray1069[anInt1067] = method307(class35_sub2_sub1_1, class35_sub2_sub1_1.anIntArray1069[i1]);
                    anIntArray1070[anInt1067] = method307(class35_sub2_sub1_1, class35_sub2_sub1_1.anIntArray1070[i1]);
                    anInt1067++;
                }

            }
        }

    }

    public Model(boolean flag, boolean flag1, Model[] aclass35_sub2_sub1, int i) {
        anInt1048 = -222;
        anInt1049 = -25737;
        aBoolean1050 = false;
        aBoolean1085 = false;
        if (!flag)
            anInt1048 = -114;
        boolean flag2 = false;
        boolean flag3 = false;
        boolean flag4 = false;
        boolean flag5 = false;
        anInt1051 = 0;
        anInt1055 = 0;
        anInt1067 = 0;
        anInt1066 = -1;
        for (int j = 0; j < i; j++) {
            Model class35_sub2_sub1 = aclass35_sub2_sub1[j];
            if (class35_sub2_sub1 != null) {
                anInt1051 += class35_sub2_sub1.anInt1051;
                anInt1055 += class35_sub2_sub1.anInt1055;
                anInt1067 += class35_sub2_sub1.anInt1067;
                flag2 |= class35_sub2_sub1.anIntArray1062 != null;
                if (class35_sub2_sub1.anIntArray1063 != null) {
                    flag3 = true;
                } else {
                    if (anInt1066 == -1)
                        anInt1066 = class35_sub2_sub1.anInt1066;
                    if (anInt1066 != class35_sub2_sub1.anInt1066)
                        flag3 = true;
                }
                flag4 |= class35_sub2_sub1.anIntArray1064 != null;
                flag5 |= class35_sub2_sub1.anIntArray1065 != null;
            }
        }

        anIntArray1052 = new int[anInt1051];
        anIntArray1053 = new int[anInt1051];
        anIntArray1054 = new int[anInt1051];
        anIntArray1056 = new int[anInt1055];
        anIntArray1057 = new int[anInt1055];
        anIntArray1058 = new int[anInt1055];
        anIntArray1059 = new int[anInt1055];
        anIntArray1060 = new int[anInt1055];
        anIntArray1061 = new int[anInt1055];
        anIntArray1068 = new int[anInt1067];
        anIntArray1069 = new int[anInt1067];
        anIntArray1070 = new int[anInt1067];
        if (flag2)
            anIntArray1062 = new int[anInt1055];
        if (flag3)
            anIntArray1063 = new int[anInt1055];
        if (flag4)
            anIntArray1064 = new int[anInt1055];
        if (flag5)
            anIntArray1065 = new int[anInt1055];
        anInt1051 = 0;
        anInt1055 = 0;
        anInt1067 = 0;
        for (int k = 0; k < i; k++) {
            Model class35_sub2_sub1_1 = aclass35_sub2_sub1[k];
            if (class35_sub2_sub1_1 != null) {
                int l = anInt1051;
                for (int i1 = 0; i1 < class35_sub2_sub1_1.anInt1051; i1++) {
                    anIntArray1052[anInt1051] = class35_sub2_sub1_1.anIntArray1052[i1];
                    anIntArray1053[anInt1051] = class35_sub2_sub1_1.anIntArray1053[i1];
                    anIntArray1054[anInt1051] = class35_sub2_sub1_1.anIntArray1054[i1];
                    anInt1051++;
                }

                for (int j1 = 0; j1 < class35_sub2_sub1_1.anInt1055; j1++) {
                    anIntArray1056[anInt1055] = class35_sub2_sub1_1.anIntArray1056[j1] + l;
                    anIntArray1057[anInt1055] = class35_sub2_sub1_1.anIntArray1057[j1] + l;
                    anIntArray1058[anInt1055] = class35_sub2_sub1_1.anIntArray1058[j1] + l;
                    anIntArray1059[anInt1055] = class35_sub2_sub1_1.anIntArray1059[j1];
                    anIntArray1060[anInt1055] = class35_sub2_sub1_1.anIntArray1060[j1];
                    anIntArray1061[anInt1055] = class35_sub2_sub1_1.anIntArray1061[j1];
                    if (flag2)
                        if (class35_sub2_sub1_1.anIntArray1062 == null)
                            anIntArray1062[anInt1055] = 0;
                        else
                            anIntArray1062[anInt1055] = class35_sub2_sub1_1.anIntArray1062[j1];
                    if (flag3)
                        if (class35_sub2_sub1_1.anIntArray1063 == null)
                            anIntArray1063[anInt1055] = class35_sub2_sub1_1.anInt1066;
                        else
                            anIntArray1063[anInt1055] = class35_sub2_sub1_1.anIntArray1063[j1];
                    if (flag4)
                        if (class35_sub2_sub1_1.anIntArray1064 == null)
                            anIntArray1064[anInt1055] = 0;
                        else
                            anIntArray1064[anInt1055] = class35_sub2_sub1_1.anIntArray1064[j1];
                    if (flag5 && class35_sub2_sub1_1.anIntArray1065 != null)
                        anIntArray1065[anInt1055] = class35_sub2_sub1_1.anIntArray1065[j1];
                    anInt1055++;
                }

                for (int k1 = 0; k1 < class35_sub2_sub1_1.anInt1067; k1++) {
                    anIntArray1068[anInt1067] = class35_sub2_sub1_1.anIntArray1068[k1] + l;
                    anIntArray1069[anInt1067] = class35_sub2_sub1_1.anIntArray1069[k1] + l;
                    anIntArray1070[anInt1067] = class35_sub2_sub1_1.anIntArray1070[k1] + l;
                    anInt1067++;
                }

            }
        }

        method308(569);
    }

    public Model(int i, boolean flag, Model class35_sub2_sub1, boolean flag1, boolean flag2, boolean flag3) {
        anInt1048 = -222;
        anInt1049 = -25737;
        aBoolean1050 = false;
        aBoolean1085 = false;
        for (anInt1051 = class35_sub2_sub1.anInt1051; i >= 0; )
            throw new NullPointerException();

        anInt1055 = class35_sub2_sub1.anInt1055;
        anInt1067 = class35_sub2_sub1.anInt1067;
        if (flag2) {
            anIntArray1052 = class35_sub2_sub1.anIntArray1052;
            anIntArray1053 = class35_sub2_sub1.anIntArray1053;
            anIntArray1054 = class35_sub2_sub1.anIntArray1054;
        } else {
            anIntArray1052 = new int[anInt1051];
            anIntArray1053 = new int[anInt1051];
            anIntArray1054 = new int[anInt1051];
            for (int j = 0; j < anInt1051; j++) {
                anIntArray1052[j] = class35_sub2_sub1.anIntArray1052[j];
                anIntArray1053[j] = class35_sub2_sub1.anIntArray1053[j];
                anIntArray1054[j] = class35_sub2_sub1.anIntArray1054[j];
            }

        }
        if (flag1) {
            anIntArray1065 = class35_sub2_sub1.anIntArray1065;
        } else {
            anIntArray1065 = new int[anInt1055];
            for (int k = 0; k < anInt1055; k++)
                anIntArray1065[k] = class35_sub2_sub1.anIntArray1065[k];

        }
        if (flag3) {
            anIntArray1064 = class35_sub2_sub1.anIntArray1064;
        } else {
            anIntArray1064 = new int[anInt1055];
            if (class35_sub2_sub1.anIntArray1064 == null) {
                for (int l = 0; l < anInt1055; l++)
                    anIntArray1064[l] = 0;

            } else {
                for (int i1 = 0; i1 < anInt1055; i1++)
                    anIntArray1064[i1] = class35_sub2_sub1.anIntArray1064[i1];

            }
        }
        if (flag) {
            anIntArray1062 = class35_sub2_sub1.anIntArray1062;
        } else {
            anIntArray1062 = new int[anInt1055];
            if (class35_sub2_sub1.anIntArray1062 == null) {
                for (int j1 = 0; j1 < anInt1055; j1++)
                    anIntArray1062[j1] = 0;

            } else {
                for (int k1 = 0; k1 < anInt1055; k1++)
                    anIntArray1062[k1] = class35_sub2_sub1.anIntArray1062[k1];

            }
        }
        anIntArray1081 = class35_sub2_sub1.anIntArray1081;
        anIntArray1082 = class35_sub2_sub1.anIntArray1082;
        anIntArray1056 = class35_sub2_sub1.anIntArray1056;
        anIntArray1057 = class35_sub2_sub1.anIntArray1057;
        anIntArray1058 = class35_sub2_sub1.anIntArray1058;
        anIntArray1063 = class35_sub2_sub1.anIntArray1063;
        anInt1066 = class35_sub2_sub1.anInt1066;
        anIntArray1068 = class35_sub2_sub1.anIntArray1068;
        anIntArray1069 = class35_sub2_sub1.anIntArray1069;
        anIntArray1070 = class35_sub2_sub1.anIntArray1070;
    }

    public Model(boolean flag, boolean flag1, Model class35_sub2_sub1) {
        anInt1048 = -222;
        anInt1049 = -25737;
        aBoolean1050 = false;
        aBoolean1085 = false;
        anInt1051 = class35_sub2_sub1.anInt1051;
        anInt1055 = class35_sub2_sub1.anInt1055;
        anInt1067 = class35_sub2_sub1.anInt1067;
        anIntArray1052 = new int[anInt1051];
        anIntArray1053 = new int[anInt1051];
        anIntArray1054 = new int[anInt1051];
        for (int i = 0; i < anInt1051; i++) {
            anIntArray1052[i] = class35_sub2_sub1.anIntArray1052[i];
            anIntArray1053[i] = class35_sub2_sub1.anIntArray1053[i];
            anIntArray1054[i] = class35_sub2_sub1.anIntArray1054[i];
        }

        if (flag1) {
            anIntArray1064 = class35_sub2_sub1.anIntArray1064;
        } else {
            anIntArray1064 = new int[anInt1055];
            if (class35_sub2_sub1.anIntArray1064 == null) {
                for (int j = 0; j < anInt1055; j++)
                    anIntArray1064[j] = 0;

            } else {
                for (int k = 0; k < anInt1055; k++)
                    anIntArray1064[k] = class35_sub2_sub1.anIntArray1064[k];

            }
        }
        anIntArray1062 = class35_sub2_sub1.anIntArray1062;
        anIntArray1065 = class35_sub2_sub1.anIntArray1065;
        anIntArray1063 = class35_sub2_sub1.anIntArray1063;
        anInt1066 = class35_sub2_sub1.anInt1066;
        anIntArrayArray1084 = class35_sub2_sub1.anIntArrayArray1084;
        anIntArrayArray1083 = class35_sub2_sub1.anIntArrayArray1083;
        anIntArray1056 = class35_sub2_sub1.anIntArray1056;
        anIntArray1057 = class35_sub2_sub1.anIntArray1057;
        anIntArray1058 = class35_sub2_sub1.anIntArray1058;
        anIntArray1059 = class35_sub2_sub1.anIntArray1059;
        anIntArray1060 = class35_sub2_sub1.anIntArray1060;
        anIntArray1061 = class35_sub2_sub1.anIntArray1061;
        if (flag) {
            throw new NullPointerException();
        } else {
            anIntArray1068 = class35_sub2_sub1.anIntArray1068;
            anIntArray1069 = class35_sub2_sub1.anIntArray1069;
            anIntArray1070 = class35_sub2_sub1.anIntArray1070;
            return;
        }
    }

    public int method307(Model class35_sub2_sub1, int i) {
        int j = -1;
        int k = class35_sub2_sub1.anIntArray1052[i];
        int l = class35_sub2_sub1.anIntArray1053[i];
        int i1 = class35_sub2_sub1.anIntArray1054[i];
        for (int j1 = 0; j1 < anInt1051; j1++) {
            if (k != anIntArray1052[j1] || l != anIntArray1053[j1] || i1 != anIntArray1054[j1])
                continue;
            j = j1;
            break;
        }

        if (j == -1) {
            anIntArray1052[anInt1051] = k;
            anIntArray1053[anInt1051] = l;
            anIntArray1054[anInt1051] = i1;
            if (class35_sub2_sub1.anIntArray1081 != null)
                anIntArray1081[anInt1051] = class35_sub2_sub1.anIntArray1081[i];
            j = anInt1051++;
        }
        return j;
    }

    public void method308(int i) {
        anInt1076 = 0;
        anInt1075 = 0;
        if (i <= 0) {
            for (int j = 1; j > 0; j++) ;
        }
        anInt1077 = 0;
        for (int k = 0; k < anInt1051; k++) {
            int l = anIntArray1052[k];
            int i1 = anIntArray1053[k];
            int j1 = anIntArray1054[k];
            if (-i1 > anInt1076)
                anInt1076 = -i1;
            if (i1 > anInt1077)
                anInt1077 = i1;
            int k1 = l * l + j1 * j1;
            if (k1 > anInt1075)
                anInt1075 = k1;
        }

        anInt1075 = (int) Math.sqrt(anInt1075);
        anInt1079 = (int) Math.sqrt(anInt1075 * anInt1075 + anInt1076 * anInt1076);
        anInt1078 = anInt1079 + (int) Math.sqrt(anInt1075 * anInt1075 + anInt1077 * anInt1077);
    }

    public void method309(boolean flag) {
        anInt1076 = 0;
        anInt1075 = 0;
        if (!flag)
            anInt1048 = 315;
        anInt1077 = 0;
        anInt1071 = 0xf423f;
        anInt1072 = 0xfff0bdc1;
        anInt1073 = 0xfffe7961;
        anInt1074 = 0x1869f;
        for (int i = 0; i < anInt1051; i++) {
            int j = anIntArray1052[i];
            int k = anIntArray1053[i];
            int l = anIntArray1054[i];
            if (j < anInt1071)
                anInt1071 = j;
            if (j > anInt1072)
                anInt1072 = j;
            if (l < anInt1074)
                anInt1074 = l;
            if (l > anInt1073)
                anInt1073 = l;
            if (-k > anInt1076)
                anInt1076 = -k;
            if (k > anInt1077)
                anInt1077 = k;
            int i1 = j * j + l * l;
            if (i1 > anInt1075)
                anInt1075 = i1;
        }

        anInt1075 = (int) Math.sqrt(anInt1075);
        anInt1079 = (int) Math.sqrt(anInt1075 * anInt1075 + anInt1076 * anInt1076);
        anInt1078 = anInt1079 + (int) Math.sqrt(anInt1075 * anInt1075 + anInt1077 * anInt1077);
    }

    public void method310(byte byte0) {
        if (byte0 != 3) {
            for (int i = 1; i > 0; i++) ;
        }
        if (anIntArray1081 != null) {
            int[] ai = new int[256];
            int j = 0;
            for (int l = 0; l < anInt1051; l++) {
                int j1 = anIntArray1081[l];
                ai[j1]++;
                if (j1 > j)
                    j = j1;
            }

            anIntArrayArray1083 = new int[j + 1][];
            for (int k1 = 0; k1 <= j; k1++) {
                anIntArrayArray1083[k1] = new int[ai[k1]];
                ai[k1] = 0;
            }

            for (int j2 = 0; j2 < anInt1051; j2++) {
                int l2 = anIntArray1081[j2];
                anIntArrayArray1083[l2][ai[l2]++] = j2;
            }

            anIntArray1081 = null;
        }
        if (anIntArray1082 != null) {
            int[] ai1 = new int[256];
            int k = 0;
            for (int i1 = 0; i1 < anInt1055; i1++) {
                int l1 = anIntArray1082[i1];
                ai1[l1]++;
                if (l1 > k)
                    k = l1;
            }

            anIntArrayArray1084 = new int[k + 1][];
            for (int i2 = 0; i2 <= k; i2++) {
                anIntArrayArray1084[i2] = new int[ai1[i2]];
                ai1[i2] = 0;
            }

            for (int k2 = 0; k2 < anInt1055; k2++) {
                int i3 = anIntArray1082[k2];
                anIntArrayArray1084[i3][ai1[i3]++] = k2;
            }

            anIntArray1082 = null;
        }
    }

    public void applyFrame(int i, int j) {
        if (anIntArrayArray1083 == null)
            return;
        if (j == -1)
            return;
        SeqFrame class11 = SeqFrame.aSeqFrameArray180[j];
        SeqBase class9 = class11.aSeqBase_182;
        anInt1121 = 0;
        anInt1122 = 0;
        if (i != 7)
            anInt1048 = -198;
        anInt1123 = 0;
        for (int k = 0; k < class11.anInt183; k++) {
            int l = class11.anIntArray184[k];
            transform(class9.anIntArray171[l], class9.anIntArrayArray172[l], class11.anIntArray185[k], class11.anIntArray186[k], class11.anIntArray187[k]);
        }

    }

    public void method312(int i, int j, int[] ai, int k) {
        if (i == -1)
            return;
        if (ai == null || k == -1) {
            applyFrame(7, i);
            return;
        }
        SeqFrame class11 = SeqFrame.aSeqFrameArray180[i];
        SeqFrame class11_1 = SeqFrame.aSeqFrameArray180[k];
        SeqBase class9 = class11.aSeqBase_182;
        anInt1121 = 0;
        if (j != 2) {
            for (int l = 1; l > 0; l++) ;
        }
        anInt1122 = 0;
        anInt1123 = 0;
        int i1 = 0;
        int j1 = ai[i1++];
        for (int k1 = 0; k1 < class11.anInt183; k1++) {
            int l1;
            for (l1 = class11.anIntArray184[k1]; l1 > j1; j1 = ai[i1++]) ;
            if (l1 != j1 || class9.anIntArray171[l1] == 0)
                transform(class9.anIntArray171[l1], class9.anIntArrayArray172[l1], class11.anIntArray185[k1], class11.anIntArray186[k1], class11.anIntArray187[k1]);
        }

        anInt1121 = 0;
        anInt1122 = 0;
        anInt1123 = 0;
        i1 = 0;
        j1 = ai[i1++];
        for (int i2 = 0; i2 < class11_1.anInt183; i2++) {
            int j2;
            for (j2 = class11_1.anIntArray184[i2]; j2 > j1; j1 = ai[i1++]) ;
            if (j2 == j1 || class9.anIntArray171[j2] == 0)
                transform(class9.anIntArray171[j2], class9.anIntArrayArray172[j2], class11_1.anIntArray185[i2], class11_1.anIntArray186[i2], class11_1.anIntArray187[i2]);
        }

    }

    public void transform(int i, int[] ai, int j, int k, int l) {
        int i1 = ai.length;
        if (i == 0) {
            int j1 = 0;
            anInt1121 = 0;
            anInt1122 = 0;
            anInt1123 = 0;
            for (int k2 = 0; k2 < i1; k2++) {
                int l3 = ai[k2];
                if (l3 < anIntArrayArray1083.length) {
                    int[] ai5 = anIntArrayArray1083[l3];
                    for (int i5 = 0; i5 < ai5.length; i5++) {
                        int j6 = ai5[i5];
                        anInt1121 += anIntArray1052[j6];
                        anInt1122 += anIntArray1053[j6];
                        anInt1123 += anIntArray1054[j6];
                        j1++;
                    }

                }
            }

            if (j1 > 0) {
                anInt1121 = anInt1121 / j1 + j;
                anInt1122 = anInt1122 / j1 + k;
                anInt1123 = anInt1123 / j1 + l;
                return;
            } else {
                anInt1121 = j;
                anInt1122 = k;
                anInt1123 = l;
                return;
            }
        }
        if (i == 1) {
            for (int k1 = 0; k1 < i1; k1++) {
                int l2 = ai[k1];
                if (l2 < anIntArrayArray1083.length) {
                    int[] ai1 = anIntArrayArray1083[l2];
                    for (int i4 = 0; i4 < ai1.length; i4++) {
                        int j5 = ai1[i4];
                        anIntArray1052[j5] += j;
                        anIntArray1053[j5] += k;
                        anIntArray1054[j5] += l;
                    }

                }
            }

            return;
        }
        if (i == 2) {
            for (int l1 = 0; l1 < i1; l1++) {
                int i3 = ai[l1];
                if (i3 < anIntArrayArray1083.length) {
                    int[] ai2 = anIntArrayArray1083[i3];
                    for (int j4 = 0; j4 < ai2.length; j4++) {
                        int k5 = ai2[j4];
                        anIntArray1052[k5] -= anInt1121;
                        anIntArray1053[k5] -= anInt1122;
                        anIntArray1054[k5] -= anInt1123;
                        int k6 = (j & 0xff) * 8;
                        int l6 = (k & 0xff) * 8;
                        int i7 = (l & 0xff) * 8;
                        if (i7 != 0) {
                            int j7 = anIntArray1129[i7];
                            int i8 = anIntArray1130[i7];
                            int l8 = anIntArray1053[k5] * j7 + anIntArray1052[k5] * i8 >> 16;
                            anIntArray1053[k5] = anIntArray1053[k5] * i8 - anIntArray1052[k5] * j7 >> 16;
                            anIntArray1052[k5] = l8;
                        }
                        if (k6 != 0) {
                            int k7 = anIntArray1129[k6];
                            int j8 = anIntArray1130[k6];
                            int i9 = anIntArray1053[k5] * j8 - anIntArray1054[k5] * k7 >> 16;
                            anIntArray1054[k5] = anIntArray1053[k5] * k7 + anIntArray1054[k5] * j8 >> 16;
                            anIntArray1053[k5] = i9;
                        }
                        if (l6 != 0) {
                            int l7 = anIntArray1129[l6];
                            int k8 = anIntArray1130[l6];
                            int j9 = anIntArray1054[k5] * l7 + anIntArray1052[k5] * k8 >> 16;
                            anIntArray1054[k5] = anIntArray1054[k5] * k8 - anIntArray1052[k5] * l7 >> 16;
                            anIntArray1052[k5] = j9;
                        }
                        anIntArray1052[k5] += anInt1121;
                        anIntArray1053[k5] += anInt1122;
                        anIntArray1054[k5] += anInt1123;
                    }

                }
            }

            return;
        }
        if (i == 3) {
            for (int i2 = 0; i2 < i1; i2++) {
                int j3 = ai[i2];
                if (j3 < anIntArrayArray1083.length) {
                    int[] ai3 = anIntArrayArray1083[j3];
                    for (int k4 = 0; k4 < ai3.length; k4++) {
                        int l5 = ai3[k4];
                        anIntArray1052[l5] -= anInt1121;
                        anIntArray1053[l5] -= anInt1122;
                        anIntArray1054[l5] -= anInt1123;
                        anIntArray1052[l5] = (anIntArray1052[l5] * j) / 128;
                        anIntArray1053[l5] = (anIntArray1053[l5] * k) / 128;
                        anIntArray1054[l5] = (anIntArray1054[l5] * l) / 128;
                        anIntArray1052[l5] += anInt1121;
                        anIntArray1053[l5] += anInt1122;
                        anIntArray1054[l5] += anInt1123;
                    }

                }
            }

            return;
        }
        if (i == 5 && anIntArrayArray1084 != null) {
            for (int j2 = 0; j2 < i1; j2++) {
                int k3 = ai[j2];
                if (k3 < anIntArrayArray1084.length) {
                    int[] ai4 = anIntArrayArray1084[k3];
                    for (int l4 = 0; l4 < ai4.length; l4++) {
                        int i6 = ai4[l4];
                        anIntArray1064[i6] += j * 8;
                        if (anIntArray1064[i6] < 0)
                            anIntArray1064[i6] = 0;
                        if (anIntArray1064[i6] > 255)
                            anIntArray1064[i6] = 255;
                    }

                }
            }

        }
    }

    public void method314(byte byte0) {
        if (byte0 != 0)
            return;
        for (int i = 0; i < anInt1051; i++) {
            int j = anIntArray1052[i];
            anIntArray1052[i] = anIntArray1054[i];
            anIntArray1054[i] = -j;
        }

    }

    public void method315(int i, byte byte0) {
        int j = anIntArray1129[i];
        int k = anIntArray1130[i];
        if (byte0 != -42)
            anInt1048 = -203;
        for (int l = 0; l < anInt1051; l++) {
            int i1 = anIntArray1053[l] * k - anIntArray1054[l] * j >> 16;
            anIntArray1054[l] = anIntArray1053[l] * j + anIntArray1054[l] * k >> 16;
            anIntArray1053[l] = i1;
        }

    }

    public void method316(int i, int j, int k, int l) {
        for (int i1 = 0; i1 < anInt1051; i1++) {
            anIntArray1052[i1] += k;
            anIntArray1053[i1] += l;
            anIntArray1054[i1] += i;
        }

        if (j == 0) ;
    }

    public void method317(int i, int j) {
        for (int k = 0; k < anInt1055; k++)
            if (anIntArray1065[k] == i)
                anIntArray1065[k] = j;

    }

    public void method318(int i) {
        for (int j = 0; j < anInt1051; j++)
            anIntArray1054[j] = -anIntArray1054[j];

        for (int k = 0; k < anInt1055; k++) {
            int l = anIntArray1056[k];
            anIntArray1056[k] = anIntArray1058[k];
            anIntArray1058[k] = l;
        }

        if (i == anInt1049) ;
    }

    public void method319(int i, int j, int k, int l) {
        if (i <= 0)
            aBoolean1050 = !aBoolean1050;
        for (int i1 = 0; i1 < anInt1051; i1++) {
            anIntArray1052[i1] = (anIntArray1052[i1] * j) / 128;
            anIntArray1053[i1] = (anIntArray1053[i1] * k) / 128;
            anIntArray1054[i1] = (anIntArray1054[i1] * l) / 128;
        }

    }

    public void method320(int i, int j, int k, int l, int i1, boolean flag) {
        int j1 = (int) Math.sqrt(k * k + l * l + i1 * i1);
        int k1 = j * j1 >> 8;
        if (anIntArray1059 == null) {
            anIntArray1059 = new int[anInt1055];
            anIntArray1060 = new int[anInt1055];
            anIntArray1061 = new int[anInt1055];
        }
        if (aVertexNormalArray1086 == null) {
            aVertexNormalArray1086 = new VertexNormal[anInt1051];
            for (int l1 = 0; l1 < anInt1051; l1++)
                aVertexNormalArray1086[l1] = new VertexNormal();

        }
        for (int i2 = 0; i2 < anInt1055; i2++) {
            int j2 = anIntArray1056[i2];
            int l2 = anIntArray1057[i2];
            int i3 = anIntArray1058[i2];
            int j3 = anIntArray1052[l2] - anIntArray1052[j2];
            int k3 = anIntArray1053[l2] - anIntArray1053[j2];
            int l3 = anIntArray1054[l2] - anIntArray1054[j2];
            int i4 = anIntArray1052[i3] - anIntArray1052[j2];
            int j4 = anIntArray1053[i3] - anIntArray1053[j2];
            int k4 = anIntArray1054[i3] - anIntArray1054[j2];
            int l4 = k3 * k4 - j4 * l3;
            int i5 = l3 * i4 - k4 * j3;
            int j5;
            for (j5 = j3 * j4 - i4 * k3; l4 > 8192 || i5 > 8192 || j5 > 8192 || l4 < -8192 || i5 < -8192 || j5 < -8192; j5 >>= 1) {
                l4 >>= 1;
                i5 >>= 1;
            }

            int k5 = (int) Math.sqrt(l4 * l4 + i5 * i5 + j5 * j5);
            if (k5 <= 0)
                k5 = 1;
            l4 = (l4 * 256) / k5;
            i5 = (i5 * 256) / k5;
            j5 = (j5 * 256) / k5;
            if (anIntArray1062 == null || (anIntArray1062[i2] & 1) == 0) {
                VertexNormal class22_2 = aVertexNormalArray1086[j2];
                class22_2.anInt323 += l4;
                class22_2.anInt324 += i5;
                class22_2.anInt325 += j5;
                class22_2.anInt326++;
                class22_2 = aVertexNormalArray1086[l2];
                class22_2.anInt323 += l4;
                class22_2.anInt324 += i5;
                class22_2.anInt325 += j5;
                class22_2.anInt326++;
                class22_2 = aVertexNormalArray1086[i3];
                class22_2.anInt323 += l4;
                class22_2.anInt324 += i5;
                class22_2.anInt325 += j5;
                class22_2.anInt326++;
            } else {
                int l5 = i + (k * l4 + l * i5 + i1 * j5) / (k1 + k1 / 2);
                anIntArray1059[i2] = method322(anIntArray1065[i2], l5, anIntArray1062[i2]);
            }
        }

        if (flag) {
            method321(i, k1, k, l, i1);
        } else {
            aVertexNormalArray1087 = new VertexNormal[anInt1051];
            for (int k2 = 0; k2 < anInt1051; k2++) {
                VertexNormal class22 = aVertexNormalArray1086[k2];
                VertexNormal class22_1 = aVertexNormalArray1087[k2] = new VertexNormal();
                class22_1.anInt323 = class22.anInt323;
                class22_1.anInt324 = class22.anInt324;
                class22_1.anInt325 = class22.anInt325;
                class22_1.anInt326 = class22.anInt326;
            }

        }
        if (flag) {
            method308(569);
            return;
        } else {
            method309(true);
            return;
        }
    }

    public void method321(int i, int j, int k, int l, int i1) {
        for (int j1 = 0; j1 < anInt1055; j1++) {
            int k1 = anIntArray1056[j1];
            int i2 = anIntArray1057[j1];
            int j2 = anIntArray1058[j1];
            if (anIntArray1062 == null) {
                int i3 = anIntArray1065[j1];
                VertexNormal class22 = aVertexNormalArray1086[k1];
                int k2 = i + (k * class22.anInt323 + l * class22.anInt324 + i1 * class22.anInt325) / (j * class22.anInt326);
                anIntArray1059[j1] = method322(i3, k2, 0);
                class22 = aVertexNormalArray1086[i2];
                k2 = i + (k * class22.anInt323 + l * class22.anInt324 + i1 * class22.anInt325) / (j * class22.anInt326);
                anIntArray1060[j1] = method322(i3, k2, 0);
                class22 = aVertexNormalArray1086[j2];
                k2 = i + (k * class22.anInt323 + l * class22.anInt324 + i1 * class22.anInt325) / (j * class22.anInt326);
                anIntArray1061[j1] = method322(i3, k2, 0);
            } else if ((anIntArray1062[j1] & 1) == 0) {
                int j3 = anIntArray1065[j1];
                int k3 = anIntArray1062[j1];
                VertexNormal class22_1 = aVertexNormalArray1086[k1];
                int l2 = i + (k * class22_1.anInt323 + l * class22_1.anInt324 + i1 * class22_1.anInt325) / (j * class22_1.anInt326);
                anIntArray1059[j1] = method322(j3, l2, k3);
                class22_1 = aVertexNormalArray1086[i2];
                l2 = i + (k * class22_1.anInt323 + l * class22_1.anInt324 + i1 * class22_1.anInt325) / (j * class22_1.anInt326);
                anIntArray1060[j1] = method322(j3, l2, k3);
                class22_1 = aVertexNormalArray1086[j2];
                l2 = i + (k * class22_1.anInt323 + l * class22_1.anInt324 + i1 * class22_1.anInt325) / (j * class22_1.anInt326);
                anIntArray1061[j1] = method322(j3, l2, k3);
            }
        }

        aVertexNormalArray1086 = null;
        aVertexNormalArray1087 = null;
        anIntArray1081 = null;
        anIntArray1082 = null;
        if (anIntArray1062 != null) {
            for (int l1 = 0; l1 < anInt1055; l1++)
                if ((anIntArray1062[l1] & 2) == 2)
                    return;

        }
        anIntArray1065 = null;
    }

    public static int method322(int i, int j, int k) {
        if ((k & 2) == 2) {
            if (j < 0)
                j = 0;
            else if (j > 127)
                j = 127;
            j = 127 - j;
            return j;
        }
        j = j * (i & 0x7f) >> 7;
        if (j < 2)
            j = 2;
        else if (j > 126)
            j = 126;
        return (i & 0xff80) + j;
    }

    public void method323(int i, int j, int k, int l, int i1, int j1, int k1) {
        int l1 = Draw3D.anInt1267;
        int i2 = Draw3D.anInt1268;
        int j2 = anIntArray1129[i];
        int k2 = anIntArray1130[i];
        int l2 = anIntArray1129[j];
        int i3 = anIntArray1130[j];
        int j3 = anIntArray1129[k];
        int k3 = anIntArray1130[k];
        int l3 = anIntArray1129[l];
        int i4 = anIntArray1130[l];
        int j4 = j1 * l3 + k1 * i4 >> 16;
        for (int k4 = 0; k4 < anInt1051; k4++) {
            int l4 = anIntArray1052[k4];
            int i5 = anIntArray1053[k4];
            int j5 = anIntArray1054[k4];
            if (k != 0) {
                int k5 = i5 * j3 + l4 * k3 >> 16;
                i5 = i5 * k3 - l4 * j3 >> 16;
                l4 = k5;
            }
            if (i != 0) {
                int l5 = i5 * k2 - j5 * j2 >> 16;
                j5 = i5 * j2 + j5 * k2 >> 16;
                i5 = l5;
            }
            if (j != 0) {
                int i6 = j5 * l2 + l4 * i3 >> 16;
                j5 = j5 * i3 - l4 * l2 >> 16;
                l4 = i6;
            }
            l4 += i1;
            i5 += j1;
            j5 += k1;
            int j6 = i5 * i4 - j5 * l3 >> 16;
            j5 = i5 * l3 + j5 * i4 >> 16;
            i5 = j6;
            anIntArray1107[k4] = j5 - j4;
            anIntArray1105[k4] = l1 + (l4 << 9) / j5;
            anIntArray1106[k4] = i2 + (i5 << 9) / j5;
            if (anInt1067 > 0) {
                anIntArray1108[k4] = l4;
                anIntArray1109[k4] = i5;
                anIntArray1110[k4] = j5;
            }
        }

        try {
            method325(false, false, 0);
            return;
        } catch (Exception _ex) {
            return;
        }
    }

    public void method324(int i, int j, int k, int l, int i1, int j1, int k1,
                          int l1, int i2) {
        int j2 = l1 * i1 - j1 * l >> 16;
        int k2 = k1 * j + j2 * k >> 16;
        int l2 = anInt1075 * k >> 16;
        int i3 = k2 + l2;
        if (i3 <= 50 || k2 >= 3500)
            return;
        int j3 = l1 * l + j1 * i1 >> 16;
        int k3 = j3 - anInt1075 << 9;
        if (k3 / i3 >= Draw2D.anInt1145)
            return;
        int l3 = j3 + anInt1075 << 9;
        if (l3 / i3 <= -Draw2D.anInt1145)
            return;
        int i4 = k1 * k - j2 * j >> 16;
        int j4 = anInt1075 * j >> 16;
        int k4 = i4 + j4 << 9;
        if (k4 / i3 <= -Draw2D.anInt1146)
            return;
        int l4 = j4 + (anInt1076 * k >> 16);
        int i5 = i4 - l4 << 9;
        if (i5 / i3 >= Draw2D.anInt1146)
            return;
        int j5 = l2 + (anInt1076 * j >> 16);
        boolean flag = k2 - j5 <= 50;
        boolean flag1 = false;
        if (i2 > 0 && aBoolean1124) {
            int k5 = k2 - l2;
            if (k5 <= 50)
                k5 = 50;
            if (j3 > 0) {
                k3 /= i3;
                l3 /= k5;
            } else {
                l3 /= i3;
                k3 /= k5;
            }
            if (i4 > 0) {
                i5 /= i3;
                k4 /= k5;
            } else {
                k4 /= i3;
                i5 /= k5;
            }
            int i6 = anInt1125 - Draw3D.anInt1267;
            int k6 = anInt1126 - Draw3D.anInt1268;
            if (i6 > k3 && i6 < l3 && k6 > i5 && k6 < k4)
                if (aBoolean1085)
                    anIntArray1128[anInt1127++] = i2;
                else
                    flag1 = true;
        }
        int l5 = Draw3D.anInt1267;
        int j6 = Draw3D.anInt1268;
        int l6 = 0;
        int i7 = 0;
        if (i != 0) {
            l6 = anIntArray1129[i];
            i7 = anIntArray1130[i];
        }
        for (int j7 = 0; j7 < anInt1051; j7++) {
            int k7 = anIntArray1052[j7];
            int l7 = anIntArray1053[j7];
            int i8 = anIntArray1054[j7];
            if (i != 0) {
                int j8 = i8 * l6 + k7 * i7 >> 16;
                i8 = i8 * i7 - k7 * l6 >> 16;
                k7 = j8;
            }
            k7 += j1;
            l7 += k1;
            i8 += l1;
            int k8 = i8 * l + k7 * i1 >> 16;
            i8 = i8 * i1 - k7 * l >> 16;
            k7 = k8;
            k8 = l7 * k - i8 * j >> 16;
            i8 = l7 * j + i8 * k >> 16;
            l7 = k8;
            anIntArray1107[j7] = i8 - k2;
            if (i8 >= 50) {
                anIntArray1105[j7] = l5 + (k7 << 9) / i8;
                anIntArray1106[j7] = j6 + (l7 << 9) / i8;
            } else {
                anIntArray1105[j7] = -5000;
                flag = true;
            }
            if (flag || anInt1067 > 0) {
                anIntArray1108[j7] = k7;
                anIntArray1109[j7] = l7;
                anIntArray1110[j7] = i8;
            }
        }

        try {
            method325(flag, flag1, i2);
            return;
        } catch (Exception _ex) {
            return;
        }
    }

    public void method325(boolean flag, boolean flag1, int i) {
        for (int j = 0; j < anInt1078; j++)
            anIntArray1111[j] = 0;

        for (int k = 0; k < anInt1055; k++)
            if (anIntArray1062 == null || anIntArray1062[k] != -1) {
                int l = anIntArray1056[k];
                int k1 = anIntArray1057[k];
                int j2 = anIntArray1058[k];
                int i3 = anIntArray1105[l];
                int l3 = anIntArray1105[k1];
                int k4 = anIntArray1105[j2];
                if (flag && (i3 == -5000 || l3 == -5000 || k4 == -5000)) {
                    aBooleanArray1104[k] = true;
                    int j5 = (anIntArray1107[l] + anIntArray1107[k1] + anIntArray1107[j2]) / 3 + anInt1079;
                    anIntArrayArray1112[j5][anIntArray1111[j5]++] = k;
                } else {
                    if (flag1 && method328(anInt1125, anInt1126, anIntArray1106[l], anIntArray1106[k1], anIntArray1106[j2], i3, l3, k4)) {
                        anIntArray1128[anInt1127++] = i;
                        flag1 = false;
                    }
                    if ((i3 - l3) * (anIntArray1106[j2] - anIntArray1106[k1]) - (anIntArray1106[l] - anIntArray1106[k1]) * (k4 - l3) > 0) {
                        aBooleanArray1104[k] = false;
                        aBooleanArray1103[k] = i3 < 0 || l3 < 0 || k4 < 0 || i3 > Draw2D.anInt1144 || l3 > Draw2D.anInt1144 || k4 > Draw2D.anInt1144;
                        int k5 = (anIntArray1107[l] + anIntArray1107[k1] + anIntArray1107[j2]) / 3 + anInt1079;
                        anIntArrayArray1112[k5][anIntArray1111[k5]++] = k;
                    }
                }
            }

        if (anIntArray1063 == null) {
            for (int i1 = anInt1078 - 1; i1 >= 0; i1--) {
                int l1 = anIntArray1111[i1];
                if (l1 > 0) {
                    int[] ai = anIntArrayArray1112[i1];
                    for (int j3 = 0; j3 < l1; j3++)
                        method326(ai[j3]);

                }
            }

            return;
        }
        for (int j1 = 0; j1 < 12; j1++) {
            anIntArray1113[j1] = 0;
            anIntArray1117[j1] = 0;
        }

        for (int i2 = anInt1078 - 1; i2 >= 0; i2--) {
            int k2 = anIntArray1111[i2];
            if (k2 > 0) {
                int[] ai1 = anIntArrayArray1112[i2];
                for (int i4 = 0; i4 < k2; i4++) {
                    int l4 = ai1[i4];
                    int l5 = anIntArray1063[l4];
                    int j6 = anIntArray1113[l5]++;
                    anIntArrayArray1114[l5][j6] = l4;
                    if (l5 < 10)
                        anIntArray1117[l5] += i2;
                    else if (l5 == 10)
                        anIntArray1115[j6] = i2;
                    else
                        anIntArray1116[j6] = i2;
                }

            }
        }

        int l2 = 0;
        if (anIntArray1113[1] > 0 || anIntArray1113[2] > 0)
            l2 = (anIntArray1117[1] + anIntArray1117[2]) / (anIntArray1113[1] + anIntArray1113[2]);
        int k3 = 0;
        if (anIntArray1113[3] > 0 || anIntArray1113[4] > 0)
            k3 = (anIntArray1117[3] + anIntArray1117[4]) / (anIntArray1113[3] + anIntArray1113[4]);
        int j4 = 0;
        if (anIntArray1113[6] > 0 || anIntArray1113[8] > 0)
            j4 = (anIntArray1117[6] + anIntArray1117[8]) / (anIntArray1113[6] + anIntArray1113[8]);
        int i6 = 0;
        int k6 = anIntArray1113[10];
        int[] ai2 = anIntArrayArray1114[10];
        int[] ai3 = anIntArray1115;
        if (i6 == k6) {
            i6 = 0;
            k6 = anIntArray1113[11];
            ai2 = anIntArrayArray1114[11];
            ai3 = anIntArray1116;
        }
        int i5;
        if (i6 < k6)
            i5 = ai3[i6];
        else
            i5 = -1000;
        for (int l6 = 0; l6 < 10; l6++) {
            while (l6 == 0 && i5 > l2) {
                method326(ai2[i6++]);
                if (i6 == k6 && ai2 != anIntArrayArray1114[11]) {
                    i6 = 0;
                    k6 = anIntArray1113[11];
                    ai2 = anIntArrayArray1114[11];
                    ai3 = anIntArray1116;
                }
                if (i6 < k6)
                    i5 = ai3[i6];
                else
                    i5 = -1000;
            }
            while (l6 == 3 && i5 > k3) {
                method326(ai2[i6++]);
                if (i6 == k6 && ai2 != anIntArrayArray1114[11]) {
                    i6 = 0;
                    k6 = anIntArray1113[11];
                    ai2 = anIntArrayArray1114[11];
                    ai3 = anIntArray1116;
                }
                if (i6 < k6)
                    i5 = ai3[i6];
                else
                    i5 = -1000;
            }
            while (l6 == 5 && i5 > j4) {
                method326(ai2[i6++]);
                if (i6 == k6 && ai2 != anIntArrayArray1114[11]) {
                    i6 = 0;
                    k6 = anIntArray1113[11];
                    ai2 = anIntArrayArray1114[11];
                    ai3 = anIntArray1116;
                }
                if (i6 < k6)
                    i5 = ai3[i6];
                else
                    i5 = -1000;
            }
            int i7 = anIntArray1113[l6];
            int[] ai4 = anIntArrayArray1114[l6];
            for (int j7 = 0; j7 < i7; j7++)
                method326(ai4[j7]);

        }

        while (i5 != -1000) {
            method326(ai2[i6++]);
            if (i6 == k6 && ai2 != anIntArrayArray1114[11]) {
                i6 = 0;
                ai2 = anIntArrayArray1114[11];
                k6 = anIntArray1113[11];
                ai3 = anIntArray1116;
            }
            if (i6 < k6)
                i5 = ai3[i6];
            else
                i5 = -1000;
        }
    }

    public void method326(int i) {
        if (aBooleanArray1104[i]) {
            method327(i);
            return;
        }
        int j = anIntArray1056[i];
        int k = anIntArray1057[i];
        int l = anIntArray1058[i];
        Draw3D.aBoolean1263 = aBooleanArray1103[i];
        if (anIntArray1064 == null)
            Draw3D.anInt1266 = 0;
        else
            Draw3D.anInt1266 = anIntArray1064[i];
        int i1;
        if (anIntArray1062 == null)
            i1 = 0;
        else
            i1 = anIntArray1062[i] & 3;
        if (i1 == 0) {
            Draw3D.method348(anIntArray1106[j], anIntArray1106[k], anIntArray1106[l], anIntArray1105[j], anIntArray1105[k], anIntArray1105[l], anIntArray1059[i], anIntArray1060[i], anIntArray1061[i]);
            return;
        }
        if (i1 == 1) {
            Draw3D.method350(anIntArray1106[j], anIntArray1106[k], anIntArray1106[l], anIntArray1105[j], anIntArray1105[k], anIntArray1105[l], anIntArray1131[anIntArray1059[i]]);
            return;
        }
        if (i1 == 2) {
            int j1 = anIntArray1062[i] >> 2;
            int l1 = anIntArray1068[j1];
            int j2 = anIntArray1069[j1];
            int l2 = anIntArray1070[j1];
            Draw3D.method352(anIntArray1106[j], anIntArray1106[k], anIntArray1106[l], anIntArray1105[j], anIntArray1105[k], anIntArray1105[l], anIntArray1059[i], anIntArray1060[i], anIntArray1061[i], anIntArray1108[l1], anIntArray1108[j2], anIntArray1108[l2], anIntArray1109[l1], anIntArray1109[j2], anIntArray1109[l2], anIntArray1110[l1], anIntArray1110[j2], anIntArray1110[l2], anIntArray1065[i]);
            return;
        }
        if (i1 == 3) {
            int k1 = anIntArray1062[i] >> 2;
            int i2 = anIntArray1068[k1];
            int k2 = anIntArray1069[k1];
            int i3 = anIntArray1070[k1];
            Draw3D.method352(anIntArray1106[j], anIntArray1106[k], anIntArray1106[l], anIntArray1105[j], anIntArray1105[k], anIntArray1105[l], anIntArray1059[i], anIntArray1059[i], anIntArray1059[i], anIntArray1108[i2], anIntArray1108[k2], anIntArray1108[i3], anIntArray1109[i2], anIntArray1109[k2], anIntArray1109[i3], anIntArray1110[i2], anIntArray1110[k2], anIntArray1110[i3], anIntArray1065[i]);
        }
    }

    public void method327(int i) {
        int j = Draw3D.anInt1267;
        int k = Draw3D.anInt1268;
        int l = 0;
        int i1 = anIntArray1056[i];
        int j1 = anIntArray1057[i];
        int k1 = anIntArray1058[i];
        int l1 = anIntArray1110[i1];
        int i2 = anIntArray1110[j1];
        int j2 = anIntArray1110[k1];
        if (l1 >= 50) {
            anIntArray1118[l] = anIntArray1105[i1];
            anIntArray1119[l] = anIntArray1106[i1];
            anIntArray1120[l++] = anIntArray1059[i];
        } else {
            int k2 = anIntArray1108[i1];
            int k3 = anIntArray1109[i1];
            int k4 = anIntArray1059[i];
            if (j2 >= 50) {
                int k5 = (50 - l1) * anIntArray1132[j2 - l1];
                anIntArray1118[l] = j + (k2 + ((anIntArray1108[k1] - k2) * k5 >> 16) << 9) / 50;
                anIntArray1119[l] = k + (k3 + ((anIntArray1109[k1] - k3) * k5 >> 16) << 9) / 50;
                anIntArray1120[l++] = k4 + ((anIntArray1061[i] - k4) * k5 >> 16);
            }
            if (i2 >= 50) {
                int l5 = (50 - l1) * anIntArray1132[i2 - l1];
                anIntArray1118[l] = j + (k2 + ((anIntArray1108[j1] - k2) * l5 >> 16) << 9) / 50;
                anIntArray1119[l] = k + (k3 + ((anIntArray1109[j1] - k3) * l5 >> 16) << 9) / 50;
                anIntArray1120[l++] = k4 + ((anIntArray1060[i] - k4) * l5 >> 16);
            }
        }
        if (i2 >= 50) {
            anIntArray1118[l] = anIntArray1105[j1];
            anIntArray1119[l] = anIntArray1106[j1];
            anIntArray1120[l++] = anIntArray1060[i];
        } else {
            int l2 = anIntArray1108[j1];
            int l3 = anIntArray1109[j1];
            int l4 = anIntArray1060[i];
            if (l1 >= 50) {
                int i6 = (50 - i2) * anIntArray1132[l1 - i2];
                anIntArray1118[l] = j + (l2 + ((anIntArray1108[i1] - l2) * i6 >> 16) << 9) / 50;
                anIntArray1119[l] = k + (l3 + ((anIntArray1109[i1] - l3) * i6 >> 16) << 9) / 50;
                anIntArray1120[l++] = l4 + ((anIntArray1059[i] - l4) * i6 >> 16);
            }
            if (j2 >= 50) {
                int j6 = (50 - i2) * anIntArray1132[j2 - i2];
                anIntArray1118[l] = j + (l2 + ((anIntArray1108[k1] - l2) * j6 >> 16) << 9) / 50;
                anIntArray1119[l] = k + (l3 + ((anIntArray1109[k1] - l3) * j6 >> 16) << 9) / 50;
                anIntArray1120[l++] = l4 + ((anIntArray1061[i] - l4) * j6 >> 16);
            }
        }
        if (j2 >= 50) {
            anIntArray1118[l] = anIntArray1105[k1];
            anIntArray1119[l] = anIntArray1106[k1];
            anIntArray1120[l++] = anIntArray1061[i];
        } else {
            int i3 = anIntArray1108[k1];
            int i4 = anIntArray1109[k1];
            int i5 = anIntArray1061[i];
            if (i2 >= 50) {
                int k6 = (50 - j2) * anIntArray1132[i2 - j2];
                anIntArray1118[l] = j + (i3 + ((anIntArray1108[j1] - i3) * k6 >> 16) << 9) / 50;
                anIntArray1119[l] = k + (i4 + ((anIntArray1109[j1] - i4) * k6 >> 16) << 9) / 50;
                anIntArray1120[l++] = i5 + ((anIntArray1060[i] - i5) * k6 >> 16);
            }
            if (l1 >= 50) {
                int l6 = (50 - j2) * anIntArray1132[l1 - j2];
                anIntArray1118[l] = j + (i3 + ((anIntArray1108[i1] - i3) * l6 >> 16) << 9) / 50;
                anIntArray1119[l] = k + (i4 + ((anIntArray1109[i1] - i4) * l6 >> 16) << 9) / 50;
                anIntArray1120[l++] = i5 + ((anIntArray1059[i] - i5) * l6 >> 16);
            }
        }
        int j3 = anIntArray1118[0];
        int j4 = anIntArray1118[1];
        int j5 = anIntArray1118[2];
        int i7 = anIntArray1119[0];
        int j7 = anIntArray1119[1];
        int k7 = anIntArray1119[2];
        if ((j3 - j4) * (k7 - j7) - (i7 - j7) * (j5 - j4) > 0) {
            Draw3D.aBoolean1263 = false;
            if (l == 3) {
                if (j3 < 0 || j4 < 0 || j5 < 0 || j3 > Draw2D.anInt1144 || j4 > Draw2D.anInt1144 || j5 > Draw2D.anInt1144)
                    Draw3D.aBoolean1263 = true;
                int l7;
                if (anIntArray1062 == null)
                    l7 = 0;
                else
                    l7 = anIntArray1062[i] & 3;
                if (l7 == 0)
                    Draw3D.method348(i7, j7, k7, j3, j4, j5, anIntArray1120[0], anIntArray1120[1], anIntArray1120[2]);
                else if (l7 == 1)
                    Draw3D.method350(i7, j7, k7, j3, j4, j5, anIntArray1131[anIntArray1059[i]]);
                else if (l7 == 2) {
                    int j8 = anIntArray1062[i] >> 2;
                    int k9 = anIntArray1068[j8];
                    int k10 = anIntArray1069[j8];
                    int k11 = anIntArray1070[j8];
                    Draw3D.method352(i7, j7, k7, j3, j4, j5, anIntArray1120[0], anIntArray1120[1], anIntArray1120[2], anIntArray1108[k9], anIntArray1108[k10], anIntArray1108[k11], anIntArray1109[k9], anIntArray1109[k10], anIntArray1109[k11], anIntArray1110[k9], anIntArray1110[k10], anIntArray1110[k11], anIntArray1065[i]);
                } else if (l7 == 3) {
                    int k8 = anIntArray1062[i] >> 2;
                    int l9 = anIntArray1068[k8];
                    int l10 = anIntArray1069[k8];
                    int l11 = anIntArray1070[k8];
                    Draw3D.method352(i7, j7, k7, j3, j4, j5, anIntArray1059[i], anIntArray1059[i], anIntArray1059[i], anIntArray1108[l9], anIntArray1108[l10], anIntArray1108[l11], anIntArray1109[l9], anIntArray1109[l10], anIntArray1109[l11], anIntArray1110[l9], anIntArray1110[l10], anIntArray1110[l11], anIntArray1065[i]);
                }
            }
            if (l == 4) {
                if (j3 < 0 || j4 < 0 || j5 < 0 || j3 > Draw2D.anInt1144 || j4 > Draw2D.anInt1144 || j5 > Draw2D.anInt1144 || anIntArray1118[3] < 0 || anIntArray1118[3] > Draw2D.anInt1144)
                    Draw3D.aBoolean1263 = true;
                int i8;
                if (anIntArray1062 == null)
                    i8 = 0;
                else
                    i8 = anIntArray1062[i] & 3;
                if (i8 == 0) {
                    Draw3D.method348(i7, j7, k7, j3, j4, j5, anIntArray1120[0], anIntArray1120[1], anIntArray1120[2]);
                    Draw3D.method348(i7, k7, anIntArray1119[3], j3, j5, anIntArray1118[3], anIntArray1120[0], anIntArray1120[2], anIntArray1120[3]);
                    return;
                }
                if (i8 == 1) {
                    int l8 = anIntArray1131[anIntArray1059[i]];
                    Draw3D.method350(i7, j7, k7, j3, j4, j5, l8);
                    Draw3D.method350(i7, k7, anIntArray1119[3], j3, j5, anIntArray1118[3], l8);
                    return;
                }
                if (i8 == 2) {
                    int i9 = anIntArray1062[i] >> 2;
                    int i10 = anIntArray1068[i9];
                    int i11 = anIntArray1069[i9];
                    int i12 = anIntArray1070[i9];
                    Draw3D.method352(i7, j7, k7, j3, j4, j5, anIntArray1120[0], anIntArray1120[1], anIntArray1120[2], anIntArray1108[i10], anIntArray1108[i11], anIntArray1108[i12], anIntArray1109[i10], anIntArray1109[i11], anIntArray1109[i12], anIntArray1110[i10], anIntArray1110[i11], anIntArray1110[i12], anIntArray1065[i]);
                    Draw3D.method352(i7, k7, anIntArray1119[3], j3, j5, anIntArray1118[3], anIntArray1120[0], anIntArray1120[2], anIntArray1120[3], anIntArray1108[i10], anIntArray1108[i11], anIntArray1108[i12], anIntArray1109[i10], anIntArray1109[i11], anIntArray1109[i12], anIntArray1110[i10], anIntArray1110[i11], anIntArray1110[i12], anIntArray1065[i]);
                    return;
                }
                if (i8 == 3) {
                    int j9 = anIntArray1062[i] >> 2;
                    int j10 = anIntArray1068[j9];
                    int j11 = anIntArray1069[j9];
                    int j12 = anIntArray1070[j9];
                    Draw3D.method352(i7, j7, k7, j3, j4, j5, anIntArray1059[i], anIntArray1059[i], anIntArray1059[i], anIntArray1108[j10], anIntArray1108[j11], anIntArray1108[j12], anIntArray1109[j10], anIntArray1109[j11], anIntArray1109[j12], anIntArray1110[j10], anIntArray1110[j11], anIntArray1110[j12], anIntArray1065[i]);
                    Draw3D.method352(i7, k7, anIntArray1119[3], j3, j5, anIntArray1118[3], anIntArray1059[i], anIntArray1059[i], anIntArray1059[i], anIntArray1108[j10], anIntArray1108[j11], anIntArray1108[j12], anIntArray1109[j10], anIntArray1109[j11], anIntArray1109[j12], anIntArray1110[j10], anIntArray1110[j11], anIntArray1110[j12], anIntArray1065[i]);
                }
            }
        }
    }

    public boolean method328(int i, int j, int k, int l, int i1, int j1, int k1,
                             int l1) {
        if (j < k && j < l && j < i1)
            return false;
        if (j > k && j > l && j > i1)
            return false;
        if (i < j1 && i < k1 && i < l1)
            return false;
        return i <= j1 || i <= k1 || i <= l1;
    }

    public int anInt1048;
    public int anInt1049;
    public boolean aBoolean1050;
    public int anInt1051;
    public int[] anIntArray1052;
    public int[] anIntArray1053;
    public int[] anIntArray1054;
    public int anInt1055;
    public int[] anIntArray1056;
    public int[] anIntArray1057;
    public int[] anIntArray1058;
    public int[] anIntArray1059;
    public int[] anIntArray1060;
    public int[] anIntArray1061;
    public int[] anIntArray1062;
    public int[] anIntArray1063;
    public int[] anIntArray1064;
    public int[] anIntArray1065;
    public int anInt1066;
    public int anInt1067;
    public int[] anIntArray1068;
    public int[] anIntArray1069;
    public int[] anIntArray1070;
    public int anInt1071;
    public int anInt1072;
    public int anInt1073;
    public int anInt1074;
    public int anInt1075;
    public int anInt1076;
    public int anInt1077;
    public int anInt1078;
    public int anInt1079;
    public int anInt1080;
    public int[] anIntArray1081;
    public int[] anIntArray1082;
    public int[][] anIntArrayArray1083;
    public int[][] anIntArrayArray1084;
    public boolean aBoolean1085;
    public VertexNormal[] aVertexNormalArray1086;
    public VertexNormal[] aVertexNormalArray1087;
    public static ModelMetadata[] aModelMetadataArray1088;
    public static Buffer aClass35_Sub2_Sub3_1089;
    public static Buffer aClass35_Sub2_Sub3_1090;
    public static Buffer aClass35_Sub2_Sub3_1091;
    public static Buffer aClass35_Sub2_Sub3_1092;
    public static Buffer aClass35_Sub2_Sub3_1093;
    public static Buffer aClass35_Sub2_Sub3_1094;
    public static Buffer aClass35_Sub2_Sub3_1095;
    public static Buffer aClass35_Sub2_Sub3_1096;
    public static Buffer aClass35_Sub2_Sub3_1097;
    public static Buffer aClass35_Sub2_Sub3_1098;
    public static Buffer aClass35_Sub2_Sub3_1099;
    public static Buffer aClass35_Sub2_Sub3_1100;
    public static Buffer aClass35_Sub2_Sub3_1101;
    public static Buffer aClass35_Sub2_Sub3_1102;
    public static boolean[] aBooleanArray1103 = new boolean[4096];
    public static boolean[] aBooleanArray1104 = new boolean[4096];
    public static int[] anIntArray1105 = new int[4096];
    public static int[] anIntArray1106 = new int[4096];
    public static int[] anIntArray1107 = new int[4096];
    public static int[] anIntArray1108 = new int[4096];
    public static int[] anIntArray1109 = new int[4096];
    public static int[] anIntArray1110 = new int[4096];
    public static int[] anIntArray1111 = new int[1500];
    public static int[][] anIntArrayArray1112 = new int[1500][512];
    public static int[] anIntArray1113 = new int[12];
    public static int[][] anIntArrayArray1114 = new int[12][2000];
    public static int[] anIntArray1115 = new int[2000];
    public static int[] anIntArray1116 = new int[2000];
    public static int[] anIntArray1117 = new int[12];
    public static int[] anIntArray1118 = new int[10];
    public static int[] anIntArray1119 = new int[10];
    public static int[] anIntArray1120 = new int[10];
    public static int anInt1121;
    public static int anInt1122;
    public static int anInt1123;
    public static boolean aBoolean1124;
    public static int anInt1125;
    public static int anInt1126;
    public static int anInt1127;
    public static int[] anIntArray1128 = new int[1000];
    public static int[] anIntArray1129;
    public static int[] anIntArray1130;
    public static int[] anIntArray1131;
    public static int[] anIntArray1132;
    public static int anInt1133;

    static {
        anIntArray1129 = Draw3D.anIntArray1271;
        anIntArray1130 = Draw3D.anIntArray1272;
        anIntArray1131 = Draw3D.anIntArray1283;
        anIntArray1132 = Draw3D.anIntArray1270;
    }
}
