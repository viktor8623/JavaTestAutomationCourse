package pvt.home.task5;

public class Tester {

	private String name;
	private String surname;
	private int expirienceInYears;
	private String englishLevel;
	private int salary;
	
	public Tester() {
		
	}
	
	public Tester(String name) {
		this.name = name;
	}
	
	public Tester(String name, String surname) {
		this(name);
		this.surname = surname;
	}
	
	public Tester(String name, String surname, int expirienceInYears) {
		this(name, surname);
		this.expirienceInYears = expirienceInYears;
	}
	
	public Tester(String name, String surname, int expirienceInYears, String englishLevel) {
		this(name, surname, expirienceInYears);
		this.englishLevel = englishLevel;
	}
	
	public Tester(String name, String surname, int expirienceInYears, String englishLevel, int salary) {
		this(name, surname, expirienceInYears, englishLevel);
		this.salary = salary;
	}
	
	public void doWork() {
		System.out.println("I'm just doing something.");
	}
	
	public void doWork(int task) {
		System.out.println("Completed " + task + " tasks.");
	}
	
	public void doWork(int testCase, int hours) {
		System.out.println("Created " + testCase + " test cases in " + hours + " hours.");
	}
	
	public void doWork(String taskName) {
		System.out.println("Task \"" + taskName + "\" has been completed.");
	}
	
	public static void printDetails(Tester tester) {
		System.out.println("Tester " + tester.name + " " + tester.surname);
		System.out.println("Tester has " + tester.expirienceInYears + " year expirience");
		System.out.println("English level is " + tester.englishLevel);
		System.out.println("Salary is " + tester.salary);
	}
	
}
