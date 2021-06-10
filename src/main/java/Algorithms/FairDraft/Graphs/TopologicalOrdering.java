package Algorithms.FairDraft.Graphs;

import java.util.List;

import java.util.Stack;

public class TopologicalOrdering {
Stack<VertexEdge> vertexEdgeStack;
    public TopologicalOrdering(List<VertexEdge> vertexEdgeList) {
        this.vertexEdgeStack = new Stack();
        dfs(vertexEdgeList);
    }

    public  void dfs(List<VertexEdge> vertexEdgeList)
    {
        for(VertexEdge ve:vertexEdgeList)
            if(!ve.isVisited())
                dfsHelper(ve);
    }

    private void dfsHelper(VertexEdge vertexEdge)
    {
        vertexEdge.setVisited(true);

        for(Edge e:vertexEdge.getEdgeList())
        {
            VertexEdge ve=e.getTarget();
            if(!ve.isVisited())
            {
                ve.setVisited(true);
                dfsHelper(ve);
            }

            vertexEdgeStack.add(vertexEdge);

        }
    }
    public  Stack<VertexEdge> getOrder()
    {
        return this.vertexEdgeStack;
    }
}
