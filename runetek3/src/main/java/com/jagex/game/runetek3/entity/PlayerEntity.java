package com.jagex.game.runetek3.entity;

// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

import com.jagex.core.io.Buffer;
import com.jagex.core.stringutils.StringUtils;
import com.jagex.core.utils.Cache;
import com.jagex.game.runetek3.config.IdkType;
import com.jagex.game.runetek3.config.ObjType;
import com.jagex.game.runetek3.config.SeqType;
import com.jagex.game.runetek3.config.SpotAnimType;
import com.jagex.game.runetek3.graphics.model.Model;

public class PlayerEntity extends PathingEntity {

    public static final int[][] anIntArrayArray938 = {
            {
                    6798, 107, 10283, 16, 4797, 7744, 5799, 4634, 33697, 22433,
                    2983, 54193
            },
            {
            8741, 12, 64030, 43162, 7735, 8404, 1701, 38430, 24094, 10153,
            56621, 4783, 1341, 16578, 35003, 25239
            },
            {
            25238, 8742, 12, 64030, 43162, 7735, 8404, 1701, 38430, 24094,
            10153, 56621, 4783, 1341, 16578, 35003
            },
            {
            4626, 11146, 6439, 12, 4758, 10270
            },
            {
            4550, 4537, 5681, 5673, 5790, 6806, 8076, 4574
            }
            };

    public static final int[] BEARD_COLORS = {
            9104, 10275, 7595, 3610, 7975, 8526, 918, 38802, 24466, 10145,
            58654, 5027, 1457, 16565, 34991, 25486
            };

    public void method413(Buffer class35_sub2_sub3, boolean flag) {
        class35_sub2_sub3.pos = 0;
        gender = class35_sub2_sub3.g1();
        headicons = class35_sub2_sub3.g1();
        for (int i = 0; i < 13; i++) {
            int j = class35_sub2_sub3.g1();
            if (j == 0) {
                body[i] = 0;
            } else {
                int l = class35_sub2_sub3.g1();
                body[i] = (j << 8) + l;
            }
        }

        for (int k = 0; k < 5; k++) {
            int i1 = class35_sub2_sub3.g1();
            if (i1 < 0 || i1 >= anIntArrayArray938[k].length)
                i1 = 0;
            colors[k] = i1;
        }

        super.standSeq = class35_sub2_sub3.g2();
        if (super.standSeq == 65535)
            super.standSeq = -1;
        super.anInt1214 = class35_sub2_sub3.g2();
        if (super.anInt1214 == 65535)
            super.anInt1214 = -1;
        super.anInt1215 = class35_sub2_sub3.g2();
        if (super.anInt1215 == 65535)
            super.anInt1215 = -1;
        super.anInt1216 = class35_sub2_sub3.g2();
        if (!flag)
            anInt1326 = -214;
        if (super.anInt1216 == 65535)
            super.anInt1216 = -1;
        super.anInt1217 = class35_sub2_sub3.g2();
        if (super.anInt1217 == 65535)
            super.anInt1217 = -1;
        super.anInt1218 = class35_sub2_sub3.g2();
        if (super.anInt1218 == 65535)
            super.anInt1218 = -1;
        super.anInt1219 = class35_sub2_sub3.g2();
        if (super.anInt1219 == 65535)
            super.anInt1219 = -1;
        name = StringUtils.method421(-580, StringUtils.fromBase37(true, class35_sub2_sub3.g8()));
        combatLevel = class35_sub2_sub3.g1();
        aBoolean1329 = true;
        aLong1335 = 0L;
        for (int j1 = 0; j1 < 12; j1++) {
            aLong1335 <<= 4;
            if (body[j1] >= 256)
                aLong1335 += body[j1] - 256;
        }

        if (body[0] >= 256)
            aLong1335 += body[0] - 256 >> 4;
        if (body[1] >= 256)
            aLong1335 += body[1] - 256 >> 8;
        for (int k1 = 0; k1 < 5; k1++) {
            aLong1335 <<= 3;
            aLong1335 += colors[k1];
        }

        aLong1335 <<= 1;
        aLong1335 += gender;
    }

