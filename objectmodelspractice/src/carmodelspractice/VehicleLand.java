/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carmodelspractice;

import inheritancepractice.CrashTestable;

/**
 *
 * @author cst
 */
public class VehicleLand {
    public static void main(String[] args) {
        SUV s = new SUV(2010,"Audi",4);
        Couper v = new Couper(2018,"Ford",2);
        System.out.println(v.getVehicleYear());
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
