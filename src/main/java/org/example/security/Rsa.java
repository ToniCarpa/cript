package org.example.security;

import javax.crypto.Cipher;
import java.security.KeyPair;
import java.security.KeyPairGenerator;

public class Rsa {
    private Cipher cipher;

    public Rsa() {
        this.cipher = cipher;
    }


    public byte[] cifrarRSA(byte[] texto, KeyPair key) throws Exception {
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.ENCRYPT_MODE, key.getPublic());

        byte[] textoCifrado = cipher.doFinal(texto);
        return textoCifrado;
    }

    public  byte[] descifrarRSA(byte[] textoCifrado, KeyPair key) throws Exception {
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.DECRYPT_MODE, key.getPrivate());

        byte[] textoDescifrado = cipher.doFinal(textoCifrado);
        return textoDescifrado;
    }
    public KeyPair getClaveRSA() throws Exception{
        KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA") ;
        keyGen.initialize(2048);
        KeyPair claves = keyGen.generateKeyPair();
        return claves;
    }
}
