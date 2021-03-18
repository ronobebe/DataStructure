package Algorithms.FairDraft.Math;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Combinations extends  Factorial {

    public static void main(String[] args) {
        //
        Scanner sc=new Scanner(System.in);
        int num1, num2;

        while (true){
            try{
                System.out.println(
                        "Please enter the first number");

                num1 = sc.nextInt();

                if (num1<0) {
                    System.out.println("Invalid Number!");
                    continue;
                }
                System.out.println(
                        "Please enter the second number");

                num2 = sc.nextInt();

                if (num2<0) {
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

        System.out.println("Combination number is : "+combinaton(num1, num2));


    }

    private static  int combinaton(int num1, int num2)
    {

        return factorial(num1)/(factorial(num2) * factorial((num1-num2)));

    }

}
