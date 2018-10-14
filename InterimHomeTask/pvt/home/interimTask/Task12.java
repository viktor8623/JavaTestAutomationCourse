package pvt.home.interimTask;


public class Task12 {

	public static void main(String[] args) {
		String sourceCode = "//	Task 8.\r\n" + 
							"	code \r\n" + 
							"	/** \r\n" + 
							"	This  \r\n" + 
							"	is  \r\n" + 
							"	documentation  \r\n" + 
							"	comment \r\n" + 
							"	*/code\r\n" + 
							"	\r\n" + 
							"	/* \r\n" + 
							"	This  \r\n" + 
							"	is  \r\n" + 
							"	multi line  \r\n" + 
							"	comment \r\n" + 
							"	*/  \r\n" + 
							"	public static ArrayList<StringBuffer> findTwoPalindromes(String[] strings) {\r\n" + 
							"		ArrayList<StringBuffer> result = new ArrayList<>(2);\r\n" + 
							"		int count = 0;";

		System.out.println(removeAllComments(sourceCode));
		
	}

	public static String removeAllComments(String sourceCode) {
		return sourceCode.replaceAll("//.*|(\"(?:\\\\[^\"]|\\\\\"|.)*?\")|(?s)/\\*.*?\\*/", "");
	}
}
