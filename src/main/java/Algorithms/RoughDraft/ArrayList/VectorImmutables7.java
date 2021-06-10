package Algorithms.RoughDraft.ArrayList;

import Algorithms.Sorting.QuickSort;

import java.util.Arrays;

public class VectorImmutables7 {
  private Object[] arrayData;
  private int size;
  private final int initialArraySize = 10;

  public VectorImmutables7() {
    arrayData = new Object[0];
  }

  public int size() {
    return this.size;
  }

  public boolean isEmpty() {
    return this.size == 0;
  }

  public int capacity() {
    return this.arrayData.length;
  }

  public boolean add(Object data) {

    this.checkArraySize(this.size + 1);
    this.arrayData[this.size++] = data;

    return true;
  }

  private void checkArraySize(int s) {
    ensureCapacity(calculateCapacity(s));
  }

  private int calculateCapacity(int n) {
    return this.capacity() == 0 ? initialArraySize : n;
  }

  private void ensureCapacity(int siz) {
    if (siz >= this.capacity()) growArray(siz);
  }

  private void growArray(int calculatedSize) {
    int len = this.capacity();
    int newSize = len << 1;
    if (newSize < calculatedSize) newSize = calculatedSize;

    this.arrayData = Arrays.copyOf(this.arrayData, newSize);
  }

  /*  public  int[] sortArray()
  {
      int[] data=new int[this.size];
      data=Arrays.copyOf(this.arrayData,this.size);
      QuickSort quickSort=new QuickSort();
      return quickSort.quickSort1(data);
  }*/

  public Object get(int pos) {
    this.checkPosition(pos);
    return this.arrayData[pos];
  }

  public boolean isAvailable(Object data) {
    return this.indexOf(data) != -1;
  }

  private void checkPosition(int pos) {
    if (pos > this.size) {

      throw new ArrayIndexOutOfBoundsException(arrayIndexMessage(pos));
    }
  }

  private String arrayIndexMessage(int pos) {
    return "Array index you entered is " + pos + " is outOfBounds " + "-1";
  }

  public int indexOf(Object data) {
    int index = -1;
    if (data == null) {
      for (int i = 0; i < this.size; i++) {
        if (this.arrayData[i] == null) index = i;
      }

    } else {
      for (int i = 0; i < this.size; i++) {
        if (this.arrayData[i] == data) index = i;
      }
    }
    return index;
  }

  public boolean enque(Object data) {
    return this.add(data);
  }

  public Object deque() {
    return delete(0);
  }

  public Object delete(int data) {
    int pos= this.indexOf(data);
    if (pos != -1) {
      Object removedData = this.arrayData[pos];
      System.arraycopy(this.arrayData, pos + 1, this.arrayData, pos, this.size - pos-1);
      this.arrayData[this.size-1]=null;
      --this.size;

      return removedData;
    }
    return -1;
  }

  public  Object insert(int pos, Object data)
  {
    this.checkInsertPosition(pos);
    this.checkArraySize(this.size+1);
    Object insertData = this.arrayData[pos];
    System.arraycopy(this.arrayData,pos,this.arrayData,pos+1,this.size-pos);
    this.arrayData[pos]=data;
    ++this.size;
    return insertData;
  }

  private void checkInsertPosition(int pos)
  {
    if(pos<0 || pos>this.size)
    {
      throw  new IllegalArgumentException(arrayIndexMessage(pos));
    }
  }


  public  void trimToSIze()
  {

    this.arrayData=Arrays.copyOf(this.arrayData,this.size);
  }

  public  boolean containsAll(Object[] data)
  {
    for (int i=0; i<data.length; i++)
    if(indexOf(data[i])==-1)
      return false;
    return true;
  }

  public  boolean addAll(Object[] data)
  {
    int len=data.length;
    this.checkArraySize(data.length);
    System.arraycopy(data,0,this.arrayData,this.size,len);
    this.size+=len;

    return true;
  }
  public  boolean addAll(int pos,Object[] data)
  {
    this.checkInsertPosition(pos);
    int len=data.length;
    this.checkArraySize(data.length);
    System.arraycopy(this.arrayData,pos,this.arrayData,pos+len,this.size-pos);
    System.arraycopy(data, 0, this.arrayData,pos, len);
    this.size+=len;

    return true;
  }

  public  Object set(int pos, Object data)
  {
    this.checkInsertPosition(pos);
    Object dat=this.arrayData[pos];
    this.arrayData[pos]=data;
    return  dat;
  }
  public static void main(String[] args) {
    VectorImmutables7 vectorImmutables7 = new VectorImmutables7();
    vectorImmutables7.add(1);
    vectorImmutables7.add(2);
    vectorImmutables7.add(3);
    vectorImmutables7.add(4);
    vectorImmutables7.add(5);
    vectorImmutables7.add(6);
    vectorImmutables7.insert(0,7);
    Object[] d={2,5,6};
    vectorImmutables7.addAll(4,d);
    System.out.println("" + vectorImmutables7.isAvailable(5));
    System.out.println("Delete " + vectorImmutables7.delete(4));
    System.out.println("size before " + vectorImmutables7.capacity());
    vectorImmutables7.trimToSIze();
    System.out.println("size after " + vectorImmutables7.capacity());

  }
}
