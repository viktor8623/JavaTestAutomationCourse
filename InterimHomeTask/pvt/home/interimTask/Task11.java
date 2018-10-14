package pvt.home.interimTask;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Task11 {

	public static void main(String[] args) {
		String text = "3 words in 1 sentence. Ocean's 12!";

		System.out.println(countNumbers(text));
	}
	
	public static int countNumbers(String text) {
		
		List<Integer> numList = Arrays.asList(text.split("[\\p{Punct}\\s]+")).stream()
				.filter(word -> word.matches("[\\d]+"))
				.map(Integer::parseInt)
				.collect(Collectors.toList());
		int sum = 0;
		for(int number : numList) {
			sum += number;
		}
		return sum;
	}
}
