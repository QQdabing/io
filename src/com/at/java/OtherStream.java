package com.at.java;

import jdk.nashorn.internal.ir.WhileNode;
import jdk.nashorn.internal.objects.annotations.Where;
import org.junit.Test;

import java.io.*;

public class OtherStream {
    /*
    标准的输入输出流
    System.in:标准输入流，默认从键盘输入
    System.out：标准输出流，默认从控制台输出
    常用方法
    System类的setIn(InputStrem in),setOut(PrintStream);
     */
    /*
    练习：从键盘输入字符串，要求读取的字符串转换为大写，并继续输入，当输入为e或exit程序退出
     */
    public static void main(String[] args) {
        BufferedReader br = null;
        try {
            InputStreamReader isr = new InputStreamReader(System.in);
            br = new BufferedReader(isr);
            String data;
            while (true) {
                System.out.println("请输入字符串");
                String s = br.readLine();
                if (s.equalsIgnoreCase("e") || s.equalsIgnoreCase("exit")) {
                    System.out.println("程序结束");
                    break;
                }
                String toUpperCase = s.toUpperCase();
                System.out.println(toUpperCase);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null)
                    br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    @Test
    public void test() {
        /*
        printStream提供一系列的方法
         */

        PrintStream ps = null;
        try {
            FileOutputStream fis = new FileOutputStream("D:\\t.txt",true);
            ps = new PrintStream(fis, true);
            if (ps!=null){
                System.setOut(ps);
            }
            for (int i = 0; i < 255; i++) {
                System.out.print((char)i);
                if (i%50==0){
                    System.out.println();
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (ps!=null)
                ps.close();
        }

    }


    @Test
    public void testData(){
        /*
        数据流：操作基本数据类型和String
        DataInputStream和DataOutputStream

        注意：文件不能双击打开读数据，要用字节流读
         */

        DataOutputStream dos = null;
        try {
            dos = new DataOutputStream(new FileOutputStream("data.txt"));
            dos.writeUTF("lx");
            dos.flush();
            dos.writeInt(23);
            dos.flush();
            dos.writeBoolean(true);
            dos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (dos!=null)
                dos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }



    }

    @Test
    public void readData(){
        DataInputStream dis = null;
        try {
            dis = new DataInputStream(new FileInputStream("data.txt"));
            String s = dis.readUTF();
            int i = dis.readInt();
            boolean b = dis.readBoolean();

            System.out.println("name="+s);
            System.out.println("年龄="+i);
            System.out.println("是否是男="+b);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (dis!=null)
                dis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }

}
