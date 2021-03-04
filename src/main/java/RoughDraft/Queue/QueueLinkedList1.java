package RoughDraft.Queue;

import java.io.Serializable;
import java.util.AbstractSequentialList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.Spliterator;
import java.util.function.UnaryOperator;

public class QueueLinkedList1<E>  implements List<E>, Deque<E>, Cloneable, Serializable {


    /**
     * All LinkedList Operations with enque and deque
     * Enque - insert element at the last position available
     * Deque - Delete element at the very first position
     * FIFO - First In First Out
     * */

    int size;
    node head;
    node tail;



    private static class node<E> {
        node prev;
        E data;
        node next;

        public node(node prev, E data, node next) {
            this.prev = prev;
            this.data = data;
            this.next = next;
        }
    }


    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return this.size==0;
    }

    @Override
    public boolean contains(Object o) {
        return this.indexOf(o)>-1;
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
    public <T> T[] toArray(T[] ts) {
        return null;
    }

    private void linkFirst(E e){
        node<E> headNode=this.head;
        node newNode=new node<E>(null, e,headNode);
        this.head=newNode;

        if(headNode==null)
            this.tail=newNode;
        else
            headNode.prev=newNode;

        ++this.size;

    }

    private void linkLast(E e){
        node<E> tailNode=this.tail;
        node<E> newNode=new node<E> (tailNode,e, null);
        this.tail=newNode;

        if(tailNode==null)
            this.head=newNode;
        else
            tailNode.next=newNode;

        ++this.size;

    }


    @Override
    public void addFirst(E e) {
     linkFirst(e);
    }

    @Override
    public void addLast(E e) {
    linkLast(e);
    }

    public void enque(E e){
        linkLast(e);
    }

    @Override
    public boolean offerFirst(E e) {
        addFirst(e);
        return true;
    }

    @Override
    public boolean offerLast(E e) {
        addLast(e);
        return true;
    }

    private E unlinkFirst(){
        node<E> removeNode=this.head;
        E removeData=removeNode.data;
        node<E> newHeadNode=removeNode.next;

        newHeadNode.prev=null;
        this.head=newHeadNode;
        removeNode.next=null;
        removeNode.data=null;

--this.size;
        return  removeData;
    }



    @Override
    public E removeFirst() {
        return unlinkFirst();
    }


    private E unlinkLast(){
        node<E> removeNode=this.tail;
        E removeData=removeNode.data;
        node<E> newHeadNode=removeNode.prev;

        newHeadNode.next=null;
        this.tail=newHeadNode;
        removeNode.prev=null;
        removeNode.data=null;
--this.size;

        return  removeData;
    }



    @Override
    public E removeLast() {
        return unlinkLast();
    }

    @Override
    public E pollFirst() {
        return unlinkFirst();
    }

    @Override
    public E pollLast() {
        return unlinkLast();
    }

    @Override
    public E getFirst() {
        node val=this.head;
        if(val==null)
            throw new NoSuchElementException();
        else

        return (E)val.data;
    }

    @Override
    public E getLast() {
        node val=this.tail;

        if(val==null)
            throw new NoSuchElementException();
        else
        return (E)val.data;
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
    public boolean add(E e) {
        linkLast(e);
        return true;
    }

    @Override
    public boolean offer(E e) {
        linkLast(e);
        return true;
    }

    @Override
    public E remove() {
        return unlinkFirst();
    }


    @Override
    public E poll() {

        return unlinkFirst();
    }

    @Override
    public E element() {
        return this.getFirst();
    }

    @Override
    public E peek() {
        return this.getFirst();
    }

    @Override
    public void push(E e) {
     this.linkFirst(e);
    }

    @Override
    public E pop() {
        return this.unlinkFirst();
    }

    @Override
    public boolean remove(Object var1) {
        this.unlinkNode(getNodeByValue(this.head,(E)var1));
        return true;
    }


    node<E> getNodeByValue(node headNode, E var1){
        node returnNode;
        if(var1==null){
            for(returnNode=headNode; returnNode!=null; returnNode=returnNode.next){
                if(returnNode.data==null){
                    return returnNode;
                }
            }

        }
        else{
            for(returnNode=headNode; returnNode!=null; returnNode=returnNode.next){
                if(returnNode.data==var1){
                    return returnNode;
                }
            }

        }

        return  null;
    }



    @Override
    public boolean containsAll(Collection<?> collection) {
        for(Object o: collection){
           if(!containAll(o))
               return false;
        }

        return true;
    }

    private boolean containAll(Object e){
        if(indexOf(e)<0)
            return false;
        return true;
    }

    @Override
    public boolean addAll(Collection<? extends E> collection) {
        return false;
    }

    @Override
    public boolean addAll(int i, Collection<? extends E> collection) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> collection) {
        return false;
    }


    @Override
    public boolean retainAll(Collection<?> collection) {
        return false;
    }

    @Override
    public void replaceAll(UnaryOperator<E> unaryOperator) {

    }

    @Override
    public void sort(Comparator<? super E> comparator) {

    }

    @Override
    public void clear() {

    }

    private void ensureElementIndex(int i){
        if(i<0 || i>=this.size)
            throw new IllegalArgumentException("Index you entered is Out of List Size : "+i);
    }

    @Override
    public E get(int var1) {
        this.ensureElementIndex(var1);
        return  (E) this.getNode(var1).data;
    }

    @Override
    public E set(int elementIndex, E e) {

        this.ensureElementIndex(elementIndex);
        E returnData= this.getNode(elementIndex).data;
        this.getNode(elementIndex).data=e;

        return returnData;
    }

    private boolean ensurePositionIndex(int i){
        return i>=0 && i<=this.size;
    }

    private void ensureIndex(int i){
        if(!this.ensurePositionIndex(i))
            throw  new OutOfMemoryError("Index size is bad : "+i);
    }

    @Override
    public void add(int elementIndex, E e) {

        this.ensureElementIndex(elementIndex);
        if(elementIndex==0)
            linkFirst(e);
        else if(elementIndex==this.size-1)
            linkLast(e);
        else{
        this.linkBefore(this.getNode(elementIndex), e);}
    }

    private void linkBefore(node node, E e){

        QueueLinkedList1.node prev=node.prev;
        QueueLinkedList1.node next=node.next;
        QueueLinkedList1.node newNode=new node<E>(prev,e, node);

        prev.next=newNode;
        node.prev=newNode;

        ++this.size;



    }

    @Override
    public E remove(int var1) {
        this.ensureElementIndex(var1);
        return (E)unlinkNode(this.getNode(var1));

    }

   private  node<E> getNode(int index){
       node<E> headNode;

    if (index < this.size >> 1) {
      headNode = this.head;
      for (int i = 0; i < index; ++i) {

        headNode = headNode.next;
      }
      return headNode;

    } else {
        headNode = this.tail;
      for (int i = this.size-1; i >index; --i) {
        headNode = headNode.prev;
      }
}
           return  headNode;

   }

   E unlinkNode(node<E> requiredNode){
       node<E> prev=requiredNode.prev;
       node<E> next=requiredNode.next;
       E returnData=requiredNode.data;

    if (prev == null)
        this.head = next;
    else {
      prev.next = next;
      requiredNode.prev=null;

         }
    if (next == null)
        this.tail = prev;
    else {
      next.prev = prev;
      requiredNode.next = null;
    }
    --this.size;


       return  returnData==null?null:returnData;
   }

    @Override
    public int indexOf(Object o) {
        if(o==null){

            for (int i=0; i<this.size; i++)
            {
                node val1=this.head;
                if(val1.data==null)
                    return i;
                else
                    val1=this.head.next;

            }

        }
        else{
            for (int i=0; i<this.size; i++)
            {
                node val1=this.head;
                if(val1.data==o)
                    return i;
                else
                    val1=this.head.next;

            }


        }

        return  -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        if(o==null){

            for (int i=this.size-1; i<-1; i++)
            {
                node val1=this.tail;
                if(val1.data==null)
                    return i;
                else
                    val1=this.tail.prev;

            }

        }
        else{
            for (int i=this.size-1; i<-1; i++)
            {
                node val1=this.tail;
                if(val1.data==o)
                    return i;
                else
                    val1=this.tail.prev;

            }


        }

        return  -1;
    }



    @Override
    public ListIterator<E> listIterator() {
        return null;
    }

    @Override
    public ListIterator<E> listIterator(int i) {
        return null;
    }

    @Override
    public List<E> subList(int i, int i1) {
        return null;
    }

    @Override
    public Spliterator<E> spliterator() {
        return null;
    }
}
