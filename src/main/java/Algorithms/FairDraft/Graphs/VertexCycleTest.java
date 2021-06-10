package Algorithms.FairDraft.Graphs;

import java.util.ArrayList;
import java.util.List;

public class VertexCycleTest {


  public static void main(String[] args) {
    //
      List<VertexCycle> vertexCycleList=new ArrayList<>();
      VertexCycle vertexCycleS=new VertexCycle("S");
      VertexCycle vertexCycleA=new VertexCycle("A");
      VertexCycle vertexCycleB=new VertexCycle("B");
      VertexCycle vertexCycleC=new VertexCycle("C");
      VertexCycle vertexCycleD=new VertexCycle("D");
      VertexCycle vertexCycleE=new VertexCycle("E");

      vertexCycleS.setVertexCycleList(vertexCycleA);
      vertexCycleA.setVertexCycleList(vertexCycleB);
      vertexCycleA.setVertexCycleList(vertexCycleE);
      vertexCycleB.setVertexCycleList(vertexCycleC);
      vertexCycleB.setVertexCycleList(vertexCycleD);
      vertexCycleE.setVertexCycleList(vertexCycleS);

      vertexCycleList.add(vertexCycleS);
      vertexCycleList.add(vertexCycleA);
      vertexCycleList.add(vertexCycleB);
      vertexCycleList.add(vertexCycleC);
      vertexCycleList.add(vertexCycleD);
      vertexCycleList.add(vertexCycleE);

      CycleDetection cycleDetection=new CycleDetection();
      cycleDetection.detectCycle(vertexCycleList);




  }
}
