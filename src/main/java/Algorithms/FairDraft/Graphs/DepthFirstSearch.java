package Algorithms.FairDraft.Graphs;

import java.util.List;
import java.util.Stack;

public class DepthFirstSearch {

  Stack<VertexA> vertexAStack;

  public DepthFirstSearch() {
    this.vertexAStack = new Stack<>();
  }

  public void dfs(List<VertexA> inputList) {
    for (VertexA vertexA : inputList) {
      if (!vertexA.isVisited()) {
        vertexA.setVisited(true);
       // dfsHelper(vertexA);
        dfsHelperRecursion(vertexA);
      }
    }
  }

  private void dfsHelper(VertexA vertexA) {
    vertexAStack.add(vertexA);
    while (!vertexAStack.isEmpty()) {
      VertexA actualVertex = vertexAStack.pop();
      System.out.println("Vertex is : " + actualVertex);
      for (VertexA vertexA1 : actualVertex.getNeighbours()) {
        if (!vertexA1.isVisited()) {
          vertexA1.setVisited(true);
          vertexAStack.add(vertexA1);
        }
      }
    }
  }


  private void dfsHelperRecursion(VertexA vertexA)
  {
    for(VertexA vertexA1:vertexA.getNeighbours())
    {
      if(!vertexA1.isVisited())
      {
        System.out.println("Vertex is : " + vertexA1);

        vertexA1.setVisited(true);
        dfsHelperRecursion(vertexA1);
      }
    }
  }
}
