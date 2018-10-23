package pvt.home.task10;

public class Word {

	private String value;
	private boolean hasPunctuation;
	private char punctuationMark;
	
	public Word(String value, boolean hasPunctuation, char punctuationMark) {
		this.value = value;
		this.hasPunctuation = hasPunctuation;
		this.punctuationMark = punctuationMark;
	}

	public void swichCharAt(int index, char newChar) {
		int wordLength = value.length();
		if (wordLength > index) {
			value = value.substring(0, index) + newChar + value.substring(index + 1, wordLength);
		}
	}
		
	public String getValue() {
		return value;
	}

	public boolean isHasPunctuation() {
		return hasPunctuation;
	}

	public char getPunctuationMark() {
		return punctuationMark;
	}

	@Override
	public String toString() {
		return value;
	}
}
