package RoughDraft.Trees;

public class BinaryTreePractice1<E> {

  private Node rootNode;
  private int size;

  public BinaryTreePractice1() {

    // this.rootNode=new Node(null,null,null, null);
  }

  public  Node inOrderSuccessor(int val){
      Node node=null;
      if(this.rootNode!=null)
          node=searchVal(this.rootNode,val);
      if(node==null)
          return null;
      else if(node.rightNode!=null)
      {
          Node tempNode=node.rightNode;

          while (tempNode!=null){
              if(val<tempNode.val  ){
                  if(tempNode.leftNode==null)
                  return tempNode;
                  else
                     tempNode=tempNode.leftNode;
              }
              else
                  tempNode=tempNode.rightNode;
      }
      }
      // if right node equals null traverse through the ancestors
      else{
Node tempNode=node.parentNode;
while (tempNode!=null){
    if(val>tempNode.val){

    }
}

      }



      return null;
  }

  public boolean addValue(int val) {

    if (rootNode == null) this.rootNode = createNew(val, null);
    else checkDirection(this.rootNode, val);

    return true;
  }

  public int getSize() {
    return this.size;
  }

  public boolean isEmpty() {
    return this.size == 0;
  }

  private Node createNew(int val, Node parent) {

    return new Node(null, parent, null, val);
  }

  private void checkDirection(Node node, int val) {
    Node leftNode = node.leftNode;
    Node rightNode = node.rightNode;

    if (val > node.val) {
      if (rightNode == null) node.rightNode = createNew(val, node);
      else checkDirection(node.rightNode, val);
    } else {
      if (leftNode == null) node.leftNode = createNew(val, node);
      else checkDirection(node.leftNode, val);
    }
  }


  private boolean checkRootNode() {
    if (rootNode == null) return false;
    else return true;
  }

  public int searchNode(int i) {
    if (this.rootNode != null)
      return searchVal(this.rootNode, i) == null ? -1 : searchVal(this.rootNode, i).val;

    return -1;
  }

  private Node searchVal(Node node, int val) {
    if (node == null) return null;
    if (val == node.val) return node;
    else if (val > node.val) return searchVal(node.rightNode, val);
    else return searchVal(node.leftNode, val);
  }

  private static class Node<E> {
    Node leftNode;
    Node parentNode;
    Node rightNode;
    int val;

    public Node(Node leftNode, Node parentNode, Node rightNode, int val) {
      this.leftNode = leftNode;
      this.parentNode = parentNode;
      this.rightNode = rightNode;
      this.val = val;
    }

    public Node getLeftNode() {
      return leftNode;
    }

    public void setLeftNode(Node leftNode) {
      this.leftNode = leftNode;
    }

    public Node getParentNode() {
      return parentNode;
    }

    public void setParentNode(Node parentNode) {
      this.parentNode = parentNode;
    }

    public Node getRightNode() {
      return rightNode;
    }

    public void setRightNode(Node rightNode) {
      this.rightNode = rightNode;
    }

    public int getVal() {
      return val;
    }

    public void setVal(int val) {
      this.val = val;
    }
  }

  public enum ApplyDirection {
    RIGHT,
    lEFT;
  }

  public static void main(String[] args) {
    //
    /*int[] array = {
      20,8, 22, 4,12, 10, 14
    };

    BinaryTreePractice1 binaryTreePractice1 = new BinaryTreePractice1();
    for (int i : array) binaryTreePractice1.addValue(i);
    System.out.println("Value found is " + binaryTreePractice1.searchNode(18));
    binaryTreePractice1.addValue(2);
    binaryTreePractice1.inOrderSuccessor(8);*/



  }
}
