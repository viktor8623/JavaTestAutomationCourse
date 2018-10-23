package pvt.home.task10;


public class Runner {

	public static void main(String[] args) {
		
		UserInput userInput = new UserInput();
		String text = userInput.getText();
		int index = userInput.getIndex();
		char placeholder = userInput.getPlaceholder();
		System.out.println(text);
		
		Paragraph par = new Paragraph(text);
		par.swichCharAtInAllWords(index, placeholder);
		System.out.println(par.restoreFromComponents());
		
	}
}
