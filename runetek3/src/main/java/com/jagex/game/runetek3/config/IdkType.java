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

    public static void decode(FileArchive archive) {
        Buffer buffer = new Buffer(archive.read(null, "idk.dat"));
        count = buffer.g2();
        if (instances == null) {
            instances = new IdkType[count];
        }
        for (int i = 0; i < count; i++) {
            if (instances[i] == null) {
                instances[i] = new IdkType();
            }
            instances[i].decode(buffer);
        }
    }

    public void decode(Buffer buffer) {
        do {
            int opcode = buffer.g1();
            if (opcode == 0) {
                return;
            }
            if (opcode == 1) {
                type = buffer.g1();
            } else if (opcode == 2) {
                int l = buffer.g1();
                models = new int[l];
                for (int i = 0; i < l; i++) {
                    models[i] = buffer.g2();
                }

            } else if (opcode >= 40 && opcode < 50) {
                recol_s[opcode - 40] = buffer.g2();
            } else if (opcode >= 50 && opcode < 60) {
                recol_d[opcode - 50] = buffer.g2();
            } else if (opcode >= 60 && opcode < 70) {
                headModels[opcode - 60] = buffer.g2();
            } else {
                System.out.println("Error unrecognised config code: " + opcode);
            }
        } while (true);
    }

    public Model method157() {
        if (models == null)
            return null;
        Model[] aclass35_sub2_sub1 = new Model[models.length];
        for (int i = 0; i < models.length; i++)
            aclass35_sub2_sub1[i] = new Model(models[i]);

        Model class35_sub2_sub1;
        if (aclass35_sub2_sub1.length == 1)
            class35_sub2_sub1 = aclass35_sub2_sub1[0];
        else
            class35_sub2_sub1 = new Model(false, aclass35_sub2_sub1.length, aclass35_sub2_sub1);
        for (int j = 0; j < 6; j++) {
            if (recol_s[j] == 0)
                break;
            class35_sub2_sub1.recolor(recol_s[j], recol_d[j]);
        }

        return class35_sub2_sub1;
    }

    public Model method158(int i) {
        if (i != 0)
            throw new NullPointerException();
        Model[] aclass35_sub2_sub1 = new Model[5];
        int j = 0;
        for (int k = 0; k < 5; k++)
            if (headModels[k] != -1)
                aclass35_sub2_sub1[j++] = new Model(headModels[k]);

        Model class35_sub2_sub1 = new Model(false, j, aclass35_sub2_sub1);
        for (int l = 0; l < 6; l++) {
            if (recol_s[l] == 0)
                break;
            class35_sub2_sub1.recolor(recol_s[l], recol_d[l]);
        }

        return class35_sub2_sub1;
    }

    public IdkType() {
        type = -1;
        recol_s = new int[6];
        recol_d = new int[6];
    }

    public static int count;
    public static IdkType[] instances;
    public int type;
    public int[] models;
    public int[] recol_s;
    public int[] recol_d;
    public int[] headModels = {
            -1, -1, -1, -1, -1
    };
}
