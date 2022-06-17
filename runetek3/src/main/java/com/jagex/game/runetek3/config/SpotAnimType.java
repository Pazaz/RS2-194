package com.jagex.game.runetek3.config;

import com.jagex.core.io.Buffer;
import com.jagex.core.io.FileArchive;
import com.jagex.core.utils.Cache;
import com.jagex.game.runetek3.graphics.model.Model;

public class SpotAnimType {

    public static void decode(FileArchive archive) {
        Buffer buffer = new Buffer(archive.read(null, "spotanim.dat"));
        count = buffer.g2();
        if (instances == null)
            instances = new SpotAnimType[count];
        for (int i = 0; i < count; i++) {
            if (instances[i] == null) {
                instances[i] = new SpotAnimType();
            }
            instances[i].id = i;
            instances[i].decode(buffer);
        }
    }

    public void decode(Buffer buffer) {
        while (true) {
            int opcode = buffer.g1();
            if (opcode == 0) {
                return;
            }

            if (opcode == 1) {
                model = buffer.g2();
            } else if (opcode == 2) {
                anim = SeqType.instances[buffer.g2()];
            } else if (opcode == 3) {
                disposeAlpha = true;
            } else if (opcode >= 40 && opcode < 50) {
                recol_s[opcode - 40] = buffer.g2();
            } else if (opcode >= 50 && opcode < 60) {
                recol_d[opcode - 50] = buffer.g2();
            } else {
                System.out.println("Error unrecognised spotanim config code: " + opcode);
            }
        }
    }

    public Model getModel() {
        Model model = (Model) models.get(id);

        if (model != null) {
            return model;
        }

        model = new Model(this.model);

        for (int i = 0; i < 6; i++) {
            if (recol_s[0] != 0) {
                model.recolor(recol_s[i], recol_d[i]);
            }
        }

        models.put(id, model);
        return model;
    }

    public SpotAnimType() {
        disposeAlpha = false;
        recol_s = new int[6];
        recol_d = new int[6];
    }

    public static int count;
    public static SpotAnimType[] instances;
    public int id;
    public int model;
    public SeqType anim;
    public boolean disposeAlpha;
    public int[] recol_s;
    public int[] recol_d;
    public static Cache models = new Cache(30);

}
