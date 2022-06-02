package com.itspazaz.lostcity.network.world.decoders;

import com.itspazaz.lostcity.network.Connection;
import com.itspazaz.lostcity.network.Decoder;
import com.jagex.core.io.Buffer;

public class MoveGameClickDecoder extends Decoder {

    @Override
    public void execute(Connection con, Buffer data) {
        int endX = data.g2();
        int endZ = data.g2();

        int count = data.available() / 2;
        int[] steps = new int[count + 1];
        steps[0] = (endX << 16) | endZ;
        for (int i = 1; i <= count; ++i) {
            int x = data.g1b();
            int z = data.g1b();
            steps[i] = (x + endX) << 16 | (z + endZ);
        }

        // reverse
        for (int left = 0, right = steps.length - 1; left < right; left++, right--) {
            int temp = steps[left];
            steps[left] = steps[right];
            steps[right] = temp;
        }

        con.player.steps = steps;
        con.player.step = steps.length - 1;
    }

}
