package com.jagex.game.runetek3.graphics;

import com.jagex.core.io.Buffer;
import com.jagex.core.io.FileArchive;

public class IndexedSprite extends Draw2D {

    public byte[] pixels;
    public int[] palette;
    public int spriteWidth;
    public int spriteHeight;
    public int clipX;
    public int clipY;
    public int clipWidth;
    public int clipHeight;

    public IndexedSprite(FileArchive archive, String s, int i) {
        Buffer dat = new Buffer(archive.read(null, s + ".dat"));
        Buffer idx = new Buffer(archive.read(null, "index.dat"));
        idx.pos = dat.g2();
        clipWidth = idx.g2();
        clipHeight = idx.g2();
        int j = idx.g1();
        palette = new int[j];
        for (int k = 0; k < j - 1; k++) {
            palette[k + 1] = idx.g3();
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
        pixels = new byte[j1];
        if (i1 == 0) {
            for (int k1 = 0; k1 < j1; k1++) {
                pixels[k1] = dat.g1b();
            }

            return;
        }
        if (i1 == 1) {
            for (int l1 = 0; l1 < spriteWidth; l1++) {
                for (int i2 = 0; i2 < spriteHeight; i2++) {
                    pixels[l1 + i2 * spriteWidth] = dat.g1b();
                }
            }
        }
    }

    public void shrink() {
        clipWidth /= 2;
        clipHeight /= 2;
        byte[] pixels = new byte[clipWidth * clipHeight];
        int j = 0;
        for (int k = 0; k < spriteHeight; k++) {
            for (int l = 0; l < spriteWidth; l++) {
                pixels[(l + clipX >> 1) + (k + clipY >> 1) * clipWidth] = this.pixels[j++];
            }
        }

        this.pixels = pixels;
        spriteWidth = clipWidth;
        spriteHeight = clipHeight;
        clipX = 0;
        clipY = 0;
    }

    public void crop() {
        if (spriteWidth == clipWidth && spriteHeight == clipHeight) {
            return;
        }
        byte[] abyte0 = new byte[clipWidth * clipHeight];
        int j = 0;
        for (int k = 0; k < spriteHeight; k++) {
            for (int l = 0; l < spriteWidth; l++) {
                abyte0[l + clipX + (k + clipY) * clipWidth] = pixels[j++];
            }
        }

        pixels = abyte0;
        spriteWidth = clipWidth;
        spriteHeight = clipHeight;
        clipX = 0;
        clipY = 0;
    }

    public void flipHorizontally() {
        byte[] abyte0 = new byte[spriteWidth * spriteHeight];
        int j = 0;

        for (int k = 0; k < spriteHeight; k++) {
            for (int l = spriteWidth - 1; l >= 0; l--) {
                abyte0[j++] = pixels[l + k * spriteWidth];
            }
        }

        pixels = abyte0;
        clipX = clipWidth - spriteWidth - clipX;
    }

    public void flipVertically() {
        byte[] abyte0 = new byte[spriteWidth * spriteHeight];
        int i = 0;
        for (int j = spriteHeight - 1; j >= 0; j--) {
            for (int k = 0; k < spriteWidth; k++) {
                abyte0[i++] = pixels[k + j * spriteWidth];
            }
        }

        pixels = abyte0;
        clipY = clipHeight - spriteHeight - clipY;
    }

    public void draw(int i, int k) {
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
            copyImage(j1, i1, i2, Draw2D.data, palette, pixels, l1, l, k1);
        }
    }

    public void copyImage(int i, int j, int k, int[] ai, int[] ai1, byte[] abyte0, int l, int i1, int j1) {
        int k1 = -(j1 >> 2);
        j1 = -(j1 & 3);
        for (int l1 = -i; l1 < 0; l1++) {
            for (int i2 = k1; i2 < 0; i2++) {
                byte byte1 = abyte0[j++];
                if (byte1 != 0) {
                    ai[i1++] = ai1[byte1 & 0xff];
                } else {
                    i1++;
                }
                byte1 = abyte0[j++];
                if (byte1 != 0) {
                    ai[i1++] = ai1[byte1 & 0xff];
                } else {
                    i1++;
                }
                byte1 = abyte0[j++];
                if (byte1 != 0) {
                    ai[i1++] = ai1[byte1 & 0xff];
                } else {
                    i1++;
                }
                byte1 = abyte0[j++];
                if (byte1 != 0) {
                    ai[i1++] = ai1[byte1 & 0xff];
                } else {
                    i1++;
                }
            }

            for (int j2 = j1; j2 < 0; j2++) {
                byte byte2 = abyte0[j++];
                if (byte2 != 0) {
                    ai[i1++] = ai1[byte2 & 0xff];
                } else {
                    i1++;
                }
            }

            i1 += l;
            j += k;
        }
    }
}
