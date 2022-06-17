package com.jagex.game.runetek3.graphics;

import com.jagex.core.io.Buffer;
import com.jagex.core.io.FileArchive;

import java.awt.*;
import java.awt.image.PixelGrabber;

public class Sprite extends Draw2D {

    public int anInt1285;
    public int anInt1287;
    public boolean aBoolean1288;
    public byte aByte1289;
    public int anInt1291;
    public int[] pixels;
    public int spriteWidth;
    public int spriteHeight;
    public int clipX;
    public int clipY;
    public int cropW;
    public int cropH;

    public Sprite(int width, int height) {
        pixels = new int[width * height];
        spriteWidth = cropW = width;
        spriteHeight = cropH = height;
        clipX = clipY = 0;
    }

    public Sprite(byte[] src, Component component) {
        try {
            Image image = Toolkit.getDefaultToolkit().createImage(src);
            MediaTracker mediatracker = new MediaTracker(component);
            mediatracker.addImage(image, 0);
            mediatracker.waitForAll();
            spriteWidth = image.getWidth(component);
            spriteHeight = image.getHeight(component);
            cropW = spriteWidth;
            cropH = spriteHeight;
            clipX = 0;
            clipY = 0;
            pixels = new int[spriteWidth * spriteHeight];
            PixelGrabber pixelgrabber = new PixelGrabber(image, 0, 0, spriteWidth, spriteHeight, pixels, 0, spriteWidth);
            pixelgrabber.grabPixels();
        } catch (Exception _ex) {
            System.out.println("Error converting jpg");
        }
    }

    public Sprite(FileArchive archive, String s, int i) {
        Buffer dat = new Buffer(archive.read(null, s + ".dat"));
        Buffer idx = new Buffer(archive.read(null, "index.dat"));
        idx.pos = dat.g2();
        cropW = idx.g2();
        cropH = idx.g2();
        int j = idx.g1();
        int[] ai = new int[j];
        for (int k = 0; k < j - 1; k++) {
            ai[k + 1] = idx.g3();
            if (ai[k + 1] == 0) {
                ai[k + 1] = 1;
            }
        }

        for (int l = 0; l < i; l++) {
            idx.pos += 2;
            dat.pos += idx.g2() * idx.g2();
            idx.pos++;
        }

        clipX = idx.g1();
        clipY = idx.g1();
        spriteWidth = idx.g2();
        spriteHeight = idx.g2();
        int i1 = idx.g1();
        int j1 = spriteWidth * spriteHeight;
        pixels = new int[j1];
        if (i1 == 0) {
            for (int k1 = 0; k1 < j1; k1++) {
                pixels[k1] = ai[dat.g1()];
            }

            return;
        }
        if (i1 == 1) {
            for (int l1 = 0; l1 < spriteWidth; l1++) {
                for (int i2 = 0; i2 < spriteHeight; i2++) {
                    pixels[l1 + i2 * spriteWidth] = ai[dat.g1()];
                }
            }
        }
    }

    public void method354() {
        Draw2D.prepare(spriteWidth, pixels, spriteHeight);

    }

    public void method355(int i, int j, int k) {
        k += clipX;
        i += clipY;
        int l = k + i * Draw2D.width;
        int i1 = 0;
        int j1 = spriteHeight;
        int k1 = spriteWidth;
        int l1 = Draw2D.width - k1;
        int i2 = 0;
        if (j != 0)
            return;
        if (i < Draw2D.top) {
            int j2 = Draw2D.top - i;
            j1 -= j2;
            i = Draw2D.top;
            i1 += j2 * k1;
            l += j2 * Draw2D.width;
        }
        if (i + j1 > Draw2D.bottom)
            j1 -= (i + j1) - Draw2D.bottom;
        if (k < Draw2D.left) {
            int k2 = Draw2D.left - k;
            k1 -= k2;
            k = Draw2D.left;
            i1 += k2;
            l += k2;
            i2 += k2;
            l1 += k2;
        }
        if (k + k1 > Draw2D.right) {
            int l2 = (k + k1) - Draw2D.right;
            k1 -= l2;
            i2 += l2;
            l1 += l2;
        }
        if (k1 > 0 && j1 > 0) {
            method356(k1, j1, l, Draw2D.data, pixels, i1, l1, i2);
        }
    }

