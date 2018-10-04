package pvt.home.task2;

import static pvt.home.task2.Task2_3.randomArray;
import static pvt.home.task2.Task2_1.printArray;

public class Task2_8 {

	public static void main(String[] args) {
		
		int[] nums = randomArray();
		printArray(nums);

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
}
