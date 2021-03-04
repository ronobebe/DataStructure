package RoughDraft.Hashing;

public class HashMapPractice {

  private int size;
  LinkedList[] arrData;
  private int insertCount;

  public HashMapPractice(int size) {
    if (size < 0) throw new IllegalArgumentException();
    else {
      arrData = new LinkedList[size];

        for (int i = 0; i < size; i++) {
            arrData[i] = new LinkedList();
            // Java requires explicit initialisaton of each object
        }
        this.size = size;
    }
  }

  public int getSize() {

      return this.insertCount;
  }

  private void checkThreshold(){

      //if(dummyThreshold>0.75)
          System.out.println("Threshold limit is : "+(this.insertCount/this.size));

  }

    private int hash(int key) {
        int val = key % size;
        return val;
    }

  public boolean addData(int i) {
    ++this.insertCount;
      checkThreshold();
    return arrData[hash(i)].add(i);
  }

  public  int deleteData(int key){
      LinkedList ln=arrData[hash(key)];

      return  ln.deleteNode(key);
  }

  public  int searchData(int key){

      return arrData[hash(key)].searchData(key);
  }

    public void displayHashtable() {
        for (int i = 0; i < size; i++) {
            System.out.printf("Bucket %d :", i);
            System.out.println(arrData[i].display());
        }
    }


  public static class LinkedList {

    Node headNode;

    public boolean isEmpty() {
      return headNode == null;
    }



    public boolean add(int i) {
      Node newNode = new Node(i, null);
      if (headNode == null) headNode = newNode;
      else {
        Node node = returnNode(headNode);
        node.nextNode = newNode;
      }

      return true;
    }

    public Node returnNode(Node node) {
      if (node.nextNode == null) return node;
      else return returnNode(node.nextNode);
    }


    public  int deleteNode( int key){
        Node node=this.headNode;
        if(isEmpty())
            return  -1;
        return   deleteNode(key,node);
    }

    private   int deleteNode(int key, Node node){
        if(node==null)
            return -1;
        int data=node.getData();
        if(data==key)
        {
            node.setData(-1);
            return data;
        }
        return deleteNode(key, node.nextNode);
    }

    public int searchData(int key){
        Node node=this.headNode;
        if(isEmpty())
            return  -1;

        return searchData(key,node);
    }

      public int searchData(int key, Node node){
      if (node.data == -1) {
          System.out.println("Search Data is : " + node.data);

          return -1;}
      else if (node.data == key) {
        System.out.println("Search Data is : " + node.data);
        return node.data;
            }
        else
           return searchData(key,node.nextNode);
        }




      public String display() {
          return display(headNode);
      }

      private String display(Node n) {
          if (n == null) {
              return "null";
          } else {
              return n.getData() + "->" + display(n.nextNode);
          }
      }

  }

  public static class Node {
    Node nextNode;
    int data;

    public Node(int data, Node nextNode) {
      this.nextNode = nextNode;
      this.data = data;
    }

    public Node getNextNode() {
      return nextNode;
    }

    public int getData() {
      return data;
    }

    public void setData(int data) {
      this.data = data;
    }
  }

  public static void main(String[] args) {
    //

    HashMapPractice hashMapPractice = new HashMapPractice(10);
       hashMapPractice.addData(7);
       hashMapPractice.addData(21);
       hashMapPractice.addData(31);
       hashMapPractice.addData(11);
       hashMapPractice.addData(41);
       hashMapPractice.deleteData(11);
       hashMapPractice.searchData(41);
       hashMapPractice.displayHashtable();
  }
}
