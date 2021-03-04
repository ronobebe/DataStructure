package RoughDraft.Queue;

import java.util.Collection;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class QueueLinkedList<E> implements List<E> {
node tail;
node head;
int size;

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
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T> T[] toArray(T[] ts) {
        return null;
    }

    @Override
    public boolean add(E e) {
        return linkLast(e);
    }

    private boolean linkFirst(E e){
       node first=this.head;
       node newNode= new node(( node)null, e, head);
       this.head=newNode;
       if(first==null)
           this.tail=newNode;
       else
           first.prev=newNode;
       ++this.size;
     return  true;
    }

    private boolean linkLast(E e){
        node last=this.tail;
        node nwNode=new node(last,e,null);
        this.tail=nwNode;
        if(last==null)
            this.head=nwNode;
        else
            last.prev=nwNode;
        ++this.size;

          return true;
    }
/**
 * this.size should be greater than zero
 * if element present in the starting or ending point call unlinkFirst and unlinkNext respectively
 * */
    @Override
    public boolean remove(Object o) {
        if(this.size<0)
            return false;
        return unLinkObject(o);
    }

    private boolean unLinkObject(Object obj){
        int index;
        node node=this.head;

        for (index=0; index<this.size; index++)
        {


          if(node.data==obj)
          {
              QueueLinkedList.node valPrev=node.prev;
              valPrev.next=node.next;

              node.prev=null;
              node.data=null;
              node.next=null;

              --this.size;

              return  true;

          }
            node=node.next;

        }


        return false;
    }


    public boolean unlinkFirst(){
        Object removedElement=this.head.data;
        node nextNode=this.head.next;

        this.head.next=null;
        this.head.data=null;
    if (nextNode == null) this.tail = null;
    else {
        nextNode.prev=null;
        this.head = nextNode;
     }
 --this.size;
        return true;
    }


    public boolean unlinkLast(){
        Object removedElement=this.tail.data;
        node nextNode=this.tail.prev;

        this.tail.prev=null;
        this.tail.data=null;
        if (nextNode == null) this.head = null;
        else {
            nextNode.next=null;
            this.tail = nextNode;
        }
        --this.size;
        return true;
    }


    @Override
    public boolean containsAll(Collection<?> collection) {
        return false;
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
    public void clear() {

    }

    @Override
    public E get(int i) {
        return null;
    }

    @Override
    public E set(int i, E e) {
        return null;
    }

    @Override
    public void add(int i, E e) {

    }

    @Override
    public E remove(int i) {
        return null;
    }

    @Override
    public int indexOf(Object o) {

        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
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


    private  static  class  node<E>{
        E data;
        node prev;
        node next;

        public node( node prev,E data, node next) {
            this.data = data;
            this.prev = prev;
            this.next = next;
        }
    }
}
