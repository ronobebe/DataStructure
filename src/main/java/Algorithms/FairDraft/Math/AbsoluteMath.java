package Algorithms.FairDraft.Math;

public class AbsoluteMath {

    private static final int absMaxValue(int[] numArray){
        if(numArray.length==0)
            throw  new IllegalArgumentException("Array size must be greater than zero");
        int temp=numArray[0];
        for(int i=1; i<numArray.length; ++i){
            if(Math.abs(numArray[i])>Math.abs(temp))
                temp=numArray[i];
        }
        return temp;
    }

    private static final int absMinValue(int[] numArray){
        if(numArray.length==0)
            throw  new IllegalArgumentException("Array size must be greater than zero");
        int temp=numArray[0];
        for(int i=1; i<numArray.length; ++i){
            if(Math.abs(numArray[i])<Math.abs(temp))
                temp=numArray[i];
        }
        return temp;
    }
    private static final int[] absValue(int[] numArray){
       // int[] tempArray=numArray;
        if(numArray.length==0)
            throw  new IllegalArgumentException("Array size must be greater than zero");
        final int temp=0;
        for(int i=0; i<numArray.length; ++i){
            if(numArray[i]<temp)
                numArray[i]=Math.abs(numArray[i]);
        }
        return numArray;
    }


  public static void main(String[] args) {
    //
      int[] testNum = {-2, 0, 16};
      int[] testNUm2={3, -10, -2};
      System.out.println("Max value is : "+absMaxValue(testNum));


      System.out.println("Max value is : "+absMaxValue(testNUm2));

      System.out.println("Min value is : "+absMinValue(testNum));


      System.out.println("Min value is : "+absMinValue(testNUm2));
      int[] tempArr=absValue(testNUm2);

      for(Integer i:tempArr)
          System.out.println("Abs value is : "+i);

  }
}
