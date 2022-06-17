package com.jagex.game.runetek3.scenegraph;

// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

import com.jagex.core.utils.LinkedList;
import com.jagex.game.runetek3.entity.Entity;
import com.jagex.game.runetek3.entity.ObjEntity;
import com.jagex.game.runetek3.graphics.Draw2D;
import com.jagex.game.runetek3.graphics.Draw3D;
import com.jagex.game.runetek3.graphics.model.Model;
import com.jagex.game.runetek3.graphics.model.VertexNormal;

public class MapSquare {

    public MapSquare(int[][][] ai, int i, int j, int k, int l) {
        aBoolean374 = true;
        anInt377 = -4278;
        aBoolean378 = true;
        anInt379 = 431;
        anInt381 = -13731;
        aTile7Array390 = new Loc[5000];
        anIntArray432 = new int[10000];
        anIntArray433 = new int[10000];
        anInt383 = j;
        anInt384 = l;
        if (i != anInt377)
            aBoolean374 = !aBoolean374;
        anInt385 = k;
        levelTiles = new Tile[j][l][k];
        anIntArrayArrayArray391 = new int[j][l + 1][k + 1];
        anIntArrayArrayArray386 = ai;
        method238(true);
    }

    public static void method237(int i) {
        aTile7Array408 = null;
        anIntArray419 = null;
        aOccluderArrayArray420 = null;
        aLinkedList_423 = null;
        aBooleanArrayArrayArrayArray437 = null;
        if (i <= 0)
            aBoolean375 = !aBoolean375;
        aBooleanArrayArray438 = null;
    }

    public void method238(boolean flag) {
        if (!flag)
            return;
        for (int i = 0; i < anInt383; i++) {
            for (int j = 0; j < anInt384; j++) {
                for (int l = 0; l < anInt385; l++)
                    levelTiles[i][j][l] = null;

            }

        }

        for (int k = 0; k < anInt418; k++) {
            for (int i1 = 0; i1 < anIntArray419[k]; i1++)
                aOccluderArrayArray420[k][i1] = null;

            anIntArray419[k] = 0;
        }

        for (int j1 = 0; j1 < anInt389; j1++)
            aTile7Array390[j1] = null;

        anInt389 = 0;
        for (int k1 = 0; k1 < aTile7Array408.length; k1++)
            aTile7Array408[k1] = null;

    }

    public void method239(int i, int j) {
        anInt388 = i;
        for (int k = 0; k < anInt384; k++) {
            for (int l = 0; l < anInt385; l++)
                levelTiles[i][k][l] = new Tile(i, k, l);

        }

        if (j != 0) {
            for (int i1 = 1; i1 > 0; i1++) ;
        }
    }

    public void method240(int i, int j, int k) {
        Tile class35_sub1 = levelTiles[0][j][i];
        for (int l = 0; l < 3; l++) {
            levelTiles[l][j][i] = levelTiles[l + 1][j][i];
            if (levelTiles[l][j][i] != null)
                levelTiles[l][j][i].anInt994--;
        }

        if (levelTiles[0][j][i] == null)
            levelTiles[0][j][i] = new Tile(0, j, i);
        levelTiles[0][j][i].aClass35_Sub1_1016 = class35_sub1;
        if (k != 9) {
            for (int i1 = 1; i1 > 0; i1++) ;
        }
        levelTiles[3][j][i] = null;
    }

    public static void method241(int i, int j, int k, byte byte0, int l, int i1, int j1, int k1,
                                 int l1) {
        if (byte0 != 80)
            aBoolean375 = !aBoolean375;
        Occluder class21 = new Occluder();
        class21.anInt305 = i / 128;
        class21.anInt306 = k / 128;
        class21.anInt307 = i1 / 128;
        class21.anInt308 = l / 128;
        class21.anInt309 = j1;
        class21.anInt310 = i;
        class21.anInt311 = k;
        class21.anInt312 = i1;
        class21.anInt313 = l;
        class21.anInt314 = j;
        class21.anInt315 = k1;
        aOccluderArrayArray420[l1][anIntArray419[l1]++] = class21;
    }

    public void method242(int i, int j, int k, int l) {
        Tile class35_sub1 = levelTiles[i][j][k];
        if (class35_sub1 == null) {
            return;
        } else {
            levelTiles[i][j][k].anInt1008 = l;
            return;
        }
    }

    public void method243(int i, int j, int k, int l, int i1, int j1, int k1,
                          int l1, int i2, int j2, int k2, int l2, int i3, int j3,
                          int k3, int l3, int i4, int j4, int k4, int l4) {
        if (l == 0) {
            TileUnderlay class23 = new TileUnderlay(k2, l2, i3, j3, -1, k4, false);
            for (int i5 = i; i5 >= 0; i5--)
                if (levelTiles[i5][j][k] == null)
                    levelTiles[i5][j][k] = new Tile(i5, j, k);

            levelTiles[i][j][k].underlay = class23;
            return;
        }
        if (l == 1) {
            TileUnderlay class23_1 = new TileUnderlay(k3, l3, i4, j4, j1, l4, k1 == l1 && k1 == i2 && k1 == j2);
            for (int j5 = i; j5 >= 0; j5--)
                if (levelTiles[j5][j][k] == null)
                    levelTiles[j5][j][k] = new Tile(j5, j, k);

            levelTiles[i][j][k].underlay = class23_1;
            return;
        }
        TileOverlay class15 = new TileOverlay(k2, i4, l, anInt376, k, l4, i1, l2, k1, j, l3, l1, j3, k4, j2, k3, i3, j4, j1, i2);
        for (int k5 = i; k5 >= 0; k5--)
            if (levelTiles[k5][j][k] == null)
                levelTiles[k5][j][k] = new Tile(k5, j, k);

        levelTiles[i][j][k].overlay = class15;
    }

    public void method244(int i, int j, byte byte0, Model class35_sub2_sub1, int k, int l, boolean flag,
                          int i1) {
        GroundDecoration class17 = new GroundDecoration();
        if (!flag)
            return;
        class17.aModel_259 = class35_sub2_sub1;
        class17.anInt257 = k * 128 + 64;
        class17.anInt258 = j * 128 + 64;
        class17.anInt256 = l;
        class17.anInt260 = i;
        class17.aByte261 = byte0;
        if (levelTiles[i1][k][j] == null)
            levelTiles[i1][k][j] = new Tile(i1, k, j);
        levelTiles[i1][k][j].aTile5_1002 = class17;
    }

    public void method245(int i, int j, Model class35_sub2_sub1, Model class35_sub2_sub1_1, int k, Model class35_sub2_sub1_2, int l,
                          boolean flag, int i1) {
        ObjEntity class19 = new ObjEntity();
        class19.aModel_284 = class35_sub2_sub1;
        if (flag)
            return;
        class19.anInt282 = i * 128 + 64;
        class19.anInt283 = l * 128 + 64;
        class19.anInt281 = j;
        class19.anInt287 = k;
        class19.aModel_285 = class35_sub2_sub1_1;
        class19.aModel_286 = class35_sub2_sub1_2;
        int j1 = 0;
        Tile class35_sub1 = levelTiles[i1][i][l];
        if (class35_sub1 != null) {
            for (int k1 = 0; k1 < class35_sub1.anInt1004; k1++) {
                int l1 = class35_sub1.aTile7Array1005[k1].aModel_343.anInt1080;
                if (l1 > j1)
                    j1 = l1;
            }

        }
        class19.anInt288 = j1;
        if (levelTiles[i1][i][l] == null)
            levelTiles[i1][i][l] = new Tile(i1, i, l);
        levelTiles[i1][i][l].aTile6_1003 = class19;
    }

    public void method246(int i, int j, int k, int l, Model class35_sub2_sub1, int i1, int j1,
                          Model class35_sub2_sub1_1, byte byte0, int k1, int l1) {
        if (class35_sub2_sub1 == null && class35_sub2_sub1_1 == null)
            return;
        Wall class27 = new Wall();
        class27.anInt364 = j;
        class27.aByte365 = byte0;
        class27.anInt358 = j1 * 128 + 64;
        class27.anInt359 = i1 * 128 + 64;
        if (i <= 0)
            anInt379 = 86;
        class27.anInt357 = l;
        class27.aModel_362 = class35_sub2_sub1;
        class27.aModel_363 = class35_sub2_sub1_1;
        class27.anInt360 = k1;
        class27.anInt361 = k;
        for (int i2 = l1; i2 >= 0; i2--)
            if (levelTiles[i2][j1][i1] == null)
                levelTiles[i2][j1][i1] = new Tile(i2, j1, i1);

        levelTiles[l1][j1][i1].wall = class27;
    }

    public void method247(int i, byte byte0, int j, int k, int l, int i1, int j1,
                          int k1, int l1, Model class35_sub2_sub1, int i2, int j2) {
        if (class35_sub2_sub1 == null)
            return;
        WallDecoration class13 = new WallDecoration();
        class13.anInt209 = l;
        class13.aByte210 = byte0;
        class13.anInt204 = i * 128 + 64 + l1;
        class13.anInt205 = i2 * 128 + 64 + k;
        class13.anInt203 = j;
        if (j1 <= 0)
            anInt379 = -32;
        class13.aModel_208 = class35_sub2_sub1;
        class13.anInt206 = i1;
        class13.anInt207 = k1;
        for (int k2 = j2; k2 >= 0; k2--)
            if (levelTiles[k2][i][i2] == null)
                levelTiles[k2][i][i2] = new Tile(k2, i, i2);

        levelTiles[j2][i][i2].aTile4_1001 = class13;
    }

    public boolean method248(Model class35_sub2_sub1, byte byte0, Entity class35_sub7, int i, int j, int k, int l,
                             int i1, int j1, int k1, int l1, int i2) {
        if (class35_sub2_sub1 == null && class35_sub7 == null)
            return true;
        int j2 = j * 128 + 64 * l;
        int k2 = k1 * 128 + 64 * k;
        if (l1 != 0)
            anInt376 = -432;
        return method251(i1, j, k1, l, k, j2, k2, i, class35_sub2_sub1, class35_sub7, i2, false, j1, byte0);
    }

    public boolean method249(Model class35_sub2_sub1, int i, int j, int k, int l, int i1, int j1,
                             int k1, Entity class35_sub7, int l1, int i2) {
        if (class35_sub2_sub1 == null && class35_sub7 == null)
            return true;
        int j2 = i1 - l1;
        int k2 = k - l1;
        int l2 = i1 + l1;
        int i3 = k + l1;
        if (k1 > 0) {
            if (l > 768 && l < 1280)
                i3 += k1;
            if (l > 1280 && l < 1792)
                l2 += k1;
            if (l > 1792 || l < 256)
                k2 -= k1;
            if (l > 256 && l < 768)
                l2 -= k1;
        }
        j2 /= 128;
        if (j != 5)
            anInt379 = -84;
        k2 /= 128;
        l2 /= 128;
        i3 /= 128;
        return method251(j1, j2, k2, (l2 - j2) + 1, (i3 - k2) + 1, i1, k, i, class35_sub2_sub1, class35_sub7, l, true, i2, (byte) 0);
    }

    public boolean method250(int i, int j, Model class35_sub2_sub1, int k, int l, int i1, int j1,
                             byte byte0, int k1, int l1, Entity class35_sub7, int i2, int j2, int k2) {
        if (byte0 == 8)
            byte0 = 0;
        else
            aBoolean375 = !aBoolean375;
        if (class35_sub2_sub1 == null && class35_sub7 == null)
            return true;
        else
            return method251(k2, k, j, (i2 - k) + 1, (j2 - j) + 1, i1, j1, l1, class35_sub2_sub1, class35_sub7, l, true, k1, (byte) 0);
    }

