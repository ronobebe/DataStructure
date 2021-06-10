package Algorithms.FairDraft.Graphs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class DijkstrasAlgorithm {


  public DijkstrasAlgorithm() {


  }

  public void commute(VertexDijkstra vertexDijkstra) {

      vertexDijkstra.setMinDistance(0);
      PriorityQueue<VertexDijkstra> vertexDijkstraPriorityQueue = new PriorityQueue<>();
      vertexDijkstraPriorityQueue.add(vertexDijkstra);

    while (!vertexDijkstraPriorityQueue.isEmpty()) {
      VertexDijkstra vd = vertexDijkstraPriorityQueue.poll();

      for (EdgeDijkstra edgeDijkstra : vd.getEdgeDijkstraList()) {
        double tot = vd.getMinDistance() + edgeDijkstra.getMinDistance();

        VertexDijkstra destVertex = edgeDijkstra.getDestinationVertex();
        if (tot < destVertex.getMinDistance()) {
          vertexDijkstraPriorityQueue.remove(destVertex);
          destVertex.setMinDistance(tot);
          destVertex.setPreceded(vd);
          vertexDijkstraPriorityQueue.add(destVertex);
        }
      }
    }
  }

  public List<VertexDijkstra> getShortLength(VertexDijkstra source)
  {
      List<VertexDijkstra> vertexDijkstraList=new ArrayList<>();

      for(VertexDijkstra vd=source;vd!=null; vd=vd.getPreceded() )
      {
          vertexDijkstraList.add(vd);
      }
      Collections.reverse(vertexDijkstraList);
      return vertexDijkstraList;
  }
}
