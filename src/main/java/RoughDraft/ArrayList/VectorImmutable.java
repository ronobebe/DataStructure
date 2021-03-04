package RoughDraft.ArrayList;

import java.lang.reflect.Array;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;

public  class VectorImmutable<E> extends AbstractList<E> {

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

    private int size;
    transient  Object[] elementData ;
    private static final Object[] EMPTY_ELEMENTDATA = new Object[0];
    private static final Object[] DEFAULTCAPACITY_EMPTY_ELEMENTDATA = new Object[0];

    public VectorImmutable(int val1) {
        // constructor for fixed size array
        if(val1>0){
           this.elementData=new Object[0];
        }
        else{
            if (val1 != 0) {
                throw new IllegalArgumentException("Illegal Capacity: " + val1);
            }

            this.elementData=EMPTY_ELEMENTDATA;
        }

    }

    public VectorImmutable(){
        // default vector
        this.elementData= DEFAULTCAPACITY_EMPTY_ELEMENTDATA;
    }

    public  E at(int i){
    this.checkInRange(i);
    return this.elementData(i);
}


    @Override
    public E get(int i) {
      return at(i);
    }

    E elementData(int var1) {
        return (E) this.elementData[var1];
    }

    @Override
    public int size() {
        return this.size;
    }

    private void checkInRange(int i){
        if(i>=size)
            throw new IndexOutOfBoundsException(this.outOfBoundsMsg(i));

}

    private String outOfBoundsMsg(int var1) {
        return "Index: " + var1 + ", Size: " + this.size;
    }



    @Override
    public boolean isEmpty() {
        return this.size==0;
    }

/**
 * add element
* */

    @Override
    public boolean add(E e) {
        this.ensureCapacityInternal(this.size + 1);
        this.elementData[this.size++] = e;
        return true;

    }

    public boolean push(E e){
        return add(e);
    }

    private static int calculateCapacity(Object[] var0, int var1) {
        return var0 == DEFAULTCAPACITY_EMPTY_ELEMENTDATA ? Math.max(2, var1) : var1;
    }

    private void ensureCapacityInternal(int var1) {
        this.ensureExplicitCapacity(calculateCapacity(this.elementData, var1));
    }

    private void ensureExplicitCapacity(int var1) {
        ++this.modCount;
        if (var1 - this.elementData.length > 0) {
            this.grow(var1);
        }

    }

    private void grow(int var1) {
        int var2 = this.elementData.length;
        int var3 = var2 + (var2 >> 1); // is equal to x = x + (int) (x/2);
        if (var3 - var1 < 0) {
            var3 = var1;
        }

        if (var3 - 2147483639 > 0) {
            var3 = hugeCapacity(var1);
        }

        this.elementData = Arrays.copyOf(this.elementData, var3);
    }

    private static int hugeCapacity(int var0) {
        if (var0 < 0) {
            throw new OutOfMemoryError();
        } else {
            return var0 > 2147483639 ? 2147483647 : 2147483639;
        }
    }


    /**
     * Capacity of array is array.length
     * */
    public  int capacity(){

        return this.elementData.length;
    }

    /**
     * insert data
     * */

    public  void insert (E e, int var1){
        add(var1,e);
    }


    public void add(int var1, E var2) {
        this.rangeCheckForAdd(var1);
        this.ensureCapacityInternal(this.size + 1);
        System.arraycopy(this.elementData, var1, this.elementData, var1 + 1, this.size - var1);
        this.elementData[var1] = var2;
        ++this.size;
    }

    private void rangeCheckForAdd(int var1) {
        if (var1 < 0 || var1 > this.size) {
            throw new IndexOutOfBoundsException(this.outOfBoundsMsg(var1));
        }
    }


}
