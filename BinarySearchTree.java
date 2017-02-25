package cs2420;

import java.util.ArrayList;
import java.util.Collection;
import java.util.NoSuchElementException;

/**
 * Created by chloe on 2/25/2017.
 */
public class BinarySearchTree <Type extends Comparable<Type>>implements SortedSet<Type>{


    public Node root;

    public BinarySearchTree () {

        this.root = null;

    }

    @Override
    public boolean add(Type item) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends Type> items) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public boolean contains(Type item) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<? extends Type> items) {
        return false;
    }

    @Override
    public Type first() throws NoSuchElementException {
        return null;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public Type last() throws NoSuchElementException {
        return null;
    }

    @Override
    public boolean remove(Type item) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<? extends Type> items) {
        return false;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public ArrayList<Type> toArrayList() {
        return null;
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
    protected static class Node<Type>
    {
        //FIXME: create a data element of the Given Type
        //FIXME: create a left and right reference to other nodes

        //FIXME: write a constructor that simplifies building an initial node
        public Node( Type the_data ){

        }

        /**
         *
         * This function must be written recursively.
         *
         * Height is defined as the 1 plus the maximum height of the left vs right sub tree
         *
         * @return the height from this node to its leaves
         *
         *
         */
        public int height(){
            return 0;
        }

        /**
         * recursive determine if the item is in this node or the nodes after
         *
         * @param item
         *            - needle
         * @return true if item in tree
         */
        public boolean contains( Type item ){
            return true;
        }

        /**
         * recursive - add a node
         *
         * @param item
         *            - data to add
         * @return
         */
        public void insert( Type item ){

        }


    }
}
