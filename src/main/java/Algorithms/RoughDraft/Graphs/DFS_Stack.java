package Algorithms.RoughDraft.Graphs;

import java.util.*;

public class DFS_Stack {
  Stack<VertexB> vertexBStack;

  public DFS_Stack() {
    vertexBStack = new Stack<>();
  }

  public void dFs(List<VertexB> vertexBList) {
    for (VertexB vb : vertexBList) {
      if (!vb.isVisitedVertex()) {
        vb.setVisitedVertex(true);
        dfsHelper(vb);
      }
    }
  }

  private void dfsHelper(VertexB vb) {

    vertexBStack.add(vb);
    vb.setVisitedVertex(true);

    while (!vertexBStack.isEmpty()) {

      VertexB vertexB = vertexBStack.pop();
      System.out.println("Vertex is : " + vertexB);

      for (VertexB vertexB1 : vertexB.getNeighbour()) {
        if (!vertexB1.isVisitedVertex()) {
          vertexB1.setVisitedVertex(true);
          vertexBStack.add(vertexB1);
        }
        //
      }
    }
  }

  public static void main(String[] args) {
    VertexB vertexB1=new VertexB("A");
    VertexB vertexB2=new VertexB("B");
    VertexB vertexB3=new VertexB("C");
    VertexB vertexB4=new VertexB("D");
    VertexB vertexB5=new VertexB("E");

    List<VertexB> vertexBList=new ArrayList<>();
    vertexB1.addNeighbour(vertexB2);
    vertexB1.addNeighbour(vertexB3);
    vertexB3.addNeighbour(vertexB4);
    vertexB4.addNeighbour(vertexB5);

    vertexBList.add(vertexB1);
    vertexBList.add(vertexB2);
    vertexBList.add(vertexB3);
    vertexBList.add(vertexB4);
    vertexBList.add(vertexB5);

   /* DFS_Stack dfs_stack=new DFS_Stack();
    dfs_stack.dFs(vertexBList);*/
    DFS_Recursion dfs_recursion=new DFS_Recursion();
    dfs_recursion.dfsRecursionMethod(vertexBList);

  }
}
