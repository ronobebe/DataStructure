package Algorithms.FairDraft.Trees;

public class BinarySearchTreeMap {

  private Node root;
  private int size;
  /**
   * set and map both are same in concepts the only difference is set : Just add data's from the
   * user. Duplicates are allowed Map : Add values and keys : Duplicates not allowed (search, get,
   * set everything based on key only values are like hidden state ) Binary search tree is not a
   * self balancing tree. So no height and balancing factors needed. Simple tree - can add data in
   * any order (not a organised tree) BST - data< root(in left) data > root (in right) AVL - same as
   * BST but it's self balancing on each insertion and deletion takes place.
   */
  public int getSize() {
    return this.size;
  }

  public boolean isEmpty() {
    return this.size == 0;
  }

  public boolean add(int key, String data) {
    if (addData(key, data)) {
      ++this.size;
      return true;
    }

    return false;
  }

  public boolean insert(int key, String data) {
    return this.add(key, data);
  }

  private boolean addData(int key, String value) {
    Node head = this.root;
    if (head == null) {
      this.root = new Node(key, value, null);
      return true;
    } else {

      while (true) {
        if (key < head.key) {
          if (head.left == null) {
            head.left = new Node(key, value, head);
            return true;
          } else head = head.left;
        } else {
          if (key == head.key) return false;
          else {
            if (head.right == null) {
              head.right = new Node(key, value, head);
              return true;
            } else head = head.right;
          }
        }
      }
    }
  }

  public String get(int key) {

    if (this.root == null) return null;
    Node node = nodeTraversal(this.root, key);

    return node == null ? null : node.value;
  }

  Node nodeTraversal(Node node, int key) {
    if(node==null)
      return null;

    if (node.key == key) return node;

    return node.key > key ? nodeTraversal(node.left, key) : nodeTraversal(node.right, key);
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

  public void delete(int key)
  {
   Node node=nodeTraversal(this.root, key);

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

  public static class Node {
    Node left;
    int key;
    String value;
    Node parent;
    Node right;

    /** insert key and values --------------> MAP */
    public Node(int key, String value, Node parent) {
      this.key = key;
      this.value = value;
      this.parent = parent;
    }
    /** insert only values --------------------------> SET */
    public Node(int key, Node parent) {
      this.key = key;
      this.parent = parent;
    }
  }

  public  void display()
  {
    display(this.root);
  }

  private void display (Node node) {
    String str="";
    if(node.left!=null)
      str+=(node.left.key+" - "+node.left.value)+"=>";
    else
      str+="END=>";
    str+=(node.key+" - "+node.value)+"";
    if(node.right!=null)
      str+="<="+(node.right.key+" - "+node.right.value);
    else
      str+="<=END";
    System.out.println(str);
    if(node.left!=null)
      display(node.left);
    if(node.right!=null)
      display(node.right);
  }

  public static void main(String[] args) {
    BinarySearchTreeMap binarySearchTreeMap = new BinarySearchTreeMap();
    System.out.println("Inserting values 1 to 10");
    for (int i = 1; i < 10; i++) binarySearchTreeMap.add(i, "Data is : " + i);

    // return false bcz key 7 is already present
    binarySearchTreeMap.add(7, "Data is : " + 7);

    System.out.print("Size is : " + binarySearchTreeMap.getSize());

    System.out.print("\n Get data is : " + binarySearchTreeMap.get(3)+"\n");
    binarySearchTreeMap.delete(5);

    binarySearchTreeMap.display();

    /*
    * END=>1 - Data is : 1<=2 - Data is : 2
END=>2 - Data is : 2<=3 - Data is : 3
END=>3 - Data is : 3<=4 - Data is : 4
END=>4 - Data is : 4<=5 - Data is : 5
END=>5 - Data is : 5<=6 - Data is : 6
END=>6 - Data is : 6<=7 - Data is : 7
END=>7 - Data is : 7<=8 - Data is : 8
END=>8 - Data is : 8<=9 - Data is : 9
END=>9 - Data is : 9<=END

    * */
  }
}
