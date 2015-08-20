package com.wondersgroup.core.util;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
/**
 * 使用DES加密与解密,可对byte[],String类型进行加密与解密密文可使用String,byte[]存储.
 * 方法:voidgetKey(StringstrKey)从strKey的字条生成一个Key
 * StringgetEncString(StringstrMing)对strMing进行加密,返回String密文String
 * getDesString(StringstrMi)对strMin进行解密,返回String明文
 * byte[]getEncCode(byte[]byteS)byte[]型的加密byte[]getDesCode(byte[]
 * byteD)byte[]型的解密
 */

public class DesEncryptUtil {

    private Key key;

    /**
     * 根据参数生成KEY。
     *
     * @param strKey
     *            密钥key
     */
    public void getKey(String strKey) {
        try {
            KeyGenerator generator = KeyGenerator.getInstance("DES");
            generator.init(new SecureRandom(strKey.getBytes()));
            this.key = generator.generateKey();
            generator = null;
        } catch (NoSuchAlgorithmException ex) {
            throw new RuntimeException(ex);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    /**
     * 加密String明文输入,String密文输出。
     *
     * @param strMing
     *            密码明文
     * @return 密码密文
     */
    public String getEncString(String strMing) {
        return byte2hex(getEncCode(strMing.getBytes()));
    }

    /**
     * 解密以String密文输入,String明文输出
     *
     * @param strMi
     *            密码密文
     * @return 密码明文
     */
    public String getDesString(String strMi) {
        return new String(getDesCode(hex2byte(strMi.getBytes())));
    }

    /**
     * 加密以byte[]明文输入,byte[]密文输出
     *
     * @param byteS
     * @return
     */
    private byte[] getEncCode(byte[] byteS) {
        byte[] byteFina = null;
        Cipher cipher;
        try {
            cipher = Cipher.getInstance("DES");
            cipher.init(Cipher.ENCRYPT_MODE, key);
            byteFina = cipher.doFinal(byteS);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        } finally {
            cipher = null;
        }
        return byteFina;
    }

    /**
     * 解密以byte[]密文输入,以byte[]明文输出
     *
     * @param byteD
     * @return
     */
    private byte[] getDesCode(byte[] byteD) {
        Cipher cipher;
        byte[] byteFina = null;
        try {
            cipher = Cipher.getInstance("DES");
            cipher.init(Cipher.DECRYPT_MODE, key);
            byteFina = cipher.doFinal(byteD);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        } finally {
            cipher = null;
        }
        return byteFina;
    }

    public static String byte2hex(byte[] b) {
        // 一个字节的数，转成16进制字符串
        String hs = "";
        String stmp = "";
        for (int n = 0; n < b.length; n++) {
            // 整数转成十六进制表示
            stmp = (java.lang.Integer.toHexString(b[n] & 0XFF));
            if (stmp.length() == 1)
                hs = hs + "0" + stmp;
            else
                hs = hs + stmp;
        }
        return hs.toUpperCase();// 转成大写
    }

    public static byte[] hex2byte(byte[] b) {
        if ((b.length % 2) != 0)
            throw new IllegalArgumentException("长度不是偶数");
        byte[] b2 = new byte[b.length / 2];
        for (int n = 0; n < b.length; n += 2) {
            String item = new String(b, n, 2);
            // 两位一组，表示一个字节,把这样表示的16进制字符串，还原成一个进制字节
            b2[n / 2] = (byte) Integer.parseInt(item, 16);
        }
        return b2;
    }

    public static void main(String[] args) {
        String strKey = "wonders";
        String password = "密码password";
        System.out.println("明文:" + password);

        DesEncryptUtil des1 = new DesEncryptUtil(); // 实例化一个对像
        des1.getKey(strKey); // 生成密匙
        String strEnc = des1.getEncString(password); // 加密字符串,返回String的密文
        System.out.println("密文:" + strEnc);

        DesEncryptUtil des2 = new DesEncryptUtil(); // 实例化一个对像
        des2.getKey(strKey); // 生成密匙
        String strDes = des2.getDesString(strEnc); // 把String类型的密文解密
        System.out.println("明文:" + strDes);
    }
}
