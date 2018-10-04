package pvt.home.task2;

import java.util.ArrayList;
import java.util.List;
import static pvt.home.task2.Task2_1.manualArray;
import static pvt.home.task2.Task2_1.printArray;

public class Task2_5 {

	public static void main(String[] args) {
		
		int[] nums = manualArray();
		printArray(nums);

		List<Integer> zeros = new ArrayList<Integer>();
		
		for(int i = 0; i < nums.length; i++) {
			if (nums[i] == 0) {
				zeros.add(i);
			}
		}
		
		if (zeros.size() == 0) {
			System.out.println("There is no \"zeros\" elements.");
		} else {
			System.out.print("\"Zeros\" elements have following indexes: ");
			for(int element : zeros) {
				System.out.print(element + " ");
			}
		}
	}
}
