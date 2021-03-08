package FairDraft.Hashing;

public class HashMapLinearProbing_DoubleHashing<K,V> extends HashMapLinearProbing_PrimaryClustering<K,V> {


    /**
     * I just written how to calculate hash in Double hashing method
     * Am not implemented Add, Delete, Set, Get methods
     * also i don't know whether its working fine Or Not.
     * Just knowing to calculate hasing is enough
     *
     * */


    private int hash1(K key)
    {
     return   (Integer) key%super.capacity();
    }

    private int hash2(K key){
        int prime=getLargestPrime();
        return prime-((Integer)key%prime);
    }

    @Override
    public int hash(K key) {
        int hash=0;
        for(int i=0; i<Integer.MAX_VALUE; i++){
             hash=(hash1(key) + i * hash2(key)) % this.arrData.length;
             if(this.arrData[hash]==null)
                 break;
            }

        return hash;
    }



    private int getLargestPrime(){
        int dummy=this.arrData.length-1;
        if(isPrime(dummy))
            return dummy;
        else
            --dummy;
        return 0;

    }

    public final boolean isPrime(int n)
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