    public Model getDrawMethod(int i, int cycle) {
        if (!aBoolean1329)
            return null;
        Model class35_sub2_sub1 = getModel(0);
        super.height = class35_sub2_sub1.maxBoundY;
        if (i != 0)
            aBoolean1327 = !aBoolean1327;
        class35_sub2_sub1.pickable = true;
        if (aBoolean1347)
            return class35_sub2_sub1;
        if (super.spotAnimIndex != -1 && super.spotAnimFrame != -1) {
            SpotAnimType class14 = SpotAnimType.instances[super.spotAnimIndex];
            Model class35_sub2_sub1_2 = new Model(-428, true, class14.getModel(), true, false, !class14.disposeAlpha);
            class35_sub2_sub1_2.translate(0, 0, -super.spotAnimOffsetY);
            class35_sub2_sub1_2.applyGroups();
            class35_sub2_sub1_2.applyFrame(class14.anim.primaryFrames[super.spotAnimFrame]);
            class35_sub2_sub1_2.skinTriangle = null;
            class35_sub2_sub1_2.labelVertices = null;
            class35_sub2_sub1_2.applyLighting(64, 850, -30, -50, -30, true);
            Model[] aclass35_sub2_sub1_1 = {
                    class35_sub2_sub1, class35_sub2_sub1_2
            };
            class35_sub2_sub1 = new Model(true, aclass35_sub2_sub1_1, 2);
        }
        if (aModel_1342 != null) {
            if (cycle >= anInt1338)
                aModel_1342 = null;
            if (cycle >= anInt1337 && cycle < anInt1338) {
                Model class35_sub2_sub1_1 = aModel_1342;
                class35_sub2_sub1_1.translate(anInt1341 - super.z, anInt1339 - super.x, anInt1340 - plane);
                if (super.anInt1254 == 512) {
                    class35_sub2_sub1_1.rotateCounterClockwise();
                    class35_sub2_sub1_1.rotateCounterClockwise();
                    class35_sub2_sub1_1.rotateCounterClockwise();
                } else if (super.anInt1254 == 1024) {
                    class35_sub2_sub1_1.rotateCounterClockwise();
                    class35_sub2_sub1_1.rotateCounterClockwise();
                } else if (super.anInt1254 == 1536)
                    class35_sub2_sub1_1.rotateCounterClockwise();
                Model[] aclass35_sub2_sub1 = {
                        class35_sub2_sub1, class35_sub2_sub1_1
                };
                class35_sub2_sub1 = new Model(true, aclass35_sub2_sub1, 2);
                if (super.anInt1254 == 512)
                    class35_sub2_sub1_1.rotateCounterClockwise();
                else if (super.anInt1254 == 1024) {
                    class35_sub2_sub1_1.rotateCounterClockwise();
                    class35_sub2_sub1_1.rotateCounterClockwise();
                } else if (super.anInt1254 == 1536) {
                    class35_sub2_sub1_1.rotateCounterClockwise();
                    class35_sub2_sub1_1.rotateCounterClockwise();
                    class35_sub2_sub1_1.rotateCounterClockwise();
                }
                class35_sub2_sub1_1.translate(super.z - anInt1341, super.x - anInt1339, plane - anInt1340);
            }
        }
        class35_sub2_sub1.pickable = true;
        return class35_sub2_sub1;
    }

