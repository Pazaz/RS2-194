package com.jagex.core.stringutils;

// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

import com.jagex.core.io.Buffer;
import com.jagex.core.io.FileArchive;

public class WordPack {

    public static void decode(FileArchive class36) {
        Buffer class35_sub2_sub3 = new Buffer(class36.read(null, "fragmentsenc.txt"));
        Buffer class35_sub2_sub3_1 = new Buffer(class36.read(null, "badenc.txt"));
        Buffer class35_sub2_sub3_2 = new Buffer(class36.read(null, "domainenc.txt"));
        Buffer class35_sub2_sub3_3 = new Buffer(class36.read(null, "tldlist.txt"));
        method187(class35_sub2_sub3, class35_sub2_sub3_1, class35_sub2_sub3_2, class35_sub2_sub3_3);
    }

    public static void method187(Buffer class35_sub2_sub3, Buffer class35_sub2_sub3_1, Buffer class35_sub2_sub3_2, Buffer class35_sub2_sub3_3) {
        method189(302, class35_sub2_sub3_1);
        method190(0, class35_sub2_sub3_2);
        method191(class35_sub2_sub3, true);
        method188(class35_sub2_sub3_3, 158);
    }

    public static void method188(Buffer class35_sub2_sub3, int i) {
        int j = class35_sub2_sub3.g4();
        aCharArrayArray277 = new char[j][];
        anIntArray278 = new int[j];
        i = 16 / i;
        for (int k = 0; k < j; k++) {
            anIntArray278[k] = class35_sub2_sub3.g1();
            char[] ac = new char[class35_sub2_sub3.g1()];
            for (int l = 0; l < ac.length; l++)
                ac[l] = (char) class35_sub2_sub3.g1();

            aCharArrayArray277[k] = ac;
        }

    }

    public static void method189(int i, Buffer class35_sub2_sub3) {
        i = 36 / i;
        int j = class35_sub2_sub3.g4();
        aCharArrayArray274 = new char[j][];
        aByteArrayArrayArray275 = new byte[j][][];
        method192(-467, class35_sub2_sub3, aByteArrayArrayArray275, aCharArrayArray274);
    }

    public static void method190(int i, Buffer class35_sub2_sub3) {
        int j = class35_sub2_sub3.g4();
        aCharArrayArray276 = new char[j][];
        if (i < 0 || i > 0) {
            return;
        } else {
            method193(class35_sub2_sub3, aByte266, aCharArrayArray276);
            return;
        }
    }

    public static void method191(Buffer class35_sub2_sub3, boolean flag) {
        anIntArray273 = new int[class35_sub2_sub3.g4()];
        if (!flag)
            return;
        for (int i = 0; i < anIntArray273.length; i++)
            anIntArray273[i] = class35_sub2_sub3.g2();

    }

    public static void method192(int i, Buffer class35_sub2_sub3, byte[][][] abyte0, char[][] ac) {
        if (i >= 0)
            aBoolean264 = !aBoolean264;
        for (int j = 0; j < ac.length; j++) {
            char[] ac1 = new char[class35_sub2_sub3.g1()];
            for (int k = 0; k < ac1.length; k++)
                ac1[k] = (char) class35_sub2_sub3.g1();

            ac[j] = ac1;
            byte[][] abyte1 = new byte[class35_sub2_sub3.g1()][2];
            for (int l = 0; l < abyte1.length; l++) {
                abyte1[l][0] = (byte) class35_sub2_sub3.g1();
                abyte1[l][1] = (byte) class35_sub2_sub3.g1();
            }

            if (abyte1.length > 0)
                abyte0[j] = abyte1;
        }

    }

    public static void method193(Buffer class35_sub2_sub3, byte byte0, char[][] ac) {
        if (byte0 != aByte267)
            return;
        for (int i = 0; i < ac.length; i++) {
            char[] ac1 = new char[class35_sub2_sub3.g1()];
            for (int j = 0; j < ac1.length; j++)
                ac1[j] = (char) class35_sub2_sub3.g1();

            ac[i] = ac1;
        }

    }

