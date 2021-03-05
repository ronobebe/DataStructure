package FairDraft.LinkedList;

import FairDraft.ListInterfaces.List;

import java.util.*;

public class LinkedListA<E> implements List<E>, Deque<E>, Cloneable {

  private int size;
  private Node head;
  private Node tail;

  public LinkedListA() {}

  @Override
  public int arrayCapacity() {
    return -1;
  }

  @Override
  public boolean trimToItsSize() {
    return false;
  }

  @Override
  public int size() {
    return this.size;
  }

  @Override
  public boolean isEmpty() {
    return this.size == 0;
  }

  @Override
  public boolean contains(Object o) {

    return false;
  }

  @Override
  public Iterator<E> iterator() {
    return null;
  }

  @Override
  public Iterator<E> descendingIterator() {
    return null;
  }

  @Override
  public Object[] toArray() {
    return new Object[0];
  }

  @Override
  public <T> T[] toArray(T[] a) {
    return null;
  }

  @Override
  public void addFirst(E e) {
    Node headNode = this.head;
    Node newNode = new Node(null, e, headNode);
    this.head = newNode;
    if (headNode == null) this.tail = newNode;
    else headNode.prev = newNode;

    ++this.size;
  }

  @Override
  public void addLast(E e) {
    Node tailNode = this.tail;
    Node newNode = new Node(this.tail, e, null);
    this.tail = newNode;
    if (tailNode == null) this.head = newNode;
    else tailNode.next = newNode;

    ++this.size;
  }

  @Override
  public boolean offerFirst(E e) {
    this.addFirst(e);
    return true;
  }

  @Override
  public boolean offerLast(E e) {
    this.addLast(e);
    return true;
  }

  @SuppressWarnings("")
  @Override
  public E removeFirst() {
    if (this.head == null) throw new IllegalArgumentException("No data available");
    Node removedNode = this.head;
    Node nextNode = removedNode.next;
    Object removedNodeData = removedNode.data;

    if (nextNode == null) this.tail = null;
    else this.head.next.prev = null;

    this.head.next = null;
    this.head.data = null;

    this.head = nextNode;
    --this.size;

    return (E) removedNodeData;
  }

  @Override
  public E removeLast() {
    if (this.tail == null) throw new IllegalArgumentException("No Data Available");
    Node removedNode = this.tail;
    Node prevNode = removedNode.prev;
    Object data = removedNode.data;

    if (prevNode == null) this.head = null;
    else this.tail.prev.next = null;

    this.tail.data = null;
    this.tail.prev = null;

    this.tail = prevNode;
    --this.size;
    return (E) data;
  }

  @Override
  public E poll() {
    if (this.head != null) return (E) removeFirst();
    return null;
  }

  @Override
  public E pollFirst() {
    if (this.head != null) return (E) removeFirst();
    return null;
  }

  @Override
  public E pollLast() {
    if (this.tail != null) return (E) removeLast();
    return null;
  }

  private void ensureFirstElement() {
    if (this.head == null) throw new IllegalArgumentException("No data available");
  }

  private void ensureLastElement() {
    if (this.tail == null) throw new IllegalArgumentException("No data available");
  }

  @Override
  public E getFirst() {
    this.ensureFirstElement();

    return (E) this.head.data;
  }

  @Override
  public E getLast() {
    this.ensureLastElement();
    return (E) this.tail.data;
  }

  @Override
  public E peek() {
    if (this.head != null) return (E) this.head.data;
    return null;
  }

  @Override
  public E peekFirst() {
    return this.peek();
  }

  @Override
  public E peekLast() {
    if (this.tail != null) return (E) this.tail.data;
    return null;
  }

  @Override
  public boolean removeFirstOccurrence(Object o) {
    return false;
  }

  @Override
  public boolean removeLastOccurrence(Object o) {
    return false;
  }

  @Override
  public boolean add(E e) {
    this.addLast(e);
    return true;
  }

  @Override
  public boolean offer(E e) {
    this.addLast(e);
    return true;
  }

  @Override
  public E remove() {
    return this.removeFirst();
  }

  @Override
  public E element() {
    return this.getFirst();
  }

  @Override
  public void push(E e) {
    this.addFirst(e);
  }

  @Override
  public E pop() {
    return this.removeFirst();
  }

