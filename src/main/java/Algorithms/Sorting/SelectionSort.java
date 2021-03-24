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
}
