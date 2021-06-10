package Algorithms.FairDraft.SortingAlgorithms;

public class HeapSort {

  public int[] heapSort(int[] inputArray) {
    heapSort(inputArray, inputArray.length );
    return inputArray;
  }

  private void heapSort(int[] inputArray, int end) {
    for(int i=(end/2)-1; i>=0;i--)
    heapify(i, inputArray, end);
    for (int j=end-1; j>=0; j--)
    {
      // Move current root to end

      BubbleSort.swapElement(0,j,inputArray);
      // call max heapify on the reduced heap
      heapify( 0,inputArray, j);
    }

  }

  private void heapify(int index, int[] inputArray, int n) {
    int element = index;
    int left = 2 * element + 1;
    int right = 2 * element + 2;

    if (left<n&&inputArray[left] > inputArray[element]) element = left;
    if (right<n&&inputArray[right] > inputArray[element]) element = right;
    if (element != index) {
      BubbleSort.swapElement(index, element, inputArray);
      heapify(element,inputArray,n);
    }
  }

  public static void main(String[] args) {
    HeapSort heapSort=new HeapSort();
    heapSort.heapSort(new int[]{4,5,2,1,7,5});
  }
}
