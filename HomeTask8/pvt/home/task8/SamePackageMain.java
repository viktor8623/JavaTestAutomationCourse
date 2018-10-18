package pvt.home.task8;

public class SamePackageMain {

	public static void main(String[] args) {
		
		Tester tester = new Tester("Jerry", "Barker", 3, 8000);
		
		tester.getDoubleSalary(); 
		//The method is marked as private. So, only code inside the same class can call the method. 
		//Code from any external class cannot access the method.
		
		tester.setEnglishLevel("Native");
		System.out.println(tester.getEnglishLevel());
		int experience = tester.getExpirienceInMonths();
		tester.printNameSurname();
		tester.printAllDelails();
	}
}
