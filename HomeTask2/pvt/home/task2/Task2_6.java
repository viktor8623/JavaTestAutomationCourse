package pvt.home.task2;

import static pvt.home.task2.Task2_3.randomArray;
import static pvt.home.task2.Task2_1.printArray;

public class Task2_6 {

	public static void main(String[] args) {
		
		int[] nums = randomArray();
		printArray(nums);

		for(int i = 0, n = 0; i < nums.length - 1; i += 2) {
			n = nums[i];
			nums[i] = nums[i + 1];
			nums[i + 1] = n;
		}
		
		printArray(nums);
	}
}