    public static void method194(int i, char[] ac) {
        if (i != 7)
            return;
        for (int j = 0; j < ac.length; j++)
            if (!method195(ac[j], 0))
                ac[j] = ' ';

    }

    public static boolean method195(char c, int i) {
        if (i != 0) {
            for (int j = 1; j > 0; j++) ;
        }
        return c >= ' ' && c <= '\177' || c == ' ' || c == '\n' || c == '\t' || c == '\243' || c == '\u20AC';
    }

    public static String method196(byte byte0, String s) {
        if (byte0 != -82)
            throw new NullPointerException();
        long l = System.currentTimeMillis();
        char[] ac = s.toLowerCase().toCharArray();
        method194(7, ac);
        method204(ac, 947);
        method199((byte) 0, ac);
        method200(804, ac);
        method213(288, ac);
        for (int i = 0; i < aStringArray279.length; i++) {
            for (int j = -1; (j = s.indexOf(aStringArray279[i], j + 1)) != -1; ) {
                char[] ac1 = aStringArray279[i].toCharArray();
                for (int k = 0; k < ac1.length; k++)
                    ac[k + j] = ac1[k];

            }

        }

        method197((byte) 6, ac, s.toCharArray());
        method198(aByte269, ac);
        long l1 = System.currentTimeMillis();
        return (new String(ac)).trim();
    }

    public static void method197(byte byte0, char[] ac, char[] ac1) {
        if (byte0 != aByte268)
            aBoolean264 = !aBoolean264;
        for (int i = 0; i < ac1.length; i++)
            if (ac[i] != '*' && method221(ac1[i], 8))
                ac[i] = ac1[i];

    }

    public static void method198(byte byte0, char[] ac) {
        if (byte0 != 6) {
            for (int i = 1; i > 0; i++) ;
        }
        boolean flag = true;
        for (int j = 0; j < ac.length; j++) {
            char c = ac[j];
            if (method218(-682, c)) {
                if (flag) {
                    if (method220((byte) 4, c))
                        flag = false;
                } else if (method221(c, 8))
                    ac[j] = (char) ((c + 97) - 65);
            } else {
                flag = true;
            }
        }

    }

    public static void method199(byte byte0, char[] ac) {
        for (int i = 0; i < 2; i++) {
            for (int j = aCharArrayArray274.length - 1; j >= 0; j--)
                method208(aByteArrayArrayArray275[j], ac, aCharArrayArray274[j], 149);

        }

        if (byte0 == 0) ;
    }

    public static void method200(int i, char[] ac) {
        char[] ac1 = ac.clone();
        char[] ac2 = {
                '(', 'a', ')'
        };
        if (i <= 0)
            aBoolean265 = !aBoolean265;
        method208(null, ac1, ac2, 149);
        char[] ac3 = ac.clone();
        char[] ac4 = {
                'd', 'o', 't'
        };
        method208(null, ac3, ac4, 149);
        for (int j = aCharArrayArray276.length - 1; j >= 0; j--)
            method201(aCharArrayArray276[j], ac3, (byte) 8, ac1, ac);

    }

    public static void method201(char[] ac, char[] ac1, byte byte0, char[] ac2, char[] ac3) {
        if (ac.length > ac3.length)
            return;
        boolean flag = true;
        if (byte0 == 8)
            byte0 = 0;
        else
            aBoolean265 = !aBoolean265;
        int i;
        for (int j = 0; j <= ac3.length - ac.length; j += i) {
            int k = j;
            int l = 0;
            i = 1;
            while (k < ac3.length) {
                int i1 = 0;
                char c = ac3[k];
                char c1 = '\0';
                if (k + 1 < ac3.length)
                    c1 = ac3[k + 1];
                if (l < ac.length && (i1 = method210(ac[l], c1, c, (byte) 17)) > 0) {
                    k += i1;
                    l++;
                    continue;
                }
                if (l == 0)
                    break;
                if ((i1 = method210(ac[l - 1], c1, c, (byte) 17)) > 0) {
                    k += i1;
                    if (l == 1)
                        i++;
                    continue;
                }
                if (l >= ac.length || !method216(9, c))
                    break;
                k++;
            }
            if (l >= ac.length) {
                boolean flag1 = false;
                int j1 = method202(21835, ac3, j, ac2);
                int k1 = method203(k - 1, ac3, ac1, (byte) -2);
                if (j1 > 2 || k1 > 2)
                    flag1 = true;
                if (flag1) {
                    for (int l1 = j; l1 < k; l1++)
                        ac3[l1] = '*';

                }
            }
        }

    }

