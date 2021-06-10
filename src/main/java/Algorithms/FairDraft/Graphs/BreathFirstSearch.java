package Algorithms.FairDraft.Graphs;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class BreathFirstSearch {
  Queue<VertexA> vertexAQueue;

  public BreathFirstSearch() {
    this.vertexAQueue = new LinkedList<>();
  }

  public void bfs(List<VertexA> mainList) {
    for (VertexA v : mainList)
      if (!v.isVisited()) {
        v.setVisited(true);
        vertexAQueue.add(v);
        /*bfsHelper*/bfsHelperRecursion(vertexAQueue);
      }
  }

  private void bfsHelper(VertexA v) {
    v.setVisited(true);
    vertexAQueue.add(v);

    while (!vertexAQueue.isEmpty()) {
      VertexA actualVertex = vertexAQueue.poll();
      System.out.println("Vertex is : " + actualVertex);

      for (VertexA va : actualVertex.getNeighbours()) {
        if (!va.isVisited()) {
          va.setVisited(true);
          vertexAQueue.add(va);
        }
      }
    }
  }

  private void bfsHelperRecursion(Queue<VertexA> vertexAQueue1)
  {

    if(vertexAQueue1.isEmpty())
      return;

    VertexA v=vertexAQueue1.poll();

    for(VertexA va:v.getNeighbours())
    {
      if(!va.isVisited())
      {
        System.out.println("Vertex is : " + va);
        v.setVisited(true);
        vertexAQueue1.add(va);
      }
    }
    bfsHelperRecursion( vertexAQueue1);
  }
}
