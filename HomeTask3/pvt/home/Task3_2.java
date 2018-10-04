package pvt.home;

public class Task3_2 {

	public static void remainderScreen(int a, int b) {
		int c = a - b;
		System.out.println("a - b = " + c);
	}
	
	public static void sumScreen(int a, int b, int c) {
		long d = a + b + c;
		System.out.println("a + b + c = " + d);
	}
	
	public static int remainder(int a, int b) {
		return a - b;
	}
	
	public static long sum(int a, int b, int c) {
		return a + b + c;
	}
	
	public static void printArray(int[] array) {
		for(int element : array) {
			System.out.print(element + " ");
		}
		System.out.println();
	}
	
	public static void printFArray(float[] array) {
		for(float element : array) {
			System.out.print(element + " ");
		}
		System.out.println();
	}
	
	public static void printArrayLength(int[] array) {
		System.out.println("Length of your array is " + array.length);
	}
	
	public static double sumOfElements(double[] array) {
		double sum = array[0];
		for(int i = 1; i < array.length; i++) {
			sum += array[i];
		}
		return sum;
	}
	
	public static float[] newArray(float[] array) {
		float[] newArr = new float[array.length];
		for(int i = 0; i < array.length; i++) {
			if ((i + 1) % 3 == 0) {
				newArr[i] = -1;
			} else {
				newArr[i] = array[i];
			}
		}
		return newArr;
	}
	
	
	public static void main(String[] args) {
		
		remainderScreen(5, 10);
		sumScreen(1, 2, 3);
		System.out.println(remainder(15, 7));
		System.out.println(sum(5, 5, 5));
		int myArray[] = {1, 2, 3, 4, 5};
		printArray(myArray);
		printArrayLength(myArray);
		double dArray[] = {1.5, 2.9, 3.2, 4.55, 5};
		System.out.println(sumOfElements(dArray));
		float fArray[] = {1.5f, 2.9f, 3.2f, 4.55f, 5f, -1034.25f};
		float[] newFArray = newArray(fArray);
		printFArray(newFArray);
	}
}