    public boolean method251(int i, int j, int k, int l, int i1, int j1, int k1,
                             int l1, Model class35_sub2_sub1, Entity class35_sub7, int i2, boolean flag, int j2, byte byte0) {
        if (class35_sub2_sub1 == null && class35_sub7 == null)
            return false;
        for (int k2 = j; k2 < j + l; k2++) {
            for (int l2 = k; l2 < k + i1; l2++) {
                if (k2 < 0 || l2 < 0 || k2 >= anInt384 || l2 >= anInt385)
                    return false;
                Tile class35_sub1 = levelTiles[i][k2][l2];
                if (class35_sub1 != null && class35_sub1.anInt1004 >= 5)
                    return false;
            }

        }

        Loc class25 = new Loc();
        class25.anInt352 = j2;
        class25.aByte353 = byte0;
        class25.anInt339 = i;
        class25.anInt341 = j1;
        class25.anInt342 = k1;
        class25.anInt340 = l1;
        class25.aModel_343 = class35_sub2_sub1;
        class25.aClass35_Sub7_344 = class35_sub7;
        class25.anInt345 = i2;
        class25.anInt346 = j;
        class25.anInt348 = k;
        class25.anInt347 = (j + l) - 1;
        class25.anInt349 = (k + i1) - 1;
        for (int i3 = j; i3 < j + l; i3++) {
            for (int j3 = k; j3 < k + i1; j3++) {
                int k3 = 0;
                if (i3 > j)
                    k3++;
                if (i3 < (j + l) - 1)
                    k3 += 4;
                if (j3 > k)
                    k3 += 8;
                if (j3 < (k + i1) - 1)
                    k3 += 2;
                for (int l3 = i; l3 >= 0; l3--)
                    if (levelTiles[l3][i3][j3] == null)
                        levelTiles[l3][i3][j3] = new Tile(l3, i3, j3);

                Tile class35_sub1_1 = levelTiles[i][i3][j3];
                class35_sub1_1.aTile7Array1005[class35_sub1_1.anInt1004] = class25;
                class35_sub1_1.anIntArray1006[class35_sub1_1.anInt1004] = k3;
                class35_sub1_1.anInt1007 |= k3;
                class35_sub1_1.anInt1004++;
            }

        }

        if (flag)
            aTile7Array390[anInt389++] = class25;
        return true;
    }

    public void method252(int i) {
        for (int j = 0; j < anInt389; j++) {
            Loc class25 = aTile7Array390[j];
            method253(-212, class25);
            aTile7Array390[j] = null;
        }

        if (i < 7 || i > 7)
            anInt377 = 177;
        anInt389 = 0;
    }

    public void method253(int i, Loc class25) {
        if (i >= 0)
            return;
        for (int j = class25.anInt346; j <= class25.anInt347; j++) {
            for (int k = class25.anInt348; k <= class25.anInt349; k++) {
                Tile class35_sub1 = levelTiles[class25.anInt339][j][k];
                if (class35_sub1 != null) {
                    for (int l = 0; l < class35_sub1.anInt1004; l++) {
                        if (class35_sub1.aTile7Array1005[l] != class25)
                            continue;
                        class35_sub1.anInt1004--;
                        for (int i1 = l; i1 < class35_sub1.anInt1004; i1++) {
                            class35_sub1.aTile7Array1005[i1] = class35_sub1.aTile7Array1005[i1 + 1];
                            class35_sub1.anIntArray1006[i1] = class35_sub1.anIntArray1006[i1 + 1];
                        }

                        class35_sub1.aTile7Array1005[class35_sub1.anInt1004] = null;
                        break;
                    }

                    class35_sub1.anInt1007 = 0;
                    for (int j1 = 0; j1 < class35_sub1.anInt1004; j1++)
                        class35_sub1.anInt1007 |= class35_sub1.anIntArray1006[j1];

                }
            }

        }

    }

    public void method254(Model class35_sub2_sub1, int i, int j, int k, int l) {
        i = 93 / i;
        if (class35_sub2_sub1 == null)
            return;
        Tile class35_sub1 = levelTiles[l][k][j];
        if (class35_sub1 == null)
            return;
        for (int i1 = 0; i1 < class35_sub1.anInt1004; i1++) {
            Loc class25 = class35_sub1.aTile7Array1005[i1];
            if ((class25.anInt352 >> 29 & 3) == 2) {
                class25.aModel_343 = class35_sub2_sub1;
                return;
            }
        }

    }

    public void method255(int i, int j, int k, Model class35_sub2_sub1, int l) {
        if (i != 38499)
            return;
        if (class35_sub2_sub1 == null)
            return;
        Tile class35_sub1 = levelTiles[l][j][k];
        if (class35_sub1 == null)
            return;
        WallDecoration class13 = class35_sub1.aTile4_1001;
        if (class13 == null) {
            return;
        } else {
            class13.aModel_208 = class35_sub2_sub1;
            return;
        }
    }

    public void method256(Model class35_sub2_sub1, byte byte0, int i, int j, int k) {
        if (byte0 != 2)
            anInt377 = 272;
        if (class35_sub2_sub1 == null)
            return;
        Tile class35_sub1 = levelTiles[i][k][j];
        if (class35_sub1 == null)
            return;
        Wall class27 = class35_sub1.wall;
        if (class27 == null) {
            return;
        } else {
            class27.aModel_362 = class35_sub2_sub1;
            return;
        }
    }

    public void method257(int i, int j, int k, int l) {
        Tile class35_sub1 = levelTiles[j][k][l];
        if (i != 0)
            return;
        if (class35_sub1 == null) {
            return;
        } else {
            class35_sub1.wall = null;
            return;
        }
    }

    public void method258(int i, int j, int k, int l) {
        Tile class35_sub1 = levelTiles[j][i][l];
        if (class35_sub1 == null)
            return;
        class35_sub1.aTile4_1001 = null;
        if (k != 0)
            aBoolean378 = !aBoolean378;
    }

    public void method259(int i, int j, int k, int l) {
        Tile class35_sub1 = levelTiles[k][l][j];
        if (class35_sub1 == null)
            return;
        for (int i1 = 0; i1 < class35_sub1.anInt1004; i1++) {
            Loc class25 = class35_sub1.aTile7Array1005[i1];
            if ((class25.anInt352 >> 29 & 3) == 2 && class25.anInt346 == l && class25.anInt348 == j) {
                method253(-212, class25);
                return;
            }
        }

        if (i <= 0)
            anInt381 = 5;
    }

    public void method260(byte byte0, int i, int j, int k) {
        Tile class35_sub1 = levelTiles[k][j][i];
        if (class35_sub1 == null)
            return;
        class35_sub1.aTile5_1002 = null;
        if (byte0 != 52) {
            for (int l = 1; l > 0; l++) ;
        }
    }

    public void method261(int i, int j, int k) {
        Tile class35_sub1 = levelTiles[i][j][k];
        if (class35_sub1 == null) {
            return;
        } else {
            class35_sub1.aTile6_1003 = null;
            return;
        }
    }

    public int method262(int i, int j, int k) {
        Tile class35_sub1 = levelTiles[i][j][k];
        if (class35_sub1 == null || class35_sub1.wall == null)
            return 0;
        else
            return class35_sub1.wall.anInt364;
    }

    public int method263(int i, int j, int k, int l) {
        if (k != -14722)
            return 0;
        Tile class35_sub1 = levelTiles[l][i][j];
        if (class35_sub1 == null || class35_sub1.aTile4_1001 == null)
            return 0;
        else
            return class35_sub1.aTile4_1001.anInt209;
    }

    public int method264(int i, int j, int k) {
        Tile class35_sub1 = levelTiles[i][j][k];
        if (class35_sub1 == null)
            return 0;
        for (int l = 0; l < class35_sub1.anInt1004; l++) {
            Loc class25 = class35_sub1.aTile7Array1005[l];
            if ((class25.anInt352 >> 29 & 3) == 2 && class25.anInt346 == j && class25.anInt348 == k)
                return class25.anInt352;
        }

        return 0;
    }

    public int method265(int i, int j, int k) {
        Tile class35_sub1 = levelTiles[i][j][k];
        if (class35_sub1 == null || class35_sub1.aTile5_1002 == null)
            return 0;
        else
            return class35_sub1.aTile5_1002.anInt260;
    }

    public int method266(int i, int j, int k, int l) {
        Tile class35_sub1 = levelTiles[i][j][k];
        if (class35_sub1 == null)
            return -1;
        if (class35_sub1.wall != null && class35_sub1.wall.anInt364 == l)
            return class35_sub1.wall.aByte365 & 0xff;
        if (class35_sub1.aTile4_1001 != null && class35_sub1.aTile4_1001.anInt209 == l)
            return class35_sub1.aTile4_1001.aByte210 & 0xff;
        if (class35_sub1.aTile5_1002 != null && class35_sub1.aTile5_1002.anInt260 == l)
            return class35_sub1.aTile5_1002.aByte261 & 0xff;
        for (int i1 = 0; i1 < class35_sub1.anInt1004; i1++)
            if (class35_sub1.aTile7Array1005[i1].anInt352 == l)
                return class35_sub1.aTile7Array1005[i1].aByte353 & 0xff;

        return -1;
    }

    public void method267(int i, int j, int k, int l, int i1, int j1) {
        int k1 = (int) Math.sqrt(l * l + k * k + i1 * i1);
        if (j1 != 0)
            aBoolean374 = !aBoolean374;
        int l1 = j * k1 >> 8;
        for (int i2 = 0; i2 < anInt383; i2++) {
            for (int j2 = 0; j2 < anInt384; j2++) {
                for (int k2 = 0; k2 < anInt385; k2++) {
                    Tile class35_sub1 = levelTiles[i2][j2][k2];
                    if (class35_sub1 != null) {
                        Wall class27 = class35_sub1.wall;
                        if (class27 != null && class27.aModel_362 != null && class27.aModel_362.vertexNormals != null) {
                            method269(class27.aModel_362, i2, j2, 1, 1, 543, k2);
                            if (class27.aModel_363 != null && class27.aModel_363.vertexNormals != null) {
                                method269(class27.aModel_363, i2, j2, 1, 1, 543, k2);
                                method270(class27.aModel_362, class27.aModel_363, 0, 0, 0, false);
                                class27.aModel_363.method321(i, l1, l, k, i1);
                            }
                            class27.aModel_362.method321(i, l1, l, k, i1);
                        }
                        for (int l2 = 0; l2 < class35_sub1.anInt1004; l2++) {
                            Loc class25 = class35_sub1.aTile7Array1005[l2];
                            if (class25 != null && class25.aModel_343 != null && class25.aModel_343.vertexNormals != null) {
                                method269(class25.aModel_343, i2, j2, (class25.anInt347 - class25.anInt346) + 1, (class25.anInt349 - class25.anInt348) + 1, 543, k2);
                                class25.aModel_343.method321(i, l1, l, k, i1);
                            }
                        }

                        GroundDecoration class17 = class35_sub1.aTile5_1002;
                        if (class17 != null && class17.aModel_259.vertexNormals != null) {
                            method268(9, k2, i2, j2, class17.aModel_259);
                            class17.aModel_259.method321(i, l1, l, k, i1);
                        }
                    }
                }

            }

        }

    }

