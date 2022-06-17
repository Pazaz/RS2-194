package com.jagex.game.runetek3.config;

// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

import com.jagex.core.io.Buffer;
import com.jagex.core.io.FileArchive;

public class FloType {

    public static int count;
    public static FloType[] instances;
    public int rgb;
    public int texture;
    public boolean opcode3;
    public boolean occlude;
    public String name;
    public int anInt77;
    public int anInt78;
    public int anInt79;
    public int blendHue;
    public int hsl16;

    public static void decode(FileArchive archive) {
        Buffer buffer = new Buffer(archive.read(null, "flo.dat"));
        count = buffer.g2();
        if (instances == null) {
            instances = new FloType[count];
        }

        for (int i = 0; i < count; i++) {
            if (instances[i] == null) {
                instances[i] = new FloType();
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
                rgb = buffer.g3();
                setColor(rgb);
            } else if (opcode == 2)
                texture = buffer.g1();
            else if (opcode == 3)
                opcode3 = true;
            else if (opcode == 5)
                occlude = false;
            else if (opcode == 6)
                name = buffer.gstr();
            else
                System.out.println("Error unrecognised config code: " + opcode);
        } while (true);
    }

    public void setColor(int i) {
        double d = (double) (i >> 16 & 0xFF) / 256.0D;
        double d1 = (double) (i >> 8 & 0xFF) / 256.0D;
        double d2 = (double) (i & 0xFF) / 256.0D;
        double d3 = d;
        if (d1 < d3) {
            d3 = d1;
        }

        if (d2 < d3) {
            d3 = d2;
        }
        double d4 = d;
        if (d1 > d4) {
            d4 = d1;
        }
        if (d2 > d4) {
            d4 = d2;
        }
        double d5 = 0.0D;
        double d6 = 0.0D;
        double d7 = (d3 + d4) / 2.0D;

        if (d3 != d4) {
            if (d7 < 0.5D) {
                d6 = (d4 - d3) / (d4 + d3);
            }
            if (d7 >= 0.5D) {
                d6 = (d4 - d3) / (2D - d4 - d3);
            }
            if (d == d4) {
                d5 = (d1 - d2) / (d4 - d3);
            } else if (d1 == d4) {
                d5 = 2D + (d2 - d) / (d4 - d3);
            } else if (d2 == d4) {
                d5 = 4D + (d - d1) / (d4 - d3);
            }
        }
        d5 /= 6D;
        anInt77 = (int) (d5 * 256D);
        anInt78 = (int) (d6 * 256D);
        anInt79 = (int) (d7 * 256D);

        if (anInt78 < 0) {
            anInt78 = 0;
        } else if (anInt78 > 255) {
            anInt78 = 255;
        }

        if (anInt79 < 0) {
            anInt79 = 0;
        } else if (anInt79 > 255) {
            anInt79 = 255;
        }

        if (d7 > 0.5D) {
            hsl16 = (int) ((1.0D - d7) * d6 * 512D);
        } else {
            hsl16 = (int) (d7 * d6 * 512D);
        }

        if (hsl16 < 1) {
            hsl16 = 1;
        }

        blendHue = (int) (d5 * (double) hsl16);
    }

    public FloType() {
        texture = -1;
        opcode3 = false;
        occlude = true;
    }
}
