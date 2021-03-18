package Algorithms.FairDraft.Math;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Factorial {

    public static void main(String[] args) {
        //
        Scanner sc=new Scanner(System.in);
        int num;

        while (true){
            try{
                System.out.println(
                        "Please enter the number");

                num = sc.nextInt();

              if (num<0) {
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

        System.out.println("Factorial number is : "+factorial(num));


    }

    public final static  int factorial(int num)
    {
        if(num==1)
            return num;

        return num*factorial(num-1);

    }

}
