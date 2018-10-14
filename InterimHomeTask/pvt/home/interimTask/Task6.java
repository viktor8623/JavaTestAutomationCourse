package pvt.home.interimTask;

import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Task6 {

	public static void main(String[] args) {
		String text = "Java language redirects here. For the natural language from the Indonesian island of Java, see Javanese language.\r\n" + 
				"This article is about a programming language. For the software package downloaded from java.com, see Java SE.\r\n" + 
				"Not to be confused with JavaScript.";
		
		countWords(text);		
	}
	
    public static void countWords(String input) {
        Map<String, Long> result = Arrays.stream(input.toLowerCase()
                .split("[\\s.,!?-]"))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        result.remove("");

        result.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Collections.reverseOrder()))
                .forEach((entry) -> System.out.println(entry.getKey() + " - " + entry.getValue()));
    }
}
