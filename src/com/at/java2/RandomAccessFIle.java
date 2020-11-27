package com.at.java2;

import com.sun.org.apache.xpath.internal.WhitespaceStrippingElementMatcher;
import org.junit.Test;


import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomAccessFIle {
    /*
    直接继承于Object实现了两个接口DataInputStream和DataOutputStream,既可以输入也可以输出
     */
    @Test
    public void test1(){
        RandomAccessFile r1 = null;
        RandomAccessFile r2 = null;
        try {
            r1 = new RandomAccessFile("1.jpg", "r");
            r2 = new RandomAccessFile("w.jpg", "rw");
            byte[] bytes = new byte[1024];
            int len;
            while ((len=r1.read(bytes))!=-1){
                r2.write(bytes,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (r1!=null)
                r1.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (r2!=null)
                r2.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    @Test
    public void test2(){
        /*
        作为输出流，如果文件存在会从第一个开始覆盖
         */
        RandomAccessFile rw = null;
        try {
            rw = new RandomAccessFile("11111.txt", "rw");
            rw.seek(3);
            rw.write("werwe".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rw!=null)
                rw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
