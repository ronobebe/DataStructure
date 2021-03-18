package Algorithms.RoughDraft.Trees;

public class BinaryTreePractice3 {

  /** this binary tree will have the operations of (Add, Delete, Insert, Get) */
  Node root;

  int size;

  public int getSize() {
    return this.size;
  }

  public boolean isEmpty() {
    return this.size == 0;
  }

  public void add(int data) {

    Node head = this.root;
    Node newNode = new Node(null, head, data, null);
    if (head == null) this.root = newNode;
    else findNodeAndAdd(newNode, data);
    ++this.size;
  }

  private void findNodeAndAdd(Node newNode, int data) {
    Node head = this.root;

    while (true) {

      if (data < head.data) {
        if (head.left == null) {
          newNode.parent = head;
          head.left = newNode;
          break;
        } else head = head.left;

      } else {
        if (head.right == null) {
          newNode.parent = head;
          head.right = newNode;
          break;
        } else head = head.right;
      }
    }
  }

  public int get(int value) {
    Node node = nodeTraversal(value);
    return node == null ? -1 : node.data;
  }

  Node nodeTraversal(int value) {
    Node head = this.root;

    if (head != null) {
      while (head != null) {
        if (head.data == value) return head;

        if (value < head.data) head = head.left;
        else head = head.right;
      }
    }

    return null;
  }

  public Node minValue() {
    Node head = this.root;
    if (head != null)
      while (head != null) {
        if (head.left == null) return head;
        else head = head.left;
      }
    return null;
  }

  public Node maxValue() {
    Node head = this.root;
    if (head != null)
      while (head != null) {
        if (head.right == null) return head;
        else head = head.right;
      }
    return null;
  }

  /**
   * Condition 1: if the node having the right node then that's the inOrderSuccessor
   *
   * <p>Condition 2: If no right node then traverse through parent node. Right node of the parent
   * node is the successor
   */
  public Node postOrderSuccessor(int val) {
    Node head = nodeTraversal(val);
    if (head != null) {
      // condition 1
      if (head.right != null) {
        if (head.right.left == null) return head.right;
        else {
          head = head.right.left;
          while (head.left != null) {
            head = head.left;
          }
          return head;
        }
      }
      // condition 2
      else {
        while (head.parent != null) {
          if (head == head.parent.right) head = head.parent;
          else return head.parent;
        }
      }
    }
    return null;
  }

  /** Condition 1: Non Leaf Node return next left node */
  public Node preOrderSuccessor(int val) {
    Node head = nodeTraversal(val);
    if (head != null) {
      if (head.left != null) {
        Node temp = head.left.right;

        if (temp == null) return head.left;
        else {
          head = temp;
          while (head.right != null) {
            head = head.right;
          }

          return head;
        }
      } else {

        while (head.parent != null) {
          if (head == head.parent.right) return head.parent;
          else head = head.parent;
        }
      }
    }

    return null;
  }

  private static class Node {
    Node left;
    Node parent;
    int data;
    Node right;

    public Node(Node left, Node parent, int data, Node right) {
      this.left = left;
      this.parent = parent;
      this.data = data;
      this.right = right;
    }
  }

  private int successor(Node root){
    root = root.right;
    while(root.left != null){
      root = root.left;
    }
    return root.data;
  }
  /**
   * Return node's predecessor value
   * @param root
   * @return
   */
  private int predecessor(Node root){
    root = root.left;
    while(root.right != null){
      root = root.right;
    }
    return root.data;
  }


  public  int delete(int val){
    Node node=this.deleteNode(this.root,val);
    if(node!=null)
      --this.size;
    return node==null?-1:node.data;
  }

/**
 * There are 3 conditions to delete Node
 * Condition 1: RequireNode in leaf . Just make that node as null
 * condition 2: Required node having only one branch node. replace this node to that node
 * condition 3: Required node having two branch node. find successor and replace that node
 * */

  private Node deleteNode(Node root, int val)
  {
    if (root==null)
      return null;
    if(val>root.data)
     root.right= deleteNode(root.right, val);
    else if(val<root.data)
      root.left=deleteNode(root.left, val);
    else
    {
      if(root.right==null && root.left==null)
        root=null;
       else if(root.right!=null){
        root.data=successor(root);
        root.right=deleteNode(root.right, root.data);
      }
      else
      {
        root.data=predecessor(root);
        root.left=deleteNode(root.left, root.data);
      }
    }

return  root;
  }

  public static void main(String[] args) {
    //

    BinaryTreePractice3 binaryTreePractice3 = new BinaryTreePractice3();
    binaryTreePractice3.add(6);
    binaryTreePractice3.add(3);
    binaryTreePractice3.add(9);
    binaryTreePractice3.add(14);
    binaryTreePractice3.add(1);
    binaryTreePractice3.add(2);
    binaryTreePractice3.add(7);
    binaryTreePractice3.add(11);

    System.out.println("Min value is : " + binaryTreePractice3.minValue().data);
    System.out.println("Max value is : " + binaryTreePractice3.maxValue().data);
    System.out.println("Size is : " + binaryTreePractice3.getSize());
    System.out.println("delete is : " + binaryTreePractice3.delete(9));
    int va = 11;
    int data = binaryTreePractice3.successor(binaryTreePractice3.nodeTraversal(va));
    System.out.println("PostOrderSuccessor is : " + data == null ? "null" : data);
    data = binaryTreePractice3.predecessor(binaryTreePractice3.nodeTraversal(va));
    System.out.println("PreOrderSuccessor is : " + data == null ? "null" : data);


  }
}
