package Algorithms.RoughDraft.Graphs;

public class AddVertexNodes {

    int[][] arrMain={
            {0,3,2,0},
            {0,0,3,0},
            {0,4,1,0},
            {0,0,0,0},
    };

  public static VertexA add1() {

    VertexA vertexA = new VertexA("A");
    VertexA vertexB = new VertexA("B");
    VertexA vertexC = new VertexA("C");
    VertexA vertexD = new VertexA("D");

      vertexA.setVertex(vertexB);
      vertexA.setVertex(vertexC);

      vertexB.setVertex(vertexC);

      vertexC.setVertex(vertexD);
      vertexC.setVertex(vertexA);

      return vertexA;
    }

}
