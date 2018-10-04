package pvt.home.task4;

public class Variables {

	public static void main(String[] args) {
		int justNumber = 123;
		short shortNumber = 5;
		long longNumber = 2L;
		double doubleNumber = 1.23456e300d;
		float floatNumber = 1.23f;
		char someChar = 'V';
		boolean isDone = true;

		int result1 = justNumber + shortNumber;
		double result2 = longNumber - doubleNumber;
		double result3 = floatNumber * doubleNumber;
		boolean result4 = longNumber > doubleNumber;
		boolean result5 = floatNumber < justNumber;
		boolean result6 = shortNumber == longNumber;
		boolean result7 = shortNumber != longNumber;
		
		System.out.println(justNumber + " " + shortNumber + " " + longNumber + " " + doubleNumber + " " 
		+ someChar + " " + isDone);
		System.out.print(result1 + " " + result2 + " " + result3 + " " + result4 + " " + result5 + " " 
		+ result6 + " " + result7);
	}
}
