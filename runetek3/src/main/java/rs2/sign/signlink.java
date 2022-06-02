package rs2.sign;

// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   signlink.java

import java.applet.Applet;
import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.URL;

public class signlink
    implements Runnable
{

    public static void startpriv(InetAddress inetaddress)
    {
        if(active)
        {
            return;
        } else
        {
            socketip = inetaddress;
            Thread thread = new Thread(new signlink());
            thread.setDaemon(true);
            thread.start();
            return;
        }
    }

    public void run()
    {
        if(active)
            return;
        active = true;
        String s = findcachedir();
        do
        {
            if(socketreq != 0)
            {
                try
                {
                    socket = new Socket(socketip, socketreq);
                }
                catch(Exception _ex)
                {
                    socket = null;
                }
                socketreq = 0;
            }
            if(threadreq != null)
            {
                Thread thread = new Thread(threadreq);
                thread.setDaemon(true);
                thread.start();
                thread.setPriority(threadreqpri);
                threadreq = null;
            }
            if(dnsreq != null)
            {
                try
                {
                    dns = InetAddress.getByName(dnsreq).getHostName();
                }
                catch(Exception _ex)
                {
                    dns = "unknown";
                }
                dnsreq = null;
            }
            if(loadreq != null)
            {
                loadbuf = null;
                try
                {
                    File file = new File(s + loadreq);
                    if(file.exists())
                    {
                        int i = (int)file.length();
                        loadbuf = new byte[i];
                        DataInputStream datainputstream = new DataInputStream(new FileInputStream(s + loadreq));
                        datainputstream.readFully(loadbuf, 0, i);
                        datainputstream.close();
                    }
                }
                catch(Exception _ex) { }
                loadreq = null;
            }
            if(savereq != null)
            {
                try
                {
                    FileOutputStream fileoutputstream = new FileOutputStream(s + savereq);
                    fileoutputstream.write(savebuf, 0, savebuf.length);
                    fileoutputstream.close();
                }
                catch(Exception _ex) { }
                savereq = null;
            }
            if(urlreq != null)
            {
                try
                {
                    urlstream = new DataInputStream((new URL(mainapp.getCodeBase(), urlreq)).openStream());
                }
                catch(Exception _ex)
                {
                    urlstream = null;
                }
                urlreq = null;
            }
            try
            {
                Thread.sleep(looprate);
            }
            catch(Exception _ex) { }
        } while(true);
    }

    public static String findcachedir()
    {
        String as[] = {
            "c:/windows/", "c:/winnt/", "d:/windows/", "d:/winnt/", "e:/windows/", "e:/winnt/", "f:/windows/", "f:/winnt/", "c:/", "~/", 
            "/tmp/", ""
        };
        String s = ".file_store_32";
        for(int i = 0; i < as.length; i++)
            try
            {
                String s1 = as[i];
                if(s1.length() > 0)
                {
                    File file = new File(s1);
                    if(!file.exists())
                        continue;
                }
                File file1 = new File(s1 + s);
                if(file1.exists() || file1.mkdir())
                    return s1 + s + "/";
            }
            catch(Exception _ex) { }

        return null;
    }

    public static long gethash(String s)
    {
        s = s.trim();
        long l = 0L;
        for(int i = 0; i < s.length() && i < 12; i++)
        {
            char c = s.charAt(i);
            l *= 37L;
            if(c >= 'A' && c <= 'Z')
                l += (1 + c) - 65;
            else
            if(c >= 'a' && c <= 'z')
                l += (1 + c) - 97;
            else
            if(c >= '0' && c <= '9')
                l += (27 + c) - 48;
        }

        return l;
    }

    public static void looprate(int i)
    {
        looprate = i;
    }

    public static byte[] cacheload(String s)
    {
        if(!active)
            return null;
        if(loadreq != null)
            return null;
        for(loadreq = String.valueOf(gethash(s)); loadreq != null;)
            try
            {
                Thread.sleep(1L);
            }
            catch(Exception _ex) { }

        return loadbuf;
    }

    public static void cachesave(String s, byte abyte0[])
    {
        if(!active)
            return;
        if(savereq != null)
            return;
        if(abyte0.length > 0x1e8480)
            return;
        savebuf = abyte0;
        for(savereq = String.valueOf(gethash(s)); savereq != null;)
            try
            {
                Thread.sleep(1L);
            }
            catch(Exception _ex) { }

    }

    public static Socket opensocket(int i)
        throws IOException
    {
        for(socketreq = i; socketreq != 0;)
            try
            {
                Thread.sleep(50L);
            }
            catch(Exception _ex) { }

        if(socket == null)
            throw new IOException("could not open socket");
        else
            return socket;
    }

    public static String dnslookup(String s)
    {
        return "unknown";
    }

    public static void startthread(Runnable runnable, int i)
    {
        threadreqpri = i;
        threadreq = runnable;
    }

    public static DataInputStream openurl(String s)
        throws IOException
    {
        for(urlreq = s; urlreq != null;)
            try
            {
                Thread.sleep(50L);
            }
            catch(Exception _ex) { }

        if(urlstream == null)
            throw new IOException("could not open: " + s);
        else
            return urlstream;
    }

    public static void reporterror(String s)
    {
        if(!reporterror)
            return;
        System.out.println("Error: " + s);
        try
        {
            s = s.replace('@', '_');
            s = s.replace('&', '_');
            s = s.replace('#', '_');
            DataInputStream datainputstream = openurl("reporterror" + 194 + ".cgi?error=" + errorname + " " + s);
            datainputstream.readLine();
            datainputstream.close();
            return;
        }
        catch(IOException _ex)
        {
            return;
        }
    }

    public signlink()
    {
    }

    public static final int clientversion = 194;
    public static Applet mainapp;
    public static boolean sunjava;
    public static boolean active;
    public static InetAddress socketip;
    public static int socketreq;
    public static Socket socket = null;
    public static int threadreqpri = 1;
    public static Runnable threadreq = null;
    public static String dnsreq = null;
    public static String dns = null;
    public static String loadreq = null;
    public static byte loadbuf[] = null;
    public static String savereq = null;
    public static byte savebuf[] = null;
    public static String urlreq = null;
    public static DataInputStream urlstream = null;
    public static String midi = null;
    public static String jingle = null;
    public static int jinglelen = 3500;
    public static int looprate = 100;
    public static boolean reporterror = true;
    public static String errorname = "";

}
