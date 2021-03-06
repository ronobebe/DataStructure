package FairDraft.Hashing;

import java.util.Arrays;

public class HashingChainingA<K, V> {

  private int size;
  private HashLinkedList[] arrayData;
  private final float defaultLoadFactor = 0.75f;
  private final int defaultSize = 10;

  public HashingChainingA() {
    arrayData = new HashLinkedList[defaultSize];
    this.explicitInitialization(0, this.arrayData.length);
  }

  private void explicitInitialization(int start, int end) {
    for (int i = start; i < end; i++) {
      this.arrayData[i] = new HashLinkedList();
    }
  }

  public int getSize() {
    return this.size;
  }

  public int arrayCapacity() {
    return this.arrayData.length;
  }

  private int createHash(K key) {
    Integer i = (Integer) key;
    return i % 3;
  }

  private int threshold() {
    float threshold = this.arrayData.length * defaultLoadFactor;
    return (int) threshold;
  }

  private void checkLoadFactor(int siz) {
    // get size + 1
    int threshold = this.threshold();
    if (siz >= threshold) growArray(siz);
  }

  private void growArray(int newSize) {
    int oldSiz = this.arrayData.length;
    int calculateSize = oldSiz + oldSiz >> 1;

    this.arrayData = Arrays.copyOf(this.arrayData, calculateSize);
    this.explicitInitialization(oldSiz, calculateSize);
  }

  public boolean add(K key, V val) {
    this.checkLoadFactor(this.size + 1);
    int hash = createHash(key);
    this.arrayData[hash].add(hash, key, val);
    ++this.size;
    return true;
  }

  public V get(K key) {
    HashLinkedList hashLinkedList = this.arrayData[this.createHash(key)];
    if (hashLinkedList.getChainCount() != 0) return (V) hashLinkedList.get(key);
    return null;
  }

  public V remove(K key) {
    HashLinkedList hashLinkedList = this.arrayData[this.createHash(key)];
    if (hashLinkedList.getChainCount() != 0) {
      --this.size;
      return (V) hashLinkedList.remove(key);
    }
    return null;
  }

  public void printAllElements() {

    for (int i = 0; i < this.size; i++) {

      System.out.println("Value at array " + i + " is : " + this.arrayData[i].toString());
    }
  }

  public static class HashLinkedList<K, V> {

    private Node<K, V> headNode;
    private int chainCount;

    public int getChainCount() {
      return this.chainCount;
    }

    public void add(int hash, K key, V value) {
      Node head = this.headNode;
      Node node;
      node = new Node<K, V>(hash, key, value, head);
      this.headNode = node;
      ++chainCount;
    }

    public V get(K key) {

      Node node = this.headNode;
      while (node != null) {
        if (node.key == key) return (V) node.value;
        else node = node.next;
      }

      return null;
    }

    public V remove(K key) {
      Node node = this.headNode;
      Node prev = this.headNode;
      for (int i = 0; i < this.getChainCount(); i++) {

        if (i == 0 && node.key == key) {
          removeFirst();
        } else if (node.key == key) {
          prev.next = node.next;
          --this.chainCount;
          return (V) node.value;
        }

        prev = node;
        node = node.next;
      }
      return null;
    }

    public V removeFirst() {
      V removeData = (V) this.headNode.value;
      Node next = this.headNode.next;
      this.headNode = next;
      --this.chainCount;
      return removeData;
    }

    @Override
    public String toString() {

      StringBuilder sb = new StringBuilder();
      Node node = this.headNode;
      while (node != null) {
        sb.append("->" + node.key + " - " + node.value);
        node = node.next;
      }

      return "HashLinkedList{ " + getChainCount() + " }" + sb.toString();
    }
  }

  public static class Node<K, V> {
    int hash;
    K key;
    V value;
    Node next;

    public Node(int hash, K key, V value, Node next) {
      this.hash = hash;
      this.key = key;
      this.value = value;
      this.next = next;
    }
  }

  public static void main(String[] args) {
    //
    HashingChainingA<Integer, String> hashingChainingA = new HashingChainingA();
    hashingChainingA.add(1, "Hi");
    hashingChainingA.add(2, "Hellow");
    hashingChainingA.add(0, "Mr X");

    hashingChainingA.add(11, "Vanakkam");
    hashingChainingA.add(8, "Namasthe");
    hashingChainingA.remove(8);
    hashingChainingA.remove(11);
    // hashingChainingA.remove(2);

    hashingChainingA.printAllElements();

    System.out.println("Array Size is : " + hashingChainingA.getSize());
    System.out.println("Array capacity is : " + hashingChainingA.arrayCapacity());
    System.out.println("Array element is : " + hashingChainingA.get(2));
  }
}
