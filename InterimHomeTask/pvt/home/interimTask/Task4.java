package pvt.home.interimTask;

public class Task4 {

	public static void main(String[] args) {
		String text = "kjl654 jsdkl ';kfds89e7ksflj";

		System.out.println(removeNotLetters(text));
	}

	public static String removeNotLetters(String text) {
		return text.replaceAll("[^a-zA-Z\\s]+", " ");
	}
}
