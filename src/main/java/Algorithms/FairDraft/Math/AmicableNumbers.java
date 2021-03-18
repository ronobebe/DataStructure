package Algorithms.FairDraft.Math;

import java.util.InputMismatchException;
import java.util.Scanner;

public class AmicableNumbers extends AliquotSum {

  private static boolean findAmicableNumbers(int num1, int num2) {
    int factorSum1;
    int factorSum2;

      factorSum1=aliquotSum(num1);
      factorSum2=aliquotSum(num2);

      if(factorSum1==num2 && factorSum2==num1)
        return  true;

      return  false;

  }

  public static void main(String[] args) {
    //
    Scanner sc=new Scanner(System.in);
    int num1, num2;
    while(true)
    {

      try{
        System.out.println(
                "Please enter the first number ");
        num1=sc.nextInt();

        if(num1<0)
        {
          System.out.println("Invalid Number!");
          continue;
        }

        System.out.println(
                "Please enter the second number ");
        num2=sc.nextInt();


        if(num2<0 && num2>num1)
        {
          System.out.println("Invalid Number!");
          continue;
        }
        break;
      }
       catch (InputMismatchException e) {
      System.out.println("Invalid input.");
      sc.next();
    }
    }
    System.out.println("Two numbers are : "+findAmicableNumbers(num1,num2));

  }
}
