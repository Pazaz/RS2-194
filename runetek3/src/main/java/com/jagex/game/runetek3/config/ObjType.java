package com.jagex.game.runetek3.config;

// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

import com.jagex.core.io.Buffer;
import com.jagex.core.io.FileArchive;
import com.jagex.core.utils.Cache;
import com.jagex.game.runetek3.graphics.Draw2D;
import com.jagex.game.runetek3.graphics.Draw3D;
import com.jagex.game.runetek3.graphics.Sprite;
import com.jagex.game.runetek3.graphics.model.Model;

public class ObjType {

    public static void decode(FileArchive class36) {
        aClass35_Sub2_Sub3_601 = new Buffer(class36.method417((byte) 6, null, "obj.dat"));
        Buffer class35_sub2_sub3 = new Buffer(class36.method417((byte) 6, null, "obj.idx"));
        anInt599 = class35_sub2_sub3.g2();
        anIntArray600 = new int[anInt599];
        int i = 2;
        for (int j = 0; j < anInt599; j++) {
            anIntArray600[j] = i;
            i += class35_sub2_sub3.g2();
        }

        aObjTypeArray602 = new ObjType[10];
        for (int k = 0; k < 10; k++)
            aObjTypeArray602[k] = new ObjType();

    }

    public static void method439(int i) {
        aCache_633 = null;
        if (i <= 0)
            anInt598 = 224;
        aCache_634 = null;
        anIntArray600 = null;
        aObjTypeArray602 = null;
        aClass35_Sub2_Sub3_601 = null;
    }

    public static ObjType method440(int i) {
        for (int j = 0; j < 10; j++)
            if (aObjTypeArray602[j].anInt604 == i)
                return aObjTypeArray602[j];

        anInt603 = (anInt603 + 1) % 10;
        ObjType class41 = aObjTypeArray602[anInt603];
        aClass35_Sub2_Sub3_601.pos = anIntArray600[i];
        class41.anInt604 = i;
        class41.method441();
        class41.method442(213, aClass35_Sub2_Sub3_601);
        return class41;
    }

    public void method441() {
        anInt605 = 0;
        aString606 = null;
        aByteArray607 = null;
        anIntArray608 = null;
        anIntArray609 = null;
        anInt610 = 2000;
        anInt611 = 0;
        anInt612 = 0;
        anInt613 = 0;
        anInt614 = 0;
        anInt615 = 0;
        aBoolean616 = false;
        anInt617 = -1;
        aBoolean618 = false;
        anInt619 = 1;
        aBoolean620 = false;
        aStringArray621 = null;
        aStringArray622 = null;
        anInt623 = -1;
        anInt624 = -1;
        aByte625 = 0;
        anInt626 = -1;
        anInt627 = -1;
        aByte628 = 0;
        anInt629 = -1;
        anInt630 = -1;
        anInt631 = -1;
        anInt632 = -1;
    }

    public void method442(int i, Buffer class35_sub2_sub3) {
        if (i <= 0)
            throw new NullPointerException();
        do {
            int j = class35_sub2_sub3.g1();
            if (j == 0)
                return;
            if (j == 1)
                anInt605 = class35_sub2_sub3.g2();
            else if (j == 2)
                aString606 = class35_sub2_sub3.gstr();
            else if (j == 3)
                aByteArray607 = class35_sub2_sub3.gstrbyte();
            else if (j == 4)
                anInt610 = class35_sub2_sub3.g2();
            else if (j == 5)
                anInt611 = class35_sub2_sub3.g2();
            else if (j == 6)
                anInt612 = class35_sub2_sub3.g2();
            else if (j == 7) {
                anInt614 = class35_sub2_sub3.g2();
                if (anInt614 > 32767)
                    anInt614 -= 0x10000;
            } else if (j == 8) {
                anInt615 = class35_sub2_sub3.g2();
                if (anInt615 > 32767)
                    anInt615 -= 0x10000;
            } else if (j == 9)
                aBoolean616 = true;
            else if (j == 10)
                anInt617 = class35_sub2_sub3.g2();
            else if (j == 11)
                aBoolean618 = true;
            else if (j == 12)
                anInt619 = class35_sub2_sub3.g4();
            else if (j == 16)
                aBoolean620 = true;
            else if (j == 23) {
                anInt623 = class35_sub2_sub3.g2();
                aByte625 = class35_sub2_sub3.g1b();
            } else if (j == 24)
                anInt624 = class35_sub2_sub3.g2();
            else if (j == 25) {
                anInt626 = class35_sub2_sub3.g2();
                aByte628 = class35_sub2_sub3.g1b();
            } else if (j == 26)
                anInt627 = class35_sub2_sub3.g2();
            else if (j >= 30 && j < 35) {
                if (aStringArray621 == null)
                    aStringArray621 = new String[5];
                aStringArray621[j - 30] = class35_sub2_sub3.gstr();
            } else if (j >= 35 && j < 40) {
                if (aStringArray622 == null)
                    aStringArray622 = new String[5];
                aStringArray622[j - 35] = class35_sub2_sub3.gstr();
            } else if (j == 40) {
                int k = class35_sub2_sub3.g1();
                anIntArray608 = new int[k];
                anIntArray609 = new int[k];
                for (int l = 0; l < k; l++) {
                    anIntArray608[l] = class35_sub2_sub3.g2();
                    anIntArray609[l] = class35_sub2_sub3.g2();
                }

            } else if (j == 90)
                anInt629 = class35_sub2_sub3.g2();
            else if (j == 91)
                anInt631 = class35_sub2_sub3.g2();
            else if (j == 92)
                anInt630 = class35_sub2_sub3.g2();
            else if (j == 93)
                anInt632 = class35_sub2_sub3.g2();
            else if (j == 95)
                anInt613 = class35_sub2_sub3.g2();
        } while (true);
    }

