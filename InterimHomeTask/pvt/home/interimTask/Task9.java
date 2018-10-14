package pvt.home.interimTask;


public class Task9 {

    public static void main(String[] args) {
        String text = "world wide web test89";
        System.out.println(toUP(text));
 
    }
    
    public static String toUP(String text) {
        char[] charArr = text.toCharArray();
        char separator = ' ';
        String finalText = "";
               
        for (int i = 0; i < charArr.length; ) {
        	if(Character.isAlphabetic(charArr[i])) {
        		boolean wordIsAlphabetic = false;
        		int nextChar = i + 1;
        		while(charArr[nextChar] != separator || charArr[nextChar] < charArr.length - 1) {
        			if (Character.isAlphabetic(charArr[nextChar])) {
        				wordIsAlphabetic = true;
        				nextChar++;
        			} else {
        				wordIsAlphabetic = false;
        				nextChar++;
        				break;
        			}
        		}
        		if (wordIsAlphabetic) {
        			finalText += Character.toUpperCase(charArr[i]);
        		} else {
        			finalText += charArr[i];
        		}
        		for(int restPart = i + 1; restPart < nextChar; restPart++) {
        			finalText += charArr[restPart];
        		}
        		
        		i = nextChar;
 
        	} else {
        		finalText += charArr[i];
        		i++;
        	}
        }	
        return finalText;
	}	
}	
	
	
