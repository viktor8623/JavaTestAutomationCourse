package pvt.home.task14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Massive {
	private String name;
	private int size;
	private int[] arrOfNumbers;
	public String[] arrOfStrings;
	
	public void getNumber(int index) {
		try {
			System.out.println(arrOfNumbers[index]);
		} catch (NullPointerException e) {
			System.out.println("Error! You forgot to create your array!");
		}
	}
	
	public void setSize() {
		BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter size of an array ");
		try {
			size = Integer.parseInt(userInput.readLine());
		} catch (IOException e) {
			e.printStackTrace();
		} catch (NumberFormatException e) {
			System.out.println("Error! Enter a number from 1 to 100.");
		}
	}
	
	public void setString(int index, String value) {
		try {
			arrOfStrings[index] = value;
		} catch (NullPointerException | ArrayIndexOutOfBoundsException e) {
			e.printStackTrace();
		}
	}
	
	public void setName() {
		BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter a name ");
		try {
			this.name = userInput.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				userInput.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void createArrOfNumbers() {
		System.out.println("Enter size of an array ");
		try (BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in))) {
			size = Integer.parseInt(userInput.readLine());
			this.arrOfNumbers = new int[size];
		} catch (IOException | NumberFormatException | NegativeArraySizeException e) {
			System.out.println("Error occurred!");
			e.printStackTrace();
		}
	}
	
	public void createArrOfStrings() {
		BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter size of your strings array.");
		try {
			size = Integer.parseInt(userInput.readLine());
			try {
				this.arrOfStrings = new String[size];
			} catch (NegativeArraySizeException e) {
				System.out.println("The size of the array cannot be negative.");
				e.printStackTrace();
			}
		} catch (IOException | NumberFormatException e) {
			e.printStackTrace();
		}
	}
	
	public void skipFinally() {
        try {
            System.out.println("Inside try block.");
            System.exit(0);
        }
        finally {
            System.out.println("Inside finally block.");
        }
    }
}