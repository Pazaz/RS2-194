package com.jagex.game.runetek3.entity;

// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

import com.jagex.game.runetek3.config.SpotAnimType;
import com.jagex.game.runetek3.graphics.model.Model;

public class ProjectileEntity extends Entity {

    public ProjectileEntity(int i, int j, int k, int l, int i1, int j1, int k1,
                            int l1, int i2, int j2, int k2, int l2) {
        anInt1170 = -403;
        aBoolean1171 = true;
        aBoolean1172 = false;
        aBoolean1184 = false;
        aSpotAnimType_1173 = SpotAnimType.aSpotAnimTypeArray212[i1];
        anInt1174 = k1;
        if (j != -35843) {
            throw new NullPointerException();
        } else {
            anInt1175 = i;
            anInt1176 = k2;
            anInt1177 = j1;
            anInt1179 = i2;
            anInt1180 = k;
            anInt1181 = j2;
            anInt1182 = l;
            anInt1183 = l1;
            anInt1178 = l2;
            aBoolean1184 = false;
            return;
        }
    }

    public void method406(int i, int j, int k, int l, boolean flag) {
        if (!aBoolean1184) {
            double d = l - anInt1175;
            double d2 = j - anInt1176;
            double d3 = Math.sqrt(d * d + d2 * d2);
            aDouble1185 = (double) anInt1175 + (d * (double) anInt1182) / d3;
            aDouble1186 = (double) anInt1176 + (d2 * (double) anInt1182) / d3;
            aDouble1187 = anInt1177;
        }
        double d1 = (anInt1180 + 1) - k;
        aDouble1188 = ((double) l - aDouble1185) / d1;
        aDouble1189 = ((double) j - aDouble1186) / d1;
        if (!flag)
            aBoolean1172 = !aBoolean1172;
        aDouble1190 = Math.sqrt(aDouble1188 * aDouble1188 + aDouble1189 * aDouble1189);
        if (!aBoolean1184)
            aDouble1191 = -aDouble1190 * Math.tan((double) anInt1181 * 0.02454369D);
        aDouble1192 = (2D * ((double) i - aDouble1187 - aDouble1191 * d1)) / (d1 * d1);
    }

    public void method407(int i, int j) {
        aBoolean1184 = true;
        aDouble1185 += aDouble1188 * (double) j;
        aDouble1186 += aDouble1189 * (double) j;
        aDouble1187 += aDouble1191 * (double) j + 0.5D * aDouble1192 * (double) j * (double) j;
        aDouble1191 += aDouble1192 * (double) j;
        anInt1193 = (int) (Math.atan2(aDouble1188, aDouble1189) * 325.94900000000001D) + 1024 & 0x7ff;
        if (i >= 0)
            anInt1170 = -428;
        anInt1194 = (int) (Math.atan2(aDouble1191, aDouble1190) * 325.94900000000001D) & 0x7ff;
        if (aSpotAnimType_1173.aSeqType_215 != null)
            for (anInt1196 += j; anInt1196 > aSpotAnimType_1173.aSeqType_215.anIntArray194[anInt1195]; ) {
                anInt1196 -= aSpotAnimType_1173.aSeqType_215.anIntArray194[anInt1195] + 1;
                anInt1195++;
                if (anInt1195 >= aSpotAnimType_1173.aSeqType_215.anInt191)
                    anInt1195 = 0;
            }

    }

    public Model getDrawMethod(int i, int cycle) {
        if (i != 0)
            aBoolean1171 = !aBoolean1171;
        Model class35_sub2_sub1 = aSpotAnimType_1173.method183();
        Model class35_sub2_sub1_1 = new Model(-428, true, class35_sub2_sub1, true, false, !aSpotAnimType_1173.aBoolean216);
        if (aSpotAnimType_1173.aSeqType_215 != null) {
            class35_sub2_sub1_1.method310((byte) 3);
            class35_sub2_sub1_1.applyFrame(7, aSpotAnimType_1173.aSeqType_215.anIntArray192[anInt1195]);
            class35_sub2_sub1_1.skinTriangle = null;
            class35_sub2_sub1_1.anIntArrayArray1083 = null;
        }
        class35_sub2_sub1_1.method315(anInt1194, (byte) -42);
        class35_sub2_sub1_1.method320(64, 850, -30, -50, -30, true);
        return class35_sub2_sub1_1;
    }

    public int anInt1170;
    public boolean aBoolean1171;
    public boolean aBoolean1172;
    public SpotAnimType aSpotAnimType_1173;
    public int anInt1174;
    public int anInt1175;
    public int anInt1176;
    public int anInt1177;
    public int anInt1178;
    public int anInt1179;
    public int anInt1180;
    public int anInt1181;
    public int anInt1182;
    public int anInt1183;
    public boolean aBoolean1184;
    public double aDouble1185;
    public double aDouble1186;
    public double aDouble1187;
    public double aDouble1188;
    public double aDouble1189;
    public double aDouble1190;
    public double aDouble1191;
    public double aDouble1192;
    public int anInt1193;
    public int anInt1194;
    public int anInt1195;
    public int anInt1196;
}
