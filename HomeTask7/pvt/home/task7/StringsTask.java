package pvt.home.task7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class StringsTask {

	public static String[] getArrayOfStrings() {
		
		Scanner in = new Scanner(System.in);
		System.out.print("Enter size of your array: ");
		int size = Integer.parseInt(in.nextLine());
		String[] strings = new String[size];
		
		for(int i = 0; i < size; i++) {
			System.out.print("Enter " + i + " element of the array. ");
			strings[i] = in.nextLine();
		}
		
		return strings;
	}
	
//	Task 1.
	public static void findAndPrintMinMaxStrings(String[] strings) {
		
		String min = strings[0];
		String max = strings[0];
		String quote = "\"";
		String withLen = " with lenght ";
		
		for(int i = 1; i < strings.length; i++) {
			if (strings[i].length() < min.length()) {
				min = strings[i];
			}
			if (strings[i].length() > max.length()) {
				max = strings[i];
			}
		}
		
		System.out.println("Min string is " + quote + min + quote + withLen + min.length());
		System.out.println("Max string is " + quote + max + quote + withLen + max.length());
	}

//	Task 2.
	public static Comparator<String> getComparatorByLength() {
		Comparator<String> compareByLength = (aString, bString) -> aString.length() - bString.length();
		return compareByLength;
	}
	
	public static void printStringsByLenghtAsc(String[] strings) {
		Arrays.asList(strings).stream().sorted(getComparatorByLength()).forEach(System.out::println);
	}
	
	public static void printStringsByLenghtDesc(String[] strings) {
		Arrays.asList(strings).stream().sorted(getComparatorByLength().reversed()).forEach(System.out::println);
	}

//	Task 3.
	public static int getAverageStringLenght(String[] strings) {
		int totalLenght = Arrays.stream(strings).mapToInt(String::length).sum();
		return totalLenght/strings.length;
	}
	
	public static void printStringsLongerThanAverage(String[] strings) {
		int averageLenght = getAverageStringLenght(strings);
		Arrays.asList(strings).stream().forEach(string -> {
			int len = string.length();
			if(len > averageLenght) {
				System.out.println(string + ", lenght: " + len);
			}
		});
	}
		
	public static void printStringsShorterThanAverage(String[] strings) {
		int averageLenght = getAverageStringLenght(strings);
		Arrays.asList(strings).stream().forEach(string -> {
			int len = string.length();
			if(len < averageLenght) {
				System.out.println(string + ", lenght: " + len);
			}
		});
	}

//	Task 4.
	public static String getFirstWordWithMinSetOfCharacters(String[] strings) {
		int quantityOfUniqueChars = Integer.MAX_VALUE;
		String result = "";
		for(int i = 0; i < strings.length; i++) {
			Set<Character> chars = strings[i].chars().mapToObj(e -> (char)e).collect(Collectors.toSet());
			int sizeOfSet = chars.size();
			if(sizeOfSet < quantityOfUniqueChars) {
				quantityOfUniqueChars = sizeOfSet;
				result = strings[i];
			}
		}
		return result;
	}
	
//	Task 5.
	public static boolean findLatinWordWithEquelAmountVowelsConsonants(String word) {
		boolean result = false;
		boolean isLatin = false;
		int vowels = 0;
		int consonants = 0;

		Pattern p = Pattern.compile("^[a-zA-Z]+$");
		Matcher m = p.matcher(word);
		isLatin = m.matches();
		
		if (isLatin) {
			Pattern pVowels = Pattern.compile("[aeiouAEIOU]");
			Matcher mVowels = pVowels.matcher(word);
			while (mVowels.find()) {
				vowels++;
			}
			
			Pattern pConsonants = Pattern.compile("[bcdfghjklmnpqrstvwxzBCDFGHJKLMNPQRSTVWXZ]");
			Matcher mConsonants = pConsonants.matcher(word);
			while (mConsonants.find()) {
				consonants++;
			}
			
			result = vowels == consonants ? true : false;
		}
		
		return result;
	}
	
	public static int getNumberOfWordsWithEquelAmountVowelsConsonants(String[] strings) {
		long result = Arrays.stream(strings).filter(word -> findLatinWordWithEquelAmountVowelsConsonants(word)).distinct().count();
		return (int) result;
	}
	
//	Task 6.
	public static void printFirstWordWithAscCharOrder(String[] strings) {
		boolean isOk = false;
		for(String string : strings) {
			for(int i = 0; i < string.length() - 1; i++) {
				if((int)string.charAt(i) < (int)string.charAt(i+1)) {
					isOk = true;
				} else {
					isOk = false;
					break;
				}
			}
			if(isOk) {
				System.out.println("Your word is " + string);
				break;
			}
		}
		if(!isOk) {
			System.out.println("There is no such word!");
		}
	}
	
//	Task 7.
	public static String findFirstWordOnlyDifferentChars(String[] strings) {
		for(String string : strings) {
			Set<Character> chars = string.chars().mapToObj(e -> (char)e).collect(Collectors.toSet());
			if(chars.size() == string.length()) {
				return string;
			}
		}
		return "Error: word is not found!";
	}
	
//	Task 8.
	public static ArrayList<StringBuffer> findTwoPalindromes(String[] strings) {
		ArrayList<StringBuffer> result = new ArrayList<>(2);
		int count = 0;
		for(String string : strings) {
			StringBuffer word = new StringBuffer(string);
			if(string.matches("^[0-9]+$") && word.equals(word.reverse())) {
				result.add(word);
				count++;
			}
			if(count == 2) {
				break;
			}
		}
		return result;
	}
	
	
	public static void main(String[] args) {
		

		String[] words = getArrayOfStrings();
		System.out.println("Task 1:");
		findAndPrintMinMaxStrings(words);
		System.out.println("Task 2:");
		printStringsByLenghtAsc(words);
		printStringsByLenghtDesc(words);
		System.out.println("Task 3:");
		printStringsLongerThanAverage(words);
		System.out.println();
		printStringsShorterThanAverage(words);
		System.out.println("Task 4:");
		System.out.println(getFirstWordWithMinSetOfCharacters(words));
		System.out.println("Task 5:");
		System.out.println(getNumberOfWordsWithEquelAmountVowelsConsonants(words));
		System.out.println("Task 6:");
		printFirstWordWithAscCharOrder(words);
		System.out.println("Task 7:");
		System.out.println(findFirstWordOnlyDifferentChars(words));
		System.out.println("Task 8:");
		System.out.println(findTwoPalindromes(words));
	}
}
