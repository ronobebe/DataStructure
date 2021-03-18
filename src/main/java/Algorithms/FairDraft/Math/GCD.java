package Algorithms.FairDraft.Math;

import java.util.InputMismatchException;
import java.util.Scanner;

public class GCD {

    public static void main(String[] args) {
        //
        Scanner sc=new Scanner(System.in);
        int num1,num2;

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

        System.out.println("GCD number is : "+findGCD(num1,num2));
        System.out.println("LCD number is : "+findLCD(num1,num2));


    }



    private static int findGCD(int num1, int num2)
    {
        int min=Math.min(num1,num2);

        int end=(int)min/2;

    for (int i = end; i >1; i--) {
     //
        if(num1%i==0 && num2%i==0)
            return i;
    }

        return 1;
    }

    private static int findLCD(int num1, int num2)
    {
        int min=Math.min(num1,num2);

        int end=(int)min/2;

        for (int i = 2; i <end; i++) {
            //
            if(num1%i==0 && num2%i==0)
                return i;
        }

        return 1;
    }

}
