package com.jagex.game.runetek3.graphics;

// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

import java.awt.*;
import java.awt.image.*;

public class FrameBuffer
        implements ImageProducer, ImageObserver {

    public FrameBuffer(int i, byte byte0, Component component, int j) {
        aBoolean366 = true;
        aBoolean367 = false;
        anInt369 = j;
        anInt370 = i;
        anIntArray368 = new int[j * i];
        aColorModel371 = new DirectColorModel(32, 0xff0000, 65280, 255);
        anImage373 = component.createImage(this);
        method236();
        component.prepareImage(anImage373, this);
        method236();
        component.prepareImage(anImage373, this);
        method236();
        component.prepareImage(anImage373, this);
        if (byte0 != -58)
            aBoolean367 = !aBoolean367;
        method234(-510);
    }

    public void method234(int i) {
        while (i >= 0)
            return;
        Draw2D.method329(anInt369, anIntArray368, anInt370, -810);
    }

    public void method235(int i, Graphics g, int j, byte byte0) {
        method236();
        if (byte0 != 7)
            aBoolean366 = !aBoolean366;
        g.drawImage(anImage373, i, j, this);
    }

    public synchronized void addConsumer(ImageConsumer imageconsumer) {
        anImageConsumer372 = imageconsumer;
        imageconsumer.setDimensions(anInt369, anInt370);
        imageconsumer.setProperties(null);
        imageconsumer.setColorModel(aColorModel371);
        imageconsumer.setHints(14);
    }

    public synchronized boolean isConsumer(ImageConsumer imageconsumer) {
        return anImageConsumer372 == imageconsumer;
    }

    public synchronized void removeConsumer(ImageConsumer imageconsumer) {
        if (anImageConsumer372 == imageconsumer)
            anImageConsumer372 = null;
    }

    public void startProduction(ImageConsumer imageconsumer) {
        addConsumer(imageconsumer);
    }

    public void requestTopDownLeftRightResend(ImageConsumer imageconsumer) {
        System.out.println("TDLR");
    }

    public synchronized void method236() {
        if (anImageConsumer372 == null) {
            return;
        } else {
            anImageConsumer372.setPixels(0, 0, anInt369, anInt370, aColorModel371, anIntArray368, 0, anInt369);
            anImageConsumer372.imageComplete(2);
            return;
        }
    }

    public boolean imageUpdate(Image image, int i, int j, int k, int l, int i1) {
        return true;
    }

    public boolean aBoolean366;
    public boolean aBoolean367;
    public int[] anIntArray368;
    public int anInt369;
    public int anInt370;
    public ColorModel aColorModel371;
    public ImageConsumer anImageConsumer372;
    public Image anImage373;
}
