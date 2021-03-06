package FairDraft.Hashing;

public class HashMapLinearProbing_DoubleHashing<K,V> extends HashMapLinearProbing_PrimaryClustering<K,V> {
    public HashMapLinearProbing_DoubleHashing() {
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

    private int hash1(K key)
    {
     return   (Integer) key%super.getSize();
    }

    private int hash2(K key){
        int prime=getLargestPrime();
        return prime-((Integer)key%prime);
    }

    @Override
    public int hash(K key) {

        return (hash1(key) + /*i **/ hash2(key)) % this.arrData.length;
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
    public Node getNode(K key) {
        return super.getNode(key);
    }

    @Override
    public V setData(K key, V value) {
        return super.setData(key, value);
    }

    @Override
    public int checkForLinearProbing(K key) {
        return super.checkForLinearProbing(key);
    }

    @Override
    public void printAllElements() {
        super.printAllElements();
    }

    private int getLargestPrime(){
        int dummy=this.arrData.length-1;
        if(isPrime(dummy))
            return dummy;
        else
            --dummy;
        return 0;

    }

    private boolean isPrime(int n)
    {
        // Corner case
        if (n <= 1)
            return false;

        // Check from 2 to n-1
        for (int i = 2; i < n; i++)
            if (n % i == 0)
                return false;

        return true;
    }

}
