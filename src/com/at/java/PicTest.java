package com.at.java;

import org.junit.Test;

import java.io.*;

public class PicTest {
    @Test
    public void test()  {
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            //FileInputStream使用路径构造器
            fis = new FileInputStream("1.jpg");
            fos = new FileOutputStream("secret1.jpg");

            byte[] buf = new byte[20];
            int len;
            while((len=fis.read(buf))!=-1){

                for (int i = 0; i < len; i++) {
                    buf[i] = (byte)(buf[i] ^5);

                }
                fos.write(buf,0,len);

            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(fis!=null)
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if(fis!=null)
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }
    @Test
    public void test1()  {
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            //FileInputStream使用路径构造器
            fis = new FileInputStream("secret1.jpg");
            fos = new FileOutputStream("3.jpg");

            byte[] buf = new byte[20];
            int len;
            while((len=fis.read(buf))!=-1){

                for (int i = 0; i < len; i++) {
                    buf[i] = (byte)(buf[i] ^5);

                }
                fos.write(buf,0,len);

            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(fis!=null)
                    fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if(fis!=null)
                    fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }
}
