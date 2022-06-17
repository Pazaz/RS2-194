package rs2;

public class ClientProt {

    public static final int[] SCRAMBLED = {
        231, 69, 239, 142, 243, 206, 131, 129, 37, 162,
        149, 54, 20, 141, 5, 70, 120, 178, 68, 180,
        28, 97, 235, 230, 119, 186, 163, 135, 252, 32,
        229, 165, 145, 85, 133, 34, 181, 104, 136, 152,
        169, 203, 72, 224, 171, 88, 10, 188, 179, 18,
        176, 60, 79, 191, 254, 101, 13, 139, 14, 112,
        107, 245, 220, 17, 21, 144, 199, 42, 38, 98,
        159, 151, 44, 241, 250, 66, 130, 22, 196, 166,
        160, 67, 123, 52, 207, 240, 217, 6, 103, 158,
        93, 80, 237, 92, 76, 95, 82, 246, 212, 125,
        117, 43, 218, 154, 150, 16, 215, 1, 106, 146,
        164, 228, 87, 157, 46, 126, 19, 187, 61, 137,
        210, 175, 202, 73, 167, 3, 30, 77, 118, 58,
        15, 84, 90, 35, 248, 2, 184, 233, 105, 161,
        134, 40, 83, 23, 109, 197, 192, 234, 208, 173,
        156, 221, 7, 45, 91, 211, 41, 78, 132, 153,
        100, 115, 183, 75, 31, 57, 0, 200, 147, 182,
        247, 121, 148, 216, 204, 155, 74, 128, 56, 94,
        185, 59, 25, 114, 190, 209, 65, 226, 4, 223,
        11, 36, 62, 236, 201, 251, 110, 12, 9, 33,
        113, 174, 47, 27, 255, 8, 86, 222, 29, 89,
        189, 214, 26, 108, 48, 24, 143, 99, 50, 198,
        194, 39, 71, 227, 63, 111, 138, 249, 102, 122,
        244, 168, 140, 232, 213, 177, 49, 253, 55, 127,
        193, 170, 116, 51, 195, 219, 96, 172, 64, 124,
        238, 81, 242, 53, 225, 205, 0
    };

    public static final int[] PACKET_LENGTHS = new int[256];

    // anticheat_* helps detect reflection bots
    public static final int ANTICHEAT_DRAW = 0;
    public static final int ANTICHEAT_UPDATE = 0;
    public static final int ANTICHEAT_UPDATE2 = 0;
    public static final int ANTICHEAT_UPDATE_LOCS = 0;
    public static final int ANTICHEAT_UPDATE_PLAYERS = 0;
    public static final int ANTICHEAT_SIDEBAR_INPUT = 0;

    public static final int IF_BUTTON = 167; // clicking an interface button
    public static final int IF_BUTTON1 = 0; // interface options 1-5 on an obj
    public static final int IF_BUTTON2 = 0;
    public static final int IF_BUTTON3 = 0;
    public static final int IF_BUTTON4 = 0;
    public static final int ANTICHEAT_IF_BUTTON4 = 0;
    public static final int IF_BUTTON5 = 0;
    public static final int ANTICHEAT_IF_BUTTON5 = 0;
    public static final int IF_BUTTOND = 0; // dragging an inv obj to another slot
    public static final int IF_FLASHING_TAB = 0; // todo name: clicked flashing tab during tutorial
    public static final int IF_DESIGN = 134; // todo name: finished customizing character design
    public static final int CLOSE_MODAL = 122; // closing an interface
    public static final int RESUME_PAUSEBUTTON = 0; // "Continue" button dialog
    public static final int RESUME_P_COUNTDIALOG = 0; // "Enter amount" dialog

    public static final int OPNPC1 = 0; // npc options 1-5
    public static final int OPNPC2 = 0;
    public static final int OPNPC3 = 0;
    public static final int ANTICHEAT_OPNPC3 = 0;
    public static final int OPNPC4 = 0;
    public static final int OPNPC5 = 0;
    public static final int ANTICHEAT_OPNPC5 = 0;
    public static final int OPNPCU = 0; // using an item on a npc
    public static final int OPNPCT = 0; // targeting a npc with a spell

