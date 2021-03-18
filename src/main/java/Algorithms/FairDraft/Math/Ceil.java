package Algorithms.FairDraft.Math;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Ceil {

  public static void main(String[] args) {
    //
      Scanner sc=new Scanner(System.in);
      double num;

      while (true){
          try{
              System.out.println(
                      "Please enter the number");

              num = sc.nextDouble();

             /* if (num<0) {
                  System.out.println("Invalid Number!");
                  continue;
              }*/
              break;
          }
          catch (InputMismatchException e) {
              System.out.println("Invalid input.");
              sc.next();
          }
      }

      System.out.println("Ceil number is : "+ceil(num));


  }


  private static double  ceil(double num)
  {
     int wholeNum=(int) num;
     if(wholeNum<0)
         return wholeNum-1;
     else if(wholeNum<num)
         return wholeNum+1;

     return wholeNum;

  }

}
