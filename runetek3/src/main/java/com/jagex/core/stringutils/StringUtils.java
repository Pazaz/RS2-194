package com.jagex.core.stringutils;

// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

import rs2.sign.signlink;

public class StringUtils {

    public static long toBase37(String s) {
        s = s.trim();
        long l = 0L;
        for (int i = 0; i < s.length() && i < 12; i++) {
            char c = s.charAt(i);
            l *= 37L;
            if (c >= 'A' && c <= 'Z')
                l += (1 + c) - 65;
            else if (c >= 'a' && c <= 'z')
                l += (1 + c) - 97;
            else if (c >= '0' && c <= '9')
                l += (27 + c) - 48;
        }

        return l;
    }

    public static String fromBase37(boolean flag, long l) {
        try {
            if (l < 0L || l >= 0x5b5b57f8a98a5dd1L)
                return "invalid_name";
            int i = 0;
            if (!flag)
                throw new NullPointerException();
            while (l != 0L) {
                long l1 = l;
                l /= 37L;
                aCharArray522[11 - i++] = aCharArray523[(int) (l1 - l * 37L)];
            }
            return new String(aCharArray522, 12 - i, i);
        } catch (RuntimeException runtimeexception) {
            signlink.reporterror("17221, " + flag + ", " + l + ", " + runtimeexception);
        }
        throw new RuntimeException();
    }

    public static long method420(String s, byte byte0) {
        s = s.toLowerCase();
        long l = 0L;
        for (int i = 0; i < s.length(); i++)
            l = (l * 61L + (long) s.charAt(i)) - 32L;

        if (byte0 != 6)
            throw new NullPointerException();
        else
            return l;
    }

    public static String method421(int i, String s) {
        if (i >= 0)
            throw new NullPointerException();
        if (s.length() > 0) {
            char[] ac = s.toCharArray();
            for (int j = 0; j < ac.length; j++)
                if (ac[j] == '_') {
                    ac[j] = ' ';
                    if (j + 1 < ac.length && ac[j + 1] >= 'a' && ac[j + 1] <= 'z')
                        ac[j + 1] = (char) ((ac[j + 1] + 65) - 97);
                }

            if (ac[0] >= 'a' && ac[0] <= 'z')
                ac[0] = (char) ((ac[0] + 65) - 97);
            return new String(ac);
        } else {
            return s;
        }
    }

    public static String method422(int i, String s) {
        s = s.toLowerCase();
        char[] ac = s.toCharArray();
        if (i != -4442)
            throw new NullPointerException();
        int j = ac.length;
        boolean flag = true;
        for (int k = 0; k < j; k++) {
            char c = ac[k];
            if (flag && c >= 'a' && c <= 'z') {
                ac[k] += '\uFFE0';
                flag = false;
            }
            if (c == '.' || c == '!')
                flag = true;
        }

        return new String(ac);
    }

    public static String method423(byte byte0, String s) {
        if (byte0 == 1) {
            byte0 = 0;
        } else {
            for (int i = 1; i > 0; i++) ;
        }
        String s1 = "";
        for (int j = 0; j < s.length(); j++)
            s1 = s1 + "*";

        return s1;
    }

    public static int anInt520 = -339;
    public static int anInt521 = 8;
    public static char[] aCharArray522 = new char[12];
    public static char[] aCharArray523 = {
            '_', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i',
            'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's',
            't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2',
            '3', '4', '5', '6', '7', '8', '9'
    };

}
