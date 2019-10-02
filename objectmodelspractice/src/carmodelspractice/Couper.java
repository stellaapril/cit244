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
public class Couper extends Vehicle implements CrashTestable{
    
    public Couper(){
        
    }
    
    public Couper(String carname,int caryear,double carweight,double bumperheight,boolean airbag,double lengthofwheelbase,DrivingMode dm){
        super(carname,caryear,carweight,bumperheight,airbag,lengthofwheelbase,dm);
    }
    

    

    @Override
    public int getVehicleYear() {
        return year;
    }

    @Override
    public DrivingMode getDrivingMode() {
         return DrivingMode.SNOW;
    }

    @Override
    public double getVehicleWeight() {
        weight=925;
        return weight;
    }

    @Override
    public double getFrontBumberHeight() {
        frontBumberHeight=15;
        return frontBumberHeight;
    }

    @Override
    public String frameMaterialIdentifer() {
        frameMaterial="carbon";
        return frameMaterial;
    }

    @Override
    public boolean driverAirbagPresent() {
        airbagPresent=true;
        return airbagPresent;
    }

    @Override
    public double getLengthOfWheelBase() {
        lengthOfWheelBase=120;
        return lengthOfWheelBase;
    }

    @Override
    public double getFrontWeightLevelWeight() {
        frontWeightlevelWeight=700;
        return frontWeightlevelWeight;
    }

    @Override
    public double getFrontWeightWhenRaised() {
        frontWeightwhenRase=3500;
        return frontWeightwhenRase;
    }
    
}
