package pvt.home.task2;

import java.util.Scanner;
import static pvt.home.task2.Task2_1.printArray;

public class Task2_3 {

	public static int[] randomArray() {
		Scanner in = new Scanner(System.in);
		System.out.print("Enter size of your array: ");
		int size = in.nextInt();
		int[] nums = new int[size];
		
		for(int i = 0; i < size; i++) {
			nums[i] = (int) (Math.random() * 100);
		}
		
		return nums;
	}
	
	public static void main(String[] args) {
		
		int[] nums = randomArray();
		printArray(nums);
		
		for(int i = 0; i < nums.length; i++) {
			if ((i + 1) % 3 == 0) {
				nums[i] *= 2;
			}
		}
		
		printArray(nums);
				
		for(int i = 2; i < nums.length; i += 3) {
			nums[i] *= 2;
		}
		
		printArray(nums);
	}
}
