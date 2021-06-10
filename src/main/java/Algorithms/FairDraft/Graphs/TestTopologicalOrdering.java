package Algorithms.FairDraft.Graphs;

import java.util.ArrayList;
import java.util.List;

public class TestTopologicalOrdering {


  public static void main(String[] args) {
    List<VertexEdge> vertexEdgesList=new ArrayList<>();
      VertexEdge vertexEdgeS=new VertexEdge("S");
      VertexEdge vertexEdgeA=new VertexEdge("A");
      VertexEdge vertexEdgeB=new VertexEdge("B");
      VertexEdge vertexEdgeC=new VertexEdge("C");
      VertexEdge vertexEdgeD=new VertexEdge("D");
      VertexEdge vertexEdgeE=new VertexEdge("E");

      vertexEdgeS.setEdge(new Edge(vertexEdgeA,1));
      vertexEdgeS.setEdge(new Edge(vertexEdgeC,2));

      vertexEdgeA.setEdge(new Edge(vertexEdgeB,6));

      vertexEdgeB.setEdge(new Edge(vertexEdgeD,1));
      vertexEdgeB.setEdge(new Edge(vertexEdgeE,2));

      vertexEdgeC.setEdge(new Edge(vertexEdgeA,4));
      vertexEdgeC.setEdge(new Edge(vertexEdgeD,3));

      vertexEdgeD.setEdge(new Edge(vertexEdgeE,1));

      vertexEdgesList.add(vertexEdgeS);
      vertexEdgesList.add(vertexEdgeA);
      vertexEdgesList.add(vertexEdgeB);
      vertexEdgesList.add(vertexEdgeC);
      vertexEdgesList.add(vertexEdgeD);
      vertexEdgesList.add(vertexEdgeE);


      ShortestPath shortestPath=new ShortestPath(vertexEdgesList);
      shortestPath.compute();

      for(VertexEdge v:vertexEdgesList)
          System.out.println("\nDistance is "+v.getPreceded()+" - "+v.getMinDistance());

  }
}
