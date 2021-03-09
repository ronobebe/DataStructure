package Algorithms.RoughDraft.Hashing;

import java.util.Map;

public class LinkedHashMap<K,V> extends  HashMapPractice1<K,V> implements Map<K,V> {
    transient Entry<K, V> head;
    transient Entry<K, V> tail;
    // final boolean accessOrder;


    Node<K, V> newNode(int var1, K var2, V var3, Node<K, V> var4) {
        Entry var5 = new Entry(var1, var2, var3, var4);
        this.linkNodeLast(var5);
        return var5;
    }

    Node<K, V> replacementNode(Node<K, V> var1, Node<K, V> var2) {
        Entry var3 = (Entry)var1;
        Entry var4 = new Entry(var3.hashValue, var3.key, var3.value, var2);
        this.transferLinks(var3, var4);
        return var4;
    }




    private void transferLinks(Entry<K, V> var1, Entry<K, V> var2) {
        Entry var3 = var2.before = var1.before;
        Entry var4 = var2.after = var1.after;
        if (var3 == null) {
            this.head = var2;
        } else {
            var3.after = var2;
        }

        if (var4 == null) {
            this.tail = var2;
        } else {
            var4.before = var2;
        }

    }

    TreeNode<K, V> newTreeNode(int var1, K var2, V var3, Node<K, V> var4) {
        TreeNode var5 = new TreeNode(var1, var2, var3, var4);
        this.linkNodeLast(var5);
        return var5;
    }
    private void linkNodeLast(Entry<K, V> var1) {
        Entry var2 = this.tail;
        this.tail = var1;
        if (var2 == null) {
            this.head = var1;
        } else {
            var1.before = var2;
            var2.after = var1;
        }

    }
    static class Entry<K, V> extends Node<K, V> {
        Entry<K, V> before;
        Entry<K, V> after;

        Entry(int var1, K var2, V var3, Node<K, V> var4) {
            super(var1, var2, var3, var4);
        }
    }
}
