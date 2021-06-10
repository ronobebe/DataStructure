package Algorithms.FairDraft.SortingAlgorithms;

public class MergeSort {

  /**
   * Merge Sort is a Divide and Conquer algorithm. It divides the input array into two halves, calls
   * itself for each halves, and then merges all sorted halves. The merge() function is used
   * for merging two halves. The merge(arr, l, m, r) is a key process that assumes that arr[l..m]
   * and arr[m+1..r] are sorted and merges the two sorted sub-arrays into one. See the following C
   * implementation for details.
   */
  public int[] mergeSort(int[] inputArray) {
    mergeSort(0, inputArray.length-1, inputArray);
    return inputArray;
  }




   void mergeSort(int start, int end, int[] inputArray) {
    if (start < end) {
      int pivot = start +( end-start) / 2;

      mergeSort(start, pivot , inputArray);
      mergeSort(pivot+1, end, inputArray);
      merge(start,pivot,end,inputArray);
    }

  }





  private void merge(int l, int m, int r, int[] arr)
  {
    // Find sizes of two subArrays to be merged
    int n1 = m - l + 1;
    int n2 = r - m;

    /* Create temp arrays */
    int L[] = new int[n1];
    int R[] = new int[n2];

    /*Copy data to temp arrays*/
    for (int i = 0; i < n1; ++i)
      L[i] = arr[l + i];
    for (int j = 0; j < n2; ++j)
      R[j] = arr[m + 1 + j];

    /* Merge the temp arrays */

    // Initial indexes of first and second subarrays
    int i = 0, j = 0;

    // Initial index of merged subarry array
    int k = l;
    while (i < n1 && j < n2) {
      if (L[i] <= R[j]) {
        arr[k] = L[i];
        i++;
      }
      else {
        arr[k] = R[j];
        j++;
      }
      k++;
    }

    /* Copy remaining elements of L[] if any */
    while (i < n1) {
      arr[k] = L[i];
      i++;
      k++;
    }

    /* Copy remaining elements of R[] if any */
    while (j < n2) {
      arr[k] = R[j];
      j++;
      k++;
    }


  }



  public static void main(String[] args) {
    //
    MergeSort mergeSort = new MergeSort();
    mergeSort.mergeSort(new int[] {2, 1, 3,6,5,7});
  }
}