    public static int method202(int i, char[] ac, int j, char[] ac1) {
        if (i != 21835)
            return anInt262;
        if (j == 0)
            return 2;
        for (int k = j - 1; k >= 0; k--) {
            if (!method216(9, ac[k]))
                break;
            if (ac[k] == '@')
                return 3;
        }

        int l = 0;
        for (int i1 = j - 1; i1 >= 0; i1--) {
            if (!method216(9, ac1[i1]))
                break;
            if (ac1[i1] == '*')
                l++;
        }

        if (l >= 3)
            return 4;
        return !method216(9, ac[j - 1]) ? 0 : 1;
    }

    public static int method203(int i, char[] ac, char[] ac1, byte byte0) {
        if (byte0 != -2)
            anInt262 = -127;
        if (i + 1 == ac.length)
            return 2;
        for (int j = i + 1; j < ac.length; j++) {
            if (!method216(9, ac[j]))
                break;
            if (ac[j] == '.' || ac[j] == ',')
                return 3;
        }

        int k = 0;
        for (int l = i + 1; l < ac.length; l++) {
            if (!method216(9, ac1[l]))
                break;
            if (ac1[l] == '*')
                k++;
        }

        if (k >= 3)
            return 4;
        return !method216(9, ac[i + 1]) ? 0 : 1;
    }

    public static void method204(char[] ac, int i) {
        char[] ac1 = ac.clone();
        char[] ac2 = {
                'd', 'o', 't'
        };
        method208(null, ac1, ac2, 149);
        char[] ac3 = ac.clone();
        char[] ac4 = {
                's', 'l', 'a', 's', 'h'
        };
        if (i <= 0)
            aBoolean264 = !aBoolean264;
        method208(null, ac3, ac4, 149);
        for (int j = 0; j < aCharArrayArray277.length; j++)
            method205(ac1, aCharArrayArray277[j], anIntArray278[j], 1, ac, ac3);

    }

    public static void method205(char[] ac, char[] ac1, int i, int j, char[] ac2, char[] ac3) {
        if (j < 1 || j > 1)
            return;
        if (ac1.length > ac2.length)
            return;
        boolean flag = true;
        int k;
        for (int l = 0; l <= ac2.length - ac1.length; l += k) {
            int i1 = l;
            int j1 = 0;
            k = 1;
            while (i1 < ac2.length) {
                int k1 = 0;
                char c = ac2[i1];
                char c1 = '\0';
                if (i1 + 1 < ac2.length)
                    c1 = ac2[i1 + 1];
                if (j1 < ac1.length && (k1 = method210(ac1[j1], c1, c, (byte) 17)) > 0) {
                    i1 += k1;
                    j1++;
                    continue;
                }
                if (j1 == 0)
                    break;
                if ((k1 = method210(ac1[j1 - 1], c1, c, (byte) 17)) > 0) {
                    i1 += k1;
                    if (j1 == 1)
                        k++;
                    continue;
                }
                if (j1 >= ac1.length || !method216(9, c))
                    break;
                i1++;
            }
            if (j1 >= ac1.length) {
                boolean flag1 = false;
                int l1 = method206(ac2, (byte) -80, l, ac);
                int i2 = method207(ac3, i1 - 1, (byte) -3, ac2);
                if (i == 1 && l1 > 0 && i2 > 0)
                    flag1 = true;
                if (i == 2 && (l1 > 2 && i2 > 0 || l1 > 0 && i2 > 2))
                    flag1 = true;
                if (i == 3 && l1 > 0 && i2 > 2)
                    flag1 = true;
                boolean _tmp = i == 3 && l1 > 2 && i2 > 0;
                if (flag1) {
                    int j2 = l;
                    int k2 = i1 - 1;
                    if (l1 > 2) {
                        if (l1 == 4) {
                            boolean flag2 = false;
                            for (int i3 = j2 - 1; i3 >= 0; i3--)
                                if (flag2) {
                                    if (ac[i3] != '*')
                                        break;
                                    j2 = i3;
                                } else if (ac[i3] == '*') {
                                    j2 = i3;
                                    flag2 = true;
                                }

                        }
                        boolean flag3 = false;
                        for (int j3 = j2 - 1; j3 >= 0; j3--)
                            if (flag3) {
                                if (method216(9, ac2[j3]))
                                    break;
                                j2 = j3;
                            } else if (!method216(9, ac2[j3])) {
                                flag3 = true;
                                j2 = j3;
                            }

                    }
                    if (i2 > 2) {
                        if (i2 == 4) {
                            boolean flag4 = false;
                            for (int k3 = k2 + 1; k3 < ac2.length; k3++)
                                if (flag4) {
                                    if (ac3[k3] != '*')
                                        break;
                                    k2 = k3;
                                } else if (ac3[k3] == '*') {
                                    k2 = k3;
                                    flag4 = true;
                                }

                        }
                        boolean flag5 = false;
                        for (int l3 = k2 + 1; l3 < ac2.length; l3++)
                            if (flag5) {
                                if (method216(9, ac2[l3]))
                                    break;
                                k2 = l3;
                            } else if (!method216(9, ac2[l3])) {
                                flag5 = true;
                                k2 = l3;
                            }

                    }
                    for (int l2 = j2; l2 <= k2; l2++)
                        ac2[l2] = '*';

                }
            }
        }

    }

