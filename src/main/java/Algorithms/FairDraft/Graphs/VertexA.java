package Algorithms.FairDraft.Graphs;



import java.util.ArrayList;
import java.util.List;

public class VertexA {

    private boolean isVisited;
    private List<VertexA> vertexAList;
    private String name;

    public VertexA(String name)
    {
        this.name=name;
        vertexAList=new ArrayList();
    }

    public List<VertexA> getNeighbours()
    {
        return  this.vertexAList;
    }
    public void addNeighbours(VertexA vertexA)
    {
        this.vertexAList.add(vertexA);
    }

    @Override
    public String toString() {
        return "Vertex Name is : "+name;
    }

    public String getName()
    {
        return this.name;
    }

    public boolean isVisited() {
        return isVisited;
    }

    public void setVisited(boolean visited) {
        isVisited = visited;
    }
}
