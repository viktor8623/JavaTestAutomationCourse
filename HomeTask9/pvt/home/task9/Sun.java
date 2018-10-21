package pvt.home.task9;

public class Sun extends Star {
	
	private boolean hasPlanets;
	private int planetsCount;
	
	public void setHasPlanets(boolean hasPlanets) {
		this.hasPlanets = hasPlanets;
	}
	
	public void setPlanetsCount(int planetsCount) {
		this.planetsCount = planetsCount;
	}
	
	public boolean isHasPlanets() {
		return hasPlanets;
	}

	@Override
	public void printDetails() {
		printStarObjectName();
		printTypeOfStar();
		System.out.println("Sun has " + planetsCount + " planets.");
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + (hasPlanets ? 1231 : 1237);
		result = prime * result + planetsCount;
		return result;
	}

}
