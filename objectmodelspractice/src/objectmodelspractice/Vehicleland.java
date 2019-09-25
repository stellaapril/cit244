/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objectmodelspractice;

import inheritancepractice.CrashTestable;

/**
 *
 * @author sitian.chen
 */
public class Vehicleland {
    public static void main(String[] args){
        Antiquecar c = new Antiquecar();
    }
    
    public static double crash(CrashTestable ct){
        double score=0.0;
        
        if(ct.driverAirbagPresent()){
            score=score+1;
        }
        if(ct.getFrontBumberHeight()<15){
            score=score+1.23;
        }
        
        
        return score;
    }
}
