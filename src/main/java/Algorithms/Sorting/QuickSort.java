package Algorithms.Sorting;

public class QuickSort {

  public int[] quickSort(int[] inputArray) {

    quickSort(0, inputArray.length - 1, inputArray);

    return inputArray;
  }

  private void quickSort(int start, int end, int[] inputArray) {

    if (start < end) {
      int pivot = partition(inputArray, start, end);

      quickSort(start, pivot - 1, inputArray);
      quickSort(pivot , end, inputArray);
    }
  }

  public  int partition(int[] array, int left, int right) {
    int pivot = array[left];
    // taking first element as pivot
    while (left <= right) {
      //searching number which is greater than pivot, bottom up
      while (array[left] < pivot) {
        left++;
      }
      //searching number which is less than pivot, top down
      while (array[right] > pivot) {
        right--;
      }
      // swap the values
      if (left <= right) {
       swapElements(array, left, right);
        //increment left index and decrement right index
        left++;
        right--;
      }
    }
    return left;
  }


  private void swapElements(int[] inputArray, int low, int high)
  {
  if (low<0 || high>=inputArray.length)
    throw  new IllegalArgumentException();
  int tempHigh=inputArray[high];
    inputArray[high]=inputArray[low];
    inputArray[low]=tempHigh;

  }



public int[] quickSort1(int[] inuputArray)
{
  if(inuputArray.length<=0)
    return null;

  quickSortRecursion(0,inuputArray.length -1,inuputArray);
  return inuputArray;
}

  private void quickSortRecursion(int start, int end, int[] inputArray) {
    if (start < end) {

      int pivot = partitionRecursion(start, end, inputArray);

      quickSortRecursion(start, pivot - 1, inputArray);
      quickSortRecursion(pivot , end, inputArray);
    }
}
private int partitionRecursion(int start, int end, int[] inputArray)
{

  int pivotElement=inputArray[start];

    while (start <= end) {
      while (inputArray[start] < pivotElement) {
        start++;
      }
      while (inputArray[end] > pivotElement) {
        end--;
      }
      if (start <= end) {
        swapElements(inputArray, start, end);
        start++;
        end--;
 } }

  return start;
}

public  int[] quickSort2(int[] inputArray)
{

  quickSortRecursion2(0,inputArray.length-1, inputArray);

  return inputArray;
}

private void quickSortRecursion2(int start, int end , int[] inputArray)
{
    if (start < end) {
      int pivot = partition2(start, end, inputArray);

      quickSortRecursion2(start, pivot - 1, inputArray);
      quickSortRecursion2(pivot,end, inputArray);
  }
}



private int partition2(int start, int end , int[] inputArray)
{
  int pivotIndex=inputArray[start];

  while(start<=end)
  {

    while (inputArray[start]<pivotIndex)
    {
     start++;
    }

    while (inputArray[end]>pivotIndex)
    {
      end--;
    }

    if(start<=end)
    {
      swapElements(inputArray,start,end);
      start++;
      end--;
    }

  }


  return start;
}
}