package pvt.home.task8;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class ReflectedBestTester {

	public static void main(String[] args) throws NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		
		Constructor<?> constructor = BestTester.class.getDeclaredConstructor();
		// The method returns an object that reflects the specified constructor of the class.
				
		constructor.setAccessible(true); 
		// When it is set true, it allows to access private constructor.
		
		BestTester bt = (BestTester) constructor.newInstance(); 
		// The class is instantiated by using the calling constructor. 
		// We need to pass required parameters if they needed. And cast from Object class to our class.
		
		bt.setName("Viktor");
		bt.setSurname("Yenjchak");
		
		System.out.println("There can be no doubt the best tester is " + bt.getName() + " " + bt.getSurname() + "!");
	}
}
