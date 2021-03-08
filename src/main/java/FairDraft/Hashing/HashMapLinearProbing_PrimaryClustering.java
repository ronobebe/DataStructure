package FairDraft.Hashing;

import java.util.Arrays;

public class HashMapLinearProbing_PrimaryClustering<K, V> {

  private int size;
   Node[] arrData;
  private final int Default_Array_Size = 3;
  final int Default_Deleted_Number = Integer.MAX_VALUE;

  public HashMapLinearProbing_PrimaryClustering() {
    arrData = new Node[Default_Array_Size];
  }

  public int getSize() {
    return this.size;
  }

  public int capacity() {
    return this.arrData.length;
  }

  public  int hash(K key) {
    Integer i = (Integer) key;
    return i % 4;
  }

  public boolean add(K key, V value) {
    this.verifyCapacity(this.size + 1);
    Node node = new Node(key, value);
    int pos = checkForLinearProbing(key);
    if (pos == -1) {
      int arrLength=this.arrData.length;
      growArray(this.size + 1);
      pos=arrLength;
        }
    this.arrData[pos]=node;
    ++this.size;

    return true;
  }

  public  V remove(K key){
    Node node=this.getNode(key);
    if(node!=null)
    {
      node.key=this.Default_Deleted_Number;
      V value=(V)node.value;
      node.value=null;
      --this.size;
      return value;
    }
    return (V)null;
  }


  public  V search(K key)
  {
    Node node=this.getNode(key);
    if(node!=null)
      return (V)node.value;
    return null;
  }

  public  Node getNode(K key)
  {
    int dummy=this.hash(key);
    while(dummy<this.capacity())
    {
      if(this.arrData[dummy]==null)
        return null;

      if(this.arrData[dummy].key==key)
        return this.arrData[dummy];
      else
        ++dummy;
    }
    return null;

  }

  public V setData(K key, V value){
    Node node=this.getNode(key);
    if (node != null) {
      V val = (V) node.value;
      node.value=value;
      return val;
      }


    return null;
  }




  public int checkForLinearProbing(K key) {
    int dummy = this.hash(key);
    while (dummy<this.arrData.length ){
    if ( this.arrData[dummy] == null || (Integer)this.arrData[dummy].key==this.Default_Deleted_Number)
      return dummy;
    else
      ++dummy;
    }
    return -1;
  }

  private void verifyCapacity(int siz) {
    if (siz > arrData.length) growArray(siz);
  }

  public void growArray(int newSize) {

    int arraySize = this.arrData.length;
    int calculatedSize = arraySize << 1;
    this.arrData = Arrays.copyOf(this.arrData, calculatedSize);
  }

  public void printAllElements() {

    for (int i = 0; i < this.arrData.length; i++) {
      Node node=this.arrData[i];
      if(node!=null)
      System.out.println("Value at array " + i + " is : " + this.arrData[i].getKey()+"->"+this.arrData[i].getValue());
      else
        System.out.println("Value at array "+i+" is : null");
    }
  }



  public final static class Node<K, V> {
    private K key;
    private V value;

    public Node(K key, V value) {
      this.key = key;
      this.value = value;
    }


    public K getKey() {
      return key;
    }

    public V getValue() {
      return value;
    }
  }

  public static void main(String[] args) {
    HashMapLinearProbing_PrimaryClustering hashMapLinearProbing_primaryClustering=new HashMapLinearProbing_PrimaryClustering();
    hashMapLinearProbing_primaryClustering.add(1,"HI");
    hashMapLinearProbing_primaryClustering.add(11,"Hellow");
    hashMapLinearProbing_primaryClustering.add(8,"Mr X");
    hashMapLinearProbing_primaryClustering.add(15,"Mr y");
    hashMapLinearProbing_primaryClustering.add(19,"Mr z");
    hashMapLinearProbing_primaryClustering.add(23,"Mr A");

    hashMapLinearProbing_primaryClustering.remove(23);

    hashMapLinearProbing_primaryClustering.add(23,"Success");
    hashMapLinearProbing_primaryClustering.setData(23,"Success123");
    System.out.println("Search value is : "+ hashMapLinearProbing_primaryClustering.search(23));
    System.out.println("Size is : "+ hashMapLinearProbing_primaryClustering.getSize());
    System.out.println("Capacity is : "+ hashMapLinearProbing_primaryClustering.capacity());


    hashMapLinearProbing_primaryClustering.printAllElements();

  }
}
