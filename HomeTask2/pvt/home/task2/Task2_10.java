package pvt.home.task2;

import static pvt.home.task2.Task2_1.manualArray;
import static pvt.home.task2.Task2_1.printArray;

public class Task2_10 {

	public static void main(String[] args) {
		
		int[] nums = manualArray();
		printArray(nums);
		
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
		System.out.println(isIncreasing);
	}
}