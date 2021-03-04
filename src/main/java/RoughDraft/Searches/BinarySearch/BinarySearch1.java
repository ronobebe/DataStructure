package RoughDraft.Searches.BinarySearch;

import java.util.Arrays;

public class BinarySearch1 {


    /**
     * Binary search using recursion function
    * */
    public  int binarySearch(int number, int[] array, int min, int max){


        if(min>max)
            return -1;

        int pivot=(min+max)/2;
        int pivotNum=array[pivot];
        
        if(number==pivotNum)
            return pivot;
        else if(number<pivotNum){
            return  binarySearch(number, array,min,pivot-1);
        }
        else if(number>pivotNum){
            return  binarySearch(number, array,pivot+1, max);
        }
        
        return -1;

                
    }




    public static void main(String[] args) {


        int arr[]={1,2,3,4,5,6,7,8};

    //  int val=  new BinarySearch1().binarySearch(10, arr, 0, arr.length-1);
        int val = BinarySearch2.binarySearch0(arr,0, arr.length,8);

System.out.println("Value is : "+val);

    }
    
    
}
