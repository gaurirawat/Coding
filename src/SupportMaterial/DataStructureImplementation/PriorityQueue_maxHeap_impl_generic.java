package SupportMaterial.DataStructureImplementation;
/*
https://opendsa-server.cs.vt.edu/ODSA/Books/Everything/html/Heaps.html#:~:text=A%20max%20heap%20has%20the,all%20values%20in%20the%20tree.
https://www.geeksforgeeks.org/priority-queue-using-binary-heap/

                    insert  delete  max
unordered array     1       n       n
ordered array       n       1       1
heap                logn    logn    1
The expected number of array accesses and compares, respectively, to insert a random key into an ordered-array
implementation of a priority queue:linear(for shifting elements) and logarithmic(search using binary search).

NOTE: ROOT IS AT INDEX 1.
min element is at index-1.
parent of k is at k/2;
child of  k are at 2k,2k+1.

Operation on Binary Heap
PriorityQueue_maxHeap_impl_generic(int cap)
public int size()
public int max()
public int deleteMax()
public void insert(T t)
public void swim(int k)
public void sink(int k)
public void swap(int a, int b)
public void less(int a, int b)
public boolean updateElement(int i, T newT)

 */
public class PriorityQueue_maxHeap_impl_generic<T extends Comparable<T>> {
    private T[] arr;
    private int size=-1;

    public PriorityQueue_maxHeap_impl_generic(int cap) {
        arr=(T[])new Comparable[cap+1];
        size=0;
    }

    public int size() {
        return size;
    }

    public T max() {
        return arr[1];
    }

    public T deleteMax() {
        if(size==0) {
            return null;
        } else if(size==0) {
            return arr[size--];
        }
        T t=arr[1];
        arr[1] = arr[size];
        arr[size]=null;
        size--;
        sink(1);
        return t;
    }

    public boolean insert(T t) {
        if(size+1==arr.length) {
            return false;
        }
        arr[++size] = t;
        swim(size);
        return true;
    }

    public boolean updateElement(int i, T newT){
        if(i>size) {
            return false;
        }
        T oldT=arr[i];
        arr[i]=newT;
        if(less(oldT,newT)) {
            swim(i);
        }
        else {
            sink(i);
        }
        return true;
    }

    public void swim(int k) {
        if(k>1 && less(arr[k/2], arr[k])) {
            swap(k,k/2);
            swim(k/2);
        }
    }

    public void sink(int k) {
        int child=2*k;
        if(child<=size) {
            int maxChild=child;
            if(child+1<=size && less(arr[child],arr[child+1])) {
                maxChild++;
            }
            if(less(arr[k],arr[maxChild])) {
                swap(maxChild,k);
                sink(maxChild);
            }
        }
    }

    public void swap(int a, int b) {
        T t=arr[a];
        arr[a]=arr[b];
        arr[b]=t;
    }

    public boolean less(T a, T b){
        return a.compareTo(b)<0;
    }
}
