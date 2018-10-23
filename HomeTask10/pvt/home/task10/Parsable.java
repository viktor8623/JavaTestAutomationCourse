package pvt.home.task10;

import java.util.ArrayList;

public interface Parsable {

	<T> ArrayList<T> parseByComponents(String text);
	
	String restoreFromComponents();
}
