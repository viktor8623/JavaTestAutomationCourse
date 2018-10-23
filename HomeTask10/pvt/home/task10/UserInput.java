package pvt.home.task10;

import java.util.Scanner;

public class UserInput {
	
	private Scanner in;
	
	public UserInput() {
		this.in = new Scanner(System.in);
	}

	public String getText() {
		System.out.print("Enter your text: ");
		String text = in.nextLine();
		return text;
	}
	
	public int getIndex() {
		System.out.print("Please inter the idex of the char you want to replace: ");
		int index = Integer.parseInt(in.nextLine());
		return index;
	}
	
	public char getPlaceholder() {
		System.out.print("Enter your placeholder: ");
		char symbol = in.nextLine().charAt(0);
		return symbol;
	}
}
