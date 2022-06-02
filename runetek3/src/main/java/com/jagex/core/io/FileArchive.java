package com.jagex.core.io;

// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

import com.jagex.core.bzip2.BZip2InputStream;

public class FileArchive {

    public FileArchive(byte[] abyte0) {
        aBoolean512 = true;
        method416(abyte0, (byte) 2);
    }

    public void method416(byte[] abyte0, byte byte0) {
        Buffer class35_sub2_sub3 = new Buffer(abyte0);
        int i = class35_sub2_sub3.g3();
        if (byte0 == 2)
            byte0 = 0;
        else
            anInt513 = -215;
        int j = class35_sub2_sub3.g3();
        if (j != i) {
            byte[] abyte1 = new byte[i];
            BZip2InputStream.method287(abyte1, i, abyte0, j, 6);
            aByteArray514 = abyte1;
            class35_sub2_sub3 = new Buffer(aByteArray514);
        } else {
            aByteArray514 = abyte0;
        }
        anInt515 = class35_sub2_sub3.g2();
        anIntArray516 = new int[anInt515];
        anIntArray517 = new int[anInt515];
        anIntArray518 = new int[anInt515];
        anIntArray519 = new int[anInt515];
        int k = class35_sub2_sub3.pos + anInt515 * 10;
        for (int l = 0; l < anInt515; l++) {
            anIntArray516[l] = class35_sub2_sub3.g4();
            anIntArray517[l] = class35_sub2_sub3.g3();
            anIntArray518[l] = class35_sub2_sub3.g3();
            anIntArray519[l] = k;
            k += anIntArray518[l];
        }

    }

    public byte[] method417(byte byte0, byte[] abyte0, String s) {
        if (byte0 == 6) {
            byte0 = 0;
        } else {
            for (int i = 1; i > 0; i++) ;
        }
        int j = 0;
        s = s.toUpperCase();
        for (int k = 0; k < s.length(); k++)
            j = (j * 61 + s.charAt(k)) - 32;

        for (int l = 0; l < anInt515; l++)
            if (anIntArray516[l] == j) {
                if (abyte0 == null)
                    abyte0 = new byte[anIntArray517[l]];
                if (anIntArray517[l] != anIntArray518[l]) {
                    BZip2InputStream.method287(abyte0, anIntArray517[l], aByteArray514, anIntArray518[l], anIntArray519[l]);
                } else {
                    for (int i1 = 0; i1 < anIntArray517[l]; i1++)
                        abyte0[i1] = aByteArray514[anIntArray519[l] + i1];

                }
                return abyte0;
            }

        return null;
    }

    public boolean aBoolean512;
    public int anInt513;
    public byte[] aByteArray514;
    public int anInt515;
    public int[] anIntArray516;
    public int[] anIntArray517;
    public int[] anIntArray518;
    public int[] anIntArray519;
}
