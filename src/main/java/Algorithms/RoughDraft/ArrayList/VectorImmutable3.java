package Algorithms.RoughDraft.ArrayList;

import java.io.Serializable;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.List;
import java.util.RandomAccess;

public class VectorImmutable3<E> extends AbstractList<E> implements List<E>, Serializable, RandomAccess {

    int size;
    Object[] EMPTY_ARRAY_LIST=new Object[0];
    Object[] DEFAULT_ARRAY_LIST=new Object[0];
    Object[] arrayData;

    public VectorImmutable3(){
        this.arrayData=DEFAULT_ARRAY_LIST;
    }

    public VectorImmutable3(int s){
        if(s>0)
            this.arrayData= new Object[s];
        else
            if(s!=0)
                throw new IllegalArgumentException();
            else
                this.arrayData=EMPTY_ARRAY_LIST;

    }

/**
 * verify given index is less than @param size
 * return element
 * */

    private  void rangeCheck(int pos){
    if(pos>=this.size)
        throw new IndexOutOfBoundsException(this.outOfBoundsMsg(pos));
}

    private String outOfBoundsMsg(int var1) {
        return "Index: " + var1 + ", Size: " + this.size;
    }

    private Object elementData(int pos){
    return this.arrayData[pos];
    }

    @Override
    public E get(int i) {
    this.rangeCheck(i);
    return (E)this.elementData(i);
    }

    @Override
    public int size() {
        return this.size;
    }

    public  int capacity(){
        return this.arrayData.length;
    }

    /**
    * verify @param arrayData have the capacity to add a data
     *
    * */
    @Override
    public boolean add(E e) {
        this.ensureCapacity(this.size+1);
        this.arrayData[this.size++] = e;
        return true;
    }

    private void ensureCapacity(int cap){
        ensureExplicitCapacity(calculateCapacity(this.arrayData,cap));
    }

    private int calculateCapacity(Object[] obj, int pos){
        return obj==DEFAULT_ARRAY_LIST?Math.max(2, pos):pos;
    }

    private void ensureExplicitCapacity(int pos){
        ++this.modCount;
        if(pos>this.arrayData.length)
            growArray(pos);
    }

    private void growArray(int pos1){
        int var2=this.arrayData.length;
        int var3=var2+(var2>>1);
        if(pos1-var3>0)
            var3=pos1;
        if(var3-2147483639>0)
            var3=hugeCapacity(pos1);
       this.arrayData= Arrays.copyOf(this.arrayData,var3);
    }

    private int hugeCapacity(int var0){

        if (var0 < 0) {
            throw new OutOfMemoryError();
        } else {
            return var0 > 2147483639 ? 2147483647 : 2147483639;
        }
    }

    @Override
    public boolean isEmpty() {
        return this.size==0;
    }


    @Override
    public void add(int i, E e) {
        this.rangeCheckForAdd(i);
        this.ensureCapacity(this.size+1);
        System.arraycopy(this.arrayData,i,this.arrayData,i+1,this.size-i);
        this.arrayData[i]=e;
        ++this.size;

    }

    private void rangeCheckForAdd(int pos){
        if(pos<0 || this.size<pos)
            throw new OutOfMemoryError();
    }

    public  Object delete(int i){
        this.rangeCheck(i);
        Object val1=this.elementData(i);
        ++this.modCount;
        if (i > 0)
        System.arraycopy(this.arrayData,i+1,this.arrayData,i,this.size-i-1);
        this.arrayData[--this.size] = null;
        --this.size;

        return val1;
    }


}
