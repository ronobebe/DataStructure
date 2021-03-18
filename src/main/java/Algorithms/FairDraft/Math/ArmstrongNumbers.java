package Algorithms.FairDraft.Math;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ArmstrongNumbers {

    /**
     * An Armstrong number is equal to the sum of the cubes of its digits. For example, 370 is an
     * Armstrong number because 3*3*3 + 7*7*7 + 0*0*0 = 370. An Armstrong number is often called
     * Narcissistic number.
     */

    private static boolean ArmstrongNumber(int num){
        int temp=num;
        int returnVal;
        int sum=0;

        while(temp!=0){
            returnVal=temp%10;
            sum=sum+(returnVal*returnVal*returnVal);

            temp=temp/10;
        }

        return sum==num;
    }

  public static void main(String[] args) {

      Scanner sc=new Scanner(System.in);
      int num;

      while (true){
          try{
              System.out.println(
                      "Please enter the number");

              num = sc.nextInt();

              if (num<1) {
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

    //

     System.out.println("Number is Armstrong : " + ArmstrongNumber(num));
  }


}
