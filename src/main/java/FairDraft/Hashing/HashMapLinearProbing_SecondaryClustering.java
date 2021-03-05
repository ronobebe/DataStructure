package FairDraft.Hashing;

public class HashMapLinearProbing_SecondaryClustering<K, V> extends  HashMapLinearProbing_PrimaryClustering<K,V> {
    public HashMapLinearProbing_SecondaryClustering() {
        super();
    }

    @Override
    public int getSize() {
        return super.getSize();
    }

    @Override
    public int capacity() {
        return super.capacity();
    }

    @Override
    public boolean add(K key, V value) {
        return super.add(key, value);
    }

    @Override
    public V remove(K key) {
        return super.remove(key);
    }

    @Override
    public V search(K key) {
        return super.search(key);
    }

    @Override
    public V setData(K key, V value) {
        return super.setData(key, value);
    }

    @Override
    public void printAllElements() {
        super.printAllElements();
    }

    public int checkForLinearProbing(K key) {
        int dummy = super.hash(key);
        int increment=1;
        while (dummy<super.arrData.length ){
            if ( super.arrData[dummy] == null || (Integer)super.arrData[dummy].key==super.Default_Deleted_Number)
                return dummy;
            else
                dummy+=(increment++)<<1;
        }
        return -1;
    }

    public Node getNode(K key)
    {
        int dummy=this.hash(key);
        int increment=1;
        while(dummy<this.capacity())
        {
            if(this.arrData[dummy]==null)
                return null;

            if(this.arrData[dummy].key==key)
                return this.arrData[dummy];
            else
                dummy+=(increment++)<<1;
        }
        return null;

    }

  public static void main(String[] args) {

        HashMapLinearProbing_SecondaryClustering hashMapLinearProbing_secondaryClustering=new HashMapLinearProbing_SecondaryClustering();
      hashMapLinearProbing_secondaryClustering.add(1,"HI");
      hashMapLinearProbing_secondaryClustering.add(11,"Hellow");
      hashMapLinearProbing_secondaryClustering.add(8,"Mr X");
      hashMapLinearProbing_secondaryClustering.add(15,"Mr y");
      hashMapLinearProbing_secondaryClustering.add(19,"Mr z");
      hashMapLinearProbing_secondaryClustering.add(23,"Mr A");

      hashMapLinearProbing_secondaryClustering.remove(23);

      hashMapLinearProbing_secondaryClustering.add(23,"Success");
      hashMapLinearProbing_secondaryClustering.setData(23,"Success123");
      System.out.println("Search value is : "+ hashMapLinearProbing_secondaryClustering.search(23));

      hashMapLinearProbing_secondaryClustering.printAllElements();
    //
  }
}
