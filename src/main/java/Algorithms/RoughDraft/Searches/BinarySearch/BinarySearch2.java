package Algorithms.RoughDraft.Searches.BinarySearch;

public class BinarySearch2 {
    /**
     * Binary search without recursion
    * */

    public static int binarySearch0(int[] arr, int minimun, int maximum, int num) {
        int var5 = minimun;
        int var6 = maximum - 1;

        while(var5 <= var6) {
            int pivot = var5 + var6 >>> 1;
            int pivotNum = arr[pivot];
            if (pivotNum < num) {
                var5 = pivot + 1;
            } else {
                if (pivotNum <= num) {
                    return pivot;
                }

                var6 = pivot - 1;
            }
        }

        return -(var5 + 1);
    }
}
