package Algorithms.RoughDraft.ArrayList;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class VectorImmutable4<E> implements List<E> {

    /**
     * size() - number of items
     *  capacity() - number of items it can hold
     *  is_empty()
     *  at(index) - returns item at given index, blows up if index out of bounds
     *  push(item)
     *  insert(index, item) - inserts item at index, shifts that index's value and trailing elements to the right
     *  this.prepend(item) - can use insert above at index 0
     *  pop() - remove from end, return value
     *  delete(index) - delete item at index, shifting all trailing elements left
     *  remove(item) - looks for value and removes index holding it (even if in multiple places)
     *  find(item) - looks for value and returns first index with that value, -1 if not found
     *  resize(new_capacity) // private function
     * when you reach capacity, resize to double the size
     * when popping an item, if size is 1/4 of capacity, resize to half
     * */

    int size;
    Object elementData[];

    public  VectorImmutable4(){

        elementData=new Object[0];
    }


    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size==0;
    }

    public  int capacity(){
        return this.elementData.length;
    }

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
     *  check if length of the array is greater than the given size
     *  @param sze is always get as size+n
     *  n is minimum of 1*/
    private boolean checkSpace(int sze){


      return  this.elementData.length>sze? true: growArray(sze);
    }


    private void checkSpaceForInsert(int sze){
    if(sze<0 || sze>this.size)
    throw  new IllegalArgumentException("Index is Out of Bounds : "+sze);

    }


    /**
     * if no space grow array and copy the element to new array
     * for first instance we get array size as zero so make it to 10
     * from the 11th element onward make the array size double
     * val2<<1 double its size
     *
    * */

    private boolean growArray(int siz){
        int newLength= this.elementData.length==0?2:siz;
        int arrSize=this.elementData.length;
        int extendedLength= arrSize<<1;
        if(extendedLength-newLength<0)
            extendedLength=newLength;

        this.elementData= Arrays.copyOf(this.elementData,extendedLength);

        return  true;
    }



    @Override
    public boolean add(E e) {
        checkSpace(this.size+1);
        this.elementData[this.size++]=e;

        return true;
    }

    @Override
    public boolean addAll(Collection<? extends E> collection) {
        this.checkSpace(this.size+collection.size());
        for (Object elem : collection)
            this.elementData[this.size++]=elem;


        return true;
    }

    @Override
    public boolean addAll(int i, Collection<? extends E> collection) {
        this.checkSpaceForInsert(i);
        this.checkSpace(this.size+collection.size());
        System.arraycopy(this.elementData,i,this.elementData,i+collection.size(), this.size-i);
        for (Object elem : collection) {
            ++this.size;
            this.elementData[i++] = elem;
        }

        for(int r=0; r<this.elementData.length; r++)
            System.out.println("Value of "+r+" is :   "+this.elementData[r]);

        return true;
    }

    @Override
    public void add(int i, E e) {
        this.checkSpaceForInsert(i);
        this.checkSpace(this.size+1);
        System.arraycopy(this.elementData, i,this.elementData,i+1,this.size-i);
        this.elementData[i]=e;
        ++this.size;



    }

    @Override
    public boolean remove(Object var1) {
        int var2;
        if (var1 == null) {
            for(var2 = 0; var2 < this.size; ++var2) {
                if (this.elementData[var2] == null) {
                    this.fastRemove(var2);
                    return true;
                }
            }
        } else {
            for(var2 = 0; var2 < this.size; ++var2) {
                if (var1.equals(this.elementData[var2])) {
                    this.fastRemove(var2);
                    return true;
                }
            }
        }


        return false;
    }

    private void fastRemove(int var1){
       // verify that given element is below the size bcz array size is greater than the ArrayList Size
        int var2 = this.size - var1 - 1;
        if (var2 > 0) {
            System.arraycopy(this.elementData, var1 + 1, this.elementData, var1, var2);
        }

        this.elementData[--this.size] = null;
    }

    @Override
    public boolean containsAll(Collection<?> collection) {
        for(Object o: collection)
        {

        }
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
    this.size=0;
        for(int var1 = 0; var1 < this.size; ++var1) {
            this.elementData[var1] = null;
        }

        this.size = 0;
    }

    @Override
    public E get(int i) {
        this.checkSpaceForInsert(i);


        return (E)this.elementData[i];
    }

    @Override
    public E set(int i, E e) {
        this.checkSpaceForInsert(i);
        Object var3=this.elementData[i];
        this.elementData[i]=e;
        return (E)var3;
    }


    @Override
    public E remove(int var1) {
        this.checkSpaceForInsert(var1);
        Object var2 = this.elementData[var1];
        int var3 = this.size - var1 - 1;
        if (var3 > 0) {
            System.arraycopy(this.elementData, var1 + 1, this.elementData, var1, var3);
        }

        this.elementData[--this.size] = null;
        return (E)var2;
    }

    @Override
    public int indexOf(Object o) {

        if(o==null)
        {
            for (int i=0; i<this.elementData.length; i++){
                if(this.elementData[i]==null)
                    return i;
            }
        }
        else{
            for (int i=0; i<this.elementData.length; i++){
                if(this.elementData[i]==o)
                    return i;
            }


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
}
