package Algorithms.FairDraft.SortingAlgorithms;

public class QuickSort {

    public int[] quickSort(int[] inputArray)
    {
        quickSort(0,inputArray.length -1,inputArray);
        return inputArray;
    }


private void quickSort(int start, int end, int[] inputArray)
{

    if(start<end)
    {
        int pivot=change(start, end, inputArray);

        quickSort(start,pivot-1,inputArray);

        quickSort(pivot,end,inputArray);
    }

}

private  int change(int tempStart, int tempEnd, int[] inputArray)
{
    int element=inputArray[tempStart];
    /*int tempStart=start;
    int tempEnd=end;*/

    while(tempStart<=tempEnd)
    {
        while (inputArray[tempStart]<element)
        {
            tempStart++;

        }
        while (inputArray[tempEnd]>element)
        {
            tempEnd--;
        }
      if (tempStart <= tempEnd) {
        BubbleSort.swapElement(tempStart, tempEnd, inputArray);
        tempStart++;
        tempEnd--;
        }

    }

return tempStart;

}

  public static void main(String[] args) {
    //
      QuickSort quickSort = new QuickSort();
      int[] arr= quickSort.quickSort(new int[] {2, 1, 3,6,5,7,2,4,3});
      for (int i = 0; i < arr.length; i++) System.out.println("Element at : " + i + " is " + arr[i]);

  }
}
