package com.jagex.core.network;

import com.jagex.game.runetek3.client.GameShell;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class BufferedStream implements Runnable {

    public BufferedStream(GameShell gameShell, int i, Socket socket) throws IOException {
        closed = false;
        writing = false;
        exception = false;
        shell = gameShell;
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
        closed = true;
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
        writing = false;
        synchronized (this) {
            notify();
        }
        buffer = null;
    }

    public int read() throws IOException {
        if (closed) {
            return 0;
        } else {
            return anInputStream83.read();
        }
    }

    public int method152() throws IOException {
        if (closed) {
            return 0;
        } else {
            return anInputStream83.available();
        }
    }

    public void method153(byte[] abyte0, int i, int j) throws IOException {
        if (closed) {
            return;
        }
        int k;
        for (; j > 0; j -= k) {
            k = anInputStream83.read(abyte0, i, j);
            if (k <= 0) {
                throw new IOException("EOF");
            }
            i += k;
        }
    }

    public void write(byte[] src, int len) throws IOException {
        if (closed) {
            return;
        }
        if (exception) {
            exception = false;
            throw new IOException("Error in writer thread");
        }
        if (buffer == null) {
            buffer = new byte[5000];
        }
        synchronized (this) {
            for (int i = 0; i < len; i++) {
                buffer[offset] = src[i];
                offset = (offset + 1) % 5000;
                if (offset == (length + 4900) % 5000) {
                    throw new IOException("buffer overflow");
                }
            }

            if (!writing) {
                writing = true;
                shell.startThread(this, 2);
            }
            notify();
        }
    }

    public void run() {
        System.out.println("clientstream writer starting");
        while (writing) {
            int i;
            int j;
            synchronized (this) {
                if (offset == length) {
                    try {
                        wait();
                    } catch (InterruptedException _ex) {
                    }
                }
                if (!writing) {
                    break;
                }
                j = length;
                if (offset >= length) {
                    i = offset - length;
                } else {
                    i = 5000 - length;
                }
            }
            if (i > 0) {
                try {
                    anOutputStream84.write(buffer, j, i);
                } catch (IOException _ex) {
                    exception = true;
                }
                length = (length + i) % 5000;
                try {
                    if (offset == length) {
                        anOutputStream84.flush();
                    }
                } catch (IOException _ex) {
                    exception = true;
                }
            }
        }
        System.out.println("clientstream writer stopping");
    }

    public InputStream anInputStream83;
    public OutputStream anOutputStream84;
    public Socket aSocket85;
    public boolean closed;
    public GameShell shell;
    public byte[] buffer;
    public int length;
    public int offset;
    public boolean writing;
    public boolean exception;
}
