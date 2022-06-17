package com.jagex.core.io;

// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

import com.jagex.core.isaac.IsaacRandom;
import com.jagex.core.utils.CacheableNode;
import com.jagex.core.utils.LinkedList;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.zip.CRC32;

public class Buffer extends CacheableNode {

    public static Buffer reserve(int type) {
        synchronized (queueMid) {
            Buffer queueBuffer = null;
            if (type == 0 && queueMinCount > 0) {
                queueMinCount--;
                queueBuffer = (Buffer) queueMin.poll();
            } else if (type == 1 && queueMidCount > 0) {
                queueMidCount--;
                queueBuffer = (Buffer) queueMid.poll();
            } else if (type == 2 && queueMaxCount > 0) {
                queueMaxCount--;
                queueBuffer = (Buffer) queueMax.poll();
            }
            if (queueBuffer != null) {
                queueBuffer.pos = 0;
                return queueBuffer;
            }
        }

        Buffer buffer = new Buffer();
        buffer.pos = 0;
        if (type == 0)
            buffer.data = new byte[100];
        else if (type == 1)
            buffer.data = new byte[5000];
        else
            buffer.data = new byte[30000];
        buffer.length = buffer.data.length;
        return buffer;
    }

    public int length;

    public int available() {
        return this.length - this.pos;
    }

    public void release() {
        synchronized (queueMid) {
            pos = 0;
            if (length == 100 && queueMinCount < 1000) {
                queueMin.pushNext(this);
                queueMinCount++;
            } else if (length == 5000 && queueMidCount < 250) {
                queueMid.pushNext(this);
                queueMidCount++;
            } else if (length == 30000 && queueMaxCount < 50) {
                queueMax.pushNext(this);
                queueMaxCount++;
            }
        }
    }

    // returns the current buffer array up to the offset, and resets the offset
    public byte[] take() {
        int size = this.pos;
        this.pos = 0;
        return Arrays.copyOfRange(this.data, 0, size);
    }

    public Buffer slice(int offset, int length) {
        return new Buffer(Arrays.copyOfRange(this.data, offset, offset + length));
    }

    public byte[] sliceBytes(int offset, int length) {
        return Arrays.copyOfRange(this.data, offset, offset + length);
    }

    public Buffer() {
    }

    public Buffer(byte[] src) {
        data = src;
        length = src.length;
        pos = 0;
    }

    private static final CRC32 crc = new CRC32();

    public static int crc32(byte[] data) {
        crc.reset();
        crc.update(data, 0, data.length);
        return (int) crc.getValue();
    }

    public void p1isaac(int opcode) {
        this.data[this.pos++] = (byte) (opcode + this.isaac.nextInt());
    }

    public void p1(int value) {
        this.data[this.pos++] = (byte) value;
    }

    public void p2(int value) {
        this.data[this.pos++] = (byte) (value >> 8);
        this.data[this.pos++] = (byte) value;
    }

    public void p3(int value) {
        this.data[this.pos++] = (byte) (value >> 16);
        this.data[this.pos++] = (byte) (value >> 8);
        this.data[this.pos++] = (byte) value;
    }

    public void p4(int value) {
        this.data[this.pos++] = (byte) (value >> 24);
        this.data[this.pos++] = (byte) (value >> 16);
        this.data[this.pos++] = (byte) (value >> 8);
        this.data[this.pos++] = (byte) value;
    }

    public void p8(long value) {
        this.data[this.pos++] = (byte) (value >> 56);
        this.data[this.pos++] = (byte) (value >> 48);
        this.data[this.pos++] = (byte) (value >> 40);
        this.data[this.pos++] = (byte) (value >> 32);
        this.data[this.pos++] = (byte) (value >> 24);
        this.data[this.pos++] = (byte) (value >> 16);
        this.data[this.pos++] = (byte) (value >> 8);
        this.data[this.pos++] = (byte) value;
    }

    public void pjstr(String str) {
        str.getBytes(0, str.length(), this.data, this.pos);
        this.pos += str.length();
        this.data[this.pos++] = 10;
    }

    public void pdata(byte[] bytes, int offset, int length) {
        for (int i = offset; i < offset + length; i++) {
            this.data[this.pos++] = bytes[i];
        }
    }

    public void psize1(int length) {
        this.data[this.pos - length - 1] = (byte) length;
    }

    public void psize2(int length) {
        this.data[this.pos - length - 2] = (byte) (length >> 8);
        this.data[this.pos - length - 1] = (byte) length;
    }

    public void psize4(int length) {
        this.data[this.pos - length - 4] = (byte) (length >> 24);
        this.data[this.pos - length - 3] = (byte) (length >> 16);
        this.data[this.pos - length - 2] = (byte) (length >> 8);
        this.data[this.pos - length - 1] = (byte) length;
    }

    public int g1isaac() {
        return (this.data[this.pos++] - this.isaac.nextInt()) & 0xFF;
    }

    public int g1() {
        return this.data[this.pos++] & 0xFF;
    }

    public byte g1b() {
        return this.data[this.pos++];
    }

    public int g2() {
        this.pos += 2;
        return ((this.data[this.pos - 2] & 0xFF) << 8) + (this.data[this.pos - 1] & 0xFF);
    }

    public int g2b() {
        pos += 2;
        int value = ((this.data[this.pos - 2] & 0xFF) << 8) + (this.data[this.pos - 1] & 0xFF);
        if (value > 32767) {
            value -= 65536;
        }
        return value;
    }

    public int g3() {
        pos += 3;
        return ((this.data[this.pos - 3] & 0xFF) << 16) + ((this.data[this.pos - 2] & 0xFF) << 8) + (this.data[this.pos - 1] & 0xFF);
    }

