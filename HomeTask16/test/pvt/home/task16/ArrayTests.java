package pvt.home.task16;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertEqualsNoOrder;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertNull;
import static org.testng.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ArrayTests {

	@BeforeSuite
	public void beforeSuite() {
		System.out.println("Code executed before test suite.");
	}

	@AfterSuite
	public void afterSuite() {
		System.out.println("Code executed after test suite.");
	}
	
	@BeforeTest
	public void beforeTest() {
		System.out.println("Code executed before group of tests that for some reason are called as \"test\".");
	}

	@AfterTest
	public void afterTest() {
		System.out.println("Code executed after group of tests that for some reason are called as \"test\".");
	}
	
	@BeforeClass
	public void beforeClass() {
		System.out.println("Code executed before test class.");
	}

	@AfterClass
	public void afterClass() {
		System.out.println("Code executed after test class.");
	}
	
	@BeforeMethod
	public void beforeMethod() {
		System.out.println("Code executed before test method aka real test.");
	}
	
	@AfterMethod
	public void afterMethod() {
		System.out.println("Code executed after test method aka real test.");
	}

	@Test
	public void testConstructor() {
		int size = 5;
		Array array = new Array(size);
		assertEquals(array.arr.length, 5, "Error in the constructor.");		
	}
	
	@Test(expectedExceptions=IllegalArgumentException.class)
	public void testConstructorWithZero() {
		int size = 0;
		new Array(size);
	}
	
	@Test(expectedExceptions=IllegalArgumentException.class)
	public void testConstructorWithNegativeNumber() {
		int size = -15;
		new Array(size);
	}
	
	@Test(expectedExceptions=IllegalArgumentException.class, enabled=false)
	public void testConstructorWithLetters() {
		int size = -15;
		new Array(size);
	}
	
	@Test
	public void testGetSumOfAllElements() {
		Array array = new Array(7);
		array.initArray(1, 2, 5, 8, 9, 10, 5);
		int expected_result = 40;
		int actual_result = array.getSumOfAllElements();
		assertEquals(actual_result, expected_result);
	}
	
	@Test
	public void testGetSumOfAllElementsWithZeroes() {
		Array array = new Array(7);
		array.initArray(1, 2, 0, 8, 9, 0, 5);
		int expected_result = 25;
		int actual_result = array.getSumOfAllElements();
		assertEquals(actual_result, expected_result);
	}
	
	@Test
	public void testGetSumOfAllElementsWithNegative() {
		Array array = new Array(7);
		array.initArray(1, 2, -5, 8, 9, -10, 0);
		int expected_result = 5;
		int actual_result = array.getSumOfAllElements();
		assertEquals(actual_result, expected_result);
	}
	
	@Test
	public void testAvarageValue() {
		Array array = new Array(7);
		array.initArray(1, 2, 5, 8, 9, 10, 5);
		int expected_result = 5;
		int actual_result = array.getAvarageValue();
		assertEquals(actual_result, expected_result);		
	}
	
	@Test
	public void testMaxValue() {
		Array array = new Array(7);
		array.initArray(1, -22, 5, 8, 9, 10, 5);
		int expected_result = 10;
		int actual_result = array.getMaxValue();
		assertEquals(actual_result, expected_result);		
	}
	
	@Test
	public void testMaxValueNegative() {
		Array array = new Array(6);
		array.initArray(-1, -22, -555, -8, -9, -10);
		int expected_result = -1;
		int actual_result = array.getMaxValue();
		assertEquals(actual_result, expected_result);		
	}
	
	@Test
	public void testMinValue() {
		Array array = new Array(7);
		array.initArray(1, -22, 0, 8, 90, 10, 5);
		int expected_result = -22;
		int actual_result = array.getMinValue();
		assertEquals(actual_result, expected_result);		
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
	public void testInitArray() {
		Array array = new Array(7);
		boolean response = array.initArray(1, 2, 5, 8, 9, 10, 5);
		Integer[] actual_result = Arrays.stream(array.arr).boxed().toArray(Integer[]::new);
		Integer[] expected_result = {1, 2, 5, 8, 9, 10, 5};
		assertEqualsNoOrder(actual_result, expected_result);
		assertTrue(response);
	}
	
	@Test
	public void testInitArrayWrongSize() {
		Array array = new Array(3);
		boolean response = array.initArray(1, 2, 5, 8, 9, 10, 5);
		assertFalse(response);
	}
	
	@Test
	public void testAddMembers() {
		Array array = new Array(5);
		array.initArray(1, 2, 5, 8, 9);
		int response = array.addMembers(11, 50);
		Integer[] actual_result = Arrays.stream(array.arr).boxed().toArray(Integer[]::new);
		Integer[] expected_result = {1, 2, 5, 8, 9, 11, 50};
		assertEqualsNoOrder(actual_result, expected_result);
		assertEquals(response, 7);
	}
	
	@Test
	public void testAddMembersToEmptyArray() {
		Array array = new Array(5);
		int response = array.addMembers(11, 50);
		Integer[] actual_result = Arrays.stream(array.arr).boxed().toArray(Integer[]::new);
		Integer[] expected_result = {0, 0, 0, 0, 0, 11, 50};
		assertEqualsNoOrder(actual_result, expected_result);
		assertEquals(response, 7);
	}
	
	@Test
	public void testGetReversedList() {
		Array array = new Array(5);
		array.initArray(1, 2, 5, 8, 9);
		ArrayList<Integer> actual_result = (ArrayList<Integer>) array.getReversedList();
		ArrayList<Integer> expected_result = new ArrayList<Integer>(Arrays.asList(9, 8, 5, 2, 1));
		assertEquals(actual_result, expected_result);
	}
	
	@Test
	public void testGetReversedListWithDuplicate() {
		Array array = new Array(5);
		array.initArray(1, 1, 5, 9, 9);
		ArrayList<Integer> actual_result = (ArrayList<Integer>) array.getReversedList();
		ArrayList<Integer> expected_result = new ArrayList<Integer>(Arrays.asList(9, 9, 5, 1, 1));
		assertEquals(actual_result, expected_result);
	}
	
	@Test
	public void testGetReversedListWithoutInit() {
		Array array = new Array(5);
		ArrayList<Integer> actual_result = (ArrayList<Integer>) array.getReversedList();
		ArrayList<Integer> expected_result = new ArrayList<Integer>(Arrays.asList(0, 0, 0, 0, 0));
		assertEquals(actual_result, expected_result);
	}
	
	@Test
	public void testGetReversedListWithNegatives() {
		Array array = new Array(5);
		array.initArray(-1, 1, -5, -9, 9);
		ArrayList<Integer> actual_result = (ArrayList<Integer>) array.getReversedList();
		ArrayList<Integer> expected_result = new ArrayList<Integer>(Arrays.asList(9, -9, -5, 1, -1));
		assertEquals(actual_result, expected_result);
	}
	
	@Test
	public void testGetUniqueNumbers() {
		Array array = new Array(5);
		array.initArray(1, 56, 5, 9, 9);
		HashSet<Integer> actual_result = (HashSet<Integer>) array.getUniqueNumbers();
		HashSet<Integer> expected_result = new HashSet<Integer>(Arrays.asList(1, 56, 5, 9));
		assertEquals(actual_result, expected_result);
	}
	
	@Test
	public void testGetUniqueNumbersOnlyDuplicate() {
		Array array = new Array(5);
		array.initArray(9, 9, 9, 9, 9);
		HashSet<Integer> actual_result = (HashSet<Integer>) array.getUniqueNumbers();
		HashSet<Integer> expected_result = new HashSet<Integer>(Arrays.asList(9));
		assertEquals(actual_result, expected_result);
	}
	
	@Test
	public void testGetUniqueNumbersWithoutDuplicate() {
		Array array = new Array(5);
		array.initArray(0, -9, 9, 90, 999);
		HashSet<Integer> actual_result = (HashSet<Integer>) array.getUniqueNumbers();
		HashSet<Integer> expected_result = new HashSet<Integer>(Arrays.asList(0, -9, 9, 90, 999));
		assertEquals(actual_result, expected_result);
	}
	
	@Test
	public void testGetUniqueNumbersWithoutInit() {
		Array array = new Array(5);
		HashSet<Integer> actual_result = (HashSet<Integer>) array.getUniqueNumbers();
		HashSet<Integer> expected_result = new HashSet<Integer>(Arrays.asList(0));
		assertEquals(actual_result, expected_result);
	}
}
