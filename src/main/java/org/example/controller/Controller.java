package org.example.controller;

import org.example.security.Des;
import org.example.security.Rsa;

import javax.crypto.SecretKey;
import java.security.KeyPair;
import java.util.Arrays;

public class Controller {
    private String fraseRsa;
    private String fraseDes;
    private Des des;
    private Rsa rsa;

    public Controller() {
        this.fraseRsa = "Esto es la frase1";
        this.fraseDes = "Esto es la frase2";
        this.des = new Des();
        this.rsa = new Rsa();
    }

    public void init() {
        try {
            finDES();
            finRSA();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


        public String finDES() throws Exception {
        SecretKey claveDes = (SecretKey) des.getClaveDES();
        byte[] textoCifradoDes = des.cifrarDES(fraseDes, claveDes);
        String textoDescifradoDes = des.descifrarDES(textoCifradoDes, claveDes);
        return "Texto original: " + fraseDes
                + "Texto cifrado: " + new String(textoCifradoDes)
                + "Texto descifrado: " + textoDescifradoDes;
    }

    public String finRSA() throws Exception {
        KeyPair claveRSA = rsa.getClaveRSA();
        byte[] textoCifradoDes = rsa.cifrarRSA(fraseRsa.getBytes(), claveRSA);
        String textoDescifradoDes = Arrays.toString(rsa.descifrarRSA(textoCifradoDes, claveRSA));
        return "Texto original: " + fraseRsa
                + "Texto cifrado: " + new String(textoCifradoDes)
                + "Texto descifrado: " + textoDescifradoDes;
    }









}
