package com.jagex.core.utils;

// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

public class LinkedList {

    public LinkedList(int i) {
        anInt334 = 962;
        aBoolean335 = true;
        anInt336 = 947;
        aNode_337 = new Node();
        aNode_337.aNode_509 = aNode_337;
        aNode_337.aNode_510 = aNode_337;
        if (i < 5 || i > 5)
            throw new NullPointerException();
        else
            return;
    }

    public void pushNext(Node class35) {
        if (class35.aNode_510 != null)
            class35.method303();
        class35.aNode_510 = aNode_337.aNode_510;
        class35.aNode_509 = aNode_337;
        class35.aNode_510.aNode_509 = class35;
        class35.aNode_509.aNode_510 = class35;
    }

    public void method225(Node class35, int i) {
        if (class35.aNode_510 != null)
            class35.method303();
        class35.aNode_510 = aNode_337;
        class35.aNode_509 = aNode_337.aNode_509;
        if (i != 0) {
            return;
        } else {
            class35.aNode_510.aNode_509 = class35;
            class35.aNode_509.aNode_510 = class35;
            return;
        }
    }

    public Node poll() {
        Node class35 = aNode_337.aNode_509;
        if (class35 == aNode_337) {
            return null;
        } else {
            class35.method303();
            return class35;
        }
    }

    public Node method227() {
        Node class35 = aNode_337.aNode_509;
        if (class35 == aNode_337) {
            aNode_338 = null;
            return null;
        } else {
            aNode_338 = class35.aNode_509;
            return class35;
        }
    }

    public Node method228(int i) {
        Node class35 = aNode_337.aNode_510;
        if (class35 == aNode_337) {
            aNode_338 = null;
            return null;
        }
        aNode_338 = class35.aNode_510;
        if (i < 8 || i > 8)
            anInt336 = -94;
        return class35;
    }

    public Node method229(int i) {
        Node class35 = aNode_338;
        if (i != 35239)
            anInt336 = -229;
        if (class35 == aNode_337) {
            aNode_338 = null;
            return null;
        } else {
            aNode_338 = class35.aNode_509;
            return class35;
        }
    }

    public Node method230(boolean flag) {
        Node class35 = aNode_338;
        if (class35 == aNode_337) {
            aNode_338 = null;
            return null;
        }
        aNode_338 = class35.aNode_510;
        if (!flag) {
            for (int i = 1; i > 0; i++) ;
        }
        return class35;
    }

    public void method231() {
        do {
            Node class35 = aNode_337.aNode_509;
            if (class35 == aNode_337)
                return;
            class35.method303();
        } while (true);
    }

    public int anInt334;
    public boolean aBoolean335;
    public int anInt336;
    public Node aNode_337;
    public Node aNode_338;
}
