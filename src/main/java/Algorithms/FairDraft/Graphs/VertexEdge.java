package Algorithms.FairDraft.Graphs;

import java.util.List;

import java.util.ArrayList;

public class VertexEdge {

    private  String vertexName;
    private List<Edge> edgeList;
    private boolean visited;
    private int minDistance;
    private VertexEdge preceded;

    public VertexEdge(String vertexName) {
        this.vertexName = vertexName;
        this.edgeList=new ArrayList();
        this.minDistance=Integer.MAX_VALUE;
    }

    @Override
    public String toString() {
        return this.vertexName+" - "+this.preceded;
    }



    public List<Edge> getEdgeList() {
        return edgeList;
    }

    public void setEdge(Edge edgeList) {
        this.edgeList .add(edgeList);
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public int getMinDistance() {
        return minDistance;
    }

    public void setMinDistance(int minDistance) {
        this.minDistance = minDistance;
    }

    public VertexEdge getPreceded() {
        return preceded;
    }

    public void setPreceded(VertexEdge preceded) {
        this.preceded = preceded;
    }
}
