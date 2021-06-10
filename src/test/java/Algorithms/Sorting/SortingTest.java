package Algorithms.Sorting;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SortingTest {
  private static BubbleSort bubbleSort;
  private static MergeSort mergeSort;
  private static SelectionSort selectionSort;
  private static InsertionSort insertionSort;
  private static QuickSort quickSort;
  private static HeapSort heapSort;

  @BeforeAll
  public static void createObject() {

    bubbleSort = new BubbleSort();
    mergeSort = new MergeSort();
    selectionSort = new SelectionSort();
    insertionSort = new InsertionSort();
    quickSort = new QuickSort();
    heapSort = new HeapSort();
  }

  @Test
  void bubbleSort() {
    int[] numArr = {1, 2, 3, 5, 8, 10, 11, 12, 31, 42, 65};
    int[] finalArray = {1, 2, 3, 4};
    assertAll(
        () -> assertArrayEquals(finalArray, bubbleSort.bubbleSort(new int[] {1, 4, 3, 2})),
        () -> assertArrayEquals(finalArray, mergeSort.mergeSort1(new int[] {1, 4, 3, 2})),
        () -> assertArrayEquals(finalArray, selectionSort.selectionSort(new int[] {1, 4, 3, 2})),
        () -> assertArrayEquals(finalArray, insertionSort.insertionSort1(new int[] {1, 4, 3, 2})),
        () -> assertArrayEquals(finalArray, quickSort.quickSort(new int[] {1, 4, 3, 2})),
        () ->
            assertArrayEquals(
                numArr, heapSort.heapSort(new int[] {31, 10, 1, 42, 8, 5, 3, 2, 12, 11, 65})));
  }
}
