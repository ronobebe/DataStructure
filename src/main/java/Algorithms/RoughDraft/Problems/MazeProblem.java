package Algorithms.RoughDraft.Problems;

import java.util.LinkedList;
import java.util.Queue;

public class MazeProblem {

   /**
    * Algorithm to find a path
    * Check if a node having more than one path
    * choose any one node to find path
    * if node having no other paths backtrack to the every previous node and search for the destination
    * */
    int[][] mazeArray={
            {1,1,1,1,1},
            {1,2,0,1,1},
            {1,0,0,1,1},
            {1,0,0,1,0},
            {1,0,0,0,3},
            };
    private final int startingNumber=2;
    private final int endingNumber=3;
    private final int wallNumber=1;
    private final int emptySpaceNumber=0;
    private int startingRow;
    private int startingCol;
    boolean[][] mazeArrayVisited;

    public MazeProblem() {
        mazeArrayVisited=new boolean[mazeArray.length][mazeArray.length];
    }

    private void isRouteExist()
{
    findPos(startingNumber);
    if(findWay(startingRow,startingCol))
        System.out.println("Solution available : "+startingCol+" "+startingRow);
    else
        System.out.println("Solution not available");
}

private  boolean findPos(int finder)
{
    int size=0;
    boolean returnPos=false;
    Queue<int[]> mainArray=new LinkedList<>();
    mainArray.add(mazeArray[size]);

   while(!mainArray.isEmpty())
   {
      int[] actualArray=mainArray.poll();
      for(int integer=0; integer<actualArray.length;integer++)
      {
          if(actualArray[integer]==finder)
          {
              startingRow=integer;
              startingCol=size;
              returnPos=true;
              break;
          }

      }
       if (size < mazeArray.length-1)
           mainArray.add(mazeArray[++size]);
   }
   return returnPos;
}
private boolean isFeasible(int x, int y)
{
    if(x<0 || x>mazeArray.length-1)
    return false;
    if(y<0 || y>mazeArray.length-1)
        return false;
    if(mazeArrayVisited[x][y])
        return false;
    if(mazeArray[x][y]==wallNumber)
    return false;

    return true;
}

private boolean findWay(int x, int y)
{
    if(x==mazeArray.length-1 && y==mazeArray.length-1)
    return true;

    if(isFeasible(x,y))
    {
        mazeArrayVisited[x][y]=true;

        if(findWay(x+1,y))
        return true;
        if(findWay(x-1,y))
            return true;
        if(findWay(x,y+1))
            return true;
        if(findWay(x,y-1))
            return true;
        mazeArrayVisited[x][y]=false;
        return  false;
    }

    return false;
}




  public static void main(String[] args) {
    //
      MazeProblem mazeProblem=new MazeProblem();
      mazeProblem.isRouteExist();

  }
}
