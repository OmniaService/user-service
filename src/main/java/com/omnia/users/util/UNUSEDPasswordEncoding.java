package com.omnia.users.util;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.util.Base64;

public class UNUSEDPasswordEncoding {

    private static final String ALGORITHM = "AES";
    private static final byte[] keyValue = "ADBSJHJS12547896".getBytes();

    public static String encrypt(String valueToEnc) throws Exception {

        Key key = generateKey();
        Cipher c = Cipher.getInstance(ALGORITHM);
        c.init(Cipher.ENCRYPT_MODE, key);

        byte[] encValue = c.doFinal(valueToEnc.getBytes());
        byte[] encryptedByteValue = Base64.getEncoder().encode(encValue);
        return encryptedByteValue.toString();
    }

    public static String decrypt(String encryptedValue) throws Exception {
        Key key = generateKey();
        Cipher c = Cipher.getInstance(ALGORITHM);
        c.init(Cipher.DECRYPT_MODE, key);

        byte[] enctVal = c.doFinal(encryptedValue.getBytes());
        byte[] decordedValue = Base64.getDecoder().decode(enctVal);

        return decordedValue.toString();
    }

    private static Key generateKey() throws Exception {
        Key key = new SecretKeySpec(keyValue, ALGORITHM);
        return key;
    }

}
