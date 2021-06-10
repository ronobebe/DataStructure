package Algorithms.FairDraft.SortingAlgorithms;

public class BubbleSort {

  /**
   * Bubble Sort is the simplest sorting algorithm that works by repeatedly swapping the adjacent
   * elements if they are in wrong order Select every element and sort with the previous one. Ex:
   * 4,1,3,2 => 1,4,3,2 => 1,3,4,2 => 1,2,3,4
   */
  public int[] bubbleSort(int[] inputArray) {

    return bubbleSortLoop(inputArray);
/*
    return  bubbleSortRecursion(0,inputArray);
*/
  }

  private int[] bubbleSortLoop(int[] inputArray) {
    int index = 0;

    while (index < inputArray.length) {

      for (int i = 0; i < inputArray.length - index - 1; i++) {
        int tempNum = inputArray[i + 1];
        if (inputArray[i] > tempNum) swapElement(i, i + 1, inputArray);
      }
      index++;
    }

    return inputArray;
  }

  private int[] bubbleSortRecursion(int index, int[] inputArray) {

    if (index >= inputArray.length) return inputArray;

    for (int i = 0; i < inputArray.length - index - 1; i++) {
      int tempNum = inputArray[i + 1];
      if (inputArray[i] > tempNum) swapElement(i, i + 1, inputArray);
    }
    index++;

    return bubbleSortRecursion(index++, inputArray);
  }

  public static  void swapElement(int index1, int index2, int[] inputArray) {

    int tempElement = inputArray[index1];
    inputArray[index1] = inputArray[index2];
    inputArray[index2] = tempElement;
  }

  public static void main(String[] args) {
    //
    BubbleSort bubbleSort = new BubbleSort();
    int[] arr = bubbleSort.bubbleSort(new int[] {4, 1, 3, 2, 3, 10, 4, 5, 2});
    for (int i = 0; i < arr.length; i++) System.out.println("Element at : " + i + " is " + arr[i]);
  }
}
