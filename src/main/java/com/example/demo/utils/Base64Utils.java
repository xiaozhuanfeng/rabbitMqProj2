package com.example.demo.utils;

import org.apache.tomcat.util.codec.binary.Base64;

import java.io.*;

public class Base64Utils {

    public static String byte2Str(byte[] byteArr) {
        return Base64.encodeBase64String(byteArr);
    }

    /**
     * 对象类型转byte
     *
     * @param obj
     * @return
     * @throws IOException
     */
    public static byte[] obj2byte(Object obj) throws IOException {
        ObjectOutputStream oo = null;
        ByteArrayOutputStream bo = null;
        try {
            byte[] bytes;
            bo = new ByteArrayOutputStream();
            oo = new ObjectOutputStream(bo);
            oo.writeObject(obj);
            bytes = bo.toByteArray();
            return bytes;
        } finally {
            if (null != oo) {
                oo.close();
            }
            if (null != bo) {
                bo.close();
            }
        }
    }

    /**
     * 字节类型转对象类型
     * @param bytes
     * @return
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public static Object byteToObj(byte[] bytes) throws IOException, ClassNotFoundException {
        Object obj = null;
        ByteArrayInputStream bi = null;
        ObjectInputStream oi = null;
        try {
            bi = new ByteArrayInputStream(bytes);
            oi = new ObjectInputStream(bi);

            obj = oi.readObject();
            bi.close();
            oi.close();
        } finally {
            if (null != oi) {
                oi.close();
            }
            if (null != bi) {
                bi.close();
            }
        }
        return obj;
    }

}
