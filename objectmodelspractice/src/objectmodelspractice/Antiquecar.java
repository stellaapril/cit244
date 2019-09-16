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
public class Antiquecar extends Vehicle{
    public boolean hasSafebelt;
    
    public int headingInDeg;
    
    @Override
    public void turn(int deg){
        // guts must be written here;
        //does this Car even maintain its heading?
        //To properly implement, perhaps we want a member
        //variable that stores the Vehicle's heading
        
        headingInDeg = headingInDeg +deg;
        
    }
    
}
