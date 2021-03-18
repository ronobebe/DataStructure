package Algorithms.FairDraft.Math;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Floor {
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

        System.out.println("Floor number is : "+floor(num));


    }


    private static double  floor(double num)
    {


        return (int) num;

    }

}

