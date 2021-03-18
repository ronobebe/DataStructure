package Algorithms.FairDraft.Trees;

public class AVLTree {

  private int size;
  private Node root;

  public int getSize() {
    return this.size;
  }

  public  boolean isEmpty()
  {
    return this.size==0;
  }

  public  boolean add(int data){
    return this.insert(data);
  }

  public boolean insert(int data) {

    Node head = this.root;
    if (head == null) this.root = new Node(data, null);
    else {

      while (head != null) {
        if (head.data > data) {
          if (head.left == null) {
            head.left = new Node(data, head);
            break;
          } else head = head.left;
          }
        else{
          if (head.right == null) {
          head.right = new Node(data, head);
          break;
        } else head = head.right;
      }
        }
      // reBalance
      reBalance(head);
    }

    ++this.size;
    return true;
  }
  private void setHeight(Node node)
  {
    if(node!=null)
    node.height=Math.max(height(node.right),height(node.left))+1;
  }


  private int height(Node node)
  {
    if(node==null)
      return -1;
    return node.height;
  }

  private void setBalance(Node... node)
  {
    for (Node n : node) {
      setHeight(n);
      n.balance = height(n.right) - height(n.left);
    }
  }
  public void printBalance() {
    printBalance(root);
  }

  private void printBalance(Node n) {
    if (n != null) {
      printBalance(n.left);
      System.out.printf("%s ", n.balance);
      printBalance(n.right);
    }
  }

  private void reBalance(Node n)
  {
    setBalance(n);

    if (n.balance == -2) {
      if (height(n.left.left) >= height(n.left.right)) n = rightRotation(n);
      else n = rotateLeftThenRight(n);

    } else if (n.balance == 2) {
      if (height(n.right.right) >= height(n.right.left)) n = rotateLeft(n);
      else n = rotateRightThenLeft(n);
    }

    if (n.parent != null) {
      reBalance(n.parent);
    } else {
      root = n;
    }


  }


  private Node rightRotation(Node node)
  {

    /*
       *
       * y                               x
       / \     Right Rotation          /  \
      x   T3   - - - - - - - >        T1   y
     / \       < - - - - - - -            / \
    T1  T2     Left Rotation            T2  T3
    *
    *

     x
    / \
   y   T3         (1)<==
  / \
  T1  T2

     x
    / \
   y   T1          (2)<==
  / \
  T3  T2


     x
    / \
   y   T1         (3)<==
  / \
  T2  T3


     x
   /  \           (4)<==
  T1   y
      / \
    T2  T3
    *
    * step 1 break them into two separate heads


  x
  \
   T3

  y
 / \
T1   T2
*
* step 2 interchange the right nodes

       * */

    Node newHead=node.left;
    newHead.parent=node.parent;

    node.left=newHead.right;
    if(node.left!=null)
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

    setBalance(node,newHead);

    return newHead;
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
    return rightRotation(n);
  }

  private Node rotateRightThenLeft(Node n) {
    n.right = rightRotation(n.right);
    return rotateLeft(n);
  }

public Node search(int data)
{
  return traverseNode(data);
}

  public static class Node {
    Node left;
    Node parent;
    int data;
    int height;
    int balance;
    Node right;

    public Node(int data, Node parent) {
      this.data = data;
      this.parent = parent;
    }

    public Node getLeft() {
      return left;
    }

    public void setLeft(Node left) {
      this.left = left;
    }

    public Node getParent() {
      return parent;
    }

    public void setParent(Node parent) {
      this.parent = parent;
    }

    public int getData() {
      return data;
    }

    public void setData(int data) {
      this.data = data;
    }

    public int getHeight() {
      return height;
    }

    public void setHeight(int height) {
      this.height = height;
    }

    public Node getRight() {
      return right;
    }

    public void setRight(Node right) {
      this.right = right;
    }
  }

  public  void display()
  {
    display(this.root);
  }

  private void display (Node node) {
    String str="";
    if(node.left!=null)
      str+=node.left.data+"=>";
    else
      str+="END=>";
    str+=node.data+"";
    if(node.right!=null)
      str+="<="+node.right.data;
    else
      str+="<=END";
    System.out.println(str);
    if(node.left!=null)
      display(node.left);
    if(node.right!=null)
      display(node.right);
  }
  /**
   * Condition 1 : right and left node null;
   * condition 2 : right or left null
   * Condition 3: right and left not equal to null
   * */

  private void delete(Node node)
  {
    if(node.left==null && node.right==null)
    {
      if(node.parent==null)
        this.root=null;
      else
      {
       if(node==node.parent.left)
       node.parent.left=null;
       else
         node.parent.right=null;

      }

      reBalance(node.parent);
      node=null;
      return;
    }
    else if(node.left!=null)
    {
      Node newHead=node.left;
      while (newHead.right!=null)
        newHead=newHead.right;

      node.data=newHead.data;
      delete(newHead);
    }
else{

  Node newHead=node.right;
  while (node.left!=null)
    newHead=node.left;
  node.data=newHead.data;
  delete(newHead);
    }

  }

  private void delete(int key)
  {
    Node node=this.traverseNode(key);
    if(node!=null) delete(node);
  }
  Node traverseNode(int data)
  {
    Node head=this.root;
    if(head==null)
      return null;
    else
    {

      while (head!=null)
      {
        if(head.data==data)
          return head;

        head= data>=head.data? head.right: head.left;

      }

    }
    return head.data==data?head:null;
  }

  public static void main(String[] args) {
    AVLTree avlTree=new AVLTree();

    System.out.println("Inserting values 1 to 10");
    for (int i = 1; i < 10; i++) avlTree.insert(i);

    System.out.print("Printing balance: ");
    avlTree.delete(6);
    avlTree.printBalance();
    avlTree.display();
    avlTree.search(7);

    // 0 0 0 1 0 1 0 0 0

    /*
     2=>4<=6
    * 1=>2<=3
END=>1<=END
END=>3<=END
5=>6<=8
END=>5<=END
7=>8<=9
END=>7<=END
END=>9<=END

    * */
  }
}
