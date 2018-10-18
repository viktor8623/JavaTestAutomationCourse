package pvt.home.task8;

public class Tester {
	
	public String name;
	public String surname;
	int expirienceInYears;
	protected String englishLevel;
	private int salary;
	private static final int SALARYMULTIPLIER = 2;
	private static final int MONTHSINYEAR = 12;
	
	Tester() {
		
	}

	Tester(String name, String surname) {
		this.name = name;
		this.surname = surname;
	}

	protected Tester(String name, String surname, int expirienceInYears) {
		this(name, surname);
		this.expirienceInYears = expirienceInYears;
	}
	
	public Tester(String name, String surname, int expirienceInYears, int salary) {
		this(name, surname, expirienceInYears);
		this.salary = salary;
	}

	private int getDoubleSalary() {
		return salary * SALARYMULTIPLIER;
	}
	
	int getExpirienceInMonths() {
		return expirienceInYears * MONTHSINYEAR;
	}
	
	protected void printNameSurname() {
		System.out.println(name + " " + surname);
	}
	
	public void printAllDelails() {
		System.out.println(name + " " + surname + " " + expirienceInYears + " " + englishLevel + " " + salary);
	}
 	
	String getName() {
		return name;
	}

	void setName(String name) {
		this.name = name;
	}

	String getSurname() {
		return surname;
	}

	void setSurname(String surname) {
		this.surname = surname;
	}

	int getExpirienceInYears() {
		return expirienceInYears;
	}

	void setExpirienceInYears(int expirienceInYears) {
		this.expirienceInYears = expirienceInYears;
	}

	String getEnglishLevel() {
		return englishLevel;
	}

	void setEnglishLevel(String englishLevel) {
		this.englishLevel = englishLevel;
	}

	int getSalary() {
		return salary;
	}

	void setSalary(int salary) {
		this.salary = salary;
	}
}
