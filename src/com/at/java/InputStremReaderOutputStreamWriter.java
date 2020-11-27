package com.at.java;

import org.junit.Test;

import java.io.*;

public class InputStremReaderOutputStreamWriter {
    /*
    InputStreamReader 将一个字节的输入流转换为字符的输入流
    OutputStreamWriter  将一个字节的输出流转换为字符的输出流
    作用：提供字符的转换

    解码：字节---字符
    编码：字符---字节

     */


    @Test
    public void test1(){
        InputStreamReader isr = null;
        try {
            FileInputStream fis = new FileInputStream("11111.txt");

            isr = new InputStreamReader(fis,"utf-8");

            char[] cbuf = new char[11];
            int len;
            while ((len=isr.read(cbuf))!=-1){
                String s = new String(cbuf, 0, len);
                System.out.print(s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (isr!=null)
                isr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    /*
    综合使用InputStreamReader和OutputStreamWriter
     */

    @Test
    public void test2(){
        InputStreamReader isr= null;
        OutputStreamWriter osw = null;
        try {
            File file = new File("hh.txt");
            File file1 = new File("j.txt");
            FileInputStream fis = new FileInputStream(file);
            FileOutputStream fos = new FileOutputStream(file1);
            isr = new InputStreamReader(fis,"utf-8");
            osw = new OutputStreamWriter(fos,"gbk");
            char[] cbuf = new char[10];
            int len;
            while ((len=isr.read(cbuf))!=-1){
                osw.write(cbuf,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            try {
                if (isr!=null)
                isr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (osw!=null)
                osw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }



}