    public void method268(int i, int j, int k, int l, Model class35_sub2_sub1) {
        if (i < 9 || i > 9)
            return;
        if (l < anInt384) {
            Tile class35_sub1 = levelTiles[k][l + 1][j];
            if (class35_sub1 != null && class35_sub1.aTile5_1002 != null && class35_sub1.aTile5_1002.aModel_259.vertexNormals != null)
                method270(class35_sub2_sub1, class35_sub1.aTile5_1002.aModel_259, 128, 0, 0, true);
        }
        if (j < anInt384) {
            Tile class35_sub1_1 = levelTiles[k][l][j + 1];
            if (class35_sub1_1 != null && class35_sub1_1.aTile5_1002 != null && class35_sub1_1.aTile5_1002.aModel_259.vertexNormals != null)
                method270(class35_sub2_sub1, class35_sub1_1.aTile5_1002.aModel_259, 0, 0, 128, true);
        }
        if (l < anInt384 && j < anInt385) {
            Tile class35_sub1_2 = levelTiles[k][l + 1][j + 1];
            if (class35_sub1_2 != null && class35_sub1_2.aTile5_1002 != null && class35_sub1_2.aTile5_1002.aModel_259.vertexNormals != null)
                method270(class35_sub2_sub1, class35_sub1_2.aTile5_1002.aModel_259, 128, 0, 128, true);
        }
        if (l < anInt384 && j > 0) {
            Tile class35_sub1_3 = levelTiles[k][l + 1][j - 1];
            if (class35_sub1_3 != null && class35_sub1_3.aTile5_1002 != null && class35_sub1_3.aTile5_1002.aModel_259.vertexNormals != null)
                method270(class35_sub2_sub1, class35_sub1_3.aTile5_1002.aModel_259, 128, 0, -128, true);
        }
    }

    public void method269(Model class35_sub2_sub1, int i, int j, int k, int l, int i1, int j1) {
        boolean flag = true;
        int k1 = j;
        int l1 = j + k;
        int i2 = j1 - 1;
        int j2 = j1 + l;
        i1 = 43 / i1;
        for (int k2 = i; k2 <= i + 1; k2++)
            if (k2 != anInt383) {
                for (int l2 = k1; l2 <= l1; l2++)
                    if (l2 >= 0 && l2 < anInt384) {
                        for (int i3 = i2; i3 <= j2; i3++)
                            if (i3 >= 0 && i3 < anInt385 && (!flag || l2 >= l1 || i3 >= j2 || i3 < j1 && l2 != j)) {
                                Tile class35_sub1 = levelTiles[k2][l2][i3];
                                if (class35_sub1 != null) {
                                    int j3 = (anIntArrayArrayArray386[k2][l2][i3] + anIntArrayArrayArray386[k2][l2 + 1][i3] + anIntArrayArrayArray386[k2][l2][i3 + 1] + anIntArrayArrayArray386[k2][l2 + 1][i3 + 1]) / 4 - (anIntArrayArrayArray386[i][j][j1] + anIntArrayArrayArray386[i][j + 1][j1] + anIntArrayArrayArray386[i][j][j1 + 1] + anIntArrayArrayArray386[i][j + 1][j1 + 1]) / 4;
                                    Wall class27 = class35_sub1.wall;
                                    if (class27 != null && class27.aModel_362 != null && class27.aModel_362.vertexNormals != null)
                                        method270(class35_sub2_sub1, class27.aModel_362, (l2 - j) * 128 + (1 - k) * 64, j3, (i3 - j1) * 128 + (1 - l) * 64, flag);
                                    if (class27 != null && class27.aModel_363 != null && class27.aModel_363.vertexNormals != null)
                                        method270(class35_sub2_sub1, class27.aModel_363, (l2 - j) * 128 + (1 - k) * 64, j3, (i3 - j1) * 128 + (1 - l) * 64, flag);
                                    for (int k3 = 0; k3 < class35_sub1.anInt1004; k3++) {
                                        Loc class25 = class35_sub1.aTile7Array1005[k3];
                                        if (class25 != null && class25.aModel_343 != null && class25.aModel_343.vertexNormals != null) {
                                            int l3 = (class25.anInt347 - class25.anInt346) + 1;
                                            int i4 = (class25.anInt349 - class25.anInt348) + 1;
                                            method270(class35_sub2_sub1, class25.aModel_343, (class25.anInt346 - j) * 128 + (l3 - k) * 64, j3, (class25.anInt348 - j1) * 128 + (i4 - l) * 64, flag);
                                        }
                                    }

                                }
                            }

                    }

                k1--;
                flag = false;
            }

    }

    public void method270(Model class35_sub2_sub1, Model class35_sub2_sub1_1, int i, int j, int k, boolean flag) {
        anInt434++;
        int l = 0;
        int[] ai = class35_sub2_sub1_1.vertexX;
        int i1 = class35_sub2_sub1_1.vertexCount;
        for (int j1 = 0; j1 < class35_sub2_sub1.vertexCount; j1++) {
            VertexNormal class22 = class35_sub2_sub1.vertexNormals[j1];
            VertexNormal class22_1 = class35_sub2_sub1.vertexNormalOriginal[j1];
            if (class22_1.magnitude != 0) {
                int i2 = class35_sub2_sub1.vertexY[j1] - j;
                if (i2 <= class35_sub2_sub1_1.minBoundY) {
                    int j2 = class35_sub2_sub1.vertexX[j1] - i;
                    if (j2 >= class35_sub2_sub1_1.minBoundX && j2 <= class35_sub2_sub1_1.maxBoundX) {
                        int k2 = class35_sub2_sub1.vertexZ[j1] - k;
                        if (k2 >= class35_sub2_sub1_1.minBoundZ && k2 <= class35_sub2_sub1_1.maxBoundZ) {
                            for (int l2 = 0; l2 < i1; l2++) {
                                VertexNormal class22_2 = class35_sub2_sub1_1.vertexNormals[l2];
                                VertexNormal class22_3 = class35_sub2_sub1_1.vertexNormalOriginal[l2];
                                if (j2 == ai[l2] && k2 == class35_sub2_sub1_1.vertexZ[l2] && i2 == class35_sub2_sub1_1.vertexY[l2] && class22_3.magnitude != 0) {
                                    class22.anInt323 += class22_3.anInt323;
                                    class22.anInt324 += class22_3.anInt324;
                                    class22.anInt325 += class22_3.anInt325;
                                    class22.magnitude += class22_3.magnitude;
                                    class22_2.anInt323 += class22_1.anInt323;
                                    class22_2.anInt324 += class22_1.anInt324;
                                    class22_2.anInt325 += class22_1.anInt325;
                                    class22_2.magnitude += class22_1.magnitude;
                                    l++;
                                    anIntArray432[j1] = anInt434;
                                    anIntArray433[l2] = anInt434;
                                }
                            }

                        }
                    }
                }
            }
        }

        if (l < 3 || !flag)
            return;
        for (int k1 = 0; k1 < class35_sub2_sub1.triangleCount; k1++)
            if (anIntArray432[class35_sub2_sub1.triangleVertexA[k1]] == anInt434 && anIntArray432[class35_sub2_sub1.triangleVertexB[k1]] == anInt434 && anIntArray432[class35_sub2_sub1.triangleVertexC[k1]] == anInt434)
                class35_sub2_sub1.triangleInfo[k1] = -1;

        for (int l1 = 0; l1 < class35_sub2_sub1_1.triangleCount; l1++)
            if (anIntArray433[class35_sub2_sub1_1.triangleVertexA[l1]] == anInt434 && anIntArray433[class35_sub2_sub1_1.triangleVertexB[l1]] == anInt434 && anIntArray433[class35_sub2_sub1_1.triangleVertexC[l1]] == anInt434)
                class35_sub2_sub1_1.triangleInfo[l1] = -1;

    }

    public void method271(int[] ai, int i, int j, int k, int l, int i1) {
        Tile class35_sub1 = levelTiles[k][l][i1];
        if (class35_sub1 == null)
            return;
        TileUnderlay class23 = class35_sub1.underlay;
        if (class23 != null) {
            int j1 = class23.anInt333;
            if (j1 == 0)
                return;
            for (int k1 = 0; k1 < 4; k1++) {
                ai[i] = j1;
                ai[i + 1] = j1;
                ai[i + 2] = j1;
                ai[i + 3] = j1;
                i += j;
            }

            return;
        }
        TileOverlay class15 = class35_sub1.overlay;
        if (class15 == null)
            return;
        int l1 = class15.anInt231;
        int i2 = class15.anInt232;
        int j2 = class15.anInt233;
        int k2 = class15.anInt234;
        int[] ai1 = anIntArrayArray435[l1];
        int[] ai2 = anIntArrayArray436[i2];
        int l2 = 0;
        if (j2 != 0) {
            for (int i3 = 0; i3 < 4; i3++) {
                ai[i] = ai1[ai2[l2++]] != 0 ? k2 : j2;
                ai[i + 1] = ai1[ai2[l2++]] != 0 ? k2 : j2;
                ai[i + 2] = ai1[ai2[l2++]] != 0 ? k2 : j2;
                ai[i + 3] = ai1[ai2[l2++]] != 0 ? k2 : j2;
                i += j;
            }

            return;
        }
        for (int j3 = 0; j3 < 4; j3++) {
            if (ai1[ai2[l2++]] != 0)
                ai[i] = k2;
            if (ai1[ai2[l2++]] != 0)
                ai[i + 1] = k2;
            if (ai1[ai2[l2++]] != 0)
                ai[i + 2] = k2;
            if (ai1[ai2[l2++]] != 0)
                ai[i + 3] = k2;
            i += j;
        }

    }

    public static void method272(int i, int j, int k, int[] ai, int l, int i1) {
        if (j != 6) {
            for (int j1 = 1; j1 > 0; j1++) ;
        }
        anInt441 = 0;
        anInt442 = 0;
        anInt443 = i;
        anInt444 = k;
        anInt439 = i / 2;
        anInt440 = k / 2;
        boolean[][][][] aflag = new boolean[9][32][53][53];
        for (int k1 = 128; k1 <= 384; k1 += 32) {
            for (int l1 = 0; l1 < 2048; l1 += 64) {
                anInt404 = Model.sin[k1];
                anInt405 = Model.cos[k1];
                anInt406 = Model.sin[l1];
                anInt407 = Model.cos[l1];
                int j2 = (k1 - 128) / 32;
                int l2 = l1 / 64;
                for (int j3 = -26; j3 <= 26; j3++) {
                    for (int l3 = -26; l3 <= 26; l3++) {
                        int i4 = j3 * 128;
                        int k4 = l3 * 128;
                        boolean flag1 = false;
                        for (int i5 = -i1; i5 <= l; i5 += 128) {
                            if (!method273(k4, i4, (byte) 54, ai[j2] + i5))
                                continue;
                            flag1 = true;
                            break;
                        }

                        aflag[j2][l2][j3 + 25 + 1][l3 + 25 + 1] = flag1;
                    }

                }

            }

        }

        for (int i2 = 0; i2 < 8; i2++) {
            for (int k2 = 0; k2 < 32; k2++) {
                for (int i3 = -25; i3 < 25; i3++) {
                    for (int k3 = -25; k3 < 25; k3++) {
                        boolean flag = false;
                        label0:
                        for (int j4 = -1; j4 <= 1; j4++) {
                            for (int l4 = -1; l4 <= 1; l4++) {
                                if (aflag[i2][k2][i3 + j4 + 25 + 1][k3 + l4 + 25 + 1])
                                    flag = true;
                                else if (aflag[i2][(k2 + 1) % 31][i3 + j4 + 25 + 1][k3 + l4 + 25 + 1])
                                    flag = true;
                                else if (aflag[i2 + 1][k2][i3 + j4 + 25 + 1][k3 + l4 + 25 + 1]) {
                                    flag = true;
                                } else {
                                    if (!aflag[i2 + 1][(k2 + 1) % 31][i3 + j4 + 25 + 1][k3 + l4 + 25 + 1])
                                        continue;
                                    flag = true;
                                }
                                break label0;
                            }

                        }

                        aBooleanArrayArrayArrayArray437[i2][k2][i3 + 25][k3 + 25] = flag;
                    }

                }

            }

        }

    }

