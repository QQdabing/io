package com.at.java2;

import org.junit.Test;

import java.io.*;

public class ObjectStream {
    /*
    对象流
    序列化：写的文件中    ObjectOutputStream

    反序列化：还原到内存中    ObjectInputStream


     */
    @Test
    public void test1() {
        /*
        序列化，反序列化    ObjectOutputStream
        通过java对象保存在磁盘中
         */
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream("object.dat"));
            oos.writeObject(new String("我爱北京天安门"));
            oos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (oos != null)
                    oos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }

    @Test
    public void testObjectInputStream() {
        /*
        反序列化：还原到内存中
         */
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream("object.dat"));

            Object o = ois.readObject();
            String str= (String) o;
            System.out.println(str);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                if (ois!=null)
                ois.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }



}
