package Algorithms.Sorting;

public class MergeSort {


    public  int[] mergeSort(int[] inputArray)
    {
        int[] newArray=new int[inputArray.length];

    return mergeSort(0, inputArray.length, inputArray,newArray);
    }

    private int[] mergeSort(int start,int stop, int[] inputArray, int[] newArray)
    {
        int[] subArray=inputArray;

        int middle=(start+stop)/2;

          if (middle == start) {
           newArray[middle]=subArray[middle];
           sort(newArray,middle);
           return null;
            }

        mergeSort(start,middle,subArray,newArray);
        mergeSort(middle,stop,subArray,newArray);


        return newArray;

    }

    private void sort(int[] subArray, int index){

        for (int i = 0; i <= index; i++) {
            int num = subArray[index];
            if (num < subArray[i]) {
                num = subArray[i];
                subArray[i] = subArray[index];
                subArray[index] = num;
            }
        }


    }
}
