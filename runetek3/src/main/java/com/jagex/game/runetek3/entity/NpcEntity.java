package com.jagex.game.runetek3.entity;

// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

import com.jagex.game.runetek3.config.NpcType;
import com.jagex.game.runetek3.config.SeqType;
import com.jagex.game.runetek3.config.SpotAnimType;
import com.jagex.game.runetek3.graphics.model.Model;

public class NpcEntity extends PathingEntity {

    public NpcType info;

    public NpcEntity() {
    }

    public Model getDrawMethod() {
        if (info == null) {
            return null;
        }

        if (super.spotAnimIndex == -1 || super.spotAnimFrame == -1) {
            return getModel();
        }

        Model model = getModel();
        SpotAnimType spotAnim = SpotAnimType.instances[super.spotAnimIndex];

        Model spotAnimModel = new Model(-428, true, spotAnim.getModel(), true, false, !spotAnim.disposeAlpha);
        spotAnimModel.translate(0, 0, -super.spotAnimOffsetY);

        spotAnimModel.applyGroups();
        spotAnimModel.applyFrame(spotAnim.seq.primaryFrames[super.spotAnimFrame]);

        spotAnimModel.skinTriangle = null;
        spotAnimModel.labelVertices = null;

        spotAnimModel.applyLighting(64, 850, -30, -50, -30, true);

        Model[] models = {model, spotAnimModel};
        Model animated = new Model(true, true, models, 2);

        if (info.size == 1) {
            animated.pickable = true;
        }
        return animated;
    }

    public Model getModel() {
        if (super.primarySeq >= 0 && super.primarySeqDelay == 0) {
            int frame1 = SeqType.instances[super.primarySeq].primaryFrames[super.primarySeqFrame];
            int frame2 = -1;

            if (super.secondarySeq >= 0 && super.secondarySeq != super.standSeq) {
                frame2 = SeqType.instances[super.secondarySeq].primaryFrames[super.secondarySeqFrame];
            }
            return info.getModel(frame1, frame2, SeqType.instances[super.primarySeq].labelGroups);
        }

        int frame = -1;

        if (super.secondarySeq >= 0) {
            frame = SeqType.instances[super.secondarySeq].primaryFrames[super.secondarySeqFrame];
        }

        Model model = info.getModel(frame, -1, null);
        super.height = model.maxBoundY;
        return model;
    }

    public boolean method411(int i) {
        return info != null;
    }


}