    public static boolean method273(int i, int j, byte byte0, int k) {
        int l = i * anInt406 + j * anInt407 >> 16;
        int i1 = i * anInt407 - j * anInt406 >> 16;
        int j1 = k * anInt404 + i1 * anInt405 >> 16;
        int k1 = k * anInt405 - i1 * anInt404 >> 16;
        if (byte0 != 54)
            throw new NullPointerException();
        if (j1 < 50 || j1 > 3500)
            return false;
        int l1 = anInt439 + (l << 9) / j1;
        int i2 = anInt440 + (k1 << 9) / j1;
        return l1 >= anInt441 && l1 <= anInt443 && i2 >= anInt442 && i2 <= anInt444;
    }

    public void method274(int i, int j, int k) {
        aBoolean413 = true;
        anInt414 = j;
        if (i != 0) {
            for (int l = 1; l > 0; l++) ;
        }
        anInt415 = k;
        anInt416 = -1;
        anInt417 = -1;
    }

    public void method275(int i, int j, int k, int l, int i1, int j1, int k1, int cycle) {
        if (i < 0)
            i = 0;
        else if (i >= anInt384 * 128)
            i = anInt384 * 128 - 1;
        if (i1 < 0)
            i1 = 0;
        else if (i1 >= anInt385 * 128)
            i1 = anInt385 * 128 - 1;
        anInt394++;
        anInt404 = Model.sin[j1];
        anInt405 = Model.cos[j1];
        anInt406 = Model.sin[k1];
        anInt407 = Model.cos[k1];
        aBooleanArrayArray438 = aBooleanArrayArrayArrayArray437[(j1 - 128) / 32][k1 / 64];
        anInt401 = i;
        anInt402 = l;
        anInt403 = i1;
        anInt399 = i / 128;
        anInt400 = i1 / 128;
        anInt393 = j;
        anInt395 = anInt399 - 25;
        if (anInt395 < 0)
            anInt395 = 0;
        anInt397 = anInt400 - 25;
        if (anInt397 < 0)
            anInt397 = 0;
        anInt396 = anInt399 + 25;
        if (anInt396 > anInt384)
            anInt396 = anInt384;
        anInt398 = anInt400 + 25;
        if (anInt398 > anInt385)
            anInt398 = anInt385;
        method281(true);
        anInt392 = 0;
        for (int l1 = anInt388; l1 < anInt383; l1++) {
            Tile[][] aclass35_sub1 = levelTiles[l1];
            for (int j2 = anInt395; j2 < anInt396; j2++) {
                for (int l2 = anInt397; l2 < anInt398; l2++) {
                    Tile class35_sub1 = aclass35_sub1[j2][l2];
                    if (class35_sub1 != null)
                        if (class35_sub1.anInt1008 > j || !aBooleanArrayArray438[(j2 - anInt399) + 25][(l2 - anInt400) + 25] && anIntArrayArrayArray386[l1][j2][l2] - l < 2000) {
                            class35_sub1.aBoolean1009 = false;
                            class35_sub1.aBoolean1010 = false;
                            class35_sub1.anInt1012 = 0;
                        } else {
                            class35_sub1.aBoolean1009 = true;
                            class35_sub1.aBoolean1010 = true;
                            class35_sub1.aBoolean1011 = class35_sub1.anInt1004 > 0;
                            anInt392++;
                        }
                }

            }

        }

        if (k != 2)
            anInt380 = -429;
        for (int i2 = anInt388; i2 < anInt383; i2++) {
            Tile[][] aclass35_sub1_1 = levelTiles[i2];
            for (int i3 = -25; i3 <= 0; i3++) {
                int j3 = anInt399 + i3;
                int l3 = anInt399 - i3;
                if (j3 >= anInt395 || l3 < anInt396) {
                    for (int j4 = -25; j4 <= 0; j4++) {
                        int l4 = anInt400 + j4;
                        int j5 = anInt400 - j4;
                        if (j3 >= anInt395) {
                            if (l4 >= anInt397) {
                                Tile class35_sub1_1 = aclass35_sub1_1[j3][l4];
                                if (class35_sub1_1 != null && class35_sub1_1.aBoolean1009)
                                    method276(class35_sub1_1, true, cycle);
                            }
                            if (j5 < anInt398) {
                                Tile class35_sub1_2 = aclass35_sub1_1[j3][j5];
                                if (class35_sub1_2 != null && class35_sub1_2.aBoolean1009)
                                    method276(class35_sub1_2, true, cycle);
                            }
                        }
                        if (l3 < anInt396) {
                            if (l4 >= anInt397) {
                                Tile class35_sub1_3 = aclass35_sub1_1[l3][l4];
                                if (class35_sub1_3 != null && class35_sub1_3.aBoolean1009)
                                    method276(class35_sub1_3, true, cycle);
                            }
                            if (j5 < anInt398) {
                                Tile class35_sub1_4 = aclass35_sub1_1[l3][j5];
                                if (class35_sub1_4 != null && class35_sub1_4.aBoolean1009)
                                    method276(class35_sub1_4, true, cycle);
                            }
                        }
                        if (anInt392 == 0) {
                            aBoolean413 = false;
                            return;
                        }
                    }

                }
            }

        }

        for (int k2 = anInt388; k2 < anInt383; k2++) {
            Tile[][] aclass35_sub1_2 = levelTiles[k2];
            for (int k3 = -25; k3 <= 0; k3++) {
                int i4 = anInt399 + k3;
                int k4 = anInt399 - k3;
                if (i4 >= anInt395 || k4 < anInt396) {
                    for (int i5 = -25; i5 <= 0; i5++) {
                        int k5 = anInt400 + i5;
                        int l5 = anInt400 - i5;
                        if (i4 >= anInt395) {
                            if (k5 >= anInt397) {
                                Tile class35_sub1_5 = aclass35_sub1_2[i4][k5];
                                if (class35_sub1_5 != null && class35_sub1_5.aBoolean1009)
                                    method276(class35_sub1_5, false, cycle);
                            }
                            if (l5 < anInt398) {
                                Tile class35_sub1_6 = aclass35_sub1_2[i4][l5];
                                if (class35_sub1_6 != null && class35_sub1_6.aBoolean1009)
                                    method276(class35_sub1_6, false, cycle);
                            }
                        }
                        if (k4 < anInt396) {
                            if (k5 >= anInt397) {
                                Tile class35_sub1_7 = aclass35_sub1_2[k4][k5];
                                if (class35_sub1_7 != null && class35_sub1_7.aBoolean1009)
                                    method276(class35_sub1_7, false, cycle);
                            }
                            if (l5 < anInt398) {
                                Tile class35_sub1_8 = aclass35_sub1_2[k4][l5];
                                if (class35_sub1_8 != null && class35_sub1_8.aBoolean1009)
                                    method276(class35_sub1_8, false, cycle);
                            }
                        }
                        if (anInt392 == 0) {
                            aBoolean413 = false;
                            return;
                        }
                    }

                }
            }

        }

    }

