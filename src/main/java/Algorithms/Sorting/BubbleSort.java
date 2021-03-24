package Algorithms.Sorting;

public class BubbleSort {

  public int[] bubbleSort(int[] inputArray) {
    int[] subArray = inputArray;
    int index = 0;

    while (index < subArray.length) {

      for (int i = index + 1; i < subArray.length; i++) {
        int num = subArray[i - 1];
        if (subArray[i] < num) {
          subArray[i - 1] = subArray[i];
          subArray[i] = num;
        }
      }
      index++;
    }
    return subArray;
  }

}
