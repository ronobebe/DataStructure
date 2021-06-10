package Algorithms.FairDraft.Graphs;

public class DijkstarasAlgorithmTest {


  public static void main(String[] args) {
    //
      VertexDijkstra vertexDijkstra0=new VertexDijkstra("A");
      VertexDijkstra vertexDijkstra1=new VertexDijkstra("B");
      VertexDijkstra vertexDijkstra2=new VertexDijkstra("C");

      vertexDijkstra0.addEdge(new EdgeDijkstra(vertexDijkstra0,vertexDijkstra0,1));
      vertexDijkstra0.addEdge(new EdgeDijkstra(vertexDijkstra0,vertexDijkstra2,3));
      vertexDijkstra1.addEdge(new EdgeDijkstra(vertexDijkstra1,vertexDijkstra2,1));

      DijkstrasAlgorithm dijkstrasAlgorithm=new DijkstrasAlgorithm();
      dijkstrasAlgorithm.commute(vertexDijkstra0);

      System.out.println(" "+dijkstrasAlgorithm.getShortLength(vertexDijkstra2));

  }
}
