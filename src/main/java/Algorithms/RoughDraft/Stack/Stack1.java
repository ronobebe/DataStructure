package Algorithms.RoughDraft.Stack;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class Stack1<E> implements List<E> {

    int size;
    Object[] arrData;

    public  Stack1(){
        arrData=new Object[0];
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
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T> T[] toArray(T[] ts) {
        return null;
    }

    private int calculateCapacity(int i, Object[] arr){
        return  arr.length==0?10:i;
    }
    private void checkCapacity(int i){
        verifyCalculatedCapacity(calculateCapacity(i, this.arrData), this.arrData.length);
    }

    private void verifyCalculatedCapacity(int newSize, int oldSize){
        if(newSize-oldSize>1)
            this.grow(newSize);

    }
    private void grow(int newLength){

        int arrLength=this.arrData.length;
        int calculatedLength= arrLength<<1;
        if(newLength<calculatedLength)
            newLength=calculatedLength;

       this.arrData= Arrays.copyOf(this.arrData,newLength);
    }


    @Override
    public boolean add(E e) {
        this.checkCapacity(this.size+1);
        this.arrData[this.size++]=e;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        int i;
                if(o==null){
                    for(i=0; i<this.size;++i){
                        if(this.arrData[i]==null)
                            quickRemove(i);
                            return true;
                    }
                }
                else {
                    for (i = 0; i < this.size; ++i) {
                        if (this.arrData[i] == o)
                            quickRemove(i);
                        return true;
                    }
                }

        return false;
    }

    private E quickRemove(int i){
        Object returnObj=this.arrData[i];
        int sze=this.size-i;
        if(sze>1)
        System.arraycopy(this.arrData,i+1, this.arrData, i,sze);
        this.arrData[--this.size]=null;
        return (E)returnObj;
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

    private void ensureLength(int i){
        if(i<0 || i>=this.size)
            throw  new IllegalArgumentException(illegalArgumentExceptionMessage(i));
    }

    private String illegalArgumentExceptionMessage(int i){
        return  "Index you  entered is out of bound : "+i;
    }

    @Override
    public E get(int i) {
        this.ensureLength(i);

        return (E)this.arrData[i];
    }

    @Override
    public E set(int i, E e) {
        // replace the element at that index
        this.ensureLength(i);
        Object obj =this.arrData[i];
        this.arrData[i]=e;
        return (E)obj;
    }

    @Override
    public void add(int i, E e) {
             this.ensureLength(i);
             this.ensureLength(i+1);
             System.arraycopy(this.arrData, i,this.arrData, i+1, this.size-i);
             this.arrData[i]=e;
             ++this.size;

    }

    @Override
    public E remove(int i) {
        return null;
    }

    @Override
    public int indexOf(Object o) {

        int i;
        if(o==null){
            for( i=0; i<this.size; i++)
                if(o==null)
                    return i;

        }else{
            for( i=0; i<this.size; i++)
                if(this.arrData[i]==o)
                    return i;
        }

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
public  E pop(){
        Object o=this.peek();
        this.remove(this.size-1);
        return (E)o;
}
public  E peek(){
        ensureLength(this.size);
        return this.get(this.size-1);

}
public  E push(E e){
        this.add(e);
        return e;
}

}
