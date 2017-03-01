package cs2420;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.NoSuchElementException;

/**
 * The generic BinarySearchTree class extends the generic SortedSet interface.
 * It provides functionality as a basic, unbalanced binary search tree ADT.
 * The generic inner Node class provides the structure for the discrete nodes
 * within the binary search tree.
 * 
 * Functionality includes add(), contains(), clear(), and toArrayList(),
 * with additional functionality for these functions in regards to
 * collections.
 *
 * @author Chloe Josien, Kylee Fluckiger, germain
 * @date 2/27/2017
 */
public class BinarySearchTree<Type extends Comparable<Type>> implements SortedSet<Type> {


    /**
     * This field stores the first Node of the BST.
     */
    public Node<Type> root;

    /**
     * This field stores the number of the elements
     * in the BST.
     */
    public int size;

    /**
     * This constructor creates a BST of size 0 and sets
     * the root to null.
     */
    public BinarySearchTree() {

        this.root = null;
        this.size = 0;
    }

    /**
     * This function adds an item to the tree if it is not already contained.
     *
     * @param item - the item whose presence is ensured in this set
     * @return true if this set changed as a result of this method call (that is,
     * if the input item was actually inserted); otherwise, returns false
     * @throws NullPointerException if the item is null
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

        //Do not add if the item is already in the BST.
        if (root.contains(item)) {
            return false;
        }

        root.insert(item);
        size++;
        return true;
    }

    /**
     * This function adds all the values in the collection that are not already
     * contained in the BST.
     * 
     * NOTE: All elements in the set that are not already contained in the BST WILL
     * be added; elements that are already present in the set will NOT
     * be added. The function does NOT return if an already present value is encountered.
     *
     * @param items - the collection of items whose presence is ensured in this set
     * @return true if this set changed as a result of this method call (that is,
     * if any item in the input collection was actually inserted);
     * otherwise, returns false
     * @throws NullPointerException if any of the items is null
     */
    @Override
    public boolean addAll(Collection<? extends Type> items) {

        //Iterate through the collection.
        for (Type current : items) {

            if (current == null) {
                throw new NullPointerException();
            }

            //If this is the first element, make it the root.
            if (root == null) {
                root = new Node<>(current);
                size++;
            }

            //Add the element only if it is not already contained in the set.
            else if (!root.contains(current)) {
                root.insert(current);
                size++;
            }
        }
        return true;
    }

    /**
     * This function clears the BST by setting root to null and
     * size to 0.
     */
    @Override
    public void clear() {
        root = null;
        size = 0;
    }

    /**
     * This function checks if the given item is contained in the tree.
     *
     * @param item - the item sought in this set
     * @return true if there is an item in this set that is equal to the input
     * item; otherwise, returns false
     * @throws NullPointerException if the item is null
     */
    @Override
    public boolean contains(Type item) {

        //If the BST is empty, it does not contain the item.
        if (root == null) {
            return false;
        }

        if (item == null) {
            throw new NullPointerException();
        }
        return root.contains(item);
    }

    /**
     * checks to see if each item in the collection is contained in the tree
     *
     * @param items - the collection of items sought in this set
     * @return true if for each item in the specified collection, there is an item
     * in this set that is equal to it; otherwise, returns false
     * @throws NullPointerException if any of the items is null
     */
    @Override
    public boolean containsAll(Collection<? extends Type> items) {

        if (items.isEmpty())
            throw new NoSuchElementException();

        //Iterate through the collection.
        for (Type current : items) {

            if (current == null) {
                throw new NoSuchElementException();
            }

            if (!root.contains(current)) {
                return false;
            }
        }
        return true;
    }

    /**
     * This function finds the first/smallest element in the tree.
     *
     * @return the smallest element in the tree
     * @throws NoSuchElementException if the item doesn't exist
     */
    @Override
    public Type first() throws NoSuchElementException {

        if (root == null){
            throw new NoSuchElementException();
        }

        Node<Type> current = root;

        while (current.left != null){

            current = current.left;
        }
        return current.data;
    }

    /**
     * This function checks if the tree is empty.
     *
     * @return true if the tree is empty, else returns false
     */
    @Override
    public boolean isEmpty() {

        if (root == null) {
            return true;
        }
        return false;
    }

