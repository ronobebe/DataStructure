package Algorithms.FairDraft.Math;

import java.util.Arrays;

public class Median {

  public static void main(String[] args) {
    //
      assert median(new int[] {0}) == 0;
      assert median(new int[] {1, 2}) == 1.5;
      assert median(new int[] {4, 1, 3, 2}) == 2.5;
      assert median(new int[] {1, 3, 3, 6, 7, 8, 9}) == 6;
      assert median(new int[] {1, 2, 3, 4, 5, 6, 8, 9}) == 4.5;

      System.out.println("Median is : "+median((new int[] {1, 2, 3, 4, 5, 6, 8, 9})));
      System.out.println("Median is : "+median((new int[] {4, 1, 3, 2})));
      System.out.println("Median is : "+median((new int[] {1, 3, 3, 6, 7, 8, 9})));
  }

    private static double median(int[] inputArr)
    {
        Arrays.sort(inputArr);
        int median= inputArr.length;
        if(inputArr.length==0)
            return -1;


        if(median%2==0)

            return (inputArr[median/2]+inputArr[median/2 -1])/2.0;

        else

            return inputArr[median / 2];





    }
}
