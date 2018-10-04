package pvt.home;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Task3_3 {
	
	// Task 1: пройти по массиву, вывести все элементы в прямом и в обратном порядке.
	
	public static int[] getManualArray() {
		Scanner in = new Scanner(System.in);
		System.out.print("Enter size of your array: ");
		int size = in.nextInt();
		System.out.println(size);
		
		int[] nums = new int[size];
		
		for(int i = 0; i < size; i++) {
			System.out.print("Enter " + i + " element of the array. ");
			int n = in.nextInt();
			nums[i] = n;
		}
//		in.close();
		return nums;
	}
	
	public static int[] getRandomArray() {
		Scanner in = new Scanner(System.in);
		System.out.print("Enter size of your array: ");
		int size = in.nextInt();
		int[] nums = new int[size];
		
		for(int i = 0; i < size; i++) {
			nums[i] = (int) (Math.random() * 100);
		}
//		in.close();
		return nums;
	}
	
	public static Integer[] convertToInteger(int[] nums) {
		Integer[] result = new Integer[nums.length];
		for (int i = 0; i < nums.length; i++) {
			result[i] = Integer.valueOf(nums[i]);
		}
		return result;
	}	
	
	public static void printArray(int[] nums) {
		
		for(int element : nums) {
			System.out.print(element + " ");
		}
		
		System.out.print("\n");
	}
	
	public static void printArray(double[] nums) {
		
		for(double element : nums) {
			System.out.print(element + " ");
		}
		
		System.out.print("\n");
	}
	
	public static void printArrayReverse(int[] nums) {
		
		for(int i = nums.length - 1; i >= 0; i--) {
			System.out.print(nums[i] + " ");
		}
		
		System.out.print("\n");
	}
	
	// Task 2: найти произведения всех элементов массива, вывести
	
	public static void printProductOfElements(int[] nums) {
		long result = 1;
		
		for(int element : nums) {
			result *= element;
		}
		System.out.println("Product of the elements is " + result);
	}
	
	// Task 3: каждый 3-й элемент умножить на 2
	
	public static void MultiplyEveryThirdElementByTwo(int[] nums) {
		for(int i = 2; i < nums.length; i += 3) {
			nums[i] *= 2;
		}
	}
	
	//	 Task 4: найти количество нулевых элементов, вывести количество. 
	//	         если нулевых элементов нет - вывести сообщение, что их нет
	
	public static void printHowManyZeroes(int[] nums) {
		int count = 0;
		
		for(int i = 0; i < nums.length; i++) {
			if (nums[i] == 0) {
				count++;
			}
		}
		
		if (count == 0) {
			System.out.println("There is no \"zero\" elements.");
		} else if (count == 1) {
			System.out.println("There is " + count + " \"zero\" element.");
		} else {
			System.out.println("There is " + count + " \"zero\" elements.");
		}
	}
	
	// Task 5: найти и вывести номер нулевых элементов. 
	//         если нулевых элементов нет - вывести сообщение, что их нет
	
	public static void printIndexesOfZeroes(int[] nums) {
		List<Integer> zeros = new ArrayList<Integer>();
		
		for(int i = 0; i < nums.length; i++) {
			if (nums[i] == 0) {
				zeros.add(i);
			}
		}
		
		if (zeros.size() == 0) {
			System.out.println("There is no \"zero\" elements. No indexes to print.");
		} else {
			System.out.print("\"Zero\" elements have following indexes: ");
			for(int element : zeros) {
				System.out.print(element + " ");
			}
		}
	}
	
	// Task 6: пройти по массиву и поменять местами каждые 2 соседних элемента
	
	public static void swapNeighbours(int[] nums) {
		int temp;
		for(int i = 0; i < nums.length - 1; i += 2) {
			temp = nums[i];
			nums[i] = nums[i + 1];
			nums[i + 1] = temp;
		}
	}
	
	// Task 7: пройти по массиву и поменять местами первый и последний, второй и предпоследний и т.д.
	
	public static void reverseArray(int[] nums) {
		int temp;
		for(int i = 0; i < nums.length / 2; i++) {
			temp = nums[i];
			nums[i] = nums[nums.length - 1 - i];
			nums[nums.length - 1 - i] = temp;
		}
	}
	
	// Task 8: найти минимальный-максимальный элементы и вывести
	
	public static void printMinMaxValues(int[] nums) {
		int min = nums[0];
		int max = nums[0];
		
		for(int i = 1; i < nums.length; i++) {
			if (nums[i] < min) {
				min = nums[i];
			}
			if (nums[i] > max) {
				max = nums[i];
			}
		}
		
		System.out.println("Min number is " + min);
		System.out.println("Max number is " + max);
	}
	
	// Task 9: найти номер минимального-максимального элементов и вывести
	
	public static void printIndexOfMinMax(Integer[] nums) {
		int min = nums[0];
		int max = nums[0];
		
		for(int i = 1; i < nums.length; i++) {
			if (nums[i] < min) {
				min = nums[i];
			}
			if (nums[i] > max) {
				max = nums[i];
			}
		}
		
		System.out.println("Index of min element is " + Arrays.asList(nums).indexOf(min));
		System.out.println("Index of max element is " + Arrays.asList(nums).indexOf(max));
	}
	
	// Task 10: проверить, является ли массив возрастающей последовательностью
	
	public static boolean isIncreasing(int[] nums) {
		boolean isIncreasing = false;
		
		int firstNum = nums[0];
		
		int i = 1;
		while(i < nums.length) {
			if (firstNum < nums[i]) {
				isIncreasing = true;
			} else {
				isIncreasing = false;
				break;
			}
			firstNum = nums[i];
			i++;
		}
		return isIncreasing;
	}
	
	// Task 11: заменить все элементы массива на полусумму соседних элементов
	
	public static double[] changeToHalfSumNeighbors(int[] nums) {
		double[] result = new double[nums.length];
		
		int i = 1;
		while(i < nums.length - 1) {
			result[i] = (double) (nums[i - 1] + nums[i + 1]) / 2;
			i++;
		}
		result[0] = nums[0];
		result[result.length - 1] = nums[nums.length - 1];
		return result;
	}
	
	// Task 12: циклически сдвинуть все элементы вправо на 2 позиции
	
	public static void moveToRightBy2(int[] nums) {
		for(int k = 0; k < 2; k++) {
			int last = 0;
			for(int i = nums.length - 1; i >= 0; i--) {
				if (i == nums.length - 1) {
					last = nums[i];
					nums[i] = nums[i - 1];
				} else if (i == 0) {
					nums[i] = last;
				} else {
					nums[i] = nums[i - 1];
				}
			}		
		}
	}
	
	
	public static void main(String[] args) {
		
		int[] reverse = getManualArray();
		printArrayReverse(reverse);
		int[] nums = getRandomArray();
		printArray(nums);
		
		printProductOfElements(nums);
		
		MultiplyEveryThirdElementByTwo(nums);
		printArray(nums);
		
		printHowManyZeroes(nums);
		
		printIndexesOfZeroes(nums);
		
		swapNeighbours(nums);
		printArray(nums);
		
		reverseArray(nums);
		printArray(nums);
		
		printMinMaxValues(nums);
		
		Integer[] arr = convertToInteger(nums);
		printIndexOfMinMax(arr);
		
		System.out.println("Is your array increasing? " + isIncreasing(nums));
		
		double[] dArray = changeToHalfSumNeighbors(nums);
		printArray(dArray);
		
		moveToRightBy2(nums);
		printArray(nums);
	}
}