    public void method276(Tile class35_sub1, boolean flag, int cycle) {
        aLinkedList_423.pushNext(class35_sub1);
        do {
            Tile class35_sub1_1;
            do {
                class35_sub1_1 = (Tile) aLinkedList_423.poll();
                if (class35_sub1_1 == null)
                    return;
            } while (!class35_sub1_1.aBoolean1010);
            int i = class35_sub1_1.anInt995;
            int j = class35_sub1_1.anInt996;
            int k = class35_sub1_1.anInt994;
            int l = class35_sub1_1.anInt997;
            Tile[][] aclass35_sub1 = levelTiles[k];
            if (class35_sub1_1.aBoolean1009) {
                if (flag) {
                    if (k > 0) {
                        Tile class35_sub1_2 = levelTiles[k - 1][i][j];
                        if (class35_sub1_2 != null && class35_sub1_2.aBoolean1010)
                            continue;
                    }
                    if (i <= anInt399 && i > anInt395) {
                        Tile class35_sub1_3 = aclass35_sub1[i - 1][j];
                        if (class35_sub1_3 != null && class35_sub1_3.aBoolean1010 && (class35_sub1_3.aBoolean1009 || (class35_sub1_1.anInt1007 & 1) == 0))
                            continue;
                    }
                    if (i >= anInt399 && i < anInt396 - 1) {
                        Tile class35_sub1_4 = aclass35_sub1[i + 1][j];
                        if (class35_sub1_4 != null && class35_sub1_4.aBoolean1010 && (class35_sub1_4.aBoolean1009 || (class35_sub1_1.anInt1007 & 4) == 0))
                            continue;
                    }
                    if (j <= anInt400 && j > anInt397) {
                        Tile class35_sub1_5 = aclass35_sub1[i][j - 1];
                        if (class35_sub1_5 != null && class35_sub1_5.aBoolean1010 && (class35_sub1_5.aBoolean1009 || (class35_sub1_1.anInt1007 & 8) == 0))
                            continue;
                    }
                    if (j >= anInt400 && j < anInt398 - 1) {
                        Tile class35_sub1_6 = aclass35_sub1[i][j + 1];
                        if (class35_sub1_6 != null && class35_sub1_6.aBoolean1010 && (class35_sub1_6.aBoolean1009 || (class35_sub1_1.anInt1007 & 2) == 0))
                            continue;
                    }
                } else {
                    flag = true;
                }
                class35_sub1_1.aBoolean1009 = false;
                if (class35_sub1_1.aClass35_Sub1_1016 != null) {
                    Tile class35_sub1_7 = class35_sub1_1.aClass35_Sub1_1016;
                    if (class35_sub1_7.underlay != null) {
                        if (!method282(0, i, j))
                            method277(class35_sub1_7.underlay, 0, anInt404, anInt405, anInt406, anInt407, i, j);
                    } else if (class35_sub1_7.overlay != null && !method282(0, i, j))
                        method278(class35_sub1_7.overlay, anInt404, anInt406, anInt405, i, false, j, anInt407);
                    Wall class27 = class35_sub1_7.wall;
                    if (class27 != null)
                        class27.aModel_362.method324(0, anInt404, anInt405, anInt406, anInt407, class27.anInt358 - anInt401, class27.anInt357 - anInt402, class27.anInt359 - anInt403, class27.anInt364);
                    for (int i2 = 0; i2 < class35_sub1_7.anInt1004; i2++) {
                        Loc class25 = class35_sub1_7.aTile7Array1005[i2];
                        if (class25 != null) {
                            Model class35_sub2_sub1 = class25.aModel_343;
                            if (class35_sub2_sub1 == null)
                                class35_sub2_sub1 = class25.aClass35_Sub7_344.getDrawMethod();
                            class35_sub2_sub1.method324(class25.anInt345, anInt404, anInt405, anInt406, anInt407, class25.anInt341 - anInt401, class25.anInt340 - anInt402, class25.anInt342 - anInt403, class25.anInt352);
                        }
                    }

                }
                boolean flag1 = false;
                if (class35_sub1_1.underlay != null) {
                    if (!method282(l, i, j)) {
                        flag1 = true;
                        method277(class35_sub1_1.underlay, l, anInt404, anInt405, anInt406, anInt407, i, j);
                    }
                } else if (class35_sub1_1.overlay != null && !method282(l, i, j)) {
                    flag1 = true;
                    method278(class35_sub1_1.overlay, anInt404, anInt406, anInt405, i, false, j, anInt407);
                }
                int j1 = 0;
                int j2 = 0;
                Wall class27_3 = class35_sub1_1.wall;
                WallDecoration class13_1 = class35_sub1_1.aTile4_1001;
                if (class27_3 != null || class13_1 != null) {
                    if (anInt399 == i)
                        j1++;
                    else if (anInt399 < i)
                        j1 += 2;
                    if (anInt400 == j)
                        j1 += 3;
                    else if (anInt400 > j)
                        j1 += 6;
                    j2 = anIntArray424[j1];
                    class35_sub1_1.anInt1015 = anIntArray426[j1];
                }
                if (class27_3 != null) {
                    if ((class27_3.anInt360 & anIntArray425[j1]) != 0) {
                        if (class27_3.anInt360 == 16) {
                            class35_sub1_1.anInt1012 = 3;
                            class35_sub1_1.anInt1013 = anIntArray427[j1];
                            class35_sub1_1.anInt1014 = 3 - class35_sub1_1.anInt1013;
                        } else if (class27_3.anInt360 == 32) {
                            class35_sub1_1.anInt1012 = 6;
                            class35_sub1_1.anInt1013 = anIntArray428[j1];
                            class35_sub1_1.anInt1014 = 6 - class35_sub1_1.anInt1013;
                        } else if (class27_3.anInt360 == 64) {
                            class35_sub1_1.anInt1012 = 12;
                            class35_sub1_1.anInt1013 = anIntArray429[j1];
                            class35_sub1_1.anInt1014 = 12 - class35_sub1_1.anInt1013;
                        } else {
                            class35_sub1_1.anInt1012 = 9;
                            class35_sub1_1.anInt1013 = anIntArray430[j1];
                            class35_sub1_1.anInt1014 = 9 - class35_sub1_1.anInt1013;
                        }
                    } else {
                        class35_sub1_1.anInt1012 = 0;
                    }
                    if ((class27_3.anInt360 & j2) != 0 && !method283(l, i, j, class27_3.anInt360))
                        class27_3.aModel_362.method324(0, anInt404, anInt405, anInt406, anInt407, class27_3.anInt358 - anInt401, class27_3.anInt357 - anInt402, class27_3.anInt359 - anInt403, class27_3.anInt364);
                    if ((class27_3.anInt361 & j2) != 0 && !method283(l, i, j, class27_3.anInt361))
                        class27_3.aModel_363.method324(0, anInt404, anInt405, anInt406, anInt407, class27_3.anInt358 - anInt401, class27_3.anInt357 - anInt402, class27_3.anInt359 - anInt403, class27_3.anInt364);
                }
                if (class13_1 != null && !method284(l, i, j, class13_1.aModel_208.maxBoundY))
                    if ((class13_1.anInt206 & j2) != 0)
                        class13_1.aModel_208.method324(class13_1.anInt207, anInt404, anInt405, anInt406, anInt407, class13_1.anInt204 - anInt401, class13_1.anInt203 - anInt402, class13_1.anInt205 - anInt403, class13_1.anInt209);
                    else if ((class13_1.anInt206 & 0x300) != 0) {
                        int j4 = class13_1.anInt204 - anInt401;
                        int l5 = class13_1.anInt203 - anInt402;
                        int k6 = class13_1.anInt205 - anInt403;
                        int k7 = class13_1.anInt207;
                        int l8;
                        if (k7 == 1 || k7 == 2)
                            l8 = -j4;
                        else
                            l8 = j4;
                        int l9;
                        if (k7 == 2 || k7 == 3)
                            l9 = -k6;
                        else
                            l9 = k6;
                        if ((class13_1.anInt206 & 0x100) != 0 && l9 < l8) {
                            int i10 = j4 + anIntArray409[k7];
                            int k10 = k6 + anIntArray410[k7];
                            class13_1.aModel_208.method324(k7 * 512 + 256, anInt404, anInt405, anInt406, anInt407, i10, l5, k10, class13_1.anInt209);
                        }
                        if ((class13_1.anInt206 & 0x200) != 0 && l9 > l8) {
                            int j10 = j4 + anIntArray411[k7];
                            int l10 = k6 + anIntArray412[k7];
                            class13_1.aModel_208.method324(k7 * 512 + 1280 & 0x7ff, anInt404, anInt405, anInt406, anInt407, j10, l5, l10, class13_1.anInt209);
                        }
                    }
                if (flag1) {
                    GroundDecoration class17 = class35_sub1_1.aTile5_1002;
                    if (class17 != null)
                        class17.aModel_259.method324(0, anInt404, anInt405, anInt406, anInt407, class17.anInt257 - anInt401, class17.anInt256 - anInt402, class17.anInt258 - anInt403, class17.anInt260);
                    ObjEntity class19_1 = class35_sub1_1.aTile6_1003;
                    if (class19_1 != null && class19_1.anInt288 == 0) {
                        if (class19_1.aModel_285 != null)
                            class19_1.aModel_285.method324(0, anInt404, anInt405, anInt406, anInt407, class19_1.anInt282 - anInt401, class19_1.anInt281 - anInt402, class19_1.anInt283 - anInt403, class19_1.anInt287);
                        if (class19_1.aModel_286 != null)
                            class19_1.aModel_286.method324(0, anInt404, anInt405, anInt406, anInt407, class19_1.anInt282 - anInt401, class19_1.anInt281 - anInt402, class19_1.anInt283 - anInt403, class19_1.anInt287);
                        if (class19_1.aModel_284 != null)
                            class19_1.aModel_284.method324(0, anInt404, anInt405, anInt406, anInt407, class19_1.anInt282 - anInt401, class19_1.anInt281 - anInt402, class19_1.anInt283 - anInt403, class19_1.anInt287);
                    }
                }
                int k4 = class35_sub1_1.anInt1007;
                if (k4 != 0) {
                    if (i < anInt399 && (k4 & 4) != 0) {
                        Tile class35_sub1_17 = aclass35_sub1[i + 1][j];
                        if (class35_sub1_17 != null && class35_sub1_17.aBoolean1010)
                            aLinkedList_423.pushNext(class35_sub1_17);
                    }
                    if (j < anInt400 && (k4 & 2) != 0) {
                        Tile class35_sub1_18 = aclass35_sub1[i][j + 1];
                        if (class35_sub1_18 != null && class35_sub1_18.aBoolean1010)
                            aLinkedList_423.pushNext(class35_sub1_18);
                    }
                    if (i > anInt399 && (k4 & 1) != 0) {
                        Tile class35_sub1_19 = aclass35_sub1[i - 1][j];
                        if (class35_sub1_19 != null && class35_sub1_19.aBoolean1010)
                            aLinkedList_423.pushNext(class35_sub1_19);
                    }
                    if (j > anInt400 && (k4 & 8) != 0) {
                        Tile class35_sub1_20 = aclass35_sub1[i][j - 1];
                        if (class35_sub1_20 != null && class35_sub1_20.aBoolean1010)
                            aLinkedList_423.pushNext(class35_sub1_20);
                    }
                }
            }
            if (class35_sub1_1.anInt1012 != 0) {
                boolean flag2 = true;
                for (int k1 = 0; k1 < class35_sub1_1.anInt1004; k1++) {
                    if (class35_sub1_1.aTile7Array1005[k1].anInt351 == anInt394 || (class35_sub1_1.anIntArray1006[k1] & class35_sub1_1.anInt1012) != class35_sub1_1.anInt1013)
                        continue;
                    flag2 = false;
                    break;
                }

                if (flag2) {
                    Wall class27_1 = class35_sub1_1.wall;
                    if (!method283(l, i, j, class27_1.anInt360))
                        class27_1.aModel_362.method324(0, anInt404, anInt405, anInt406, anInt407, class27_1.anInt358 - anInt401, class27_1.anInt357 - anInt402, class27_1.anInt359 - anInt403, class27_1.anInt364);
                    class35_sub1_1.anInt1012 = 0;
                }
            }
            if (class35_sub1_1.aBoolean1011) {
                int i1 = class35_sub1_1.anInt1004;
                class35_sub1_1.aBoolean1011 = false;
                int l1 = 0;
                label0:
                for (int k2 = 0; k2 < i1; k2++) {
                    Loc class25_1 = class35_sub1_1.aTile7Array1005[k2];
                    if (class25_1.anInt351 == anInt394)
                        continue;
                    for (int k3 = class25_1.anInt346; k3 <= class25_1.anInt347; k3++) {
                        for (int l4 = class25_1.anInt348; l4 <= class25_1.anInt349; l4++) {
                            Tile class35_sub1_21 = aclass35_sub1[k3][l4];
                            if (class35_sub1_21.aBoolean1009) {
                                class35_sub1_1.aBoolean1011 = true;
                            } else {
                                if (class35_sub1_21.anInt1012 == 0)
                                    continue;
                                int l6 = 0;
                                if (k3 > class25_1.anInt346)
                                    l6++;
                                if (k3 < class25_1.anInt347)
                                    l6 += 4;
                                if (l4 > class25_1.anInt348)
                                    l6 += 8;
                                if (l4 < class25_1.anInt349)
                                    l6 += 2;
                                if ((l6 & class35_sub1_21.anInt1012) != class35_sub1_1.anInt1014)
                                    continue;
                                class35_sub1_1.aBoolean1011 = true;
                            }
                            continue label0;
                        }

                    }

                    aTile7Array408[l1++] = class25_1;
                    int i5 = anInt399 - class25_1.anInt346;
                    int i6 = class25_1.anInt347 - anInt399;
                    if (i6 > i5)
                        i5 = i6;
                    int i7 = anInt400 - class25_1.anInt348;
                    int l7 = class25_1.anInt349 - anInt400;
                    if (l7 > i7)
                        class25_1.anInt350 = i5 + l7;
                    else
                        class25_1.anInt350 = i5 + i7;
                }

                while (l1 > 0) {
                    int i3 = -50;
                    int l3 = -1;
                    for (int j5 = 0; j5 < l1; j5++) {
                        Loc class25_2 = aTile7Array408[j5];
                        if (class25_2.anInt350 > i3 && class25_2.anInt351 != anInt394) {
                            i3 = class25_2.anInt350;
                            l3 = j5;
                        }
                    }

                    if (l3 == -1)
                        break;
                    Loc class25_3 = aTile7Array408[l3];
                    class25_3.anInt351 = anInt394;
                    Model class35_sub2_sub1_1 = class25_3.aModel_343;
                    if (class35_sub2_sub1_1 == null)
                        class35_sub2_sub1_1 = class25_3.aClass35_Sub7_344.getDrawMethod();
                    if (!method285(l, class25_3.anInt346, class25_3.anInt347, class25_3.anInt348, class25_3.anInt349, class35_sub2_sub1_1.maxBoundY))
                        class35_sub2_sub1_1.method324(class25_3.anInt345, anInt404, anInt405, anInt406, anInt407, class25_3.anInt341 - anInt401, class25_3.anInt340 - anInt402, class25_3.anInt342 - anInt403, class25_3.anInt352);
                    for (int i8 = class25_3.anInt346; i8 <= class25_3.anInt347; i8++) {
                        for (int i9 = class25_3.anInt348; i9 <= class25_3.anInt349; i9++) {
                            Tile class35_sub1_22 = aclass35_sub1[i8][i9];
                            if (class35_sub1_22.anInt1012 != 0)
                                aLinkedList_423.pushNext(class35_sub1_22);
                            else if ((i8 != i || i9 != j) && class35_sub1_22.aBoolean1010)
                                aLinkedList_423.pushNext(class35_sub1_22);
                        }

                    }

                }
                if (class35_sub1_1.aBoolean1011)
                    continue;
            }
            if (!class35_sub1_1.aBoolean1010 || class35_sub1_1.anInt1012 != 0)
                continue;
            if (i <= anInt399 && i > anInt395) {
                Tile class35_sub1_8 = aclass35_sub1[i - 1][j];
                if (class35_sub1_8 != null && class35_sub1_8.aBoolean1010)
                    continue;
            }
            if (i >= anInt399 && i < anInt396 - 1) {
                Tile class35_sub1_9 = aclass35_sub1[i + 1][j];
                if (class35_sub1_9 != null && class35_sub1_9.aBoolean1010)
                    continue;
            }
            if (j <= anInt400 && j > anInt397) {
                Tile class35_sub1_10 = aclass35_sub1[i][j - 1];
                if (class35_sub1_10 != null && class35_sub1_10.aBoolean1010)
                    continue;
            }
            if (j >= anInt400 && j < anInt398 - 1) {
                Tile class35_sub1_11 = aclass35_sub1[i][j + 1];
                if (class35_sub1_11 != null && class35_sub1_11.aBoolean1010)
                    continue;
            }
            class35_sub1_1.aBoolean1010 = false;
            anInt392--;
            ObjEntity class19 = class35_sub1_1.aTile6_1003;
            if (class19 != null && class19.anInt288 != 0) {
                if (class19.aModel_285 != null)
                    class19.aModel_285.method324(0, anInt404, anInt405, anInt406, anInt407, class19.anInt282 - anInt401, class19.anInt281 - anInt402 - class19.anInt288, class19.anInt283 - anInt403, class19.anInt287);
                if (class19.aModel_286 != null)
                    class19.aModel_286.method324(0, anInt404, anInt405, anInt406, anInt407, class19.anInt282 - anInt401, class19.anInt281 - anInt402 - class19.anInt288, class19.anInt283 - anInt403, class19.anInt287);
                if (class19.aModel_284 != null)
                    class19.aModel_284.method324(0, anInt404, anInt405, anInt406, anInt407, class19.anInt282 - anInt401, class19.anInt281 - anInt402 - class19.anInt288, class19.anInt283 - anInt403, class19.anInt287);
            }
            if (class35_sub1_1.anInt1015 != 0) {
                WallDecoration class13 = class35_sub1_1.aTile4_1001;
                if (class13 != null && !method284(l, i, j, class13.aModel_208.maxBoundY))
                    if ((class13.anInt206 & class35_sub1_1.anInt1015) != 0)
                        class13.aModel_208.method324(class13.anInt207, anInt404, anInt405, anInt406, anInt407, class13.anInt204 - anInt401, class13.anInt203 - anInt402, class13.anInt205 - anInt403, class13.anInt209);
                    else if ((class13.anInt206 & 0x300) != 0) {
                        int l2 = class13.anInt204 - anInt401;
                        int j3 = class13.anInt203 - anInt402;
                        int i4 = class13.anInt205 - anInt403;
                        int k5 = class13.anInt207;
                        int j6;
                        if (k5 == 1 || k5 == 2)
                            j6 = -l2;
                        else
                            j6 = l2;
                        int j7;
                        if (k5 == 2 || k5 == 3)
                            j7 = -i4;
                        else
                            j7 = i4;
                        if ((class13.anInt206 & 0x100) != 0 && j7 >= j6) {
                            int j8 = l2 + anIntArray409[k5];
                            int j9 = i4 + anIntArray410[k5];
                            class13.aModel_208.method324(k5 * 512 + 256, anInt404, anInt405, anInt406, anInt407, j8, j3, j9, class13.anInt209);
                        }
                        if ((class13.anInt206 & 0x200) != 0 && j7 <= j6) {
                            int k8 = l2 + anIntArray411[k5];
                            int k9 = i4 + anIntArray412[k5];
                            class13.aModel_208.method324(k5 * 512 + 1280 & 0x7ff, anInt404, anInt405, anInt406, anInt407, k8, j3, k9, class13.anInt209);
                        }
                    }
                Wall class27_2 = class35_sub1_1.wall;
                if (class27_2 != null) {
                    if ((class27_2.anInt361 & class35_sub1_1.anInt1015) != 0 && !method283(l, i, j, class27_2.anInt361))
                        class27_2.aModel_363.method324(0, anInt404, anInt405, anInt406, anInt407, class27_2.anInt358 - anInt401, class27_2.anInt357 - anInt402, class27_2.anInt359 - anInt403, class27_2.anInt364);
                    if ((class27_2.anInt360 & class35_sub1_1.anInt1015) != 0 && !method283(l, i, j, class27_2.anInt360))
                        class27_2.aModel_362.method324(0, anInt404, anInt405, anInt406, anInt407, class27_2.anInt358 - anInt401, class27_2.anInt357 - anInt402, class27_2.anInt359 - anInt403, class27_2.anInt364);
                }
            }
            if (k < anInt383 - 1) {
                Tile class35_sub1_12 = levelTiles[k + 1][i][j];
                if (class35_sub1_12 != null && class35_sub1_12.aBoolean1010)
                    aLinkedList_423.pushNext(class35_sub1_12);
            }
            if (i < anInt399) {
                Tile class35_sub1_13 = aclass35_sub1[i + 1][j];
                if (class35_sub1_13 != null && class35_sub1_13.aBoolean1010)
                    aLinkedList_423.pushNext(class35_sub1_13);
            }
            if (j < anInt400) {
                Tile class35_sub1_14 = aclass35_sub1[i][j + 1];
                if (class35_sub1_14 != null && class35_sub1_14.aBoolean1010)
                    aLinkedList_423.pushNext(class35_sub1_14);
            }
            if (i > anInt399) {
                Tile class35_sub1_15 = aclass35_sub1[i - 1][j];
                if (class35_sub1_15 != null && class35_sub1_15.aBoolean1010)
                    aLinkedList_423.pushNext(class35_sub1_15);
            }
            if (j > anInt400) {
                Tile class35_sub1_16 = aclass35_sub1[i][j - 1];
                if (class35_sub1_16 != null && class35_sub1_16.aBoolean1010)
                    aLinkedList_423.pushNext(class35_sub1_16);
            }
        } while (true);
    }

