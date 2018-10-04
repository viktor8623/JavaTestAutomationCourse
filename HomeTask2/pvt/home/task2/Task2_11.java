package pvt.home.task2;

import static pvt.home.task2.Task2_1.manualArray;
import static pvt.home.task2.Task2_1.printArray;

public class Task2_11 {

	public static void main(String[] args) {

		int[] nums = manualArray();
		printArray(nums);

		double[] nums2 = new double[nums.length];
		
		int i = 1;
		while(i < nums.length - 1) {
			nums2[i] = (double) (nums[i - 1] + nums[i + 1]) / 2;
			i++;
		}
		nums2[0] = nums[0];
		nums2[nums2.length - 1] = nums[nums.length - 1];
		
		for(double element : nums2) {
			System.out.print(element + " ");
		}
	}
}
