package org.example.security;

import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.security.NoSuchAlgorithmException;

public class DES {
    private Cipher cipher;

    public DES(Cipher cipher) {
        this.cipher = cipher;
    }

    public byte[] cifra(String texto, SecretKey key) throws Exception {
        cipher = Cipher.getInstance("DES");
        cipher.init(Cipher.ENCRYPT_MODE, key);
        byte[] textoCifrado = cipher.doFinal(texto.getBytes(StandardCharsets.UTF_8));ç
        return textoCifrado;
    }

}
