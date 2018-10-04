package pvt.home.task2;

import static pvt.home.task2.Task2_1.manualArray;
import static pvt.home.task2.Task2_1.printArray;

public class Task2_2 {

	public static void main(String[] args) {
		
		int[] nums = manualArray();
		printArray(nums);
		
		int result = 1;
		
		for(int element : nums) {
			result *= element;
		}
		System.out.println(result);
	}
}
