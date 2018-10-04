package pvt.home;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Task3_1 {

	public static int min(int a, int b) {
		return (a <= b) ? a : b;
	}
	
	public static boolean even(int a) {
		boolean isEven = false;
		if (a % 2 == 0) {
			isEven = true;
		}
		return isEven;
	}
	
	public static int sqr(int a) {
		return a * a;
	}
	
	public static int cube(int a) {
		return (int) Math.pow(a, 3);
	}
	
	public static int getUserInput() {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int input;
		while (true) {
			try {
				String s = reader.readLine();
				input = Integer.parseInt(s);
				break;
			} catch (Exception ex) {
				System.out.println("Try again!");
			}
		}
		return input;
	}
	
		
	public static void main(String[] args) {
		
		System.out.println("Enter two numbers to find minimun:");
		int a = getUserInput();
		int b = getUserInput();
		System.out.println("Minimum number is " + min(a, b));
		System.out.println();
		
		System.out.println("Enter a number to check if it's even:");
		a = getUserInput();
		System.out.println(even(a));
		System.out.println();
		
		System.out.println("Enter a number.");
		a = getUserInput();
		System.out.println("Square of your number is  " + sqr(a));
		System.out.println();
		
		System.out.println("Enter a number.");
		a = getUserInput();
		System.out.println("Cube of your number is  " + cube(a));
		System.out.println();
	}
}
