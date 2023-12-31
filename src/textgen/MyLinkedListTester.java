/**
 * 
 */
package textgen;

import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.Before;
import org.junit.Test;

/**
 * @author UC San Diego MOOC team
 *
 */
public class MyLinkedListTester {

	private static final int LONG_LIST_LENGTH =10; 

	MyLinkedList<String> shortList;
	MyLinkedList<Integer> emptyList;
	MyLinkedList<Integer> longerList;
	MyLinkedList<Integer> list1;
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		// Feel free to use these lists, or add your own
	    shortList = new MyLinkedList<String>();
		shortList.add("A");
		shortList.add("B");
		emptyList = new MyLinkedList<Integer>();
		longerList = new MyLinkedList<Integer>();
		for (int i = 0; i < LONG_LIST_LENGTH; i++)
		{
			longerList.add(i);
		}
		list1 = new MyLinkedList<Integer>();
		list1.add(65);
		list1.add(21);
		list1.add(42);
		
	}

	
	/** Test if the get method is working correctly.
	 */
	/*You should not need to add much to this method.
	 * We provide it as an example of a thorough test. */
	@Test
	public void testGet()
	{
		//test empty list, get should throw an exception
		try {
			emptyList.get(0);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
			
		}
		
		// test short list, first contents, then out of bounds
		assertEquals("Check first", "A", shortList.get(0));
		assertEquals("Check second", "B", shortList.get(1));
		
		try {
			shortList.get(-1);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		try {
			shortList.get(2);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		// test longer list contents
		for(int i = 0; i<LONG_LIST_LENGTH; i++ ) {
			assertEquals("Check "+i+ " element", (Integer)i, longerList.get(i));
		}
		
		// test off the end of the longer array
		try {
			longerList.get(-1);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		try {
			longerList.get(LONG_LIST_LENGTH);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		}
		
	}
	
	
	/** Test removing an element from the list.
	 * We've included the example from the concept challenge.
	 * You will want to add more tests.  */
	@Test
	public void testRemove()
	{
		try {
			list1.remove(-1);
			fail("Check out of bounds");
		} catch(IndexOutOfBoundsException e) {
			
		}
		
		try {
			list1.remove(5);
			fail("Check out of bounds");
		} catch(IndexOutOfBoundsException e) {
			
		}
		
		int a = list1.remove(0);
		assertEquals("Remove: check a is correct ", 65, a);
		assertEquals("Remove: check element 0 is correct ", (Integer)21, list1.get(0));
		assertEquals("Remove: check size is correct ", 2, list1.size());
		
		// TODO: Add more tests here
		assertEquals("Remove: check link after remove", list1.head, list1.head.next.prev);
		
		shortList.add("C");
		String b = shortList.remove(1);
		assertEquals("Remove: check link after remove", shortList.head.next, shortList.tail.prev.prev);
		assertEquals("Remove: check link after remove", shortList.tail.prev, shortList.head.next.next);
	}
	
	/** Test adding an element into the end of the list, specifically
	 *  public boolean add(E element)
	 * */
	@Test
	public void testAddEnd()
	{
        // TODO: implement this test
		try {
			list1.add(null);
			fail("Null elements are not allowed");
		} catch (NullPointerException e) {
			
		}
		
		emptyList.add(1);
		assertEquals("AddEnd: check element 0 is correct", (Integer)1, emptyList.get(0));
		assertEquals("AddEnd: check head link to element is correct", (Integer)1, emptyList.head.next.data);
		assertEquals("AddEnd: check element link to tail is correct", emptyList.tail, emptyList.head.next.next);
		assertEquals("AddEnd: check return is correct", true, emptyList.add(2));
		assertEquals("AddEnd: check size is correct", 2, emptyList.size());
	}

	
	/** Test the size of the list */
	@Test
	public void testSize()
	{
		// TODO: implement this test
		assertEquals("Size: empty list", 0, emptyList.size());
		assertEquals("Size: short list", 2, shortList.size());
		assertEquals("Size: long list", 10, longerList.size());
		
		assertEquals("Size: list", 3, list1.size());
		list1.add(13);
		list1.add(37);
		assertEquals("Size: list", 5, list1.size());
		list1.remove(3);
		assertEquals("Size: list", 4, list1.size());
	}

	
	
	/** Test adding an element into the list at a specified index,
	 * specifically:
	 * public void add(int index, E element)
	 * */
	@Test
	public void testAddAtIndex()
	{
        // TODO: implement this test
		try {
			list1.add(-1, 10);
			fail("Check out of bounds");
		} catch(IndexOutOfBoundsException e) {
			
		}
		
		try {
			list1.add(1, null);
			fail("Check element be null");
		} catch(NullPointerException e) {
			
		}
		
		try {
			shortList.add(3, "C");
			fail("Check out of bounds");
		} catch(IndexOutOfBoundsException e) {
			
		}
		
		shortList.add(1, "C");
		assertEquals("AddAtEnd: check value is correct", (String)"C", shortList.get(1));
		assertEquals("AddAtEnd: check value is correct", (String)"B", shortList.get(2));
		assertEquals("AddAtEnd: check size is correct", 3, shortList.size());
	}
	
	/** Test setting an element in the list */
	@Test
	public void testSet()
	{
	    // TODO: implement this test
	    try {
	    	shortList.set(0, null);
	    	fail("Check element be null");
	    } catch(NullPointerException e) {
	    	
	    }
	    
	    try {
	    	shortList.set(2,  "C");
	    	fail("Check out of bounds");
	    } catch(IndexOutOfBoundsException e) {
	    	
	    }
	    
	    try {
	    	shortList.set(-1, "D");
	    	fail("Check out of bounds");
	    } catch(IndexOutOfBoundsException e) {
	    	
	    }
	    
	    assertEquals("Set: check return is correct", (Integer)21, list1.set(1, 13));
	    assertEquals("Set: check value is correct", (Integer)13, list1.get(1));
	    assertEquals("Set: check size is correct", 3, list1.size());
	}
	
	
	// TODO: Optionally add more test methods.
	
}
