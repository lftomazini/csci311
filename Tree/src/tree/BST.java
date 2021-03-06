// BST.java: a partial implementation of a BST.
// DO NOT CHANGE any completed methods.  Complete the methods with comments
// indicating that they are not complete.  BE SURE TO INCLUDE A RUNNING TIME
// FOR EACH METHOD YOU COMPLETE.

public class BST<T extends Comparable> {

    private T key;
    private boolean isEmpty;
    private BST<T> left;
    private BST<T> right;

    public BST() {
        isEmpty = true;
    }

    /**
     * *******************************************************
     *                                                        *
     * Precondition: None. * Postcondition: None. * Returns: true if and only if
     * T is an empty tree * *
     * *******************************************************
     */
    // DO NOT CHANGE THIS METHOD
    public boolean IsEmpty() {
        return isEmpty;
    }

    /**
     * *********************************************************************
     *                                                                      *
     * Precondition: The tree is a Binary Search Tree * Postconditions: inData
     * is inserted into the tree, which remains a * Binary Search Tree * *
     * *********************************************************************
     */
    // DO NOT CHANGE THIS METHOD
    public void Insert(T inData) {
        if (IsEmpty()) {
            left = new BST<T>();
            right = new BST<T>();
            key = inData;
            isEmpty = false;
        } else if (inData.compareTo(key) < 0) {
            left.Insert(inData);
        } else {
            right.Insert(inData);
        }
    }

    /**
     * **********************************************************
     *							        *
     * Method: Lookup	* Precondition: none	* Postcondition: none	* Returns: true
     * if tree has a node containing inData * false otherwise	* *
     * **********************************************************
     */
    // DO NOT CHANGE THIS METHOD
    public boolean Lookup(T inData) {
        if (IsEmpty()) {
            return false;
        } else if (inData.equals(key)) {
            return true;
        } else if (inData.compareTo(key) < 0) {
            return left.Lookup(inData);
        } else {
            return right.Lookup(inData);
        }
    }

    // COMPLETE THE METHODS BELOW:
    /**
     * ***************************************************
     *						         *
     * Method: FindMin	* Precondition: none	* Postcondition: none	* Returns: a
     * reference to the minimum value * in the BST or null if the BST is * is
     * empty. * RUNNING TIME: O(lg n)*
     * ***************************************************
     */
    // COMPLETE THIS METHOD
    public T FindMin() {
        if (this.key != null) {
            if (this.left.isEmpty) {
                return this.key;
            } else {
                return this.left.FindMin();
            }
        } else {
            return null;
        }
    }

    /**
     * **************************************************************
     *							            *
     * Method: Remove	* Purpose: remove a node containing inData from the tree *
     * Precondition: tree is a Binary Search Tree * Postcondition: node
     * containing inData is removed IF inData * was in the tree * RUNNING
     * TIME:O(lg n) *
     * **************************************************************
     */
    // COMPLETE THIS METHOD
    public void Remove(T inData) {
        if (!this.isEmpty) {
            if (inData.equals(key)) {
                if (this.left.isEmpty && this.right.isEmpty) {
                    this.isEmpty = true;
                } else if (this.left.isEmpty && !this.right.isEmpty) {
                    this.key = this.right.key;
                    this.left = this.right.left;
                    this.right = this.right.right;
                } else if (!this.left.isEmpty && this.right.isEmpty) {
                    this.key = this.left.key;
                    this.right = this.left.right;
                    this.left = this.left.left;
                } else if (!this.left.isEmpty && !(this.right.isEmpty)) {
                    T min = this.right.FindMin();
                    this.right.Remove(min);
                    this.key = min;
                } else {
                    System.out.println("Error");
                }
            } else if (inData.compareTo(this.key) < 0) {
                this.left.Remove(inData);
            } else {
                this.right.Remove(inData);
            }
        }
    }

    /**
     * **************************************************************
     *				                                    *
     * Method: Print	* Purpose: print the entries in the BST in alphabetical *
     * order * Precondition: none * Postcondition: the entries of the BST are
     * printed, one to a * line, in alphabetical	order * RUNNING TIME: O(n)*
     * **************************************************************
     */
// COMPLETE THIS METHOD
    public void Print() {
        if (this.isEmpty) {
            return;
        } else {
            this.left.Print();
            System.out.println(this.key);
            this.right.Print();
        }
    }
}
