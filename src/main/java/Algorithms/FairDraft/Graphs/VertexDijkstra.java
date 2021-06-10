package Algorithms.FairDraft.Graphs;

import java.util.ArrayList;
import java.util.List;

public class VertexDijkstra implements  Comparable<VertexDijkstra> {
  private List<EdgeDijkstra> edgeDijkstraList;
  private boolean isVisited;
  private String name;
  private double minDistance = Double.MAX_VALUE;
  private VertexDijkstra preceded;

  public VertexDijkstra(String name) {
    this.name = name;
    this.edgeDijkstraList = new ArrayList<>();
  }

  @Override
  public String toString() {
    return name;
  }

  public List<EdgeDijkstra> getEdgeDijkstraList() {
    return edgeDijkstraList;
  }

  public void addEdge(EdgeDijkstra edgeDijkstra) {
    this.edgeDijkstraList.add(edgeDijkstra);
  }

  public boolean isVisited() {
    return isVisited;
  }

  public void setVisited(boolean visited) {
    isVisited = visited;
  }

  public String getName() {
    return toString();
  }

  public double getMinDistance() {
    return minDistance;
  }

  public void setMinDistance(double minDistance) {
    this.minDistance = minDistance;
  }

  public VertexDijkstra getPreceded() {
    return preceded;
  }

  public void setPreceded(VertexDijkstra preceded) {
    this.preceded = preceded;
  }

  @Override
  public int compareTo(VertexDijkstra o) {
    return Double.compare(this.minDistance,o.getMinDistance());
  }
}
