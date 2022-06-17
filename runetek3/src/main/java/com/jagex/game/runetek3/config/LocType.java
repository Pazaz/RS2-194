package com.jagex.game.runetek3.config;

// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

import com.jagex.core.io.Buffer;
import com.jagex.core.io.FileArchive;
import com.jagex.core.utils.Cache;
import com.jagex.game.runetek3.graphics.model.Model;

public class LocType {

    public static void decode(FileArchive archive) {
        dat = new Buffer(archive.read(null, "loc.dat"));

        Buffer idx = new Buffer(archive.read(null, "loc.idx"));
        count = idx.g2();
        offsets = new int[count];
        int offset = 2;
        for (int i = 0; i < count; i++) {
            offsets[i] = offset;
            offset += idx.g2();
        }

        cache = new LocType[10];
        for (int i = 0; i < 10; i++) {
            cache[i] = new LocType();
        }

    }

    public static void unload() {
        aCache_568 = null;
        aCache_569 = null;
        offsets = null;
        cache = null;
        dat = null;
    }

    public static LocType get(int id) {
        for (int i = 0; i < 10; i++) {
            if (cache[i].id == id) {
                return cache[i];
            }
        }

        offset = (offset + 1) % 10;
        LocType type = cache[offset];
        dat.pos = offsets[id];
        type.id = id;
        type.reset();
        type.decode(dat);
        return type;
    }

    public void reset() {
        models = null;
        shapes = null;
        name = null;
        desc = null;
        recol_s = null;
        recol_d = null;
        width = 1;
        length = 1;
        blockwalk = true;
        blockrange = true;
        interactable = false;
        hillskew = false;
        computeVertexColors = false;
        occlude = false;
        anim = -1;
        walloff = 16;
        ambient = 0;
        contrast = 0;
        ops = null;
        disposeAlpha = false;
        mapfunctions = -1;
        mapscene = -1;
        mirror = false;
        active = true;
        resizeX = 128;
        resizeY = 128;
        resizeZ = 128;
        blocksides = 0;
        xoff = 0;
        yoff = 0;
        zoff = 0;
        forcedecor = false;
    }

    public void decode(Buffer buffer) {
        int interactive = -1;

        do {
            int opcode = buffer.g1();

            if (opcode == 0) {
                break;
            }

            if (opcode == 1) {
                int count = buffer.g1();
                shapes = new int[count];
                models = new int[count];
                for (int i = 0; i < count; i++) {
                    models[i] = buffer.g2();
                    shapes[i] = buffer.g1();
                }

            } else if (opcode == 2) {
                name = buffer.gstr();
            } else if (opcode == 3) {
                desc = buffer.gstrbyte();
            } else if (opcode == 14) {
                width = buffer.g1();
            } else if (opcode == 15) {
                length = buffer.g1();
            } else if (opcode == 17) {
                blockwalk = false;
            } else if (opcode == 18) {
                blockrange = false;
            } else if (opcode == 19) {
                interactive = buffer.g1();
                if (interactive == 1) {
                    interactable = true;
                }
            } else if (opcode == 21) {
                hillskew = true;
            } else if (opcode == 22) {
                computeVertexColors = true;
            } else if (opcode == 23) {
                occlude = true;
            } else if (opcode == 24) {
                anim = buffer.g2();
                if (anim == 65535) {
                    anim = -1;
                }
            } else if (opcode == 25) {
                disposeAlpha = true;
            } else if (opcode == 28) {
                walloff = buffer.g1();
            } else if (opcode == 29) {
                ambient = buffer.g1b();
            } else if (opcode == 39) {
                contrast = buffer.g1b();
            } else if (opcode >= 30 && opcode < 39) {
                if (ops == null) {
                    ops = new String[5];
                }
                ops[opcode - 30] = buffer.gstr();
            } else if (opcode == 40) {
                int count = buffer.g1();
                recol_s = new int[count];
                recol_d = new int[count];
                for (int i = 0; i < count; i++) {
                    recol_s[i] = buffer.g2();
                    recol_d[i] = buffer.g2();
                }

            } else if (opcode == 60) {
                mapfunctions = buffer.g2();
            } else if (opcode == 62) {
                mirror = true;
            } else if (opcode == 64) {
                active = false;
            } else if (opcode == 65) {
                resizeX = buffer.g2();
            } else if (opcode == 66) {
                resizeY = buffer.g2();
            } else if (opcode == 67) {
                resizeZ = buffer.g2();
            } else if (opcode == 68) {
                mapscene = buffer.g2();
            } else if (opcode == 69) {
                blocksides = buffer.g1();
            } else if (opcode == 70)
                xoff = buffer.g2b();
            else if (opcode == 71)
                yoff = buffer.g2b();
            else if (opcode == 72)
                zoff = buffer.g2b();
            else if (opcode == 73)
                forcedecor = true;
        } while (true);

        if (shapes == null) {
            shapes = new int[0];
        }

        if (interactive == -1) {
            interactable = shapes.length > 0 && shapes[0] == 10;

            if (ops != null) {
                interactable = true;
            }
        }
    }

