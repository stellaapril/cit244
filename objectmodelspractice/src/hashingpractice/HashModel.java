/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashingpractice;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;
import javax.xml.bind.DatatypeConverter;

/**
 *
 * @author cst
 */
public class HashModel {
    //private String hashtext;
    
  
    public void setHashing() throws NoSuchAlgorithmException{
        System.out.println("Please input your text");
        Scanner userInput = new Scanner(System.in);
        String hashtext = userInput.next();
        
        try{
            MessageDigest digester = MessageDigest.getInstance("MD5");
            
            digester.update(hashtext.getBytes());
            
            String hash =DatatypeConverter.printHexBinary(digester.digest());
            
            System.out.println("hahsed value: " + hash);
        } catch(NoSuchAlgorithmException ex){
            System.out.println(ex);
        }
        
    }
}
