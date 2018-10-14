package pvt.home.interimTask;

public class Task5 {

	public static void main(String[] args) {
		String text = "Some text(very small).";
		
		char firstSymbol = '(';
		char secondSymbol = ')';
		
		System.out.println(removeTextBetweenSymbols(text, firstSymbol, secondSymbol));

	}
	
	public static String removeTextBetweenSymbols(String text, char firstSymbol, char secondSymbol) {
		String regex = String.format("[%s].*[%s]", firstSymbol, secondSymbol);
		return text.replaceAll(regex, "");
	}
}