    public void method277(TileUnderlay class23, int i, int j, int k, int l, int i1, int j1,
                          int k1) {
        int l1;
        int i2 = l1 = (j1 << 7) - anInt401;
        int j2;
        int k2 = j2 = (k1 << 7) - anInt403;
        int l2;
        int i3 = l2 = i2 + 128;
        int j3;
        int k3 = j3 = k2 + 128;
        int l3 = anIntArrayArrayArray386[i][j1][k1] - anInt402;
        int i4 = anIntArrayArrayArray386[i][j1 + 1][k1] - anInt402;
        int j4 = anIntArrayArrayArray386[i][j1 + 1][k1 + 1] - anInt402;
        int k4 = anIntArrayArrayArray386[i][j1][k1 + 1] - anInt402;
        int l4 = k2 * l + i2 * i1 >> 16;
        k2 = k2 * i1 - i2 * l >> 16;
        i2 = l4;
        l4 = l3 * k - k2 * j >> 16;
        k2 = l3 * j + k2 * k >> 16;
        l3 = l4;
        if (k2 < 50)
            return;
        l4 = j2 * l + i3 * i1 >> 16;
        j2 = j2 * i1 - i3 * l >> 16;
        i3 = l4;
        l4 = i4 * k - j2 * j >> 16;
        j2 = i4 * j + j2 * k >> 16;
        i4 = l4;
        if (j2 < 50)
            return;
        l4 = k3 * l + l2 * i1 >> 16;
        k3 = k3 * i1 - l2 * l >> 16;
        l2 = l4;
        l4 = j4 * k - k3 * j >> 16;
        k3 = j4 * j + k3 * k >> 16;
        j4 = l4;
        if (k3 < 50)
            return;
        l4 = j3 * l + l1 * i1 >> 16;
        j3 = j3 * i1 - l1 * l >> 16;
        l1 = l4;
        l4 = k4 * k - j3 * j >> 16;
        j3 = k4 * j + j3 * k >> 16;
        k4 = l4;
        if (j3 < 50)
            return;
        int i5 = Draw3D.anInt1267 + (i2 << 9) / k2;
        int j5 = Draw3D.anInt1268 + (l3 << 9) / k2;
        int k5 = Draw3D.anInt1267 + (i3 << 9) / j2;
        int l5 = Draw3D.anInt1268 + (i4 << 9) / j2;
        int i6 = Draw3D.anInt1267 + (l2 << 9) / k3;
        int j6 = Draw3D.anInt1268 + (j4 << 9) / k3;
        int k6 = Draw3D.anInt1267 + (l1 << 9) / j3;
        int l6 = Draw3D.anInt1268 + (k4 << 9) / j3;
        Draw3D.anInt1266 = 0;
        if ((i6 - k6) * (l5 - l6) - (j6 - l6) * (k5 - k6) > 0) {
            Draw3D.aBoolean1263 = i6 < 0 || k6 < 0 || k5 < 0 || i6 > Draw2D.safeX || k6 > Draw2D.safeX || k5 > Draw2D.safeX;
            if (aBoolean413 && method280(anInt414, anInt415, j6, l6, l5, i6, k6, k5)) {
                anInt416 = j1;
                anInt417 = k1;
            }
            if (class23.anInt331 == -1) {
                if (class23.anInt329 != 0xbc614e)
                    Draw3D.method348(j6, l6, l5, i6, k6, k5, class23.anInt329, class23.anInt330, class23.anInt328);
            } else if (!aBoolean382) {
                if (class23.aBoolean332)
                    Draw3D.method352(j6, l6, l5, i6, k6, k5, class23.anInt329, class23.anInt330, class23.anInt328, i2, i3, l1, l3, i4, k4, k2, j2, j3, class23.anInt331);
                else
                    Draw3D.method352(j6, l6, l5, i6, k6, k5, class23.anInt329, class23.anInt330, class23.anInt328, l2, l1, i3, j4, k4, i4, k3, j3, j2, class23.anInt331);
            } else {
                int i7 = anIntArray431[class23.anInt331];
                Draw3D.method348(j6, l6, l5, i6, k6, k5, method279(i7, class23.anInt329, 9), method279(i7, class23.anInt330, 9), method279(i7, class23.anInt328, 9));
            }
        }
        if ((i5 - k5) * (l6 - l5) - (j5 - l5) * (k6 - k5) > 0) {
            Draw3D.aBoolean1263 = i5 < 0 || k5 < 0 || k6 < 0 || i5 > Draw2D.safeX || k5 > Draw2D.safeX || k6 > Draw2D.safeX;
            if (aBoolean413 && method280(anInt414, anInt415, j5, l5, l6, i5, k5, k6)) {
                anInt416 = j1;
                anInt417 = k1;
            }
            if (class23.anInt331 == -1) {
                if (class23.anInt327 != 0xbc614e) {
                    Draw3D.method348(j5, l5, l6, i5, k5, k6, class23.anInt327, class23.anInt328, class23.anInt330);
                    return;
                }
            } else {
                if (!aBoolean382) {
                    Draw3D.method352(j5, l5, l6, i5, k5, k6, class23.anInt327, class23.anInt328, class23.anInt330, i2, i3, l1, l3, i4, k4, k2, j2, j3, class23.anInt331);
                    return;
                }
                int j7 = anIntArray431[class23.anInt331];
                Draw3D.method348(j5, l5, l6, i5, k5, k6, method279(j7, class23.anInt327, 9), method279(j7, class23.anInt328, 9), method279(j7, class23.anInt330, 9));
            }
        }
    }

