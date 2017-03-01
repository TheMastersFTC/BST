package cs2420;

import static org.junit.Assert.*;
import org.junit.Test;
import java.util.*;

public class BinarySearchTreeTest {

    @Test
    public void testBinarySearchTree() {

        BinarySearchTree<Integer> list = new BinarySearchTree<>();

        assertEquals(0, list.size);
        assertEquals(null, list.root);

    }

    @Test
    public void testAddRoot() {

        BinarySearchTree<Integer> list = new BinarySearchTree<>();

        list.add(4);

        assertEquals(4, (int)list.root.data);

    }

    @Test
    public void testAddThree() {

        BinarySearchTree<Integer> list = new BinarySearchTree<>();

        list.add(4);
        list.add(3);
        list.add(5);

        assertEquals(4, (int)list.root.data);
        assertEquals(5, (int)list.root.right.data);
        assertEquals(3, (int)list.root.left.data);

    }

    @Test
    public void testAddMultiple() {

        BinarySearchTree<Integer> list = new BinarySearchTree<>();

        list.add(4);
        list.add(3);
        list.add(5);

        assertEquals(4, (int)list.root.data);
        assertEquals(5, (int)list.root.right.data);
        assertEquals(3, (int)list.root.left.data);

        list.add(2);
        list.add(6);

        assertEquals(2, (int)list.root.left.left.data);
        assertEquals(6, (int)list.root.right.right.data);

    }

    @Test
    public void testAddIntermediateNumber() {

        BinarySearchTree<Integer> list = new BinarySearchTree<>();

        list.add(4);
        list.add(2);
        list.add(6);

        assertEquals(4, (int)list.root.data);
        assertEquals(6, (int)list.root.right.data);
        assertEquals(2, (int)list.root.left.data);

        list.add(3);

        assertEquals(2, (int)list.root.left.data);
        assertEquals(3, (int)list.root.left.right.data);

    }

    @Test
    public void testAddAll() {
        BinarySearchTree<Integer> list = new BinarySearchTree<>();

        HashSet<Integer> set = new HashSet<>();
        set.add(1);
        set.add(2);
        set.add(3);
        set.add(4);
        set.add(5);

        list.addAll(set);

        //checks to make sure all values are contained
        assertEquals(true, list.contains(1));
        assertEquals(true, list.contains(2));
        assertEquals(true, list.contains(3));
        assertEquals(true, list.contains(4));
        assertEquals(true, list.contains(5));

        //checks for a non-contained value
        assertEquals(false,list.contains(6));

    }

    @Test
    public void testAddAllOneInvalid() {

        BinarySearchTree<Integer> list = new BinarySearchTree<>();

        list.add(2);

        HashSet<Integer> set = new HashSet<>();
        set.add(1);
        set.add(2);
        set.add(3);
        set.add(4);
        set.add(5);

        list.addAll(set);

        //checks to make sure all values are contained
        assertEquals(true, list.contains(1));
        assertEquals(true, list.contains(2));
        assertEquals(true, list.contains(3));
        assertEquals(true, list.contains(4));
        assertEquals(true, list.contains(5));

        //checks for a non-contained value
        assertEquals(false,list.contains(6));

        assertEquals(5, list.size());

    }

    @Test
    public void testClear() {

        BinarySearchTree<Integer> list = new BinarySearchTree<>();

        list.add(4);
        list.add(3);
        list.add(5);

        list.clear();

        assertEquals(null, list.root);
        assertEquals(0, list.size);

    }

    @Test
    public void testContains() {

        BinarySearchTree<Integer> list = new BinarySearchTree<>();

        list.add(0);
        list.add(1);
        list.add(2);

        assertTrue(list.contains(0));
        assertTrue(list.contains(1));
        assertTrue(list.contains(2));

        assertFalse(list.contains(14));

    }

    @Test
    public void testContainsStrings() {

        BinarySearchTree<String> list = new BinarySearchTree<>();

        list.add("hello");
        list.add("dude");
        list.add("what");

        assertTrue(list.contains("hello"));
        assertTrue(list.contains("dude"));
        assertTrue(list.contains("what"));

        assertFalse(list.contains("zoo"));

    }

    @Test
    public void testContainsLarge() {

        BinarySearchTree<Integer> list = new BinarySearchTree<>();

        list.add(0);
        list.add(1);
        list.add(2);
        list.add(68);
        list.add(92);
        list.add(71);
        list.add(4);
        list.add(654);
        list.add(91);
        
        assertTrue(list.contains(0));
        assertTrue(list.contains(1));
        assertTrue(list.contains(2));
        assertTrue(list.contains(68));
        assertTrue(list.contains(92));
        assertTrue(list.contains(71));
        assertTrue(list.contains(4));
        assertTrue(list.contains(654));
        assertTrue(list.contains(91));

        assertFalse(list.contains(14));

    }


    @Test
    public void testContainsOnEmpty() {

        BinarySearchTree<Integer> list = new BinarySearchTree<>();

        assertFalse(list.contains(11));

    }