  @Override
  public boolean remove(Object o) {
    Node node=this.head;
    for(int i=0; i<this.size; i++){
      if (node.data == o) {
        this.unlinkNode(node);
        return true;
        }
      else
        node=node.next;
    }

    return false;
  }

  @Override
  public boolean containsAll(Collection<?> c) {
    return false;
  }

  @Override
  public boolean addAll(Collection<? extends E> c) {
    return false;
  }

  @Override
  public boolean addAll(int index, Collection<? extends E> c) {
    return false;
  }

  @Override
  public boolean removeAll(Collection<?> c) {
    return false;
  }

  @Override
  public boolean retainAll(Collection<?> c) {
    return false;
  }

  @Override
  public void clear() {}

  private void ensureIndex(int index){
    if(index<0 && index>this.size-1)
      throw  new IllegalArgumentException("Index out of bound : "+index);

  }

  @Override
  public E get(int index) {
    this.ensureIndex(index);
    Node node=this.node(index);
    return node!=null?(E)node.data:null;
  }

  private Node node(int i) {

    int index;
    Node node;
    int halfVal=this.size>>1;
    if (i < this.size >> 1) {
      node=this.head;
      for(index=0; index<halfVal; index++)
        if(i==index)
          return node;
        else
          node=node.next;
    } else {
      node=this.tail;
      for(index=this.size-1; index>=halfVal; index--)
        if(i==index)
          return node;
        else
          node=node.prev;
    }
    return  null;
  }

  @Override
  public E set(int index, E element) {
    this.ensureIndex(index);
    Node node=this.node(index);
    Object oldData;
    if (node != null) {
       oldData = node.data;
       node.data = element;
       return (E)oldData;
    }

    return null;
  }

  @Override
  public void add(int index, E element) {
    this.ensureIndex(index);
    Node node=this.node(index);
    Node prevNode=node.prev;
    Node newNode=new Node<E>(node.prev, element,node);
    if(prevNode==null)
      this.head=newNode;

    node.prev=newNode;
    ++this.size;

  }

  @Override
  public E remove(int index) {
    this.ensureIndex(index);
    Node node=this.node(index);

    return  unlinkNode(node);
  }

  E unlinkNode(Node node){
    Object removeData=node.data;
    Node prev=node.prev;
    Node next=node.next;



    if (prev == null) {

      next.prev = null;
      this.head = node.next;
    }
    else
    {
      prev.next=node.next;
      next.prev=null;
    }

    if(next==null)
    {
      prev.next=null;
      this.tail=prev;

    }
    else{
      next.prev=next;
      node.next=null;
    }
    --this.size;




    return (E)removeData;
  }

  @Override
  public int indexOf(Object o)
  {
    this.ensureFirstElement();
    int index;
    Node node=this.head;
    for (index = 0; index < this.size; index++) {
      if (node.data == o) return index;
      else node = node.next;
       }

    return -1;
  }

  @Override
  public int lastIndexOf(Object o) {
    this.ensureLastElement();
    int index;
    Node node=this.tail;
    for (index = this.size-1; index <= 0; index--) {
      if (node.data == o) return index;
      else node = node.prev;
    }
    return -1;
  }

  @Override
  public ListIterator<E> listIterator() {
    return null;
  }

  @Override
  public ListIterator<E> listIterator(int index) {
    return null;
  }

  @Override
  public java.util.List<E> subList(int fromIndex, int toIndex) {
    return null;
  }

  private static class Node<E> {

    Node<E> prev;
    Node<E> next;
    E data;

    public Node(Node prev, E data, Node next) {
      this.prev = prev;
      this.next = next;
      this.data = data;
    }


  }

  public static void main(String[] args) {


    LinkedListA<String> linkedListA=new LinkedListA();
    linkedListA.add("1");
    linkedListA.add("2");
    linkedListA.add("3");
    //linkedListA.set(0, "4");
   // linkedListA.add(2, "4");
   // linkedListA.addFirst("4");
   // linkedListA.addLast("4");
    //linkedListA.removeLast();
    linkedListA.remove(0);
    for(int i=0; i<linkedListA.size(); i++)
      System.out.println("Array element "+i+" is  : "+linkedListA.get(i));


    System.out.println("Array Size is : "+linkedListA.size());
    System.out.println("Array First Element is : "+linkedListA.getFirst());
    System.out.println("Array Last Element is : "+linkedListA.getLast());

  }
}
