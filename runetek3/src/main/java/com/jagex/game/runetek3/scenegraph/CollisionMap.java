package com.jagex.game.runetek3.scenegraph;

public class CollisionMap {

    public static final int OPEN = 0x0;
    public static final int CLOSED = 0xFFFFFF;

    public static final int WALL_NORTHWEST = 0x1;
    public static final int WALL_NORTH = 0x2;
    public static final int WALL_NORTHEAST = 0x4;
    public static final int WALL_EAST = 0x8;
    public static final int WALL_SOUTHEAST = 0x10;
    public static final int WALL_SOUTH = 0x20;
    public static final int WALL_SOUTHWEST = 0x40;
    public static final int WALL_WEST = 0x80;

    public static final int OCCUPIED_TILE = 0x100;

    public static final int BLOCKED_NORTHWEST = 0x200;
    public static final int BLOCKED_NORTH = 0x400;
    public static final int BLOCKED_NORTHEAST = 0x800;
    public static final int BLOCKED_EAST = 0x1000;
    public static final int BLOCKED_SOUTHEAST = 0x2000;
    public static final int BLOCKED_SOUTH = 0x4000;
    public static final int BLOCKED_SOUTHWEST = 0x8000;
    public static final int BLOCKED_WEST = 0x10000;

    public static final int SOLID = 0x20000;
    public static final int FLAG_UNUSED1 = 0x80000;
    public static final int BLOCKED_TILE = 0x200000;

    public boolean aBoolean37;

    public int anInt39;
    public int anInt40;
    public int x;
    public int z;
    public int[][] flags;

    public CollisionMap(int x, int z) {
        this.x = x;
        this.z = z;
        flags = new int[this.x][this.z];
        reset();
    }

    public void reset() {
        for (int x = 0; x < this.x; x++) {
            for (int z = 0; z < this.z; z++) {
                if (x == 0 || z == 0 || x == this.x - 1 || z == this.z - 1) {
                    flags[x][z] = CLOSED;
                } else {
                    flags[x][z] = OPEN;
                }
            }
        }
    }

    public void method122(int i, int j, int k, int l, boolean flag) {
        l -= anInt39;
        j -= anInt40;
        if (i == 0) {
            if (k == 0) {
                method125(l, j, 128);
                method125(l - 1, j, 8);
            }
            if (k == 1) {
                method125(l, j, 2);
                method125(l, j + 1, 32);
            }
            if (k == 2) {
                method125(l, j, 8);
                method125(l + 1, j, 128);
            }
            if (k == 3) {
                method125(l, j, 32);
                method125(l, j - 1, 2);
            }
        }
        if (i == 1 || i == 3) {
            if (k == 0) {
                method125(l, j, 1);
                method125(l - 1, j + 1, 16);
            }
            if (k == 1) {
                method125(l, j, 4);
                method125(l + 1, j + 1, 64);
            }
            if (k == 2) {
                method125(l, j, 16);
                method125(l + 1, j - 1, 1);
            }
            if (k == 3) {
                method125(l, j, 64);
                method125(l - 1, j - 1, 4);
            }
        }
        if (i == 2) {
            if (k == 0) {
                method125(l, j, 130);
                method125(l - 1, j, 8);
                method125(l, j + 1, 32);
            }
            if (k == 1) {
                method125(l, j, 10);
                method125(l, j + 1, 32);
                method125(l + 1, j, 128);
            }
            if (k == 2) {
                method125(l, j, 40);
                method125(l + 1, j, 128);
                method125(l, j - 1, 2);
            }
            if (k == 3) {
                method125(l, j, 160);
                method125(l, j - 1, 2);
                method125(l - 1, j, 8);
            }
        }
        if (flag) {
            if (i == 0) {
                if (k == 0) {
                    method125(l, j, 0x10000);
                    method125(l - 1, j, 4096);
                }
                if (k == 1) {
                    method125(l, j, 1024);
                    method125(l, j + 1, 16384);
                }
                if (k == 2) {
                    method125(l, j, 4096);
                    method125(l + 1, j, 0x10000);
                }
                if (k == 3) {
                    method125(l, j, 16384);
                    method125(l, j - 1, 1024);
                }
            }
            if (i == 1 || i == 3) {
                if (k == 0) {
                    method125(l, j, 512);
                    method125(l - 1, j + 1, 8192);
                }
                if (k == 1) {
                    method125(l, j, 2048);
                    method125(l + 1, j + 1, 32768);
                }
                if (k == 2) {
                    method125(l, j, 8192);
                    method125(l + 1, j - 1, 512);
                }
                if (k == 3) {
                    method125(l, j, 32768);
                    method125(l - 1, j - 1, 2048);
                }
            }
            if (i == 2) {
                if (k == 0) {
                    method125(l, j, 0x10400);
                    method125(l - 1, j, 4096);
                    method125(l, j + 1, 16384);
                }
                if (k == 1) {
                    method125(l, j, 5120);
                    method125(l, j + 1, 16384);
                    method125(l + 1, j, 0x10000);
                }
                if (k == 2) {
                    method125(l, j, 20480);
                    method125(l + 1, j, 0x10000);
                    method125(l, j - 1, 1024);
                }
                if (k == 3) {
                    method125(l, j, 0x14000);
                    method125(l, j - 1, 1024);
                    method125(l - 1, j, 4096);
                }
            }
        }
    }

