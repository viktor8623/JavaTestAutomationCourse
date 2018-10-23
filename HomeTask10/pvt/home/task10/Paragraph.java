package pvt.home.task10;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Paragraph implements Parsable {
	
	private ArrayList<Sentence> sentences;
	
	
	public Paragraph(String text) {
		this.sentences = parseByComponents(text);
	}

	public void swichCharAtInAllWords(int index, char newChar) {
		sentences.stream().forEach(sentence -> sentence.getWords()
									.stream()
									.forEach(word -> word.swichCharAt(index, newChar)));
	}
	
	public ArrayList<Sentence> getSentences() {
		return sentences;
	}
	
	@Override
	public ArrayList<Sentence> parseByComponents(String text) {
		ArrayList<Sentence> sentences = new ArrayList<>();
		Matcher matcher = Pattern.compile("([^.!?]+[.!?])").matcher(text);
		while (matcher.find())
		{
			String sentence = matcher.group(1).trim();
			sentences.add(new Sentence(sentence));
		}
		return sentences;
	}

	@Override
	public String restoreFromComponents() {
		String result = "";
		for (Sentence sentence : sentences) {
			result += sentence.restoreFromComponents();
		}
		return result;
	}	
	
	@Override
	public String toString() {
		return "Paragraph contains following sentences " + sentences.toString();
	}
}