    public Model getModel(int i) {
        long l = aLong1335;
        int j = -1;
        int k = -1;
        int i1 = -1;
        int j1 = -1;
        if (i != 0)
            aBoolean1327 = !aBoolean1327;
        if (super.primarySeq >= 0 && super.primarySeqDelay == 0) {
            SeqType class12 = SeqType.instances[super.primarySeq];
            j = class12.primaryFrames[super.primarySeqFrame];
            if (super.secondarySeq >= 0 && super.secondarySeq != super.standSeq)
                k = SeqType.instances[super.secondarySeq].primaryFrames[super.secondarySeqFrame];
            if (class12.mainhand >= 0) {
                i1 = class12.mainhand;
                l += i1 - body[5] << 40;
            }
            if (class12.offhand >= 0) {
                j1 = class12.offhand;
                l += j1 - body[3] << 48;
            }
        } else if (super.secondarySeq >= 0)
            j = SeqType.instances[super.secondarySeq].primaryFrames[super.secondarySeqFrame];
        Model class35_sub2_sub1 = (Model) aCache_1348.get(l);
        if (class35_sub2_sub1 == null) {
            Model[] aclass35_sub2_sub1 = new Model[13];
            int k1 = 0;
            for (int l1 = 0; l1 < 13; l1++) {
                int i2 = body[l1];
                if (j1 >= 0 && l1 == 3)
                    i2 = j1;
                if (i1 >= 0 && l1 == 5)
                    i2 = i1;
                if (i2 >= 256 && i2 < 512)
                    aclass35_sub2_sub1[k1++] = IdkType.instances[i2 - 256].method157();
                if (i2 >= 512) {
                    ObjType class41 = ObjType.get(i2 - 512);
                    Model class35_sub2_sub1_2 = class41.method445(92, gender);
                    if (class35_sub2_sub1_2 != null)
                        aclass35_sub2_sub1[k1++] = class35_sub2_sub1_2;
                }
            }

            class35_sub2_sub1 = new Model(false, k1, aclass35_sub2_sub1);
            for (int j2 = 0; j2 < 5; j2++)
                if (colors[j2] != 0) {
                    class35_sub2_sub1.recolor(anIntArrayArray938[j2][0], anIntArrayArray938[j2][colors[j2]]);
                    if (j2 == 1)
                        class35_sub2_sub1.recolor(BEARD_COLORS[0], BEARD_COLORS[colors[j2]]);
                }

            class35_sub2_sub1.applyGroups();
            class35_sub2_sub1.applyLighting(64, 850, -30, -50, -30, true);
            aCache_1348.put(l, class35_sub2_sub1);
        }
        if (aBoolean1347)
            return class35_sub2_sub1;
        Model class35_sub2_sub1_1 = new Model(false, true, class35_sub2_sub1);
        if (j != -1 && k != -1)
            class35_sub2_sub1_1.applyFrames(j, k, SeqType.instances[super.primarySeq].labelGroups);
        else if (j != -1)
            class35_sub2_sub1_1.applyFrame(j);
        class35_sub2_sub1_1.calculateYBoundaries();
        class35_sub2_sub1_1.skinTriangle = null;
        class35_sub2_sub1_1.labelVertices = null;
        return class35_sub2_sub1_1;
    }

    public Model method415(boolean flag) {
        if (!aBoolean1329)
            return null;
        Model[] aclass35_sub2_sub1 = new Model[13];
        int i = 0;
        if (!flag)
            throw new NullPointerException();
        for (int j = 0; j < 13; j++) {
            int k = body[j];
            if (k >= 256 && k < 512)
                aclass35_sub2_sub1[i++] = IdkType.instances[k - 256].method158(0);
            if (k >= 512) {
                Model class35_sub2_sub1_1 = ObjType.get(k - 512).method446((byte) 107, gender);
                if (class35_sub2_sub1_1 != null)
                    aclass35_sub2_sub1[i++] = class35_sub2_sub1_1;
            }
        }

        Model class35_sub2_sub1 = new Model(false, i, aclass35_sub2_sub1);
        for (int l = 0; l < 5; l++)
            if (colors[l] != 0) {
                class35_sub2_sub1.recolor(anIntArrayArray938[l][0], anIntArrayArray938[l][colors[l]]);
                if (l == 1)
                    class35_sub2_sub1.recolor(BEARD_COLORS[0], BEARD_COLORS[colors[l]]);
            }

        return class35_sub2_sub1;
    }

    public boolean method411(int i) {
        if (i != 0)
            throw new NullPointerException();
        return aBoolean1329;
    }

    public PlayerEntity() {
        aBoolean1327 = false;
        aBoolean1329 = false;
        body = new int[13];
        colors = new int[5];
        aBoolean1347 = false;
    }

    public int anInt1326;
    public boolean aBoolean1327;
    public String name;
    public boolean aBoolean1329;
    public int gender;
    public int headicons;
    public int[] body;
    public int[] colors;
    public int combatLevel;
    public long aLong1335;
    public int plane;
    public int anInt1337;
    public int anInt1338;
    public int anInt1339;
    public int anInt1340;
    public int anInt1341;
    public Model aModel_1342;
    public int anInt1343;
    public int anInt1344;
    public int anInt1345;
    public int anInt1346;
    public boolean aBoolean1347;
    public static Cache aCache_1348 = new Cache(200);

}
