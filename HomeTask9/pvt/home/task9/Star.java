package pvt.home.task9;

public class Star extends StarSystem {

	private String typeOfStar;
	private long age;
	
	public Star() {
		
	}
	
	public Star(String typeOfStar) {
		this.typeOfStar = typeOfStar;
	}
	
	public Star(String typeOfStar, long age) {
		this(typeOfStar);
		this.age = age;
	}
	
	public Star(String name, int mass, String typeOfStar, long age) {
		super(name, mass);
		this.typeOfStar = typeOfStar;
		this.age = age;
	}
	
	@Override
	public void printDetails() {
		printStarObjectName();
		printStarObjectMass();
		System.out.println("Star's type: " + typeOfStar);
		System.out.println("Star's age: " + age);
	}

	@Override
	public void printMassOfObject() {
		System.out.println("Star's mass " + getMass());
	}
	
	public void printTypeOfStar() {
		System.out.println(typeOfStar != null ? typeOfStar : "I don't know...");
	}
	
	public void printAge() {
		System.out.println(age != 0 ? age : "I don't know...");
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + (int) (age ^ (age >>> 32));
		result = prime * result + ((typeOfStar == null) ? 0 : typeOfStar.hashCode());
		return result;
	}

	@Override
	public String toString() {
		return typeOfStar;
	}
}