    public static int method206(char[] ac, byte byte0, int i, char[] ac1) {
        if (i == 0)
            return 2;
        for (int j = i - 1; j >= 0; j--) {
            if (!method216(9, ac[j]))
                break;
            if (ac[j] == ',' || ac[j] == '.')
                return 3;
        }

        int k = 0;
        if (byte0 != -80) {
            for (int l = 1; l > 0; l++) ;
        }
        for (int i1 = i - 1; i1 >= 0; i1--) {
            if (!method216(9, ac1[i1]))
                break;
            if (ac1[i1] == '*')
                k++;
        }

        if (k >= 3)
            return 4;
        return !method216(9, ac[i - 1]) ? 0 : 1;
    }

    public static int method207(char[] ac, int i, byte byte0, char[] ac1) {
        if (i + 1 == ac1.length)
            return 2;
        for (int j = i + 1; j < ac1.length; j++) {
            if (!method216(9, ac1[j]))
                break;
            if (ac1[j] == '\\' || ac1[j] == '/')
                return 3;
        }

        if (byte0 != -3)
            return anInt263;
        int k = 0;
        for (int l = i + 1; l < ac1.length; l++) {
            if (!method216(9, ac[l]))
                break;
            if (ac[l] == '*')
                k++;
        }

        if (k >= 5)
            return 4;
        return !method216(9, ac1[i + 1]) ? 0 : 1;
    }