    public Model method443() {
        Model class35_sub2_sub1 = (Model) aCache_633.method295(anInt604);
        if (class35_sub2_sub1 != null)
            return class35_sub2_sub1;
        class35_sub2_sub1 = new Model(anInt605, 298);
        if (anIntArray608 != null) {
            for (int i = 0; i < anIntArray608.length; i++)
                class35_sub2_sub1.method317(anIntArray608[i], anIntArray609[i]);

        }
        class35_sub2_sub1.method320(64, 768, -50, -10, -50, true);
        class35_sub2_sub1.aBoolean1085 = true;
        aCache_633.method296(anInt604, 7, class35_sub2_sub1);
        return class35_sub2_sub1;
    }

    public static Sprite method444(int i, byte byte0) {
        Sprite class35_sub2_sub2_sub2 = (Sprite) aCache_634.method295(i);
        if (class35_sub2_sub2_sub2 != null)
            return class35_sub2_sub2_sub2;
        ObjType class41 = method440(i);
        class35_sub2_sub2_sub2 = new Sprite(32, 32);
        int j = Draw3D.anInt1267;
        int k = Draw3D.anInt1268;
        int[] ai = Draw3D.anIntArray1273;
        int[] ai1 = Draw2D.anIntArray1137;
        int l = Draw2D.anInt1138;
        int i1 = Draw2D.anInt1139;
        Draw3D.aBoolean1265 = false;
        Draw2D.method329(32, class35_sub2_sub2_sub2.anIntArray1292, 32, -810);
        Draw2D.method333(0, anInt598, 32, 0, 32, 0);
        Draw3D.method338((byte) 16);
        Model class35_sub2_sub1 = class41.method443();
        int j1 = Draw3D.anIntArray1271[class41.anInt611] * class41.anInt610 >> 16;
        int k1 = Draw3D.anIntArray1272[class41.anInt611] * class41.anInt610 >> 16;
        class35_sub2_sub1.method323(0, class41.anInt612, class41.anInt613, class41.anInt611, class41.anInt614, j1 + class35_sub2_sub1.anInt1076 / 2 + class41.anInt615, k1 + class41.anInt615);
        for (int j2 = 31; j2 >= 0; j2--) {
            for (int l1 = 31; l1 >= 0; l1--)
                if (class35_sub2_sub2_sub2.anIntArray1292[j2 + l1 * 32] == 0)
                    if (j2 > 0 && class35_sub2_sub2_sub2.anIntArray1292[(j2 - 1) + l1 * 32] > 1)
                        class35_sub2_sub2_sub2.anIntArray1292[j2 + l1 * 32] = 1;
                    else if (l1 > 0 && class35_sub2_sub2_sub2.anIntArray1292[j2 + (l1 - 1) * 32] > 1)
                        class35_sub2_sub2_sub2.anIntArray1292[j2 + l1 * 32] = 1;
                    else if (j2 < 31 && class35_sub2_sub2_sub2.anIntArray1292[j2 + 1 + l1 * 32] > 1)
                        class35_sub2_sub2_sub2.anIntArray1292[j2 + l1 * 32] = 1;
                    else if (l1 < 31 && class35_sub2_sub2_sub2.anIntArray1292[j2 + (l1 + 1) * 32] > 1)
                        class35_sub2_sub2_sub2.anIntArray1292[j2 + l1 * 32] = 1;

        }

        for (int k2 = 31; k2 >= 0; k2--) {
            for (int i2 = 31; i2 >= 0; i2--)
                if (class35_sub2_sub2_sub2.anIntArray1292[k2 + i2 * 32] == 0 && k2 > 0 && i2 > 0 && class35_sub2_sub2_sub2.anIntArray1292[(k2 - 1) + (i2 - 1) * 32] > 0)
                    class35_sub2_sub2_sub2.anIntArray1292[k2 + i2 * 32] = 0x302020;

        }

        aCache_634.method296(i, 7, class35_sub2_sub2_sub2);
        Draw2D.method329(l, ai1, i1, -810);
        Draw3D.anInt1267 = j;
        Draw3D.anInt1268 = k;
        Draw3D.anIntArray1273 = ai;
        if (byte0 != -11)
            throw new NullPointerException();
        Draw3D.aBoolean1265 = true;
        if (class41.aBoolean618)
            class35_sub2_sub2_sub2.anInt1297 = 33;
        else
            class35_sub2_sub2_sub2.anInt1297 = 32;
        return class35_sub2_sub2_sub2;
    }

