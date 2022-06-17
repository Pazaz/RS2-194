package com.jagex.game.runetek3.config;

import com.jagex.core.io.Buffer;
import com.jagex.core.io.FileArchive;
import com.jagex.core.utils.Cache;
import com.jagex.game.runetek3.graphics.Draw2D;
import com.jagex.game.runetek3.graphics.Draw3D;
import com.jagex.game.runetek3.graphics.Sprite;
import com.jagex.game.runetek3.graphics.model.Model;

public class ObjType {

    public static void decode(FileArchive archive) {
        dat = new Buffer(archive.read(null, "obj.dat"));
        Buffer idx = new Buffer(archive.read(null, "obj.idx"));
        count = idx.g2();
        offsets = new int[count];
        int offset = 2;
        for (int i = 0; i < count; i++) {
            offsets[i] = offset;
            offset += idx.g2();
        }

        cache = new ObjType[10];
        for (int i = 0; i < 10; i++) {
            cache[i] = new ObjType();
        }

    }

    public static void unload() {
        models = null;
        icons = null;
        offsets = null;
        cache = null;
        dat = null;
    }

    public static ObjType get(int id) {
        for (int i = 0; i < 10; i++) {
            if (cache[i].id == id) {
                return cache[i];
            }
        }

        offset = (offset + 1) % 10;
        ObjType obj = cache[offset];
        dat.pos = offsets[id];
        obj.id = id;
        obj.reset();
        obj.decode(dat);
        return obj;
    }

    public void reset() {
        model = 0;
        name = null;
        desc = null;
        recol_s = null;
        recol_d = null;
        zoom2d = 2000;
        xand2 = 0;
        yand2d = 0;
        zand2d = 0;
        xof2d = 0;
        yof2d = 0;
        opcode9 = false;
        opcode10 = -1;
        stackable = false;
        cost = 1;
        members = false;
        ops = null;
        iops = null;
        manwear = -1;
        manwear2 = -1;
        manwearOffsetY = 0;
        womanwear = -1;
        womanwear2 = -1;
        womanwearOffsetY = 0;
        manhead = -1;
        manhead2 = -1;
        womanhead = -1;
        womanhead2 = -1;
    }

    public void decode(Buffer buffer) {
        while (true) {
            int opcode = buffer.g1();

            if (opcode == 0) {
                return;
            }

            if (opcode == 1) {
                model = buffer.g2();
            } else if (opcode == 2) {
                name = buffer.gstr();
            } else if (opcode == 3) {
                desc = buffer.gstrbyte();
            } else if (opcode == 4) {
                zoom2d = buffer.g2();
            } else if (opcode == 5) {
                xand2 = buffer.g2();
            } else if (opcode == 6) {
                yand2d = buffer.g2();
            } else if (opcode == 7) {
                xof2d = buffer.g2();
                if (xof2d > 32767) {
                    xof2d -= 65536;
                }
            } else if (opcode == 8) {
                yof2d = buffer.g2();
                if (yof2d > 32767) {
                    yof2d -= 65536;
                }
            } else if (opcode == 9) {
                opcode9 = true;
            } else if (opcode == 10) {
                opcode10 = buffer.g2();
            } else if (opcode == 11) {
                stackable = true;
            } else if (opcode == 12) {
                cost = buffer.g4();
            } else if (opcode == 16) {
                members = true;
            } else if (opcode == 23) {
                manwear = buffer.g2();
                manwearOffsetY = buffer.g1b();
            } else if (opcode == 24) {
                manwear2 = buffer.g2();
            } else if (opcode == 25) {
                womanwear = buffer.g2();
                womanwearOffsetY = buffer.g1b();
            } else if (opcode == 26) {
                womanwear2 = buffer.g2();
            } else if (opcode >= 30 && opcode < 35) {
                if (ops == null) {
                    ops = new String[5];
                }
                ops[opcode - 30] = buffer.gstr();
            } else if (opcode >= 35 && opcode < 40) {
                if (iops == null) {
                    iops = new String[5];
                }
                iops[opcode - 35] = buffer.gstr();
            } else if (opcode == 40) {
                int count = buffer.g1();
                recol_s = new int[count];
                recol_d = new int[count];
                for (int l = 0; l < count; l++) {
                    recol_s[l] = buffer.g2();
                    recol_d[l] = buffer.g2();
                }
            } else if (opcode == 90) {
                manhead = buffer.g2();
            } else if (opcode == 91) {
                womanhead = buffer.g2();
            } else if (opcode == 92) {
                manhead2 = buffer.g2();
            } else if (opcode == 93) {
                womanhead2 = buffer.g2();
            } else if (opcode == 95) {
                zand2d = buffer.g2();
            }
        }
    }

