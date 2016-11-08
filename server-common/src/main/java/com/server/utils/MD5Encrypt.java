/**
 * 
 */
package com.server.utils;

import java.security.MessageDigest;

/**
 * MD5算法，与.net MD5算法同步
 * @author Yuyuan
 *
 */
public class MD5Encrypt {

	//将字符串加密成MD5，32位16进制字串，如"3031209"转成"e043a49740adde7aae4f34818c52528e"    
    public static String EncodeMD5Hex(String text) throws Exception {
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(text.getBytes()); 
        byte[] digest = md.digest();
        StringBuffer md5 = new StringBuffer();
        for (int i = 0; i < digest.length; i++) {    
            md5.append(Character.forDigit((digest[i] & 0xF0) >> 4, 16));
            md5.append(Character.forDigit((digest[i] & 0xF), 16));
        }    
        return md5.toString();    
    }    
    
    //将ASCII字串编码成16进制字串,如：“?C??@??z?O4??RR?“转成”3f433f3f403f3f7a3f4f343f3f52523f“    
    //参数text    
    //返回结果16进制字符串    
    public static String DecodeMD5Hex(String text) throws Exception {
        byte[] digest = text.getBytes();            
        StringBuffer md5 = new StringBuffer();
        for (int i = 0; i < digest.length; i++) {    
            md5.append(Character.forDigit((digest[i] & 0xF0) >> 4, 16));
            md5.append(Character.forDigit((digest[i] & 0xF), 16));
        }    
        return md5.toString();
    }
}
