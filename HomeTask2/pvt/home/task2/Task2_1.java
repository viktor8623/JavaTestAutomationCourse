package pvt.home.task2;

import java.util.Scanner;

public class Task2_1 {

	public static int[] manualArray() {
		
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
		
		return nums;
	}
	
	public static void printArray(int[] nums) {
		
		for(int element : nums) {
			System.out.print(element + " ");
		}
		
		System.out.print("\n");
	}
	
	public static void main(String[] args) {
		
		int[] nums = manualArray();
		printArray(nums);
		
		for(int i = nums.length - 1; i >= 0; i--) {
			System.out.print(nums[i] + " ");
		}
	}
}
