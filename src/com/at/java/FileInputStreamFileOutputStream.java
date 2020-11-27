package com.at.java;

import org.junit.Test;

import java.io.*;

public class FileInputStreamFileOutputStream {
    @Test
    public void testInputStream() {
        FileInputStream fs = null;
        try {
            //1、文件
            File file = new File("hi.txt");
            //2、流
            fs = new FileInputStream(file);
            //3、操作流
            byte[] bytes = new byte[10];
            int len;
            while ((len = fs.read(bytes)) != -1) {
                for (int i = 0; i < len; i++) {
                    System.out.print((char) bytes[i]);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fs != null)
                    fs.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    @Test
    public void testInputOutputStream() {
        /*
        实现图片复制操作
         */
        FileInputStream is = null;
        FileOutputStream os = null;
        try {
            //1、文件
            File file = new File("1.jpg");
            File file1 = new File("2.jpg");
            //2、流
            is = new FileInputStream(file);
            os = new FileOutputStream(file1);

            //3、操作
            byte[] bytes = new byte[10];
            int len;
            while ((len = is.read(bytes)) != -1) {
//                for (int i = 0; i < len; i++) {
//                    os.write(bytes[i]);
                os.write(bytes, 0, len);

            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4、关闭资源
            try {
                if (is != null)
                    is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (is != null)
                    os.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }


    /*
    指定路径文件的复制
     */
    public void copyFile(String oldFile, String newFile) {

        FileInputStream is = null;
        FileOutputStream os = null;
        try {
            //1、文件
            File file = new File(oldFile);
            File file1 = new File(newFile);
            //2、流
            is = new FileInputStream(file);
            os = new FileOutputStream(file1);

            //3、操作
            byte[] bytes = new byte[10];
            int len;
            while ((len = is.read(bytes)) != -1) {
//                for (int i = 0; i < len; i++) {
//                    os.write(bytes[i]);
                os.write(bytes, 0, len);

            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4、关闭资源
            try {
                if (is != null)
                    is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (is != null)
                    os.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void testCopyFile(){
        long startTime = System.currentTimeMillis();
        copyFile("1.jpg","D:/hi.jpg");
        long endTime = System.currentTimeMillis();
        System.out.println("复制时间为："+(endTime-startTime));
    }
}
