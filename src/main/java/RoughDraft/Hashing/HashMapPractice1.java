package RoughDraft.Hashing;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.AbstractMap;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class HashMapPractice1<K,V>  extends AbstractMap<K, V> implements Map<K,V>, Cloneable, Serializable {

    int size;
    static final int DEFAULT_INITIAL_CAPACITY = 16;
    static final int MAXIMUM_CAPACITY = 1073741824;
    static final float DEFAULT_LOAD_FACTOR = 0.75F;
    static final int TREEIFY_THRESHOLD = 8;
    static final int UNTREEIFY_THRESHOLD = 6;
    static final int MIN_TREEIFY_CAPACITY = 64;
    Node<K,V> table[];
    int threshold;
    float loadFactor;

    public HashMapPractice1(){
        this.loadFactor=0.75f;
    }

  public HashMapPractice1(int initialCapacity, float loadFactor) {
    if (initialCapacity < 0) throw new IllegalArgumentException();
      else {

          if (initialCapacity > 1073741824) {
             initialCapacity = 1073741824;
           }

      if (loadFactor < 0.0f && !Float.isNaN(loadFactor))
        throw new IllegalArgumentException();
        else {
        this.loadFactor = loadFactor;
        this.threshold=tableSizeFor(initialCapacity);

      }
      }
    }

    private static  final int hash(Object obj){
        int val1;
        return obj==null?0:(val1=obj.hashCode())^ val1>>>16;
    }

/**
 * each iteration the given value is rounded to the nearest 2^power value
 * Ex : 2^1>3, 2^2>5, 2^3>9, 2^4>16, 2^5>32
 * */
    static final int tableSizeFor(int var0) {
        int var1 = var0 - 1; // unsigned bit 11111111111111111111111111111111 (-1)
        var1 |= var1 >>> 1; // unsigned bit var1 >>> 1 0111 1111 1111 1111 1111 1111 1111 1111
        var1 |= var1 >>> 2;              // var1    -1 1111 1111 1111 1111 1111 1111 1111 1111
        var1 |= var1 >>> 4;               //           0000 0000 0000 0000 1111 1111 1111 1111
        var1 |= var1 >>> 8;
        var1 |= var1 >>> 16;
        return var1 < 0 ? 1 : (var1 >= 1073741824 ? 1073741824 : var1 + 1);
    }


    public HashMapPractice1(int initialCapacity){
        this(initialCapacity,0.75f);
    }

    public HashMapPractice1(Map<? extends K,? extends V> mapSet){
       this.loadFactor=0.75f;

    }


    private int calculateCapacity(int val1){
        return val1==0?DEFAULT_INITIAL_CAPACITY:val1;
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
    public boolean containsKey(Object o) {
        return false;
    }

    @Override
    public boolean containsValue(Object o) {
        return false;
    }

    @Override
    public V get(Object o) {
        return null;
    }

    @Override
    public V put(K k, V v) {

        return put(hash(k),k,v,false, false);
    }

    final Node<K,V>[] resize(){
        Node[] tempTable=this.table;
        int tempTableLength= tempTable==null?0: tempTable.length;
        int tempThreshold=this.threshold;
        int defaultSize=0;
        int defaultThreshold=0;
        if(tempTableLength>0)
            /**
             * check for the table size first
             * if the size is greater than or equal to the max size assign constant value to the this.threshold
             * and return array*/
            if(tempTableLength>=1073741824)
            {
                this.threshold=2147483647;
                return tempTable;


            }
            else  if(tempThreshold>0)
            {
                defaultSize=tempThreshold;
            }
            else{
               defaultSize=16;
               defaultThreshold=12;
            }

            if(defaultThreshold==0){
                float calculateThreshold=(float)defaultSize*this.loadFactor;
                defaultThreshold = defaultSize < 1073741824 && calculateThreshold < 1.07374182E9F ? (int)calculateThreshold : 2147483647;

            }

            /**
             * so far this we calculate threshold based on capacity of the array and load factor
             * assign the calculated threshold to this.threshold
             * */
            this.threshold=defaultThreshold;

            /**
             * create new table and assign it into this.table
             * */
            Node[] newTable=(Node[])( new Node[defaultSize]);
            this.table=tempTable;
            if(tempTable!=null)
            {
                /**
                 * iterate the loop over a array
                 * check every index if its filled with Linked lists or just empty(null) spaces
                 * @param tempNode store the index value into it
                 * @param tempTable[index] into null
                 *
                 * */
                for (int index=0; index<tempTableLength; ++index)
                {
                    Node tempNode;
                    if((tempNode=tempTable[index])!=null)
                    {
                        tempTable[index]=null;
                        if(tempNode.nextNode==null) // single value in the linked list
                        {
                         newTable[tempNode.hashValue & defaultSize -1]=tempNode;
                        }
                        // if hashMap consist of tree node
                        if(tempNode instanceof HashMapPractice1.TreeNode ){
                            ((TreeNode)tempNode).split(this, newTable, index, tempTableLength);
                        }
                        else{
                            Node dummyNode = null;
                            Node dummyNode1 = null;
                            Node dummyNode2 = null;
                            Node dummyNode3 = null;

                            Node dummyNode4;
                            do{
                                dummyNode4=tempNode.nextNode;
                                if((tempNode.hashValue & tempTableLength)==0)
                                {
                                    if(dummyNode1==null)
                                        dummyNode=tempNode;
                                    else
                                        dummyNode1.nextNode=tempNode;


                                dummyNode1=tempNode;
                                }
                                else{
                                    if(dummyNode3==null)
                                        dummyNode2=tempNode;
                                    else
                                        dummyNode3.nextNode=tempNode;


                                    dummyNode3=tempNode;
                                }

                                tempNode=dummyNode4;
                            }

                            while(dummyNode4!=null);

                            if (dummyNode1 != null) {
                                dummyNode1.nextNode = null;
                                newTable[index] = dummyNode;
                            }

                            if (dummyNode3 != null) {
                                dummyNode3.nextNode = null;
                                newTable[index + tempTableLength] = dummyNode2;
                            }


                        }


                    }
                }

            }


        return newTable;
    }




    private V put(int hash,K k, V v,boolean val4, boolean val5)
    {

        Node[] tempTable;
        int tempTableLength;
        if((tempTable=this.table)==null && (tempTableLength=this.table.length)==0)
            tempTableLength=(tempTable=null).length;

        return null;
    }



    @Override
    public V remove(Object o) {
        return null;
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> map) {

    }

    @Override
    public void clear() {

    }

    @Override
    public Set<K> keySet() {
        return null;
    }

    @Override
    public Collection<V> values() {
        return null;
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        return null;
    }


     static class Node<K,V> implements Entry<K,V>{

        Node nextNode;
        final K key;
        V value;
        int hashValue;

        public Node( int hashValue, K key, V value,Node nextNode) {
            this.nextNode = nextNode;
            this.key = key;
            this.value = value;
            this.hashValue = hashValue;
        }

        @Override
        public K getKey() {
            return this.key;
        }

        @Override
        public V getValue() {
            return this.value;
        }

        @Override
        public V setValue(V v) {
            V value1=this.value;
            this.value=v;
            return value1;
        }


    }

     static final class TreeNode<K, V> extends LinkedHashMap.Entry<K, V> {
        TreeNode<K, V> parent;
        TreeNode<K, V> left;
        TreeNode<K, V> right;
        TreeNode<K, V> prev;
        boolean red;

        TreeNode(int var1, K var2, V var3, Node<K, V> var4) {
            super(var1, var2, var3, var4);
        }

        final TreeNode<K, V> root() {
            TreeNode var1;
            TreeNode var2;
            for(var1 = this; (var2 = var1.parent) != null; var1 = var2) {
            }

            return var1;
        }

        static <K, V> void moveRootToFront(Node<K, V>[] var0, TreeNode<K, V> var1) {
            int var2;
            if (var1 != null && var0 != null && (var2 = var0.length) > 0) {
                int var3 = var2 - 1 & var1.hashValue;
                TreeNode var4 = (TreeNode)var0[var3];
                if (var1 != var4) {
                    var0[var3] = var1;
                    TreeNode var6 = var1.prev;
                    Node var5;
                    if ((var5 = var1.nextNode) != null) {
                        ((TreeNode)var5).prev = var6;
                    }

                    if (var6 != null) {
                        var6.nextNode = var5;
                    }

                    if (var4 != null) {
                        var4.prev = var1;
                    }

                    var1.nextNode = var4;
                    var1.prev = null;
                }

                assert checkInvariants(var1);
            }

        }

        final TreeNode<K, V> find(int var1, Object var2, Class<?> var3) {
            TreeNode var4 = this;

            do {
                TreeNode var8 = var4.left;
                TreeNode var9 = var4.right;
                int var5;
                if ((var5 = var4.hashValue) > var1) {
                    var4 = var8;
                } else if (var5 < var1) {
                    var4 = var9;
                } else {
                    Object var7;
                    if ((var7 = var4.key) == var2 || var2 != null && var2.equals(var7)) {
                        return var4;
                    }

                    if (var8 == null) {
                        var4 = var9;
                    } else if (var9 == null) {
                        var4 = var8;
                    } else {
                        int var6;
                        if ((var3 != null || (var3 = HashMapPractice1.comparableClassFor(var2)) != null) && (var6 = HashMapPractice1.compareComparables(var3, var2, var7)) != 0) {
                            var4 = var6 < 0 ? var8 : var9;
                        } else {
                            TreeNode var10;
                            if ((var10 = var9.find(var1, var2, var3)) != null) {
                                return var10;
                            }

                            var4 = var8;
                        }
                    }
                }
            } while(var4 != null);

            return null;
        }

        final TreeNode<K, V> getTreeNode(int var1, Object var2) {
            return (this.parent != null ? this.root() : this).find(var1, var2, (Class)null);
        }

        static int tieBreakOrder(Object var0, Object var1) {
            int var2;
            if (var0 == null || var1 == null || (var2 = var0.getClass().getName().compareTo(var1.getClass().getName())) == 0) {
                var2 = System.identityHashCode(var0) <= System.identityHashCode(var1) ? -1 : 1;
            }

            return var2;
        }

        final void treeify(Node<K, V>[] var1) {
            TreeNode var2 = null;

            TreeNode var4;
            for(TreeNode var3 = this; var3 != null; var3 = var4) {
                var4 = (TreeNode)var3.nextNode;
                var3.left = var3.right = null;
                if (var2 == null) {
                    var3.parent = null;
                    var3.red = false;
                    var2 = var3;
                } else {
                    Object var5 = var3.key;
                    int var6 = var3.hashValue;
                    Class var7 = null;
                    TreeNode var8 = var2;

                    int var9;
                    TreeNode var12;
                    do {
                        Object var11 = var8.key;
                        int var10;
                        if ((var10 = var8.hashValue) > var6) {
                            var9 = -1;
                        } else if (var10 < var6) {
                            var9 = 1;
                        } else if (var7 == null && (var7 = HashMapPractice1.comparableClassFor(var5)) == null || (var9 = HashMapPractice1.compareComparables(var7, var5, var11)) == 0) {
                            var9 = tieBreakOrder(var5, var11);
                        }

                        var12 = var8;
                    } while((var8 = var9 <= 0 ? var8.left : var8.right) != null);

                    var3.parent = var12;
                    if (var9 <= 0) {
                        var12.left = var3;
                    } else {
                        var12.right = var3;
                    }

                    var2 = balanceInsertion(var2, var3);
                }
            }

            moveRootToFront(var1, var2);
        }

        final Node<K, V> untreeify(HashMapPractice1<K, V> var1) {
            Node var2 = null;
            Node var3 = null;

            for(Object var4 = this; var4 != null; var4 = ((Node)var4).nextNode) {
                Node var5 = var1.replacementNode((Node)var4, (Node)null);
                if (var3 == null) {
                    var2 = var5;
                } else {
                    var3.nextNode = var5;
                }

                var3 = var5;
            }

            return var2;
        }

        final TreeNode<K, V> putTreeVal(HashMapPractice1<K, V> var1, Node<K, V>[] var2, int var3, K var4, V var5) {
            Class var6 = null;
            boolean var7 = false;
            TreeNode var8 = this.parent != null ? this.root() : this;
            TreeNode var9 = var8;

            int var10;
            TreeNode var13;
            do {
                int var11;
                if ((var11 = var9.hashValue) > var3) {
                    var10 = -1;
                } else if (var11 < var3) {
                    var10 = 1;
                } else {
                    Object var12;
                    if ((var12 = var9.key) == var4 || var4 != null && var4.equals(var12)) {
                        return var9;
                    }

                    if (var6 == null && (var6 = HashMapPractice1.comparableClassFor(var4)) == null || (var10 = HashMapPractice1.compareComparables(var6, var4, var12)) == 0) {
                        if (!var7) {
                            var7 = true;
                            TreeNode var14;
                            if ((var14 = var9.left) != null && (var13 = var14.find(var3, var4, var6)) != null || (var14 = var9.right) != null && (var13 = var14.find(var3, var4, var6)) != null) {
                                return var13;
                            }
                        }

                        var10 = tieBreakOrder(var4, var12);
                    }
                }

                var13 = var9;
            } while((var9 = var10 <= 0 ? var9.left : var9.right) != null);

            Node var16 = var13.nextNode;
            TreeNode var15 = var1.newTreeNode(var3, var4, var5, var16);
            if (var10 <= 0) {
                var13.left = var15;
            } else {
                var13.right = var15;
            }

            var13.nextNode = var15;
            var15.parent = var15.prev = var13;
            if (var16 != null) {
                ((TreeNode)var16).prev = var15;
            }

            moveRootToFront(var2, balanceInsertion(var8, var15));
            return null;
        }

        final void removeTreeNode(HashMapPractice1<K, V> var1, Node<K, V>[] var2, boolean var3) {
            int var4;
            if (var2 != null && (var4 = var2.length) != 0) {
                int var5 = var4 - 1 & this.hashValue;
                TreeNode var6 = (TreeNode)var2[var5];
                TreeNode var7 = var6;
                TreeNode var9 = (TreeNode)this.nextNode;
                TreeNode var10 = this.prev;
                if (var10 == null) {
                    var6 = var9;
                    var2[var5] = var9;
                } else {
                    var10.nextNode = var9;
                }

                if (var9 != null) {
                    var9.prev = var10;
                }

                if (var6 != null) {
                    if (var7.parent != null) {
                        var7 = var7.root();
                    }

                    TreeNode var8;
                    if (var7 != null && (!var3 || var7.right != null && (var8 = var7.left) != null && var8.left != null)) {
                        TreeNode var12 = this.left;
                        TreeNode var13 = this.right;
                        TreeNode var14;
                        TreeNode var15;
                        TreeNode var16;
                        if (var12 != null && var13 != null) {
                            for(var15 = var13; (var16 = var15.left) != null; var15 = var16) {
                            }

                            boolean var17 = var15.red;
                            var15.red = this.red;
                            this.red = var17;
                            TreeNode var18 = var15.right;
                            TreeNode var19 = this.parent;
                            if (var15 == var13) {
                                this.parent = var15;
                                var15.right = this;
                            } else {
                                TreeNode var20 = var15.parent;
                                if ((this.parent = var20) != null) {
                                    if (var15 == var20.left) {
                                        var20.left = this;
                                    } else {
                                        var20.right = this;
                                    }
                                }

                                if ((var15.right = var13) != null) {
                                    var13.parent = var15;
                                }
                            }

                            this.left = null;
                            if ((this.right = var18) != null) {
                                var18.parent = this;
                            }

                            if ((var15.left = var12) != null) {
                                var12.parent = var15;
                            }

                            if ((var15.parent = var19) == null) {
                                var7 = var15;
                            } else if (this == var19.left) {
                                var19.left = var15;
                            } else {
                                var19.right = var15;
                            }

                            if (var18 != null) {
                                var14 = var18;
                            } else {
                                var14 = this;
                            }
                        } else if (var12 != null) {
                            var14 = var12;
                        } else if (var13 != null) {
                            var14 = var13;
                        } else {
                            var14 = this;
                        }

                        if (var14 != this) {
                            var15 = var14.parent = this.parent;
                            if (var15 == null) {
                                var7 = var14;
                            } else if (this == var15.left) {
                                var15.left = var14;
                            } else {
                                var15.right = var14;
                            }

                            this.left = this.right = this.parent = null;
                        }

                        var15 = this.red ? var7 : balanceDeletion(var7, var14);
                        if (var14 == this) {
                            var16 = this.parent;
                            this.parent = null;
                            if (var16 != null) {
                                if (this == var16.left) {
                                    var16.left = null;
                                } else if (this == var16.right) {
                                    var16.right = null;
                                }
                            }
                        }

                        if (var3) {
                            moveRootToFront(var2, var15);
                        }

                    } else {
                        var2[var5] = var6.untreeify(var1);
                    }
                }
            }
        }

        final void split(HashMapPractice1<K, V> var1, Node<K, V>[] var2, int var3, int var4) {
            TreeNode var6 = null;
            TreeNode var7 = null;
            TreeNode var8 = null;
            TreeNode var9 = null;
            int var10 = 0;
            int var11 = 0;

            TreeNode var13;
            for(TreeNode var12 = this; var12 != null; var12 = var13) {
                var13 = (TreeNode)var12.nextNode;
                var12.nextNode = null;
                if ((var12.hashValue & var4) == 0) {
                    if ((var12.prev = var7) == null) {
                        var6 = var12;
                    } else {
                        var7.nextNode = var12;
                    }

                    var7 = var12;
                    ++var10;
                } else {
                    if ((var12.prev = var9) == null) {
                        var8 = var12;
                    } else {
                        var9.nextNode = var12;
                    }

                    var9 = var12;
                    ++var11;
                }
            }

            if (var6 != null) {
                if (var10 <= 6) {
                    var2[var3] = var6.untreeify(var1);
                } else {
                    var2[var3] = var6;
                    if (var8 != null) {
                        var6.treeify(var2);
                    }
                }
            }

            if (var8 != null) {
                if (var11 <= 6) {
                    var2[var3 + var4] = var8.untreeify(var1);
                } else {
                    var2[var3 + var4] = var8;
                    if (var6 != null) {
                        var8.treeify(var2);
                    }
                }
            }

        }

        static <K, V> TreeNode<K, V> rotateLeft(TreeNode<K, V> var0, TreeNode<K, V> var1) {
            TreeNode var2;
            if (var1 != null && (var2 = var1.right) != null) {
                TreeNode var4;
                if ((var4 = var1.right = var2.left) != null) {
                    var4.parent = var1;
                }

                TreeNode var3;
                if ((var3 = var2.parent = var1.parent) == null) {
                    var0 = var2;
                    var2.red = false;
                } else if (var3.left == var1) {
                    var3.left = var2;
                } else {
                    var3.right = var2;
                }

                var2.left = var1;
                var1.parent = var2;
            }

            return var0;
        }

        static <K, V> TreeNode<K, V> rotateRight(TreeNode<K, V> var0, TreeNode<K, V> var1) {
            TreeNode var2;
            if (var1 != null && (var2 = var1.left) != null) {
                TreeNode var4;
                if ((var4 = var1.left = var2.right) != null) {
                    var4.parent = var1;
                }

                TreeNode var3;
                if ((var3 = var2.parent = var1.parent) == null) {
                    var0 = var2;
                    var2.red = false;
                } else if (var3.right == var1) {
                    var3.right = var2;
                } else {
                    var3.left = var2;
                }

                var2.right = var1;
                var1.parent = var2;
            }

            return var0;
        }

        static <K, V> TreeNode<K, V> balanceInsertion(TreeNode<K, V> var0, TreeNode<K, V> var1) {
            var1.red = true;

            TreeNode var2;
            while((var2 = var1.parent) != null) {
                TreeNode var3;
                if (!var2.red || (var3 = var2.parent) == null) {
                    return var0;
                }

                TreeNode var4;
                if (var2 == (var4 = var3.left)) {
                    TreeNode var5;
                    if ((var5 = var3.right) != null && var5.red) {
                        var5.red = false;
                        var2.red = false;
                        var3.red = true;
                        var1 = var3;
                    } else {
                        if (var1 == var2.right) {
                            var1 = var2;
                            var0 = rotateLeft(var0, var2);
                            var3 = (var2 = var2.parent) == null ? null : var2.parent;
                        }

                        if (var2 != null) {
                            var2.red = false;
                            if (var3 != null) {
                                var3.red = true;
                                var0 = rotateRight(var0, var3);
                            }
                        }
                    }
                } else if (var4 != null && var4.red) {
                    var4.red = false;
                    var2.red = false;
                    var3.red = true;
                    var1 = var3;
                } else {
                    if (var1 == var2.left) {
                        var1 = var2;
                        var0 = rotateRight(var0, var2);
                        var3 = (var2 = var2.parent) == null ? null : var2.parent;
                    }

                    if (var2 != null) {
                        var2.red = false;
                        if (var3 != null) {
                            var3.red = true;
                            var0 = rotateLeft(var0, var3);
                        }
                    }
                }
            }

            var1.red = false;
            return var1;
        }

        static <K, V> TreeNode<K, V> balanceDeletion(TreeNode<K, V> var0, TreeNode<K, V> var1) {
            while(var1 != null && var1 != var0) {
                TreeNode var2;
                if ((var2 = var1.parent) == null) {
                    var1.red = false;
                    return var1;
                }

                if (var1.red) {
                    var1.red = false;
                    return var0;
                }

                TreeNode var3;
                TreeNode var5;
                TreeNode var6;
                if ((var3 = var2.left) == var1) {
                    TreeNode var4;
                    if ((var4 = var2.right) != null && var4.red) {
                        var4.red = false;
                        var2.red = true;
                        var0 = rotateLeft(var0, var2);
                        var4 = (var2 = var1.parent) == null ? null : var2.right;
                    }

                    if (var4 == null) {
                        var1 = var2;
                    } else {
                        var5 = var4.left;
                        var6 = var4.right;
                        if (var6 != null && var6.red || var5 != null && var5.red) {
                            if (var6 == null || !var6.red) {
                                if (var5 != null) {
                                    var5.red = false;
                                }

                                var4.red = true;
                                var0 = rotateRight(var0, var4);
                                var4 = (var2 = var1.parent) == null ? null : var2.right;
                            }

                            if (var4 != null) {
                                var4.red = var2 == null ? false : var2.red;
                                if ((var6 = var4.right) != null) {
                                    var6.red = false;
                                }
                            }

                            if (var2 != null) {
                                var2.red = false;
                                var0 = rotateLeft(var0, var2);
                            }

                            var1 = var0;
                        } else {
                            var4.red = true;
                            var1 = var2;
                        }
                    }
                } else {
                    if (var3 != null && var3.red) {
                        var3.red = false;
                        var2.red = true;
                        var0 = rotateRight(var0, var2);
                        var3 = (var2 = var1.parent) == null ? null : var2.left;
                    }

                    if (var3 == null) {
                        var1 = var2;
                    } else {
                        var5 = var3.left;
                        var6 = var3.right;
                        if ((var5 == null || !var5.red) && (var6 == null || !var6.red)) {
                            var3.red = true;
                            var1 = var2;
                        } else {
                            if (var5 == null || !var5.red) {
                                if (var6 != null) {
                                    var6.red = false;
                                }

                                var3.red = true;
                                var0 = rotateLeft(var0, var3);
                                var3 = (var2 = var1.parent) == null ? null : var2.left;
                            }

                            if (var3 != null) {
                                var3.red = var2 == null ? false : var2.red;
                                if ((var5 = var3.left) != null) {
                                    var5.red = false;
                                }
                            }

                            if (var2 != null) {
                                var2.red = false;
                                var0 = rotateRight(var0, var2);
                            }

                            var1 = var0;
                        }
                    }
                }
            }

            return var0;
        }

        static <K, V> boolean checkInvariants(TreeNode<K, V> var0) {
            TreeNode var1 = var0.parent;
            TreeNode var2 = var0.left;
            TreeNode var3 = var0.right;
            TreeNode var4 = var0.prev;
            TreeNode var5 = (TreeNode)var0.nextNode;
            if (var4 != null && var4.nextNode != var0) {
                return false;
            } else if (var5 != null && var5.prev != var0) {
                return false;
            } else if (var1 != null && var0 != var1.left && var0 != var1.right) {
                return false;
            } else if (var2 != null && (var2.parent != var0 || var2.hashValue > var0.hashValue)) {
                return false;
            } else if (var3 == null || var3.parent == var0 && var3.hashValue >= var0.hashValue) {
                if (var0.red && var2 != null && var2.red && var3 != null && var3.red) {
                    return false;
                } else if (var2 != null && !checkInvariants(var2)) {
                    return false;
                } else {
                    return var3 == null || checkInvariants(var3);
                }
            } else {
                return false;
            }
        }
    }
    static Class<?> comparableClassFor(Object var0) {
        if (var0 instanceof Comparable) {
            Class var1;
            if ((var1 = var0.getClass()) == String.class) {
                return var1;
            }

            Type[] var2;
            if ((var2 = var1.getGenericInterfaces()) != null) {
                for(int var6 = 0; var6 < var2.length; ++var6) {
                    Type[] var3;
                    Type var4;
                    ParameterizedType var5;
                    if ((var4 = var2[var6]) instanceof ParameterizedType && (var5 = (ParameterizedType)var4).getRawType() == Comparable.class && (var3 = var5.getActualTypeArguments()) != null && var3.length == 1 && var3[0] == var1) {
                        return var1;
                    }
                }
            }
        }

        return null;
    }

    static int compareComparables(Class<?> var0, Object var1, Object var2) {
        return var2 != null && var2.getClass() == var0 ? ((Comparable)var1).compareTo(var2) : 0;
    }

    Node<K, V> replacementNode(Node<K, V> var1, Node<K, V> var2) {
        return new Node(var1.hashValue, var1.key, var1.value, var2);
    }

    TreeNode<K, V> newTreeNode(int var1, K var2, V var3, Node<K, V> var4) {
        return new TreeNode(var1, var2, var3, var4);
    }
}
