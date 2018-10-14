package pvt.home.interimTask;

import java.util.Scanner;
import java.util.regex.PatternSyntaxException;

public class Task2 {

	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
        System.out.print("Enter your text: ");
        String text = read.nextLine();
        System.out.print("Enter the substring after which you want to paste the word: ");
        String sub = read.nextLine();
        System.out.print("Enter your word: ");
        String word = read.nextLine();
        System.out.printf("Result: %s", putWordAfterSub(text, sub, word));
	}
	
	public static String putWordAfterSub(String text, String sub, String word) {		
		String result = text;
		try {
			result = text.replaceAll(sub, sub+word);
		} catch(PatternSyntaxException ex) {
			System.out.println("You haven't entered a word. So I can't add your word...");
		}
		return result;
	}
}