    public static void method208(byte[][] abyte0, char[] ac, char[] ac1, int i) {
        if (ac1.length > ac.length)
            return;
        boolean flag = true;
        i = 61 / i;
        int j;
        for (int k = 0; k <= ac.length - ac1.length; k += j) {
            int l = k;
            int i1 = 0;
            int j1 = 0;
            j = 1;
            boolean flag1 = false;
            while (l < ac.length) {
                int k1 = 0;
                char c = ac[l];
                char c2 = '\0';
                if (l + 1 < ac.length)
                    c2 = ac[l + 1];
                if (i1 < ac1.length && (k1 = method211(c, true, c2, ac1[i1])) > 0) {
                    l += k1;
                    i1++;
                    continue;
                }
                if (i1 == 0)
                    break;
                if ((k1 = method211(c, true, c2, ac1[i1 - 1])) > 0) {
                    l += k1;
                    if (i1 == 1)
                        j++;
                    continue;
                }
                if (i1 >= ac1.length || !method217((byte) 73, c))
                    break;
                if (method216(9, c) && c != '\'')
                    flag1 = true;
                l++;
                if ((++j1 * 100) / (l - k) > 90)
                    break;
            }
            if (i1 >= ac1.length) {
                boolean flag2 = true;
                if (!flag1) {
                    char c1 = ' ';
                    if (k - 1 >= 0)
                        c1 = ac[k - 1];
                    char c3 = ' ';
                    if (l < ac.length)
                        c3 = ac[l];
                    byte byte0 = method212(false, c1);
                    byte byte1 = method212(false, c3);
                    if (abyte0 != null && method209(byte0, byte1, 10068, abyte0))
                        flag2 = false;
                } else {
                    boolean flag3 = false;
                    boolean flag4 = false;
                    if (k - 1 < 0 || method216(9, ac[k - 1]) && ac[k - 1] != '\'')
                        flag3 = true;
                    if (l >= ac.length || method216(9, ac[l]) && ac[l] != '\'')
                        flag4 = true;
                    if (!flag3 || !flag4) {
                        boolean flag5 = false;
                        int k2 = k - 2;
                        if (flag3)
                            k2 = k;
                        for (; !flag5 && k2 < l; k2++)
                            if (k2 >= 0 && (!method216(9, ac[k2]) || ac[k2] == '\'')) {
                                char[] ac2 = new char[3];
                                int l2;
                                for (l2 = 0; l2 < 3; l2++) {
                                    if (k2 + l2 >= ac.length || method216(9, ac[k2 + l2]) && ac[k2 + l2] != '\'')
                                        break;
                                    ac2[l2] = ac[k2 + l2];
                                }

                                boolean flag6 = l2 != 0;
                                if (l2 < 3 && k2 - 1 >= 0 && (!method216(9, ac[k2 - 1]) || ac[k2 - 1] == '\''))
                                    flag6 = false;
                                if (flag6 && !method222(false, ac2))
                                    flag5 = true;
                            }

                        if (!flag5)
                            flag2 = false;
                    }
                }
                if (flag2) {
                    int l1 = 0;
                    for (int i2 = k; i2 < l; i2++)
                        if (method219(ac[i2], (byte) -70))
                            l1++;

                    if ((l1 * 100) / (l - k) <= 50) {
                        for (int j2 = k; j2 < l; j2++)
                            ac[j2] = '*';

                    }
                }
            }
        }

    }

    public static boolean method209(byte byte0, byte byte1, int i, byte[][] abyte0) {
        int j = 0;
        if (abyte0[j][0] == byte0 && abyte0[j][1] == byte1)
            return true;
        int k = abyte0.length - 1;
        if (i != 10068) {
            for (int l = 1; l > 0; l++) ;
        }
        if (abyte0[k][0] == byte0 && abyte0[k][1] == byte1)
            return true;
        do {
            int i1 = (j + k) / 2;
            if (abyte0[i1][0] == byte0 && abyte0[i1][1] == byte1)
                return true;
            if (byte0 < abyte0[i1][0] || byte0 == abyte0[i1][0] && byte1 < abyte0[i1][1])
                k = i1;
            else
                j = i1;
        } while (j != k && j + 1 != k);
        return false;
    }

    public static int method210(char c, char c1, char c2, byte byte0) {
        if (byte0 != 17)
            return anInt270;
        if (c == c2)
            return 1;
        if (c == 'o' && c2 == '0')
            return 1;
        if (c == 'o' && c2 == '(' && c1 == ')')
            return 2;
        if (c == 'c' && (c2 == '(' || c2 == '<' || c2 == '['))
            return 1;
        if (c == 'e' && c2 == '\u20AC')
            return 1;
        if (c == 's' && c2 == '$')
            return 1;
        return c != 'l' || c2 != 'i' ? 0 : 1;
    }

