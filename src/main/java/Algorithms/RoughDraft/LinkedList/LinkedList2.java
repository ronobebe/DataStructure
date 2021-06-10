package Algorithms.RoughDraft.LinkedList;

public class LinkedList2 {

  private Node head;
  private Node tail;
  int size;

  public LinkedList2() {}

  public int size() {
    return this.size;
  }

  public boolean isEmpty() {
    return this.size == 0;
  }

  public boolean addData(Object data) {
    this.linkLast(data);
    return true;
  }

  private void linkLast(Object data) {
    Node first = this.tail;
    Node newNode = new Node(first, data, null);
    this.tail = newNode;
    if (first == null) {
      this.head = newNode;
    } else first.right = newNode;

    ++this.size;
  }

  private void linkFirst(Object data) {
    Node first = this.head;
    Node newNode = new Node(null, data, first);
    this.head = newNode;
    if (first != null) first.left = newNode;
    else this.tail = newNode;

    ++this.size;
  }

  private Object unlinkFirst() {
    this.checkDataAvailable();
    Node first = this.head;
    Node right = first.right;
    if (right != null) {
      right.left = null;
    } else {
      this.tail = null;
    }

    first.right = null;
    this.head = right;
    --this.size;
    return first.data;
  }

  private Object unlinkLast() {

    this.checkDataAvailable();
    Node last = this.tail;
    Node left = last.left;
    if (left == null) this.head = null;
    else left.right = null;

    last.left = null;
    this.tail = left;
    --this.size;

    return last.data;
  }

  private void checkDataAvailable() {
    if (this.size <= 0) throw new IllegalArgumentException("OutOfBoundException");
  }

  private Object deque() {
    return this.unlinkFirst();
  }

  private boolean enque(Object data) {
    this.linkLast(data);
    return true;
  }

  private Object removeData(Object data) {

    Node temp = indexOf(data);
    if (temp != null) unlinkNode(temp);
    return temp != null ? temp.data : null;
  }

  private void unlinkNode(Node mainNode) {
    Node left = mainNode.left;
    Node right = mainNode.right;
    if (left == null) unlinkFirst();
    else if (right == null) unlinkLast();
    else {
      left.right = right;
      right.left = left;
      mainNode.left = null;
      mainNode.right = null;
      mainNode.data = null;
    }
  }

  private Object set(int pos, Object data) {
    this.verifyPosition(pos);
    Node node = this.getNode(pos);
    Object dat = null;
    if (node != null) {
      dat = node.data;
      node.data = data;
    }
    return dat;
  }

  private Node getNode(int pos) {
    int pivot = this.size / 2;
    Node node;
    if (pos < pivot) {
      node = this.head;
      for (int i = 0; i < pos; i++) node = node.right;

      return node;

    } else {
      node = this.tail;
      for (int i = this.size - 1; i > pos; i--) {
        node = node.left;
      }
      return node;
    }
  }

  private Node indexOf(Object data) {
    Node next = this.head;
    while (next != null) {
      if (next.data == data) return next;
      next = next.right;
    }

    return null;
  }

  private void verifyPosition(int pos) {
    if (pos < 0 || pos >= this.size)
      throw new IllegalArgumentException("Index Out of Bound Exception");
  }

  private class Node {
    Node left;
    Node right;
    Object data;

    public Node(Node left, Object data, Node right) {
      this.left = left;
      this.right = right;
      this.data = data;
    }
  }

  public static void main(String[] args) {
    LinkedList2 linkedList2 = new LinkedList2();
    linkedList2.addData(2);
    linkedList2.addData(3);
    linkedList2.addData(4);
    linkedList2.removeData(31);
  }
}