    public static final int OPLOC1 = 0; // loc (object) options 1-5
    public static final int OPLOC2 = 0;
    public static final int OPLOC3 = 0;
    public static final int OPLOC4 = 0;
    public static final int ANTICHEAT_OPLOC4 = 0;
    public static final int OPLOC5 = 0;
    public static final int ANTICHEAT_OPLOC5 = 0;
    public static final int OPLOCU = 0; // using an item on a loc
    public static final int OPLOCT = 0; // targeting a loc with a spell

    public static final int OPOBJ1 = 0; // objstack (ground item) options 1-5
    public static final int OPOBJ2 = 0;
    public static final int OPOBJ3 = 0;
    public static final int OPOBJ4 = 0;
    public static final int OPOBJ5 = 0;
    public static final int OPOBJU = 0; // using an item on an objstack
    public static final int OPOBJT = 0; // targeting an objstack with a spell

    public static final int OPHELD1 = 0; // inv obj (items in inventory) options 1-5
    public static final int ANTICHEAT_OPHELD1 = 0;
    public static final int OPHELD2 = 0;
    public static final int OPHELD3 = 0;
    public static final int OPHELD4 = 0;
    public static final int ANTICHEAT_OPHELD4 = 0;
    public static final int OPHELD5 = 0;
    public static final int OPHELDU = 0; // using an item on an inv obj
    public static final int OPHELDT = 0; // targeting a spell on an inv obj

    public static final int OPPLAYER1 = 0; // player options 1-5
    public static final int OPPLAYER2 = 0;
    public static final int OPPLAYER3 = 0;
    public static final int ANTICHEAT_OPPLAYER3 = 0;
    public static final int OPPLAYER4 = 0;
    public static final int OPPLAYERU = 0; // using an item on a player
    public static final int OPPLAYERT = 0; // targeting a spell on a player

    public static final int CHAT_SETMODE = 0;
    public static final int BUG_REPORT = 0; // todo: confirm if this is report abuse
    public static final int MESSAGE_PUBLIC = 0;
    public static final int MESSAGE_PRIVATE = 0;
    public static final int FRIENDLIST_ADD = 0;
    public static final int FRIENDLIST_DEL = 0;
    public static final int IGNORELIST_ADD = 0;
    public static final int IGNORELIST_DEL = 0;

    public static final int MOVE_MINIMAPCLICK = 0;
    public static final int MOVE_GAMECLICK = 204;
    public static final int MOVE_OPCLICK = 0; // todo: sent when an OP is selected >1 tile away, what's the real name?

    public static final int EVENT_CAMERA_POSITION = 0;
    public static final int CLIENT_CHEAT = 237;
    public static final int NO_TIMEOUT = 87;
    public static final int IDLE_TIMER = 0; // todo name: no input, notify the server to log out
    public static final int MAP_REQUEST_AREAS = 188; // todo name: request missing map files
    public static final int EVENT_TRACKING = 0; // todo name: bot detection, all inputs get recorded in a buffer and sent up