    public Model method445(int i, int j) {
        int k = anInt623;
        if (j == 1)
            k = anInt626;
        if (k == -1)
            return null;
        int l = anInt624;
        i = 8 / i;
        if (j == 1)
            l = anInt627;
        Model class35_sub2_sub1 = new Model(k, 298);
        if (l != -1) {
            Model class35_sub2_sub1_1 = new Model(l, 298);
            Model[] aclass35_sub2_sub1 = {
                    class35_sub2_sub1, class35_sub2_sub1_1
            };
            class35_sub2_sub1 = new Model(false, 2, aclass35_sub2_sub1);
        }
        if (j == 0 && aByte625 != 0)
            class35_sub2_sub1.method316(0, 0, 0, aByte625);
        if (j == 1 && aByte628 != 0)
            class35_sub2_sub1.method316(0, 0, 0, aByte628);
        if (anIntArray608 != null) {
            for (int i1 = 0; i1 < anIntArray608.length; i1++)
                class35_sub2_sub1.method317(anIntArray608[i1], anIntArray609[i1]);

        }
        return class35_sub2_sub1;
    }

    public Model method446(byte byte0, int i) {
        if (byte0 != 107) {
            for (int j = 1; j > 0; j++) ;
        }
        int k = anInt629;
        if (i == 1)
            k = anInt631;
        if (k == -1)
            return null;
        int l = anInt630;
        if (i == 1)
            l = anInt632;
        Model class35_sub2_sub1 = new Model(k, 298);
        if (l != -1) {
            Model class35_sub2_sub1_1 = new Model(l, 298);
            Model[] aclass35_sub2_sub1 = {
                    class35_sub2_sub1, class35_sub2_sub1_1
            };
            class35_sub2_sub1 = new Model(false, 2, aclass35_sub2_sub1);
        }
        if (anIntArray608 != null) {
            for (int i1 = 0; i1 < anIntArray608.length; i1++)
                class35_sub2_sub1.method317(anIntArray608[i1], anIntArray609[i1]);

        }
        return class35_sub2_sub1;
    }

    public ObjType() {
        anInt604 = -1;
    }

    public static int anInt598 = -878;
    public static int anInt599;
    public static int[] anIntArray600;
    public static Buffer aClass35_Sub2_Sub3_601;
    public static ObjType[] aObjTypeArray602;
    public static int anInt603;
    public int anInt604;
    public int anInt605;
    public String aString606;
    public byte[] aByteArray607;
    public int[] anIntArray608;
    public int[] anIntArray609;
    public int anInt610;
    public int anInt611;
    public int anInt612;
    public int anInt613;
    public int anInt614;
    public int anInt615;
    public boolean aBoolean616;
    public int anInt617;
    public boolean aBoolean618;
    public int anInt619;
    public boolean aBoolean620;
    public String[] aStringArray621;
    public String[] aStringArray622;
    public int anInt623;
    public int anInt624;
    public byte aByte625;
    public int anInt626;
    public int anInt627;
    public byte aByte628;
    public int anInt629;
    public int anInt630;
    public int anInt631;
    public int anInt632;
    public static Cache aCache_633 = new Cache(-24094, 50);
    public static Cache aCache_634 = new Cache(-24094, 200);

}
