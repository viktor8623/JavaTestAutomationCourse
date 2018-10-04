package pvt.home.task2;

import static pvt.home.task2.Task2_3.randomArray;
import static pvt.home.task2.Task2_1.printArray;

public class Task2_7 {

	public static void main(String[] args) {
		
		int[] nums = randomArray();
		printArray(nums);
		
		for(int i = 0, buffer = 0; i < nums.length / 2; i++) {
			buffer = nums[i];
			nums[i] = nums[nums.length - 1 - i];
			nums[nums.length - 1 - i] = buffer;
		}
		
		printArray(nums);
	}
}
