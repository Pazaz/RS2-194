package com.jagex.core.stringutils;

// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

import com.jagex.core.io.Buffer;

public class TextEncoder {

    public static String method424(int i, int j, Buffer class35_sub2_sub3) {
        int k = 0;
        int l = -1;
        for (int i1 = 0; i1 < j; i1++) {
            int j1 = class35_sub2_sub3.g1();
            int k1 = j1 >> 4 & 0xf;
            if (l == -1) {
                if (k1 < 13)
                    aCharArray525[k++] = aCharArray526[k1];
                else
                    l = k1;
            } else {
                aCharArray525[k++] = aCharArray526[((l << 4) + k1) - 195];
                l = -1;
            }
            k1 = j1 & 0xf;
            if (l == -1) {
                if (k1 < 13)
                    aCharArray525[k++] = aCharArray526[k1];
                else
                    l = k1;
            } else {
                aCharArray525[k++] = aCharArray526[((l << 4) + k1) - 195];
                l = -1;
            }
        }

        boolean flag = true;
        if (i != -17950)
            throw new NullPointerException();
        for (int l1 = 0; l1 < k; l1++) {
            char c = aCharArray525[l1];
            if (flag && c >= 'a' && c <= 'z') {
                aCharArray525[l1] += '\uFFE0';
                flag = false;
            }
            if (c == '.' || c == '!')
                flag = true;
        }

        return new String(aCharArray525, 0, k);
    }

    public static void method425(String s, boolean flag, Buffer class35_sub2_sub3) {
        if (s.length() > 80)
            s = s.substring(0, 80);
        s = s.toLowerCase();
        if (!flag)
            aBoolean524 = !aBoolean524;
        int i = -1;
        for (int j = 0; j < s.length(); j++) {
            char c = s.charAt(j);
            int k = 0;
            for (int l = 0; l < aCharArray526.length; l++) {
                if (c != aCharArray526[l])
                    continue;
                k = l;
                break;
            }

            if (k > 12)
                k += 195;
            if (i == -1) {
                if (k < 13)
                    i = k;
                else
                    class35_sub2_sub3.p1(k);
            } else if (k < 13) {
                class35_sub2_sub3.p1((i << 4) + k);
                i = -1;
            } else {
                class35_sub2_sub3.p1((i << 4) + (k >> 4));
                i = k & 0xf;
            }
        }

        if (i != -1)
            class35_sub2_sub3.p1(i << 4);
    }

    public static boolean aBoolean524;
    public static char[] aCharArray525 = new char[100];
    public static char[] aCharArray526 = {
            ' ', 'e', 't', 'a', 'o', 'i', 'h', 'n', 's', 'r',
            'd', 'l', 'u', 'm', 'w', 'c', 'y', 'f', 'g', 'p',
            'b', 'v', 'k', 'x', 'j', 'q', 'z', '0', '1', '2',
            '3', '4', '5', '6', '7', '8', '9', ' ', '!', '?',
            '.', ',', ':', ';', '(', ')', '-', '&', '*', '\\',
            '\'', '@', '#', '+', '=', '\243', '$', '%', '"', '[',
            ']'
    };

}
