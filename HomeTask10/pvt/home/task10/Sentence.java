package pvt.home.task10;

import java.util.ArrayList;

public class Sentence implements Parsable {
	
	private ArrayList<Word> words;
	private static final char SEPARATOP = ' ';
	
	
	public Sentence(String text) {
		this.words = parseByComponents(text);
	}
		
	public ArrayList<Word> getWords() {
		return words;
	}

	@Override
	public ArrayList<Word> parseByComponents(String text) {
		ArrayList<Word> words = new ArrayList<>();
		String[] listOfStrings = text.split(" ");
		for(String string : listOfStrings) {
			boolean hasPunctuation = false;
			char punctuationMark = ' ';
			string.trim();
			if (string.matches(".+[.,:;!?]$")) {
				hasPunctuation = true;
				punctuationMark = string.charAt(string.length() - 1);
				string = string.substring(0, string.length() - 1);
				words.add(new Word(string, hasPunctuation, punctuationMark));
			} else {
				words.add(new Word(string, hasPunctuation, punctuationMark));
			}		
		}		
		return words;
	}

	@Override
	public String restoreFromComponents() {
		String result = "";
		for (Word word : words) {
			if (word.isHasPunctuation()) {
				result += word.getValue() + word.getPunctuationMark() + SEPARATOP;
			} else {
				result += word.getValue() + SEPARATOP;
			}
		}
		return result;
	}	
	
	@Override
	public String toString() {
		return "Sentence with words " + words;
	}
}
