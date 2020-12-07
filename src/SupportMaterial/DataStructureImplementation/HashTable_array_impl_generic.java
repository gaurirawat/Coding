package SupportMaterial.DataStructureImplementation;
/*
https://www.geeksforgeeks.org/implementing-our-own-hash-table-with-separate-chaining-in-java/
http://www.kaushikbaruah.com/posts/java-hashmap/
https://dzone.com/articles/custom-hashmap-implementation-in-java

Assume keys are generic and use equals for comparison and hashcode to generate hashcode.
Implementations:

                    search(WC)  insert(WC)  search(AC)  insert(AC)  orderedIteration    key interface

sequential search
unordered list.         n           n           n/2         n           no                  equals()

binary search
ordered array           logn        n           logn        n/2         yes                 compareTo()

bst                     n           n          logn         logn        yes                 compareTo()

balanced bst            logn        logn       logn         logn        yes                 compareTo()

hashing with
separate chaining       logn        logn       3-5         3-5          mo                  equals()

hashing with linear
probing where m=n/5     logn        logn       3-5         3-5          mo                  equals()

insert is costly in ordered array since elements need to be shifted
For hashing with separate chaining if there are n elements, m buckets, then typically m=n/5;

HashTable:
public V get(K k) : returns the value corresponding to the key if the key is present in HT (Hash Table)
public void put(K k, V v) : adds new valid key, value pair to the HT, if already present updates the value
public V delete(K k) : removes the key, value pair
public boolean isEmpty(): returns true if size is zero
public int size(): returns size

all java classes inherit hashcode which returns a 32 bit int.
hashcode of int is the value itself, for double xors the decimal & fractional bits
Since string are immutable the hashcode is cached as a property/instance variable for string. calculated just once.
imp: hashcode is any value btw Integer.MAX_VALUE and Integer.MIN_VALUE. On taking the abs we can get a bug when original
value was=Integer.MIN_VALUE. Hence value= element.hashCode() &0x7fffffff

for hashtable implementation using linear probing, it is essential that the array> no of elements otherwise there can be
huge clusters when the array is almost full. Array resizing is also essential here.

Kruth's parking problem:
he has proven that if array is < half full and n elements have to be inserted then on an average they will find a place
after 3/2 clusters.
*/

public class HashTable_array_impl_generic<K,V> {
    class Node{
        K key;
        V value;
        Node next;
        private Node(K key,V value, Node next){
            this.key = key;
            this.value = value;
            this.next=next;
        }
    }

    Node[] arr;
    int size;


    public HashTable_array_impl_generic(int size) {
        arr= (Node[])new Object[size];
    }

    public HashTable_array_impl_generic() {
        arr= (Node[])new Object[10000000];
    }

    public boolean isEmpty() {
        return size==0;
    }

    public int size() {
        return size;
    }

    /*
    imp: hashcode is any value btw Integer.MAX_VALUE and Integer.MIN_VALUE. On taking the abs we can get a bug when
    original value was=Integer.MIN_VALUE. Hence k.hashCode() &0x7fffffff
     */
    public int getBucketIndex(K k) {
        return (k.hashCode() &0x7fffffff)%arr.length;
    }
    public void put(K k, V v) {
        int bucket=getBucketIndex(k);
        for(Node node=arr[bucket];node!=null;node=node.next) {
            if(node.key.equals(k)) {
                node.value=v;
                return;
            }
        }
        arr[bucket]=new Node(k,v,arr[bucket]);
        ++size;
    }

    public V delete(K k) {
        int bucket=getBucketIndex(k);
        Node node=arr[bucket];
        V delValue=null;
        if(node==null) {
            ;
        } else if(node.key.equals(k)) {
            delValue=node.value;
            arr[bucket]=node.next;
            --size;
        }
        else {
            while(node.next!=null && !node.next.key.equals(k)) {
                node=node.next;
            }
            if(node.next!=null && node.next.key.equals(k)) {
                delValue=node.next.value;
                node.next=node.next.next;
                --size;
            }
        }
        return delValue;
    }

    public V get(K k) {
        int bucket=getBucketIndex(k);
        Node node=arr[bucket];
        V getValue= null;
        while(node!=null && !node.key.equals(k)) {
            node=node.next;
        }
        if(node!=null) {
            getValue=node.value;
        }
        return getValue;
    }

}