    public Model method431(int i, int j, int k, int l, int i1, int j1, int k1) {
        int l1 = -1;
        for (int i2 = 0; i2 < shapes.length; i2++) {
            if (shapes[i2] != i)
                continue;
            l1 = i2;
            break;
        }

        if (l1 == -1)
            return null;
        long l2 = (long) ((id << 6) + (l1 << 3) + j) + ((long) (k1 + 1) << 32);
        if (aBoolean529)
            l2 = 0L;
        if (!hillskew && !computeVertexColors) {
            Model class35_sub2_sub1 = (Model) aCache_569.method295(l2);
            if (class35_sub2_sub1 != null) {
                return class35_sub2_sub1;
            }
        }
        if (l1 >= models.length) {
            return null;
        }
        int j2 = models[l1];
        if (j2 == -1) {
            return null;
        }
        boolean flag = mirror ^ (j > 3);
        if (flag) {
            j2 += 0x10000;
        }
        Model class35_sub2_sub1_1 = (Model) aCache_568.method295(j2);
        if (class35_sub2_sub1_1 == null) {
            class35_sub2_sub1_1 = new Model(j2 & 0xffff, 298);
            if (flag) {
                class35_sub2_sub1_1.flipBackwards();
            }
            aCache_568.method296(j2, 7, class35_sub2_sub1_1);
        }
        boolean flag1;
        flag1 = resizeX != 128 || resizeY != 128 || resizeZ != 128;
        boolean flag2;
        flag2 = xoff != 0 || yoff != 0 || zoff != 0;
        Model model = new Model(-428, !computeVertexColors, class35_sub2_sub1_1, recol_s == null, j == 0 && !hillskew && k1 == -1 && !flag1 && !flag2, !disposeAlpha);
        if (k1 != -1) {
            model.applyGroups();
            model.applyFrame(k1);
            model.skinTriangle = null;
            model.labelVertices = null;
        }
        while (j-- > 0) {
            model.rotateCounterClockwise();
        }
        if (recol_s != null) {
            for (int k2 = 0; k2 < recol_s.length; k2++) {
                model.recolor(recol_s[k2], recol_d[k2]);
            }

        }
        if (flag1) {
            model.method319(728, resizeX, resizeY, resizeZ);
        }
        if (hillskew) {
            int i3 = (k + l + i1 + j1) / 4;
            for (int j3 = 0; j3 < model.vertexCount; j3++) {
                int k3 = model.vertexX[j3];
                int l3 = model.vertexZ[j3];
                int i4 = k + ((l - k) * (k3 + 64)) / 128;
                int j4 = j1 + ((i1 - j1) * (k3 + 64)) / 128;
                int k4 = i4 + ((j4 - i4) * (l3 + 64)) / 128;
                model.vertexY[j3] += k4 - i3;
            }

        }
        if (flag2) {
            model.translate(zoff, xoff, yoff);
        }
        model.applyLighting(64 + ambient, 768 + contrast * 5, -50, -10, -50, !computeVertexColors);
        if (blockwalk) {
            model.anInt1080 = model.maxBoundY;
        }
        if (!hillskew && !computeVertexColors) {
            aCache_569.method296(l2, 7, model);
        }
        return model;
    }

    public LocType() {
        id = -1;
    }

    public static int anInt527 = -494;
    public static boolean aBoolean528 = true;
    public static boolean aBoolean529;
    public static int count;
    public static int[] offsets;
    public static Buffer dat;
    public static LocType[] cache;
    public static int offset;
    public int id;
    public int[] models;
    public int[] shapes;
    public String name;
    public byte[] desc;
    public int[] recol_s;
    public int[] recol_d;
    public int width;
    public int length;
    public boolean blockwalk;
    public boolean blockrange;
    public boolean interactable;
    public boolean hillskew;
    public boolean computeVertexColors;
    public boolean occlude;
    public int anim;
    public int walloff;
    public byte ambient;
    public byte contrast;
    public String[] ops;
    public boolean disposeAlpha;
    public int mapfunctions;
    public int mapscene;
    public boolean mirror;
    public boolean active;
    public int resizeX;
    public int resizeY;
    public int resizeZ;
    public int xoff;
    public int yoff;
    public int zoff;
    public int blocksides;
    public boolean forcedecor;
    public static Cache aCache_568 = new Cache(-24094, 500);
    public static Cache aCache_569 = new Cache(-24094, 30);

}