    public void setLoc(int i, int j, boolean solid, int k, int i1, int j1) {
        int flag = OCCUPIED_TILE;
        if (solid) {
            flag += 0x20000;
        }
        i -= anInt39;
        i1 -= anInt40;
        if (j1 == 1 || j1 == 3) {
            int l1 = k;
            k = j;
            j = l1;
        }
        for (int i2 = i; i2 < i + k; i2++)
            if (i2 >= 0 && i2 < x) {
                for (int j2 = i1; j2 < i1 + j; j2++)
                    if (j2 >= 0 && j2 < z) {
                        method125(i2, j2, flag);
                    }
            }
    }

    public void method124(int j, int k) {
        k -= anInt39;
        j -= anInt40;
        flags[k][j] |= 0x200000;
    }

    public void method125(int i, int j, int k) {
        flags[i][j] |= k;
    }

    public void method126(int i, int j, int k, boolean flag, int l, int i1) {
        if (i <= 0)
            return;
        j -= anInt39;
        l -= anInt40;
        if (i1 == 0) {
            if (k == 0) {
                method128(j, (byte) 3, l, 128);
                method128(j - 1, (byte) 3, l, 8);
            }
            if (k == 1) {
                method128(j, (byte) 3, l, 2);
                method128(j, (byte) 3, l + 1, 32);
            }
            if (k == 2) {
                method128(j, (byte) 3, l, 8);
                method128(j + 1, (byte) 3, l, 128);
            }
            if (k == 3) {
                method128(j, (byte) 3, l, 32);
                method128(j, (byte) 3, l - 1, 2);
            }
        }
        if (i1 == 1 || i1 == 3) {
            if (k == 0) {
                method128(j, (byte) 3, l, 1);
                method128(j - 1, (byte) 3, l + 1, 16);
            }
            if (k == 1) {
                method128(j, (byte) 3, l, 4);
                method128(j + 1, (byte) 3, l + 1, 64);
            }
            if (k == 2) {
                method128(j, (byte) 3, l, 16);
                method128(j + 1, (byte) 3, l - 1, 1);
            }
            if (k == 3) {
                method128(j, (byte) 3, l, 64);
                method128(j - 1, (byte) 3, l - 1, 4);
            }
        }
        if (i1 == 2) {
            if (k == 0) {
                method128(j, (byte) 3, l, 130);
                method128(j - 1, (byte) 3, l, 8);
                method128(j, (byte) 3, l + 1, 32);
            }
            if (k == 1) {
                method128(j, (byte) 3, l, 10);
                method128(j, (byte) 3, l + 1, 32);
                method128(j + 1, (byte) 3, l, 128);
            }
            if (k == 2) {
                method128(j, (byte) 3, l, 40);
                method128(j + 1, (byte) 3, l, 128);
                method128(j, (byte) 3, l - 1, 2);
            }
            if (k == 3) {
                method128(j, (byte) 3, l, 160);
                method128(j, (byte) 3, l - 1, 2);
                method128(j - 1, (byte) 3, l, 8);
            }
        }
        if (flag) {
            if (i1 == 0) {
                if (k == 0) {
                    method128(j, (byte) 3, l, 0x10000);
                    method128(j - 1, (byte) 3, l, 4096);
                }
                if (k == 1) {
                    method128(j, (byte) 3, l, 1024);
                    method128(j, (byte) 3, l + 1, 16384);
                }
                if (k == 2) {
                    method128(j, (byte) 3, l, 4096);
                    method128(j + 1, (byte) 3, l, 0x10000);
                }
                if (k == 3) {
                    method128(j, (byte) 3, l, 16384);
                    method128(j, (byte) 3, l - 1, 1024);
                }
            }
            if (i1 == 1 || i1 == 3) {
                if (k == 0) {
                    method128(j, (byte) 3, l, 512);
                    method128(j - 1, (byte) 3, l + 1, 8192);
                }
                if (k == 1) {
                    method128(j, (byte) 3, l, 2048);
                    method128(j + 1, (byte) 3, l + 1, 32768);
                }
                if (k == 2) {
                    method128(j, (byte) 3, l, 8192);
                    method128(j + 1, (byte) 3, l - 1, 512);
                }
                if (k == 3) {
                    method128(j, (byte) 3, l, 32768);
                    method128(j - 1, (byte) 3, l - 1, 2048);
                }
            }
            if (i1 == 2) {
                if (k == 0) {
                    method128(j, (byte) 3, l, 0x10400);
                    method128(j - 1, (byte) 3, l, 4096);
                    method128(j, (byte) 3, l + 1, 16384);
                }
                if (k == 1) {
                    method128(j, (byte) 3, l, 5120);
                    method128(j, (byte) 3, l + 1, 16384);
                    method128(j + 1, (byte) 3, l, 0x10000);
                }
                if (k == 2) {
                    method128(j, (byte) 3, l, 20480);
                    method128(j + 1, (byte) 3, l, 0x10000);
                    method128(j, (byte) 3, l - 1, 1024);
                }
                if (k == 3) {
                    method128(j, (byte) 3, l, 0x14000);
                    method128(j, (byte) 3, l - 1, 1024);
                    method128(j - 1, (byte) 3, l, 4096);
                }
            }
        }
    }

