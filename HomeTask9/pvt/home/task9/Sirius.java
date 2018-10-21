package pvt.home.task9;

public class Sirius extends Star {

	private long distanceFromEarth;
	private String colour;
	
	public Sirius(long distanceFromEarth, String colour) {
		this.distanceFromEarth = distanceFromEarth;
		this.colour = colour;
	}
	
	public void printDistanceFromEarth() {
		System.out.println(distanceFromEarth);
	}
	
	public void printSiriusColour() {
		System.out.println(colour);
	}
	
	@Override
	public void printMassOfObject() {
		System.out.println("Sirius' mass " + getMass());
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((colour == null) ? 0 : colour.hashCode());
		result = prime * result + (int) (distanceFromEarth ^ (distanceFromEarth >>> 32));
		return result;
	}

	@Override
	public String toString() {
		return "This is Sirius.";
	}
}
