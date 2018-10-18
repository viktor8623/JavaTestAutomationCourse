package pvt.home.task8.second_package;

import pvt.home.task8.Tester;

public class AnotherPackageMain {

	public static void main(String[] args) {
		
		Tester tester = new Tester("Jerry", "Barker", 3, 8000);
		
		tester.getDoubleSalary(); 
		//The method is marked as private. So, only code inside the same class can call the method. 
		//Code from any external class cannot access the method.
		
		tester.setEnglishLevel("Native");		
		System.out.println(tester.getEnglishLevel());
		int experience = tester.getExpirienceInMonths();
		// The methods don't have access modifier (Which means they are friendly). 
		// Only code inside the same package can call those methods.
			
		tester.printNameSurname();
		// The method is marked as protected. Only code inside the same package or subclasses from another packages
		// can call the method.
		
		tester.printAllDelails();
	}
}
