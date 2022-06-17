package com.jagex.game.runetek3.graphics.ui;

// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

import com.jagex.core.io.Buffer;
import com.jagex.core.io.FileArchive;
import com.jagex.core.stringutils.StringUtils;
import com.jagex.core.utils.Cache;
import com.jagex.game.runetek3.graphics.Sprite;
import com.jagex.game.runetek3.graphics.model.Model;

public class Component {

    public static void decode(FileArchive class36, FileArchive class36_1, Font[] aclass35_sub2_sub2_sub4) {
        aCache_167 = new Cache(50000);
        aCache_168 = new Cache(50000);
        Buffer class35_sub2_sub3 = new Buffer(class36_1.read(null, "data"));
        int j = -1;
        int k = class35_sub2_sub3.g2();
        aComponentArray110 = new Component[k];
        while (class35_sub2_sub3.pos < class35_sub2_sub3.data.length) {
            int l = class35_sub2_sub3.g2();
            if (l == 65535) {
                j = class35_sub2_sub3.g2();
                l = class35_sub2_sub3.g2();
            }
            Component class8 = aComponentArray110[l] = new Component();
            class8.anInt115 = l;
            class8.anInt116 = j;
            class8.anInt117 = class35_sub2_sub3.g1();
            class8.anInt118 = class35_sub2_sub3.g1();
            class8.anInt119 = class35_sub2_sub3.g2();
            class8.anInt120 = class35_sub2_sub3.g2();
            class8.anInt121 = class35_sub2_sub3.g2();
            class8.anInt127 = class35_sub2_sub3.g1();
            if (class8.anInt127 != 0)
                class8.anInt127 = (class8.anInt127 - 1 << 8) + class35_sub2_sub3.g1();
            else
                class8.anInt127 = -1;
            int j1 = class35_sub2_sub3.g1();
            if (j1 > 0) {
                class8.anIntArray125 = new int[j1];
                class8.anIntArray126 = new int[j1];
                for (int k1 = 0; k1 < j1; k1++) {
                    class8.anIntArray125[k1] = class35_sub2_sub3.g1();
                    class8.anIntArray126[k1] = class35_sub2_sub3.g2();
                }

            }
            int l1 = class35_sub2_sub3.g1();
            if (l1 > 0) {
                class8.anIntArrayArray124 = new int[l1][];
                for (int i2 = 0; i2 < l1; i2++) {
                    int j3 = class35_sub2_sub3.g2();
                    class8.anIntArrayArray124[i2] = new int[j3];
                    for (int i5 = 0; i5 < j3; i5++)
                        class8.anIntArrayArray124[i2][i5] = class35_sub2_sub3.g2();

                }

            }
            if (class8.anInt117 == 0) {
                class8.anInt128 = class35_sub2_sub3.g2();
                class8.aBoolean130 = class35_sub2_sub3.g1() == 1;
                int j2 = class35_sub2_sub3.g1();
                class8.anIntArray131 = new int[j2];
                class8.anIntArray132 = new int[j2];
                class8.anIntArray133 = new int[j2];
                for (int k3 = 0; k3 < j2; k3++) {
                    class8.anIntArray131[k3] = class35_sub2_sub3.g2();
                    class8.anIntArray132[k3] = class35_sub2_sub3.g2b();
                    class8.anIntArray133[k3] = class35_sub2_sub3.g2b();
                }

            }
            if (class8.anInt117 == 1) {
                class8.anInt134 = class35_sub2_sub3.g2();
                class8.aBoolean135 = class35_sub2_sub3.g1() == 1;
            }
            if (class8.anInt117 == 2) {
                class8.anIntArray111 = new int[class8.anInt120 * class8.anInt121];
                class8.anIntArray112 = new int[class8.anInt120 * class8.anInt121];
                class8.aBoolean136 = class35_sub2_sub3.g1() == 1;
                class8.aBoolean137 = class35_sub2_sub3.g1() == 1;
                class8.aBoolean138 = class35_sub2_sub3.g1() == 1;
                class8.anInt139 = class35_sub2_sub3.g1();
                class8.anInt140 = class35_sub2_sub3.g1();
                class8.anIntArray142 = new int[20];
                class8.anIntArray143 = new int[20];
                class8.aSpriteArray141 = new Sprite[20];
                for (int k2 = 0; k2 < 20; k2++) {
                    int l3 = class35_sub2_sub3.g1();
                    if (l3 == 1) {
                        class8.anIntArray142[k2] = class35_sub2_sub3.g2b();
                        class8.anIntArray143[k2] = class35_sub2_sub3.g2b();
                        String s1 = class35_sub2_sub3.gstr();
                        if (class36 != null && s1.length() > 0) {
                            int j5 = s1.lastIndexOf(",");
                            class8.aSpriteArray141[k2] = method175(Integer.parseInt(s1.substring(j5 + 1)), (byte) -128, s1.substring(0, j5), class36);
                        }
                    }
                }

                class8.aStringArray144 = new String[5];
                for (int i4 = 0; i4 < 5; i4++) {
                    class8.aStringArray144[i4] = class35_sub2_sub3.gstr();
                    if (class8.aStringArray144[i4].length() == 0)
                        class8.aStringArray144[i4] = null;
                }

            }
            if (class8.anInt117 == 3)
                class8.aBoolean145 = class35_sub2_sub3.g1() == 1;
            if (class8.anInt117 == 4 || class8.anInt117 == 1) {
                class8.aBoolean146 = class35_sub2_sub3.g1() == 1;
                int l2 = class35_sub2_sub3.g1();
                if (aclass35_sub2_sub2_sub4 != null)
                    class8.aClass35_Sub2_Sub2_Sub4_148 = aclass35_sub2_sub2_sub4[l2];
                class8.aBoolean147 = class35_sub2_sub3.g1() == 1;
            }
            if (class8.anInt117 == 4) {
                class8.aString149 = class35_sub2_sub3.gstr();
                class8.aString150 = class35_sub2_sub3.gstr();
            }
            if (class8.anInt117 == 1 || class8.anInt117 == 3 || class8.anInt117 == 4)
                class8.anInt151 = class35_sub2_sub3.g4();
            if (class8.anInt117 == 3 || class8.anInt117 == 4) {
                class8.anInt152 = class35_sub2_sub3.g4();
                class8.anInt153 = class35_sub2_sub3.g4();
            }
            if (class8.anInt117 == 5) {
                String s = class35_sub2_sub3.gstr();
                if (class36 != null && s.length() > 0) {
                    int j4 = s.lastIndexOf(",");
                    class8.aSprite_154 = method175(Integer.parseInt(s.substring(j4 + 1)), (byte) -128, s.substring(0, j4), class36);
                }
                s = class35_sub2_sub3.gstr();
                if (class36 != null && s.length() > 0) {
                    int k4 = s.lastIndexOf(",");
                    class8.aSprite_155 = method175(Integer.parseInt(s.substring(k4 + 1)), (byte) -128, s.substring(0, k4), class36);
                }
            }
            if (class8.anInt117 == 6) {
                int i1 = class35_sub2_sub3.g1();
                if (i1 != 0)
                    class8.aModel_156 = method176((i1 - 1 << 8) + class35_sub2_sub3.g1(), (byte) -56);
                i1 = class35_sub2_sub3.g1();
                if (i1 != 0)
                    class8.aModel_157 = method176((i1 - 1 << 8) + class35_sub2_sub3.g1(), (byte) -56);
                i1 = class35_sub2_sub3.g1();
                if (i1 != 0)
                    class8.anInt158 = (i1 - 1 << 8) + class35_sub2_sub3.g1();
                else
                    class8.anInt158 = -1;
                i1 = class35_sub2_sub3.g1();
                if (i1 != 0)
                    class8.anInt159 = (i1 - 1 << 8) + class35_sub2_sub3.g1();
                else
                    class8.anInt159 = -1;
                class8.anInt160 = class35_sub2_sub3.g2();
                class8.anInt161 = class35_sub2_sub3.g2();
                class8.anInt162 = class35_sub2_sub3.g2();
            }
            if (class8.anInt117 == 7) {
                class8.anIntArray111 = new int[class8.anInt120 * class8.anInt121];
                class8.anIntArray112 = new int[class8.anInt120 * class8.anInt121];
                class8.aBoolean146 = class35_sub2_sub3.g1() == 1;
                int i3 = class35_sub2_sub3.g1();
                if (aclass35_sub2_sub2_sub4 != null)
                    class8.aClass35_Sub2_Sub2_Sub4_148 = aclass35_sub2_sub2_sub4[i3];
                class8.aBoolean147 = class35_sub2_sub3.g1() == 1;
                class8.anInt151 = class35_sub2_sub3.g4();
                class8.anInt139 = class35_sub2_sub3.g2b();
                class8.anInt140 = class35_sub2_sub3.g2b();
                class8.aBoolean137 = class35_sub2_sub3.g1() == 1;
                class8.aStringArray144 = new String[5];
                for (int l4 = 0; l4 < 5; l4++) {
                    class8.aStringArray144[l4] = class35_sub2_sub3.gstr();
                    if (class8.aStringArray144[l4].length() == 0)
                        class8.aStringArray144[l4] = null;
                }

            }
            if (class8.anInt118 == 2 || class8.anInt117 == 2) {
                class8.aString163 = class35_sub2_sub3.gstr();
                class8.aString164 = class35_sub2_sub3.gstr();
                class8.anInt165 = class35_sub2_sub3.g2();
            }
            if (class8.anInt118 == 1 || class8.anInt118 == 4 || class8.anInt118 == 5 || class8.anInt118 == 6) {
                class8.aString166 = class35_sub2_sub3.gstr();
                if (class8.aString166.length() == 0) {
                    if (class8.anInt118 == 1)
                        class8.aString166 = "Ok";
                    if (class8.anInt118 == 4)
                        class8.aString166 = "Select";
                    if (class8.anInt118 == 5)
                        class8.aString166 = "Select";
                    if (class8.anInt118 == 6)
                        class8.aString166 = "Continue";
                }
            }
        }
        aCache_167 = null;
        aCache_168 = null;
    }

