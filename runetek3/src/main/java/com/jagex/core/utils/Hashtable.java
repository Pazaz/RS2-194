package com.jagex.core.utils;

// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

import rs2.sign.signlink;

public class Hashtable {

    public Hashtable(byte byte0, int i) {
        anInt499 = 647;
        anInt500 = i;
        if (byte0 == 1)
            byte0 = 0;
        else
            throw new NullPointerException();
        aNodeArray501 = new Node[i];
        for (int j = 0; j < i; j++) {
            Node class35 = aNodeArray501[j] = new Node();
            class35.aNode_509 = class35;
            class35.aNode_510 = class35;
        }

    }

    public Node get(long l) {
        Node class35 = aNodeArray501[(int) (l & (long) (anInt500 - 1))];
        for (Node class35_1 = class35.aNode_509; class35_1 != class35; class35_1 = class35_1.aNode_509)
            if (class35_1.aLong508 == l)
                return class35_1;

        return null;
    }

    public void put(Node class35, int i, long l) {
        try {
            if (class35.aNode_510 != null)
                class35.unlink();
            Node class35_1 = aNodeArray501[(int) (l & (long) (anInt500 - 1))];
            class35.aNode_510 = class35_1.aNode_510;
            class35.aNode_509 = class35_1;
            class35.aNode_510.aNode_509 = class35;
            for (class35.aNode_509.aNode_510 = class35; i >= 0; )
                return;

            class35.aLong508 = l;
            return;
        } catch (RuntimeException runtimeexception) {
            signlink.reporterror("79247, " + class35 + ", " + i + ", " + l + ", " + runtimeexception);
        }
        throw new RuntimeException();
    }

    public int anInt499;
    public int anInt500;
    public Node[] aNodeArray501;
}