    static {
//        PACKET_LENGTHS[ANTICHEAT_DRAW] = -1;
//        PACKET_LENGTHS[ANTICHEAT_UPDATE] = 3;
//        PACKET_LENGTHS[ANTICHEAT_UPDATE2] = 4;
//        PACKET_LENGTHS[ANTICHEAT_UPDATE_LOCS] = 0;
//        PACKET_LENGTHS[ANTICHEAT_UPDATE_PLAYERS] = -1;
//        PACKET_LENGTHS[ANTICHEAT_SIDEBAR_INPUT] = 1;

        PACKET_LENGTHS[IF_BUTTON] = 2;
//        PACKET_LENGTHS[IF_BUTTON1] = 6;
//        PACKET_LENGTHS[IF_BUTTON2] = 6;
//        PACKET_LENGTHS[IF_BUTTON3] = 6;
//        PACKET_LENGTHS[IF_BUTTON4] = 6;
//        PACKET_LENGTHS[ANTICHEAT_IF_BUTTON4] = 1;
//        PACKET_LENGTHS[IF_BUTTON5] = 6;
//        PACKET_LENGTHS[ANTICHEAT_IF_BUTTON5] = 4;
//        PACKET_LENGTHS[IF_BUTTOND] = 6;
//        PACKET_LENGTHS[IF_FLASHING_TAB] = 1;
        PACKET_LENGTHS[IF_DESIGN] = 13;
        PACKET_LENGTHS[CLOSE_MODAL] = 0;
//        PACKET_LENGTHS[RESUME_PAUSEBUTTON] = 2;
//        PACKET_LENGTHS[RESUME_P_COUNTDIALOG] = 4;

//        PACKET_LENGTHS[OPNPC1] = 2;
//        PACKET_LENGTHS[OPNPC2] = 2;
//        PACKET_LENGTHS[OPNPC3] = 2;
//        PACKET_LENGTHS[ANTICHEAT_OPNPC3] = 4;
//        PACKET_LENGTHS[OPNPC4] = 2;
//        PACKET_LENGTHS[OPNPC5] = 2;
//        PACKET_LENGTHS[ANTICHEAT_OPNPC5] = 2;
//        PACKET_LENGTHS[OPNPCU] = 8;
//        PACKET_LENGTHS[OPNPCT] = 4;

//        PACKET_LENGTHS[OPLOC1] = 6;
//        PACKET_LENGTHS[OPLOC2] = 6;
//        PACKET_LENGTHS[OPLOC3] = 6;
//        PACKET_LENGTHS[OPLOC4] = 6;
//        PACKET_LENGTHS[ANTICHEAT_OPLOC4] = 4;
//        PACKET_LENGTHS[OPLOC5] = 6;
//        PACKET_LENGTHS[ANTICHEAT_OPLOC5] = 4;
//        PACKET_LENGTHS[OPLOCU] = 12;
//        PACKET_LENGTHS[OPLOCT] = 8;

//        PACKET_LENGTHS[OPOBJ1] = 6;
//        PACKET_LENGTHS[OPOBJ2] = 6;
//        PACKET_LENGTHS[OPOBJ3] = 6;
//        PACKET_LENGTHS[OPOBJ4] = 6;
//        PACKET_LENGTHS[OPOBJ5] = 6;
//        PACKET_LENGTHS[OPOBJU] = 12;
//        PACKET_LENGTHS[OPOBJT] = 8;

//        PACKET_LENGTHS[OPHELD1] = 6;
//        PACKET_LENGTHS[ANTICHEAT_OPHELD1] = 3;
//        PACKET_LENGTHS[OPHELD2] = 6;
//        PACKET_LENGTHS[OPHELD3] = 6;
//        PACKET_LENGTHS[OPHELD4] = 6;
//        PACKET_LENGTHS[ANTICHEAT_OPHELD4] = 0;
//        PACKET_LENGTHS[OPHELD5] = 6;
//        PACKET_LENGTHS[OPHELDU] = 12;
//        PACKET_LENGTHS[OPHELDT] = 8;

//        PACKET_LENGTHS[OPPLAYER1] = 2;
//        PACKET_LENGTHS[OPPLAYER2] = 2;
//        PACKET_LENGTHS[OPPLAYER3] = 2;
//        PACKET_LENGTHS[ANTICHEAT_OPPLAYER3] = 2;
//        PACKET_LENGTHS[OPPLAYER4] = 2;
//        PACKET_LENGTHS[OPPLAYERU] = 8;
//        PACKET_LENGTHS[OPPLAYERT] = 4;

//        PACKET_LENGTHS[CHAT_SETMODE] = 3;
//        PACKET_LENGTHS[BUG_REPORT] = 10;
//        PACKET_LENGTHS[MESSAGE_PUBLIC] = -1;
//        PACKET_LENGTHS[MESSAGE_PRIVATE] = -1;
//        PACKET_LENGTHS[FRIENDLIST_ADD] = 8;
//        PACKET_LENGTHS[FRIENDLIST_DEL] = 8;
//        PACKET_LENGTHS[IGNORELIST_ADD] = 8;
//        PACKET_LENGTHS[IGNORELIST_DEL] = 8;

        PACKET_LENGTHS[MOVE_GAMECLICK] = -1;
//        PACKET_LENGTHS[MOVE_MINIMAPCLICK] = -1;
//        PACKET_LENGTHS[MOVE_OPCLICK] = -1;

//        PACKET_LENGTHS[EVENT_CAMERA_POSITION] = 6;
        PACKET_LENGTHS[CLIENT_CHEAT] = -1;
        PACKET_LENGTHS[NO_TIMEOUT] = 0;
//        PACKET_LENGTHS[IDLE_TIMER] = 0;
        PACKET_LENGTHS[MAP_REQUEST_AREAS] = -1;
//        PACKET_LENGTHS[EVENT_TRACKING] = -2;
    }

}
