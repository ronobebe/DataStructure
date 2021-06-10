package Algorithms.RoughDraft.Graphs;

import java.util.List;
import java.util.Stack;

public class DFS_Recursion {

    Stack<VertexB> vertexBStack;
    public DFS_Recursion()
    {
      vertexBStack=new Stack<>() ;
    }

    public void dfsRecursionMethod(List<VertexB> vertexBList)
    {
        for(VertexB vertexB:vertexBList)
        {
            if(!vertexB.isVisitedVertex())
            {
                vertexB.setVisitedVertex(true);
                dfsRecursionHelper(vertexB);
            }
        }
    }

    private void dfsRecursionHelper(VertexB vertexB) {


        System.out.println("Vertex is : "+vertexB);

        for(VertexB vertexB1:vertexB.getNeighbour())
        {
            if(!vertexB1.isVisitedVertex())
            {
                vertexB1.setVisitedVertex(true);
                dfsRecursionHelper(vertexB1);
            }
        }


    }
}
