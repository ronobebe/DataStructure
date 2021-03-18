package Algorithms.FairDraft.Trees;

public class AVLTreeMap {

  Node root;
  int size;

  public int getSize() {
    return this.size;
  }

  public boolean isEmpty() {
    return this.size == 0;
  }

  public boolean add(int key, String data) {
    if (this.addData(this.root, key, data)) {
      ++this.size;
      return true;
    }
    return false;
  }

  public boolean addData(Node node, int key, String value) {
    Node head = node;
    if (this.root == null) {
      this.root = new Node(key, value, null);
      return true;
    }
    else if (head.key > key)
      if (head.left == null)
      {
        head.left = new Node(key, value, node);
        reBalance(head.left);
        return true;
  }
      else return addData(node.left, key, value);
    else if (head.key < key)
      if (head.right == null) {
        head.right = new Node(key, value, node);
        reBalance(head.right);
        return true;
        }
      else
        return addData(node.right,key,value);

    return false;
  }
  
  
  private void reBalance(Node n)
  {
    setBalance(n);



    if (n.balance == -2) {
      if (getHeight(n.left.left) >= getHeight(n.left.right)) n = rotateRight(n);
      else n = rotateLeftThenRight(n);

    } else if (n.balance == 2) {
      if (getHeight(n.right.right) >= getHeight(n.right.left)) n = rotateLeft(n);
      else n = rotateRightThenLeft(n);
    }

    if (n.parent != null) {
      reBalance(n.parent);
    } else {
      root = n;
    }



  }
  
  private  void setBalance(Node... node)
  {
    for (Node n:node){
    reHeight(n);
    n.balance= (getHeight(n.right)-getHeight(n.left));
            }
  }
  
  private void reHeight(Node node)
  {
    if(node!=null)
    node.height=Math.max(getHeight(node.right),getHeight(node.left))+1;
    
  }

  
  private int getHeight(Node node)
  {
    if(node==null)
      return -1;
    return node.height;
  }
  
  
  private Node rotateRight(Node node)
  {
    Node newHead=node.left;
    newHead.parent=node.parent;
    if(node.left!=null)
      node.left=newHead.right;
      node.left.parent=node;
      
      newHead.right=node;
      node.parent=newHead;
      
      if(newHead.parent!=null)
      {
        if (newHead.parent.right == node) {
          newHead.parent.right = newHead;
        } else {
          newHead.parent.left = newHead;
        }
      }
      
    return  newHead;
  }

  private Node rotateLeft(Node node)
  {
    Node newHead=node.right;
    newHead.parent=node.parent;
    node.right=newHead.left;

    if(node.right!=null)
      node.right.parent=node;

    newHead.left=node;
    node.parent=newHead;

    if(newHead.parent!=null)
    {
      if (newHead.parent.right == node) {
        newHead.parent.right = newHead;
      } else {
        newHead.parent.left = newHead;
      }

    }
    setBalance(node,newHead);
    return newHead;
  }

  private Node rotateLeftThenRight(Node n) {
    n.left = rotateLeft(n.left);
    return rotateRight(n);
  }

  private Node rotateRightThenLeft(Node n) {
    n.right = rotateRight(n.right);
    return rotateLeft(n);
  }

  public String search(int data)
  {

    return traverseNode(data).value;
  }
  Node traverseNode(int key)
  {
    Node head=this.root;
    if(head==null)
      return null;
    else
    {

      while (head!=null)
      {
        if(head.key==key)
          return head;

        head= key>=head.key? head.right: head.left;

      }

    }
    return head.key==key?head:null;
  }



  public void display() {
    display(this.root);
  }

  private void display(Node node) {
    String str = "";
    if (node.left != null) str += node.left.key + "=>";
    else str += "END=>";
    str += node.key + "";
    if (node.right != null) str += "<=" + node.right.key;
    else str += "<=END";
    System.out.println(str);
    if (node.left != null) display(node.left);
    if (node.right != null) display(node.right);
  }

  public void delete(int key)
  {
    Node node=traverseNode(key);

    if(node!=null)
      this.deleteData(node);
    else
      return;
  }


  private  void deleteData(Node node)
  {
    if(node.left==null && node.right==null)
    {
      if(node.parent==null)
        this.root=null;
      else
      {
        if (node.parent.left == node)
          node.parent.left = null;

        else
          node.parent.right=null;
          reBalance(node);
          node=null;

        return;

      }
    } else if (node.left != null) {
      Node temp = preceder(node);
      node.key=temp.key;
      node.value=temp.value;
      deleteData(temp);
    }
    else
    {
      Node temp=successor(node);
      node.key=temp.key;
      node.value=temp.value;
      deleteData(temp);
    }
  }


  private Node successor(Node node)
  {
    Node root=node.right;
    while(root.left!=null)
      root=root.left;

    return root;

  }

  private Node preceder(Node node)
  {
    Node root=node.left;
    while(root.right!=null)
      root=root.right;

    return root;

  }

  private static class Node {

    Node left;
    int height;
    int balance;
    int key;
    String value;
    Node parent;
    Node right;

    public Node(int key, String value, Node parent) {
      this.key = key;
      this.value = value;
      this.parent = parent;
    }
  }

  public static void main(String[] args) {
    //
    AVLTreeMap avlTree = new AVLTreeMap();

    System.out.println("Inserting values 1 to 10");
    for (int i = 1; i < 10; i++) avlTree.add(i, "Data is : " + i);
    avlTree.delete(4);
    avlTree.display();
    System.out.println("Size is : " + avlTree.getSize());
    System.out.println("Get Data is : " + avlTree.search(3));


  }
}
