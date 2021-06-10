package Algorithms.Sorting;

public class BubbleSort {

  /**
   * Bubble sort practice for  several times.
  * */

  public int[] bubbleSort(int[] inputArray) {
    int[] subArray = inputArray;
    int index = 0;

    while (index < subArray.length) {

      for (int i = index + 1; i < subArray.length; i++) {
        int num = subArray[i - 1];
        if (subArray[i] <= num) {
          subArray[i - 1] = subArray[i];
          subArray[i] = num;
        }
      }
      index++;
    }
    return subArray;
  }

  public int[] bubbleSort1(int[] inputArray)
  {

    assert inputArray.length>0;

    int start=0;

    while (start<inputArray.length)
    {
      for(int i=1; i<inputArray.length-start; i++)
      {
       if(inputArray[i-1]>inputArray[i])
         swapElements(inputArray,i,i-1);
      }
      ++start;
    }
    return inputArray;
  }


  private void swapElements(int[] inputArray, int low, int high)
  {
    if (low<0 || high>=inputArray.length)
      throw  new IllegalArgumentException();
    int tempHigh=inputArray[high];
    inputArray[high]=inputArray[low];
    inputArray[low]=tempHigh;

  }



}
