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
public class Hatchback extends Vehicle implements CrashTestable{

    @Override
    public int getVehicleYear() {
        year=2011;
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
        frontBumberHeight=18;
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
        lengthOfWheelBase=125;
        return lengthOfWheelBase;
    }

    @Override
    public double getFrontWeightLevelWeight() {
        frontWeightlevelWeight=700;
        return frontWeightlevelWeight;
    }

    @Override
    public double getFrontWeightWhenRaised() {
        frontWeightwhenRase=600;
        return frontWeightwhenRase;
    }
    
}