    public Model method443() {
        Model class35_sub2_sub1 = (Model) models.get(id);
        if (class35_sub2_sub1 != null)
            return class35_sub2_sub1;
        class35_sub2_sub1 = new Model(model);
        if (recol_s != null) {
            for (int i = 0; i < recol_s.length; i++)
                class35_sub2_sub1.recolor(recol_s[i], recol_d[i]);

        }
        class35_sub2_sub1.applyLighting(64, 768, -50, -10, -50, true);
        class35_sub2_sub1.pickable = true;
        models.put(id, class35_sub2_sub1);
        return class35_sub2_sub1;
    }

    public static Sprite method444(int i) {
        Sprite class35_sub2_sub2_sub2 = (Sprite) icons.get(i);
        if (class35_sub2_sub2_sub2 != null) {
            return class35_sub2_sub2_sub2;
        }
        ObjType class41 = get(i);
        class35_sub2_sub2_sub2 = new Sprite(32, 32);
        int j = Draw3D.anInt1267;
        int k = Draw3D.anInt1268;
        int[] ai = Draw3D.anIntArray1273;
        int[] ai1 = Draw2D.data;
        int l = Draw2D.width;
        int i1 = Draw2D.height;
        Draw3D.aBoolean1265 = false;
        Draw2D.prepare(32, class35_sub2_sub2_sub2.pixels, 32);
        Draw2D.fillRect(0, 32, 0, 32, 0);
        Draw3D.method338((byte) 16);
        Model class35_sub2_sub1 = class41.method443();
        int j1 = Draw3D.anIntArray1271[class41.xand2] * class41.zoom2d >> 16;
        int k1 = Draw3D.anIntArray1272[class41.xand2] * class41.zoom2d >> 16;
        class35_sub2_sub1.method323(0, class41.yand2d, class41.zand2d, class41.xand2, class41.xof2d, j1 + class35_sub2_sub1.maxBoundY / 2 + class41.yof2d, k1 + class41.yof2d);
        for (int j2 = 31; j2 >= 0; j2--) {
            for (int l1 = 31; l1 >= 0; l1--) {
                if (class35_sub2_sub2_sub2.pixels[j2 + l1 * 32] == 0) {
                    if (j2 > 0 && class35_sub2_sub2_sub2.pixels[(j2 - 1) + l1 * 32] > 1) {
                        class35_sub2_sub2_sub2.pixels[j2 + l1 * 32] = 1;
                    } else if (l1 > 0 && class35_sub2_sub2_sub2.pixels[j2 + (l1 - 1) * 32] > 1) {
                        class35_sub2_sub2_sub2.pixels[j2 + l1 * 32] = 1;
                    } else if (j2 < 31 && class35_sub2_sub2_sub2.pixels[j2 + 1 + l1 * 32] > 1) {
                        class35_sub2_sub2_sub2.pixels[j2 + l1 * 32] = 1;
                    } else if (l1 < 31 && class35_sub2_sub2_sub2.pixels[j2 + (l1 + 1) * 32] > 1) {
                        class35_sub2_sub2_sub2.pixels[j2 + l1 * 32] = 1;
                    }
                }
            }
        }

        for (int k2 = 31; k2 >= 0; k2--) {
            for (int i2 = 31; i2 >= 0; i2--) {
                if (class35_sub2_sub2_sub2.pixels[k2 + i2 * 32] == 0 && k2 > 0 && i2 > 0 && class35_sub2_sub2_sub2.pixels[(k2 - 1) + (i2 - 1) * 32] > 0) {
                    class35_sub2_sub2_sub2.pixels[k2 + i2 * 32] = 0x302020;
                }
            }
        }

        icons.put(i, class35_sub2_sub2_sub2);
        Draw2D.prepare(l, ai1, i1);
        Draw3D.anInt1267 = j;
        Draw3D.anInt1268 = k;
        Draw3D.anIntArray1273 = ai;

        Draw3D.aBoolean1265 = true;
        if (class41.stackable) {
            class35_sub2_sub2_sub2.cropW = 33;
        } else {
            class35_sub2_sub2_sub2.cropW = 32;
        }
        return class35_sub2_sub2_sub2;
    }