    /**
     * This function finds the last/biggest element in the tree
     *
     * @return the biggest element in the tree
     * @throws NoSuchElementException if the item doesn't exist
     */
    @Override
    public Type last() throws NoSuchElementException {

        //If the BST is empty, there is no "last" value.
        if (root == null) {
            throw new NoSuchElementException();
        }

        Node<Type> current = root;

        //Traverse down to the biggest element.
        while (current.right != null) {
            current = current.right;
        }
        return current.data;
    }

    /**
     * Removes the given item from the tree.
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

        if (root == null) {
            return false;
        }
        
        if(item == null) {
            throw new NullPointerException();
        }

        if (root.contains(item) == false) {
            return false;
        }

        //if we're removing the root
        if (root.data == item) {

            Node<Type> dummy = new Node<Type>(null);

            dummy.left = root;
            dummy.left.delete(item, dummy, true);
            root = dummy.left;
        }

        if (root.data.compareTo(item) > 0) {
            root.delete(item, root, true);
        } else {
            root.delete(item, root, false);
        }
        size--;
        return true;
    }

    /**
     * removes all items in a given set.
     *
     * @param items
     *          - the collection of items whose absence is ensured in this set
     * @return true if this set changed as a result of this method call (that is,
     *         if any item in the input collection was actually removed);
     *         otherwise, returns false
     * @throws NullPointerException
     *           if any of the items is null
     */
    @Override
    public boolean removeAll(Collection<? extends Type> items) {

        int beforeSize = size;

        for (Type current : items) {
            remove(current);
        }

        if (beforeSize == size) {
            return false;
        }
        return true;
    }

    /**
     * This function returns the number of items in this set.
     *
     * @return size, the number of elements in the BST
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * This function returns an ArrayList containing all of the items in
     * this set, in sorted order.
     *
     * @return ArrayList<Type>, the BST's sorted ArrayList representation
     */
    @Override
    public ArrayList<Type> toArrayList() {

        ArrayList<Type> list = new ArrayList<>();

        if (root == null)
            return list;

        //Call the recursive helper function.
        return toArrayListHelper(root, list);
    }

    /**
     * This function recursively traverses the tree to add items to the arrayList
     * in sorted order.
     *
     * @param element - the node you want to start from
     * @param list    - the list to add values too
     * @return a sorted ArrayList
     */
    public ArrayList<Type> toArrayListHelper(Node<Type> element, ArrayList<Type> list) {

        if (element.left != null) {
            toArrayListHelper(element.left, list);
        }

        list.add(element.data);

        if (element.right != null) {
            toArrayListHelper(element.right, list);
        }

        return list;

    }

    /**
     * This function writes data to a file such that it can be
     * opened with Graphviz and show the binary search tree
     * represented by a diagram (so long as the filename specifies
     * a .gv or a .dot file).
     * 
     * @param filename, the String name of the file to be written to
     */
    public void writeDot(String filename) {

        FileWriter file = null;

        try {
            file = new FileWriter(filename);
            file.append("digraph {\n");

            //Call the recursive helper function to fill in the data.
            dotWriterHelper(file, root);

            file.append("}");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        	
            //Close the file
            try {
                file.flush();
                file.close();
            } catch (IOException e) {

            }
        }
    }

