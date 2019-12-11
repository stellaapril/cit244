/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cryptpgraphy;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.xml.bind.DatatypeConverter;

/**
 *
 * @author cst
 */
public class Controller {
    private Model model;
    private View view;
    private Controller con;
    final static String FILE_NAME ="names.txt";
    
    public static void setupMVC(){
        Controller control = new Controller();
        
    }
    
    public void createModel(){
        model=new Model();
        model.writeFile(FILE_NAME);
        //need a readfile()
    }
    
    public void createView(){
        view = new View();
        //need setcontroller
    }
    
    public void hash(){
        
        final String importantMessage="cit24444";
        try{
            MessageDigest digester = MessageDigest.getInstance("MD5");
            
            digester.update(importantMessage.getBytes());
            
            String hash =DatatypeConverter.printHexBinary(digester.digest());
            
            System.out.println("hahsed value: " + hash);
        } catch(NoSuchAlgorithmException ex){
            System.out.println(ex);
        }
    }
    
}
