package cs2420;

import java.util.ArrayList;
import java.util.Collection;
import java.util.NoSuchElementException;

/**
 * Created by chloe on 2/25/2017.
 */
public class BinarySearchTree <Type extends Comparable<Type>>implements SortedSet<Type>{


    public Node<Type> root;
    public int size;


    public BinarySearchTree () {

        this.root = null;
        this.size = 0;

    }

    @Override
    public boolean add(Type item) {

        if(item == null)
            throw new NullPointerException();

        //If the list is empty:
        if(root == null) {

            Node<Type> newNode = new Node<>(item);

            root = newNode;

            size++;

        }

        if(root.contains(item))
            return false;

        root.insert(item);

        size++;

        return true;

    }

    @Override
    public boolean addAll(Collection<? extends Type> items) {

        int beforeSize = size;

        for(Type current : items) {
            if(root==null){
                this.add(current);
            }
            else if(root.contains(current)==false) {
                this.add(current);
            }
        }

        if(beforeSize == size)
            return false;

        return true;

    }

    @Override
    public void clear() {

        root = null;
        size = 0;

    }

    @Override
    public boolean contains(Type item) {

        if(item == null)
            throw new NullPointerException();

        return root.contains(item);

    }

    @Override
    public boolean containsAll(Collection<? extends Type> items) {

        for(Type current : items) {

            if(root.contains(current) == false)
                return false;

        }

        return true;

    }

    @Override
    public Type first() throws NoSuchElementException {

        if(root == null)
            throw new NoSuchElementException();

        Node<Type> current = root;

        while(current.left != null) {

            current = current.left;

        }

        return current.data;

    }

    @Override
    public boolean isEmpty() {

        if(root == null)
            return true;

        return false;

    }

    @Override
    public Type last() throws NoSuchElementException {

        if(root == null)
            throw new NoSuchElementException();

        Node<Type> current = root;

        while(current.right != null) {

            current = current.right;

        }

        return current.data;

    }

    @Override
    public boolean remove(Type item) {

        size--;
        return false;

    }

    @Override
    public boolean removeAll(Collection<? extends Type> items) {

        int beforeSize = size;

        for(Type current : items) {

            remove(current);

        }

        if(beforeSize == size)
            return false;

        return true;

    }

    @Override
    public int size() {

        return size;

    }

    @Override
    public ArrayList<Type> toArrayList() {

        ArrayList<Type> list = new ArrayList<>();

        Node<Type> current = root;

        //Add the left side:
        while(current.left != null) {



        }

        list.add(root.data);

        current = root;

        while(current.right != null) {

            list.add(current.data);

            current = current.right;

        }

        return list;

    }


    /**
     * FIXME: comments
     *
     * Pictorially, a node is:
     *
     *       left data  right
     *       ---------------
     *     <--+   |  5  |  +--->
     *       ---------------
     *
     *  Note, while a 5 is used above any "Type" could be contained in the node
     */
    protected static class Node<Type extends Comparable<Type>> {

        protected Type data;

        protected Node<Type> left;
        protected Node<Type> right;

        public Node( Type the_data ) {

            this.data = the_data;
            this.left = null;
            this.right = null;


        }

        /**
         *
         * This function must be written recursively.
         *
         * Height is defined as the 1 plus the maximum height of the left vs right sub tree
         *
         * @return the height from this node to its leaves
         *
         */
        public int height() {

            if(this.left == null || this.right == null)
                return 1;

            int leftDepth = this.left.height();
            int rightDepth = this.right.height();

            if(leftDepth > rightDepth)
                return leftDepth;

            else {

                return rightDepth;

            }

        }

        /**
         * recursive determine if the item is in this node or the nodes after
         *
         * @param item
         *            - needle
         * @return true if item in tree
         */
        public boolean contains( Type item ){

            if(this.data == item)
                return true;

            if(this.data.compareTo(item) > 0) {

                if(this.left == null)
                    return false;

                return this.left.contains(item);

            }

            else {

                if(this.right == null)
                    return false;

                return this.right.contains(item);

            }

        }

        /**
         * recursive - add a node
         *
         * @param item
         *            - data to add
         * @return
         */
        public void insert( Type item ) {

            Node<Type> newNode = new Node<>(item);

            //To traverse through the left side:
            if(this.data.compareTo(item) > 0) {

                //If you have reached the end of the branch:
                if(this.left == null) {

                    this.left = newNode;
                    return;

                }
                
                else {

                	this.left.insert(item);
                	
                }

            }

            //To traverse through the right side:
            else if(this.data.compareTo(item) < 0) {

                //If you have reached the end of the branch:
                if(this.right == null) {

                    this.right = newNode;
                    return;

                }

                else {
                	
                	this.right.insert(item);
                
                }

            }

        }


    }


}
