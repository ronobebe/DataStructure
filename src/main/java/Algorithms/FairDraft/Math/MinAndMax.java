package Algorithms.FairDraft.Math;

public class MinAndMax {

  public static void main(String[] args) {
    //
      double num1=2.0012;
      double num2=2.0002;


      System.out.println("Min value is :"+ min(num1,num2));
      System.out.println("Max value is :"+ max(num1,num2));
  }

    private static double min(double num1, double num2)
    {
        return num1<=num2?num1:num2;
    }
    private static double max(double num1, double num2)
    {
        return num1<=num2?num2:num1;
    }
}