    public Model method174(int i, int j, boolean flag) {
        Model class35_sub2_sub1 = aModel_156;
        if (flag)
            class35_sub2_sub1 = aModel_157;
        if (class35_sub2_sub1 == null)
            return null;
        if (i == -1 && j == -1 && class35_sub2_sub1.unmodifiedTriangleColor == null)
            return class35_sub2_sub1;
        Model class35_sub2_sub1_1 = new Model(-428, true, class35_sub2_sub1, true, false, true);
        if (i != -1 || j != -1)
            class35_sub2_sub1_1.applyGroups();
        if (i != -1)
            class35_sub2_sub1_1.applyFrame(i);
        if (j != -1)
            class35_sub2_sub1_1.applyFrame(j);
        class35_sub2_sub1_1.applyLighting(64, 768, -50, -10, -50, true);
        return class35_sub2_sub1_1;
    }

    public static Sprite method175(int i, byte byte0, String s, FileArchive class36) {
        long l = (StringUtils.method420(s, (byte) 6) << 4) + (long) i;
        Sprite class35_sub2_sub2_sub2 = (Sprite) aCache_167.get(l);
        if (byte0 != -128)
            throw new NullPointerException();
        if (class35_sub2_sub2_sub2 != null)
            return class35_sub2_sub2_sub2;
        try {
            class35_sub2_sub2_sub2 = new Sprite(class36, s, i);
            aCache_167.put(l, class35_sub2_sub2_sub2);
        } catch (Exception _ex) {
            return null;
        }
        return class35_sub2_sub2_sub2;
    }