    public void method127(int i, int j, boolean flag, int k, int l, int i1, boolean flag1) {
        int j1 = 256;
        if (flag)
            j1 += 0x20000;
        i1 -= anInt39;
        if (flag1)
            aBoolean37 = !aBoolean37;
        i -= anInt40;
        if (l == 1 || l == 3) {
            int k1 = k;
            k = j;
            j = k1;
        }
        for (int l1 = i1; l1 < i1 + k; l1++)
            if (l1 >= 0 && l1 < x) {
                for (int i2 = i; i2 < i + j; i2++)
                    if (i2 >= 0 && i2 < z)
                        method128(l1, (byte) 3, i2, j1);

            }

    }

    public void method128(int i, byte byte0, int j, int k) {
        flags[i][j] &= 0xffffff - k;
        if (byte0 != 3) {
            for (int l = 1; l > 0; l++) ;
        }
    }

    public void method129(int i, int j, int k) {
        j -= anInt39;
        if (i > 0) {
            k -= anInt40;
            flags[j][k] &= 0xdfffff;
        }
    }

    public boolean method130(int i, int j, int k, int l, int i1, int k1) {
        if (k1 == i1 && i == l) {
            return true;
        }
        k1 -= anInt39;

        i -= anInt40;
        i1 -= anInt39;
        l -= anInt40;
        if (j == 0) {
            if (k == 0) {
                if (k1 == i1 - 1 && i == l) {
                    return true;
                }
                if (k1 == i1 && i == l + 1 && (flags[k1][i] & 0x280120) == 0) {
                    return true;
                }
                if (k1 == i1 && i == l - 1 && (flags[k1][i] & 0x280102) == 0) {
                    return true;
                }
            } else if (k == 1) {
                if (k1 == i1 && i == l + 1) {
                    return true;
                }
                if (k1 == i1 - 1 && i == l && (flags[k1][i] & 0x280108) == 0) {
                    return true;
                }
                if (k1 == i1 + 1 && i == l && (flags[k1][i] & 0x280180) == 0) {
                    return true;
                }
            } else if (k == 2) {
                if (k1 == i1 + 1 && i == l) {
                    return true;
                }
                if (k1 == i1 && i == l + 1 && (flags[k1][i] & 0x280120) == 0) {
                    return true;
                }
                if (k1 == i1 && i == l - 1 && (flags[k1][i] & 0x280102) == 0) {
                    return true;
                }
            } else if (k == 3) {
                if (k1 == i1 && i == l - 1) {
                    return true;
                }
                if (k1 == i1 - 1 && i == l && (flags[k1][i] & 0x280108) == 0) {
                    return true;
                }
                if (k1 == i1 + 1 && i == l && (flags[k1][i] & 0x280180) == 0) {
                    return true;
                }
            }
        }
        if (j == 2) {
            if (k == 0) {
                if (k1 == i1 - 1 && i == l) {
                    return true;
                }
                if (k1 == i1 && i == l + 1) {
                    return true;
                }
                if (k1 == i1 + 1 && i == l && (flags[k1][i] & 0x280180) == 0) {
                    return true;
                }
                if (k1 == i1 && i == l - 1 && (flags[k1][i] & 0x280102) == 0) {
                    return true;
                }
            } else if (k == 1) {
                if (k1 == i1 - 1 && i == l && (flags[k1][i] & 0x280108) == 0) {
                    return true;
                }
                if (k1 == i1 && i == l + 1) {
                    return true;
                }
                if (k1 == i1 + 1 && i == l) {
                    return true;
                }
                if (k1 == i1 && i == l - 1 && (flags[k1][i] & 0x280102) == 0) {
                    return true;
                }
            } else if (k == 2) {
                if (k1 == i1 - 1 && i == l && (flags[k1][i] & 0x280108) == 0) {
                    return true;
                }
                if (k1 == i1 && i == l + 1 && (flags[k1][i] & 0x280120) == 0) {
                    return true;
                }
                if (k1 == i1 + 1 && i == l) {
                    return true;
                }
                if (k1 == i1 && i == l - 1) {
                    return true;
                }
            } else if (k == 3) {
                if (k1 == i1 - 1 && i == l) {
                    return true;
                }
                if (k1 == i1 && i == l + 1 && (flags[k1][i] & 0x280120) == 0) {
                    return true;
                }
                if (k1 == i1 + 1 && i == l && (flags[k1][i] & 0x280180) == 0) {
                    return true;
                }
                if (k1 == i1 && i == l - 1) {
                    return true;
                }
            }
        }
        if (j == 9) {
            if (k1 == i1 && i == l + 1 && (flags[k1][i] & 0x20) == 0) {
                return true;
            }
            if (k1 == i1 && i == l - 1 && (flags[k1][i] & 2) == 0) {
                return true;
            }
            if (k1 == i1 - 1 && i == l && (flags[k1][i] & 8) == 0) {
                return true;
            }
            return k1 == i1 + 1 && i == l && (flags[k1][i] & 0x80) == 0;
        }
        return false;
    }

