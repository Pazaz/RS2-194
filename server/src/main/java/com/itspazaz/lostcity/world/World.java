package com.itspazaz.lostcity.world;

import com.itspazaz.lostcity.network.Connection;
import com.itspazaz.lostcity.utils.Position;

import java.nio.channels.SocketChannel;
import java.util.HashMap;
import java.util.Map;

public class World {
    public static final Map<SocketChannel, Connection> players = new HashMap<SocketChannel, Connection>();

    public static long tick = 0;

    public static void tick() {
        System.out.println("Tick " + tick + " (" + players.size() + " players)");
        for (Connection con : players.values()) {
            try {
                if (!con.connected) {
                    con.player.save();
                    players.remove(con.channel);
                    continue;
                }

                con.out.pos = 0;
                con.in.pos = 0;

                if (Math.abs(con.player.lastLoadedX - con.player.entity.x) >= 36 || Math.abs(con.player.lastLoadedZ - con.player.entity.z) >= 36) {
                    con.player.loaded = false;
                    con.player.loading = false;
                }

                if (!con.player.loaded && !con.player.loading) {
                    con.player.sendLoadArea();
                }

                con.player.sendPlayerInfo();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        tick++;
    }
}
