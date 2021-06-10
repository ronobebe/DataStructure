package Algorithms.RoughDraft.Graphs;

import java.util.ArrayList;
import java.util.List;

public class VertexA {

    private List<VertexA> vertexAList;
    private String name;
    private  boolean isVisited;

    public VertexA(String name) {
        this.name = name;
        vertexAList=new ArrayList<>();
    }

    @Override
    public String toString() {
        return this.name;
    }

    public List<VertexA> getVertexAList() {
        return vertexAList;
    }

    public void setVertex(VertexA vertexAList) {
        this.vertexAList.add( vertexAList);
    }

    public String getName() {
        return name;
    }

    public boolean isVisited() {
        return isVisited;
    }

    public void setVisited(boolean visited) {
        isVisited = visited;
    }
}
