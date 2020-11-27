package com.at.java;

import org.junit.Test;

import java.io.*;

public class BufferedInputOutputReaderWriterTest {
    /*
    BufferdInputStream
    BufferdOutputStream
    BufferdReader
    BufferdWriter
    缓冲流是转换流的一种可以提高效率
     */
    @Test
    public void BufferedStream(){
        FileInputStream fis = null;
        FileOutputStream fos = null;
        BufferedInputStream bips = null;
        BufferedOutputStream bops = null;
        try {
            //1文件
            File file = new File("1.jpg");
            File file1 = new File("11111.jpg");
            //2、造流
            fis = new FileInputStream(file);
            fos = new FileOutputStream(file1);
            bips = new BufferedInputStream(fis);
            bops = new BufferedOutputStream(fos);


            //3、操作
            byte[] bytes = new byte[10];
            int len ;
            while ((len=bips.read(bytes))!=-1){
                bops.write(bytes,0,len);
                bops.flush();//刷新缓冲区
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4、关闭
//            try {
//                if (fis!=null)
//                fis.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//            try {
//                if (fos!=null)
//                fos.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
            //注意关闭外层流时内层流也会消失
            try {
                if (bips!=null)
                bips.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (bops!=null)
                bops.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }

    @Test
    public void testReaderWriterTest(){
        BufferedReader br = null;
        BufferedWriter bw = null;
        try {
            br = new BufferedReader(new FileReader(new File("hi.txt")));
            bw = new BufferedWriter(new FileWriter(new File("hh.txt")));
//            方式一
//            char[] chars = new char[10];
//            int len;
//            while ((len=br.read(chars))!=-1){
//                bw.write(chars,0,len);
//                bw.flush();
//            }
            //方式二
            String data;
            while ((data=br.readLine())!=null){
//                bw.write(data+"\n");//不包含换行符
                bw.write(data);
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br!=null)
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if(bw!=null)
                bw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
