package Algorithms.FairDraft.ArrayList;

import Algorithms.FairDraft.ListInterfaces.List;

import java.util.*;

public class ArrayListA<E> implements List<E> {

    private int size;
    private Object[] arrData;
    private int hugeCapacityLength=Integer.MAX_VALUE-8;
    private final int DEFAULT_ARRAY_CAPACITY=10;

    public ArrayListA(int size) {
        if (size > 0)
            throw new IllegalArgumentException("Array Size Must be minimum zero : " + size);
        // fixed size array
        this.hugeCapacityLength=this.size;

        arrData = new Object[size];

    }

    public ArrayListA() {
        arrData=new Object[0];
    }


    @Override
    public int arrayCapacity() {
        return this.arrData.length;
    }

    @Override
    public boolean trimToItsSize() {

     this.arrData= Arrays.copyOf(this.arrData,this.size);
     return true;
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
        return indexOf(o)>-1;
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return Arrays.copyOf(this.arrData, this.size);
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    @Override
    public boolean add(E e) {
        this.checkArraySize(this.size+1);

        // this condition is for fixed size array
        if(this.arrayCapacity()>this.size()) {
            this.arrData[this.size++] = e;
            return true;
        }


        return false;
    }

    private void checkArraySize(int s){
       ensureCapacity(calculateCapacity(s,this.arrData));

    }

    private int calculateCapacity(int size, Object[] obj){
        return obj.length==0?DEFAULT_ARRAY_CAPACITY:size;
    }

    private void ensureCapacity(int size)
    {
        if(size>this.arrData.length)
            growArray(size);

    }
    private void growArray(int newSize){
        int arrayLength=this.arrData.length;
        // which is equal to arrayLength+arrayLength/2
        int calculateNewLength=arrayLength+arrayLength>>1 ;
        // Don't panic in this Line. when first iteration occurs array length is zero so calculatedNewLength=0 but newSize=10
        // which u can c from calculatedCapacity method. So for that we put if condition nothing much
        if(calculateNewLength<newSize)
            calculateNewLength=newSize;

        if(calculateNewLength>hugeCapacityLength)
            calculateNewLength= this.hugeCapacity(newSize);

        this.arrData=Arrays.copyOf(this.arrData,calculateNewLength);
    }

    private  int hugeCapacity(int length){
        // overflow
        if(hugeCapacityLength<0)
            throw new OutOfMemoryError();
        return (hugeCapacityLength<length)?Integer.MAX_VALUE:hugeCapacityLength;
    }


    @Override
    public boolean remove(Object o) {
        int index=indexOf(o);
        if(index>-1){
            System.arraycopy(this.arrData,index+1, this.arrData, index, this.size-index);
            this.arrData[this.size-1]=null;
            --this.size;
            return  true;
        }

        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {

        for(Object o:c)
            if(indexOf(o)<0)
                return  false;


        return true;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        int collectionLength=c.size();
        this.ensureCapacity(this.size+collectionLength);
        Object[] TempArray=c.toArray();
        System.arraycopy(TempArray,0, this.arrData, this.size,collectionLength );
        this.size+=collectionLength;

        return true;
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        int collectionLength=c.size();
        this.ensureCapacity(this.size+collectionLength);
        Object[] tempArray=c.toArray();
        System.arraycopy(this.arrData, index, this.arrData, index+collectionLength, this.size-index);
        System.arraycopy(tempArray, 0, this.arrData, index, collectionLength);
        this.size+=collectionLength;


        return true;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        for (Object o:c)
            this.remove(o);
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {
        for (int i=0; i<this.size; i++)
            this.arrData[i]=null;

    }

   private void ensureIndex(int index){
        if(index<0 && index>this.size-1)
            throw  new IllegalArgumentException("Index you entered is Out of Memory : "+index);
   }
    @SuppressWarnings("unchecked")
    @Override
    public E get(int index) {
        this.ensureIndex(index);

        return (E)this.arrData[index];
    }

    @SuppressWarnings("unchecked")
    @Override
    public E set(int index, E element) {
        this.ensureIndex(index);
        Object o=this.arrData[index];
        this.arrData[index]=element;
        return (E)o;
    }

    @Override
    public void add(int index, E element) {
        this.ensureIndex(index);
        this.ensureCapacity(this.size+1);
        System.arraycopy(this.arrData, index, this.arrData, index+1, this.size-index);
        this.arrData[index]=element;
        ++this.size;
    }

    @SuppressWarnings("unchecked")
    @Override
    public E remove(int index) {
        this.ensureIndex(index);
        Object o=this.arrData[index];
        System.arraycopy(this.arrData, index+1, this.arrData,index, this.size=index );
        --this.size;
        return (E)o;
    }

    @Override
    public int indexOf(Object o) {

        int index;
        if(o==null)
        {
            for(index=0; index<this.size; index++)
                if(this.arrData[index]==null)
                    return index;

        }
        else{
            for(index=0; index<this.size; index++)
                if(this.arrData[index]==o)
                    return index;
        }


        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        int index;
        if(o==null)
        {
            for(index=this.size-1; index<=0; index--)
                if(this.arrData[index]==null)
                    return index;

        }
        else{
            for(index=this.size-1; index<=0; index--)
                if(this.arrData[index]==o)
                    return index;
        }
        return -1;
    }

    @Override
    public ListIterator<E> listIterator() {
        return null;
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        return null;
    }

    @Override
    public java.util.List<E> subList(int fromIndex, int toIndex) {
        return null;
    }

    public static void main(String[] args) {

        ArrayListA<String> arrayListA=new ArrayListA<String>();

        arrayListA.add("1");
        arrayListA.add("2");
        arrayListA.add("3");
        arrayListA.add("4");
        System.out.println("Array contains the element before remove : "+arrayListA.contains("3"));
        arrayListA.remove("3");
        System.out.println("Array contains the element After remove : "+arrayListA.contains("3"));
        arrayListA.add(2, "5");
        arrayListA.set(3, "6");
        arrayListA.addAll(1,arrayListA);

        for(int i=0; i<arrayListA.size(); i++)
            System.out.println("Array element at "+i+" is : "+arrayListA.get(i));

        System.out.println("Array Size is : "+arrayListA.size());
        System.out.println("Array Capacity is : "+arrayListA.arrayCapacity());
        arrayListA.trimToItsSize();
        System.out.println("Array Capacity After trim to siZe : "+arrayListA.arrayCapacity());


    }

}
