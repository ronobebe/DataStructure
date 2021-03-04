package RoughDraft.ArrayList;

import java.util.AbstractList;
import java.util.Arrays;

public class VectorImmutable2<E> extends AbstractList<E> {

    private int size;
    private static  final Object[] EMPTY_ELEMENT_DATA=new Object[0];
    private static final Object[] DEFAULTCAPACITY_EMPTY_ELEMENTDATA = new Object[0];
    private Object[] elementData;

    public VectorImmutable2(){
        // assign empty element data
        this.elementData=DEFAULTCAPACITY_EMPTY_ELEMENTDATA;
    }



    public VectorImmutable2(int sze){
        // assign a size to elementData
        if(size>0)
            this.elementData=new Object[sze];
        else
            if(size<0)
                throw new IllegalArgumentException("Size must be greater than zero");
            else
                this.elementData=EMPTY_ELEMENT_DATA;
    }
/**
 * size of the arrayData is added here
 * */
    @Override
    public int size() {
        return this.size;
    }

    /**
     * Capacity of the whole array
     * */

    public int capacity() {
        return this.elementData.length;
    }

    /**
     * get data from vectors
     * */

    @Override
    public E get(int i) {
        this.rangeCheck(i);
        return (E)this.elementData(i);
    }

    public void rangeCheck(int i){
        if(i>size)
            throw new IndexOutOfBoundsException(this.outOfBoundsMsg(i));

    }

    private String outOfBoundsMsg(int var1) {
        return "Index: " + var1 + ", Size: " + this.size;
    }

     private Object elementData(int i){
        return this.elementData[i];
     }

     /**
      * Add data in the array list
      * check capacity of array
      * if array size is less just add value to the array
      * if its greater than length copy the value of the array to new array
      * check also array size is not exceeding the huge value
      * */

    @Override
    public boolean add(Object o) {
        this.ensureCapacity(this.size + 1);
        this.elementData[this.size++] = o;
        return true;
    }

    private static int calculateCapacity(Object[] var0, int var1) {
        return var0 == DEFAULTCAPACITY_EMPTY_ELEMENTDATA ? Math.max(2, var1) : var1;
    }

    private void ensureCapacity(int i){
         this.ensureExplicitCapacity(calculateCapacity(this.elementData,i));
    }

    private void ensureExplicitCapacity(int val1){
        // to ensure the amount of time array is modified while iteration
        ++this.modCount;
        if(val1-this.elementData.length>0)
            growArray(val1);

    }

    private void growArray(int val1){
      int val2=this.elementData.length;
      int val3 =val2+(val2 >> 1);

      // check element size
      if(val3-val1<0){
          val3=val1;
      }

       // check size is exceed huge value
       if(val3-2147483639 > 0) {
           val3 = hugeCapacity(val1);
       }

        this.elementData = Arrays.copyOf(this.elementData, val3);

    }

    private static int hugeCapacity(int var0) {
        if (var0 < 0) {
            throw new OutOfMemoryError();
        } else {
            return var0 > 2147483639 ? 2147483647 : 2147483639;
        }
    }

    /**
    * insert element at specific index
     * check range if the given index is already available or not
     * inserting one element to the required index we must need to check array have the capacity to hold extra element
    * */

    public  void add( int i, Object a){
        // function throw exception if the given size is more than array length
        this.rangeCheckForAdd(i);
        this.ensureCapacity(this.size+1);
        System.arraycopy(this.elementData, i, this.elementData, i + 1, this.size - i);
        this.elementData[i] = a;
        ++this.size;

    }

    private void rangeCheckForAdd(int i){
        if(i<0 || i> this.size)
            throw new IndexOutOfBoundsException(this.outOfBoundsMsg(i));
    }


/**
 * is array size is zero return true
 * */
    @Override
    public boolean isEmpty() {
        return this.size==0;
    }
    /**
     * add element in the zero th position
     * */

    public  void prepend(Object o){
        this.add(0,o);
    }

    /**
     * Delete and pop
     * delete item at specific index
     * pop delete index this.size-1
     * for delete check range
     * remove the item shift elements left side
    * */

    @Override
    public E remove(int var1) {
        rangeCheck(var1);
        ++this.modCount;
        Object var2 = this.elementData(var1);
        int var3 = this.size - var1 - 1;
        if (var3 > 0) {
            System.arraycopy(this.elementData, var1 + 1, this.elementData, var1, var3);
        }

        this.elementData[--this.size] = null;
        return (E)var2;
    }

    public  E pop(){
        int val3=this.elementData.length/4;
        if(this.size<=val3)
            this.elementData = Arrays.copyOf(this.elementData, this.size);
        return remove(this.size-1);
    }

    /**
     * find the element
     * check array size is greater than zero
     * */

    public  boolean delete(Object var1){
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

    private void fastRemove(int var1) {
        ++this.modCount;
        int var2 = this.size - var1 - 1;
        if (var2 > 0) {
            System.arraycopy(this.elementData, var1 + 1, this.elementData, var1, var2);
        }

        this.elementData[--this.size] = null;
    }

    public  int find(Object var1){
        int var2;
        if (var1 == null) {
            for(var2 = 0; var2 < this.size; ++var2) {
                if (this.elementData[var2] == null) {
                    return var2;

                }
            }
        } else {
            for(var2 = 0; var2 < this.size; ++var2) {
                if (var1.equals(this.elementData[var2])) {
                    return var2;
                }
            }
        }

        return -1;
    }

}
