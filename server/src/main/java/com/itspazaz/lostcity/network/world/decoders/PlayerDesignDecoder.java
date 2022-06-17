package com.itspazaz.lostcity.network.world.decoders;

import com.itspazaz.lostcity.network.Connection;
import com.itspazaz.lostcity.network.Decoder;
import com.jagex.core.io.Buffer;
import com.jagex.game.runetek3.config.IdkType;

public class PlayerDesignDecoder extends Decoder {

    @Override
    public void execute(Connection con, Buffer data) {
        con.player.entity.gender = data.g1();

        int[] style = new int[7];
        for (int i = 0; i < style.length; i++) {
            style[i] = data.g1b();
        }
        con.player.entity.body[5] = style[0];
        con.player.entity.body[10] = style[1];
        con.player.entity.body[4] = style[2];
        con.player.entity.body[6] = style[3];
        con.player.entity.body[7] = style[4];
        con.player.entity.body[8] = style[5];
        con.player.entity.body[9] = style[6];

        int [] color = new int[5];
        for (int i = 0; i < color.length; i++) {
            con.player.entity.colors[i] = data.g1();
        }

        con.player.appearanceUpdated = true;
    }

}
