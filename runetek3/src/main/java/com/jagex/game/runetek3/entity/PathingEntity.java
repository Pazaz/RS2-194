package com.jagex.game.runetek3.entity;

// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

import com.jagex.game.runetek3.config.SeqType;

public class PathingEntity extends Entity {

    public void method409(byte byte0, int i, int j) {
        if (primarySeq != -1 && SeqType.instances[primarySeq].anInt198 <= 1) {
            primarySeq = -1;
        }
        int k = i - pathTileX[0];
        int l = j - pathTileZ[0];
        if (k >= -2 && k <= 2 && l >= -2 && l <= 2) {
            if (pathRemaining < 9)
                pathRemaining++;
            for (int i1 = pathRemaining; i1 > 0; i1--) {
                pathTileX[i1] = pathTileX[i1 - 1];
                pathTileZ[i1] = pathTileZ[i1 - 1];
                aBooleanArray1258[i1] = aBooleanArray1258[i1 - 1];
            }

            pathTileX[0] = i;
            pathTileZ[0] = j;
            aBooleanArray1258[0] = false;
            return;
        }
        pathRemaining = 0;
        anInt1259 = 0;
        pathTileX[0] = i;
        pathTileZ[0] = j;
        x = pathTileX[0] * 128 + index * 64;
        if (byte0 == 28) {
            z = pathTileZ[0] * 128 + index * 64;
        }
        return;
    }

    public void method410(boolean flag, int i, int j) {
        int k = pathTileX[0];
        int l = pathTileZ[0];
        if (i == 0) {
            k--;
            l++;
        }
        if (i == 1)
            l++;
        if (i == 2) {
            k++;
            l++;
        }
        if (i == 3)
            k--;
        if (i == 4)
            k++;
        if (i == 5) {
            k--;
            l--;
        }
        if (i == 6)
            l--;
        if (i == 7) {
            k++;
            l--;
        }
        if (primarySeq != -1 && SeqType.instances[primarySeq].anInt198 <= 1)
            primarySeq = -1;
        if (pathRemaining < 9)
            pathRemaining++;
        for (int i1 = pathRemaining; i1 > 0; i1--) {
            pathTileX[i1] = pathTileX[i1 - 1];
            pathTileZ[i1] = pathTileZ[i1 - 1];
            aBooleanArray1258[i1] = aBooleanArray1258[i1 - 1];
        }

        pathTileX[0] = k;
        pathTileZ[0] = l;
        aBooleanArray1258[0] = flag;
        j = 3 / j;
    }

    public boolean method411(int i) {
        if (i != 0)
            anInt1207 = 254;
        return false;
    }

    public PathingEntity() {
        anInt1207 = 49498;
        index = 1;
        standSeq = -1;
        anInt1214 = -1;
        anInt1215 = -1;
        anInt1216 = -1;
        anInt1217 = -1;
        anInt1218 = -1;
        anInt1219 = -1;
        anInt1221 = 100;
        anInt1226 = -1000;
        anInt1229 = -1;
        secondarySeq = -1;
        primarySeq = -1;
        spotAnimIndex = -1;
        pathTileX = new int[10];
        pathTileZ = new int[10];
        aBooleanArray1258 = new boolean[10];
    }

    public int anInt1207;
    public int x;
    public int z;
    public int anInt1210;
    public int anInt1211;
    public int index;
    public int standSeq;
    public int anInt1214;
    public int anInt1215;
    public int anInt1216;
    public int anInt1217;
    public int anInt1218;
    public int anInt1219;
    public String aString1220;
    public int anInt1221;
    public int anInt1222;
    public int anInt1223;
    public int anInt1224;
    public int anInt1225;
    public int anInt1226;
    public int anInt1227;
    public int anInt1228;
    public int anInt1229;
    public int anInt1230;
    public int anInt1231;
    public int secondarySeq;
    public int secondarySeqFrame;
    public int anInt1234;
    public int primarySeq;
    public int primarySeqFrame;
    public int anInt1237;
    public int primarySeqDelay;
    public int anInt1239;
    public int spotAnimIndex;
    public int spotAnimFrame;
    public int anInt1242;
    public int anInt1243;
    public int spotAnimOffsetY;
    public int anInt1245;
    public int anInt1246;
    public int anInt1247;
    public int anInt1248;
    public int anInt1249;
    public int anInt1250;
    public int anInt1251;
    public int anInt1252;
    public int height;
    public int anInt1254;
    public int pathRemaining;
    public int[] pathTileX;
    public int[] pathTileZ;
    public boolean[] aBooleanArray1258;
    public int anInt1259;
}