    public void method356(int i, int j, int k, int[] ai, int[] ai1, int i1, int j1, int k1) {
        int l1 = -(i >> 2);
        i = -(i & 3);
        for (int i2 = -j; i2 < 0; i2++) {
            for (int j2 = l1; j2 < 0; j2++) {
                ai[k++] = ai1[i1++];
                ai[k++] = ai1[i1++];
                ai[k++] = ai1[i1++];
                ai[k++] = ai1[i1++];
            }

            for (int k2 = i; k2 < 0; k2++) {
                ai[k++] = ai1[i1++];
            }

            k += j1;
            i1 += k1;
        }
    }

    public void method357(int i, int k) {
        k += clipX;
        i += clipY;
        int l = k + i * Draw2D.width;
        int i1 = 0;
        int j1 = spriteHeight;
        int k1 = spriteWidth;
        int l1 = Draw2D.width - k1;
        int i2 = 0;
        if (i < Draw2D.top) {
            int j2 = Draw2D.top - i;
            j1 -= j2;
            i = Draw2D.top;
            i1 += j2 * k1;
            l += j2 * Draw2D.width;
        }
        if (i + j1 > Draw2D.bottom) {
            j1 -= (i + j1) - Draw2D.bottom;
        }
        if (k < Draw2D.left) {
            int k2 = Draw2D.left - k;
            k1 -= k2;
            k = Draw2D.left;
            i1 += k2;
            l += k2;
            i2 += k2;
            l1 += k2;
        }
        if (k + k1 > Draw2D.right) {
            int l2 = (k + k1) - Draw2D.right;
            k1 -= l2;
            i2 += l2;
            l1 += l2;
        }
        if (k1 > 0 && j1 > 0) {
            method358(Draw2D.data, pixels, i1, l, k1, j1, l1, i2);
        }
    }

    public void method358(int[] ai, int[] ai1, int j, int k, int l, int i1, int j1, int k1) {
        int l1 = -(l >> 2);
        l = -(l & 3);
        for (int i2 = -i1; i2 < 0; i2++) {
            int i;
            for (int j2 = l1; j2 < 0; j2++) {
                i = ai1[j++];
                if (i != 0) {
                    ai[k++] = i;
                } else {
                    k++;
                }
                i = ai1[j++];
                if (i != 0) {
                    ai[k++] = i;
                } else {
                    k++;
                }
                i = ai1[j++];
                if (i != 0) {
                    ai[k++] = i;
                } else {
                    k++;
                }
                i = ai1[j++];
                if (i != 0) {
                    ai[k++] = i;
                } else {
                    k++;
                }
            }

            for (int k2 = l; k2 < 0; k2++) {
                i = ai1[j++];
                if (i != 0) {
                    ai[k++] = i;
                } else {
                    k++;
                }
            }

            k += j1;
            j += k1;
        }

    }

    public void method359(int i, int j, int k) {
        i += clipX;
        k += clipY;
        int l = i + k * Draw2D.width;
        int i1 = 0;

        int j1 = spriteHeight;
        int k1 = spriteWidth;
        int l1 = Draw2D.width - k1;
        int i2 = 0;
        if (k < Draw2D.top) {
            int j2 = Draw2D.top - k;
            j1 -= j2;
            k = Draw2D.top;
            i1 += j2 * k1;
            l += j2 * Draw2D.width;
        }
        if (k + j1 > Draw2D.bottom) {
            j1 -= (k + j1) - Draw2D.bottom;
        }
        if (i < Draw2D.left) {
            int k2 = Draw2D.left - i;
            k1 -= k2;
            i = Draw2D.left;
            i1 += k2;
            l += k2;
            i2 += k2;
            l1 += k2;
        }
        if (i + k1 > Draw2D.right) {
            int l2 = (i + k1) - Draw2D.right;
            k1 -= l2;
            i2 += l2;
            l1 += l2;
        }
        if (k1 > 0 && j1 > 0) {
            method360(pixels, k1, j, i1, j1, aByte1289, i2, Draw2D.data, l1, l);
        }
    }

