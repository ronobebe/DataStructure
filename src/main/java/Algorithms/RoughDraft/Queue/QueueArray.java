package Algorithms.RoughDraft.Queue;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class QueueArray<E> implements List<E> {

  private  int size;
  private   Object[] arrData;
    private static final int MAX_ARRAY_SIZE = 2147483639;


    public QueueArray() {
        this.arrData=new Object[0];
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return this.size==0;
    }

    public int capacity(){return  this.arrData.length;}

    @Override
    public boolean contains(Object o) {
        return indexOf(o)>=0;
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
/**
 * To adding an element we need to check array size
 * check for this.size+1
 * if yes add element else make array size as (size+size*0.5)
 * also check size is exceeding it larger value;
 * */
    @Override
    public boolean add(E e) {
        this.ensureCapacity(this.size+1);
        this.arrData[this.size++]=e;
        return true;
    }

    private void ensureCapacity(int s){
        checkCapacity(calculateCapacity(s,this.arrData),this.arrData.length);
    }
    private int calculateCapacity(int s, Object[] arr){
        return  arr.length==0?2:s;
    }

    private void checkCapacity(int s, int arrSize){
        if(s>arrSize)
            growArray(s);

    }
    private void growArray(int newSize){
        int arrLength=this.arrData.length;
        int extendedLength=arrLength+arrLength>>1;
        if(newSize>extendedLength)
            extendedLength=newSize;
        if(extendedLength>MAX_ARRAY_SIZE)
            extendedLength =ensureLargeCapacity(newSize);

        this.arrData= Arrays.copyOf(this.arrData,extendedLength);
    }
/**
 * implemented for fixed size array
* */
    private int ensureLargeCapacity(int s){
    if (s > MAX_ARRAY_SIZE) throw new OutOfMemoryError("Array size you fixed is " + MAX_ARRAY_SIZE);
    else {
      int newSize = MAX_ARRAY_SIZE - s;
      return s+newSize;
        }

    }
/**
 * Its like a queue
 * add element at the last
 * Dequeue
 * remove element from the very first
 * */
    public boolean enque(E e){
      return  this.add(e);
    }

    public  E deque(){
        return  this.remove(0);
    }

    @Override
    public boolean remove(Object o) {
        int val1=indexOf(o);


        return val1==-1?false:quickRemove(val1);
    }
    /**
     * size of the array is always lesser than the array length
     * so iteration over array may return null element
     * so always check @param i is lesser than this.size-1
    * */

    private boolean quickRemove(int i){

        int val1=this.size-1-i;
        if(val1>=1)
        System.arraycopy(this.arrData,i+1,this.arrData,i , val1);
        this.arrData[--this.size]=null;

        return true;
    }

    @Override
    public boolean containsAll(Collection<?> collection) {
        for(Object obj: collection)
            if(indexOf(obj)==-1)
                return false;

        return true;
    }

    @Override
    public boolean addAll(Collection<? extends E> collection) {
    Object[] val1=collection.toArray();
    int arrSize=val1.length;
    this.ensureCapacity(this.size+arrSize);
    System.arraycopy(val1, 0, this.arrData, this.size, arrSize);
    this.size+=arrSize;

    return  true;
    }


    @Override
    public boolean addAll(int i, Collection<? extends E> collection) {
        Object[] val1=collection.toArray();
        int arrSize=val1.length;
        this.ensureCapacity(this.size+arrSize);
        int newLength=this.size-i ;
        System.arraycopy(this.arrData,i, this.arrData,i+arrSize,newLength);
        System.arraycopy(val1,0,this.arrData,i,arrSize );

        this.size+=arrSize;
        return true;
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
    private void ensureSize(int i){
        if(i<0 || i>=this.size)
            throw  new OutOfMemoryError("Index you entered is out of memory error : "+i);
    }

    @Override
    public E get(int i) {
        this.ensureSize(i);

        return this.arrData(i);
    }

    E arrData(int i){
        return (E) this.arrData[i];
    }

    @Override
    public E set(int i, E e) {
        this.ensureSize(i);
        E val1=this.arrData(i);
        this.arrData[i]=e;
        return val1;
    }

    @Override
    public void add(int i, E e) {
    this.ensureSize(i);
    this.ensureCapacity(this.size+1);
    System.arraycopy(this.arrData,i,this.arrData,i+1,this.size-i);
    this.arrData[i]=e;
    ++this.size;

    }

    @Override
    public E remove(int i) {
        this.ensureSize(i);
        E val1 =this.arrData(i);
        quickRemove(i);
        return val1;
    }

    @Override
    public int indexOf(Object o) {
        int i;
        if(o==null){
            for ( i=0; i<this.size; i++){
                if(this.arrData[i]==null)
                    return i;
            }
        }
        else{
            for ( i=0; i<this.size; i++){
                if(this.arrData[i]==o)
                    return i;
            }
        }

        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        int i;
        if(o==null){
            for ( i=this.size-1; i>-1; i++){
                if(this.arrData[i]==null)
                    return i;
            }
        }
        else{
            for ( i=this.size-1; i>-1; i++){
                if(this.arrData[i]==o)
                    return i;
            }
        }

        return -1;
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
}
