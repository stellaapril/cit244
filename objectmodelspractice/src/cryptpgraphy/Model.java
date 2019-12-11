/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cryptpgraphy;

import gui_studentlist.Student;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;


/**
 *
 * @author cst
 */
public class Model {
    public void writeFile(String fileName) {
        PrintWriter fileWriter = null;
        StringBuilder sb = new StringBuilder();
        sb.append("src/files/");
        sb.append(fileName);
        try {
            java.io.File nameFile = new java.io.File(sb.toString());
            System.out.println("Writing to: " + nameFile.getAbsolutePath());
            
            
            fileWriter = new PrintWriter(nameFile);
            fileWriter.println("Hashing Hashing");
            fileWriter.println("cit244");
            fileWriter.flush();
            fileWriter.close();
        } catch (FileNotFoundException ex) {
            System.out.println(ex);
        } finally {
            if (fileWriter != null) {
                fileWriter.close();
            }
        }
    }

    
    
}