    public boolean method131(int i, int j, int k, int l, int i1, int j1) {
        if (k == i && j == i1) {
            return true;
        }
        k -= anInt39;

        j -= anInt40;
        i -= anInt39;
        i1 -= anInt40;
        if (l == 6 || l == 7) {
            if (l == 7)
                j1 = j1 + 2 & 3;
            if (j1 == 0) {
                if (k == i + 1 && j == i1 && (flags[k][j] & 0x80) == 0)
                    return true;
                if (k == i && j == i1 - 1 && (flags[k][j] & 2) == 0)
                    return true;
            } else if (j1 == 1) {
                if (k == i - 1 && j == i1 && (flags[k][j] & 8) == 0)
                    return true;
                if (k == i && j == i1 - 1 && (flags[k][j] & 2) == 0)
                    return true;
            } else if (j1 == 2) {
                if (k == i - 1 && j == i1 && (flags[k][j] & 8) == 0)
                    return true;
                if (k == i && j == i1 + 1 && (flags[k][j] & 0x20) == 0)
                    return true;
            } else if (j1 == 3) {
                if (k == i + 1 && j == i1 && (flags[k][j] & 0x80) == 0)
                    return true;
                if (k == i && j == i1 + 1 && (flags[k][j] & 0x20) == 0)
                    return true;
            }
        }
        if (l == 8) {
            if (k == i && j == i1 + 1 && (flags[k][j] & 0x20) == 0)
                return true;
            if (k == i && j == i1 - 1 && (flags[k][j] & 2) == 0)
                return true;
            if (k == i - 1 && j == i1 && (flags[k][j] & 8) == 0)
                return true;
            return k == i + 1 && j == i1 && (flags[k][j] & 0x80) == 0;
        }
        return false;
    }

    public boolean method132(int i, int k, int l, int i1, int j1, int k1, int l1) {
        int i2 = (j1 + k) - 1;
        int j2 = (l + i1) - 1;
        if (k1 >= j1 && k1 <= i2 && l1 >= l && l1 <= j2)
            return true;
        if (k1 == j1 - 1 && l1 >= l && l1 <= j2 && (flags[k1 - anInt39][l1 - anInt40] & 8) == 0 && (i & 8) == 0)
            return true;
        if (k1 == i2 + 1 && l1 >= l && l1 <= j2 && (flags[k1 - anInt39][l1 - anInt40] & 0x80) == 0 && (i & 2) == 0)
            return true;
        if (l1 == l - 1 && k1 >= j1 && k1 <= i2 && (flags[k1 - anInt39][l1 - anInt40] & 2) == 0 && (i & 4) == 0)
            return true;
        return l1 == j2 + 1 && k1 >= j1 && k1 <= i2 && (flags[k1 - anInt39][l1 - anInt40] & 0x20) == 0 && (i & 1) == 0;
    }
}
