package Algorithms.FairDraft.SortingAlgorithms;

public class SelectionSort {

    /**
     * The selection sort algorithm sorts an array by repeatedly finding the minimum element (considering ascending order)
     * from unsorted part and putting it at the beginning. The algorithm maintains two subarrays in a given array
     * */

    private  int[] selectionSort(int[] inputArray)
    {

      //  return  selectionSortLoop(inputArray);
        return  selectionSortRecursion(inputArray,0);
    }


    private int[] selectionSortLoop(int[] inputArray)
    {
       int index=0;
       while(index<inputArray.length)
       {
           int element=index;
      for (int i = index+1; i < inputArray.length; i++) {
       //

          if(inputArray[element]>inputArray[i])
               element=i;
      }
           BubbleSort.swapElement(element,index,inputArray);

           index++;
       }

        return  inputArray;
    }


    private int[] selectionSortRecursion(int[] inputArray, int index)
    {
        if(index>=inputArray.length)
        {
            return inputArray;
        }
        int element=index;
        for (int i = index+1; i < inputArray.length; i++) {
            //

            if(inputArray[element]>inputArray[i])
                element=i;
        }
        BubbleSort.swapElement(element,index,inputArray);




        return selectionSortRecursion(inputArray, ++index);
    }

  public static void main(String[] args) {
    //
      SelectionSort selectionSort=new SelectionSort();
      int[] arr=selectionSort.selectionSort(new int[] {4, 1, 3, 2, 3, 10, 4, 5, 2});
      for (int i = 0; i < arr.length; i++) System.out.println("Element at : " + i + " is " + arr[i]);

  }
}
