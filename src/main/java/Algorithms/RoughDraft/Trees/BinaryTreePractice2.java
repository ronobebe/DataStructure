package Algorithms.RoughDraft.Trees;

public class BinaryTreePractice2<V> {

  private int size;
  Node root;

  Node minValue(Node node) {
    Node current = node;
    while (current.leftNode != null) {
      current = current.leftNode;
    }
    return current;
  }

  Node maxValue(Node node) {
    Node currentNode = node;
    while (currentNode.rightNode != null) {
      currentNode = currentNode.rightNode;
    }
    return currentNode;
  }

  Node inOrderSuccessor(V val) {
    Node n = searchVal(this.root, val);

    return inOrderSuccessor(n, val);
  }

  Node inOrderSuccessor(Node n, V val) {
    if (n.rightNode != null) return minValue(n.rightNode);

    Node p = n.parent;
    while (p != null && n == p.rightNode) {
      n = p;
      p = p.parent;
    }
    return p;
  }

  private V successor(Node root){
    root = root.rightNode;
    while(root.leftNode != null){
      root = root.leftNode;
    }
    return (V)root.data;
  }
  /**
   * Return node's predecessor value
   * @param root
   * @return
   */
  private V predecessor(Node root){
    root = root.leftNode;
    while(root.rightNode != null){
      root = root.rightNode;
    }
    return (V)root.data;
  }

  void  deleteNode(V data) {
    root = deleteNode(this.root, data);
  }

  public Node deleteNode(Node root, V key) {
    if(root == null) return root;
    if((Integer)key >(Integer) root.data){ //move right
      root.rightNode = deleteNode(root.rightNode, key);
    }else if((Integer)key < (Integer)root.data){ //move left
      root.leftNode = deleteNode(root.leftNode, key);
    }else{ //oh yes, we finally found the target
      if(root.leftNode == null && root.rightNode == null){ //hmm, its a leaf node; easy peasy
        root = null;
      }else if(root.rightNode != null){ // oh, it has a right child, don't make it an orphan or is it old enough to become a parent ? lets find out
        root.data = successor(root); // my worthy successor
        root.rightNode = deleteNode(root.rightNode,(V) root.data);
      }else{ //oh it seems that I do not have a worthy successor, fallback, fallback ...
        root.data = predecessor(root);
        root.leftNode = deleteNode(root.leftNode, (V)root.data);
      }
    }
    return root;
  }




  public int getSize() {
    return this.size;
  }

  public boolean isEmpty() {
    return this.size == 0;
  }

  private void checkDataIsNull(V data) {
    if (data == null) throw new IllegalArgumentException("Data you entered is null");
  }

  private BinaryTreePractice2.Node createNew(V val, Node parent) {

    return new BinaryTreePractice2.Node(null, val, parent, null);
  }

  public void add(V data) {
    this.checkDataIsNull(data);
    Node parentNode = this.root;
    if (parentNode == null) this.root = createNew(data, null);
    else insertDirection(this.root, data);

    ++this.size;
  }

  private void insertDirection(BinaryTreePractice2.Node node, V val) {
    BinaryTreePractice2.Node leftNode = node.leftNode;
    BinaryTreePractice2.Node rightNode = node.rightNode;

    if ((Integer) val > (Integer) node.data) {
      if (rightNode == null) node.rightNode = createNew(val, node);
      else insertDirection(node.rightNode, val);
    } else {
      if (leftNode == null) node.leftNode = createNew(val, node);
      else insertDirection(node.leftNode, val);
    }
  }

  public V searchNode(V data) {
    this.checkDataIsNull(data);
    return searchVal(this.root, data) == null ? null : (V) searchVal(this.root, data).data;
  }

  private Node searchVal(Node node, V val) {
    if (node == null) return null;
    if ((Integer) val == (Integer) node.data) return node;
    else if ((Integer) val > (Integer) node.data) return searchVal(node.rightNode, val);
    else return searchVal(node.leftNode, val);
  }

  private static class Node<V> {
    private Node parent;
    private Node leftNode;
    private Node rightNode;
    private V data;

    public Node(Node leftNode, V data, Node parent, Node rightNode) {
      this.parent = parent;
      this.leftNode = leftNode;
      this.rightNode = rightNode;
      this.data = data;
    }

    public Node getParent() {
      return parent;
    }

    public void setParent(Node parent) {
      this.parent = parent;
    }

    public Node getLeftNode() {
      return leftNode;
    }

    public void setLeftNode(Node leftNode) {
      this.leftNode = leftNode;
    }

    public Node getRightNode() {
      return rightNode;
    }

    public void setRightNode(Node rightNode) {
      this.rightNode = rightNode;
    }

    public V getData() {
      return data;
    }

    public void setData(V data) {
      this.data = data;
    }
  }

  public static void main(String[] args) {
    BinaryTreePractice2<Integer> binaryTreePractice2 = new BinaryTreePractice2();
    binaryTreePractice2.add(31);
    binaryTreePractice2.add(21);
    binaryTreePractice2.add(41);
    binaryTreePractice2.add(11);
    binaryTreePractice2.add(15);
    binaryTreePractice2.add(25);
    binaryTreePractice2.add(23);
    binaryTreePractice2.add(26);

    binaryTreePractice2.deleteNode(21);
  //  System.out.println("Delete  : " + binaryTreePractice2.deleteNode(21));

  }
}
