package pvt.home.task9.composition;

import java.util.ArrayList;

public class Star {

	private String name;
	private long mass;
	private String type;
	private int planetCount;
	private ArrayList<Planet> planets;

	public Star(String name, long mass, String type) {
		this.name = name;
		this.mass = mass;
		this.type = type;
		this.planetCount = 0;
		this.planets = new ArrayList<>();
	}

	public void createPlanet(String name, boolean hasAtmosphere, boolean isInhabitable, boolean hasWater,
			int moonsCount) {
		planets.add(new Planet(name, hasAtmosphere, isInhabitable, hasWater, moonsCount));
		planetCount++;
		System.out.println("Congrats!!! New planet has been created!");
	}
	
	public Planet getPlanetByName(String name) {
		return planets.stream().filter(planet -> name.equals(planet.getName())).findAny().orElse(null);
	}
	
	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "Star " + name + ", mass=" + mass + ", type=" + type + ", planetCount=" + planetCount;
	}
}
