package com.jagex.game.runetek3.graphics;

import com.jagex.core.utils.CacheableNode;

public class Draw2D extends CacheableNode {

    public static int[] data;
    public static int width;
    public static int height;
    public static int top;
    public static int bottom;
    public static int left;
    public static int right;
    public static int safeX;
    public static int centerX;
    public static int centerY;

    public static void prepare(int width, int[] data, int height) {
        Draw2D.data = data;
        Draw2D.width = width;
        Draw2D.height = height;
        setBounds(height, width, 0, 0);
    }

    public static void resetBounds() {
        left = 0;
        top = 0;
        right = width;
        bottom = height;
        safeX = right - 1;
        centerX = right / 2;
    }

    public static void setBounds(int y1, int x1, int y0, int x0) {
        if (x0 < 0) {
            x0 = 0;
        }
        if (y0 < 0) {
            y0 = 0;
        }
        if (x1 > width) {
            x1 = width;
        }
        if (y1 > height) {
            y1 = height;
        }
        left = x0;
        top = y0;
        right = x1;
        bottom = y1;

        safeX = right - 1;
        centerX = right / 2;
        centerY = bottom / 2;
    }

    public static void clear() {
        int length = width * height;
        for (int i = 0; i < length; i++) {
            data[i] = 0;
        }
    }

    public static void fillRect(int rgb, int h, int y, int w, int x) {
        if (x < left) {
            w -= left - x;
            x = left;
        }
        if (y < top) {
            h -= top - y;
            y = top;
        }
        if (x + w > right) {
            w = right - x;
        }
        if (y + h > bottom) {
            h = bottom - y;
        }
        int off = width - w;
        int pixel = x + y * width;
        for (int i2 = -h; i2 < 0; i2++) {
            for (int row = -w; row < 0; row++) {
                data[pixel++] = rgb;
            }

            pixel += off;
        }
    }

    public static void method334(int rgb, int y, int w, int h, int x) {
        drawHorizontalLine(x, y, w, rgb);
        drawHorizontalLine(x, (y + h) - 1, w, rgb);
        drawVerticalLine(x, y, h, rgb);
        drawVerticalLine((x + w) - 1, y, h, rgb);
    }

    public static void drawHorizontalLine(int x, int y, int len, int rgb) {
        if (y < top || y >= bottom) {
            return;
        }
        if (x < left) {
            len -= left - x;
            x = left;
        }
        if (x + len > right) {
            len = right - x;
        }
        int off = x + y * width;
        for (int w = 0; w < len; w++) {
            data[off + w] = rgb;
        }
    }

    public static void drawVerticalLine(int x, int y, int len, int rgb) {
        if (x < left || x >= right) {
            return;
        }
        if (y < top) {
            len -= top - y;
            y = top;
        }
        if (y + len > bottom) {
            len = bottom - y;
        }
        int off = x + y * width;
        for (int v = 0; v < len; v++) {
            data[off + v * width] = rgb;
        }
    }

    public Draw2D() {
    }
}