    public void method278(TileOverlay class15, int i, int j, int k, int l, boolean flag, int i1,
                          int j1) {
        int k1 = class15.anIntArray220.length;
        for (int l1 = 0; l1 < k1; l1++) {
            int i2 = class15.anIntArray220[l1] - anInt401;
            int k2 = class15.anIntArray221[l1] - anInt402;
            int i3 = class15.anIntArray222[l1] - anInt403;
            int k3 = i3 * j + i2 * j1 >> 16;
            i3 = i3 * j1 - i2 * j >> 16;
            i2 = k3;
            k3 = k2 * k - i3 * i >> 16;
            i3 = k2 * i + i3 * k >> 16;
            k2 = k3;
            if (i3 < 50)
                return;
            if (class15.anIntArray229 != null) {
                TileOverlay.anIntArray237[l1] = i2;
                TileOverlay.anIntArray238[l1] = k2;
                TileOverlay.anIntArray239[l1] = i3;
            }
            TileOverlay.anIntArray235[l1] = Draw3D.anInt1267 + (i2 << 9) / i3;
            TileOverlay.anIntArray236[l1] = Draw3D.anInt1268 + (k2 << 9) / i3;
        }

        Draw3D.anInt1266 = 0;
        if (flag)
            anInt381 = 174;
        k1 = class15.anIntArray226.length;
        for (int j2 = 0; j2 < k1; j2++) {
            int l2 = class15.anIntArray226[j2];
            int j3 = class15.anIntArray227[j2];
            int l3 = class15.anIntArray228[j2];
            int i4 = TileOverlay.anIntArray235[l2];
            int j4 = TileOverlay.anIntArray235[j3];
            int k4 = TileOverlay.anIntArray235[l3];
            int l4 = TileOverlay.anIntArray236[l2];
            int i5 = TileOverlay.anIntArray236[j3];
            int j5 = TileOverlay.anIntArray236[l3];
            if ((i4 - j4) * (j5 - i5) - (l4 - i5) * (k4 - j4) > 0) {
                Draw3D.aBoolean1263 = i4 < 0 || j4 < 0 || k4 < 0 || i4 > Draw2D.safeX || j4 > Draw2D.safeX || k4 > Draw2D.safeX;
                if (aBoolean413 && method280(anInt414, anInt415, l4, i5, j5, i4, j4, k4)) {
                    anInt416 = l;
                    anInt417 = i1;
                }
                if (class15.anIntArray229 == null || class15.anIntArray229[j2] == -1) {
                    if (class15.anIntArray223[j2] != 0xbc614e)
                        Draw3D.method348(l4, i5, j5, i4, j4, k4, class15.anIntArray223[j2], class15.anIntArray224[j2], class15.anIntArray225[j2]);
                } else if (!aBoolean382) {
                    if (class15.aBoolean230)
                        Draw3D.method352(l4, i5, j5, i4, j4, k4, class15.anIntArray223[j2], class15.anIntArray224[j2], class15.anIntArray225[j2], TileOverlay.anIntArray237[0], TileOverlay.anIntArray237[1], TileOverlay.anIntArray237[3], TileOverlay.anIntArray238[0], TileOverlay.anIntArray238[1], TileOverlay.anIntArray238[3], TileOverlay.anIntArray239[0], TileOverlay.anIntArray239[1], TileOverlay.anIntArray239[3], class15.anIntArray229[j2]);
                    else
                        Draw3D.method352(l4, i5, j5, i4, j4, k4, class15.anIntArray223[j2], class15.anIntArray224[j2], class15.anIntArray225[j2], TileOverlay.anIntArray237[l2], TileOverlay.anIntArray237[j3], TileOverlay.anIntArray237[l3], TileOverlay.anIntArray238[l2], TileOverlay.anIntArray238[j3], TileOverlay.anIntArray238[l3], TileOverlay.anIntArray239[l2], TileOverlay.anIntArray239[j3], TileOverlay.anIntArray239[l3], class15.anIntArray229[j2]);
                } else {
                    int k5 = anIntArray431[class15.anIntArray229[j2]];
                    Draw3D.method348(l4, i5, j5, i4, j4, k4, method279(k5, class15.anIntArray223[j2], 9), method279(k5, class15.anIntArray224[j2], 9), method279(k5, class15.anIntArray225[j2], 9));
                }
            }
        }

    }

    public int method279(int i, int j, int k) {
        j = 127 - j;
        j = (j * (i & 0x7f)) / 160;
        if (k < 9 || k > 9) {
            for (int l = 1; l > 0; l++) ;
        }
        if (j < 2)
            j = 2;
        else if (j > 126)
            j = 126;
        return (i & 0xff80) + j;
    }

    public boolean method280(int i, int j, int k, int l, int i1, int j1, int k1,
                             int l1) {
        if (j < k && j < l && j < i1)
            return false;
        if (j > k && j > l && j > i1)
            return false;
        if (i < j1 && i < k1 && i < l1)
            return false;
        if (i > j1 && i > k1 && i > l1)
            return false;
        int i2 = (j - k) * (k1 - j1) - (i - j1) * (l - k);
        int j2 = (j - i1) * (j1 - l1) - (i - l1) * (k - i1);
        int k2 = (j - l) * (l1 - k1) - (i - k1) * (i1 - l);
        return i2 * k2 > 0 && k2 * j2 > 0;
    }

    public void method281(boolean flag) {
        int i = anIntArray419[anInt393];
        Occluder[] aclass21 = aOccluderArrayArray420[anInt393];
        if (!flag)
            return;
        anInt421 = 0;
        for (int j = 0; j < i; j++) {
            Occluder class21 = aclass21[j];
            if (class21.anInt309 == 1) {
                int k = (class21.anInt305 - anInt399) + 25;
                if (k < 0 || k > 50)
                    continue;
                int j1 = (class21.anInt307 - anInt400) + 25;
                if (j1 < 0)
                    j1 = 0;
                int i2 = (class21.anInt308 - anInt400) + 25;
                if (i2 > 50)
                    i2 = 50;
                boolean flag1 = false;
                while (j1 <= i2)
                    if (aBooleanArrayArray438[k][j1++]) {
                        flag1 = true;
                        break;
                    }
                if (!flag1)
                    continue;
                int i3 = anInt401 - class21.anInt310;
                if (i3 > 32) {
                    class21.anInt316 = 1;
                } else {
                    if (i3 >= -32)
                        continue;
                    class21.anInt316 = 2;
                    i3 = -i3;
                }
                class21.anInt319 = (class21.anInt312 - anInt403 << 8) / i3;
                class21.anInt320 = (class21.anInt313 - anInt403 << 8) / i3;
                class21.anInt321 = (class21.anInt314 - anInt402 << 8) / i3;
                class21.anInt322 = (class21.anInt315 - anInt402 << 8) / i3;
                aOccluderArray422[anInt421++] = class21;
                continue;
            }
            if (class21.anInt309 == 2) {
                int l = (class21.anInt307 - anInt400) + 25;
                if (l < 0 || l > 50)
                    continue;
                int k1 = (class21.anInt305 - anInt399) + 25;
                if (k1 < 0)
                    k1 = 0;
                int j2 = (class21.anInt306 - anInt399) + 25;
                if (j2 > 50)
                    j2 = 50;
                boolean flag2 = false;
                while (k1 <= j2)
                    if (aBooleanArrayArray438[k1++][l]) {
                        flag2 = true;
                        break;
                    }
                if (!flag2)
                    continue;
                int j3 = anInt403 - class21.anInt312;
                if (j3 > 32) {
                    class21.anInt316 = 3;
                } else {
                    if (j3 >= -32)
                        continue;
                    class21.anInt316 = 4;
                    j3 = -j3;
                }
                class21.anInt317 = (class21.anInt310 - anInt401 << 8) / j3;
                class21.anInt318 = (class21.anInt311 - anInt401 << 8) / j3;
                class21.anInt321 = (class21.anInt314 - anInt402 << 8) / j3;
                class21.anInt322 = (class21.anInt315 - anInt402 << 8) / j3;
                aOccluderArray422[anInt421++] = class21;
            } else if (class21.anInt309 == 4) {
                int i1 = class21.anInt314 - anInt402;
                if (i1 > 128) {
                    int l1 = (class21.anInt307 - anInt400) + 25;
                    if (l1 < 0)
                        l1 = 0;
                    int k2 = (class21.anInt308 - anInt400) + 25;
                    if (k2 > 50)
                        k2 = 50;
                    if (l1 <= k2) {
                        int l2 = (class21.anInt305 - anInt399) + 25;
                        if (l2 < 0)
                            l2 = 0;
                        int k3 = (class21.anInt306 - anInt399) + 25;
                        if (k3 > 50)
                            k3 = 50;
                        boolean flag3 = false;
                        label0:
                        for (int l3 = l2; l3 <= k3; l3++) {
                            for (int i4 = l1; i4 <= k2; i4++) {
                                if (!aBooleanArrayArray438[l3][i4])
                                    continue;
                                flag3 = true;
                                break label0;
                            }

                        }

                        if (flag3) {
                            class21.anInt316 = 5;
                            class21.anInt317 = (class21.anInt310 - anInt401 << 8) / i1;
                            class21.anInt318 = (class21.anInt311 - anInt401 << 8) / i1;
                            class21.anInt319 = (class21.anInt312 - anInt403 << 8) / i1;
                            class21.anInt320 = (class21.anInt313 - anInt403 << 8) / i1;
                            aOccluderArray422[anInt421++] = class21;
                        }
                    }
                }
            }
        }

    }

    public boolean method282(int i, int j, int k) {
        int l = anIntArrayArrayArray391[i][j][k];
        if (l == -anInt394)
            return false;
        if (l == anInt394)
            return true;
        int i1 = j << 7;
        int j1 = k << 7;
        if (method286(i1 + 1, anIntArrayArrayArray386[i][j][k], j1 + 1) && method286((i1 + 128) - 1, anIntArrayArrayArray386[i][j + 1][k], j1 + 1) && method286((i1 + 128) - 1, anIntArrayArrayArray386[i][j + 1][k + 1], (j1 + 128) - 1) && method286(i1 + 1, anIntArrayArrayArray386[i][j][k + 1], (j1 + 128) - 1)) {
            anIntArrayArrayArray391[i][j][k] = anInt394;
            return true;
        } else {
            anIntArrayArrayArray391[i][j][k] = -anInt394;
            return false;
        }
    }

    public boolean method283(int i, int j, int k, int l) {
        if (!method282(i, j, k))
            return false;
        int i1 = j << 7;
        int j1 = k << 7;
        int k1 = anIntArrayArrayArray386[i][j][k] - 1;
        int l1 = k1 - 120;
        int i2 = k1 - 230;
        int j2 = k1 - 238;
        if (l < 16) {
            if (l == 1) {
                if (i1 > anInt401) {
                    if (!method286(i1, k1, j1))
                        return false;
                    if (!method286(i1, k1, j1 + 128))
                        return false;
                }
                if (i > 0) {
                    if (!method286(i1, l1, j1))
                        return false;
                    if (!method286(i1, l1, j1 + 128))
                        return false;
                }
                if (!method286(i1, i2, j1))
                    return false;
                return method286(i1, i2, j1 + 128);
            }
            if (l == 2) {
                if (j1 < anInt403) {
                    if (!method286(i1, k1, j1 + 128))
                        return false;
                    if (!method286(i1 + 128, k1, j1 + 128))
                        return false;
                }
                if (i > 0) {
                    if (!method286(i1, l1, j1 + 128))
                        return false;
                    if (!method286(i1 + 128, l1, j1 + 128))
                        return false;
                }
                if (!method286(i1, i2, j1 + 128))
                    return false;
                return method286(i1 + 128, i2, j1 + 128);
            }
            if (l == 4) {
                if (i1 < anInt401) {
                    if (!method286(i1 + 128, k1, j1))
                        return false;
                    if (!method286(i1 + 128, k1, j1 + 128))
                        return false;
                }
                if (i > 0) {
                    if (!method286(i1 + 128, l1, j1))
                        return false;
                    if (!method286(i1 + 128, l1, j1 + 128))
                        return false;
                }
                if (!method286(i1 + 128, i2, j1))
                    return false;
                return method286(i1 + 128, i2, j1 + 128);
            }
            if (l == 8) {
                if (j1 > anInt403) {
                    if (!method286(i1, k1, j1))
                        return false;
                    if (!method286(i1 + 128, k1, j1))
                        return false;
                }
                if (i > 0) {
                    if (!method286(i1, l1, j1))
                        return false;
                    if (!method286(i1 + 128, l1, j1))
                        return false;
                }
                if (!method286(i1, i2, j1))
                    return false;
                return method286(i1 + 128, i2, j1);
            }
        }
        if (!method286(i1 + 64, j2, j1 + 64))
            return false;
        if (l == 16)
            return method286(i1, i2, j1 + 128);
        if (l == 32)
            return method286(i1 + 128, i2, j1 + 128);
        if (l == 64)
            return method286(i1 + 128, i2, j1);
        if (l == 128) {
            return method286(i1, i2, j1);
        } else {
            System.out.println("Warning unsupported wall type");
            return true;
        }
    }

