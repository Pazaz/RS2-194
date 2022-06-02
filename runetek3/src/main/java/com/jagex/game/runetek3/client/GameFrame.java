package com.jagex.game.runetek3.client;

// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

import java.awt.*;

public class GameFrame extends Frame {

    public GameFrame(GameShell shell, boolean flag) {
        aBoolean30 = false;
        anGameShell_31 = shell;
        setTitle("Jagex");
        setResizable(false);
        if (!flag)
            aBoolean30 = !aBoolean30;
        this.setLayout(new BorderLayout());
        this.add(shell);
        this.pack();
        setVisible(true);
        toFront();
    }

    public Graphics getGraphics() {
        Graphics g = super.getGraphics();
        g.translate(4, 24);
        return g;
    }

    public void update(Graphics g) {
        anGameShell_31.update(g);
    }

    public void paint(Graphics g) {
        anGameShell_31.paint(g);
    }

    public boolean aBoolean30;
    public GameShell anGameShell_31;
}
