package org.example.security;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.security.SecureRandom;

public class Des {
    private Cipher cipher;

    public Des() {
        this.cipher = cipher;
    }

    public byte[] cifrarDES(String texto, SecretKey key) throws Exception {
        cipher = Cipher.getInstance("DES");
        cipher.init(Cipher.ENCRYPT_MODE, key);
        byte[] textoCifrado = cipher.doFinal(texto.getBytes(StandardCharsets.UTF_8));
        return textoCifrado;
    }

    public  String descifrarDES(byte[] textoCifrado, SecretKey clave) throws Exception {
        Cipher cipher = Cipher.getInstance("DES");
        cipher.init(Cipher.DECRYPT_MODE, clave);

        byte[] textoDescifrado = cipher.doFinal(textoCifrado);
        return new String(textoDescifrado, StandardCharsets.UTF_8);
    }

    public Key getClaveDES() throws Exception{
        KeyGenerator keyGenerator = KeyGenerator.getInstance("DES");
        keyGenerator.init(new SecureRandom());
        SecretKey clave = keyGenerator.generateKey();
        return clave;
    }


}
