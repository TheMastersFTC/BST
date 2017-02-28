package cs2420;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.NoSuchElementException;

/**
 * Created by chloe on 2/25/2017.
 */
public class BinarySearchTree<Type extends Comparable<Type>> implements SortedSet<Type> {


    public Node<Type> root;
    public int size;


    public BinarySearchTree() {

        this.root = null;
        this.size = 0;

    }

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
     * Ensures that this set contains all items in the specified collection.
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

            if (root == null)
                root = new Node<>(current);

            else if (root.contains(current))
                return false;

            else {

                root.insert(current);

            }

        }

        return true;

    }

    @Override
    public void clear() {

        root = null;
        size = 0;

    }

    @Override
    public boolean contains(Type item) {

        if (item == null)
            throw new NullPointerException();

        return root.contains(item);

    }

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

    @Override
    public boolean isEmpty() {

        if (root == null)
            return true;

        return false;

    }

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

    /**
     * Ensures that this set does not contain the specified item.
     *
     * @param item
     *          - the item whose absence is ensured in this set
     * @return true if this set changed as a result of this method call (that is,
     *         if the input item was actually removed); otherwise, returns false
     * @throws NullPointerException
     *           if the item is null
     */
    @Override
    public boolean remove(Type item) {

        if (root.contains(item)==false) {
            return false;
        }
        size--;
        return true;

    }

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

        ArrayList list = new ArrayList();

        return toArrayListHelper(root, list);
    }

    public ArrayList<Type> toArrayListHelper(Node element, ArrayList list){

//        if(element.left==null){
//            list.add(element.data);
//            return list;
//        }
//
//        toArrayListHelper(element.left,list);

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
     * <p>
     * Pictorially, a node is:
     * <p>
     * left data  right
     * ---------------
     * <--+   |  5  |  +--->
     * ---------------
     * <p>
     * Note, while a 5 is used above any "Type" could be contained in the node
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
//            if(this.left==null){
//                return right.height()+1;
//            }else if(this.right==null){
//                return left.height()+1;
//            }
//            return  Math.max(left.height(),right.height())+1;

        }

        /**
         * recursive determine if the item is in this node or the nodes after
         *
         * @param item - needle
         * @return true if item in tree
         */
        public boolean contains(Type item) {

            if (this.data == item)
                return true;

            if (this.data.compareTo(item) > 0) {

                if (this.left == null)
                    return false;

                return this.left.contains(item);

            } else {

                if (this.right == null)
                    return false;

                return this.right.contains(item);

            }

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
                    return;

                } else {

                    this.left.insert(item);
                }
            }

            //To traverse through the right side:
            else if (this.data.compareTo(item) < 0) {

                //If you have reached the end of the branch:
                if (this.right == null) {

                    this.right = newNode;
                    return;
                } else {
                    this.right.insert(item);
                }
            }
        }
    }
}
