package Algorithms.FairDraft.Graphs;

public class Edge {
    private VertexEdge target;
    private int weight;

    public Edge(VertexEdge target, int weight) {
        this.target = target;
        this.weight = weight;
    }

    public VertexEdge getTarget() {
        return target;
    }

    public void setTarget(VertexEdge target) {
        this.target = target;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}
