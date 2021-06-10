package Algorithms.RoughDraft.Problems;

import Algorithms.FairDraft.Graphs.VertexA;

import java.util.List;
import java.util.Stack;

public class TopologicalOrdering {

    Stack<VertexA> vertexAStack;

    public TopologicalOrdering()
    {
        vertexAStack=new Stack<>();
    }

    public  void dfs(List<VertexA> bfsLits)
    {
        for (VertexA va:bfsLits)
        {
            if(!va.isVisited())
            {
                va.setVisited(true);
               // dfsHelper(va);
               dfsHelperRecursion(va);
            }
        }
    }
    private void dfsHelper(VertexA v)
    {

        v.setVisited(true);
        vertexAStack.add(v);
        while(!vertexAStack.isEmpty())
        {
            VertexA va=vertexAStack.pop();
            System.out.println("Vertex name is : "+va);
            for(VertexA vertexA:va.getNeighbours())
            {
                if(!vertexA.isVisited())
                {
                    vertexA.setVisited(true);
                    vertexAStack.add(vertexA);
                }
            }
        }
    }

    private void dfsHelperRecursion(VertexA v)
    {
        v.setVisited(true);
        for(VertexA va:v.getNeighbours())
        {
            if(!va.isVisited())
            {
                va.setVisited(true);
                dfsHelperRecursion(va);
            }
        }

        vertexAStack.push(v);
    }

    public void printTopologicalOrdering()
    {
        int size=vertexAStack.size();
        for(int i=0; i<size; i++)
        {
            System.out.println("Topological order is : "+ vertexAStack.pop());
        }

    }
}