    public void method360(int[] ai, int i, int j, int k, int l, byte byte0, int i1, int[] ai1, int j1, int l1) {
        int i2 = 256 - j;
        for (int j2 = -l; j2 < 0; j2++) {
            for (int k2 = -i; k2 < 0; k2++) {
                int k1 = ai[k++];
                if (k1 != 0) {
                    int l2 = ai1[l1];
                    ai1[l1++] = ((k1 & 0xff00ff) * j + (l2 & 0xff00ff) * i2 & 0xff00ff00) + ((k1 & 0xff00) * j + (l2 & 0xff00) * i2 & 0xff0000) >> 8;
                } else {
                    l1++;
                }
            }

            l1 += j1;
            k += i1;
        }
    }

    public void method361(int[] ai, int i, int j, int k, int[] ai1, int l, int i1, int j1, int k1, int l1) {

        int j2 = -i / 2;
        int k2 = -k / 2;
        int l2 = (int) (Math.sin((double) k1 / 326.11000000000001D) * 65536D);
        int i3 = (int) (Math.cos((double) k1 / 326.11000000000001D) * 65536D);
        int j3 = (j1 << 16) + (k2 * l2 + j2 * i3);
        int k3 = (l1 << 16) + (k2 * i3 - j2 * l2);
        int l3 = l + i1 * Draw2D.width;
        for (i1 = 0; i1 < k; i1++) {
            int i4 = ai1[i1];
            int j4 = l3 + i4;
            int k4 = j3 + i3 * i4;
            int l4 = k3 - l2 * i4;
            for (l = -ai[i1]; l < 0; l++) {
                Draw2D.data[j4++] = pixels[(k4 >> 16) + (l4 >> 16) * spriteWidth];
                k4 += i3;
                l4 -= l2;
            }

            j3 += l2;
            k3 += i3;
            l3 += Draw2D.width;
        }
    }

    public void method362(int i, int j, IndexedSprite class35_sub2_sub2_sub3, int k) {
        j += clipX;
        k += clipY;
        int l = j + k * Draw2D.width;
        int i1 = 0;
        int j1 = spriteHeight;
        int k1 = spriteWidth;
        int l1 = Draw2D.width - k1;
        int i2 = 0;
        if (k < Draw2D.top) {
            int j2 = Draw2D.top - k;
            j1 -= j2;
            k = Draw2D.top;
            i1 += j2 * k1;
            l += j2 * Draw2D.width;
        }
        if (k + j1 > Draw2D.bottom) {
            j1 -= (k + j1) - Draw2D.bottom;
        }
        if (j < Draw2D.left) {
            int k2 = Draw2D.left - j;
            k1 -= k2;
            j = Draw2D.left;
            i1 += k2;
            l += k2;
            i2 += k2;
            l1 += k2;
        }
        if (j + k1 > Draw2D.right) {
            int l2 = (j + k1) - Draw2D.right;
            k1 -= l2;
            i2 += l2;
            l1 += l2;
        }
        if (k1 > 0 && j1 > 0) {
            method363(i1, Draw2D.data, k1, j1, pixels, i2, l, l1, class35_sub2_sub2_sub3.pixels);
        }
    }

    public void method363(int i, int[] ai, int k, int l, int[] ai1, int i1, int j1, int k1, byte[] abyte0) {
        int l1 = -(k >> 2);
        k = -(k & 3);
        for (int i2 = -l; i2 < 0; i2++) {
            int j;
            for (int j2 = l1; j2 < 0; j2++) {
                j = ai1[i++];
                for (int i3 = 0; i3 < 3; i3++) {
                    if (j != 0 && abyte0[j1] == 0)
                        ai[j1++] = j;
                    else
                        j1++;
                    j = ai1[i++];
                }
                if (j == 0 || abyte0[j1] != 0) {
                    j1++;
                } else {
                    ai[j1++] = j;
                }
            }

            for (int k2 = k; k2 < 0; k2++) {
                j = ai1[i++];
                if (j == 0 || abyte0[j1] != 0) {
                    j1++;
                } else {
                    ai[j1++] = j;
                }
            }

            j1 += k1;
            i += i1;
        }
    }
}
