package com.jagex.game.runetek3.scenegraph;

// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

import com.jagex.core.utils.Node;
import com.jagex.game.runetek3.entity.ObjEntity;

public class Tile extends Node {

    public Tile(int i, int j, int k) {
        aTile7Array1005 = new Loc[5];
        anIntArray1006 = new int[5];
        anInt997 = anInt994 = i;
        anInt995 = j;
        anInt996 = k;
    }

    public int anInt994;
    public int anInt995;
    public int anInt996;
    public int anInt997;
    public TileUnderlay underlay;
    public TileOverlay overlay;
    public Wall wall;
    public WallDecoration aTile4_1001;
    public GroundDecoration aTile5_1002;
    public ObjEntity aTile6_1003;
    public int anInt1004;
    public Loc[] aTile7Array1005;
    public int[] anIntArray1006;
    public int anInt1007;
    public int anInt1008;
    public boolean aBoolean1009;
    public boolean aBoolean1010;
    public boolean aBoolean1011;
    public int anInt1012;
    public int anInt1013;
    public int anInt1014;
    public int anInt1015;
    public Tile aClass35_Sub1_1016;
}
