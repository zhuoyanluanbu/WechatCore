package com.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

/**
 * Created by huyoucheng on 2017/5/26.
 */
public class ValidateWeixin {

    public static String token="jiekuang";

    public static boolean checkSignature(String signature,String timestamp,String nonce){
        //把token timestamp nonce组成字符串数组
        String[] str=new String[]{token,timestamp,nonce};
        //排序
        Arrays.sort(str);
        //拼接
        StringBuffer buff=new StringBuffer();
        for(int i=0;i<str.length;i++){
            buff.append(str[i]);
        }
        //安全验证֤
        MessageDigest md=null;
        String result=null;
        try {
            md=MessageDigest.getInstance("SHA-1");
            byte[] digest=md.digest(buff.toString().getBytes());
        } catch (NoSuchAlgorithmException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return true;
    }



    //将字节数组转16进制字符串
    private static String bytesToStr(byte[] byteArray){
        String strDigest="";
        for(int i=0;i<byteArray.length;i++){
            strDigest+=byteToHexStr(byteArray[i]);
        }
        return strDigest;
    }
    //转16进制
    private static String byteToHexStr(byte mByte){
        char[] digit={'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
        char[] tempArr=new char[2];
        tempArr[0]=digit[(mByte>>>4) & 0X0F];
        tempArr[1]=digit[mByte & 0X0F];
        String s=new String(tempArr);
        return s;
    }


    public static void main(String[] args) {
        String s = "City of Superior市";
        s = s.replace(" ","");
        System.out.println(s);
    }
}
