package pvt.home.task5;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExTask {
	
	public static boolean lessThan4LatinCharTogether(String testString) {		
		Pattern pattern = Pattern.compile("^[^a-zA-Z]*[a-zA-Z]{1,4}[^a-zA-Z]*$");
		Matcher matcher = pattern.matcher(testString);
		return matcher.matches();
	}
	
	public static boolean contains4Symbols(String testString) {		
		Pattern pattern = Pattern.compile("^.{4}$");
		Matcher matcher = pattern.matcher(testString);
		return matcher.matches();
	}
		
	public static void main(String[] args) {
		
		String str1 = "125abc$";
		String str2 = "125abcddd$";
		String str3 = "f89";
		String str4 = "6h*/";
		
		System.out.println(lessThan4LatinCharTogether(str1));
		System.out.println(lessThan4LatinCharTogether(str2));
		System.out.println(lessThan4LatinCharTogether(str3));
		System.out.println(lessThan4LatinCharTogether(str4));
		System.out.println();
		System.out.println(contains4Symbols(str1));
		System.out.println(contains4Symbols(str2));
		System.out.println(contains4Symbols(str3));
		System.out.println(contains4Symbols(str4));		
		
	}

}
