package Algorithms.RoughDraft.Trees;

public class BinaryTreePractice4 {
  private int size;
  private Node root;

  public int size() {
    return this.size;
  }

  public boolean isEmpty() {
    return this.size == 0;
  }

  /** this binary tree will have the operations of (Add, Delete, Insert, Get) */
  public BinaryTreePractice4() {}

  public boolean add(int data) {
    if (this.root == null) this.root = new Node(null, null, data, null);
    else {
      // unique data;
      if (this.addData(data)) ++this.size;
      else return false;
    }
    return true;
  }

  private boolean addData(int data) {
    Node head = this.root;
    while (head != null) {
      if (head.data > data) {
        if (head.left == null) {
          head.left = new Node(null, head, data, null);
          return true;
        } else head = head.left;

      } else if (head.data < data) {
        if (head.right == null) {
          head.right = new Node(null, head, data, null);
          return true;
        } else head = head.right;
      } else return false;
    }
    return false;
  }

  int get(int data) {
    Node node = this.nodeTraversal(data);
    return node != null ? node.data : -1;
  }

  Node nodeTraversal(int data) {
    Node head = this.root;
    if (head == null) return null;
    else {

      while (head.data != data) {
        if (head.data > data) {
          head = head.left;
        } else head = head.right;
      }
    }

    return head.data == data ? head : (Node) null;
  }

  public boolean insert(int data) {
    return this.add(data);
  }

  public Node min() {
    Node node = this.root;
    if (node == null) return null;
    else {
      while (node.left != null) {
        node = node.left;
      }
    }
    return node;
  }

  public Node max() {
    Node node = this.root;
    if (node == null) return null;
    else
      while (node.right != null) {
        node = node.right;
      }
    return node;
  }

  public Node postOrderSuccessor(Node root) {
    root = root.right;
    while (root.left != null) {
      root = root.left;
    }
    return root;
  }

  public int postOrderSuccessorData(Node head) {

    return postOrderSuccessor(head).data;
  }

  public int preOrderSuccessorData(Node head) {

    return preOrderSuccessor(head).data;
  }

  public Node preOrderSuccessor(Node root) {
    root = root.left;
    while (root.right != null) {
      root = root.right;
    }
    return root;
  }

  public  int delete(int data)
  {
    System.out.println("Max depth is : " + maxDepth(nodeTraversal(21)));

    return deleteNode(this.root,data).data;
  }

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

  int maxDepth(Node node)
  {
    if (node == null)
      return -1;
    else
    {
      /* compute the depth of each subtree */
      int lDepth = maxDepth(node.getLeft());
      int rDepth = maxDepth(node.getRight());

      /* use the larger one */
      if (lDepth > rDepth)
        return (lDepth + 1);
      else
        return (rDepth + 1);
    }
  }




  public static class Node {
    private Node left;
    private Node Parent;
    private int data;
    private Node right;

    public Node(Node left, Node parent, int data, Node right) {
      this.left = left;
      Parent = parent;
      this.data = data;
      this.right = right;
    }

    public Node getLeft() {
      return left;
    }

    public void setLeft(Node left) {
      this.left = left;
    }

    public Node getParent() {
      return Parent;
    }

    public void setParent(Node parent) {
      Parent = parent;
    }

    public int getData() {
      return data;
    }

    public void setData(int data) {
      this.data = data;
    }

    public Node getRight() {
      return right;
    }

    public void setRight(Node right) {
      this.right = right;
    }
  }

  public static void main(String[] args) {

    BinaryTreePractice4 binaryTreePractice4 = new BinaryTreePractice4();
    binaryTreePractice4.add(21);
    binaryTreePractice4.add(18);
    binaryTreePractice4.add(31);
    binaryTreePractice4.add(17);
    binaryTreePractice4.add(19);
    binaryTreePractice4.add(24);
    binaryTreePractice4.add(23);
    binaryTreePractice4.add(28);
    binaryTreePractice4.add(22);
    /*System.out.println("Inserting values 1 to 10");
    for (int i = 1; i < 10; i++) binaryTreePractice4.add(i);
*/

    System.out.println("Get data is : " + binaryTreePractice4.get(3));
    System.out.println("Size of data is : " + binaryTreePractice4.size());
    System.out.println("IsEmpty data is : " + binaryTreePractice4.isEmpty());
    System.out.println("min data is : " + binaryTreePractice4.min().data);
    System.out.println("max data is : " + binaryTreePractice4.max().data);
    System.out.println("delete data is : " + binaryTreePractice4.delete(24));

  }
}
