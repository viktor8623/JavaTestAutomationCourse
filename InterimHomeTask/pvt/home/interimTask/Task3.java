package pvt.home.interimTask;

public class Task3 {

	public static void main(String[] args) {
		String input = "Some word...";
		char ch = 'o';
		int sign = 1;
		int index = 7;
		
		removeOrReplaceChar(input, ch, sign, index);
	}

    public static void removeOrReplaceChar(String input, char ch, int sign, int index) {
        if (sign == 0) {
        	String chString = Character.toString(ch);
        	input = input.replace(chString,"");
            System.out.println(input);
        } else if (sign == 1) {
            input = input.substring(0, index) + ch + input.substring(index);
            System.out.println(input);
        } else {
        	System.out.println("Oops! Something went wrong... Check your index.");
        }
    }
}
