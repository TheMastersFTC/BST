/**
 * This interface represents common actions done to Collections, whether
 * they are stacks, queues, bags, etc.
 * 
 * All operations should list expected Big O time
 *
 * You are to implement this interface as a Generic Linked List and as an Integer Array List
 * 
 * @author germain & Kylee Fluckiger
 * @date February 23, 2017
 * 
 */

package cs2420;

import java.util.ArrayList;
import java.util.NoSuchElementException;



public interface List_2420<Type>
{
	/**
	 * This function adds the new data to the beginning of the list.
	 * 
	 * Big O: O(1)
	 * 
	 * @param data
	 * 
	 */
	void add_first( Type data );
	
	/**
	 * This functions adds the data to the end of the list.
	 * 
	 * Big O: O(n)
	 * 
	 * @param data
	 * 
	 */
	void add_last( Type data );

	/**
	 * This function adds a node after the given node index.
	 * 
	 * Big O: O(n)
	 * 
	 * @param after
	 *            (for example, after = 0, would mean after the first node)
	 *            if after is larger or equal to the length of the list, then
	 *            put the new node at the end of the list. if the value of after is larger than the
	 *            length of the list, then add to the end.
	 *            
	 */
	void add_middle( int after, Type data );

	/**
	 * This function clears the list.
	 * 
	 * Big O: O(1)
	 * 
	 */
	void clear(); 

	/**
	 * This iterative function returns true if the item is present in the list.
	 * 
	 * Big O: O(n)
	 * 
	 * @param item
	 * 
	 * @return boolean, if the list contains the item
	 * 
	 */
	boolean contains( Type item ); 

	/**
	 * This recursive function returns true if the item is present in the list.
	 * 
	 * Big O: O(n)
	 * 
	 * @param item
	 * 
	 * @return boolean, if the list contains the item
	 * 
	 */
	boolean contains_recursive( Type item ); 

	/**
	 * This function returns the value of the first item in the list.
	 * 
	 * Big O: O(1)
	 * 
	 * @return Type, value of first item in the list
	 * 
	 * @throws NoSuchElementException
	 * 
	 */
	Type get_first() throws NoSuchElementException; 
	
	/**
	 * This function returns the value of the last item in the list.
	 * 
	 * Big O: O(n)
	 * 
	 * @return Type, value of last item in the list
	 * 
	 * @throws NoSuchElementException
	 *
	 */
	Type get_last()  throws NoSuchElementException; 
	
	/**
	 * This function removes the first item in the list and returns its value.
	 * 
	 * Big O: O(1)
	 * 
	 * @return Type, the value of the removed item
	 * 
	 * @throws NoSuchElementException
	 * 
	 */
	Type remove_first() throws NoSuchElementException;
	
	/**
	 * This function removes the last item in the list and returns its value.
	 * 
	 * Big O: O(n)
	 * 
	 * @return Type, the value of the removed item
	 * 
	 * @throws NoSuchElementException
	 * 
	 */
	Type remove_last()  throws NoSuchElementException;

	/**
	 * This function returns the size of the list.
	 * 
	 * Big O: O(1)
	 * 
	 * @return int size, the number of elements in the list
	 * 
	 */
	int size();

	/**
	 * Using a single traversal, swap the order of the
	 * entire list.
	 * 
	 * Big O: O(n)
	 * 
	 */
	void reverse();

	/**
	 * For linked list: determines the size of a list using the Node<Type>.size_recursive() function
	 * For array list: writes a recursive size method
	 * 
	 * Big O: O(n)
	 * 
	 * @return the length of the list
	 *        
	 */
	int compute_size_recursive();

	/**
	 * This function recursively traverses the list, building up an ArrayList 
	 * of the data.
	 * 
	 * For linked list: use the Note<Type>.to_ArrayList_post_recurse() function
	 * 
	 * Big O: O(n) + ArrayList overhead
	 * 
	 * @return an ArrayList of the data in the linked list in reverse order.
	 * 
	 */
	ArrayList<Type> to_ArrayList_post_recurse();

	/**
	 * This function iteratively traverses the list and builds an ArrayList
	 * of the data members.
	 * 
	 * Big O: O(n) + ArrayList overhead
	 * 
	 */
	ArrayList<Type> to_ArrayList();

}