    public static Model method176(int i, byte byte0) {
        Model class35_sub2_sub1 = (Model) aCache_168.get(i);
        if (byte0 != aByte109)
            throw new NullPointerException();
        if (class35_sub2_sub1 != null) {
            return class35_sub2_sub1;
        } else {
            Model class35_sub2_sub1_1 = new Model(i);
            aCache_168.put(i, class35_sub2_sub1_1);
            return class35_sub2_sub1_1;
        }
    }

    public Component() {
    }

    public static byte aByte109 = -56;
    public static Component[] aComponentArray110;
    public int[] anIntArray111;
    public int[] anIntArray112;
    public int anInt113;
    public int anInt114;
    public int anInt115;
    public int anInt116;
    public int anInt117;
    public int anInt118;
    public int anInt119;
    public int anInt120;
    public int anInt121;
    public int anInt122;
    public int anInt123;
    public int[][] anIntArrayArray124;
    public int[] anIntArray125;
    public int[] anIntArray126;
    public int anInt127;
    public int anInt128;
    public int anInt129;
    public boolean aBoolean130;
    public int[] anIntArray131;
    public int[] anIntArray132;
    public int[] anIntArray133;
    public int anInt134;
    public boolean aBoolean135;
    public boolean aBoolean136;
    public boolean aBoolean137;
    public boolean aBoolean138;
    public int anInt139;
    public int anInt140;
    public Sprite[] aSpriteArray141;
    public int[] anIntArray142;
    public int[] anIntArray143;
    public String[] aStringArray144;
    public boolean aBoolean145;
    public boolean aBoolean146;
    public boolean aBoolean147;
    public Font aClass35_Sub2_Sub2_Sub4_148;
    public String aString149;
    public String aString150;
    public int anInt151;
    public int anInt152;
    public int anInt153;
    public Sprite aSprite_154;
    public Sprite aSprite_155;
    public Model aModel_156;
    public Model aModel_157;
    public int anInt158;
    public int anInt159;
    public int anInt160;
    public int anInt161;
    public int anInt162;
    public String aString163;
    public String aString164;
    public int anInt165;
    public String aString166;
    public static Cache aCache_167;
    public static Cache aCache_168;

}
