package Algorithms.FairDraft.Trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BFSandDFS extends AVLTree {

  @Override
  public boolean add(int data) {
    return super.add(data);
  }

  public String[] breathFirstSearch() {

    if(super.root==null)
      return null;
    StringBuilder sb = new StringBuilder();
    sb = breathFirstSearch(super.root, sb);
    System.out.println("BFS is : " + sb.toString());
    String[] stringArray = sb.toString().split(" ");
    return stringArray;
  }

  private StringBuilder breathFirstSearch(Node node, StringBuilder sb) {
    Queue<Node> nodeQueue = new LinkedList<>();
    nodeQueue.add(node);

    int size = nodeQueue.size();

    while (size > 0) {

      for (int i = 0; i < size; i++) {
        Node node1 = nodeQueue.peek();
        sb.append(node1.data + " ");
        nodeQueue.remove(node1);
        if (node1.left != null) nodeQueue.add(node1.left);
        if (node1.right != null) nodeQueue.add(node1.right);
      }
      size = nodeQueue.size();
    }
    return sb;
  }


  /* Given a binary tree, print its nodes in inorder*/
  void printInorder(Node node)
  {
    if (node == null)
      return;

    /* first recur on left child */
    printInorder(node.left);

    /* then print the data of node */
    System.out.print(node.data + " ");

    /* now recur on right child */
    printInorder(node.right);
  }

  // Wrappers over above recursive functions
  void printInorder() { printInorder(root); }


  void printPreorder(Node node)
  {
    if (node == null)
      return;

    /* first print data of node */
    System.out.print(node.data + " ");

    /* then recur on left sutree */
    printPreorder(node.left);

    /* now recur on right subtree */
    printPreorder(node.right);
  }

  // Wrappers over above recursive functions
  void printPreorder() { printPreorder(root); }



  void printPostorder(Node node)
  {
    if (node == null)
      return;

    // first recur on left subtree
    printPostorder(node.left);

    // then recur on right subtree
    printPostorder(node.right);

    // now deal with the node
    System.out.print(node.data + " ");
  }

  // Wrappers over above recursive functions
  void printPostorder() { printPostorder(root); }


  public static void main(String[] args) {
    //
    BFSandDFS bfSandDFS = new BFSandDFS();
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
    System.out.println("Print in order");
    bfSandDFS.printInorder();
    System.out.println("\nPrint pre order");
    bfSandDFS.printPreorder();
    System.out.println("\nPrint post order");
    bfSandDFS.printPostorder();
    System.out.println("\nPrint BFS");
    bfSandDFS.breathFirstSearch();
  }
}
