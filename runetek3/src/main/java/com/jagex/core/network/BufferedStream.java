package com.jagex.core.network;

// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

import com.jagex.game.runetek3.client.GameShell;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class BufferedStream
        implements Runnable {

    public BufferedStream(GameShell gameShell, int i, Socket socket)
            throws IOException {
        aBoolean86 = false;
        aBoolean91 = false;
        aBoolean92 = false;
        anGameShell_87 = gameShell;
        aSocket85 = socket;
        aSocket85.setSoTimeout(30000);
        aSocket85.setTcpNoDelay(true);
        anInputStream83 = aSocket85.getInputStream();
        if (i <= 0) {
            throw new NullPointerException();
        } else {
            anOutputStream84 = aSocket85.getOutputStream();
            return;
        }
    }

    public void method150() {
        aBoolean86 = true;
        try {
            if (anInputStream83 != null)
                anInputStream83.close();
            if (anOutputStream84 != null)
                anOutputStream84.close();
            if (aSocket85 != null)
                aSocket85.close();
        } catch (IOException _ex) {
            System.out.println("Error closing stream");
        }
        aBoolean91 = false;
        synchronized (this) {
            notify();
        }
        aByteArray88 = null;
    }

    public int read()
            throws IOException {
        if (aBoolean86)
            return 0;
        else
            return anInputStream83.read();
    }

    public int method152()
            throws IOException {
        if (aBoolean86)
            return 0;
        else
            return anInputStream83.available();
    }

    public void method153(byte[] abyte0, int i, int j)
            throws IOException {
        if (aBoolean86)
            return;
        int k;
        for (; j > 0; j -= k) {
            k = anInputStream83.read(abyte0, i, j);
            if (k <= 0)
                throw new IOException("EOF");
            i += k;
        }

    }

    public void write(byte[] abyte0, int i, boolean flag, int j)
            throws IOException {
        if (aBoolean86)
            return;
        if (aBoolean92) {
            aBoolean92 = false;
            throw new IOException("Error in writer thread");
        }
        if (aByteArray88 == null)
            aByteArray88 = new byte[5000];
        synchronized (this) {
            for (int k = 0; k < i; k++) {
                aByteArray88[anInt90] = abyte0[k + j];
                anInt90 = (anInt90 + 1) % 5000;
                if (anInt90 == (anInt89 + 4900) % 5000)
                    throw new IOException("buffer overflow");
            }

            if (!aBoolean91) {
                aBoolean91 = true;
                anGameShell_87.method12(this, 2);
            }
            notify();
        }
        if (flag)
            anInt82 = 114;
    }

    public void run() {
        System.out.println("clientstream writer starting");
        while (aBoolean91) {
            int i;
            int j;
            synchronized (this) {
                if (anInt90 == anInt89)
                    try {
                        wait();
                    } catch (InterruptedException _ex) {
                    }
                if (!aBoolean91)
                    break;
                j = anInt89;
                if (anInt90 >= anInt89)
                    i = anInt90 - anInt89;
                else
                    i = 5000 - anInt89;
            }
            if (i > 0) {
                try {
                    anOutputStream84.write(aByteArray88, j, i);
                } catch (IOException _ex) {
                    aBoolean92 = true;
                }
                anInt89 = (anInt89 + i) % 5000;
                try {
                    if (anInt90 == anInt89)
                        anOutputStream84.flush();
                } catch (IOException _ex) {
                    aBoolean92 = true;
                }
            }
        }
        System.out.println("clientstream writer stopping");
    }

    public int anInt82;
    public InputStream anInputStream83;
    public OutputStream anOutputStream84;
    public Socket aSocket85;
    public boolean aBoolean86;
    public GameShell anGameShell_87;
    public byte[] aByteArray88;
    public int anInt89;
    public int anInt90;
    public boolean aBoolean91;
    public boolean aBoolean92;
}
