package pvt.home.interimTask;

import java.util.Scanner;

public class Task1 {

	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
        System.out.print("Enter your text: ");
        String text = read.nextLine();
        System.out.print("Enter substring to paste it: ");
        String sub = read.nextLine();
        System.out.print("Enter k-index: ");
        int k = read.nextInt();
        System.out.printf("Result: %s", putSub(text, sub, k));
    }
 
    public static StringBuilder putSub(String text, String sub, int k) {
        StringBuilder result = new StringBuilder(text);
        try {
        	result = result.replace(k, k, sub);
        } catch(StringIndexOutOfBoundsException ex) {
        	System.out.println("Enter valid k-index. Any number between 0 and the last index of the string.");
        }
        return result;
    }
}
