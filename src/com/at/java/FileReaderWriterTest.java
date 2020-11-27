package com.at.java;

import org.junit.Test;

import java.io.*;

public class FileReaderWriterTest {
    /*
    将hi.txt中的内容读到内存并输出到控制台
     */
    @Test
    public void test() {
        FileReader fr = null;
        try {
            //1、实例化File类对象指明操作文件
            File file = new File("hi.txt");//相较于当前工程
            //2、提供具体的流（异常）
            fr = new FileReader(file);
            //3、数据读入
            //fr.read():返回文件读入的一个字符。如果达到末尾，返回-1
            int read;
            //避免一上来就是-1
            while ((read = fr.read()) != -1) {
                System.out.print((char) read);
                read = fr.read();
            }
            //4、流的关闭
            fr.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fr != null) {
                    fr.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    /*
    使用read中的重载方法
     */
    @Test
    public void testR() {
        //1、File的实例化
        File file = new File("hi.txt");
        //2、流的实例化
        FileReader fr = null;
        try {
            //3、读入的 操作
            fr = new FileReader(file);
            char[] chars = new char[5];//一次读取几个数
            int len;
            while ((len = fr.read(chars)) != -1) {
                //方式一：
//            for (int i = 0; i < len; i++) {
//                System.out.print(chars[i]);
//            }
                //方式二：
                String s = new String(chars, 0, len);
                System.out.print(s);
            }
            ;

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //4、流的关闭
            try {
                if (fr != null)
                    fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    /*
    从内存中写入输入到硬盘文件，
    说明：输出操作对应的file可以不存在，如果不存在，在输出的过程中会自动创建
                如果存在：如果要覆盖就是用构造器FileWriter(file),如果要添加使用构造器FileWriter(file,true)
     */
    @Test
    public void testFile()  {
        FileWriter fileWriter = null;
        try {
            //1、提供File对象提供一个文件
            File file = new File("hi1.txt");
            //2、提供FileReader对象，用于数据写出
            fileWriter = new FileWriter(file,true);
            //3、写出操作
            fileWriter.write("nihoa");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4、关闭流
            try {
                if(fileWriter!=null)
                    fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }


    /*
    file的复制操作
     */
    @Test
    public void testFileReaderFileWriter() {
        FileReader fileReader = null;
        FileWriter fileWriter = null;
        try {
            //1、指定读入和读出的文件
            File srcFile = new File("hi1.txt");
            File descFile = new File("hi2.txt");

            //2、指定流
            fileReader = new FileReader(srcFile);
            fileWriter = new FileWriter(descFile);
            //3、数据读入写出操作
            char[] cbuf = new char[2];
            int len;
            while ((len=fileReader.read(cbuf))!=-1){
                fileWriter.write(cbuf,0,len);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //4、关闭资源
            try {
                if (fileReader!=null)
                    fileReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if(fileWriter!=null)
                    fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
    