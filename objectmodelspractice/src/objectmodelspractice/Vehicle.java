/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objectmodelspractice;

import inheritancepractice.CrashTestable;
import inheritancepractice.DrivingMode;

/**
 *
 * @author sitian.chen
 */
public abstract class Vehicle implements Turnable,CrashTestable{
    //public variables
    public String vin;
    public String color;
    public String brand;
    public String makemodel;
    public int totalkm;
    public int year;
    
    
    
    //private variables
    private boolean isEnginerunning;
    private boolean checkLightstatus;
    private double speed;
    
    
    
    public void startCar(){
        isEnginerunning = true;
    }//close startCar
    
    public void stopCar(){
        isEnginerunning = false;
    }//close stopCar
    
    
    public double accelerate(int increasemph){
        speed = speed+increasemph;
        return speed;
    }//close method
    
    public double deaccelerate(int decreasemph){
        speed = speed+decreasemph;
        return speed;
    }//close method
    
    public boolean checkLightstatus(){
        if(checkLightstatus == true){
            System.out.println("Light is on");
        }else{
            System.out.println("Light is not on");
        }
        return checkLightstatus;
    }//close method

    @Override
    public void turn(int degrees) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getVehicleYear() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public DrivingMode getDrivingMode() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public double getVehicleWeight() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public double getFrontBumberHeight() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String frameMaterialIdentifer() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean driverAirbagPresent() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public double getLengthOfWheelBase() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public double getFrontWeightLevelWeight() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public double getFrontWeightWhenRaised() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
