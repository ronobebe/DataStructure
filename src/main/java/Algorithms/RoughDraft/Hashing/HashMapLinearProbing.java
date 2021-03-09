package Algorithms.RoughDraft.Hashing;


public class HashMapLinearProbing<K,V> {


  private   int arraySize;
    private  Object[] array;

    private  int count;

    public HashMapLinearProbing(int size) {
       if(size<0)
           throw new  IllegalArgumentException("Size you entered is incorrect : "+size);
       else{
           this.arraySize = size;
         array=new Object[this.arraySize];
       }
    }

    public HashMapLinearProbing() {
        array=new Object[0];
    }


    public int getArraySize(){
        return this.count;
    }

    public  int capacity(){
        return  this.arraySize;
    }

    public  boolean isEmpty(){
        return  this.count==0;
    }

    private boolean isFull(){
        return this.count==this.arraySize;
    }

    private int hash(K key)
    {
        Integer i=(Integer) key;
        return this.arraySize%i;
    }

    public  boolean add(K key, V value){
        int hash=hash(key);
    if (this.arraySize!=0 && isFull())
        throw new OutOfMemoryError("you initialize array size is : " + this.arraySize);
    else if(this.array[hash]!=null)
    {
         hash=checkForNextPossiblePlace(hash+1);
         if(hash==-1)
             throw  new IllegalArgumentException("There is no available space");
    }

        Node node = new Node(key, value);
        ++this.count;
        this.array[hash]=node;


        return  true;
    }

    public  int checkForNextPossiblePlace(int hash){
        if(hash==this.arraySize-1)
            return -1;
        if(this.array[hash]==null)
            return hash;
        return  checkForNextPossiblePlace(hash+1);
    }


    public V get(K key){
        if(key==null)
            throw new IllegalArgumentException("You entered null");
        int hashKey=hash(key);
        if(hashKey>this.count)
            throw  new IllegalArgumentException("Array index Out of Bound");

            return (V)getValue(hashKey, key);
    }
    private String getValue(int has, K key){
        if(this.array[has]==null)
            return null;
        Node node=(Node)this.array[has];
        if(node.getKey()==key)
            return (String)node.getValue();

        return getValue(has+1, key);

    }



    public static class Node<K,V>{

        K key;
        V value;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        private void setKey(K key) {
            this.key = key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }
    }

  public static void main(String[] args) {
    //

      HashMapLinearProbing hashMapLinearProbing=new HashMapLinearProbing(10);
      hashMapLinearProbing.add(3,"Bebetto");
      hashMapLinearProbing.add(3,"Sivanesh");
      hashMapLinearProbing.add(3,"Pooch");
      hashMapLinearProbing.get(3);
  }
}
