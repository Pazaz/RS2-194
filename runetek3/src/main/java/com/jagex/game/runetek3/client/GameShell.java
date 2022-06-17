package com.jagex.game.runetek3.client;

// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

import com.jagex.game.runetek3.graphics.FrameBuffer;
import com.jagex.game.runetek3.graphics.Sprite;

import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;

public class GameShell extends Applet
        implements Runnable, MouseListener, MouseMotionListener, KeyListener, FocusListener, WindowListener {

    public void method1(int i, int j, int k) {
        anInt11 = j;
        anInt12 = k;
        this.setPreferredSize(new Dimension(this.anInt11, this.anInt12));
        aGameFrame__16 = new GameFrame(this, true);
        aGraphics13 = method11(-36374).getGraphics();
        if (i != 0) {
            return;
        } else {
            aFrameBuffer_14 = new FrameBuffer(anInt12, (byte) -58, method11(-36374), anInt11);
            startThread(this, 1);
            return;
        }
    }

    public void method2(boolean flag, int i, int j) {
        if (!flag) {
            return;
        } else {
            anInt11 = i;
            anInt12 = j;
            aGraphics13 = method11(-36374).getGraphics();
            aFrameBuffer_14 = new FrameBuffer(anInt12, (byte) -58, method11(-36374), anInt11);
            startThread(this, 1);
            return;
        }
    }

    public void run() {
        System.out.println("Registering event listeners");
        method11(-36374).addMouseListener(this);
        method11(-36374).addMouseMotionListener(this);
        method11(-36374).addKeyListener(this);
        method11(-36374).addFocusListener(this);
        if (aGameFrame__16 != null)
            aGameFrame__16.addWindowListener(this);
        showProgress((byte) -75, 0, "Loading...");
        method6();
        int i = 0;
        int j = 256;
        int k = 1;
        int i1 = 0;
        for (int j1 = 0; j1 < 10; j1++)
            aLongArray9[j1] = System.currentTimeMillis();

        long l = System.currentTimeMillis();
        while (anInt6 >= 0) {
            if (anInt6 > 0) {
                anInt6--;
                if (anInt6 == 0) {
                    method3(-59);
                    return;
                }
            }
            int k1 = j;
            int i2 = k;
            j = 300;
            k = 1;
            long l1 = System.currentTimeMillis();
            if (aLongArray9[i] == 0L) {
                j = k1;
                k = i2;
            } else if (l1 > aLongArray9[i])
                j = (int) ((long) (2560 * anInt7) / (l1 - aLongArray9[i]));
            if (j < 25)
                j = 25;
            if (j > 256) {
                j = 256;
                k = (int) ((long) anInt7 - (l1 - aLongArray9[i]) / 10L);
            }
            aLongArray9[i] = l1;
            i = (i + 1) % 10;
            if (k > 1) {
                for (int j2 = 0; j2 < 10; j2++)
                    if (aLongArray9[j2] != 0L)
                        aLongArray9[j2] += k;

            }
            if (k < anInt8)
                k = anInt8;
            try {
                Thread.sleep(k);
            } catch (InterruptedException _ex) {
            }
            for (; i1 < 256; i1 += j) {
                method7((byte) 3);
                anInt22 = 0;
                anInt27 = anInt28;
            }

            i1 &= 0xff;
            if (anInt7 > 0)
                anInt10 = (1000 * j) / (anInt7 * 256);
            method9(-14379);
        }
        if (anInt6 == -1)
            method3(-59);
    }

    public void method3(int i) {
        anInt6 = -2;
        System.out.println("Closing program");
        method8(false);
        if (i >= 0)
            anInt1 = 282;
        try {
            Thread.sleep(1000L);
        } catch (Exception _ex) {
        }
        try {
            System.exit(0);
            return;
        } catch (Throwable _ex) {
            return;
        }
    }

    public void method4(byte byte0, int i) {
        if (byte0 == 7)
            byte0 = 0;
        else
            return;
        anInt7 = 1000 / i;
    }

    public void start() {
        if (anInt6 >= 0)
            anInt6 = 0;
    }

    public void stop() {
        if (anInt6 >= 0)
            anInt6 = 4000 / anInt7;
    }

    public void destroy() {
        anInt6 = -1;
        try {
            Thread.sleep(5000L);
        } catch (Exception _ex) {
        }
        if (anInt6 == -1) {
            System.out.println("5 seconds expired, forcing kill");
            method3(-59);
        }
    }

    public void update(Graphics g) {
        if (aGraphics13 == null)
            aGraphics13 = g;
        aBoolean17 = true;
        method10(false);
    }

    public void paint(Graphics g) {
        if (aGraphics13 == null)
            aGraphics13 = g;
        aBoolean17 = true;
        method10(false);
    }

    public void mousePressed(MouseEvent mouseevent) {
        int i = mouseevent.getX();
        int j = mouseevent.getY();
        anInt18 = 0;
        anInt23 = i;
        anInt24 = j;
        if (mouseevent.isMetaDown()) {
            anInt22 = 2;
            anInt19 = 2;
        } else {
            anInt22 = 1;
            anInt19 = 1;
        }
        if (InputTracking.aBoolean103)
            InputTracking.method162(j, (byte) -58, i);
    }

    public void mouseReleased(MouseEvent mouseevent) {
        anInt18 = 0;
        anInt19 = 0;
        if (InputTracking.aBoolean103)
            InputTracking.method163(aBoolean3);
    }

    public void mouseClicked(MouseEvent mouseevent) {
    }

    public void mouseEntered(MouseEvent mouseevent) {
        if (InputTracking.aBoolean103)
            InputTracking.method169(-611);
    }

    public void mouseExited(MouseEvent mouseevent) {
        if (InputTracking.aBoolean103)
            InputTracking.method170((byte) 66);
    }

    public void mouseDragged(MouseEvent mouseevent) {
        int i = mouseevent.getX();
        int j = mouseevent.getY();
        anInt18 = 0;
        anInt20 = i;
        anInt21 = j;
        if (InputTracking.aBoolean103)
            InputTracking.method164(true, j, i);
    }

    public void mouseMoved(MouseEvent mouseevent) {
        int i = mouseevent.getX();
        int j = mouseevent.getY();
        anInt18 = 0;
        anInt20 = i;
        anInt21 = j;
        if (InputTracking.aBoolean103)
            InputTracking.method164(true, j, i);
    }

    public void keyPressed(KeyEvent keyevent) {
        anInt18 = 0;
        int i = keyevent.getKeyCode();
        int j = keyevent.getKeyChar();
        if (j < 30)
            j = 0;
        if (i == 37)
            j = 1;
        if (i == 39)
            j = 2;
        if (i == 38)
            j = 3;
        if (i == 40)
            j = 4;
        if (i == 17)
            j = 5;
        if (i == 8)
            j = 8;
        if (i == 127)
            j = 8;
        if (i == 9)
            j = 9;
        if (i == 10)
            j = 10;
        if (i >= 112 && i <= 123)
            j = (1008 + i) - 112;
        if (i == 36)
            j = 1000;
        if (i == 35)
            j = 1001;
        if (i == 33)
            j = 1002;
        if (i == 34)
            j = 1003;
        if (j > 0 && j < 128)
            anIntArray25[j] = 1;
        if (j > 4) {
            anIntArray26[anInt28] = j;
            anInt28 = anInt28 + 1 & 0x7f;
        }
        if (InputTracking.aBoolean103)
            InputTracking.method165(j, true);
    }

    public void keyReleased(KeyEvent keyevent) {
        anInt18 = 0;
        int i = keyevent.getKeyCode();
        char c = keyevent.getKeyChar();
        if (c < '\036')
            c = '\0';
        if (i == 37)
            c = '\001';
        if (i == 39)
            c = '\002';
        if (i == 38)
            c = '\003';
        if (i == 40)
            c = '\004';
        if (i == 17)
            c = '\005';
        if (i == 8)
            c = '\b';
        if (i == 127)
            c = '\b';
        if (i == 9)
            c = '\t';
        if (i == 10)
            c = '\n';
        if (c > 0 && c < '\200')
            anIntArray25[c] = 0;
        if (InputTracking.aBoolean103)
            InputTracking.method166(aByte4, c);
    }

    public void keyTyped(KeyEvent keyevent) {
    }

    public void focusGained(FocusEvent focusevent) {
        aBoolean17 = true;
        method10(false);
        if (InputTracking.aBoolean103)
            InputTracking.method167(aBoolean5);
    }

    public void focusLost(FocusEvent focusevent) {
        if (InputTracking.aBoolean103)
            InputTracking.method168((byte) 9);
    }

    public int method5(int i) {
        if (i != 6542)
            anInt1 = 230;
        int j = -1;
        if (anInt28 != anInt27) {
            j = anIntArray26[anInt27];
            anInt27 = anInt27 + 1 & 0x7f;
        }
        return j;
    }

    public void windowActivated(WindowEvent windowevent) {
    }

    public void windowClosed(WindowEvent windowevent) {
    }

    public void windowClosing(WindowEvent windowevent) {
        destroy();
    }

    public void windowDeactivated(WindowEvent windowevent) {
    }

    public void windowDeiconified(WindowEvent windowevent) {
    }

    public void windowIconified(WindowEvent windowevent) {
    }

    public void windowOpened(WindowEvent windowevent) {
    }

    public void method6() {
    }

    public void method7(byte byte0) {
        if (byte0 != 3) {
            for (int i = 1; i > 0; i++) ;
        }
    }

    public void method8(boolean flag) {
        if (flag)
            aBoolean5 = !aBoolean5;
    }

    public void method9(int i) {
        if (i != -14379)
            aBoolean3 = !aBoolean3;
    }

    public void method10(boolean flag) {
        if (flag) {
            for (int i = 1; i > 0; i++) ;
        }
    }

    public Component method11(int i) {
        return this;
    }

    public void startThread(Runnable runnable, int i) {
        Thread thread = new Thread(runnable);
        thread.start();
        thread.setPriority(i);
    }

    public void showProgress(byte byte0, int i, String s) {
        while (aGraphics13 == null) {
            aGraphics13 = method11(-36374).getGraphics();
            try {
                method11(-36374).repaint();
            } catch (Exception _ex) {
            }
            try {
                Thread.sleep(1000L);
            } catch (Exception _ex) {
            }
        }
        Font font = new Font("Helvetica", 1, 13);
        FontMetrics fontmetrics = method11(-36374).getFontMetrics(font);
        Font font1 = new Font("Helvetica", 0, 13);
        method11(-36374).getFontMetrics(font1);
        if (aBoolean17) {
            aGraphics13.setColor(Color.black);
            aGraphics13.fillRect(0, 0, anInt11, anInt12);
            aBoolean17 = false;
        }
        Color color = new Color(140, 17, 17);
        int j = anInt12 / 2 - 18;
        aGraphics13.setColor(color);
        aGraphics13.drawRect(anInt11 / 2 - 152, j, 304, 34);
        aGraphics13.fillRect(anInt11 / 2 - 150, j + 2, i * 3, 30);
        aGraphics13.setColor(Color.black);
        if (byte0 != -75) {
            return;
        } else {
            aGraphics13.fillRect((anInt11 / 2 - 150) + i * 3, j + 2, 300 - i * 3, 30);
            aGraphics13.setFont(font);
            aGraphics13.setColor(Color.white);
            aGraphics13.drawString(s, (anInt11 - fontmetrics.stringWidth(s)) / 2, j + 22);
            return;
        }
    }

    public GameShell() {
        anInt1 = 3073;
        aBoolean2 = false;
        aBoolean3 = true;
        aByte4 = -63;
        aBoolean5 = false;
        anInt7 = 20;
        anInt8 = 1;
        aLongArray9 = new long[10];
        aSpriteArray15 = new Sprite[6];
        aBoolean17 = true;
        anIntArray25 = new int[128];
        anIntArray26 = new int[128];
    }

    public int anInt1;
    public boolean aBoolean2;
    public boolean aBoolean3;
    public byte aByte4;
    public boolean aBoolean5;
    public int anInt6;
    public int anInt7;
    public int anInt8;
    public long[] aLongArray9;
    public int anInt10;
    public int anInt11;
    public int anInt12;
    public Graphics aGraphics13;
    public FrameBuffer aFrameBuffer_14;
    public Sprite[] aSpriteArray15;
    public GameFrame aGameFrame__16;
    public boolean aBoolean17;
    public int anInt18;
    public int anInt19;
    public int anInt20;
    public int anInt21;
    public int anInt22;
    public int anInt23;
    public int anInt24;
    public int[] anIntArray25;
    public int[] anIntArray26;
    public int anInt27;
    public int anInt28;
    public static int anInt29;
}
