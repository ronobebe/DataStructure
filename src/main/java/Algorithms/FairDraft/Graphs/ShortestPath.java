package Algorithms.FairDraft.Graphs;

import java.util.List;

import java.util.Stack;

public class ShortestPath {
    private TopologicalOrdering topologicalOrdering;

    public ShortestPath(List<VertexEdge> vertexEdgeList)
    {
        this.topologicalOrdering=new TopologicalOrdering(vertexEdgeList);
        vertexEdgeList.get(0).setMinDistance(0);
    }

    public void  compute()
    {
        Stack<VertexEdge>  vertexEdgeStack=topologicalOrdering.getOrder();
        while (!vertexEdgeStack.isEmpty())
        {
            VertexEdge s=vertexEdgeStack.pop();

            for(Edge edge:s.getEdgeList())
            {
                VertexEdge v= edge.getTarget();
                if(v.getMinDistance()>s.getMinDistance()+edge.getWeight())
                {
                    v.setMinDistance(s.getMinDistance()+edge.getWeight());
                    v.setPreceded(s);
                }

            }
        }
    }



}
