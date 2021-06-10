package Algorithms.Sorting;

public class InsertionSort {

  public int[] insertionSort(int[] inputArray) {
    int[] subArray = inputArray;
    int index = 1;
    while (index < subArray.length) {

      for (int i = 0; i <= index; i++) {
        int num = subArray[index];
        if (num < subArray[i]) {
          num = subArray[i];
          subArray[i] = subArray[index];
          subArray[index] = num;
        }
      }
      index++;
    }

    return subArray;
  }
  private void swapElements(int[] inputArray, int low, int high) {
    if (low < 0 || high >= inputArray.length) throw new IllegalArgumentException();
    int tempHigh = inputArray[high];
    inputArray[high] = inputArray[low];
    inputArray[low] = tempHigh;
  }

  public  int[] insertionSort1(int[] inputArray)
  {
    int index=1;
    while (index<inputArray.length)
    {


      int tempIndex=0;

      while (tempIndex<index)
      {
        if(inputArray[tempIndex]>inputArray[index])
          swapElements(inputArray,tempIndex,index);
        tempIndex++;

      }

      index++;
    }

    return  inputArray;
  }
}
