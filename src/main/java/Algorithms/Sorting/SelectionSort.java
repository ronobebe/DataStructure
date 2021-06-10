package Algorithms.Sorting;


public class SelectionSort {

  // BIG O n is O(n^2)

  public int[] selectionSort( int[] input) {
    int[] subArray = input;
    int index = 0;

    while (index < input.length) {

      for (int i = index + 1; i < subArray.length; i++) {
        int num = subArray[index];
        if (num > subArray[i]) {
          subArray[index] = subArray[i];
          subArray[i] = num;
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

  private int[] selectionSort1(int[] inputArray)
  {

    int index=0;

    while(index<inputArray.length)
    {

      int tempIndex=index+1;

      while (tempIndex<inputArray.length)
      {
        if(inputArray[tempIndex]<inputArray[index])
          swapElements(inputArray,index,tempIndex);
        tempIndex++;

      }
      index++;
    }

    return inputArray;
  }
}
