package pvt.home;

public class Massive {

	public void printMassiveAsLine(int[] arr) {
		for(int n : arr) {
			System.out.print(n + " ");
		}
		System.out.println();
	}
	
	public void printReverseMassiveAsLine(int[] arr) {
		for (int i = arr.length - 1; i >= 0; i--) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
	
	public int getSumOfElements(int[] arr) {
		int sum = 0;
		for (int i : arr) {
			sum += i;
		}
		return sum;
	}
	
	public int[] multiptyBy3(int[] arr) {
		int[] result = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			result[i] = arr[i] * 3;
		}
		return result;
	}
	
}
