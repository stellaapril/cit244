/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sortingpractice;



/**
 *
 * @author cst
 */
public class Sorter {
    //bubble sort
    long bubbleStartTime;
    long bubbleEndTime;
    
    public int[] bubbleSort(int[] list){
        bubbleStartTime= java.time.Instant.now().toEpochMilli();
        boolean needNextPass=true;
        //swap loop
        for(int m=1; m<list.length && needNextPass; m++){
            needNextPass = false;
            for(int i=0; i<list.length-m;i++){
                if(list[i]>list[i+1]){
                    int temp = list[i];
                    list[i]=list[i+1];
                    list[i+1]=temp;
                    
                    needNextPass = true;
                }//close if
            }//close inner for loop
        }//close outter for loop
        bubbleEndTime = java.time.Instant.now().toEpochMilli();
        return list;
    }//close bubbleSort
    
    
    
    
    //quicksort
    long quickStartTime;
    long quickEndTime;
    public int[] quickSort(int[] list){
       quickStartTime= java.time.Instant.now().toEpochMilli();
       quickSorthelper(list, 0, list.length-1);
       quickEndTime= java.time.Instant.now().toEpochMilli();
       return list;
    }
    
    public void quickSorthelper(int[] list, int first, int last){
        if(last>first){
            int pivotIndex = partition(list, first, last);
            quickSorthelper(list, first, pivotIndex-1);
            quickSorthelper(list, pivotIndex+1, last);
        }
    }
    
    
    public int partition(int[] list, int first, int last){
        int pivot = list[first];
        int low = first+1;
        int high = last;
        
        while(high>low){
            //search forward from left
            while(low<=high&&list[low]<=pivot){
                low++;
            }
            //search backward from right
            while(low<= high && list[high]>pivot){
                high--;
            }
            
            //swap
            if(high>low){
                int quicktemp = list[high];
                list[high] = list[low];
                list[low] =quicktemp;
            }
        }
        
        while (high>first && list[high] >= pivot){
            high--;
        }
        
        //swap pivot
        if(pivot > list[high]){
            list[first] = list[high];
            list[high] = pivot;
            return high;
        }else{
            return first;
        }
    }
}
