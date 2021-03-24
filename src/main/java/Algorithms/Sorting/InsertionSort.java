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
}
