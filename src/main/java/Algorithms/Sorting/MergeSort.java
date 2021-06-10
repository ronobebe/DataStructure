package Algorithms.Sorting;

public class MergeSort {


    public  int[] mergeSort(int[] inputArray)
    {
        int[] newArray=new int[inputArray.length];

    return mergeSort(0, inputArray.length, inputArray,newArray);
    }

    private int[] mergeSort(int start,int stop, int[] inputArray, int[] newArray)
    {
        int[] subArray=inputArray;

        int middle=(start+stop)/2;

          if (middle == start) {
           newArray[middle]=subArray[middle];
           sort(newArray,middle);
           return null;
            }

        mergeSort(start,middle,subArray,newArray);
        mergeSort(middle,stop,subArray,newArray);


        return newArray;

    }

    private void sort(int[] subArray, int index){

        for (int i = 0; i <= index; i++) {
            int num = subArray[index];
            if (num < subArray[i]) {
                num = subArray[i];
                subArray[i] = subArray[index];
                subArray[index] = num;
            }
        }


    }


    public int[] mergeSort1(int[] inputArray)
    {
        merge1(0,inputArray.length-1, inputArray);

        return inputArray;
    }

    private void merge1(int start, int end , int[] inputArray)
    {
    if (start < end) {

      int middle = (start +end) / 2;
      System.out.println("Middle is : "+middle);

      merge1(start, middle, inputArray);
      merge1(middle + 1, end, inputArray);
      merge(start,middle,end,inputArray);
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
        MergeSort mergeSort=new MergeSort();
        mergeSort.mergeSort1(new int[]{2,4,5,6,1,7,8});
    //
  }
}
