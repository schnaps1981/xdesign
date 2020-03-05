package com.y.xdesign.model.utils;

import android.util.Base64;

import java.security.spec.AlgorithmParameterSpec;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class AESTest {
    private  final String key = "kA32q0HEI@%@ax?W~5#QH{w7g@EshiFN";
    private  byte[] ivBytes = {0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00};

    public  String encode(String str) {
        try {
            byte[] textBytes = str.getBytes("UTF-8");

            AlgorithmParameterSpec ivSpec = new IvParameterSpec(ivBytes);
            SecretKeySpec newKey = new SecretKeySpec(key.getBytes("UTF-8"), "AES");

            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, newKey, ivSpec);

            return Base64.encodeToString(cipher.doFinal(textBytes), 0);
        } catch (Exception e) {
            return null;
        }
    }
}