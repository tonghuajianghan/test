package com.wondersgroup.core.util;

import java.security.MessageDigest;

public class MD5Util {
    /**
     * 对指定字节数组进行MD5加密，返回字符串结果
     * 
     * @param source 传入字节数组
     * @return
     */
    public static String getMD5(byte[] source) {
        String s = null;
        char hexDigits[] = { // 用来将字节转换成 16 进制表示的字符
        '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(source);
            byte tmp[] = md.digest();

            // MD5 的计算结果是一个 128 位的长整数，用字节表示就是 16 个字节
            // 每个字节用 16 进制表示的话，使用两个字符，所以表示成 16 进制需要 32 个字符
            char str[] = new char[16 * 2];

            int k = 0; // 表示转换结果中对应的字符位置
            // 从第一个字节开始，对 MD5 的每一个字节转换成 16 进制字符
            for (int i = 0; i < 16; i++) {
                byte byte0 = tmp[i]; // 取第 i 个字节
                str[k++] = hexDigits[byte0 >>> 4 & 0xf]; // 取字节中高 4 位的数字转换,
                // >>> 为逻辑右移，将符号位一起右移
                str[k++] = hexDigits[byte0 & 0xf]; // 取字节中低 4 位的数字转换
            }

            // 换后的结果转换为字符串
            s = new String(str);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return s;
    }

    /**
     * 取得MD5加密字符串。
     * 
     * @param str 加密前的字符串
     * @return 加密后的字符串
     */
    public static String getMD5(String str) {
        String digest = "";

        try {
            MessageDigest currentAlgorithm = MessageDigest.getInstance("md5");
            currentAlgorithm.reset();
            byte[] mess = str.getBytes();
            byte[] hash = currentAlgorithm.digest(mess);
            for (int i = 0; i < hash.length; i++) {
                int v = hash[i];
                if (v < 0) {
                    v = 256 + v;
                }
                if (v < 16) {
                    digest += "0";
                }
                digest += Integer.toString(v, 16).toUpperCase() + "";
            }
        } catch (Exception ex) {
            digest = str;
        }

        return digest;
    }

    public static void main(String args[]) throws Exception {
        // System.out.println(getMD5("ting1111".getBytes()));
        // System.out.println(getMD5("ting1111"));
    }
}