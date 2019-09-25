/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carmodelspractice;

/**
 *
 * @author cst
 */
public abstract class Vehicle { 
    
    String vin;
    String color;
    String brand;
    String fuelType;
    int totalkm;
    int year;
    int speed;
    int max_speed;
    int numOfdoors;
    double headingInDeg;
    double weight;
    double frontBumberHeight;
    String frameMaterial;
    boolean airbagPresent;
    double lengthOfWheelBase;
    double frontWeightlevelWeight;
    double frontWeightwhenRase;
    
    public Vehicle(){
        
    }
    
    public Vehicle(int y, String b,int numdoor){
        year=y;
        brand=b;
        numOfdoors=numdoor;
    }
    
    
}
