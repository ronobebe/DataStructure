package Algorithms.FairDraft.Math;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class FindMaxOrMin {

  public static void main(String[] args) {
    //
    Scanner sc = new Scanner(System.in);
    Random random = new Random();
    int size = random.nextInt(100) + 1;
    int[] arr = new int[size];

    for(int i=0; i<size; ++i){
      arr[i] = random.nextInt()%1000;
    }
    System.out.println("min in arrray is : "+min(arr));
    System.out.println("max in arrray is : "+max(arr));

  }

  private static int min(int[] arr)
  {
   int temp=arr[0];
    for(int i=1; i<arr.length; i++)
      if(arr[i]<temp)
        temp=arr[i];

      return temp;
  }


  private static int max(int[] arr)
  {
    int temp=arr[0];
    for(int i=1; i<arr.length; i++)
      if(arr[i]>temp)
        temp=arr[i];

    return temp;
  }

}
