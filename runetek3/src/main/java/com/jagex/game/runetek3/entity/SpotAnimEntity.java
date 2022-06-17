package com.jagex.game.runetek3.entity;

// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

import com.jagex.game.runetek3.config.SpotAnimType;
import com.jagex.game.runetek3.graphics.model.Model;

public class SpotAnimEntity extends Entity {

    public SpotAnimType spotAnim;
    public int anInt1199;
    public int anInt1200;
    public int anInt1201;
    public int anInt1202;
    public int anInt1203;
    public int seqFrame;
    public int frameCycle;
    public boolean finished;

    public SpotAnimEntity(int i, int j, int k, int l, int spotAnimIndex, int j1, int k1) {
        spotAnim = SpotAnimType.instances[spotAnimIndex];


        anInt1200 = k1;
        anInt1201 = k;
        anInt1202 = i;
        anInt1203 = j;
        anInt1199 = j1 + l;
        finished = false;
    }

    public void method408(int cycle) {
        for (frameCycle += cycle; frameCycle > spotAnim.anim.frameDelay[seqFrame]; ) {
            frameCycle -= spotAnim.anim.frameDelay[seqFrame] + 1;
            seqFrame++;

            if (seqFrame >= spotAnim.anim.frameCount) {
                seqFrame = 0;
                finished = true;
            }
        }

    }

    public Model getDrawMethod() {

        Model model = new Model(-428, true, spotAnim.getModel(), true, false, !spotAnim.disposeAlpha);
        if (!finished) {
            model.applyGroups();
            model.applyFrame(spotAnim.anim.primaryFrames[seqFrame]);
            model.skinTriangle = null;
            model.labelVertices = null;
        }
        model.applyLighting(64, 850, -30, -50, -30, true);
        return model;
    }
}
