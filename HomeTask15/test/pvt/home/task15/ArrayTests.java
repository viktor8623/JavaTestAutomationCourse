package pvt.home.task15;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import junit.framework.Assert;

public class ArrayTests {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("Code executed in the beginning.");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("Code executed in the end.");
	}

	@Before
	public void setUp() throws Exception {
		System.out.println("Code executed in the beginning of every test.");
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("Code executed in the end of every test.");
	}

	
	@Test
	public void testConstructor() {
		int size = 5;
		Array array = new Array(size);
		assertEquals(size, array.arr.length);		
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testConstructorWithZero() {
		int size = 0;
		new Array(size);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testConstructorWithNegativeNumber() {
		int size = -15;
		new Array(size);
	}
	
	@Ignore
	@Test(expected=IllegalArgumentException.class)
	public void testConstructorWithLetters() {
		int size = -15;
		new Array(size);
	}
	
	@Test
	public void testIsEmptyFalse() {
		int size = 5;
		Array array = new Array(size);
		assertFalse(array.isEmpty());
		assertNotNull(array.arr);
	}
	
	@Test
	public void testIsEmptyTrue() {
		int size = 5;
		Array array = new Array(size);
		array.arr = null;
		assertTrue(array.isEmpty());		
	}
	
	@Test
	public void testArrField() {
		Array array = new Array(3);
		array.arr = null;
		assertNull(array.arr);		
	}
	
	@Test
	public void testAvarageValue() {
		Array array = new Array(7);
		array.initArray(1, 2, 5, 8, 9, 10, 5);
		int expected_result = 5;
		int actual_result = array.getAvarageValue();
		assertEquals("Wrong avarage", expected_result, actual_result);		
	}
	
	@Test
	public void testMaxValue() {
		Array array = new Array(7);
		array.initArray(1, -22, 5, 8, 9, 10, 5);
		int expected_result = 10;
		int actual_result = array.getMaxValue();
		assertEquals(expected_result, actual_result);		
	}
	
	@Test
	public void testInitArray() {
		Array array = new Array(7);
		boolean response = array.initArray(1, 2, 5, 8, 9, 10, 5);
		int[] expected_result = {1, 2, 5, 8, 9, 10, 5};
		assertArrayEquals(expected_result, array.arr);
		assertTrue(response);
	}
	
	@Test
	public void testInitArrayWrongSize() {
		Array array = new Array(3);
		boolean response = array.initArray(1, 2, 5, 8, 9, 10, 5);
		assertFalse(response);
	}
	
	@Test
	public void test() {
		fail("Not yet implemented");
	}
}
