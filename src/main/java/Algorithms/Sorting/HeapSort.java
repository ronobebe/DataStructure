package Algorithms.Sorting;

public class HeapSort {

    public  int[] headSort(int[] inputArray)
    {
        if(inputArray.length<=0)
            return null;

        /*sort*/heapSort(inputArray);
        return  inputArray;

    }

    public void sort(int arr[])
    {
        int n = arr.length;

        // Build heap (rearrange array)
        for (int i = n / 2 -1; i >= 0; i--)
            heapify(arr, n, i);

        // One by one extract an element from heap
        for (int i = n - 1; i > 0; i--) {
            // Move current root to end
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // call max heapify on the reduced heap
            heapify(arr, i, 0);
        }
    }

    // To heapify a subtree rooted with node i which is
    // an index in arr[]. n is size of heap
    void heapify(int arr[], int n, int i)
    {
        int largest = i; // Initialize largest as root
        int l = 2 * i + 1; // left = 2*i + 1
        int r = 2 * i + 2; // right = 2*i + 2    1,4,2,3  i=0, l=1(4), r=2(2)

        // If left child is larger than root
        if (l < n && arr[l] > arr[largest])
            largest = l;

        // If right child is larger than largest so far
        if (r < n && arr[r] > arr[largest])
            largest = r;

        // If largest is not root
        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            // Recursively heapify the affected sub-tree
            heapify(arr, n, largest);
        }
    }


    public  void heapSort(int[] inputArray)
    {

        int arrLength=inputArray.length;

        for(int i=(arrLength/2)-1; i>=0; i--)
            heapifyOwn(inputArray,i,arrLength);
        for(int j=arrLength-1;j>0; j--)
        {
            swapElements(inputArray,0,j);
            heapifyOwn(inputArray,0,j);

        }

    }


    private void heapifyOwn(int[] inputArray, int n, int arrLength)
    {
        int element=n;

        int left=element*2+1;
        int right=element*2+2;

        if(left<arrLength && inputArray[left]>inputArray[element])
            element=left;
        if(right<arrLength && inputArray[right]>inputArray[element])
            element=right;

        if(element!=n)
        {
            swapElements(inputArray,n,element);
            heapifyOwn(inputArray,element,arrLength);
        }

    }

    private void swapElements(int[] inputArray, int low, int high)
    {
        if (low<0 || high>=inputArray.length)
            throw  new IllegalArgumentException();
        int tempHigh=inputArray[high];
        inputArray[high]=inputArray[low];
        inputArray[low]=tempHigh;

    }

}
