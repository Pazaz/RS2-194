package com.jagex.game.runetek3.config;

import com.jagex.core.io.Buffer;
import com.jagex.core.io.FileArchive;
import com.jagex.game.runetek3.graphics.seq.SeqFrame;

public class SeqType {

    public static void decode(FileArchive archive) {
        Buffer buffer = new Buffer(archive.read(null, "seq.dat"));
        count = buffer.g2();
        if (instances == null) {
            instances = new SeqType[count];
        }
        for (int i = 0; i < count; i++) {
            if (instances[i] == null) {
                instances[i] = new SeqType();
            }
            instances[i].decode(buffer);
        }

    }

    public void decode(Buffer buffer) {
        do {
            int opcode = buffer.g1();
            if (opcode == 0) {
                break;
            }
            if (opcode == 1) {
                frameCount = buffer.g1();
                primaryFrames = new int[frameCount];
                secondaryFrames = new int[frameCount];
                frameDelay = new int[frameCount];

                for (int i = 0; i < frameCount; i++) {
                    primaryFrames[i] = buffer.g2();
                    secondaryFrames[i] = buffer.g2();
                    if (secondaryFrames[i] == 65535) {
                        secondaryFrames[i] = -1;
                    }
                    frameDelay[i] = buffer.g2();
                    if (frameDelay[i] == 0) {
                        frameDelay[i] = SeqFrame.instances[primaryFrames[i]].delay;
                    }
                    if (frameDelay[i] == 0) {
                        frameDelay[i] = 1;
                    }
                }

            } else if (opcode == 2) {
                replayoff = buffer.g2();
            } else if (opcode == 3) {
                int i = buffer.g1();

                labelGroups = new int[i + 1];
                for (int j = 0; j < i; j++) {
                    labelGroups[j] = buffer.g1();
                }
                labelGroups[i] = 9999999;
            } else if (opcode == 4) {
                stretches = buffer.g2();
            } else if (opcode == 5) {
                priority = buffer.g1();
            } else if (opcode == 6) {
                mainhand = buffer.g2();
            } else if (opcode == 7) {
                offhand = buffer.g2();
            } else if (opcode == 8) {
                replaycount = buffer.g1();
            } else {
                System.out.println("Error unrecognised seq config code: " + opcode);
            }
        } while (true);

        if (frameCount == 0) {
            frameCount = 1;
            primaryFrames = new int[1];
            primaryFrames[0] = -1;
            secondaryFrames = new int[1];
            secondaryFrames[0] = -1;
            frameDelay = new int[1];
            frameDelay[0] = -1;
        }
    }

    public SeqType() {
        replayoff = -1;
        priority = 5;
        mainhand = -1;
        offhand = -1;
        replaycount = 99;
    }

    public static int count;
    public static SeqType[] instances;
    public int frameCount;
    public int[] primaryFrames;
    public int[] secondaryFrames;
    public int[] frameDelay;
    public int replayoff;
    public int[] labelGroups;
    public int stretches;
    public int priority;
    public int mainhand;
    public int offhand;
    public int replaycount;

}
