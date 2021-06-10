package Algorithms.RoughDraft.Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class VertexB {

  private List<VertexB> vertexBList;
  private String name;
  private boolean isVisitedVertex;

  public VertexB(String name) {
    this.name = name;
    this.vertexBList = new ArrayList<>();
  }

  @Override
  public String toString() {
    return "Name = " + name;
  }

  public void addNeighbour(VertexB vertexB) {
    this.vertexBList.add(vertexB);
  }

  public List<VertexB> getNeighbour() {
    return vertexBList;
  }

  public String getName() {
    return name;
  }

  public boolean isVisitedVertex() {
    return isVisitedVertex;
  }

  public void setVisitedVertex(boolean visitedVertex) {
    isVisitedVertex = visitedVertex;
  }
}
