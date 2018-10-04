package pvt.home.task2;

import static pvt.home.task2.Task2_3.randomArray;
import static pvt.home.task2.Task2_1.printArray;

public class Task2_4 {

	public static void main(String[] args) {

		int[] nums = randomArray();
		printArray(nums);
		

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
}
