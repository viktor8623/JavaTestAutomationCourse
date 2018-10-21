package pvt.home.task9;

public abstract class StarSystem {
	
	private String name;
	private int mass;
	
	public StarSystem() {
		
	}
	
	public StarSystem(String name, int mass) {
		this.name = name;
		this.mass = mass;
	}
	
	public abstract void printDetails();
	
	public abstract void printMassOfObject();

	public void printStarObjectName() {
		System.out.println("Star object name: " + name);
	}
	
	public void printStarObjectMass() {
		System.out.println("Star oject mass: " + mass);
	}
	
	public String getName() {
		return name;
	}

	public int getMass() {
		return mass;
	}

	public void setMass(int mass) {
		this.mass = mass;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + mass;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public String toString() {
		return "Star system name: " + name;
	}
}
