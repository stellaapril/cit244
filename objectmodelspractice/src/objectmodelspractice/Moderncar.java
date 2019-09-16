/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objectmodelspractice;

/**
 *
 * @author sitian.chen
 */
public class Moderncar extends Vehicle{
    //safety variables
    public boolean hasAirbag;
    public boolean hasNavi;
    public boolean hasBackupcamera;
    public boolean hasBluetooth;
    public boolean hasLighterplug;
    public boolean hybridcar;
    public String carGearShifter;
    public String Reverse = "R";
    
    public boolean openBackupcamera;
    
    @Override
    public void turn(int deg){
        
    }
    
    
    
    public boolean backupCamera(String gear){
        if(gear.equals(Reverse)){
            openBackupcamera = true;
        }else{
            openBackupcamera = false;
        }
        return openBackupcamera;
    }
    
    
}
