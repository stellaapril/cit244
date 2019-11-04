/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package diffiepractice;

import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.KeyAgreement;
import javax.crypto.interfaces.DHPublicKey;
import javax.crypto.spec.DHParameterSpec;

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

    }
}