    public static int method211(char c, boolean flag, char c1, char c2) {
        if (!flag) {
            for (int i = 1; i > 0; i++) ;
        }
        if (c2 == c)
            return 1;
        if (c2 >= 'a' && c2 <= 'm') {
            if (c2 == 'a') {
                if (c == '4' || c == '@' || c == '^')
                    return 1;
                return c != '/' || c1 != '\\' ? 0 : 2;
            }
            if (c2 == 'b')
                return c != '1' || c1 != '3' ? 0 : 2;
            if (c2 == 'c')
                return c != '(' && c != '<' && c != '{' && c != '[' ? 0 : 1;
            if (c2 == 'd')
                return 0;
            if (c2 == 'e')
                return c != '3' && c != '\u20AC' ? 0 : 1;
            if (c2 == 'f') {
                if (c == 'p' && c1 == 'h')
                    return 2;
                return c != '\243' ? 0 : 1;
            }
            if (c2 == 'g')
                return c != '9' && c != '6' ? 0 : 1;
            if (c2 == 'h')
                return c != '#' ? 0 : 1;
            if (c2 == 'i')
                return c != 'y' && c != 'l' && c != 'j' && c != '1' && c != '!' && c != ':' && c != ';' && c != '|' ? 0 : 1;
            if (c2 == 'j')
                return 0;
            if (c2 == 'k')
                return 0;
            if (c2 == 'l')
                return c != '1' && c != '|' && c != 'i' ? 0 : 1;
            if (c2 == 'm')
                return 0;
        }
        if (c2 >= 'n' && c2 <= 'z') {
            if (c2 == 'n')
                return 0;
            if (c2 == 'o') {
                if (c == '0' || c == '*')
                    return 1;
                return (c != '(' || c1 != ')') && (c != '[' || c1 != ']') && (c != '{' || c1 != '}') && (c != '<' || c1 != '>') ? 0 : 2;
            }
            if (c2 == 'p')
                return 0;
            if (c2 == 'q')
                return 0;
            if (c2 == 'r')
                return 0;
            if (c2 == 's')
                return c != '5' && c != 'z' && c != '$' && c != '2' ? 0 : 1;
            if (c2 == 't')
                return c != '7' ? 0 : 1;
            if (c2 == 'u') {
                if (c == 'v')
                    return 1;
                return (c != '\\' || c1 != '/') && (c != '\\' || c1 != '|') && (c != '|' || c1 != '/') ? 0 : 2;
            }
            if (c2 == 'v')
                return (c != '\\' || c1 != '/') && (c != '\\' || c1 != '|') && (c != '|' || c1 != '/') ? 0 : 2;
            if (c2 == 'w')
                return c != 'v' || c1 != 'v' ? 0 : 2;
            if (c2 == 'x')
                return (c != ')' || c1 != '(') && (c != '}' || c1 != '{') && (c != ']' || c1 != '[') && (c != '>' || c1 != '<') ? 0 : 2;
            if (c2 == 'y')
                return 0;
            if (c2 == 'z')
                return 0;
        }
        if (c2 >= '0' && c2 <= '9') {
            if (c2 == '0') {
                if (c == 'o' || c == 'O')
                    return 1;
                return (c != '(' || c1 != ')') && (c != '{' || c1 != '}') && (c != '[' || c1 != ']') ? 0 : 2;
            }
            if (c2 == '1')
                return c != 'l' ? 0 : 1;
            else
                return 0;
        }
        if (c2 == ',')
            return c != '.' ? 0 : 1;
        if (c2 == '.')
            return c != ',' ? 0 : 1;
        if (c2 == '!')
            return c != 'i' ? 0 : 1;
        else
            return 0;
    }

    public static byte method212(boolean flag, char c) {
        if (flag)
            aBoolean271 = !aBoolean271;
        if (c >= 'a' && c <= 'z')
            return (byte) ((c - 97) + 1);
        if (c == '\'')
            return 28;
        if (c >= '0' && c <= '9')
            return (byte) ((c - 48) + 29);
        else
            return 27;
    }

    public static void method213(int i, char[] ac) {
        int j = 0;
        int k = 0;
        int l = 0;
        int i1 = 0;
        i = 46 / i;
        while ((j = method214(ac, anInt272, k)) != -1) {
            boolean flag = false;
            for (int j1 = k; j1 >= 0 && j1 < j && !flag; j1++)
                if (!method216(9, ac[j1]) && !method217((byte) 73, ac[j1]))
                    flag = true;

            if (flag)
                l = 0;
            if (l == 0)
                i1 = j;
            k = method215(ac, j, -401);
            int k1 = 0;
            for (int l1 = j; l1 < k; l1++)
                k1 = (k1 * 10 + ac[l1]) - 48;

            if (k1 > 255 || k - j > 8)
                l = 0;
            else
                l++;
            if (l == 4) {
                for (int i2 = i1; i2 < k; i2++)
                    ac[i2] = '*';

                l = 0;
            }
        }
    }

