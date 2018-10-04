package pvt.home.task2;

import java.util.Arrays;
import java.util.Scanner;

public class Task2_9 {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		System.out.print("Enter size of your array: ");
		int size = in.nextInt();
		Integer[] nums = new Integer[size];
		
		for(int i = 0; i < size; i++) {
			nums[i] = (int) (Math.random() * 100);
		}

		for(int element : nums) {
			System.out.print(element + " ");
		}
		System.out.println();

		int min = nums[0];
		int max = nums[0];
		
		for(int i = 1; i < size; i++) {
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
}