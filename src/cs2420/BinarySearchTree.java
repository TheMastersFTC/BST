package cs2420;

import java.util.ArrayList;
import java.util.Collection;
import java.util.NoSuchElementException;

/**
 * @author chloe Josien, Kylee Fluckiger
 * @date 2/27/2017
 *
 */
public class BinarySearchTree<Type extends Comparable<Type>> implements SortedSet<Type> {

    //fields
    public Node<Type> root;
    public int size;

    /**
     * constructs a BinarySearchTree
     */
    public BinarySearchTree() {

        this.root = null;
        this.size = 0;

    }

    /**
     * Adds an item to the tree if it is not already contained
     *
     * @param item
     *          - the item whose presence is ensured in this set
     * @return true if this set changed as a result of this method call (that is,
     *         if the input item was actually inserted); otherwise, returns false
     * @throws NullPointerException
     *           if the item is null
     */
    @Override
    public boolean add(Type item) {

        if (item == null)
            throw new NullPointerException();

        //If the list is empty:
        if (root == null) {

            Node<Type> newNode = new Node<>(item);

            root = newNode;

            size++;

        }

        if (root.contains(item))
            return false;

        root.insert(item);

        size++;

        return true;

    }

    /**
     * adds all the values in the collection if not already contained
     *
     * @param items
     *          - the collection of items whose presence is ensured in this set
     * @return true if this set changed as a result of this method call (that is,
     *         if any item in the input collection was actually inserted);
     *         otherwise, returns false
     * @throws NullPointerException
     *           if any of the items is null
     */
    @Override
    public boolean addAll(Collection<? extends Type> items) {

        for (Type current : items) {

            if (root == null) {

                root = new Node<>(current);
                size++;

            }

            else if (!root.contains(current)) {

                root.insert(current);
                size++;

            }

        }

        return true;

    }

    /**
     * clears the tree
     */
    @Override
    public void clear() {

        root = null;
        size = 0;

    }

    /**
     * checks if the given item is contained in the tree
     *
     * @param item
     *          - the item sought in this set
     * @return true if there is an item in this set that is equal to the input
     *         item; otherwise, returns false
     * @throws NullPointerException
     *           if the item is null
     */
    @Override
    public boolean contains(Type item) {

        if(root==null)
            return false;

        if(item == null)
            throw new NullPointerException();

        return root.contains(item);

    }

    /**
     * checks to see if each item in the collection is contained in the tree
     *
     * @param items
     *          - the collection of items sought in this set
     * @return true if for each item in the specified collection, there is an item
     *         in this set that is equal to it; otherwise, returns false
     * @throws NullPointerException
     *           if any of the items is null
     */
    @Override
    public boolean containsAll(Collection<? extends Type> items) {

        if (items.isEmpty())
            throw new NoSuchElementException();

        for (Type current : items) {

            if (current == null)
                throw new NoSuchElementException();

            if (root.contains(current) == false)
                return false;

        }

        return true;

    }

    /**
     * Finds the first/ smallest element in the tree
     * 
     * @return the smallest element in the tree
     * 
     * @throws NoSuchElementException if the item doesn't exist
     */
    @Override
    public Type first() throws NoSuchElementException {

        if (root == null)
            throw new NoSuchElementException();

        Node<Type> current = root;

        while (current.left != null) {

            current = current.left;

        }

        return current.data;

    }

    /**
     * checks if the tree is empty
     * 
     * @return true if the tree is empty else returns false
     */
    @Override
    public boolean isEmpty() {

        if (root == null)
            return true;

        return false;

    }

    /**
     * Finds the last/biggest element in the tree
     *
     * @return the biggest element in the tree
     *
     * @throws NoSuchElementException if the item doesn't exist
     */
    @Override
    public Type last() throws NoSuchElementException {

        if (root == null)
            throw new NoSuchElementException();

        Node<Type> current = root;

        while (current.right != null) {
            current = current.right;
        }
        return current.data;
    }

    // FIXME: Write comment for this when written
    @Override
    public boolean remove(Type item) {

        if(root==null)
            return false;

        if (root.contains(item)==false)
            return false;
        
        size--;
        return true;

    }

    //FIXME: Write comment for this when written
    @Override
    public boolean removeAll(Collection<? extends Type> items) {

        int beforeSize = size;

        for (Type current : items) {

            remove(current);

        }

        if (beforeSize == size)
            return false;

        return true;

    }

    /**
     * Returns the number of items in this set.
     */
    @Override
    public int size() {

        return size;

    }

    /**
     * Returns an ArrayList containing all of the items in this set, in sorted
     * order.
     */
    @Override
    public ArrayList<Type> toArrayList() {

        ArrayList<Type> list = new ArrayList<>();

        if(root==null)
            return list;

        return toArrayListHelper(root, list);

    }

    /**
     * recursively traverses the tree to add item to the arrayList in sorted order
     * 
     * @param element - the node you want to start from
     * @param list - the list to add values too
     * @return a sorted ArrayList
     */
    public ArrayList<Type> toArrayListHelper(Node<Type> element, ArrayList<Type> list){

        if(element.left!=null){
            toArrayListHelper(element.left,list);
        }

        list.add(element.data);

        if(element.right!=null) {
            toArrayListHelper(element.right, list);
        }

        return list;

    }


    /**
     * builds a node with certain properties
     * 
     */
    protected static class Node<Type extends Comparable<Type>> {

        protected Type data;

        protected Node<Type> left;
        protected Node<Type> right;

        public Node(Type the_data) {

            this.data = the_data;
            this.left = null;
            this.right = null;


        }

        /**
         * This function must be written recursively.
         * <p>
         * Height is defined as the 1 plus the maximum height of the left vs right sub tree
         *
         * @return the height from this node to its leaves
         */
        public int height() {

            if (this.left == null || this.right == null)
                return 1;

            int leftDepth = this.left.height();
            int rightDepth = this.right.height();

            if (leftDepth > rightDepth)
                return leftDepth;

            else {

                return rightDepth;

            }

        }

        /**
         * recursive determine if the item is in this node or the nodes after
         *
         * @param item - needle
         * @return true if item in tree
         */
        public boolean contains(Type item) {

            if (this.data.equals(item))
                return true;

            if (this.data.compareTo(item) > 0 && this.left != null) {

                return this.left.contains(item);

            } else if (this.data.compareTo(item) < 0 && this.right != null){

                return this.right.contains(item);

            }

            return false;

        }

        /**
         * recursive - add a node
         *
         * @param item - data to add
         * @return
         */
        public void insert(Type item) {

            Node<Type> newNode = new Node<>(item);

            //To traverse through the left side:
            if (this.data.compareTo(item) > 0) {

                //If you have reached the end of the branch:
                if (this.left == null) {

                    this.left = newNode;

                } else {

                    this.left.insert(item);
                }
            }

            //To traverse through the right side:
            else if (this.data.compareTo(item) < 0) {

                //If you have reached the end of the branch:
                if (this.right == null) {

                    this.right = newNode;

                } else {
                    this.right.insert(item);
                }
            }
        }
    }

}
