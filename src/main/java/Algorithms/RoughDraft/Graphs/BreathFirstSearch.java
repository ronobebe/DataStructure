package Algorithms.RoughDraft.Graphs;

import Algorithms.FairDraft.Trees.AVLTree;
import Algorithms.FairDraft.Trees.BFSandDFS;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class BreathFirstSearch extends AVLTree {

  public String bfsNode() {

    return breathFirstSearch(root);
  }

  public void breathFirstSearch(VertexA base) {

    Queue<VertexA> queue = new LinkedList<>();
    base.setVisited(true);
    queue.add(base);

    while (!queue.isEmpty()) {
      VertexA tempVertex = queue.poll();
      System.out.println("Visited Vertex is : " + tempVertex);

      for (VertexA vtx : tempVertex.getVertexAList()) {
        if (!vtx.isVisited()) {
          vtx.setVisited(true);
          queue.add(vtx);
        }
      }
    }
  }

  private String breathFirstSearch(Node base) {

    StringBuilder sb = new StringBuilder();

    Queue<Node> queue = new LinkedList<>();
    queue.add(base);

    while (!queue.isEmpty()) {
      Node temp = queue.poll();
      if (temp.getLeft() != null) queue.add(temp.getLeft());
      if (temp.getRight() != null) queue.add(temp.getRight());
      sb.append(temp.getData()).append(" , ");
    }

    return sb.toString();
  }

  public static void main(String[] args) {
    //

    BreathFirstSearch bfSandDFS = new BreathFirstSearch();
    bfSandDFS.add(21);
    bfSandDFS.add(15);
    bfSandDFS.add(11);
    bfSandDFS.add(18);
    bfSandDFS.add(7);
    bfSandDFS.add(14);
    bfSandDFS.add(17);
    bfSandDFS.add(20);
    bfSandDFS.add(27);
    bfSandDFS.add(25);
    bfSandDFS.add(29);
    bfSandDFS.add(24);
    bfSandDFS.add(26);
    bfSandDFS.add(28);
    // System.out.println(bfSandDFS.bfsNode());
    bfSandDFS.breathFirstSearch(AddVertexNodes.add1());
  }
}