    @Test
    public void testContainsAll() {
        BinarySearchTree<Integer> list = new BinarySearchTree<>();
        HashSet<Integer> set = new HashSet<>();
        set.add(1);
        set.add(2);
        set.add(3);
        set.add(4);
        set.add(5);

        list.addAll(set);

        assertEquals(true,list.containsAll(set));

        set.add(6);
        assertEquals(false, list.containsAll(set));

    }

    @Test (expected = NoSuchElementException.class)
    public void testContainsAllException(){
        BinarySearchTree<Integer> list = new BinarySearchTree<>();

        list.add(42);
        list.add(13);
        list.add(2);

        HashSet<Integer> set = new HashSet<>();

        list.containsAll(set);

    }

    @Test
    public void testFirst() {

        BinarySearchTree<Integer> list = new BinarySearchTree<>();

        list.add(4);
        list.add(3);
        list.add(5);

        assertEquals(3, (int)list.first());

    }

    @Test
    public void testIsEmpty() {

        BinarySearchTree<Integer> list = new BinarySearchTree<>();

        assertTrue(list.isEmpty());

        list.add(4);
        list.add(3);
        list.add(5);

        assertFalse(list.isEmpty());

    }

    @Test
    public void testLast() {

        BinarySearchTree<Integer> list = new BinarySearchTree<>();

        list.add(4);
        list.add(3);
        list.add(5);

        assertEquals(5, (int)list.last());

        list.add(7);

        assertEquals(7, (int)list.last());

        list.add(8);

        assertEquals(8, (int)list.last());

    }

    @Test
    public void testRemove() {
        BinarySearchTree<Integer> list = new BinarySearchTree<>();

        //tests case 1
        list.add(4);
        list.add(3);
        list.add(5);

        list.remove(5);

        //checks that the size is smaller
        assertEquals(2,list.size());

        //checks that it is no longer contained
        assertEquals(false, list.contains(5));

        list.clear();
        //test case 2
        list.add(4);
        list.add(3);
        list.add(5);
        list.add(7);

        list.remove(5);

        //checks that the size is smaller
        assertEquals(3,list.size());

        //checks that it is no longer contained
        assertEquals(false, list.contains(5));

        list.clear();
        //test case 3
        list.add(3);
        list.add(2);
        list.add(5);
        list.add(7);
        list.add(4);

        list.remove(5);

        //checks that the size is smaller
        assertEquals(4,list.size());

        //checks that it is no longer contained
        assertEquals(false, list.contains(5));

    }

    @Test
    public void testRemoveRoot() {
        BinarySearchTree<Integer> list = new BinarySearchTree<>();

        list.add(5);
        list.add(2);

        list.remove(5);

        assertEquals(1,list.size());

        //checks that it is no longer contained
        assertEquals(false, list.contains(5));
    }

    @Test
    public void testRemoveAll() {
        BinarySearchTree<Integer> list = new BinarySearchTree<>();

        HashSet<Integer> set = new HashSet<>();
        set.add(1);
        set.add(2);
        set.add(3);
        set.add(4);
        set.add(5);

        list.addAll(set);

        list.removeAll(set);

        //checks that the size is smaller
        assertEquals(0,list.size());

        //checks that it is no longer contained
        assertEquals(false, list.containsAll(set));
    }

    @Test
    public void testSize() {

        BinarySearchTree<Integer> list = new BinarySearchTree<>();

        list.add(4);
        list.add(3);
        list.add(5);

        assertEquals(3, list.size());

        list.add(17);
        list.add(42);

        assertEquals(5, list.size());

        //This one SHOULD NOT change the size, as it should not be added.
        list.add(4);

        assertEquals(5, list.size());

        list.add(81);

        assertEquals(6, list.size());

    }

    @Test
    public void testToArrayList() {
        BinarySearchTree<Integer> list = new BinarySearchTree<>();

        list.add(3);
        list.add(4);
        list.add(5);

        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        arrayList.add(3);
        arrayList.add(4);
        arrayList.add(5);

        assertEquals(arrayList, list.toArrayList());
    }

    @Test
    public void testToArrayListOutOfOrder() {
        BinarySearchTree<Integer> list = new BinarySearchTree<>();

        list.add(3);
        list.add(4);
        list.add(5);
        list.add(1);
        list.add(42);

        ArrayList<Integer> arrayList = new ArrayList<Integer>();

        arrayList.add(1);
        arrayList.add(3);
        arrayList.add(4);
        arrayList.add(5);
        arrayList.add(42);

        assertEquals(arrayList, list.toArrayList());
    }

    @Test
    public void testToArrayListEmpty() {
        BinarySearchTree<Integer> list = new BinarySearchTree<>();

        ArrayList<Integer> arrayList = new ArrayList<Integer>();

        assertEquals(arrayList, list.toArrayList());
    }

    @Test
    public void dotFile() {

        BinarySearchTree<Integer> list = new BinarySearchTree<>();

        list.add(3);
        list.add(4);
        list.add(5);
        list.add(1);
        list.add(42);
        list.add(0);
        list.add(2);

        list.writeDot("dotFile.gv");

    }
}
