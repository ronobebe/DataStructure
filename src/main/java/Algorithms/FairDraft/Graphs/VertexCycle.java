package Algorithms.FairDraft.Graphs;

import java.util.ArrayList;
import java.util.List;

public class VertexCycle {
   private List<VertexCycle> vertexCycleList;
    private boolean isVisited;
    private String name;
    private boolean isBeingVisited;

    public VertexCycle(String name) {
        this.name = name;
        this.vertexCycleList=new ArrayList<>();
    }

    public List<VertexCycle> getVertexCycleList() {
        return vertexCycleList;
    }

    public void setVertexCycleList(VertexCycle vertexCycle) {
        this.vertexCycleList.add( vertexCycle);
    }

    public boolean isVisited() {
        return isVisited;
    }

    public void setVisited(boolean visited) {
        isVisited = visited;
    }

    public String getName() {
        return toString();
    }


    @Override
    public String toString() {
        return "VertexCycle{" +
                "name='" + name + '\'' +
                '}';
    }

    public boolean isBeingVisited() {
        return isBeingVisited;
    }


    public void setBeingVisited(boolean beingVisited) {
        isBeingVisited = beingVisited;
    }
}
