package Algorithms.FairDraft.Graphs;

import java.util.List;

public class CycleDetection {

    public void detectCycle(List<VertexCycle> vertexCycleList)
    {
        for (VertexCycle vc:vertexCycleList)
            if(!vc.isVisited())
                dfs(vc);
    }


    private void dfs(VertexCycle vertexCycle)
    {
        vertexCycle.setBeingVisited(true);

        for(VertexCycle vc:vertexCycle.getVertexCycleList())
        {
            if(vc.isBeingVisited())
            {
                System.out.println("Cycle Detected");
                return;
            }
            if(!vc.isVisited())
            {
                vc.setVisited(true);
                dfs(vc);
            }
        }
        vertexCycle.setBeingVisited(false);
        vertexCycle.setVisited(true);

    }
}
