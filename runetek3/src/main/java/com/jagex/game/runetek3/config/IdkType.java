package com.jagex.game.runetek3.config;

// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

import com.jagex.core.io.Buffer;
import com.jagex.core.io.FileArchive;
import com.jagex.game.runetek3.graphics.model.Model;

public class IdkType {

    public static int findPart(int type, int index) {
        int part = 0;
        for (int i = 0; i < count; ++i) {
            if (instances[i].type == type) {
                if (index == part) {
                    return i;
                }
                part++;
            }
        }
        return -1;
    }

    public static void decode(FileArchive class36) {
        Buffer class35_sub2_sub3 = new Buffer(class36.method417((byte) 6, null, "idk.dat"));
        count = class35_sub2_sub3.g2();
        if (instances == null)
            instances = new IdkType[count];
        for (int i = 0; i < count; i++) {
            if (instances[i] == null)
                instances[i] = new IdkType();
            instances[i].method156(213, class35_sub2_sub3);
        }
    }

    public void method156(int i, Buffer class35_sub2_sub3) {
        if (i <= 0) {
            for (int j = 1; j > 0; j++) ;
        }
        do {
            int k = class35_sub2_sub3.g1();
            if (k == 0)
                return;
            if (k == 1)
                type = class35_sub2_sub3.g1();
            else if (k == 2) {
                int l = class35_sub2_sub3.g1();
                anIntArray96 = new int[l];
                for (int i1 = 0; i1 < l; i1++)
                    anIntArray96[i1] = class35_sub2_sub3.g2();

            } else if (k >= 40 && k < 50)
                anIntArray97[k - 40] = class35_sub2_sub3.g2();
            else if (k >= 50 && k < 60)
                anIntArray98[k - 50] = class35_sub2_sub3.g2();
            else if (k >= 60 && k < 70)
                anIntArray99[k - 60] = class35_sub2_sub3.g2();
            else
                System.out.println("Error unrecognised config code: " + k);
        } while (true);
    }

    public Model method157() {
        if (anIntArray96 == null)
            return null;
        Model[] aclass35_sub2_sub1 = new Model[anIntArray96.length];
        for (int i = 0; i < anIntArray96.length; i++)
            aclass35_sub2_sub1[i] = new Model(anIntArray96[i], 298);

        Model class35_sub2_sub1;
        if (aclass35_sub2_sub1.length == 1)
            class35_sub2_sub1 = aclass35_sub2_sub1[0];
        else
            class35_sub2_sub1 = new Model(false, aclass35_sub2_sub1.length, aclass35_sub2_sub1);
        for (int j = 0; j < 6; j++) {
            if (anIntArray97[j] == 0)
                break;
            class35_sub2_sub1.method317(anIntArray97[j], anIntArray98[j]);
        }

        return class35_sub2_sub1;
    }

    public Model method158(int i) {
        if (i != 0)
            throw new NullPointerException();
        Model[] aclass35_sub2_sub1 = new Model[5];
        int j = 0;
        for (int k = 0; k < 5; k++)
            if (anIntArray99[k] != -1)
                aclass35_sub2_sub1[j++] = new Model(anIntArray99[k], 298);

        Model class35_sub2_sub1 = new Model(false, j, aclass35_sub2_sub1);
        for (int l = 0; l < 6; l++) {
            if (anIntArray97[l] == 0)
                break;
            class35_sub2_sub1.method317(anIntArray97[l], anIntArray98[l]);
        }

        return class35_sub2_sub1;
    }

    public IdkType() {
        type = -1;
        anIntArray97 = new int[6];
        anIntArray98 = new int[6];
    }

    public static int count;
    public static IdkType[] instances;
    public int type;
    public int[] anIntArray96;
    public int[] anIntArray97;
    public int[] anIntArray98;
    public int[] anIntArray99 = {
            -1, -1, -1, -1, -1
    };
}
