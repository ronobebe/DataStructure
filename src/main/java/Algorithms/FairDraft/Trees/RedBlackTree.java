package Algorithms.FairDraft.Trees;



import java.util.TreeMap;

public class RedBlackTree {

  Node root;
  int size;
  Node nil=new Node(null,-1);

  public boolean insert(int data) {

    return add(data);
  }

  public boolean add(int data) {
    boolean addNode = addNode(data);
    if (addNode){
      ++this.size;}

    return addNode;
  }

  private boolean addNode(int data) {
    Node head = this.root;
    if (head == null) {
      this.root = new Node(null, data);
      this.root.color=true;
       this.root.parent=nil;
    } else {

      while (head != null) {
        if (head.data > data)
          if (head.left == null) {
            head.left = new Node(head, data);
            head=head.left;
            break;
          } else head = head.left;
        else if (head.right == null) {
          head.right = new Node(head, data);
          head=head.right;
          break;
        } else head = head.right;
      }
      fixTree(head);

    }

    return true;
  }




  void rotateLeft(Node node) {
    if (node.parent != null) {
      if (node == node.parent.left) {
        node.parent.left = node.right;
      } else {
        node.parent.right = node.right;
      }
      node.right.parent = node.parent;
      node.parent = node.right;
      if (node.right.left != null) {
        node.right.left.parent = node;
      }
      node.right = node.right.left;
      node.parent.left = node;
    } else {
      Node right = root.right;
      root.right = right.left;
      right.left.parent = root;
      root.parent = right;
      right.left = root;
      right.parent = null;
      root = right;
    }
  }

  void rotateRight(Node node) {
    if (node.parent != null) {
      if (node == node.parent.left) {
        node.parent.left = node.left;
      } else {
        node.parent.right = node.left;
      }

      node.left.parent = node.parent;
      node.parent = node.left;
      if (node.left.right != null) {
        node.left.right.parent = node;
      }
      node.left = node.left.right;
      node.parent.right = node;
    } else {
      Node left = root.left;
      root.left = root.left.right;
      left.right.parent = root;
      root.parent = left;
      left.right = root;
      left.parent = null;
      root = left;
    }
  }

  /**
   * Base Conditions :
   * root must be black
   * No consecutive red nodes
   * Number of black nodes in each path must be same
   *
   * Check Conditions :
   * If Parent Of a new Node is Black then exit
   * Parent is red then check sibling of parent
   * A)black then do suitable rotations and recolour
   * B)red just recolor till the root node
   *
   *
   * */
  private void fixTree(Node node) {
    while (!node.parent.color) {
      Node parentSibling = null;
      if (node.parent == node.parent.parent.left) {
        parentSibling = node.parent.parent.right;

        if (parentSibling != null && !parentSibling.color ) {
          node.parent.color =true ;
          parentSibling.color = false;
          node.parent.parent.color = false;
          node = node.parent.parent;
          continue;
        }
        if (node == node.parent.right) {
          node = node.parent;
          rotateLeft(node);
        }
        node.parent.color = true;
        node.parent.parent.color = false;
        rotateRight(node.parent.parent);
      } else {
        parentSibling = node.parent.parent.left;
        if (parentSibling != null && !parentSibling.color) {
          node.parent.color = true;
          parentSibling.color = true;
          node.parent.parent.color = false;
          node = node.parent.parent;
          continue;
        }
        if (node == node.parent.left) {
          node = node.parent;
          rotateRight(node);
        }
        node.parent.color = true;
        node.parent.parent.color = false;
        rotateLeft(node.parent.parent);
      }
    }
    root.color = true;
  }


  /**
   * EverparentSibling new node color should be in red. So consider
   * @paramColor = false as red , true as black;
   * EverparentSibling null node is consider as black node
   *
   * */
  private static class Node {
    Node left;
    Node parent;
    int data;
    boolean color;
    Node right;



    public Node(Node parent, int data) {
      this.parent = parent;
      this.data = data;
    }
  }



  public static void main(String[] args) {
    //
    RedBlackTree redBlackTree=new RedBlackTree();
    redBlackTree.add(9);
    redBlackTree.add(4);
    redBlackTree.add(8);
    redBlackTree.add(10);
    redBlackTree.add(5);
    redBlackTree.add(6);
    redBlackTree.add(11);
    redBlackTree.add(18);
    redBlackTree.add(20);
    redBlackTree.add(5);
    redBlackTree.add(3);
    redBlackTree.add(21);

  }
}
