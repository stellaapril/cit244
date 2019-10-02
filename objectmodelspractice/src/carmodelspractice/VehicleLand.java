/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carmodelspractice;

import inheritancepractice.CrashTestable;
import inheritancepractice.DrivingMode;

/**
 *
 * @author cst
 */
public class VehicleLand {
    public static void main(String[] args) {
        //constructor name,year,weight,bunberheight,airbag
        Van honda = new Van("odyssey",2010,4640,22,true,118.1,DrivingMode.ECO);
        SUV jeep = new SUV("grand_cherokee",2015,5150,24,true,114.8,DrivingMode.SNOW);
        Couper ford = new Couper("mustang",2014,3735,14,true,107.1,DrivingMode.SPORTY);
        Hatchback civic = new Hatchback("civic",1995,2390,14,true,103.2,DrivingMode.NULL);
        Convertible bmw = new Convertible("4series",2018,4270,16,true,110.6,DrivingMode.SPORTY);
        
        display(jeep);
        display(honda);
        display(ford);
        display(civic);
        display(bmw);
        
    }
    
        public static void display(Vehicle v){
            
            System.out.println("Test Result of "+v.name+"is: "+crash(v));
            
        }
    
        public static double crash(CrashTestable ct){
        double score=0.0;
        if(ct.getVehicleYear()>2010){
            score=score+1;
        }
        
        if(ct.getVehicleWeight()<4000){
            score=score-1;
        }
        
        if(ct.getFrontBumberHeight()>15){
            score=score+1;
        }
        
        if(ct.driverAirbagPresent()){
            score=score+1;
        }
        
        if(ct.getLengthOfWheelBase()>110){
            score=score+1;
        }
        
        
        
        return score;
    }
    
}
