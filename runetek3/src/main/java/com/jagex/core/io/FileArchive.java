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
        if (byte0 == 2) {
        }
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
        fileCount = class35_sub2_sub3.g2();
        fileHash = new int[fileCount];
        fileUnpackedSize = new int[fileCount];
        anIntArray518 = new int[fileCount];
        anIntArray519 = new int[fileCount];
        int k = class35_sub2_sub3.pos + fileCount * 10;
        for (int l = 0; l < fileCount; l++) {
            fileHash[l] = class35_sub2_sub3.g4();
            fileUnpackedSize[l] = class35_sub2_sub3.g3();
            anIntArray518[l] = class35_sub2_sub3.g3();
            anIntArray519[l] = k;
            k += anIntArray518[l];
        }

    }

    public byte[] read(byte[] dest, String name) {
        int hash = 0;
        String upperName = name.toUpperCase();
        for (int i = 0; i < upperName.length(); i++) {
            hash = (hash * 61 + upperName.charAt(i)) - 32;
        }

        for (int i = 0; i < fileCount; i++) {
            if (fileHash[i] == hash) {
                if (dest == null) {
                    dest = new byte[fileUnpackedSize[i]];
                }
                if (fileUnpackedSize[i] != anIntArray518[i]) {
                    BZip2InputStream.method287(dest, fileUnpackedSize[i], aByteArray514, anIntArray518[i], anIntArray519[i]);
                } else {
                    for (int i1 = 0; i1 < fileUnpackedSize[i]; i1++) {
                        dest[i1] = aByteArray514[anIntArray519[i] + i1];
                    }

                }
                return dest;
            }
        }
        return null;
    }

    public boolean aBoolean512;
    public int anInt513;
    public byte[] aByteArray514;
    public int fileCount;
    public int[] fileHash;
    public int[] fileUnpackedSize;
    public int[] anIntArray518;
    public int[] anIntArray519;
}
