package Algorithms.FairDraft.Graphs;

public class EdgeDijkstra {
  private VertexDijkstra startVertex;
  private VertexDijkstra destinationVertex;
  private int minDistance;

  public EdgeDijkstra(
      VertexDijkstra startVertex, VertexDijkstra destinationVertex, int minDistance) {
    this.startVertex = startVertex;
    this.destinationVertex = destinationVertex;
    this.minDistance = minDistance;
  }

  public VertexDijkstra getStartVertex() {
    return startVertex;
  }

  public void setStartVertex(VertexDijkstra startVertex) {
    this.startVertex = startVertex;
  }

  public VertexDijkstra getDestinationVertex() {
    return destinationVertex;
  }

  public void setDestinationVertex(VertexDijkstra destinationVertex) {
    this.destinationVertex = destinationVertex;
  }

  public int getMinDistance() {
    return minDistance;
  }

  public void setMinDistance(int minDistance) {
    this.minDistance = minDistance;
  }
}
