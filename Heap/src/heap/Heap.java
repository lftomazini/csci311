/**
 * An implementation of a minimum heap with handles
 */
package heap;

public class Heap {

    private HeapElt[] array;
    int heapsize;
    int arraysize;

    /*
     The constructor has been set up with an initial array of size 4
     so that your doubleHeap() method will be tested.  Don't change
     this!
     */
    public Heap() {
        array = new HeapElt[4];
        heapsize = 0;
        arraysize = 4;
    }

    /*
     Exchanges that values at positions pos1 and pos2 in the heap array.
     Handles must be exchanged correctly as well.

     Running time = O(1)
     */
    private void exchange(int pos1, int pos2) {
        HeapElt aux = new HeapElt();
        aux = this.array[pos1];
        aux.setHandle(pos1);

        this.array[pos1] = array[pos2];
        this.array[pos1].setHandle(pos1);

        this.array[pos2] = aux;
        this.array[pos2].setHandle(pos2);
    }

    /*
     Doubles the size of the array.  A new array is created, the elements in
     the heap are copied to the new array, and the array data member is set
     to the new array.  Data member arraysize is set to the size of the
     new array.

     Running time = O(n)
     */
    private void doubleHeap() {
        HeapElt[] aux = new HeapElt[2 * this.array.length];

        for (int i = 0; i < this.array.length; i++) {
            aux[i] = this.array[i];
        }

        this.arraysize = aux.length;
        this.array = aux;
    }

    /*
     Fixes the heap if the value at position pos may be smaller than its
     parent.  Using exchange() to swap elements will simplify your
     implementation.  Heap elements contain records that are Comparable;
     you will need to figure out what to test and how to test it.

     Running time = O(lg n)
     */
    public void heapifyUp(int pos) {
        while (pos > 1 && this.array[parent(pos)].getRecord().compareTo(
                this.array[pos].getRecord()) > 0) {
            this.exchange(pos, parent(pos));
            pos = parent(pos);
        }
    }

    /*
     Fixes the heap if the value at position pos may be bigger than one of
     its children.  Using exchange() to swap elements will simplify your
     implementation.  Heap elements contain records that are Comparable;
     you will need to figure out what to test and how to test it.

     Running time = O(lg n)
     */
    public void heapifyDown(int pos) {
        int left = left(pos);
        int right = right(pos);
        int smallest;

        if (left <= this.heapsize && this.array[left].getRecord().compareTo(
                this.array[pos].getRecord()) < 0) {
            smallest = left;
        } else {
            smallest = pos;
        }

        if (right <= this.heapsize && this.array[right].getRecord().compareTo(
                this.array[smallest].getRecord()) < 0) {
            smallest = right;
        }

        if (smallest != pos) {
            exchange(pos, smallest);
            heapifyDown(smallest);
        }
    }

    /*
     Insert inElt into the heap.  Before doing so, make sure that there is
     an open spot in the array for doing so.  If you need more space, call
     doubleHeap() before doing the insertion.

     Running time = O(lg n) (NOTE if heap is doubled Running time = O(n lg n)
     */
    public void insert(HeapElt inElt) {
        if (this.heapsize >= this.arraysize - 1) {
            this.doubleHeap();
        }

        this.heapsize++;
        this.array[this.heapsize] = inElt;
        this.array[this.heapsize].setHandle(this.heapsize);
        heapifyUp(this.heapsize);
    }

    /*
     Remove the minimum element from the heap and return it.  Restore
     the heap to heap order.  Assumes heap is not empty, and will
     cause an exception if the heap is empty.

     Running time = O(lg n)
     */
    public HeapElt removeMin() throws Exception {
        // WARNING: Will fail with empty heap!
        if (heapsize <= 0) {
            throw new Exception("Empty heap");
        }

        exchange(this.heapsize, 1);
        this.heapsize--;
        heapifyDown(1);

        return this.array[this.heapsize + 1];
    }

    /*
     Return the number of elements in the heap..

     Running time = O(1)
     */
    public int getHeapsize() {
        return this.heapsize;
    }

    /*
     Print out the heap for debugging purposes.  It is recommended to
     print both the key from the record and the handle.

     Running time = O(n)
     */
    public void printHeap() {
        for (int i = 1; i <= heapsize; i++) {
            System.out.println(
                    "Element with the value " + this.array[i].record + " with handele " + this.array[i].getHandle());
        }
    }

    /*
     Returns the index of the parent of an element

     Running time = O(1)
     */
    private int parent(int pos) {
        return (pos / 2);
    }

    /*
     Returns the index of the left child of an element

     Running time = O(1)
     */
    private int left(int pos) {
        return (2 * pos);
    }

    /*
     Returns the index of the right child of an element

     Running time = O(1)
     */
    private int right(int pos) {
        return (2 * pos + 1);
    }

}
