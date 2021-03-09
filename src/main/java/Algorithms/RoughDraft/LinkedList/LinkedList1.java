package Algorithms.RoughDraft.LinkedList;

import java.io.Serializable;
import java.util.AbstractSequentialList;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;

public class LinkedList1<E> extends AbstractSequentialList<E> implements List<E>, Deque<E>, Cloneable, Serializable {


  transient int size;
  transient Node<E> first;
  transient Node<E> last;

  public LinkedList1() {

    this.size = 0;
  }

  @Override
  public ListIterator<E> listIterator(int i) {
    return null;
  }

  @Override
  public void addFirst(E e) {
    this.linkFirst(e);
  }

  private void linkFirst(E e) {
    Node head = this.first;
    Node newNode = new Node<E>((Node) null, e, head);
    // assign every single node to   first node
    this.first = newNode;

    // check if the newly created node is the very first node we created
    if (head == null)
      // assign the newly created node to last node so we can assume there is only one node
      // available in the LL
      this.last = newNode;
    else
      // if we already have nodes in the linked list then assign this newly created node to previous
      // node of the very last noce
      head.prev = newNode;

    ++this.size;
  }

  private void linkLast(E e) {
    Node head = this.last;
    Node tail = new Node<E>(head, e, (Node) null);
    // assign every single node to   first node
    this.last = tail;

    // check if the newly created node is the very first node we created
    if (head == null)
      // assign the newly created node to last node so we can assume there is only one node
      // available in the LL
      this.first = tail;
    else
      // if we already have nodes in the linked list then assign this newly created node to previous
      // node of the very last noce
      head.next = tail;

    ++this.size;
  }

  @Override
  public boolean add(E e) {
    linkLast(e);
    return true;
  }

  @Override
  public void addLast(E e) {
    this.linkLast(e);
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

  @Override
  public E removeFirst() {
    return this.unLinkFirst();
  }

  private void checkLinkedListIsEmpty() {
    if (this.first == null) throw new IllegalArgumentException("Linked list is Empty");
  }

  private E unLinkFirst() {
    // check if linked list is empty
    this.checkLinkedListIsEmpty();
    // get the next node available in the first node
    Node newHead = this.first.next;
    // get a copy of a next node item for the return value
    Object var2 = this.first.item;
    // assign null to every values of a first node
    this.first.next = null;
    this.first.item = null;
    // assign the val to the first node
    this.first = newHead;

    // if there is only one node available means previous and the next node data will be null
    if (newHead == null) this.last = null;
    else newHead.prev = null;

    --this.size;

    return (E) var2;
  }

  @Override
  public E removeLast() {
    return unlinkLast();
  }

  private E unlinkLast() {
    this.checkLinkedListIsEmpty();
    E valReturn = this.last.item;
    Node lastNode = this.last.prev;

    this.last.next = null;
    this.last.item = null;

    this.last = lastNode;
    if (lastNode == null) this.first = null;
    else lastNode.next = null;

    --this.size;

    return valReturn;
  }

  @Override
  public E pollFirst() {
    return null;
  }

  @Override
  public E pollLast() {
    return null;
  }

  @Override
  public E getFirst() {
    Node var1 = this.first;
    if (var1 == null) {
      throw new NoSuchElementException();
    } else {
      return (E) var1.item;
    }
  }

  @Override
  public E getLast() {
    Node var1 = this.last;
    if (var1 == null) {
      throw new NoSuchElementException();
    } else {
      return (E) var1.item;
    }
  }

  @Override
  public E peekFirst() {

    return getFirst();
  }

  @Override
  public E peekLast() {
    return getLast();
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
  public boolean offer(E e) {
    return false;
  }

  @Override
  public E remove() {

    return this.removeFirst();
  }

  @Override
  public E poll() {
    return this.unLinkFirst();
  }

  @Override
  public E element() {
    return this.getFirst();
  }

  @Override
  public E peek() {
    return getFirst();
  }

  @Override
  public void push(E e) {
    this.addFirst(e);
  }

  @Override
  public E pop() {
    return removeFirst();
  }

  @Override
  public int size() {
    return this.size;
  }

  @Override
  public Iterator<E> descendingIterator() {
    return null;
  }

  private static class Node<E> {
    E item;
    Node<E> next;
    Node<E> prev;

    Node(Node<E> var1, E var2, Node<E> var3) {
      this.prev = var1;
      this.item = var2;
      this.next = var3;
    }
  }

  private void verifyIndex(int i) {
    if (i < 0 || i >= this.size) throw new IllegalArgumentException();
  }

  public E indexAt(int val) {
    this.verifyIndex(val);

    return node(val).item;
  }

  Node<E> node(int index) {
    Node<E> returnVal;
    int firstIndex;
    // split the search by 2 halfs
    if (index < this.size >> 1) {
      returnVal = this.first;
      for (firstIndex = 0; firstIndex < index; ++firstIndex) {

        returnVal = returnVal.next;
      }
      return returnVal;

    } else {
      returnVal = this.last;
      for (firstIndex = this.size - 1; firstIndex > index; --firstIndex) {
        returnVal = returnVal.prev;
      }
      return returnVal;
    }
  }

  @Override
  public boolean isEmpty() {
    return this.size == 0;
  }

  @Override
  public E set(int index, E value) {
    this.verifyIndex(index);

    Node var3 = this.node(index);
    Object var4 = var3.item;
    var3.item = value;

    return (E) var4;
  }

  public boolean insert(int index, E value) {
    this.verifyIndex(index);
    // get the desired node
    Node var3 = this.node(index);
    // create a new node
    Node<E> newNode = new Node<E>(var3.prev, value, var3);
    //
    var3.prev = newNode;

    ++this.size;

    return true;
  }

  public E get(int var1) {
    this.verifyIndex(var1);
    return this.node(var1).item;
  }

  public boolean reverse() {
    if (this.size > 1) {
      this.first = this.last;
      reverse(this.first);
    }

    return true;
  }

  private void reverse(Node<E> node) {

    for (int i = this.size; i > 0; --i) {
      Node<E> newPrev = node.prev;
      node.prev = node.next;
      node.next = newPrev;
    }
  }
}
