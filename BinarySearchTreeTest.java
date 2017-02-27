package cs2420;

import static org.junit.Assert.*;

import org.junit.Test;

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
		fail("Not yet implemented");
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
	public void testContainsAll() {
		fail("Not yet implemented");
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
		fail("Not yet implemented");
	}

	@Test
	public void testRemoveAll() {
		fail("Not yet implemented");
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
		fail("Not yet implemented");
	}

}
