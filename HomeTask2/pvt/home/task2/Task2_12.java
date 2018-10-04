package pvt.home.task2;

import static pvt.home.task2.Task2_3.randomArray;
import static pvt.home.task2.Task2_1.printArray;

public class Task2_12 {

	public static void main(String[] args) {
		
		int[] nums = randomArray();
		printArray(nums);
		
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
		
		printArray(nums);
		
	}
}
