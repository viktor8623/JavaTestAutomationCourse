package pvt.home.interimTask;

import java.util.Arrays;
import java.util.Comparator;


public class Task7 {

	public static void main(String[] args) {
		String text = "795**-+ lkgjsa564 sfdjleiowr2947 165465+46/*-* 654";
		
		System.out.println(findMaxSubWithoutLetters(text));
	}
	
	public static String findMaxSubWithoutLetters(String text) {
		return Arrays.stream(text.split(" "))
				.filter(word -> word.matches("[^a-zA-Z]+"))
				.max(Comparator.comparingInt(String::length))
				.get();
	}
}