    public int g4() {
        pos += 4;
        return ((this.data[this.pos - 4] & 0xFF) << 24) + ((this.data[this.pos - 3] & 0xFF) << 16) + ((this.data[this.pos - 2] & 0xFF) << 8) + (this.data[this.pos - 1] & 0xFF);
    }

    public long g8() {
        long high = (long) this.g4() & 0xFFFFFFFFL;
        long low = (long) this.g4() & 0xFFFFFFFFL;
        return (high << 32) + low;
    }

    public String gstr() {
        int start = this.pos;
        while (this.data[this.pos++] != 10) ;
        return new String(this.data, start, this.pos - start - 1);
    }

    public byte[] gstrbyte() {
        int start = this.pos;
        while (this.data[this.pos++] != 10) ;
        byte[] bytes = new byte[this.pos - start - 1];
        for (int i = start; i < this.pos - 1; i++) {
            bytes[i - start] = this.data[i];
        }
        return bytes;
    }

    public void gdata(byte[] dest, int offset, int length) {
        for (int i = offset; i < offset + length && i < dest.length; i++) {
            dest[i] = this.data[this.pos++];
        }
    }

    public void accessBits() {
        this.bitOffset = this.pos * 8;
    }

    public int gBit(int n) {
        int byteOffset = this.bitOffset >> 3;
        int msb = 8 - (this.bitOffset & 0x7);
        int i = 0;
        this.bitOffset += n;
        while (n > msb) {
            i += (this.data[byteOffset++] & BITMASK[msb]) << n - msb;
            n -= msb;
            msb = 8;
        }
        if (n == msb) {
            i += this.data[byteOffset] & BITMASK[msb];
        } else {
            i += this.data[byteOffset] >> msb - n & BITMASK[n];
        }
        return i;
    }

    public void pBit(int n, int value) {
        int byteOffset = this.bitOffset >> 3;
        int remaining = 8 - (this.bitOffset & 0x7);
        this.bitOffset += n;

        for (; n > remaining; remaining = 8) {
            this.data[byteOffset] &= ~BITMASK[remaining];
            this.data[byteOffset++] |= (value >>> (n - remaining)) & BITMASK[remaining];
            n -= remaining;
        }

        if (n == remaining) {
            this.data[byteOffset] &= ~BITMASK[remaining];
            this.data[byteOffset] |= value & BITMASK[remaining];
        } else {
            this.data[byteOffset] &= ~BITMASK[n] << (remaining - n);
            this.data[byteOffset] |= (value & BITMASK[n]) << (remaining - n);
        }
    }

    public void accessBytes() {
        this.pos = (this.bitOffset + 7) / 8;
    }

    public int gsmart() {
        int peek = this.data[this.pos] & 0xFF;
        return peek < 128 ? this.g1() - 64 : this.g2() - 0xc000;
    }

    public int gsmarts() {
        int peek = this.data[this.pos] & 0xFF;
        return peek < 128 ? this.g1() : this.g2() - 0x8000;
    }

    public void rsaenc(BigInteger mod, BigInteger exp) {
        int start = this.pos;
        this.pos = 0;
        byte[] raw = new byte[start];
        this.gdata(raw, 0, start);
        BigInteger bigRaw = new BigInteger(raw);
        BigInteger bigEnc = bigRaw.modPow(exp, mod);
        byte[] enc = bigEnc.toByteArray();
        this.pos = 0;
        this.p1(enc.length);
        this.pdata(enc, 0, enc.length);
    }

    public void rsadec(BigInteger mod, BigInteger exp) {
        int length = this.g1();
        byte[] enc = new byte[length];
        this.gdata(enc, 0, length);
        BigInteger bigEnc = new BigInteger(enc);
        BigInteger bigRaw = bigEnc.modPow(exp, mod);
        byte[] dec = bigRaw.toByteArray();
        this.pos = 0;
        this.pdata(dec, 0, dec.length);
        this.pos = 0; // reset afterwards to read the new data
    }

    public int addcrc() {
        int crc = -1;
        for (int j = 0; j < pos; j++) {
            crc = crc >>> 8 ^ crctable[(crc ^ data[j]) & 0xff];
        }

        crc = ~crc;
        p4(crc);
        return crc;
    }

    public static int anInt1148 = -984;
    public boolean aBoolean1149;
    public byte aByte1150;
    public int anInt1151;
    public int anInt1152;
    public byte aByte1153;
    public int anInt1154;
    public boolean aBoolean1155;
    public int anInt1156;
    public byte[] data;
    public int pos;
    public int bitOffset;
    public static int[] crctable;
    private static final int[] BITMASK = new int[] {
        0, 1, 3, 7, 0xf, 0x1f, 0x3f, 0x7f, 0xff,
        0x1ff, 0x3ff, 0x7ff, 0xfff, 0x1fff, 0x3fff, 0x7fff, 0xffff,
        0x1ffff, 0x3ffff, 0x7ffff, 0xfffff, 0x1fffff, 0x3fffff, 0x7fffff, 0xffffff,
        0x1ffffff, 0x3ffffff, 0x7ffffff, 0xfffffff, 0x1fffffff, 0x3fffffff, 0x7fffffff, 0xffffffff
    };
    public IsaacRandom isaac;
    public static int queueMinCount;
    public static int queueMidCount;
    public static int queueMaxCount;
    public static LinkedList queueMin = new LinkedList();
    public static LinkedList queueMid = new LinkedList();
    public static LinkedList queueMax = new LinkedList();
    public static boolean aBoolean1169;

    static {
        crctable = new int[256];
        for (int j = 0; j < 256; j++) {
            int i = j;
            for (int k = 0; k < 8; k++)
                if ((i & 1) == 1)
                    i = i >>> 1 ^ 0xedb88320;
                else
                    i >>>= 1;

            crctable[j] = i;
        }

    }
}
