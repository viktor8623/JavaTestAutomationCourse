package pvt.home.task9.composition;

public class Planet {
	
	private String name;
	private boolean hasAtmosphere;
	private boolean isInhabitable;
	private boolean hasWater;
	private int moonsCount;
	
	public Planet(String name, boolean hasAtmosphere, boolean isInhabitable, boolean hasWater, int moonsCount) {
		this.name = name;
		this.hasAtmosphere = hasAtmosphere;
		this.isInhabitable = isInhabitable;
		this.hasWater = hasWater;
		this.moonsCount = moonsCount;
	}

	public String getName() {
		return name;
	}
	
	@Override
	public String toString() {
		return "Planet " + name + ", hasAtmosphere=" + hasAtmosphere + ", isInhabitable=" + isInhabitable
				+ ", hasWater=" + hasWater + ", moonsCount=" + moonsCount;
	}
}
