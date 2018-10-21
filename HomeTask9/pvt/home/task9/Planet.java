package pvt.home.task9;

public class Planet extends StarSystem {

	protected int planetSize;
	private boolean hasSurface;
	
	public Planet() {
		
	}
	
	public Planet(String name, int mass) {
		super(name, mass);
	}
	
	public Planet(int planetSize, boolean hasSurface) {
		this.planetSize = planetSize;
		this.hasSurface = hasSurface;
	}

	@Override
	public void printDetails() {
		printStarObjectName();
		printStarObjectMass();
		System.out.println(hasSurface ? "Planet has surface." : "It's a gas giant planet.");
	}

	@Override
	public void printMassOfObject() {
		System.out.println("Planet's mass " + getMass());
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + (hasSurface ? 1231 : 1237);
		result = prime * result + planetSize;
		return result;
	}

	@Override
	public String toString() {
		return getName();
	}
}
