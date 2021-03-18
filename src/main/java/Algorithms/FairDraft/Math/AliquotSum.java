package Algorithms.FairDraft.Math;

public class AliquotSum {


    public static int  aliquotSum(int num)
    {

        int returnVal=0;
        final int limit=num/2;

        for(int i=1 ; i<=limit; i++)
            if(num%i==0)
                returnVal+=i;

        return returnVal;
    }


  public static void main(String[] args) {
    //

     System.out.println("Aliquot sum is : "+ aliquotSum(15));
  }
}
