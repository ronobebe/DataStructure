package Algorithms.FairDraft.Graphs;


import Algorithms.RoughDraft.Problems.TopologicalOrdering;

import java.util.ArrayList;
import java.util.List;

public class AdjacentMatrixAndList {

    private int[][] adjacentMatrix={
            {0,3,2,0},
            {0,0,3,0},
            {0,4,1,0},
            {0,0,0,0},
    };

    public  static   List<VertexA>  adjacentList()
    {
        List<VertexA> vertexAList=new ArrayList<>();
        VertexA vertexA=new VertexA("A");
        VertexA vertexB=new VertexA("B");
        VertexA vertexC=new VertexA("C");
        VertexA vertexD=new VertexA("D");
        VertexA vertexE=new VertexA("E");
        VertexA vertexF=new VertexA("F");
        VertexA vertexG=new VertexA("G");
        VertexA vertexH=new VertexA("H");
        VertexA vertexI=new VertexA("I");

        vertexA.addNeighbours(vertexB);
        vertexA.addNeighbours(vertexC);
        vertexB.addNeighbours(vertexD);
        vertexB.addNeighbours(vertexE);
        vertexC.addNeighbours(vertexF);
        vertexF.addNeighbours(vertexI);
        vertexE.addNeighbours(vertexG);
        vertexE.addNeighbours(vertexH);

        vertexAList.add(vertexA);
        vertexAList.add(vertexB);
        vertexAList.add(vertexC);
        vertexAList.add(vertexD);
        vertexAList.add(vertexE);
        vertexAList.add(vertexF);
        vertexAList.add(vertexG);
        vertexAList.add(vertexH);
        vertexAList.add(vertexI);

        return  vertexAList;
    }

  public static void main(String[] args) {
    //
   /*   BreathFirstSearch breathFirstSearch=new BreathFirstSearch();
      breathFirstSearch.bfs(AdjacentMatrixAndList.adjacentList());

      DepthFirstSearch depthFirstSearch=new DepthFirstSearch();
      depthFirstSearch.dfs(AdjacentMatrixAndList.adjacentList());
*/
      TopologicalOrdering topologicalOrdering=new TopologicalOrdering();
      topologicalOrdering.dfs(AdjacentMatrixAndList.adjacentList());
      topologicalOrdering.printTopologicalOrdering();
  }
}
