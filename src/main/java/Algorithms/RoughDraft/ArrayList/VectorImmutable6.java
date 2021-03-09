package Algorithms.RoughDraft.ArrayList;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class VectorImmutable6<E> implements List<E> {

  int size;
  Object[] arrData;

  public VectorImmutable6() {
    arrData = new Object[0];
  }

  @Override
  public int size() {
    return this.size;
  }

  @Override
  public boolean isEmpty() {
    return this.size == 0;
  }

  public int capacity() {
    return this.arrData.length;
  }

  @Override
  public boolean contains(Object o) {
    return indexOf(o) > -1;
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

  private int calculateCapacity(Object[] arr, int i) {

    return this.arrData.length == 0 ? 2 : i;
  }

  private void checkArrayCapacity(int i) {
    verifyCapacity(calculateCapacity(this.arrData, i), this.arrData.length);
  }

  private void verifyCapacity(int newLength, int arrLength) {
    if (newLength >= arrLength) growArray(newLength);
  }

  private void growArray(int newLength) {
    int val2 = this.arrData.length;
    int val3 = val2 << 1;

    if (newLength > val3) val3 = newLength;

    this.arrData = Arrays.copyOf(this.arrData, val3);
  }

  E arrData(int i) {
    return (E) this.arrData[i];
  }

  @Override
  public boolean add(E e) {

    checkArrayCapacity(this.size + 1);
    this.arrData[++this.size] = e;
    return true;
  }

  @Override
  public boolean remove(Object o) {

    int val2;
    if (o == null) {
      for (val2 = 0; val2 < this.arrData.length; ++val2)
        if (this.arrData[val2] == null) {
          quickRemove(val2);
          return true;
        }
    } else {
      for (val2 = 0; val2 < this.arrData.length; ++val2)
        if (this.arrData[val2] == o) {
          quickRemove(val2);
          return true;
        }
    }

    return false;
  }
  /**
   * this.size is always lesser than or equal to this.arrData.length remaining all positions are
   * occupied by null default so that is meaningless to remove so need to check before remove
   * element
   */
  private E quickRemove(int pos) {

    int val1 = this.size - pos;
    Object obj = this.arrData[pos];
    if (val1 > 0) System.arraycopy(this.arrData, pos + 1, this.arrData, pos, val1);
    this.arrData[--this.size] = null;

    return (E) obj;
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
  public void clear() {}

  @Override
  public E get(int i) {
    return null;
  }

  @Override
  public E set(int i, E e) {
    return null;
  }

  @Override
  public void add(int i, E e) {}

  @Override
  public E remove(int i) {
    return null;
  }

  @Override
  public int indexOf(Object o) {
    int val1;
    if (o == null) {

      for (val1 = 0; val1 < this.arrData.length; val1++)
        if (this.arrData[val1] == null) return val1;
    } else {
      for (val1 = 0; val1 < this.arrData.length; val1++) if (this.arrData[val1] == o) return val1;
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
