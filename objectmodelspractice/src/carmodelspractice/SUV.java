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
public class SUV extends Vehicle implements CrashTestable{
    
    
    //constructor
    public SUV(){
        
    }
    
    public SUV(String carname,int caryear,double carweight,double bumperheight,boolean airbag,double lengthofwheelbase,DrivingMode dm){
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
        weight=4513;
        return weight;
    }
    

    @Override
    public double getFrontBumberHeight() {
        frontBumberHeight=22;
        return frontBumberHeight;
    }

    @Override
    public String frameMaterialIdentifer() {
        frameMaterial="steel";
        return frameMaterial;
    }

    @Override
    public boolean driverAirbagPresent() {
        airbagPresent=true;
        return airbagPresent;
    }

    @Override
    public double getLengthOfWheelBase() {
        lengthOfWheelBase=170;
        return lengthOfWheelBase;
    }

    @Override
    public double getFrontWeightLevelWeight() {
        frontWeightlevelWeight=4000;
        return frontWeightlevelWeight;
    }

    @Override
    public double getFrontWeightWhenRaised() {
        frontWeightwhenRase=3500;
        return frontWeightwhenRase;
    }
    
}
