package pvt.home.interimTask;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task10 {

	public static void main(String[] args) {
		String text = ". is a period or full stop\r\n" + 
						", is a comma\r\n" + 
						"? is a question mark\r\n" + 
						"! is an exclamation mark\r\n" + 
						"' is an apostrophe\r\n" + 
						"\" is a quotation mark/inverted comma\r\n" + 
						": is a colon\r\n" + 
						"; is a semicolon\r\n" + 
						"... is an ellipsis\r\n" + 
						"— is a dash";
		
		System.out.println(countPunctuationMarks(text));
	}
	
	public static int countPunctuationMarks(String text) {
		int result = 0;
		Pattern p = Pattern.compile("[\\.]{3}|[\\.,?!'\":;—]");
		Matcher m = p.matcher(text);
		while (m.find()) {
			result++;
		}
		
		return result;
	}
}
