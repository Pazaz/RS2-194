package com.jagex.game.runetek3.config;

import com.jagex.core.io.Buffer;
import com.jagex.core.io.FileArchive;

public class VarpType {

    public static void decode(FileArchive archive) {
        Buffer buffer = new Buffer(archive.read(null, "varp.dat"));
        opcode3Count = 0;
        count = buffer.g2();
        if (instances == null) {
            instances = new VarpType[count];
        }
        if (opcode3Array == null) {
            opcode3Array = new int[count];
        }
        for (int i = 0; i < count; i++) {
            if (instances[i] == null) {
                instances[i] = new VarpType();
            }
            instances[i].decode(i, buffer);
        }

    }

    public void decode(int id, Buffer buffer) {
        while (true) {
            int opcode = buffer.g1();

            if (opcode == 0) {
                return;
            }

            if (opcode == 1) {
                opcode1 = buffer.g1();
            } else if (opcode == 2) {
                opcode2 = buffer.g1();
            } else if (opcode == 3) {
                opcode3 = true;
                opcode3Array[opcode3Count++] = id;
            } else if (opcode == 4) {
                opcode4 = false;
            } else if (opcode == 5) {
                clientcode = buffer.g2();
            } else if (opcode == 10) {
                opcode10 = buffer.gstr();
            } else {
                System.out.println("Error unrecognised config code: " + opcode);
            }
        }
    }

    public VarpType() {
        opcode3 = false;
        opcode4 = true;
    }

    public static int count;
    public static VarpType[] instances;
    public static int opcode3Count;
    public static int[] opcode3Array;
    public String opcode10;
    public int opcode1;
    public int opcode2;
    public boolean opcode3;
    public boolean opcode4;
    public int clientcode;

}
