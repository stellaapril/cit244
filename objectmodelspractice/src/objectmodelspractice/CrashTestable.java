/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objectmodelspractice;

/**
 *Direct implementing classes to return data
 * used by crash simulating code to determine
 * a vehicle's crash safety rating
 * @author sitian.chen
 */
public interface CrashTestable {
    public double getWeight();
    public double lengthWheelBase();
    public double frontWeightNonRaised();
    public double frontWeightWhenRaised(int raiseAngle);
    
    
}