    public Model method445(int j) {
        int k = manwear;
        if (j == 1)
            k = womanwear;
        if (k == -1)
            return null;
        int l = manwear2;
        if (j == 1)
            l = womanwear2;
        Model class35_sub2_sub1 = new Model(k);
        if (l != -1) {
            Model class35_sub2_sub1_1 = new Model(l);
            Model[] aclass35_sub2_sub1 = {class35_sub2_sub1, class35_sub2_sub1_1};
            class35_sub2_sub1 = new Model(false, 2, aclass35_sub2_sub1);
        }
        if (j == 0 && manwearOffsetY != 0) {
            class35_sub2_sub1.translate(0, 0, manwearOffsetY);
        }
        if (j == 1 && womanwearOffsetY != 0) {
            class35_sub2_sub1.translate(0, 0, womanwearOffsetY);
        }
        if (recol_s != null) {
            for (int i1 = 0; i1 < recol_s.length; i1++) {
                class35_sub2_sub1.recolor(recol_s[i1], recol_d[i1]);
            }

        }
        return class35_sub2_sub1;
    }

    public Model method446(byte byte0, int i) {
        if (byte0 != 107) {
            for (int j = 1; j > 0; j++) ;
        }
        int k = manhead;
        if (i == 1) {
            k = womanhead;
        }
        if (k == -1) {
            return null;
        }
        int l = manhead2;
        if (i == 1) {
            l = womanhead2;
        }
        Model class35_sub2_sub1 = new Model(k);
        if (l != -1) {
            Model class35_sub2_sub1_1 = new Model(l);
            Model[] aclass35_sub2_sub1 = {class35_sub2_sub1, class35_sub2_sub1_1};
            class35_sub2_sub1 = new Model(false, 2, aclass35_sub2_sub1);
        }
        if (recol_s != null) {
            for (int i1 = 0; i1 < recol_s.length; i1++) {
                class35_sub2_sub1.recolor(recol_s[i1], recol_d[i1]);
            }
        }
        return class35_sub2_sub1;
    }

    public ObjType() {
        id = -1;
    }

    public static int anInt598 = -878;
    public static int count;
    public static int[] offsets;
    public static Buffer dat;
    public static ObjType[] cache;
    public static int offset;
    public int id;
    public int model;
    public String name;
    public byte[] desc;
    public int[] recol_s;
    public int[] recol_d;
    public int zoom2d;
    public int xand2;
    public int yand2d;
    public int zand2d;
    public int xof2d;
    public int yof2d;
    public boolean opcode9;
    public int opcode10;
    public boolean stackable;
    public int cost;
    public boolean members;
    public String[] ops;
    public String[] iops;
    public int manwear;
    public int manwear2;
    public byte manwearOffsetY;
    public int womanwear;
    public int womanwear2;
    public byte womanwearOffsetY;
    public int manhead;
    public int manhead2;
    public int womanhead;
    public int womanhead2;
    public static Cache models = new Cache(50);
    public static Cache icons = new Cache(200);

}
