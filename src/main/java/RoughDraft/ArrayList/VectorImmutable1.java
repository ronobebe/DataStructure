package RoughDraft.ArrayList;

import java.io.Serializable;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.RandomAccess;

public class VectorImmutable1<E> extends AbstractList<E> implements List<E>, RandomAccess, Cloneable, Serializable {

    private int size;
    private final Object defaultListArray[]=new Object[0];
    private final Object emptyListArray[]=new Object[0];
    private Object[] elementData;

    public VectorImmutable1(){
        this.elementData=defaultListArray;
        
    }

    public VectorImmutable1(int fixedSize){
        if(fixedSize>0)
            this.elementData=new Object[fixedSize];
        else
            if(fixedSize<0)
                throw  new IllegalArgumentException("size must be greater than or equal to zero");
            else
                this.elementData=emptyListArray;
    }


    /**
     * @return
     */
    @Override
    public boolean isEmpty() {
        return this.size==0;
    }

    /**
     * @return Test
     */
    @Override
    public int size() {
        return this.size;
    }


    /**
     * check if array have enough space to add element
     * if not create a new array with double its length
     * if yes add element to it
     * 2147483639
     *  */
    @Override
    public boolean add(E e) {
         this.ensureCapacity(this.size+1);
         this.elementData[this.size++]=e;
         return  true;
    }
    private void ensureCapacity(int val1){
        ensureExplicitCapacity(calculateCapacity(this.elementData,val1));
    }
    private int calculateCapacity(Object[] obj,int val1){
        return  obj==defaultListArray?Math.max(10,val1):val1;
    }
    private void ensureExplicitCapacity(int val1){
        ++this.modCount;
        if(val1-this.elementData.length>0)
            growArray(val1);
    }
    private void growArray(int val1){
        int val2=this.elementData.length;
        int val3=val2+(val2>>1);
        if(val1-val3>0)
            val3=val1;
        if(val1-2147483639>0)
            val3=hugeCapacityArray(val1);

        this.elementData=Arrays.copyOf(this.elementData, val3);

    }


    private int hugeCapacityArray(int val1){
        if(val1<0)
            throw new OutOfMemoryError();
        return val1>2147483639?2147483646:2147483639;
    }
/**
 * @param i should be less than this.size
 * */
    @Override
    public void add(int i, E e) {
        this.rangeCheckForAdd(i);
        this.ensureCapacity(this.size+1);
        System.arraycopy(this.elementData,i, this.elementData, i+1, this.size-i);
        this.elementData[i]=e;
        ++this.size;
    }

    private void rangeCheckForAdd(int i){
        if(i<0 || i>this.size)
            throw new IndexOutOfBoundsException();
    }

    private void rangeCheck(int i){
        if( i>this.size)
            throw new IndexOutOfBoundsException();
    }

    private Object elementData(int i){
        return this.elementData[i];
    }

    /**
     * @param i is less than size of the array
     *
     * */
    public Object delete(  int i){
       this.rangeCheck(i);
       ++this.modCount;
        Object var2 = this.elementData(i);
        int var3 = this.size - i - 1;
        if (var3 > 0) {
            System.arraycopy(this.elementData, i + 1, this.elementData, i, var3);
        }
        this.elementData[--this.size] = null;
        return  var2;
    }

    public  boolean delete(Object e){
        int i=find(e);
        if(i!=-1)
        {
            ++this.modCount;
            int var3 = this.size - i - 1;
            if (var3 > 0) {
                System.arraycopy(this.elementData, i + 1, this.elementData, i, var3);
            }

            this.elementData[--this.size] = null;
            return  true;
        }

        return  false;
    }

    public  int find(Object e){
        if(e==null){
            for(int i=0; i<this.size; i++){
                if(this.elementData(i)==null)
                    return i;
            }

        }
        else{
            for(int i=0; i<this.size; i++){
                if(this.elementData(i)==e)
                    return i;
            }

        }
        return -1;
    }


    public  E get(int var1){
        this.rangeCheck(var1);
        return (E)this.elementData(var1);
    }

    public  int capacity(){
        return  this.elementData.length;
    }

}