    public boolean method284(int i, int j, int k, int l) {
        if (!method282(i, j, k))
            return false;
        int i1 = j << 7;
        int j1 = k << 7;
        return method286(i1 + 1, anIntArrayArrayArray386[i][j][k] - l, j1 + 1) && method286((i1 + 128) - 1, anIntArrayArrayArray386[i][j + 1][k] - l, j1 + 1) && method286((i1 + 128) - 1, anIntArrayArrayArray386[i][j + 1][k + 1] - l, (j1 + 128) - 1) && method286(i1 + 1, anIntArrayArrayArray386[i][j][k + 1] - l, (j1 + 128) - 1);
    }

    public boolean method285(int i, int j, int k, int l, int i1, int j1) {
        if (j == k && l == i1) {
            if (!method282(i, j, l))
                return false;
            int k1 = j << 7;
            int i2 = l << 7;
            return method286(k1 + 1, anIntArrayArrayArray386[i][j][l] - j1, i2 + 1) && method286((k1 + 128) - 1, anIntArrayArrayArray386[i][j + 1][l] - j1, i2 + 1) && method286((k1 + 128) - 1, anIntArrayArrayArray386[i][j + 1][l + 1] - j1, (i2 + 128) - 1) && method286(k1 + 1, anIntArrayArrayArray386[i][j][l + 1] - j1, (i2 + 128) - 1);
        }
        for (int l1 = j; l1 <= k; l1++) {
            for (int j2 = l; j2 <= i1; j2++)
                if (anIntArrayArrayArray391[i][l1][j2] == -anInt394)
                    return false;

        }

        int k2 = (j << 7) + 1;
        int l2 = (l << 7) + 2;
        int i3 = anIntArrayArrayArray386[i][j][l] - j1;
        if (!method286(k2, i3, l2))
            return false;
        int j3 = (k << 7) - 1;
        if (!method286(j3, i3, l2))
            return false;
        int k3 = (i1 << 7) - 1;
        if (!method286(k2, i3, k3))
            return false;
        return method286(j3, i3, k3);
    }

    public boolean method286(int i, int j, int k) {
        for (int l = 0; l < anInt421; l++) {
            Occluder class21 = aOccluderArray422[l];
            if (class21.anInt316 == 1) {
                int i1 = class21.anInt310 - i;
                if (i1 > 0) {
                    int j2 = class21.anInt312 + (class21.anInt319 * i1 >> 8);
                    int k3 = class21.anInt313 + (class21.anInt320 * i1 >> 8);
                    int l4 = class21.anInt314 + (class21.anInt321 * i1 >> 8);
                    int i6 = class21.anInt315 + (class21.anInt322 * i1 >> 8);
                    if (k >= j2 && k <= k3 && j >= l4 && j <= i6)
                        return true;
                }
            } else if (class21.anInt316 == 2) {
                int j1 = i - class21.anInt310;
                if (j1 > 0) {
                    int k2 = class21.anInt312 + (class21.anInt319 * j1 >> 8);
                    int l3 = class21.anInt313 + (class21.anInt320 * j1 >> 8);
                    int i5 = class21.anInt314 + (class21.anInt321 * j1 >> 8);
                    int j6 = class21.anInt315 + (class21.anInt322 * j1 >> 8);
                    if (k >= k2 && k <= l3 && j >= i5 && j <= j6)
                        return true;
                }
            } else if (class21.anInt316 == 3) {
                int k1 = class21.anInt312 - k;
                if (k1 > 0) {
                    int l2 = class21.anInt310 + (class21.anInt317 * k1 >> 8);
                    int i4 = class21.anInt311 + (class21.anInt318 * k1 >> 8);
                    int j5 = class21.anInt314 + (class21.anInt321 * k1 >> 8);
                    int k6 = class21.anInt315 + (class21.anInt322 * k1 >> 8);
                    if (i >= l2 && i <= i4 && j >= j5 && j <= k6)
                        return true;
                }
            } else if (class21.anInt316 == 4) {
                int l1 = k - class21.anInt312;
                if (l1 > 0) {
                    int i3 = class21.anInt310 + (class21.anInt317 * l1 >> 8);
                    int j4 = class21.anInt311 + (class21.anInt318 * l1 >> 8);
                    int k5 = class21.anInt314 + (class21.anInt321 * l1 >> 8);
                    int l6 = class21.anInt315 + (class21.anInt322 * l1 >> 8);
                    if (i >= i3 && i <= j4 && j >= k5 && j <= l6)
                        return true;
                }
            } else if (class21.anInt316 == 5) {
                int i2 = j - class21.anInt314;
                if (i2 > 0) {
                    int j3 = class21.anInt310 + (class21.anInt317 * i2 >> 8);
                    int k4 = class21.anInt311 + (class21.anInt318 * i2 >> 8);
                    int l5 = class21.anInt312 + (class21.anInt319 * i2 >> 8);
                    int i7 = class21.anInt313 + (class21.anInt320 * i2 >> 8);
                    if (i >= j3 && i <= k4 && k >= l5 && k <= i7)
                        return true;
                }
            }
        }

        return false;
    }

    public boolean aBoolean374;
    public static boolean aBoolean375 = true;
    public static int anInt376;
    public int anInt377;
    public boolean aBoolean378;
    public int anInt379;
    public int anInt380;
    public int anInt381;
    public static boolean aBoolean382 = true;
    public int anInt383;
    public int anInt384;
    public int anInt385;
    public int[][][] anIntArrayArrayArray386;
    public Tile[][][] levelTiles;
    public int anInt388;
    public int anInt389;
    public Loc[] aTile7Array390;
    public int[][][] anIntArrayArrayArray391;
    public static int anInt392;
    public static int anInt393;
    public static int anInt394;
    public static int anInt395;
    public static int anInt396;
    public static int anInt397;
    public static int anInt398;
    public static int anInt399;
    public static int anInt400;
    public static int anInt401;
    public static int anInt402;
    public static int anInt403;
    public static int anInt404;
    public static int anInt405;
    public static int anInt406;
    public static int anInt407;
    public static Loc[] aTile7Array408 = new Loc[100];
    public static final int[] anIntArray409 = {
            53, -53, -53, 53
    };
    public static final int[] anIntArray410 = {
            -53, -53, 53, 53
    };
    public static final int[] anIntArray411 = {
            -45, 45, 45, -45
    };
    public static final int[] anIntArray412 = {
            45, 45, -45, -45
    };
    public static boolean aBoolean413;
    public static int anInt414;
    public static int anInt415;
    public static int anInt416 = -1;
    public static int anInt417 = -1;
    public static int anInt418;
    public static int[] anIntArray419;
    public static Occluder[][] aOccluderArrayArray420;
    public static int anInt421;
    public static Occluder[] aOccluderArray422 = new Occluder[500];
    public static LinkedList aLinkedList_423 = new LinkedList();
    public static final int[] anIntArray424 = {
            19, 55, 38, 155, 255, 110, 137, 205, 76
    };
    public static final int[] anIntArray425 = {
            160, 192, 80, 96, 0, 144, 80, 48, 160
    };
    public static final int[] anIntArray426 = {
            76, 8, 137, 4, 0, 1, 38, 2, 19
    };
    public static final int[] anIntArray427 = {
            0, 0, 2, 0, 0, 2, 1, 1, 0
    };
    public static final int[] anIntArray428 = {
            2, 0, 0, 2, 0, 0, 0, 4, 4
    };
    public static final int[] anIntArray429 = {
            0, 4, 4, 8, 0, 0, 8, 0, 0
    };
    public static final int[] anIntArray430 = {
            1, 1, 0, 0, 0, 8, 0, 0, 8
    };
    public static final int[] anIntArray431 = {
            41, 39248, 41, 4643, 41, 41, 41, 41, 41, 41,
            41, 41, 41, 41, 41, 43086, 41, 41, 41, 41,
            41, 41, 41, 8602, 41, 28992, 41, 41, 41, 41,
            41, 5056, 41, 41, 41, 41, 41, 41, 41, 41,
            41, 41, 41, 41, 41, 41, 3131, 41, 41, 41
    };
    public int[] anIntArray432;
    public int[] anIntArray433;
    public int anInt434;
    public int[][] anIntArrayArray435 = {
            new int[16], {
            1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
            1, 1, 1, 1, 1, 1
    }, {
            1, 0, 0, 0, 1, 1, 0, 0, 1, 1,
            1, 0, 1, 1, 1, 1
    }, {
            1, 1, 0, 0, 1, 1, 0, 0, 1, 0,
            0, 0, 1, 0, 0, 0
    }, {
            0, 0, 1, 1, 0, 0, 1, 1, 0, 0,
            0, 1, 0, 0, 0, 1
    }, {
            0, 1, 1, 1, 0, 1, 1, 1, 1, 1,
            1, 1, 1, 1, 1, 1
    }, {
            1, 1, 1, 0, 1, 1, 1, 0, 1, 1,
            1, 1, 1, 1, 1, 1
    }, {
            1, 1, 0, 0, 1, 1, 0, 0, 1, 1,
            0, 0, 1, 1, 0, 0
    }, {
            0, 0, 0, 0, 0, 0, 0, 0, 1, 0,
            0, 0, 1, 1, 0, 0
    }, {
            1, 1, 1, 1, 1, 1, 1, 1, 0, 1,
            1, 1, 0, 0, 1, 1
    },
            {
                    1, 1, 1, 1, 1, 1, 0, 0, 1, 0,
                    0, 0, 1, 0, 0, 0
            }, {
            0, 0, 0, 0, 0, 0, 1, 1, 0, 1,
            1, 1, 0, 1, 1, 1
    }, {
            0, 0, 0, 0, 0, 0, 0, 0, 0, 1,
            1, 0, 1, 1, 1, 1
    }
    };
    public int[][] anIntArrayArray436 = {
            {
                    0, 1, 2, 3, 4, 5, 6, 7, 8, 9,
                    10, 11, 12, 13, 14, 15
            }, {
            12, 8, 4, 0, 13, 9, 5, 1, 14, 10,
            6, 2, 15, 11, 7, 3
    }, {
            15, 14, 13, 12, 11, 10, 9, 8, 7, 6,
            5, 4, 3, 2, 1, 0
    }, {
            3, 7, 11, 15, 2, 6, 10, 14, 1, 5,
            9, 13, 0, 4, 8, 12
    }
    };
    public static boolean[][][][] aBooleanArrayArrayArrayArray437 = new boolean[8][32][51][51];
    public static boolean[][] aBooleanArrayArray438;
    public static int anInt439;
    public static int anInt440;
    public static int anInt441;
    public static int anInt442;
    public static int anInt443;
    public static int anInt444;

    static {
        anInt418 = 4;
        anIntArray419 = new int[anInt418];
        aOccluderArrayArray420 = new Occluder[anInt418][500];
    }
}