    public static int method214(char[] ac, int i, int j) {
        for (int k = j; k < ac.length && k >= 0; k++)
            if (ac[k] >= '0' && ac[k] <= '9')
                return k;

        if (i != 0)
            return anInt262;
        else
            return -1;
    }

    public static int method215(char[] ac, int i, int j) {
        while (j >= 0)
            aBoolean271 = !aBoolean271;
        for (int k = i; k < ac.length && k >= 0; k++)
            if (ac[k] < '0' || ac[k] > '9')
                return k;

        return ac.length;
    }

    public static boolean method216(int i, char c) {
        if (i < 9 || i > 9)
            throw new NullPointerException();
        return !method218(-682, c) && !method219(c, (byte) -70);
    }

    public static boolean method217(byte byte0, char c) {
        if (byte0 != 73)
            aBoolean271 = !aBoolean271;
        if (c < 'a' || c > 'z')
            return true;
        return c == 'v' || c == 'x' || c == 'j' || c == 'q' || c == 'z';
    }

    public static boolean method218(int i, char c) {
        if (i >= 0) {
            for (int j = 1; j > 0; j++) ;
        }
        return c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z';
    }

    public static boolean method219(char c, byte byte0) {
        if (byte0 != -70) {
            for (int i = 1; i > 0; i++) ;
        }
        return c >= '0' && c <= '9';
    }

    public static boolean method220(byte byte0, char c) {
        if (byte0 != 4)
            anInt270 = -472;
        return c >= 'a' && c <= 'z';
    }

    public static boolean method221(char c, int i) {
        if (i != 8) {
            for (int j = 1; j > 0; j++) ;
        }
        return c >= 'A' && c <= 'Z';
    }

    public static boolean method222(boolean flag, char[] ac) {
        if (flag) {
            for (int i = 1; i > 0; i++) ;
        }
        boolean flag1 = true;
        for (int j = 0; j < ac.length; j++)
            if (!method219(ac[j], (byte) -70) && ac[j] != 0)
                flag1 = false;

        if (flag1)
            return true;
        int k = method223(ac, 9);
        int l = 0;
        int i1 = anIntArray273.length - 1;
        if (k == anIntArray273[l] || k == anIntArray273[i1])
            return true;
        do {
            int j1 = (l + i1) / 2;
            if (k == anIntArray273[j1])
                return true;
            if (k < anIntArray273[j1])
                i1 = j1;
            else
                l = j1;
        } while (l != i1 && l + 1 != i1);
        return false;
    }

    public static int method223(char[] ac, int i) {
        if (ac.length > 6)
            return 0;
        int j = 0;
        if (i != 9) {
            for (int k = 1; k > 0; k++) ;
        }
        for (int l = 0; l < ac.length; l++) {
            char c = ac[ac.length - l - 1];
            if (c >= 'a' && c <= 'z')
                j = j * 38 + ((c - 97) + 1);
            else if (c == '\'')
                j = j * 38 + 27;
            else if (c >= '0' && c <= '9')
                j = j * 38 + ((c - 48) + 28);
            else if (c != 0)
                return 0;
        }

        return j;
    }

    public static int anInt262 = 3073;
    public static int anInt263 = 95;
    public static boolean aBoolean264;
    public static boolean aBoolean265 = true;
    public static byte aByte266 = 75;
    public static byte aByte267 = 75;
    public static byte aByte268 = 6;
    public static byte aByte269 = 6;
    public static int anInt270 = 947;
    public static boolean aBoolean271 = true;
    public static int anInt272;
    public static int[] anIntArray273;
    public static char[][] aCharArrayArray274;
    public static byte[][][] aByteArrayArrayArray275;
    public static char[][] aCharArrayArray276;
    public static char[][] aCharArrayArray277;
    public static int[] anIntArray278;
    public static final String[] aStringArray279 = {
            "cook", "cook's", "cooks", "seeks", "sheet"
    };
    public static int anInt280;

}
