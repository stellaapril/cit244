/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package diffiepractice;

import java.security.AlgorithmParameters;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.Cipher;
import javax.crypto.KeyAgreement;

import javax.crypto.interfaces.DHPublicKey;
import javax.crypto.spec.DHParameterSpec;
import javax.crypto.spec.SecretKeySpec;




/**
 *
 * @author sitian.chen
 */
public class DHKeyAgreement {


    private DHKeyAgreement(){
        
    }
    
    public static void main(String argv[])throws Exception{
        //jerry create DH key pair with 2048-bit size
        System.out.println("Jerry: Generate DH keypair ...");
        KeyPairGenerator jerryKpairGen=KeyPairGenerator.getInstance("DH");
        jerryKpairGen.initialize(2048);
        KeyPair jerryKpair = jerryKpairGen.generateKeyPair();
        
        //jerry creates and initializes his DH KeyAgreement object
        System.out.println("Jerry: initialization...");
        KeyAgreement jerryKeyAgree = KeyAgreement.getInstance("DH");
        jerryKeyAgree.init(jerryKpair.getPrivate());
        
        //jerry encode his public key and sends it to tom
        byte[] jerryPubKeyEnc =jerryKpair.getPublic().getEncoded();
        
        //???
        KeyFactory tomKeyFac = KeyFactory.getInstance("DH");
        X509EncodedKeySpec x509KeySpec = new X509EncodedKeySpec(jerryPubKeyEnc);

        PublicKey jerryPubKey = tomKeyFac.generatePublic(x509KeySpec);
        
        //tom gets the DH parameters associated with jerry's public key
        //embodies the exchange of the keys across some network
        //assuming both computers are speaking JAVA
        DHParameterSpec dhParamFromJerryPubKey =((DHPublicKey)jerryPubKey).getParams();
        
        
        //Tom create his own dh key pair
        System.out.println("Tom: Generate DH keypair ...");
        KeyPairGenerator tomKpairGen=KeyPairGenerator.getInstance("DH");
        tomKpairGen.initialize(dhParamFromJerryPubKey);
        KeyPair tomKpair = tomKpairGen.generateKeyPair();
        
        
        System.out.println("Tom: Initialization ...");
        KeyAgreement tomKeyAgree = KeyAgreement.getInstance("DH");
        tomKeyAgree.init(tomKpair.getPrivate());
        
        //tom encode
        byte[] tomPubKeyEnc = tomKpair.getPublic().getEncoded();
        
        KeyFactory jerryKeyFac = KeyFactory.getInstance("DH");
        x509KeySpec = new X509EncodedKeySpec(tomPubKeyEnc);
        PublicKey tomPubKey = jerryKeyFac.generatePublic(x509KeySpec);
        System.out.println("Jerry: Execute PHASE1 ...");
        jerryKeyAgree.doPhase(tomPubKey, true);
        
        System.out.println("Tom: Execute PHASE1 ...");
        tomKeyAgree.doPhase(jerryPubKey,true);
        
        //jerry and tom have completed the dh key
        
        
//        try{
            byte[] jerrySharedSecret = jerryKeyAgree.generateSecret();
            int jerryLen = jerrySharedSecret.length;
            byte[] tomSharedSecret = new byte[jerryLen];
            int tomLen;
//        }catch (ShortBufferException e) {
//            System.out.println(e.getMessage());
//        } // provide output buffer of required size
         
        tomLen = tomKeyAgree.generateSecret(tomSharedSecret, 0);
        System.out.println("Jerry secret: " +
                toHexString(jerrySharedSecret));
        System.out.println("Tom secret: " +
                toHexString(tomSharedSecret));
        if (!java.util.Arrays.equals(jerrySharedSecret, tomSharedSecret))
            throw new Exception("Shared secrets differ");
        System.out.println("Shared secrets are the same");
         
        
        System.out.println("Use shared secret as SecretKey object ...");
        SecretKeySpec tomAesKey = new SecretKeySpec(tomSharedSecret, 0, 16, "AES");
        SecretKeySpec jerryAesKey = new SecretKeySpec(jerrySharedSecret, 0, 16, "AES");
        
        
        Cipher tomCipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        tomCipher.init(Cipher.ENCRYPT_MODE, tomAesKey);
        byte[] cleartext = "This is just an example".getBytes();
        byte[] ciphertext = tomCipher.doFinal(cleartext);
        
        byte[] encodedParams = tomCipher.getParameters().getEncoded();
        
        
        AlgorithmParameters aesParams = AlgorithmParameters.getInstance("AES");
        aesParams.init(encodedParams);
        Cipher jerryCipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        jerryCipher.init(Cipher.DECRYPT_MODE, jerryAesKey, aesParams);
        byte[] recovered = jerryCipher.doFinal(ciphertext);
        if (!java.util.Arrays.equals(cleartext, recovered))
            throw new Exception("AES in CBC mode recovered text is " +
                    "different from cleartext");
        System.out.println("AES in CBC mode recovered text is same as cleartext");
        

    }
    
     private static void byte2hex(byte b, StringBuffer buf) {
        char[] hexChars = { '0', '1', '2', '3', '4', '5', '6', '7', '8',
                '9', 'A', 'B', 'C', 'D', 'E', 'F' };
        int high = ((b & 0xf0) >> 4);
        int low = (b & 0x0f);
        buf.append(hexChars[high]);
        buf.append(hexChars[low]);
    }
    
    private static String toHexString(byte[] block) {
        StringBuffer buf = new StringBuffer();
        int len = block.length;
        for (int i = 0; i < len; i++) {
            byte2hex(block[i], buf);
            if (i < len-1) {
                buf.append(":");
            }
        }
        return buf.toString();
    }
}


