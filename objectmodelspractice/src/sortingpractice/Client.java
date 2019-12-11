/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sortingpractice;

import java.util.Random;
import java.util.Scanner;
/**
 *
 * @author cst
 */
public class Client{
    
    
    public static void main(String[] args){
        display();
    }
   
    
    public static void display(){
        Sorter bubblesorter = new Sorter();
        Sorter quicksorter =new Sorter();
        
        //simple test
        int[] arry={5,2,12,10,3,1,8,4};
        int[] arry2={5,2,12,10,3,1,8,4};
        
        
        //bubblesorter.bubbleSort(arry);
        //printer(arry);
        //test(arry);
        
        //quicksorter.quickSort(arry2);
        //printer(arry2);
        //test(arry2);
        
        //user input
        System.out.println("Input a size of test case");
        Scanner userInput = new Scanner(System.in);
        int size = userInput.nextInt();
        
        System.out.println("Input a range of random numbers in test case");
        int range= userInput.nextInt();
        
        //display test
        System.out.println("-------------------------------------------------");
        System.out.println("                  Sorting Test                   ");
        System.out.println("Test Size:   "+ size);
        System.out.println("Test Rnage: "+ range);
        //set up random arry list
        int[] testArry = generator(size,range);
        int[] testArryBubble= testArry.clone();
        int[] testArryQuick= testArry.clone();
       
        System.out.print("Test of Bubble Sort: " );
        testresult(test(bubblesorter.bubbleSort(testArryBubble)));
        System.out.print("Test of Quick Sort: " );
        testresult(test(quicksorter.quickSort(testArryQuick)));
        
        System.out.println("Time of Bubble Sort :"+ getTimeStamp(getBubbleRunTimes(bubblesorter)) );
        
        System.out.println("Time of Quick Sort :"+ getTimeStamp(getQuickRunTimes(quicksorter)) + "\n");
        
        //compare the bubble sort time and quick sort time
        System.out.print("The Result of Test Case: ");
        if(getTimeStamp(getBubbleRunTimes(bubblesorter))<getTimeStamp(getQuickRunTimes(quicksorter))){
            System.out.println("Bubble Sort Win!");
        }else if(getTimeStamp(getBubbleRunTimes(bubblesorter))==getTimeStamp(getQuickRunTimes(quicksorter))){
            System.out.println("Tie");
        }else{
            System.out.println("Quick Sort Win!");
        }
    
        System.out.println("-------------------------------------------------");
    }
    
    //print arry list
    public static void printer(int[] arr){
        
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i]+",");
        }
        System.out.println(" ");
    }
    
    //check Sorter
    public static boolean test(int[] arr){
        boolean tester = false;
        for(int i=0; i<arr.length-1;i++){
            if(arr[i]<=arr[i+1]){
               tester=true;
            }else{
                System.out.println(":(");
                tester = false;
                break;
            }
        }
        return tester;
    }
    
    //check sorter printer
    public static void testresult(boolean tester){
        if(tester){
            System.out.println("Success! :)");
        }else{
            System.out.println("Failure");
        }
    }
    
    //Random
    public static int[] generator(int size,int range){
        int[] randomArry =new int[size];
        Random randomNum = new Random();
        
        for(int i=0;i<size;i++){
            randomArry[i] = randomNum.nextInt(range);
        }
        
        return randomArry;
    }
   
    //get bubble sort time
    public static long[] getBubbleRunTimes(Sorter s){
        long start = s.bubbleStartTime;
        long end = s.bubbleEndTime;
        long[] bubbletime={start,end}; 
        
        return bubbletime;
    }
    
    //get quick sort time
    public static long[] getQuickRunTimes(Sorter t){
        long start = t.quickStartTime;
        long end = t.quickEndTime;
        long[] quicktime={start,end}; 
        
        return quicktime;
    }
    
    //get timestamp
    public static long getTimeStamp(long[] time){
        long timestamp = time[1] - time[0];
        return timestamp;
    }
}
