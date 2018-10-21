package pvt.home.task9;

public class Mars extends Planet {
	
	private int moonsCount;
	private int orbitaPeriodEarthDays;
	
	public Mars(String name, int mass, int planetSize, int moonsCount, int orbitaPeriodEarthDays) {
		super(name, mass);
		this.planetSize = planetSize;
		this.moonsCount = moonsCount;
		this.orbitaPeriodEarthDays = orbitaPeriodEarthDays;
	}
	
	public void printMoonsCount() {
		System.out.println("Mars has " + moonsCount + " moons.");
	}
	
	@Override
	public void printDetails() {
		printStarObjectName();
		System.out.println("1 year = " + orbitaPeriodEarthDays + " Earth days.");
	}
	
	@Override
	public int hashCode() {
		final int prime = 5;
		int result = super.hashCode();
		result = prime * result + moonsCount;
		result = prime * result + orbitaPeriodEarthDays;
		return result;
	}

	@Override
	public String toString() {
		return "This is Mars.";
	}
}