    /**
     * This is the recursive helper function for the dotWriter function.
     * It recursively traverses the array, top to bottom, left to right,
     * and stores the .gv representation of each parent and its children in
     * the following format:
     * 
     * 		parent -> leftChild; (if leftChild exists)
     * 		parent -> rightChild; (if rightChild exists)
     * 
     * @param file, the FileWriter that is storing our data in a file
     * @param element, the current Node we are recording
     */
    public void dotWriterHelper(FileWriter file, Node<Type> element) {

        try {
        	
        	//Print a pointer line for the left child if applicable.
            if (element.left != null) {
                file.append(element.data + " -> ");
                file.append(element.left.data + ";\n");
            }

            //Print a pointer line for the right child if applicable.
            if (element.right != null) {
                file.append(element.data + " -> ");
                file.append(element.right.data + ";\n");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        //Recurse down the left branch, if not at the end.
        if (element.left != null) {
            dotWriterHelper(file, element.left);
        }

        //Recurse down the right branch, if not at the end.
        if (element.right != null) {
            dotWriterHelper(file, element.right);
        }
    }

    /**
     * This generic inner Node class provides the discrete functionality
     * for components of the binary search tree.
     * 
     * It holds a Type value and two references to a "left" and "right" Node,
     * whereby the left Node holds a value less than the current value and the
     * right Node holds a value greater than the current value.
     * 
     * This class provides some recursive functionality that allows for the
     * calculation of the BST height, and it also allows for the insertion
     * and searching of Nodes.
     *
     * @author Chloe Josien, Kylee Fluckiger, germain
     * @date 2/27/201
     */
    protected static class Node<Type extends Comparable<Type>> {


        /**
         * This field stores the Type value of the Node.
         */
        protected Type data;

        /**
         * This field stores a reference to the "left" Node,
         * which must hold a value less than the parent's value.
         */
        protected Node<Type> left;

        /**
         * This field stores a reference to the "right" Node,
         * which must hold a value greater than the parent's value.
         */
        protected Node<Type> right;


        /**
         * This constructor for the Node class creates a new Node
         * with the specified value and sets both of its children
         * to null.
         *
         * @param //Type the_data, the value to be stored in the new Node
         */
        public Node(Type the_data) {

            this.data = the_data;
            this.left = null;
            this.right = null;

        }

        /**
         * This recursive function calculates the height of the binary search tree,
         * where height is defined as 1 + the maximum height of either the left
         * or the right sub-tree.
         *
         * @return the height from this node to its leaves
         */
        public int height() {

            //If we reach the end of a branch, return.
            if (this.left == null || this.right == null) {
                return 1;
            }

            //Calculate the height of the left branch.
            int leftDepth = this.left.height();

            //Calculate the height of the right branch.
            int rightDepth = this.right.height();

            //Return the maximum of the two heights.
            if (leftDepth > rightDepth) {
                return leftDepth;
            }
            else {
                return rightDepth;
            }
        }

        /**
         * This recursive function determines if the specified value is present
         * in the binary search tree.
         *
         * @param item - needle
         * @return true if item in tree
         */
        public boolean contains(Type item) {

            if (this.data.equals(item)) {
                return true;
            }
            //If the value to find is less than the current value, go left.
            if (this.data.compareTo(item) > 0 && this.left != null) {
                return this.left.contains(item);
            }

            //Otherwise, go right, as long as right isn't null.
            else if (this.data.compareTo(item) < 0 && this.right != null) {
                return this.right.contains(item);
            }
            //If you've completed all of the recursion and not returned true, return false.
            return false;
        }

        /**
         * This recursive function inserts a new Node with the specified value
         * into the binary search tree at the appropriate sorted position.
         *
         * @param item - data to add
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

        /**
         * traverses the tree to find what value to delete and
         * reorients the tree
         *
         * @param item - the item to delete
         * @param parent - the previous node
         * @param leftFlag - true if going left
         * @return - a boolean value
         */
        public boolean delete(Type item, Node<Type> parent, boolean leftFlag) {

        	//Traverse to the desired Node (if present).
        	
        	//Go to the left if item is less than current value.
            if (this.data.compareTo(item) > 0) {
                if (this.left == null) {
                    return false;
                }
                
                //Recursive call to continue traversal.
                this.left.delete(item, this, true);
                  
            //Go to the right if item is more than current value.
            } else if (this.data.compareTo(item) < 0) {
                if (this.right == null) {
                    return false;
                }
                
                //Recursive call to continue traversal.
                this.right.delete(item, this, false);
                
            } 
            
            //Once to the specified Node, begin removal process.
            else {

                //Case 1: Node to be deleted has no children.
                if (this.left == null && this.right == null) {
                    if (leftFlag) {
                        parent.left = null;
                        return true;
                    } else {
                        parent.right = null;
                        return true;
                    }
                }

                //Case 2: Node to be deleted has 1 child.
                else if (this.left == null || this.right == null) {

                    if (this.left != null) {
                        parent.left = this.left;
                    } else {
                        parent.right = this.right;
                    }
                }

                //Case 3: Node to be deleted has 2 children.
                else {
                    Node<Type> current = this.left;
                    while (current.right != null) {
                        current = current.right;
                    }
                    Node<Type> target = current;

                    this.data = (Type) target.data;
                    this.right.delete((Type) target.data, this, false);
                }
            }
            
            return false;
        }
    }
}
