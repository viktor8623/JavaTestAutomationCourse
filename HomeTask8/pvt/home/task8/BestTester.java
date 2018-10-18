package pvt.home.task8;

public class BestTester {
	
	private static BestTester bestTester;
	private String name;
	private String surname;

	private BestTester() {
		
	}
	
	public static BestTester getInstance() {
		if (bestTester == null) {
			bestTester = new BestTester();
		}
		return bestTester;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}
}


// Java Singleton
//Singleton pattern restricts the instantiation of a class and ensures that only one instance of the class
//exists in the java virtual machine.
//The singleton class must provide a global access point to get the instance of the class.
//In our case the getBestTester method.
//Singleton pattern is used for logging, drivers objects, caching and thread pool.
//Singleton design pattern is also used in other design patterns like Abstract Factory, Builder, 
//Prototype, Facade etc.
//Singleton design pattern is used in core java classes also, for example java.lang.Runtime, java.awt.Desktop.
//In our case, Lazy initialization is used.
//Lazy initialization method to implement Singleton pattern creates the instance in the global access method. 






